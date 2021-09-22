package com.skillrary.girslshopping.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.skillrary.girslshopping.genericlibs.FUtil;
import com.skillrary.girslshopping.genericlibs.IAutoConstants;
import com.skillrary.girslshopping.genericlibs.WebActionUtil;
import com.skillrary.girslshopping.pom.HomePage;
import com.skillrary.girslshopping.pom.LoginPage;

public class BaseTest implements IAutoConstants {
	
	WebDriver driver;
	WebActionUtil webActionUtil;
	HomePage hp;
	
	@Parameters({"browserName", "appUrl", "implicit", "explicit"})
	@BeforeClass(alwaysRun=true)
	public void openApp(@Optional(DEFAULT_BROWSER) String browserName,
						@Optional(MAIN_URL) String appUrl,
						@Optional(ITO) String implicit,
						@Optional(ETO) String explicit) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(GECKO_KEY, GECKO_PATH);
			driver = new FirefoxDriver();
		} else {
			Assert.fail("Browser Is not Supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(implicit), TimeUnit.SECONDS);
		driver.get(appUrl);
		webActionUtil = new WebActionUtil(driver, Long.parseLong(explicit));
	}
	
	
	@Parameters({"emailId", "password"})
	@BeforeMethod(alwaysRun=true)
	public void loginToApp(@Optional(DEFAULT_USER)String emailId,
						   @Optional(DEFAULT_PASSWORD)String password) {
		LoginPage lp = new LoginPage(driver, webActionUtil);
		lp.login(emailId, password);
		hp = new HomePage(driver, webActionUtil);
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void logoutFromApp(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String sPath=FUtil.getPhoto(driver, result.getName());
			System.out.println(sPath);
		}
		
		hp.getSignOutLink().click();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeApp() {
		driver.quit();
	}
	
}
