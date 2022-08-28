package week6;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class FillMandatoryFields extends BaseClass {
	@Test
    public  void fillMandatoryFields() throws InterruptedException {
		/*
		 * 1. Launch ServiceNow application 2. Login with valid credentials 3. Enter
		 * Knowledge in filter navigator and press enter 4. Create new Article 5.Select
		 * knowledge base as IT and category as IT- java and Click Ok 6.Update the other
		 * mandatory fields 7.Select the submit option
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
	shadow.setImplicitWait(10);
	filter.sendKeys("Knowledge",Keys.ENTER);
	dom.click();
	
	Thread.sleep(2000); 
	shadow.setImplicitWait(10);
	WebElement knowledge = shadow.findElementByXPath("//a[contains(@class,'nested-item')]");
	knowledge.click();
	
	Thread.sleep(1000);
	WebElement frames = shadow.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(frames);
	
	WebElement createAnArticle = driver.findElement(By.xpath("//span[text()='Create an Article']"));
	createAnArticle.click();
	
	WebElement knowledgeBase = driver.findElement(By.xpath("(//input[contains(@id,'knowledge_base')])[4]"));
	knowledgeBase.sendKeys("IT");
	
	WebElement knowledgeCategory = driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']"));
	knowledgeCategory.sendKeys("IT - Java");
	Thread.sleep(1000);
	
	WebElement shortDescription = driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']"));
	shortDescription.sendKeys("June Non IT to IT Batch");
	Thread.sleep(1000);
	
	WebElement submit = driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']"));
	submit.click();
	System.out.println("Fill Mandatory Fields is Done");	
    }
}
