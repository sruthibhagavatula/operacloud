package com.operacloud.testcases;




import org.testng.annotations.Test;

import com.operacloud.pages.OperaCloud_LoginPage;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC003_OperaCloudReservationTestCases extends OperaCloudSeleniumActions {

	
	@BeforeTest
	public void setBrowserAndTestName() {
		
		invokeBrowser();
	}
	
	@Test
	public void createReservation() throws InterruptedException {
		try {
			testName = "Create a reservation for 1 night";
			test = extent.createTest(testName, testDescription);
			test.assignCategory(testCategory);
			node = test.createNode(testName);
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickMenuOption()
			.clickOnOperaCloud()
			.clickOnBookings()
			.clickOnWalkInReservation()
			.verifyWalkInReservationPageTitle();
		} catch (Exception e) {
			System.out.println("Reservation creation is not successful");
		}
		
		
		}
}