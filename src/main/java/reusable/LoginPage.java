package reusable;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.cucumber.mavencucumber.Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.model.Test;

public class LoginPage extends Page {
	
	public LoginPage(WebDriver driver1,String testcasename,ArrayList<String> teststep1,ExtentReports extent1,ExtentTest test1)
	{
		this.driver = driver1;
		this.TESTCASENAME = testcasename;
		this.TestStep = teststep1;
		this.extent = extent1;
		this.test= test1;
		
		System.out.println("driver "+driver);
		System.out.println("TESTCASENAME "+TESTCASENAME);
		System.out.println("TestStep "+TestStep);
		System.out.println("extent "+extent);
		System.out.println("test "+test);
		System.out.println("test1 "+test1);
	}
	
	

	public void login()
	{
		
		driver.get("https://auspost.com.au/");
		takeScreenshot(TESTCASENAME,"user is able to login to auspost");

	}
	
	public Page SwitchloginPageToPage()
	{
		Page page = new Page();
		return page;
	}

	
}
