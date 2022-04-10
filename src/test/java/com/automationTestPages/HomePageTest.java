
package com.automationTestPages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationWebsite.Utils.ExcelUtils;
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

	@Test (dataProvider="signUpDataProvider")
	public void verifyNameOfCustomerSignedIn (String email, String password) {

		homePage.enterLoginEmail(email);
		homePage.enterLoginPassword(password);
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

	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@DataProvider(name="signUpDataProvider")
	public String[][] readAndFeedLoginDataFromExcel() throws IOException {
		String filePath = "C:\\DataSheet.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", rows);
		String[][] loginData = new String[rows][col];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}
		return loginData;

	}
}
