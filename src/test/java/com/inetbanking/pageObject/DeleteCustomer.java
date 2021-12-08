package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {
	WebDriver Idriver;
	public DeleteCustomer(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@CacheLookup
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[4]/a")
	WebElement lnkDeleteCustomer;
	@CacheLookup
	@FindBy(how = How.NAME, using="cusid")
	WebElement txtCustomerId;
	
	@CacheLookup
	@FindBy(how = How.NAME, using="AccSubmit")
	WebElement btnDelSubmit;
	
	public void clickDeleteCustomer()
	{
		lnkDeleteCustomer.click();
	}
	public void custId(String cId)
	{
		txtCustomerId.sendKeys(cId);
	}
	public void clickDelSubmit()
	{
		btnDelSubmit.click();
	}
}
