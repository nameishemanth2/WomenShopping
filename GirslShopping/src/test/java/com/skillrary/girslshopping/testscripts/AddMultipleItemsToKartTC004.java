package com.skillrary.girslshopping.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.skillrary.girslshopping.genericlibs.ExcelLibrary;
import com.skillrary.girslshopping.pom.CategoryPage;
import com.skillrary.girslshopping.pom.OrderDetailsPage;
import com.skillrary.girslshopping.pom.ProductDetailsPage;

public class AddMultipleItemsToKartTC004 extends BaseTest {
	
	@DataProvider(name="productSpecs")
	public String[][] getData(){
		return ExcelLibrary.getMultipleData("TestMultipleProductsTC003");
	}
	
	@Test(dataProvider="productSpecs")
	public void testMultipleProductsInODP(String menuName,
										  String productId,
										  String increaseQuantity,
										  String decreaseQuantity,
										  String size,
										  String colorName) {
		
		productId = productId.split("\\.")[0];
		int iq = Integer.parseInt(increaseQuantity.split("\\.")[0]);
		int dq = Integer.parseInt(decreaseQuantity.split("\\.")[0]);
		
		hp.clickOnMenu(menuName);
		
		CategoryPage cp = new CategoryPage(driver, webActionUtil);
		cp.clickOnProduct(productId);
		
		ProductDetailsPage pdp = new ProductDetailsPage(driver, webActionUtil);
		pdp.addItemToKart(iq, dq, size, colorName);
		
		OrderDetailsPage odp = new OrderDetailsPage(driver, webActionUtil);
		Assert.assertTrue(odp.isProductDisplayed(productId));
		
	}
}
