package performer;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import approval.ApprovalcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtAMethod;
import companyadmin.CompanyPOM;
import departmentHead.DeptCountPOM;
import login.BasePage;
import reviewer.ReMethodsPOM;

public class OverdueCount extends BasePage
{
//	public static  = null;			//Web instance created
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
	
	public static String link = "mgmt1";
	static String filePath ="E:\\Regtrack Merge Project\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx";
/*	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		
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
	//	test = extent.startTest("Loging In - Performer");
	//	test.log(LogStatus.PASS, "Logging into system");
		
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);		
		Thread.sleep(3000);
	//	XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		 = login.Login.UserLogin(uname,password,"Overdue");		//Method of Login class to login user.
		*/
		
	//extent.endTest(test);
	//extent.flush();
	}
	
	public static void message()
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
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
	
	
	@Test(priority = 2)//pass     Critical
	void Upcoming_ComplianceStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Upcoming Compliance Verification");
		
		Thread.sleep(3000);
		
		MethodsPOM.UpcomingCompliance( test, "Statutory",workbook);
		extent.endTest(test);
	extent.flush();
	}
	
	@Test(priority = 3)//pass
	void Upcoming_ComplianceStatutoryCkeckView() throws InterruptedException
	{
		test = extent.startTest("Statutory Upcoming Compliance Check View Button Verification");
		
		Thread.sleep(3000);
		MethodsPOM.UpcomingComplianceADView( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	 @Test(priority = 4) //pass
	void Upcoming_ComplianceInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Upcoming Compliance Verification");
		
		
		MethodsPOM.UpcomingCompliance( test, "Internal",workbook);
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 5)
	void DashboardStatutoryOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard Statutory Overdue Value Verification");
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
	//	test.log(LogStatus.PASS, "***********Statutory Overdue************ ");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		
		String string_overdueStatutory = OverduePOM.clickStatutoryOverdue().getText();		//Storing old value of Statutory overdue.
		overdueStatutory = Integer.parseInt(string_overdueStatutory);
		String string_reviewStatutory = OverduePOM.readPendingReviewStatutory().getText();	//Storing old value of Pending Review.
		reviewStatutory = Integer.parseInt(string_reviewStatutory);
		
		OverduePOM.clickStatutoryOverdue().click();				//Clicking on Statutory overdue.
		
		//Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		Thread.sleep(2000);
		MethodsPOM.StatutoryOverdueExport(test,workbook);	
		Thread.sleep(3000);
		MethodsPOM.StatutoryOverdue();							//Calling method of Statutory Overdue
		
		Thread.sleep(3000);		
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItems1().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems1().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(compliancesCount);
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickStatutoryOverdue()));
		
		String string_overdueStatutoryNew = OverduePOM.clickStatutoryOverdue().getText();		//Storing old value of Statutory overdue.
		newOverdueStatutory = Integer.parseInt(string_overdueStatutoryNew);
		String string_reviewStatutoryNew = OverduePOM.readPendingReviewStatutory().getText();	//Storing old value of Pending Review.
		newReviewStatutory = Integer.parseInt(string_reviewStatutoryNew);
		
		if(overdueStatutory > newOverdueStatutory && reviewStatutory < newReviewStatutory)
		{
			test.log(LogStatus.PASS, "Stautory 'Overudue' value decremented and Statutory 'Pending For Reveiew' value increamented");
			//test.log(LogStatus.INFO, "Old Statutory Count = "+overdueStatutory+" | New Statutory Count = "+newOverdueStatutory+". Old Pending for Review Count = "+reviewStatutory+ " | New Pending for Riview Count = "+newReviewStatutory);
		}
		else
		{
			if(overdueStatutory > newOverdueStatutory)
			{
				test.log(LogStatus.PASS, "Stautory 'Overudue' value decremented on Dashboard");
				//test.log(LogStatus.INFO, "Old Statutory Count = "+overdueStatutory+" | New Statutory Count = "+newOverdueStatutory+".");
			}
			else
			{
				test.log(LogStatus.FAIL, "Stautory 'Overudue' value didn't decremented");
				//test.log(LogStatus.INFO, "Old Statutory Count = "+overdueStatutory+" | New Statutory Count = "+newOverdueStatutory+". Old Pending for Review Count = "+reviewStatutory+ " | New Pending for Riview Count = "+newReviewStatutory);
			}
			if(reviewStatutory < newReviewStatutory)
			{
				test.log(LogStatus.PASS, "Statutory 'Pending For Reveiew' value incremented");
			//	test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewStatutory+" | New Pending for Riview Count = "+newReviewStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "Statutory 'Pending For Reveiew' value didn't incremented");
			//	test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewStatutory+" | New Pending for Riview Count = "+newReviewStatutory);
			}
		}
		if(count == newOverdueStatutory)
		{
		//	test.log(LogStatus.PASS, "Number of compliances matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.PASS, "No of Compliances in the grid = "+count+" | Dashboard Statutory Overdue Count = "+newOverdueStatutory);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.FAIL, "No of Compliances in the grid = "+count+" | Dashboard Statutory Overdue Count = "+newOverdueStatutory);
		}
		OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)  //pass
	void DashboardInternalOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard Internal Overdue Value Verification");
		
		
	//	test.log(LogStatus.PASS, "***********Internal Overdue************ ");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(1000);
		String string_internalOverdue = OverduePOM.clickInternalOverdue().getText();		//Storing old value of Statutory overdue.
		overdueInternal = Integer.parseInt(string_internalOverdue);
		String string_internalReview = OverduePOM.readPendingReviewInternal().getText();	//Storing old value of Pending Review.
		reviewInternal = Integer.parseInt(string_internalReview);
		
		OverduePOM.clickInternalOverdue().click();				//Clicking on Internal Overdue value.
		
		//Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		
		
		
		//.findElement(By.xpath("//*[@id='grid']"));		//Searching grid/kendo.
		Thread.sleep(2000);
		MethodsPOM.StatutoryOverdueExport(test,workbook);	
		Thread.sleep(500);
	//	Thread.sleep(2000);
	//	MethodsPOM.InternalOverdue();							//Calling InternalOverdue() method.
		Thread.sleep(2000);
	//	MethodsPOM.StatutoryOverdueExport(test,workbook);	
		Thread.sleep(500);
		Thread.sleep(3000);		
		js.executeScript("window.scrollBy(0,3000)");
		
		CFOcountPOM.readTotalItems1().click();
		Thread.sleep(500);
		String item1 = CFOcountPOM.readTotalItems1().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length-2];				//Getting the second last word (total number of users)
		Integer count1 = Integer.parseInt(compliancesCount1);
		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		
		String string_newInternalOverdue = OverduePOM.clickInternalOverdue().getText();		//Storing old value of Statutory overdue.
		newOverdueInternal = Integer.parseInt(string_newInternalOverdue);
		String string_newInternalReview = OverduePOM.readPendingReviewInternal().getText();	//Storing old value of Pending Review.
		newReviewInternal = Integer.parseInt(string_newInternalReview);
		
		if(newOverdueInternal < overdueInternal && newReviewInternal > reviewInternal)
		{
			test.log(LogStatus.PASS, "Internal 'Overudue' value decremented and Internal 'Pending For Reveiew' value increamented");
			//test.log(LogStatus.INFO, "Old Internal Count = "+overdueInternal+" | New Internal Count = "+newOverdueInternal+". Old Pending for Review Count = "+reviewInternal+" | New Pending for Riview Count = "+newReviewInternal);
		}
		else
		{
			if(newOverdueInternal < overdueInternal)
			{
				test.log(LogStatus.PASS, "Internal 'Overudue' value decremented on Dashboard");
			//	test.log(LogStatus.INFO, "Old Internal Overdue Count = "+overdueInternal+" | New Internal Overdue Count = "+newOverdueInternal);
			}
			else
			{
				test.log(LogStatus.PASS, "Internal 'Overudue' value didn't decremented because Compliance releted task is not yet completed.");
			//	test.log(LogStatus.INFO, "Old Internal Overdue Count = "+overdueInternal+" | New Internal Overdue Count = "+newOverdueInternal);
			}
			if(newReviewInternal > reviewInternal)
			{
				test.log(LogStatus.PASS, "Internal 'Pending For Reveiew' value incremented");
			//	test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewInternal+" | New Pending for Riview Count = "+newReviewInternal);
			}
			else
			{
				test.log(LogStatus.PASS, "Internal 'Pending For Reveiew' value didn't increment because Compliance releted task is not yet completed.");
			//	test.log(LogStatus.INFO, "Old Pending for Review Count = "+reviewInternal+" | New Pending for Riview Count = "+newReviewInternal);
			}
		}
		if(count1 == newOverdueInternal)
		{
			//	test.log(LogStatus.PASS, "Number of compliances matches to Dashboard Internal Overdue Count.");
		test.log(LogStatus.PASS, "No of Compliances in the grid = "+count1+" | Dashboard Internal Overdue Count = "+newOverdueInternal);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of compliances does not matches to Internal Overdue Count.");
			test.log(LogStatus.PASS, "No of Compliances in the grid = "+count1+" | Dashboard Internal Overdue Count = "+newOverdueInternal);
		}
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	
  @Test(priority = 7) //pass non -critical
	void MyWorkComplianceClear() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace - Compliance - To check Clear button Working or not");
		
		
		MethodsPOM.MyWorkComplianceClear( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8) //pass
	void StatutoryOverdueMitigationplan() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan");
		
		MethodsPOM.StatutoryOverdueMitigationplan( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
/*	@Test(priority = 9) //pass
	void StatutoryOverdueMitigationplanM() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan - To check whether the multiple file can be uploaded or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryOverdueMitigationplanMul( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10) 
	void StatutoryOverdueMitigationplanDDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryOverdueMitigationplanDDoc( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11) 
	void StatutoryOverdueMitigationplanView() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryOverdueMitigationplanView( test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 12) 
	void StatutoryOverdueMitigationplanDe() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan - To check whether the file can be delete or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryOverdueMitigationplanDe( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13) 
	void StatutoryOverdueMitigationplanWD() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan -  To check whether the without upload document compliance mitigation plan updated or not?");
		
		
		MethodsPOM.StatutoryOverdueMitigationplanWD( test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
	/*@Test(priority = 14) //pass
	void StatutoryOverdueMP() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Edit - To check whether the overdue compliance complied or not without updated mitigation plan?");
		
		
		MethodsPOM.StatutoryOverdueMP( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15) //pass
	void InternalOverdueMitigationplan() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan");
		
		
		MethodsPOM.InternalOverdueMitigationplan( test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
/*	@Test(priority = 16) //pass
	void InternalOverdueMitigationplanMul() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan - To check whether the multiple file can be uploaded or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalOverdueMitigationplanMul( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17) //pass
	void InternalOverdueMitigationplanDDoc() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalOverdueMitigationplanDDoc( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18) //pass
	void InternalOverdueMitigationplanView() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalOverdueMitigationplanView( test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 19) //pass
	void InternalOverdueMitigationplanDe() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan - To check whether the file can be delete or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalOverdueMitigationplanDe( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20) //pass
	void InternalOverdueMitigationplanWD() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan -  To check whether the without upload document compliance mitigation plan updated or not?");
		
		
		MethodsPOM.InternalOverdueMitigationplanWD( test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
/*	@Test(priority = 21) 
		void InternalOverdueMP() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Overdue - Edit - To check whether the overdue compliance complied or not without updated mitigation plan?");
			
			
			MethodsPOM.InternalOverdueMP( test);
			
			extent.endTest(test);
			extent.flush();
		}

//@Test(priority = 22) //pass
	void StatutoryOverdueMitigationPFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Filter - Statutory Overdue - Mitigation Plan - Pending Updation filter working or not");
		
		
		MethodsPOM.StatutoryOverdueMitigationPFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 26) //pass
	void InternalOverdueMitigationPFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Filter - Internal Overdue - Mitigation Plan - Pending Updation filter working or not");
		
		
		MethodsPOM.InternalOverdueMitigationPFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 27) //pass   Critical Not run
	void StatutoryChecklistAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Checklist Count Through Action");
		
		
		MethodsPOM.StatutoryCheckListAction( test);
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 28) //pass
	void StatutoryChecklistBox() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Checklist CheckBoxes check ");
		
		
		MethodsPOM.StatutoryCheckListCheckbox( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 29) //pass
	void StatutoryCheckListCBNotComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Checklist CheckBoxes check  -Not Complied");
		
		
		MethodsPOM.StatutoryCheckListCBNotComplied( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
 
	//@Test(priority = 30)  //pass Not run
	void InternalCheckListAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Checklist Count Through Action");
		
		
		MethodsPOM.InternalCheckListAction( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)  //pass
	void InternalCheckListCheckBox() throws InterruptedException
	{
		test = extent.startTest("Internal Checklist CheckBoxes check");
		
		
		MethodsPOM.InternalCheckListCheckbox( test);
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 32)  //pass non-critical
	void StatutoryCheckListMitigationP() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory CheckList - Mitigation Plan");
		
		
		MethodsPOM.StatutoryCheckListMitigationP( test);
		
		extent.endTest(test);
		extent.flush();
	}	*/
	
/*	@Test(priority = 30)  //pass
	void StatutoryCheckListMitigationPMul() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory CheckList - Mitigation Plan - To check whether the multiple file can be uploaded or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryCheckListMitigationPMul( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)  //pass
	void StatutoryCheckListMitigationPD() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory CheckList - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryCheckListMitigationPD( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)  //pass
	void StatutoryCheckListMitigationPView() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory CheckList - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryCheckListMitigationPView( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)  //pass
	void StatutoryCheckListMitigationPDe() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory CheckList - Mitigation Plan - To check whether the file can be delete or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.StatutoryCheckListMitigationPDe( test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 34)  //pass
	void StatutoryCheckListMitigationPDeWD() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory CheckList - Mitigation Plan - To check whether the without upload document compliance mitigation plan updated or not?");
		
		
		MethodsPOM.StatutoryCheckListMitigationPDeWD( test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
/*	@Test(priority = 35)  //pass
	void StatutoryCheckListMP() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory CheckList - Edit - To check whether the overdue compliance complied or not without updated mitigation plan?");
		
		
		MethodsPOM.StatutoryCheckListMP( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36)  //pass
	void InternalCheckListMitigationP() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal CheckList - Mitigation Plan");
		
		
		MethodsPOM.InternalCheckListMitigationP( test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
/*	@Test(priority = 37)  //pass
	void InternalCheckListMpMul() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal CheckList - Mitigation Plan - To check whether the multiple file can be uploaded or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalCheckListMpMul( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38)  //pass
	void InternalCheckListMitigationPD() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal CheckList - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalCheckListMitigationPD( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 39)  //pass
	void InternalCheckListMitigationPView() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal CheckList - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalCheckListMitigationPView( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 40)  //pass
	void InternalCheckListMitigationPDe() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal CheckList - Mitigation Plan - To check whether the file can be delete or not in the popup of compliance mitigation plan?");
		
		
		MethodsPOM.InternalCheckListMitigationPDe( test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 41)  //pass
	void InternalCheckListMitigationPDeWD() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal CheckList - Mitigation Plan - To check whether the without upload document compliance mitigation plan updated or not?");
		
		
		MethodsPOM.InternalCheckListMitigationPDeWD( test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
/*	@Test(priority =42)  //pass
	void InternalCheckListMP() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal CheckList - Edit - To check whether the overdue compliance complied or not without updated mitigation plan?");
		
		
		MethodsPOM.InternalCheckListMP( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 43)  //pass
	void StatutoryCheckListMitigationPFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Filter -Statutory CheckList -  Mitigation Plan - Pending Updation filter working or not");
		
		
		MethodsPOM.StatutoryCheckListMitigationPFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 44)  //pass
	void InternalCheckListMitigationPFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Filter -Internal CheckList - Mitigation Plan - Pending Updation filter working or not");
		
		
		MethodsPOM.InternalCheckListMitigationPFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority =45) // pass Critical
	void DashboardRejectStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Rejected Compliance Count - Dashboard");
		
		
		MethodsPOM.DashboardRejected( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)  // pass
	void DashboardRejectInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Rejected Compliance Count - Dashboard");
		
				
		MethodsPOM.DashboardRejected( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =47) // pass non-critical
	void DashboardPFRStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Pending For Review - Export");
		
		
		MethodsPOM.PFR( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48)  // pass
	void DashboardPFRInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Pending For Review - Export");
		
				
		MethodsPOM.PFR( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}*/
	
/*	@Test(priority =18) // no present
	void WorkspaceADExportStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest(" My Workspace - Advanced Search -Statutory -Export");
		
		
		MethodsPOM.WorkspaceADExportStatutory( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority =19) // no present
	void WorkspaceADExportInternal() throws InterruptedException, IOException
	{
		test = extent.startTest(" My Workspace - Advanced Search -Internal -Export");
		
		
		MethodsPOM.WorkspaceADExportInternal( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 20)  //pass
	void AssignedEventsSingle() throws InterruptedException
	{
		test = extent.startTest("Activated Events Count using Activate button");
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		Thread.sleep(2000);
		int oldActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents().getText());	//Storing old Activated Events value
		
		Thread.sleep(4000);
		OverduePOM.clickAssignedEvents().click();					//Clicking on 'Assigned Events' value
		
		Thread.sleep(1000);
		elementsList1 = OverduePOM.viewEvent();
		elementsList1.get(0).click();									//Clicking on View Event button
		
		Thread.sleep(2000);
		OverduePOM.closeViewEvent().click();						//Closing the View Event
		test.log(LogStatus.PASS, "View Successfully");

		Thread.sleep(1000);/*
		//elementsList = OverduePOM.clickCheckBoxes();
	//	elementsList.get(1).click();									//Clicking on first check box (Actually second on form)
      // .findElement(By.xpath("//*[@id='f6df6518-5450-446c-8735-38ae10150ecd']/label")).click();
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickTextBoxes();
		elementsList1.get(2).sendKeys("Automation Testing");			//Writing in first text box
		//.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[5]/input")).sendKeys("Automation Testing");
		Thread.sleep(3000);
	//	elementsList1 = OverduePOM.clickDates();
	//	elementsList1.get(1).sendKeys("07/07/2021");						//Clicking on first date (Actually second on form)
		Thread.sleep(3000);
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/input");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = .findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(1).sendKeys("07/07/2021");;
	//	elementsList1.get(1).click();
		
	//	OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
			Thread.sleep(3000);
		Thread.sleep(1000);
		elementsList1 = OverduePOM.clickActivate();
		elementsList1.get(1).click();									//Clicking on first Activate button image
		
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(1000);
		.switchTo().alert().accept();
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard
		Thread.sleep(2000);
		int newActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents().getText());	//Storing new Activated Events value
		Thread.sleep(2000);
		if(newActivatedEventValue > oldActivatedEventValue)
		{
			test.log(LogStatus.PASS, "Activated Events count incremented. Old value = " +oldActivatedEventValue+" New Value = "+ newActivatedEventValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		OverduePOM.clickDashboard().click();	
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 21) //Script Issue not Run 
	void AssignedEventsMultiple() throws InterruptedException
	{
		test = extent.startTest("Activated Events Count using Save button");
		

		Thread.sleep(2000);
		int oldActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents().getText());	//Storing old Activated Events value
		
		Thread.sleep(1000);
		OverduePOM.clickAssignedEvents().click();					//Clicking on 'Assigned Events' value
		
		Thread.sleep(4000);
		elementsList = OverduePOM.clickCheckBoxes();
		elementsList.get(1).click();									//Clicking on first check box (Actually second on form)
		elementsList.get(2).click();									//Clicking on second check box (Actually third on form)
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickTextBoxes();
		elementsList1.get(0).sendKeys("Automation Testing1");			//Writing in first text box
		elementsList1.get(1).sendKeys("Automation Testing2");			//Writing in second text box
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.clickDates();
		elementsList1.get(1).click();									//Clicking on first date (Actually second on form)
		Thread.sleep(500);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		elementsList1.get(2).click();									//Clicking on second date (Actually second on form)
		Thread.sleep(500);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		Thread.sleep(500);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)"," ");
		
		Thread.sleep(1000);
		OverduePOM.clickSave().click();							//Clicking on Save button.
		
		Thread.sleep(2000);
		WebElement button = null;
		try
		{
			JavascriptExecutor js1 = (JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scrollBy(0,1500)"," ");
			button = OverduePOM.clickAssigneCompliance();			//Checking if the 'Assign Compliance' button is present
		}
		catch(Exception e)
		{
			
		}
		
		if(button != null)												//If button is present
		{
			OverduePOM.clickAssigneCompliance().click();			//CLicking on the 'Assign Compliance' button
			
			Thread.sleep(2000);
			OverduePOM.selectPerformer().click();
			Select dropdown1 = new Select(OverduePOM.selectPerformer());	//Selecting performer dropdown 
			dropdown1.selectByVisibleText("performer a");						//Selecting performer
			
			Thread.sleep(700);
			Select dropdown2 = new Select(OverduePOM.selectReviewer());	//Selecting reviewer dropdown
			dropdown2.selectByVisibleText("reviewer b");						//Selecting reviewer
			
			Thread.sleep(700);
			Select dropdown3 = new Select(OverduePOM.selectApprover());	//Selecting approver dropdown
			dropdown3.selectByVisibleText("App App");							//Selecting approver
			
			Thread.sleep(700);
			OverduePOM.selectDate1().click();								//Clicking on calendar
			Thread.sleep(500);
			OverduePOM.selectDate().click();								//Selecting date of second row and fifth column
			
			Thread.sleep(700);
			Select dropdown4 = new Select(OverduePOM.selectEvent());		//Selecting Event dropdown
			dropdown4.selectByIndex(2);											//Selecting Event
			
			Thread.sleep(700);
			OverduePOM.clickCheckbox().click();							//Clicking on Select all checkbox
			
			Thread.sleep(2000);
			OverduePOM.clickSave1().click();								//Clicking on 'Save' button of compliance assign prosess
			
			Thread.sleep(2000);
			OverduePOM.clickSave().click();								//Clicking on Save button of Compliance Activate process.
		}
		
		Thread.sleep(1500);
		getDriver().switchTo().alert().accept();
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();								//Clicking on Dashboard.
		Thread.sleep(2000);
		int newActivatedEventValue = Integer.parseInt(OverduePOM.readActivatedEvents().getText());	//Storing new Activated Events value
		
		if(newActivatedEventValue > oldActivatedEventValue)
		{
			test.log(LogStatus.PASS, "Activated Events count incremented. Old value = " +oldActivatedEventValue+" New Value = "+ newActivatedEventValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		extent.endTest(test);
		extent.flush();
	}*/
	
	
/*	@Test(priority = 49) //pass non-critical
	void WorkspaceOverdueStatutory() throws InterruptedException
	{
		test = extent.startTest("My Workspace - Statutory Overdue Value Verification");
		
		
		MethodsPOM.WorkspaceOverdueStatutory( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50)
	void WorkspaceOverdueInternal() throws InterruptedException
	{
		test = extent.startTest("My Workspace - Internal Overdue Value Verification");
		
		
		MethodsPOM.WorkspaceOverdueInternal( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
  @Test(priority = 51) //pass
	    void ActivatedEventsPer() throws InterruptedException, IOException
		{
			test = extent.startTest("Event Owner Summary - Statutory Activated Events Count Match");
			
			
			ReMethodsPOM.ActivatedEventsPer(test);
			
			extent.endTest(test);
			extent.flush();
		}
	    
	@Test(priority = 52) //pass 
	    void ClosedEventsPer() throws InterruptedException, IOException
		{
			test = extent.startTest(" Event Owner Summary - Statutory Closed  Events Count Match");
			
			
			ReMethodsPOM.ClosedEventsPer(test);
			
			extent.endTest(test);
			extent.flush();
		}
	    
  @Test(priority = 53) //pass 
	    void AssignedEvents() throws InterruptedException, IOException
		{
			test = extent.startTest("Event Owner Summary - Statutory Assigned  Event Count Match");
			
			ReMethodsPOM.AssignedEvents(test);
			
			extent.endTest(test);
			extent.flush();
		}*/
	
   @Test(priority = 54) //pass
  void PerformerTaskUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Statutory Upcoming Count Match");
		
		
		MethodsPOM.PerformerTaskUpcoming(test,"Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 55) //pass
  void PerformerTaskUpcomingIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Internal Upcoming Count Match");
		
		
		MethodsPOM.PerformerTaskUpcoming(test,"Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	

 @Test(priority = 56) //pass
 void PerformerTaskOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Statutory Overdue Count Match");
		
		
		MethodsPOM.PerformerTaskOverdue(test,"Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 57) //pass
 void PerformerTaskOverdueIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Internal Overdue Count Match");
		
		
		MethodsPOM.PerformerTaskOverdue(test,"Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
 @Test(priority = 58) //pass
	   void PerformerTaskRejected() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Statutory Rejected Count Match");
			
			
			MethodsPOM.PerformerTaskRejected(test,"Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 59) //pass
	   void PerformerTaskRejectedIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Internal Rejected Count Match");
			
			
			MethodsPOM.PerformerTaskRejected(test,"Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	
 @Test(priority = 60) 
	   void PerformerTaskPFR() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Statutory Pending For Review Count Match");
			
			
			MethodsPOM.PerformerTaskPFR(test,"Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 61) //pass
	   void PerformerTaskPFRIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Internal Pending For Review Count Match");
			
			
			MethodsPOM.PerformerTaskPFR(test,"Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	
	    
	 
	
			
	@Test(priority = 62) 
		void DetailedReport1() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report -Statutory Count Verification");
			
			
			ReMethodsPOM.DetailedReport1CriPer(test, "Statutory");

			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 63) 
		void DetailedReportIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report -Internal Count Verification");
			
			ReMethodsPOM.DetailedReport1CriPer(test,  "Internal");
			
			extent.endTest(test);
			extent.flush();
		}

	
	@Test(priority = 64) 
	void DetailedReportFilterper() throws InterruptedException, IOException
	{
		test = extent.startTest("To check  Detailed report filters working or not Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReportFilterper(test,  "Reviewer");
		
		extent.endTest(test);
		extent.flush();
	}
	

@Test(priority = 65)  
	void DetailedReportStautau() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Statutory -Status -Closed Timely display Verification");
		
		
	
		MethodsPOM.DetailedReportCD(test,"performer");
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 65)
void PerformReviewEmailCol() throws InterruptedException, IOException
{
	test = extent.startTest("Detailed Report - Performer Email column and Reviewer Email column Visible on grid Verification. ");
		
	MethodsPOM.PerformReviewEmailCol(test);
	
	extent.endTest(test);
	extent.flush();
}

	
	@Test(priority = 66) //pass
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report count verification");
		
		
		CFOcountPOM.AssignmentReport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 67)// non-critical
	void AssignmentReportFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilter1(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
//	@Test(priority = 68)
	void ComplianceIDFilterEBDe() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterEBDe(test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
//	@Test(priority = 69)
	void ComplianceIDFilterINDe() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterINDe(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 70)
	void ComplianceIDFilter1Invalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilter1Invalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
//	@Test(priority = 71)
	void ComplianceIDFilterEBInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterEBInvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 72)
	void ComplianceIDFilterINInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterINInvalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	 @Test(priority = 73) //pass 
     void TaskReport() throws InterruptedException
			{
				test = extent.startTest("Task Report Verification");
			
				
				MethodsPOM.TaskReport(test);
				
				extent.endTest(test);
				extent.flush();
			}
     
	@Test(priority = 73)
 	void ComplianceRepository() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Compliance Repository/Act Repository  verification");
 		
 		
 		MethodsPOM.complianceRepository(test);

 		extent.endTest(test);
 		extent.flush();
 	}
 	
	@Test(priority = 66) //critical
	void ComplianceDocumentsSat() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents Statutory verification");
		
		
		MethodsPOM.complianceDocumentStaCri(test);
		
	           extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 67) 
		void ComplianceDocumentsInter() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents Internal verification");
			
			
			MethodsPOM.complianceDocumentInCri(test);
			
		extent.endTest(test);
		extent.flush();
		}
	
	
	@Test(priority = 68) //	pass	
	void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Critical Document Verification");
		
		OverduePOM.CriticalDocuments( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 69) // pass
	void MyReminderStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Statutory Count Verification");
		
		OverduePOM.MyReminder( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 70) //pass
	void MyReminderInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Internal Count Verification");
		
		OverduePOM.MyReminder( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 74) //pass non-critical
	void ReviseCompliance() throws InterruptedException
	{
		test = extent.startTest("Revise Compliance and Update Penalty  Count Verification");
		
		OverduePOM.ReviseCompliance( test, 2);	//2 for 'Revised Compliance' from 'More Actions' drop down.
		Thread.sleep(4000);
		OverduePOM.ReviseCompliance( test, 1);	//1 for 'Update Penalty' from 'More Actions' drop down.
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();
		
		extent.endTest(test);
		extent.flush();
	}
	
/*	@Test(priority = 72)		
	void ComplianceUpdateTask() throws InterruptedException, EncryptedDocumentException, IOException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - Statutory  Verification");
		
		Thread.sleep(3000);
		MethodsPOM.UpdateTask( test, workbook, "Statutory");
	//	MethodsPOM.EditTask(test);
		OverduePOM.clickDashboard().click();
    //	MethodsPOM.UpdateTask( test, workbook, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 73)		
	void ComplianceUpdateTaskIn() throws InterruptedException, EncryptedDocumentException, IOException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - Internal  Verification");
		Thread.sleep(3000);
    	MethodsPOM.UpdateTask( test, workbook, "Internal");
		OverduePOM.clickDashboard().click();
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 74)		
	void ComplianceEditSatTask() throws InterruptedException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' -Statutory - Edit  Verification");
		
		
		MethodsPOM.EditTask(test);
		
		OverduePOM.clickDashboard().click();
	
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 75)		
	void ComplianceEditINTask() throws InterruptedException
	{
		test = extent.startTest("My Workspace - 'Update Tasks' - 'Edit ' - Internal Verification");
		
		
		MethodsPOM.EditInternalTask(test);
		
		OverduePOM.clickDashboard().click();
	
		
		extent.endTest(test);
		extent.flush();
	}*/
	
	  @Test(priority = 74) 
		            void PenaltyUpdation() throws InterruptedException
		      			{
		          	  test = extent.startTest("My Workspace - Penalty Updation");
		        		
		        		
		        		MethodsPOM.WorkspacePenaltyUpdation( test);
		        		
		        		extent.endTest(test);
		        		extent.flush();
		      			}
	

 @Test(priority = 0)
	void PerformerTaskAddUpcomingStatutory() throws InterruptedException, EncryptedDocumentException, IOException
  {
		test = extent.startTest("Dashboard Statutory Upcoming Performer Task Verification");
		
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		test.log(LogStatus.INFO, "***********Upcoming Statutory Performer Task************ ");
		
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTUpcomingStatutory()));
		
		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		OverduePOM.clickPTUpcomingStatutory().click();
	//	Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
		OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
		//wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
		
		test.log(LogStatus.INFO, "------------- Statutory -------------");
		Thread.sleep(2000);
		OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
		Select drp = new Select(OverduePOM.clickActFilter());
		drp.selectByIndex(2);										//Selecting third Act
		
		Thread.sleep(2000);
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
		OverduePOM.clickComplianceDropDown().click();			//Clicking on 'Compliance' drop down.
		drp = new Select(OverduePOM.clickComplianceDropDown());
		Thread.sleep(2000);
		drp.selectByIndex(1);										
		
		
//		FileInputStream fis = new FileInputStream(filePath);
//	    Workbook workbook = WorkbookFactory.create(fis);
//		Thread.sleep(5000);
//		Sheet sheet = workbook.getSheetAt(4);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
////		//int row = 0;
////		Thread.sleep(5000);
////		Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
//		Cell c1 = null;
//		row0= sheet.getRow(3);
//		c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
//		OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
		
		 FileInputStream fis = new FileInputStream(filePath);
	     Workbook workbook = WorkbookFactory.create(fis);
	     Sheet sheet = workbook.getSheetAt(0);
	     Row row1 = sheet.getRow(3);
	     Cell c1 = row1.getCell(1);
	     OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());
	 
	
		Row row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
		Cell c0 = row0.getCell(1);							//Selected cell (1 row,2 column)
		OverduePOM.clickDescription().sendKeys(c0.getStringCellValue());	//Writing description
	
		row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
		c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
		int day = (int) c1.getNumericCellValue();
		OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
	
		Select taskType=new Select(	OverduePOM.clickTaskType());
		taskType.selectByIndex(1);
		Thread.sleep(1000);

		OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
		
	js.executeScript("window.scrollBy(0,2000)");
	row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
	c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
	OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
	
	row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
	c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
	OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
	
	row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
	c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
	OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
		
	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	Thread.sleep(1500);
	//String workingDir = System.getProperty("user.dir");
	OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");
	
	Thread.sleep(1000);
	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
	
	Thread.sleep(500);
	String saveMsg = OverduePOM.taskSavedMsg().getText();
	OverduePOM.taskSavedMsg().click();
	
	if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
	{
		test.log(LogStatus.PASS, "Message displayed - 'Task Saved Successfully'");
	}
	else
	{
		test.log(LogStatus.FAIL, "Message displayed - 'Task already exist.'");
	}
	
	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
	Thread.sleep(1000);
	/*int total1 = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records displayed
	
	if(total1 > total)
	{
		test.log(LogStatus.PASS, "New Task added and displayed successfully.");
	}
	else
	{
		test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
	}
	
			Thread.sleep(1500);
			OverduePOM.clickShow().click();				//Clicking on Show dropdown
		Select	select = new Select(OverduePOM.clickShow());
			select.selectByIndex(3);							//Selecting 50
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2000)");		//Scrolling down window by 2000 px.
			*/
	//-------------------------------Create Sub Task--------------------------------------
	OverduePOM.ClickTaskCreation().click();
	Thread.sleep(3000);
	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
	int no = elementsList1.size();

	Thread.sleep(2000);
	elementsList1.get(2).click();

	Thread.sleep(4000);

	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
	Thread.sleep(3000);
	 sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
//		 row = 0;
//		Thread.sleep(500);
//		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
//		Cell c11 = null;
		Row row01= sheet.getRow(10);
		Cell c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
		OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

		row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
		c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
		OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

		row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
		c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
		int day1 = (int) c11.getNumericCellValue();
		OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

		OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

	js.executeScript("window.scrollBy(0,2000)");
	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
		
	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	Thread.sleep(1500);
	//String workingDir = System.getProperty("user.dir");
	OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");

	Thread.sleep(1000);
	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
	Thread.sleep(500);
	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
		
	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
	try
	{
		Thread.sleep(700);
		if(OverduePOM.checkRecordsTable().isDisplayed())
		{
			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
		}
	}
	catch(Exception e)
	{
		
	}

			OverduePOM.clickDashboard().click();
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 21)
		void PerformerTaskUpcomingInternal() throws InterruptedException{
		 test = extent.startTest("Dashboard Internal Upcoming Performer Task Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			
			test.log(LogStatus.INFO, "***********Upcoming Internal Performer Task************ ");
			
			js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTUpcomingInternal()));
			
			Thread.sleep(500);
		//	litigationPerformer.MethodsPOM.progress();
			OverduePOM.clickPTUpcomingInternal().click();
			
			Thread.sleep(3000);
			OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
			
			int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
			
		//	OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
			Thread.sleep(3000);
		//	wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
			OverduePOM.clickAddNew1().click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
			
					test.log(LogStatus.INFO, "------------- Internal -------------");
					
					OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
					Thread.sleep(4000); 
					Select drp = new Select(OverduePOM.clickInternalCompliance());
					drp.selectByIndex(1);
					Thread.sleep(1000);
					
				   sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
						int row = 0;
						Thread.sleep(500);
						Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
						Cell c1 = null;
						row0= sheet.getRow(3);
						c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
					OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
					
					row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
					c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
					OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
					
					row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
					c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
					int day = (int) c1.getNumericCellValue();
					OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
					
				  Select taskType=new Select(	OverduePOM.clickTaskType());
				  taskType.selectByIndex(1);
				  Thread.sleep(4000);

					OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
					
					js.executeScript("window.scrollBy(0,2000)");
					row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
					c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
					OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
					
					row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
					c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
					OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
					
					row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
					c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
					OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
						
					js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
					Thread.sleep(1500);
				//	String workingDir = System.getProperty("user.dir");
					OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");
					
					Thread.sleep(1000);
					OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
					
					Thread.sleep(500);
					String saveMsg = OverduePOM.taskSavedMsg().getText();
					OverduePOM.taskSavedMsg().click();
					
					if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
					{
						test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
					}
					else
					{
						test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
					}
					
					getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
					Thread.sleep(1000);
					OverduePOM.ClickTaskCreation().click();
					int total1 = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
					
					if(total1 > total)
					{
						test.log(LogStatus.PASS, "New Task added and displayed successfully.");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
					}
					
					/*		Thread.sleep(1500);
							OverduePOM.clickShow().click();				//Clicking on Show dropdown
						Select	select = new Select(OverduePOM.clickShow());
							select.selectByIndex(3);							//Selecting 50
							
							Thread.sleep(1000);
							js.executeScript("window.scrollBy(0,2000)");		//Scrolling down window by 2000 px.
							
			*/
    //-------------------------------Create Sub Task--------------------------------------
  	OverduePOM.ClickTaskCreation().click();
  	Thread.sleep(3000);
  	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
  	int no = elementsList1.size();

  	Thread.sleep(2000);
  	elementsList1.get(2).click();

  	Thread.sleep(4000);

  	
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
  	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
  	Thread.sleep(3000);
  	 sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
  		  row = 0;
  		Thread.sleep(500);
  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
  		Cell c11 = null;
  		row01= sheet.getRow(10);
  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
  	OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
  	int day1 = (int) c11.getNumericCellValue();
  	OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

  	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

  	js.executeScript("window.scrollBy(0,2000)");
  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
  	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
  	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
  	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
  		
  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
  	Thread.sleep(1500);
  	//String workingDir = System.getProperty("user.dir");
  	OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");

  	Thread.sleep(1000);
  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
  	Thread.sleep(500);
  	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
  		
  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
  	try
  	{
  		Thread.sleep(700);
  		if(OverduePOM.checkRecordsTable().isDisplayed())
  		{
  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
  		}
  		else
  		{
  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
  		}
  	}
  	catch(Exception e)
  	{
  		
  	}
					OverduePOM.clickDashboard().click();
			test.log(LogStatus.PASS, "Test Passed.");
			extent.endTest(test);
			extent.flush();
	 }
	 
