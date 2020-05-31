package test;

import org.testng.annotations.Test;

import pages.LoginPage;
import utility.ExcelData;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class LoginTest extends Base {
	@Test(priority = 1,dataProvider="logintestdata")
	public void verifylogin(String username,String password) {
		LoginPage l = new LoginPage(driver);

		l.usernameset(username);
        Assert.assertTrue(true,"failed");
	   l.passwordset(password);
	   Assert.assertTrue(true,"failed password");
		l.loginbuttonclick();
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		String expected = "Payroll Application";
		System.out.println(expected);
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "Test failed for Login Button");
}
	@BeforeMethod
	public void beforemethod()
	{
	driver.get("https://www.qabible.in/payrollapp/site/login");
	}
	  @DataProvider
	  public Object[][] logintestdata() throws InvalidFormatException, IOException  {
	          Object[][]data= ExcelData.getDataFromSheet("G:\\Excel_Read\\LoginDataExcelCareDirect.xlsx");
	          return data;
	  
	  
	}
}
