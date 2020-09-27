package com.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.utils.ElementUtil;

public class HomePage
{
	public WebDriver driver;
	By Dresses = By.xpath("//*[@id='block_top_menu']/ul/li[2]");
	ElementUtil elementUtil;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		
	}
	public void clickonDresses() throws InterruptedException 
	{
		Thread.sleep(5000);
		elementUtil.doClick(Dresses);
		//driver.findElement(Dresses).click();
	}
	
}
