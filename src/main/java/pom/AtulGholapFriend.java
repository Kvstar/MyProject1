package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtulGholapFriend {

	@FindBy (xpath="//span[text()='Add Friend']")
	private WebElement addFriend;
	
	@FindBy (xpath="//span[text()='Cancel Request']")
	private WebElement CancleFriend;
	
	public AtulGholapFriend(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddFriendButton()
	{
		addFriend.click();
	}
	public void clickOnCancleFriendButton()
	{
		CancleFriend.click();
	}
	
}
