package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWebsite.Utilis.Utilis;
import com.automationWesiteBasePackage.TestBase;

public class ShoppingCartPage extends TestBase {

	public ShoppingCartPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "add_to_cart")
	WebElement addToMyCart;

	public OrderPage clickCartOption() {
		addToMyCart.submit();
		return new OrderPage();
	}

	@FindBy(className = "navigation_page")
	WebElement ShoppingCartMessage;

	public String getVeriyCartMessage() {
		return Utilis.getTextFromWebelement(ShoppingCartMessage);
	}
}
