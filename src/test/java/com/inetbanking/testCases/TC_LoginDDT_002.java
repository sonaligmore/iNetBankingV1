package com.inetbanking.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObject.Loginpage;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String pwd) throws InterruptedException
	{
		//driver.get(baseURL);
		Loginpage lp= new Loginpage(driver);
		lp.setUserName(uname);
		logger.info("Entered Username");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.clickSubmit();
		Thread.sleep(3000);
		boolean alertPresent=isAlertPresent();
		if (alertPresent==true)
		{
			driver.switchTo().alert();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");

		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passes");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		FileInputStream fs=new FileInputStream("C://Learn//BankingProj//inetBankingV1//src//test//java//com//inetbanking//testData//LoginData.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=wbook.getSheet("Sheet1");
	    int rownum= sheet.getLastRowNum();
	    	int colnum=sheet.getRow(0).getLastCellNum();
		System.out.println(colnum);


	  String LoginData[][]= new String[rownum][colnum];
	  for (int i=1; i<=rownum;i++)
	  {
		  
		  for(int j=0;j<colnum;j++)
		  {
			  LoginData[i-1][j]=  sheet.getRow(i).getCell(j).toString();
			  System.out.println( LoginData[i-1][j]);
		  }
	  }
	  wbook.close();
		return LoginData;
	}
	
}
