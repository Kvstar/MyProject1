package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.Facebook;
import pom.LoginOrSignUp;


public class TestNgTestClass {
	WebDriver driver;
	LoginOrSignUp loginOrSignUp;
	
	@BeforeClass
	public void launchTheBrowser() {
		 System.out.println("Before Class");
		// System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	   //  driver = new ChromeDriver();
	     System.setProperty("webdriver.gecko.driver", "C:\\Users\\ASUS\\Downloads\\geckodriver.exe");
		   driver = new FirefoxDriver();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void loginToApplication() {
		 System.out.println("before method");
		 driver.get("https://www.facebook.com/");
		 loginOrSignUp = new LoginOrSignUp(driver);
		 boolean result=loginOrSignUp.checkLogoOfFacebook(); 
		 SoftAssert  softAssert=new  SoftAssert();
		 softAssert.assertTrue(result);
		
		 loginOrSignUp.sendToEmailAddressOrPhoneNumber("8007877390");
		 loginOrSignUp.sendToPassword("Vishal@95");
		 softAssert.assertAll();
		
	}
	
	@Test
	public void checkTextOfLoginButton( ) {
		System.out.println("test 1");
		 String loginText = loginOrSignUp.getTextOfLoginButton();
		 SoftAssert  softAssert=new  SoftAssert();
		 softAssert.assertEquals(loginText, "Log In");
		 
	}	 
    @Test
    public void loginIntoFacebook() {
			System.out.println("test2");
			loginOrSignUp.clickOnLOgInButton();
			String URL=driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://www.facebook.com/","URL of facebook home page is verified");
			System.out.println(URL);
		
	}
	
	@AfterMethod
	public void logoutFromTheApplication() {
		System.out.println("after method");
	//	Facebook facebook = new Facebook(driver);
	//	 facebook.clickOnRollButton();
	//	 facebook.clickOnLogOut();	
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
		driver.close();;
	}
	

}
