import java.util.Random;
import java.util.Scanner;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Bank {
	String name;
	int acc,pin,amt,transacc,transamt;
	
	void getData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------");
		System.out.println("Creating Account");
		System.out.println("Enter your name:");
		name=sc.nextLine();
		
		System.out.println("");
		System.out.println("Enter 6 digit account number:");
		acc=sc.nextInt();
		
		// PIN Generation
		// Using numeric values 
        String numbers = "0123456789"; 
 
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[5]; 
  
        for (int i = 0; i < 4; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        String PIN = otp[0]+""+otp[1]+otp[2]+otp[3];
        System.out.println("Generated PIN: "+PIN);
        pin = Integer.parseInt(PIN);
		System.out.println("Enter money amount:");
		amt=sc.nextInt();
//		if(amt<1000)
//		{
//			System.out.println("Amount should be greater than $1000");
//			System.out.println("Enter money amount again:");
//			amt=sc.nextInt();
//		}
		System.out.println("------------------------");
		System.out.println("Account Created!");
		System.out.println("Congratulations!");
	}
	void depositeMoney()
	{
			Scanner sc = new Scanner(System.in);
			int dep=0;
			System.out.println("Login Successful");
			System.out.println("Enter your deposite value");
         	dep=sc.nextInt();
			amt=amt+dep;
			System.out.println("Amount successfully deposited!");
			System.out.println("New account balance: $"+amt);
		
		
	}
	void withdrawMoney()
	{
		Scanner sc = new Scanner(System.in);
		int with,sum;
		System.out.println("----------------");
		System.out.println("Withdraw Money");
		System.out.println("Enter your account number:");
		int num2=sc.nextInt();
		System.out.println("Enter your personal PIN:");
		int num3=sc.nextInt();
		if(num2==acc && num3==pin)
		{
			System.out.println("Login Successful");
			System.out.println("Enter your withdrawal value");
			with=sc.nextInt();
			sum=amt-with;
			if(sum>=0)
			{
				amt=amt-with;
				System.out.println("Amount successfully Withdrawn!");
				System.out.println("New account balance: $"+amt);
			}
			else
			{
				System.out.println("Transcation Failed!");
				System.out.println("Don't have sufficient funds.");
			}
			
		}
	}
	void showData()
	{
		System.out.print(name+"\t"+acc+"\t");
		System.out.println(amt);
	}
	void searchData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Name\tAcc No.\tPIN\tAmount($)");
		System.out.println(name+"\t"+acc+"\t"+pin+"\t"+amt);
	}
	void transferMoney(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the transfer amount:");
		transamt=sc.nextInt();
		int sum=0;
		sum=amt-transamt;
		if(sum>0)
		{
			amt=amt-transamt;
			System.out.println("Amount successfully Transfered!");
			System.out.println("New account balance: $"+amt);
		}
		else
		{
			System.out.println("Transcation Failed!");
			System.out.println("Don't have sufficient funds.");
		}
		
	}
	void addTransfer(int transferamt){
		amt=transferamt+amt;
	}
	int getTransferAcc()
	{
		return transacc;
	}
	int getTransferAmt()
	{
		return transamt;
	}
	int getPIN()
	{
		return pin;
	}
	int getAcc()
	{
		return acc;
	}
//	String getName()
//	{
//		return name;
//	}
	public void transfer(Bank x, int amount) {
		amt=amt-amount;
		x.amt=x.amt+amount;
	}
	
	public void changePin(int newPin)
	{
		pin = newPin;
	}

}
