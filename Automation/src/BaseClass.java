import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BaseClass {
	public static FluentWait<WebDriver> wait;
	 public static WebDriver driver = null ;
	
	 @BeforeClass(alwaysRun=true)
	    public void setUp() {
	        try {

			 	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manan\\Desktop\\February\\Weight_Watchers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("disable-infobars");
				 driver = new ChromeDriver(options);
				 
					String baseUrl = Configuration.app_url ;
					driver.get(baseUrl);
					driver.manage().window().maximize();
					Thread.sleep(5000);
	            
	            
	        } catch (Exception e) {
	            
	        }
	    }
	 
	 @AfterClass
	 public void cleanUp()
	 {
		 driver.quit();
		 
	 }
	 
	 public static boolean waitForElementToBeVisible(WebDriver driver, WebElement element) {

	        boolean webElement = false;

	        try {
	            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	            wait = new WebDriverWait(driver, 60)
	                    .ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
	                    .pollingEvery(12, TimeUnit.SECONDS);
	            wait.until(ExpectedConditions.visibilityOf(element));
	     
	            webElement = true;
	        } catch (Exception e) {
	         
	            webElement = false;
	        } finally {
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        }
	        return webElement;
	    }
}
