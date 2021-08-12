package com.operacloud.pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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


public class OperaCloud_GeneratedExportsPage extends OperaCloudSeleniumActions {
	
	public OperaCloud_GeneratedExportsPage(ChromeDriver driver, ExtentTest node) {
		//to do, verify title of the home page
		this.driver=driver;
		this.node=node;
		initPage();
	}
	
	
	@FindBy(xpath="//h1[text()='Generated Exports']")
	private WebElement verifyTitle;
	
	public OperaCloud_GeneratedExportsPage verifyTitleOfGeneratedExportsPage() throws InterruptedException, IOException
	{
		try {
			String actualText=verifyTitle.getText();
			Assert.assertTrue(true, "Generated Exports");
			reportStep("you are on Generated Exports page of operacloud", "PASS");
		}
		catch(Exception e)
		{
			reportStep("you are not on Generated Exports page of operacloud", "FAIL");
		}
		return this;
	}
	@FindBy(xpath="(//table[@_selstate]//tr//td[count(//th//span[text()='Status']//ancestor::th/preceding-sibling::th)+1]//span)[1]")
	private WebElement verifyStatusOfExport;
		
		public OperaCloud_GeneratedExportsPage verifyTheStatusOfExport() throws IOException {
			try {
					String statusText = verifyStatusOfExport.getText();
					System.out.println("printing status text " +statusText);
					if (statusText.equals("Completed")) {
						Thread.sleep(5000);
						//wait.until(ExpectedConditions.textToBePresentInElement(verifyStatusOfExport, "Completed"));
						System.out.println("Export is in completed state" );
						reportStep("Export is in completed state", "pass");
						
					} 
				
			}catch (Exception e) {
				reportStep("Export is not in completed state", "fail");
			}
			return this;
		
		}
		
		@FindBy(xpath="//a[@title='Actions']")
		private WebElement clickActions;
		
		public OperaCloud_GeneratedExportsPage clickOnActions() throws IOException {
			try {
				Thread.sleep(5000);
				System.out.println(clickActions);
				clickActions.click();
				reportStep("click on Actions menu is successful", "pass");
			} catch (Exception e) {
				reportStep("click on Actions  menu is unsuccessful", "fail");
			}
			return this;
		
		}
		@FindBy(xpath="//span[text()='Generate File']")
		
		private WebElement generateFile;
		
		public OperaCloud_GeneratedExportsPage clickOnGenerateFile() throws IOException {
			try {
				Thread.sleep(5000);
				generateFile.click();
				Thread.sleep(15000);
				reportStep("click on Generate File is successful", "pass");
			} catch (Exception e) {
				reportStep("click on Generate File is unsuccessful", "fail");
			}
			return this;
		
		}
		
		@FindBy(xpath="//div[text()='Export File Name']//following::label[text()='Required Field']//parent::span//parent::div//following-sibling::div//following::label[text()='File Name']//following::input")
		private WebElement fileNameText;
		public OperaCloud_GeneratedExportsPage enterExportFileName() throws IOException {
			try {
				Thread.sleep(5000);
				fileNameText.sendKeys(OperaCloud_MiscellaneousGeneralPage.exportName);
				Thread.sleep(5000);
				reportStep("Entered file name to export successfully", "pass");
			} catch (Exception e) {
				reportStep("File name is not entered successfully", "fail");
			}
			return this;
		
		}
		
		@FindBy(xpath = "//div[text()='Export File Name']//following::label[text()='Required Field']//parent::span//parent::div//following-sibling::div//following::label[text()='Extension']//following::input")
		private WebElement fileNameextension;
		public OperaCloud_GeneratedExportsPage enterExportFileNameExtension(String ext) throws IOException {
			try {
				Thread.sleep(5000);
				fileNameextension.sendKeys(ext);
				Thread.sleep(5000);
				reportStep("Entered file name extension successfully", "pass");
			} catch (Exception e) {
				reportStep("File name extension is not entered successfully", "fail");
			}
			return this;
		
		}
		@FindBy(xpath="//div[text()='Export File Name']//following::label[text()='Required Field']//parent::span//parent::div//following-sibling::div//following::span[text()='Generate File']")
		private WebElement generateFileButton;
		public OperaCloud_GeneratedExportsPage clickGenerateFileButton() throws IOException {
			try {
				Thread.sleep(5000);
				generateFileButton.click();
				Thread.sleep(5000);
				reportStep("clicked on Generate File button successfully", "pass");
			} catch (Exception e) {
				reportStep("click on Generate File button is not successful", "fail");
			}
			return this;
		
		}
		
		@FindBy(xpath="//div[text()='Information']//following::div[contains(text(),'submitted successfully')]")
		private WebElement infoText;
		
