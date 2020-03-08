package wizeline.hometest.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.SignUpPageObject;
import pageUIs.SignUpPageUI;

public class SignUp extends AbstractTest {

	private WebDriver driver;

	private HomePageObject homePage;
	private SignUpPageObject signUpPage;

	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openUrl(Constants.URL);
	}

	@Test
	public void TC_01_SignUp() {
		signUpPage = (SignUpPageObject) homePage.openMultiplePage("Sign Up");
		signUpPage.inputTextToFirstName("Khoa");
		signUpPage.inputTextToLastName("Nguyen");
		signUpPage.inputTextToEmail("khoa.nguyendang1990@gmail.com");
		signUpPage.selectDropdown(SignUpPageUI.GENDER_DROPDOWN, SignUpPageUI.DROPDOWN_ITEM, "Male");
		signUpPage.selectDropdown(SignUpPageUI.MONTH_DROPDOWN, SignUpPageUI.DROPDOWN_ITEM, "May");
		signUpPage.selectDropdown(SignUpPageUI.DAY_DROPDOWN, SignUpPageUI.DROPDOWN_ITEM, "28");
		signUpPage.selectDropdown(SignUpPageUI.YEAR_DROPDOWN, SignUpPageUI.DROPDOWN_ITEM, "1990");
		signUpPage.clickOnNext();
		assertTrue(signUpPage.isSubTitleIsDisplay("Step 2"));
		signUpPage.sendKeyToElement(SignUpPageUI.DYNAMIC_TEXTBOX, "Ho Chi Minh City", "city");
		signUpPage.sendKeyToElement(SignUpPageUI.DYNAMIC_TEXTBOX, "70000", "zip");
		signUpPage.selectDropdown(SignUpPageUI.COUNTRY_DROPDOWN, SignUpPageUI.DROPDOWN_ITEM, "Vietnam");
		signUpPage.clickOnNext();
		assertTrue(signUpPage.isSubTitleIsDisplay("Step 3"));
		assertEquals(signUpPage.getTextElement(SignUpPageUI.SUBTITLE), "Tell us about your devices");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
