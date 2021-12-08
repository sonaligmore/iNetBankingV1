package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObject.Loginpage;

public class TC_LoginTest_001 extends BaseClass 
{

	@Test
	public void logintest() 
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		Loginpage lp= new Loginpage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		
		System.out.println(driver.getTitle());
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test pass");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login test fail");
		}
	}
}
