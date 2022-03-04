package TestAutomation.BDDUsingCucumber;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import TestAutomation.BDDUsingCucumber.page.LoginPage;
import TestAutomation.BDDUsingCucumber.page.LoginPageAdmin;

import driverFactory.WebDriverFactoryProvider;
import io.cucumber.java.en.*;

public class CucumberDefinitionImpl {

	private static WebDriver driver;

	private static String platformname;
	private static String orangeHRMURL;
	private static LoginPage loginPage;

	@BeforeTest
	public static void setup(ITestContext context)throws MalformedURLException
	{
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformname = context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
		orangeHRMURL = context.getCurrentXmlTest().getParameter("OrangeHRMBaseURL");

		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		
		loginPage = new LoginPage(driver);

	}






	@Given("Open Browser")
	
	public static void setup() throws MalformedURLException {
	
		driver.get(orangeHRMURL);
		loginPage = new LoginPage(driver);
	}



	@Given("Username is {string} and password is {string}")
	public void username_is_and_password_is(String userName, String password) {
		loginPage = loginPage.enterUserName(userName)
				.enterPassword(password);


	}
	
	@Given("LoginPage is Opened")
	public void login_page_opened()
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/auth/login");
	}




	@When("user click on login button")
	public void user_click_on_login_button()  {

		loginPage.clickLoginButton();

	}
	
	

	@Then("User should navigate to {string}")
	public void user_should_navigate_to_dashboard(String string) {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith(string));
		
	}



	@Then("User should navigate to Dashboard")
	public void user_should_navigate_to_dashboard() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("dashboard"));

	}



	@Then("User should navigate to Retry Page")
	public void user_should_navigate_to_retry_page() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("retryLogin"));

	}
	
	@Then("User should be in same page")
	public void user_should_be_in_same_page()
	{
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("login"));
		
	}




}