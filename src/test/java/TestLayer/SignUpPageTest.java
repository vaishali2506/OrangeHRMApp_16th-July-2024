package TestLayer;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.SignUpPage;
import UtilityLayer.ExcelReader;

public class SignUpPageTest {

	@BeforeTest
	public void setUp() {
		BaseClass.initialization();
	}
	
	@Test(dataProvider="fbapplication")
	public void validateSignUpFunctionalityTest(String fname, String lname) {
		
		SignUpPage signuppage = new SignUpPage();
		signuppage.validateSignUpFunctionality(fname, lname);
	}
	
	@DataProvider(name="fbapplication")
	public Object[][] getTestData() throws IOException
	{
		ExcelReader obj = new ExcelReader("C:\\Users\\vaish\\OneDrive\\Desktop\\TestDataFB.xlsx");
		Object[][] data = obj.getAllSheetTestData(0);
		return data;
	}
}
