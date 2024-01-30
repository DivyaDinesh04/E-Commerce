package com.ManageProduct_Module;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.genericUtility.ExcelUtils;
import com.genericUtility.FileUtils;
import com.genericUtility.JavaUtils;
import com.genericUtility.WebDriverUtils;

public class ManageProductTest {

	public static void main(String[] args) throws IOException, InterruptedException {
    
		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		WebDriverUtils wLib = new WebDriverUtils();
		JavaUtils jLib = new JavaUtils();
		
		
		int random = jLib.getRandomNo();
		
		//Get common data from property file
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
	
		//get Testdata from excel file
		String catName = eLib.readDataFromExcel("Category", 0, 1)+random;
		String catDescription = eLib.readDataFromExcel("Category", 1, 1);
		String subname = eLib.readDataFromExcel("Category", 2, 1);
		String psp = eLib.readDataFromExcel("Insert Product", 5, 1);
		
		//launch the browser
		WebDriver driver= new ChromeDriver();
		
		//maximize the browser
		wLib.windowMax(driver);
		
		//enter Url
		driver.get(URL);
		
		//wait pageload statement
	  	wLib.waitPageLoad(driver, 10);
	  	
	    //login to application
		driver.findElement(By.id("inputEmail")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		//Click on create category
		driver.findElement(By.xpath("//a[.=' Create Category ']")).click();
		
		//enter details and create category
		driver.findElement(By.name("category")).sendKeys(catName);
		driver.findElement(By.name("description")).sendKeys(catDescription);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		// create category confirmation message
		String cres = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(cres);
		
		//create subcategory
		driver.findElement(By.xpath("//a[.='Sub Category ']")).click();
		
		//select category from dropdown
		WebElement categoryEle = driver.findElement(By.name("category"));
		wLib.selectByVisibleText(categoryEle, catName);
	
		//create sub category
		driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys(subname);
		driver.findElement(By.name("submit")).click();
		
		//create subcategory confirmation message
		String sres = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		System.out.println(sres);
		
		//click on Insert Product
		driver.findElement(By.xpath("//a[.='Insert Product ']")).click();
		
		
		//select category
		WebElement cat = driver.findElement(By.name("category"));
		wLib.selectByVisibleText(cat, catName);
		
		//select sub category
		WebElement subcat = driver.findElement(By.id("subcategory"));
		wLib.waitVisibilityOf(driver, 10, subcat);
		wLib.selectByVisibleText(subcat, subname);
		
		//enter all text field
		
		HashMap<String, String> map = eLib.HashMapData("Insert Product", 0);
		
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		
		//enter productShippingcharge
		driver.findElement(By.xpath("//input[@name='productShippingcharge']")).sendKeys(psp);
		
		//select Product Availability
        WebElement proAvai = driver.findElement(By.id("productAvailability"));
		
        wLib.selectByVisibleText(proAvai, "In Stock");
        
		//handle file upload popup
		driver.findElement(By.xpath("//input[@id='productimage1']")).sendKeys("C:\\Users\\nash\\Desktop\\dd eclipse\\E-Commerce_Project\\src\\test\\resources\\car img.jpg");
		driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys("C:\\Users\\nash\\Desktop\\dd eclipse\\E-Commerce_Project\\src\\test\\resources\\car img.jpg");
		driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\Users\\nash\\Desktop\\dd eclipse\\E-Commerce_Project\\src\\test\\resources\\car img.jpg");
		
		//click on insert button
        driver.findElement(By.xpath("//button[.='Insert']")).click();
        
        //insertproduct confirmation message
        String ipRes = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        System.out.println(ipRes);
        
        //click on manage product
		driver.findElement(By.xpath("//a[.='Manage Products ']")).click();
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(catName);
		driver.findElement(By.xpath("//td[text()='"+catName+"']/../td[@class=' ']//i[@class='icon-remove-sign']")).click();
		
		//Handle alert popup
		wLib.alertAccept(driver);
		
		//get confirmation message
		String result = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
		System.out.println(result);
		
		//logout application
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		
		//close driver
		driver.quit();
		
		
		
		
	}

}
