package researchReviewer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import companyAdminDiy.CompanyAdminDiyMethod;
import login.BasePage;

public class RRTestCase extends BasePage {

	//public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	public static List<WebElement> elementsList2 = null;
	public static List<WebElement> elementsList3 = null;
	public static List<WebElement> elementsList4 = null;
	public static List<WebElement> menus = null;
	public int count = 0;
	public int interest = 0;					//Variable created for reading Interest
	public int penalty = 0;						//Variable created for reading Penalty
	
	
	public static String link = "Implementation";  
	
/*	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("C:\\Users\\Mayuri\\Desktop\\Compliance\\AvacomAll\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(22);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\researchReviewer.htm",true);
		test = extent.startTest("Loging In - research Reviewer");
		test.log(LogStatus.PASS, "Logging into system");
		/*
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
	//	test = extent.startTest("Loging In - research Reviewer");
	//	test.log(LogStatus.PASS, "Logging into system");
		initialization(link,22,"Statutory");
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
	//	XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		Thread.sleep(3000);
		*/
		
		
		//extent.endTest(test);
		//extent.flush();
	}
	
	public static void progress1()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
   @Test(priority = 2)
	void MinistryMaster() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliance- Ministry Master");
		
		
		RRMethods.MinistryMaster(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void RegulatorMaster() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliance- Regulator Master");
		
		
		RRMethods.RegulatorMaster(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void ActDepartmentMaster() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliance- Act Department Master ");
		
		
		RRMethods.ActDepartmentMaster(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 5)
	void ActAddNew() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliance- Act - Add New ");
		
		
		RRMethods.ActAddNew(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 6)
	void Actupdate() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliance- Act - Update ");
		
		
		RRMethods.Actupdate(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void ActDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliance- Act - Delete ");
		
		
		RRMethods.ActDelete(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 8)
	void ActGroupAddNew() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliance- Act Group - Add New ");
		
		
		RRMethods.ActGroupAddNew(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		Thread.sleep(1000);
  	//	driver.close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}	 
	
	
	
	
	
	
	
	
	
	
	
	
}
