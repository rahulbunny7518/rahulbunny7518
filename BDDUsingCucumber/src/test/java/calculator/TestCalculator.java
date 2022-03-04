package calculator;



import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\features\\calculator.feature",
				glue="calculator")
				//tags="@DataTable")

public class TestCalculator extends AbstractTestNGCucumberTests {
	
	@Test(enabled=false)
	public void met()
	{
		
	}

}
