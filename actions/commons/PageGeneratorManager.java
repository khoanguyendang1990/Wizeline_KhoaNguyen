package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObject;
import pageObjects.SignUpPageObject;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static SignUpPageObject getSignUpPage(WebDriver driver) {
		return new SignUpPageObject(driver);
	}
	
}
