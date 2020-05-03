package com.companyName.projectName.testBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.companyName.projectName.testBase.TestBase_20July;

public class TestNGAsserts extends TestBase_20July{
	
	@Test
	public static void testNGAsserts() {
		
	//	Assert.fail();
		
		try {
			System.out.println("I am testing Assert Class");
			driver.findElement(By.xpath("")).getText();	
		//	Assert.fail("test case got fail due to Xpath issue"); // TestNG // Priority 
			String Actual_Text = "Payment Successful." ;
			String Expected_Text = "Payment Successful" ;
			Assert.assertEquals(Actual_Text, Expected_Text);
			System.out.println("I am testing Assert Class");
			System.out.println("I am testing Assert Class");
		} catch (Exception e) {
			System.out.println("I am testing Assert Class and is in Catch block");
		}
		
		
		Assert.assertEquals(true, true);
		
		Assert.assertEquals(500, 500);
		
		Assert.assertFalse(false, "i am cheking Assert class");
		
		
	//	Assert.assertTrue(true);
    //  String Actual_Text=	driver.findElement(By.xpath("")).getText();		
	//	Assert.assertEquals(Actual_Text, "Payment Successful");// Confirmation Page
		
		
	}

}