package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class WomenPage extends TestBase {
	
	public  WomenPage(){
		PageFactory.initElements(wd, this);	
	}
	
	@FindBy(css="div [class = 'product-image-container']")
	WebElement quickview;
	
	public ShoppingCartPage clickQuickView() {
		quickview.click();
		wd.switchTo().frame(0);
		return new ShoppingCartPage();
	}
	
	
	
	
	
		
	

}
