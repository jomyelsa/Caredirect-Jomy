package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Base {
	public WebDriver driver;
	@BeforeClass

	public void setup() {

		System.setProperty("webdriver.chrome.driver", "H:\\Chrome_83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();

	}


}
