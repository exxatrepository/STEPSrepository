package automation.ExtentReport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



import com.aventstack.extentreports.Status;


public class Reports extends automation.BaseMethods.Controls{
	
	static ExtentHtmlReporter Reporter;
	static ExtentReports extent;
	static ExtentTest logger;
	
	
	
	//create html report file
	public static void Startlog()
	{
		
		Reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\Steps_report.html");
		extent = new ExtentReports ();
		extent.attachReporter(Reporter);
		
		extent.setSystemInfo("Host Name", "STEPS Automation");
		extent.setSystemInfo("Environment", "UAT");
		extent.setSystemInfo("User Name", "Exxat User");
		 
		Reporter.config().setDocumentTitle("STEPS AUTOMATION REPORT");
		Reporter.config().setReportName("STEPS AUTOMATION TEST REPORT");
		Reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		Reporter.config().setTheme(Theme.STANDARD);
		
		
//		extent=ExtentReports.get(Reports.class);
//		extent.init(System.getProperty("user.dir")+"\\src\\Reports\\Steps_report.html",false);
		
	}
	//TO write scenarios heading
	public static void StartTest(String Text)
	{
		
		logger=extent.createTest(Text);
		//extent.startTest(Text);
		
		
	}
	
	//Log status pass or fail
	public static void log(Status status,String details)
	{
		logger.log(status, details);
		//extent.log(status, Text);
		
		
	}
	//End test
	public static void endTest()
	{
		extent.flush();
		
		
	}


}
