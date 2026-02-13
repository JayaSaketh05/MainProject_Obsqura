package testscripts;

import java.io.IOException;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.LoginPage;
import automationcore.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	@Test(priority=1,description="Validating Userlogin with valid credentials",groups= {"smoke"})  // all the testcases needed description but priority is not mandatory
	public void verifyUserLoginWithValidCredentials() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
	
	}
	
	
	@Test(priority=2,description="Validating Userlogin with valid Username & Invalid Password")
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
	}
	
	
	@Test(priority=3,description="Validating Userlogin with Invalid Username & Valid Password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
				
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
	}
	
	
	@Test(priority=4,description="Validating Userlogin with Invalid credentials",groups={"smoke"})
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
	}

}
