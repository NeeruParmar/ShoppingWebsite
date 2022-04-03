package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class OrderPage  extends TestBase{
	
	public OrderPage () {
		PageFactory.initElements(wd, this);
	}

	@FindBy(className = "icon-trash" )
	WebElement deleteCartOption;
	
	@FindBy(className  = "alert alert-warning")
	WebElement ConfirmationMessageText;

	
	public void clickdeleteCartOption() {
		deleteCartOption.click();
		
	}
	
	public String getTextFromMessage() {
	return ConfirmationMessageText.getText();
	}

	
	
}
