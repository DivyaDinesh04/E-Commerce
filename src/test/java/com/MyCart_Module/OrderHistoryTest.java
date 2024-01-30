package com.MyCart_Module;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

public class OrderHistoryTest {

	public static void main(String[] args) throws IOException {
		
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
		driver.findElement(By.xpath("//a[.='Login']")).click();
	 	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(UUSERNAME);
	  	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(UPASSWORD);
	  	driver.findElement(By.name("login")).click();
			  	
		//click on my account link
	  	driver.findElement(By.xpath("//a[.='My Account']")).click();
	  	
	  	//click on order history
	  	driver.findElement(By.xpath("//a[.='Order History']")).click();
	  	String res = driver.findElement(By.xpath("//li[@class='active']")).getText();
	  	
	  	if(res.equalsIgnoreCase("Shopping Cart")) 
	  	{
	  		System.out.println("order history page displayed");
	  	}
	  	else
	  	{
	  		System.out.println("order history page not displayed");
	  	}
	  	
	    //logout application
	  	driver.findElement(By.xpath("//a[.='Logout']")).click();
			  	
	  	//close driver
	  	driver.quit();
			  	
	}

}
