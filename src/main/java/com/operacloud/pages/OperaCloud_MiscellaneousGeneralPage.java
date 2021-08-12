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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;


public class OperaCloud_MiscellaneousGeneralPage extends OperaCloudSeleniumActions {
	
	public OperaCloud_MiscellaneousGeneralPage(ChromeDriver driver, ExtentTest node) {
		//to do, verify title of the home page
		this.driver=driver;
		this.node=node;
		initPage();
	}
	
	static String exportName;
	
	@FindBy(xpath="//h1[text()='General']")
	private WebElement verifyTitle;
	
	public OperaCloud_MiscellaneousGeneralPage verifyTitleOfGeneralPage() throws InterruptedException, IOException
	{
		try {
			String actualText=verifyTitle.getText();
			Assert.assertTrue(true, "General");
			reportStep("you are on General page of operacloud", "PASS");
		}
		catch(Exception e)
		{
			reportStep("you are not on General page of operacloud", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="((//table//span[text()='Description']//ancestor::table/parent::div/parent::div//following-sibling::div)[1] //colgroup//following::tbody//preceding::div[@_afrcolcount]//following-sibling::div//table[@_afrit]//td[count( //table//span[text()='Description']//ancestor::th//preceding-sibling::th)+1])[1]//span")
	private WebElement getExportText;
	
	@FindBy(xpath="//h1[text()='General']//following::h2[text()='Search']//following::label[text()='Description']//following::input")
	private WebElement enterDescription;
	
	public OperaCloud_MiscellaneousGeneralPage getExportTextAndSendItToDescription() throws InterruptedException, IOException
	{
		try {
			exportName=getExportText.getText();
			Thread.sleep(5000);
			enterDescription.sendKeys(exportName);
			Thread.sleep(5000);
			reportStep("Successfully entered description as "+ exportName, "PASS");
		}
		catch(Exception e)
		{
			reportStep("Couldn't enter description", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//h1[text()='General']//following::h2[text()='Search']//following::a//following::span[text()='Search']")
	private WebElement clickSearch;
	
	public OperaCloud_MiscellaneousGeneralPage clickOnSearchToFetchDescription() throws InterruptedException, IOException
	{
		try {
			clickSearch.click();
			Thread.sleep(5000);
			reportStep("Successfully clicked on search button", "PASS");
		}
		catch(Exception e)
		{
			reportStep("Couldn't click search button", "FAIL");
		}
		return this;
	}
	
	
	public OperaCloud_MiscellaneousGeneralPage clickOnSearchedReportToExport() throws InterruptedException, IOException
	{
		//String exportedText = getExportText.getText();
		enterDescription.click();
		return this;
	}
	@FindBy(xpath="//a[@title='Actions']")
	private WebElement clickActions;
	
	public OperaCloud_MiscellaneousGeneralPage clickOnActions() throws IOException {
		try {
			Thread.sleep(5000);
			//scrollPage();
			System.out.println(clickActions);
			clickActions.click();
			//Actions act = new Actions(driver);
			//act.click(clickActions);
			//Thread.sleep(5000);
			reportStep("click on Actions menu is successful", "pass");
		} catch (Exception e) {
			reportStep("click on Actions  menu is unsuccessful", "fail");
		}
		return this;
	
	}
	
	@FindBy(xpath="//span[text()='Export Data']")
	
	private WebElement exportData;
	
	public OperaCloud_MiscellaneousGeneralPage clickOnExportData() throws IOException {
		try {
			Thread.sleep(5000);
			exportData.click();
			Thread.sleep(5000);
			reportStep("click on Export data is successful", "pass");
		} catch (Exception e) {
			reportStep("click on Export data is unsuccessful", "fail");
		}
		return this;
	
	}
	
	@FindBy(xpath="//div[text()='Information']//ancestor::tr//following-sibling::tr//following::div[contains(text(),'submitted')]")
	private WebElement getInfoText;
	
	@FindBy(xpath="//div[text()='Information']//ancestor::tr//following-sibling::tr//following::span[text()='OK']")
	private WebElement clickOK;
	public OperaCloud_MiscellaneousGeneralPage getInfoTextAndClickOk() throws IOException {
		try {
			Thread.sleep(5000);
			String actualText=getInfoText.getText();
			if(actualText.contains("Export data request submitted. Check status on View Exports screen."))
			{
				reportStep("Export is successful", "pass");
			}
			Thread.sleep(1000);
			clickOK.click();
			Thread.sleep(5000);
			reportStep("clicked ok button", "PASS");
		} catch (Exception e) {
			reportStep("click on Export data is unsuccessful", "fail");
		}
		return this;
	
	}
@FindBy(xpath="//span[text()='View Exports']")
	
	private WebElement viewExports;
	
	public OperaCloud_GeneratedExportsPage clickOnViewExports() throws IOException {
		try {
			Thread.sleep(5000);
			viewExports.click();
			Thread.sleep(5000);
			reportStep("click on View Exports is successful", "pass");
		} catch (Exception e) {
			reportStep("click on View Exports is unsuccessful", "fail");
		}
		return new OperaCloud_GeneratedExportsPage(driver,node);
	
	}
	
	
}

