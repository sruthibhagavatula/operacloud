package com.operacloud.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class OperaCloud_WalkInReservationPage extends OperaCloudSeleniumActions {

	public OperaCloud_WalkInReservationPage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		initPage();
		
	}
	@FindBy(xpath="//div[@title='Walk In Reservation']")
	private WebElement verifyTitle;
	public OperaCloud_WalkInReservationPage verifyWalkInReservationPageTitle() throws InterruptedException, IOException
	{
		try {
		String titleText=verifyTitle.getText();
		Assert.assertEquals("Walk-In Reservation", titleText);
		reportStep("You are on Walk-In reservation page", "pass");
		}
		catch(Exception e)
		{
			reportStep("oops!!! you are not on Walk-In reservation page", "fail");
		}
		return this;
	}
	
	
}
