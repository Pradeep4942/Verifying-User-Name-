package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_01_Popups 
{
	@FindBy(xpath = "(//button[@class='close icon-cancel'])[6]")private WebElement closepopup;
	
	public POM_01_Popups(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClosePopups () throws InterruptedException
	{
		Thread.sleep(7000);
		closepopup.click();
	}

}
