package com.cucumber.mavencucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page  {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	public WebDriver driver;
	public int timeOut = 120;

	public Page(WebDriver driver){

		this.driver = driver;

	}
	protected Logger getLogger(){
		return logger;
	}
	public WebElement findobject(final By by){

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(timeOut, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		WebElement pageDisplayed = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));

		return pageDisplayed;

	}

	public void clickLink(final By by){
		WebElement obj = findobject(by);
		obj.click();
		//	logger.info("clicked : "+ by.toString());
		System.out.println("clicked : "+ by.toString());
	}
	public void clickSubMenu(final By byMainMenu, final By bySubMenu)  {
		//set focus on the object first
		Actions action = new Actions(driver);
		action.moveToElement(findobject(byMainMenu)).build().perform();
		logger.info("hovered : "+ byMainMenu.toString());
		//	Thread.sleep(3000);
		findobject(bySubMenu).click();
		//	logger.info("clicked : "+ bySubMenu.toString());
		System.out.println("clicked : "+ bySubMenu.toString());
	}

	public void setValueinTextField(final By by,String data)
	{
		findobject(by).click();
		//	findobject(by).clear();
		findobject(by).sendKeys(data);
		System.out.println("value set : "+data+" "+ by.toString());

	}

	public impfunc imp(){
		impfunc imp = new impfunc(driver);
		return imp;
	}

	public WebDriver Browser(String browser){
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		}
	
		return driver;
	}
}
