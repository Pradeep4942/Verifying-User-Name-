package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_01_LoginPage
{
	@FindBy(xpath = "//input[@id='txtUserID']")private WebElement username;
	@FindBy(xpath = "//input[@id='txtTradingPassword']")private WebElement password;
	@FindBy(xpath = "//a[@id='loginBtn']")private WebElement clickonlogin;
	
	
	public POM_01_LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void UserName (String USER)
	{
		username.sendKeys(USER);
	}
	
	public void Password (String PASS)
	{
		password.sendKeys(PASS);
	}
	
	public void ClickOnLogin ()
	{
		clickonlogin.click();
	}

}
