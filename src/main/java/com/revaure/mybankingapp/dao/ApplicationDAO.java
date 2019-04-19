package com.revaure.mybankingapp.dao;

import java.util.ArrayList;

import com.revature.mybankingapp.Application;

public interface ApplicationDAO {
	
	public void saveApplication(Application application);
	public void approveApplication(Application application);
	public void denyApplication(Application application);
	public ArrayList<Application> getApplications();

}
