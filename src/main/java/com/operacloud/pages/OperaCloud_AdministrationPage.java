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


public class OperaCloud_AdministrationPage extends OperaCloudSeleniumActions {

	
	
	public OperaCloud_AdministrationPage(ChromeDriver driver, ExtentTest node) {
		// to do, verify title of the home page
		this.driver = driver;
		this.node = node;
		initPage();
	}

	@FindBy(xpath = "//a[text()='Interfaces']")
	private WebElement clickInterfaces;

	public OperaCloud_AdministrationPage clickOnInterfaces() throws InterruptedException, IOException {
		try {
		Thread.sleep(5000);
		clickInterfaces.click();
		Thread.sleep(5000);
		reportStep("click interfaces is successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click interfaces is unsuccessful", "fail");
		}
		return this;
	}

	public OperaCloud_HomePage goBackToHomePage() throws InterruptedException, IOException {
		try {
			reportStep("You are on OperaCloud Home page", "pass");
		}
		catch(Exception e)
		{
			reportStep("not on operacloud home page", "fail");
		}
		return new OperaCloud_HomePage(driver, node);
	}

	@FindBy(xpath = "//td[text()='Delivery Management']")
	private WebElement clickDeliveryManagement;

	public OperaCloud_AdministrationPage clickOnDeliveryManagement() throws InterruptedException, IOException {
		try {
		Thread.sleep(5000);
		clickDeliveryManagement.click();
		Thread.sleep(10000);
		reportStep("successfully clicked delivery management", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on delivery management is unsuccessful", "pass");
		}
		return this;
	}

	public OperaCloud_AdministrationPage scrollAdminPage() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			scrollPage();
			Thread.sleep(5000);
			reportStep("scroll performed successfully", "pass");
		} catch (Exception e) {
			reportStep("scroll not successfully performed", "fail");
		}
		
		return this;
	}

	@FindBy(xpath = "//span[text()='mailhost.int.oracleindustry.com']")
	private WebElement getServerText;

	public OperaCloud_AdministrationPage getServerTextContent() throws InterruptedException, IOException {
		
		Thread.sleep(5000);
		verifyText(getServerText, "mailhost.int.oracleindustry.com");
		Thread.sleep(3000);
		return this;
	}

	@FindBy(xpath = "//a[@title='Show User Options']")
	private WebElement userOptions;

	public OperaCloud_HomePage clickUserOptions() throws InterruptedException, IOException {
		try {
		
		userOptions.click();
		Thread.sleep(5000);
		reportStep("clicked on user options  successfully", "pass");
		}
		catch(Exception e)
		{
			reportStep("user options  unsuccessfully", "fail");
		}
		return new OperaCloud_HomePage(driver, node);
	}
}
