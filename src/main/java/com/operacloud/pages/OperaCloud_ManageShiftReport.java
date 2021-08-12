package com.operacloud.pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;
import net.bytebuddy.utility.RandomString;

public class OperaCloud_ManageShiftReport extends OperaCloudSeleniumActions {
	public static String repname = RandomString.make(5).toUpperCase();
	public OperaCloud_ManageShiftReport(ChromeDriver driver, ExtentTest node) {
		// to do, verify title of the home page
		this.driver = driver;
		this.node = node;
		initPage();
	}

	@FindBy(xpath = "//h1[text()='Manage Shift Report']")
	private WebElement pageTitleText;

	public OperaCloud_ManageShiftReport verifyPageTitle() {
		String text = pageTitleText.getText();
		Assert.assertEquals(text, "Manage Shift Report");
		return this;

	}

	
	@FindBy(xpath = "//label[text()='Report Name']//following::input[@type='text']")
	private WebElement enterRepName;

	
	public OperaCloud_ManageShiftReport enterReportName() {
		
		try {
			Thread.sleep(5000);
			//wait.until(ExpectedConditions.visibilityOf(enterRepName));
			
			enterRepName.sendKeys("rep_"+repname);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
		
		@FindBy(xpath ="//label[text()='Display Name']//following::input[@id[contains(.,'it::content')]]")
		private WebElement displayName;
		public OperaCloud_ManageShiftReport enterDisplayname() {
			try {
				Thread.sleep(5000);
				displayName.sendKeys("rep_"+repname);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return this;
			
		}
		
		@FindBy(xpath ="//input[@placeholder='Filter']")
		private WebElement filterName;
		public OperaCloud_ManageShiftReport enterFilter(String reportName) {
			try {
				System.out.println(reportName);
				Thread.sleep(5000);
				filterName.sendKeys(reportName);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return this;
			
		}
		@FindBy(xpath="//span[text()='Available']//following::div//a//span[text()='Go']")
		private WebElement click1stGo;
		
		public OperaCloud_ManageShiftReport clickAvailableGo() {
			try {
				Thread.sleep(5000);
				click1stGo.click();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this;
		}
		
		@FindBy(xpath="//div[@title='Add All']")
		private WebElement addAllTheReports;
		public OperaCloud_ManageShiftReport clickAddAllReports() {
			try {
				Thread.sleep(5000);
				addAllTheReports.click();
				Thread.sleep(5000);
				scrollPage();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this;
		}
		
		@FindBy(xpath="//a[@title='Clear Search']")
		private WebElement clearSearch;
		public OperaCloud_ManageShiftReport clickOnClearSearch() {
			try {
				Thread.sleep(5000);
				clearSearch.click();
				Thread.sleep(5000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this;
		}
		
		
		
		
		@FindBy(xpath="//a[@role='button']//following::span[text()='Save']")
		private WebElement clickSaveButton;
		public OperaCloud_ShiftReportsPage clickOnSaveButton() {
			try {
				Thread.sleep(5000);
				clickSaveButton.click();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return new OperaCloud_ShiftReportsPage(driver,node);
		}

		
			


}

