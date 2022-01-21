package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		
		LoginPage lpage= new LoginPage(driver);
		lpage.setTxtusername(username);
		lpage.setTxtpassword(password);
		lpage.clickLogin();
		logger.info("Login button click");
		
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test Passed");
		}
		else {
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test Failed");
			
		}
	}

}
