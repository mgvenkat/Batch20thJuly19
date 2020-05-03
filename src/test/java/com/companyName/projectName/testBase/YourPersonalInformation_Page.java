package com.companyName.projectName.testBase;

import java.util.Hashtable;

import com.companyName.projectName.testBase.TestBase_20July;
import com.companyName.projectName.testBase.TestBase_20July;

public class YourPersonalInformation_Page extends TestBase_20July {
	
	public static void enterYourPersonalInformation(Hashtable<String, String> testData) throws Throwable {

		 CommonMethods.clickOnWebelement("XGender", "Mr. Title");
		
		//Assert.assertEquals(CommonMethods.getTitle(), "My Store"); // Verifying correctness of landing page

		 CommonMethods.writeIntoInputBox("XFirstName", testData, "First_Name");

		//Assert.assertEquals(CommonMethods.getText("XAcntText"), "CREATE AN ACCOUNT");

		 CommonMethods.writeIntoInputBox("XLastName", testData, "Last_Name");

		 CommonMethods.writeIntoInputBox("Xpwd", testData, "Password");

	//	Assert.assertTrue(CommonMethods.isDisplayed("XperInfoPage", "YOUR PERSONAL INFORMATION"));

	}

	
		
	}



