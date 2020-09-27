package com.qa.tests;
import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.pages.HomePage;
import com.qa.pages.Base;
import com.qa.testdata.Constants;
;

public class HomePageTest extends Base
{
	
	HomePage homePage = null;
	@BeforeTest
	public void initialize()
	{
		 driver =initializeDriver();
		 homePage = new HomePage(driver);
	}	
	@Test(priority=1)
	public void verifyflow() throws InterruptedException
	{
		driver.get(Constants.url);
		homePage.clickonDresses();
	}

}
