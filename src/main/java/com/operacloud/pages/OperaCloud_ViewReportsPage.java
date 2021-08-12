package com.operacloud.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;



public class OperaCloud_ViewReportsPage extends OperaCloudSeleniumActions {

	public OperaCloud_ViewReportsPage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		initPage();
		
	//to do, verify title of the login page	
	}
	@FindBy(xpath="//span[text()='Process']")
	private WebElement clickProcess;
	public OperaCloud_ShiftReportsViewPage clickOnProcess() throws InterruptedException, IOException
	{
		try {
		clickElement(clickProcess);
		Thread.sleep(5000);
		//switchWindow();
		Thread.sleep(10000);
		reportStep("click on click process successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on click process unsuccessful", "fail");
		}
		return new OperaCloud_ShiftReportsViewPage(driver,node);
	}
	@FindBy(xpath="//span[text()[contains(.,'error')]]")
	private WebElement checkReportStatus;
	public OperaCloud_ViewReportsPage toCheckReportStatus() throws InterruptedException, IOException
	{
		try {
		String message = checkReportStatus.getText();
		if(message.contains("error"))
		{
			reportStep("report generation failed", "fail");
		}
		else
			reportStep("report is generated successfully", "PASS");
		Thread.sleep(5000);
		
		}
		catch(Exception e)
		{
			reportStep("click on click process unsuccessful", "fail");
		}
		return this;
	}
	
	
	
	
}
