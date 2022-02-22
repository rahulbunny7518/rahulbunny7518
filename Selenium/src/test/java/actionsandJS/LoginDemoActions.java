package actionsandJS;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginDemoActions {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver(BrowserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@Test
	public void method() throws InterruptedException
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");

		LoginActions login=new LoginActions(driver);
		login.enterUserName("Admin")
				.enterPassword("U@qBLVtm09")
				.clickLoginButton()
				.screenShotMethod();
	}
	
	

}
