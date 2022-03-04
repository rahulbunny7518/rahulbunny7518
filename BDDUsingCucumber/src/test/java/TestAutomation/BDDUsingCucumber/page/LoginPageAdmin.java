package TestAutomation.BDDUsingCucumber.page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageAdmin {
	
	private final WebDriver driver;

	
	@FindBy(linkText="Admin")
	private WebElement admin;
	
	@FindBy(partialLinkText="User Management")
	private WebElement userManagement;
	
	@FindBy(partialLinkText="Users")
	private WebElement users;
	
	@FindBy(xpath="//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']")
	private WebElement editButton;
	
	
	@FindBy(xpath="(//i[text()='arrow_drop_down'])[3]")
	//@FindBy(xpath="//label[@for='adminrole']/parent::div/parent::div//div[@class='input-group-append-container']/div/button/i[text()='arrow_drop_down']")
	private WebElement admindropdown;
	
	@FindBy(xpath="//a[@id='bs-select-3-2']/span[text()='Global Admin']")
	private WebElement globalAdmin;
	
	@FindBy(xpath="//button[@id='modal-save-button'][text()='Save']")
	private WebElement saveButton;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[3]/ng-include/span")
	private WebElement userRoles;
	
	
	
	@FindBy(id="bs-select-6-0")
	private WebElement removeGlobalAdmin;
	
	
	
	public LoginPageAdmin(WebDriver driver) {

		this.driver = driver;

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);

	}
	
	
	
	
	public LoginPageAdmin clickAdminButton()
	{
		this.admin.click();
		return this;
	}
	

	public LoginPageAdmin clickUserManagementButton()
	{
		this.userManagement.click();
		return this;
	}
	

	public LoginPageAdmin clickUsersButton()
	{
		this.users.click();
		return this;
	}
	

	public LoginPageAdmin clickEditButton() throws InterruptedException
	{
		Thread.sleep(5000);
		this.editButton.click();
		return this;
	}
	

	public LoginPageAdmin selectAdminDropDown()
	{
		this.admindropdown.click();
		return this;
	}
	

	public LoginPageAdmin selectGlobalAdmin()
	{
		this.globalAdmin.click();
		return this;
	}
	

	public LoginPageAdmin clickSaveButton() throws InterruptedException
	{
		Thread.sleep(5000);
		
		this.saveButton.click();
		return this;
	}
	

	public LoginPageAdmin verifyingUserRoles() throws InterruptedException
	{
		Thread.sleep(5000);
		
		String userRoles=this.userRoles.getText();
		String users[]=userRoles.split(",");
		assertEquals(users[2], " Global Admin");
		System.out.println(userRoles);
		return this;
	}
	
	public LoginPageAdmin removingGlobalAdmin()
	{
		this.removeGlobalAdmin.click();
		return this;
	}
	
	public LoginPageAdmin verifyingUserRolesAfter() throws InterruptedException
	{
		Thread.sleep(5000);
		
		String userRoles=this.userRoles.getText();
		String users[]=userRoles.split(",");
		assertEquals(users.length,2);
		return this;
	}
	

}
