package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
// import utilities.FakerUtility;

public class AdminUsersTest extends TestNGBase {
	
	@Test(description="Verifying whether User is able to Add New User successfully")
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
		
	/*	FakerUtility faker = new FakerUtility();
		String newusername = faker.createRandomUsername();
		String newpassword = faker.createRandomPassword();
	*/
		
		String newusername = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		String newpassword = ExcelUtility.getStringData(0, 1, "AdminUsersPage");
		adminUsers.enterNewUsername(newusername).enterPassword(newpassword).selectNewUserType().clickOnSaveButton();
		
		Assert.assertTrue(adminUsers.isUserCreatedSuccessfully(), Constants.ADMINNOTCREATEDALERT);
		
	}
	
	@Test(description="Verifying whether User is able to Search the Admin details")
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
		
		String username = ExcelUtility.getStringData(0, 0, "AdminUsersPage");
		adminUsers.enterUsername(username).selectUserType().clickOnSearchButtonToFind();
		
		Assert.assertFalse(!adminUsers.isUserAbleToSearchAdmin(), Constants.ADMINFOUND);
		
	}
	
	@Test(description="Verifying whether Reset button is working successfully")
	public void verifyWhetherResetButtonIsWorking() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAdminUsersButton();
		
		AdminUsersPage adminUsers = new AdminUsersPage(driver);
		adminUsers.clickOnResetButton();
		
		
		Assert.assertTrue(adminUsers.isResetButtonClickable(), Constants.RESETISDISABLED);
		
	}
	
}
