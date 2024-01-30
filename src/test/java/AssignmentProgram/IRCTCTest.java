package AssignmentProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.ObjectRepository.IRCTCPage;
import com.genericUtility.BaseClass1;

public class IRCTCTest extends BaseClass1{

	@Test
	public void irctcTest() throws InterruptedException
	{
		int date = 27;
		//click buses link
		IRCTCPage ip = new IRCTCPage(driver);
		ip.clickBusesLink();
		wLib.waitPageLoad(driver, 20);
		//switch to child tab
		wLib.switchChildWindow(driver, "Online Bus Ticket");
		
		ip.getDeparture().sendKeys("bangalore");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='Bangalore']")).click();
		ip.getGoingTo().sendKeys("goa");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.='Goa']")).click();
		ip.getDepartureDate().click();
		driver.findElement(By.xpath("//td[@data-handler=\"selectDay\"]/a[.='"+date+"']")).click();
		ip.getSearchBus().click();
		Thread.sleep(4000);
		ip.getDepAfter6pm().click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[.='Anand Travels']/following-sibling::p[.='NON A/C Sleeper (2+1)']/ancestor::div[@class='top-search-result-card']//button[.='Select Seat']")).click();
		Thread.sleep(4000);
		
		WebElement ele = driver.findElement(By.xpath("//span[@title='Seat No. : L5 | Fare : INR 1375.50']"));
		wLib.waitVisibilityOf(driver, 30, ele);
		ele.click();
		driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-valid']")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@class='ng-untouched ng-pristine ng-valid']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[.='Proceed to Book']")).click();
	    driver.findElement(By.xpath("//a[.='Guest User Login ']")).click();
	    driver.findElement(By.xpath("//input[@id='emailLogin']")).sendKeys("divyaragavan4@gmail.com");
	    driver.findElement(By.xpath("//input[@id='phoneLogin']")).sendKeys("9384356109");
	    driver.findElement(By.xpath("//input[@id='emailLogin']/../following-sibling::div[@class='text-center']/button")).click();
	    
	    
	    driver.findElement(By.xpath("//input[@name='mobileno']")).sendKeys("1234567890");
	    driver.findElement(By.xpath("//input[@name='address']")).sendKeys("abc");
	    WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
	    wLib.selectByVisibleText(country, "India");
	    driver.findElement(By.xpath("//input[@name='state']")).sendKeys("karnataka");
	    driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("12345");
	    driver.findElement(By.xpath("//input[@placeholder='Traveller Name']")).sendKeys("divya");
	    WebElement gender = driver.findElement(By.xpath("//select[@name='select']"));
	    wLib.selectByVisibleText(gender, "Female");
	    driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys("25");
	    WebElement ele1 = driver.findElement(By.xpath("//input[@id='agree']"));
	    wLib.moveToElementAndClick(driver, ele1);
	    driver.findElement(By.xpath("//button[.='Continue to Book ']")).click();
	
	
	}

}
