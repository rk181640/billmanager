package com.interview.demo.billmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.interview.demo.billmanager.vo.Bill;

@Component
public interface BillJPARepository extends JpaRepository<Bill, Long> {

	Bill findByExpenseID(Integer expenseID);
}
