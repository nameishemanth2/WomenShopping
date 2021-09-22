package com.skillrary.girslshopping.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.girslshopping.genericlibs.WebActionUtil;

public class OrderDetailsPage extends BasePage {
	
	@FindBy(xpath="//td[@class='cart_product']/a")
	private List<WebElement> productsList;
	
	
	@FindBy(css="a[title='Delete']")
	private List<WebElement> deleteIconsList;
	
	public List<WebElement> getProductsList() {
		return productsList;
	}

	public OrderDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}

	public boolean isProductDisplayed(String productId) {
		
		for(WebElement ele:productsList) {
			if(ele.getAttribute("href").contains(productId)) {
				return true;
			}
		}
		
		return false;
	}

	public void deleteProduct(String productId) {
		for(WebElement ele:deleteIconsList) {
			if(ele.getAttribute("href").contains(productId)) {
				webActionUtil.clickOnElement(ele);
				webActionUtil.waitForVisibility(ele, false);
				break;
			}
		}
		
	}
}
