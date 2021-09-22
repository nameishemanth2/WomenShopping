package com.skillrary.girslshopping.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.skillrary.girslshopping.genericlibs.WebActionUtil;

public class LoginPage extends BasePage {
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(linkText="Sign in")
	private WebElement signInLink;
	
	public WebElement getSignInLink() {
		return signInLink;
	}

	@FindBy(id="passwd")
	private WebElement passwordField;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public void login(String emailId, String password) {
		webActionUtil.jsClick(signInLink);
		webActionUtil.enterData(emailTextField, emailId);
		webActionUtil.enterData(passwordField, password);
		webActionUtil.clickOnElement(signInButton);
	}
}
