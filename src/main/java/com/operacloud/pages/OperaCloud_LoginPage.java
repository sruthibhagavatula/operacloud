package com.operacloud.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.operacloud.selenium.actions.extensions.OperaCloudSeleniumActions;

import net.bytebuddy.asm.Advice.This;



public class OperaCloud_LoginPage extends OperaCloudSeleniumActions {

	public OperaCloud_LoginPage(ChromeDriver driver, ExtentTest node) {
		System.out.println(driver);
		this.driver=driver;
		this.node=node;
		initPage();
		
		
	//to do, verify title of the login page	
	}
	@FindBy(id="username")
	private WebElement userName;
	
	
	public OperaCloud_LoginPage enterUsrname(String usrname) throws IOException
	{try {
		userName.sendKeys(usrname);
		Thread.sleep(5000);
		reportStep("successfully entered"+usrname+" username" , "pass");
	}
	catch(Exception e)
	{
		reportStep("username not entered successfully", "fail");
	}
		return this;
	} 
	
	@FindBy(id="password")
	private WebElement passwrd;
	public OperaCloud_LoginPage enterPasswd(String passwd) throws IOException
	{
		try {
		passwrd.sendKeys(passwd);
		Thread.sleep(5000);
		reportStep("password entered "+passwd+" successfully" , "pass");
		}
		catch(Exception e)
		{
			reportStep("password entering unsuccessful","fail");
		}
		return this;
	}
	
	@FindBy(id="loginBtn")
	private WebElement loginButton;
	public OperaCloud_HomePage clickSignIn() throws InterruptedException, IOException
	{
		try {
			Thread.sleep(5000);
		loginButton.click();
		Thread.sleep(20000);
		reportStep("successfully clicked on login button", "pass");
		}
		catch(Exception e)
		{
			reportStep(" click on login button unsuccessful", "Fail");
		}
		return new OperaCloud_HomePage(driver,node);
	}
	
	
	
	
	
}
