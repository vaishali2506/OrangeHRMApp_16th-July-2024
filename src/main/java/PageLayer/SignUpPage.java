package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilityLayer.Wait;

public class SignUpPage extends BaseClass {
	
	@FindBy(name="firstname")
	private WebElement fname;
	
	@FindBy(name="lastname")
	private WebElement lname;
	
	public SignUpPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void validateSignUpFunctionality(String Firstname, String Lastname) {
		
		Wait.sendKeys(fname, Firstname);
		Wait.sendKeys(lname, Lastname);
	}
}
