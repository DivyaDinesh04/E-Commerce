package com.ObjectRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class ShippingBillingAddPage {

	//declaration
	@FindBy(xpath = "//button[@name='update']")
	private WebElement billingUpdateBtn;
	
	@FindBy(xpath = "//button[@name='shipupdate']")
	private WebElement shippingUpdateBtn;
	
	//initialization
	public ShippingBillingAddPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getBillingUpdateBtn() {
		return billingUpdateBtn;
	}

	public WebElement getShippingUpdateBtn() {
		return shippingUpdateBtn;
	}
	
	//business logic
	public void hashmapBAddress(WebDriver driver,HashMap<String, String> map) throws EncryptedDocumentException, IOException 
	{
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
		}
		billingUpdateBtn.click();
		WebDriverUtils wLib = new WebDriverUtils();
		wLib.alertAccept(driver);
		
	}
	
	public void hashmapSAddress(WebDriver driver,HashMap<String, String> map) throws EncryptedDocumentException, IOException 
	{
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
		}
		shippingUpdateBtn.click();
		WebDriverUtils wLib = new WebDriverUtils();
		wLib.alertAccept(driver);
		
	}
	
}
