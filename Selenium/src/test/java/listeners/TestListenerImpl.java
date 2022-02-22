package listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenerImpl implements ITestListener{
	
	WebDriver driver;

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		
		ITestContext context=result.getTestContext();
		WebDriver driver=(WebDriver)context.getAttribute("WebDriver");
		
		TakesScreenshot screenShot=(TakesScreenshot) driver; 
		File screenShotFile=screenShot.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenShotFile, new File("./loginPage2.jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("on test failure");
		
		
		
		System.out.println("Driver ->"+driver);
	}

	



}
