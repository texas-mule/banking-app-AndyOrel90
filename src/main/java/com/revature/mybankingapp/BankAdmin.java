package com.revature.mybankingapp;

import java.util.ArrayList;

import com.revaure.mybankingapp.dao.ApplicationDAOImpl;

public class BankAdmin extends User {

	private ApplicationDAOImpl appdao = new ApplicationDAOImpl();

	public void printApplications(ArrayList<Application> applications) {

		for (Application i : applications) {
			System.out.println("* " + i.toString());
		}
		System.out.println("");
	}

	public void printCustomers(ArrayList<Customer> customers) {

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

	public void withdraw(Account account, long withdrawamount) {
		System.out.println("");
		System.out.println(account.withdraw(account, withdrawamount));
		System.out.println("");
	}

	public void transfer(long amount, Account fromaccount, long toaccountnumber) {
		System.out.println("");
		System.out.println(fromaccount.transfer(amount, fromaccount, toaccountnumber));
		System.out.println("");
	}

	public void deposit(Account account, long depositamount) {
		System.out.println("");
		System.out.println(account.deposit(account, depositamount));
		System.out.println("");
	}

}
