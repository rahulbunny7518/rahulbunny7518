package TestAutomation.Selenium.OrangeHRMPOM;

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
	
	
	//Leave Assignment 
	
	@FindBy(linkText="Leave")
	private WebElement leaveButton;
	
	@FindBy(linkText="Apply")
	private WebElement applyButton;
	
	@FindBy(xpath="//*[@class=\"select-dropdown\"]")
	private WebElement leaveType;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/form/div[1]/materializecss-decorator[1]/div/sf-decorator[1]/div/div/ul/li[5]/span")
	private WebElement sickLeave;
	
	@FindBy(xpath="//*[@id=\"applyLeaveForm\"]/div[1]/materializecss-decorator[2]/div/sf-decorator[1]/div/span[1]/span[1]/i")
	private WebElement fromDateDropdown;
	
	@FindBy(xpath="//*[@id=\"P862135225_table\"]/tbody/tr[1]/td[3]/div")
	private WebElement fromDate;
	
	
	@FindBy(xpath="//*[@id=\"applyLeaveForm\"]/div[1]/materializecss-decorator[2]/div/sf-decorator[2]/div/span[1]/span[1]/i")
	private WebElement toDateDropdown;
	
	@FindBy(xpath="//*[@id=\"P1800574927_table\"]/tbody/tr[4]/td[5]/div")
	private WebElement toDate;
	
	//@FindBy(linkText="From date should be before to date")
	//private WebElement error;
	
	
	public LoginPage clickLeaveButton()
	{
		this.leaveButton.click();
		return this;
	}
	
	public LoginPage clickApplyButton()
	{
		this.applyButton.click();
		return this;
	}
	public LoginPage clickLeaveType()
	{
		this.leaveType.click();
		return this;
	}
	public LoginPage clickSickLeave()
	{
		this.sickLeave.click();
		return this;
	}
	public LoginPage clickfromDateDropdown()
	{
		this.fromDateDropdown.click();
		return this;
	}
	public LoginPage clickfromDate()
	{
		this.fromDate.click();
		return this;
	}
	public LoginPage clicktoDateDropdown()
	{
		this.toDateDropdown.click();
		return this;
	}
	public LoginPage clicktoDate()
	{
		this.toDate.click();
		return this;
	}
	
	
	


}