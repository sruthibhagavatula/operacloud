package com.operacloud.pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class OperaCloud_CreateReportsPage extends OperaCloudSeleniumActions {

	public OperaCloud_CreateReportsPage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		initPage();
		// to do, verify title of the login page
	}

	@FindBy(xpath = "//label[text()='Customized Report']")
	private WebElement clickCustomizedReport;

	public OperaCloud_CreateReportsPage clickOnCustomizedReport() throws InterruptedException, IOException {
		try{
			Thread.sleep(5000);
			//wait.until(ExpectedConditions.elementToBeClickable(clickCustomizedReport));
			clickCustomizedReport.click();
			Thread.sleep(5000);
			reportStep("successfully clicked on customized report", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on customized report unsuccessful", "fail");
		}
		
		return this;
	}

	@FindBy(xpath = "//label[text()='Display Name']")
	private WebElement clickOnScreen;

	public OperaCloud_CreateReportsPage clickAnywhereOnScreen() throws InterruptedException, IOException {
		try {
		clickElement(clickOnScreen);
		Thread.sleep(5000);
		reportStep("successfully clicked on screen", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on screen unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//input[contains(@id,'lov7:odec_lov_itLovetext')]")
	private WebElement enterReportsName;

	public OperaCloud_CreateReportsPage enterTheReportName(String customRep) throws InterruptedException, IOException {
		try {
		enterTextToWebElement(enterReportsName, customRep);
		Thread.sleep(5000);
		reportStep("successfully entered report name", "pass");
		}
		catch(Exception e)
		{
			reportStep("report name couldnt be entered", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[contains(text(),'Download Sample Report')]")
	private WebElement dwnldrprt;

	public OperaCloud_CreateReportsPage clickDownloadReportAndRename(String fileName)
			throws InterruptedException, IOException {
		try {
		clickElement(dwnldrprt);
		Thread.sleep(5000);
		Path downloadedFile = Paths.get("S:\\Cloud Workspace\\resources\\sample_alert.rtf");
		Files.move(downloadedFile, downloadedFile.resolveSibling("alert.rtf"));
		reportStep("successfully clicked on download report and renamed the file", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on download report is unsuccessful", "fail");	
		}
		return this;
	}

	@FindBy(xpath = "//input[contains(@id,'inFile')]/..")
	private WebElement chooseFile;

	public OperaCloud_CreateReportsPage chooseFileToUpload(String fileNameToUpload) throws InterruptedException, IOException {
try {				
	WebElement browse = chooseFile;	
	browse.click();
	Thread.sleep(3000);
	Robot rb = new Robot();
	StringSelection str = new StringSelection("S:\\Cloud Workspace\\resources\\alert.rtf");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 rb.keyPress(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_V);
 
    // release Contol+V for pasting
    rb.keyRelease(KeyEvent.VK_CONTROL);
    rb.keyRelease(KeyEvent.VK_V);
 
    // for pressing and releasing Enter
    rb.keyPress(KeyEvent.VK_ENTER);
    rb.keyRelease(KeyEvent.VK_ENTER);
				
		reportStep("successfully clicked on chooseFileToUpload", "pass");
}
catch(Exception e)
{
	reportStep("click on chooseFileToUpload failed", "fail");
}
		return this;
	}

	@FindBy(xpath = "//select[contains(@id,'lov3')]//option[contains(text(),'Accounts')]")
	private WebElement reportGrp;

	public OperaCloud_CreateReportsPage selectReportGroup() throws InterruptedException, IOException {
		try {
		clickElement(reportGrp);
		Thread.sleep(5000);
		reportStep("successfully clicked on report group", "pass");
		}
		catch (Exception e)
		{
			reportStep("click on report group unsuccessful", "fail");
		}
		return this;
	}

}
