package com.example.easynotes.model;

public class LoanRequest {
	long customerId;
    String customerName;
    String customerEmail;
    String gender;
    long customerPhone;
    String customerAddress;
    String panNumber;
    String aadharNumber;
    long loanAmount;
    
    public long getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(long loanAmount) {
		this.loanAmount = loanAmount;
	}
	public double getLoanId() {
		return loanId;
	}
	public void setLoanId(double loanId) {
		this.loanId = loanId;
	}
	double monthlyIncome;
    double loanId;

    public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(long customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
    
}
