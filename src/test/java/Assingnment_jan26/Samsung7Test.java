package Assingnment_jan26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtility.WebDriverUtils;

public class Samsung7Test {
		
		@Test
		public void SamsungTest() throws Throwable {
			WebDriverUtils
			wlib = new WebDriverUtils();
			WebDriver driver= new ChromeDriver();
			wlib.waitPageLoad(driver, 30);
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			driver.findElement(By.xpath("//span[text()='Appliances']")).click();
			WebElement tv = driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
			wlib.moveToElement(driver, tv);
		    driver.findElement(By.xpath("//a[text()='Samsung']"));
}
}