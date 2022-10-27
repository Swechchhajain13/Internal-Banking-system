package com.ibs.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.demo.model.AppliedLoans;
import com.ibs.demo.model.User;
import com.ibs.demo.repository.AppliedLoanRepository;

@Service
public class AppliedLoanService {

	@Autowired
	private AppliedLoanRepository appliedLoanRepository;
	
	@Autowired
	private UsersService userService;

	public List<AppliedLoans> findAll(String userName) {
		User user = userService.findByUserName(userName);
		List<AppliedLoans> loans = appliedLoanRepository.findLoansByUser(user.getId());
		loans.stream().forEach(loan -> loan.setUser_id(null));
		return loans;  	
	}

	@Transactional
	public AppliedLoans applyLoan(String userName, AppliedLoans appliedLoans) {
		User user = userService.findByUserName(userName);
		appliedLoans.setUser_id(user);
		return appliedLoanRepository.save(appliedLoans);
	}
	
	
}
