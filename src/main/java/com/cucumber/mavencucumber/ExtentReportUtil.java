package com.cucumber.mavencucumber;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html

import static java.io.File.separator;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;


public class ExtentReportUtil {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {

			//	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String fileName="HWM-FunctionalTestAutomationReport.html";
			//	Date date = new Date();
			String reportPath = "target" + separator + "ExtentReport"+ separator +fileName;


			/*Old implementaion
			String reportPath =ConstantsUtil.REPORTS_PATH+fileName;
			String reportPath ="./target/report/"+fileName;
			 */	System.out.println(reportPath);
			 extent = new ExtentReports(reportPath, false);//, DisplayOrder.NEWEST_FIRST);
			 extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
			 // optional
			 //extent.addSystemInfo("Selenium Version", "2.45.0").addSystemInfo("Environment:"+ConstantsUtil.ENV, "CD Automation Team");
			 //	extent.addSystemInfo("Selenium Version :", "2.45.0").addSystemInfo("Environment :", ConstantsUtil.ENV).addSystemInfo("Team :","CICD Remedy Automation");
			 /**********************************System Info in Report*/
			 extent.addSystemInfo("Selenium Version", "2.45");
			 extent.addSystemInfo("Environment","test");
				 extent.addSystemInfo("Browser","test browser");
			 extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));

		}
		return extent;
	}
}
