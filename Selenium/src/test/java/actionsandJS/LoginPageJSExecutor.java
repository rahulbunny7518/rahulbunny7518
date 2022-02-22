package actionsandJS;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



public class LoginPageJSExecutor {
	
	private final JavascriptExecutor driver;
	
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(className = "input-field")
	private List<WebElement> inputFields;
	
	// find All works like AND operator. All conditions has to be true for element to be part of the list
	@FindBys({@FindBy(className = "input-field"), @FindBy(tagName = "td")})
	private List<WebElement> inputFieldsBYS;
	
	
	// find All works like OR operator. Any condition is true for element will be part of this list
	@FindAll({@FindBy(className = "input-field"), @FindBy(tagName = "td")})
	private List<WebElement> inputFieldsBYALL;
	
	@FindBy(className = "form-body")
	private WebElement form;
	
	
	public LoginPageJSExecutor(WebDriver driver) {
	
		this.driver = (JavascriptExecutor)driver;
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}
	
	public LoginPageJSExecutor enterUserName(String userName)
	{
		// define the script
		String script = "document.getElementById('txtUsername').value ='" + userName + "'" ;
		driver.executeScript(script);
		
		return this;
	}
	
	public LoginPageJSExecutor enterPassword(String password)
	{
		// define the script
		String script = "document.getElementById('txtPassword').value ='" + password + "'" ;
		driver.executeScript(script);
	
		return this;
	}
	
	public Dashboard clickLoginButton() 
	{
		String script = "document.getElementsByClassName('form-body')" ;
		WebElement form = (WebElement)driver.executeScript(script); 
		form.submit();
		
		return new Dashboard((WebDriver)driver);
	}
	
	
	public LoginPageJSExecutor printElementInputFields()
	{
		System.out.println("Number of element : " + inputFields.size());
		
		for (Iterator iterator = inputFields.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element  : " + webElement.getTagName());
		}
		
		
		System.out.println("Number of element : " + inputFieldsBYS.size());
		
		for (Iterator iterator = inputFieldsBYS.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element  : " + webElement.getTagName());
		}
		
		
		System.out.println("Number of element : " + inputFieldsBYALL.size());
		
		for (Iterator iterator = inputFieldsBYALL.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element  : " + webElement.getTagName());
		}
		
		return this;
	}
	
	
	
	
	public LoginPageJSExecutor login(String userName, String password) throws InterruptedException
	{
		this.enterUserName(userName)
			.enterPassword(password)
			.clickLoginButton();
		
		return this;
	}

}
