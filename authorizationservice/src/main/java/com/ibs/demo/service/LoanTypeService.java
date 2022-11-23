package com.ibs.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.demo.exception.ResourceNotFoundException;
import com.ibs.demo.model.LoanType;
import com.ibs.demo.repository.LoanTypeRepository;

@Service
public class LoanTypeService {

	@Autowired
	private LoanTypeRepository loanTypeRepository;
	
	public List<LoanType> findAll(){
		return loanTypeRepository.findAll();
	}
	
	public LoanType getLoanById(Integer id) {
		LoanType loan = loanTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Loan type does not exist with id: "+id));
		return loan;
	}
	
	@Transactional
	public LoanType updateInterest(LoanType loanType) {
		LoanType updatedLoanType = new LoanType();
		updatedLoanType.setId(loanType.getId());
		updatedLoanType.setName(loanType.getName());
		updatedLoanType.setInterest(loanType.getInterest());
		return loanTypeRepository.save(updatedLoanType);
	}
}
