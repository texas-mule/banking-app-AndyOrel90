package com.revature.mybankingapp.REPL;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.User;
import com.revaure.mybankingapp.dao.UserDAO;
import com.revaure.mybankingapp.dao.UserDAOImpl;

//import com.examples.ezoo.dao.FeedingScheduleDAO;
//import com.examples.ezoo.dao.FeedingScheduleDAOImpl;

public class MainREPL {
	
	private String usertype;
	
	private boolean handleUserLogin(String username, String password) {
		User loggedinuser = new User();
		UserDAO userdao = new UserDAOImpl();
		
		loggedinuser = userdao.login(username, password);
		
		if(loggedinuser.getFirstname() == null)
		{
			return true;
		}
		else
		{
			this.usertype = loggedinuser.getUsertype();
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
	        	 //System.out.println(option);
	     		
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
			     				//System.out.println("Welcome!!!");
			     				//run user login interface
			     				switch(this.usertype) {
			     					case "customer": //CustomerREPL crepl = new CustomerREPL();
			     									 //crepl.run();
			     						break;
			     					case "employee": //EmployeeREPL erepl = new EmployeeREPL();
			     									 //erepl.run();
			     						break;
			     					case "admin": //AdminREPL arepl = new AdminREPL();
			     								  //arepl.run();
			     						break;
			     				}
			     			}
	     					break;
	     			case 2: //run ApplicationREPL
	     					ApplicationREPL arepl = new ApplicationREPL();
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
