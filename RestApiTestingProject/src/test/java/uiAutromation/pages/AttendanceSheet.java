package uiAutromation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class AttendanceSheet {
	
	private final WebDriver driver;

	
	@FindBy(xpath="//span[text()='Punch In/Out']")
	private WebElement punchInOut;
	
	public AttendanceSheet(WebDriver driver)
	{

		
		this.driver=driver;
		
		AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	}

	
	
}
