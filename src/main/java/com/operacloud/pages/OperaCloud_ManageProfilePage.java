package com.operacloud.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

public class OperaCloud_ManageProfilePage extends OperaCloudSeleniumActions {

	public OperaCloud_ManageProfilePage(ChromeDriver driver, ExtentTest node) {
		this.driver = driver;
		this.node = node;
		initPage();
	}

	@FindBy(xpath = "//h1[text()='Manage Profile']")
	private WebElement verifyText;

	public OperaCloud_ManageProfilePage verifyManageProfileTitle() throws IOException {
		try {
			Thread.sleep(3000);
			String text = verifyText.getText();
			Thread.sleep(3000);
			Assert.assertEquals("Manage Profile", text, "page name didnt match");
			reportStep("Manage profile page title is as expected", "Pass");
		} catch (InterruptedException e) {
			reportStep("Manage profile page title is not as expected", "Fail");
		}
		return this;

	}

	@FindBy(xpath = "//a//following::span[text()='Create Guest Profile']")
	private WebElement clickCreateGuestProfile;

	public OperaCloud_CreateGuestProfilePage clickOnCreateGuestProfile() throws IOException {
		try {
			Thread.sleep(5000);
			clickCreateGuestProfile.click();
			Thread.sleep(3000);
			reportStep("successfully clicked on Create Guest Profile Success", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on Create Guest Profile failed", "Fail");
		}
		return new OperaCloud_CreateGuestProfilePage(driver, node);
	}

	
	
	  @FindBy(xpath	  ="//h2[text()='Search']//ancestor::table//parent::div//following-sibling::div//following::input[contains(@placeholder,'Profile Name')]"
	  ) private WebElement profileSearchBasic;
	  
	  public OperaCloud_ManageProfilePage enterProfileNameToDoBasicSearch() throws
	  IOException { try { Thread.sleep(5000);
	  profileSearchBasic.sendKeys(OperaCloud_CreateGuestProfilePage.profileName);
	  Thread.sleep(3000); reportStep("Basic Profile search is successful", "Pass");
	  } catch (InterruptedException e) {
	  reportStep("Unable to find the profile with given name", "Fail"); } return
	  this; }
	 
	 
	
	
	/*
	 * @FindBy(xpath =
	 * "//h2[text()='Search']//ancestor::table//parent::div//following-sibling::div//following::input[contains(@placeholder,'Profile Name')]"
	 * ) private WebElement profileSearchBasic;
	 * 
	 * public OperaCloud_ManageProfilePage enterProfileNameToDoBasicSearch() throws
	 * IOException { try { Thread.sleep(5000);
	 * profileSearchBasic.sendKeys("profile-6MI"); Thread.sleep(3000);
	 * reportStep("Basic Profile search is successful", "Pass"); } catch
	 * (InterruptedException e) {
	 * reportStep("Unable to find the profile with given name", "Fail"); } return
	 * this; }
	 */

	@FindBy(xpath="//h2[text()='Search']//ancestor::table//parent::div//following-sibling::div//following::a[@role='button']//span[text()='Search']")

	private WebElement searchButton;

	public OperaCloud_ManageProfilePage clickOnSearchButton() throws IOException {
		try {
			Thread.sleep(5000);
			searchButton.click();
			Thread.sleep(3000);
			reportStep("Successfully clicked on Search Button", "Pass");
		} catch (InterruptedException e) {
			reportStep("Unable to click on search button", "Fail");
		}
		return this;
	}

	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::span[text()='Name']//following::span[contains(text(),'profile')]")
	private WebElement profileText;
	
	public OperaCloud_ManageProfilePage validationOfProfileCreated() throws IOException {
		try {
			Thread.sleep(5000);
			String actualProfileText=profileText.getText();
			String expectedProfileText= OperaCloud_CreateGuestProfilePage.profileName;
			Assert.assertEquals(actualProfileText, expectedProfileText);
			Thread.sleep(3000);
			reportStep("Validation of Profile Search is successful", "Pass");
		} catch (InterruptedException e) {
			reportStep("Validation of Profile search failed", "Fail");
		}
		return this;
	}
	
	@FindBy(xpath="//h2[text()='Search']//ancestor::table//parent::div//following-sibling::div//following::span[text()='Go to Advanced Search']")
	private WebElement advancedSearchLink;
	
	public OperaCloud_ManageProfilePage clickOnAdvancedSearchLink() throws IOException {
		try {
			Thread.sleep(5000);
			advancedSearchLink.click();
			reportStep("click on advanced search link is successful", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on advanced search link failed", "Fail");
		}
		return this;
	}
	
	
	  @FindBy(
	  xpath="//h2[text()='Search']//ancestor::table//parent::div//following-sibling::div//following::input[contains(@placeholder,'Last / Account / Alternate')]"
	  ) 
	  private WebElement profileAdvancedSearch;
	  
	  public OperaCloud_ManageProfilePage enterProfileNameToDoAdvancedSearch() throws IOException 
	  { try 
	  {
		  Thread.sleep(5000);
	  profileAdvancedSearch.sendKeys(OperaCloud_CreateGuestProfilePage.profileName);
	  Thread.sleep(3000); 
	  reportStep("Advanced Profile search is successful", "Pass"); 
	  }
	  catch (InterruptedException e) {
	  reportStep("Unable to find the profile with given name", "Fail");
	  } 
	  return this;
	  }
	 
	/*
	 * @FindBy(
	 * xpath="//h2[text()='Search']//ancestor::table//parent::div//following-sibling::div//following::input[contains(@placeholder,'Last / Account / Alternate')]"
	 * ) private WebElement profileAdvancedSearch;
	 * 
	 * public OperaCloud_ManageProfilePage enterProfileNameToDoAdvancedSearch()
	 * throws IOException { try { Thread.sleep(5000);
	 * profileAdvancedSearch.sendKeys("profile-6MI"); Thread.sleep(3000);
	 * reportStep("Advanced Profile search is successful", "Pass"); } catch
	 * (InterruptedException e) {
	 * reportStep("Unable to find the profile with given name", "Fail"); } return
	 * this; }
	 */
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::span[text()='I Want To...']//following::a[@title='I Want To…']")
	private WebElement clickIWantTo;
	public OperaCloud_ManageProfilePage clickOnIWantToOption() throws IOException {
		try {
			Thread.sleep(5000);
			clickIWantTo.click();;
			Thread.sleep(3000);
			reportStep("click on I Want To is successful", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on I Want To is unsuccessful", "Fail");
		}
		return this;
	}
	
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::label[text()='Notifications']//following::span[contains(text(),'Attachments')]")
	private WebElement clickAttachments;
	
	public OperaCloud_ManageProfilePage clickOnAttachments() throws IOException {
		try {
			Thread.sleep(5000);
			clickAttachments.click();;
			Thread.sleep(3000);
			reportStep("click on attachments is successful", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on attachments is unsuccessful", "Fail");
		}
		return this;
	}
	
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::div[text()='Attachments']//following::span[text()='New']")
	private WebElement clickNew;
	
	public OperaCloud_ManageProfilePage clickOnNewAttachments() throws IOException {
		try {
			Thread.sleep(5000);
			clickNew.click();
			Thread.sleep(3000);
			reportStep("click on new attachments is successful", "Pass");
		} catch (InterruptedException e) {
			reportStep("click on new attachments is unsuccessful", "Fail");
		}
		return this;
	}
	
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::div[text()='Upload Attachment']//following::label[text()='Attachment']//following::input[contains(@id,'FileAttachInput')]")
	private WebElement clickChooseFile;
	
	public OperaCloud_ManageProfilePage clickOnChooseFileToAttachTextFile() throws IOException {
		try {
			Thread.sleep(5000);
			CreateFileAndWriteToFile();
			Thread.sleep(8000);
			clickChooseFile.sendKeys(textFilePath);
			Thread.sleep(3000);
			reportStep("file attached successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("file attached is unsuccessful", "Fail");
		}
		return this;
	}
	
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::div[text()='Upload Attachment']//following::label[text()='Name']//following::input")
	private WebElement enterFileName;
	
	public OperaCloud_ManageProfilePage enterTheFileName(String nameOfTheFile) throws IOException {
		try {
			Thread.sleep(15000);
			enterFileName.sendKeys(nameOfTheFile);
			Thread.sleep(10000);
			reportStep("Name of the file is entered successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("entering name of the file is unsuccessful", "Fail");
		}
		return this;
	}
	
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::div[text()='Upload Attachment']//following::label[text()='Description']//following::textarea")
	private WebElement enterFileDescription;
	
	public OperaCloud_ManageProfilePage enterTheFileDescription(String nameOfTheFile) throws IOException {
		try {
			Thread.sleep(10000);
			enterFileDescription.sendKeys(nameOfTheFile);
			Thread.sleep(10000);
			reportStep("Description of the file is entered successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("entering description of the file is unsuccessful", "Fail");
		}
		return this;
	}
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::div[text()='Upload Attachment']//following::a[@role='button']//span[text()='Save']")
	private WebElement clickSave;
	
	public OperaCloud_ManageProfilePage clickUploadAttachmentSave() throws IOException {
		try {
			Thread.sleep(10000);
			clickSave.click();
			Thread.sleep(10000);
			reportStep("successfully clicked save on upload attachment screen", "Pass");
		} catch (InterruptedException e) {
			reportStep("clicking save button in not successful on upload attachment screen", "Fail");
		}
		return this;
	}
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::div[text()='Attachments']//following::a[@title='Close']")
	private WebElement clickClose;
	
	public OperaCloud_ManageProfilePage clickAttachmentClose() throws IOException {
		try {
			Thread.sleep(5000);
			clickClose.click();
			Thread.sleep(5000);
			reportStep("successfully clicked close on attachment screen", "Pass");
		} catch (InterruptedException e) {
			reportStep("clicking close button in not successful on attachment screen", "Fail");
		}
		return this;
	}
	
	@FindBy(xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following-sibling::div//following::span[contains(text(),'Attachments')]")
	private WebElement validateAttachments;
	
	public OperaCloud_ManageProfilePage validationOfAttachments() throws IOException {
		try {
			Thread.sleep(5000);
			String attachmentsCount= validateAttachments.getText();
			attachmentsCount = attachmentsCount.replaceAll("\\D+","");
			int count = 0;
			try {
				count = Integer.parseInt(attachmentsCount);
				reportStep("there are " +count +" attachments attached to the profile", "pass");
			}
			catch( NumberFormatException nfe)
			{
				reportStep("there are no attachments attached to the profile", "fail");
			}
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			reportStep("clicking close button in not successful on attachment screen", "Fail");
		}
		return this;
	}
	
	/*
	 * @FindBy(
	 * xpath="//table[@_selstate]//parent::div//preceding-sibling::div[@role='row']//following::div[text()='Upload Attachment']//following::label[text()='Attachment']//following::input[contains(@id,'FileAttachInput')]"
	 * ) private WebElement clickChooseFile;
	 */
	
	public OperaCloud_ManageProfilePage clickOnChooseFileToAttachImageFile() throws IOException {
		try {
			Thread.sleep(5000);
			clickChooseFile.sendKeys(imageFilePath);
			Thread.sleep(3000);
			reportStep("Image attached successfully", "Pass");
		} catch (InterruptedException e) {
			reportStep("Image attached is unsuccessful", "Fail");
		}
		return this;
	}
}
