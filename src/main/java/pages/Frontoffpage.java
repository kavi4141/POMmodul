package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Frontoffpage extends Testbase {
	@FindBy(xpath="//h3[text()='Appointment Details']")WebElement ffpagetitle;
	@FindBy(css="div.box-tools>a:nth-child(2)")WebElement vistorbook;
	
	public Frontoffpage() {
		PageFactory.initElements(driver, this);
	}
	//script to check add vistor page title
	public String getpagetitle() {
		return ffpagetitle.getText();
		
	}
	//script to click  vistorbook
	public Addvistorpage clickvistor() {
		vistorbook.click();
		return new Addvistorpage();
	}
	//script to check add vistor title
	/*public boolean getvistortitle() {
		return vistortitle.isDisplayed();
		
	}
	//script to click add vistor
	public void clickaddvistor() {
		addvistor.click();
	}
	//script to get vistor page title
	public boolean getvistorlisttitle() {
		return vistorpagetitle.isDisplayed();
		
	}*/

}
