package com.skillrary.girslshopping.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.girslshopping.genericlibs.WebActionUtil;

public class ProductDetailsPage extends BasePage {
	
	@FindBy(className="icon-plus")
	private WebElement plusIcon;
	
	@FindBy(className="icon-minus")
	private WebElement minusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//a[contains(@class,'color_pick')]")
	private List<WebElement> colorPickerList;
	
	@FindBy(name="Submit")
	private WebElement addToKartButton;
	
	@FindBy(linkText="Proceed to checkout")
	private WebElement proceedToCheckOutButton;
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getMinusIcon() {
		return minusIcon;
	}

	public WebElement getSizeListBox() {
		return sizeListBox;
	}

	public List<WebElement> getColorPickerList() {
		return colorPickerList;
	}

	public WebElement getAddToKartButton() {
		return addToKartButton;
	}

	public WebElement getProceedToCheckOutButton() {
		return proceedToCheckOutButton;
	}

	public ProductDetailsPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public void increaseQuantity(int count) {
		for(int i=1;i<=count;i++) {
			webActionUtil.clickOnElement(plusIcon);
		}
	}
	
	public void decreaseQuantity(int count) {
		for(int i=1;i<=count;i++) {
			webActionUtil.clickOnElement(minusIcon);
		}
	}
	
	public void selectSize(String sizeText) {
		webActionUtil.selectByVisibletext(sizeListBox, sizeText);
	}
	
	public void selectColor(String colorName) {
		for(WebElement ele:colorPickerList) {
			if(ele.getAttribute("name").equalsIgnoreCase(colorName)) {
				webActionUtil.clickOnElement(ele);
				break;
			}
		}
	}
	
	public void addItemToKart(int increaseCount, int decreaseCount, String sizeText, String colorName) {
		increaseQuantity(increaseCount);
		decreaseQuantity(decreaseCount);
		selectSize(sizeText);
		selectColor(colorName);
		webActionUtil.clickOnElement(addToKartButton);
		webActionUtil.clickOnElement(proceedToCheckOutButton);
	}
}
