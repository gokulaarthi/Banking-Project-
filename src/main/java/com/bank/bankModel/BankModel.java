package com.bank.bankModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Account_Information")
public class BankModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id" )
	private long id;
	
	@Column(name="accountName")
	private String accountName;
	
	@Column(name="fatherName")
	private String fatherNAme;
	
	@Column(name="aadharNumber",unique = true)
	private String aadharNumber;
	
	@Column(name="mobileNumber",nullable = false)
	private String mobileNumber;
	
	@Column(name="accountNumber" ,unique = true)
	private String accountNumber;
	
	@Column(name="accountBAlance")
	private Long accountBAlance ;
	
	@Column(name="dateOfBirth",nullable = false)
	private String dateOfBirth;
	
	@Column(name="address")
	private String address;
	
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
	public String getFatherNAme() {
		return fatherNAme;
	}
	public void setFatherNAme(String fatherNAme) {
		this.fatherNAme = fatherNAme;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
