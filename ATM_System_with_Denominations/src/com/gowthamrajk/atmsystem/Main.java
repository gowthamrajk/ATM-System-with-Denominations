package com.gowthamrajk.atmsystem;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Main 
{
	public static void updateDenominations(int amount, int denomination, Denominations denominationObj)
    {
        if(amount == 2000)
            denominationObj.setTwoThousands(denominationObj.getTwoThousands()+denomination);
        else if(amount == 500)
            denominationObj.setFiveHundreds(denominationObj.getFiveHundreds()+denomination);
        else if(amount == 200)
            denominationObj.setTwoHundreds(denominationObj.getTwoHundreds()+denomination);
        else if(amount == 100)
            denominationObj.setHundreds(denominationObj.getHundreds()+denomination);
    }
    
    public static void updateDepositingAmount(ATM atmObj, Denominations denominationObj)
    {
        int depositingAmount = denominationObj.getTwoThousands()*2000 + denominationObj.getFiveHundreds()*500 + denominationObj.getTwoHundreds()*200 + denominationObj.getHundreds()*100;
        atmObj.setDepositingAmount(depositingAmount);
        atmObj.setTotal(atmObj.getDepositingAmount());
    }
    
    public static void reduceDenominations(int amount, int denomination, Denominations denominationObj)
    {
        if(amount == 2000)
            denominationObj.setTwoThousands(denominationObj.getTwoThousands()-denomination);
        else if(amount == 500)
            denominationObj.setFiveHundreds(denominationObj.getFiveHundreds()-denomination);
        else if(amount == 200)
            denominationObj.setTwoHundreds(denominationObj.getTwoHundreds()-denomination);
        else if(amount == 100)
            denominationObj.setHundreds(denominationObj.getHundreds()-denomination);
    }
    
    public static void updateWithdrawalAmount(ATM atmObj, int withdrawalAmount)
    {
        atmObj.setWithdrawalAmount(withdrawalAmount);
        atmObj.setTotal(atmObj.getTotal()-withdrawalAmount);
    }
    
    public static int[] calculateDispensingDenomination(int[] notes, int withdrawalAmount)
    {
        int[] noteCounter = new int[notes.length];
        for (int index = 0; index < notes.length; index++) 
        {
             if(withdrawalAmount >= notes[index]) 
             {
                 noteCounter[index] = withdrawalAmount / notes[index];
                 withdrawalAmount = withdrawalAmount - noteCounter[index] * notes[index];
             }
        }
    	return noteCounter;
    }
    
    public static void main(String args[]) 
    {
        try(Scanner scanner = new Scanner(System.in)) 
        {
			Denominations denominationObj = new Denominations();
			ATM atmObj = new ATM();
			List<TransactionHistory> transactions = new ArrayList<>();
			int[] notes = new int[]{2000, 500, 200, 100};
			System.out.println("Welcome to Gowthamraj K's ATM Management System 👋");
		    System.out.println("Begin your Transactions Now...\n");
			while(true)
			{
			    int option = 0;
			    System.out.println("Choose any Option shown below\n1) Deposit \n2) Withdrawal \n3) View Transaction History \n4) End");
			    option = scanner.nextInt();
			    System.out.println();
			    scanner.nextLine();
			    switch(option)
			    {
			        case 1:
			        {
			        	System.out.println("### Depositing Console ###\n");
			            System.out.println("Enter the Denominations to be deposited...");
			            String denominations[] = scanner.nextLine().split(",");
			            for(String val : denominations)
			            {
			                String elements[] = val.split(":");
			                int amount = Integer.valueOf(elements[0].replaceAll("[^\\d]", " ").trim().replaceAll(" +", " "));
			                int denomination = Integer.valueOf(elements[1]);
			                if(amount < 0 || denomination < 0)
			                    System.out.println("Incorrect deposit amount\n");
			                else if(amount == 0 || denomination ==0)
			                    System.out.println("Deposit amount cannot be zero\n");
			                else  
			                    updateDenominations(amount, denomination, denominationObj);
			            }
			            updateDepositingAmount(atmObj, denominationObj);
			            System.out.print("\nBalance : 2000s="+denominationObj.getTwoThousands()+", ");
			            System.out.print("500s="+denominationObj.getFiveHundreds()+", ");
			            System.out.print("200s="+denominationObj.getTwoHundreds()+", ");
			            System.out.print("100s="+denominationObj.getHundreds()+", ");
			            System.out.println("Total="+atmObj.getTotal());
			            System.out.println("---------------------------------------------------------\n");
			            transactions.add(new TransactionHistory(getTodayDate(), "Deposited", atmObj.getDepositingAmount(), 0,atmObj.getTotal()));
			            break;
			        }
			        case 2:
			        {
			        	System.out.println("### Withdrawal Console ###\\n");
			            System.out.println("Enter the Amount to be Withdrawn...");
			            int withdrawalAmount = scanner.nextInt();
			            if( withdrawalAmount < 0 ||  withdrawalAmount == 0 || withdrawalAmount > atmObj.getTotal())
			            {
			                System.out.println("Incorrect or insufficient funds\n");
			                break;
			            }
			            int dispensingDenominations[] = calculateDispensingDenomination(notes, withdrawalAmount);
			            for(int index = 0; index < notes.length; index++)
			            {
			            	if(dispensingDenominations[index] != 0)
			            	{
			            	    System.out.print(notes[index]+"s="+dispensingDenominations[index]);
			            	    reduceDenominations(notes[index], dispensingDenominations[index], denominationObj);
			            	    if(index != notes.length-1)
			                	    System.out.print(", ");
			            	}
			            }
			            System.out.println();
			            updateWithdrawalAmount(atmObj, withdrawalAmount);
			            System.out.print("Balance : 2000s="+denominationObj.getTwoThousands()+", ");
			            System.out.print("500s="+denominationObj.getFiveHundreds()+", ");
			            System.out.print("200s="+denominationObj.getTwoHundreds()+", ");
			            System.out.print("100s="+denominationObj.getHundreds()+", ");
			            System.out.println("Total="+atmObj.getTotal());
			            System.out.println("---------------------------------------------------------\n");
			            transactions.add(new TransactionHistory(getTodayDate(), "Withdrawed", 0, atmObj.getWithdrawalAmount(), atmObj.getTotal()));
			            break;
			        }
			        case 3:
			        {
			        	if(transactions.size() == 0)
			        		System.out.println("Your Transaction is Empty 👎. Please make some transactions !!!\n\n");
			        	else
			        	{
			        	    System.out.println("Your Transaction History is : \n");
			        	    System.out.println("Date         Mode         Deposit     Withdrawal     Balance");
			        	    for(TransactionHistory transactionObj : transactions)
			        	    {
			        	    	System.out.println(transactionObj.getDate()+"   "+transactionObj.getMode()+"     "+transactionObj.getDeposit()+"        "+transactionObj.getWithdrawal()+"              "+transactionObj.getBalance());
			        	    }
			        	    System.out.println("\n");
			        	}
			        	break;
			        }
			        case 4:
			        {
			        	System.out.println("Thankyou for using my Console Application 😃");
			        	System.out.println("Hope you had a great time !!!");
			        	System.out.println("For queries, Reach me anytime at gowthamraj692@gmail.com (or) whatsapp to 9698382306");
			        	System.exit(0);
			        }
			        default:
			        {
			        	System.out.println("Please enter valid option, try again !!!\n\n");
			        }
			    }
			}
		} 
        catch(Exception exception) 
        {
        	exception.printStackTrace();
		}
    }
    
    public static String getTodayDate()
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        return formatter.format(date);  
    }
}