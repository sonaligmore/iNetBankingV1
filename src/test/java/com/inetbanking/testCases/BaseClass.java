
package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger= Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver=new ChromeDriver();
			driver.manage().window().maximize();

		}
//		else if (br.equals("firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver",readconfig.getfirfoxpath());
//			driver=new Firefoxdriver();
//		}
//		else if (br.equals("ie"))
//		{
//			System.setProperty("webdriver.chrome.driver",readconfig.getIEpath());
//			driver=new IEDriver();
//		}	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfile= System.getProperty("user.dir") + "/Screenshots/" + testCaseName + ".png";
		FileUtils.copyFile(source,new File(destinationfile));
		return destinationfile;
	}
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}
	public String randomnumbet()
	{
		String generatednumber1=RandomStringUtils.randomNumeric(4);
		return generatednumber1;
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;

		}
		
	}
}
