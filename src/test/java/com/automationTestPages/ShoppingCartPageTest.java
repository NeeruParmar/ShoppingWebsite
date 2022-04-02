package com.automationTestPages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationWesiteBasePackage.TestBase;
import com.automationsPages.HomePage;
import com.automationsPages.MyAccountPage;
import com.automationsPages.ShoppingCartPage;

public class ShoppingCartPageTest extends TestBase {
	HomePage homepage;
	MyAccountPage myaccountpage;
	ShoppingCartPage shoppingCartPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
		shoppingCartPage =new ShoppingCartPage();
		myaccountpage=new MyAccountPage();

	}

	@Test
	public void verifyMyAccountLogin() {

		homepage.enterLoginEmail(prop.getProperty("loginemail"));
		homepage.enterLoginPassword(prop.getProperty("loginpassword"));
		myaccountpage = homepage.clickAccSignIn();
	}
	
	
	@Test
	
	private void verifyCartEmpt() {
		shoppingCartPage=myaccountpage.clickCartOption();
		shoppingCartPage.clickdeleteCartOption();
		
		String cartEmptyConfirmation=shoppingCartPage.getTextFromMessage();
		Assert.assertEquals(cartEmptyConfirmation, prop.get("ConfirmationMessageText"), "no message cart still have itms" );
		
		

	}

}
