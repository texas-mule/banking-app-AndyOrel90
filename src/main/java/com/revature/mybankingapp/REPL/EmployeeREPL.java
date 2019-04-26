package com.revature.mybankingapp.REPL;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.*;
import com.revaure.mybankingapp.dao.AccountDAOImpl;
import com.revaure.mybankingapp.dao.ApplicationDAOImpl;
import com.revaure.mybankingapp.dao.CustomerDAOImpl;

public class EmployeeREPL {

	private CustomerDAOImpl customerdao = new CustomerDAOImpl();
	private ApplicationDAOImpl applicationdao = new ApplicationDAOImpl();
	private AccountDAOImpl accountdao = new AccountDAOImpl();

	private ArrayList<Application> applications = new ArrayList<>();

	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Account> accounts = new ArrayList<>();

	private BankAdmin admin = new BankAdmin();

	public EmployeeREPL() {

		this.customers = this.customerdao.getCustomers();
		this.applications = this.applicationdao.getApplications();
		this.accounts = this.accountdao.getAccounts();
	}

	private Application getApplicationbyid(long id) {
		for (int i = 0; i < this.applications.size(); i++) {
			if (this.applications.get(i).getApplicationid() == id) {
				System.out.println(applications.get(i).getApplicationid());
				return this.applications.get(i);
			}
		}

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
				if(app.getStatus().equals(new String("customerapplied")))
				{
					this.admin.approveCustomerApplication(app);
				}
				else
				{
					this.admin.approveApplication(app);
				}
				
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

	private Account getAccountByAccountnumber(long accountnumber) {
		for (int i = 0; i < this.accounts.size(); i++) {
			if (this.accounts.get(i).getAccountnumber() == accountnumber) {
				System.out.println(accounts.get(i).getAccountnumber());
				return this.accounts.get(i);
			}
		}

		return null;
	}

	private void updateAccountList() {
		this.accounts = this.accountdao.getAccounts();
	}


	public void run(Customer loggedinuser) {

		Scanner input = new Scanner(System.in);
		int option = 0;
		boolean exit = true;

		while (exit) {

			System.out.println("");
			System.out.println("******************************************");
			System.out.println("Employee Main Menu");
			System.out.println("Welcome " + loggedinuser.getFirstname() + " " + loggedinuser.getLastname());
			System.out.println("Choose your option below:");
			System.out.println("Press 1 to view all customers:");
			System.out.println("Press 2 to view all applications:");
			System.out.println("Press 3 to approve application:");
			System.out.println("Press 4 to deny application:");
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
					this.updateAccountList();
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
