package test;

import org.testng.annotations.Test;

import pages.CompanyPage;
import pages.DivisionPage;
import pages.LoginPage;
import utility.ExcelData;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class DivisionTest extends Base {
	@Test(priority=1,dataProvider="logintestdata")
	public void verifydivisionclick(String username,String password) throws InterruptedException {
		LoginPage l = new LoginPage(driver);

		l.usernameset(username);
		l.passwordset(password);
		l.loginbuttonclick();
		DivisionPage d = new DivisionPage(driver);
		d.companyclick();
		d.divisionclick();
		d.setdropdowndivsion();
		d.setdivsionname();
		d.setdivisionaddress("Trivandrum");
		d.savedata();
		Thread.sleep(5000);
		d.edit();
		d.editdetails("Kollam");
		d.savedata();
		Thread.sleep(5000);
		d.viewdetails();
	}
	@Test(priority=2)
	public void verifysavedata()
	{
		
		DivisionPage d = new DivisionPage(driver);
		String expected[]= {"3","asdf","tvm1"};
		String actuallist[]=d.columnvalues();
		System.out.println(expected);
		System.out.println(actuallist);
		Assert.assertEquals(actuallist, expected);
	}
 @BeforeTest
  public void beforeTest() {
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

  @AfterTest
  public void afterTest() {
  }

}