//	 @Test(priority = 22)
		void PerformerTaskOverdueStatutory() throws InterruptedException{
		 
		 test = extent.startTest("Dashboard Statutory Overdue Performer Task Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			
			test.log(LogStatus.INFO, "***********Overdue Statutory Performer Task************ ");
			
			js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTOverdueStatutory()));
			
			Thread.sleep(500);
		//	litigationPerformer.MethodsPOM.progress();
			OverduePOM.clickPTOverdueStatutory().click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
			Thread.sleep(500);
			OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
			int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
			OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
			//wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
			
			test.log(LogStatus.INFO, "------------- Statutory -------------");
			Thread.sleep(1000);
			OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
			Select drp = new Select(OverduePOM.clickActFilter());
			drp.selectByIndex(2);										//Selecting third Act
			
			Thread.sleep(1000);
		//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
			OverduePOM.clickComplianceDropDown().click();			//Clicking on 'Compliance' drop down.
			drp = new Select(OverduePOM.clickComplianceDropDown());
			drp.selectByIndex(1);										
			
			Thread.sleep(500);
			sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
			Cell c1 = null;
			row0= sheet.getRow(3);
			c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
			OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
		
			row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
			c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
			OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
			
			row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
			c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
			int day = (int) c1.getNumericCellValue();
			OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
			
		  Select taskType=new Select(	OverduePOM.clickTaskType());
		  taskType.selectByIndex(1);
		  Thread.sleep(1000);

		OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
		
		js.executeScript("window.scrollBy(0,2000)");
		row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
		c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
		OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
		
		row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
		c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
		OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
		
		row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
		c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
		OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
			
		js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
		Thread.sleep(1500);
	//	String workingDir = System.getProperty("user.dir");
		OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");
		
		Thread.sleep(1000);
		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		
		Thread.sleep(500);
		String saveMsg = OverduePOM.taskSavedMsg().getText();
		OverduePOM.taskSavedMsg().click();
		
		if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
		}
		
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
		Thread.sleep(1000);
		OverduePOM.ClickTaskCreation().click();
		int total1 = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
		
		if(total1 > total)
		{
			test.log(LogStatus.PASS, "New Task added and displayed successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
		}
		
		//-------------------------------Create Sub Task--------------------------------------
  	OverduePOM.ClickTaskCreation().click();
  	Thread.sleep(3000);
  	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
  	int no = elementsList1.size();

  	Thread.sleep(2000);
  	elementsList1.get(3).click();

  	Thread.sleep(4000);

  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
  	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
  	Thread.sleep(3000);
  	 sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
  		 row = 0;
  		Thread.sleep(500);
  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
  		Cell c11 = null;
  		row01= sheet.getRow(10);
  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
  	OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
  	int day1 = (int) c11.getNumericCellValue();
  	OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

  	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

  	js.executeScript("window.scrollBy(0,2000)");
  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
  	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
  	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
  	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
  		
  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
  	Thread.sleep(1500);
  	//String workingDir = System.getProperty("user.dir");
  	OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");

  	Thread.sleep(1000);
  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
  	Thread.sleep(500);
  	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
  		
  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
  	try
  	{
  		Thread.sleep(700);
  		if(OverduePOM.checkRecordsTable().isDisplayed())
  		{
  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
  		}
  		else
  		{
  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
  		}
  	}
  	catch(Exception e)
  	{
  		
  	}
		OverduePOM.clickDashboard().click();
		
			test.log(LogStatus.PASS, "Test Passed.");
				extent.endTest(test);
				extent.flush();
	 }
