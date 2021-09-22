package com.skillrary.girslshopping.genericlibs;

/**
 * 
 * This interface is used to store all the Fixed Configuration Data for the Project
 * It is like Property FIle
 */
public interface IAutoConstants {
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_PATH="./drivers/chromedriver.exe";
	
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_PATH="./drivers/geckodriver.exe";
	
	String MAIN_URL="http://automationpractice.com/";
	String DEFAULT_USER="nameishemanth@gmail.com";
	String DEFAULT_PASSWORD="Testing@123";
	String DEFAULT_BROWSER="chrome";
	
	String ITO="15";
	String ETO="15";
	
	String XL_PATH="./resources/TestData.xlsx";
	String IMG_PATH="./errorshots/";
	
}
