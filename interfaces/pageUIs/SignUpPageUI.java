package pageUIs;

public class SignUpPageUI {

	public static final String STEP1_FIRSTNAME_TEXTBOX="//input[@id='firstName']";
	public static final String STEP1_LASTNAME_TEXTBOX="//input[@id='lastName']";
	public static final String STEP1_EMAIL_TEXTBOX="//input[@id='email']";
	public static final String STEP2_TITLE="//span[contains(text(),'Step 2:')]";
	public static final String STEP2_SUBTITLE="//span[@class='sub-title']";
	public static final String NEXT_BUTTON="//a[@class='btn btn-blue']";
	public static final String GENDER_DROPDOWN="//div[@id='genderCode']";
	public static final String MONTH_DROPDOWN="//div[@id='birthMonth']";
	public static final String DAY_DROPDOWN="//div[@id='birthDay']";
	public static final String YEAR_DROPDOWN="//div[@id='birthYear']";
	public static final String DROPDOWN_ITEM="//ul[@class='ui-select-choices ui-select-choices-content ui-select-dropdown dropdown-menu']//span[@class='ui-select-choices-row-inner']/div[text()='%s']";
	public static final String EMAIL_ERROR="//span[@id='emailError']";
}
