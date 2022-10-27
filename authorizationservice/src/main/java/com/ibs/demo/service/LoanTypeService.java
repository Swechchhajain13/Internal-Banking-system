package com.ibs.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.demo.model.LoanType;
import com.ibs.demo.repository.LoanTypeRepository;

@Service
public class LoanTypeService {

	@Autowired
	private LoanTypeRepository loanTypeRepository;
	
	public List<LoanType> findAll(){
		return loanTypeRepository.findAll();
	}
}
