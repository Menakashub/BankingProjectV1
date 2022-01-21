package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.AddCustomer;
import com.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage page = new LoginPage(driver); //driver comes from BaseClass
		
		page.setTxtusername(username);
		logger.info("Username is provided");
		page.setTxtpassword(password); 
		logger.info("password is provided");// url will open in BaseCLass itself
		page.clickLogin();
		Thread.sleep(3000);
		logger.info("Login Success");
		AddCustomer cust = new AddCustomer(driver);
		cust.clicknewcustomerlink();
		cust.Custname("menk");
		cust.Gender("male");
		cust.dob("05", "31", "1986");
		cust.Address("First Street");
		cust.city("Chennai");
		cust.state("TN");
		cust.pinno(1234567);
		cust.telephoneno(12345678);
		String email=generateRandomString()+"@gmail.com";
				cust.emailid(email);
		cust.password("abcdef");
		cust.clickSubmit();
		
		Thread.sleep(8000);
		
		boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result==true) {
			logger.info("Customer added success");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Customer not added");
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	

}
