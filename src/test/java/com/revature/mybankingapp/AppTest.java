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
    
    MoneyParser mparser = new MoneyParser();
    ArrayList<Customer> customerlist = new ArrayList<>();
    ArrayList<Application> applist = new ArrayList<>();

    
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
		
		loggedinuser = userdao.login("username1", "password");
		
		Class aClass = loggedinuser.getClass();
    	
        assertFalse(aClass.isInstance(test));
    }
    
    public void testUserDAOgetUserRArrayList()
    {
    	//checks if method returns a ArrayList
    	
    	
    	ArrayList<Customer> test = new ArrayList<>();

		CustomerDAO customerdao = new CustomerDAOImpl();
		
		customerlist = customerdao.getCustomers();
		
		Class aClass = customerlist.getClass();
    	
        assertTrue(aClass.isInstance(test));
    }
    
    public void testUserDAOgetUserRArrayListUser()
    {
    	//checks if method returns a ArrayList and inside the list are users
    	
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
    	ArrayList<Application> testapp = new ArrayList<>();

		ApplicationDAO appdao = new ApplicationDAOImpl();
		
		applist = appdao.getApplications();
		
		Class aClass = applist.getClass();
    	
        assertTrue(aClass.isInstance(testapp));
    }
    
    public void testgetApplications()
    {
    	//checks if method returns a ArrayList and inside the list are users
    	String fName = "";
    	
    	Application app = new Application(0, "", "", "", "", "", "", 0, "");
    	Application testapp = new Application(0, fName, fName, fName, fName, fName, fName, 0, fName);
		ApplicationDAO appdao = new ApplicationDAOImpl();
		
		app = appdao.getApplications().get(0);
		
		Class aClass = app.getClass();
    	
        assertTrue(aClass.isInstance(testapp));
    }
    
    public void testMoneyParser1() {
    	
    	assertTrue(mparser.parse(20.234) == 20.23);
    }
    
    public void testMoneyParser2() {
    	
    	assertTrue(mparser.parse(000.23) == 0.23);
    }
    
    public void testMoneyParser3() {
    	MoneyParser mparser = new MoneyParser();
    	
    	assertTrue(mparser.parse(1000.239340303) == 1000.24);
    }
    
    public void testMoneyParser4() {
    	
    	assertTrue(mparser.parse(1090900.2338438583) == 1090900.23);
    }
    
}
