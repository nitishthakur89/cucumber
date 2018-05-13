package com.cucumber.mavencucumber;



import java.io.File;





import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class impfunc extends Page{
	
	public impfunc(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
//	@SuppressWarnings({"static-access","unchecked"})
	public  void takeScreenshot(String TestcaseName)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);        
		try {
			FileUtils.copyFile(scrFile, new File("target\\screenshot\\"+TestcaseName+"\\"+System.currentTimeMillis()+".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
