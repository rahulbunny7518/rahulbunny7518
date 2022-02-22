package hubnode;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import loginpackage.LoginPage;




public class TestOrangeHRMLoginPage {
	WebDriver driver;

	@BeforeClass
	//@Parameters("BrowserName")
	public void setup() throws MalformedURLException {
		driver = WebGridDriverFactory.getWebDriver("FIREFOX");
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();

	}

	@Test(priority=1)
	public void testLoginFunctionality() throws InterruptedException {

		//driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUserName("Admin")
		.enterUserName("U@qBLVtm09")
		.clickLoginButton();
	}


}