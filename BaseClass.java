package week6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class BaseClass {

	 public ChromeDriver driver;
		@BeforeMethod
	  public void preCondition() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		    driver.get("https://dev87541.service-now.com");
		    driver.findElement(By.id("user_name")).sendKeys("admin");
		    driver.findElement(By.id("user_password")).sendKeys("Service@123");
		    driver.findElement(By.id("sysverb_login")).click();
		  
		    
		   
	}

}
