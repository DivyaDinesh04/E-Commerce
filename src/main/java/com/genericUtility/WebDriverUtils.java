package com.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void windowMax(WebDriver driver)
	{
			driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void windowMin(WebDriver driver)
	{
			driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to implic+itly wait 
	 * @param driver
	 * @param sec
	 */
	public void waitPageLoad(WebDriver driver, int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	//explicit wait
	public WebDriverWait webDriverWaitObject(WebDriver driver, int sec) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	/**
	 * This method is used to wait until the alert popup is displayed
	 * @param driver
	 * @param sec
	 */
	public void waitAlertIsPresent(WebDriver driver, int sec)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * This method is used to wait until the expected title id is displayed
	 * @param driver
	 * @param sec
	 * @param title
	 */
	public void waitTitleIs(WebDriver driver, int sec, String title)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.titleIs(title));
	}
	
	/**
	 * This method is used to wait until the expected element to be clickable
	 * @param driver
	 * @param sec
	 * @param title
	 * @param element
	 */
	public void waitElementToBeClickable(WebDriver driver, int sec, String title, WebElement element)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * This method is used to wait until the expected element is selected
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitElementToBeSelected(WebDriver driver, int sec, WebElement element)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.elementToBeSelected(element));
	}
	
	/**
	 * This method is used to wait until the expected element is displayed
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitVisibilityOf(WebDriver driver, int sec, WebElement element)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method is used to check whether the given frame is available to switch to
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitFrameToBeAvailableAndSwitchToIt(WebDriver driver, int sec, WebElement element)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	
	/**
	 * This method is used to check that the title contains a case-sensitive substring
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitTitleContains(WebDriver driver, int sec, String text)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.titleContains(text));
	}
	
	
	/**
	 * This method is used to check whether the URL of the current page to be a specific url
	 * @param driver
	 * @param sec
	 * @param element
	 */
	public void waitUrlToBe(WebDriver driver, int sec, String url)
	{
		webDriverWaitObject(driver,sec).until(ExpectedConditions.urlToBe(url));
	}
	
	
	//select class
	public Select selectObject(WebElement element) 
	{
		Select s = new Select(element);
		return s;
	}
	
	public void select(WebElement element,int index)
	{
		selectObject(element).selectByIndex(index);
	}
	
	
	public void select(WebElement element, String value)
	{
		selectObject(element).selectByValue(value);
	}
	
	public void selectByVisibleText(WebElement element, String text)
	{
		selectObject(element).selectByVisibleText(text);
	}
	
	
	public void deSelect(WebElement element)
	{
		selectObject(element).deselectAll();
	}
	
	public void deselect(WebElement element,String text)
	{
		selectObject(element).deselectByVisibleText(text);
	}
	
	
	//Actions
	
	public Actions actionsObject(WebDriver driver)
	{
		Actions a = new Actions(driver);
		return a;
	}
	/**
	 * This method is used to drag and drop a perticular element in targeted location
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
	{
		
		actionsObject(driver).dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method is used to right click on perticular element
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void contextClick(WebDriver driver, WebElement element)
	{
		actionsObject(driver).contextClick(element).perform();
	}
	
	/**
	 * This method is used to right click
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void contextClick(WebDriver driver)
	{
		actionsObject(driver).contextClick().perform();
	}
	
	/**
	 * This method is used to move the mouse to perticular element
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void moveToElement(WebDriver driver, WebElement element)
	{
		actionsObject(driver).moveToElement(element).perform();
	}
	
	public void moveToElementAndClick(WebDriver driver, WebElement element)
	{
		actionsObject(driver).moveToElement(element).click().perform();
	}
	/**
	 * This method is used to doubleclick on perticular element
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
		actionsObject(driver).doubleClick(element);
	}
	
	/**
	 * This method is used to doubleclick
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void doubleClick(WebDriver driver)
	{
		actionsObject(driver).doubleClick();
	}
	
	/**
	 * This method is used to press enter key
	 * @throws AWTException
	 */
	public void robortpress() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to press enter key
	 * @throws AWTException
	 */
	public void robortrelease() throws AWTException
	{
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method is used to accept the alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method is used to cancel the alert popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method is used to switch to perticular frame by index value
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch back to parent frame
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	
	/**
	 * This method is used to switch back to parent frame
	 * @param driver
	 * @param index
	 */
	public void handleFrameDefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to switch between windows
	 * @param driver
	 * @param index
	 */
	public void window(WebDriver driver, String win)
	{
		driver.switchTo().window(win);
	}
	
	/**
	 * 
	 * @param driver
	 * @param screenshot
	 * @throws IOException
	 */
	public static String takeScreenshot(WebDriver driver,String screenshot) throws IOException
	{
		JavaUtils jLib = new JavaUtils();
		TakesScreenshot t = (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String path="./Screenshot/"+screenshot+jLib.getSystemDateInFormat()+".png";
		File dest = new File(path);
		String res = dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return res;
		
	}
	
	/**
	 * This method is used to scroll to a perticular element 
	 * @param driver
	 * @param element
	 * @param y
	 */
	public void javascript(WebDriver driver, WebElement element, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+y+")",element);
	}
	
	/**
	 * This method will perform random scroll
	 * @param driver
	 */
	public void javascript(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	
	
	/**
	 * This method is used to switch to perticular window
	 * @param driver
	 * @param title
	 */
	public void switchChildWindow(WebDriver driver, String title) 
	{
		 Set<String> allwh = driver.getWindowHandles();
		 for(String wh:allwh) {
		       String gtitle = driver.switchTo().window(wh).getTitle();
		    	if(gtitle.contains(title))
		    	{
		    		driver.switchTo().window(wh);
		    		break;
		    	}
		    }
	}
	
	public void openNewTab(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	public void openNewWindow(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	
	
	
}
