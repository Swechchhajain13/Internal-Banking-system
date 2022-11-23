package com.ibs.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibs.demo.model.LoanType;

@Repository
public interface LoanTypeRepository extends JpaRepository<LoanType, Integer>{
	
//	@Query(value = "SELECT * FROM loan_type l WHERE l.id = :loanId", nativeQuery = true)
//	public LoanType findLoanById(@Param("loanId") int loanId);
	
}
