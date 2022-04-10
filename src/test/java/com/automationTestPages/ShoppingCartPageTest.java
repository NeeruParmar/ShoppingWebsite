package com.automationTestPages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationWesiteBasePackage.TestBase;
import com.automationsPages.AddressPage;
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
	AddressPage addressPage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		sf = new SoftAssert();

		shoppingCartPage = new ShoppingCartPage();
		orderPage = new OrderPage();
		addressPage = new AddressPage();
		homePage.enterLoginEmail(prop.getProperty("email"));
		homePage.enterLoginPassword(prop.getProperty("password"));
		myAccountPage = homePage.clickAccSignIn();

	}

	@Test

	public void verifyCartSummaryPageAfterContiueShopping() {

		womenPage = myAccountPage.clickWomenPage();
		womenPage.clickQuickView();
		orderPage = shoppingCartPage.clickCartOption();
		addressPage = orderPage.clickCheckOut();
		shoppingCartPage = addressPage.clickContinueShopping();
		String ShoppingCartMessage = shoppingCartPage.getVeriyCartMessage();
		sf.assertEquals(ShoppingCartMessage, prop.getProperty("ShoppingCartMessage"));
		sf.assertAll();
	}

	@Test

	public void verifyCartEmpty() {

		womenPage = myAccountPage.clickWomenPage();
		womenPage.clickQuickView();
		orderPage = shoppingCartPage.clickCartOption();

		orderPage.clickdeleteCartOption();

		String cartEmptyConfirmation = orderPage.getDeletedMessageText();
		sf.assertEquals(cartEmptyConfirmation, prop.get("ConfirmationMessageText"));
		sf.assertAll();
		
	}

}
