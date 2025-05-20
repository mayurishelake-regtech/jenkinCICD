package criticalTestScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import departmentHead.DeptCountPOM;
import login.BasePage;
import performer.MethodsPOM;
import performer.OverduePOM;
import reviewer.ReMethodsPOM;

public class Performer extends BasePage {
	
	
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
	
	public static String link = "mgmt1";
	
	/*public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(4);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\PerformerResults.html",true);
		test = extent.startTest("Loging In - Performer");
		test.log(LogStatus.PASS, "Logging id - deepali12@tlregtech.in , Password - admin@123");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,4,"Statutory");
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);		
		Thread.sleep(3000);
	
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		*/
	}
	
	public static void message( )
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
	
	@Test(priority = 1)
	void Upcoming_ComplianceStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Summary :- Statutory Upcoming Compliance Verification");
		
		Thread.sleep(3000);
		
		MethodsPOM.UpcomingComplianceCri( test, "Statutory",workbook);
		extent.endTest(test);
	extent.flush();
	}
	
	 @Test(priority = 2) 
		void Upcoming_ComplianceInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- Internal Upcoming Compliance Verification");
			
			
			MethodsPOM.UpcomingComplianceCri( test, "Internal",workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	
	 @Test(priority = 3) 
		void StatutoryOverdueCri() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- Dashboard Statutory Overdue Value Verification");
			
			
			MethodsPOM.StatutoryOverdueCri( test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	 @Test(priority = 4) 
		void InternalOverdueCri() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- Dashboard Internal Overdue Value Verification");
			
			
			MethodsPOM.InternalOverdueCri( test);
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 5) 
		void StatutoryChecklistAction() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- Statutory Checklist Count Through Action");
			
			
			MethodsPOM.StatutoryCheckListActionCri( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 6) 
		void StatutoryChecklistBox() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- To Check Perform Multiple statutory Checklist Compliance working or not ");
			
			
			MethodsPOM.StatutoryCheckListCheckboxCri( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 7)  
		void InternalCheckListAction() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- Internal Checklist Count Through Action");
			
			
			MethodsPOM.InternalCheckListActionCri( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority =8)  
		void InternalCheckListCheckBox() throws InterruptedException
		{
			test = extent.startTest("Performer Summary :- To Check Perform Multiple  Internal Checklist Compliance working or not");
			
			
			MethodsPOM.InternalCheckListCheckboxCri( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority =9) 
		void DashboardRejectStatutory() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- Statutory Rejected Compliance Count - Dashboard");
			
			
			MethodsPOM.DashboardRejectedCri( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 10)  
		void DashboardRejectInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Summary :- Internal Rejected Compliance Count - Dashboard");
			
					
			MethodsPOM.DashboardRejectedCri( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		
	   @Test(priority = 11) //pass
	    void ActivatedEventsPer() throws InterruptedException, IOException
		{
			test = extent.startTest("Event Owner Summary - Statutory Activated Events Count Match");
			
			
			ReMethodsPOM.ActivatedEventsPer(test);
			
			extent.endTest(test);
			extent.flush();
		}
	    
	   @Test(priority = 12) //pass 
	    void ClosedEventsPer() throws InterruptedException, IOException
		{
			test = extent.startTest(" Event Owner Summary - Statutory Closed  Events Count Match");
			
			
			ReMethodsPOM.ClosedEventsPer(test);
			
			extent.endTest(test);
			extent.flush();
		}
	    
	  @Test(priority = 13) //pass 
	    void AssignedEvents() throws InterruptedException, IOException
		{
			test = extent.startTest("Event Owner Summary - Statutory Assigned  Event Count Match");
			
			ReMethodsPOM.AssignedEvents(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
     @Test(priority = 14) //pass
    void PerformerTaskUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Statutory Upcoming Count Match");
		
		
		//MethodsPOM.PerformerTaskUpcoming(test,"Statutory");
		MethodsPOM.PerformUpcomingStatutory(test);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15) //pass
    void PerformerTaskUpcomingIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Internal Upcoming Count Match");
		
		
		MethodsPOM.PerformerTaskUpcoming(test,"Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	

    @Test(priority = 16) //pass
   void PerformerTaskOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Statutory Overdue Count Match");
		
		
		MethodsPOM.PerformerTaskOverdue(test,"Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17) //pass
   void PerformerTaskOverdueIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performer Task Summary - Internal Overdue Count Match");
		
		
		MethodsPOM.PerformerTaskOverdueInternal(test,"Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	 @Test(priority = 18) //pass
	   void PerformerTaskRejected() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Statutory Rejected Count Match");
			
			
			MethodsPOM.PerformerTaskRejected(test,"Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 19) //pass
	   void PerformerTaskRejectedIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Internal Rejected Count Match");
			
			
			MethodsPOM.PerformerTaskRejectedInternal(test,"Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	
	 @Test(priority = 20) 
	   void PerformerTaskPFR() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Statutory Pending For Review Count Match");
			
			
			MethodsPOM.PerformerTaskPFR(test,"Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 21) //pass
	   void PerformerTaskPFRIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performer Task Summary - Internal Pending For Review Count Match");
			
			
			MethodsPOM.PerformerTaskPFR(test,"Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	// @Test(priority = 22) //pass
	    void DueButNotSubmitted() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Statutory Due But Not Submitted Count Match");
			
			
			MethodsPOM.DueButNotSubmitted(test);
			
			extent.endTest(test);
			extent.flush();
		}
	 
	// @Test(priority = 23) //pass
	    void DueButNotSubmittedIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Internal Due But Not Submitted Count Match");
			
			
			MethodsPOM.DueButNotSubmittedIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
	    
	//  @Test(priority = 24) //pass
	    void PendingForReview() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Statutory Pending For Review Count Match");
			
			
			MethodsPOM.PendingForReview(test,"Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 
	// @Test(priority = 25) //pass
	    void PendingForReviewIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Internal Pending For Review Count Match");
			
			
			MethodsPOM.PendingForReview(test,"Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 
//	 //@Test(priority = 26) //pass
	    void Rejectedtask() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Statutory Rejected Count Match");
			
			
			MethodsPOM.Rejectedtask(test,"Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 
//	// @Test(priority = 27) //pass
	    void RejectedtaskIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Reviewer Task Summary - Internal Rejected Count Match");
			
			
			MethodsPOM.Rejectedtask(test,"Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	
	
    	//@Test(priority = 28) 
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
					
					
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iPerformerFrame"));
					
					//ContentPlaceHolder1_iPerformerFrame
					js.executeScript("window.scrollBy(0,500)");                	
				
					Thread.sleep(500);
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
					Thread.sleep(3000);
					OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
										//Clicking on 'Add Link' button of Compliance Documents
					Thread.sleep(2000);
					Thread.sleep(1000);
					js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
					try {
					Select status = new Select(OverduePOM.selectDropdown());	//Selecting dropdown box
					int k = status.getOptions().size();
					System.out.println("Options = "+ k);
					if(k > 1)
					{
						status.selectByIndex(1);
					}
					Thread.sleep(500);
					OverduePOM.selectDateStatutory().click();				//Clicking on Date input box
					OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
					Thread.sleep(500);
					OverduePOM.selectDate2().click();						//Clicking on date
					
					}catch(Exception e) {
						
					}
					
					Thread.sleep(2000);
					OverduePOM.remark().sendKeys("Automation");
					Thread.sleep(1000);
					getDriver().findElement(By.xpath("//*[@id='btnSave']")).click();
					Thread.sleep(1000);
					getDriver().switchTo().alert().accept();	
					//MethodsPOM.MyCalendarCompliance( test);
					getDriver().switchTo().parentFrame();
					getDriver().switchTo().parentFrame();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "user able to perform compliance from calendar Successfully.");
					OverduePOM.clickDashboard().click();
					extent.endTest(test);
					extent.flush();
					
					
				}
	       
	       
	       
	   @Test(priority = 28) 
	   	void Compliancecalendar() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("To Check \" Calendar Report \" Downloaded Or not");
	   		
	   		ReMethodsPOM.CalendarDownload(test);
	   		
	   	extent.endTest(test);
	   	extent.flush(); 
	   	}
	   	
		//@Test(priority = 29) 
    void ComplianceSatCalender1() throws InterruptedException, AWTException
			{
				test = extent.startTest(" Calender Statutory Count Verification");
				
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait( getDriver(),(30));
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
//				Thread.sleep(8000);
//				 Robot robot = new Robot();
//				  robot.keyPress(KeyEvent.VK_CONTROL);
				//   robot.keyPress(KeyEvent.VK_SUBTRACT);
				//   robot.keyRelease(KeyEvent.VK_SUBTRACT);
				//   robot.keyRelease(KeyEvent.VK_CONTROL);
				

				
				try {
			           

		            // Set zoom level to 50% (0.5) for zooming out
		            setZoomLevel(getDriver(), 0.9);

		            // Wait to observe the effect
		            Thread.sleep(2000);

		            // Set zoom level back to 100% (1.0) to reset to normal
		          //  setZoomLevel(getDriver(), 1.0);

		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
				
				Thread.sleep(8000);
				String string_Compliances =OverduePOM.CalendarCount().getText();		//Storing old value of Statutory overdue.
				int	CalendarCount = Integer.parseInt(string_Compliances);
				OverduePOM.CalendarCount1().click();
				Thread.sleep(3000);
			
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
				Thread.sleep(3000);
				
				
				String s1 = CFOcountPOM.readUsersCount1().getText();		//Reading total number of items.
				String[] bits = s1.split(" ");									//Splitting the String
				String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
				
				int count = 0;
				if(itomsCount.equalsIgnoreCase("to"))							//If not items found
				{
					Thread.sleep(2500);
					s1 = CFOcountPOM.readTotalItems().getText();
					bits = s1.split(" ");										//Splitting the String
					itomsCount = bits[bits.length - 2];
				}
				if(itomsCount.equalsIgnoreCase("to"))							//If not items found
				{
					count = 0;
				}
				else
				{
					count = Integer.parseInt(itomsCount);
				}
				
				if(count == CalendarCount)
				{
				//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
					test.log(LogStatus.PASS, "calendar count ="+CalendarCount+" | Calendar grid  "+count);
				}
				else
				{
				//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
					test.log(LogStatus.FAIL, "calendar count ="+CalendarCount+" | Calendar grid count :- "+count);				}
			
				getDriver().switchTo().parentFrame();
				Thread.sleep(1000);
				getDriver().findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
			
			
				OverduePOM.clickDashboard().click();
				extent.endTest(test);
				extent.flush();
			}
		
	@Test(priority = 29) 
	void DetailedReport1() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Statutory Count Verification");
		
		
		ReMethodsPOM.DetailedReport1CriPer(test, "Statutory");

		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30) 
	void DetailedReportIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Internal Count Verification");
		
		ReMethodsPOM.DetailedReport1CriPer(test,  "Internal");
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 31) 
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report count verification");
		
		
		CFOcountPOM.AssignmentReport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32) 
	void SMETAReport() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -  SMETA Report Verification");
		
		
		ReMethodsPOM.SMETAReport(test, "Statutory");

		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 33) 
	void SMETAReportFilterMgmt() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -  To Check Whether Smeta Report Grid all filter working or not ? ");
		
		
		DeptCountPOM.SMETAReportFilterMgmt(test);

		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 34) 
	void ComplianceDocumentsSat() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents Statutory verification");
		
		MethodsPOM.complianceDocumentStaCri(test);
		
	extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 35) 
		void ComplianceDocumentsInter() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents Internal verification");
			
			
			MethodsPOM.complianceDocumentInCri(test);
			
		 extent.endTest(test);
		 extent.flush();
		 
		}
	
	

	public static void setZoomLevel(WebDriver driver, double zoomLevel) 
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
    }
	
		@AfterMethod
      	void browserClosing() throws InterruptedException
      	{
			closeBrowser();
			//Thread.sleep(1000);
      	//	getDriver().close();
      	}	       
      		       		
      	@AfterTest
      	void Closing() throws InterruptedException
      	{
      		
      	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	

}
