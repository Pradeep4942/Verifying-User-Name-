package Library;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base 
{
	public WebDriver driver;
	@SuppressWarnings("deprecation")
	public void BaseClass() throws IOException 
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\chrome\\chromedriver_win32\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(Utility.PropertyFile("URL"));
		driver.manage().window().maximize();
	}

}
