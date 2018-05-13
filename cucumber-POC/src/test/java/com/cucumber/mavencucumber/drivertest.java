package com.cucumber.mavencucumber;




import static objectIds.Homepage.homepagescreen.*;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class drivertest  {



	@Test
	public void drivertesting() {

		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get("https://auspost.com.au/");

		Page page = new Page(driver);
		impfunc imp = page.imp();
		imp.takeScreenshot(getClass().getSimpleName());
		page.clickSubMenu(HOMEPAGE_RECEIVING_HOVER, TRACK_YOUR_ITEM);
		
		imp.takeScreenshot(getClass().getSimpleName());
		page.setValueinTextField(TRACKING_NUMBER,"EBA00369813701008462501");
		page.clickLink(TRACK_BTN);
		
		imp.takeScreenshot(getClass().getSimpleName());
		
	}
}



