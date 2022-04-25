package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Dashboradpage extends Testbase {
	@FindBy(css="ul.sidebar-menu>li")WebElement clickfrontoff;
	public Dashboradpage() {
		PageFactory.initElements(driver, this);
	}
	//script to click on frontoffice
	public Frontoffpage clickonfrontoff() {
		clickfrontoff.click();
		return new Frontoffpage();
	}

}
