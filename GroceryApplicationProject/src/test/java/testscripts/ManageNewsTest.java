package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase {
	
	
	@Test(description="Verifying whether User is able to add New News")
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
		
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		manageNews.enterNews(news);
		manageNews.clickOnSaveButton();
		
	}
	
	@Test(description="Verifying whether User is able to Search the News")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNews() throws IOException {
		
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue);
		login.enterPasswordOnPasswordField(passwordvalue);
		login.clickOnLoginButton();
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnManageNewsButton();
		
		String news = ExcelUtility.getStringData(0, 0, "ManageNewsPage");
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		
		manageNews.clickOnSearchButton();
		
		
		manageNews.enterNewsInSearchBox(news);
		manageNews.clickOnVerifyingSearchButton();
	}
	
	@Test(description="Verifying whether User is able to Manage the Reset Button")
	public void verifyUserIsAbleToManageReset() throws IOException {
		
		verifyWhetherUserIsAbleToSearchNewlyAddedNews();
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.clickOnResetButton();
		
	}

}
