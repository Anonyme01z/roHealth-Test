import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class danielTest {
	private WebDriver driver;
    private String facebookUsername = "dannyboy";
    private String facebookPassword = "daniel12345";
    
  @Test
  public void testAutomation() {
      // facebook login
      driver.get("https://www.facebook.com/");
      driver.findElement(By.id("email")).sendKeys(facebookUsername);
      driver.findElement(By.id("pass")).sendKeys(facebookPassword);
      driver.findElement(By.name("login")).click();

      // facebook post
      WebElement postTextArea = driver.findElement(By.xpath("//div[@data-testid='status-attachment-mentions-input']"));
      postTextArea.sendKeys("I Kill Bugs!");
      driver.findElement(By.xpath("//span[text()='Post']")).click();

      // google search
      driver.get("https://www.google.com/");
      driver.findElement(By.name("q")).sendKeys("best QA Engineering practices");
      driver.findElement(By.name("btnK")).submit();
  }
  
  @BeforeMethod
	  public void setUp() {
	        System.setProperty("webdriver.chromedriver", "drivers/chromedriver");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
