package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SignUpPageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static SignUpPageObject getSignUpPage(WebDriver driver) {
		return new SignUpPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new LoginPageObject(driver);
	}
	
}
