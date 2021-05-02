package TestPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UpdateUserDetailsForAddedVote {
	
	public WebDriver driver ;
	
  @Test
  public void updateFnameLnameforAddedVote() throws Exception {
	  		//Select Profile
			driver.findElement(By.xpath("//a[@href='/profile']")).click();
			Thread.sleep(3000);
			
			//Update Details under profile
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Tom_Test5");
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Harry_Test5");
			Thread.sleep(3000);
			
			//save Details
			driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			Thread.sleep(3000);
			
			//verify details saved successfully
			WebElement detailsSavedText = driver.findElement(By.xpath("//div[@class='result alert alert-success hidden-md-down']"));
			String detailsSavedMsg = detailsSavedText.getText();
			String expectedMsg = "The profile has been saved successful";
			Assert.assertEquals(detailsSavedMsg, expectedMsg);
			
			//Navigate to home page
			driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();
			
			
			//to verify updated details
			driver.findElement(By.xpath("//img[@src=\"/img/overall.jpg\"]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Lancia')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Delta')]")).click();
			Thread.sleep(3000);
			WebElement changedDetailsF = driver.findElement(By.xpath("//td[contains(text(),'Tom_Test')]"));
			//js.executeScript("arguments[0].scrollIntoView();", changedDetailsF);
			Thread.sleep(3000);
			String changedDetailsFistLastName = changedDetailsF.getText();
			String changedFnameLname = "Tom_Test5"+" "+"Harry_Test5";
			Assert.assertEquals(changedDetailsFistLastName,changedFnameLname);
			  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://buggy.justtestit.org");
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Test_Uname6");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
	  	driver.quit();
  }

}
