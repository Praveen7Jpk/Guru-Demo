package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
 
public class ExtentManager {
	
	private static ExtentReports Extent;
	private static ExtentTest Test;
	public static ExtentHtmlReporter htmlReporter;
	public static String filePath = "C:\\Users\\praveen kumar J\\Documents\\Reports\\ExtentReport_Results03.html";
	
	
	public static ExtentReports GetExtent(){
		if (Extent != null)
                    return Extent;   //avoid creating new instance of html file
		Extent = new ExtentReports();		
		Extent.attachReporter(getHtmlReporter());
			
		return Extent;
	}
 
	private static ExtentHtmlReporter getHtmlReporter() {
	
        htmlReporter = new ExtentHtmlReporter(filePath);
		
	// make the charts visible on report open
        htmlReporter.config().setChartVisibilityOnOpen(true);
		
        htmlReporter.config().getResourceCDN();
        htmlReporter.config().getLevel();
        htmlReporter.config().getFilePath();
        htmlReporter.config().getTestViewChartLocation();
        
        htmlReporter.config().setDocumentTitle("Guru99 Bank automation report");
        htmlReporter.config().setReportName("Regression Demo cycle");
        return htmlReporter;
	}
	
	public static ExtentTest createTest(String name, String description){
		Test = Extent.createTest(name, description);
		return Test;
	}
}