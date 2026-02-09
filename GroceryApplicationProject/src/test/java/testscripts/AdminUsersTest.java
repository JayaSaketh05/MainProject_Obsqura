package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends TestNGBase {
	
	@Test
	public void verifyWhetherUserIsAbleToAddNewUserSuccessfully() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminUsersButton();
		
		AdminUsersPage adminUsers = new AdminUsersPage(driver);
		
		adminUsers.clickOnNewButton();
		adminUsers.enterNewUsername();
		adminUsers.enterPassword();
		adminUsers.selectNewUserType();
		adminUsers.clickOnSaveButton();
	}
	
	@Test
	public void verifyWhetherUserIsAbleToSearchNewlyAddedAdmin() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminUsersButton();
		
		AdminUsersPage adminUsers = new AdminUsersPage(driver);
		
		adminUsers.clickOnMainSearchButton();
		adminUsers.enterUsername();
		adminUsers.selectUserType();
		adminUsers.clickOnSearchButtonToFind();
	}
	
	@Test
	public void verifyWhetherResetButtonIsWorking() throws IOException {
		verifyWhetherUserIsAbleToSearchNewlyAddedAdmin();
		AdminUsersPage adminUsers = new AdminUsersPage(driver);
		adminUsers.clickOnResetButton();
	}
	
	@Test
	public void runAllMethods() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminUsersButton();
		
		AdminUsersPage adminUsers = new AdminUsersPage(driver);
		
		//Method-1 New user creation
		adminUsers.clickOnNewButton();
		adminUsers.enterNewUsername();
		adminUsers.enterPassword();
		adminUsers.selectNewUserType();
		adminUsers.clickOnSaveButton();
		
		//Method-2 Searching the newly created user 
		adminUsers.clickOnMainSearchButton();
		adminUsers.enterUsername();
		adminUsers.selectUserType();
		adminUsers.clickOnSearchButtonToFind();
		
		//Method-3 Checking the reset button
		adminUsers.clickOnResetButton();
	}
	
}
