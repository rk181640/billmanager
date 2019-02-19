package com.interview.demo.billmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.interview.demo.billmanager.vo.Friend;

@Component
public interface FriendJPARepository extends JpaRepository<Friend, Long> {

	Friend findByName(String name);
	Friend findByExpenseID(Integer expenseID);
	
	void deleteByExpenseID(Integer expenseID);
}
