package complianceCertificateOwner;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import implementation.ImplementMethods;
import login.BasePage;
import performer.MethodsPOM;

public class CertificateOwnerTest extends BasePage {
	
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
	
	public static String link = "CertificateOwner";  
	
	/*public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		fis = new FileInputStream("C:\\Users\\Mayuri\\Desktop\\Compliance\\AvacomAll\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(16);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\AVACOM Project\\AvacomModified\\Reports\\CertificateOwner.html",true);
		test = extent.startTest("Loging In - Certificate Owner");
		test.log(LogStatus.PASS, "Logging into system");
		
		/*XSSFSheet sheet = ReadExcel();
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
		
		initialization(link,16,"Statutory");
		//test = extent.startTest("Loging In - Certificate Owner");
		//test.log(LogStatus.PASS, "Logging into system");
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
		
		//Write "CFO-diy" for DIYProduction link.
		//Write "CFO" for login.avantis
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		*/	
	//	test.log(LogStatus.PASS, "Test Passed.");
		//extent.endTest(test);
		//extent.flush();
	}
	
	public static void progress1()
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	/*
	@Test(priority = 2)
	void CustomersCreate() throws InterruptedException, IOException
	{
		test = extent.startTest("Certificate Owner");
		
		CertificateOwnerMethod.CertificateOwner(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void CertificateOwnerParticularPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Particular Period");
		
		CertificateOwnerMethod.CertificateOwnerParticularPeriod(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void CertificateOwnerParticularPeriodCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Particular Period");
		
		CertificateOwnerMethod.CertificateOwnerParticularPeriodCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void CertificateOwnerReviewer() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer - Reviewer User -Compliance Tech");
		
		CertificateOwnerMethod.CertificateOwnerReviewer(test);
		
		extent.endTest(test);
		extent.flush();
	}
	*/
	@Test(priority =6)
	void NoticeCreated() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the new notice can be created or not ?");
		
		CertificateOwnerMethod.NoticeCreated(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void NoticeCreatedEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the Notice can be updated or not?");
		
		CertificateOwnerMethod.NoticeCreatedEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 0)
	void NoticeCreatedDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the Notice can be deleted or not ?");
		
		CertificateOwnerMethod.NoticeCreatedDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =9)
	void NoticeCreatedExport() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the export button working or not on the popup of add notice details?");
		
		CertificateOwnerMethod.NoticeCreatedExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 6) //pass 
    void WhatsNew() throws InterruptedException, IOException
			{
				test = extent.startTest("' what's New ' Verification");
				
				MethodsPOM.WhatsNew(test);
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
