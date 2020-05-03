package com.companyName.projectName.testBase;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.companyName.projectName.testBase.TestBase_20July;


public class HomePage extends TestBase_20July {

	public static void createAnAccount(Hashtable<String, String> testData) throws Throwable {

		Assert.assertEquals(CommonMethods.getTitle(), "My Store"); // Verifying correctness of landing page // Pass

		CommonMethods.clickOnWebelement("XSignInBtn", "Sign In Button");

		Assert.assertEquals(CommonMethods.getText("XAcntText"), "CREATE AN ACCOUNT");

		CommonMethods.writeIntoInputBox("XEmail_add", testData, "Email_ID");

		CommonMethods.clickOnWebelement("XCreatAcnt_btn", "Create An Account Button");

		Assert.assertTrue(CommonMethods.isDisplayed("XperInfoPage", "YOUR PERSONAL INFORMATION"));

	}

	public static void alreadyRegistered(Hashtable<String, String> testData) throws Throwable {

		String Actual_title = driver.getTitle();

		Assert.assertEquals(Actual_title, "My Store");

		CommonMethods.clickOnWebelement("XSignInBtn", "Sign In Button");

		String A_AcntText = driver.findElement(By.xpath(OR.getProperty("XAcntText"))).getText();

		Assert.assertEquals(A_AcntText, "Create an account");

		CommonMethods.writeIntoInputBox("XEmail_add", testData, "Email_ID");

		CommonMethods.clickOnWebelement("XCreatAcnt_btn", "Create An Account Button");
	}

	public static void customerServiceContactUs() throws IOException {

		CommonMethods.clickOnWebelement("XContactUs", "Contact Us Button");

		// CommonMethods.writeIntoInputBox("XEmail_add", testData, "Email_ID");
	}

	
	public static void navigatetoWomenSection() throws IOException {

		CommonMethods.clickOnWebelement("XContactUs", "Contact Us Button");

		// CommonMethods.writeIntoInputBox("XEmail_add", testData, "Email_ID");
	}

	
}
