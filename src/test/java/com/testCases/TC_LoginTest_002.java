package com.testCases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import com.Utilities.XLUtils;
import com.pageObjects.LoginPage;



//checking the login test with values from Excel and Dataprovider--Data driven test
public class TC_LoginTest_002 extends BaseClass{

	@Test(dataProvider ="logintest")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage page = new LoginPage(driver);
		page.setTxtusername(user);
		page.setTxtpassword(pwd);
		page.clickLogin();
		
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent(); // returns to main page
			Assert.assertTrue(false);  // Its a failure condiion . becos alert appears in invalid data
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true); // Its a Pass condition. Means Valid data
			page.clicklogout();
			Thread.sleep(3000);
			if(isAlertPresent()==true) {
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				
			}
		}
	}

	public boolean isAlertPresent() { // user defined method to check alert present or not
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;  // it means there is no alert
			
		}
	}
	
	
	@DataProvider(name ="logintest")
	public Object[][] getData() throws IOException{
		logger.info("I am going to read excel");
		String path =System.getProperty("user.dir")+"\\src\\test\\java\\com\\testData\\TestData.xlsx";
		System.out.println(path);
		int totrows=XLUtils.getRowCount(path, "Sheet1");
		System.out.println("totrows" +totrows);
		int totcolumn=XLUtils.getColCount(path, "Sheet1", 1);
		System.out.println("totcolumn " +totcolumn);
		String logindata[][]= new String[totrows][totcolumn];

		for(int i=1;i<=totrows;i++) {
			for(int j=0;j<totcolumn;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;

	}

	public boolean IsAlertPresent() {

		try {
			driver.switchTo().alert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return false;

	}
}
