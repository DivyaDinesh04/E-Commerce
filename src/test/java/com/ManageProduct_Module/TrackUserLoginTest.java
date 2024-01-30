package com.ManageProduct_Module;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;

public class TrackUserLoginTest {

	public static void main(String[] args) throws IOException {
		
		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		JavaUtils jLib = new JavaUtils();
		
		//Get common data from property file
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		String UURL = fLib.readDataFromPropertyFile("uurl");
	    String NUSERNAME = fLib.readDataFromPropertyFile("newusername");
	    String NPASSWORD = fLib.readDataFromPropertyFile("newpassword");
	    
	    //get Testdata from excel file
	    String searchPro = eLib.readDataFromExcel("search", 0, 0);
	    String pro_name = eLib.readDataFromExcel("search", 0, 1);
	    
	    //launch browser
	    WebDriver driver = new ChromeDriver();
	 
	    //maximize the browser
	  	wLib.windowMax(driver);
	 
	  	//enter User url
	  	driver.get(UURL);
	  	
	  	//wait pageload statement
	    wLib.waitPageLoad(driver, 20);
	  	
	  	//login to application
	  	driver.findElement(By.xpath("//a[.='Login']")).click();
	  	driver.findElement(By.xpath("//input[@name='email']")).sendKeys(NUSERNAME);
	  	driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(NPASSWORD);
	  	driver.findElement(By.xpath("//button[text()='Login']")).click();
	  	
	  	String date = jLib.getSystemDate();
	  	System.out.println(date);
	  	
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
	  	driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
	  	
	  	//handle alert popup
	  	wLib.alertAccept(driver);
	  	
	  	//make payment
	  	driver.findElement(By.name("ordersubmit")).click();
	  	driver.findElement(By.xpath("//input[@value='COD']")).click();
	  	driver.findElement(By.name("submit")).click();
	  
	  	driver.findElement(By.xpath("(//a[contains(text(),'"+pro_name+"')]/ancestor::tr//a[contains(text(),'Track')])[last()]")).click();
	  	
	  	//handle child popup window
	  	wLib.switchChildWindow(driver, "Order Tracking Details");
	  
	  	String ordernum = driver.findElement(By.xpath("//td[@class='fontkink']")).getText();
	  	driver.close();
	  	wLib.switchChildWindow(driver, "Order History");
	    wLib.waitTitleContains(driver, 10, "Order History");
	
	    //logout application
	  	driver.findElement(By.xpath("//a[.='Logout']")).click();
	
	  	//open new tab
	  	wLib.openNewTab(driver);
	  	//driver.switchTo().newWindow(WindowType.TAB);
	  	
	  	//enter admin url
	  	driver.get(URL);
	  	
		//login to application as admin
		driver.findElement(By.id("inputEmail")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		//track user placed order in pending order
		driver.findElement(By.xpath("//i[@class='icon-chevron-down pull-right']")).click();
		driver.findElement(By.xpath("//a[@href='pending-orders.php']/..")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@name='DataTables_Table_0_length']"));
		Select s = new Select(ele);
		s.selectByVisibleText("100");
		
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(NUSERNAME);
		driver.findElement(By.xpath("(//td[contains(text(),'abc@gmail.com')]/..//i[@class='icon-edit'])[last()]")).click();
		
		//handle childpopup
		wLib.switchChildWindow(driver, "Update Compliant");
		
		String pordernum = driver.findElement(By.xpath("//b[.='order Id:']/../../td[@class='fontkink']")).getText();
		
		if(ordernum.equalsIgnoreCase(pordernum)) 
		{
			System.out.println("user order is displaed in admin's pending order. order number: "+ordernum);
		}
		else 
		{
			System.out.println("order not placed");
		}
		
		wLib.switchChildWindow(driver, "Admin| Pending Orders");
	    
		//click on user login log link
		driver.findElement(By.xpath("//a[.='User Login Log ']")).click();
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(NUSERNAME);
	
	    String login_time = driver.findElement(By.xpath("(//td[.='"+NUSERNAME+"']/../td[4])[last()]")).getText();
	    System.out.println("user login time: "+ login_time);
	    
	    //logout application
	  	driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	  	driver.findElement(By.xpath("//a[.='Logout']")).click();
	  	
	  	//close driver
	  	driver.quit();
	  	
	}

}
