package com.skillrary.girslshopping.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.skillrary.girslshopping.genericlibs.ExcelLibrary;
import com.skillrary.girslshopping.pom.CategoryPage;
import com.skillrary.girslshopping.pom.OrderDetailsPage;
import com.skillrary.girslshopping.pom.ProductDetailsPage;

public class AddToKartTC001 extends BaseTest {
	@Test
	public void testProductInODP() {
		
		String sheetName = "AddToKartTC001";
		
		String menuName = ExcelLibrary.getStringData(sheetName, 1, 0);
		String productId = ExcelLibrary.getStringData(sheetName, 1, 1).split("\\.")[0];
		int increaseQuantity = (int)ExcelLibrary.getDoubleData(sheetName, 1, 2);
		int decreaseQuantity = (int)ExcelLibrary.getDoubleData(sheetName, 1, 3);
		String size=ExcelLibrary.getStringData(sheetName, 1, 4);
		String colorName=ExcelLibrary.getStringData(sheetName, 1, 5);
		
		hp.clickOnMenu(menuName);
		
		CategoryPage cp = new CategoryPage(driver, webActionUtil);
		cp.clickOnProduct(productId);
		
		ProductDetailsPage pdp = new ProductDetailsPage(driver, webActionUtil);
		pdp.addItemToKart(increaseQuantity, decreaseQuantity, size, colorName);
		
		OrderDetailsPage odp = new OrderDetailsPage(driver, webActionUtil);
		Assert.assertTrue(odp.isProductDisplayed(productId));
	}
}
