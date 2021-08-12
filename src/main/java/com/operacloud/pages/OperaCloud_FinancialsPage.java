package com.operacloud.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class OperaCloud_FinancialsPage extends OperaCloudSeleniumActions {

	public OperaCloud_FinancialsPage(ChromeDriver driver, ExtentTest node) {
		// to do, verify title of the home page
		this.driver = driver;
		this.node = node;
		initPage();
	}

	// click on user property on top right corner of the page
	@FindBy(xpath = "//a[@title='Show User Options']")
	private WebElement userOptions;

	public OperaCloud_FinancialsPage clickUserOptions() throws IOException {
		try {
			Thread.sleep(5000);
			clickElement(userOptions);
			Thread.sleep(5000);
			reportStep("click on useroptions passed", "pass");

		} catch (Exception e) {
			reportStep("click on useroptions failed", "fail");
		}
		return this;
	}

	// click logout button
	@FindBy(xpath = "//a[contains(@href,'#')]/span[text()='Logout']")
	private WebElement logoutButton;

	public OperaCloud_LoginPage clickSignOut() throws InterruptedException, IOException {
		try {

			Thread.sleep(5000);
			logoutButton.click();
			reportStep("successfully logged out of application", "PASS");
			Thread.sleep(10000);
		} catch (Exception e) {
			System.out.println("signout button click failed");
		}
		return new OperaCloud_LoginPage(driver, node);
	}

	@FindBy(xpath = "//span[text()='Select Location']/parent::div/following-sibling::div/descendant::span[@title='Select Location']/span/span[2]")
	private WebElement clkSlctLocation;

	public OperaCloud_FinancialsPage clickSelectLocation() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(clkSlctLocation));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", clkSlctLocation);
			Thread.sleep(5000);
			reportStep("clicked on select location", "pass");
		} catch (Exception e) {
			reportStep("click on select location failed", "fail");
		}
		return this;
	}

	// enter text to search
	@FindBy(xpath = "//span[contains(@id,'odec_it') and @title]")
	private WebElement searchText;

	public OperaCloud_FinancialsPage enterTextToSearch(String searchTxt) throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			Actions act = new Actions(driver);
			Thread.sleep(5000);
			act.moveToElement(searchText).click().sendKeys(searchTxt).build().perform();
			Thread.sleep(5000);
			reportStep("search text entered successfully", "pass");
		} catch (Exception e) {
			reportStep("search text entry failed", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[(text()='Search')]")
	private WebElement searchButton;

	public OperaCloud_FinancialsPage clickSearchButton() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(searchButton);
			reportStep("successfully clicked on search button", "pass");
		} catch (Exception e) {
			reportStep("click on search button failed", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Select']")
	private WebElement selectButton;

	public OperaCloud_FinancialsPage clickSelectButton() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(selectButton);
			Thread.sleep(5000);
			reportStep("successfully clicked on select button", "pass");
		} catch (Exception e) {
			reportStep("click on select button unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//img[@title='Show Menu']")
	private WebElement clickMenu;

	public OperaCloud_FinancialsPage clickMenuOption() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			Actions act = new Actions(driver);
			act.moveToElement(clickMenu).click().build().perform();
			Thread.sleep(5000);
			reportStep("successfully clicked on menu", "pass");
		} catch (Exception e) {
			reportStep("click on menu is unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//a[@title='Settings']//span[text()='Settings']")
	private WebElement clickSettings;

	public OperaCloud_FinancialsPage clickOnSettings() throws InterruptedException, IOException {

		try {
			Thread.sleep(5000);
			clickElement(clickSettings);
			Thread.sleep(5000);
			reportStep("successfully clicked on settings", "pass");
		} catch (Exception e) {
			reportStep("click on settings unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//a[contains(@href,'#')]/span[text()='Save']")
	private WebElement clickSave;

	public OperaCloud_FinancialsPage clickOnSave() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(clickSave);
			Thread.sleep(5000);
			reportStep("successfully clicked on save", "pass");
		} catch (Exception e) {
			reportStep("click on save unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Clear Cache']")
	private WebElement clickClearCache;

	public OperaCloud_FinancialsPage clickOnClearCache() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(clickClearCache);
			Thread.sleep(5000);
			reportStep("click on clearcache is successfull", "pass");
		} catch (Exception e) {
			reportStep("click on clearcache is unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//a[@href='#']//span[text()='Clear Cache' and @class='xri']")
	private WebElement clickPopUpClearCache;

	public OperaCloud_FinancialsPage clickOnPopUpClearCache() throws InterruptedException, IOException {
		try {
			Thread.sleep(2000);
			clickElement(clickPopUpClearCache);
			Thread.sleep(5000);
			reportStep("click on clear cache successfull", "pass");
		} catch (Exception e) {
			reportStep("click on clearcache unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[(text()='Add New Tiles')]")
	private WebElement clickAddTitles;

	public OperaCloud_FinancialsPage clickOnAddTitles() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(clickAddTitles);
			Thread.sleep(5000);
			reportStep("successfully clicked on add tiles", "pass");
		} catch (Exception e) {
			reportStep("add tiles click unsuccesful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='View Logs']")
	private WebElement clickViewLogs;

	public OperaCloud_FinancialsPage clickOnViewLogs() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(clickViewLogs);
			Thread.sleep(5000);
			reportStep("click on view logs successful", "pass");
		} catch (Exception e) {
			reportStep("click on view logs unsuccessful ", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//div[text()='Settings']")
	private WebElement settingsTitle;

	public OperaCloud_FinancialsPage switchTabToSettings() throws InterruptedException, IOException {
		try {
			reportStep("click on settings successful ", "pass");
			Thread.sleep(5000);
			switchTab(settingsTitle);
			Thread.sleep(5000);
		} catch (Exception e) {
			reportStep("click on settings unsuccessful ", "fail");
		}
		return this;
	}

	String xpath = "//input[contains(@id,'adt:replacethisvalue:')]";

	public OperaCloud_FinancialsPage enterQuantityToTile(String tileNumber, String quantity)
			throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			WebElement addQuantity = findElement("xpath", generateDynamicXpath(xpath, tileNumber));
			enterTextToWebElement(addQuantity, quantity);
			Thread.sleep(5000);
			reportStep("enter quantity to tile successful ", "pass");
		} catch (Exception e) {
			reportStep("enter quantity to tile unsuccessful ", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Add to Dashboard']")
	private WebElement addToDashboard;

	public OperaCloud_FinancialsPage clickOnAddToDashboard() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(addToDashboard);
			Thread.sleep(5000);
			reportStep("click on add to dashboard successful", "pass");
		} catch (Exception e) {
			reportStep("click on add to dashboard unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//span[text()='Administration']")
	private WebElement clickAdministrationLink;

	public OperaCloud_AdministrationPage clickOnAdministration() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(clickAdministrationLink);
			Thread.sleep(5000);
			reportStep("click on administration link successful", "pass");
		} catch (Exception e) {
			reportStep("click on administration link unsuccessful", "fail");
		}
		return new OperaCloud_AdministrationPage(driver, node);
	}

	@FindBy(xpath = "//a[@title='Help']//span[text()='Help']")
	private WebElement clickHelp;

	public OperaCloud_HelpPage clickOnHelp() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(clickHelp);
			Thread.sleep(5000);
			reportStep("click on help link successful", "pass");
		} catch (Exception e) {
			reportStep("click on help link unsuccessful", "fail");
		}
		return new OperaCloud_HelpPage(driver, node);
	}

	@FindBy(xpath = "//span[text()='Toolbox']")
	private WebElement clickToolBoxIcon;

	public OperaCloud_ToolBoxPage clickOnToolBoxIcon() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickToolBoxIcon.click();
			Thread.sleep(5000);
			reportStep("click on toolbox page link is successful", "pass");
		} catch (Exception e) {
			reportStep("click on toolbox page link is unsuccessful", "fail");
		}
		return new OperaCloud_ToolBoxPage(driver, node);
	}

	@FindBy(xpath = "//a[@title='About OPERA Cloud']//span[text()='About OPERA Cloud']")
	private WebElement clickAboutOperaCloud;

	public OperaCloud_FinancialsPage clickOnAboutOperaCloud() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickAboutOperaCloud.click();
			Thread.sleep(5000);
			reportStep("click on about opera cloud link successful", "pass");
		} catch (Exception e) {
			reportStep("click on about operacloud link unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//a[@title='Close']")
	private WebElement clickClose;

	public OperaCloud_FinancialsPage clickOnClose() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickElement(clickClose);
			Thread.sleep(5000);
			reportStep("click on close successful", "pass");
		} catch (Exception e) {
			reportStep("click on close unsuccessful", "fail");
		}
		return this;
	}

	// click on show more
	@FindBy(xpath = "//div[@title='Show More']")
	private WebElement showMore;

	public OperaCloud_FinancialsPage clickShowMore() throws InterruptedException, IOException {
		try {
			clickElement(showMore);
			Thread.sleep(5000);
			reportStep("click on show more successful", "pass");
		} catch (Exception e) {
			reportStep("click on show more unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//a[text()='Reports']")
	private WebElement clickReports;

	public OperaCloud_FinancialsPage clickOnReports() throws InterruptedException, IOException {
		try {
			Thread.sleep(10000);
			clickReports.click();
			Thread.sleep(8000);
			reportStep("click on reports successful", "pass");
		} catch (Exception e) {
			reportStep("click on reports unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//td[text()='Shift Reports']")
	private WebElement clickShiftReports;

	public OperaCloud_ShiftReportsPage clickOnShiftReports() throws IOException {
		try {

			clickShiftReports.click();
			Thread.sleep(5000);
			reportStep("click on shift reports successful", "pass");
		} catch (Exception e) {
			reportStep("click on shift reports unsuccessful", "fail");
		}
		return new OperaCloud_ShiftReportsPage(driver, node);
	}

	@FindBy(xpath = "//span[text()='New']")
	private WebElement clickNewButton;

	public OperaCloud_ManageShiftReport clickOnNewButton() {
		return null;

	}

	@FindBy(xpath = "//td[text()='Manage Reports']")
	private WebElement clickManageReports;

	public OperaCloud_ManageReportsPage clickOnManageReports() throws IOException {
		try {
			Thread.sleep(5000);
			clickManageReports.click();
			Thread.sleep(5000);
			reportStep("click on manage reports successful", "pass");
		} catch (Exception e) {
			reportStep("click on manage reports unsuccessful", "fail");
		}
		return new OperaCloud_ManageReportsPage(driver, node);
	}

	@FindBy(xpath = "//a[contains(@id,'app_lnk')]//span[text()='OPERA Cloud']")
	private WebElement clickOperaCloud;

	public OperaCloud_FinancialsPage clickOnOperaCloud() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickOperaCloud.click();
			Thread.sleep(5000);
			reportStep("click on operacloud link successful", "pass");
		} catch (Exception e) {
			reportStep("click on operacloud link unsuccessful", "fail");
		}
		return new OperaCloud_FinancialsPage(driver, node);
	}

	@FindBy(xpath = "//a[text()='Bookings']")
	private WebElement clickBookings;

	public OperaCloud_FinancialsPage clickOnBookings() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickBookings.click();
			Thread.sleep(8000);
			reportStep("click on bookings successful", "pass");
		} catch (Exception e) {
			reportStep("click on bookings unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//td[text()='Reservations']")
	private WebElement clickReservations;

	public OperaCloud_FinancialsPage clickOnReservations() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickReservations.click();
			Thread.sleep(8000);
			reportStep("click on Reservations successful", "pass");
		} catch (Exception e) {
			reportStep("click on Reservations unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//a[text()='Client Relations']")
	private WebElement clickClientRelations;

	public OperaCloud_FinancialsPage clickOnClientRelations() throws InterruptedException, IOException {
		try {
			Thread.sleep(8000);
			clickClientRelations.click();
			Thread.sleep(8000);
			reportStep("click on client relations is successful", "pass");
		} catch (Exception e) {
			reportStep("click on client relations unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//tr[@role='menuitem']//following::td[text()='Profiles']")
	private WebElement clickProfiles;

	public OperaCloud_FinancialsPage clickOnProfiles() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickProfiles.click();
			Thread.sleep(3000);
			reportStep("click on profiles is successful", "pass");
		} catch (Exception e) {
			reportStep("click on profiles unsuccessful", "fail");
		}
		return this;
	}

	@FindBy(xpath = "//tr[@role='menuitem']//following::td[text()='Manage Profile']")
	private WebElement clickManageProfiles;

	public OperaCloud_ManageProfilePage clickOnManageProfile() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickManageProfiles.click();
			Thread.sleep(3000);
			reportStep("click on Manage profiles is successful", "pass");
		} catch (Exception e) {
			reportStep("click on Manage profiles unsuccessful", "fail");
		}
		return new OperaCloud_ManageProfilePage(driver,node);
	}

	@FindBy(xpath = "//td[text()='Manage Reservation']")
	private WebElement clickManageReservation;

	public OperaCloud_ManageReservationPage clickOnManageReservation() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickManageReservation.click();
			Thread.sleep(5000);
			reportStep("click on managereservation successful", "pass");
		} catch (Exception e) {
			reportStep("click on managereservation unsuccessful", "fail");
		}
		return new OperaCloud_ManageReservationPage(driver, node);
	}

	@FindBy(xpath = "//td[text()='Walk In Reservation']")
	private WebElement clickWalkInReservation;

	public OperaCloud_WalkInReservationPage clickOnWalkInReservation() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickWalkInReservation.click();
			Thread.sleep(5000);
			reportStep("click on walk-in-reservation successful", "pass");
		} catch (Exception e) {
			reportStep("click on walk-in-reservation  unsuccessful", "fail");
		}
		return new OperaCloud_WalkInReservationPage(driver, node);
	}
	
	
	@FindBy(xpath = "//a[text()='Miscellaneous']")
	private WebElement clickMiscellaneous;

	public OperaCloud_FinancialsPage clickOnMiscellaneous() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickMiscellaneous.click();
			Thread.sleep(5000);
			reportStep("click on Miscellaneous is successful", "PASS");
		} catch (Exception e) {
			reportStep("click on Miscellaneous is  unsuccessful", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath = "//div[@aria-label='Miscellaneous']//table//following::a[text()='Miscellaneous']//following::td[text()='Exports']")
	private WebElement clickExports;

	public OperaCloud_FinancialsPage clickOnExports() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickExports.click();
			Thread.sleep(5000);
			reportStep("click on Exports is successful", "PASS");
		} catch (Exception e) {
			reportStep("click on Exports is  unsuccessful", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//div[@aria-label='Miscellaneous']//table//following::a[text()='Miscellaneous']//following::td[text()='Exports']//following::td[text()='General']")
	private WebElement clickGeneral;
	public OperaCloud_MiscellaneousGeneralPage clickOnGeneral() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickGeneral.click();
			Thread.sleep(5000);
			reportStep("click on General is successful", "PASS");
		} catch (Exception e) {
			reportStep("click on General is  unsuccessful", "FAIL");
		}
		return new OperaCloud_MiscellaneousGeneralPage(driver, node);
	}
	
	@FindBy(linkText="Financials")
	private WebElement clickFinancials;
	
	public OperaCloud_FinancialsPage clickOnFinancials() throws InterruptedException, IOException {
		try {
			Thread.sleep(5000);
			clickGeneral.click();
			Thread.sleep(5000);
			reportStep("click on General is successful", "PASS");
		} catch (Exception e) {
			reportStep("click on General is  unsuccessful", "FAIL");
		}
		return new OperaCloud_FinancialsPage(driver, node);
	}
	
}
