package com.skillrary.girslshopping.genericlibs;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// It is used to Write The Wrapper Methods around the WebElement Methods
public class WebActionUtil {
	
	WebDriverWait wait;
	WebDriver driver;
	Actions actions;
	JavascriptExecutor jse;
	
	public WebActionUtil(WebDriver driver, long eto) {
		this.driver = driver;
		jse = (JavascriptExecutor)driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver, eto);
	}
	
	
	public void enterData(WebElement ele, String textToEnter) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.clear();
		ele.sendKeys(textToEnter);
	}
	
	public void clickOnElement(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();	
	}
	
	public void jsClick(WebElement ele) {
		jse.executeScript("arguments[0].click();", ele);
	}
	
	public void jsEnterData(WebElement ele, String text) {
		jse.executeScript("arguments[0].value=arguments[1];", ele, text);
	}
	
	public void scroll(int xPixles, int yPixels) {
		jse.executeScript("scrollBy(arguments[0], arguments[1])", xPixles, yPixels);
	}
	
	public void scrollToEnd() {
		jse.executeScript("scrollTo(0,document.body.scrollHeight);");
	}
	
	public void scrollToTop() {
		jse.executeScript("scrollTo(0,-document.body.scrollHeight);");
	}
	
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();	
	}
	
	public void moveToElement(WebElement ele) {
		actions.moveToElement(ele).perform();
	}
	
	public void doubleClick(WebElement ele) {
		actions.doubleClick(ele).perform();
	}
	
	public void selectByVisibletext(WebElement targetListBox, String text) {
		Select s = new Select(targetListBox);
		s.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement targetListBox, int index) {
		Select s = new Select(targetListBox);
		s.selectByIndex(index);
	}
	
	public void switchToFrame(String indexNameOrId) {
		try {
			int index = Integer.parseInt(indexNameOrId);
			driver.switchTo().frame(index);
		} catch (NumberFormatException e) {
			driver.switchTo().frame(indexNameOrId);
		}
	}
	
	public void closeAllChildBrowsers() {
		
		String parentWindowId = driver.getWindowHandle();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindowId);
		
		for(String wid:allWindowIds) {
			driver.switchTo().window(wid);
			driver.close();
		}
		
		driver.switchTo().window(parentWindowId);
	}
	
	public void switchToWindow(String title) {
		
		String parentWindowId = driver.getWindowHandle();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		for(String wid:allWindowIds) {
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(title)) {
				return;
			}
		}
		
		driver.switchTo().window(parentWindowId);
	}
	
	public void waitForVisibility(WebElement ele, boolean exist) {
		if(exist) {
			wait.until(ExpectedConditions.visibilityOf(ele));
		} else {
			wait.until(ExpectedConditions.invisibilityOf(ele));
		}		
	}
	
	
}







