package Assingnment_jan26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.genericUtility.WebDriverUtils;

public class YouTube6Test {
	
	@Test
	public void youTube() throws Throwable {
		WebDriverUtils
		wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wlib.waitPageLoad(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("song");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(" ");
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//b[text()=' new']"));
		wlib.waitVisibilityOf(driver,30, search);	
		search.click();
		
	}

}
