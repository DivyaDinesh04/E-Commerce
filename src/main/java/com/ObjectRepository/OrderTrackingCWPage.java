package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class OrderTrackingCWPage extends WebDriverUtils{

	//declaration
	@FindBy(xpath = "//td[@class='fontkink']")
	private WebElement orderNum;
	
	//initialization
	public OrderTrackingCWPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOrderNum() {
		return orderNum;
	}
	
	
	//business logic
	public void switchToChildWindow(WebDriver driver)
	{
	    switchChildWindow(driver, "Order Tracking Details");
	}
	
	
	public String getOrderNumber()
	{
		String orderN = orderNum.getText();
		return orderN;
	}
	
	public void closeAndSwitchToParentWin(WebDriver driver)
	{
		driver.close();
		switchChildWindow(driver, "Order History");
		waitTitleContains(driver, 10, "Order History");
	}
}
