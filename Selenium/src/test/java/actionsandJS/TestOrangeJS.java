package actionsandJS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.Selenium.WebDriverFactory;

public class TestOrangeJS {

	WebDriver driver;

	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver=WebDriverFactory.getWebDriver(BrowserName);
	}
	@Test
	public void testLoginFunctionalityofuserNamejs() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPageJSExecutor loginpageaction=new LoginPageJSExecutor(driver);
		
	}



}