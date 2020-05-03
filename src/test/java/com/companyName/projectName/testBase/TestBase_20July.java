package com.companyName.projectName.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase_20July {

	public static WebDriver driver;
	public static Properties config;
	public static Properties OR;
	public static String testCaseName, skip=null;
	public static ExtentReports extents;
	public static ExtentTest test;
	static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	public static ExcelReader excel = new ExcelReader(
			"C:\\Users\\generic1\\eclipse-workspace\\April20th_2020_MVN_Project\\src\\test\\resources\\jar_Files\\ExcelReader.jar");

	public static Hashtable<String, String> testCaseRunMode = new Hashtable<String, String>();

	@BeforeSuite
	public static void loadingFilesAndGenerateReport() throws IOException {

		config = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\generic1\\eclipse-workspace\\April20th_2020_MVN_Project\\src\\test\\resources\\propertiesFiles\\config.properties");
		config.load(fis);
		System.out.println("************ Config file has been loaded ************");

		OR = new Properties();
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\generic1\\eclipse-workspace\\April20th_2020_MVN_Project\\src\\test\\resources\\propertiesFiles\\OR.properties");
		OR.load(fis1);
		System.out.println("************ OR file has been loaded ************");

		extents = new ExtentReports(
				"E:\\Study Material\\Automation_World-Training\\workspace\\Batch20thJuly_2019_MVN_Project\\src\\test\\resources\\excutionReport\\ExcutionReport_"
						+ timeStamp + ".html");

		loadHashTable(testCaseRunMode, "Test_Cases", "TestCaseName", "Run_Mode");
	}

	// @BeforeMethod
	public static void launchBrowser() throws IOException {

		if (config.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\generic1\\eclipse-workspace\\April20th_2020_MVN_Project\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (config.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\generic1\\eclipse-workspace\\April20th_2020_MVN_Project\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\generic1\\eclipse-workspace\\April20th_2020_MVN_Project\\src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize(); // POM -Page Object Model 
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

		test = extents.startTest(testCaseName);

		driver.get(config.getProperty("Application_URL")); // dynamic
		System.out.println("Browser has been launched and user redirected to Application URL");
		test.log(LogStatus.PASS, "Browser has been launched and user redirected to Application URL:- "
				+ config.getProperty("Application_URL"));
	}

	// @AfterMethod
	public static void closeBrowser() {

		driver.quit();
		//driver.getTitle();
		test.log(LogStatus.PASS, "Driver has been closed & Test case execution is completed");

	}

	@AfterSuite(alwaysRun = true)
	public static void writeIntoExtentReports() {
		extents.endTest(test);
		extents.flush();
	}

	public static void loadHashTable(Hashtable<String, String> testCaseRunMode, String SheetName, String KeyCol,
			String valueCol) {

		int row = excel.getRowCount(SheetName);

		for (int i = 2; i <= row; i++) {

			String key = excel.getCellData(SheetName, KeyCol, i);

			String val = excel.getCellData(SheetName, valueCol, i);

			testCaseRunMode.put(key, val);
		}

		System.out.println(testCaseRunMode);
	}

	public static boolean isExecutable(String TC_name) {
		testCaseName = TC_name;
		if (testCaseRunMode.get(TC_name).equalsIgnoreCase("Y")) { // Run Mode value
			 skip="No" ;
			return true;
		} else {
			 skip="Yes" ;
			return false;
		}
	}

	public static void takeScreenShot() throws IOException {

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\src\\test\\resources\\screenShots\\Passed\\" + testCaseName + "_" + timeStamp + ".png";

			File destFile = new File(reportDirectory);

			FileHandler.copy(scrFile, destFile);

			test.log(LogStatus.PASS, test.addScreenCapture(reportDirectory));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error while taking screenshot for Pass Test case" + e.getMessage());
		}

	}

	public static void takeScreenShot_Fail() throws IOException {
		try {

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\src\\test\\resources\\screenShots\\Failed\\" + testCaseName + "_" + timeStamp + ".png";

			File destFile = new File(reportDirectory);

			FileHandler.copy(scrFile, destFile);

			test.log(LogStatus.FAIL, test.addScreenCapture(reportDirectory));

		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Error while taking screenshot for Fail Test case" + e.getMessage());
		}

	}

	@DataProvider
	public static Object[][] Data_Collections() {

		DataCollection dc = new DataCollection(excel, "Test_Data", testCaseName);

		return dc.dataArray();
		// Hash Table -- htdata
	}
}