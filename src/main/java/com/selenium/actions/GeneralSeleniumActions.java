package com.selenium.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeneralSeleniumActions {

	/** The driver to launch to browser. */
	public static ChromeDriver driver;
	public String parentWindow;
	public WebDriverWait wait;
	//public String downloadFilepath = "S:\\Cloud Workspace\\resources";
	//public File resourceFolder = new File("S:\\Cloud Workspace\\resources");
	public static Properties prop = new Properties();
	public static File projectWorkSpace= new File(System.getProperty("user.dir"));
	public static File file = new File (projectWorkSpace.getAbsoluteFile()+"/file.txt");
	public String textFilePath = file.getAbsolutePath();
	public static File imgfile = new File (projectWorkSpace.getAbsoluteFile()+"/image.jpeg");
	public String imageFilePath = imgfile.getAbsolutePath();
	public static String downloadPath = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator + "downloadFiles";
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public ExtentTest test, node;
	
	public static String username, password,reportname1,reportname3,location,tileAndQuantity,helpSearchText,shellname,reportgrp,
	emailid,format,reportname2,url,mobileType,emailType,nameOfFile,nameOfImageFile,exportFileName,fileNameExtension;

	public void setUp() throws IOException {

		
		FileInputStream fis = new FileInputStream(projectWorkSpace.getAbsolutePath()+"\\src\\main\\resources\\config.properties");
		prop.load(fis);
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		reportname1 = prop.getProperty("reportname1");
		reportname2 = prop.getProperty("reportname2");
		reportname3 = prop.getProperty("reportname3");
		location = prop.getProperty("location");
		reportgrp = prop.getProperty("reportgrp");
		emailid = prop.getProperty("emailid");
		format = prop.getProperty("format");
		mobileType = prop.getProperty("mobileType");
		emailType = prop.getProperty("emailType");
		nameOfFile=prop.getProperty("nameOfFile");
		nameOfImageFile= prop.getProperty("nameOfImageFile");
		tileAndQuantity= prop.getProperty("tileAndQuantity");
		helpSearchText=prop.getProperty("helpSearchText");
		shellname=prop.getProperty("shellname");
		exportFileName=prop.getProperty("exportFileName");
		fileNameExtension= prop.getProperty("fileNameExtension");
		
		

		// ChromeOptions options = new ChromeOptions();

		// Map<String,Object> prefs = new HashMap<String,Object>();
		// prefs.put("", value)
	}
	
	
	public void reportStep(String msg, String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			node.pass(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());
		} else if (status.equalsIgnoreCase("fail")) {
			node.fail(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img" + takeSnap() + ".png").build());
			throw new RuntimeException();
		}

	}
	public void switchBetweenOpenedWindows(String urlContent) throws IOException, InterruptedException {
		
		// ((JavascriptExecutor) driver).executeScript("window.open()");
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String windowToSwitch = I1.next();
			System.out.println("sysout after switching window " +driver.getCurrentUrl());
			driver.switchTo().window(windowToSwitch);
			Thread.sleep(15000);
			if (driver.getCurrentUrl().contains(urlContent)) {
				System.out.println("Switched to " +driver.getCurrentUrl());
				reportStep("window switched successfully to title "+driver.getTitle(), "pass");
				break;
			}
		}
	}

	public void invokeBrowser() {
		System.out.println("url");
	driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	public void launchBrowser() {
		WebDriverManager.chromedriver().proxy("http://www-proxy.us.oracle.com:80").setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory",downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		//ChromeDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		

	}

	 public boolean isFileDownloaded(String downloadPath, String fileName) {

		 boolean flag = false;

		 File directory = new File(downloadPath);

		 File[] content = directory.listFiles();

		  for (int i = 0; i < content.length; i++) {
		  if (content[i].getName().equals(fileName))
		 return flag=true;
		   		}
		 return flag;
		  }
	
	public int takeSnap() throws IOException {
		int snapNumber = (int) (Math.random() * 90000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img" + snapNumber + ".png");
		FileUtils.copyFile(source, target);
		return snapNumber;
	}

	public void initPage() {
		PageFactory.initElements(this.driver, this);

	}

	public WebElement findElement(String locator, String locatorValue) {
		try {
			switch (locator) {
			case "id":
				return driver.findElementById(locatorValue);

			case "name":
				return driver.findElementByName(locatorValue);

			case "xpath":
				return driver.findElementByXPath(locatorValue);

			case "linktext":
				return driver.findElementByLinkText(locatorValue);

			case "partiallinktext":
				return driver.findElementByPartialLinkText(locatorValue);

			default:
				return null;

			}
		} catch (Exception e) {

			return null;
		}

	}

	public void clickByLocator(String locator) {
		try {
			WebElement element = driver.findElementByXPath(locator);
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click(); // xpath - //*[text()='Next']
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyTitle(String locator) {
		try {
			WebElement element = driver.findElementByXPath(locator);
			String title = element.getText();
			driver.getTitle().equalsIgnoreCase(title);
			element.click(); // xpath - //*[text()='Next']
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickElement(WebElement element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			System.out.println(element);
			// wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click(); // xpath - //*[text()='Next']
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchTab(WebElement element) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			System.out.println(element);
			// wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(Keys.CONTROL + "\t"); // xpath - //*[text()='Next']
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollPage() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			// js.executeScript("window.", args)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifyText(WebElement element, String textToVerify) {
		boolean isVerified = false;
		try {
			isVerified = element.getText().contains(textToVerify);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isVerified;
	}

	public void enterTextToWebElement(WebElement element, String textValue) {
		try {

			/*
			 * wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			 * wait.until(ExpectedConditions.visibilityOf(element));
			 */

			System.out.println(textValue);
			element.sendKeys(textValue); // xpath - //*[text()='Next']
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadFile(WebElement element, String fileToUpload) {
		try {

			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			System.out.println(element.getTagName());
			// WebElement clickChooseFile =
			// driver.findElementByXPath("//span[contains(text(),'Choose File')]");
			Actions act = new Actions(driver);
			Action seriesOfActions = act.sendKeys(element, fileToUpload).build();
			seriesOfActions.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String generateDynamicXpath(String xpath, String replaceValue) {
		try {
			xpath = xpath.replace("replacethisvalue", replaceValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xpath;
	}

	public void waitUntilTitle(String expectedTitle) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.titleContains(expectedTitle));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectFromDropDownByVisibleText(String locator, String locValue, String visibleText) {
		try {
			WebElement element = findElement(locator, locValue);
			new Select(element).selectByVisibleText(visibleText);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchWindow() {
		try {
			Set<String> winhandles = driver.getWindowHandles();
			for (String windowhandle : winhandles) {
				driver.switchTo().window(windowhandle);
			}

			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToParentWindow() throws InterruptedException, IOException {
		try {
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			driver.close();
			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CreateFileAndWriteToFile() {
		 //System.getProperty returns absolute path
	   
	    if(!file.getParentFile().exists()){
	    	file.getParentFile().mkdirs();
	    }
	    //Remove if clause if you want to overwrite file
	    if(!file.exists()){
	        try {
	        	file.createNewFile();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    try {
	        //dir will change directory and specifies file name for writer
	        File dir = new File(file.getParentFile(), file.getName());
	        PrintWriter writer = new PrintWriter(dir);
	      
	        writer.print("Sample txt file to upload to profile");
	        writer.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		
}
}
