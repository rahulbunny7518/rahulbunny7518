package TestAutomation.TestNG;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestIgnore {
	
	@Test
	public void testApp1()
	{
		assertTrue(true);
	}
	
	@Test(enabled=false)// this method won't executes
	public void testApp2()
	{
		assertTrue(true);
	}

}
