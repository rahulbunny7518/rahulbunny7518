package guru99;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginGuru {
	private final WebDriver driver;

	@FindBy(xpath="//input[@type=\"text\"]")
	private WebElement customerId;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement submitButton;
	
	
	public LoginGuru(WebDriver driver) {

		this.driver = driver;

		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(driver, this);

	}
	
	
	public LoginGuru sendCustomerId(String customerId)
	{
		this.customerId.sendKeys(customerId);
		return this;
	}
	
	public LoginGuru clickSubmitButton()
	{
		this.submitButton.click();
		return this;
	}
	
	
	@FindBy(xpath="//p/a")
	private WebElement clickHerebutton;
	
	@FindBy(xpath="//input[@name=\"emailid\"]")
	private WebElement emailId;
	
	public LoginGuru clickHereButton()
	{
		this.clickHerebutton.click();
		
		return this;
	}
	
	public LoginGuru sendEmailId(String emailId)
	{
		this.sendEmailId(emailId);
		
		return this;
	}
	
	
	
	
	public LoginGuru switchingWindows() throws InterruptedException
	{
		String curWindow = driver.getWindowHandle();
		System.out.println("Parent :"+curWindow);
		
		Set<String> windows = driver.getWindowHandles();
		
		for(String ele:windows) {
			System.out.println("Child windows are "+ele);
		}
		
		
		Iterator<String> iterator= windows.iterator();
	
		while (iterator.hasNext()) {
			String child_window = iterator.next();
			if (!curWindow.equals(child_window)) {
				driver.switchTo().window(child_window);
				
			}
			
		}
		Thread.sleep(10000);
		
		return this;

	}
	
	
	@FindBy(xpath="//a[contains(text(),'BANK')]")
	private WebElement bankElement;
	
	@FindBy(xpath="//*[@id='bank']/li")
	private WebElement account;
	
	
	public LoginGuru dragAndDropImplementation()
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(bankElement, account).perform();
		return this;
		
	}
	

}
