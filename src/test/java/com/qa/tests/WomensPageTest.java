package com.qa.tests;
import java.util.Collections;
import java.util.List;
import com.qa.pages.Base;
import com.qa.testdata.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.WomensPage;
public class WomensPageTest extends Base
{
	
	WebDriver driver;
	WomensPage WomensPage;
	Constants c = new Constants();
	
	@Test
	public void Numberdresses() throws InterruptedException
	{ 
		WomensPage = new WomensPage(Base.getDriver());
		List<WebElement> NumofDresses = WomensPage.numberofWomenDresses();
		System.out.println("\nNumber of Womens dresses on page : "+NumofDresses.size());
		Assert.assertEquals(NumofDresses.size(), 7);
		
	}
	@Test
	public void Listdresses() throws InterruptedException
	{
		WomensPage = new WomensPage(Base.getDriver());
		Collections.sort(c.expectedWomanDressList);
		List<String> ListofDress = WomensPage.listofWomenDress();
		Assert.assertEquals(c.expectedWomanDressList,ListofDress);
	}
	@Test
	public void Pricedresses() throws InterruptedException
	{
		WomensPage = new WomensPage(Base.getDriver());
		Collections.sort(c.expectedWomanDressPrice);
		List<String> DressPrice = WomensPage.priceofWomenDress();
		Assert.assertEquals(c.expectedWomanDressPrice,DressPrice);
	}
	@Test
	public void Discountdresses() throws InterruptedException
	{
		WomensPage = new WomensPage(Base.getDriver());
		Collections.sort(c.expectedWomanDressDiscount);
		List<String> DressDiscount = WomensPage.discountonWomenDress();
		Assert.assertEquals(c.expectedWomanDressDiscount,DressDiscount);
	}

}
