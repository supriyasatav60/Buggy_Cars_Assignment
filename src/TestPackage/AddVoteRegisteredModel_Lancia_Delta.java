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

public class AddVoteRegisteredModel_Lancia_Delta {
	
	public WebDriver driver ;
	
  @Test
  public void addVoteLanciaDelta() throws Exception {
	//Select home page
		driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();
		
		//Select model Delta
		driver.findElement(By.xpath("//img[@src=\"/img/overall.jpg\"]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Lancia')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Delta')]")).click();
		
		// To retrive current number of votes
		WebElement voteCount = driver.findElement(By.xpath("//h4[contains(text(),'Votes:')]//strong[contains(text(),'632')]"));
		int customCount = Integer.parseInt(voteCount.getText());
		
		//Add comment and vote
		driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys("Testing new comments for add vote");
		driver.findElement(By.xpath("//button[text() ='Vote!']")).click();
		
		//To verify vote added successfully
		WebElement MsgDelta = driver.findElement(By.xpath("//p[@class='card-text']"));
		String voteMsgDelta = MsgDelta.getText();
		String expectedVoteMsg = "Thank you for your vote!";
		Assert.assertEquals(voteMsgDelta, expectedVoteMsg);
		
		//To verify vote count
		WebElement increasedVoteCount = driver.findElement(By.xpath("//h4[contains(text(),'Votes:')]//strong[contains(text(),'633')]"));
		Thread.sleep(3000);
		int increasedCustomCount1 = Integer.parseInt(increasedVoteCount.getText());
		Assert.assertEquals(increasedCustomCount1, (customCount+1));
		
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shree\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://buggy.justtestit.org");
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		
		//Login
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Test_Uname5");
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
