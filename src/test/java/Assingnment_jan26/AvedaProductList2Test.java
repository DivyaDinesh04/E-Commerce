package Assingnment_jan26;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericUtility.WebDriverUtils;

public class AvedaProductList2Test {

	public static void main(String[] args) throws Throwable {
		WebDriverUtils wlib = new WebDriverUtils();
		WebDriver driver= new ChromeDriver();
		wlib.waitPageLoad(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.aveda.de/");
		List<WebElement> productlist = driver.findElements(By.xpath("//div[@class='product-grid-wrapper']/descendant::div[@class='js-product js-product-brief product-brief product-brief__container product-brief--sku-product']/descendant::div[@class='product-brief__name product-name']"));

		for(WebElement pro:productlist)
		{
			if(pro.isDisplayed()) {
			System.out.println(pro.getText());
			}
			else
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pro);
				System.out.println(pro.getText());
			}
		}
	
	
	
	}
}
