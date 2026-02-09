package automationcore;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;

public class TestNGBase {
	
public WebDriver driver;
	
	@BeforeMethod
	public void initialiseBrowser()
	{
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException { 
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
  
 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
 			screenShot.getScreenshot(driver, iTestResult.getName());
 		} 
 		//driver.quit();
 	
  
 	}
 	
	
}
