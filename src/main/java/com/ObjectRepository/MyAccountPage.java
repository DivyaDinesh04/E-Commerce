package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {

	@FindBy(xpath = "//a[.='Shipping / Billing Address']")
	private WebElement ShippingBillingLink;
	
	@FindBy(xpath = "//a[@class='collapsed']/span[.='1']")
	private WebElement billingAdd;
	
	
}
