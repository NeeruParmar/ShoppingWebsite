
package com.automationTestPages;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationWesiteBasePackage.TestBase;
import com.automationsPages.HomePage;
import com.automationsPages.MyAccountPage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		myAccountPage = new MyAccountPage();
	}

	@Test
	public void verifyNameOfCustomerSignedIn() {

		homePage.enterLoginEmail(prop.getProperty("email"));
		homePage.enterLoginPassword(prop.getProperty("password"));
		myAccountPage = homePage.clickAccSignIn();
		String customerName = myAccountPage.getCustomerNameConfirmationText();
		Assert.assertEquals(customerName, prop.getProperty("customerName"));

	}

	@Test

	public void verifyErrorIfUserEmailPasswordBlank() {
		myAccountPage = homePage.clickAccSignIn();
		String errorMessage = homePage.getloginErrorMessageText();
		Assert.assertEquals(errorMessage, prop.getProperty("errorMessage"));

	}

	@Test

	public void verifyErrorIfUserEmailBlankWithValidPassword() {
		homePage.enterLoginPassword(prop.getProperty("password"));
		myAccountPage = homePage.clickAccSignIn();
		String errorMessage = homePage.getloginErrorMessageText();
		Assert.assertEquals(errorMessage, prop.getProperty("errorMessage"));

	}

}
