package com.revature.mybankingapp;

import java.util.ArrayList;

import com.revaure.mybankingapp.dao.ApplicationDAOImpl;

public class BankAdmin extends User {

	private ApplicationDAOImpl appdao = new ApplicationDAOImpl();

	public void printApplications(ArrayList<Application> applications) {

		System.out.println("All Applications");
		for (Application i : applications) {
			System.out.println("* " + i.toString());
		}
		System.out.println("");
	}

	public void printCustomers(ArrayList<Customer> customers) {

		System.out.println("All Customers");
		for (Customer i : customers) {
			System.out.println("* " + i.toString());
		}

		System.out.println("");
	}

	public void denyApplication(Application application) {
		appdao.denyApplication(application);

		System.out.println("");
		System.out.println("Application has been Denied and Updated");
		System.out.println("");
	}

	public void approveApplication(Application application) {
		appdao.approveApplication(application);

		System.out.println("");
		System.out.println("Application has been Approved and Updated");
		System.out.println("");
	}

	public void approveCustomerApplication(Application application) {
		appdao.approveCustomerApplication(application);

		System.out.println("");
		System.out.println("Application has been Approved and Updated");
		System.out.println("");
	}

	public void withdraw(Account account, double withdrawamount) {
		System.out.println("");
		System.out.println(account.withdraw(account, withdrawamount));
		System.out.println("");
	}

	public void transfer(double amount, Account fromaccount, long toaccountnumber) {
		System.out.println("");
		System.out.println(fromaccount.transfer(amount, fromaccount, toaccountnumber));
		System.out.println("");
	}

	public void deposit(Account account, double depositamount) {
		System.out.println("");
		System.out.println(account.deposit(account, depositamount));
		System.out.println("");
	}

	public void cancel(Account account) {
		System.out.println("");
		System.out.println(account.cancel(account));
		System.out.println("");
	}

}
