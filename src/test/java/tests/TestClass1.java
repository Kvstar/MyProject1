package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.AtulGholapFriend;
import pom.Facebook;
import pom.LoginOrSignUp;

public class TestClass1 {
	
	public static void main(String[] args) {
		
		 System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://www.facebook.com/");
		 
		 LoginOrSignUp loginOrSignUp = new LoginOrSignUp(driver);
	//	 loginOrSignUp.login("8007877390", "Vishal@95");
		 
		 boolean result=loginOrSignUp.checkLogoOfFacebook();
		 if(result==true)
			{
				System.out.println("logo is displyed");
			}
			else
			{
				System.out.println("logo is not displyed");
			}
		 loginOrSignUp.sendToEmailAddressOrPhoneNumber("8007877390");
		 loginOrSignUp.sendToPassword("Vishal@95");
		 String loginText = loginOrSignUp.getTextOfLoginButton();
		 if(loginText.equals("Log In"))
		    {
		    	System.out.println("text is correct");
		    }
		    else
		    {
		    	System.out.println("test is wrong");
		    }
		 
		 loginOrSignUp.clickOnLOgInButton();
		 
		 Facebook facebook = new Facebook(driver);
		 facebook.clickOnSearch();
		 facebook.sendToSearchBar();
		 facebook.clickOnAtulGholap();
		 facebook.finalClickOnAtulGholap();
		 
		 AtulGholapFriend atulGholapFriend = new AtulGholapFriend(driver);
		 atulGholapFriend.clickOnAddFriendButton();
		 atulGholapFriend.clickOnCancleFriendButton();
		 
		 facebook.clickOnRollButton();
		 facebook.clickOnLogOut();
		 
	}

}
