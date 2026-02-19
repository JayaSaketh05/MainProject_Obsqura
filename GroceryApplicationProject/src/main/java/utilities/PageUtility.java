package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropDownWithValue(WebElement element, String value) {
		
		Select object = new Select(element);
		object.selectByValue(value);
	}
	
	public void deselectAll(WebElement element, String value) {
		
		Select object = new Select(element);
		object.deselectAll();
	}
	
	public void selectDropDownWithVisibleText(WebElement element, String value) {
		
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}
	
	public void selectDropDownByIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}
	
	
	
	

}
