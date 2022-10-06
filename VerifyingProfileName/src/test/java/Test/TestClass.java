package Test;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.Base;
import Library.Utility;
import POM.POM_01_HomePage;
import POM.POM_01_LoginPage;
import POM.POM_01_Popups;


public class TestClass extends Base
{
	POM_01_LoginPage Login1;
	POM_01_Popups Login2;
	POM_01_HomePage Login3;
	int TCID;
		
	@BeforeClass
	public void BrowserOpnig() throws IOException 
	{
		BaseClass();
		
		Login1 = new POM_01_LoginPage(driver);
		Login2 = new POM_01_Popups(driver);
		Login3 = new POM_01_HomePage(driver);		
	}
	
	@BeforeMethod
	public void Login () throws InterruptedException, EncryptedDocumentException, IOException
	{
		Login1.UserName(Utility.PropertyFile("UserName"));
		Login1.Password(Utility.ExcelSheet(0, 1));
		Login1.ClickOnLogin();
		Login2.ClosePopups();
	}
	
	@Test
	public void Verifying () throws IOException
	{
		TCID =101;
		String ActualName = Login3.UserId();
		String EXPECTEDUSERID = Utility.PropertyFile("Expected");
		
		if (ActualName.equals(EXPECTEDUSERID))
		{
			System.out.println("Result: Pass both are same");
		}
		else 
		{
			System.out.println("Result: Fail both are different");
		}
	}
	
	@AfterMethod
	public void CloseApp (ITestResult result) throws InterruptedException, IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			Utility.ScreenShot(driver, TCID);
		}
		Login3.LogoutFromApp(driver);
	}
	
	@AfterClass
	public void CloseBrowser ()
	{
		driver.close();
	}

}
