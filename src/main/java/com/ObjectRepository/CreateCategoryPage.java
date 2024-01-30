package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPage {
	
	//declaration
	@FindBy(name = "category")
	private WebElement categoryNameEdit;
	
	@FindBy(name = "description")
	private WebElement catDescriptionEdit;
	
	@FindBy(xpath = "//button[text()='Create']")
	private WebElement catCreateBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement categoryConfimMessage;
	
	
	//initialization
	public CreateCategoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//utilization
	public WebElement getCategoryName() {
		return categoryNameEdit;
	}

	public WebElement getCatDescription() {
		return catDescriptionEdit;
	}

	public WebElement getCatCreateBtn() {
		return catCreateBtn;
	}
	
	public WebElement getCategoryConfimMessage() {
		return categoryConfimMessage;
	}


	
	//Business logic
	public void CreateCategory(String categoryName,String categoryDescription)
	{
		categoryNameEdit.sendKeys(categoryName);
		catDescriptionEdit.sendKeys(categoryDescription);
		catCreateBtn.click();
		String text = categoryConfimMessage.getText();
		System.out.println(text);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
