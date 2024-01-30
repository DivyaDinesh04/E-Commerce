package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class ManageProductPage extends WebDriverUtils{
	//declaration
		@FindBy(xpath = "//input[@aria-controls='DataTables_Table_0']")
		private WebElement searchTbx;
		
		@FindBy(xpath = "//div[@class='alert alert-error']")
		private WebElement mpDeleteMsg;
		
		@FindBy(xpath = "//h3[.='Manage Products']")
		public WebElement MPtitle;
		
		//initialization
		public ManageProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		
		//utilization
		public WebElement getSearchTbx() 
		{
			return searchTbx;
		}

		public WebElement getMpDeleteMsg() {
			return mpDeleteMsg;
		}


		//business logic
		public void manageCategorySearchAndDeleteProduct(WebDriver driver,String categoryName)
		{
			searchTbx.sendKeys(categoryName);
			driver.findElement(By.xpath("//td[text()='"+categoryName+"']/../td[@class=' ']//i[@class='icon-remove-sign']")).click();
			alertAccept(driver);
			System.out.println(mpDeleteMsg.getText());
			
		}
		
		public String ManageProductPageTitle()
		{
			String title = MPtitle.getText();
			return title;
		}
}
