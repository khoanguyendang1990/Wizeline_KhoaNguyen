package wizeline.hometest.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.SignUpPageObject;
import pageUIs.SignUpPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class SignUp extends AbstractTest{
	
	
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
	}

	@Test
	public void TC_01_SignUp() {
		signUpPage = (SignUpPageObject)homePage.openMultiplePage("Sign Up");
		signUpPage.inputTextToFirstName("Khoa");
		signUpPage.inputTextToLastName("Nguyen");
		signUpPage.inputTextToEmail("khoa.nguyendang1990@gmail.com");
		signUpPage.selectDropdown(SignUpPageUI.GENDER_DROPDOWN,SignUpPageUI.DROPDOWN_ITEM,"Male");
		signUpPage.selectDropdown(SignUpPageUI.MONTH_DROPDOWN,SignUpPageUI.DROPDOWN_ITEM,"May");
		signUpPage.selectDropdown(SignUpPageUI.DAY_DROPDOWN,SignUpPageUI.DROPDOWN_ITEM,"28");
		signUpPage.selectDropdown(SignUpPageUI.YEAR_DROPDOWN,SignUpPageUI.DROPDOWN_ITEM,"1990");
		signUpPage.clickOnNext();
		assertTrue(signUpPage.isSubTitleIsDisplay());
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
