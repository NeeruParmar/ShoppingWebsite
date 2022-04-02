package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class ShoppingCartPage extends TestBase{
	
	public ShoppingCartPage() {
		PageFactory.initElements(wd, this);
	}
	//text SHOPPING-CART SUMMARY
	
	
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
