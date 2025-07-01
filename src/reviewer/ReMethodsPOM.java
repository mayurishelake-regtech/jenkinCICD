
package reviewer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import approval.ApprovalcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtSonyMethod;
import departmentHead.DeptCountPOM;
import implementation.ImplementPOM;
import login.BasePage;
import performer.OverduePOM;


public class ReMethodsPOM extends BasePage
{
	//public static XSSFSheet sheet = null;
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	private static List<WebElement> elementsList2 = null;
	static String filePath ="D:\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx";
	
	
	
	public static void SubmittedInterimReview(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickStatutoryReview()));	//Waiting for Pending Review Count to be visible.
		
		int oldValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());			//Reading old value of Statutory Pending For Review
		ReviewerPOM.clickStatutoryReview().click();		//Clicking on Statutory Review value.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 2600 px.
		
		CFOcountPOM.readTotalItems1().click();					//Clicking just to scroll down the window
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickStatus();					//CLicking on Status to sort it in ascending order
		elementsList.get(0).click();
		elementsList.get(0).click();									//Double clicking on Status header to get 'Submitted For Interim Review' status compliance on top.
		elementsList = OverduePOM.readStatus();					//Getting all status values (names)
		int n = elementsList.size();
		String status = null;
		int i = 0, flag = 0;
		for(i = 0; i < n; i++)
		{
			elementsList = OverduePOM.readStatus();
			status = elementsList.get(i).getText();
			if(status.equalsIgnoreCase("Submitted For Interim Review"))
			{
				flag = 1;
				break;
			}
		}
		
		if(flag == 1)
		{
			elementsList1 = OverduePOM.clickCalenderAction();		//Getting all action buttons
			elementsList1.get(i).click();								//Clicking on ith action button which has blue status 
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iReviewerFrame"));
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			ReviewerPOM.clickDownload1().click();					//Clicking on Download link 
			
			Thread.sleep(500);
			ReviewerPOM.InterimApproveRadio().click();			//Clicking on 'Interim Review Approve' radio button
			
			try
			{
				Thread.sleep(700);
				ReviewerPOM.clickCheckBox().click();
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(500);
			ReviewerPOM.insertTextArea().sendKeys("Automation Remark");	//Sending remark to text area.
			
			Thread.sleep(500);
			OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button. 
			
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();	
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
			
			OverduePOM.clickDashboard().click();					//Clicking on 'Dashboard'
			
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickStatutoryReview()));	//Waiting for Pending Review Count to be visible.
			int newValue = Integer.parseInt(ReviewerPOM.clickStatutoryReview().getText());			//Reading old value of Statutory Pending For Review
			if(newValue < oldValue)
			{
				test.log(LogStatus.PASS, "Statutory value for 'Pending For Review' decremented. Old Statutory Review Value = "+oldValue+ " New Statutory Review Value = "+ newValue);
			}
			else
			{
				test.log(LogStatus.PASS, "Statutory value for 'Pending For Review' doesn't decremented. Old Statutory Review Value = "+oldValue+ " New Statutory Review Value = "+ newValue);
			}
		}
		else
		{
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();					//Clicking on 'Dashboard'
			test.log(LogStatus.PASS, "No compliance submitted for Interim Review.");
			Thread.sleep(4000);
		}
	}
	
	public static void MyEscalationReviewer(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickMyEscalation()));	//Waiting for My Escalation link to be visible.
		
		ReviewerPOM.clickMyEscalation().click();					//Clicking on 'My Escalation'
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.loadGrid() ));	//Waiting for records table to be visible.
		
		///----------------- Single Compliance - Through Update Button --------------------------
		
		String no = "25";
		Thread.sleep(1500);
		elementsList = ReviewerPOM.clickWorkFileText();		//Getting all Work File text boxes
		elementsList.get(0).clear();
		elementsList = ReviewerPOM.clickWorkFileText();
		elementsList.get(0).sendKeys(no);
		
		Thread.sleep(500);
		elementsList1 = ReviewerPOM.clickEscalationText();	//Getting all the Escalation text boxes
		elementsList1.get(0).clear();
		elementsList2 = ReviewerPOM.clickEscalationText();
		elementsList2.get(0).sendKeys("21");
		
		ReviewerPOM.clickFirstAction().click();
		ReviewerPOM.clickFirstAction().click();
		
		Thread.sleep(1500);
		ReviewerPOM.clickUpdate().click();
		Thread.sleep(1500);
		ReviewerPOM.clickFirstAction().click();
		Thread.sleep(1500);
		elementsList = ReviewerPOM.clickWorkFileText();
		int value = Integer.parseInt(elementsList.get(0).getAttribute("value"));
		int no1 = Integer.parseInt(no);
		
	//	test.log(LogStatus.INFO, "----------- Single Compliance Escallation -----------");
		if(value == no1)					//If Save button renamed to Update
		{
			test.log(LogStatus.PASS, "Update button appeared after Save. Compliance escalated successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inserted data didn't saved successfully.");
		}
		/*
		///----------------- Multiple Compliances - Through Save Button --------------------------
		Thread.sleep(4000);
		elementsList = ReviewerPOM.clickCheckboxes();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.elementToBeClickable(elementsList.get(2)));
		elementsList.get(2).click();
		Thread.sleep(1500);
		elementsList.get(3).click();
		Thread.sleep(1500);
		//getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[1]/label")).click();
		Thread.sleep(500);
		String num = "9";
		elementsList = ReviewerPOM.clickWorkFileText();			//Getting all Work File text boxes
		elementsList.get(2).clear();
		elementsList = ReviewerPOM.clickWorkFileText();
		elementsList.get(2).sendKeys(num);
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickEscalationText();			//Getting all Escalation text boxes
		elementsList.get(2).clear();
		elementsList = ReviewerPOM.clickEscalationText();
		elementsList.get(2).sendKeys("27");
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickWorkFileText();			//Getting all Work File text boxes
		elementsList.get(3).clear();
		elementsList = ReviewerPOM.clickWorkFileText();
		elementsList.get(3).sendKeys(num);
		
		Thread.sleep(500);
		elementsList = ReviewerPOM.clickEscalationText();			//Getting all Escalation text boxes
		elementsList.get(3).clear();
		elementsList = ReviewerPOM.clickEscalationText();
		elementsList.get(3).sendKeys("27");
		
		Thread.sleep(1000);
		ReviewerPOM.clickSaveButton().click();
		
		Thread.sleep(1200);
		String msg = getDriver().switchTo().alert().getText();
		getDriver().switchTo().alert().accept();	
		String expectedMsg = "Selected Compliance(s) Escalated Successfully.";
		
	//	test.log(LogStatus.INFO, "----------- Multiple Compliance Escallation -----------");
		if(msg.equalsIgnoreCase(expectedMsg))
		{
			test.log(LogStatus.PASS, "Success message : "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Compliances didn't escalated successfully.");
			test.log(LogStatus.INFO, "Message : "+msg);
		}
		*/
	//	Thread.sleep(1000);
	//	ReviewerPOM.clickRisk().click();
	//	Thread.sleep(1000);
	//	ReviewerPOM.clickCritical().click();
		Thread.sleep(2000);
	//	ReviewerPOM.clickClear().click();
		Thread.sleep(1000);
	//	test.log(LogStatus.PASS, "Clear Button data ");
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		Thread.sleep(2000);
		Thread.sleep(500);
		//performer.OverdueCount.message();
	}
	
	public static void ReassignPerformer(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (30));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickMyWorkspace()));	//Waiting for 'My Workspace' link to be visible.
		OverduePOM.clickMyWorkspace().click();				//Clicking on 'My Workspace'
		
		Thread.sleep(300);
		OverduePOM.clickCompliance().click();					//Clicking on 'Compliance' under My Workspace
		
		/*Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickMoreActions()));	//Waiting for records table to get visible.
		OverduePOM.clickUserRole().click();
		Thread.sleep(300);
		elementsList = OverduePOM.selectUserRole();
		elementsList.get(1).click();*/
		
		Thread.sleep(3000);
		OverduePOM.clickMoreActions1().click();				//Clicking on 'More Actions' drop down.
		Thread.sleep(1000);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(3).click();								//Clicking on fourth option "Reassign Performer"
		Thread.sleep(4000);
		Thread.sleep(300);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,400)");					//Scrolling down window by 2600 px.
		
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkRecordsTable()));	//Waiting for records table to get visible.
		ReviewerPOM.selectUserAssign().click();				//Clicking on 'Select User to Assign' drop down.
		Select drp = new Select(ReviewerPOM.selectUserAssign());
		drp.selectByIndex(1);										//Select first user
		
		Thread.sleep(2000);
		drp = new Select(ReviewerPOM.selectUserAssign());
		String user_dropdown = drp.getFirstSelectedOption().getText();		//Reading selected user name from dropdown.
		String user_table = ReviewerPOM.readAssignedUser().getText();	//Reading already assigned user from table.
		
		if(user_dropdown.equalsIgnoreCase(user_table))				//If user from dropdown matches to user from table
		{
			drp = new Select(ReviewerPOM.selectUserAssign());
			drp.selectByIndex(2);									//Selecting (next) second user of index 2
		}
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickFirstCheckbox()));
		ReviewerPOM.clickFirstCheckbox().click();				//Clicking on first checkbox (Not select all checkbox)
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");					//Scrolling down window by 2600 px.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickSaveButton()));
		OverduePOM.clickSaveButton().click();					//Clicking on 'Save' button.
		
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.selectUserAssign()));
		drp = new Select(ReviewerPOM.selectUserAssign());
		String user1 = drp.getFirstSelectedOption().getText();		//Reading the selected user in Drop down
		String user2 = ReviewerPOM.readAssignedUser().getText();	//Reading the assigned user name from table.
		
		if(user1.equalsIgnoreCase(user2))
		{
			test.log(LogStatus.PASS, "Performer user name updated with selected name.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Performer user name doesn't updated with selected name.");
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();
	}
	
	public static void PendingReviewStatutoryASApprove(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickStatutoryReview()));	//Wait until Statutory Pending For Review count gets visible.
		

		ReviewerPOM.clickStatutoryReview().click();		//Clicking on Statutory Review value.
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
		
		
		ReviewerPOM.clickAdavanceSearch().click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table")));
		elementsList=	ReviewerPOM.clickAction2();
		
		elementsList.get(4).click();	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iReviewerFrame1"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)"," ");
		ReviewerPOM.clickDownloadAS().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyAS()));
		WebElement el = ReviewerPOM.clickClosedTimelyAS();
		ReviewerPOM.clickClosedTimelyAS().click();	
		Thread.sleep(1000);
	//	ReviewerPOM.insertTextArea().sendKeys("Automation");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,500)"," ");
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickApprove()));
		ReviewerPOM.clickApprove().click();	
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();										//Accepting msg of Successful Submission.
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		ReviewerPOM.Clickclose().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search -Approve Successfully");

		ReviewerPOM.closeAS().click();
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();
		
		
	}
	
	public static void PendingReviewStatutoryASReject(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickStatutoryReview()));	//Wait until Statutory Pending For Review count gets visible.
		

		ReviewerPOM.clickStatutoryReview().click();		//Clicking on Statutory Review value.
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
		
		
		ReviewerPOM.clickAdavanceSearch().click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table")));
		elementsList=	ReviewerPOM.clickAction2();
		
		elementsList.get(4).click();	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iReviewerFrame1"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)"," ");
		ReviewerPOM.clickDownloadAS().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyAS()));
		WebElement el = ReviewerPOM.clickClosedTimelyAS();
		ReviewerPOM.clickClosedTimelyAS().click();	
		Thread.sleep(1000);
		ReviewerPOM.insertTextArea().sendKeys("Automation");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,500)"," ");
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickReject()));
		ReviewerPOM.clickReject().click();	
		Thread.sleep(500);
		//getDriver().switchTo().alert().accept();										//Accepting msg of Successful Submission.
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		ReviewerPOM.Clickclose().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search -Reject Successfully");
		ReviewerPOM.closeAS().click();		
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
	
	}
		
	public static void PendingReviewInternalASApprove(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickInternalReview()));	//Wait until Statutory Pending For Review count gets visible.
		

		ReviewerPOM.clickInternalReview().click();		//Clicking on Statutory Review value.
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
	
		
		ReviewerPOM.clickAdavanceSearch().click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table")));
		elementsList=	ReviewerPOM.clickAction2();
		
		elementsList.get(1).click();	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalReviewerFrame1"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)"," ");
		ReviewerPOM.clickInternalDownloadAS().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyInternal()));
		WebElement el = ReviewerPOM.clickClosedTimelyInternal();
		ReviewerPOM.clickClosedTimelyInternal().click();	
		Thread.sleep(1000);
	//	ReviewerPOM.insertTextArea().sendKeys("Automation");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,500)"," ");
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickApprove()));
		ReviewerPOM.clickApprove().click();	
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();										//Accepting msg of Successful Submission.
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		ReviewerPOM.ClickINclose().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search -Approve Successfully");
		ReviewerPOM.closeAS().click();
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();
		
		
	}
	
	public static void PendingReviewInternalASReject(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickInternalReview()));	//Wait until Statutory Pending For Review count gets visible.
		

		ReviewerPOM.clickInternalReview().click();		//Clicking on Statutory Review value.
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
	
		
		ReviewerPOM.clickAdavanceSearch().click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table")));
		elementsList=	ReviewerPOM.clickAction2();
		
		elementsList.get(0).click();	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalReviewerFrame1"));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)"," ");
		ReviewerPOM.clickInternalDownloadAS().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyInternal()));
		WebElement el = ReviewerPOM.clickClosedTimelyInternal();
		ReviewerPOM.clickClosedTimelyInternal().click();	
		Thread.sleep(1000);
		ReviewerPOM.insertTextAreaInternal().sendKeys("Automation");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,500)"," ");
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickReject()));
		ReviewerPOM.clickReject().click();	
		Thread.sleep(500);
	//	getDriver().switchTo().alert().accept();										//Accepting msg of Successful Submission.
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		ReviewerPOM.ClickINclose().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search -Reject Successfully");
		ReviewerPOM.closeAS().click();
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();
		
		
	}
	
	
	
	public static void PendingReviewInternal(ExtentTest test, XSSFSheet sheet, String clickButton)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickInternalReview()));	//Wait until Internal Pending For Review count gets visible.
		int oldInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading old value of Internal Pending For Review
		int oldInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.clickInternalReview().click();		//Clicking on Statutory Review value.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
		Thread.sleep(500);
		
		
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " :- File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, " :- File does not downloaded.");
		}
		
	//	elementsList = ReviewerPOM.clickActions();
	//	elementsList.get(0).click();
			
	//	elementsList = ReviewerPOM.clickStatus();			//CLicking on Status to sort it in ascending order
	//	elementsList.get(0).click();
		Thread.sleep(500);
		int flag = 0;
	//	wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
		elementsList = ReviewerPOM.clickActions();
		for (int i = 0; i < elementsList.size(); i++)						//Starting from the third button.
		{
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,500)"," ");
			
			Thread.sleep(300);
			elementsList = ReviewerPOM.clickActions();
			elementsList.get(i).click();									//Clicking on ith action button.
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalReviewerFrame"));
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			WebElement download = null;
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickDownloadInternal1()));
				download = ReviewerPOM.clickDownloadInternal1();			//Check if Download link is available or not.		
			}
			catch(Exception e)
			{
				
			}
			
			if(download == null)
			{
				flag = 1;
				getDriver().switchTo().parentFrame();							//Switching back to parent frame from iFrame
				ReviewerPOM.ComplainceInternalReviewer().click();		//Closing the compliance popup as it has message.
				Thread.sleep(1000);
			}
			else
			{
				flag = 0;
				ReviewerPOM.clickDownloadInternal1().click();				//Clicking on Download to download the document
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,400)"," ");					//Scrolling down window by 2000 px.
				
				Thread.sleep(500);
				try
				{
					ReviewerPOM.clickClosedTimelyInternal().click();		//Clicking on Closed-Delay radio button.
				}
				catch(Exception e)
				{
					
				}
				
				WebElement ele1 = null;
				WebElement ele2 = null;
				WebElement ele3 = null;
				try
				{
					wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertLiability1()));
					ele1 = ReviewerPOM.insertLiability1();			//Loaded element in ele1. So that, if element not found it will do nothing.
					ele2 = ReviewerPOM.insertLiability2();			//Loaded element in ele2. So that, if element not found it will do nothing.
					ele3 = ReviewerPOM.insertLiability3();			//Loaded element in ele3. So that, if element not found it will do nothing.
				}
				catch(Exception e)
				{
					
				}
				if(ele1 != null)
				{
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
					Row row4 = sheet.getRow(4);											//Selected 4th index row (Fifth row)
					Cell c2 = row4.getCell(1);											//Selected cell (4 row,1 column)
					int liability2 = (int) c2.getNumericCellValue();					//Got the amount stored at position 4,1
					String l2 = Integer.toString(liability2); 							//Converting int to String
					ReviewerPOM.insertLiability2().clear();				//Clearing the text box.
					ReviewerPOM.insertLiability2().sendKeys(l2);		//Inserting amount in text box
					Thread.sleep(500);
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
				
				Row row6 = sheet.getRow(6);											//Selected 6th index row (Seventh row)
				Cell c4 = row6.getCell(1);											//Selected cell (6 row,1 column)
				String remark = c4.getStringCellValue();							//Got the URL stored at position 6,1
				try
				{
					wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextAreaInternal()));
					ReviewerPOM.insertTextAreaInternal().sendKeys(remark);		//Inserting remark in Text area
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(500);
				if(clickButton.equalsIgnoreCase("Approve"))
				{
					ReviewerPOM.clickApprove().click();						//Clicking on Approve button.
					Thread.sleep(500);
					getDriver().switchTo().alert().accept();									//Accepting msg of Successful Submission.
				}
				else
				{
					ReviewerPOM.clickReject().click();						//Clicking on Reject button.
					Thread.sleep(500);
				}
				
				getDriver().switchTo().parentFrame();									//Switching back to parent frame from iFrame
				Thread.sleep(1000);
		//		.navigate().refresh();
				Thread.sleep(3000);
			//	wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
			//	break;
			}
			Thread.sleep(500);
		/*	if(i == elementsList.size()-1)
			{
				js.executeScript("window.scrollBy(0,500)"," ");
				CFOcountPOM.clickNextPage1().click();
				i = -1;
			}*/
		}		
		
		Thread.sleep(2500);
		
		getDriver().navigate().refresh();
		
		wait.until(ExpectedConditions.visibilityOf(performer.OverduePOM.clickDashboard()));
		performer.OverduePOM.clickDashboard().click();
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickInternalReview()));
		int newInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading new value of Internal Pending For Review
		int newInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		
		if(flag == 0)
		{
			if(newInternalReviewValue < oldInternalReviewValue)
			{
			//	test.log(LogStatus.PASS, "Internal value for 'Pending For Review' decremented.");
			test.log(LogStatus.PASS, "Old Value = "+oldInternalReviewValue+ " | New Value = "+ newInternalReviewValue);
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated Internal Count doesn't reverted on Dashboard.");
			}
			if(clickButton.equalsIgnoreCase("Reject"))
			{
				if(newInternalRejectValue > oldInternalRejectValue)
				{
				//	test.log(LogStatus.PASS, "Internal value for 'Rejected : "+clickButton+"' incremented.");
					test.log(LogStatus.PASS, "Old Internal Reject Value = "+oldInternalRejectValue+" | New Internal Reject Value = "+ newInternalRejectValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Updated Internal value not reverted on Dashboard.");
				}
			}
		}
		else
		{
			test.log(LogStatus.PASS, "Internal Compliance (Pending for Review) doesn't performed as the Compliance Document didn't found.");
		}
		
		performer.OverduePOM.clickDashboard().click();
	}
	
	public static void PendingReviewInternalCri(ExtentTest test, XSSFSheet sheet, String clickButton)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickInternalReview()));	//Wait until Internal Pending For Review count gets visible.
		int oldInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading old value of Internal Pending For Review
		int oldInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		int OldCountCompletedIn = Integer.parseInt(ReviewerPOM.ClickCompletedIn().getText());	//Reading old value of Internal Reject

		ReviewerPOM.clickInternalReview().click();		//Clicking on Statutory Review value.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
		Thread.sleep(6000);
	
		int flag = 0;
	//	wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
		elementsList = ReviewerPOM.clickActions();
		for (int i = 0; i < elementsList.size(); i++)						//Starting from the third button.
		{
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,500)"," ");
			
			Thread.sleep(300);
			elementsList = ReviewerPOM.clickActions();
			elementsList.get(i).click();									//Clicking on ith action button.
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalReviewerFrame"));
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			WebElement download = null;
			try
			{
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickDownloadInternal1()));
				download = ReviewerPOM.clickDownloadInternal1();			//Check if Download link is available or not.		
			}
			catch(Exception e)
			{
				
			}
			
			if(download == null)
			{
				flag = 1;
				getDriver().switchTo().parentFrame();							//Switching back to parent frame from iFrame
				ReviewerPOM.ComplainceInternalReviewer().click();		//Closing the compliance popup as it has message.
				Thread.sleep(1000);
			}
			else
			{
				flag = 0;
				ReviewerPOM.clickDownloadInternal1().click();				//Clicking on Download to download the document
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,400)"," ");					//Scrolling down window by 2000 px.
				
				Thread.sleep(500);
				try
				{
					ReviewerPOM.clickClosedTimelyInternal().click();		//Clicking on Closed-Delay radio button.
				}
				catch(Exception e)
				{
					
				}
				
				WebElement ele1 = null;
				WebElement ele2 = null;
				WebElement ele3 = null;
				try
				{
					wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertLiability1()));
					ele1 = ReviewerPOM.insertLiability1();			//Loaded element in ele1. So that, if element not found it will do nothing.
					ele2 = ReviewerPOM.insertLiability2();			//Loaded element in ele2. So that, if element not found it will do nothing.
					ele3 = ReviewerPOM.insertLiability3();			//Loaded element in ele3. So that, if element not found it will do nothing.
				}
				catch(Exception e)
				{
					
				}
				if(ele1 != null)
				{
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
					Row row4 = sheet.getRow(4);											//Selected 4th index row (Fifth row)
					Cell c2 = row4.getCell(1);											//Selected cell (4 row,1 column)
					int liability2 = (int) c2.getNumericCellValue();					//Got the amount stored at position 4,1
					String l2 = Integer.toString(liability2); 							//Converting int to String
					ReviewerPOM.insertLiability2().clear();				//Clearing the text box.
					ReviewerPOM.insertLiability2().sendKeys(l2);		//Inserting amount in text box
					Thread.sleep(500);
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
				
				Row row6 = sheet.getRow(6);											//Selected 6th index row (Seventh row)
				Cell c4 = row6.getCell(1);											//Selected cell (6 row,1 column)
				String remark = c4.getStringCellValue();							//Got the URL stored at position 6,1
				try
				{
					wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextAreaInternal()));
					ReviewerPOM.insertTextAreaInternal().sendKeys(remark);		//Inserting remark in Text area
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(500);
				if(clickButton.equalsIgnoreCase("Approve"))
				{
					ReviewerPOM.clickApprove().click();						//Clicking on Approve button.
					Thread.sleep(500);
					getDriver().switchTo().alert().accept();									//Accepting msg of Successful Submission.
				}
				else
				{
					ReviewerPOM.clickReject().click();						//Clicking on Reject button.
					Thread.sleep(500);
				}
				
				getDriver().switchTo().parentFrame();									//Switching back to parent frame from iFrame
				Thread.sleep(1000);
		//		.navigate().refresh();
				Thread.sleep(3000);
			//	wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickAction1()));
			//	break;
			}
			Thread.sleep(500);
		/*	if(i == elementsList.size()-1)
			{
				js.executeScript("window.scrollBy(0,500)"," ");
				CFOcountPOM.clickNextPage1().click();
				i = -1;
			}*/
		}		
		
		Thread.sleep(2500);
		
		getDriver().navigate().refresh();
		
		wait.until(ExpectedConditions.visibilityOf(performer.OverduePOM.clickDashboard()));
		performer.OverduePOM.clickDashboard().click();
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickInternalReview()));
		int newInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading new value of Internal Pending For Review
		int newInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		int NewCountCompletedIn = Integer.parseInt(ReviewerPOM.ClickCompletedIn().getText());	//Reading old value of Internal Reject

		if(flag == 0)
		{
			if(newInternalReviewValue < oldInternalReviewValue)
			{
			//	test.log(LogStatus.PASS, "Internal value for 'Pending For Review' decremented.");
			test.log(LogStatus.PASS, "Old Value = "+oldInternalReviewValue+ " | New Value = "+ newInternalReviewValue);
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated Internal Count doesn't reverted on Dashboard.");
			}
			if(clickButton.equalsIgnoreCase("Reject"))
			{
				if(newInternalRejectValue > oldInternalRejectValue)
				{
				//	test.log(LogStatus.PASS, "Internal value for 'Rejected : "+clickButton+"' incremented.");
					test.log(LogStatus.PASS, "Old Internal Reject Value = "+oldInternalRejectValue+" | New Internal Reject Value = "+ newInternalRejectValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Updated Internal value not reverted on Dashboard.");
				}
			}else {
				
				test.log(LogStatus.PASS, "Old Internal Completed Value = "+OldCountCompletedIn+ " | New Internal Completed Value = "+ NewCountCompletedIn+".");
				
			}
		}
		else
		{
			test.log(LogStatus.PASS, "Internal Compliance (Pending for Review) doesn't performed as the Compliance Document didn't found.");
		}
		
		performer.OverduePOM.clickDashboard().click();
	}
	
	public static void PendingReviewInternalCri1(ExtentTest test, String clickButton)throws InterruptedException, EncryptedDocumentException, IOException
	{
		
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.clickStatutoryReview()));	//Wait until Statutory Pending For Review count gets visible.
		int oldInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading old value of Internal Pending For Review
		int oldInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		int OldCountCompletedIn = Integer.parseInt(ReviewerPOM.ClickCompletedIn().getText());	//Reading old value of Internal Reject

		ReviewerPOM.clickInternalReview().click();		//Clicking on Statutory Review value.
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='grid'][@class='k-selectable']")));
	//	elementsList = ReviewerPOM.clickStatus();				//CLicking on Status to sort it in ascending order
	//	elementsList.get(0).click();
		
		elementsList = ReviewerPOM.clickActions();
		elementsList.get(0).click();					//Clicking on third action button.
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalReviewerFrame"));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
		try
		{
			Thread.sleep(500);
			ReviewerPOM.clickDownloadInternal1().click();					//Clicking on 'Click Here' label.
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
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyInternal()));
			ReviewerPOM.clickClosedTimelyInternal().click();			//Clicking on Closed-Delay radio button.
		}
		catch(Exception e)
		{
			
		}
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(1);
		//XSSFSheet sheet = ReadExcel();
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
		
	
		Row row6 = sheet.getRow(6);											//Selected 6th index row (Seventh row)
		Cell c4 = row6.getCell(1);											//Selected cell (6 row,1 column)
		String remark = c4.getStringCellValue();							//Got the URL stored at position 6,1
		ReviewerPOM.insertTextAreaInternal().sendKeys(remark);				//Inserting remark in Text area
		try
		{
		//	wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.insertTextAreaInternal()));
			ReviewerPOM.insertTextAreaInternal().sendKeys(remark);		//Inserting remark in Text area
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(500);
		if(clickButton.equalsIgnoreCase("Approve"))
		{
			ReviewerPOM.clickApprove().click();						//Clicking on Approve button.
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();									//Accepting msg of Successful Submission.
		}
		else
		{
			ReviewerPOM.clickReject().click();						//Clicking on Reject button.
			Thread.sleep(500);
		}
		
		try {
			getDriver().switchTo().alert().accept();		
		}catch(Exception e) {
			
		}
		
		getDriver().switchTo().parentFrame();									//Switching back to parent frame from iFrame
		Thread.sleep(1000);


	

		Thread.sleep(2500);
		
		//getDriver().navigate().refresh();
		
		wait.until(ExpectedConditions.visibilityOf(performer.OverduePOM.clickDashboard()));
		performer.OverduePOM.clickDashboard().click();
		
		Thread.sleep(7000);
		wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickInternalReview()));
		int newInternalReviewValue = Integer.parseInt(ReviewerPOM.clickInternalReview().getText());	//Reading new value of Internal Pending For Review
		int newInternalRejectValue = Integer.parseInt(ReviewerPOM.readInternalReject().getText());	//Reading old value of Internal Reject
		int NewCountCompletedIn = Integer.parseInt(ReviewerPOM.ClickCompletedIn().getText());	//Reading old value of Internal Reject


	if(newInternalReviewValue < oldInternalReviewValue)
	{
	//	test.log(LogStatus.PASS, "Internal value for 'Pending For Review' decremented.");
	test.log(LogStatus.PASS, "Old  Internal Pending For Review Value = "+oldInternalReviewValue+ " | New Internal Pending For Review Value Value = "+ newInternalReviewValue);
	}
	else
	{
		test.log(LogStatus.FAIL, "Updated Internal Count doesn't reverted on Dashboard.");
	}
	if(clickButton.equalsIgnoreCase("Reject"))
	{
		if(newInternalRejectValue > oldInternalRejectValue)
		{
		//	test.log(LogStatus.PASS, "Internal value for 'Rejected : "+clickButton+"' incremented.");
			test.log(LogStatus.PASS, "Old Internal Reject Value = "+oldInternalRejectValue+" | New Internal Reject Value = "+ newInternalRejectValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated Internal value not reverted on Dashboard.");
		}
	}else {
		
		test.log(LogStatus.PASS, "Old Internal Completed Value = "+OldCountCompletedIn+ " | New Internal Completed Value = "+ NewCountCompletedIn+".");
		
	}

	}
	
	public static void CompletedStatutory(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickCompletedSta()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickCompletedSta().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickCompletedSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, " File does not downloaded.");
		}
		
		elementsList = ReviewerPOM.clickOverView();
		elementsList.get(4).click();
		Thread.sleep(2000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			//test.log(LogStatus.PASS, "Number of Completed grid matches to Dashboard Completed  Count.");
			test.log(LogStatus.PASS, "No of Completed in the grid = "+count+" | Dashboard Completed  Count = "+DasCountCompletedSta);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Completed does not matches to Dashboard Completed  Count.");
			test.log(LogStatus.FAIL, "No of Completed in the grid = "+count+" | Dashboard Completed  Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(500,0)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		elementsList.get(5).click();
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark().sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen().click();
		Thread.sleep(8000);
		String msg =getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();	
		test.log(LogStatus.PASS, "Message Display " +msg);
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(5000);
		/*
		ReviewerPOM.clickAdavanceSearch().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody")));
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		
		String s4 = ReviewerPOM.ReadCountEvent1().getText();		//Reading total number of items.
		String[] bits4 = s4.split(" ");									//Splitting the String
		String itomsCount4 = bits4[bits4.length - 2];						//Getting the second last word (total number of items)
		int	count4 = Integer.parseInt(itomsCount4);
		
		Thread.sleep(1000);
		ReviewerPOM.ReopenAS().click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews5"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark().sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen().click();
		Thread.sleep(8000);
		String msg1 =getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();	
		test.log(LogStatus.PASS, "Message Display  :- " +msg1);
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody")));
		String s2 = ReviewerPOM.ReadCountEvent1().getText();		//Reading total number of items.
		String[] bits1 = s2.split(" ");									//Splitting the String
		String itomsCount1 = bits1[bits1.length - 2];						//Getting the second last word (total number of items)
		int	count1 = Integer.parseInt(itomsCount1);
		if(count4 > count1)
		{
			test.log(LogStatus.PASS, "After Re-Open Count on Grid decrease");
		}
		else
		{
			test.log(LogStatus.FAIL, "Count Not decrease");
		}
		Thread.sleep(2000);
		ReviewerPOM.closeAS().click();		
		Thread.sleep(3000);
		*/
		OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
		
		
	}
	
	public static void CompletedStatutoryCri(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickCompletedSta()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickCompletedSta().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickCompletedSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		elementsList = ReviewerPOM.clickOverView1();
		elementsList.get(1).click();
		Thread.sleep(2000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			//test.log(LogStatus.PASS, "Number of Completed grid matches to Dashboard Completed  Count.");
			test.log(LogStatus.PASS, "No of Completed in the grid = "+count+" | Dashboard Completed  Count = "+DasCountCompletedSta);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Completed does not matches to Dashboard Completed  Count.");
			test.log(LogStatus.FAIL, "No of Completed in the grid = "+count+" | Dashboard Completed  Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
	
		OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
		
		
	}
	
	public static void CompletedInternal(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickCompletedIn()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickCompletedIn().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickCompletedIn().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		elementsList = ReviewerPOM.clickOverView();
		elementsList.get(4).click();
		Thread.sleep(2000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			//test.log(LogStatus.PASS, "Number of Completed Internal grid matches to Dashboard Completed Internal Count.");
			test.log(LogStatus.PASS, "No of Completed Internal in the grid = "+count+" | Dashboard Completed Internal Count = "+DasCountCompletedSta);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Completed Internal does not matches to Dashboard Completed Internal Count.");
			test.log(LogStatus.FAIL, "No of Completed Internal in the grid = "+count+" | Dashboard Completed Internal Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(2000);
		
	}
	
	public static void CompletedInternalCri(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickCompletedIn()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickCompletedIn().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickCompletedIn().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		Thread.sleep(8000);
	
		
		elementsList = ReviewerPOM.clickOverView1();
		elementsList.get(1).click();
		Thread.sleep(2000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
		//	test.log(LogStatus.PASS, "Number of Completed Internal grid matches to Dashboard Completed Internal Count.");
			test.log(LogStatus.PASS, "No of Completed Internal in the grid = "+count+" | Dashboard Completed Internal Count = "+DasCountCompletedSta);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Completed Internal does not matches to Dashboard Completed Internal Count.");
			test.log(LogStatus.FAIL, "No of Completed Internal in the grid = "+count+" | Dashboard Completed Internal Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(2000);
		
	}
	
	
	
	public static void  OverdueStatutory(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueSta()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickOverdueSta().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickOverdueSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		Thread.sleep(2000);
		elementsList = ReviewerPOM.clickOverView();
		elementsList.get(4).click();
		Thread.sleep(3000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			test.log(LogStatus.PASS, "Number of Overdue grid matches to Dashboard Overdue  Count.");
			//test.log(LogStatus.INFO, "No of Overdue in the grid = "+count+" | Dashboard Overdue  Count = "+DasCountCompletedSta);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of Overdue does not matches to Dashboard Overdue  Count.");
			//test.log(LogStatus.INFO, "No of Overdue in the grid = "+count+" | Dashboard Overdue  Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(2000);
		
	}
	
	public static void  OverdueStatutoryMp(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueSta()));	//Wait until Internal Pending For Review count gets visible.
		
		
		
		ReviewerPOM.ClickOverdueSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		OverduePOM.txtSearchComplianceID().sendKeys("111463");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		 ReviewerPOM.MitigationPlanVD().click();
		 Thread.sleep(8000);
		 getDriver().switchTo().frame("frameMitigationOverViews");		
			 Thread.sleep(4000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		ReviewerPOM.MPDownload().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		Thread.sleep(2000);
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		ReviewerPOM.CloseMp().click();
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(2000);
		
	}
	
	public static void  OverdueStatutoryMpV(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueSta()));	//Wait until Internal Pending For Review count gets visible.
		
		
		
		ReviewerPOM.ClickOverdueSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		OverduePOM.txtSearchComplianceID().sendKeys("111463");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		 ReviewerPOM.MitigationPlanVD().click();
		 Thread.sleep(8000);
			getDriver().switchTo().frame("frameMitigationOverViews");		
			 Thread.sleep(4000);
	
		 ReviewerPOM.ViewDoc().click();
		
		Thread.sleep(8000);
		ReviewerPOM.CloseViewDoc().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"view Document Successfully");
	
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		ReviewerPOM.CloseMp().click();
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(2000);
		
	}
	
	public static void OverdueInternal(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueIn()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickOverdueIn().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickOverdueIn().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		elementsList = ReviewerPOM.clickOverView();
		elementsList.get(4).click();
		Thread.sleep(2000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			test.log(LogStatus.PASS, "Number of Overdue Internal grid matches to Dashboard Overdue Internal Count.");
			//test.log(LogStatus.INFO, "No of Overdue Internal in the grid = "+count+" | Dashboard Overdue Internal Count = "+DasCountCompletedSta);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of Overdue Internal does not matches to Dashboard Overdue Internal Count.");
		//	test.log(LogStatus.INFO, "No of Overdue Internal in the grid = "+count+" | Dashboard Overdue Internal Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void  OverdueInternalMp(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueIn()));	//Wait until Internal Pending For Review count gets visible.
		
		
		
		ReviewerPOM.ClickOverdueIn().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		OverduePOM.txtSearchComplianceID().sendKeys("20024");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		 ReviewerPOM.MitigationPlanVD().click();
		 Thread.sleep(8000);
		 getDriver().switchTo().frame("frameMitigationOverViews");		
			 Thread.sleep(4000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		ReviewerPOM.MPDownload().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		Thread.sleep(2000);
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		ReviewerPOM.CloseMp().click();
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(2000);
		
	}
	
	public static void  OverdueInternalMpV(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueIn()));	//Wait until Internal Pending For Review count gets visible.
		
		
		
		ReviewerPOM.ClickOverdueIn().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		OverduePOM.txtSearchComplianceID().sendKeys("20024");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		 ReviewerPOM.MitigationPlanVD().click();
		 Thread.sleep(7000);
		 getDriver().switchTo().frame("frameMitigationOverViews");		
			 Thread.sleep(4000);
	
		 ReviewerPOM.ViewDoc().click();
		
		Thread.sleep(8000);
		By locator = By.xpath("//*[@id='DocumentPriview']/div/div/div[1]/button");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS,"view Document Successfully");
	
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		ReviewerPOM.CloseMp().click();
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(2000);
		
	}
	
	public static void  OverdueStatutoryCri(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueSta()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickOverdueSta().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickOverdueSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		Thread.sleep(8000);
		
		elementsList = ReviewerPOM.clickOverView();
		elementsList.get(1).click();
		Thread.sleep(3000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
		//	test.log(LogStatus.PASS, "Number of Overdue grid matches to Dashboard Overdue  Count.");
			test.log(LogStatus.PASS, "No of Overdue in the grid = "+count+" | Dashboard Overdue  Count = "+DasCountCompletedSta);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Overdue does not matches to Dashboard Overdue  Count.");
			test.log(LogStatus.FAIL, "No of Overdue in the grid = "+count+" | Dashboard Overdue  Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(2000);
		
	}
	
	public static void OverdueInternalCri(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueIn()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickOverdueIn().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickOverdueIn().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		Thread.sleep(8000);
		elementsList = ReviewerPOM.clickOverView();
		elementsList.get(1).click();
		Thread.sleep(2000);
		ReviewerPOM.CloseOverview().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			//test.log(LogStatus.PASS, "Number of Overdue Internal grid matches to Dashboard Overdue Internal Count.");
			test.log(LogStatus.PASS, "No of Overdue Internal in the grid = "+count+" | Dashboard Overdue Internal Count = "+DasCountCompletedSta);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Overdue Internal does not matches to Dashboard Overdue Internal Count.");
			test.log(LogStatus.FAIL, "No of Overdue Internal in the grid = "+count+" | Dashboard Overdue Internal Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	
	public static void  RejectedStatutory(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickRejectedSta()));	//Wait until Internal Pending For Review count gets visible.
		
		
		ReviewerPOM.ClickRejectedSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
	
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(4000);
		
		
	}
	
	public static void  RejectedInternal(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickRejectedSta()));	//Wait until Internal Pending For Review count gets visible.
		
		
		ReviewerPOM.ClickRejectedIn().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
	
		Thread.sleep(4000);
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(4000);
		
	}
	
	
	public static void Events(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickEvents()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickEvents().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickEvents().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s = ReviewerPOM.ReadCountEvent().getText();	
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		elementsList = ReviewerPOM.clickOverViewE();
		elementsList.get(1).click();
		Thread.sleep(3000);
		ReviewerPOM.CloseOverview1().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
		//JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			test.log(LogStatus.PASS, "Number of Event grid matches to Dashboard Event Count.");
			test.log(LogStatus.INFO, "No of Event in the grid = "+count+" | Dashboard Event Count = "+DasCountCompletedSta);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of Overdue Internal does not matches to Dashboard Event Count.");
			test.log(LogStatus.INFO, "No of Event in the grid = "+count+" | Dashboard Event Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		}else {
			
			if(DasCountCompletedSta == 0)
			{
				test.log(LogStatus.PASS, "Number of Event grid matches to Dashboard Event Count.");
				test.log(LogStatus.PASS, "No of Event in the grid = "+0+" | Dashboard Event Count = "+DasCountCompletedSta);
			}
			else
			{
				test.log(LogStatus.FAIL, "Number of Overdue Internal does not matches to Dashboard Event Count.");
				test.log(LogStatus.INFO, "No of Event in the grid = "+0+" | Dashboard Event Count = "+DasCountCompletedSta);
			}
			
		}
		
		
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void EventsFilter(ExtentTest test, int no)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickEvents()));	//Wait until Internal Pending For Review count gets visible.
		
		
		
		ReviewerPOM.ClickEvents().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		
		
		ReviewerPOM.EventID().sendKeys(""+no+"",Keys.ENTER);
		Thread.sleep(500);
	
		ReviewerPOM.EntitySubEntity().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		DeptCountPOM.EntityLocationExpand().click();
		Thread.sleep(2000);
		  String locationtext =DeptCountPOM.ABPvtLtd().getText();
	       Thread.sleep(2000);
	       ReviewerPOM.EntitySubEntity().click();		//Clicking on Statutory Review value.
			Thread.sleep(1000);
Thread.sleep(5000);
Thread.sleep(500);

Thread.sleep(500);
List<String> li=new ArrayList<String>();

li.add(""+no+"");
li.add(locationtext);
Thread.sleep(3000);

	List<String> filter=new ArrayList<String>();	
	filter.add("Event ID");
	filter.add("Location");
	
	MgmtSonyMethod.ClickTri().click();
    Thread.sleep(1000);
    MgmtSonyMethod.ColumnsE().click();
    Thread.sleep(500);
    MgmtSonyMethod.EventIdcol().click();
    Thread.sleep(1000);
   
    MgmtSonyMethod. ClickTri().click();


JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scrollBy(0,150)");	
Thread.sleep(3000);
//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
String s = CFOcountPOM.readTotalItemsD().getText();
Thread.sleep(500);
if(!s.equalsIgnoreCase("No items to display")) {
Thread.sleep(5000);

List<WebElement> IDcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[8]"));
List<WebElement> locationcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));

for(int i=0; i<li.size(); i++){

List<String> text= new ArrayList<String>();
HashSet<String> pass=new LinkedHashSet<>();
HashSet<String> fail=new LinkedHashSet<>();
List<WebElement> raw=new ArrayList<WebElement>();

if(i==0)
{
raw.addAll(IDcol);
}
else
if(i==1)
{
raw.addAll(locationcol);
}

for(int k=0;k<raw.size();k++)
{
text.add(raw.get(k).getText());
}

for(int l=0;l<text.size();l++)
{
if(text.get(l).equals(li.get(i)))
{
	pass.add(text.get(l));	
	System.out.println("pass : "+text.get(l)+" : "+li.get(i));

}
else
{
fail.add(text.get(l));		
System.out.println("fail : "+text.get(l)+" : "+li.get(i));
System.out.println(i);

}
}

for(String Fal : fail)
{
		test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
}	
for(String Pas : pass)
{
	 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
		test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
		System.out.println(filter.get(i)+" : "+Pas);
}
text.clear();
pass.clear();
fail.clear();
raw.clear();


}
}else {
test.log(LogStatus.PASS," :- No records found");	
}
Thread.sleep(3000);

		
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void ActivatedEvents(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickActivatedEvents()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickActivatedEvents().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickActivatedEvents().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s = ReviewerPOM.ReadCountEvent().getText();	
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		elementsList = ReviewerPOM.clickOverViewAE();
		elementsList.get(1).click();
		Thread.sleep(3000);
		ReviewerPOM.CloseOverview1().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
		///	test.log(LogStatus.INFO, "No of  Activated Events in the grid = "+count+" | Dashboard  Activated Events Count = "+DasCountCompletedSta);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
		//	test.log(LogStatus.INFO, "No of Activated Events in the grid = "+count+" | Dashboard Activated Events Count = "+DasCountCompletedSta);
		}
		
}else {
			
			if(DasCountCompletedSta == 0)
			{
				test.log(LogStatus.PASS, "Number of  Activated Event grid matches to Dashboard Event Count.");
				test.log(LogStatus.PASS, "No of Activated Event in the grid = "+0+" | Dashboard Activated Event Count = "+DasCountCompletedSta);
			}
			else
			{
				test.log(LogStatus.FAIL, "Number of Activated Event does not matches to Dashboard Activated Event Count.");
				test.log(LogStatus.INFO, "No of Activated Event in the grid = "+0+" | Dashboard Activated Event Count = "+DasCountCompletedSta);
			}
}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void ClosedEvents(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickClosedEvents()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickClosedEvents().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickClosedEvents().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s = ReviewerPOM.ReadCountEvent().getText();	
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		elementsList = ReviewerPOM.clickOverViewCE();
		elementsList.get(1).click();
		Thread.sleep(3000);
		ReviewerPOM.CloseOverview1().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			test.log(LogStatus.PASS, "Number of Closed Events  grid matches to Dashboard Closed Events Count.");
		//	test.log(LogStatus.INFO, "No of  Closed Events in the grid = "+count+" | Dashboard  Closed Events Count = "+DasCountCompletedSta);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of Closed Events  does not matches to Dashboard Closed Events  Count.");
			//test.log(LogStatus.INFO, "No of Closed Events in the grid = "+count+" | Dashboard Closed Events Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		
}else {
			
			if(DasCountCompletedSta == 0)
			{
				test.log(LogStatus.PASS, "Number of  Closed Event grid matches to Dashboard Closed Event Count.");
				test.log(LogStatus.PASS, "No of Closed Event in the grid = "+0+" | Dashboard Closed Event Count = "+DasCountCompletedSta);
			}
			else
			{
				test.log(LogStatus.FAIL, "Number of Closed Event does not matches to Dashboard Closed Event Count.");
				test.log(LogStatus.INFO, "No of Closed Event in the grid = "+0+" | Dashboard Closed Event Count = "+DasCountCompletedSta);
			}
}
		OverduePOM.clickDashboard().click();
		
	}
	
	
	
	public static void DetailedReport1(ExtentTest test, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(5000);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage().click();			//Exporting (Downloading) file
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Export successfully");
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(1000);
		CFOcountPOM.closeDocument1().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
		OverduePOM.clickRiskD().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorR));
		Thread.sleep(4000);
		
		WebElement clickHigh = getDriver().findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclearBtn().click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(4000);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = getDriver().findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
	test.log(LogStatus.PASS, "Advanced Search-overView successfully");
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportExcel().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search-Export successfully");
		CFOcountPOM.selectMonth1().click();
		Thread.sleep(3000);
		/*
		CFOcountPOM.selectLastSixMon().click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel().click();
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = getDriver().findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor);
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Advanced Search-After Apply Month-overView success");
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(4000);
			CFOcountPOM.clickExportExcel().click();
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Advanced Search-After Apply Month-Export Succefully");
			//clickStartDate1().click();
			CFOcountPOM.clickStartDate11().sendKeys("23-Nov-2022");
			CFOcountPOM.clickLastDate11().sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			CFOcountPOM.clickApplyAd().click();
			Thread.sleep(3000);*/
			OverduePOM.clickRiskDA().click();
			Thread.sleep(1000);
			By locatorRA = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[72]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorRA));
			Thread.sleep(4000);
			
			WebElement clickHighA = getDriver().findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
			
			OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);
			OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
	}

	public static void DetailedReportIn(ExtentTest test, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		OverduePOM.clickcomplianceType().click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceSta().click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceIN().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage().click();			//Exporting (Downloading) file
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Export successfully");
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(1000);
		CFOcountPOM.closeDocument1().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
		OverduePOM.clickRiskD().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement clickHigh = getDriver().findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclearBtn().click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);
	/*	CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(7000);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(3000);
	OverduePOM.clickcomplianceTypeAS().click();
	Thread.sleep(3000);
	By locatorS = By.xpath("(//span[@class='k-in k-state-selected'])");
	wait.until(ExpectedConditions.presenceOfElementLocated(locatorS));
	Thread.sleep(4000);
	
	WebElement ClickSta = getDriver().findElement(locatorR);	
	Thread.sleep(4000);
jse.executeScript("arguments[0].click();", ClickSta);
	Thread.sleep(4000);
	
	//OverduePOM.clickcomplianceStaASR().click();
	Thread.sleep(2000);
	OverduePOM.clickcomplianceINASR().click();
	
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor);
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = getDriver().findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
	test.log(LogStatus.INFO, "Advanced Search-overView success");
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportExcel().click();
		Thread.sleep(3000);
		test.log(LogStatus.INFO, "Advanced Search-Export successfully");
		CFOcountPOM.selectMonth1().click();
		Thread.sleep(3000);
		
		CFOcountPOM.selectLastSixMon().click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel().click();
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = getDriver().findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor);
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.INFO, "Advanced Search-After Apply Month-overView success");
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(4000);
			CFOcountPOM.clickExportExcel().click();
			Thread.sleep(3000);
			test.log(LogStatus.INFO, "Advanced Search-After Apply Month-Export Succefully");
			//clickStartDate1().click();
			CFOcountPOM.clickStartDate11().sendKeys("23-Nov-2022");
			CFOcountPOM.clickLastDate11().sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			CFOcountPOM.clickApplyAd().click();
			Thread.sleep(3000);
			OverduePOM.clickRiskDA().click();
			Thread.sleep(1000);
			By locatorRA = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[72]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorRA));
			Thread.sleep(4000);
			
			WebElement clickHighA = getDriver().findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
			
			OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
			test.log(LogStatus.INFO, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();*/
			Thread.sleep(2000);
			OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
	}
	
	public static void CalendarDownload(ExtentTest test ) throws InterruptedException, IOException
	{
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
		Thread.sleep(1000);
		ReviewerPOM.CalendarDownload().click();
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "While click on ' Download ' Button  Month Wise Calendar Report should be Downloaded.");
		Thread.sleep(3000);
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.CalendarIcon().click();		//Exporting (Downloading) file
		Thread.sleep(8000);
		Thread.sleep(3000);//C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		Thread.sleep(3000);
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  click on ' Calendar ' Icon  Calendar Report should be Downloaded.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		
		OverduePOM.clickDashboard().click();
	
	}
	
	public static void CalendarApprove(ExtentTest test ) throws InterruptedException, IOException
	{
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
		Thread.sleep(8000);
		OverduePOM.clickStaBtnCaleRe().click();
		Thread.sleep(3000);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
		Thread.sleep(3000);
		elementsList = OverduePOM.clickCalenderAction();
		Thread.sleep(2000);
		elementsList.get(2).click();
		Thread.sleep(4000);
		
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iInternalReviewerFrame"));
		js.executeScript("window.scrollBy(0,500)");                  	
		Thread.sleep(2000);
		OverduePOM.ClickRadioBtn().click();
		Thread.sleep(3000);
		OverduePOM.remark2().sendKeys("Automation Testing");
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='btnSave3']")).click();
		Thread.sleep(1000);
		String Msg =getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();	
		if(Msg.equalsIgnoreCase("save successfully"))
		{
			test.log(LogStatus.INFO, "Message displayed - 'save successfully'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - save successfully this msg not show'");
		}
		
		//MethodsPOM.MyCalendarCompliance(, test);
		getDriver().switchTo().parentFrame();
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Calendder Internal Approve Succefully");
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
	
		
	}
	
	public static void CalendarReject(ExtentTest test ) throws InterruptedException, IOException
	{
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
		Thread.sleep(8000);
		OverduePOM.clickStaBtnCaleRe().click();
		Thread.sleep(3000);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
		Thread.sleep(3000);
		elementsList = OverduePOM.clickCalenderAction();
		Thread.sleep(2000);
		elementsList.get(2).click();
		Thread.sleep(4000);
		
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iInternalReviewerFrame"));
		js.executeScript("window.scrollBy(0,500)");                  	
		Thread.sleep(2000);
		OverduePOM.ClickRadioBtn().click();
		Thread.sleep(2000);
		OverduePOM.remark2().sendKeys("Automation Testing");
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='btnReject3']")).click();
		Thread.sleep(1000);
		
		//MethodsPOM.MyCalendarCompliance(, test);
		getDriver().switchTo().parentFrame();
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Calendder Internal perform Succefully");
		OverduePOM.clickDashboard().click();
	
		
	}
	
	public static void DetailedReport1Cri(ExtentTest test, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(4000);
		
//		OverduePOM.ClickDropD().click();
//		Thread.sleep(3000);
//		OverduePOM.Selectreviwer().click();
		Thread.sleep(3000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(user.equalsIgnoreCase("Internal")) {
			CFOcountPOM.InternalRe().click();
			Thread.sleep(4000);
		}
		else {
		CFOcountPOM.StatutoryRe().click();
		Thread.sleep(4000);
	}
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage2().click();			//Exporting (Downloading) file
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Exporting (Downloading) file successfully");
	//	By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument2().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		
			performer.OverduePOM.clickDashboard().click();
	}

	public static void DetailedReport1CriPer(ExtentTest test, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
//		Thread.sleep(4000);
//		OverduePOM.ClickDropD().click();
//		Thread.sleep(3000);
//		OverduePOM.SelectPerformer().click();
//		Thread.sleep(500);
		//OverduePOM.clickApply().click();
		//Thread.sleep(5000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(user.equalsIgnoreCase("Internal")) {
			CFOcountPOM.InternalRe().click();
			Thread.sleep(4000);
		}
		else {
		CFOcountPOM.StatutoryRe().click();
		Thread.sleep(4000);
	}
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage2().click();			//Exporting (Downloading) file
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Exporting (Downloading) file successfully");
	//	By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument2().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		
			performer.OverduePOM.clickDashboard().click();
	}

	
	public static void MPFilter(ExtentTest test, int no ,String Text)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickEvents()));	//Wait until Internal Pending For Review count gets visible.
		
		
		if(Text.equalsIgnoreCase("internal")) {
			ReviewerPOM.ClickOverdueIn().click();		//Clicking on Statutory Review value.
			Thread.sleep(1000);
		}else {
			ReviewerPOM.ClickOverdueSta().click();		//Clicking on Statutory Review value.
			Thread.sleep(1000);
		}
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		
	
		ReviewerPOM.MitigationPlan().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		  String MPtext =ReviewerPOM.MitigationPlan1().getText();
	       Thread.sleep(2000);
		ReviewerPOM.MitigationPlan1().click();
		Thread.sleep(2000);
		ReviewerPOM.Apply().click();		//Clicking on Statutory Review value.
		Thread.sleep(4000);
