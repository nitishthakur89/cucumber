package com.cucumber.mavencucumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page  {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	public WebDriver driver;
	public String browsername ;
	public   ExtentTest test;
	public  ExtentReports extent= ExtentReportUtil.getInstance();

	public int timeOut = 120;
	public String TESTCASENAME;
	public  ArrayList<String> TestStep = new ArrayList<String>();

	/*public Page(WebDriver driver){

		this.driver = driver;

	}
	 */	protected Logger getLogger(){
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


	 public WebDriver Browser(String browser){
		 //WebDriver driver = null;
		 if (browser.equalsIgnoreCase("chrome"))
		 {
			 driver = new ChromeDriver();
			 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		 }
		 else	if (browser.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
			 System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		 }
		 browsername = browser;
		 return driver;
	 }

	 public  void takeScreenshot(String TestcaseName,String desc)
	 {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);        
		 try {
			 FileUtils.copyFile(scrFile, new File("target\\screenshot\\"+TestcaseName+"\\"+System.currentTimeMillis()+".jpg"));
			 TestStep.add(desc);
			 System.out.println("test inside takescrenshot");
			 test.log(LogStatus.INFO, desc);
		 } catch (IOException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }

	 public void waitforseconds(int sec) throws InterruptedException
	 {
		 Thread.sleep(sec*1000);

	 }

	 public void ScreenshotToPDf(String Testcase) {


		 Document document = new Document();


		 String path = "target\\screenshot\\"+Testcase+"\\";

		 int count = FilesCount(path);
		 System.out.println("count" + count);
		 try {
			 PdfWriter.getInstance(document, new FileOutputStream(path + Testcase + ".pdf"));
		 } catch (FileNotFoundException e1) {
			 // TODO Auto-generated catch block
			 System.out.println("No Screenshot present to Convert into Pdf");

		 } catch (DocumentException e1) {
			 // TODO Auto-generated catch block
			 e1.printStackTrace();
		 }
		 document.open();
		 String[] fileNames = new File(path).list();
		 Font font1 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
		 for (int i = 1; i <= count; i++)
		 {
			 String namefile = path + fileNames[i-1];//Testcase + "_" + i + ".jpg";
			 System.out.println("namefile" + namefile);
			 try {
				 if ((i % 2 == 1) && (i > 1)) {
					 document.newPage();
				 }
				 //  document.add(new Paragraph(Testcase + "_" + i, font1));

				 document.add(Chunk.NEWLINE);


				 /* if(i<=(count-1))
		            {*/
				 String s = (String) TestStep.get(i-1);


				 document.add(new Paragraph(s, font1)); 
				 //  }
				 //document.add(new Paragraph(Testcase+"_"+i+".jpg"));
				 document.add(Chunk.NEWLINE);
				 //document.add(Chunk.NEWLINE );
				 Image image1 = Image.getInstance(namefile);
				 image1.scaleAbsolute(500f, 300f);
				 document.add(image1);
				 document.add(Chunk.NEWLINE);
				 new File(namefile).delete();

			 } catch (Exception e) {
				 e.printStackTrace();
			 }
		 }

		 document.close();
		 TestStep.clear();


	 }



	 public int FilesCount(String folderPath) {
		 //String namefile=path+Testcase+"_"+i+".jpg";
		 System.out.println("folderPath" + folderPath);
		 String[] fileNames = new File(folderPath).list();
		 System.out.println("nitish ====="+fileNames[0]);
		 System.out.println("fileNames"+fileNames.length);
		 //System.out.println("fileNames.length"+fileNames.length);
		 int total = 0;
		 for (int i = 0; i < fileNames.length; i++) {
			 String suffix = ".jpg";
			 if (fileNames[i].toLowerCase().endsWith(suffix)) {
				 total++;
			 }

		 }
		 //System.out.println("total"+total);
		 return total;
	 }

}
