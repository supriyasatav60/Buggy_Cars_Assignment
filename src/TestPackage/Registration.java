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

public class Registration {
	public WebDriver driver ;
	
  @Test
  public void verifyRegistration() {
	  driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Test_Uname8");
		driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("James");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Smith");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Password@123");
		driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("Password@123");
		driver.findElement(By.xpath("//button[text() ='Register']")).click();
		WebElement msg = driver.findElement(By.xpath("//div[@class='result alert alert-success']"));
		String actualMsg = msg.getText();
		String expectedText = "Registration is successful";
		Assert.assertEquals(actualMsg, expectedText);
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Documents\\chromedriver.exe");
	  	driver = new ChromeDriver();
		driver.get("https://buggy.justtestit.org/register");
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
  }

  @AfterTest
  public void afterTest() {
	 driver.quit();
  }

}
