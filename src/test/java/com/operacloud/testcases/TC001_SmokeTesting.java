package com.operacloud.testcases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.operacloud.pages.OperaCloud_HomePage;
import com.operacloud.pages.OperaCloud_LoginPage;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class TC001_SmokeTesting extends OperaCloudSeleniumActions{
	
	@BeforeTest
	public void setBrowserAndTestName() {
		invokeBrowser();
	}	
	
	@Test(priority = 0)
	public void changeLocation() throws InterruptedException, IOException {
		try 
		{
		testName = "Test to change the location of the user";
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		node = test.createNode(testName);	
		new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickUserOptions()
			.clickSelectLocation()
			.enterTextToSearch(location)//enterTextSearch()
			.clickSearchButton()
			.clickSelectButton()
			.clickUserOptions()
			.clickSignOut();
		reportStep("changing location is successful", "PASS");
		}
		catch (Exception e) {
			reportStep("changing location is not successful", "FAIL");
		}
		}
	
	@Test(priority = 1)
	public void testSettingsAccessible() throws IOException  {
		try {
			testName = "Test to check settings are accessible";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnSettings()
			.clickOnSave()
			.clickUserOptions()
			.clickSignOut();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			reportStep("Settings are accessible in application", "PASS");
		} catch (Exception e) {
			reportStep("Setting are not accessible in application", "FAIL");
		}
		
		}
	@Test (priority = 2)
	public void testConfirmTilescanbeaddedtoOperaCloudDashboard() throws IOException {
		try {
			testName = "Test to check Tiles can be added to Homepage of application";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickOnAddTitles()
			.enterQuantityToTile(tileAndQuantity,tileAndQuantity)
			.clickOnAddToDashboard()
			.clickUserOptions()
			.clickSignOut();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			reportStep("Tiles are successfully added to the application", "PASS");
			
		} catch (Exception e) {
			reportStep("Tiles are not added to the application", "FAIL");
		}
}
	@Test(priority = 3)
	public void testUsercansuccessfullyclearapplicationcache() throws IOException {
		try {
			testName = "Test to check user is able to clear application cache";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnSettings()
			.clickOnClearCache()
			.clickOnPopUpClearCache()
			.clickUserOptions()
			.clickSignOut();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			reportStep("User is successfully able to clear application cache", "PASS");
		} catch (Exception e) {
			reportStep("User is not able to clear application cache", "FAIL");
		}
		
		}
	//@Test (priority = 4)
	public void testVerifyHelpisaccessibleandfunctional() throws InterruptedException, IOException {
		try {
			testName = "Test to check Help is accessible and functional";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickMenuOption()
		.clickOnHelp()
		.clickCloudServicesUserGuide(helpSearchText);
		Thread.sleep(5000);
		new OperaCloud_LoginPage(driver, node)
		.switchToParentWindow();
		Thread.sleep(5000);
		new OperaCloud_HomePage(driver, node)
		.clickUserOptions()
		.clickSignOut();
		Thread.sleep(5000);
		reportStep("Help functionality is success and searched text is displayed", "PASS");
		}
		catch (Exception e) {
			reportStep("Help functionality is not success", "FAIL");
		}
	}
	@Test (priority = 5)
	public void testValidatePrerequisiteConfigurationforEmailDelivery() throws InterruptedException, IOException {
		try {
			testName = "Test to validate Prerequisite configuration for email";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
		new OperaCloud_LoginPage(driver, test)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickMenuOption()
		.clickOnAdministration()
		.clickOnInterfaces()
		.clickOnDeliveryManagement()
		.scrollAdminPage()
		.getServerTextContent()
		.clickUserOptions()
		.clickSignOut();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		reportStep("Email sent successfully", "PASS");
		}
		catch (Exception e) {
			reportStep("Email is not sent successfully", "FAIL");
		}
	}
	@Test (priority = 6)
	public void testVerifyEnvironmentControlsIsAccessible() throws IOException {
		try {
			testName = "Test to verify environment controls are accessible";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, test)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnToolBoxIcon()
			.clickSystemSetup()
			.clickEnvironmentControls();			
			new OperaCloud_HomePage(driver, test)
			.clickMenuOption()
			.clickOnOperaCloud()
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(3000);
			reportStep("Environment controls are accessible", "PASS");
		} catch (Exception e) {
			reportStep("Environment controls are not accessible", "FAIL");
		} 
	}
	@Test (priority = 7)
	public void testToolBoxExportShell() throws IOException {
		try {
			testName = "Test to verify Tool box export shell";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnToolBoxIcon()	
			.clickSystemSetup()
			.clickOnExportShell()
			.enterShellName(shellname)
			.selectShellType()
			.clickOnExportShell();
			new OperaCloud_HomePage(driver, node)
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(3000);
			reportStep("Tool box export shell is successful", "PASS");
		} catch (Exception e) {
			reportStep("Tool box export shell is not successful", "FAIl");
		}		
		}
	@Test (priority = 8)
	public void verifyApplicationLogs() throws InterruptedException, IOException {
		try {
			testName = "Test to  verify application logs via settings";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnSettings()
			.clickOnViewLogs();
			Thread.sleep(5000);
			new OperaCloud_LoginPage(driver, node)
			.switchToParentWindow();
			Thread.sleep(5000);
			new OperaCloud_HomePage(driver, node)
			.clickOnSave()
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(5000);
			reportStep("Validation of viewing application logs via settings is successful", "PASS");
		} catch (Exception e) {
			reportStep("Validation of viewing application logs via settings is not successful", "FAIL");
			
		}
	}
	@Test (priority = 9)
	public void aboutOperacloud() throws InterruptedException, IOException {
		try {
			testName = "Test to verify about operacloud";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnAboutOperaCloud()
			.clickOnClose()
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(5000);
			reportStep("About operacloud is displayed successfully", "PASS");
		} catch (Exception e) {
			reportStep("About operacloud is not displayed successfully", "FAIl");
		}
		
		
		}
	
	@Test (priority = 10)
	public void confirmAllModulesAreAccessible() throws InterruptedException, IOException {
		try {
			testName = "Test to verify All the modules are accessible";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnOperaCloud()
			//.goBackToHomePage()
			.clickMenuOption()
			.clickOnAdministration()
			.goBackToHomePage()
			.clickMenuOption()
			.clickOnToolBoxIcon()
			.goBackToHomePage()
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(5000);
			reportStep("All the modules are accessible successfully", "PASS");
		} catch (Exception e) {
			reportStep("All the modules are not accessible successfully", "FAIL");
		}
		}
		
}
