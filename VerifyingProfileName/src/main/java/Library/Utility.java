package Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
	/* This method used for fetching the data from Excel sheet
	 * Its required two parameter pass for row and cell
	 * So i am fetch the only password from excel
	 */
	public static String ExcelSheet (int row ,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("D:\\Testing files\\Angleapk.xlsx");
		String value = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

	/* This method used for fetching the data from PropertyFile
	 * Mainly i fetching the User name and URL
	 * also Expected user name 
	 */
	public static String PropertyFile (String key) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\workspace\\VerifyingProfileName\\PropertyFile.properties");
		Properties property = new Properties();
	    property.load(file);
		 String Data = property.getProperty(key);
		return Data;
	}
	
	public static void ScreenShot (WebDriver driver ,int TCID) throws IOException
	{
		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File dest = new File("C:\\Users\\Admin\\eclipse-workspace\\workspace\\VerifyingProfileName\\ScreenShot\\Report01"+TCID+".jpg");
		 FileHandler.copy(src, dest);
	}
}
