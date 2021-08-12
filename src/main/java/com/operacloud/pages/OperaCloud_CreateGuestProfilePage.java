package com.operacloud.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

import net.bytebuddy.utility.RandomString;

public class OperaCloud_CreateGuestProfilePage extends OperaCloudSeleniumActions{
	public static String namePrefix="profile-";
	public static String profileName = namePrefix+RandomString.make(3).toUpperCase();
	public static String address = RandomString.make(5).toUpperCase();
	public static String city = RandomString.make(5).toUpperCase();
	public OperaCloud_CreateGuestProfilePage(ChromeDriver driver, ExtentTest node) {
		this.driver=driver;
		this.node=node;
		initPage();
	}
	
	@FindBy(xpath="//h1[text()='Create Guest Profile']")
	private WebElement createguestProfileTitle;
	
	public OperaCloud_CreateGuestProfilePage verifyPageTitle() {
		
		
		try {
			String title = createguestProfileTitle.getText();
			System.out.println(title);
			Assert.assertEquals("Create Guest Profile", title);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
		
	}
	
	@FindBy(xpath="//a[@title='Search and Select Language']")
	private WebElement propSearch;
	
	public OperaCloud_CreateGuestProfilePage clickPropSearch() {
		try {
			Thread.sleep(5000);
			propSearch.click();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return this;
	}
	
	@FindBy(xpath="//span[contains(text(),'RP03')]")
	private WebElement propSelect;
	
	public OperaCloud_CreateGuestProfilePage clickPropSelect() throws IOException {
		try {
			Thread.sleep(5000);
			propSelect.click();
			Thread.sleep(5000);
			reportStep("successfully selected prop", "Pass");
		} catch (InterruptedException e) {
			reportStep("couldnt select prop", "Fail");
		}
		
		
		return this;
	}
	
	@FindBy(xpath="//label[text()='Name']//following::input[contains(@id,'it3:odec')]")
	private WebElement name;
	
	public OperaCloud_CreateGuestProfilePage enterProfileName() throws IOException, InterruptedException
	{
		
		try {
			System.out.println(profileName);
			name.sendKeys(profileName);
			Thread.sleep(5000);
			scrollPage();
			Thread.sleep(5000);
			System.out.println("entered profile name successfully");
			reportStep("entered profile name successfully", "Pass");
		} catch (Exception e) {
			reportStep("profile name is not entered successfully" , "Fail");
		}
		return this;
		
	}
	
	@FindBy(xpath="//a[@title='Search and Select Communication Type']")
	private WebElement type;
	public OperaCloud_CreateGuestProfilePage clickOnEmailTypeSearch() throws IOException
	{
		try {
			Thread.sleep(5000);
			Actions act = new Actions(driver);
			act.click(type).build().perform();
			//type.click();
			reportStep("clicked on type search icon successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on type search icon unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath = "//input[contains(@placeholder,'Use (*)')]")
	private WebElement enterEmailText;
	
	public OperaCloud_CreateGuestProfilePage enterEmailTextInType(String emailtype) throws IOException
	{
		try {
			
			enterEmailText.sendKeys(emailtype);
			reportStep("entered Type as Email successfully", "Pass");
			
			
		} catch (Exception  e) {
			reportStep("unable to enter type as email ", "Fail");
		}
		
		return this;
		
	}
	
	
	@FindBy(xpath = "//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Communication Type']//following::input[@placeholder='Use (*) for wildcard search']")
	private WebElement enterMobileText;
	
	public OperaCloud_CreateGuestProfilePage enterMobileTextInType(String mobiletype) throws IOException
	{
		try {
			
			Thread.sleep(5000);
			//enterMobileText.sendKeys(mobiletype);
			Actions act = new Actions(driver);
			act.sendKeys(mobiletype).build().perform();
			
			reportStep("entered Type as Mobile successfully", "Pass");
			
			
			
		} catch (Exception e) {
			reportStep("unable to enter type as mobile ", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//a[@role='button']//span[text()='Search']")
	private WebElement clickSearch;
	
	public OperaCloud_CreateGuestProfilePage clickSearchAfterSelectingEmailType() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickSearch.click();
			reportStep("clicked on search button successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on search button unsuccessful", "Fail");
		}
		
		return this;
		
	}
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Communication Type']//following::div//span[text()='Search']")
	private WebElement clickMobileSearch;
	
	public OperaCloud_CreateGuestProfilePage clickSearchAfterSelectingMobileType() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickMobileSearch.click();
			
			reportStep("clicked on search button successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on search button unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//td//span[text()='EMAIL']")
	private WebElement clickEmail;
	public OperaCloud_CreateGuestProfilePage clickOnEmailType() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickEmail.click();
			reportStep("clicked on email successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on email unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Communication Type']//following::div//span[text()='MOBILE']")
	private WebElement clickMobile;
	public OperaCloud_CreateGuestProfilePage clickOnMobileType() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickMobile.click();
			reportStep("clicked on Mobile successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on Mobile unsuccessful", "Fail");
		}
		
		return this;
		
	}
	@FindBy(xpath="//a//span[text()='Select']")
	private WebElement clickEmailSelect;
	public OperaCloud_CreateGuestProfilePage clickOnEmailSelect() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickEmailSelect.click();
			Thread.sleep(5000);
			reportStep("clicked on select button after selecting email successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on select button unsuccessful after selecting email", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Communication Type']//following::div//span[text()='Select']")
	private WebElement clickMobileSelect;
	public OperaCloud_CreateGuestProfilePage clickOnMobileSelect() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickMobileSelect.click();
			Thread.sleep(5000);
			reportStep("clicked on select button successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on select button unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//td//span[text()='MOBILE']")
	private WebElement selectMobile;
	public OperaCloud_CreateGuestProfilePage selectMobileType() throws IOException
	{
		try {
			Thread.sleep(3000);
			selectMobile.click();
			reportStep("clicked on Mobile option successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on Mobile option unsuccessful", "Fail");
		}
		
		return this;
		
	}
	@FindBy(xpath="//input[contains(@id,'tit19:odec')]")
	private WebElement communicationValueEmailID;
	public OperaCloud_CreateGuestProfilePage enterCommunicationValueForEmailId() throws IOException
	{
		try {
			Thread.sleep(3000);
			communicationValueEmailID.sendKeys("abc@invalid.com");
			Thread.sleep(5000);
			reportStep("Entered email id successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("Email id was not entered successfully", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::a[@title='Search and Select Communication Type']")
	private WebElement mobileTypeSearchIcon;
	public OperaCloud_CreateGuestProfilePage clickOnMobileTypeSearch() throws IOException
	{
		try {
			Thread.sleep(3000);
			mobileTypeSearchIcon.click();
			reportStep("clicked search icon for Mobile option successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on search icon for Mobile option unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td[count(//th//span[text()='Communication Value']//ancestor::th/preceding-sibling::th)+1]//input")
	private WebElement communicationValueMobile;
	
	
	public OperaCloud_CreateGuestProfilePage enterCommunicationValueForMobile() throws IOException
	{
		try {
			Thread.sleep(3000);
			communicationValueMobile.sendKeys("2312321312");
			Thread.sleep(5000);
			reportStep("Entered mobile number successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("mobile number is not entered successfully", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//label[text()='Address Type']//following::span//a[@title='Search and Select Address Type']")
	private WebElement addressTypeSearchIcon;
	
	public OperaCloud_CreateGuestProfilePage clickOnAddressTypeSearchIcon() throws IOException
	{
		try {
			Thread.sleep(3000);
			addressTypeSearchIcon.click();
			Thread.sleep(5000);
			reportStep("click on Address Type Search icon successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on Address Type Search icon is unsuccessfully", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Address Type']//following::input[@placeholder='Use (*) for wildcard search']")
	private WebElement addressTypeText;
	public OperaCloud_CreateGuestProfilePage enterAddressTypeInSearchBox() throws IOException
	{
		try {
			Thread.sleep(3000);
			addressTypeText.sendKeys("Home");
			Thread.sleep(5000);
			reportStep("Entered Home as search criteria in address type search box", "Pass");
		} catch (InterruptedException e) {
			reportStep("enter of Home as search criteria in address type search box is unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Address Type']//following::div//span[text()='Search']")
	private WebElement clickSearchButton;
	public OperaCloud_CreateGuestProfilePage clickOnSearchButtonOnAddressSearch() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickSearchButton.click();
			Thread.sleep(5000);
			reportStep("successfully clicked on searchButton on Address Search", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on search button on address search is unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Address Type']//following::div//span[text()='HOME']")
	private WebElement clickSelectedAddressType;
	public OperaCloud_CreateGuestProfilePage clickOnSearchedAddressType() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickSelectedAddressType.click();
			Thread.sleep(5000);
			reportStep("successfully clicked on searchButton on Address Search", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on search button on address search is unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//table[@_selstate]//tr//following-sibling::tr//td//following::div[text()='Search and Select Address Type']//following::div//span[text()='Select']")
	private WebElement clickSelectButtonAddressType;
	
	public OperaCloud_CreateGuestProfilePage clickOnSelectButtonOnAddressSearch() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickSelectButtonAddressType.click();
			Thread.sleep(5000);
			reportStep("successfully clicked on select Button on Address Search", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on select button on address search is unsuccessful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//div[@data-ode-fl-nm='AddressCommunicationViewEdit']//following::span//label[text()='Address 1']//following::input")
	private WebElement enterAdd1;
	
	public OperaCloud_CreateGuestProfilePage enterAddress1(String add) throws IOException
	{
		try {
			Thread.sleep(3000);
			enterAdd1.sendKeys(add);
			Thread.sleep(5000);
			reportStep("successfully added address1", "Pass");
		} catch (InterruptedException e) {
			reportStep("Adding address1 isn't successful", "Fail");
		}
		
		return this;
		
	}
	@FindBy(xpath="//div[@data-ode-fl-nm='AddressCommunicationViewEdit']//following::span//label[text()='Address 2']//following::input")
	private WebElement enterAdd2;
	
	public OperaCloud_CreateGuestProfilePage enterAddress2(String add) throws IOException
	{
		try {
			Thread.sleep(3000);
			enterAdd2.sendKeys(add);
			Thread.sleep(5000);
			reportStep("successfully added address2", "Pass");
		} catch (InterruptedException e) {
			reportStep("Adding address2 isn't successful", "Fail");
		}
		
		return this;
		
	}
	@FindBy(xpath="//div[@data-ode-fl-nm='AddressCommunicationViewEdit']//following::span//label[text()='Address 3']//following::input")
	private WebElement enterAdd3;
	
	public OperaCloud_CreateGuestProfilePage enterAddress3(String add) throws IOException
	{
		try {
			Thread.sleep(3000);
			enterAdd3.sendKeys(add);
			Thread.sleep(5000);
			reportStep("successfully added address3", "Pass");
		} catch (InterruptedException e) {
			reportStep("Adding address3 isn't successful", "Fail");
		}
		
		return this;
		
	}
	@FindBy(xpath="//div[@data-ode-fl-nm='AddressCommunicationViewEdit']//following::span//label[text()='Address 4']//following::input")
	private WebElement enterAdd4;
	
	public OperaCloud_CreateGuestProfilePage enterAddress4(String add) throws IOException
	{
		try {
			Thread.sleep(3000);
			enterAdd4.sendKeys(add);
			Thread.sleep(5000);
			reportStep("successfully added address4", "Pass");
		} catch (InterruptedException e) {
			reportStep("Adding address4 isn't successful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//div[@data-ode-fl-nm='AddressCommunicationViewEdit']//following::span//label[text()='City']//following::input")
	private WebElement entercity;
	
	public OperaCloud_CreateGuestProfilePage enterCity(String city) throws IOException
	{
		try {
			Thread.sleep(3000);
			entercity.sendKeys(city);
			Thread.sleep(5000);
			scrollPage();
			reportStep("successfully added city", "Pass");
		} catch (InterruptedException e) {
			reportStep("Adding city isn't successful", "Fail");
		}
		
		return this;
		
	}
	
	@FindBy(xpath="//a[@role='button']//span[text()='Save']")
	private WebElement clickProfileSave;
	public OperaCloud_ManageProfilePage clickOnSaveProfile() throws IOException
	{
		try {
			Thread.sleep(3000);
			clickProfileSave.click();
			Thread.sleep(15000);
			reportStep("successfully saved the profile", "Pass");
		} catch (InterruptedException e) {
			reportStep("unable to save the profile", "Fail");
		}
		
		return new OperaCloud_ManageProfilePage(driver,node);
		
	}
	
	
}
