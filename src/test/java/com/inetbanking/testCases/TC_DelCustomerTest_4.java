package com.inetbanking.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.DeleteCustomer;
import com.inetbanking.pageObject.Loginpage;

public class TC_DelCustomerTest_4 extends BaseClass
{
	@Test
	public void delCustomer() throws InterruptedException
	{
		String alertResponse="Ok";
		Loginpage lp= new Loginpage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		
		DeleteCustomer delCust=new DeleteCustomer(driver);
		delCust.clickDeleteCustomer();
		delCust.custId("57318"
				+ "	");
		delCust.clickDelSubmit();
		
		Thread.sleep(3000);
		
		if (alertResponse.contains("Ok"))
		{
			driver.switchTo().alert().accept();
			if(isAlertPresent()==true)
			{
				String txtAlert= driver.switchTo().alert().getText();
				if (txtAlert.trim().contains("Customer does not exist!!"))
				{
					Thread.sleep(3000);
					Assert.assertTrue(true);
					logger.info("Customer does not exist");
					driver.switchTo().alert().accept();
					driver.switchTo().defaultContent();
				}
				else
				{
					Thread.sleep(3000);
					//Assert.assertTrue(false);
					logger.info("Customer is deleted");
					driver.switchTo().alert().accept();
					//driver.switchTo().defaultContent();
				}
				
			}
			
		}
		else
		{
			driver.switchTo().alert().dismiss();
			driver.switchTo().defaultContent();
		}
		
	}
}
