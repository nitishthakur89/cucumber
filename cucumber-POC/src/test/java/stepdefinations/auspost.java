package stepdefinations;

import static objectIds.Homepage.homepagescreen.HOMEPAGE_RECEIVING_HOVER;
import static objectIds.Homepage.homepagescreen.TRACKING_NUMBER;
import static objectIds.Homepage.homepagescreen.TRACK_BTN;
import static objectIds.Homepage.homepagescreen.TRACK_YOUR_ITEM;

import org.openqa.selenium.WebDriver;

import com.cucumber.mavencucumber.Page;
import com.cucumber.mavencucumber.impfunc;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class auspost {

	impfunc imp;
	WebDriver driver ;
	Page page = new Page(driver);

	@Given("^user has opened aus post site$")
	public void user_has_opened_aus_post_site() throws Throwable 
	{

		driver= 	page.Browser("chrome");
		page = new Page(driver);
		driver.get("https://auspost.com.au/");
		imp = page.imp();
		imp.takeScreenshot(getClass().getSimpleName());
	}

	@When("^user is searching wih tracking \"([^\"]*)\"$")
	public void user_is_searching_wih_tracking(String arg1) throws Throwable 
	{
		page.clickSubMenu(HOMEPAGE_RECEIVING_HOVER, TRACK_YOUR_ITEM);
		page.setValueinTextField(TRACKING_NUMBER,arg1);
		imp.takeScreenshot(getClass().getSimpleName());

	}

	@Then("^user is able to search sucessfully$")
	public void user_is_able_to_search_sucessfully() throws Throwable 
	{

		page.clickLink(TRACK_BTN);
		imp.takeScreenshot(getClass().getSimpleName());

	}


}
