package com.operacloud.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class OperaCloud_ManageReservationPage extends OperaCloudSeleniumActions {

	public OperaCloud_ManageReservationPage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		initPage();
		
	}
	@FindBy(xpath="//div[@title='Manage Reservation']")
	private WebElement verifyTitle;
	public OperaCloud_ManageReservationPage verifyManageReservationPageTitle() throws InterruptedException, IOException
	{
		try {
		String titleText=verifyTitle.getText();
		Assert.assertEquals("Manage Reservation", titleText);
		reportStep("You are on manage reservation page", "pass");
		}
		catch(Exception e)
		{
			reportStep("oops!!! you are not on manage reservation page", "fail");
		}
		return this;
	}
		
}