package com.revature.mybankingapp;

import java.util.ArrayList;

import com.revaure.mybankingapp.dao.ApplicationDAO;
import com.revaure.mybankingapp.dao.ApplicationDAOImpl;
import com.revaure.mybankingapp.dao.CustomerDAO;
import com.revaure.mybankingapp.dao.CustomerDAOImpl;

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

    /*
     * @Before
     * public void setup(){
     *  //variables setup here are available with 
     * }
     */
    
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
		CustomerDAO userdao = new CustomerDAOImpl();
		
		loggedinuser = userdao.login("username1", "password1");
		
		Class aClass = loggedinuser.getClass();
    	
        assertTrue(aClass.isInstance(test));
    }
    
    public void testUserDAOgetUserRArrayList()
    {
    	//checks if method returns a ArrayList
    	ArrayList<Customer> customerlist = new ArrayList<>();
    	
    	ArrayList<Customer> test = new ArrayList<>();

		CustomerDAO customerdao = new CustomerDAOImpl();
		
		customerlist = customerdao.getCustomers();
		
		Class aClass = customerlist.getClass();
    	
        assertTrue(aClass.isInstance(test));
    }
    
    public void testUserDAOgetUserRArrayListUser()
    {
    	//checks if method returns a ArrayList and inside the list are users
    	ArrayList<Customer> customerlist = new ArrayList<>();
    	
    	Customer customer = new Customer();
    	User testuser = new Customer();
		CustomerDAO customerdao = new CustomerDAOImpl();
		
		customer = customerdao.getCustomers().get(0);
		
		Class aClass = customer.getClass();
    	
        assertTrue(aClass.isInstance(testuser));
    }
    
    public void testApplicationDAOgetApplicationsArrayList()
    {
    	//checks if method returns a ArrayList
    	ArrayList<Application> applist = new ArrayList<>();
    	
    	ArrayList<Application> testapp = new ArrayList<>();

		ApplicationDAO appdao = new ApplicationDAOImpl();
		
		applist = appdao.getApplications();
		
		Class aClass = applist.getClass();
    	
        assertTrue(aClass.isInstance(testapp));
    }
    
    public void testgetApplications()
    {
    	//checks if method returns a ArrayList and inside the list are users
    	ArrayList<Application> applist = new ArrayList<>();
    	String fName = "";
    	
    	Application app = new Application(0, "", "", "", "", "", "", 0, "");
    	Application testapp = new Application(0, fName, fName, fName, fName, fName, fName, 0, fName);
		ApplicationDAO appdao = new ApplicationDAOImpl();
		
		app = appdao.getApplications().get(0);
		
		Class aClass = app.getClass();
    	
        assertTrue(aClass.isInstance(testapp));
    }
    
}
