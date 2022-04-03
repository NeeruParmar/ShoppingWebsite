package com.automationTestPages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationWesiteBasePackage.TestBase;
import com.automationsPages.HomePage;

import com.automationsPages.MyAccountPage;
import com.automationsPages.OrderPage;
import com.automationsPages.ShoppingCartPage;
import com.automationsPages.WomenPage;

public class ShoppingCartPageTest extends TestBase {
	HomePage homePage;
	MyAccountPage myAccountPage;
	ShoppingCartPage shoppingCartPage;
	WomenPage womenPage;
	OrderPage orderPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		HomePage homePage = new HomePage();
		MyAccountPage myAccountPage = new MyAccountPage();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
		WomenPage womenPage = new WomenPage();

		// OrderSummaryPage orderSummaryPage =new OrderSummaryPage();
		homePage.enterLoginEmail(prop.getProperty("email"));
		homePage.enterLoginPassword(prop.getProperty("password"));
		myAccountPage = homePage.clickAccSignIn();
	}

	@Test
	public void verifyCartEmpty() {
		womenPage = myAccountPage.clickWomenPage();
		womenPage.clickQuickView();
		orderPage = shoppingCartPage.clickCartOption();
		orderPage.clickdeleteCartOption();

		String cartEmptyConfirmation = shoppingCartPage.getTextFromMessage();
		Assert.assertEquals(cartEmptyConfirmation, prop.get("ConfirmationMessageText"),
				"no message cart still have itms");

	}

}
