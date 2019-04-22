package com.revature.mybankingapp.REPL;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.BankAdmin;
import com.revature.mybankingapp.Customer;
import com.revature.mybankingapp.Employee;
import com.revature.mybankingapp.User;
import com.revaure.mybankingapp.dao.CustomerDAO;
import com.revaure.mybankingapp.dao.CustomerDAOImpl;


public class MainREPL {
	
	private Customer loggedinuserobj;
	
	private boolean handleUserLogin(String username, String password) {
		Customer loggedinuser = new Customer();
		CustomerDAO customerdao = new CustomerDAOImpl();
		
		loggedinuser = customerdao.login(username, password);
		
		if(loggedinuser.getFirstname() == null)
		{
			return true;
		}
		else
		{
			this.loggedinuserobj = loggedinuser;
			return false;
		}
	}
	
	private boolean option1() {
		Scanner input = new Scanner(System.in);
		System.out.println("Login");
		System.out.print("User Name: ");
		String username = input.nextLine();
		System.out.print("Password: ");
		String password = input.nextLine();
		
		return this.handleUserLogin(username, password);
	}
	
	public void run() {
		
		Scanner input = new Scanner(System.in);
		int option = 0;
		boolean exit = true;
		
		
		while(exit)
		{
		System.out.println("******************************************");
		System.out.println("Welcome to my Banking App");
		System.out.println("Main Menu");
		System.out.println("Choose your option below:");
		System.out.println("Press 1 to Login:");
		System.out.println("Press 2 to Apply for a bank account:");
		System.out.println("Press 3 to Exit:");
		System.out.println("******************************************");
		
		try {
			option = input.nextInt();

	        }catch (InputMismatchException e) {
	           input.next();

	           System.out.println("Invalid choice");
	          
	        } finally {
	     		
	     		switch(option) {
	     			case 1: int count = 0; 
	     					boolean breakfromloop = false;
	     					while(this.option1()) {
	     						if(count >= 2)
	     						{
	     							breakfromloop = true;
	     							break;
	     						}
			     				count++;
			     			}
			     			if(!breakfromloop)
			     			{
			     				//run user login interface
			     				switch(this.loggedinuserobj.getUsertype()) {
			     					case "customer": CustomerREPL crepl = new CustomerREPL();
			     									 crepl.run(loggedinuserobj);
			     						break;
			     					case "employee": //EmployeeREPL erepl = new EmployeeREPL();
			     									 //erepl.run();
			     						break;
			     					case "admin": AdminREPL arepl = new AdminREPL();
			     								  arepl.run(loggedinuserobj);
			     						break;
			     				}
			     			}
	     					break;
	     			case 2: ApplicationREPL arepl = new ApplicationREPL();
	     					arepl.run();
	     					break;
	     			case 3: exit = false;
	     					System.out.println("Enjoy your day!!");
 							break;
	     			default: System.out.println("Try again");
	     		
	     		}
	        }
		}
		
	}

}
