package com.cucumber.mavencucumber;

import reusable.LoginPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;




public class ReusableFunctions extends Page{

	public ReusableFunctions(ExtentReports extent1, ExtentTest test1, String tESTCASENAME1)
	{
		this.extent = extent1;
		this.test = test1;
		this.TESTCASENAME = tESTCASENAME1;

		System.out.println("extent "+extent);
		System.out.println("test "+test);
		System.out.println("TESTCASENAME "+TESTCASENAME);
		System.out.println("--------------");



	}

	public void initializeTest(String testcaseName,String module,String Author){
		/*
		 * Function Def: this function can be used for initializing the test case details.
		 * ***************parameter***************************
		 * testcaseName,testCaseDescription,module,Author
		 * 
		 */
		test = extent.startTest(testcaseName,"").assignCategory("Module :"+module).assignAuthor(Author);
		System.out.println("test : "+test);
		System.out.println("extent : "+extent);

	}
	
	public ExtentTest test1(){
		
		return test;
	}


	public void endTest(){
		//	dymanicDataToUpdate.clear();
		if(extent!=null){
			extent.endTest(test);
			extent.flush();
		}
	}

	}

