package pages;

import javax.xml.stream.events.StartElement;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	@FindBy(id = "loginform-username")
	WebElement user;
	@FindBy(id = "loginform-password")
	WebElement paswd;
	@FindBy(name = "login-button")
	WebElement sbmit;

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void usernameset(String username) {
//		
//		boolean staleElement = true;
//		while(staleElement){
//		  try{
//		WebDriverWait wait=new WebDriverWait(driver,20);
//		  WebElement user= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginform-username")));
		user.sendKeys(username);
		boolean usernamee=user.isEnabled();
	
	
//   	staleElement=false;
//			  }
//			  catch(StaleElementReferenceException e){
//
//				    staleElement = true;
//			  }
//		}	
}

	public void passwordset(String password) {
//		boolean staleElement = true;
//		while(staleElement){
//			  try{
//		WebDriverWait wait=new WebDriverWait(driver,20);
//		  WebElement paswd= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginform-password")));
//		  WebElement paswd= wait.until(ExpectedConditions.refreshed(By.id("loginform-password")));
		paswd.sendKeys(password);
		boolean passwordd=paswd.isEnabled();
		
	
	
//		staleElement=false;
//			  }
//			  catch(StaleElementReferenceException e){
//
//				    staleElement = true;			  }
//		}
	
	}

	public void loginbuttonclick() {

		sbmit.click();
		
		

	}

}
