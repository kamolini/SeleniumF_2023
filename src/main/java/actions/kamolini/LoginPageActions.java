package actions.kamolini;

import org.openqa.selenium.WebDriver;

import elements.kamolini.LoginPageElements;

public class LoginPageActions extends LoginPageElements{

	public LoginPageActions(WebDriver driver) {
		super(driver);
	}
	
	public boolean validateLoginWithInvalidEmail(String emailValue) {
		
		boolean b = true;
		
		clearAndFillText(email_textBox, emailValue);
		staticWait(2);
		
		if(!isDisplayed(email_error_text)) {
			b = false;
		}
		
		if(verifyText(getText(email_error_text), "Please enter a valid email address") == false) {
			b = false;
		}
		
		isDisabled(email_error_text);
			
		return b;
	}

}
