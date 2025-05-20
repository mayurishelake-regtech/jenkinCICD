package performer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
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

import cfo.CFOcountPOM;
import login.BasePage;

public class FePerformer extends BasePage {
	
	//public static Web  = null;			//Web instance created
	public static WebElement upload = null;			//WebElement to get upload button
	public static ExtentReports extent;				//Instance created for report file
	public static ExtentTest test;					//Instance created for tests
	public int overdueStatutory;					//Variable to get old Statutory Overdue
	public int reviewStatutory;						//Variable to get old Statutory Review
	public int newOverdueStatutory;					//Variable to get new Statutory Overdue
	public int newReviewStatutory;					//Variable to get new Statutory Review
	public int overdueInternal;						//Variable to get old Internal Overdue
	public int reviewInternal;						//Variable to get old Internal Review
	public int newOverdueInternal;					//Variable to get new Internal Overdue
	public int newReviewInternal;					//Variable to get new Internal Review
	public static List<WebElement> elementsList = null;		//Variable to get list of action buttons
	public static List<WebElement> checkboxesList = null;	//Variable to get list of check boxes
	public static List<WebElement> elementsList1 = null;	//Variable to get list of text boxes
	public static FileInputStream fis = null;		//File input stream variable
	public static XSSFWorkbook workbook = null;		//Excel sheet workbook variable
	public static XSSFSheet sheet = null;			//Sheet variable
	
	public static String link = "PerTlcg";
	
/*	public static XSSFSheet ReadExcel() throws IOException
	{
		
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(4);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		//String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\Regtrack Merge Project\\Regtrack-Project\\Reports\\PerformerResults.html",true);
		test = extent.startTest("Loging In - Performer");
		test.log(LogStatus.PASS, "Logging into system");
		
	/*	XSSFSheet sheet = ReadExcel();
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
		initialization(link,4,"Statutory");
		
/*	XSSFSheet sheet = ReadExcel();
	Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
	Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
	String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
	
	login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
	
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		*/
	}
	
	public static void message()
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage()));
			if(OverduePOM.closeMessage().isDisplayed())	//If Compliance Updation message popped up,
			{
				OverduePOM.closeMessage().click();		//then close the message.
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
//	@Test(priority = 2)  
	void AssignedEventsSingle() throws InterruptedException
	{
		test = extent.startTest("Assigned Events Count using Assigned button");
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		Thread.sleep(2000);
		int dasAssignedEventVal = Integer.parseInt(OverduePOM.clickAssignedEventsOw().getText());	//Storing old Activated Events value
		
		Thread.sleep(1000);
		OverduePOM.clickAssignedEventsOw().click();					//Clicking on 'Assigned Events' value
		
		Thread.sleep(3000);
		elementsList1 = OverduePOM.viewEvent();
		elementsList1.get(0).click();									//Clicking on View Event button
		
		Thread.sleep(4000);
		OverduePOM.closeViewEvent().click();						//Closing the View Event
		
		Thread.sleep(2000);
	/*	Thread.sleep(500);
		elementsList1 = OverduePOM.clickTextBoxes();
		elementsList1.get(2).sendKeys("Automation Testing");			//Writing in first text box
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickDates();
	//	elementsList1.get(1).sendKeys("07072021");						//Clicking on first date (Actually second on form)
		Thread.sleep(3000);
		elementsList1.get(0).click();
		
	//	OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
	
		Thread.sleep(1000);
		elementsList1 = OverduePOM.clickActivate();
		elementsList1.get(1).click();									//Clicking on first Activate button image
		
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(1000);
		.switchTo().alert().accept();
		*/
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		OverduePOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = OverduePOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int countGrid = Integer.parseInt(compliancesCount);
		if(dasAssignedEventVal == countGrid)
		{
			test.log(LogStatus.PASS, "Number of  grid matches to Dashboard  Count.");
			test.log(LogStatus.INFO, "No of  the grid = "+countGrid+" | Dashboard   Count = "+dasAssignedEventVal);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
			test.log(LogStatus.INFO, "No of  the grid = "+countGrid+" | Dashboard   Count = "+dasAssignedEventVal);
		}
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard
		Thread.sleep(2000);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)  
	void ActivatedEventsSingle() throws InterruptedException
	{
		test = extent.startTest("Activated Events Count using Activate button");
		test.log(LogStatus.INFO, "Test Initiated");
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		Thread.sleep(2000);
		int dasActivatedEventVal = Integer.parseInt(OverduePOM.readActivatedEventsOw().getText());	//Storing old Activated Events value
		
		Thread.sleep(1000);
		OverduePOM.readActivatedEventsOw().click();					//Clicking on 'Assigned Events' value
		
		Thread.sleep(3000);
		elementsList1 = OverduePOM.viewEvent();
		elementsList1.get(0).click();									//Clicking on View Event button
		
		Thread.sleep(4000);
		OverduePOM.closeViewEvent().click();						//Closing the View Event
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		OverduePOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = OverduePOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int countGrid = Integer.parseInt(compliancesCount);
		if(dasActivatedEventVal == countGrid)
		{
			test.log(LogStatus.PASS, "Number of  grid matches to Dashboard  Count.");
			test.log(LogStatus.PASS, "No of  the grid = "+countGrid+" | Dashboard   Count = "+dasActivatedEventVal);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
			test.log(LogStatus.FAIL, "No of  the grid = "+countGrid+" | Dashboard   Count = "+dasActivatedEventVal);
		}
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard
		Thread.sleep(2000);
		
		extent.endTest(test);
		extent.flush();
	}
	

	//@Test(priority = 36)		
	void WorkspaceSR() throws InterruptedException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
		
		Thread.sleep(3000);
		MethodsPOM.WorkspaceSR( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 36)		
	void SecondaryReDisplay() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
		
		Thread.sleep(3000);
		MethodsPOM.SecondaryReDisplay( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 37)		
	void SRWorkspaceSR() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - sub-task -  To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
		
		Thread.sleep(3000);
		MethodsPOM.SRWorkspaceSR( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 38)		
	void SRWorkspaceSRDis() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - sub-task -  To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
		
		Thread.sleep(3000);
		MethodsPOM.SRWorkspaceSRDis( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 36)		
	void WorkspaceSRIn() throws InterruptedException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - Internal - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
		
		Thread.sleep(3000);
		MethodsPOM.WorkspaceSRIn( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 36)		
	void SecondaryReDisplayIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - Internal - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
		
		Thread.sleep(3000);
		MethodsPOM.SecondaryReDisplayIn( test);
	
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 37)		
		void SRWorkspaceSRIn() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' - Internal - sub-task -  To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
			
			Thread.sleep(3000);
			MethodsPOM.SRWorkspaceSRIn( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 38)		
		void SRWorkspaceSRDisIn() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' -Internal - sub-task -  To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
			
			Thread.sleep(3000);
			MethodsPOM.SRWorkspaceSRDisIn( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 39)
		void PerformReviewEmailCol() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report - Performer Email column and Reviewer Email column Visible on grid Verification. ");
				
			MethodsPOM.PerformReviewEmailCol(test);
			
			extent.endTest(test);
			extent.flush();
		}

		
	
	
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		//Thread.sleep(1000);
  	//	.close();
  	}	       
  		      

}
