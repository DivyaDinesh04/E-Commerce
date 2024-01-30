package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class AdminHomePage {
	
	
    //declaration
	@FindBy(xpath = "//i[@class='icon-chevron-down pull-right']")
	private WebElement orderManagementLink;
	
	@FindBy(xpath = "//a[@href='pending-orders.php']/..")
	private WebElement pendingOrderLink;
	
	@FindBy(xpath = "//a[.=' Create Category ']")
	private WebElement createCategoryLink;
	
	@FindBy(xpath = "//a[.='Sub Category ']")
	private WebElement subCategoryLink;
	
	@FindBy(xpath = "//a[.='Insert Product ']")
	private WebElement insertProductLink;
	
	@FindBy(xpath = "//a[.='Manage Products ']")
	private WebElement manageProductLink;
	
	@FindBy(xpath = "//a[.='User Login Log ']")
	private WebElement userLoginLog;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	private WebElement adminLogoutDropdown;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement adminlogoutbt;
	
	//initialization
	public AdminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getOrderManagementLink() {
		return orderManagementLink;
	}

	public WebElement getPendingOrderLink() {
		return pendingOrderLink;
	}

	public WebElement getCreateCategoryLink() {
		return createCategoryLink;
	}

	public WebElement getSubCategoryLink() {
		return subCategoryLink;
	}

	public WebElement getInsertProductLink() {
		return insertProductLink;
	}

	public WebElement getManageProductLink() {
		return manageProductLink;
	}

	public WebElement getUserLoginLog() {
		return userLoginLog;
	}

	public WebElement getAdminLogoutDropdown() {
		return adminLogoutDropdown;
	}

	public WebElement getAdminlogoutbt() {
		return adminlogoutbt;
	}
	
	
	//Business logic
	public void adminLogout()
	{
		adminLogoutDropdown.click();
		adminlogoutbt.click();
		
	}
	
	public void clickCreateCategoryLink()
	{
		createCategoryLink.click();
	}
	
	public void clickSubCategoryLink()
	{
		subCategoryLink.click();
	}
	
	public void clickInsertProductLink()
	{
		insertProductLink.click();
	}
	
	public void clickManageProductLink()
	{
		manageProductLink.click();
	}
	
	public void clickorderManagementLink()
	{
		orderManagementLink.click();
	}
	
	public void clickpendingOrderLink(WebDriver driver)
	{
		WebDriverUtils wLib = new WebDriverUtils();
		wLib.waitVisibilityOf(driver, 20, pendingOrderLink);
		pendingOrderLink.click();
	}
}
