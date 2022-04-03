package com.automationsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class HomePage extends TestBase {

	public HomePage() {

		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "passwd")
	WebElement passwordInput;

	@FindBy(id = "SubmitLogin")
	WebElement AccSignIn;

	public void enterLoginEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void enterLoginPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public MyAccountPage clickAccSignIn() {
		AccSignIn.click();
		return new MyAccountPage();
	}

}
