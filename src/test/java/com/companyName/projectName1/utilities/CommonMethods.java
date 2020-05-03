package com.companyName.projectName1.utilities;

import java.io.IOException;
import java.util.Hashtable;
import org.openqa.selenium.By;
import com.companyName.projectName.testBase.TestBase_20July;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods extends TestBase_20July {

	// final String Name="Rahul";

	public static void clickOnWebelement(String Xpath, String webelement) throws IOException {
		try {
			driver.findElement(By.xpath(OR.getProperty(Xpath))).click();
			test.log(LogStatus.PASS, webelement + " has been clicked");
			takeScreenShot();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Error while clicking Webelement:- " + e.getMessage());
			takeScreenShot_Fail();
		}

	}

	public static void writeIntoInputBox(String Xpath, Hashtable<String, String> testData, String value)
			throws IOException, Throwable {

		try {
			driver.findElement(By.xpath(OR.getProperty(Xpath))).sendKeys(testData.get(value));
			test.log(LogStatus.PASS, value + " has been entered");
			takeScreenShot();
		} catch (Throwable t) {
			test.log(LogStatus.FAIL, "Error while entering text in field:- " + t.getMessage());
			takeScreenShot_Fail();
		}

	}

	public static void selectByIndex(String Xpath, Hashtable<String, String> testData, String HTKey,
			String webelement) {

		// Mechanism to select value from drop down box with Indexing.
	}

	public static void selectByVisibleText(String Xpath, Hashtable<String, String> testData, String HTKey,
			String webelement) {

		// Mechanism to select value from drop down box with selectByVisibleTex.
	}

	public static void selectByValue(String Xpath, Hashtable<String, String> testData, String HTKey,
			String webelement) {

		// Mechanism to select value from drop down box with selectByValue.
	}

	
	public static void getDropDownValues(String Xpath, Hashtable<String, String> testData, String HTKey,
			String webelement) {

		// Mechanism to select value from drop down box with selectByValue.
	}
	
	public static void verifyDropDownValues(String Xpath, Hashtable<String, String> testData, String HTKey,
			String webelement) {

		// Mechanism to select value from drop down box with selectByValue.
	}
	
	public static String getTitle() {	
		String Actual_title = driver.getTitle(); // Pass Or Fail Or Skip
		test.log(LogStatus.PASS, "Page title is :- " +Actual_title);
		return Actual_title;	
	}
	
	public static String getText(String xpath) {	
		String Actual_Text = driver.findElement(By.xpath(OR.getProperty(xpath))).getText(); // Pass Or Fail
		test.log(LogStatus.PASS, "The Text is :- " +Actual_Text);
		return Actual_Text;	
			
	}
	
  public static Boolean isDisplayed(String xpath, String name) {
		
	    Boolean webelement = driver.findElement(By.xpath(OR.getProperty(xpath))).isDisplayed() ; // Pass Or Fail
	    test.log(LogStatus.PASS, "WebElement is displayed on the page :- " +name);
	    return webelement;			
	}
	
	
}
