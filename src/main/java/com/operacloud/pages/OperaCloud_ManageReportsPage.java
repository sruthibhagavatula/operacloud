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

public class OperaCloud_ManageReportsPage extends OperaCloudSeleniumActions {

	public OperaCloud_ManageReportsPage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		initPage();
		// to do, verify title of the login page

	}

	@FindBy(xpath = "//h1[text()='Manage Reports']")
	private WebElement verifyPageTitle;

	public OperaCloud_ManageReportsPage verificationOfManageReportsPageTitle()
			throws InterruptedException, IOException {
		try {
			String actualPageTitle = verifyPageTitle.getText();
			Assert.assertEquals(actualPageTitle, "Manage Reports");
			reportStep("You are here on Manage reports page", "pass");
		} catch (Exception e) {
			reportStep("oops something wrong!!!!! you are not on manage reports page", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='New Report']")
	private WebElement clickNewReport;

	public OperaCloud_CreateReportsPage clickOnNewReport() throws InterruptedException, IOException {
		try {
			clickNewReport.click();
			Thread.sleep(5000);
			reportStep("successfully clicked on new report ", "pass");
		} catch (Exception e) {
			reportStep("click on new report unsuccessful", "fail");
		}
		return new OperaCloud_CreateReportsPage(driver, node);
	}

	@FindBy(xpath = "//input[contains(@id,'reportName')]")
	private WebElement enterReportName;

	public OperaCloud_ManageReportsPage enterTheReportName(String reportName) throws InterruptedException, IOException {
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

	public OperaCloud_ManageReportsPage clickOnSearchAndSelectButton() throws InterruptedException, IOException {
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

	public OperaCloud_ManageReportsPage selectReportGroup(String grpval) throws InterruptedException, IOException {
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

	public OperaCloud_ManageReportsPage clickOnPropName() throws InterruptedException, IOException {
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

	public OperaCloud_ManageReportsPage clickOnSelectButton() throws InterruptedException, IOException {
		try {
			clickSelectButton.click();
			Thread.sleep(5000);
			reportStep("clicked select button successfully", "pass");
		} catch (Exception e) {
			reportStep("click on select button unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//div[contains(@id,'advncd_srch_btn')]")
	private WebElement clickSearchButton;

	public OperaCloud_ManageReportsPage clickOnSearchButton() throws InterruptedException, IOException {
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

	@FindBy(xpath = "//span[text()='Manage Scheduled Reports']")
	private WebElement clickManageScheduledReportsButton;

	public OperaCloud_ManageScheduledReportsPage clickonManageScheduledReportsButton()
			throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickManageScheduledReportsButton.click();
			Thread.sleep(5000);
			reportStep("click on Manage Scheduled button successfull", "pass");
		} catch (Exception e) {
			reportStep("click on Manage Scheduled button unsuccessful", "fail");
		}
		return new OperaCloud_ManageScheduledReportsPage(driver,node);
	}

	String xpath = "//span[text()='replacethisvalue']";

	public OperaCloud_ManageReportsPage clickOnReport(String reportName) throws IOException {
		try {
			Thread.sleep(8000);

			WebElement rprtnme = findElement("xpath", generateDynamicXpath(xpath, reportName));
			rprtnme.click();
			Thread.sleep(5000);
			reportStep("click on report is successful", "pass");
		} catch (Exception e) {
			reportStep("click on report is unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Email']")
	private WebElement clickEmailLink;

	public OperaCloud_ManageReportsPage clickOnEmailLink() throws IOException {
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

	public OperaCloud_ManageReportsPage enterEmailAddress(String email) throws IOException {
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

	public OperaCloud_ManageReportsPage selectFileFormat(String format) throws IOException {
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

	public OperaCloud_ManageReportsPage clickOnEmailButton() throws IOException {
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

	public OperaCloud_ManageReportsPage validationOfEmailAlert() throws IOException {
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

	public OperaCloud_ManageReportsPage clickOnPreviewOrDownloadButton() throws IOException {
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

	public OperaCloud_ManageReportsPage clickOnDownloadAsButton() throws IOException {
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

	public OperaCloud_ManageReportsPage clickOnHTMLRadioButton() throws IOException {
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

	public OperaCloud_ManageReportsPage clickOnDownloadButton() throws IOException {
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
