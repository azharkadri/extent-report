package test_extent_report;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtentReport {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest test;

	
	@BeforeTest
	public void setup() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myExtentReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("os", "windows os");
		reports.setSystemInfo("tester", "azhar");
				
	}	
		
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"test case failed : "+result.getName());
			test.log(Status.FAIL,"test case failed :"+result.getThrowable());
			
			
		}
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "test case passed  :"+result.getName());
			
		}
		
		if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "test case skipped :"+result.getName());
		}
		
	}
	
	@AfterTest
	public void flush() {
		reports.flush();
	}
	
	@Test
	public void Test1() {
		test=reports.createTest("Test1");
		
		int a=10,b=20;
		Assert.assertEquals(a, b/2);
	}
	
	@Test
	public void Test4() {
		test=reports.createTest("Test4");
		
		int a=10,b=20;
		Assert.assertEquals(a, b/2);
	}
	
	@Test
	public void Test3() {
		test=reports.createTest("Test3");
		
		int a=10,b=20;
		Assert.assertEquals(a, b/2);
	}
	
	@Test
	public void Test2() {
		test=reports.createTest("Test2");
		int a=10,b=20;
		Assert.assertEquals(a, b);
	}

}
