package pageObjects;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.server.HttpInput.SentinelContent;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPageObject {

	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	

	public void isSignInTileDisplay() {
		waitForElementVisible(LoginPageUI.SIGN_IN_TITLE);
	}

	public void inputToEmail(String email) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(LoginPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPassword(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);		
	}

	public HomePageObject clickToSubmit() {
		waitForElementVisible(LoginPageUI.SUBMIT_BUTTON);
		clickToElement(LoginPageUI.SUBMIT_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	
}
