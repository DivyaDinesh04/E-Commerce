package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserHomePage {

	//declaration
	@FindBy(xpath = "//input[@class='search-field']")
	private WebElement searchTextBxEdit;
	
	@FindBy(xpath = "//button[@class='search-button']")
	private WebElement searchIconEdit;
	
	@FindBy(xpath = "//i[@class='fa fa-heart']")
	private WebElement wishlistIcon;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//a[.='My Account']")
	private WebElement myAccountLink;
	
	
	//initialization
	public UserHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getSearchTextBxEdit() {
		return searchTextBxEdit;
	}

	public WebElement getSearchIconEdit() {
		return searchIconEdit;
	}

	public WebElement getWishlistLink() {
		return wishlistIcon;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public WebElement getMyAccountLink() {
		return myAccountLink;
	}



	//Business logic
	public void searchProduct(String searchProductName)
	{
		searchTextBxEdit.sendKeys(searchProductName);
		searchIconEdit.click();
	}
	public void addProductToWishlist(String product_name,WebDriver driver)
	{
		
		driver.findElement(By.xpath("//a[.='"+product_name+"']")).click();
		wishlistIcon.click();
	}
	
	public void logoutApp()
	{
		logoutBtn.click();
	}
	
	public void clickMyAccountLink()
	{
		myAccountLink.click();
	}
	
    
	
}
