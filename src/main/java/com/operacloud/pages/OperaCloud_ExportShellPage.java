package com.operacloud.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;


public class OperaCloud_ExportShellPage extends OperaCloudSeleniumActions {

	public OperaCloud_ExportShellPage(ChromeDriver driver, ExtentTest node) {
		//to do, verify title of the home page
		this.driver=driver;
		this.node=node;
		initPage();
	}	
	
	//@FindBy(xpath = "//label[text()='Shell Name']//..//..//following::span")
	@FindBy(xpath="//input[contains(@id,'odec_it_it::content')]")
	private WebElement enterShellName;
	
	public OperaCloud_ExportShellPage enterShellName(String shellName) throws InterruptedException, IOException
	{
		try {
		Thread.sleep(5000);
		enterShellName.sendKeys(shellName);
		Thread.sleep(5000);
		reportStep("successfully entered shellname", "pass");
		}
		catch(Exception e)
		{
			reportStep("shellname unsuccessful", "fail");
		}
		return this;
	}
	
	@FindBy(xpath = "//label[text()='Property Shell (Legacy)']")
	private WebElement selectShellType;
	
	public OperaCloud_ExportShellPage selectShellType() throws InterruptedException
	{
		Thread.sleep(5000);
		selectShellType.click();
		Thread.sleep(5000);
		return this;
	}
	
	@FindBy(xpath = "//span[text()='Export Shell']")
	private WebElement exportShell;
	
	public OperaCloud_ExportShellPage clickOnExportShell() throws InterruptedException
	{
		Thread.sleep(5000);
		exportShell.click();
		Thread.sleep(5000);
		return this;
	}
}

