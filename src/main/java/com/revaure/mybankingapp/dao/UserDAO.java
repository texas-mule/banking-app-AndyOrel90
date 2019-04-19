package com.revaure.mybankingapp.dao;

import java.util.ArrayList;

import com.revature.mybankingapp.User;

public interface UserDAO {
	
	public User login(String username, String password);
	public ArrayList<User> getUsers();
	public void addUser(User user);
	
}
