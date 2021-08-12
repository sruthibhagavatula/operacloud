package com.operacloud.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.operacloud.pages.OperaCloud_CreateGuestProfilePage;
import com.operacloud.pages.OperaCloud_HomePage;
import com.operacloud.pages.OperaCloud_LoginPage;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class TC004_OperaCloudProfileTestCases extends OperaCloudSeleniumActions {

	
	@BeforeTest
	public void setBrowserAndTestName() {
		
		invokeBrowser();
	}
	
	@Test(priority=0)
	public void createProfile() throws InterruptedException, IOException {
		try {
			testName = "Create profile";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			String address = OperaCloud_CreateGuestProfilePage.address;
			String city = OperaCloud_CreateGuestProfilePage.city;
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnOperaCloud()
			.clickOnClientRelations()
			.clickOnProfiles()
			.clickOnManageProfile()
			.verifyManageProfileTitle()
			.clickOnCreateGuestProfile()
			.verifyPageTitle()
			.enterProfileName()
			.clickOnEmailTypeSearch()
			.enterEmailTextInType(emailType)
			.clickSearchAfterSelectingEmailType()
			.clickOnEmailType()
			.clickOnEmailSelect()
			.enterCommunicationValueForEmailId()
			.clickOnMobileTypeSearch()
			.enterMobileTextInType(mobileType)
			.clickSearchAfterSelectingMobileType()
			.clickOnMobileType()
			.clickOnMobileSelect()
			.enterCommunicationValueForMobile()
			.clickOnAddressTypeSearchIcon()
			.enterAddressTypeInSearchBox()
			.clickOnSearchButtonOnAddressSearch()
			.clickOnSearchedAddressType()
			.clickOnSelectButtonOnAddressSearch()
			.enterAddress1(address)
			.enterAddress2(address)
			.enterAddress3(address)
			.enterAddress4(address)
			.enterCity(city)
			.clickOnSaveProfile();
			new OperaCloud_HomePage(driver, node)
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(10000);
		} catch (Exception e) {
			reportStep("Profile creation is not successful", "FAIL");
		}
		
		
		}
	
	@Test(priority=1 , dependsOnMethods = "createProfile")
	public void basicSearchProfile() throws InterruptedException, IOException {
		try {
			testName = "Basic profile Search";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnOperaCloud()
			.clickOnClientRelations()
			.clickOnProfiles()
			.clickOnManageProfile()
			.verifyManageProfileTitle()
			.enterProfileNameToDoBasicSearch()
			.clickOnSearchButton();
			//.validationOfProfileCreated();
			new OperaCloud_HomePage(driver, node)
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(10000);
			
		} catch (Exception e) {
			reportStep("Basic profile search is not successful", "FAIL");
		}
		
		
		}
	
	@Test(priority=2,dependsOnMethods = "createProfile" )
	public void advancedSearchProfile() throws InterruptedException, IOException {
		try {
			testName = "Advanced profile Search";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnOperaCloud()
			.clickOnClientRelations()
			.clickOnProfiles()
			.clickOnManageProfile()
			.verifyManageProfileTitle()
			.clickOnAdvancedSearchLink()
			.enterProfileNameToDoAdvancedSearch()
			.clickOnSearchButton()
			.validationOfProfileCreated();
			new OperaCloud_HomePage(driver, node)
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(10000);
			
		} catch (Exception e) {
			reportStep("Advanced profile search is not successful", "FAIL");
		}
		
		
		}
	

	@Test(priority=3,dependsOnMethods = "createProfile")
	public void addAttachmentTxtFile() throws InterruptedException, IOException {
		try {
			testName = "Add Text file as attachment to created profile";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnOperaCloud()
			.clickOnClientRelations()
			.clickOnProfiles()
			.clickOnManageProfile()
			.verifyManageProfileTitle()
			.enterProfileNameToDoBasicSearch()
			.clickOnSearchButton()
			.clickOnIWantToOption()
			.clickOnAttachments()
			.clickOnNewAttachments()
			.clickOnChooseFileToAttachTextFile()
			.enterTheFileName(nameOfFile)
			.enterTheFileDescription(nameOfFile)
			.clickUploadAttachmentSave()
			.clickAttachmentClose()
			.validationOfAttachments();
			new OperaCloud_HomePage(driver, node)
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(10000);
			
		} catch (Exception e) {
			reportStep("Adding of Text file as attachment to profile is not successful", "FAIL");
		}
		
		
		}
	
	@Test(priority=4 )//,dependsOnMethods = "createProfile")
	public void addAttachmentImageFile() throws InterruptedException, IOException {
		try {
			testName = "Add Image file as attachment to created profile";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnOperaCloud()
			.clickOnClientRelations()
			.clickOnProfiles()
			.clickOnManageProfile()
			.verifyManageProfileTitle()
			.enterProfileNameToDoBasicSearch()
			.clickOnSearchButton()
			.clickOnIWantToOption()
			.clickOnAttachments()
			.clickOnNewAttachments()
			.clickOnChooseFileToAttachImageFile()
			.enterTheFileName(nameOfImageFile)
			.enterTheFileDescription(nameOfImageFile)
			.clickUploadAttachmentSave()
			.clickAttachmentClose()
			.validationOfAttachments();
			new OperaCloud_HomePage(driver, node)
			.clickUserOptions()
			.clickSignOut();
			Thread.sleep(10000);
			
		} catch (Exception e) {
			reportStep("Adding of Image file as attachment to profile is not successful", "FAIL");
		}
		
		
		}
	
}