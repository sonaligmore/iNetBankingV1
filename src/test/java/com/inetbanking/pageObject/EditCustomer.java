package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer 
{
	WebDriver Idriver;
	public EditCustomer(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@CacheLookup
	@FindBy(how = How.NAME ,using="name" )
	WebElement txtCustomerName;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME ,using="dob")
	WebElement txtDob;
	
	public void EditName(String cName)
	{
		txtCustomerName.sendKeys(cName);
		System.out.println("Customer info updated.");
	}
	
	public void EdidAdd(String cAdd)
	{
		txtDob.sendKeys(cAdd);
		System.out.println("Customer info updated.");
	}
}
