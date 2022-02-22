package guru99;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestGuru99Alerts {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver = TestAutomation.Selenium.WebDriverFactory.getWebDriver(BrowserName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.get("https://demo.guru99.com/test/delete_customer.php");
		
	}
	
	//@Test
	public void handlingAlerts()
	{
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		
		LoginGuru login=new LoginGuru(driver);
		login.sendCustomerId("123456")
				.clickSubmitButton();
		
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		
		//driver.switchTo().alert().dismiss(); Locate element the it works
		
		
	}
	
	@Test
	public void handlingWindows() throws InterruptedException
	{
		driver.get("https://demo.guru99.com/popup.php");
		LoginGuru login=new LoginGuru(driver);
		
		login.clickHereButton()
		.switchingWindows()
		.sendEmailId("abc@sjjs");

		//Set<String> windows=driver.getWindowHandles();
		//driver.switchTo().window(windows.toArray()[1].toString());


	}
	
	//@Test
	public void dragAndDrop()
	{
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		LoginGuru login=new LoginGuru(driver);
		login.dragAndDropImplementation();

	}

}
