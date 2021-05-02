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

public class LoginWithChangedPassword {
	
	public WebDriver driver ;
	
  @Test
  public void loginWthChangedPwd() throws Exception {
	  	//Select Profile
		driver.findElement(By.xpath("//a[@href='/profile']")).click();
		Thread.sleep(3000);
		
		//Change password
		driver.findElement(By.xpath("//input[@name='currentPassword']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@name='newPassword']")).sendKeys("Password@456");
		driver.findElement(By.xpath("//input[@name='newPasswordConfirmation']")).sendKeys("Password@456");
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(3000);
		WebElement detailsSavedText = driver.findElement(By.xpath("//div[@class='result alert alert-success hidden-md-down']"));
		String detailsSavedMsg = detailsSavedText.getText();
		String expectedMsg = "The profile has been saved successful";
		Assert.assertEquals(detailsSavedMsg, expectedMsg);
				
		
		//Logout
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		Thread.sleep(3000);
				
		//Login with new password
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Test_Uname7");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password@456");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(3000);
				
		//Verify URL
		String currentURL = driver.getCurrentUrl();
		String profileURL= "https://buggy.justtestit.org/profile";
		Assert.assertEquals(currentURL, profileURL);

  }
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://buggy.justtestit.org");
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Test_Uname7");
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
