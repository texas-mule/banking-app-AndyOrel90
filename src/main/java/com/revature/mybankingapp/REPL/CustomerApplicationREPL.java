package com.revature.mybankingapp.REPL;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.mybankingapp.Application;
import com.revature.mybankingapp.MoneyParser;

public class CustomerApplicationREPL {
	private String firstname;
	private String lastname;
	private long userid;
	private String username;
	
	private MoneyParser mparser = new MoneyParser();

	public CustomerApplicationREPL(String firstname, String lastname, String username, long userid) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.userid = userid;

	}

	private void startSingleApplication() {
		Scanner input = new Scanner(System.in);

		String acttype = null;
		String usertype = "customer";
		long appid = 0;
		boolean exit1 = true;
		int enteredaccounttype = 0;
		boolean exit2 = true;
		double depositamount = 25;
		long currentuser = 0;

		// gets input to set up a checking or savings account
		// loops through if neither hasnt been selected
		while (exit1) {
			System.out.print("Press 1 for checking account and press 2 for savings:");

			try {

				enteredaccounttype = input.nextInt();

			} catch (Exception e) {
				input.next();
				System.out.println("Invalid choice");

			} finally {

				switch (enteredaccounttype) {
				case 1:
					acttype = "checking";
					exit1 = false;
					break;
				case 2:
					acttype = "savings";
					exit1 = false;
					break;
				default:
				}
			}
		}

		while (exit2) {
			System.out.print("Deposit Amount (only dollar amount, minimum 25):");

			try {

				depositamount = input.nextDouble();
				depositamount = mparser.parse(depositamount);

			} catch (Exception e) {
				input.next();
				System.out.println("Invalid amount");

			} finally {
				if (depositamount < 25) {
					System.out.println("Minimum deposit is 25");
				} else {
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
		application.setAccounttype(acttype);
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
	
	private void startJointApplication() {
		Scanner input = new Scanner(System.in);

		String acttype = null;
		String usertype = "customer";
		long appid = 0;
		boolean exit1 = true;
		int enteredaccounttype = 0;
		boolean exit2 = true;
		double depositamount = 25;
		long currentuser = 0;
		
		System.out.println("Second User Info:");
		System.out.print("First Name:");
		String firstname2 = input.nextLine();
		System.out.print("Last Name:");
		String lastname2 = input.nextLine();
		System.out.print("User Name:");
		String username2 = input.nextLine();
		System.out.print("Password:");
		String password2 = input.nextLine();

		// gets input to set up a checking or savings account
		// loops through if neither hasnt been selected
		while (exit1) {
			System.out.print("Press 1 for checking account and press 2 for savings:");

			try {

				enteredaccounttype = input.nextInt();

			} catch (Exception e) {
				input.next();
				System.out.println("Invalid choice");

			} finally {

				switch (enteredaccounttype) {
				case 1:
					acttype = "checking";
					exit1 = false;
					break;
				case 2:
					acttype = "savings";
					exit1 = false;
					break;
				default:
				}
			}
		}

		while (exit2) {
			System.out.print("Deposit Amount (only dollar amount, minimum 25):");

			try {

				depositamount = input.nextDouble();
				depositamount = mparser.parse(depositamount);

			} catch (Exception e) {
				input.next();
				System.out.println("Invalid amount");

			} finally {
				if (depositamount < 25) {
					System.out.println("Minimum deposit is 25");
				} else {
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
		application.setDepositamount(depositamount);
		application.setStatus("jointappliedfromcustomer");
		application.setAccounttype(acttype);
		application.setFirstname2(firstname2);
		application.setLastname2(lastname2);
		application.setUsername2(username2);
		application.setPassword2(password2);
		application.setIsjointaccount(true);
		application.setUsertype("customer");
		application.setCurrentuser(this.userid);

		application.saveNewJointApplicationFromUser();

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
		System.out.println("Press 1 to Apply to a Single Account:");
		System.out.println("Press 2 to Apply for a Joint Acount");
		System.out.println("Press 0 to Exit:");
		System.out.println("******************************************");
		System.out.println("");

		try {
			option = input.nextInt();

		} catch (InputMismatchException e) {

			input.next();

			System.out.println("Invalid choice");

		} finally {

			switch (option) {
			case 1:
				startSingleApplication();
				break;
			case 2:
				startJointApplication();
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