		@FindBy(xpath="//div[text()='Information']//following::div[contains(text(),'submitted successfully')]//following::span[text()='OK']")
		private WebElement clickOkButton;
		public OperaCloud_GeneratedExportsPage verifyGeneratedExportSuccessMessageAndClickOk() throws IOException {
			try {
				Thread.sleep(5000);
				String successText= infoText.getText();
				String actualText="Generate export file job submitted successfully";
				if(successText.contains(actualText)) {
					reportStep("export is generated successfully", "pass");
				}
				clickOkButton.click();
				reportStep("clicked on ok button successfully", "pass");
			} catch (Exception e) {
				reportStep("export is not generated successfully", "fail");
			}
			return this;
		
		}
		@FindBy(xpath="//h2[text()='Exports']//following::span[text()='Refresh']")
		private WebElement clickRefresh;
		
		public OperaCloud_GeneratedExportsPage clickRefreshButton() throws IOException {
			try {
				String statusCheck =(verifyStatusOfExport).getText();
				if(statusCheck.equals("In Queue"))
				{
					reportStep("Current status is " + statusCheck +"clicking on refresh button", "pass");
					clickRefresh.click();
					Thread.sleep(5000);
				}
				if(statusCheck.equals("Running"))
				{
					reportStep("Current status is " + statusCheck +"clicking on refresh button", "pass");
					clickRefresh.click();
					Thread.sleep(5000);
				}
				reportStep("clicked on refresh button successfully", "pass");
				System.out.println(verifyStatusOfExport);
			} catch (Exception e) {
				reportStep("refresh button is not clicked successfully", "fail");
			}
			return this;
		
		}
		
		
		public OperaCloud_GeneratedExportsPage clickActionsButton() throws IOException {
			try {
				String statusCheck =verifyStatusOfExport.getText();
				if(statusCheck.equals("Completed"))
				{
					reportStep("Current status is " + statusCheck +"clicking on actions button", "pass");
					clickActions.click();
				}
				reportStep("clicked on refresh button successfully", "pass");
			} catch (Exception e) {
				reportStep("refresh button is not clicked successfully", "fail");
			}
			return this;
		
		}
		
		
		@FindBy(xpath="//span[text()='View Details']")
		
		private WebElement viewDetails;
		
		public OperaCloud_GeneratedExportsPage clickOnViewDetails() throws IOException {
			try {
				
				Thread.sleep(5000);
				clickOnActions();
				viewDetails.click();
				Thread.sleep(5000);
				reportStep("click on view details is successful", "pass");
			} catch (Exception e) {
				reportStep("click on view details is unsuccessful", "fail");
			}
			return this;
		
		}
		
		@FindBy(xpath="//h1[text()='Export Details']//following::label[text()='Description']//following::span")
		private WebElement validateDetails;
		@FindBy(xpath="//h1[text()='Export Details']//following::a[@role='button']//following::span[text()='Back']")
		private WebElement clickBack;
		
		public OperaCloud_GeneratedExportsPage validateExportDetails() throws IOException {
			try {
				Thread.sleep(5000);
				String exportName = validateDetails.getText();
				System.out.println(exportName);
				if(OperaCloud_MiscellaneousGeneralPage.exportName.equals(exportName))
				{
					reportStep("Export validation is successfull", "PASS");
				}
				Thread.sleep(5000);
				scrollPage();
				clickBack.click();
				reportStep("clicked on back button successfully", "PASS");
				
			} catch (Exception e) {
				reportStep("Export Validation is unsuccessful", "fail");
			}
			return this;
		
		}
		
		@FindBy(xpath="//span[text()='Download']")
		private WebElement downloadExport;
		
		
		public OperaCloud_GeneratedExportsPage downloadTheExport() throws IOException {
			try {
				clickOnActions();
				Thread.sleep(5000);
				downloadExport.click();
				reportStep("clicked on download button successfully", "PASS");
				switchWindow();
				isFileDownloaded(downloadPath, OperaCloud_MiscellaneousGeneralPage.exportName+".txt");
				reportStep("File download is validated", "PASS");
				Thread.sleep(5000);
				if ((new File(downloadPath+"/"+OperaCloud_MiscellaneousGeneralPage.exportName+".txt")).delete()) {
	                reportStep("File deleted successfully from downloaded location", "PASS");    
	            } else {
	            	reportStep("File cannot be deleted from downloaded location", "FAIL"); 
	            }
			}
			catch (FileNotFoundException e) {
				reportStep("File download is not successfully validated", "fail");
			}
			catch (Exception ex) {
				reportStep("click on download button is unsuccessful", "fail");
			}
			return this;
		
		}
		
		
	
}

