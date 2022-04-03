package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(className = "sf-menu clearfix menu-content sf-js-enabled sf-arrows")
	WebElement selectWomenTab;

	public WomenPage clickWomenPage() {
		Actions action = new Actions(wd);

		action.click(selectWomenTab).perform();
		return new WomenPage();
	}

}
