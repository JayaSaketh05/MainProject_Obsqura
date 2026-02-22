package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import automationcore.TestNGBase;
import constants.Constants;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	HomePage homepage;
	
	@Test(priority=1,description="Validating Userlogin with valid credentials",groups= {"smoke"})  // all the testcases needed description but priority is not mandatory
	public void verifyUserLoginWithValidCredentials() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		homepage = login.clickOnLoginButton();
		
		boolean dashboardDisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constants.VALIDCREDENTIALERROR);
		// Assert.assertFalse(!dashboardDisplay, Constants.VALIDCREDENTIALERROR);
		
		
	
	}
	
	
	@Test(priority=2,description="Validating Userlogin with valid Username & Invalid Password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = login.dashboardText();
		Assert.assertEquals(expected, actual, Constants.INVALIDPASSWORDERROR);
		
		
		
	}
	
	
	@Test(priority=3,description="Validating Userlogin with Invalid Username & Valid Password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
				
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = login.dashboardText();
		Assert.assertEquals(expected, actual, Constants.INVALIDUSERNAMEERROR);
		
		
	}
	
	
	@Test(priority=4,description="Validating Userlogin with Invalid credentials",groups={"smoke"}, dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String usernamevalue, String passwordvalue) throws IOException {
		
	//	String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
	//	String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = login.dashboardText();
		Assert.assertEquals(expected, actual, Constants.INVALIDCREDENTIALSERROR);
		
		
	}
	
	 @DataProvider(name = "loginProvider") 
	 	public Object[][] getDataFromDataProvider() throws IOException { 
	  
	 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
	 				// new Object[] {ExcelUtility.getStringData(3, 
	 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} 
	 		}; 
	 	}

}
