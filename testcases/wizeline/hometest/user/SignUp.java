package wizeline.hometest.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.SignUpPageObject;
import pageUIs.SignUpPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

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
		signUpPage.inputTextToEmail("khoa.nguyendang1990@hotmail.com");
		System.out.println("done input email");
		try {
			signUpPage.selectDropdown(SignUpPageUI.GENDER_DROPDOWN,"//div[@id='ui-select-choices-row-3-0']","Male");
			signUpPage.selectDropdown(SignUpPageUI.MONTH_DROPDOWN,SignUpPageUI.DROPDOWN,"May");
			signUpPage.selectDropdown(SignUpPageUI.DAY_DROPDOWN,SignUpPageUI.DROPDOWN,"28");
			signUpPage.selectDropdown(SignUpPageUI.YEAR_DROPDOWN,SignUpPageUI.DROPDOWN,"1990");
			System.out.println("done selectdate");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		signUpPage.clickOnNext();
		assertTrue(signUpPage.isSubTitleIsDisplay());
		
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
