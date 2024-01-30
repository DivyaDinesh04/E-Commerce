package com.TestNG;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ObjectRepository.OrderHistoryPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.UserLoginPage;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

public class SoftAssertOHPTest {
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
	  	
	  	String expRes = "Shopping Cart";    //pass
	  	//String expRes = "ShoppingCart";   //fail
	  	
	  	SoftAssert sa = new SoftAssert();
	  	sa.assertEquals(res, expRes,"Expected result not matching with actual result");
	  	sa.assertEquals(res, expRes,"Expected result not matching with actual result");
	  	
	    //logout application
        uhp.logoutApp();
	  	
	  	//close driver
	  	driver.quit();
	  	System.out.println("hi");
	  	sa.assertAll();
}
}
