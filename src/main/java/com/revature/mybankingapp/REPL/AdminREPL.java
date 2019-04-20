package com.revature.mybankingapp.REPL;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.*;
import com.revaure.mybankingapp.dao.ApplicationDAOImpl;
import com.revaure.mybankingapp.dao.CustomerDAOImpl;

public class AdminREPL {

	private ArrayList<Application> applications = new ArrayList<>();
	private BankAdmin admin = new BankAdmin();
	private ArrayList<Customer> customers = new ArrayList<>();
	private CustomerDAOImpl customerdao = new CustomerDAOImpl();
	private ApplicationDAOImpl applicationdao = new ApplicationDAOImpl();

	public AdminREPL() {

		this.customers = this.customerdao.getCustomers();
		this.applications = applicationdao.getApplications();
	}

	public ArrayList<Customer> customers() {
		return null;

	}

	public ArrayList<Application> applications() {
		return null;

	}

	public void approveApplication(long applicationid) {

	}

	public void denyApplication(long applicationid) {

	}

	public void cancelApplication(long applicationid) {

	}

	private Application getApplicationbyid(long id) {
		for (Application app : this.applications) {
			if (app.getApplicationid() == id) {
				System.out.println(app.getApplicationid());
				return app;
			}
		}
		System.out.println("went to null");
		return null;
	}

	private boolean option3() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Application ID you would like to Approve");
		System.out.print("Application ID: ");
		Application app = new Application();
		long appid = -1;

		try {
			appid = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();

			System.out.println("Invalid character");

		}
		
		app = this.getApplicationbyid(appid);
		
		if (app == null) {
			System.out.println("Application not found");
			return true;
		} else {
			if (appid < 0) {
				return true;
			} else {
				this.admin.approveApplication(app);
				return false;
			}
		}

	}
	
	private boolean option4() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Application ID you would like to Deny");
		System.out.print("Application ID: ");
		Application app = new Application();
		long appid = -1;

		try {
			appid = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();

			System.out.println("Invalid character");

		}
		
		app = this.getApplicationbyid(appid);
		
		if (app == null) {
			System.out.println("Application not found");
			return true;
		} else {
			if (appid < 0) {
				return true;
			} else {
				this.admin.denyApplication(app);
				return false;
			}
		}

	}

	public void run(Customer loggedinuser) {

		Scanner input = new Scanner(System.in);
		int option = 0;
		boolean exit = true;

		while (exit) {

			System.out.println("");
			System.out.println("******************************************");
			System.out.println("Admin Main Menu");
			System.out.println("Welcome " + loggedinuser.getFirstname() + " " + loggedinuser.getLastname());
			System.out.println("Choose your option below:");
			System.out.println("Press 1 to view all customers:");
			System.out.println("Press 2 to view all applications:");
			System.out.println("Press 3 to approve application:");
			System.out.println("Press 4 to deny application:");
			System.out.println("Press 5 to cancel account:");
			System.out.println("Press 6 to withdraw from account:");
			System.out.println("Press 7 to deposit to account:");
			System.out.println("Press 8 to transfer to account:");
			System.out.println("Press 0 to exit:");
			System.out.println("******************************************");
			System.out.println("");

			try {
				option = input.nextInt();

			} catch (InputMismatchException e) {
				input.next();

				System.out.println("Invalid choice");

			} finally {

				switch (option) {
				case 1: // print out all customers
					this.admin.printCustomers(this.customers);
					break;
				case 2: // print all applications
					this.admin.printApplications(this.applications);
					break;
				case 3: // approve application
					int count = 0;
					while (this.option3()) {
						if (count >= 2) {
							break;
						}
						count++;
					}
					break;
				case 4: // deny application
					int count2 = 0;
					while (this.option4()) {
						if (count2 >= 2) {
							break;
						}
						count2++;
					}
					break;
				case 5: // cancel account
						// admin.cancelAccount();
					break;
				case 6: // withdraw
						// admin.withdraw();
					break;
				case 7: // deposit
						// admin.deposit();
					break;
				case 8: // transfer
						// admin.transfer();
					break;
				case 0:
					exit = false;
					break;
				default:
					System.out.println("Try again");
				}
			}
		}

	}

}
