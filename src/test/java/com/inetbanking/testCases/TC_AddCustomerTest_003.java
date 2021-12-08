package com.inetbanking.testCases;

import java.io.IOException;
import org.junit.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObject.AddCustomerPage;
import com.inetbanking.pageObject.Loginpage;

public class TC_AddCustomerTest_003 extends BaseClass 
{
	//public String custId;
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		Loginpage lp=new Loginpage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust= new AddCustomerPage(driver);
		logger.info("provinding customer details......");

		addcust.clickAddNewcustomer();
		
		addcust.custName("Kiya");
		addcust.custGender("female");
		addcust.custAddress("India wdsdsd");
		addcust.custDob("12", "14", "1980");
		Thread.sleep(2000);
		
		addcust.custCity("HYD");
		addcust.custState("AP");
		addcust.custPinno(5000074);
		addcust.custTelephoneno("987890091");
		
		String email=randomstring() + "@gmail.com";
		addcust.custEmailid(email);
		addcust.custPassword("xxx");
		addcust.custSubmit();
		Thread.sleep(2000);
		
		logger.info("Validation started.....");

		if(driver.getPageSource().contains("Customer Registered Successfully!!!"))
		{
			//custId=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else 
		{
			logger.info("test caes failed");
			getScreenShotPath("addNewCustomer",driver);
			Assert.assertTrue(false);
		}

	}
	
	
}
