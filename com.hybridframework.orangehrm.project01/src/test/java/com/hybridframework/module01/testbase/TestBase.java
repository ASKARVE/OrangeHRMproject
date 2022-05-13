package com.hybridframework.module01.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.hybridframework.module01.utility.ConfigDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	static String configdatapath = "./Config/config.properties";

	public ConfigDataProvider configdataprovider;

	@BeforeSuite

	public void init() {

		configdataprovider = new ConfigDataProvider(configdatapath);

	}

	@BeforeTest
	@Parameters({"browser"})
	
	public void Setup(@Optional("chrome") String brName) {
		
		if(brName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(brName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser is not matched then please check with expected browser");
		}
		driver.manage().window().maximize();
		
		driver.get(configdataprovider.getURL());
		
		@AfterTest
		public void tearDown() {
			driver.quit();
			driver.close();
		}
	}
			
}
