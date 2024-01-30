package com.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtility.WebDriverUtils;

public class MyCartPage extends WebDriverUtils{

	//declaration
	@FindBy(xpath = "//a[.='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//i[@class='icon fa fa-shopping-cart']/..")
	private WebElement myCartLink;
	
	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement updateCartBtn;
	
	@FindBy(name = "ordersubmit")
	private WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath = "//input[@value='COD']")
	private WebElement CODoptionBtn;
	
	@FindBy(name = "submit")
	private WebElement orderSubmitbtn;
	
	//initialization
	public MyCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

		
	//utilization
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getMyCartLink() {
		return myCartLink;
	}

	public WebElement getUpdateCartBtn() {
		return updateCartBtn;
	}

	public WebElement getProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

	public WebElement getCODoptionBtn() {
		return CODoptionBtn;
	}

	public WebElement getOrderSubmitbtn() {
		return orderSubmitbtn;
	}
	
	//business logic
	public void addProductToMyCart(WebDriver driver,String pro_name)
	{
		addToCartBtn.click();
		myCartLink.click();
		updateCartBtn.click();
		alertAccept(driver);
		String res = driver.findElement(By.xpath("//h4[@class='cart-product-description']/a[.='"+pro_name+"']")).getText();
	  	
	  	if(res.equalsIgnoreCase(pro_name))
	  	{
	  		System.out.println("product added to my cart successfully");
	  	}
	  	else 
	  	{
	  		System.out.println("product not added to my cart");
	  	}
		
	}
	
	public void placeOrder(WebDriver driver,String pro_name)
	{
		proceedToCheckoutBtn.click();
		CODoptionBtn.click();
		orderSubmitbtn.click();
		String order = driver.findElement(By.xpath("//a[contains(text(),'"+pro_name+"')]")).getText();
	  	if(order.equalsIgnoreCase(pro_name))
	  	{
	  		System.out.println("Order placed successfully");
	  	}
	  	else 
	  	{
	  		System.out.println("order not placed");
	  	}
	}
}
