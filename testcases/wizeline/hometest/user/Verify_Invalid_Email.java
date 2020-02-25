package wizeline.hometest.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		homePage = PageGeneratorManager.getHomePage(driver);
		signUpPage = (SignUpPageObject)homePage.openMultiplePage("Sign Up");
	}


	@Test(dataProvider = "getEmailData")
	public void TC_01_VerifyInvalidEmail(String email) {
		signUpPage.inputTextToEmail(email);
		signUpPage.waitForElementVisible(SignUpPageUI.EMAIL_ERROR);
		signUpPage.getTextElement(SignUpPageUI.EMAIL_ERROR);
		assertTrue(signUpPage.getTextElement(SignUpPageUI.EMAIL_ERROR).contains("Enter valid email"));
	}
	
	@DataProvider(name ="getEmailData")
	public Object[][] getEmailData(){
		return new Object[][] {
			{"khoa.nguyendang1990"},
			{"khoa.nguyendang1990@"},
			{"khoa.nguyendang1990@."},
			{"khoa.nguyendang1990@gmail.a"},
			{"khoa.nguyendang1990@gmai.com@"}};
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
