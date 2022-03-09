package driverFactory;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverProxy extends RemoteWebDriver{
	
	private WebDriver driver;
	
	public WebDriverProxy(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	

	public void get(String url) {
		driver.get(url);
	}

	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return driver.findElements(by);
	}

	public WebElement findElement(By by) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public String getPageSource() {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}

	public void close() {
		driver.close();
	}

	public void quit() {
		// TODO Auto-generated method stub
		driver.quit();
		
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public Options manage() {
		return driver.manage();
	}
	
	@Override
	public Object executeScript(String script, Object... args) {
		// TODO Auto-generated method stub
		return ((RemoteWebDriver )driver).executeScript(script, args);
	}
	
	
	@Override
	public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
		// TODO Auto-generated method stub
		return ((RemoteWebDriver )driver).getScreenshotAs(outputType);
	}
	

}
