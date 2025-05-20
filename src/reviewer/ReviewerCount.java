package reviewer;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
import org.openqa.selenium.interactions.Actions;
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
import departmentHead.DeptCountPOM;
import login.BasePage;
import performer.MethodsPOM;
import performer.OverduePOM;

public class ReviewerCount extends BasePage 
{
//	public static Web  = null;		//Web instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	
	static String filePath ="E:\\Regtrack Merge Project\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx";
	public static String link = "mgmt1";
	public static XSSFSheet ReadExcel() throws IOException
	{
		
		fis = new FileInputStream("E:\\Regtrack Merge Project\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(1);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		//String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\Regtrack Merge Project\\Regtrack-Project\\Reports\\ReviewerResults.html",true);
		test = extent.startTest("Logging In - Reviewer");
		test.log(LogStatus.PASS, "Logging into system");
		
					
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
	//	test = extent.startTest("Logging In - Reviewer");
	//	test.log(LogStatus.PASS, "Logging into system");
	//	initialization("FM",9,"Statutory");
		initialization(link,9,"Statutory");
		
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		Thread.sleep(3000);
	
	//	XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		 = login.Login.UserLogin(uname,password,"PendingReview");		//Method of Login class to login user.
		*/
		
	//	extent.endTest(test);
	//	extent.flush();
	}

