package loginpackage;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

	private final WebDriver driver;

	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;
	
	@FindBy(xpath="//img[@class=\"icon login-icon\"]")
	private WebElement loginButton;

	@FindBy(className = "input-field")
	private List<WebElement> inputFields;

    //FindBys works like AND OPERATOR .so all the given conditions should be true
	@FindBys({@FindBy(className = "input-field"), @FindBy(tagName = "td")})
	private List<WebElement> inputFieldsBYS;

	//FindAll Works like OR operator 
	@FindAll({@FindBy(className = "input-field"), @FindBy(tagName = "td")})
	private List<WebElement> inputFieldsBYALL;

	@FindBy(className = "form-body")
	private WebElement form;
	
	
	//@FindBys(@FindBy(className="col s12"))
	//private List<WebElement> instructions;


	public LoginPage(WebDriver driver) {

		this.driver = driver;

		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(driver, this);

	}

	public LoginPage enterUserName(String userName)
	{
		this.userName.sendKeys(userName);
		return this;
	}

	public LoginPage enterPassword(String password)
	{
		this.password.sendKeys(password);
		return this;
	}

	public LoginPage clickLoginButton() throws InterruptedException
	{
		this.loginButton.click();
		//this.form.submit();
		return this;
	}


	public LoginPage printElementInputFields()
	{
		System.out.println("Number of element : " + inputFields.size());

		for (Iterator iterator = inputFields.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element : " + webElement.getTagName());
		}


		System.out.println("Number of element : " + inputFieldsBYS.size());

		for (Iterator iterator = inputFieldsBYS.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element : " + webElement.getTagName());
		}


		System.out.println("Number of element : " + inputFieldsBYALL.size());

		for (Iterator iterator = inputFieldsBYALL.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println("Element : " + webElement.getTagName());
		}

		return this;
	}




	public LoginPage login(String userName, String password) throws InterruptedException
	{
		this.enterUserName(userName)
		.enterPassword(password)
		.clickLoginButton();

		return this;
	}
	
	
	
	
	
	//Radio button and check boxes task
	
	@FindBy(xpath="//label[@for='30_Yes']")
	private WebElement radioButton;
	
	@FindBy(xpath="//label[@for='26Dairy-Free']")
	private WebElement checkbox1;
	
	@FindBy(xpath="//label[@for='26Gluten-Free']")
	private WebElement checkbox2;
	
	public LoginPage clickRadioButton()
	{
		this.radioButton.click();
		return this;
	}
	public LoginPage clickCheckBox1()
	{
		this.checkbox1.click();
		return this;
	}
	public LoginPage clickCheckBox2()
	{
		this.checkbox2.click();
		return this;
	}
	
	
	


}