//@Test(priority = 23)
		void PerformerTaskOverdueInternal() throws InterruptedException{
		 
		 test = extent.startTest("Dashboard Internal Overdue Performer Task Verification");
			
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			
			test.log(LogStatus.INFO, "***********Overdue Statutory Performer Task************ ");
			
			js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTOverdueInternal()));
			
			Thread.sleep(500);
		//	litigationPerformer.MethodsPOM.progress();
			OverduePOM.clickPTOverdueInternal().click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
			Thread.sleep(500);
			Thread.sleep(3000);
			OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
			
			int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
			
		//	OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
			Thread.sleep(3000);
		//	wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
			OverduePOM.clickAddNew1().click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
			
					test.log(LogStatus.INFO, "------------- Internal -------------");
					
					OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
					Thread.sleep(2000); 
					Select drp = new Select(OverduePOM.clickInternalCompliance());
					drp.selectByIndex(1);
					Thread.sleep(1000);
					
				   sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
						int row = 0;
						Thread.sleep(500);
						Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
						Cell c1 = null;
						row0= sheet.getRow(3);
						c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
					OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
					
					row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
					c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
					OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
					
					row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
					c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
					int day = (int) c1.getNumericCellValue();
					OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
					
				  Select taskType=new Select(	OverduePOM.clickTaskType());
				  taskType.selectByIndex(1);
				  Thread.sleep(2000);

					OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
					
					js.executeScript("window.scrollBy(0,2000)");
					row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
					c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
					OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
					
					row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
					c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
					OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
					
					row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
					c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
					OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
						
					js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
					Thread.sleep(1500);
				//	String workingDir = System.getProperty("user.dir");
					OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");
					
					Thread.sleep(1000);
					OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
					
					Thread.sleep(500);
					String saveMsg = OverduePOM.taskSavedMsg().getText();
					OverduePOM.taskSavedMsg().click();
					
					if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
					{
						test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
					}
					else
					{
						test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
					}
					
					getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
					Thread.sleep(1000);
					OverduePOM.ClickTaskCreation().click();
					int total1 = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
					
					if(total1 > total)
					{
						test.log(LogStatus.PASS, "New Task added and displayed successfully.");
					}
					else
					{
						test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
					}
					
					//-------------------------------Create Sub Task--------------------------------------
				  	OverduePOM.ClickTaskCreation().click();
				  	Thread.sleep(3000);
				  	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
				  	int no = elementsList1.size();

				  	Thread.sleep(2000);
				  	elementsList1.get(4).click();

				  	Thread.sleep(4000);

				  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
				  	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
				  	Thread.sleep(3000);
				  	 sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
				  		 row = 0;
				  		Thread.sleep(500);
				  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
				  		Cell c11 = null;
				  		row01= sheet.getRow(10);
				  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
				  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

				  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
				  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
				  	OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

				  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
				  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
				  	int day1 = (int) c11.getNumericCellValue();
				  	OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

				  	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

				  	js.executeScript("window.scrollBy(0,2000)");
				  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
				  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
				  	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

				  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
				  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
				  	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

				  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
				  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
				  	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
				  		
				  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
				  	Thread.sleep(1500);
				  	//String workingDir = System.getProperty("user.dir");
				  	OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");

				  	Thread.sleep(1000);
				  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
				  	Thread.sleep(500);
				  	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

				  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
				  		
				  	getDriver()	.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
				  	try
				  	{
				  		Thread.sleep(700);
				  		if(OverduePOM.checkRecordsTable().isDisplayed())
				  		{
				  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
				  		}
				  		else
				  		{
				  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
				  		}
				  	}
				  	catch(Exception e)
				  	{
				  		
				  	}
					OverduePOM.clickDashboard().click();
					test.log(LogStatus.PASS, "Test Passed.");
					extent.endTest(test);
					extent.flush();
		}
		
