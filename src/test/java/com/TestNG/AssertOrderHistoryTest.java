package com.TestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import com.ObjectRepository.OrderHistoryPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.UserLoginPage;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

public class AssertOrderHistoryTest {

	@Test
	public void OrderHistoryTest() throws IOException {

		FileUtils fLib = new FileUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		// get common data from property file
		String UURL = fLib.readDataFromPropertyFile("uurl");
		String UUSERNAME = fLib.readDataFromPropertyFile("uusername");
		String UPASSWORD = fLib.readDataFromPropertyFile("upassword");
			    
		//launch browser
	    WebDriver driver = new ChromeDriver();
			 
		//maximize the browser
	    wLib.windowMax(driver);
	    
		//enter url
		driver.get(UURL);
			  	
		//wait pageload statement
		wLib.waitPageLoad(driver, 10);
		
	  	//login to application
		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.userLoginToApp(UUSERNAME, UPASSWORD);
		
		//click on my account link
		UserHomePage uhp = new UserHomePage(driver);
		uhp.clickMyAccountLink();
		
	  	//click on order history
	  	OrderHistoryPage ohp = new OrderHistoryPage(driver);
	  	String res = ohp.OrderHistoryPageTitle();
	  	
	  	String expRes = "Shopping Cart";  //pass
	  	//String expRes = "ShoppingCart";  //fail
	  	
	  	assertEquals(res, expRes,"Expected result not matching with actual result" );
	  
	  /*	if(res.equalsIgnoreCase("Shopping Cart")) 
	  	{
	  		System.out.println("order history page displayed");
	  	}
	  	else
	  	{
	  		System.out.println("order history page not displayed");
	  	} */
	  	
	    //logout application
        
        uhp.logoutApp();
	  	
	  	//close driver
	  	driver.quit();
}
}
