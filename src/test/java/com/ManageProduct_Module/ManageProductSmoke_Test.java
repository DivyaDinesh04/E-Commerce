package com.ManageProduct_Module;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.AdminLoginPage;
import com.genericUtility.FileUtils;
import com.genericUtility.WebDriverUtils;

public class ManageProductSmoke_Test {

	public static void main(String[] args) throws IOException {
		
		FileUtils fLib = new FileUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		
		//Get common data from property file
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
	
		//launch the browser
		WebDriver driver= new ChromeDriver();

		//maximize the browser
		wLib.windowMax(driver);
		
		//enter url
		driver.get(URL);
				
		 //login to application
	  	AdminLoginPage alp = new AdminLoginPage(driver);
	  	alp.adminLoginToApp(USERNAME, PASSWORD);
				
		//click on manage product
		driver.findElement(By.xpath("//a[.='Manage Products ']")).click();
		String result = driver.findElement(By.xpath("//h3[.='Manage Products']")).getText();
		
		if(result.contains("Manage Products")) 
		{
			System.out.println("Manage Products page displayed properly");
		}
		else 
		{
			System.out.println("Manage Products page not loaded properly");
		}
				
		//logout application
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.adminLogout();
				
		//close driver
		driver.quit();
		
	}

}
