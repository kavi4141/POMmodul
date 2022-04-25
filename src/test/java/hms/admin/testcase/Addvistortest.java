package hms.admin.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Testbase;
import commonutility.ReadExcel;
import pages.Addvistorpage;
import pages.Dashboradpage;
import pages.Frontoffpage;
import pages.Loginpage;

public class Addvistortest extends Testbase {
	Loginpage objlog;
	Dashboradpage objdb;
	Frontoffpage objfo;
	Addvistorpage objav;
	public Addvistortest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initilization();
		objlog=new Loginpage();
		objdb=objlog.loginpage(prop.getProperty("Username"),prop.getProperty("Password"));
		objfo=objdb.clickonfrontoff();
		objav=objfo.clickvistor();
	}
	
	@DataProvider
	public Object[][] getvistordata(){
		Object[][] data=ReadExcel.getTestData("testdata");
		return data;
	}
	@Test(dataProvider = "getvistordata")
	public void addvistor(String vis[]) {
		String expectedvistortitle="Visitor List";
		Assert.assertEquals(objav.getvistortitle(), expectedvistortitle);
		objav.clickaddvistor();
		String expectedaddvistor="Add Visitor";
		Assert.assertEquals(objav.getaddvistortitle(), expectedaddvistor);
		objav.vistordetail(vis);
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
