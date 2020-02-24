package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class HomePageObject extends AbstractPageObject {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
}
