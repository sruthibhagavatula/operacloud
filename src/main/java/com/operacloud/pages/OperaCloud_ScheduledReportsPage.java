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

public class OperaCloud_ScheduledReportsPage extends OperaCloudSeleniumActions {

	public OperaCloud_ScheduledReportsPage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		initPage();
		

	}

	@FindBy(xpath = "//h1[text()='Scheduled Reports']")
	private WebElement verifyPageTitle;

	public OperaCloud_ScheduledReportsPage verificationOfScheduledReportsPageTitle()
			throws InterruptedException, IOException {
		try {
			String actualPageTitle = verifyPageTitle.getText();
			Assert.assertEquals(actualPageTitle, "Scheduled Reports");
			reportStep("You are here on Scheduled reports page creation", "pass");
		} catch (Exception e) {
			reportStep("oops something wrong!!!!! you are not on Scheduled reports page creation", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='New']")
	private WebElement clickNewButton;

	public OperaCloud_ScheduledReportsPage clickOnNewButton() throws InterruptedException, IOException {
		try {
			clickNewButton.click();
			Thread.sleep(5000);
			reportStep("successfully clicked on new button on Manage Scheduled reports page ", "pass");
		} catch (Exception e) {
			reportStep("Something is wrong!!!!! click on new button on Manage Scheduled reports page is unsuccessful", "fail");
		}
		return new OperaCloud_ScheduledReportsPage(driver, node);
	}

	@FindBy(xpath = "//input[contains(@id,'reportName')]")
	private WebElement enterReportName;

	public OperaCloud_ScheduledReportsPage enterTheReportName(String reportName) throws InterruptedException, IOException {
		try {
			enterReportName.sendKeys(reportName);
			Thread.sleep(5000);
			reportStep("report name entered successfully ", "pass");
		} catch (Exception e) {
			reportStep("report name not entered successfully ", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//a[@title='Search and Select Property']")
	private WebElement clickSearchAndSelectButton;

	public OperaCloud_ScheduledReportsPage clickOnSearchAndSelectButton() throws InterruptedException, IOException {
		try {
			clickSearchAndSelectButton.click();
			Thread.sleep(5000);
			reportStep("clicked Search And Select Button successfully ", "pass");
		} catch (Exception e) {
			reportStep("click on Search And Select Button unsuccessful ", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//label[text()='Report Group']//following::select")
	private WebElement selectRptGroup;

	public OperaCloud_ScheduledReportsPage selectReportGroup(String grpval) throws InterruptedException, IOException {
		try {
			Select sel = new Select(selectRptGroup);
			sel.selectByValue(grpval);
			Thread.sleep(5000);
			reportStep("selected report group successfully", "pass");

		} catch (Exception e) {
			reportStep("select on report group unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//td[contains(@id,'lov_cCode')]")
	private WebElement clickPropName;

	public OperaCloud_ScheduledReportsPage clickOnPropName() throws InterruptedException, IOException {
		try {
			clickPropName.click();
			Thread.sleep(5000);
			reportStep("clicked property name successfully", "pass");

		} catch (Exception e) {
			reportStep("click property name unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Select']")
	private WebElement clickSelectButton;

	public OperaCloud_ScheduledReportsPage clickOnSelectButton() throws InterruptedException, IOException {
		try {
			scrollPage();
			clickSelectButton.click();
			Thread.sleep(5000);
			reportStep("clicked select button successfully", "pass");
		} catch (Exception e) {
			reportStep("click on select button unsuccessful", "fail");
		}
		return this;
	}
	@FindBy(xpath="//div[@title='Report Parameters']//parent::div//following::span[text()='Next']")
	private WebElement clickNextReportParametersButton;
	
	public OperaCloud_ScheduledReportsPage clickOnReportParametersNextButton() throws IOException {
		try {
			Thread.sleep(5000);
			clickNextReportParametersButton.click();
			Thread.sleep(5000);
		
		reportStep("click on Report Parameters Next button is successful", "pass");
	} catch (Exception e) {
		reportStep("click on Report Parameters Next button unsuccessful", "fail");
	}
	return this;
}

	@FindBy(xpath="//div[@title='Repeat Intervals']//parent::div//following::span[text()='Next']")
	private WebElement clickNextRepeatIntervalsButton;
	
	public OperaCloud_ScheduledReportsPage clickOnRepeatIntervalsNextButton() throws IOException {
		try {
			Thread.sleep(5000);
			clickNextRepeatIntervalsButton.click();
			Thread.sleep(5000);
		
		reportStep("click on Repeat Intervals Next button is successful", "pass");
	} catch (Exception e) {
		reportStep("click on Repeat Intervals Next button unsuccessful", "fail");
	}
	return this;
}
			
		
	
	
	@FindBy(xpath = "//div[contains(@id,'advncd_srch_btn')]")
	private WebElement clickSearchButton;

	public OperaCloud_ScheduledReportsPage clickOnSearchButton() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickSearchButton.click();
			Thread.sleep(5000);
			scrollPage();
			reportStep("click on search button successful", "pass");
		} catch (Exception e) {
			reportStep("click on search button unsuccessful", "fail");
		}
		return this;
	}
	
	
	@FindBy(xpath = "//a[@title='Expand']")
	private WebElement clickExpand;

	public OperaCloud_ScheduledReportsPage clickOnExpandConfiguration() throws InterruptedException, IOException {
		try {
			/*
			 * Actions act = new Actions(driver); act.click(clickExpand).build().perform();
			 */
			clickExpand.click();
			//Thread.sleep(5000);
			reportStep("Configuration expanded successfully", "pass");
		} catch (Exception e) {
			reportStep("Configuration expansion is not successful", "fail");
		}
		return this;
	}
	
	@FindBy(xpath="//a[@role='button']//span[text()='Save']")
	private WebElement clickSave;

	public OperaCloud_ManageScheduledReportsPage clickOnSaveButton() throws InterruptedException, IOException {
		try {
			clickSave.click();
			Thread.sleep(5000);
			reportStep("clicked on save button successfully", "pass");
		} catch (Exception e) {
			reportStep("Click on save button is unsuccessful", "fail");
		}
		return new OperaCloud_ManageScheduledReportsPage(driver,node);
	}
	
	
	@FindBy(xpath = "//a//span[text()='Select']")
	private WebElement clickSelect;

	public OperaCloud_ScheduledReportsPage clickOnSelectReport() throws InterruptedException, IOException {
		try {
			clickSelect.click();
			Thread.sleep(5000);
			reportStep("clicked on select successfully", "pass");
		} catch (Exception e) {
			reportStep("Click on select is unsuccessful", "fail");
		}
		return this;
	}
	
	

	@FindBy(xpath = "//span[text()='Manage Scheduled Reports']")
	private WebElement clickManageScheduledReportsButton;

	public OperaCloud_ScheduledReportsPage clickonManageScheduledReportsButton()
			throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickManageScheduledReportsButton.click();
			Thread.sleep(5000);
			reportStep("click on search button successful", "pass");
		} catch (Exception e) {
			reportStep("click on search button unsuccessful", "fail");
		}
		return this;
	}

	//String xpath = "//span[text()='replacethisvalue']";

	/*
	 * public OperaCloud_ScheduledReportsPage clickOnReport(String reportName)
	 * throws IOException { try { Thread.sleep(5000);
	 * 
	 * WebElement rprtnme = findElement("xpath", generateDynamicXpath(xpath,
	 * reportName)); System.out.println(rprtnme); rprtnme.click();
	 * Thread.sleep(5000); reportStep("click on report is successful", "pass"); }
	 * catch (Exception e) { reportStep("click on report is unsuccessful", "fail");
	 * } return this; }
	 */
	
	String xpath = "//span[text()='replacethisvalue']";

	public OperaCloud_ScheduledReportsPage clickOnReport() throws InterruptedException, IOException 
	{
		try {
		Thread.sleep(5000);

		WebElement reprtnme = findElement("xpath", generateDynamicXpath(xpath, "Application Settings"));
		System.out.println(reprtnme);
		reprtnme.click();
		Thread.sleep(5000);
		reportStep("click on report  successful", "pass");
		}
		catch(Exception e)
		{
			reportStep("click on report  unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Email']")
	private WebElement clickEmailLink;

	public OperaCloud_ScheduledReportsPage clickOnEmailLink() throws IOException {
		try {
			clickEmailLink.click();
			Thread.sleep(3000);
			reportStep("click on email link successful", "pass");

		} catch (Exception e) {
			reportStep("click on email link unsuccessful", "fail");

		}
		return this;
	}

	@FindBy(xpath = "//input[@placeholder='Multiple email addresses separated by comma or semi-colon']")
	private WebElement emailAddress;

	public OperaCloud_ScheduledReportsPage enterEmailAddress(String email) throws IOException {
		try {
			emailAddress.sendKeys(email);
			reportStep("email address entered successfully", "pass");
		} catch (Exception e) {
			reportStep("Email address is not entered successfully", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//label[text()='File Format']//following::select")
	private WebElement fileFormat;

	public OperaCloud_ScheduledReportsPage selectFileFormat(String format) throws IOException {
		try {
			Select sel = new Select(fileFormat);
			sel.selectByVisibleText(format);
			Thread.sleep(3000);
			reportStep("file format selected successfully", "pass");
		} catch (Exception e) {
			reportStep("file format not selected successfully", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//table//a[@role='button']//span[text()='Email']")
	private WebElement clickEmailButton;

	public OperaCloud_ScheduledReportsPage clickOnEmailButton() throws IOException {
		try {
			Thread.sleep(3000);
			System.out.println(clickEmailButton + "xpath");
			Actions act = new Actions(driver);
			act.click(clickEmailButton).build().perform();

			reportStep("clicked on email button successfully", "pass");
		} catch (Exception e) {
			reportStep("click on email button is unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//div[text()='Job Status']")
	private WebElement validateEmailAlert;

	public OperaCloud_ScheduledReportsPage validationOfEmailAlert() throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			if (wait.until(ExpectedConditions.alertIsPresent()) == null)
				System.out.println("Alert is not present");
			Thread.sleep(3000);
			String alrt = validateEmailAlert.getText();
			System.out.println(alrt);
			String alert = driver.switchTo().alert().getText();
			System.out.println(alert);
			Assert.assertEquals(alert, "Job Status");
			reportStep("successfully validated email", "pass");
		} catch (Exception e) {
			reportStep("email validation failed", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[contains(text(),'Preview / Download')]")
	private WebElement clickPreviewOrDownloadButton;

	public OperaCloud_ScheduledReportsPage clickOnPreviewOrDownloadButton() throws IOException {
		try {
			clickPreviewOrDownloadButton.click();
			Thread.sleep(5000);
			reportStep("click on previewordownload button successful", "pass");
		} catch (Exception e) {
			reportStep("click on previewordownload unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[contains(text(),'Download As...')]")
	private WebElement clickDownloadAsButton;

	public OperaCloud_ScheduledReportsPage clickOnDownloadAsButton() throws IOException {
		try {
			clickDownloadAsButton.click();
			Thread.sleep(5000);
			reportStep("click on downloadas button successful", "pass");
		} catch (Exception e) {
			reportStep("click on downloadas button unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//label[contains(text(),'HTML')]")
	private WebElement checkHTMLRadioButton;

	public OperaCloud_ScheduledReportsPage clickOnHTMLRadioButton() throws IOException {
		try {
			checkHTMLRadioButton.click();
			Thread.sleep(5000);
			reportStep("check  HTML radio button  successful", "pass");
		} catch (Exception e) {
			reportStep("check  HTML radio button  unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Download']")
	private WebElement clickDownloadButton;

	public OperaCloud_ScheduledReportsPage clickOnDownloadButton() throws IOException {
		try {
			clickDownloadButton.click();
			Thread.sleep(5000);
			reportStep("click on download button successful", "pass");
		} catch (Exception e) {
			reportStep("click on download button unsuccessful", "fail");
		}
		return this;
	}

	// todo
	@FindBy(xpath = "//span[text()='New Report']")
	private WebElement clickSearchReport;

	public OperaCloud_CreateReportsPage clickOnSearchReport() throws InterruptedException, IOException {
		try {
			clickSearchReport.click();
			Thread.sleep(5000);
			reportStep("click on search report successful", "pass");
		} catch (Exception e) {
			reportStep("click on search report unsuccessful", "fail");
		}
		return new OperaCloud_CreateReportsPage(driver, node);
	}

}