// @Test(priority = 24)
			void PerformerTaskRejectedStatutory() throws InterruptedException{
			 
			 test = extent.startTest("Dashboard Statutory Overdue Performer Task Verification");
				test.log(LogStatus.INFO, "Test Initiated");
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				
				test.log(LogStatus.INFO, "***********Rejected Statutory Performer Task************ ");
				
				js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
				
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTRejectedStatutory()));
				
				Thread.sleep(500);
				//litigationPerformer.MethodsPOM.progress();
				OverduePOM.clickPTRejectedStatutory().click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
				Thread.sleep(500);
				OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
				
				int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
				OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
				//wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
				
				test.log(LogStatus.INFO, "------------- Statutory -------------");
				Thread.sleep(1000);
				OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
				Select drp = new Select(OverduePOM.clickActFilter());
				drp.selectByIndex(2);										//Selecting third Act
				
				Thread.sleep(1000);
			//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
				OverduePOM.clickComplianceDropDown().click();			//Clicking on 'Compliance' drop down.
				drp = new Select(OverduePOM.clickComplianceDropDown());
				drp.selectByIndex(1);										
				Thread.sleep(500);
		   sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
				Cell c1 = null;
				row0= sheet.getRow(3);
				c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
			OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
			
			row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
			c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
			OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
			
			row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
			c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
			int day = (int) c1.getNumericCellValue();
			OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
			
		  Select taskType=new Select(	OverduePOM.clickTaskType());
		  taskType.selectByIndex(1);
		  Thread.sleep(1000);

			OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
			
			js.executeScript("window.scrollBy(0,2000)");
			row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
			c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
			OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
			
			row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
			c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
			OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
			
			row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
			c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
			OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
				
			js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
			Thread.sleep(1500);
			String workingDir = System.getProperty("user.dir");
			OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");
			
			Thread.sleep(1000);
			OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
			
			Thread.sleep(500);
			String saveMsg = OverduePOM.taskSavedMsg().getText();
			OverduePOM.taskSavedMsg().click();
			
			if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
			{
				test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
			}
			else
			{
				test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
			}
			
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
			Thread.sleep(1000);
			OverduePOM.ClickTaskCreation().click();
			int total1 = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
			
			if(total1 > total)
			{
				test.log(LogStatus.PASS, "New Task added and displayed successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
			}
			
			//-------------------------------Create Sub Task--------------------------------------
		  	OverduePOM.ClickTaskCreation().click();
		  	Thread.sleep(3000);
		  	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
		  	int no = elementsList1.size();

		  	Thread.sleep(2000);
		  	elementsList1.get(5).click();

		  	Thread.sleep(4000);

		  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
		  	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
		  	Thread.sleep(3000);
		  	 sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
		  		 row = 0;
		  		Thread.sleep(500);
		  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
		  		Cell c11 = null;
		  		row01= sheet.getRow(10);
		  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
		  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

		  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
		  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
		  	OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

		  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
		  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
		  	int day1 = (int) c11.getNumericCellValue();
		  	OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

		  	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

		  	js.executeScript("window.scrollBy(0,2000)");
		  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
		  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
		  	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

		  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
		  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
		  	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

		  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
		  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
		  	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
		  		
		  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
		  	Thread.sleep(1500);
		  	//String workingDir = System.getProperty("user.dir");
		  	OverduePOM.SampleFormUpload().sendKeys("E:\\AVACOM Project\\AvacomModified\\Reports\\PerformerResults.html");

		  	Thread.sleep(1000);
		  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		  	Thread.sleep(500);
		  	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

		  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
		  		
		  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
		  	try
		  	{
		  		Thread.sleep(700);
		  		if(OverduePOM.checkRecordsTable().isDisplayed())
		  		{
		  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
		  		}
		  		else
		  		{
		  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
		  		}
		  	}
		  	catch(Exception e)
		  	{
		  		
		  	}
			OverduePOM.clickDashboard().click();
			test.log(LogStatus.PASS, "Test Passed.");
			extent.endTest(test);
			extent.flush();
		 }
			
	//	@Test(priority = 25)
			void PerformerTaskRejectedInternal() throws InterruptedException{
			 
			 test = extent.startTest("Dashboard Internal Rejected Performer Task Verification");
				
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				
				test.log(LogStatus.INFO, "***********Rejected Internal  Performer Task************ ");
				
				js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
				
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTRejectedInternal()));
				
				Thread.sleep(500);
		//		litigationPerformer.MethodsPOM.progress();
				OverduePOM.clickPTRejectedInternal().click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
				Thread.sleep(500);
				Thread.sleep(3000);
				OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
				
				int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
				
			//	OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
				Thread.sleep(3000);
			//	wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
				OverduePOM.clickAddNew1().click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
				
						test.log(LogStatus.INFO, "------------- Internal -------------");
						
						OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
						Thread.sleep(2000); 
						Select drp = new Select(OverduePOM.clickInternalCompliance());
						drp.selectByIndex(1);
						Thread.sleep(1000);
						
					 //  sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
							int row = 0;
							Thread.sleep(500);
							Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
							Cell c1 = null;
							row0= sheet.getRow(3);
							c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
						OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
								
						row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
						c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
						OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
						
						row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
						c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
						int day = (int) c1.getNumericCellValue();
						OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
						
					  Select taskType=new Select(	OverduePOM.clickTaskType());
					  taskType.selectByIndex(1);
					  Thread.sleep(2000);

						OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
						
						js.executeScript("window.scrollBy(0,2000)");
						row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
						c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
						OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
						
						row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
						c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
						OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
						
						row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
						c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
						OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
							
						js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
						Thread.sleep(1500);
				//		String workingDir = System.getProperty("user.dir");
						OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");
						
						Thread.sleep(1000);
						OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
						
						Thread.sleep(500);
						String saveMsg = OverduePOM.taskSavedMsg().getText();
						OverduePOM.taskSavedMsg().click();
						
						if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
						{
							test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
						}
						else
						{
							test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
						}
						
						getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
						Thread.sleep(1000);
						OverduePOM.ClickTaskCreation().click();
						int total1 = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
						
						if(total1 > total)
						{
							test.log(LogStatus.PASS, "New Task added and displayed successfully.");
						}
						else
						{
							test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
						}
						
						//-------------------------------Create Sub Task--------------------------------------
					  	OverduePOM.ClickTaskCreation().click();
					  	Thread.sleep(3000);
					  	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
					  	int no = elementsList1.size();

					  	Thread.sleep(2000);
					  	elementsList1.get(3).click();

					  	Thread.sleep(4000);

					  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
					  	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
					  	Thread.sleep(3000);
					  	 sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
					  		 row = 0;
					  		Thread.sleep(500);
					  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
					  		Cell c11 = null;
					  		row01= sheet.getRow(10);
					  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
					  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

					  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
					  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
					  	OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

					  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
					  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
					  	int day1 = (int) c11.getNumericCellValue();
					  	OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

					  	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

					  	js.executeScript("window.scrollBy(0,2000)");
					  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
					  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
					  	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

					  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
					  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
					  	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

					  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
					  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
					  	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
					  		
					  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
					  	Thread.sleep(1500);
					  	//String workingDir = System.getProperty("user.dir");
					  	OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

					  	Thread.sleep(1000);
					  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
					  	Thread.sleep(500);
					  	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

					  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
					  		
					  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
					  	try
					  	{
					  		Thread.sleep(700);
					  		if(OverduePOM.checkRecordsTable().isDisplayed())
					  		{
					  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
					  		}
					  		else
					  		{
					  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
					  		}
					  	}
					  	catch(Exception e)
					  	{
					  		
					  	}
						OverduePOM.clickDashboard().click();
						test.log(LogStatus.PASS, "Test Passed.");
						extent.endTest(test);
						extent.flush();
			}
			
	        /*    @Test(priority = 40)
				void PerformerTaskPerformUpcomingStatutory() throws InterruptedException{
					test = extent.startTest("Dashboard Statutory Upcoming Performer Task Count Verification");
					
					
					MethodsPOM.PerformUpcomingStatutory( test);
					
					extent.endTest(test);
			  		extent.flush();
			
			 }
				
	             @Test(priority = 41)
					void PerformerTaskPerformUpcomingInternal() throws InterruptedException{
						test = extent.startTest("Dashboard Internal Upcoming Performer Task Count Verification");
						
						
						MethodsPOM.PerformUpcomingInternal( test);
						
						extent.endTest(test);
				  		extent.flush();
				
				 }
					
	    	@Test(priority = 42)
		   void PerformerTaskPerformOverdueStatutory() throws InterruptedException{
						test = extent.startTest("Dashboard Statutory Overdue Performer Task Count Verification");
						
						
						MethodsPOM.PerformOverdueStatutory( test);
						
						extent.endTest(test);
				  		extent.flush();
				
				 }	
		
		 @Test(priority = 43)
			void PerformerTaskPerformOverdueInternal() throws InterruptedException{
				test = extent.startTest("Dashboard Internal Overdue Performer Task Count Verification");
				
				
				MethodsPOM.PerformOverdueInternal( test);
				
				extent.endTest(test);
		  		extent.flush();
		
		 }
			
		@Test(priority = 44)
			void PerformerTaskPerformRejectedStatutory() throws InterruptedException{
							test = extent.startTest("Dashboard Statutory Rejected Performer Task Count Verification");
							
							
							MethodsPOM.PerformRejectedStatutory( test);
							
							extent.endTest(test);
					  		extent.flush();
					  		
					 }	
			
    	@Test(priority = 45)
				void PerformerTaskPerformRejectedInternal() throws InterruptedException{
					test = extent.startTest("Dashboard Internal Rejected Performer Task Count Verification");
					
					
					MethodsPOM.PerformRejectedInternal( test);
					
					extent.endTest(test);
			  		extent.flush();
			
			 }
						
	//	@Test(priority = 46) //pass fri not run
	       void ComplianceSatCalender() throws InterruptedException
				{
					test = extent.startTest("My Compliance Calender Statutory perform Verification");
					
					Thread.sleep(3000);
					WebDriverWait wait = new WebDriverWait( getDriver(),(30));
					JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
					js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
					Thread.sleep(8000);
					OverduePOM.clickStaBtnCale().click();
					Thread.sleep(3000);
				//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));	//Waiting for records table to get visible
					Thread.sleep(4000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
					Thread.sleep(3000);
					elementsList = OverduePOM.clickCalenderAction();
					Thread.sleep(2000);
					elementsList.get(0).click();
					Thread.sleep(4000);
					
					getDriver().switchTo().parentFrame();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					Thread.sleep(3000);
					
					
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iChecklistPerformerFrame"));
					js.executeScript("window.scrollBy(0,500)");                 	
				
					Thread.sleep(500);
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
					Thread.sleep(3000);
					OverduePOM.fileUploadStatutory().sendKeys("C:\\Users\\Mayuri\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
										//Clicking on 'Add Link' button of Compliance Documents
					Thread.sleep(2000);
					Thread.sleep(1000);
					js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
				
					OverduePOM.remark().sendKeys("Automation");
					Thread.sleep(1000);
					.findElement(By.xpath("//*[@id='btnSave']")).click();
					Thread.sleep(1000);
					getDriver().switchTo().alert().accept();	
					//MethodsPOM.MyCalendarCompliance( test);
					getDriver().switchTo().parentFrame();
					getDriver().switchTo().parentFrame();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "Calendder Statutory perform Succefully");
					OverduePOM.clickDashboard().click();
					extent.endTest(test);
					extent.flush();
					
					
				}
			
	   //   @Test(priority = 47) //pass fri not run
	       void ComplianceInternalCalender() throws InterruptedException
				{
					test = extent.startTest("My Compliance Calender Internal perform Verification");
					
					Thread.sleep(3000);
					WebDriverWait wait = new WebDriverWait( getDriver(), (60));
					JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
					js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
					Thread.sleep(8000);
					OverduePOM.clickInterBtnCale().click();
					Thread.sleep(3000);
				//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));	//Waiting for records table to get visible
					Thread.sleep(4000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
					Thread.sleep(3000);
					elementsList = OverduePOM.clickCalenderAction();
					Thread.sleep(2000);
					elementsList.get(0).click();
					Thread.sleep(4000);
					
					getDriver().switchTo().parentFrame();
					Thread.sleep(3000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					Thread.sleep(3000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iInternalPerformerFrame"));
					js.executeScript("window.scrollBy(0,500)");                  	
				
					Thread.sleep(500);
					Select status = new Select(OverduePOM.selectStatutoryDropdown1());	//Selecting dropdown box
					status.selectByIndex(1);											//Selecting 2nd value from dropdown.
					
					Thread.sleep(500);
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory2()));
					Thread.sleep(3000);
					OverduePOM.fileUploadStatutory2().sendKeys("C:\\Users\\Mayuri\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
				//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
					Thread.sleep(2000);
					Thread.sleep(1000);
					js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
					
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory1()));
					OverduePOM.selectDateStatutory1().click();					//Click on the Date text box
					OverduePOM.selectLastMonth().click();						//Clicking to get last month
					Thread.sleep(1000);
					OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
					
					OverduePOM.remark1().sendKeys("Automation Testing");
					Thread.sleep(1000);
					.findElement(By.xpath("//*[@id='btnSave2']")).click();
					Thread.sleep(1000);
					getDriver().switchTo().alert().accept();	
					//MethodsPOM.MyCalendarCompliance( test);
					getDriver().switchTo().parentFrame();
					getDriver().switchTo().parentFrame();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "Calendder Internal perform Succefully");
					OverduePOM.clickDashboard().click();
					extent.endTest(test);
					extent.flush();
					
				}*/
	  
		
		@Test(priority = 77)// non-critical
		void DailyUpdates() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'Daily Updates'  OverView");
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//	js.executeScript("window.scrollBy(0,4600)");					//Scrolling down window by 2600 px.
			js.executeScript("window.scrollBy(0,1500)");
			Thread.sleep(4000);	
			CFOcountPOM.clickViewAllDU().click();
			Thread.sleep(4000);	
		//	WebDriverWait wait = new WebDriverWait( getDriver(), Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
			CFOcountPOM.clickView1().click();
			Thread.sleep(4000);	
			CFOcountPOM.closeNewsView().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "view Successfully");
			OverduePOM.searchBox().sendKeys("Haryana Land Partnership Policy-2022");
			Thread.sleep(500);
			OverduePOM.ClicksearchBtn().click();
			Thread.sleep(7000);
			test.log(LogStatus.PASS, "Search Successfully");
			Thread.sleep(1000);
			OverduePOM.ClickClearBtn().click();
			Thread.sleep(8000);
			test.log(LogStatus.PASS, "Clear button Working Successfully");
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(1000);
			extent.endTest(test);
			extent.flush();
		}
		
     	@Test(priority = 78)
		void NewsLetter() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'News Letters'  OverView");
			
			Thread.sleep(500);
			WebDriverWait wait = new WebDriverWait( getDriver(), (40));
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,1500)","");					//Scrolling down window by 2600 px.
			
			CFOcountPOM.clickViewAllNL().click();
			Thread.sleep(4000);	
		//	WebDriverWait wait = new WebDriverWait( getDriver(), Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
			CFOcountPOM.clickView2().click();
			Thread.sleep(4000);	
			CFOcountPOM.closeNewsLView().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "OverView Successfully");
			performer.OverduePOM.clickDashboard().click();
			
			extent.endTest(test);
			extent.flush();
		}	
	       
	       @Test(priority = 79)
			void InternalMsg() throws InterruptedException, IOException
			{
				Thread.sleep(500);		
				test = extent.startTest("'Internal Msg  '  Verification");
				
					Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait( getDriver(),(40));
				Thread.sleep(500);
				OverduePOM.ClickInternalMsg().click();
				Thread.sleep(4000);
				OverduePOM.ClickTo().sendKeys("mayuri@tlregtech.in");
				Thread.sleep(500);
				OverduePOM.ClickSub().sendKeys("Automation");
				Thread.sleep(1000);
				OverduePOM.TypeMsg().sendKeys("Automation testing");
				Thread.sleep(1000);
				OverduePOM.choosefile().sendKeys("E:\\Test Cases\\Approver Test Case.xlsx");
				Thread.sleep(1000);
				//OverduePOM.send().click();
				By locator = By.xpath("//*[@id='btnsendmailNew']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "Internal Message working Successfully");
				Thread.sleep(1000);
				extent.endTest(test);
				extent.flush();
			}
			
			 @Test(priority = 80)
				void SupportTicket() throws InterruptedException, IOException
				{
					Thread.sleep(1000);		
					test = extent.startTest("'Support Ticket  '  Verification");
					
					
					MethodsPOM.SupportTicket(test);
					
					extent.endTest(test);
					extent.flush();
				}
				
			
		            
		      //    @Test(priority = 81) //pass
		            void MyEscalation() throws InterruptedException
		      			{
		      				test = extent.startTest("My Escalation Verification");
		      			
		      				Thread.sleep(3000);
		      				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		      				OverduePOM.clickMyEscalation().click();
		      				Thread.sleep(4000);
		      				getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]")).click();
		      				Thread.sleep(1000);
		      				getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[11]/input")).clear();
		      				Thread.sleep(1000);
		      				getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[11]/input")).sendKeys("6");
		      				Thread.sleep(1000);
		      				getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[12]/input")).clear();
		      				getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[12]/input")).sendKeys("4");
		      				Thread.sleep(2000);
		      				getDriver().findElement(By.xpath("//*[@id='btnsave']")).click();
		      				Thread.sleep(2000);
						      	String Msg=			getDriver().switchTo().alert().getText();
						      	Thread.sleep(2000);
						      	test.log(LogStatus.PASS, "Message Displayed : -"+Msg);
						      	Thread.sleep(2000);
						      	getDriver().switchTo().alert().accept();
		      				Thread.sleep(2000);
		      				Thread.sleep(500);
		      				OverduePOM.clickDashboard().click();
		      				Thread.sleep(2000);
		      				extent.endTest(test);
		      				extent.flush();
		      				
		      			}
		            
		            @Test(priority = 82)
		        	void ActDocuments() throws InterruptedException, IOException
		        	{
		        		test = extent.startTest("Act Documents  verification");
		        		
		        		
		        		MethodsPOM.ActDocuments(test);
		        		
		        		extent.endTest(test);
		        		extent.flush();
		        	}
				
		        //    @Test(priority = 83) //pass 
			       void EventReport() throws InterruptedException
						{
							test = extent.startTest("Event Report Verification");
							
							
							MethodsPOM.EventReport(test);
							
							extent.endTest(test);
							extent.flush();
						}
		      		       
			      
			
			 @Test(priority = 84) //pass 
		       void WhatsNew() throws InterruptedException, IOException
					{
						test = extent.startTest("' what's New ' Verification");
						
						
						MethodsPOM.WhatsNew(test);
						
						extent.endTest(test);
						extent.flush();
					}
		      
		  //    @Test(priority = 85) //pass 
		       void MyLeave() throws InterruptedException, IOException
					{
						test = extent.startTest(" My Leave  - temporary assignment -  add new - To check whether the compliance can be reassign to new users or not?");
						
						
						MethodsPOM.MyLeave(test);
						
						extent.endTest(test);
						extent.flush();
					}
		       
		 //      @Test(priority = 86) //pass 
		       void MyLeaveIn() throws InterruptedException, IOException
					{
						test = extent.startTest(" My Leave  - temporary assignment -  add new - Internal -  To check whether the compliance can be reassign to new users or not?");
						
						
						MethodsPOM.MyLeaveIn(test);
						
						extent.endTest(test);
						extent.flush();
					}
		       
		 //  	@Test(priority = 87)
			void DetailedReportAPer() throws InterruptedException, IOException
			{
				test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in details tab on the view icon of Detailed report?");
				
				
				MgmtAMethod.DetailedReportAPer(test);
				
				extent.endTest(test);
				extent.flush();
			}
		   	
		  //@Test(priority = 28)
			void Reopening() throws InterruptedException, IOException
			{
				test = extent.startTest("My Reopening - To check whether the new tab named \"My Reopening\" is seperately reflects or not on the dashboard in the main menu while the tab will be visible only for who have made the configuration.");
					
				DeptCountPOM.Reopening(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		/*	@Test(priority = 29)
			void ReopeningRe() throws InterruptedException, IOException
			{
				test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Re-open");
					
				DeptCountPOM.ReopeningRe(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 30)
			void Reopeningapprove() throws InterruptedException, IOException
			{
				test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Approve");
					
				DeptCountPOM.Reopeningapprove(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 31)
			void ReopeningExport() throws InterruptedException, IOException
			{
				test = extent.startTest("My Reopening - To Check Whether Export button of working or not?");
					
				DeptCountPOM.ReopeningExport(test);
				
				extent.endTest(test);
				extent.flush();
			}*/
			
		//	@Test(priority = 31)
			void DeviationApplied() throws InterruptedException, IOException
			{
				test = extent.startTest("My Calendar - To check that, after selection of \"Deviation Applied\" status in the status dropdown, the three new fields (Reason for Overdue / Delay Compliance, Deviation Closure Date, Upload Supporting Document) are visible or not in the update compliance status?");
					
				MethodsPOM.DeviationApplied(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 32)
			void DeviationAppliedW() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - compliance - To check that, after selection of \"Deviation Applied\" status in the status dropdown, the three new fields (Reason for Overdue / Delay Compliance, Deviation Closure Date, Upload Supporting Document) are visible or not in the update compliance status?");
					
				MethodsPOM.DeviationAppliedW(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 32)
			void DeviationAppliedWS() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - compliance - To check whether records are submitted after entering the data in \"reason for delay/overdue compliance\" and \"Deviation closer date\"?");
					
				MethodsPOM.DeviationAppliedWS(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 32)
			void DeviationAppliedWD() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - compliance - To check that the \"Upload Supporting Document\" field is non mandatory.");
					
				MethodsPOM.DeviationAppliedWD(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 32)
			void DeviationAppliedWR() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - compliance - To check that the \"Reason for Overdue / Delay Compliance and Deviation Closure Date\" fileds are mandatory or not?");
					
				MethodsPOM.DeviationAppliedWR(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 32)
			void DeviationAppliedWCD() throws InterruptedException, IOException
			{
				test = extent.startTest("Performer Summary - Checklist - To check while performing an checklist compliance  Deviation Approval button or not");
					
				MethodsPOM.DeviationAppliedWCD(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 33)
			void DeviationAppliedWC() throws InterruptedException, IOException
			{
				test = extent.startTest("Performer Summary - Checklist - To check while Enter the mandatory details  without entering the mandatoy fields (Reason for Overdue / Delay Compliance, Deviation Closure Date, Upload Supporting Document) do not enter date in these fields and clicked on Closed Timely,Closed Dealyed or Not Applicable button.");
					
				MethodsPOM.DeviationAppliedWC(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 33)
			void OverdueDA() throws InterruptedException, IOException
			{
				test = extent.startTest("Performer Summary - Overdue - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my workspace page?");
					
				MethodsPOM.OverdueDA(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 33)
			void DeviationApproverCol() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - compliance - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\"in grid and downloaded export report of My workspace ");
					
				MethodsPOM.DeviationApproverCol(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 34)
			void DeviationClosureStatuscol() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - compliance - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
					
				MethodsPOM.DeviationClosureStatuscol(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//@Test(priority = 35)
			void ComplianceDocumentsDA() throws InterruptedException, IOException
			{
				test = extent.startTest("My Documents - Compliance Documents - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my document page?");
					
				MethodsPOM.ComplianceDocumentsDA(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 36)
			void DeviationApproverColCD() throws InterruptedException, IOException
			{
				test = extent.startTest("My Documents - Compliance Documents - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\"in grid  of My document page?");
					
				MethodsPOM.DeviationApproverColCD(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 37)
			void DeviationClosureStatuscolCD() throws InterruptedException, IOException
			{
				test = extent.startTest("My Documents - Compliance Documents - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
					
				MethodsPOM.DeviationClosureStatuscolCD(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		@Test(priority = 37)
			void DetailedReportDA() throws InterruptedException, IOException
			{
				test = extent.startTest("my Report - Detailed  report - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my report page?");
					
				MethodsPOM.DetailedReportDA(test);
				
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
		      		       		
		      	@AfterTest
		      	void Closing() throws InterruptedException
		      	{
		      		
		      	}
				
				
				
				
				
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
				
		 
	   //    @Test(priority = 39)
			void LiveChat() throws InterruptedException, IOException
			{
				Thread.sleep(500);		
				test = extent.startTest("'Live Chat '  Verification");
				
				Thread.sleep(1000);
				WebDriverWait wait = new WebDriverWait( getDriver(), (40));
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tawk-custom-color tawk-custom-border-color tawk-button tawk-button-circle tawk-button-large']")));
				Thread.sleep(500);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("jpu4a9g0g1io1671521533203"));	//Wait until frame get visible and switch to it.
				Thread.sleep(3000);
			//WebElement frame1=.findElement(By.xpath("//*[@id='jpu4a9g0g1io1671521533203']"));
		//	.switchTo().frame(frame1);
				OverduePOM.ClickLivechat().click();
				Thread.sleep(2000);
				getDriver().switchTo().parentFrame();
			/*	Thread.sleep(500);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("vgchbp6p9au1671521533260"));	//Wait until frame get visible and switch to it.
				Thread.sleep(500);
				
				OverduePOM.EmailtextBox().sendKeys("deepali@tlregtech.in");
				Thread.sleep(500);
				OverduePOM.StratChat().click();
				Thread.sleep(500);
				getDriver().switchTo().parentFrame();
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("jpu4a9g0g1io1671521533203"));	//Wait until frame get visible and switch to it.
				Thread.sleep(500);
				OverduePOM.ClickLivechat().click();*/
				extent.endTest(test);
				extent.flush();
			}          
	       
	//	@Test(priority = 24) //pass
		       void ComplianceCalender() throws InterruptedException
			{
				test = extent.startTest("My Compliance Calender Count Verification");
				
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait( getDriver(),(60));
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
				Thread.sleep(4000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='export']")).click();
				Thread.sleep(2000);
				elementsList = OverduePOM.clickCalenderAction();
				Thread.sleep(2000);
				elementsList.get(0).click();
				Thread.sleep(4000);
				
			//	.switchTo().frame("showdetails");
				Thread.sleep(1000);
			//	.switchTo().frame("ContentPlaceHolder1_iInternalPerformerFrame");
				getDriver().switchTo().parentFrame();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				Thread.sleep(1000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iInternalPerformerFrame"));
				js.executeScript("window.scrollBy(0,500)");	
				
				Thread.sleep(500);
				Select status = new Select(OverduePOM.selectStatutoryDropdown1());	//Selecting dropdown box
				status.selectByIndex(1);											//Selecting 2nd value from dropdown.
				
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory2()));
				Thread.sleep(3000);
				OverduePOM.fileUploadStatutory2().sendKeys("C:/Users/sandip/Downloads/Holiday List 2022.xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(2000);
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
				
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory1()));
				OverduePOM.selectDateStatutory1().click();					//Click on the Date text box
				OverduePOM.selectLastMonth().click();						//Clicking to get last month
				Thread.sleep(1000);
				OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
				
				OverduePOM.remark1().sendKeys("Automation Testing");
				Thread.sleep(1000);
				getDriver().findElement(By.xpath("//*[@id='btnSave2']")).click();
				Thread.sleep(1000);
				getDriver().switchTo().alert().accept();	
				//MethodsPOM.MyCalendarCompliance( test);
				getDriver().switchTo().parentFrame();
				getDriver().switchTo().parentFrame();
				Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
				extent.endTest(test);
				extent.flush();
			}
		       
		       @Test(priority = 25)
				void DetailedReportSF() throws InterruptedException, IOException
				{
					test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Deatiled Report?");
					
					MethodsPOM.DetailedReportSF(test);
					
					extent.endTest(test);
					extent.flush();
				}
				@Test(priority = 26)
				void ComplianceDocumentsSF() throws InterruptedException, IOException
				{
					test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Compliance Document?");
					
					MethodsPOM.ComplianceDocumentsSF(test);
					
					extent.endTest(test);
					extent.flush();
				}
		       
  
}
