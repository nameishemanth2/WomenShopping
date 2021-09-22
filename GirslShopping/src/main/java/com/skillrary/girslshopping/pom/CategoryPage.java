package com.skillrary.girslshopping.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.girslshopping.genericlibs.WebActionUtil;

public class CategoryPage extends BasePage {
	
	@FindBy(xpath="//a[@class='product_img_link']")
	private List<WebElement> productsList;
	
	
	public List<WebElement> getProductsList() {
		return productsList;
	}

	public CategoryPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}

	public void clickOnProduct(String productId) {
		for(WebElement ele:productsList) {
			if(ele.getAttribute("href").contains(productId)) {
				webActionUtil.jsClick(ele);
				break;
			}
		}
	}
}
