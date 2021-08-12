package com.operacloud.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.operacloud.pages.OperaCloud_HomePage;
import com.operacloud.pages.OperaCloud_LoginPage;
import com.operacloud.pages.OperaCloud_ManageShiftReport;
import com.operacloud.pages.OperaCloud_ShiftReportsPage;
import com.operacloud.pages.OperaCloud_ShiftReportsViewPage;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class TC002_OperaCloudReportsAndExportTestCases extends OperaCloudSeleniumActions {
	
	@BeforeTest
	public void setBrowserAndTestName() {
		// testName = "ConfirmSettingsAreAccessible";
		invokeBrowser();
	}

	// @Parameters({"username","password"})
	// @Test
	public void createCustomReportAndView(String username, String password) throws InterruptedException, IOException {
		testName = "Creating a Custom report";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);
		new OperaCloud_LoginPage(driver, node).enterUsrname(username).enterPasswd(password).clickSignIn()
				.clickOnReports().clickOnManageReports().clickOnNewReport().clickOnCustomizedReport()
				.enterTheReportName("sample_alert").clickAnywhereOnScreen().clickDownloadReportAndRename("alert")
				.chooseFileToUpload("alert.rtf").selectReportGroup();
		new OperaCloud_HomePage(driver, node).clickUserOptions().clickSignOut();
		Thread.sleep(5000);

	}

	
	@Test(priority = 0)
	public void downloadAReport() throws InterruptedException, IOException {
		try {
		testName = "Downloading a report";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);
		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickMenuOption()
		.clickOnOperaCloud()
		.clickOnReports()
		.clickOnManageReports()
		.selectReportGroup(reportgrp)
		.clickOnSearchButton()
		.clickOnReport(reportname2)
		.clickOnDownloadAsButton()
		.clickOnHTMLRadioButton()
		.clickOnDownloadButton()
		.switchWindow();
		Thread.sleep(5000);
		new OperaCloud_LoginPage(driver, node).switchToParentWindow();
		Thread.sleep(5000);
		new OperaCloud_HomePage(driver, node).clickUserOptions().clickSignOut();
		Thread.sleep(5000);
		reportStep("Downloading a report is successful", "PASS");
		}
		catch (Exception e) {
			reportStep("Downloading a report is not successful", "FAIL");	
		}
	}

	
	@Test(priority = 1)
	public void emailAReport() throws InterruptedException, IOException {
		testName = "email a report";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);

		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickMenuOption()
		.clickOnOperaCloud()
		.clickOnReports()
		.clickOnManageReports()
		.selectReportGroup(reportgrp)
		.clickOnSearchButton()
		.clickOnReport(reportname2)
		.clickOnEmailLink()
		.enterEmailAddress(emailid)
		.selectFileFormat(format)
		.clickOnEmailButton();
	  //.validationOfEmailAlert();
		Thread.sleep(5000);
		new OperaCloud_LoginPage(driver, node).switchToParentWindow();
		Thread.sleep(5000);
		new OperaCloud_HomePage(driver, node).clickUserOptions().clickSignOut();
		Thread.sleep(5000);

	}

	
	@Test(priority = 2)
	public void createShiftReport()
			throws InterruptedException, IOException {
		testName = "Creating a shift report";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);

		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickMenuOption()
	    .clickOnOperaCloud()
	    .clickOnReports()
	    .clickOnShiftReports()
	    .clickOnNewButton()
		.verifyPageTitle()
		.enterReportName()
		.enterDisplayname()
		.enterFilter(reportname1)
		.clickAvailableGo()
		.clickAddAllReports()
		.clickOnClearSearch()
		.enterFilter(reportname2)
		.clickAvailableGo()
		.clickAddAllReports()
		.clickOnSaveButton();
		String newlyCreatedReportName = "rep_" + OperaCloud_ManageShiftReport.repname;
		System.out.println(newlyCreatedReportName);

		new OperaCloud_ShiftReportsPage(driver, node)
		.searchCreatedReport(newlyCreatedReportName)
		.clickSearchButton()
				// .scrollShiftReportsPage()
		.clickOnReportName(newlyCreatedReportName)
		.clickOnActions()
		.clickOnViewOption()
		.clickOnProcess()
		.verifyTheStatusOfShiftReport();
		Thread.sleep(5000);
		new OperaCloud_LoginPage(driver, node).switchToParentWindow();
		Thread.sleep(5000);
		new OperaCloud_HomePage(driver, node).clickUserOptions().clickSignOut();
		Thread.sleep(5000);
		// .processReportsWithVerifyingStatus();

	}
	@Test(priority=3,dependsOnMethods ="createShiftReport")
	public void previewMultipleReports()
			throws InterruptedException, IOException {
		testName = "Previewing multiple reports";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);
		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickOnReports()
	    .clickOnShiftReports();
	    /*.clickOnNewButton()
	    .verifyPageTitle()
	    .enterReportName()
		.enterDisplayname()
		.enterFilter(reportname3)
		.clickAvailableGo()
		.clickAddAllReports()
		.clickOnSaveButton();*/
		String newlyCreatedReportName = "rep_" + OperaCloud_ManageShiftReport.repname;
		System.out.println(newlyCreatedReportName);
		new OperaCloud_ShiftReportsPage(driver, node)
		.searchCreatedReport(newlyCreatedReportName)
		.clickSearchButton()
		.clickOnReportName(newlyCreatedReportName)
		.clickOnActions()
		.clickOnViewOption()
		.clickOnProcess()
		.verifyTheStatusOfShiftReport();
		Thread.sleep(5000);
		new OperaCloud_LoginPage(driver, node).switchToParentWindow();
		Thread.sleep(5000);
		new OperaCloud_HomePage(driver, node).clickUserOptions().clickSignOut();
		Thread.sleep(5000);

	}
	
	@Test(priority = 4)
	public void createScheduledReport()
			throws InterruptedException, IOException {
		testName = "Creating a scheduled report";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);

		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickMenuOption()
		.clickOnOperaCloud()
		.clickOnReports()
		.clickOnManageReports()
		.clickonManageScheduledReportsButton()
		.verificationOfManageScheduledReportsPageTitle()
		.clickOnNewButton()
		.selectReportGroup(reportgrp)
		.clickOnSearchButton()
				// .clickOnExpandConfiguration()
		.clickOnReport()
		.clickOnSelectButton()
		.clickOnReportParametersNextButton()
		.clickOnRepeatIntervalsNextButton()
		.clickOnSaveButton()
		.clickOnActions()
		.clickOnRunReport()
		.clickOkButtonOnJobInformation()
		.clickOnViewExecutedReports()
		.clickOnActionsButtonOnExecutedReports()
		.clickOnPreview()
		.previewSuccessScheduledReport();
		Thread.sleep(5000);
		new OperaCloud_LoginPage(driver, node).switchToParentWindow();
		Thread.sleep(5000);
		new OperaCloud_HomePage(driver, node).clickUserOptions().clickSignOut();
		Thread.sleep(5000);

	}
	
	@Test(priority = 5)
	public void generateExport()	throws InterruptedException, IOException {
		testName = "Test to generate export";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);

		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickMenuOption()
		.clickOnOperaCloud()
		.clickOnMiscellaneous()
		.clickOnExports()
		.clickOnGeneral()
		.verifyTitleOfGeneralPage()
		.getExportTextAndSendItToDescription()
		.clickOnSearchToFetchDescription()
		.clickOnSearchedReportToExport()
		.clickOnActions()
		.clickOnExportData()
		.getInfoTextAndClickOk()
		.clickOnActions()
		.clickOnViewExports()
		.verifyTheStatusOfExport()
		.clickOnActions()
		.clickOnGenerateFile()
		.enterExportFileName()
		.enterExportFileNameExtension(fileNameExtension)
		.clickGenerateFileButton()
		.verifyGeneratedExportSuccessMessageAndClickOk()
		.clickRefreshButton()
		.clickOnViewDetails()
		.validateExportDetails()
		.downloadTheExport();
		Thread.sleep(5000);
		new OperaCloud_HomePage(driver, node)
		.clickUserOptions()
		.clickSignOut();
		Thread.sleep(5000);
		
		

	}


}
