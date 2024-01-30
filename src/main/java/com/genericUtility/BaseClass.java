package com.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.AdminLoginPage;

public class BaseClass {

	public DataBaseUtils dLib = new DataBaseUtils();
	public ExcelUtils eLib = new ExcelUtils();
	public FileUtils fLib = new FileUtils();
	public JavaUtils jLib = new JavaUtils();
	public WebDriverUtils wLib = new WebDriverUtils();
	public WebDriver driver;
	
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void config_BS() throws SQLException
	{
		dLib.getRegisterAndConnection();
		Reporter.log("-- connect to DB --",true);
	}
	
	//@Parameters("BROWSER")
	
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException
	{
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
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
		String URL =fLib.readDataFromPropertyFile("url");
		driver.get(URL);
		wLib.waitPageLoad(driver, 20);
		Reporter.log("-- launched browser --",true);
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws IOException
	{
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLoginToApp(USERNAME, PASSWORD);
		Reporter.log("-- logged into application --",true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM()
	{
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.adminLogout();
		Reporter.log("-- logged out from application",true);
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC()
	{
		driver.quit();
		Reporter.log("-- browser closed --",true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws SQLException
	{
		dLib.closeDB();
		Reporter.log("-- closed DB connection --",true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
