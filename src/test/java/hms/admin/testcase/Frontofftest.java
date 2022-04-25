package hms.admin.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Dashboradpage;
import pages.Frontoffpage;
import pages.Loginpage;

public class Frontofftest extends Testbase {
	Loginpage objlog;
	Dashboradpage objdb;
	Frontoffpage objfo;
	public Frontofftest() {
		super();
	
	}
	@BeforeMethod
	public void setup() {
		initilization();
		objlog=new Loginpage();
		objdb=objlog.loginpage(prop.getProperty("Username"),prop.getProperty("Password"));
		objfo=objdb.clickonfrontoff();
	}
	@Test
	public void clickvistorbook() {
		String expectedfftitle="Appointment Details";
		Assert.assertEquals(objfo.getpagetitle(), expectedfftitle);
		objfo.clickvistor();
		/*String expectedvistortitle="Visitor List";
		Assert.assertEquals(objfo.getvistortitle(), expectedvistortitle);
		objfo.clickaddvistor();
		String expectedvistorlist="Add Visitor";
		Assert.assertEquals(objfo.getvistorlisttitle(), expectedvistorlist);*/
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
