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
import com.hybridframework.module01.utility.ExcelDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
	
	public WebDriver driver;
	public String exceldataprovider="./testdata/data.xlsx";
	public String configdatapath = "./Config/config.properties";
	public ConfigDataProvider configdataprovider;
	public ExcelDataProvider exceldata;
	@BeforeSuite
	public void init() throws Exception {
		 configdataprovider = new ConfigDataProvider(configdatapath);
		 exceldata=new ExcelDataProvider(exceldataprovider);
	}
	@BeforeTest
	@Parameters({"browser"})
	public void setUp(@Optional("Chrome") String brName) {
		if (brName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (brName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("browser not matched please check with expected browser");
		}

		driver.manage().window().maximize();
		driver.get(configdataprovider.getURL());
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
