package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;

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
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newsCreatedAlert;
	
	@FindBy(id="res")WebElement newsSearch;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement newsResetButton;
	
	
	
	
	public ManageNewsPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public ManageNewsPage enterNews(String news) {
		newsBox.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	
	public ManageNewsPage clickOnSearchButton() {
		searchButtonOne.click();
		return this;
	}
	
	public ManageNewsPage enterNewsInSearchBox(String news) {
		searchTextBox.sendKeys(news);
		return this;
	}
	
	public ManageNewsPage clickOnVerifyingSearchButton() {
		searchButtonTwo.click();
		return this;
	}
	
	public ManageNewsPage clickOnResetButton() {
		resetButton.click();
		return this;
	}
	
	public boolean isNewsAddedSuccessfully() {
	    return newsCreatedAlert.getText().contains(Constants.NEWSADDEDALERT);
	}
	
	public boolean isUserAbleToSearchNews() {
		return newsSearch.getText().contains(Constants.NEWSNOTFOUNDERROR);
	}
	
	public boolean isNewsResetButtonClickable() {
		return newsResetButton.getText().contains(Constants.NEWSRESET);
	}
	

}