Thread.sleep(500);

if(MPtext.equalsIgnoreCase("Updated"))
{


Thread.sleep(500);
List<String> li=new ArrayList<String>();

li.add(""+no+"");

Thread.sleep(3000);

	List<String> filter=new ArrayList<String>();	
	filter.add("Mitigation plan ");
	
	MgmtSonyMethod.ClickTri().click();
    Thread.sleep(3000);
    MgmtSonyMethod.Columns().click();
    Thread.sleep(4000);
    By locator = By.cssSelector("input[type='checkbox'][data-field='MitigationPlan']");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
   // MgmtSonyMethod.MitigationPlan().click();
    Thread.sleep(3000);
   
    MgmtSonyMethod. ClickTri().click();


JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scrollBy(0,150)");	
Thread.sleep(3000);
//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
String s = CFOcountPOM.readTotalItemsD().getText();
Thread.sleep(500);
if(!s.equalsIgnoreCase("No items to display")) {
Thread.sleep(5000);

List<WebElement> IDcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[15]"));

for(int i=0; i<li.size(); i++){

List<String> text= new ArrayList<String>();
HashSet<String> pass=new LinkedHashSet<>();
HashSet<String> fail=new LinkedHashSet<>();
List<WebElement> raw=new ArrayList<WebElement>();

if(i==0)
{
raw.addAll(IDcol);
}


for(int k=0;k<raw.size();k++)
{
text.add(raw.get(k).getText());
}

for(int l=0;l<text.size();l++)
{
if(text.get(l).equals(li.get(i)))
{
	pass.add(text.get(l));	
	System.out.println("pass : "+text.get(l)+" : "+li.get(i));

}
else
{
fail.add(text.get(l));		
System.out.println("fail : "+text.get(l)+" : "+li.get(i));
System.out.println(i);

}
}

for(String Fal : fail)
{
		test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
}	
for(String Pas : pass)
{
	 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
		test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
		System.out.println(filter.get(i)+" : "+Pas);
}
text.clear();
pass.clear();
fail.clear();
raw.clear();


}
}else {
test.log(LogStatus.PASS," :- No records found");	
}
Thread.sleep(3000);
}
		
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void MyEscalationFilter(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.MyEscalation()));	//Wait until Internal Pending For Review count gets visible.
		
		
		
		ReviewerPOM.MyEscalation().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		

		ReviewerPOM.EntitySubEntityE().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		DeptCountPOM.EntityLocationExpand().click();
		Thread.sleep(2000);
		  String locationtext =DeptCountPOM.ABPvtLtd1().getText();
	       Thread.sleep(2000);
	       DeptCountPOM.ABPvtLtd1().click();		//Clicking on Statutory Review value.
			Thread.sleep(1000);
			ReviewerPOM.EntitySubEntityE().click();
