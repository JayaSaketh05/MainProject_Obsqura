package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {
	
	HomePage homepage;
	
	@Test(retryAnalyzer = retry.RetryMechanism.class,description="Verifying whether User is able to Logout successfully")
	public void verifyWhetherUserisAbletoLogoutSuccessfully() throws IOException {
	
	String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
	String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
	
	LoginPage login = new LoginPage(driver);
	login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
	homepage = login.clickOnLoginButton();
	
	homepage.cliclonAdminLogoutIcon();
	login = homepage.cliclonLogoutButton();
	
	String expected = "7rmart supermarket";
	String actual = login.dashboardText();
	Assert.assertEquals(expected, actual, Constants.LOGOUTERROR);
	
	}

}
