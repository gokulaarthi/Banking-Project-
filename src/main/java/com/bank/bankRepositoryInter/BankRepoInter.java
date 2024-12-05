package com.bank.bankRepositoryInter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.bankModel.BankModel;
@Repository
public interface BankRepoInter extends JpaRepository<BankModel, Long> {
@Query(value ="SELECT * FROM Account_Information WHERE account_number =:accountNumber",nativeQuery = true)
	List<BankModel>  findAccountbalance (@Param(value="accountNumber") String account_No);

@Query(value="select * from Account_Information where account_number=:accountnumber",nativeQuery = true)
	BankModel findByaccount_number(String accountnumber);
}
 