	@Test(priority = 2) //pass
	 void ReviewCountStatutoryApprove() throws InterruptedException, IOException
		{
			test = extent.startTest("Statutory Pending For Review Count and Completed when Approved");
		
			Thread.sleep(4000);
			WebDriverWait wait = new WebDriverWait( getDriver(),  30);
			
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickStatutoryReview()));	//Wait until Statutory Pending For Review count gets visible.
			
			int oldValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());	//Reading old value of Statutory Pending For Review
			int OldCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickCompletedSta().getText());	//Reading old value of Internal Reject

			ReviewerPOM.clickStatutoryReview().click();		//Clicking on Statutory Review value.
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
			Thread.sleep(8000);
			
		//	elementsList = ReviewerPOM.clickStatus();			//CLicking on Status to sort it in ascending order
		//	elementsList.get(0).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
			ReviewerPOM.clickAction1().click();				//Clicking on third action button.
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iReviewerFrame"));
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,500)"," ");
			
			try
			{
				//Thread.sleep(500);
				ReviewerPOM.clickDownload1().click();					//Clicking on 'Click Here' label.
			}
			catch(Exception e)
			{
				
			}
			try
			{
				//Thread.sleep(500);
				ReviewerPOM.clickDownload2().click();					//Clicking on 'Click Here' label.
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,300)"," ");					//Scrolling down window by 2000 px.
			
			WebElement el = null;
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimely()));
				el = ReviewerPOM.clickClosedTimely();			
			}
			catch(Exception e)
			{
				
			}
			if(el != null)
			{
			//	Thread.sleep(500);
				ReviewerPOM.clickClosedTimely().click();				//Clicking on first radio button.
			}
			
			WebElement checkbox = null;
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickCheckBox()));
				checkbox = ReviewerPOM.clickCheckBox();				//Clicking on Check box
			}
			catch(Exception e)
			{
				
			}
			if(checkbox != null)
			{
				if(checkbox.isDisplayed() && !checkbox.isSelected())
					ReviewerPOM.clickCheckBox().click();
			}
			
			//Thread.sleep(500);
			 FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(1);
			WebElement ele1 = null;
			WebElement ele2 = null;
			WebElement ele3 = null;
			try
			{
			//	Thread.sleep(600);
				//wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertLiability1()));
				ele1 = ReviewerPOM.insertLiability1();			//Loaded element in ele1. So that, if element not found it will do nothing.
				ele2 = ReviewerPOM.insertLiability2();			//Loaded element in ele2. So that, if element not found it will do nothing.
				ele3 = ReviewerPOM.insertLiability3();			//Loaded element in ele3. So that, if element not found it will do nothing.
			}
			catch(Exception e)
			{
				
			}
			if(ele1 != null)
			{
				Row row3 = sheet.getRow(3);									//Selected 3rd index row (Fourth row)
				Cell c1 = row3.getCell(1);									//Selected cell (3 row,1 column)
				int liability1 = (int) c1.getNumericCellValue();			//Got the amount stored at position 3,1
				String l1 = Integer.toString(liability1); 					//Converting int to String
				ReviewerPOM.insertLiability1().clear();				//Clearing the text box.
				ReviewerPOM.insertLiability1().sendKeys(l1);			//Inserting amount in text box
				Thread.sleep(400);
			}
			
			if(ele2 != null)
			{
				Row row4 = sheet.getRow(4);											//Selected 4th index row (Fifth row)
				Cell c2 = row4.getCell(1);											//Selected cell (4 row,1 column)
				int liability2 = (int) c2.getNumericCellValue();					//Got the amount stored at position 4,1
				String l2 = Integer.toString(liability2); 							//Converting int to String
				ReviewerPOM.insertLiability2().clear();				//Clearing the text box.
				ReviewerPOM.insertLiability2().sendKeys(l2);		//Inserting amount in text box
				Thread.sleep(400);
			}
			
			if(ele3 != null)
			{
				Row row5 = sheet.getRow(5);											//Selected 5th index row (Sixth row)
				Cell c3 = row5.getCell(1);											//Selected cell (5 row,1 column)
				int liability3 = (int) c3.getNumericCellValue();					//Got the amount stored at position 5,1
				String l3 = Integer.toString(liability3); 							//Converting int to String
				ReviewerPOM.insertLiability3().clear();				//Clearing the text box.
				ReviewerPOM.insertLiability3().sendKeys(l3);		//Inserting amount in text box
				Thread.sleep(500);
			}
			js.executeScript("window.scrollBy(0,400)"," ");
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextArea()));
			Row row6 = sheet.getRow(6);											//Selected 6th index row (Seventh row)
			Cell c4 = row6.getCell(1);											//Selected cell (6 row,1 column)
			String remark = c4.getStringCellValue();							//Got the URL stored at position 6,1
			ReviewerPOM.insertTextArea().sendKeys(remark);		//Inserting remark in Text area
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickApprove()));
			ReviewerPOM.clickApprove().click();					//Clicking on Approve button.

			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();									//Accepting msg of Successful Submission.
			
			try {
				getDriver().switchTo().alert().accept();	
			}catch(Exception e) {
				
			}
			getDriver().switchTo().parentFrame();									//Switching back to parent frame from iFrame
			
			Thread.sleep(1000);
			performer.OverduePOM.clickDashboard().click();
			
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickStatutoryReview()));
			int newValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());	//Reading new value of Statutory Pending For Review
			int newCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickCompletedSta().getText());	//Reading old value of Internal Reject

			
				if(newValue < oldValue && newCountCompletedSta > OldCountCompletedSta)
				{
					//test.log(LogStatus.PASS, "Statutory value for 'Pending For Review' decreamented and Statutory value for 'Rejected' incremented.");
					test.log(LogStatus.PASS, "Old Statutory Pending Review Value = "+oldValue+ " | New Statutory Pending Review Value = "+ newValue+".");
					test.log(LogStatus.PASS, "Old Statutory Completed Value = "+OldCountCompletedSta+ " | New Statutory Completed Value = "+ newCountCompletedSta+".");
				}
			else
			{
			//	test.log(LogStatus.FAIL, "Statutory count of Pending For Review doesn't decremented.");
				test.log(LogStatus.FAIL, "Old statutory Pending Review Count = "+oldValue + " | New statutory Pending Review Count = "+ newValue);
			}
			Thread.sleep(1000);
			performer.OverduePOM.clickDashboard().click();
			
			extent.endTest(test);
			extent.flush();
		}
	
   @Test(priority = 3) //pass
	void ReviewCountStatutoryReject() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory 'Pending For Review' and 'Rejected' Count when Rejected");
		
		
		WebDriverWait wait = new WebDriverWait( getDriver() ,(30));
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickStatutoryReview()));	//Wait until Statutory Pending For Review count gets visible.
		int oldStatutoryReviewValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());	//Reading old value of Statutory Pending For Review
		int oldStatutoryRejectValue = Integer.parseInt(ReviewerPOM.readStatutoryReject().getText());	//Reading old value of Statutory Rejected
		ReviewerPOM.clickStatutoryReview().click();			//Clicking on Statutory Review value.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
		elementsList = ReviewerPOM.clickStatus();				//CLicking on Status to sort it in ascending order
		elementsList.get(0).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
		ReviewerPOM.clickAction1().click();					//Clicking on third action button.
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iReviewerFrame"));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
		try
		{
			Thread.sleep(500);
			ReviewerPOM.clickDownload1().click();					//Clicking on 'Click Here' label.
		}
		catch(Exception e)
		{
			
		}
		try
		{
			Thread.sleep(500);
			ReviewerPOM.clickDownload2().click();
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,300)"," ");					//Scrolling down window by 2000 px.
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimely()));
			ReviewerPOM.clickClosedTimely().click();				//Clicking on Closed-Delay radio button.
		}
		catch(Exception e)
		{
			
		}
		
		XSSFSheet sheet = ReadExcel();
		WebElement ele1 = null;
		WebElement ele2 = null;
		WebElement ele3 = null;
		try
		{
			Thread.sleep(600);
			//wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertLiability1()));
			ele1 = ReviewerPOM.insertLiability1();			//Loaded element in ele1. So that, if element not found it will do nothing.
			ele2 = ReviewerPOM.insertLiability2();			//Loaded element in ele2. So that, if element not found it will do nothing.
			ele3 = ReviewerPOM.insertLiability3();			//Loaded element in ele3. So that, if element not found it will do nothing.
		}
		catch(Exception e)
		{
			
		}
		if(ele1 != null)
		{
			js.executeScript("window.scrollBy(0,300)"," ");
			Row row3 = sheet.getRow(3);											//Selected 3rd index row (Fourth row)
			Cell c1 = row3.getCell(1);											//Selected cell (3 row,1 column)
			int liability1 = (int) c1.getNumericCellValue();					//Got the amount stored at position 3,1
			String l1 = Integer.toString(liability1); 							//Converting int to String
			ReviewerPOM.insertLiability1().clear();				//Clearing the text box.
			ReviewerPOM.insertLiability1().sendKeys(l1);		//Inserting amount in text box
			Thread.sleep(500);
		}
		
		if(ele2 != null)
		{
			Row row4 = sheet.getRow(4);										//Selected 4th index row (Fifth row)
			Cell c2 = row4.getCell(1);										//Selected cell (4 row,1 column)
			int liability2 = (int) c2.getNumericCellValue();				//Got the amount stored at position 4,1
			String l2 = Integer.toString(liability2); 						//Converting int to String
			ReviewerPOM.insertLiability2().clear();					//Clearing the text box.
			ReviewerPOM.insertLiability2().sendKeys(l2);				//Inserting amount in text box
			Thread.sleep(500);
		}
		
		if(ele3 != null)
		{
			Row row5 = sheet.getRow(5);										//Selected 5th index row (Sixth row)
			Cell c3 = row5.getCell(1);										//Selected cell (5 row,1 column)
			int liability3 = (int) c3.getNumericCellValue();				//Got the amount stored at position 5,1
			String l3 = Integer.toString(liability3); 						//Converting int to String
			ReviewerPOM.insertLiability3().clear();					//Clearing the text box.
			ReviewerPOM.insertLiability3().sendKeys(l3);				//Inserting amount in text box
			Thread.sleep(500);
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextArea()));
		Row row6 = sheet.getRow(6);											//Selected 6th index row (Seventh row)
		Cell c4 = row6.getCell(1);											//Selected cell (6 row,1 column)
		String remark = c4.getStringCellValue();							//Got the URL stored at position 6,1
		ReviewerPOM.insertTextArea().sendKeys(remark);				//Inserting remark in Text area
		
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickReject()));
		Actions action = new Actions(getDriver());
		action.moveToElement(ReviewerPOM.clickReject()).click().perform();
		//ReviewerPOM.clickReject().click();							//Clicking on Reject button.
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@value='Reject']")));
		
		Thread.sleep(300);
		getDriver().switchTo().parentFrame();									//Switching back to parent frame from iFrame
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(performer.OverduePOM.clickDashboard()));
		WebElement element = performer.OverduePOM.clickDashboard();
		action.moveToElement(element).click().perform();					//Clicking on dashboard,
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickStatutoryReview()));	//Wait until Statutory Pending For Review count gets visible.
		int newStatutoryReviewValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());	//Reading new value of Statutory Pending For Review
		int newStatutoryRejectValue = Integer.parseInt(ReviewerPOM.readStatutoryReject().getText());	//Reading new value of Statutory Rejected
		
		if(newStatutoryReviewValue < oldStatutoryReviewValue && newStatutoryRejectValue > oldStatutoryRejectValue)
		{
			test.log(LogStatus.PASS, "Statutory value for 'Pending For Review' decreamented and Statutory value for 'Rejected' incremented.");
			test.log(LogStatus.PASS, "Old Statutory Pending Review Value = "+oldStatutoryReviewValue+ " | New Statutory Pending Review Value = "+ newStatutoryReviewValue+".");
			test.log(LogStatus.PASS, "Old Statutory Reject Value = "+oldStatutoryRejectValue+ " | New Statutory Reject Value = "+ newStatutoryRejectValue+".");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated statutory values not reverted on Dashboard.");
		}
		extent.endTest(test);
		extent.flush();
	}
	
 // @Test(priority = 4) //pass   not present Script
    void ReviewCountStatutoryASA() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Review - Advanced Search -Count when Approved");
		
		ReMethodsPOM.PendingReviewStatutoryASApprove(test);
		extent.endTest(test);
		extent.flush();
	}
	 
