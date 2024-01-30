package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class PendingOrderPage extends WebDriverUtils{

	//declaration
	@FindBy(xpath = "//select[@name='DataTables_Table_0_length']")
	private WebElement showDD;
	
	@FindBy(xpath = "//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchTextBx;
	
	@FindBy(xpath = "//b[.='order Id:']/../../td[@class='fontkink']")
	private WebElement orderNum;
	
	//initialization
	public PendingOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getShowDD() {
		return showDD;
	}

	public WebElement getSearchTextBx() {
		return searchTextBx;
	}
	
	//business logic
	public void showEntries100()
	{
		selectByVisibleText(showDD, "100");
	}
	
	public void searchProduct(String productName)
	{
		searchTextBx.sendKeys(productName);
	}
	
	public String  getLastOrderNum(WebDriver driver,String NUserName)
	{
      driver.findElement(By.xpath("(//td[contains(text(),'"+NUserName+"')]/..//i[@class='icon-edit'])[last()]")).click();
		
	  //handle childpopup
	  switchChildWindow(driver, "Update Compliant");
		
	  String OrderNumber = orderNum.getText();
	  switchChildWindow(driver, "Admin| Pending Orders");
	  return OrderNumber;
	}
}
