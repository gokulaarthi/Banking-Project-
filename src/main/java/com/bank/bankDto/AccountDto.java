package com.bank.bankDto;


public class AccountDto {
	private long id;
	private String accountName;
	private String fatherName;
	private String aadharNumber;
	private String mobileNumber;
	private String accountNumber;
	private Long accountBAlance ;
	private String dateOFBirth;
	private String address;
	public AccountDto() {
		super();
	}
	public AccountDto(long id, String accountName, String fatherName, String aadharNumber, String mobileNumber,
			String accountNumber, Long accountBAlance, String dateOFBirth, String address) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.fatherName = fatherName;
		this.aadharNumber = aadharNumber;
		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
		this.accountBAlance = accountBAlance;
		this.dateOFBirth = dateOFBirth;
		this.address = address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getAccountBAlance() {
		return accountBAlance;
	}
	public void setAccountBAlance(Long accountBAlance) {
		this.accountBAlance = accountBAlance;
	}
	public String getDateOFBirth() {
		return dateOFBirth;
	}
	public void setDateOFBirth(String dateOFBirth) {
		this.dateOFBirth = dateOFBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	

}
