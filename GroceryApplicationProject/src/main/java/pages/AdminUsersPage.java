package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;
import utilities.PageUtility;

public class AdminUsersPage {
	
public WebDriver driver;

PageUtility page = new PageUtility();
	
	public AdminUsersPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton;
	@FindBy(xpath="//select[@name='user_type']")WebElement userTypeDropdown1;
	@FindBy(id="username")WebElement usernameBox1;
	@FindBy(id="password")WebElement passwordBox;
	@FindBy(xpath="(//button[@type='submit'])[2]")WebElement saveButton;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchMainButton;
	@FindBy(xpath="//input[@name='un']")WebElement usernameBox2;
	@FindBy(id="ut")WebElement userTypeDropdown2;
	@FindBy(xpath="(//button[@type='submit'])[1]")WebElement searchFinalButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement resetButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement loginAlert;
	
	public AdminUsersPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public AdminUsersPage selectNewUserType() {
		
		page.selectDropDownWithVisibleText(userTypeDropdown1, Constants.DROPDOWNVALUE1);
		return this;
		
	/*	Select select = new Select(userTypeDropdown1);
		select.selectByValue("admin");
		return this;
	*/
	}
	
	public AdminUsersPage enterNewUsername(String newusername) {
		usernameBox1.sendKeys(newusername);
		return this;
	}
	
	public AdminUsersPage enterPassword(String newpassword) {
		passwordBox.sendKeys(newpassword);
		return this;
	}
	
	public AdminUsersPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}
	
	public AdminUsersPage clickOnMainSearchButton() {
		searchMainButton.click();
		return this;
	}
	
	public AdminUsersPage enterUsername(String username) {
		usernameBox2.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage selectUserType() {
		
		page.selectDropDownWithVisibleText(userTypeDropdown2, Constants.DROPDOWNVALUE1);
		
	/*	Select select = new Select(userTypeDropdown2);
		select.selectByVisibleText("Admin");
	*/
		return this;
	}
	
	public AdminUsersPage clickOnSearchButtonToFind() {
		searchFinalButton.click();
		return this;
	}
	
	public AdminUsersPage clickOnResetButton() {
		resetButton.click();
		return this;
	}
	
	public boolean isUserCreatedSuccessfully() {
	    return loginAlert.getText().contains(Constants.ADMINCREATEDALERT);
	}
	

}
