package com.operacloud.pages;

import java.io.IOException;
import java.util.List;
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

import junit.framework.Assert;

public class OperaCloud_ShiftReportsViewPage extends OperaCloudSeleniumActions {

	public OperaCloud_ShiftReportsViewPage(ChromeDriver driver, ExtentTest node) {
		// to do, verify title of the home page
		this.driver = driver;
		this.node = node;
		initPage();
	}

	@FindBy(xpath = "//h1[contains(text(),'Shift Report')]")
	private WebElement verifyShiftReportsViewTitle;

	@SuppressWarnings("deprecation")
	public OperaCloud_ShiftReportsViewPage verifyShiftReportViewPageTitle() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			String actualValue = verifyShiftReportsViewTitle.getText();
			System.out.println("Title of the view shift reports page is " + actualValue);
			reportStep("verified the report view title", "pass");
			// Assert.asser("Shift Report-", actualValue);
			Thread.sleep(15000);
		} catch (Exception e) {
			reportStep("verification of the reportview title failed", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//table[@_selstate]//tr//td[count(//th//span[text()='Status']//ancestor::th/preceding-sibling::th)+1]//span")
	private List<WebElement> verifyStatusOfShiftReport;
	
	@FindBy(xpath="//span[contains(@id,'m1:odec_msg')]")
	private WebElement checkStatusOfShiftReport;

	@SuppressWarnings("deprecation")
	public OperaCloud_ShiftReportsViewPage verifyTheStatusOfShiftReport() throws InterruptedException, IOException {
		try {
			
			System.out.println("printing check page :");
			Thread.sleep(15000);
			switchBetweenOpenedWindows("launch-index/LaunchPage");
			Thread.sleep(15000);
			System.out.println("printing verifyStatusOfShiftReport sysout ");
			Thread.sleep(5000);
			for (WebElement element : verifyStatusOfShiftReport) {
				Thread.sleep(15000);
				String statusText = element.getText();
				System.out.println("printing status text " +statusText);
				if (statusText.equals("Pending")) {
					Thread.sleep(15000);
					//wait.until(ExpectedConditions.textToBePresentInElement(element, "pending"));
					System.out.println("report execution pending state" );
					reportStep("Report execution status is still in pending state", "pass");
					//Thread.sleep(8000);
				} 
				if (statusText.equals("Queued")) {
					Thread.sleep(15000);
					//wait.until(ExpectedConditions.textToBePresentInElement(element, "Queued"));
					//Thread.sleep(8000);
					System.out.println("report execution Queued state");
					
					reportStep("Report execution status is still in Queued state", "pass");
				} 
				if (statusText.equals("Running")) {
					Thread.sleep(15000);
					//wait.until(ExpectedConditions.textToBePresentInElement(element, "Running"));
					System.out.println("report execution Running state");
					Thread.sleep(15000);
					reportStep("Report execution status is still in Running state", "Pass");
				} 
				if (statusText.equals("Complete")) {
					Thread.sleep(15000);
					System.out.println("report execution completed state");
					reportStep("Report execution status is completed", "Pass");
					Thread.sleep(18000);

				}
			}

			
			String actualValue = checkStatusOfShiftReport.getText();
			Thread.sleep(3000);
			System.out.println("status of the view shift reports page is " + actualValue);
			reportStep("verified the report view title", "pass");

			System.out.println("sysout before switching to ex=PREVIEW&rep= " +driver.getCurrentUrl());
			Thread.sleep(3000);
			switchBetweenOpenedWindows("ex=PREVIEW&rep=");
			Thread.sleep(3000);
		} catch (Exception e) {
			reportStep("verification of the report status failed", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[contains(text(),'successfully generated')]")
	private WebElement reportSuccess;

	public OperaCloud_ShiftReportsViewPage verifyReportGenerationSuccessful() throws InterruptedException, IOException {

		Thread.sleep(25000);
		String reportMessage = reportSuccess.getText();
		if (reportMessage.contains("successfully generated")) {
			reportStep("Shift reports are generated successfully", "pass");

		} else
			reportStep("Shift report generation is unsuccessful", "fail");

		return this;
	}

}
