package Assingnment_jan26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.genericUtility.WebDriverUtils;

public class Myntra10Test {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
	
		driver.get("https://www.myntra.com/");
		Actions a = new Actions(driver);
		WebElement homeLiving = driver.findElement(By.xpath("//a[.='Home & Living']"));
		a.moveToElement(homeLiving).perform();
		
		List<WebElement> homeDecod = driver.findElements(By.xpath("//a[.='Home Décor']/../following-sibling::li"));
		for (WebElement ele : homeDecod) {
			a.moveToElement(ele);
			String result = ele.getText();
			System.out.println(result);
		}
		WebElement men = driver.findElement(By.xpath("//a[.='Men']"));
		a.moveToElement(men).perform();
		driver.findElement(By.xpath("//a[.='Jackets']")).click();
		List<WebElement> allimg = driver.findElements(By.xpath("//img"));
		int count = allimg.size();
		System.out.println("total prroducts: "+count);
		
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Mango-man shirt"+Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='product-imageSliderContainer'])[2]")).click();
		WebDriverUtils wLib = new WebDriverUtils();
		wLib.switchChildWindow(driver, "MANGO MAN");
		driver.findElement(By.xpath("//p[.='42']")).click();
		driver.findElement(By.xpath("//div[.='ADD TO BAG']")).click();
		String result = driver.findElement(By.xpath("//span[@data-reactid='904']")).getText();
		if(result.equals("1"))
		{
			System.out.println("product added");
		}
		driver.quit();
		
	}

}
