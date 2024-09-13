package com.orangeHrm.pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.orangeHrm.utility.utility;

public class login_page {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginButton;

//error messages
	@FindBy(xpath = "(//span[text()='Required'])[1]")
	private WebElement required1;
	@FindBy(xpath = "(//span[text()='Required'])[2]")
	private WebElement required2;

//error message
	@FindBy(xpath = "//p[text()='Invalid credentials']")
	private WebElement invalidCredentials;
	
	//dashboard page
	
	@FindBy(xpath="//h6[text()='Dashboard']")private WebElement dashboard;

	public login_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void withoutEnteringUsernameAndPassword(WebDriver driver) {

		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));

		w.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		Reporter.log("Click on the login Button", true);
		String act = "Required";
		String exp = required1.getText();

		Assert.assertEquals(act, exp, "if Actual and Exp is not match then our test cases if failed");
		Reporter.log("Check error message at username field", true);
		String act1 = "Required";
		String exp1 = required2.getText();

		Assert.assertEquals(act1, exp1, "if Actual and Exp is not match then our test cases if failed");
		Reporter.log("Check error message at password field", true);
	}

	public void validUsernameInvalidPassword(WebDriver driver) throws EncryptedDocumentException, IOException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		File myFile = new File("D:\\excel\\dest.xlsx");
		String uname = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(2).getCell(0).getStringCellValue();
		String pword = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(2).getCell(1).getStringCellValue();

		w.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(uname);
		Reporter.log("user enter valid username in username field", true);
		
		w.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pword);
		Reporter.log("user enter invalid password in password field", true);

		w.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		Reporter.log("Click on the login Button", true);
		String act = "Invalid credentials";
		String exp = invalidCredentials.getText();

		Assert.assertEquals(act, exp, "If act is not equal exp then our test cases is failed");

		Reporter.log("Check error message like Invalid credentials", true);
	}

	public void InValidUsernamevalidPassword(WebDriver driver) throws EncryptedDocumentException, IOException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		File myFile = new File("D:\\excel\\dest.xlsx");
		String uname = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(5).getCell(0).getStringCellValue();
		String pword = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(5).getCell(1).getStringCellValue();

		w.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(uname);
		Reporter.log("user enter Invalid username in username field", true);
		w.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pword);
		Reporter.log("user enter valid password in password field", true);

		w.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		Reporter.log("Click on the login Button", true);

		String act = "Invalid credentials";
		String exp = invalidCredentials.getText();

		Assert.assertEquals(act, exp, "If act is not equal exp then our test cases is failed");

		Reporter.log("Check error message like Invalid credentials", true);
	}

	public void InValidUsernameInvalidPassword(WebDriver driver) throws EncryptedDocumentException, IOException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		File myFile = new File("D:\\excel\\dest.xlsx");
		String uname = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(8).getCell(0).getStringCellValue();
		String pword = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(8).getCell(1).getStringCellValue();

		w.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(uname);
		Reporter.log("user enter Invalid username in username field", true);
		w.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pword);
		Reporter.log("user enter Invalid password in password field", true);

		w.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		Reporter.log("Click on the login Button", true);

		String act = "Invalid credentials";
		String exp = invalidCredentials.getText();

		Assert.assertEquals(act, exp, "If act is not equal exp then our test cases is failed");

		Reporter.log("Check error message like Invalid credentials", true);
	}

	public void ValidUsernamevalidPassword(WebDriver driver) throws EncryptedDocumentException, IOException {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(30));
		File myFile = new File("D:\\excel\\dest.xlsx");
		String uname = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(11).getCell(0).getStringCellValue();
		String pword = WorkbookFactory.create(myFile).getSheet("Sheet2").getRow(11).getCell(1).getStringCellValue();

		w.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(uname);
		Reporter.log("user enter valid username in username field", true);
		w.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(pword);
		Reporter.log("user enter valid password in password field", true);

		w.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		Reporter.log("Click on the login Button", true);
		
		String act = "Dashboard";
		String exp = dashboard.getText();

		Assert.assertEquals(act, exp, "If act is not equal exp then our test cases is failed");
		
		
		Reporter.log("user successfully login and user on the dashboard page of this application", true);
	}

}
