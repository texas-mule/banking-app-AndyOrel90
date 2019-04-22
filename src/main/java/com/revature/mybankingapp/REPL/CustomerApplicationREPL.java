package com.revature.mybankingapp.REPL;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.Application;

public class CustomerApplicationREPL {
	private String firstname;
	private String lastname;
	private long userid;
	private String username;
	
	public CustomerApplicationREPL(String firstname, String lastname, String username, long userid) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.userid = userid;
		
	}
	
	public void startApplication() {
		Scanner input = new Scanner(System.in);
		
		String acttype = null;
		String usertype = "customer";
		long appid = 0;
		boolean exit1 = true;
		int enteredaccounttype = 0;
		boolean exit2 = true;
		long depositamount = 25;
		long currentuser = 0;
		
		//gets input to set up a checking or savings account
		//loops through if neither hasnt been selected
		while(exit1)
		{
			System.out.print("Press 1 for checking account and press 2 for savings:");
			
			try {
				
				enteredaccounttype = input.nextInt();
				
			} catch (Exception e) {
				input.next();
				System.out.println("Invalid choice");
				
			} finally {
				
					switch(enteredaccounttype) {
					case 1: acttype = "checking";
							exit1 = false;
							break;
					case 2: acttype = "savings";
							exit1 = false;
							break;
					default:
				}
			}
		}
		
		
		while(exit2)
		{
			System.out.print("Deposit Amount (only dollar amount, minimum 25):");
			
			try {
				
				depositamount = input.nextLong();
				
			} catch (Exception e) {
				input.next();
				System.out.println("Invalid amount");
				
			} finally {
				if(depositamount < 25)
				{
					System.out.println("Minimum deposit is 25");
				}
				else
				{
					exit2 = false;
				}
			}
		}
		

		Application application = new Application();
		application.setApplicationid(appid);
		application.setFirstname(this.firstname);
		application.setLastname(this.lastname);
		application.setUsername(this.username);
		application.setPassword("already exists");
		application.setUsertype("customer");
		application.setAccounttype("checking");
		application.setDepositamount(depositamount);
		application.setStatus("customerapplied");
		application.setCurrentuser(this.userid);
		
		application.saveNewApplicationFromUser();
		
		
		System.out.println("");
		System.out.println("******************************************");
		System.out.println("Your application has been created and sent.");
		System.out.println("Please wait for approval.");
		System.out.println("******************************************");
		System.out.println("");
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);
		int option = 0;
		boolean exit = true;
		
		System.out.println("");
		System.out.println("******************************************");
		System.out.println("Application Menu");
		System.out.println("Choose your option below:");
		System.out.println("Press 1 to Apply:");
		System.out.println("Press 2 to Exit:");
		System.out.println("******************************************");
		System.out.println("");
		
		try {
			option = input.nextInt();

	        }catch (InputMismatchException e) {
	        	
	           input.next();

	           System.out.println("Invalid choice");
	          
	        } finally {

	     		switch(option) {
	     			case 1: startApplication();
	     					break;
	     			case 2: exit = false;
 							break;
	     			default: System.out.println("Try again");
	     		
	     		}
	        }
	}
	
}
