package com.cucumber.mavencucumber;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		format ={"pretty","html:target/html/"},
		features="src/test/resource",
		monochrome = true,
		glue ="stepdefinations",
		tags = {"@auspost"})
		//tags ={"@Sanity,@Regression"})
public class RunnerTest {



}



