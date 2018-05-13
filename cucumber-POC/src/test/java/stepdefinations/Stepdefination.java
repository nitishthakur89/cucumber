package stepdefinations;






import java.util.List;

import org.junit.Assert;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefination extends Stepdefination2 {

	//WebDriver driver = new FirefoxDriver();


	@Given("^code is correct$")
	public void code_is_correct() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("running given codition");
		code_is_not_working();
		//  driver.get("https://www.google.com");
	}

	@When("^POC is done with \"(.*)\" and \"(.*)\"$")
	public void poc_is_done(String username,String pwd) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("print when condition "+username +"and "+ pwd);
		if (username.equalsIgnoreCase("user1")){
		//	test.log(LogStatus.FAIL, "print when condition "+username +"and "+ pwd);
			Assert.fail("test case fail");
			
		}
		poc_is_was_not_enough();
		test.log(LogStatus.INFO, "print when condition "+username +"and "+ pwd);
		// driver.navigate().to("https://www.facebook.com");
	}

	@Then("^test cases passed for me again$")
	public void test_cases_passed_for_me_again() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("running then constions");
		test_cases_should_fail();
		//	driver.navigate().to("https://www.gmail.com");
	}

	@Then("^test cases pass with ([^\"]*)$")
	public void test_cases_pass_with(String param)  {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("test cases pass with "+param);
		
		test.log(LogStatus.INFO,"test cases pass with "+param);
	}

	@When("^POC is carry with ([^\"]*)$")
	public void poc_is_carry_with(String param)  {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("POC is carry with "+param);
		test.log(LogStatus.INFO,"POC is carry with "+param);
	}

	@When("^POC is done$")
	public void poc_is_done(DataTable param)  {

		System.out.println(param);

		List<List<String>> item = param.raw(); 
		
		System.out.println("data processed : "+ item.get(0).get(0));
		System.out.println("data processed : "+ item.get(0).get(1));
		System.out.println("data processed : "+ item.get(1).get(0));
		System.out.println("data processed : "+ item.get(1).get(1));
	}

	@Before
	public void starting(Scenario s){
		System.out.println(s.getName().toString());
		
		initializeTest(s.getName().toString(),"test desc","Regression Test","Nitish");

	}

	@After
	public void ending(Scenario s){
		if (s.isFailed()) {
			test.log(LogStatus.FAIL, "Test case failed");;
			
			
		}
			endTest();
			
		
	}
}
