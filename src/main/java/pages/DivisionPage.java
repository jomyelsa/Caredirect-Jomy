package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DivisionPage {
	WebDriver driver;

	@FindBy(linkText = "Company")
	WebElement comp;
	@FindBy(linkText = "Division")
	WebElement division;
	@FindBy(id="division-company_id")
	 WebElement divisioncomp;
	@FindBy(id ="division-branch_id")
	WebElement divisionbranch;

	@FindBy(id="division-division_name")
	private WebElement divisionname;
	@FindBy(xpath="//button[@class='btn btn-success' and text()='Save']")
	 WebElement savetext;
	@FindBy(xpath="//a[starts-with(@href,'/payrollapp/division/update?id=3')]")
	 WebElement editdata;
	@FindBy(xpath="//a[starts-with(@href,'/payrollapp/division/view?id=3')]")
	 WebElement viewdata;
	@FindBy(xpath="//*[@id='w0']//tr[3]//td")
	private List<WebElement> colvalues;
	
	public DivisionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void companyclick() {
		comp.click();
	}
	public void divisionclick() {
		division.click();
		
	}
	 public void setdropdowndivsion()
     {
		 Select obj=new Select(divisioncomp);
		   obj.selectByIndex(1);
     }
	
	 public void setdivsionname() {
		 Select obj1=new Select(divisionbranch);
		  obj1.selectByValue("1");
			
		}
	 public void setdivisionaddress(String address) {
			
		 divisionname.sendKeys(address);
		}
	 public void savedata() {
			
		 savetext.click();
		}
	 public void edit() {
			
		 editdata.click();
		}
	 public void editdetails(String addr1) {
		 
			
		 divisionname.clear();
		 divisionname.sendKeys(addr1);
		}
	 public void viewdetails() {
		 
			viewdata.click();
		}
	 public String[] columnvalues() {
		 
			String actual[]=new String[3];
			
			for(int i=0;i<3;i++)
			{
				actual[i]=colvalues.get(i).getText();
			
			}
		
			return actual;
	 }
}
