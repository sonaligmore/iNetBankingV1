package com.inetbanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage
{
	WebDriver Idriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@CacheLookup
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	@CacheLookup
	@FindBy(how = How.NAME ,using="name" )
	WebElement txtCustomerName;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="rad1")
	WebElement rdGender;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME ,using="dob")
	WebElement txtDob;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="addr")
	WebElement txtAddress;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="city")
	WebElement txtCity;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="state")
	WebElement txtState;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="pinno")
	WebElement txtPinno;
	
	@CacheLookup
	@FindBy(how = How.NAME,using="telephoneno")
	WebElement txtTelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME,using="emailid")
	WebElement txtEmailid;

	@CacheLookup
	@FindBy(how = How.NAME,using="password")
	WebElement txtPassword;

	@CacheLookup
	@FindBy(how = How.NAME	 ,using="sub")
	WebElement btnSubmit;

//	@CacheLookup
//	@FindBy(how = How.NAME,using="res")
//	WebElement btnReset;
	
	public void clickAddNewcustomer()
	{
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname)
	{
		txtCustomerName.sendKeys(cname);	
	}
	
	public void custGender(String cgender)
	{
		rdGender.click();		
	}
	
	public void custDob(String mm,String dd,String yy)
	{
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	public void custAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);	
	}
	
	public void custCity(String ccity)
	{
		txtCity.sendKeys(ccity);	
	}
	public void custState(String cstate)
	{
		txtState.sendKeys(cstate);	
	}
	
	public void custPinno(int cpinno)
	{
		txtPinno.sendKeys(String.valueOf(cpinno));	
	}
	public void custTelephoneno(String ctelephoneno)
	{
		txtTelephoneno.sendKeys(ctelephoneno);	
	}
	public void custEmailid(String cemailid)
	{
		txtEmailid.sendKeys(cemailid);	
	}
	public void custPassword(String cpassword)
	{
		txtPassword.sendKeys(cpassword);	
	}
	public void custSubmit()
	{
		btnSubmit.click();
		}
	
	
	
	
	
	
	
	
}

