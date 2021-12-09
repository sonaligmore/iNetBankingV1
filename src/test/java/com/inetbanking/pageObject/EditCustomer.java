package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer 
{
	WebDriver Idriver;
	public EditCustomer(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

}
