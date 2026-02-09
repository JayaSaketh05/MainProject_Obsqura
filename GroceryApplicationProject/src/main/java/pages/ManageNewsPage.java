package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath="//textarea[@id='news']")WebElement newsBox;
	@FindBy(xpath="//button[@name='create']")WebElement saveButton;
	
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchButtonOne;
	@FindBy(xpath="//input[@class='form-control']")WebElement searchTextBox;
	@FindBy(xpath="//button[@type='submit']")WebElement searchButtonTwo;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement resetButton;
	
	
	
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterNews() {
		newsBox.sendKeys("Sample News");
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

	
	public void clickOnSearchButton() {
		searchButtonOne.click();
	}
	
	public void enterNewsInSearchBox() {
		searchTextBox.sendKeys("Sample News");
	}
	
	public void clickOnVerifyingSearchButton() {
		searchButtonTwo.click();
	}
	
	public void clickOnResetButton() {
		resetButton.click();
	}

}
