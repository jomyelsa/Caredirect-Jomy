package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyPage {
	WebDriver driver;

	@FindBy(linkText = "Company")
	WebElement comp;
	@FindBy(linkText = "Branch")
	WebElement branch;
	@FindBy(id="branch-company_id")
	 WebElement branchcomp;
	@FindBy(id ="branch-branch_name")
	WebElement branchname;

	@FindBy(id="branch-branch_address")
	private WebElement branchaddress;
	@FindBy(xpath="//*[@id='w0']//tr[2]//td")
	private List<WebElement> colvalues;
	
	@FindBy(xpath="//button[@class='btn btn-success' and text()='Save']")
	 WebElement savetext;
	@FindBy(xpath="//a[starts-with(@href,'/payrollapp/branch/update?id=3')]")
	 WebElement editdata;
	@FindBy(xpath="//a[starts-with(@href,'/payrollapp/branch/view?id=3')]")
	 WebElement viewdata;
	@FindBy(xpath="//ul[@class='pagination']//li//a")
    WebElement pagination;

	

	public CompanyPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void companyclick() {
		comp.click();
	}
	public void branchclick() {
		branch.click();
		
	}
	 public void setdropdowncompany()
     {
		 Select obj=new Select(branchcomp);
		   obj.selectByIndex(1);
     }
	
	 public void setbranchname(String name) {
			
			branchname.sendKeys(name);
		}
	 public void setbranchaddress(String address) {
			
			branchaddress.sendKeys(address);
		}
	 public void savedata() {
			
		 savetext.click();
		}
	 public void edit() {
			
		 editdata.click();
		}
	 public void editdetails(String addr1) {
		 
			
		 branchaddress.clear();
		 branchaddress.sendKeys(addr1);
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
	 public void paginationclick() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		while(pagination.isEnabled()) 
		{
			String nextlink="//ul[@class='pagination']//li[@class='next']//a";
			WebDriverWait wait=new WebDriverWait(driver,60);
			WebElement paginate=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nextlink)));
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			 js.executeScript("window.scrollBy(0,1000)");
			 if(paginate.isEnabled())
			 {
				 paginate.click();
			 }
			 else if(!paginate.isEnabled())
			 {
				System.out.println("jjj");
			 }
		}
//	 if(pagination .size()>0){ 
//		 System.out.println("pagination exists"); 
//
//		 // click on pagination link 
//
//		 for(int i=0; i<pagination .size(); i++){ 
//			 System.out.println("page::"+pagination.size());
//			 js.executeScript("window.scrollBy(0,1000)");
//		 pagination.get(i).click(); 
//		 } 
//		 } else { 
//			 System.out.println("pagination not exists"); 
		 } 

	 public void paginationpreviousclick() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	
		 String prevlink="//ul[@class='pagination']//li[@class='prev']//a";
			WebDriverWait wait=new WebDriverWait(driver,60);
			WebElement paginatee=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prevlink)));
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			 js.executeScript("window.scrollBy(0,1000)");
			 if(paginatee.isEnabled())
			 {
				 paginatee.click();
			 }
			 else if(!paginatee.isEnabled())
			 {
				System.out.println("jjj");
		
}
	 }
}


