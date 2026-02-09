package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	
	@Test
	public void verifyWhetherUserisAbletoLogoutSuccessfully() throws IOException {
	
	String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
	String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
	LoginPage login = new LoginPage(driver);
	login.enterUsernameOnUsernameField(usernamevalue);
	login.enterPasswordOnPasswordField(passwordvalue);
	login.clickOnLoginButton();
	
	HomePage home = new HomePage(driver);
	home.cliclonAdminLogoutIcon();
	home.cliclonLogoutButton();
	
	}

}
