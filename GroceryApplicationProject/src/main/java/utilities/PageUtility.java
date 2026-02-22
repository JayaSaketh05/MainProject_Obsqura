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
	
	public void selectDropDownByVisibleText(WebElement element, String value) {
		
		Select object = new Select(element);
		object.selectByVisibleText(value);
	}
	
	public void deselectDropDownByVisibleText(WebElement element, String value) {
	    
	    Select object = new Select(element);
	    object.deselectByVisibleText(value);
	}
	
	public void selectDropDownByIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
	}
	
	public boolean isMultiple(WebElement element) {
	    
	    Select object = new Select(element);
	    return object.isMultiple();
	}
	
	
}
