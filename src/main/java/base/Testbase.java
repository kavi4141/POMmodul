package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonutility.Activitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver event;
	 public static Activitycapture actcap;
	 public Testbase()
	 {
		 try {
			FileInputStream ipconfig=new FileInputStream("./src/main/java/config/appconfig.properties");
			prop=new Properties();
			prop.load(ipconfig);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static  void initilization() {
		 String runbrowser=prop.getProperty("Browser");
		 String mode=prop.getProperty("Headless");
		 if(runbrowser.equals("chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 if(mode.equals("true"))
			 {
				 ChromeOptions op=new ChromeOptions();
				 op.addArguments("----headless");
				 driver=new ChromeDriver(op);
				  
			 }else {
				 driver=new ChromeDriver();
			 }
		 }else if(runbrowser.equals("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		 }else if(runbrowser.equals("edge")) {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		 }else {
			 System.out.println("Check the name of the browser");
			
		 }
		 
		 //basic methods
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.get(prop.getProperty("URL"));
		 
		 event=new EventFiringWebDriver(driver);
		 actcap=new Activitycapture();
		 event.register(actcap);
		 driver=event;
	 }
		 
		 public static void waitforvisibility(WebElement el) {
			 WebDriverWait wt =new WebDriverWait(driver, Duration.ofSeconds(3000));
			 wt.until(ExpectedConditions.visibilityOf(el));
		 }
	 

}
