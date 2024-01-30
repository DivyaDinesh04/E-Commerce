package Assingnment_jan26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtility.ExcelUtils;
import com.genericUtility.WebDriverUtils;

public class AmazoniPhone8Test {

	@Test
	public void AmazonTest() throws Throwable
	{
		WebDriverUtils wLib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wLib.waitPageLoad(driver, 30);
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("iPhone 13");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> moblist = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<WebElement> pricelist = driver.findElements(By.xpath(
				"//div[@class='_4rR01T']//ancestor::div[@class='_3pLy-c row']//descendant::div[@class='col col-5-12 nlI3QM']//descendant::div[@class='_30jeq3 _1_WHN1']"));

	

		for (int i = 0; i < pricelist.size(); i++) {
			String price = pricelist.get(i).getText();
			String name = moblist.get(i).getText();
			price = price.replace("₹", "");
			price = price.replace(",", "");
			int intAmount = Integer.parseInt(price);
			String amount=Integer.toString(intAmount);
			ExcelUtils.wrireDataintoExcel("flipAss", i, 0, name, amount);
			
		}
}
}
