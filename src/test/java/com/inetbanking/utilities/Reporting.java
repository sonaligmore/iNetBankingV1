package com.inetbanking.utilities;

import java.io.File;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentReports extent;
	public ExtentSparkReporter reporter;
	public ExtentTest logger;
	public void onStart(ITestContext testcontext)
	{
		String repname="Test-Report.html" ;
		String path1=System.getProperty("user.dir") + "/test-output/"+ repname;
		reporter=new ExtentSparkReporter(path1);
		
		extent=new ExtentReports();

		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Sonali");
		reporter.config().setDocumentTitle("InetBanking Test Project");
		reporter.config().setReportName("Functional Test Report");
		reporter.config().setTheme(Theme.STANDARD);
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult tr)
	{
		//WebDriver driver;
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED ));
		
		String screenshotpath=System.getProperty("user.dir")+"\\Screenshots\\" + tr.getName()+".png";
		System.out.println(screenshotpath);
		File fs=new File(screenshotpath);

		if(fs.exists())
		{
			try 
			{
			logger.fail("Screenshot is below: "+logger.addScreenCaptureFromPath(screenshotpath));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTestskip(ITestResult tr)
	{
		logger=extent.createTest(tr.getTestName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
}
