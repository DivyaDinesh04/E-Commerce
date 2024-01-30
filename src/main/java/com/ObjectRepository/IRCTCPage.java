package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IRCTCPage {
	
	
    //declaration
	@FindBy(xpath = "//a[.=' BUSES ']")
	private WebElement busesLink;
	
	@FindBy(xpath = "//input[@id='departFrom']")
	private WebElement departure;
	
	@FindBy(xpath = "//input[@id='goingTo']")
	private WebElement goingTo;
	
	@FindBy(xpath = "//input[@id='departDate']")
	private WebElement departureDate;
	
	@FindBy(xpath = "//button[.='Search Bus ']")
	private WebElement searchBus;
	
	@FindBy(xpath = "//h4[.='Departure Time']/ancestor::div[@class='heading-02-wrap']//label[.='After 6 pm']")
	private WebElement depAfter6pm;
	
	//initialization
	public IRCTCPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public void setBusesLink(WebElement busesLink) {
		this.busesLink = busesLink;
	}



	public void setDeparture(WebElement departure) {
		this.departure = departure;
	}



	public void setGoingTo(WebElement goingTo) {
		this.goingTo = goingTo;
	}



	public void setDepartureDate(WebElement departureDate) {
		this.departureDate = departureDate;
	}



	public void setSearchBus(WebElement searchBus) {
		this.searchBus = searchBus;
	}



	public void setDepAfter6pm(WebElement depAfter6pm) {
		this.depAfter6pm = depAfter6pm;
	}



	//utilization
	public WebElement getBusesLink() {
		return busesLink;
	}

	public WebElement getDepAfter6pm() {
		return depAfter6pm;
	}

	public WebElement getDeparture() {
		return departure;
	}

	public WebElement getGoingTo() {
		return goingTo;
	}

	public WebElement getDepartureDate() {
		return departureDate;
	}

	public WebElement getSearchBus() {
		return searchBus;
	}
	
	//businessLogic
	public void clickBusesLink()
	{
		busesLink.click();
	}
	
	
	
}
