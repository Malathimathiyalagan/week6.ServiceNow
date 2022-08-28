package week6;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewProposal extends BaseClass{
	    	@Test
	    		public  void createNewProposal() throws InterruptedException {
					/*
					 * 1. Launch ServiceNow application 2. Login with valid credential 3. Click All
					 * and Enter Proposal in filter navigator and press enter 4. Click- new and fill
					 * mandatory fields and click 'Submit' Button. 5. Verify the successful creation
					 * of new Proposal
					 */
	    		    Shadow shadow = new Shadow(driver);
	    			Thread.sleep(10000);
	    			shadow.setImplicitWait(10);
	    			WebElement dom = shadow.findElementByXPath("//div[@id='all']");
	    			dom.click();
	    			Thread.sleep(2000);
	    			shadow.setImplicitWait(10);
	    			
	    			WebElement filter = shadow.findElementByXPath("//input[@id='filter']");	   
	    			filter.click();
	    			filter.sendKeys("Proposal",Keys.ENTER);
	    			dom.click();
	    			shadow.setImplicitWait(10);

	    			WebElement myProposal = shadow.findElementByXPath("//a[@class='nested-item item-label keyboard-navigatable highlighted-item']");
	    			myProposal.click();
	    			Thread.sleep(1000);
	    				    	
	    			WebDriver frame = driver.switchTo().frame(shadow.findElementByXPath("iframe[@id='gsft_main']"));
	    			frame.getCurrentUrl();
	    			WebElement newButton = driver.findElement(By.xpath("//button[text()='New']"));
	    			newButton.click();

	    			WebElement temDescription = driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']"));
	    			temDescription.sendKeys("New Proposal",Keys.ENTER);
	    			Thread.sleep(1000); 
	    			WebElement submit = driver.findElement(By.xpath("(//button[text()='Submit'])[2]"));
	    			submit.click();
	    			String proposal = driver.findElement(By.xpath("//td[text()='New Proposal']")).getText();
	    			System.out.println(proposal);
	    			System.out.println("Create New Proposal is Done");
}
}