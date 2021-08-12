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


public class OperaCloud_HelpPage extends OperaCloudSeleniumActions {

	public OperaCloud_HelpPage(ChromeDriver driver, ExtentTest node) {
		// to do, verify title of the home page
		this.driver = driver;
		this.node = node;
		initPage();
		switchWindow();
		
	}

	String xpath = "//a[contains(@href,'replacethisvalue')]";

	public OperaCloud_HelpPage clickCloudServicesUserGuide(String helpContent) throws InterruptedException, IOException 
	{
		try {
		Thread.sleep(5000);

		WebElement helpCntnt = findElement("xpath", generateDynamicXpath(xpath, helpContent));
		helpCntnt.click();
		Thread.sleep(5000);
		reportStep("click on help content successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on help content unsuccessful", "fail");
		}
		return this;
	}
	public void parentWindow() throws InterruptedException, IOException 
	{
		try {
		Thread.sleep(5000);
		switchToParentWindow();
		driver.close();
		reportStep("successfully switched to parent window", "pass");
		}
		catch(Exception e)
		{
			reportStep("switch unsuccessful", "fail");
		}
		
		
		
	}
}
