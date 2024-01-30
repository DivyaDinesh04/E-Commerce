package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.AdminLoginPage;

public class BaseClass1 {
	
	public DataBaseUtils dLib = new DataBaseUtils();
	public ExcelUtils eLib = new ExcelUtils();
	public FileUtils fLib = new FileUtils();
	public JavaUtils jLib = new JavaUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--diable-notifications--");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver(option);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("-- invalid browser --");
		}
		
		sdriver = driver;
		
		wLib.windowMax(driver);
		
		Reporter.log("-- launched browser --",true);
	}
	
	
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		//driver.quit();
		Reporter.log("-- browser closed --",true);
	}
	

}
