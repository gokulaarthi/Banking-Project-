package com.bank.bankServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankDto.AccountDto;
import com.bank.bankModel.BankModel;
import com.bank.bankRepositoryInter.BankRepoInter;

@Service
public class BankServiceImpl implements BankServiceInter {
	@Autowired
	private BankRepoInter bankRepoInter;

	@Override
	public String save(AccountDto details) {
		BankModel bankModel = new BankModel();
		bankModel.setId(details.getId());
		bankModel.setAccountName(details.getAccountName());
		bankModel.setFatherNAme(details.getFatherName());
		bankModel.setAadharNumber(details.getAadharNumber());
		bankModel.setMobileNumber(details.getMobileNumber());
		bankModel.setAccountNumber(details.getAccountNumber());
		bankModel.setAccountBAlance(details.getAccountBAlance());
		bankModel.setDateOfBirth(details.getDateOFBirth());
		bankModel.setAddress(details.getAddress());
		try {
			BankModel message = bankRepoInter.save(bankModel);
			if (message != null) {
				return "account created sussefully";
			}
		} catch (Exception msg) {
			Exception err = msg;
			if (err != null) {
				return "error in account saving or already the account is present";
			}
		}
		return "saving process failed";

	}

	@Override
	public List<AccountDto> getall() {
		List<BankModel> rec = bankRepoInter.findAll();

		return rec.stream().map(da -> {
			AccountDto re = new AccountDto();
			re.setId(da.getId());
			re.setAccountName(da.getAccountName());
			re.setFatherName(da.getFatherNAme());
			re.setAadharNumber(da.getAadharNumber());
			re.setMobileNumber(da.getMobileNumber());
			re.setAccountNumber(da.getAccountNumber());
			re.setAccountBAlance(da.getAccountBAlance());
			re.setDateOFBirth(da.getDateOfBirth());
			re.setAddress(da.getAddress());
			return re;
		}).collect(Collectors.toList());

	}

	@Override
	public List<AccountDto> getBalance(String accountNumber) {
		try {
			List<BankModel> msg = bankRepoInter.findAccountbalance(accountNumber);
			return msg.stream().map(ds -> {
				AccountDto ms = new AccountDto();
				ms.setAccountName(ds.getAccountName());
				ms.setAccountNumber(ds.getAccountNumber());
				ms.setMobileNumber(ds.getMobileNumber());
				ms.setAccountBAlance(ds.getAccountBAlance());
				return ms;
			}).collect(Collectors.toList());

		} catch (Exception e) {
			System.out.println(e);

		}
		return null;

	}

	@Override
	public String updateBalance(String accountno, Long deposit) {
		BankModel mo = bankRepoInter.findByaccount_number(accountno);
		mo.setAccountBAlance((mo.getAccountBAlance()) + deposit);
		bankRepoInter.save(mo);
		return "sucessfull " + String.valueOf(deposit);
	}

	@Override
	public String withDraw(String accountno, Long amount) {
		try {
			BankModel ds = bankRepoInter.findByaccount_number(accountno);
			ds.setAccountBAlance((ds.getAccountBAlance()) - amount);
			BankModel ms = bankRepoInter.save(ds);
			if (ms != null) {
				return "withraw sussefull  " + String.valueOf(amount);
			}
			return "not withdraw some error";
		} catch (Exception e) {
			System.out.println(e);
		}
		return String.valueOf(amount);
	}

	@Override
	public String accountTransferMoney(String fromAccount, String toAccount, Long ammount) {
		BankModel fromAcc = bankRepoInter.findByaccount_number(fromAccount);
		BankModel toAcc = bankRepoInter.findByaccount_number(toAccount);
		if (fromAcc != null && toAcc != null) {
			if (fromAcc.getAccountBAlance() > 0 && ammount < fromAcc.getAccountBAlance()) {
				fromAcc.setAccountBAlance((fromAcc.getAccountBAlance()) - ammount);
				toAcc.setAccountBAlance((toAcc.getAccountBAlance()) + ammount);

				bankRepoInter.save(fromAcc);
				bankRepoInter.save(toAcc);
				return "Ammount transfered sussefully: " + String.valueOf(ammount);
			} else {
				return "does'nt have enough money";
			}
		}
		return "account not found";
	}

}
