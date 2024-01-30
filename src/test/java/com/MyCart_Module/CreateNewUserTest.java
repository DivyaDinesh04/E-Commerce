package com.MyCart_Module;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepository.CreateNewAccountPage;
import com.ObjectRepository.MyCartPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.UserLoginPage;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;

public class CreateNewUserTest {

	@Test
	public void createNewUser() throws IOException {

		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		JavaUtils jLib = new JavaUtils();
		
		int random = jLib.getRandomNo();
		
		// get common data from property file
		String UURL = fLib.readDataFromPropertyFile("uurl");
		
		//get data from excel file
		String FullName = eLib.readDataFromExcel("createNewUser", 0, 1)+random;
		String email = eLib.readDataFromExcel("createNewUser", 1, 1)+random;
		String contactNo = eLib.readDataFromExcel("createNewUser", 2, 1);
		String password = eLib.readDataFromExcel("createNewUser", 3, 1);
		String confirmPass = eLib.readDataFromExcel("createNewUser", 4, 1);
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
	  	
	  	CreateNewAccountPage cna = new CreateNewAccountPage(driver);
	  	cna.createNewUser(FullName, email, contactNo, password, confirmPass, driver);
	  
	  	eLib.writeDataIntoExcel("createNewUser", 7, 0, FullName);
	  	eLib.writeDataIntoExcel("createNewUser", 8, 0, email);
	  	
	  	
	  	UserLoginPage ulp = new UserLoginPage(driver);
	  	ulp.userLoginToApp("anuj.lpu1@gmail.com", "Test@123");
	  	
        UserHomePage uhp = new UserHomePage(driver);
	  	
	  //search product
	  	uhp.searchProduct(searchPro);
	  	uhp.addProductToWishlist(pro_name, driver);
	  	
	    //add product to my cart
	  	MyCartPage mcp = new MyCartPage(driver);
	  	mcp.addProductToMyCart(driver, pro_name);
	  	
	  	HashMap<String, String> map = eLib.HashMapData("BAddress", 0);
	  	for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			
		}
	  	driver.findElement(By.xpath("//button[@name='update']")).click();
	  	driver.switchTo().alert().accept();
	  	
	  	
	  	HashMap<String, String> map1 = eLib.HashMapData("SAddress", 0);
	  	for(Entry<String, String> set:map1.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	  	driver.findElement(By.xpath("//button[@name='shipupdate']")).click();
	  	driver.switchTo().alert().accept();
	  	driver.findElement(By.xpath("//button[.='PROCCED TO CHEKOUT']")).click();
	  	
	}

}
