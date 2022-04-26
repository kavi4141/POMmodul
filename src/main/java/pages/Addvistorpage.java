package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Testbase;
import commonutility.Datepicker;
import commonutility.utilities;

public class Addvistorpage extends Testbase {
	@FindBy(xpath="//h3[text()='Visitor List']")WebElement vistortitle;
	@FindBy(css="div.box-tools>a") WebElement addvistor;
	@FindBy(xpath="//h4[text()=' Add Visitor']")WebElement addvistortitle;
	@FindBy(css="form#formadd select[name='purpose']")WebElement purpose;
	@FindBy(css="form#formadd input[name='name']")WebElement name;
	@FindBy(css="form#formadd input[name='contact']")WebElement phoneno;
	@FindBy(css="form#formadd input[name='id_proof']")WebElement idcard;
	@FindBy(css="form#formadd input[name='pepples']")WebElement noperson;
	@FindBy(css="form#formadd input[name='date']")WebElement date;
	@FindBy(css="form#formadd textarea[name='note']")WebElement note;
	@FindBy(css="form#formadd input[name='file']")WebElement addfile;
	@FindBy(css="button.close")WebElement btncls;
	
	public Addvistorpage() {
		PageFactory.initElements(driver, this);
	}
	//script to check add vistor title
		public String getvistortitle() {
			return vistortitle.getText();
			
		}
		//script to click add vistor
		public void clickaddvistor() {
			addvistor.click();
		}
		//script to get vistor page title
		public String getaddvistortitle() {
			waitforvisibility(addvistortitle);
			return addvistortitle.getText();
			
		}
		
		//script to enter the vistor deatils
		public void vistordetail(String vd[]) {
			Select sdrp=new Select(purpose);
			sdrp.selectByVisibleText(vd[0]);
			name.sendKeys(vd[1]);
			phoneno.sendKeys(vd[2]);
			idcard.sendKeys(vd[3]);
			noperson.sendKeys(vd[5]);
			//datepicker
			date.click();
			Datepicker dt = new Datepicker();
			dt.datpicker(vd[4]);
			note.sendKeys(vd[6]);
			//upload
			utilities.mouseclick(addfile);
			utilities.fileupload(vd[7]);
			
		}

}