//	@Test(priority = 5) //pass  not present Script
    void ReviewCountStatutoryASR() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Review -Advanced Search-Count when Rejected");
		
		ReMethodsPOM.PendingReviewStatutoryASReject(test);
		extent.endTest(test);
		extent.flush();
	}
	
	
    @Test(priority = 6)
	void PendingReviewInternalCri1() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Pending For Review Count and Completed when Approved Verification");
		
		
		ReMethodsPOM.PendingReviewInternalCri1( test,  "Approve");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)  
	void ReviewCountInternalReject() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal 'Pending For Review' and 'Rejected' - When Reject Verification");
	
		
		ReMethodsPOM.PendingReviewInternalCri1( test, "Reject");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 8) //pass not present Script
    void ReviewCountInternalASA() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Review -Advanced Search-Count when Approved");
		
		ReMethodsPOM.PendingReviewInternalASApprove(test);
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 9) //pass  not present Script
    void ReviewCountInternalASR() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Review -Advanced Search-Count when Rejected");
		
		ReMethodsPOM.PendingReviewInternalASReject(test);
		extent.endTest(test);
		extent.flush();
	}
	
    @Test(priority = 10)
    void CompletedStatutoryCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Completed ");
		
		ReMethodsPOM.CompletedStatutoryCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
    @Test(priority = 11)
    void CompletedInternalCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Completed ");
		
		
		ReMethodsPOM.CompletedInternalCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
   
  @Test(priority = 12) 
  void OverdueStatutoryCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue ");
		
		
		ReMethodsPOM.OverdueStatutoryCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
  @Test(priority =13) 
  void OverdueInternalCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue ");
		
		
		ReMethodsPOM.OverdueInternalCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
      
    @Test(priority = 14) //pass  non critical
    void RejectedStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Rejected Statutory - Export");
		
		
		ReMethodsPOM.RejectedStatutory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
   @Test(priority = 15) //pass
    void RejectedInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Rejected Internal - Export");
		
		
		ReMethodsPOM.RejectedInternal(test);
		
		extent.endTest(test);
		extent.flush();
	}
     
 /*@Test(priority = 16) //pass 
    void EventsCount() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Event Count Match");
		
		ReMethodsPOM.Events(test);
		
		extent.endTest(test);
		extent.flush();
	}
 
  @Test(priority = 17) //pass
    void ActivatedEventsCount() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Activated Events Count Match");
		
		
		ReMethodsPOM.ActivatedEvents(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
   @Test(priority = 18) //pass 
    void ClosedEventsCount() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Closed  Events Count Match");
		
		
		ReMethodsPOM.ClosedEvents(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
    
	@Test(priority = 0) // pass
	void MyReminderStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Statutory Count Verification");
		
		
		OverduePOM.MyReminder( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20) //pass
	void MyReminderInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Internal Count Verification");
		
		OverduePOM.MyReminder( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}*/
	
	
	@Test(priority = 21) //pass
	void InterimReview() throws InterruptedException, IOException
	{
		test = extent.startTest("Interim Review Count Verification");
		
		
		ReMethodsPOM.SubmittedInterimReview( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 22)
	void MyEscalation() throws InterruptedException, IOException
	{
		test = extent.startTest("My Escalation verification");
		
		
		ReMethodsPOM.MyEscalationReviewer( test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 23) //pass  //non critical
	void ReassignUser() throws InterruptedException, IOException
	{
		test = extent.startTest("Reassign User verification");
		
		
		ReMethodsPOM.ReassignPerformer( test);
		
		extent.endTest(test);
		extent.flush();
	}
	// --------- Reviewer Task  -----
     
  /*  @Test(priority = 11) //pass
  	void ReviewerTaskPFRStatutory  () throws InterruptedException, IOException
  	{
    	  test = extent.startTest("Statutory 'Pending For Review' - Reviewer Task");
  		test.log(LogStatus.INFO, "Test initiated");
  		WebDriverWait wait = new WebDriverWait( getDriver() (40));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		test.log(LogStatus.INFO, "***********Statutory 'Pending For Review'************ ");
		
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRStatutory()));
		
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress();
		ReviewerPOM.ClickReviewerTaskPFRStatutory().click();
		Thread.sleep(2000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskReviewer']")));	//Waiting for records table to get visible
	//	Thread.sleep(500);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
	int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
	OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
	//wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
	
	test.log(LogStatus.INFO, "------------- Statutory -------------");
	Thread.sleep(3000);
	OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
	Select drp = new Select(OverduePOM.clickActFilter());
	drp.selectByIndex(2);										//Selecting third Act
	
	Thread.sleep(4000);
//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
	OverduePOM.clickComplianceDropDown().click();			//Clicking on 'Compliance' drop down.
	drp = new Select(OverduePOM.clickComplianceDropDown());
	drp.selectByIndex(1);										
	Thread.sleep(3000);
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
Thread.sleep(3000);

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

.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
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
OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

Thread.sleep(1000);
OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
Thread.sleep(500);
String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
	
.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
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
Thread.sleep(1000);
test.log(LogStatus.PASS, "Test Passed.");
extent.endTest(test);
extent.flush();
  	}
      
   @Test(priority = 0) //pass
    	void ReviewerTaskPFRInternal  () throws InterruptedException, IOException
    	{
      	  test = extent.startTest("Internal 'Pending For Review' - Reviewer Task");
    		test.log(LogStatus.INFO, "Test initiated");
    		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
  		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
  		
  		test.log(LogStatus.INFO, "***********Internal 'Pending For Review'************ ");
  		
  		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
  		
  		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRInternal()));
  		
  	//	Thread.sleep(500);
  	//	litigationPerformer.MethodsPOM.progress();
  		ReviewerPOM.ClickReviewerTaskPFRInternal().click();
  		Thread.sleep(3000);
  	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskReviewer']")));	//Waiting for records table to get visible
  		//Thread.sleep(1000);
  		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
  		
  		int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
  	
  		OverduePOM.clickAddNew1().click();
  		Thread.sleep(2000);
  		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
	
			test.log(LogStatus.INFO, "------------- Internal -------------");
			Thread.sleep(2000);
			OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
			Thread.sleep(4000); 
			Select drp = new Select(OverduePOM.clickInternalCompliance());
			drp.selectByIndex(1);
			Thread.sleep(3000);
			
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
			Thread.sleep(2000);
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
			
			//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
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
			elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
			int no = elementsList1.size();

			Thread.sleep(1000);
			elementsList1.get(3).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
			Thread.sleep(5000);
			OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
			Thread.sleep(3000);
			 sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
				 row = 0;
				Thread.sleep(3000);
				Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
				Cell c11 = null;
				row01= sheet.getRow(10);
				c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
			OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title
			Thread.sleep(2000);
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
				
			.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
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
  	Thread.sleep(1000);
  	test.log(LogStatus.PASS, "Test Passed.");
  	extent.endTest(test);
  	extent.flush();
    	}
    	 @Test(priority = 13) //pass
    	  	void ReviewerTaskDBNSStatutory  () throws InterruptedException, IOException
    	  	{
    	    	  test = extent.startTest("Statutory 'Due But Not Submitted' - Reviewer Task");
    	  		test.log(LogStatus.INFO, "Test initiated");
    	  		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
    			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
    			
    			test.log(LogStatus.INFO, "***********Statutory 'Due But Not Submitted  '************ ");
    			
    			js.executeScript("window.scrollBy(0,200)");	//Scrolling down window by 2000 px.
    			
    			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ReviewerTaskDBNSStatutory()));
    			
    			//Thread.sleep(500);
    			//litigationPerformer.MethodsPOM.progress();
    			ReviewerPOM.ReviewerTaskDBNSStatutory().click();
    			Thread.sleep(2000);
    		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskReviewer']")));	//Waiting for records table to get visible
    		//	Thread.sleep(500);
    			OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
    			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
    				
    			int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
    			OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
    			//wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
    			
    			test.log(LogStatus.INFO, "------------- Statutory -------------");
    			Thread.sleep(3000);
    			OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
    			Select drp = new Select(OverduePOM.clickActFilter());
    			drp.selectByIndex(2);										//Selecting third Act
    			
    			Thread.sleep(4000);
//    			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
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
    			c1 = row0.getCell(2);						//Selected cell (0 row,2 column)	(2 column = third column)
    		OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title

    		row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
    		c1 = row0.getCell(2);							//Selected cell (1 row,2 column)
    		OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description

    		row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
    		c1 = row0.getCell(2);							//Selected cell (2 row,2 column)
    		int day = (int) c1.getNumericCellValue();
    		OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days

    		Select taskType=new Select(	OverduePOM.clickTaskType());
    		taskType.selectByIndex(1);
    		Thread.sleep(3000);

    		OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

    		js.executeScript("window.scrollBy(0,2000)");
    		row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
    		c1 = row0.getCell(2);							//Selected cell (3 row,2 column)
    		OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message

    		row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
    		c1 = row0.getCell(2);							//Selected cell (4 row,2 column)
    		OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box

    		row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
    		c1 = row0.getCell(2);							//Selected cell (5 row,2 column)
    		OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
    			
    		js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
    		Thread.sleep(1500);
    		
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

    		//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
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
    		OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

    		Thread.sleep(1000);
    		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
    		Thread.sleep(500);
    		String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

    		test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
    			
    		//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
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
    	  	Thread.sleep(1000);
    	  	test.log(LogStatus.PASS, "Test Passed.");
    	  	extent.endTest(test);
    	  	extent.flush();
    	  	}
    	  	
    //	  	@Test(priority = 14) //pass
        	void ReviewerTaskDBNSInternal  () throws InterruptedException, IOException
        	{
          	  test = extent.startTest("Internal 'Due But Not Submitted' - Reviewer Task");
        		test.log(LogStatus.INFO, "Test initiated");
        		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
      		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
      		
      		test.log(LogStatus.INFO, "***********Internal 'Due But Not Submitted'************ ");
      		
      		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
      		
      		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ReviewerTaskDBNSInternal()));
      		
      		//Thread.sleep(500);
      		//litigationPerformer.MethodsPOM.progress();
      		ReviewerPOM.ReviewerTaskDBNSInternal().click();
      		Thread.sleep(3000);
      		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskReviewer']")));	//Waiting for records table to get visible
      		//Thread.sleep(1000);
      		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
      		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
      		
      			int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
      			OverduePOM.clickAddNew1().click();
      			Thread.sleep(2000);
    			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
    	
    			test.log(LogStatus.INFO, "------------- Internal -------------");
    			Thread.sleep(2000);
    			OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
    			Thread.sleep(4000); 
    			Select drp = new Select(OverduePOM.clickInternalCompliance());
    			drp.selectByIndex(1);
    			Thread.sleep(3000);
    			
    		   		sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
    				int row = 0;
    				Thread.sleep(1000);
    				Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
    				Cell c1 = null;
    				row0= sheet.getRow(3);
    				c1 = row0.getCell(2);						//Selected cell (0 row,2 column)	(2 column = third column)
    				OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
    			
    			row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
    			c1 = row0.getCell(2);							//Selected cell (1 row,2 column)
    			OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
    			
    			row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
    			c1 = row0.getCell(2);							//Selected cell (2 row,2 column)
    			int day = (int) c1.getNumericCellValue();
    			OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
    			
    		  Select taskType=new Select(	OverduePOM.clickTaskType());
    		  taskType.selectByIndex(1);
    		  Thread.sleep(3000);

    			OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
    			Thread.sleep(2000);
    			js.executeScript("window.scrollBy(0,2000)");
    			row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
    			c1 = row0.getCell(2);							//Selected cell (3 row,2 column)
    			OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
    			
    			row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
    			c1 = row0.getCell(2);							//Selected cell (4 row,2 column)
    			OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
    			
    			row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
    			c1 = row0.getCell(2);							//Selected cell (5 row,2 column)
    			OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
    				
    			js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
    			Thread.sleep(1500);
    			
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
    			
    			//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
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
    			OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

    			Thread.sleep(1000);
    			OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
    			Thread.sleep(500);
    			String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

    			test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
    				
    			//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
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
        	  	Thread.sleep(1000);
        	  	test.log(LogStatus.PASS, "Test Passed.");
        	  	extent.endTest(test);
        	  	extent.flush();
        	}*/
        	
        	
        	 @Test(priority = 15) //pass
     	    void DueButNotSubmitted() throws InterruptedException, IOException
     		{
     			test = extent.startTest("Reviewer Task Summary - Statutory Due But Not Submitted Count Match");
     			
     			
     			MethodsPOM.DueButNotSubmitted(test);
     			
     			extent.endTest(test);
     			extent.flush();
     		}
     	 
     	 @Test(priority = 16) //pass
     	    void DueButNotSubmittedIn() throws InterruptedException, IOException
     		{
     			test = extent.startTest("Reviewer Task Summary - Internal Due But Not Submitted Count Match");
     			
     			
     			MethodsPOM.DueButNotSubmittedIn(test);
     			
     			extent.endTest(test);
     			extent.flush();
     		}
     	 
     	 @Test(priority = 17) //pass
 	    void PendingForReview() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Reviewer Task Summary - Statutory Pending For Review Count Match");
 			
 			
 			MethodsPOM.PendingForReview(test,"Statutory");
 			
 			extent.endTest(test);
 			extent.flush();
 		}
 	 
 	 @Test(priority = 18) //pass
 	    void PendingForReviewIn() throws InterruptedException, IOException
 		{
 			test = extent.startTest("Reviewer Task Summary - Internal Pending For Review Count Match");
 			
 			
 			MethodsPOM.PendingForReview(test,"Internal");
 			
 			extent.endTest(test);
 			extent.flush();
 		}
 	 
 	 @Test(priority = 19) //pass
	    void Rejectedtask() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Statutory Rejected Count Match");
			
			
			MethodsPOM.Rejectedtask(test,"Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 
	 @Test(priority = 20) //pass
	    void RejectedtaskIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Internal Rejected Count Match");
			
			
			MethodsPOM.Rejectedtask(test,"Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 
	 @Test(priority =21) 
		void Compliancecalendar() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check \" Calendar Report \" Downloaded Or not");
			
			ReMethodsPOM.CalendarDownload(test);
			
		extent.endTest(test);
		extent.flush();
		}
        	
        	
	 @Test(priority = 22) 
		void DetailedReport1() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report -Statutory Count Verification");
			
			
			ReMethodsPOM.DetailedReport1Cri(test,  "Statutory");

			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 23) 
		void DetailedReportIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report -Internal Count Verification");
			
			ReMethodsPOM.DetailedReport1Cri(test,  "Internal");
			
			extent.endTest(test);
			extent.flush();
		}

	
	@Test(priority = 24) 
	void DetailedReportFilterRe() throws InterruptedException, IOException
	{
		test = extent.startTest("To check  Detailed report filters working or not Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReportFilterper(test,  "Reviewer");
		
		extent.endTest(test);
		extent.flush();
	}
        	
        	@Test(priority = 25) //pass
        	void AssignmentReport() throws InterruptedException, IOException
        	{
        		test = extent.startTest("Assignment Report count verification");
        		
        		
        		CFOcountPOM.AssignmentReport(test );
        		
        		extent.endTest(test);
        		extent.flush();
        	}
	
	@Test(priority = 26)
	void AssignmentReportFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check 'Assignment Report ' Filter Working Or not");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.AssignmentReportFilterRevi(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27) //non Critical
	void ComplianceIDFilter1() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilter1(test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority =28)
	void ComplianceIDFilterEBDe() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterEBDe(test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 29)
	void ComplianceIDFilterINDe() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterINDe(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 30)
	void ComplianceIDFilter1Invalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilter1Invalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 31)
	void ComplianceIDFilterEBInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterEBInvalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 32)
	void ComplianceIDFilterINInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterINInvalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
