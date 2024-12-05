package com.bank.bankServices;

import java.util.List;
import com.bank.bankDto.AccountDto;

//import com.bank.bankModel.BankModel;
public interface BankServiceInter {
	public String save(AccountDto details);

	public List<AccountDto> getall();

	public List<AccountDto> getBalance(String accountNumber);

	public String updateBalance(String accountno, Long deposit);

	public String withDraw(String accountno, Long amount);

	public String accountTransferMoney(String fromAccount, String toAccount, Long ammount);
}
