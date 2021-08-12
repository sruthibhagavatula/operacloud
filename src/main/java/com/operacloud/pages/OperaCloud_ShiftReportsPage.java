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


public class OperaCloud_ShiftReportsPage extends OperaCloudSeleniumActions {

	public OperaCloud_ShiftReportsPage(ChromeDriver driver, ExtentTest node) {
		//to do, verify title of the home page
		this.driver=driver;
		this.node=node;
		initPage();
	}
	public OperaCloud_HomePage goBackToHomePage() throws InterruptedException, IOException
	{
		try {
			reportStep("you are on shift reports page", "pass");
		}
		catch(Exception e)
		{
			reportStep("you are not on shift reports page", "fail");
		}
		return new OperaCloud_HomePage(driver, node);
	}
	@FindBy(xpath="//a//span[text()='New']")
	private WebElement newButton;
	public OperaCloud_ManageShiftReport clickOnNewButton() throws IOException {
		
		try {
			System.out.println("about to click new button");
			Thread.sleep(5000);
			//wait.until(ExpectedConditions.presenceOfElementLocated((By) newButton));
			newButton.click();
			System.out.println("new button clicked");
			Thread.sleep(5000);
			reportStep("successfully clicked on new button", "PASS");
		}
		catch(Exception e)
		{
			reportStep("clicking on new Button is unsuccessful", "FAIL");
		}
		
		return new OperaCloud_ManageShiftReport(driver, node);
	}
	
	
	@FindBy(xpath="//span[text()='Search']")
	private WebElement searchButton;
	public OperaCloud_ShiftReportsPage clickSearchButton() throws InterruptedException, IOException
	{
		try {
		searchButton.click();
		Thread.sleep(5000);
		reportStep("click on search button successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on search button unsuccessful", "fail");
		}
		return this;
	}
	
	public OperaCloud_ShiftReportsPage scrollShiftReportsPage()
	{
		try {
			Thread.sleep(5000);
			scrollPage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	String xpath = "//span[text()='replacethisvalue']";

	public OperaCloud_ShiftReportsPage clickOnReportName(String reportName) throws IOException  
	{
		try {
		Thread.sleep(5000);

		WebElement rprtnme = findElement("xpath", generateDynamicXpath(xpath, reportName));
		rprtnme.click();
		Thread.sleep(5000);
		reportStep("click on report is successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on report is unsuccessful", "fail");
		}
		return this;
	}
	


	public OperaCloud_ShiftReportsPage clickOnActions() throws IOException  
	{
		try {
		Thread.sleep(5000);
		WebElement clickActions= driver.findElement(By.xpath("//span[text()='rep_"+OperaCloud_ManageShiftReport.repname+"']//parent::td//following::td//span//a[@title='Actions']"));
		
		System.out.println(clickActions +"is the xpath of clickActions");
		clickActions.click();
		Thread.sleep(5000);
		reportStep("click on Actions is successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on Actions is unsuccessful", "fail");
		}
		return this;
	}
	@FindBy(xpath="//a[@title='Actions']")
	private WebElement clickReportsAction;
	public OperaCloud_ShiftReportsPage clickOnReportsAction() throws InterruptedException, IOException
	{
		try {
		wait.until(ExpectedConditions.elementToBeClickable(clickReportsAction));
		clickReportsAction.click();
		Thread.sleep(5000);
		reportStep("click on reports actions successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on reports actions unsuccessful", "fail");
		}
		return this;
	}
	@FindBy(xpath="//label[text()='Report']//following::input[contains(@id,'ReportName')]")
	private WebElement ReportSearch;
	public OperaCloud_ShiftReportsPage searchCreatedReport(String reportName) throws IOException
	{
		try {
			System.out.println(reportName);
			Thread.sleep(5000);
			ReportSearch.sendKeys(reportName);
			Thread.sleep(5000);
			reportStep("successfully entered the newly created report in search field", "pass");
		} catch (InterruptedException e) {
			e.printStackTrace();
			reportStep("something wrong in entering newly created report in search field" , "fail");
		}
		return this;
	}
	
	@FindBy(xpath = "//span[text()='View']")
	private WebElement clickViewOption;
	
	public OperaCloud_ViewReportsPage clickOnViewOption() throws InterruptedException, IOException
	{
		try {
		//wait.until(ExpectedConditions.elementToBeClickable(clickViewOption));
		clickViewOption.click();
		Thread.sleep(5000);
		scrollPage();
		reportStep("click on view options successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on view options unsuccessful", "fail");
		}
		return new OperaCloud_ViewReportsPage(driver,node);
	}

}