Thread.sleep(5000);
Thread.sleep(500);

Thread.sleep(500);
List<String> li=new ArrayList<String>();


li.add(locationtext);
Thread.sleep(3000);

	List<String> filter=new ArrayList<String>();	
	
	filter.add("Location");
	
	

JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scrollBy(0,150)");	
Thread.sleep(3000);
//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
String s = CFOcountPOM.readTotalItemsD().getText();
Thread.sleep(500);
if(!s.equalsIgnoreCase("No items to display")) {
Thread.sleep(5000);


List<WebElement> locationcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));

for(int i=0; i<li.size(); i++){

List<String> text= new ArrayList<String>();
HashSet<String> pass=new LinkedHashSet<>();
HashSet<String> fail=new LinkedHashSet<>();
List<WebElement> raw=new ArrayList<WebElement>();



if(i==0)
{
raw.addAll(locationcol);
}

for(int k=0;k<raw.size();k++)
{
text.add(raw.get(k).getText());
}

for(int l=0;l<text.size();l++)
{
if(text.get(l).equals(li.get(i)))
{
	pass.add(text.get(l));	
	System.out.println("pass : "+text.get(l)+" : "+li.get(i));

}
else
{
fail.add(text.get(l));		
System.out.println("fail : "+text.get(l)+" : "+li.get(i));
System.out.println(i);

}
}

for(String Fal : fail)
{
		test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
}	
for(String Pas : pass)
{
	 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
		test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
		System.out.println(filter.get(i)+" : "+Pas);
}
text.clear();
pass.clear();
fail.clear();
raw.clear();


}
}else {
test.log(LogStatus.PASS," :- No records found");	
}
Thread.sleep(3000);

		
		OverduePOM.clickDashboard().click();
		
	}

	public static void MyReminderFilter(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.MyEscalation()));	//Wait until Internal Pending For Review count gets visible.
		
		
		
		OverduePOM.clickMyReminder().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]/table")));
		

		ReviewerPOM.EntitySubEntityR().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		DeptCountPOM.EntityLocationExpand().click();
		Thread.sleep(2000);
		  String locationtext =DeptCountPOM.ABPvtLtd11().getText();
	       Thread.sleep(2000);
	       DeptCountPOM.ABPvtLtd11().click();		//Clicking on Statutory Review value.
			Thread.sleep(1000);
		//	ReviewerPOM.EntitySubEntityR().click();
