package com.interview.demo.billmanager.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="Expense Description")
	private String expenseDescription;
	
	@ApiModelProperty(value="Expense ID")
	@Id
	@Column(name = "EXPENSE_ID")
	private Integer expenseID;
	
	@ApiModelProperty(value="Expense Amount")
	private BigDecimal exepenseAmount;
	
	public String getExpenseDescription() {
		return expenseDescription;
	}
	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
	public Integer getExpenseID() {
		return expenseID;
	}
	public void setExpenseID(Integer expenseID) {
		this.expenseID = expenseID;
	}
	public BigDecimal getExepenseAmount() {
		return exepenseAmount;
	}
	public void setExepenseAmount(BigDecimal exepenseAmount) {
		this.exepenseAmount = exepenseAmount;
	}
	@Override
	public String toString() {
		return "Bill [expenseDescription=" + expenseDescription
				+ ", expenseID=" + expenseID + ", exepenseAmount="
				+ exepenseAmount + "]";
	}
	
	
}