//	@Test(priority = 34)		
		void WorkspaceSRFm() throws InterruptedException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
			
			Thread.sleep(3000);
			MethodsPOM.WorkspaceSRFm( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 35)		
		void SecondaryReDisplayFm() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace - 'Update Tasks' - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
			
			Thread.sleep(3000);
			MethodsPOM.SecondaryReDisplayFm( test);
		
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 36)		
			void SRWorkspaceSRFm() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - 'Update Tasks' - sub-task -  To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
				
				Thread.sleep(3000);
				MethodsPOM.SRWorkspaceSRFm( test);
			
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 37)		
			void SRWorkspaceSRDisFm() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - 'Update Tasks' - sub-task -  To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
				
				Thread.sleep(3000);
				MethodsPOM.SRWorkspaceSRDisFm( test);
			
				extent.endTest(test);
				extent.flush();
			}
			
			//@Test(priority = 38)		
			void WorkspaceSRFmIn() throws InterruptedException
			{
				test = extent.startTest("My Workspace - 'Update Tasks' - Internal - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
				
				Thread.sleep(3000);
				MethodsPOM.WorkspaceSRFmIn( test);
			
				extent.endTest(test);
				extent.flush();
			}
			
			//@Test(priority = 39)		
			void SecondaryReDisplayFmIn() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace - 'Update Tasks' -  Internal - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
				
				Thread.sleep(3000);
				MethodsPOM.SecondaryReDisplayFmIn( test);
			
				extent.endTest(test);
				extent.flush();
			}
			
			//@Test(priority = 40)		
					void SRWorkspaceSRFmIn() throws InterruptedException, IOException
					{
						test = extent.startTest("My Workspace - 'Update Tasks' - Internal - sub-task -  To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
						
						Thread.sleep(3000);
						MethodsPOM.SRWorkspaceSRFmIn( test);
					
						extent.endTest(test);
						extent.flush();
					}
					
        
        	 @Test(priority = 41) //pass 
             void TaskReport() throws InterruptedException
        			{
        				test = extent.startTest("Task Report Verification");
        				
        				
        				MethodsPOM.TaskReport(test);
        				
        				extent.endTest(test);
        				extent.flush();
        			}
             
        @Test(priority = 42) //Non Critical
         	void ComplianceRepository() throws InterruptedException, IOException
         	{
         		test = extent.startTest("Compliance Repository/Act Repository  verification");
         		
         		
         		MethodsPOM.complianceRepository(test);

         		extent.endTest(test);
         		extent.flush();
         	}
         	
   // @Test(priority = 43)
	void ActRepositoryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check 'Act Repository Page'  Filters Working or not");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.ActRepositoryFilterRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
       /*  	
         	 @Test(priority = 44) //pass 
  	       void EventReport() throws InterruptedException
  				{
  					test = extent.startTest("Event Report Verification");
  					
  					
  					MethodsPOM.EventReport(test);
  					
  					extent.endTest(test);
  					extent.flush();
  				}*/
        	
	@Test(priority = 45) 
	void ComplianceDocumentsSat() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents Statutory verification");
		
		MethodsPOM.complianceDocumentStaCri(test);
		
	extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 46) 
		void ComplianceDocumentsInter() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents Internal verification");
			
			
			MethodsPOM.complianceDocumentInCri(test);
			
		 extent.endTest(test);
		 extent.flush();
		 
		}
        		
        		@Test(priority = 47) //	pass	
        		void CriticalDocuments() throws InterruptedException, IOException
        		{
        			test = extent.startTest("Critical Document Verification");
        			
        			
        			OverduePOM.CriticalDocuments( test);
        			
        			extent.endTest(test);
        			extent.flush();
        		}
        		
        	/*	@Test(priority = 48) 
        		void Compliancecalendar() throws InterruptedException, IOException
        		{
        			test = extent.startTest("Compliance Documents Internal verification");
        			
        			
        		//	ReMethodsPOM.CalendarApprove(test,);
        			Thread.sleep(3000);
        		//	ReMethodsPOM.CalendarReject(test,);
        			ReMethodsPOM.CalendarDownload(test);
        		extent.endTest(test);
            	extent.flush();
        		}*/
        		
        		@Test(priority = 49)
        		void DailyUpdates() throws InterruptedException, IOException
        		{
        			Thread.sleep(3000);		
        			test = extent.startTest("'Daily Updates'  OverView");
        		
        			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        			//js.executeScript("window.scrollBy(0,4600)");					//Scrolling down window by 2600 px.
        			js.executeScript("window.scrollBy(0,900)");
        			Thread.sleep(500);	
        			if(ApprovalcountPOM.DailyUpdates().isDisplayed()) {
				test.log(LogStatus.PASS, "Daily Updates Displayed Successfully");
			}
        			CFOcountPOM.clickViewAllDU().click();
        			Thread.sleep(4000);	
        		//	WebDriverWait wait = new WebDriverWait( getDriver() Duration.ofSeconds(30));
        			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
        			CFOcountPOM.clickView1().click();
        			Thread.sleep(4000);	
        			CFOcountPOM.closeNewsView().click();
        			Thread.sleep(1000);
        			test.log(LogStatus.PASS, "view Successfully");
        			OverduePOM.searchBox().sendKeys("NSE issued the MFSS Settlement Calendar");
        			Thread.sleep(500);
        			OverduePOM.ClicksearchBtn().click();
        			Thread.sleep(7000);
        			test.log(LogStatus.PASS, "Search Successfully");
        			Thread.sleep(1000);
        			OverduePOM.ClickClearBtn().click();
        			Thread.sleep(8000);
        			test.log(LogStatus.PASS, "Clear button Working Successfully");
        		
        			performer.OverduePOM.clickDashboard().click();
        			
        			extent.endTest(test);
        			extent.flush();
        		}
        		
        		
        		@Test(priority = 50)
        		void NewsLetter() throws InterruptedException, IOException
        		{
        			Thread.sleep(500);		
        			test = extent.startTest("'News Letters'  OverView");
        			
        			Thread.sleep(3000);
      
        			
        			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        			js.executeScript("window.scrollBy(0,1500)");					//Scrolling down window by 2600 px.
        			Thread.sleep(4000);
        			if(ApprovalcountPOM.NewsLetter().isDisplayed())
        			{
        				test.log(LogStatus.PASS, "News Letter Displayed Successfully");
        			}
        			CFOcountPOM.clickViewAllNL().click();
        			Thread.sleep(4000);	
        		//	WebDriverWait wait = new WebDriverWait( getDriver() Duration.ofSeconds(30));
        			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
        			CFOcountPOM.clickView2().click();
        			Thread.sleep(4000);	
        			CFOcountPOM.closeNewsLView().click();
        			Thread.sleep(1000);
        			test.log(LogStatus.PASS, "OverView Successfully");
        			performer.OverduePOM.clickDashboard().click();
        			Thread.sleep(3000);
        			extent.endTest(test);
        			extent.flush();
        		}
        		
        		
        	//	@Test(priority = 51) // pass non critical
        		void MessageCenter() throws InterruptedException, IOException
        		{
        			test = extent.startTest(" Message Center - Verification");
        			
        			WebDriverWait wait = new WebDriverWait( getDriver() ,(30));
        			Thread.sleep(8000);
        			CFOcountPOM.clickMessageCenter().click();
        			Thread.sleep(4000);
        			CFOcountPOM.clickViewMsg().click();
        			Thread.sleep(4000);
        			test.log(LogStatus.PASS, "View Button is clickable");
        			Thread.sleep(1000);
        			performer.OverduePOM.clickDashboard().click();
        			extent.endTest(test);
        			extent.flush();
        		}
        		
        		//@Test(priority = 52) // pass
        		void MyNotifications() throws InterruptedException, IOException
        		{
        			test = extent.startTest("My Notifications - Verification");
        			
        			WebDriverWait wait = new WebDriverWait( getDriver() ,(30));
        			Thread.sleep(8000);
        			CFOcountPOM.clickMyNotifications().click();
        			Thread.sleep(4000);
        			CFOcountPOM.clickViewBtnNO().click();
        			Thread.sleep(4000);
        			CFOcountPOM.CloseViewNO().click();
        			Thread.sleep(4000);
        			test.log(LogStatus.PASS, "View Successfully");	
        			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_chkCompliances_0']")).click();
        			Thread.sleep(1000);
        			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_chkCompliances_1']")).click();
        			Thread.sleep(1000);
        			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        			js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2100 px.
        			Thread.sleep(2000);
        			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMarkasRead']")).click();
        			test.log(LogStatus.PASS, "Read Successfully");	
        			Thread.sleep(1000);
        			performer.OverduePOM.clickDashboard().click();
        			extent.endTest(test);
        			extent.flush();
        		}
        		
        		 @Test(priority =53 )
     			void InternalMsg() throws InterruptedException, IOException
     			{
     				Thread.sleep(500);		
     				test = extent.startTest("'Internal Msg  '  Verification");
     				
     					Thread.sleep(1000);
     				WebDriverWait wait = new WebDriverWait( getDriver(), (40));
     				Thread.sleep(500);
     				OverduePOM.ClickInternalMsg().click();
     				Thread.sleep(4000);
     				OverduePOM.ClickTo().sendKeys("mayuri@tlregtech.in");
     				Thread.sleep(500);
     				OverduePOM.ClickSub().sendKeys("Automation");
     				Thread.sleep(1000);
     				OverduePOM.TypeMsg().sendKeys("Automation testing");
     				Thread.sleep(1000);
     				OverduePOM.choosefile().sendKeys("E:\\Test Cases\\Act Sub_Industry Test Cases.xlsx");
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
     				test.log(LogStatus.PASS, "Internal Message working Succefully");
     				Thread.sleep(1000);
     				extent.endTest(test);
     				extent.flush();
     			}
     			
     			 @Test(priority = 54)
     				void SupportTicket() throws InterruptedException, IOException
     				{
     					Thread.sleep(3000);		
     					test = extent.startTest("'Support Ticket  '  Verification");
     					
     					
     					MethodsPOM.SupportTicket(test);
     					
     					extent.endTest(test);
     					extent.flush();
     				}	
     		 
	
	//@Test(priority = 55)
	void ComplianceDocumentsFilterRE() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check Compliance Document page All filters working or not");
	
		DeptCountPOM.ComplianceDocumentsFilterRE(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 56) //pass 
    void WhatsNew() throws InterruptedException, IOException
			{
				test = extent.startTest("' what's New ' Verification");
				
				
				MethodsPOM.WhatsNew(test);
				
				extent.endTest(test);
				extent.flush();
			}
    
  //  @Test(priority = 63)
	void EventsFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check \" Event Overdue \" Page All filter working or not.");
	
		ReMethodsPOM.EventsFilter(test,1664);
		
				extent.endTest(test);
				extent.flush();
	}
	
	//@Test(priority = 63)
	void MPFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the Mitigation plan Filter can be working or not while clicking on the count of Internal  overdue compliance on Reviewer Dashboard.");
	
		ReMethodsPOM.MPFilter(test,2,"internal");
		
				extent.endTest(test);
				extent.flush();
	}
    
