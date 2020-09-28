package com.policy.domain;

public class LicPolicy {
	private int policyNumber;
	private String policyName;   
	private String policyHolderName;
	private String policyStartDate;
	private float premiumAmount;
	private String premiumType;
	
	public LicPolicy() {
		super();
	}
	
	public LicPolicy(int policyNumber, String policyName, String policyHolderName, String policyStartDate,
			float premiumAmount, String premiumType) {
		super();
		this.policyNumber=policyNumber;
		this.policyName = policyName;
		this.policyHolderName = policyHolderName;
		this.policyStartDate = policyStartDate;
		this.premiumAmount = premiumAmount;
		this.premiumType = premiumType;
	}
	
	
	public LicPolicy(String policyName, String policyHolderName, String policyStartDate,
			float premiumAmount, String premiumType) {
		super();
		this.policyName = policyName;
		this.policyHolderName = policyHolderName;
		this.policyStartDate = policyStartDate;
		this.premiumAmount = premiumAmount;
		this.premiumType = premiumType;
	}
	
	public LicPolicy(int policyNumber) {
		super();
		this.policyNumber = policyNumber;
	}
	
	public LicPolicy(int policyNumber,float premiumAmount) {
		super();
		this.policyNumber = policyNumber;
		this.premiumAmount=premiumAmount;
	}
	

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(String policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public float getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

}

