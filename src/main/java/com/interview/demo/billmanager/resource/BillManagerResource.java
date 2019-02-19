package com.interview.demo.billmanager.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.billmanager.repo.BillJPARepository;
import com.interview.demo.billmanager.repo.FriendJPARepository;
import com.interview.demo.billmanager.request.ExpenseRequest;
import com.interview.demo.billmanager.response.ExpenseResponse;
import com.interview.demo.billmanager.response.SplitExpenseResponse;
import com.interview.demo.billmanager.vo.Friend;
import com.interview.demo.billmanager.vo.SplitExpenseResponseModel;

@RestController
@RequestMapping("/api/bill")
@Api(value = "Bill Manager API")
public class BillManagerResource {

	Logger logger = Logger.getGlobal();

	@Autowired
	private BillJPARepository billJPARespository;

	@Autowired
	private FriendJPARepository friendJpaRespository;

	@ApiOperation(value = "API to pull the expenses for all the friends.")
	@GetMapping("get-expenses")
	public ExpenseResponse getExpense() {
		ExpenseResponse response = new ExpenseResponse();
		response.setFriends(friendJpaRespository.findAll());
		return response;
	}

	@ApiOperation(value = "API to add expenses for friends.")
	@PostMapping("/add-expense")
	public ExpenseResponse addExpense(
			@Valid @RequestBody ExpenseRequest expenseRequest) {
		logger.info("In Add Expense");
		ExpenseResponse response = new ExpenseResponse();

		for (Friend friend : expenseRequest.getFriends()) {
			friend.setBill(billJPARespository.save(friend.getBill()));
			friendJpaRespository.save(friend);
		}
		response.setFriends(friendJpaRespository.findAll());
		return response;
	}

	@ApiOperation(value = "API to edit expenses for friends.")
	@PutMapping("/edit-expense")
	public ExpenseResponse editExpense(
			@RequestBody ExpenseRequest expenseRequest) {
		logger.info("in Edit expense");
		ExpenseResponse response = new ExpenseResponse();
		for (Friend friend : expenseRequest.getFriends()) {
			friend.setBill(billJPARespository.save(friend.getBill()));
			friendJpaRespository.save(friend);
		}
		response.setFriends(friendJpaRespository.findAll());
		return response;
	}

	@ApiOperation(value = "API to delete expenses for friends.")
	@DeleteMapping("/delete-expense")
	public ExpenseResponse deleteExpense(
			@RequestBody ExpenseRequest expenseRequest) {
		logger.info("in Delete expense");
		ExpenseResponse response = new ExpenseResponse();
		for (Friend friend : expenseRequest.getFriends()) {
			friendJpaRespository.delete(friend);
			// friendJpaRespository.deleteByExpenseID(friend.getExpenseID());
		}
		response.setFriends(friendJpaRespository.findAll());
		return response;
	}

	@ApiOperation(value = "API to split the expenses between friends and display the settlement details.")
	@PostMapping("/split-expense")
	public SplitExpenseResponse splitExpense(
			@RequestBody ExpenseRequest expenseRequest) {
		logger.info("in Split expense");
		SplitExpenseResponse response = new SplitExpenseResponse();
		BigDecimal totlaExpense = new BigDecimal("0.0");

		Integer friendsSize = expenseRequest.getFriends().size();
		for (Friend friend : expenseRequest.getFriends()) {
			totlaExpense = totlaExpense.add(friend.getBill()
					.getExepenseAmount());
		}

		logger.info("TotalExpense is " + totlaExpense);

		BigDecimal averageExpense = totlaExpense.divide(new BigDecimal(
				friendsSize));
		logger.info("averageExpense is " + averageExpense);

		String friendWithMaxPayment = "";
		List<SplitExpenseResponseModel> SplitExpenseResponseModelList = new ArrayList<SplitExpenseResponseModel>();
		for (Friend friend : expenseRequest.getFriends()) {
			SplitExpenseResponseModel model = new SplitExpenseResponseModel();
			model.setFriendName(friend.getName());
			model.setEmailAddress(friend.getEmailAddress());

			if (null != friend.getBill()) {
				int comp = friend.getBill().getExepenseAmount()
						.compareTo(averageExpense);
				if (comp == 0) {
					model.setSetledExpenses(averageExpense);
					model.setSettlementDescription("Everyone has paid equally... setllement Done no expense to settle");
				} else if (comp > 0) {
					friendWithMaxPayment = friend.getName();
					model.setSetledExpenses(new BigDecimal(0.0));
					model.setSettlementDescription(friendWithMaxPayment
							+ " will receieve "
							+ friend.getBill().getExepenseAmount()
									.subtract(averageExpense) + "$ from others");

				} else {
					model.setSetledExpenses(averageExpense.subtract(friend
							.getBill().getExepenseAmount()));
					model.setSettlementDescription(friend.getName()
							+ " will pay "
							+ averageExpense.subtract(friend.getBill()
									.getExepenseAmount()) + "$ to others");
				}
			}
			SplitExpenseResponseModelList.add(model);
		}
		response.setExpenseResponseModelList(SplitExpenseResponseModelList);
		return response;
	}

}