//	@Test(priority = 64)
	void MPFilterSta() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the Mitigation plan Filter can be working or not while clicking on the count of Statutory  overdue compliance on Reviewer Dashboard.");
	
		ReMethodsPOM.MPFilter(test,2,"Statutory");
		
				extent.endTest(test);
				extent.flush();
	}
	
//	@Test(priority = 64)
	void MyEscalationFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check \"My Escalation \" page All Filter selection wise Working or not.");
	
		ReMethodsPOM.MyEscalationFilter(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
	//@Test(priority = 64)
	void MyReminderFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check \" My Reminder \" selection Wise Filter Working Or not.");
	
		ReMethodsPOM.MyReminderFilter(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
	//   @Test(priority = 57) //pass 
       void MyLeave() throws InterruptedException, IOException
			{
				test = extent.startTest(" My Leave  - temporary assignment -  add new - To check whether the compliance can be reassign to new users or not?");
				
				
				MethodsPOM.MyLeave(test);
				
				extent.endTest(test);
				extent.flush();
			}
       
  //     @Test(priority = 58) //pass 
       void MyLeaveIn() throws InterruptedException, IOException
			{
				test = extent.startTest(" My Leave  - temporary assignment -  add new - Internal -  To check whether the compliance can be reassign to new users or not?");
				
				
				MethodsPOM.MyLeaveIn(test);
				
				extent.endTest(test);
				extent.flush();
			}
       
  // @Test(priority = 13)
   	void DetailedReportAP() throws InterruptedException, IOException
   	{
   		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in details tab on the view icon of Detailed report?");
   		
   		
   		MgmtAMethod.DetailedReportAP(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
   	
  //	@Test(priority = 70) //pass
    void OverdueCountStatutoryMP() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		ReMethodsPOM.OverdueStatutoryMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
   	
	//@Test(priority = 71) //pass
    void OverdueStatutoryMpV() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		ReMethodsPOM.OverdueStatutoryMpV(test);
		
		extent.endTest(test);
		extent.flush();
	}
   	
	//@Test(priority = 72) //pass
    void OverdueInternalMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		ReMethodsPOM.OverdueInternalMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
   	
//	@Test(priority = 73) //pass
    void OverdueInternalMpV() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		ReMethodsPOM.OverdueInternalMpV(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
/*	@Test(priority = 28)
		void Reopening() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To check whether the new tab named \"My Reopening\" is seperately reflects or not on the dashboard in the main menu while the tab will be visible only for who have made the configuration.");
				
			DeptCountPOM.Reopening(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 29)
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
		
        		
        		@Test(priority = 74)
    			void OverdueDAR() throws InterruptedException, IOException
    			{
    				test = extent.startTest("Reviewer Summary - Overdue - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my workspace page?");
    					
    				ReMethodsPOM.OverdueDAR(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 75)
    			void DeviationApproverCol() throws InterruptedException, IOException
    			{
    				test = extent.startTest("My Workspace - compliance - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\"in grid and downloaded export report of My workspace ");
    					
    				MethodsPOM.DeviationApproverColRE(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 76)
    			void DeviationClosureStatuscol() throws InterruptedException, IOException
    			{
    				test = extent.startTest("My Workspace - compliance - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
    					
    				MethodsPOM.DeviationClosureStatuscolRE(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 77)
    			void ComplianceDocumentsDA() throws InterruptedException, IOException
    			{
    				test = extent.startTest("My Documents - Compliance Documents - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my document page?");
    					
    				MethodsPOM.ComplianceDocumentsDA(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 78)
    			void DeviationApproverColCD() throws InterruptedException, IOException
    			{
    				test = extent.startTest("My Documents - Compliance Documents - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\"in grid  of My document page?");
    					
    				MethodsPOM.DeviationApproverColCD(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 79)
    			void DeviationClosureStatuscolCD() throws InterruptedException, IOException
    			{
    				test = extent.startTest("My Documents - Compliance Documents - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
    					
    				MethodsPOM.DeviationClosureStatuscolCD(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 80)
    			void DetailedReportDA() throws InterruptedException, IOException
    			{
    				test = extent.startTest("my Report - Detailed  report - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my report page?");
    					
    				MethodsPOM.DetailedReportDA(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 81)
    			void CompletedStatutorySF() throws InterruptedException, IOException
    			{
    				test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Deatiled Report?");
    				
    				ReMethodsPOM.CompletedStatutorySF(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 82)
    			void DetailedReportSF() throws InterruptedException, IOException
    			{
    				test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Deatiled Report?");
    				
    				MethodsPOM.DetailedReportSF(test);
    				
    				extent.endTest(test);
    				extent.flush();
    			}
    			
    			@Test(priority = 83)
				void PerformReviewEmailCol() throws InterruptedException, IOException
				{
					test = extent.startTest("Detailed Report - Performer Email column and Reviewer Email column Visible on grid Verification. ");
						
					MethodsPOM.PerformReviewEmailCol(test);
					
					extent.endTest(test);
					extent.flush();
				}

    			@Test(priority = 84)
    			void ComplianceDocumentsSF() throws InterruptedException, IOException
    			{
    				test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Compliance Document?");
    				
    				MethodsPOM.ComplianceDocumentsSF(test);
    				
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
		      		       		      		
        	
	//@AfterTest
	void Closing() throws InterruptedException
	{
		
	}
	
}
