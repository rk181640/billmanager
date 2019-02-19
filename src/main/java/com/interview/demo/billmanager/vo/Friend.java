package com.interview.demo.billmanager.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Friend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value="Friend's full name")
	private String name;
	@ApiModelProperty(value="Friend's email address")
	private String emailAddress;
	@Id
	@Column(name = "EXPENSE_ID")
	private Integer expenseID;

	@OneToOne
	@JoinColumn(name = "expenseID", nullable = false)
	private Bill bill;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Integer getExpenseID() {
		return expenseID;
	}

	public void setExpenseID(Integer expenseID) {
		this.expenseID = expenseID;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", emailAddress=" + emailAddress
				+ ", expenseID=" + expenseID + ", bill=" + bill + "]";
	}

}
