package com.skillrary.girslshopping.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.girslshopping.genericlibs.WebActionUtil;

public class HomePage extends BasePage {
	
	@FindBy(xpath="//ul[contains(@class,'menu-content')]/li/a")
	private List<WebElement> menuLinksList;
	
	@FindBy(linkText="Sign out")
	private WebElement signOutLink;
		
	public List<WebElement> getMenuLinksList() {
		return menuLinksList;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public List<WebElement> getMenuLinks() {
		return menuLinksList;
	}

	public HomePage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public void clickOnMenu(String menuName) {
		for(WebElement ele:menuLinksList) {
			if(ele.getText().equalsIgnoreCase(menuName)) {
				webActionUtil.clickOnElement(ele);
				break;
			}
		}
	}
}
