package actionsandJS;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageJSTestcases {
	
WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver(BrowserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	@Test
	public void loginUsingJS()
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		
		LoginPageJSExecutor login=new LoginPageJSExecutor(driver);
		
	}

}
