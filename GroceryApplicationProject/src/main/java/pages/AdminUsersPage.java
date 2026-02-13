package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	
public WebDriver driver;
	
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
	
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void selectNewUserType() {
		Select select = new Select(userTypeDropdown1);
		select.selectByValue("admin");
	}
	
	public void enterNewUsername(String newusername) {
		usernameBox1.sendKeys(newusername);  // replace with excelRead
	}
	
	public void enterPassword(String newpassword) {
		passwordBox.sendKeys(newpassword);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public void clickOnMainSearchButton() {
		searchMainButton.click();
	}
	
	public void enterUsername(String username) {
		usernameBox2.sendKeys(username);
	}
	
	public void selectUserType() {
		Select select = new Select(userTypeDropdown2);
		select.selectByVisibleText("Admin");
	}
	
	public void clickOnSearchButtonToFind() {
		searchFinalButton.click();
	}
	
	public void clickOnResetButton() {
		resetButton.click();
	}

}
