package test;

import org.testng.annotations.Test;

import pages.CompanyPage;
import pages.LoginPage;
import utility.ExcelData;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CompanyTest extends Base {
	@Test(priority=1,dataProvider="logintestdata")
	public void verifycompanyclick(String username,String password) throws InterruptedException {
		LoginPage l = new LoginPage(driver);

		l.usernameset(username);
		l.passwordset(password);
		l.loginbuttonclick();
		CompanyPage c = new CompanyPage(driver);
		c.companyclick();
		c.branchclick();
		c.setdropdowncompany();
		c.setbranchname("Thiruvalla");
		c.setbranchaddress("Pathanamthitta");
		c.savedata();
		Thread.sleep(5000);
		c.edit();
		c.editdetails("mavelikara");
		c.savedata();
		Thread.sleep(5000);
		c.viewdetails();
		

	}
	@Test(priority=3)
	public void verifysavedata()
	{
		
		CompanyPage c = new CompanyPage(driver);
		String expected[]= {"2","JKCompany","Mumbai"};
		String actuallist[]=c.columnvalues();
		System.out.println(expected);
		System.out.println(actuallist);
		Assert.assertEquals(actuallist, expected);
	}
	@Test(priority=2)
	public void verifyeditlink() throws InterruptedException{
		CompanyPage c = new CompanyPage(driver);
		c.companyclick();
		c.branchclick();
		c.setdropdowncompany();
		c.setbranchname("Thiruvalla");
		c.setbranchaddress("Pathanamthitta");
		c.savedata();
		Thread.sleep(5000);
		c.edit();
		String expected = "Update Branch: 4234mmm";
		System.out.println(expected);
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "Test failed for Edit");
	}
	@Test(priority=4)
	public void verifypaginationlink(){
		CompanyPage c = new CompanyPage(driver);
		c.paginationclick();
	
	}
	@Test(priority=5)
	public void verifypaginationlinkprevious(){
		CompanyPage c = new CompanyPage(driver);
		c.paginationpreviousclick();
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
