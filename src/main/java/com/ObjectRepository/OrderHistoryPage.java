package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
	
	
    //declaration
	@FindBy(xpath = "//a[.='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "//a[.='Order History']")
	private WebElement orderHistoryLink;
	
	@FindBy(xpath = "//li[@class='active']")
	private WebElement shoppingCartpage;
	
	//initialization
	public OrderHistoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getOrderHistoryLink() {
		return orderHistoryLink;
	}

	public WebElement getShoppingCartpage() {
		return shoppingCartpage;
	}


	//business logic
	
	public String OrderHistoryPageTitle()
	{
		orderHistoryLink.click();
		String text = shoppingCartpage.getText();
		return text;
	}
	
	public void getLastPlacedOrder(String pro_name,WebDriver driver)
	{
		driver.findElement(By.xpath("(//a[contains(text(),'"+pro_name+"')]/ancestor::tr//a[contains(text(),'Track')])[last()]")).click();
	}
	
}
