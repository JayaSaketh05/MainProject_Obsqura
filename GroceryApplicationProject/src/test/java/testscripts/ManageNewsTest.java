package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase {
	
	
	@Test
	public void verifyWhetherUserIsAbleToAddNewNewsSuccessfully() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnManageNewsButton();
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		
		manageNews.clickOnNewButton();
		manageNews.enterNews();
		manageNews.clickOnSaveButton();
		
	}
	
	@Test
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNews() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnManageNewsButton();
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		
		manageNews.clickOnSearchButton();
		manageNews.enterNewsInSearchBox();
		manageNews.clickOnVerifyingSearchButton();
	}
	
	@Test
	public void verifyUserIsAbleToManageReset() throws IOException {
		
		verifyWhetherUserIsAbleToSearchNewlyAddedNews();
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnResetButton();
		
	}

}
