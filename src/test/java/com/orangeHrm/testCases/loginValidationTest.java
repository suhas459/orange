package com.orangeHrm.testCases;

import org.testng.annotations.Test;

import com.orangeHrm.baseClass.baseClass;
import com.orangeHrm.pages.login_page;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class loginValidationTest extends baseClass {
 
	
	login_page lp;
	
	  @BeforeMethod
	  public void beforeMethod() throws IOException {
		  launchThebrowser();
		  lp=new login_page(driver);
		  
		  
	  }
	
	@Test(priority= -5, enabled=true, invocationCount = 2)
  public void withoutEnteringUsernamePassword() {
		lp.withoutEnteringUsernameAndPassword(driver);
		
  }
	
	@Test(priority= -4, enabled=true)
	  public void validUsernameAndInvalidPassword() throws EncryptedDocumentException, IOException {
			lp.validUsernameInvalidPassword(driver);
			
	  }

	@Test(priority= -3, enabled=true)
	  public void InValidUsernameAndvalidPassword() throws EncryptedDocumentException, IOException {
			lp.InValidUsernamevalidPassword(driver);
			
	  }
	
	@Test(priority= -2, enabled=true)
	  public void InValidUsernameAndInValidPassword() throws EncryptedDocumentException, IOException {
			lp.InValidUsernameInvalidPassword(driver);
			
	  }
	
	
	@Test(priority= -1, enabled=true)
	  public void ValidUsernameAndValidPassword() throws EncryptedDocumentException, IOException {
			lp.ValidUsernamevalidPassword(driver);
			
	  }
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(6000);
		driver.close();
		
		
		
	}
	
	
	
	
}
