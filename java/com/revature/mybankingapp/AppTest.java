package com.revature.mybankingapp;

import java.util.ArrayList;

import com.revaure.mybankingapp.dao.UserDAO;
import com.revaure.mybankingapp.dao.UserDAOImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testUserDAOlogin()
    {
    	User loggedinuser = new User();
    	User test = new User();
		UserDAO userdao = new UserDAOImpl();
		
		loggedinuser = userdao.login("username1", "password1");
		
		Class aClass = loggedinuser.getClass();
    	
        assertTrue(aClass.isInstance(test));
    }
    
    public void testUserDAOgetUserRArrayList()
    {
    	//checks if method returns a ArrayList
    	ArrayList<User> userlist = new ArrayList<>();
    	
    	ArrayList<User> test = new ArrayList<>();

		UserDAO userdao = new UserDAOImpl();
		
		userlist = userdao.getUsers();
		
		Class aClass = userlist.getClass();
    	
        assertTrue(aClass.isInstance(test));
    }
    
    public void testUserDAOgetUserRArrayListUser()
    {
    	//checks if method returns a ArrayList and inside the list are users
    	ArrayList<User> userlist = new ArrayList<>();
    	
    	User user = new User();
    	User testuser = new User();
		UserDAO userdao = new UserDAOImpl();
		
		user = userdao.getUsers().get(0);
		
		Class aClass = user.getClass();
    	
        assertTrue(aClass.isInstance(testuser));
    }
}
