package reviewer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import login.BasePage;
import performer.MethodsPOM;

public class FmReviewer extends BasePage {
	
	//public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	
	
/*	public static XSSFSheet ReadExcel() throws IOException
	{
		
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(9);					//Retrieving second sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\Regtrack Merge Project\\Regtrack-Project\\Reports\\ReviewerResults.html",true);
		test = extent.startTest("Logging In - Reviewer");
		test.log(LogStatus.PASS, "Logging into system");
		
					
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		
		initialization("FM",9,"Statutory");
	/*
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		Thread.sleep(3000);
	

		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"FM");		//Method of Login class to login user.
		
		
	*/
	}
	
	//@Test(priority = 1)		
	void WorkspaceSRFm() throws InterruptedException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
		
		Thread.sleep(3000);
		MethodsPOM.WorkspaceSRFm( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 2)		
	void SecondaryReDisplayFm() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
		
		Thread.sleep(3000);
		MethodsPOM.SecondaryReDisplayFm( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 3)		
		void SRWorkspaceSRFm() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' - sub-task -  To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
			
			Thread.sleep(3000);
			MethodsPOM.SRWorkspaceSRFm( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority = 4)		
		void SRWorkspaceSRDisFm() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' - sub-task -  To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
			
			Thread.sleep(3000);
			MethodsPOM.SRWorkspaceSRDisFm( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 5)		
		void WorkspaceSRFmIn() throws InterruptedException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' - Internal - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
			
			Thread.sleep(3000);
			MethodsPOM.WorkspaceSRFmIn( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 6)		
		void SecondaryReDisplayFmIn() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' -  Internal - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
			
			Thread.sleep(3000);
			MethodsPOM.SecondaryReDisplayFmIn( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 7)		
				void SRWorkspaceSRFmIn() throws InterruptedException, IOException
				{
					test = extent.startTest("My Workspace - 'Update Tasks' - Internal - sub-task -  To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
					
					Thread.sleep(3000);
					MethodsPOM.SRWorkspaceSRFmIn( test);
				
					extent.endTest(test);
					extent.flush();
				}
				


	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		//Thread.sleep(1000);
  		//driver.close();
  	}	       
  		

}
