package com.ibs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibs.demo.model.AppliedLoans;
import com.ibs.demo.model.LoanType;
import com.ibs.demo.service.AppliedLoanService;
import com.ibs.demo.service.LoanTypeService;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Prashik
 * 
 */
@RestController
@Slf4j
public class LoanController {

	@Autowired
	private LoanTypeService loanTypeService;

	@Autowired
	private AppliedLoanService appliedLoanService;

	@GetMapping("/getAllLoanTypes")
	public List<LoanType> getAllLoans() {
		log.info("Inside loan types : ");
		return loanTypeService.findAll();
	}
/**
 * 
 * @param userName
 * @return List<AppliedLoans>
 */
	@GetMapping("/userLoan/{userName}")
	public ResponseEntity<List<AppliedLoans>> getAllRecords(@PathVariable String userName) {
		log.info("Retrieving loan records by Username : ");
		return new ResponseEntity<>(appliedLoanService.findAll(userName), HttpStatus.OK);
	}

	@PostMapping("/applyLoan/{userName}")
	public ResponseEntity<AppliedLoans> applyLoan(@PathVariable String userName, @RequestBody AppliedLoans appliedLoans) {
		log.info("Inside Apply Loan : ");
		return new ResponseEntity<>(appliedLoanService.applyLoan(userName, appliedLoans), HttpStatus.OK);
	}
/**
 * 
 * @param userName
 * @param appliedLoans
 * @return appliedLoans
 */
	@PutMapping("/updateLoan/{userName}")
	public ResponseEntity<AppliedLoans> updateLoan(@PathVariable String userName, @RequestBody AppliedLoans appliedLoans) {
		log.info("Inside Update Loan : ");
		return new ResponseEntity<>(appliedLoanService.applyLoan(userName, appliedLoans), HttpStatus.OK);
	}

}
