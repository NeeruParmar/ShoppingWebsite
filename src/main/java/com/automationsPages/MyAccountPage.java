package com.automationsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.automationWebsite.Utilis.Utilis;
import com.automationWesiteBasePackage.TestBase;

public class MyAccountPage extends TestBase {
	Actions action;

	public MyAccountPage() {
		PageFactory.initElements(wd, this);
		action = new Actions(wd);
	}

	@FindBy(css = "a[class='account']")
	WebElement customerNameConfirmation;

	@FindBy(xpath = "//a[contains(text(),'Women')]")
	WebElement selectWomenTab;

	public String getCustomerNameConfirmationText() {
		return Utilis.getTextFromWebelement(customerNameConfirmation);

	}

	public WomenPage clickWomenPage() {
		selectWomenTab.click();
		return new WomenPage();

	}

}
