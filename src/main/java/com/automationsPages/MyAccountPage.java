package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class MyAccountPage extends TestBase {
	
	public MyAccountPage() {
		PageFactory.initElements(wd, this);
	}
	
	
	@FindBy(css="[title='View my shopping cart']")
	WebElement myCart;
	
	
	public ShoppingCartPage clickCartOption() {
	 myCart.click();
	return new ShoppingCartPage();
}

	

}
