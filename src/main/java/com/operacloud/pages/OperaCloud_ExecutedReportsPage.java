package com.operacloud.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class OperaCloud_ExecutedReportsPage extends OperaCloudSeleniumActions {

	public OperaCloud_ExecutedReportsPage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		initPage();
		

	}

	@FindBy(xpath="//a[@title='Actions']")
	private WebElement clickActionsButton;
	
	public OperaCloud_ExecutedReportsPage clickOnActionsButtonOnExecutedReports() throws IOException {
		try {
			scrollPage();
			clickActionsButton.click();
			Thread.sleep(5000);
			reportStep("click on actions in Executed Reports page successful", "pass");
		} catch (Exception e) {
			reportStep("click on actions in  executed reports page is unsuccessful", "fail");
		}
		return this;
	
	}

	@FindBy(xpath="//span[text()='Preview']")
	private WebElement clickPreview;
	
	public OperaCloud_ExecutedReportsPage clickOnPreview() throws IOException {
		try {
			
			clickPreview.click();
			Thread.sleep(5000);
			reportStep("click on Preview report in Executed Reports page successful", "pass");
		} catch (Exception e) {
			reportStep("click on preview report  in  executed reports page is unsuccessful", "fail");
		}
		return this;
	
	}
}
