package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']")WebElement loginButton;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboardTile;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginText;
	
	
	public LoginPage enterUsernameOnUsernameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;
	}
	
	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed() {
		return dashboardTile.isDisplayed();
	}
	
	public String dashboardText() {
		return loginText.getText();
	}
	
	

}
