package hms.admin.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Dashboradpage;
import pages.Loginpage;

public class Dashboradtest extends Testbase {
	Loginpage objlog;
	Dashboradpage objdb;
	public Dashboradtest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilization();
		objlog=new Loginpage();
		objdb=objlog.loginpage(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	@Test
	public void clickfrontoff() {
		objdb.clickonfrontoff();
		
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
