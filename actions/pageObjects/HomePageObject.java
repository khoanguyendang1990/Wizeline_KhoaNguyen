package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPageObject {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public LoginPageObject clickToLoginLink() {
		waitForElementVisible(HomePageUI.SIGN_UP_BUTTON);
		clickToElement(HomePageUI.SIGN_UP_BUTTON);
		return PageGeneratorManager.getLoginPage(driver);
	}
}
