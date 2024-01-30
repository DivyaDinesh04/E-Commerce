package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

	
	//declaration
	@FindBy(xpath = "//a[.='Login']")
	private WebElement loginlink;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement uUserName;
	
	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	private WebElement uPassword;
	
	@FindBy(name = "login")
	private WebElement uloginbt;
	
	
	//initialization
	public UserLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//utilization
	public WebElement getLoginlink() {
		return loginlink;
	}


	public WebElement getuUserName() {
		return uUserName;
	}

	public WebElement getuPassword() {
		return uPassword;
	}
	
	public WebElement getUloginbt() {
		return uloginbt;
	}
	
	
	//business login
	public void userLoginToApp(String userUsername,String userPassword)
	{
		loginlink.click();
		uUserName.sendKeys(userUsername);
		uPassword.sendKeys(userPassword);
		uloginbt.click();
	}


}
