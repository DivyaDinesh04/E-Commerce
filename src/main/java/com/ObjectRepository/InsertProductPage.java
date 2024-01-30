package com.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class InsertProductPage {

	//declaration
	@FindBy(name = "category")
	private WebElement selectCategoryDropDown;
	
	@FindBy(id = "subcategory")
	private WebElement selectsubCategoryDropDown;
	
	@FindBy(xpath = "//input[@name='productShippingcharge']")
	private WebElement productShippingchargeEdit;
	
	@FindBy(name = "productAvailability")
	private WebElement productAvailabilityDD;

	@FindBy(xpath = "//input[@id='productimage1']")
	private WebElement uploadProductimage1;
	
	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement uploadProductimage2;
	
	@FindBy(xpath = "//input[@name='productimage3']")
	private WebElement uploadProductimage3;
	
	@FindBy(xpath = "//button[.='Insert']")
	private WebElement insertCreateBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement insertProductConfirmMsg;
	
	//Initialization
	public InsertProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getSelectCategoryDropDown() {
		return selectCategoryDropDown;
	}

	public WebElement getSelectsubCategoryDropDown() {
		return selectsubCategoryDropDown;
	}

	public WebElement getProductShippingcharge() {
		return productShippingchargeEdit;
	}

	public WebElement getProductAvailabilityDD() {
		return productAvailabilityDD;
	}

	public WebElement getUploadProductimage1() {
		return uploadProductimage1;
	}

	public WebElement getUploadProductimage2() {
		return uploadProductimage2;
	}

	public WebElement getUploadProductimage3() {
		return uploadProductimage3;
	}

	public WebElement getInsertCreateBtn() {
		return insertCreateBtn;
	}

	public WebElement getProductShippingchargeEdit() {
		return productShippingchargeEdit;
	}


	public WebElement getInsertProductConfirmMsg() {
		return insertProductConfirmMsg;
	}


	//business logic
	public void insertProduct(String categoryNameVisible, String subCategoryNameVisible, HashMap<String, String> map, WebDriver driver,String productShippingcharge, String productAvailability, String img1,String img2,String img3 )
	{
		WebDriverUtils wLib = new WebDriverUtils();
		wLib.selectByVisibleText(selectCategoryDropDown, categoryNameVisible);
		wLib.selectByVisibleText(selectsubCategoryDropDown, subCategoryNameVisible);
		
		for(Entry<String, String> set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
		productShippingchargeEdit.sendKeys(productShippingcharge);
		wLib.selectByVisibleText(productAvailabilityDD, productAvailability);
		
		uploadProductimage1.sendKeys(img1);
		uploadProductimage2.sendKeys(img2);
		uploadProductimage3.sendKeys(img3);
		insertCreateBtn.click();
		System.out.println(insertProductConfirmMsg.getText());
		
	}
}
