package actionsandJS;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginActions {

	private final WebDriver driver;

	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//img[@class=\"icon login-icon\"]")
	private WebElement loginButton;
	
	
	public LoginActions(WebDriver driver) {

		this.driver = driver;

		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public LoginActions enterUserName(String userName)
	{
		this.userName.sendKeys(userName);
		return this;
	}

	public LoginActions enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
	}

	public LoginActions clickLoginButton() throws InterruptedException
	{
		Actions action=new Actions(driver);
		action.moveToElement(this.loginButton).click().perform();
		//this.loginButton.click();
		//this.form.submit();
		
		
		return this;
	}
	
	
	public LoginActions screenShotMethod()
	{
		// Window Handle example
		String nameForTheCurrentWindow = driver.getWindowHandle();

		System.out.println("Name of the current Window : " + nameForTheCurrentWindow);

		Set<String> windowHandler = driver.getWindowHandles();
		for (Iterator iterator = windowHandler.iterator(); iterator.hasNext();) {
		String windowName = (String) iterator.next();
		System.out.println("window Name - > " + windowName);


		}


		// ScreenShot capturing in selenium
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File screenShotFile = screenShot.getScreenshotAs(OutputType.FILE);

		try {
		FileUtils.copyFile(screenShotFile, new File("./loginPage.jpg"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		return this;
	}
}
