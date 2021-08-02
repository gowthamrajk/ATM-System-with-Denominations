package com.gowthamrajk.atmsystem;

public class TransactionHistory 
{
	private String date;
	private String mode;
	private int deposit;
	private int withdrawal;
	private int balance;
	
	public TransactionHistory() 
	{
		super();
	}

	public TransactionHistory(String date, String mode, int deposit, int withdrawal, int balance) 
	{
		super();
		this.date = date;
		this.mode = mode;
		this.deposit = deposit;
		this.withdrawal = withdrawal;
		this.balance = balance;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}

	public String getMode() 
	{
		return mode;
	}

	public void setMode(String mode) 
	{
		this.mode = mode;
	}

	public int getDeposit() 
	{
		return deposit;
	}

	public void setDeposit(int deposit) 
	{
		this.deposit = deposit;
	}

	public int getWithdrawal() 
	{
		return withdrawal;
	}

	public void setWithdrawal(int withdrawal) 
	{
		this.withdrawal = withdrawal;
	}

	public int getBalance() 
	{
		return balance;
	}

	public void setBalance(int balance) 
	{
		this.balance = balance;
	}
}