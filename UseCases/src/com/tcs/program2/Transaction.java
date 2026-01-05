package com.tcs.program2;

public class Transaction{
	
	private String transactionId;
	
	private String transactionType;
	
	private double amount;

	private long timestamp;

	public Transaction(String transactionId, String transactionType, double amount, long timestamp) {
		super();
		this.setTransactionId(transactionId);
		this.setTransactionType(transactionType);
		this.setAmount(amount);
		this.setTimestamp(timestamp);
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String toString() {
		return transactionId+"   "+transactionType+"  "+amount+"   "+timestamp;
	}
}
