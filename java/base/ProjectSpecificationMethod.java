package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utils.Utility;

public class ProjectSpecificationMethod extends Utility{
	
	@BeforeSuite
	public void reportIniatialization()
	{
		//To Create Report in the given location
		ExtentSparkReporter reporter=new ExtentSparkReporter("C:\\Users\\jeevansx\\eclipse-workspace\\MiniProject2\\report\\HerokuappReport.html");
		reporter.config().setReportName("Herokuapp Report");
		
		//To Capture the test data
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
	}
	
	@BeforeClass
	@Parameters("testName") // optional
	public void testDetails(@Optional("Default Test Name") String testName) {
	    ExtentTest extentTest = extent.createTest(testName);
	}
	
	
	@BeforeMethod
	@Parameters("url")
	public void launchingBrowserandLoadingURL(@Optional("https://thinking-tester-contact-list.herokuapp.com/") String url) {
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(url);
	}
	
	//@AfterMethod
	//public void closeBrowser() {
		
	//	browserclose();
	}

