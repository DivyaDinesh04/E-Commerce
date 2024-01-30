package Assingnment_jan26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtility.WebDriverUtils;

public class LastNameXpath5Test {
	
	@Test
	public void lastName()
	{
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		wlib.waitPageLoad(driver, 30);
		driver.findElement(By.xpath("//label[.='Last Name']/following-sibling::input[@name='name']")).sendKeys("last name");
	}

}
