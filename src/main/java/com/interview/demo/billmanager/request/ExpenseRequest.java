package com.interview.demo.billmanager.request;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.interview.demo.billmanager.vo.Friend;

public class ExpenseRequest {

	
	@ApiModelProperty(value="Friends sharing the expenses")
	@NotNull
	private List<Friend> friends;
	
	public List<Friend> getFriends() {
		return friends;
	}
	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}
	
    
	
	
}
