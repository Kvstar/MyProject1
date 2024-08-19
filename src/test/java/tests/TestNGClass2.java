package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.AtulGholapFriend;
import pom.Facebook;
import pom.LoginOrSignUp;

public class TestNGClass2 {
	WebDriver driver;
	LoginOrSignUp loginOrSignUp;
	Facebook facebook;
	AtulGholapFriend atulGholapFriend;
	
	@BeforeTest
	@Parameters("browser")
	public void launchTheBrowser(String browser) {
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")){
		   System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		   driver = new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
	       System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\Downloads\\geckodriver.exe");
		   driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void createPOMObjects() {
		 System.out.println("Before Class");
		 loginOrSignUp = new LoginOrSignUp(driver);
		 facebook = new Facebook(driver);
		 atulGholapFriend = new AtulGholapFriend(driver);
	}
	
	
	@BeforeMethod
	public void loginToApplication() {
		 System.out.println("before method");
		 driver.get("https://www.facebook.com/");
		 loginOrSignUp.sendToEmailAddressOrPhoneNumber("8007877390");
		 loginOrSignUp.sendToPassword("Vishal@95");
		 loginOrSignUp.clickOnLOgInButton();
	}
	
	@Test
	public void sendFriendRequstToAtulGholap( ) {
		 System.out.println("test 1");
	     facebook.clickOnSearch();
		 facebook.sendToSearchBar();
		 facebook.clickOnAtulGholap();
		 facebook.finalClickOnAtulGholap();
		 atulGholapFriend.clickOnAddFriendButton();
		 atulGholapFriend.clickOnCancleFriendButton();
    }
	
	@AfterMethod
	public void logoutFromTheApplication() {
		System.out.println("after method");
		facebook.clickOnRollButton();
		facebook.clickOnLogOut();	
	}
	
	@AfterClass
	public void clearPOMObjects() {
		System.out.println("after class");
		 loginOrSignUp = null;
		 facebook = null;
		 atulGholapFriend = null;
	}
	@AfterTest
	public void closeTheBrowser() {
		System.out.println("after Test");
		driver.quit();
		driver=null;
		System.gc();
	}
	


}
