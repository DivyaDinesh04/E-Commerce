package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginLogPage {

	//declaration
	@FindBy(xpath = "//a[.='User Login Log ']")
	private WebElement userLoginLogLink;
	
	@FindBy(xpath = "//input[@aria-controls='DataTables_Table_0']")
	private WebElement serachTextBx;
	
	//initialization
	public UserLoginLogPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUserLoginLogLink() {
		return userLoginLogLink;
	}

	public WebElement getSerachTextBx() {
		return serachTextBx;
	}
	
	//business login
	public void clickUserLoginLogLink()
	{
		userLoginLogLink.click();
	}
	
	public String lastUserLoginTime(WebDriver driver,String NUSERNAME)
	{
		serachTextBx.sendKeys(NUSERNAME);
		String login_time = driver.findElement(By.xpath("(//td[.='"+NUSERNAME+"']/../td[4])[last()]")).getText();
		return login_time;
	}
	
	
}
