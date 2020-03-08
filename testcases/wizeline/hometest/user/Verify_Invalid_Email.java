package wizeline.hometest.user;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.SignUpPageObject;
import pageUIs.SignUpPageUI;

public class Verify_Invalid_Email extends AbstractTest{
	
	
private WebDriver driver;
	
	private HomePageObject homePage;
	private SignUpPageObject signUpPage;
	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);		
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openUrl(Constants.URL);	
		signUpPage = (SignUpPageObject)homePage.openMultiplePage("Sign Up");
		//assertTrue(false);
	}


	@Test(dataProvider = "getEmail")
	public void TC_01_VerifyInvalidEmail(String email) {
		signUpPage.inputTextToEmail(email);
		signUpPage.waitForElementVisible(SignUpPageUI.EMAIL_ERROR);
		signUpPage.getTextElement(SignUpPageUI.EMAIL_ERROR);
		assertTrue(signUpPage.getTextElement(SignUpPageUI.EMAIL_ERROR).contains("Enter valid email"));
	}
	
	@DataProvider(name ="getEmail")
	public Object[][] getEmailData(){
		return new Object[][] {
			{"khoa.nguyendang1990"},
			{"khoa.nguyendang1990@"},
			{"khoa.nguyendang1990@."},
			{"khoa.nguyendang1990@gmail.a"},
			{"khoa.nguyendang1990@gmai.com@"}};
	}
	
	@AfterClass(alwaysRun=true)
	public void afterClass() {
		homePage.quitBrowser();
	}

}
