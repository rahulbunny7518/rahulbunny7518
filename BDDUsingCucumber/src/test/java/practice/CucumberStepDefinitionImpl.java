package practice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import TestAutomation.BDDUsingCucumber.page.LoginPage;
import TestAutomation.BDDUsingCucumber.page.LoginPageAdmin;
import driverFactory.WebDriverFactoryProvider;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepDefinitionImpl {
	
	private static WebDriver driver;

	private static String platformname;
	private static String orangeHRMURL;
	private LoginPage loginPage;
	private static LoginPageAdmin loginPageAdmin;

	@BeforeTest
	public static void setup(ITestContext context)throws MalformedURLException
	{
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformname = context.getCurrentXmlTest().getParameter("OrangeHRMTestExecutionPlatform");
		orangeHRMURL = context.getCurrentXmlTest().getParameter("OrangeHRMBaseURL");

		driver = WebDriverFactoryProvider.getWebDriverFactory(platformname).getWebDriver(browserName);
		
		loginPageAdmin = new LoginPageAdmin(driver);

	}

	
/*	
	@Given("open BrowserLogin page And Username is {string} and password is {string}")
	public void open_browser_login_page_and_username_is_and_password_is(String userName, String password) {
		driver.get(orangeHRMURL);
		loginPage = new LoginPage(driver);
		loginPage.enterUserName(userName)
					.enterPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	   loginPage.clickLoginButton();
	}

	@Then("User should navigate to Dashboard")
	public void user_should_navigate_to_dashboard() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("dashboard"));
	}

	@Given("Admin Role is {string}")
	public void admin_role_is(String adminRole) {
	  assertEquals(adminRole, "Global Admin");
	}

	@When("user click on Admin button")
	public void user_click_on_admin_button() {
	  loginPageAdmin.clickAdminButton();
	}

	@When("user click on User Management button")
	public void user_click_on_user_management_button() {
	   loginPageAdmin.clickUserManagementButton();
	}

	@When("user click on Users button")
	public void user_click_on_users_button() {
	    loginPageAdmin.clickUsersButton();
	}

	@Then("User should navigate to Users page")
	public void user_should_navigate_to_users_page() {
	   String currentUrl=driver.getCurrentUrl();
	   assertTrue(currentUrl.endsWith("systemUsers"));
	}

	@Given("Username is {string}")
	public void username_is(String username) {
	    assertEquals(username, "amanda");
	}

	@When("user click amanda Edit button")
	public void user_click_amand_edit_button() throws InterruptedException {
	    loginPageAdmin.clickEditButton();
	}

	@When("click on Admin Role dropdown")
	public void click_on_admin_role_dropdown() {
	   loginPageAdmin.selectAdminDropDown();
	}

	@When("click on Global Admin")
	public void click_on_global_admin() {
	 loginPageAdmin.selectGlobalAdmin();
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    loginPageAdmin.clickSaveButton();
	}

	@Then("user should able to see Global Admin in User Roles of amanda")
	public void user_should_able_to_in_user_roles_of() throws InterruptedException {
	    loginPageAdmin.verifyingUserRoles();
	}
*/

}
