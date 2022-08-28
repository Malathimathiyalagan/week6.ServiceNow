package week6;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class OrderMobile extends BaseClass {
	@Test
	public void orderMobile() throws InterruptedException {

		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * 
		 * // launch url driver.get("https://dev87541.service-now.com");
		 * driver.findElement(By.id("user_name")).sendKeys("admin");
		 * driver.findElement(By.id("user_password")).sendKeys("Service@123");
		 * driver.findElement(By.id("sysverb_login")).click();
		 */
		/*
		 * 1. Launch ServiceNow application 2. Login with valid credentials username as
		 * admin and password as India@123 3. Click-AllEnter Service catalog in filter
		 * navigator and press enter 4. Click on mobiles 5.Select Apple iphone6s
		 * 6.Update color field to rose gold and storage field to 128GB 7.Select Order
		 * now option 8.Verify order is placed and copy the request number
		 */
		 
		Shadow shadow = new Shadow(driver);
		Thread.sleep(10000);
		shadow.setImplicitWait(10);
		WebElement dom = shadow.findElementByXPath("//div[@id='all']");
		dom.click();
		Thread.sleep(2000);
		shadow.setImplicitWait(10);
		WebElement serviceCatalog = shadow.findElementByXPath("//span[text()='Service Catalog']");
		serviceCatalog.click();

		Thread.sleep(10000);
		// switching frame with webElement
		WebElement frameHandle = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameHandle);
		driver.findElement(By.xpath("//h2[contains(text(), 'Mobiles')]")).click();
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
		Select drop = new Select(color);
		drop.selectByValue("gold");

		WebElement storage = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]"));
		Select drop1 = new Select(storage);
		drop1.selectByValue("onehudred_twentyeight");
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();

		String orderStatus = driver.findElement(By.xpath("//div[@class='notification notification-success']/span")).getText();
		System.out.println("Ordered Status is: " + orderStatus);
		String expectedResult = "Thank you, your request has been submitted";

		if (orderStatus.equals(expectedResult)) {
			System.out.println("Order is Placed");
		} else {
			System.out.println("Order is not placed");
		}

		/*
		 * if(orderStatus.equalsIgnoreCase("Thank you, your request has been submitted"
		 * )) { System.out.println("Order is Placed"); } WebElement reqNum
		 * =driver.findElement(By.xpath("//a[@id='requesturl']"));
		 * System.out.println(reqNum.getText());
		 */
		  WebElement requestnumber = driver.findElement(By.xpath("//a[@id='requesturl']/b"));
		  System.out.println("Request number for the order placed is: " + requestnumber.getText());
		 System.out.println("Order Mobile is Done");

	}

}
