package hms.admin.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Testbase;
import pages.Loginpage;

public class Logintest extends Testbase {
	Loginpage objlog;
	public Logintest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initilization();
		objlog=new Loginpage();
	}
	@Test
	public void logintest() {
		String expectedtitle="Smart Hospital : Hospital Management System";
		Assert.assertEquals(objlog.getpagetitle(),expectedtitle);
		Assert.assertTrue(objlog.logomth());
		String expectedadmintxt= "Admin Login";
		Assert.assertEquals(objlog.getlogintxt(), expectedadmintxt);
		objlog.loginpage(prop.getProperty("Username"), prop.getProperty("Password"));
		String expectedlogintext="Smart Hospital Management System";
		Assert.assertEquals(objlog.getpagetitle(), expectedlogintext);
		
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
