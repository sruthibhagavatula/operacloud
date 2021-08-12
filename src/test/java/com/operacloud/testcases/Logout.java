package com.operacloud.testcases;

import org.testng.annotations.Test;

import com.operacloud.pages.OperaCloud_LoginPage;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

import org.testng.annotations.Test;

import java.io.IOException;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Logout extends OperaCloudSeleniumActions {

	
	
	@Parameters("url")
	@BeforeTest
	public void setBrowserAndTestName(String url) {
		testName = "logout";
		invokeBrowser();
		

	}

	@Parameters({ "username", "password" })
	@Test
	public void testLogin(String username, String password) throws InterruptedException, IOException {

		new OperaCloud_LoginPage(driver, node)
		.enterUsrname(username)
		.enterPasswd(password)
		.clickSignIn()
		.clickUserOptions()
		.clickSignOut();
	}
	@Parameters({"username","password"})
	@Test
	public void changeLocation(String username, String password) throws InterruptedException, IOException {
			new OperaCloud_LoginPage(driver, node)
			.enterUsrname(username)
			.enterPasswd(password)
			.clickSignIn()
			.clickUserOptions()
			.clickSelectLocation()
			.enterTextToSearch("RBEPROP")//enterTextSearch()
			.clickSearchButton()
			.clickSelectButton()
			.clickUserOptions()
			.clickSignOut();
		
		}

}
