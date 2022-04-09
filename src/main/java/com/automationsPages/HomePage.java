package com.automationsPages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.internal.Utils;

import com.automationWebsite.Utilis.Utilis;
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

	@FindBy(css = "div[class='alert alert-danger']")
	WebElement loginErrorMessage;

	public void enterLoginEmail(String email) {
		Utilis.sendData(emailInput, email);
	}

	public void enterLoginPassword(String password) {
		Utilis.sendData(passwordInput, password);

	}

	public MyAccountPage clickAccSignIn() {
		Utilis.clickOnElement(AccSignIn);
		return new MyAccountPage();

	}

	public String getloginErrorMessageText() {

		return Utilis.getTextFromWebelement(loginErrorMessage);
	}

}
