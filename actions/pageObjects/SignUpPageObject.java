package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import pageUIs.SignUpPageUI;;

public class SignUpPageObject extends AbstractPageObject {

	WebDriver driver;
	public SignUpPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void inputTextToFirstName(String firstName) {
		// TODO Auto-generated method stub
		waitForElementVisible(SignUpPageUI.STEP1_FIRSTNAME_TEXTBOX);
		sendKeyToElement(SignUpPageUI.STEP1_FIRSTNAME_TEXTBOX, firstName);
	}
	public void inputTextToLastName(String lastName) {
		// TODO Auto-generated method stub
		waitForElementVisible(SignUpPageUI.STEP1_LASTNAME_TEXTBOX);
		sendKeyToElement(SignUpPageUI.STEP1_LASTNAME_TEXTBOX, lastName);
	}
	
	public void inputTextToEmail(String email) {
		// TODO Auto-generated method stub
		waitForElementVisible(SignUpPageUI.STEP1_EMAIL_TEXTBOX);
		sendKeyToElement(SignUpPageUI.STEP1_EMAIL_TEXTBOX, email);
	}
	public void clickOnNext() {
		// TODO Auto-generated method stub
		waitForElementVisible(SignUpPageUI.NEXT_BUTTON);
		clickToElement(SignUpPageUI.NEXT_BUTTON);
	}
	public void selectDropdown(String parentLocator, String itemLocator, String itemValue) throws InterruptedException {
		waitForElementVisible(parentLocator);
		selectItemInCustomDropdown(parentLocator, itemLocator, itemValue);
	}
	public boolean isSubTitleIsDisplay(String subTitle) {
		// TODO Auto-generated method stub
		waitForElementVisible(SignUpPageUI.SUBTITLE,subTitle);
		return isElementDisplay(SignUpPageUI.SUBTITLE,subTitle);
	}
	
	public void clickOnNextDevice() {
		// TODO Auto-generated method stub
		waitForElementVisible(SignUpPageUI.NEXT_BUTTON);
		clickToElement(SignUpPageUI.NEXT_BUTTON);
	}
}
