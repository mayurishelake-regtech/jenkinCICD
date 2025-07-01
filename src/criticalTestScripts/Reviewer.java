package criticalTestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import departmentHead.DeptCountPOM;
import login.BasePage;
import performer.MethodsPOM;
import performer.OverduePOM;
import reviewer.ReMethodsPOM;
import reviewer.ReviewerPOM;

public class Reviewer  extends BasePage {
	
	//public static Web  = null;		//Web instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	static String filePath ="D:\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx";
	public static String link = "mgmt1";
	
	/*
	public static XSSFSheet ReadExcel() throws IOException
	{
		
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(1);					//Retrieving second sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\ReviewerResults.html",true);
		test = extent.startTest("Logging In - Reviewer");
		test.log(LogStatus.PASS, "Logging id - snehal.patil12@tlregtech.in , Password - admin@123");
		
					
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,9,"Statutory");
		/*XSSFSheet sheet = ReadExcel();
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
		
		 = login.Login.UserLogin(uname,password,"PendingReview");		//Method of Login class to login user.
		*/
	}
	
	@Test(priority = 1)
    void CompletedStatutoryCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Completed ");
		
		ReMethodsPOM.CompletedStatutoryCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
    @Test(priority = 2)
    void CompletedInternalCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Completed ");
		
		
		ReMethodsPOM.CompletedInternalCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
    @Test(priority = 3) 
    void OverdueStatutoryCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Overdue ");
		
		
		ReMethodsPOM.OverdueStatutoryCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
    @Test(priority = 4) 
    void OverdueInternalCri() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Overdue ");
		
		
		ReMethodsPOM.OverdueInternalCri(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5) 
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
	//	wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextArea()));
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
	
 @Test(priority = 6) 
	void ReviewCountStatutoryReject() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory 'Pending For Review' and 'Rejected' Count when Rejected");
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickStatutoryReview()));	//Wait until Statutory Pending For Review count gets visible.
		int oldStatutoryReviewValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());	//Reading old value of Statutory Pending For Review
		int oldStatutoryRejectValue = Integer.parseInt(ReviewerPOM.readStatutoryReject().getText());	//Reading old value of Statutory Rejected
		ReviewerPOM.clickStatutoryReview().click();			//Clicking on Statutory Review value.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
	//	elementsList = ReviewerPOM.clickStatus();				//CLicking on Status to sort it in ascending order
	//	elementsList.get(0).click();
		
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
		
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(1);
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
		
	//	wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextArea()));
		Row row6 = sheet.getRow(6);											//Selected 6th index row (Seventh row)
		Cell c4 = row6.getCell(1);											//Selected cell (6 row,1 column)
		String remark = c4.getStringCellValue();							//Got the URL stored at position 6,1
		ReviewerPOM.insertTextArea().sendKeys(remark);				//Inserting remark in Text area
		
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickReject()));
		Actions action = new Actions(getDriver());
		action.moveToElement(ReviewerPOM.clickReject()).click().perform();
		//ReviewerPOM.clickReject().click();							//Clicking on Reject button.
		Thread.sleep(8000);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@value='Reject']")));
		try {
			getDriver().switchTo().alert().accept();	
		}catch(Exception e) {
			
		}
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
		//	test.log(LogStatus.PASS, "Statutory value for 'Pending For Review' decreamented and Statutory value for 'Rejected' incremented.");
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

	@Test(priority = 7)
	void PendingReviewInternalCri1() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Pending For Review Count and Completed when Approved Verification");
		
		
		ReMethodsPOM.PendingReviewInternalCri1( test,  "Approve");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)  
	void ReviewCountInternalReject() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal 'Pending For Review' and 'Rejected' - When Reject Verification");
	
		
		ReMethodsPOM.PendingReviewInternalCri1( test, "Reject");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
 @Test(priority = 9) //pass
    void DueButNotSubmitted() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Statutory Due But Not Submitted Count Match");
		
		
		MethodsPOM.DueButNotSubmitted(test);
		
		extent.endTest(test);
		extent.flush();
	}
 
 @Test(priority = 10) //pass
    void DueButNotSubmittedIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Internal Due But Not Submitted Count Match");
		
		
		MethodsPOM.DueButNotSubmittedIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
  @Test(priority = 11) //pass
    void PendingForReview() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Statutory Pending For Review Count and Completed when Approved");
		
		
		MethodsPOM.PendingForReview(test,"Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
 
 @Test(priority = 12) //pass
    void PendingForReviewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Internal Pending For Review Count and Completed when Approved");
		
		
		MethodsPOM.PendingForReviewInternalTask(test,"Internal");
		
		extent.endTest(test);
		extent.flush();
	}
 
 @Test(priority = 13) //pass
 void PendingForReviewTaskRejected() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Statutory Pending For Review Count and Rejected when Rejected");
		
		
		MethodsPOM.PendingForReviewTaskRejected(test,"Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 14) //pass
 void PendingForReviewTaskInRejected() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Internal Pending For Review Count and Rejected when Rejected");
		
		
		MethodsPOM.PendingForReviewTaskInRejected(test);
		
		extent.endTest(test);
		extent.flush();
	}
 
 @Test(priority = 13) //pass
    void Rejectedtask() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Statutory Rejected Count Match");
		
		
		MethodsPOM.Rejectedtask(test,"Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
 
 @Test(priority = 14) //pass
    void RejectedtaskIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Reviewer Task Summary - Internal Rejected Count Match");
		
		
		MethodsPOM.Rejectedtask(test,"Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15) 
	void Compliancecalendar() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check \" Calendar Report \" Downloaded Or not");
		
		ReMethodsPOM.CalendarDownload(test);
		
	extent.endTest(test);
	extent.flush();
	}
	
//	@Test(priority = 10) //not run
	void Compliancecalendar1() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check \" Calendar Report \" Downloaded Or not");
		
		
	ReMethodsPOM.CalendarApprove(test);
		Thread.sleep(3000);
	//	ReMethodsPOM.CalendarReject(test,);
		
	extent.endTest(test);
	extent.flush();
	}
	
	@Test(priority = 16) 
	void DetailedReport1() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Statutory Count Verification");
		
		
		ReMethodsPOM.DetailedReport1Cri(test,  "Statutory");

		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17) 
	void DetailedReportIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Internal Count Verification");
		
		ReMethodsPOM.DetailedReport1Cri(test,  "Internal");
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 18) 
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report count verification");
		
		
		CFOcountPOM.AssignmentReport(test );
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 19) 
	void SMETAReport() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - SMETA Report Verification");
		
		
		ReMethodsPOM.SMETAReport(test, "Statutory");

		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 20) 
	void SMETAReportFilterMgmt() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -  To Check Whether Smeta Report Grid all filter working or not ? ");
		
		
		DeptCountPOM.SMETAReportFilterMgmt(test);

		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 21) 
	void ComplianceDocumentsSat() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents Statutory verification");
		
		MethodsPOM.complianceDocumentStaCri(test);
		
	extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 22) 
		void ComplianceDocumentsInter() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents Internal verification");
			
			
			MethodsPOM.complianceDocumentInCri(test);
			
		 extent.endTest(test);
		 extent.flush();
		 
		}

	//@Test(priority = 23)
	void MyEscalation() throws InterruptedException, IOException
	{
		test = extent.startTest("My Escalation verification");
		
		
		ReMethodsPOM.MyEscalationReviewer( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		//getDriver().close();
  	}	       
  		       		      		


}