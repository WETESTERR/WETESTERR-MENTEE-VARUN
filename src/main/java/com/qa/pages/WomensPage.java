package com.qa.pages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.utils.ElementUtil;
public class WomensPage {
	public WebDriver driver;
	//Replace the below locator with WomensPage locator
	By women = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a[1]");
	By numofwomendresses = By.xpath("//*[@id='center_column']/ul/li");
	By listofwomandresses = By.xpath("//*[@id='center_column']/ul/li/div/div/h5/a");
	By priceofwomanDresses = By.xpath("//*[@id='center_column']/ul[1]/li/div[1]/div[2]/div[1]/span[@class='price product-price']");
	By discountonwomanDresses = By.xpath("//*[@id='center_column']/ul/li/div/div/div/span[@class='price-percent-reduction']");
	ElementUtil elementUtil;
	ArrayList<String> actualDressList = new ArrayList<String>();
	ArrayList<String> actualDressPrice = new ArrayList<String>();
	ArrayList<String> actualDressDiscount = new ArrayList<String>();
	private List<WebElement> dressnumber ;
	private List<WebElement> elementsDressList;
	private List<WebElement> pricelistofDresses;
	private List<WebElement> listofdiscount;
	public WomensPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	public List<WebElement> numberofWomenDresses() throws InterruptedException {
		elementUtil.waitForElementPresent(women, 10);
		elementUtil.doClick(women);
		elementUtil.visibilityOfAllElements(numofwomendresses, 10);
		dressnumber = driver.findElements(numofwomendresses);
		return (dressnumber);
	}
	public ArrayList<String> listofWomenDress(){
		elementsDressList = driver.findElements(listofwomandresses);   
		System.out.println("\nList of Women Dresses: ");
		for(WebElement list : elementsDressList)
		{
			actualDressList.add(list.getText());
			System.out.println(list.getText());
		} 
		Collections.sort(actualDressList);
		return actualDressList;
	}
	public ArrayList<String> priceofWomenDress(){
		pricelistofDresses = driver.findElements(priceofwomanDresses);
		System.out.println("\nPrice of Women Dresses :");
		for(WebElement list : pricelistofDresses)
		{
			actualDressPrice.add(list.getText());
			System.out.println(list.getText());
		} 
		Collections.sort(actualDressPrice);
		return actualDressPrice;
	}
	public ArrayList<String> discountonWomenDress(){
		listofdiscount = driver.findElements(discountonwomanDresses);
		System.out.println("\nDiscount on Women Dresses :");
		for(WebElement list : listofdiscount)
		{
			actualDressDiscount.add(list.getText());
			System.out.println(list.getText());
		} 
		System.out.println("--------------------------------------------------------------------------------");
		Collections.sort(actualDressDiscount);
		return actualDressDiscount;
	}
}

