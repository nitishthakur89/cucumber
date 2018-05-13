package objectIds;

import org.openqa.selenium.By;

public class Homepage {

	public interface  homepagescreen
	{

		By HOMEPAGE_RECEIVING_HOVER = By.cssSelector("#ni475332-428796>span");
		By TRACK_YOUR_ITEM = By.linkText("Track your item");
		By TRACKING_NUMBER = By.xpath("//input[@placeholder='Enter tracking number(s) here']");
		By TRACK_BTN = By.cssSelector(".btn.btn-primary");


	}
}
