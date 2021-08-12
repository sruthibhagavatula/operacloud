package com.operacloud.selenium.actions.extensions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.operacloud.utils.ReadExcel;
import com.selenium.actions.GeneralSeleniumActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OperaCloudSeleniumActions extends GeneralSeleniumActions {
	
	

	public String testName, testDescription, testAuthor, testCategory;
	
	@BeforeSuite
	public void startReport() throws IOException  {
		setUp();
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(false);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		launchBrowser();
		
	}

	

	 //@BeforeMethod 
	 public void startApp() {
	  
	  test = extent.createTest(testName, testDescription);
	  test.assignCategory(testCategory);
	  node = test.createNode(testName);
	  
	 
	 }
	 

	
		/*
		 * @DataProvider(name = "fetchData") public String[][] methodForData() throws
		 * IOException { ReadExcel re = new ReadExcel(); return
		 * re.excelRead(excelFileName);
		 * 
		 * }
		 */
	
	@AfterSuite
	public void endReport() {
		extent.flush();
		driver.quit();
		

	}

	
	
	 
	
	public void previewSuccessScheduledReport() throws InterruptedException, IOException {
		try {
			switchBetweenOpenedWindows("ex=PREVIEW&rep=EXIST");
			/*
			 * ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			 * driver.switchTo().window(tabs2.get(1)); String switchedUrl=
			 * driver.getCurrentUrl(); System.out.println("Switched to " + switchedUrl);
			 * 
			 * if(switchedUrl.contains("ex=PREVIEW&rep=EXIST")) {
			 * reportStep("Report is generated successfully", "pass"); } Thread.sleep(5000);
			 * driver.close(); driver.switchTo().window(tabs2.get(0));
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
