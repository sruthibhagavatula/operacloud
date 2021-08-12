package com.operacloud.testcases;




import org.testng.annotations.Test;

import com.operacloud.pages.OperaCloud_LoginPage;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends OperaCloudSeleniumActions {

	//@BeforeTest
	public void setData() {
		testName = "Login";

	}

	//@Test(priority = 1)
	/*
	 * public void testLogin() throws InterruptedException {
	 * launchBrowser("chrome"); String url =
	 * "https://hru4-rbe-oc.oracleindustry.com/OPERA9/opera/operacloud"; // RBE
	 * launchWebApplication(url); new OperaCloud_LoginPage(driver, test)
	 * 
	 * .enterUsrname("rbechaadmin") .enterPasswd("Welcome123") .clickSignIn();
	 * 
	 * }
	 */
	@AfterTest
	public void checkDriver() {
		System.out.println(driver +"checking driver in after test annotaion");
	}
}
