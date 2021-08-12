package com.operacloud.pages;

import java.io.IOException;

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


public class OperaCloud_ExchangePage extends OperaCloudSeleniumActions {

	public OperaCloud_ExchangePage(ChromeDriver driver, ExtentTest node) {
		//to do, verify title of the home page
		this.driver=driver;
		this.node=node;
		initPage();
	}
	public OperaCloud_HomePage goBackToHomePage() throws InterruptedException, IOException
	{
		try {
			reportStep("you are on home page of Operacloud", "pass");
		}
		catch(Exception e)
		{
			reportStep("you are not on home page of operacloud", "fail");
		}
		return new OperaCloud_HomePage(driver, node);
	}
	
	
}

