package com.interview.demo.billmanager.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class SplitExpenseResponseModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="Friend's full Name")
	private String friendName;
	@ApiModelProperty(value="Friend's email Address")
	private String emailAddress;
	@ApiModelProperty(value="settled Expense Value")
	private BigDecimal setledExpenses;
	@ApiModelProperty(value="settlement Description")
	private String settlementDescription;
	
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public BigDecimal getSetledExpenses() {
		return setledExpenses;
	}
	public void setSetledExpenses(BigDecimal setledExpenses) {
		this.setledExpenses = setledExpenses;
	}
	public String getSettlementDescription() {
		return settlementDescription;
	}
	public void setSettlementDescription(String settlementDescription) {
		this.settlementDescription = settlementDescription;
	}
	@Override
	public String toString() {
		return "SplitExpenseResponseModel [friendName=" + friendName
				+ ", emailAddress=" + emailAddress + ", setledExpenses="
				+ setledExpenses + ", settlementDescription="
				+ settlementDescription + "]";
	}
	

}
