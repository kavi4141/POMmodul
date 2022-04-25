package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Loginpage extends Testbase {
	@FindBy(tagName = "img")WebElement Logo;
	@FindBy(css="h3.font-white")WebElement logintext;
	@FindBy(css="input.form-username")WebElement username;
	@FindBy(css="input.form-password")WebElement password;
	@FindBy(css="button.btn")WebElement signin;
	@FindBy(css="span.sidebar-session")WebElement logedintext;
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	//script to get logo
	public String getpagetitle() {
		return driver.getTitle();
		
	}
	public boolean logomth() {
		return Logo.isDisplayed();
		
	}
	public String getlogintxt() {
		return logintext.getText();
		
	}
	public Dashboradpage loginpage(String uname,String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		signin.click();
		return new Dashboradpage();
	}
	public boolean titletext() {
		return logedintext.isDisplayed();
		
	}
	
	
	

}
