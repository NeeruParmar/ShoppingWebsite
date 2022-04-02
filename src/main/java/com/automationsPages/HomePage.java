package com.automationsPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationWesiteBasePackage.TestBase;

public class HomePage extends TestBase {

		public HomePage() {

			PageFactory.initElements(wd, this);
		}
		
		@FindBy(id = "[id='email']")
		WebElement emailInput;
		
		
		@FindBy (css= "[name='passwd']")
		WebElement passwordInput;
		
		 @FindBy(id="SubmitLogin")
		 WebElement AccSignIn;
		 
		 
		 public void enterLoginEmail(String loginemail) {
			 emailInput.sendKeys(loginemail);
		 }
		 
		 
		 public void enterLoginPassword(String password) {
			 passwordInput.sendKeys(password);	 
		 }
 
		 public MyAccountPage clickAccSignIn() {
			 AccSignIn.click();
			return new MyAccountPage();
		 }

}
