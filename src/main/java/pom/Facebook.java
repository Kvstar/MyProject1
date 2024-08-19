package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Facebook {
	private WebDriverWait wait;
	
	@FindBy (xpath="//label[contains(@class,'br7hx15l h2jyy9rg')]")
	private WebElement search;
	
	@FindBy (xpath="//input[@type='search']")
	private WebElement searchBar;
	
	@FindBy (xpath="(//i[@class='hu5pjgll m6k467ps'])[1]")
	private WebElement searchForAtulGholap;
	
	@FindBy (xpath="(//span[text()='Atul Gholap'])[1]")
	private WebElement AtulGholap;
	
	@FindBy (xpath="(//div[@role='button'])[3]")
	private WebElement rollButton;
	
	@FindBy (xpath="//span[text()='Log Out']")
	private WebElement logOut;
	
	public Facebook(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
	}
	
	public void clickOnSearch()
	{
		search.click();
	}
	public void sendToSearchBar()
	{
		searchBar.sendKeys("atul gholap");
	}
	public void clickOnAtulGholap()
	{
		wait.until(ExpectedConditions.visibilityOf(searchForAtulGholap));
		searchForAtulGholap.click();
	}
	public void finalClickOnAtulGholap()
	{
		AtulGholap.click();
	}
	public void clickOnRollButton()
	{
		rollButton.click();
	}
	public void clickOnLogOut()
	{
		logOut.click();
	}


}
