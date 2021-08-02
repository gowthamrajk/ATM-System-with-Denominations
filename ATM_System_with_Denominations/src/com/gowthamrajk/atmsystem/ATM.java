package com.gowthamrajk.atmsystem;

class ATM
{
    private int total;
    private int depositingAmount;
    private int withdrawalAmount;
    
    public ATM() 
    {
		super();
	}

	public ATM(int total, int depositingAmount, int withdrawalAmount)
    {
		super();
        this.total = total;
        this.depositingAmount = depositingAmount;
        this.withdrawalAmount = withdrawalAmount;
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void setTotal(int total)
    {
        this.total = total;
    }
    
    public int getDepositingAmount()
    {
        return depositingAmount;
    }
    
    public void setDepositingAmount(int depositingAmount)
    {
        this.depositingAmount = depositingAmount;
    }
    
    public int  getWithdrawalAmount()
    {
        return withdrawalAmount;
    }
    
    public void setWithdrawalAmount(int withdrawalAmount)
    {
        this.withdrawalAmount = withdrawalAmount;
    }
}