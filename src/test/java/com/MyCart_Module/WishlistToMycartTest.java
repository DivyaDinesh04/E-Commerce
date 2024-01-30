package com.MyCart_Module;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ObjectRepository.UserLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

public class WishlistToMycartTest {

	public static void main(String[] args) throws IOException {
    
		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		// get common data from property file
		String UURL = fLib.readDataFromPropertyFile("uurl");
		String UUSERNAME = fLib.readDataFromPropertyFile("uusername");
	    String UPASSWORD = fLib.readDataFromPropertyFile("upassword");
	
	    //get Testdata from excel file
	    String searchPro = eLib.readDataFromExcel("search", 0, 0);
	    String pro_name = eLib.readDataFromExcel("search", 0, 1);
	    
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
	  	
	  	/*
	  	driver.findElement(By.xpath("//a[.='Login']")).click();
	 	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(UUSERNAME);
	  	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(UPASSWORD);
	  	driver.findElement(By.name("login")).click();  */
	  	
	  	//search product
	  	driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(searchPro);
	  	driver.findElement(By.xpath("//button[@class='search-button']")).click();
	  	driver.findElement(By.xpath("//a[.='"+pro_name+"']")).click();
	  	
	  	//add product to wishlist
	  	driver.findElement(By.xpath("//i[@class='fa fa-heart']")).click();
	  	
	  	//add product to my cart
	  	driver.findElement(By.xpath("//a[.='Add to cart']")).click();
	  	
	  	//click on my cart 
	  	driver.findElement(By.xpath("//i[@class='icon fa fa-shopping-cart']/..")).click();
	  	
	  	//update cart 
	  	driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
	  	
	  	//handle alert popup
	  	wLib.alertAccept(driver);
	  	
	  	String res = driver.findElement(By.xpath("//h4[@class='cart-product-description']/a[.='"+pro_name+"']")).getText();
	  	
	  	if(res.equalsIgnoreCase(pro_name))
	  	{
	  		System.out.println("product added to my cart successfully");
	  	}
	  	else 
	  	{
	  		System.out.println("product not added to my cart");
	  	}
	  	
	  	//make payment
	  	driver.findElement(By.name("ordersubmit")).click();
	  	driver.findElement(By.xpath("//input[@value='COD']")).click();
	  	driver.findElement(By.name("submit")).click();
	  
	  	String order = driver.findElement(By.xpath("//a[contains(text(),'"+pro_name+"')]")).getText();
	  	if(order.equalsIgnoreCase(pro_name))
	  	{
	  		System.out.println("Order placed successfully");
	  	}
	  	else 
	  	{
	  		System.out.println("order not placed");
	  	}
	  		
	  	//logout application
	  	driver.findElement(By.xpath("//a[.='Logout']")).click();
	  	
	  	//close driver
	  	driver.quit();

		
	}

}
