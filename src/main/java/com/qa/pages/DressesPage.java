package com.qa.pages;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.utils.ElementUtil;

public class DressesPage {
	
	public WebDriver driver;
	ElementUtil elementUtil;

	By dresses = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a[1]");
	By numofDresses = By.xpath("//*[@id='center_column']/ul/li");
	By listofdresses = By.xpath("//*[@id='center_column']/ul/li/div/div/h5/a");
	By priceofDresses = By.xpath("//*[@id='center_column']/ul[1]/li/div[1]/div[2]/div[1]/span[@class='price product-price']");
	By discountonDresses = By.xpath("//*[@id='center_column']/ul/li/div/div/div/span[@class='price-percent-reduction']");

	ArrayList<String> actualDressList = new ArrayList<String>();
	ArrayList<String> actualDressPrice = new ArrayList<String>();
	ArrayList<String> actualDressDiscount = new ArrayList<String>();
	
	private List<WebElement> DressNumber ;
	private List<WebElement> elementsDressList;
	private List<WebElement> pricelistofDresses;
	private List<WebElement> listofdiscount;
	
	public DressesPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public List<WebElement> numberofDresses() throws InterruptedException {
		 
		elementUtil.waitForElementPresent(dresses, 10);
		elementUtil.doClick(dresses);
		elementUtil.visibilityOfAllElements(numofDresses, 10);
		DressNumber = driver.findElements(numofDresses);
		return (DressNumber);
	}
	
	public ArrayList<String> listofDress(){
		elementUtil.waitForElementPresent(dresses, 10);
		elementUtil.doClick(dresses); 
		elementsDressList = driver.findElements(listofdresses);   
		System.out.println("\nList of Dresses :");
		for(WebElement list : elementsDressList)
		{
			actualDressList.add(list.getText());
//			System.out.println(list.getText());
		} 
		Collections.sort(actualDressList);
		return actualDressList;
	}
	
	public ArrayList<String> priceofDress(){
		elementUtil.waitForElementPresent(dresses, 10);
		elementUtil.doClick(dresses);
		pricelistofDresses = driver.findElements(priceofDresses);
		System.out.println("\nPrice of Dresses :");
		for(WebElement list : pricelistofDresses)
		{
			actualDressPrice.add(list.getText());
//			System.out.println(list.getText());
		} 
		Collections.sort(actualDressPrice);
		return actualDressPrice;
	}
	
	public ArrayList<String> discountonDress(){
		elementUtil.waitForElementPresent(dresses, 10);
		elementUtil.doClick(dresses);
		listofdiscount = driver.findElements(discountonDresses);
		System.out.println("\nDiscount on Dresses:");
		for(WebElement list : listofdiscount)
		{
			actualDressDiscount.add(list.getText());
	//		System.out.println(list.getText());
		} 
		System.out.println("--------------------------------------------------------------------------------");
		Collections.sort(actualDressDiscount);
		return actualDressDiscount;
	}

	private void clickonDressbutton()
	{
		elementUtil.waitForElementPresent(dresses, 10);
		elementUtil.doClick(dresses); 
	}

}

