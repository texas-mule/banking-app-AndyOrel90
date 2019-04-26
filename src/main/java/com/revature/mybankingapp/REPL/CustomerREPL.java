package com.revature.mybankingapp.REPL;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.Account;
import com.revature.mybankingapp.Customer;
import com.revature.mybankingapp.MoneyParser;

public class CustomerREPL extends ConsoleREPL {

	private Customer loggedincustomer = new Customer();
	private MoneyParser mparser = new MoneyParser();

	private Account getAccountByAccountnumber(long accountnumber) {
		ArrayList<Account> actlist = new ArrayList();

		actlist = this.loggedincustomer.getAccountList();

		for (int i = 0; i < actlist.size(); i++) {
			if (actlist.get(i).getAccountnumber() == accountnumber) {
				return actlist.get(i);
			}
		}

		return null;
	}

	private boolean option1() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Account Number you would like to deposit to");
		System.out.print("Account Number: ");
		Account account = new Account();
		double depositamount = -1;
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
			depositamount = input.nextDouble();
			depositamount = mparser.parse(depositamount);

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
			this.loggedincustomer.deposit(account, depositamount);
			return false;
		}
	}

	private boolean option2() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Account Number you would like to withdraw from");
		System.out.print("Account Number: ");
		Account account = new Account();
		double withdrawamount = -1;
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
			withdrawamount = input.nextDouble();
			withdrawamount = mparser.parse(withdrawamount);

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
			this.loggedincustomer.withdraw(account, withdrawamount);
			return false;
		}
	}

	private boolean option3() {
		Scanner input = new Scanner(System.in);
		Account fromaccountobj = new Account();
		Account toaccountobj = new Account();
		double transferamount = -1;
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
			transferamount = input.nextDouble();
			transferamount = mparser.parse(transferamount);

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
			this.loggedincustomer.transfer(transferamount, fromaccountobj, toaccountnumber);
			return false;
		}
	}

	private boolean option4() {
		ArrayList<Account> actlist = new ArrayList();
		actlist = loggedincustomer.getAccountList();

		System.out.println("Your accounts: ");

		for (int i = 0; i < actlist.size(); i++) {
			System.out.println("* Routing Number: " + actlist.get(i).getRoutingnumber() + " Account Number: "
					+ actlist.get(i).getAccountnumber() + " Account Type: " + actlist.get(i).getAccounttype()
					+ " Balance: " + actlist.get(i).getAccountbalance());
		}
		return false;
	}

	public void run(Customer loggedinuser) {

		Scanner input = new Scanner(System.in);
		int option = 0;
		boolean exit = true;
		this.loggedincustomer = loggedinuser;
		loggedincustomer.setAccountList();

		while (exit) {

			System.out.println("");
			System.out.println("******************************************");
			System.out.println("Customer Main Menu");
			System.out.println("Welcome " + loggedinuser.getFirstname() + " " + loggedinuser.getLastname());
			System.out.println("Choose your option below:");
			System.out.println("Press 1 to deposit funds to account:");
			System.out.println("Press 2 to withdraw funds from account:");
			System.out.println("Press 3 to transfer funds to another account:");
			System.out.println("Press 4 to view all your accounts and their balance:");
			System.out.println("Press 5 to apply for a new account:");
			System.out.println("Press 6 to apply for a joint account:");
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
				case 1: // deposit
					int count1 = 0;
					while (this.option1()) {
						if (count1 >= 2) {
							break;
						}
						count1++;
					}
					break;
				case 2: // withdraw
					int count2 = 0;
					while (this.option2()) {
						if (count2 >= 2) {
							break;
						}
						count2++;
					}
					break;
				case 3: // transfer
					int count3 = 0;
					while (this.option3()) {
						if (count3 >= 2) {
							break;
						}
						count3++;
					}
					break;
				case 4: // view all user account
					int count4 = 0;
					while (this.option4()) {
						if (count4 >= 2) {
							break;
						}
						count4++;
					}
					break;
				case 5: // apply for new account
					CustomerApplicationREPL crepl = new CustomerApplicationREPL(this.loggedincustomer.getFirstname(),
							this.loggedincustomer.getLastname(), this.loggedincustomer.getUsername(), this.loggedincustomer.getUserid());
					crepl.run();
				case 6: // apply for a joint account
					CustomerApplicationREPL cjrepl = new CustomerApplicationREPL(this.loggedincustomer.getFirstname(),
							this.loggedincustomer.getLastname(), this.loggedincustomer.getUsername(), this.loggedincustomer.getUserid());
					cjrepl.run();
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
