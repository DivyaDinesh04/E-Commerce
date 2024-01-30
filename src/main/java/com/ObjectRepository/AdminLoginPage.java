package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {

	
	//declaration
	@FindBy(name = "username")
	private WebElement adminUsername;

	@FindBy(name = "password")
	private WebElement adminPassword;
	
	@FindBy(name = "submit")
	private WebElement adminLoginbt;
	
	
	//initialization
	public AdminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//utilization
	public WebElement getAdminUsername() {
		return adminUsername;
	}

	public WebElement getAdminPassword() {
		return adminPassword;
	}

	public WebElement getAdminLoginbt() {
		return adminLoginbt;
	}
	
	
	//Business logic
	public void adminLoginToApp(String asername, String apassword)
	{
		adminUsername.sendKeys(asername);
		adminPassword.sendKeys(apassword);
		adminLoginbt.click();
	}
	
}
