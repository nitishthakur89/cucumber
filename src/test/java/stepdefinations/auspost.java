package stepdefinations;

import static objectIds.Homepage.homepagescreen.*;
import reusable.LoginPage;

import com.cucumber.mavencucumber.Page;



import com.cucumber.mavencucumber.ReusableFunctions;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class auspost extends Page{

	Page page;
	LoginPage loginpage ;
	ReusableFunctions reusable;

	@Given("^user has opened aus post site with browser \"([^\"]*)\"$")
	public void user_has_opened_aus_post_site(String browsername) throws Throwable 
	{
		page = new Page();
		driver= 	page.Browser(browsername);
		loginpage = new LoginPage(driver,TESTCASENAME,TestStep,extent,test);
		loginpage.login();
		/*	page = new Page();
		driver= 	page.Browser(browsername);

		driver.get("https://auspost.com.au/");
		takeScreenshot(getClass().getSimpleName());
		 */}

	@When("^user is searching wih tracking \"([^\"]*)\"$")
	public void user_is_searching_wih_tracking(String arg1) throws Throwable 
	{
		clickSubMenu(HOMEPAGE_RECEIVING_HOVER, TRACK_YOUR_ITEM);
		setValueinTextField(TRACKING_NUMBER,arg1);
		takeScreenshot(TESTCASENAME,"user is searching wih tracking "+arg1);


	}

	@Then("^user is able to search sucessfully$")
	public void user_is_able_to_search_sucessfully() throws Throwable 
	{

		clickLink(TRACK_BTN);
		waitforseconds(3);
		takeScreenshot(TESTCASENAME,"user is able to search sucessfully");

	}

	@When("^user is able to click on manage you mail link$")
	public void user_is_able_to_click_on_manage_you_mail_link() throws Throwable {
		clickSubMenu(HOMEPAGE_RECEIVING_HOVER, MANAGEYOURBILL_LINK);
		waitforseconds(2);
		takeScreenshot(TESTCASENAME,"user is able to click on manage you mail link");
	}
	@When("^user is able to click on Business link$")
	public void user_is_able_to_click_on_Business_link() throws Throwable {
		clickLink(BUSINESS_LINK);
		waitforseconds(2);
		takeScreenshot(TESTCASENAME,"user is able to click on Business link");
	}
	@Before
	public void starting(Scenario s){

		String[] st = s.getId().split(";");
		System.out.println(st[0]);
		TESTCASENAME = st[0];

		reusable = new ReusableFunctions(extent,test,TESTCASENAME);
		reusable.initializeTest(TESTCASENAME,"Regression Test","Nitish");
		test = reusable.test1();
	}

	@After
	public void ending(Scenario s){
		driver.quit();
		if (s.isFailed()) {


			test.log(LogStatus.FAIL, "Test case failed");;


		}
		reusable.endTest();
		ScreenshotToPDf(TESTCASENAME);

	}

}
