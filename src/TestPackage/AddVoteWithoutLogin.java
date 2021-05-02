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

public class AddVoteWithoutLogin {
	
	String expectedMsg = "You need to be logged in to vote.";
	public WebDriver driver ;
	
  @Test
  public void verifyAddvote() throws Exception {
	  	//To verify add vote for popular Make
		driver.findElement(By.xpath("//img[@title='Lamborghini']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Veneno')]")).click();
		WebElement voteMsgVeneno = driver.findElement(By.xpath("//p[@class='card-text']"));
		String actualMsgVeneno = voteMsgVeneno.getText();
		Thread.sleep(3000);
		Assert.assertEquals(actualMsgVeneno, expectedMsg);
		
		//To navigate to home page
		driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();
		
		//To verify add vote for popular model
		driver.findElement(By.xpath("//img[@title='Diablo']")).click();
		WebElement voteMsg = driver.findElement(By.xpath("//p[@class='card-text']"));
		String actualMsgDiablo = voteMsg.getText();
		Thread.sleep(3000);
		Assert.assertEquals(actualMsgDiablo, expectedMsg);
		
		//To navigate to home page
		driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();	
		
		//To Verify add vote for Overall Rating for Model - Zonda
		driver.findElement(By.xpath("//img[@src=\"/img/overall.jpg\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Zonda')]")).click();
		WebElement MsgZonda = driver.findElement(By.xpath("//p[@class='card-text']"));
		String voteMsgZonda = MsgZonda.getText();
		Assert.assertEquals(voteMsgZonda, expectedMsg);

  }
  @BeforeTest
  public void beforeTest() {
	  
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://buggy.justtestit.org");
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
