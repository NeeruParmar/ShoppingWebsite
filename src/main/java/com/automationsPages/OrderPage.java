package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWebsite.Utils.Utilis;
import com.automationWesiteBasePackage.TestBase;

public class OrderPage extends TestBase {

	public OrderPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);
	}

	@FindBy(css = "div [class='button btn btn-default standard-checkout button-medium']")
	WebElement proceedCheckOut;

	public AddressPage clickCheckOut() {
		proceedCheckOut.click();
		return new AddressPage();

	}

	@FindBy(className = "icon-trash")
	WebElement deleteCartOption;

	@FindBy(css = "p.alert.alert-warning")
	WebElement ConfirmationMessageText;

	public void clickdeleteCartOption() {
		Utilis.clickOnElement(deleteCartOption);
		//deleteCartOption.click();

	}

	public String getDeletedMessageText() {
		return Utilis.getTextFromWebelement(ConfirmationMessageText);

	}

}
