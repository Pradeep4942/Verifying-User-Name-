package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_01_HomePage 
{
	@FindBy(xpath = "(//a[@class='dropdown-toggle'])[10]")private WebElement logout;
	@FindBy(xpath ="//a[text()='Logout']")private WebElement ClickOnlogout;
	@FindBy (xpath ="//a[text()='BBLM24363 ']")private WebElement ProfileName;
	public POM_01_HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LogoutFromApp (WebDriver driver) throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(logout).perform();
		Thread.sleep(7000);
		act.click(ClickOnlogout).perform();
	}
	
	public String UserId ()
	{
		String ActualName = ProfileName.getText();
		return ActualName;
	}

}
