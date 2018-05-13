package com.cucumber.mavencucumber;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReusableFunctions {
	public static ExtentTest test;
	public  ExtentReports extent= ExtentReportUtil.getInstance();
	public void initializeTest(String testcaseName,String testCaseDescription,String module,String Author){
		/*
		 * Function Def: this function can be used for initializing the test case details.
		 * ***************parameter***************************
		 * testcaseName,testCaseDescription,module,Author
		 * 
		 */
		test = extent.startTest(testcaseName,testCaseDescription).assignCategory("Module :"+module).assignAuthor(Author);
		
	}
	public void endTest(){
		//	dymanicDataToUpdate.clear();
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
	}

}
