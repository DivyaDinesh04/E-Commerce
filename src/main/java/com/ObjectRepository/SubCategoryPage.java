package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class SubCategoryPage extends WebDriverUtils{
	   
	   //declaration
	
	    @FindBy(name = "category")
	    private WebElement selectCategoryDropDown;
	    
		@FindBy(xpath = "//input[@name='subcategory']")
		private WebElement subCategoryNameEdit;
		
		@FindBy(name = "submit")
		private WebElement subCreateBtn;
		
		@FindBy(xpath = "//div[@class='alert alert-success']")
		private WebElement subCategoryConfirmMsg;
		
		//initialization
		public SubCategoryPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getSubCategoryName() {
			return subCategoryNameEdit;
		}

		public WebElement getSubCreateBtn() {
			return subCreateBtn;
		}
		
		public WebElement getSelectCategoryDropDown() {
			return selectCategoryDropDown;
		}
		
		
		//Business logic
		
		public void createSubCategory(String visibletext, String subCategoryName)
		{
			selectByVisibleText(selectCategoryDropDown, visibletext);
			subCategoryNameEdit.sendKeys(subCategoryName);
			subCreateBtn.click();
			String msg = subCategoryConfirmMsg.getText();
			System.out.println(msg);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
