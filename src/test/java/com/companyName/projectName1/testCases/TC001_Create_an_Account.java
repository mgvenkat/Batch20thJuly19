package com.companyName.projectName1.testCases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.companyName.projectName1.pages.HomePage;
import com.companyName.projectName1.pages.YourPersonalInformation_Page;
import com.companyName.projectName.testBase.TestBase_20July;

public class TC001_Create_an_Account extends TestBase_20July {
	
	
	@BeforeClass
	public static void isSkip() {
		
		if(!isExecutable("TC001_Create_an_Account")) 
		throw new SkipException("Skipping Testcase as it's Run Mode is marked as N");
	}
		
	@Test(dataProvider="Data_Collections")
	public static void TC001_Create_An_Account(Hashtable<String, String> testData) throws Throwable {	
		
		HomePage.createAnAccount(testData);

		YourPersonalInformation_Page.enterYourPersonalInformation(testData);
		
	}
	
}