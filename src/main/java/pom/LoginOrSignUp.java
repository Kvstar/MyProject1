package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUp {
	@FindBy (xpath="//img[@class='fb_logo _8ilh img']")
	private WebElement logo;
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement emailAddressOrPhoneNumber;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[text()='Log In']")
	private WebElement logIn;
	
	public LoginOrSignUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public boolean checkLogoOfFacebook()
	{
		boolean img=logo.isDisplayed();
		return img;
	}
	
	public void sendToEmailAddressOrPhoneNumber(String email)
	{
		emailAddressOrPhoneNumber.sendKeys(email);
	}
	
	public void sendToPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public String getTextOfLoginButton()
	{
		String text=logIn.getText();
		return text;
	}
	
	public void clickOnLOgInButton()
	{
	   logIn.click();
	}
	public void login(String email,String pass)
	{
		emailAddressOrPhoneNumber.sendKeys(email);
		password.sendKeys(pass);
		 logIn.click();
	}



}
