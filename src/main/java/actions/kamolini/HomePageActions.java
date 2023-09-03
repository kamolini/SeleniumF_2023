package actions.kamolini;

import org.openqa.selenium.WebDriver;

import elements.kamolini.HomePageElements;

public class HomePageActions extends HomePageElements{

	public HomePageActions(WebDriver driver) {
		super(driver);
	}
	
	public LoginPageActions navigateToLoginPage(){
		staticWait(2);
		click(loginLink);
		staticWait(2);
		return new LoginPageActions(driver);
	}
	
	

}
