package com.automationsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationWebsite.Utils.Utilis;
import com.automationWesiteBasePackage.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);

	}

	@FindBy(css = "a[class='account']")
	WebElement customerNameConfirmation;

	@FindBy(xpath = "//a[contains(text(),'Women')]")
	WebElement selectWomenTab;

	public String getCustomerNameConfirmationText() {
		return Utilis.getTextFromWebelement(customerNameConfirmation);

	}

	public WomenPage clickWomenPage() {
		Utilis.clickOnElement(selectWomenTab);
		// selectWomenTab.click();
		return new WomenPage();

	}

}
