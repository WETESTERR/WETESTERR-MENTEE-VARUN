package com.qa.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.testdata.Constants;

public class Base{
	public static WebDriver driver;
	@BeforeMethod
	public void initialize() 
	{
		driver = initializeDriver();
	}
	@AfterMethod
	public void teardown() throws IOException{
		driver.close();
		driver.quit();
	}
	public static WebDriver getDriver(){
		if(driver!=null)
		{
			return driver;
		}
		return null;
	}
	
	public void chromeoption()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
		driver= new ChromeDriver(options);
	}
	public WebDriver initializeDriver() 
	{
		//System.out.println(browser);
		if(Constants.browser.equals("chrome"))
		{
			chromeoption();
		}
		else if (Constants.browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
			//firefox code
		}
		else if (Constants.browser.equals("IE"))
		{
			//	IE code
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.url);
		return driver;
	}

	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));

	}


}
