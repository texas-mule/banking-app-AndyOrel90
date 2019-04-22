package com.revature.mybankingapp.REPL;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.*;
import com.revaure.mybankingapp.dao.AccountDAOImpl;
import com.revaure.mybankingapp.dao.ApplicationDAOImpl;
import com.revaure.mybankingapp.dao.CustomerDAOImpl;

public class AdminREPL {

	private CustomerDAOImpl customerdao = new CustomerDAOImpl();
	private ApplicationDAOImpl applicationdao = new ApplicationDAOImpl();
	private AccountDAOImpl accountdao = new AccountDAOImpl();

	private ArrayList<Application> applications = new ArrayList<>();

	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Account> accounts = new ArrayList<>();

	private BankAdmin admin = new BankAdmin();

	public AdminREPL() {

		this.customers = this.customerdao.getCustomers();
		this.applications = this.applicationdao.getApplications();
		this.accounts = this.accountdao.getAccounts();
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

	private boolean option7() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Account Number you would like to deposit to");
		System.out.print("Account Number: ");
		Account account = new Account();
		long depositamount = -1;
		long accountnumber = -1;

		try {
			accountnumber = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();

			System.out.println("Invalid character");
			return true;
		}

		account = this.getAccountByAccountnumber(accountnumber);

		if (account == null) {
			System.out.println("");
			System.out.println("Account not found");
			System.out.println("");
			return true;
		}

		System.out.println("Enter the amount you would like to deposit");
		System.out.print("Deposit Amount: ");

		try {
			depositamount = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();
			System.out.println("");
			System.out.println("Invalid character");
			System.out.println("");
			return true;
		}

		if (depositamount < 0) {
			System.out.println("");
			System.out.println("Invalid deposit");
			System.out.println("");
			return true;
		} else {
			this.admin.deposit(account, depositamount);
			return false;
		}

	}

	private boolean option6() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Account Number you would like to withdraw from");
		System.out.print("Account Number: ");
		Account account = new Account();
		long withdrawamount = -1;
		long accountnumber = -1;

		try {
			accountnumber = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();

			System.out.println("Invalid character");
			return true;
		}

		account = this.getAccountByAccountnumber(accountnumber);

		if (account == null) {
			System.out.println("");
			System.out.println("Account not found");
			System.out.println("");
			return true;
		}

		System.out.println("Enter the amount you would like to withdraw");
		System.out.print("Withdraw Amount: ");

		try {
			withdrawamount = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();
			System.out.println("");
			System.out.println("Invalid character");
			System.out.println("");
			return true;
		}

		if (withdrawamount < 0) {
			System.out.println("");
			System.out.println("Invalid deposit");
			System.out.println("");
			return true;
		} else {
			this.admin.withdraw(account, withdrawamount);
			return false;
		}

	}

	private boolean option8() {
		Scanner input = new Scanner(System.in);
		Account fromaccountobj = new Account();
		Account toaccountobj = new Account();
		long transferamount = -1;
		long fromaccountnumber = -1;
		long toaccountnumber = -1;

		// from account
		System.out.println("Enter Account Number you would like to Transfer from");
		System.out.print("Account Number: ");

		try {
			fromaccountnumber = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();

			System.out.println("Invalid character");
			return true;
		}

		fromaccountobj = this.getAccountByAccountnumber(fromaccountnumber);

		if (fromaccountobj == null) {
			System.out.println("");
			System.out.println("From Account not found");
			System.out.println("");
			return true;
		}

		// to account
		System.out.println("Enter Account Number you would like to Transfer to");
		System.out.print("Account Number: ");

		try {
			toaccountnumber = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();

			System.out.println("Invalid character");
			return true;
		}

		toaccountobj = this.getAccountByAccountnumber(toaccountnumber);

		if (toaccountobj == null) {
			System.out.println("");
			System.out.println("To Account not found");
			System.out.println("");
			return true;
		}

		System.out.println("Enter the amount you would like to transfer");
		System.out.print("Transfer Amount: ");

		try {
			transferamount = input.nextLong();

		} catch (InputMismatchException e) {
			input.next();
			System.out.println("");
			System.out.println("Invalid character");
			System.out.println("");
			return true;
		}

		if (transferamount < 0) {
			System.out.println("");
			System.out.println("Invalid deposit");
			System.out.println("");
			return true;
		} else {
			this.admin.transfer(transferamount, fromaccountobj, toaccountnumber);
			return false;
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
				case 5: // cancel account
						// admin.cancelAccount();
					break;
				case 6: // withdraw
					int count6 = 0;
					while (this.option6()) {
						if (count6 >= 2) {
							break;
						}
						count6++;
					}
					break;
				case 7: // deposit
					int count7 = 0;
					while (this.option7()) {
						if (count7 >= 2) {
							break;
						}
						count7++;
					}
					break;
				case 8: // transfer
					int count8 = 0;
					while (this.option8()) {
						if (count8 >= 2) {
							break;
						}
						count8++;
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