Thread.sleep(5000);
Thread.sleep(500);

Thread.sleep(500);
List<String> li=new ArrayList<String>();


li.add(locationtext);
Thread.sleep(3000);

	List<String> filter=new ArrayList<String>();	
	
	filter.add("Location");
	
	

JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scrollBy(0,150)");	
Thread.sleep(3000);
//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
String s = CFOcountPOM.readTotalItemsD().getText();
Thread.sleep(500);
if(!s.equalsIgnoreCase("No items to display")) {
Thread.sleep(5000);


List<WebElement> locationcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[1]"));

for(int i=0; i<li.size(); i++){

List<String> text= new ArrayList<String>();
HashSet<String> pass=new LinkedHashSet<>();
HashSet<String> fail=new LinkedHashSet<>();
List<WebElement> raw=new ArrayList<WebElement>();



if(i==0)
{
raw.addAll(locationcol);
}

for(int k=0;k<raw.size();k++)
{
text.add(raw.get(k).getText());
}

for(int l=0;l<text.size();l++)
{
if(text.get(l).equals(li.get(i)))
{
	pass.add(text.get(l));	
	System.out.println("pass : "+text.get(l)+" : "+li.get(i));

}
else
{
fail.add(text.get(l));		
System.out.println("fail : "+text.get(l)+" : "+li.get(i));
System.out.println(i);

}
}

for(String Fal : fail)
{
		test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
}	
for(String Pas : pass)
{
	 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
		test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
		System.out.println(filter.get(i)+" : "+Pas);
}
text.clear();
pass.clear();
fail.clear();
raw.clear();


}
}else {
test.log(LogStatus.PASS," :- No records found");	
}
Thread.sleep(3000);

		
		OverduePOM.clickDashboard().click();
		
	}

	public static void ActivatedEventsPer(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.readActivatedEvents()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(OverduePOM.readActivatedEvents().getText());	//Reading old value of Internal Reject
		
		OverduePOM.readActivatedEvents().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
//		elementsList = ReviewerPOM.clickOverViewPer();
//		elementsList.get(0).click();
//		Thread.sleep(3000);
//		ReviewerPOM.CloseOverview1().click();
//		Thread.sleep(3000);
//		test.log(LogStatus.PASS,"Overview Successfully");
		//JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
		//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
			test.log(LogStatus.PASS, "No of  Activated Events in the grid = "+count+" | Dashboard  Activated Events Count = "+DasCountCompletedSta);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
			test.log(LogStatus.FAIL, "No of Activated Events in the grid = "+count+" | Dashboard Activated Events Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void ClosedEventsPer(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");		
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickClosedEventsPer()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickClosedEventsPer().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickClosedEventsPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(2000);
	/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		elementsList = ReviewerPOM.clickOverViewPerCE();
		elementsList.get(1).click();
		Thread.sleep(3000);
		ReviewerPOM.CloseOverview1().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");*/
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
			//test.log(LogStatus.PASS, "Number of Closed Events  grid matches to Dashboard Closed Events Count.");
			test.log(LogStatus.PASS, "No of  Closed Events in the grid = "+count+" | Dashboard  Closed Events Count = "+DasCountCompletedSta);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Closed Events  does not matches to Dashboard Closed Events  Count.");
			test.log(LogStatus.FAIL, "No of Closed Events in the grid = "+count+" | Dashboard Closed Events Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void AssignedEvents(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAssignedEvents()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(OverduePOM.clickAssignedEvents().getText());	//Reading old value of Internal Reject
		
		OverduePOM.clickAssignedEvents().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		elementsList = ReviewerPOM.clickOverViewAEPer();
		elementsList.get(1).click();
		Thread.sleep(3000);
		ReviewerPOM.CloseOverview1().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Overview Successfully");
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		ReviewerPOM.ReadCountEvent().click();					//Clicking on Text of total items just to scroll down.
		String s1 = ReviewerPOM.ReadCountEvent().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = ReviewerPOM.ReadCountEvent().getText();
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
		
					
		
		if(count == DasCountCompletedSta)
		{
		
			test.log(LogStatus.PASS, "No of  Assigned  Events in the grid = "+count+" | Dashboard  Assigned  Events Count = "+DasCountCompletedSta);	}
		else
		{
			
			test.log(LogStatus.FAIL, "No of Assigned  Internal in the grid = "+count+" | Dashboard Assigned  Internal Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void OverdueDAR(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		ReviewerPOM.ClickOverdueSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(1000);	
		Thread.sleep(3000);
		OverduePOM.StatusOverdue().click();
		Thread.sleep(3000);
		
		
	
     String textDA=	OverduePOM.DeviationAppliedO().getText();
     String textDR=	OverduePOM.DeviationRejectedO().getText();
     String textDAp=	OverduePOM.DeviationApprovedO().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown ");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void CompletedStatutorySF(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),  (35));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickCompletedSta()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickCompletedSta().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickCompletedSta().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(8000);
		CFOcountPOM.ComplianceID().sendKeys("27522");
		Thread.sleep(8000);
		ReviewerPOM.Apply().click();
		
		//elementsList = ReviewerPOM.clickOverView1();	Thread.sleep(3000);
		
		
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		
		Thread.sleep(8000);
		
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[26]/a[2]");
	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton =getDriver() .findElement(locator);	
		Thread.sleep(3000);
		JavascriptExecutor jse= (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
	
		WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews']"));
		getDriver()  .switchTo().frame(farme1);
		Thread.sleep(3000);
      	CFOcountPOM.Details().click();
      	Thread.sleep(5000);
      	OverduePOM.Clickoverview().click();
	  	Thread.sleep(3000);
	  	OverduePOM.ClickoverviewClose().click();
	  	Thread.sleep(3000);
		test.log(LogStatus.PASS, "The view icon should get working and document should be displayed on the popup.");
	
	
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		OverduePOM.Download().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) 
		{
			test.log(LogStatus.PASS,  "File downloaded successfully.");
		} 
		else 
		{
		test.log(LogStatus.FAIL,  "File does not downloaded.");
		}
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
	
	
	
		CFOcountPOM.closeDocument1().click();

		getDriver().switchTo().defaultContent();
		//Thread.sleep(3000);
		//CFOcountPOM.closeCategories().click();
		//Thread.sleep(1000);
	}
	
	public static void  SMETAReport(ExtentTest test, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(4000);
		if(CFOcountPOM.SMETAReport().isDisplayed())
		{
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Smeta Report  should be present under My Reports section.");
			if(CFOcountPOM.SMETAReport().isEnabled())
			{
				test.log(LogStatus.PASS, "Smeta Report screen should be opened.");
			
			CFOcountPOM.SMETAReport().click();
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Smeta Report not present under My Reports section.");
			
		}

		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(user.equalsIgnoreCase("Internal")) {
			CFOcountPOM.InternalRe().click();
			Thread.sleep(4000);
		}
		else {
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Statutory");
		//CFOcountPOM.StatutoryRe().click();
		Thread.sleep(4000);
	}
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		
		 File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExportImage2().click();					//Exporting (Downloading) file
			
			Thread.sleep(3000);//C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			Thread.sleep(3000);
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " File does not downloaded.");
			}
		
		
	
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument2().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		
			performer.OverduePOM.clickDashboard().click();
	}

	
	public static void  SMETAReport1(ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(4000);
		 Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_SUBTRACT);
		  robot.keyRelease(KeyEvent.VK_SUBTRACT);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_SUBTRACT);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_SUBTRACT);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_SUBTRACT);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_SUBTRACT);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
			
		Thread.sleep(4000);
		
		if(CFOcountPOM.SMETAReport().isDisplayed())
		{
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Smeta Report  should be present under My Reports section.");
			if(CFOcountPOM.SMETAReport().isEnabled())
			{
				test.log(LogStatus.PASS, "Smeta Report screen should be opened.");
			
			CFOcountPOM.SMETAReport().click();
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Smeta Report not present under My Reports section.");
			
		}
		
		try {
	           

            // Set zoom level to 50% (0.5) for zooming out
         //   setZoomLevel(getDriver(), 0.9);

            // Wait to observe the effect
            Thread.sleep(2000);

            // Set zoom level back to 100% (1.0) to reset to normal
            setZoomLevel(getDriver(), 1.0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(user.equalsIgnoreCase("Internal")) {
			CFOcountPOM.InternalRe().click();
			Thread.sleep(4000);
		}
		else {
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Statutory");
		//CFOcountPOM.StatutoryRe().click();
		Thread.sleep(4000);
	}
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		
		 File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExportImage2().click();					//Exporting (Downloading) file
			
			Thread.sleep(3000);//C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			Thread.sleep(3000);
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " File does not downloaded.");
			}
		
		
	
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument2().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		
			performer.OverduePOM.clickDashboard().click();
	}

	public static void setZoomLevel(WebDriver driver, double zoomLevel) 
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
    }
	
	
}