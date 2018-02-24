package extreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
public class ExtentManager {
	
	private static ExtentReports report;
	private static ExtentTest logger;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath = "C:\\Users\\praveen kumar J\\Documents\\Reports\\ExtentReport_Results.html";
	
	
	public static ExtentReports GetExtent(){
		if (report != null)
                    return report;   //avoid creating new instance of html file
		report = new ExtentReports();		
			report.attachReporter(getHtmlReporter());
			
			return report;
	}
 
	private static ExtentHtmlReporter getHtmlReporter() {
	
        htmlReporter = new ExtentHtmlReporter(filePath);
		
	// make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
		
        htmlReporter.config().getLevel();
        htmlReporter.config().getFilePath();
        htmlReporter.config().getTestViewChartLocation();
        
        htmlReporter.config().setDocumentTitle("Guru99 Bank automation report");
        htmlReporter.config().setReportName("Regression Demo cycle");
        return htmlReporter;
	}
	
	public static ExtentTest createTest(String name, String description){
		logger = report.createTest(name, description);
		return logger;
	}
}