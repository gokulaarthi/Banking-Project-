package com.bank.bankController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bank.bankDto.AccountDto;
//import com.bank.bankModel.BankModel;
import com.bank.bankServices.BankServiceInter;
//import ch.qos.logback.core.model.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/account")
public class BankController {
	@Autowired
	private BankServiceInter serviceInter;

	@PostMapping("/create")
	public String postMethodName(@RequestBody AccountDto details) {
		return serviceInter.save(details);
	}

	@GetMapping("/getall")
	public List<AccountDto> getMethodName() {
		return serviceInter.getall();

	}

	@GetMapping("/balance")
	public List<AccountDto> getBalance(@RequestParam String accountNumber) {
		
		return serviceInter.getBalance(accountNumber);

	}

	@PutMapping("/deposit")
	public String Deposit(@RequestParam String accountno, @RequestParam Long deposit) {
		if(deposit>0) {
			return serviceInter.updateBalance(accountno, deposit);
		}
		return "enter the valid deposit ammount";
	}

	@PutMapping("/withdraw")
	public String withDraw(@RequestParam String accountno, @RequestParam Long amount) {
		if(amount>0) {
			
		
		return serviceInter.withDraw(accountno, amount);
		}else {
			return "enter the valid amount";
		}
	}

	@PutMapping("/accountTransfer/{fromAccount}/{toAccount}/{ammount}")
	public String putMethodName(@RequestParam String fromAccount, @RequestParam String toAccount,@RequestParam Long ammount) {
		
		if(ammount>0) {
		return	serviceInter.accountTransferMoney(fromAccount, toAccount, ammount);
		}
		return "enter the valid ammount";

	}

}
