package uiAutromation.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class Login {
	
	private final WebDriver driver;
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement login;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
	}
	
	public Login enterUsername(String username)
	{
		this.username.sendKeys(username);
		return this;
		
	}
	
	public Login enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
		
	}
	
	public Dashboard clickLoginButton()
	{
		this.login.click();
		assertTrue(driver.getCurrentUrl().endsWith("dashboard"));
		
		return new Dashboard(driver);
	}

}
