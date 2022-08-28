package week6;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller extends BaseClass  {
	@Test
	public  void createNewCaller() throws InterruptedException {
		/*
		 * 1. Launch ServiceNow application 2. Login with valid credential 3. Click-All
		 * and Enter Callers in filter navigator and press enter 4. Create new Caller by
		 * filling all the fields and click 'Submit'. 5. Search and verify the newly
		 * created Caller
		 */
	Shadow shadow=new Shadow(driver); 
	Thread.sleep(10000); 
	shadow.setImplicitWait(10);
	WebElement dom = shadow.findElementByXPath("//div[@id='all']");
	dom.click();
	Thread.sleep(2000); 
	shadow.setImplicitWait(10);
	WebElement filter = shadow.findElementByXPath("//input[@placeholder='Filter']"); 
	
	filter.click(); 
	Thread.sleep(2000); 
	filter.sendKeys("Callers",Keys.ENTER);
	dom.click();
	
	Thread.sleep(2000); 
	shadow.setImplicitWait(10);
	WebElement callers = shadow.findElementByXPath("//span[@class='item-icon']");
	callers.click();
	Thread.sleep(1000);
	shadow.setImplicitWait(10);
	WebDriver frame = driver.switchTo().frame(shadow.findElementByXPath("iframe[@id='gsft_main']"));
    frame.getCurrentUrl();
	
    WebElement newButton = driver.findElement(By.xpath("//button[text()='New']"));
	newButton.click();
	
	WebElement fname = driver.findElement(By.xpath("//input[@id='sys_user.first_name']"));
	fname.sendKeys("Malathi");
	
	WebElement lname = driver.findElement(By.xpath("//input[@id='sys_user.last_name']"));
	lname.sendKeys("Mathiyalagan");
	
	WebElement email = driver.findElement(By.xpath("//input[@id='sys_user.email']"));
	email.sendKeys("malathi@gmail.com");
	
	WebElement businessNum = driver.findElement(By.xpath("//input[@id='sys_user.phone']"));
	businessNum.sendKeys("9938005034");
	
	WebElement title = driver.findElement(By.xpath("//input[@id='sys_user.title']"));
	title.sendKeys("Junior Developer");
	
	WebElement mobNum = driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']"));
	mobNum.sendKeys("9938005036");
	
	WebElement submit = driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']"));
	submit.click();
	
	
	WebElement drop = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
	Select select = new Select(drop);
	select.selectByVisibleText("First name");
	Thread.sleep(1000);
	WebElement search = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	search.sendKeys("Malathi",Keys.ENTER);
	
	String name = driver.findElement(By.xpath("//table//tr[1]//td[4]")).getText();
	System.out.println("Search with FirstName and verified: "+name);
	System.out.println("Create New Caller is Done");
	
}

}


