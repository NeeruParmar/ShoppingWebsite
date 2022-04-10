package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class AddressPage extends TestBase {
	public AddressPage() {

		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);
	}

	@FindBy(css = "[title='Previous']")
	WebElement continueShoppingPreviousPage;

	public ShoppingCartPage clickContinueShopping() {
		continueShoppingPreviousPage.click();
		return new ShoppingCartPage();
	}

}
