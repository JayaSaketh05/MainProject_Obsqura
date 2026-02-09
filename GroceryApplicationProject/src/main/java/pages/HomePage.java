package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement adminLogoutIcon;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logoutButton;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")WebElement manageNewsButton;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")WebElement adminUsersButton;
	
	public void cliclonAdminLogoutIcon() {
		adminLogoutIcon.click();
	}
	
	public void cliclonLogoutButton() {
		logoutButton.click();
	}
	
	public void clickOnManageNewsButton() {
		manageNewsButton.click();
	}
	
	public void clickOnAdminUsersButton() {
		adminUsersButton.click();
	}
	
	
	

}
