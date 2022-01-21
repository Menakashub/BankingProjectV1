package com.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig config= new ReadConfig();
	
	public String baseURL =config.getApplicationURL();
	public String username=config.getUsername();
	public String password =config.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("chrome")){
			System.setProperty(config.getChromePath(),config.getChromeDriver());
			driver= new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		logger.info("URL opened");
		 	
		
	}
	@AfterClass
	public void teadDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testcasename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") +"/Screenshots/" +testcasename +".png");
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot taken");
		logger.info("Screenshot taken");
	}
	public String generateRandomString() {
		String randomEmail=RandomStringUtils.randomAlphabetic(8);
		return randomEmail;
	}
	public static String generateRandomNumber() {
		String randomNum=RandomStringUtils.randomNumeric(8);
		return randomNum;
	}
	
	
	
	

}
