package com.revature.mybankingapp.REPL;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.mybankingapp.Customer;
import com.revaure.mybankingapp.dao.CustomerDAO;
import com.revaure.mybankingapp.dao.CustomerDAOImpl;


public class MainREPL {
	
	private Customer loggedinuserobj;
	
	private static final Logger log = Logger.getLogger(MainREPL.class.getName());
	
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
		//TODO add approve joint account from admin view
		//TODO check what happens if user already exists shouldnt allow insert user to app
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
		System.out.println("Press 2 to Apply for a single member bank account:");
		System.out.println("Press 3 to Apply for a joint bank account");
		System.out.println("Press 0 to Exit:");
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
			     									 log.info("The Following User has loggedin: " + loggedinuserobj.getUserid() + " " + loggedinuserobj.getFirstname() + " " + loggedinuserobj.getLastname());
			     						break;
			     					case "employee": EmployeeREPL erepl = new EmployeeREPL();
			     									 erepl.run(loggedinuserobj);
			     									log.info("The Following User has loggedin: " + loggedinuserobj.getUserid() + " " + loggedinuserobj.getFirstname() + " " + loggedinuserobj.getLastname());
			     						break;
			     					case "admin": AdminREPL arepl = new AdminREPL();
			     								  arepl.run(loggedinuserobj);
			     								 log.info("The Following User has loggedin: " + loggedinuserobj.getUserid() + " " + loggedinuserobj.getFirstname() + " " + loggedinuserobj.getLastname());
			     						break;
			     				}
			     			}
	     					break;
	     			case 2: JointApplicationREPL arepl = new JointApplicationREPL();
	     					arepl.run();
	     					log.info("The Following User has loggedin: " + loggedinuserobj.getUserid() + " " + loggedinuserobj.getFirstname() + " " + loggedinuserobj.getLastname());
	     					break;
	     			case 3: JointApplicationREPL jarepl = new JointApplicationREPL();
 							jarepl.run();
 							log.info("The Following User has loggedin: " + loggedinuserobj.getUserid() + " " + loggedinuserobj.getFirstname() + " " + loggedinuserobj.getLastname());
 					break;
	     			case 0: exit = false;
	     			log.info("The Following User has loggedout: " + loggedinuserobj.getUserid() + " " + loggedinuserobj.getFirstname() + " " + loggedinuserobj.getLastname());
	     					System.out.println("Enjoy your day!!");
 							break;
	     			default: System.out.println("Try again");
	     		
	     		}
	        }
		}
		input.close();
	}

}
