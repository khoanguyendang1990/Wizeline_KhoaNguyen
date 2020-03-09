package wizeline.hometest.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.SignUpPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class VerifyAPIKeys extends AbstractTest {
	private WebDriver driver;

	private HomePageObject homePage;
	private LoginPageObject loginPage;
//	private APIPageObject apiPage;
	
	@Test
	public void TC_01_CreateAPIKey() {
		apiPage = homePage.clickToAPIKeyTab();
		apiPage.inputToAPIName("khoa");
		apiPage.clickToGenerate();
		apiPage.isAPIDisplay("khoa");		
	}
	
	@Test
	public void TC_02_EditAPIKey() {
		apiPage = homePage.clickToAPIKeyTab();
		apiPage.isAPIDisplay("khoa");
		apiPage.clickToEditAPI("khoa");
		apiPage.inputToEditAPIName("khoa-edited");
		apiPage.clickToEdit();
		apiPage.isAPIDisplay("khoa-edited");
	}

	@Test
	public void TC_03_DeleteAPIKey() {
		apiPage = homePage.clickToAPIKeyTab();
		apiPage.isAPIDisplay("khoa");
		apiPage.clickToDeleteAPI("khoa");
		apiPage.clickToOkButtonOnPopup();
		apiPage.isAPINotDisplay("khoa");
	}
	
	@BeforeClass
	@Parameters("browserName")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openUrl(Constants.URL);
		loginPage = homePage.clickToLoginLink();
		loginPage.isSignInTileDisplay();
		loginPage.inputToEmail("wizetest1@gmail.com");
		loginPage.inputToPassword("autotest");
		homePage = loginPage.clickToSubmit();
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
