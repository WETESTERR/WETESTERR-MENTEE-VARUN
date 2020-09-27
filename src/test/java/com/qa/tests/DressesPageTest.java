package com.qa.tests;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import com.qa.pages.Base;
import com.qa.testdata.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.pages.DressesPage;

public class DressesPageTest extends Base
{
	
	WebDriver driver;
	
	Constants c = new Constants();
	
	@Test
	public void Numberdresses() throws InterruptedException
	{ 
		DressesPage DressesPage = new DressesPage(Base.getDriver());
		List<WebElement> NumofDresses = DressesPage.numberofDresses();
		System.out.println("Number of dresses present on page : "+NumofDresses.size());
		Assert.assertEquals(NumofDresses.size(), 5);
	
	}
	@Test
	public void Listdresses() throws InterruptedException
	{
		DressesPage DressesPage = new DressesPage(Base.getDriver());
		Collections.sort(c.expectedDressList);
		List<String> ListofDress = DressesPage.listofDress();
		Assert.assertEquals(c.expectedDressList,ListofDress);
	}
	@Test
	public void Pricedresses() throws InterruptedException
	{
		DressesPage DressesPage = new DressesPage(Base.getDriver());
		Collections.sort(c.expectedDressPrice);
		List<String> DressPrice = DressesPage.priceofDress();
		Assert.assertEquals(c.expectedDressPrice,DressPrice);
	}
	@Test
	public void Discountdresses() throws InterruptedException
	{
		DressesPage DressesPage = new DressesPage(Base.getDriver());
		Collections.sort(c.expectedDressDiscount);
		List<String> DressDiscount = DressesPage.discountonDress();
		Assert.assertEquals(c.expectedDressDiscount,DressDiscount);
	}

}
