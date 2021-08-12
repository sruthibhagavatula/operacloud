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


public class OperaCloud_ToolBoxPage extends OperaCloudSeleniumActions {

	public OperaCloud_ToolBoxPage(ChromeDriver driver, ExtentTest node) {
		//to do, verify title of the home page
		this.driver=driver;
		this.node=node;
		initPage();
	}
	public OperaCloud_HomePage goBackToHomePage() throws InterruptedException, IOException
	{try {
		reportStep("you are on toolbox page", "pass");
	}
	catch(Exception e)
	{
		reportStep("you are on wrong page", "fail");
	}
		
		return new OperaCloud_HomePage(driver, node);
	}
	@FindBy(xpath = "//a[text()='System Setup']")
	private WebElement systemSetup;
	
	public OperaCloud_ToolBoxPage clickSystemSetup() throws InterruptedException, IOException
	{
		try {
		Thread.sleep(3000);
		systemSetup.click();
		Thread.sleep(5000);
		reportStep("click system setup successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click system setup unsuccessful", "fail");
		}
		return this;
	}
	@FindBy(xpath = "//td[text()='Export Shell']")
	private WebElement exportShell;
	
	public OperaCloud_ExportShellPage clickOnExportShell() throws  IOException
	{
		try {
		Thread.sleep(3000);
		exportShell.click();
		Thread.sleep(5000);
		reportStep("click on export shell successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on export shell unsuccessful", "fail");
		}
		
		return new OperaCloud_ExportShellPage(driver,node);
	}
	
	@FindBy(xpath = "//td[text()='Environment Controls']")
	private WebElement environmentControls;
	
	public OperaCloud_EnvironmentControlsPage clickEnvironmentControls() throws InterruptedException, IOException
	{
		try {
		Thread.sleep(3000);
		environmentControls.click();
		Thread.sleep(5000);
		reportStep("click on environment controls successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on environment controls unsuccessful", "fail");
		}
		return new OperaCloud_EnvironmentControlsPage(driver, node);
	}
	
}

