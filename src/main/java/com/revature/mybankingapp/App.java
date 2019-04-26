package com.revature.mybankingapp;

import com.revature.mybankingapp.REPL.MainREPL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	//MainREPL main = new MainREPL();
    	
    	//main.run();
    	MoneyParser mparser = new MoneyParser();
    	
    	System.out.println(mparser.parse(1000.239340303));
    }
}
