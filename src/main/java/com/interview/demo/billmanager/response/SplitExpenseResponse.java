package com.interview.demo.billmanager.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.interview.demo.billmanager.vo.SplitExpenseResponseModel;



public class SplitExpenseResponse {
	
	@ApiModelProperty(value="Expense List Response")
	private List<SplitExpenseResponseModel> expenseResponseModelList;

	public List<SplitExpenseResponseModel> getExpenseResponseModelList() {
		return expenseResponseModelList;
	}

	public void setExpenseResponseModelList(
			List<SplitExpenseResponseModel> expenseResponseModelList) {
		this.expenseResponseModelList = expenseResponseModelList;
	}
}
