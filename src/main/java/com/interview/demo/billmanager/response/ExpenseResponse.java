package com.interview.demo.billmanager.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import com.interview.demo.billmanager.vo.Friend;

public class ExpenseResponse {
	
	@ApiModelProperty(value="Friends List Response")
	private List<Friend> friends;
	
	
	public List<Friend> getFriends() {
		return friends;
	}
	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}
	
}
