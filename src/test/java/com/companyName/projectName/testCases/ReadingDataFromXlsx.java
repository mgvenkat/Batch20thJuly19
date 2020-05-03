package com.companyName.projectName.testCases;

import org.testng.annotations.Test;

import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;

public class ReadingDataFromXlsx {
	
	@Test	
	public  void readingDataFromXlsx() {
		
		ExcelReader excel = new ExcelReader("C:\\Users\\generic1\\Downloads\\Master_Sheet.xlsx");
		
		//excel.addSheet("New_Sheet");
		
		//excel.addColumn("Test_Cases", "Comments");
		//excel.removeColumn("Test_Cases", 3);
		
		
		System.out.println(excel.getCellData("Test_Cases", 1, 4)); //OOPS concept
		System.out.println(excel.getCellData("Test_Cases","Run_Mode", 4));
		
		
		
		
	}

}
