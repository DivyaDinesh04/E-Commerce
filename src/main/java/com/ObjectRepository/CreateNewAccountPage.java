package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class CreateNewAccountPage {

	//declaration
	@FindBy(xpath = "//a[.='Login']")
	private WebElement loginbt;
	
	@FindBy(id = "fullname")
	private WebElement fullNameEdit;
	
	@FindBy(id = "email")
	private WebElement emailEdit;
	
	@FindBy(id = "contactno")
	private WebElement contactnoEdit;
	
	@FindBy(id = "password")
	private WebElement passwordEdit;
	
	@FindBy(id = "confirmpassword")
	private WebElement confirmpasswordEdit;
	
	@FindBy(xpath = "//button[.='Sign Up']")
	private WebElement signInBt;
	
	//initialization
	public CreateNewAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getLoginbt() {
		return loginbt;
	}

	public WebElement getFullNameEdit() {
		return fullNameEdit;
	}

	public WebElement getEmailEdit() {
		return emailEdit;
	}

	public WebElement getContactnoEdit() {
		return contactnoEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getConfirmpasswordEdit() {
		return confirmpasswordEdit;
	}

	public WebElement getSignInBt() {
		return signInBt;
	}
	
	//business logic
	public void createNewUser(String fullName,String email,String contactNo,String password,String confirmpassword,WebDriver driver)
	{
		loginbt.click();
		fullNameEdit.sendKeys(fullName);
		emailEdit.sendKeys(email);
		contactnoEdit.sendKeys(contactNo);
		passwordEdit.sendKeys(password);
		confirmpasswordEdit.sendKeys(confirmpassword);
		signInBt.click();
		WebDriverUtils wlib = new WebDriverUtils();
		wlib.alertAccept(driver);
	}
	
}
