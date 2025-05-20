
package performer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import approval.ApprovalcountPOM;
import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtSonyMethod;
import companyadmin.CompanyPOM;
import implementation.ImplementPOM;
import login.BasePage;
import reviewer.ReviewerPOM;


public class MethodsPOM  extends BasePage
{
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	private static List<WebElement> checkboxesList = null;				//WebElement list created for selecting action button from multiple action buttons
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	 static String filePath ="E:\\AVACOM Project\\AvacomModified\\TestData\\ComplianceSheet.xlsx";
	public static void StatutoryCheckListMitigationP( ExtentTest test) throws InterruptedException, IOException
	{
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(40));
		Thread.sleep(3000);
	
		
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		OverduePOM.Reason().clear();
		Thread.sleep(500);
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		OverduePOM.Legal().clear();
		Thread.sleep(1000);
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().clear();
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		try {
		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
	//	OverduePOM.UploadFiles().sendKeys("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\Approver.html");
		Thread.sleep(1000);
		OverduePOM.submit().click();
		Thread.sleep(1000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Add - Message Displayed ; -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(4000);
	// Mitigation Plan - Upadate
	OverduePOM.clickMitigationPlanCheck().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
	OverduePOM.Reason().clear();
	Thread.sleep(1000);
	OverduePOM.Reason().sendKeys("Reason");
	Thread.sleep(1000);
	OverduePOM.submit().click();
	Thread.sleep(1000);
String msg1=	getDriver().switchTo().alert().getText();
Thread.sleep(1000);
getDriver().switchTo().alert().accept();
test.log(LogStatus.PASS, "Update - Message Displayed : -"+msg1);
Thread.sleep(4000);
getDriver().switchTo().parentFrame();
		
		
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void StatutoryCheckListMitigationPMul( ExtentTest test) throws InterruptedException, IOException
	{
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(40));
		Thread.sleep(3000);
	
		
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		OverduePOM.Reason().clear();
		Thread.sleep(500);
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		OverduePOM.Legal().clear();
		Thread.sleep(1000);
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().clear();
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		try {
		//OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		//Thread.sleep(1000);
		//OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(3000);
		}catch(Exception e) {
			
		}
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		OverduePOM.submit().click();
		Thread.sleep(1000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Add - Message Displayed ; -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(4000);
	
		
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void StatutoryCheckListMitigationPD( ExtentTest test) throws InterruptedException, IOException
	{
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(40));
		Thread.sleep(3000);
	
		
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		try {
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			}catch(Exception e) {
				test.log(LogStatus.FAIL, " :- No file Found");
			}
		
		getDriver().switchTo().parentFrame();
		Thread.sleep(4000);
		OverduePOM.CloseMpPopUp().click();
		Thread.sleep(4000);
	
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(4000);
	
		
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void StatutoryCheckListMitigationPView(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		try {
		
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found");
		}
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryCheckListMitigationPDe(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
	}
		
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryCheckListMitigationPDeWD(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
	}catch(Exception e) {
		
	}
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryCheckListMP(ExtentTest test) throws InterruptedException
	{
	
		WebDriverWait wait1 = new WebDriverWait(getDriver(),(60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		//litigationPerformer.MethodsPOM.progress();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(5000);
		
		OverduePOM.txtSearchComplianceID().sendKeys("151994");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		 Actions at = new Actions(getDriver());
		 at.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklistAction().get(0)));	//Waiting until all Action buttons get visible.
		Thread.sleep(4000);
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Statutory Checklist click
									//Clicking on Third Action button.
		
		Thread.sleep(1000);
		getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		try {
			String msg =OverduePOM.MsgText().getText();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Message Displayed :-" +msg);	
	}catch(Exception e) {
		test.log(LogStatus.PASS,"mitigation plan already updated ");	
	}
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		OverduePOM.CloseEdit().click();				//Clicking on Statutory overdue.
		Thread.sleep(2000);
		
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		Thread.sleep(3000);
	
		
	}
	
	
	public static void InternalCheckListMitigationP( ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		Thread.sleep(3000);
	
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);

		// Mitigation Plan - Add
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		OverduePOM.Reason().clear();
		Thread.sleep(1000);
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		OverduePOM.Legal().clear();
		Thread.sleep(1000);
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().clear();
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		try {
		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(1000);
	}catch(Exception e) {
		
	}
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Add - Message Displayed  : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	// Mitigation Plan - Upadate
	OverduePOM.clickMitigationPlanCheck().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
	OverduePOM.Reason().clear();
	Thread.sleep(1000);
	OverduePOM.Reason().sendKeys("Reason");
	Thread.sleep(1000);
	OverduePOM.submit().click();
	Thread.sleep(1000);
String msg1=	getDriver().switchTo().alert().getText();
Thread.sleep(1000);
getDriver().switchTo().alert().accept();
test.log(LogStatus.PASS, "Update - Message Displayed : -"+msg1);
Thread.sleep(4000);
getDriver().switchTo().parentFrame();
		
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void InternalCheckListMpMul( ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		Thread.sleep(3000);
	
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		OverduePOM.Reason().clear();
		Thread.sleep(1000);
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		OverduePOM.Legal().clear();
		Thread.sleep(1000);
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().clear();
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		try {
		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(1000);
		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(1000);
}catch(Exception e) {
			
		}
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Add - Message Displayed  : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
		
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void InternalCheckListMitigationPD( ExtentTest test) throws InterruptedException, IOException
	{
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(40));
		Thread.sleep(3000);
	
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		try {
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			}catch(Exception e) {
				test.log(LogStatus.FAIL, " :- No file Found");
			}
		
		getDriver().switchTo().parentFrame();
		Thread.sleep(4000);
		OverduePOM.CloseMpPopUp().click();
		Thread.sleep(4000);
	
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(4000);
	
		
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void InternalCheckListMitigationPView(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		try {
		
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found");
		}
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalCheckListMitigationPDe(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
	}
		
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalCheckListMitigationPDeWD(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		OverduePOM.clickMitigationPlanCheck().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
	}catch(Exception e) {
		
	}
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalCheckListMP(ExtentTest test) throws InterruptedException
	{
	
		WebDriverWait wait1 = new WebDriverWait(getDriver(),(60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(8000);
		//litigationPerformer.MethodsPOM.progress();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(5000);
		
		OverduePOM.txtSearchComplianceID().sendKeys("56637");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		 Actions at = new Actions(getDriver());
		 at.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklistAction().get(0)));	//Waiting until all Action buttons get visible.
		Thread.sleep(4000);
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Statutory Checklist click
									//Clicking on Third Action button.
		
		Thread.sleep(4000);
		getDriver().switchTo().frame("iInternalPerformerFrame");						//Switching 1st iFrame.
		try
		{
			String msg =OverduePOM.MsgText().getText();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Message Displayed :-" +msg);	
		}
		catch(Exception e) {
			test.log(LogStatus.PASS,"mitigation plan already updated ");	
		}
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		OverduePOM.CloseEditIn().click();				//Clicking on Statutory overdue.
		Thread.sleep(2000);
		
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		Thread.sleep(3000);
	
		
	}
	
	public static void InternalCheckListMitigationPFilter( ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		Thread.sleep(3000);
	
		
		OverduePOM.clickInternalChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		
		OverduePOM.MitigationPFilter().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdownlistMplan_listbox']/li[2]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			
			OverduePOM.Apply().click();
			Thread.sleep(4000);
			
			OverduePOM.Clicktri().click();
			Thread.sleep(1000);
			OverduePOM.Column().click();
			Thread.sleep(1000);
			OverduePOM.MitigationPlanCheck().click();
			Thread.sleep(1000);
			OverduePOM.Clicktri().click();
			Thread.sleep(3000);
			Thread.sleep(1000);
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[12]")); //column list
			 
			 List<String> text=new ArrayList<String>();
			 Thread.sleep(3000);
			 for(int i=0;i<Risks.size();i++) {
				 text.add(Risks.get(i).getText());
			 }
			 Thread.sleep(3000);
			 List<String> pass=new ArrayList<String>();
			 
			 List<String> fail=new ArrayList<String>();
				
				for(int i=0;i<text.size();i++)
				{
				if(text.get(i).equals("1")||text.get(i).equals(""))
				{
					pass.add(text.get(i));		//	the specified element at the end of a list.
				}
				else
				{
					fail.add(text.get(i));
				}
				
				Thread.sleep(3000);
	}
			 HashSet<String> pas=new LinkedHashSet<>(pass); //duplicate values are not allowed.
			 pass.clear();
			 pass.addAll(pas);                              //all of the elements in the specified collection to the end of this list,
			 
			 Thread.sleep(3000);
			 HashSet<String> fal=new LinkedHashSet<>(fail);
			 fail.clear();
			 fail.addAll(fal);
			 Thread.sleep(3000);
			 for(String Fal : fail)
			 {
				 test.log(LogStatus.FAIL, "Selection Pending Updation  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Selection Pending Updation  filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }

		
	
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void StatutoryCheckListMitigationPFilter( ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		Thread.sleep(3000);
	
		
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(4000);
		
		OverduePOM.MitigationPFilter().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@id='example']/div[2]/span[5]/span/span[1])")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			
			OverduePOM.Apply().click();
			Thread.sleep(4000);
			
			OverduePOM.Clicktri().click();
			Thread.sleep(1000);
			OverduePOM.Column().click();
			Thread.sleep(1000);
			OverduePOM.MitigationPlanCheck().click();
			Thread.sleep(1000);
			OverduePOM.Clicktri().click();
			Thread.sleep(3000);
			Thread.sleep(1000);
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[12]")); //column list
			 
			 List<String> text=new ArrayList<String>();
			 Thread.sleep(3000);
			 for(int i=0;i<Risks.size();i++) {
				 text.add(Risks.get(i).getText());
			 }
			 Thread.sleep(3000);
			 List<String> pass=new ArrayList<String>();
			 
			 List<String> fail=new ArrayList<String>();
				
				for(int i=0;i<text.size();i++)
				{
				if(text.get(i).equals("1"))
				{
					pass.add(text.get(i));		//	the specified element at the end of a list.
				}
				else
				{
					fail.add(text.get(i));
				}
				
				Thread.sleep(3000);
	}
			 HashSet<String> pas=new LinkedHashSet<>(pass); //duplicate values are not allowed.
			 pass.clear();
			 pass.addAll(pas);                              //all of the elements in the specified collection to the end of this list,
			 
			 Thread.sleep(3000);
			 HashSet<String> fal=new LinkedHashSet<>(fail);
			 fail.clear();
			 fail.addAll(fal);
			 Thread.sleep(3000);
			 if(fail.isEmpty()) {
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Selection Pending Updation  filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }
			 }
			 for(String Fal : fail)
			 {
				 if(Fal.isEmpty()) {
					 test.log(LogStatus.FAIL, "Status column have Empty value");
					 }else {
				 test.log(LogStatus.FAIL, "Selection Pending Updation  filter not working Properly : "+Fal);
				
					 }
			 }

		
	
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	public static void StatutoryOverdueMitigationPFilter( ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		Thread.sleep(3000);
	
		
		OverduePOM.clickStatutoryOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(8000);
		By locator = By.xpath("//*[@id='example']/div[2]/span[5]/span/span[2]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//OverduePOM.MitigationPFilter().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdownlistMplan_listbox']/li[2]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			
			OverduePOM.Apply().click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
			Thread.sleep(8000);
			
			OverduePOM.Clicktri().click();
			Thread.sleep(1000);
			OverduePOM.Column().click();
			Thread.sleep(1000);
			OverduePOM.MitigationPlanCheck1().click();
			Thread.sleep(1000);
			OverduePOM.Clicktri().click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
			Thread.sleep(8000);
			Thread.sleep(1000);
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[15]")); //column list
			 
			 List<String> text=new ArrayList<String>();
			 Thread.sleep(3000);
			 for(int i=0;i<Risks.size();i++) {
				 text.add(Risks.get(i).getText());
			 }
			 Thread.sleep(3000);
			 List<String> pass=new ArrayList<String>();
			 
			 List<String> fail=new ArrayList<String>();
				
				for(int i=0;i<text.size();i++)
				{
				if(text.get(i).equals("1"))
				{
					pass.add(text.get(i));		//	the specified element at the end of a list.
				}
				else
				{
					fail.add(text.get(i));
				}
				
				Thread.sleep(3000);
	}
			 HashSet<String> pas=new LinkedHashSet<>(pass); //duplicate values are not allowed.
			 pass.clear();
			 pass.addAll(pas);                              //all of the elements in the specified collection to the end of this list,
			 
			 Thread.sleep(3000);
			 HashSet<String> fal=new LinkedHashSet<>(fail);
			 fail.clear();
			 fail.addAll(fal);
			 Thread.sleep(3000);
			 if(fail.isEmpty()) 
			 {
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS, "Selection Pending Updation  filter working Properly   Value Match with : "+Pas);
					 // System.out.println("Pass : "+Pas);
				 }
			 }
			 for(String Fal : fail)
			 {
				 if(Fal.isEmpty()) {
					 test.log(LogStatus.FAIL, "Status column have Empty value");
					 }else {
				 test.log(LogStatus.FAIL, "Selection Pending Updation  filter not working Properly : "+Fal);
				
					 }
			 }

		
				Thread.sleep(4000);
				OverduePOM.clickDashboard().click();


	}
	
	public static void InternalOverdueMitigationPFilter( ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(1200));
		Thread.sleep(3000);
	
		
		OverduePOM.clickInternalOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(8000);
		
		By locator = By.xpath("//*[@id='example']/div[2]/span[5]/span/span[2]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdownlistMplan_listbox']/li[2]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			
			OverduePOM.Apply().click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
			Thread.sleep(8000);
			
			OverduePOM.Clicktri().click();
			Thread.sleep(1000);
			OverduePOM.Column().click();
			Thread.sleep(1000);
			OverduePOM.MitigationPlanCheck1().click();
			Thread.sleep(1000);
			OverduePOM.Clicktri().click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
			Thread.sleep(8000);
			Thread.sleep(1000);
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[14]")); //column list
			 
			 List<String> text=new ArrayList<String>();
			 Thread.sleep(3000);
			 for(int i=0;i<Risks.size();i++) {
				 text.add(Risks.get(i).getText());
			 }
			 Thread.sleep(3000);
			 List<String> pass=new ArrayList<String>();
			 
			 List<String> fail=new ArrayList<String>();
				
				for(int i=0;i<text.size();i++)
				{
					
				if(text.get(i).equals("1"))
				{
					pass.add(text.get(i));		//	the specified element at the end of a list.
				}
				else
				{
					fail.add(text.get(i));
						
				}
				
				Thread.sleep(3000);
	}
			 HashSet<String> pas=new LinkedHashSet<>(pass); //duplicate values are not allowed.
			 pass.clear();
			 pass.addAll(pas);                              //all of the elements in the specified collection to the end of this list,
			 
			 Thread.sleep(3000);
			 HashSet<String> fal=new LinkedHashSet<>(fail);
			 fail.clear();
			 fail.addAll(fal);
			 Thread.sleep(3000);
			 if(fail.isEmpty()) {
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Selection Pending Updation  filter working Properly   Value Match with : "+Pas);
				
			 }
			 }
			 for(String Fal : fail)
			 {
				 if(Fal.isEmpty()) {
					 test.log(LogStatus.FAIL, "Status column have Empty value");
					 
					 }else {
				 test.log(LogStatus.FAIL, "Selection Pending Updation  filter not working Properly : "+Fal);
				
					 }
			 }

		
	
	OverduePOM.clickDashboard().click();

	Thread.sleep(4000);
	}
	
	
	
	public static void StatutoryOverdueMitigationplan(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		OverduePOM.clickStatutoryOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		if(OverduePOM.clickMitigationPlan().isDisplayed()) {
		OverduePOM.clickMitigationPlan().click();
		test.log(LogStatus.PASS, "Mitigation Plan Button Is Displayed ");
		}
		
		// Mitigation Plan - Add
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		//Thread.sleep(2000);
		//OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(1000);
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed - Add : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	// Mitigation Plan - Upadate
/*	OverduePOM.clickMitigationPlan().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
	OverduePOM.Reason().clear();
	Thread.sleep(1000);
	OverduePOM.Reason().sendKeys("Reason");
	Thread.sleep(1000);
	OverduePOM.submit().click();
	Thread.sleep(1000);
String msg1=	getDriver().switchTo().alert().getText();
Thread.sleep(1000);
getDriver().switchTo().alert().accept();
test.log(LogStatus.PASS, "Update - Message Displayed ; -"+msg1);
Thread.sleep(4000);
getDriver().switchTo().parentFrame();
*/
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryOverdueMitigationplanMul(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		OverduePOM.clickStatutoryOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		
		
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
//		Thread.sleep(2000);
//		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
//		Thread.sleep(2000);
//		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(3000);
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed - Add : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryOverdueMitigationplanDDoc(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		OverduePOM.clickStatutoryOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		try {
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Dwounload().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " :- File downloaded successfully.");	
		}
		else
		{
			test.log(LogStatus.FAIL, " :- File does not downloaded.");
		}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found");
		}
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryOverdueMitigationplanView(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		OverduePOM.clickStatutoryOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		try {
		
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found");
		}
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryOverdueMitigationplanDe(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		OverduePOM.clickStatutoryOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		
		
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
	}
		
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryOverdueMitigationplanWD(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		OverduePOM.clickStatutoryOverdue().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		
		
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
	}catch(Exception e) {
		
	}
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void StatutoryOverdue( ) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		WebDriverWait wait1 = new WebDriverWait(getDriver(),(45));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)"," ");
		
		Thread.sleep(3000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
		elementsList = OverduePOM.ActionButtons();
		wait.until(ExpectedConditions.elementToBeClickable(elementsList.get(2)));
		Thread.sleep(3000);
		elementsList = OverduePOM.ActionButtons();
		elementsList.get(2).click();							//Clicking on Third Action button.
		
		Thread.sleep(1000);
		getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");				//Scrolling down window by 2000 px.
		try {
		Thread.sleep(500);
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadStatutory().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();	
		Thread.sleep(1000);//Click on the Date text box
		OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
		Thread.sleep(1000);
	//	OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		WebElement ele1 = null;
		WebElement ele2 = null;
		try
		{
			ele1 = OverduePOM.valueSystem();
			ele2 = OverduePOM.valueReturn();
		}
		catch(Exception e)
		{
			
		}
		
		if(ele1 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueSystem().sendKeys("100");					//Sending Value as per System textbox
		}
		if(ele2 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueReturn().sendKeys("50");					//Sending Value as per Return textbox
		}
		}catch(Exception e){
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
			Thread.sleep(3000);
			OverduePOM.fileUploadStatutory().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");
		}
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		try {
		Thread.sleep(3000);
		OverduePOM.clickComplianceSubmitAS().click();				//Click on Submit button.
		}catch(Exception e) {
			OverduePOM.clickComplianceSubmit().click();	
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
	/*	OverduePOM.clickAdvancedSearch().click();
		Thread.sleep(1000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid1']")));
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
	//	wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
		elementsList = OverduePOM.ActionButtons1();
		wait.until(ExpectedConditions.elementToBeClickable(elementsList.get(2)));
		Thread.sleep(3000);
		elementsList = OverduePOM.ActionButtons1();
		elementsList.get(2).click();							//Clicking on Third Action button.
		
		Thread.sleep(1000);
		.switchTo().frame("iPerformerFrame1");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,200)"," ");				//Scrolling down window by 2000 px.
		
		Thread.sleep(1000);
		Select status1 = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status1.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadStatutory().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		WebElement ele3 = null;
		WebElement ele4 = null;
		try
		{
			ele3 = OverduePOM.valueSystem();
			ele4 = OverduePOM.valueReturn();
		}
		catch(Exception e)
		{
			
		}
		
		if(ele3 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueSystem().sendKeys("100");					//Sending Value as per System textbox
		}
		if(ele4 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueReturn().sendKeys("50");					//Sending Value as per Return textbox
		}
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		
		Thread.sleep(3000);
		OverduePOM.clickComplianceSubmitAS().click();				//Click on Submit button.
		
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer1']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
		Thread.sleep(3000);*/
	}
	
	public static void StatutoryOverdueCri(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		WebDriverWait wait1 = new WebDriverWait(getDriver(),(60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_overdueStatutory = OverduePOM.clickStatutoryOverdue().getText();		//Storing old value of Statutory overdue.
		int	overdueStatutory = Integer.parseInt(string_overdueStatutory);
		String string_reviewStatutory = OverduePOM.readPendingReviewStatutory().getText();	//Storing old value of Pending Review.
		int	reviewStatutory = Integer.parseInt(string_reviewStatutory);
		
		OverduePOM.clickStatutoryOverdue().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		//litigationPerformer.MethodsPOM.progress();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,2000)"," ");
		
		Thread.sleep(5000);
		CFOcountPOM.readTotalItems4().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems4().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(compliancesCount);
		
		
		if(overdueStatutory == count)
		{
		
			test.log(LogStatus.PASS, "Before Perform :- Total Stautory 'Overdue' Compliance Count in the Grid = "+count+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		else
		{
			test.log(LogStatus.FAIL, "Before Perform :- Total  Stautory 'Overdue' Count in the Grid = "+count+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
	//	wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]")));
	//	elementsList = OverduePOM.ActionButtons();
	//	wait.until(ExpectedConditions.elementToBeClickable(elementsList.get(2)));
		Thread.sleep(3000);
		 Actions at = new Actions(getDriver());
		 at.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		elementsList = OverduePOM.ActionButtons();
		elementsList.get(2).click();							//Clicking on Third Action button.
		
		Thread.sleep(1000);
		getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");				//Scrolling down window by 2000 px.
		try {
		Thread.sleep(500);
	//	Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
	//	status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();	
		Thread.sleep(1000);//Click on the Date text box
		OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
		Thread.sleep(1000);
	//	OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		WebElement ele1 = null;
		WebElement ele2 = null;
		try
		{
			ele1 = OverduePOM.valueSystem();
			ele2 = OverduePOM.valueReturn();
		}
		catch(Exception e)
		{
			
		}
		
		if(ele1 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueSystem().sendKeys("100");					//Sending Value as per System textbox
		}
		if(ele2 != null)
		{
			Thread.sleep(500);
			OverduePOM.valueReturn().sendKeys("50");					//Sending Value as per Return textbox
		}
		}catch(Exception e){
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
			Thread.sleep(3000);
			OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");
		}
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		try {
		Thread.sleep(3000);
		OverduePOM.clickComplianceSubmitAS().click();				//Click on Submit button.
		}catch(Exception e) {
			OverduePOM.clickComplianceSubmit().click();	
			Thread.sleep(3000);
		}
		Thread.sleep(3000);
		getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickStatutoryOverdue()));
		
		String string_overdueStatutoryNew = OverduePOM.clickStatutoryOverdue().getText();		//Storing old value of Statutory overdue.
		int	newOverdueStatutory = Integer.parseInt(string_overdueStatutoryNew);
		String string_reviewStatutoryNew = OverduePOM.readPendingReviewStatutory().getText();	//Storing old value of Pending Review.
		int newReviewStatutory = Integer.parseInt(string_reviewStatutoryNew);
		
		if(overdueStatutory > newOverdueStatutory)
		{
			test.log(LogStatus.PASS, "After Perform :- Stautory 'Overdue' count decreased.");
			test.log(LogStatus.PASS, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
		}
		else
		{
			test.log(LogStatus.FAIL, "After Perform :- Stautory 'Overdue' count doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
		}
		
		if(newReviewStatutory > reviewStatutory)
		{
			test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
			test.log(LogStatus.PASS, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
		}
		else
		{
			test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
			test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
		}
	}
	
	public static void StatutoryOverdueMP(ExtentTest test) throws InterruptedException
	{
	
		WebDriverWait wait1 = new WebDriverWait(getDriver(),(60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickStatutoryOverdue().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		//litigationPerformer.MethodsPOM.progress();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(5000);
		
		OverduePOM.txtSearchComplianceID().sendKeys("83908");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		 Actions at = new Actions(getDriver());
		 at.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		elementsList = OverduePOM.ActionButtons();
		elementsList.get(2).click();							//Clicking on Third Action button.
		
		Thread.sleep(1000);
		getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		try 
		{
			String msg =OverduePOM.MsgText().getText();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Message Displayed :-" +msg);	
		
		}
		catch(Exception e) 
		{
			WebDriverWait wait = new WebDriverWait(getDriver(),(60));
			//test.log(LogStatus.PASS,"mitigation plan already updated ");
			Thread.sleep(3000);
			 //Actions at1 = new Actions(getDriver());
			 at.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(3000);
			elementsList = OverduePOM.ActionButtons();
			elementsList.get(2).click();							//Clicking on Third Action button.
			
			Thread.sleep(1000);
			getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,2000)"," ");				//Scrolling down window by 2000 px.
			try {
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
			status.selectByIndex(1);											//Selecting 2nd value from dropdown.
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
			Thread.sleep(3000);
			OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
			Thread.sleep(2000);
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();	
			Thread.sleep(1000);//Click on the Date text box
			OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
			Thread.sleep(1000);
		//	OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
			
			WebElement ele1 = null;
			WebElement ele2 = null;
			try
			{
				ele1 = OverduePOM.valueSystem();
				ele2 = OverduePOM.valueReturn();
			}
			catch(Exception e1)
			{
				
			}
			
			if(ele1 != null)
			{
				Thread.sleep(500);
				OverduePOM.valueSystem().sendKeys("100");					//Sending Value as per System textbox
			}
			if(ele2 != null)
			{
				Thread.sleep(500);
				OverduePOM.valueReturn().sendKeys("50");					//Sending Value as per Return textbox
			}
			}catch(Exception e2){
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				Thread.sleep(3000);
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");
			}
			Thread.sleep(500);
			OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
			try {
			Thread.sleep(3000);
			OverduePOM.clickComplianceSubmitAS().click();				//Click on Submit button.
			}catch(Exception e2) {
				OverduePOM.clickComplianceSubmit().click();	
				Thread.sleep(3000);
			}
			Thread.sleep(3000);
			getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
			Thread.sleep(5000);
			
			OverduePOM.clickDashboard().click();	
			}
		
//		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
//		Thread.sleep(5000);
//		OverduePOM.CloseEdit().click();				//Clicking on Statutory overdue.
		Thread.sleep(2000);
		
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		Thread.sleep(3000);
	
		
	}
	
	public static void StatutoryOverdueExport(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
			
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
				
		}
		else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		
	
	}
	
	public static void StatutoryCheckListExport(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
			
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn2().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " :- File downloaded successfully.");	
		}
		else
		{
			test.log(LogStatus.FAIL, " :- File does not downloaded.");
		}
		
		
	
	}
	
	public static void InternalOverdueMitigationplan(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		OverduePOM.clickInternalOverdue().click();		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(2000);
		
		OverduePOM.clickMitigationPlan().click();
		
		
		// Mitigation Plan - Add
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		OverduePOM.Reason().clear();
		Thread.sleep(1000);
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		OverduePOM.Legal().clear();
		Thread.sleep(1000);
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().clear();
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		//Thread.sleep(2000);
		//OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(1000);
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Add - Message Displayed  : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	// Mitigation Plan - Upadate
	OverduePOM.clickMitigationPlan().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
	OverduePOM.Reason().clear();
	Thread.sleep(1000);
	OverduePOM.Reason().sendKeys("Reason");
	Thread.sleep(1000);
	OverduePOM.submit().click();
	Thread.sleep(1000);
String msg1=	getDriver().switchTo().alert().getText();
Thread.sleep(1000);
getDriver().switchTo().alert().accept();
test.log(LogStatus.PASS, "Update - Message Displayed : -"+msg1);
Thread.sleep(4000);
getDriver().switchTo().parentFrame();

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalOverdueMitigationplanMul(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		OverduePOM.clickInternalOverdue().click();		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(2000);
		OverduePOM.UploadFiles().sendKeys("D:\\Automation File\\Charge.xlsx");
		Thread.sleep(3000);
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed - Add : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalOverdueMitigationplanDDoc(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		OverduePOM.clickInternalOverdue().click();		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		try {
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Dwounload().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " :- File downloaded successfully.");	
		}
		else
		{
			test.log(LogStatus.FAIL, " :- File does not downloaded.");
		}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found");
		}
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalOverdueMitigationplanView(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		OverduePOM.clickInternalOverdue().click();		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		try {
		
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found");
		}
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);
	
OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalOverdueMitigationplanDe(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		OverduePOM.clickInternalOverdue().click();		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		
		
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
	}
		
	getDriver().switchTo().parentFrame();
	Thread.sleep(4000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalOverdueMitigationplanWD(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		OverduePOM.clickInternalOverdue().click();		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(1000);
		
		OverduePOM.clickMitigationPlan().click();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Switching to iFrame.
		
		OverduePOM.Reason().sendKeys("Reason");
		Thread.sleep(1000);
		
		OverduePOM.Legal().sendKeys("Legal");
		Thread.sleep(1000);
		OverduePOM.RemediationSteps().sendKeys("Remediation Steps");
		Thread.sleep(1000);
		OverduePOM.Timeline().click();
		Thread.sleep(1000);
		OverduePOM.Date28().click();
		Thread.sleep(2000);
	try {
		OverduePOM.DeleteDoc().click();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
	}catch(Exception e) {
		
	}
		OverduePOM.submit().click();
		Thread.sleep(3000);
		
	String msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS, "Message Displayed : -"+msg);
	getDriver().switchTo().parentFrame();
	Thread.sleep(5000);
	OverduePOM.CloseMpPopUp().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
	Thread.sleep(1000);

OverduePOM.clickDashboard().click();

Thread.sleep(4000);
	}
	
	public static void InternalOverdueMP(ExtentTest test) throws InterruptedException
	{
	
		WebDriverWait wait1 = new WebDriverWait(getDriver(),(60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		OverduePOM.clickInternalOverdue().click();	
		Thread.sleep(8000);
		//litigationPerformer.MethodsPOM.progress();
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		Thread.sleep(5000);
		
		OverduePOM.txtSearchComplianceID().sendKeys("59476");				//Clicking on Statutory overdue.
		Thread.sleep(3000);
		OverduePOM.ClickApply().click();				//Clicking on Statutory overdue.
		Thread.sleep(8000);
		
		
		
		Thread.sleep(3000);
		 Actions at = new Actions(getDriver());
		 at.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		elementsList = OverduePOM.ActionButtons();
		elementsList.get(1).click();							//Clicking on Third Action button.
		
		
		Thread.sleep(1000);
		getDriver().switchTo().frame("iInternalPerformerFrame");						//Switching 1st iFrame.
		try {
			String msg =OverduePOM.MsgText1().getText();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Message Displayed :-" +msg);	
		
	}catch(Exception e) {
		test.log(LogStatus.PASS,"mitigation plan already updated ");	
	}
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		OverduePOM.CloseEditIn().click();				//Clicking on Statutory overdue.
		Thread.sleep(2000);
		
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		Thread.sleep(3000);
	
		
	}
	
	
	public static void InternalOverdue( ) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,1000)");
		
		
		//OverduePOM.loadNextPage().click();
		//OverduePOM.loadNextPage().click();
		//OverduePOM.loadNextPage().click();
		//OverduePOM.loadNextPage().click();						//Going to Page Index 5.
		
		elementsList = OverduePOM.clickActionButtonList();		//Getting all action buttons on the page.
		elementsList.get(1).click();	
		Thread.sleep(2000);
	//	wait.until(ExpectedConditions.elementToBeClickable)
	//	for (int i = 3; i < elementsList.size(); i++)					//Starting from the third button.
	//	{
			js.executeScript("window.scrollBy(0,1000)", "");				//Scrolling down window by 2000 px.
			
		//	wait.until(ExpectedConditions.visibilityOf(elementsList.get(i))).click();								//Clicking on the ith button
			Thread.sleep(500);
			getDriver().switchTo().frame("iInternalPerformerFrame");			//Switching to 1st iFrame.
			WebElement ele = null;
			try
			{
				ele = OverduePOM.msgCheck();						//Loaded message element in 'ele' variable. If element not found then it will do nothing.
			}															//Checking if the Compliance related task is done or not.
			catch(Exception e)
			{
				
			}
			if(ele!=null)												//If message found do the following.
			{
				getDriver().switchTo().parentFrame();						//Switching back to parent frame from iFrame
				OverduePOM.closeCompliance().click();				//Closing the compliance pop up as it has message.
				Thread.sleep(500);
			}			
			else														//We will proceed if the message not shown.
			{
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				
				Thread.sleep(500);
				Select status1 = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box.
				status1.selectByIndex(1);								//Selecting 2nd value from dropdown.
				
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				Thread.sleep(3000);
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLinkInternal().click();		//Clicking on 'Add Link' button of Compliance Documents
				
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				Thread.sleep(1000);
				OverduePOM.selectDateInternal().click();			//Clicking on the Date text box
				OverduePOM.selectLastMonth().click();				//Clicking to get last month
				Thread.sleep(1000);
				OverduePOM.selectDate().click(); 					//Selecting date - second row and fifth column date from calendar
				Thread.sleep(2000);
				
				try {
					Thread.sleep(500);
					OverduePOM.remark1().sendKeys("Automation Testing");
				
					}catch(Exception e) {
						
					}
				
				try {
					Thread.sleep(500);
					
					OverduePOM.clickComplianceSubmitAS().click();				//Click on Submit button.
					}catch(Exception e) {
						
						OverduePOM.clickComplianceSubmit2().click();	
						Thread.sleep(3000);
					}
				
				
				getDriver().switchTo().alert().accept();						//Accepting msg of Successful Submission.
				getDriver().switchTo().parentFrame();						//Switching back to parent frame from iFrame
			//	break;
			}
			Thread.sleep(1000);
		/*	OverduePOM.clickAdvancedSearch().click();
			Thread.sleep(4000);
			elementsList = OverduePOM.clickActionButtonList1();
			elementsList.get(2).click();
			Thread.sleep(4000);
			.switchTo().frame("iInternalPerformerFrame1");	
			js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			Select status1 = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box.
			status1.selectByIndex(1);								//Selecting 2nd value from dropdown.
			
			js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
			Thread.sleep(3000);
			OverduePOM.fileUploadInternal().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
		//	OverduePOM.buttonAddLinkInternal().click();		//Clicking on 'Add Link' button of Compliance Documents
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
			Thread.sleep(1000);
			OverduePOM.selectDateInternal().click();			//Clicking on the Date text box
			OverduePOM.selectLastMonth().click();				//Clicking to get last month
			Thread.sleep(1000);
			OverduePOM.selectDate().click(); 					//Selecting date - second row and fifth column date from calendar
			
			Thread.sleep(500);
			OverduePOM.clickComplianceSubmit().click();
			
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();						//Accepting msg of Successful Submission.
			getDriver().switchTo().parentFrame();
		
			Thread.sleep(4000);
			getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer1']/div/div/div[1]/button")).click();
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
			Thread.sleep(3000);*/
		/*	if(i==elementsList.size())
			{
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				Thread.sleep(500);
				OverduePOM.loadNextPage().click();				//Clicking on next page indicator 'Arrow'
				Thread.sleep(500);
				elementsList = OverduePOM.clickActionButtonList();	//Re-assigning list of action buttons to variable
			}*/
	//	}
	}
	
	public static void InternalOverdueCri(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		Thread.sleep(1000);
		String string_internalOverdue = OverduePOM.clickInternalOverdue().getText();		//Storing old value of Statutory overdue.
		int overdueInternal = Integer.parseInt(string_internalOverdue);
		String string_internalReview = OverduePOM.readPendingReviewInternal().getText();	//Storing old value of Pending Review.
		int reviewInternal = Integer.parseInt(string_internalReview);
		
		OverduePOM.clickInternalOverdue().click();				//Clicking on Internal Overdue value.
		
		Thread.sleep(5000);
		//litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);	
		CFOcountPOM.readTotalItems4().click();
		Thread.sleep(500);
		String item1 = CFOcountPOM.readTotalItems4().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length-2];				//Getting the second last word (total number of users)
		Integer count1 = Integer.parseInt(compliancesCount1);
		if(overdueInternal == count1)
		{
		
			test.log(LogStatus.PASS, "Before Perform :- Total 'Overdue' Internal Compliance Count in the Grid = "+count1+" | Dashboard 'Overdue' Internal Compliance Count = "+overdueInternal);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Before Perform :- Upcoming Internal count does not matches to total number of compliances displayed.");
			test.log(LogStatus.FAIL, "Before Perform :- Total 'Overdue' Internal Compliance Count in the Grid = "+count1+" | Dashboard 'Overdue' Internal Compliance Count = "+overdueInternal);
		}
		
		 Actions at = new Actions(getDriver());
		 at.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(5000);
		elementsList = OverduePOM.clickActionButtonList();		//Getting all action buttons on the page.
		elementsList.get(0).click();	
		Thread.sleep(2000);
	//	wait.until(ExpectedConditions.elementToBeClickable)
	//	for (int i = 3; i < elementsList.size(); i++)					//Starting from the third button.
	//	{
			js.executeScript("window.scrollBy(0,1000)", "");				//Scrolling down window by 2000 px.
			
		//	wait.until(ExpectedConditions.visibilityOf(elementsList.get(i))).click();								//Clicking on the ith button
			Thread.sleep(500);
			getDriver().switchTo().frame("iInternalPerformerFrame");			//Switching to 1st iFrame.
			WebElement ele = null;
			try
			{
				ele = OverduePOM.msgCheck();						//Loaded message element in 'ele' variable. If element not found then it will do nothing.
			}															//Checking if the Compliance related task is done or not.
			catch(Exception e)
			{
				
			}
			/*if(ele!=null)												//If message found do the following.
			{
				getDriver().switchTo().parentFrame();						//Switching back to parent frame from iFrame
				OverduePOM.closeCompliance().click();				//Closing the compliance pop up as it has message.
				Thread.sleep(500);
			}			
			else														//We will proceed if the message not shown.
			{*/
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				try {
					if(OverduePOM.text1().isDisplayed()) {
						getDriver().switchTo().parentFrame();
						OverduePOM.close().click();	
						elementsList1 = OverduePOM.clickActionButtonList();	//Getting all action buttons (Statutory/Internal)
						elementsList1.get(1).click();					//Clicking on ith action button which has blue status 
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
						Thread.sleep(500);
						js.executeScript("window.scrollBy(0,550)");	
				Thread.sleep(500);
					}
				}catch(Exception e) {
					
				}
				try {
				Select status1 = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box.
				status1.selectByIndex(1);								//Selecting 2nd value from dropdown.
				}catch(Exception e) {
					
				}
				
				js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				Thread.sleep(3000);
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLinkInternal().click();		//Clicking on 'Add Link' button of Compliance Documents
				
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,2500)"," ");		//Scrolling down window by 2000 px.
				
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateInternal()));
				Thread.sleep(1000);
				OverduePOM.selectDateInternal().click();			//Clicking on the Date text box
				//Thread.sleep(1000);
				//OverduePOM.selectLastMonth().click();				//Clicking to get last month
				Thread.sleep(1000);
				OverduePOM.selectDate4().click(); 					//Selecting date - second row and fifth column date from calendar
				
				Thread.sleep(2000);
				
				try {
					Thread.sleep(500);
					OverduePOM.remark1().sendKeys("Automation Testing");
				
					}catch(Exception e) {
						
					}
				
				try {
					Thread.sleep(500);
					
					OverduePOM.clickComplianceSubmitAS().click();				//Click on Submit button.
					}catch(Exception e) {
						
						OverduePOM.clickComplianceSubmit2().click();	
						Thread.sleep(3000);
					}
				
				
				getDriver().switchTo().alert().accept();						//Accepting msg of Successful Submission.
				getDriver().switchTo().parentFrame();						//Switching back to parent frame from iFrame
			//	break;
			//}
			Thread.sleep(1000);
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
			
			String string_newInternalOverdue = OverduePOM.clickInternalOverdue().getText();		//Storing old value of Statutory overdue.
		int	newOverdueInternal = Integer.parseInt(string_newInternalOverdue);
			String string_newInternalReview = OverduePOM.readPendingReviewInternal().getText();	//Storing old value of Pending Review.
		int	newReviewInternal = Integer.parseInt(string_newInternalReview);
		
		if(overdueInternal > newOverdueInternal)
		{
			test.log(LogStatus.PASS, "After Perform :- 'Overdue' Internal count decreased.");
			test.log(LogStatus.PASS, "Old Compliance Count = "+overdueInternal+" | New Compliance Count = "+newOverdueInternal);
		}
		else
		{
			test.log(LogStatus.FAIL, "After Perform :- 'Overdue' Internal count doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Compliance Count = "+overdueInternal+" | New Compliance Count = "+newOverdueInternal);
		}
		
		if(newReviewInternal > reviewInternal)
		{
			test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Internal count increased.");
			test.log(LogStatus.PASS, "Old Compliance Count = "+reviewInternal+" | New Compliance Count = "+newReviewInternal);
		}
		else
		{
			test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Internal count doesn't increased.");
			test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewInternal+" | New Compliance Count = "+newReviewInternal);
		}
		
	}
	
	
	static void CheckList( String action) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		//div[@class = 'k-multiselect-wrap k-floatwrap']
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(3000);
	//	js.executeScript("window.scrollBy(0,4000)");			//Sometimes it doesn't scrolls down so extra query added.
		
		//getDriver().findElement(By.xpath("//div[@class = 'k-multiselect-wrap k-floatwrap']")).click();
		Thread.sleep(5000);
		//getDriver().findElement(By.xpath("//div[@class='k-grouping-header']")).click();
	//	OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
	//	OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickCheckboxesList().get(0)));
		//checkboxesList =OverduePOM.clickCheckboxesList();		//Getting multiple check boxes
		OverduePOM.clickCheckboxesList().get(1).click();
		OverduePOM.clickCheckboxesList().get(2).click();									//Clicking on 2,3 check box
		
		if(action.equalsIgnoreCase("submit"))
		{
			Thread.sleep(1000);
			OverduePOM.clickSubmit().click();						//Clicking on 'Submit' button on top.
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();							//Clicking on alert to accept the message.
		}else
		if(action.equalsIgnoreCase("ClosedDelayed"))
		{
			Thread.sleep(1000);
			OverduePOM.ClickClosedDelayed().click();						//Clicking on 'Submit' button on top.
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();							//Clicking on alert to accept the message.
		}
		else
		{
			Thread.sleep(1000);
			OverduePOM.clickCheckboxesNotApplicable().click();	//Clicking on 'Not Applicable' button on top.
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();							//Clicking on alert to accept the message.
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();						//Clicking on dashboard.
		Thread.sleep(2000);
	}
	
	static void Action( String action, String frame) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(5000);
	//	js.executeScript("window.scrollBy(0,4000)");			//Sometimes it doesn't scrolls down so extra query added.
		
		/*getDriver().findElement(By.xpath("//div[@class = 'k-multiselect-wrap k-floatwrap']")).click();
		Thread.sleep(500);
		//div[@class = 'k-multiselect-wrap k-floatwrap']
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		*/
	//	CFOcountPOM.clickNextPage1().sendKeys(Keys.DOWN);
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklistAction().get(0)));	//Waiting until all Action buttons get visible.
		Thread.sleep(4000);
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Statutory Checklist click
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));	//Switching to iFrame
		js.executeScript("window.scrollBy(0,1500)");
		
		if(action.equalsIgnoreCase("submit")||action.equalsIgnoreCase("Closed Delayed"))
		{
			Thread.sleep(500);
			OverduePOM.clickDateChecklist().click();
			
			Thread.sleep(500);
			OverduePOM.selectDateChecklist().click();
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
			OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//	OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,1500)"," ");				//Scrolling down window by 2000 px.
			OverduePOM.remark().sendKeys("Automation Testing");
			Thread.sleep(2000);
			if(action.equalsIgnoreCase("submit")){
				Thread.sleep(2000);
			OverduePOM.clickComplianceSubmit3().click();				//Clicking on 'Submit' button.
			//getDriver().findElement(By.xpath("//*[@id='btnSave']")).click();
		//	getDriver().switchTo().alert().accept();
			}else
				if(action.equalsIgnoreCase("Closed Delayed")) {
					Thread.sleep(2000);
					OverduePOM.clickClosedDelayed().click();	  //Clicking on 'Closed Delayed' button.
				//	getDriver().switchTo().alert().accept();
					Thread.sleep(1000);
				}
			//getDriver().switchTo().alert().accept();
			try
			{
				Thread.sleep(1000);
				getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				OverduePOM.clickClose().click();
				Thread.sleep(1000);
			}
			getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		}
		else
		{
			Thread.sleep(2000);
			OverduePOM.clickActionNotApplicable().click();		//Clicking on 'Not Applicable' button.
			
			Thread.sleep(500);
			getDriver().switchTo().alert().dismiss();				//Clicking on OK of alert.
			getDriver().switchTo().parentFrame();						//Switching back to parent frame.
		}
	/*	Thread.sleep(4000);
		OverduePOM.clickAdvancedSearch().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklistAction1().get(0)));	//Waiting until all Action buttons get visible.
		Thread.sleep(2000);
		OverduePOM.clickStatutoryChecklistAction1().get(1).click();	//Clicking on first Action button inside Statutory Checklist click
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));	//Switching to iFrame
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
		OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1500)"," ");				//Scrolling down window by 2000 px.
		OverduePOM.remark().sendKeys("Automation Testing");
		Thread.sleep(500);
	//	OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.
	//	getDriver().findElement(By.xpath("//*[@id='btnSave']")).click();
		if(action.equalsIgnoreCase("submit")){
			
			OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.
			
			}else
				if(action.equalsIgnoreCase("Closed Delayed")) {
					OverduePOM.clickClosedDelayed().click();	  //Clicking on 'Closed Delayed' button.
				}Thread.sleep(1000);
		//getDriver().switchTo().alert().accept();
		try
		{
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
		}
		catch(Exception e)
		{
			OverduePOM.clickClose().click();
			Thread.sleep(4000);
		}
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
		Thread.sleep(4000);
		
	/*	By locator = By.xpath("//*[@id='sel_chkbx']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		List<WebElement> ViewButton = getDriver().findElements(locator);	
		Thread.sleep(3000);
		ViewButton.get(0).click();
		Thread.sleep(1000);
		ViewButton.get(1).click();
		Thread.sleep(1000);
		ViewButton.get(2).click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//*[@id='dvbtnSubmit']")).click();
		Thread.sleep(3000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//*[@id='CheckListrpt']")).click();
		
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lbtnExportExcel']")).click();
		Thread.sleep(4000);*/
	//	OverduePOM.clickDashboard().click();						//Clicking on Dashboard.
	}
	
	static void ActionCri( String action, String frame) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklistAction().get(0)));	//Waiting until all Action buttons get visible.
		Thread.sleep(4000);
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Statutory Checklist click
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));	//Switching to iFrame
		js.executeScript("window.scrollBy(0,1500)");
		
		if(action.equalsIgnoreCase("submit")||action.equalsIgnoreCase("Closed Delayed"))
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
			OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//	OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
			
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,200)"," ");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutoryChecklist()));
			OverduePOM.selectDateStatutoryChecklist().click();	
			Thread.sleep(1000);//Click on the Date text box
			OverduePOM.selectDate4().click();						//Clicking to get last month
			
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,1500)"," ");				//Scrolling down window by 2000 px.
			OverduePOM.remark().sendKeys("Automation Testing");
			Thread.sleep(2000);
			OverduePOM.clickClosedDelayed().click();	  //Clicking on 'Closed Delayed' button.
			
			Thread.sleep(8000);
//			if(action.equalsIgnoreCase("submit"))
//			{
//				Thread.sleep(2000);
//				OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.
//			//getDriver().findElement(By.xpath("//*[@id='btnSave']")).click();
//		//	getDriver().switchTo().alert().accept();
//			}
//			else
//				if(action.equalsIgnoreCase("Closed Delayed")) 
//				{
//					Thread.sleep(2000);
//					OverduePOM.clickClosedDelayed().click();	  //Clicking on 'Closed Delayed' button.
//				//	getDriver().switchTo().alert().accept();
//					Thread.sleep(1000);
//				}
			//getDriver().switchTo().alert().accept();
			try
			{
				Thread.sleep(3000);
				getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				Thread.sleep(3000);
				OverduePOM.clickClose().click();
				Thread.sleep(1000);
			}
			getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		}
//		else
//		{
//			Thread.sleep(2000);
//			OverduePOM.clickActionNotApplicable().click();		//Clicking on 'Not Applicable' button.
//			
//			Thread.sleep(500);
//			getDriver().switchTo().alert().dismiss();				//Clicking on OK of alert.
//			getDriver().switchTo().parentFrame();						//Switching back to parent frame.
//		}
		Thread.sleep(4000);
	
	//	OverduePOM.clickDashboard().click();						//Clicking on Dashboard.
	}
	
	
	public static void StatutoryCheckListCBNotComplied( ExtentTest test) throws InterruptedException, IOException
	{
		//-----------------------------Closed Timely after multiple checkbox click--------------------
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		OverduePOM.clickStatutoryChecklist().click();	
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,4000)");
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];	
		//int	count = Integer.parseInt(itomsCount);
		Thread.sleep(2000);
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItemsD().getText();
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
		
		js.executeScript("window.scrollBy(0,-4000)");
		
		OverduePOM.clickCheckboxesList().get(1).click();
		Thread.sleep(2000);
		OverduePOM.NotComplied().click();
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,4000)");
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s2 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits1 = s2.split(" ");									//Splitting the String
		String itomsCount1 = bits1[bits1.length - 2];	
		int	count1 = Integer.parseInt(itomsCount1);
		
		if(count>count1) {
			test.log(LogStatus.PASS, "Checkbox 'Not Complied' - Statutory 'Checklist' value decremented. Old value = " +count +" | New Value = "+ count1);	
		}else {
			
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		OverduePOM.clickDashboard().click();						//Click on Dashboard
		Thread.sleep(2000);
	}

	public static void StatutoryCheckListCheckbox( ExtentTest test) throws InterruptedException, IOException
	{
		//-----------------------------Closed Timely after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
		Thread.sleep(500);
		
		CheckList( "Submit");									//Will click on 'Submit' button
		
		
		
		Thread.sleep(1000);
		int newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Closed Timely' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
	//-----------------------------Closed Delayed after multiple checkbox click--------------------
		
		Thread.sleep(1000);
	  oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
		Thread.sleep(500);
		
		CheckList( "Closed Delayed");									//Will click on 'Submit' button
		
		Thread.sleep(1000);
	 newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Closed Delayed' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
	/*	//--------------------------------Not Applicable after multiple checkbox click--------------------not count in mannual
		
		Thread.sleep(1000);
		oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
		CheckList(, "Not Applicable");							//Will click on 'Not Applicable' button
		
		Thread.sleep(1000);
		newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Not Applicable' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}*/
	}
	
	public static void StatutoryCheckListCheckboxCri( ExtentTest test) throws InterruptedException, IOException
	{
		//-----------------------------Closed Timely after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
		Thread.sleep(3000);
		
		CheckList( "Submit");									//Will click on 'Submit' button
		
		Thread.sleep(1000);
		int newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "while select Multiple Checkbox : click On'Closed Timely' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
	
	}
	
	
	public static void StatutoryCheckListAction( ExtentTest test) throws InterruptedException, IOException
	{
		
		//---------------------------Submit after Action button click--------------------------
		
		Thread.sleep(1000);
		int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		Thread.sleep(4000);
		Action( "Submit", "iPerformerFrame");					//Will click on 'Action' button
		Thread.sleep(3000);
		MethodsPOM.StatutoryCheckListExport(test,workbook);	
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();						//Click on Dashboard
		Thread.sleep(4000);
		Thread.sleep(1000);
		int newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
		
			test.log(LogStatus.PASS, "Action 'Submit' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//--------------------------------Closed Delayed after Action button click--------------------------
			
				Thread.sleep(1000);
				oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
				
				OverduePOM.clickStatutoryChecklist().click();									//Clicking on Statutory Checklist value
				Thread.sleep(4000);
				Action( "Closed Delayed", "iPerformerFrame");								//Will click on 'Not Applicable' button
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();						//Click on Dashboard
				Thread.sleep(2000);
				Thread.sleep(1000);
				newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
				
				if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
				{
					test.log(LogStatus.PASS, "Action 'Closed Delayed - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Test Failed.");
				}
		
		
		
		//--------------------------------Not Applicable after Action button click--------------------------
		/*
		Thread.sleep(1000);
		oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();									//Clicking on Statutory Checklist value
		
		Action(, "Not Applicable", "iPerformerFrame");								//Will click on 'Not Applicable' button
		
		Thread.sleep(1000);
		newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Not Applicable' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		*/
	}
	
	public static void StatutoryCheckListActionCri( ExtentTest test) throws InterruptedException, IOException
	{
		
		//---------------------------Submit after Action button click--------------------------
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(1000);
		int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		
//		Thread.sleep(3000);
//		 Actions at = new Actions(getDriver());
//		 at.sendKeys(Keys.PAGE_UP).build().perform();
//		Thread.sleep(3000);
//		elementsList = OverduePOM.clickStatutoryChecklistAction();
//		Thread.sleep(300);
//		elementsList.get(1).click();							//Clicking on Third Action button.
//		
//		
//		Thread.sleep(1000);
//		getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
//		
//		Thread.sleep(500);
//		js.executeScript("window.scrollBy(0,2000)"," ");				//Scrolling down window by 2000 px.
		
		Thread.sleep(5000);
		ActionCri( "Submit", "iPerformerFrame");					//Will click on 'Action' button
		
//		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutoryChecklist()));
//		OverduePOM.selectDateStatutoryChecklist().click();	
//		Thread.sleep(1000);//Click on the Date text box
//		OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
		
		
//		Thread.sleep(500);
//		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		
		//Thread.sleep(5000);
	//	ActionCri( "Submit", "iPerformerFrame");					//Will click on 'Action' button
		Thread.sleep(3000);
	
		OverduePOM.clickDashboard().click();						//Click on Dashboard
		Thread.sleep(4000);
		Thread.sleep(1000);
		int newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
		
			test.log(LogStatus.PASS, "Action ' Closed Timely' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//--------------------------------Closed Delayed after Action button click--------------------------
	/*		
				Thread.sleep(1000);
				oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
				
				OverduePOM.clickStatutoryChecklist().click();									//Clicking on Statutory Checklist value
				Thread.sleep(4000);
				Action(, "Closed Delayed", "iPerformerFrame");								//Will click on 'Not Applicable' button
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();						//Click on Dashboard
				Thread.sleep(2000);
				Thread.sleep(1000);
				newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
				
				if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
				{
					test.log(LogStatus.PASS, "Action 'Closed Delayed - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Test Failed.");
				}
		
		
		
		//--------------------------------Not Applicable after Action button click--------------------------
		/*
		Thread.sleep(1000);
		oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		OverduePOM.clickStatutoryChecklist().click();									//Clicking on Statutory Checklist value
		
		Action(, "Not Applicable", "iPerformerFrame");								//Will click on 'Not Applicable' button
		
		Thread.sleep(1000);
		newStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
		
		if(newStatutoryChecklistValue < oldStatutoryChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Not Applicable' - Statutory 'Checklist' value decremented. Old value = " +oldStatutoryChecklistValue +" | New Value = "+ newStatutoryChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		*/
	}
	
	
	
	public static void InternalCheckListCheckbox( ExtentTest test) throws InterruptedException
	{
		//-----------------------------Closed Timely after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		int oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Internal Checkilist.
		OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist value.
		
		CheckList( "Submit");									//Will click on 'Submit' button
		
		Thread.sleep(1000);
		int newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing new value of Internal Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Closed Timely' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" | New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//-----------------------------Closed Delayed after multiple checkbox click--------------------
		
				Thread.sleep(1000);
				 oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Internal Checkilist.
				OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist value.
				
				CheckList( "Closed Delayed");									//Will click on 'Submit' button
				
				Thread.sleep(1000);
				 newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing new value of Internal Checkilist.
				
				if(newInternalChecklistValue < oldInternalChecklistValue)
				{
					test.log(LogStatus.PASS, "Checkbox 'Closed Delayed' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" | New Value = "+ newInternalChecklistValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Test Failed.");
				}
		
	/*	//--------------------------------Not Applicable after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Internal Checkilist.
		OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist value.
		
		CheckList(, "Not Applicable");							//Will click on 'Not Applicable' button
		
		Thread.sleep(1000);
		newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing new value of Internal Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Checkbox 'Not Applicable' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" | New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		*/
	}
	
	public static void InternalCheckListCheckboxCri( ExtentTest test) throws InterruptedException
	{
		//-----------------------------Closed Timely after multiple checkbox click--------------------
		
		Thread.sleep(1000);
		int oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Internal Checkilist.
		OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist value.
		
		CheckList( "Submit");									//Will click on 'Submit' button
		
		Thread.sleep(1000);
		int newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing new value of Internal Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "While select Multiple Checkbox and click On 'Closed Timely' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" | New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		
	}
	
	
	public static void InternalCheckListAction( ExtentTest test) throws InterruptedException, IOException
	{
		//--------------------------------Submit after Action button click------------------------------
		
		Thread.sleep(1000);
		int oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());		//Storing old value of Internal Checkilist.
		
		OverduePOM.clickInternalChecklist().click();					//Clicking on Internal Checklist Value
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction().get(0)));	//Waiting until all Action buttons get visible.
		Thread.sleep(3000);
		OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
		OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
		OverduePOM.remark().sendKeys("Automation Testing");
		Thread.sleep(500);
		//OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.	
		getDriver().findElement(By.xpath("//*[@id='btnSave2']")).click();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();								//Clicking on alert to accept the message.
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		/*Thread.sleep(2000);
		OverduePOM.clickAdvancedSearch().click();
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']"))); //Waiting until grid/kendo gets visible.
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction1().get(0)));	//Waiting until all Action buttons get visible.
		OverduePOM.clickStatutoryChecklistAction1().get(0).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
		OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
		OverduePOM.remark().sendKeys("Automation Testing");
		Thread.sleep(500);
		//OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.	
		getDriver().findElement(By.xpath("//*[@id='btnSave2']")).click();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();								//Clicking on alert to accept the message.
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(2000);
		//getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
		Thread.sleep(4000);
	/*	By locator = By.xpath("//*[@id='sel_chkbx']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		List<WebElement> ViewButton = getDriver().findElements(locator);	
		Thread.sleep(3000);
		ViewButton.get(0).click();
		Thread.sleep(1000);
		ViewButton.get(1).click();
		Thread.sleep(1000);
		ViewButton.get(2).click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//*[@id='dvbtnSubmit']")).click();
		Thread.sleep(3000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//*[@id='CheckListrpt']")).click();
		
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lbtnExportExcel']")).click();
		Thread.sleep(4000);*/
		
		Thread.sleep(2000);
		MethodsPOM.StatutoryCheckListExport(test,workbook);	
		Thread.sleep(500);
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();						//Click on Dashboard
		Thread.sleep(4000);
		int newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Submit' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
		//--------------------------------Closed Delayed after Action button click------------------------------
		
				Thread.sleep(3000);
				 oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());		//Storing old value of Internal Checkilist.
				
				OverduePOM.clickInternalChecklist().click();					//Clicking on Internal Checklist Value
				
				//WebDriverWait wait = new WebDriverWait(getDriver(), (30));
			//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				
				Thread.sleep(4000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
				
				Thread.sleep(3000);
			//	js.executeScript("window.scrollBy(0,2000)");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction().get(0)));	//Waiting until all Action buttons get visible.
				OverduePOM.clickStatutoryChecklistAction().get(0).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,2000)");
				
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
				//OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
				OverduePOM.remark().sendKeys("Automation Testing");
				Thread.sleep(500);
				//OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.	
				getDriver().findElement(By.xpath("//*[@id='btnClosedDelayed']")).click();
				Thread.sleep(3000);
				try {
					Thread.sleep(1000);
					getDriver().switchTo().alert().accept();	
				}catch(Exception e) {
					OverduePOM.clickClose2().click();
					Thread.sleep(4000);
				}
											//Clicking on alert to accept the message.
				getDriver().switchTo().parentFrame();								//Switching back to parent frame.
				Thread.sleep(2000);
				OverduePOM.clickAdvancedSearch().click();
				Thread.sleep(4000);
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']"))); //Waiting until grid/kendo gets visible.
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction1().get(0)));	//Waiting until all Action buttons get visible.
				OverduePOM.clickStatutoryChecklistAction1().get(0).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
				
				Thread.sleep(500);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,2000)");
				
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
				//OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
				OverduePOM.remark().sendKeys("Automation Testing");
				Thread.sleep(500);
				//OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.	
				getDriver().findElement(By.xpath("//*[@id='btnClosedDelayed']")).click();
				Thread.sleep(1000);
				try {
				getDriver().switchTo().alert().accept();								//Clicking on alert to accept the message.
				}catch(Exception e) {
					OverduePOM.clickClose2().click();
					Thread.sleep(4000);
				}
				getDriver().switchTo().parentFrame();								//Switching back to parent frame.
				Thread.sleep(2000);
				getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
				Thread.sleep(4000);
			
				Thread.sleep(2000);
				OverduePOM.clickDashboard().click();						//Click on Dashboard
				Thread.sleep(4000);
				 newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Statutory Checkilist.
				
				if(newInternalChecklistValue < oldInternalChecklistValue)
				{
					test.log(LogStatus.PASS, "Action 'Closed Delayed' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" New Value = "+ newInternalChecklistValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Test Failed.");
				}
				Thread.sleep(4000);
				
		/*
		//--------------------------------Not Applicable after Action button click--------------------------
		
		Thread.sleep(2000);
		oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());		//Storing old value of Internal Checkilist.
		OverduePOM.clickInternalChecklist().click();				//Clicking on Internal Checklist Value
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		
		Thread.sleep(4000);
		//js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction()));	//Waiting until all Action buttons get visible.
		Thread.sleep(3000);
		OverduePOM.clickStatutoryChecklistAction().get(1).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(4000);
		OverduePOM.clickActionNotApplicable().click();			//Clicking on 'Not Applicable' button
		Thread.sleep(3000);
		try
		{
			Thread.sleep(2000);
			getDriver().switchTo().alert().dismiss();						//Clicking on OK of alert.
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(2000);
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard
		Thread.sleep(2000);
		Thread.sleep(2000);
		newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Action 'Not Applicable' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}*/
	}
	
	public static void InternalCheckListActionCri( ExtentTest test) throws InterruptedException, IOException
	{
		//--------------------------------Submit after Action button click------------------------------
		
		Thread.sleep(1000);
		int oldInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());		//Storing old value of Internal Checkilist.
		
		OverduePOM.clickInternalChecklist().click();					//Clicking on Internal Checklist Value
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']/div[4]"))); //Waiting until grid/kendo gets visible.
		
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(OverduePOM.clickStatutoryChecklistAction().get(1)));	//Waiting until all Action buttons get visible.
		Thread.sleep(3000);
		OverduePOM.clickStatutoryChecklistAction().get(1).click();	//Clicking on first Action button inside Internal Checklist click (Using Statutory xpath)
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));	//Switching to iFrame
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
		OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
		OverduePOM.remark().sendKeys("Automation Testing");
		Thread.sleep(500);
		//OverduePOM.clickComplianceSubmit().click();				//Clicking on 'Submit' button.	
		getDriver().findElement(By.xpath("//*[@id='btnSave2']")).click();
		Thread.sleep(8000);
		getDriver().switchTo().alert().accept();								//Clicking on alert to accept the message.
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(2000);

		OverduePOM.clickDashboard().click();						//Click on Dashboard
		Thread.sleep(4000);
		int newInternalChecklistValue = Integer.parseInt(OverduePOM.clickInternalChecklist().getText());	//Storing old value of Statutory Checkilist.
		
		if(newInternalChecklistValue < oldInternalChecklistValue)
		{
			test.log(LogStatus.PASS, "Action ' Closed Timely' - Internal 'Checklist' value decremented. Old value = " +oldInternalChecklistValue +" New Value = "+ newInternalChecklistValue);
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed.");
		}
		
	}
	
	
	static void RejectDelete( String Compliance,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		elementsList = OverduePOM.clickStatutoryActionButton();
		elementsList.get(2).click();			//Clicking on third Action button.
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));
			
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2000 px.
			if(OverduePOM.rejectStauDelete().isDisplayed())
			{
				test.log(LogStatus.PASS, "  Delete Button Displayed Successfully");
				
				OverduePOM.rejectStauDelete().click();
				Thread.sleep(2000);
			String Msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();
				
			test.log(LogStatus.PASS, " Delete Msg -" +Msg);
			}
			getDriver().switchTo().parentFrame();
			OverduePOM.CloseRS().click();
		}
		else if(Compliance.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
			Thread.sleep(500);
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,800)");	
			if(OverduePOM.rejectInDelete().isDisplayed())
			{
				test.log(LogStatus.PASS, " Delete Button Displayed Successfully");
				
				OverduePOM.rejectInDelete().click();
				Thread.sleep(2000);
			String Msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();
				
			test.log(LogStatus.PASS, " Delete Msg -" +Msg);
			}
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			OverduePOM.CloseRIn().click();
		}
		
		Thread.sleep(2000);
	/*	OverduePOM.clickAdvancedSearch().click();
		Thread.sleep(2000);
		
		elementsList = OverduePOM.clickStatutoryActionButton1();
		elementsList.get(2).click();	
		Thread.sleep(2000);
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame1"));
			
			
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.rejectStauDelete().isDisplayed())
			{
				test.log(LogStatus.PASS, "Advanced Search - Delete Button Displayed Successfully");
				
				OverduePOM.rejectStauDelete().click();
				Thread.sleep(2000);
			String Msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();
				
			test.log(LogStatus.PASS, "Advanced Search Delete Msg -" +Msg);
			}
			getDriver().switchTo().parentFrame();
			OverduePOM.CloseRADS().click();
			
		}
		else if(Compliance.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame1"));
			
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.rejectInDelete().isDisplayed())
			{
				test.log(LogStatus.PASS, "Advanced Search - Delete Button Displayed Successfully");
				
				OverduePOM.rejectInDelete().click();
				Thread.sleep(2000);
			String Msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();
				
			test.log(LogStatus.PASS, "Advanced Search Delete Msg -" +Msg);
			}
			getDriver().switchTo().parentFrame();
			OverduePOM.CloseRADIn().click();
			
		}
		
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
		Thread.sleep(2000);
		*/
	}

	static void RejectAction( String Compliance,ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		elementsList = OverduePOM.clickStatutoryActionButton();
		elementsList.get(0).click();			//Clicking on third Action button.
		int flag = 0;
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));
			try {
			OverduePOM.selectStatutoryDropdown().click();			//Clicking on statutory Status drop down.
			Select drp = new Select(OverduePOM.selectStatutoryDropdown());
			drp.selectByIndex(1);										//Selecting second index option of drop down.
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.fileUploadStatutory().isEnabled())
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
				Thread.sleep(2000);//OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
			}
			else
			{
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Uploading file by sending file to Upload Button.
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2000 px.
			}
			js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2000 px.
			OverduePOM.selectDateStatutory().click();				//Clicking on Date inbox
			flag = 1;
			Thread.sleep(1000);
			OverduePOM.selectDateStatutory11().click();	
			Thread.sleep(1000);
		//	OverduePOM.selectLastMonth().click();						//Clicking on Last Month Arrow on calendar
			Thread.sleep(500);
		//	OverduePOM.selectDate().click();							//Clicking on date at second row and fourth column
			Thread.sleep(500);
			}catch(Exception e) {
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");
			}
		}
		else if(Compliance.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
			try {
			OverduePOM.selectInternalDropdown().click();			//Clicking on internal Status drop down.
			Select drp = new Select(OverduePOM.selectInternalDropdown());
			drp.selectByIndex(1);										//Selecting second index option of drop down.
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.fileUploadInternal().isEnabled())
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
				//OverduePOM.buttonAddLinkInternal().click();						//Clicking on 'Add Link' button of Compliance Documents
			}
			else
			{
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
			//	String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadInternal().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	//Uploading file by sending file to Upload Button.
			}
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2000 px.
			OverduePOM.selectDateInternal().click();				//Clicking on Date inbox
			Thread.sleep(500);
		//	OverduePOM.selectLastMonth().click();						//Clicking on Last Month Arrow on calendar
			Thread.sleep(500);
		//	OverduePOM.selectDate().click();							//Clicking on date at second row and fourth column
			OverduePOM.selectDateStatutory11().click();	
			Thread.sleep(1000);
			flag = 2;
			}catch(Exception e) {
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	
			}
		}
		Actions action = new Actions(getDriver());
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	
		Thread.sleep(5000);
		if(Compliance.equalsIgnoreCase("Statutory") ) {
			OverduePOM.remark().sendKeys("Automation Remark");	//Clicking on remark text area (statutory)
			Thread.sleep(3000);
		}	else {
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Clicking on remark text area (internal)
			Thread.sleep(3000);
		}
		Thread.sleep(2000);
	
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
		Thread.sleep(3000);
		
			OverduePOM.clickComplianceSubmit1().click();			//Clicking on 'Submit' button.
		
		}
		else {
			
			Thread.sleep(3000);
			OverduePOM.clickComplianceSubmit2().click();
		}
		Thread.sleep(8000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(2000);
	/*	OverduePOM.clickAdvancedSearch().click();
		Thread.sleep(2000);
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
		
		CFOcountPOM.readTotalItems2().click();					//Clicking on total items to scroll down
		String item = CFOcountPOM.readTotalItems2().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];
	int	countA = Integer.parseInt(compliancesCount);
		
		elementsList = OverduePOM.clickStatutoryActionButton1();
		elementsList.get(2).click();			//Clicking on third Action button.
		int flag1 = 0;
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame1"));
			
			OverduePOM.selectStatutoryDropdown().click();			//Clicking on statutory Status drop down.
			Select drp = new Select(OverduePOM.selectStatutoryDropdown());
			drp.selectByIndex(1);										//Selecting second index option of drop down.
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.fileUploadStatutory().isEnabled())
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("C:/Users/sandip/Downloads/Holiday List 2022.xlsx");	//Providing Compliance Documents link
				//OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
			}
			else
			{
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadStatutory().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");	//Uploading file by sending file to Upload Button.
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2000 px.
			}
			js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2000 px.
			OverduePOM.selectDateStatutory().click();				//Clicking on Date inbox
			flag1 = 1;
		}
		else if(Compliance.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame1"));
			
			OverduePOM.selectInternalDropdown().click();			//Clicking on internal Status drop down.
			Select drp = new Select(OverduePOM.selectInternalDropdown());
			drp.selectByIndex(1);										//Selecting second index option of drop down.
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			if(OverduePOM.fileUploadInternal().isEnabled())
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("C:/Users/sandip/Downloads/Holiday List 2022.xlsx");	//Providing Compliance Documents link
				//OverduePOM.buttonAddLinkInternal().click();						//Clicking on 'Add Link' button of Compliance Documents
			}
			else
			{
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadInternal().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2000 px.
			OverduePOM.selectDateInternal().click();				//Clicking on Date inbox
			flag1 = 2;
		}
		
		Thread.sleep(500);
		OverduePOM.selectLastMonth().click();						//Clicking on Last Month Arrow on calendar
		Thread.sleep(500);
		OverduePOM.selectDate().click();							//Clicking on date at second row and fourth column
		
		Thread.sleep(500);
		if(flag1 == 1)
			OverduePOM.remark().sendKeys("Automation Remark");	//Clicking on remark text area (statutory)
		else
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Clicking on remark text area (internal)
		
		Thread.sleep(500);
		OverduePOM.clickComplianceSubmit().click();				//clicking on submit button.
		
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);  
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
		getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer1']/div/div/div[1]/button")).click();
		Thread.sleep(500);
		}else if(Compliance.equalsIgnoreCase("Internal"))
		{
			getDriver().findElement(By.xpath("//*[@id='ComplainceInternalPerformaer1']/div/div/div[1]/button")).click();
			Thread.sleep(500);
		}
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		CFOcountPOM.readTotalItems2().click();					//Clicking on total items to scroll down
		String item1 = CFOcountPOM.readTotalItems2().getText();	//Reading total items String value
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];
	int	countAD = Integer.parseInt(compliancesCount1);
	if(countA >countAD)
	{
		test.log(LogStatus.PASS, "Advanced Search - After Perform  count decreased");
	}
	else
	{
		test.log(LogStatus.FAIL, "Advanced Search - After Perform  count doesn't decreased");
	}
	Thread.sleep(500);
	getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
	Thread.sleep(2000);
		*/
	}
	
	public static void DashboardRejected( ExtentTest test, String Compliance) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerRejectedPEOcount']")));	//Waiting for 'Statutory Reject' value to get visible on Dashboard
		
		String string_rejected = null;
		int rejected = 0;
		for(int i = 0; i <= 0; i++)						//For loop used only to get 'break;' functionality in use.
		{
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejected = OverduePOM.clickStatutoryRejected().getText();	//Storing old value of Statutory Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				OverduePOM.clickStatutoryRejected().click();			//Clicking on Statutory overdue.
			}
			else															//Going for Internal click
			{
				string_rejected = OverduePOM.clickInternalRejected().getText();	//Storing old value of Internal Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				OverduePOM.clickInternalRejected().click();			//Clicking on Statutory overdue.
				Thread.sleep(3000);
			}
		}
		
		if(rejected > 0)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 2000 px.
			
			CFOcountPOM.readTotalItems4().click();					//Clicking on total items to scroll down
			String item = CFOcountPOM.readTotalItems4().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems4().getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			count = Integer.parseInt(compliancesCount);
			
			if(rejected == count)
			{
				test.log(LogStatus.PASS, "Before Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + count + " | Total Compliances count on Dashboard = " + rejected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Before Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + count + " | Total Compliances count on Dashboard = " + rejected);
			}
			
			RejectAction( Compliance,test);								//Calling method of Action Button click
			
			Thread.sleep(5000);
			MethodsPOM.StatutoryOverdueExport(test,workbook);	
			Thread.sleep(500);
			MethodsPOM.RejectDelete(Compliance,test);	
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
			
			js.executeScript("window.scrollBy(0,1000)");
			
			Thread.sleep(2000);
			CFOcountPOM.readTotalItems4().click();					//Clicking on total items count
			item = CFOcountPOM.readTotalItems4().getText();			//Reading total items String value
			bits = item.split(" ");											//Splitting the String
			compliancesCount = bits[bits.length - 2];						//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems4().getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			count1 = Integer.parseInt(compliancesCount);
					
			Thread.sleep(500);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryRejected()));
			
			String string_rejectedNew = null;
			int rejectedNew = 0;
			
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejectedNew = OverduePOM.clickStatutoryRejected().getText();	//Storing new value of Statutory Reject.
				rejectedNew = Integer.parseInt(string_rejectedNew);
			}
			else															//Going for Internal click
			{
				string_rejectedNew = OverduePOM.clickInternalRejected().getText();	//Storing old value of Internal Reject.
				rejectedNew = Integer.parseInt(string_rejectedNew);
			}
			if(rejectedNew == count1)
			{
				test.log(LogStatus.PASS, "After Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + count1 + " | Total Compliances count on Dashboard = " + rejectedNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + count1 + " | Total Compliances count on Dashboard = " + rejectedNew);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, Compliance +" Rejected count = "+rejected);
		}
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		
	}
	

	public static void DashboardRejectedCri( ExtentTest test, String Compliance) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerRejectedPEOcount']")));	//Waiting for 'Statutory Reject' value to get visible on Dashboard
		
		String string_rejected = null;
		int rejected = 0;
		for(int i = 0; i <= 0; i++)						//For loop used only to get 'break;' functionality in use.
		{
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejected = OverduePOM.clickStatutoryRejected().getText();	//Storing old value of Statutory Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				OverduePOM.clickStatutoryRejected().click();			//Clicking on Statutory overdue.
			}
			else															//Going for Internal click
			{
				string_rejected = OverduePOM.clickInternalRejected().getText();	//Storing old value of Internal Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				OverduePOM.clickInternalRejected().click();			//Clicking on Statutory overdue.
				Thread.sleep(3000);
			}
		}
		
		if(rejected > 0)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 2000 px.
			
			CFOcountPOM.readTotalItems4().click();					//Clicking on total items to scroll down
			String item = CFOcountPOM.readTotalItems4().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems4().getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			count = Integer.parseInt(compliancesCount);
			
			if(rejected == count)
			{
				test.log(LogStatus.PASS, "Before Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + count + " | Total Compliances count on Dashboard = " + rejected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Before Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + count + " | Total Compliances count on Dashboard = " + rejected);
			}
			
		RejectAction( Compliance,test);								//Calling method of Action Button click
			
			Thread.sleep(5000);
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
			
			js.executeScript("window.scrollBy(0,1000)");
			
			Thread.sleep(2000);
			CFOcountPOM.readTotalItems4().click();					//Clicking on total items count
			item = CFOcountPOM.readTotalItems4().getText();			//Reading total items String value
			bits = item.split(" ");											//Splitting the String
			compliancesCount = bits[bits.length - 2];						//Getting the second last word (total number of users)
			int count1 = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item = CFOcountPOM.readTotalItems4().getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			count1 = Integer.parseInt(compliancesCount);
					
			Thread.sleep(500);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryRejected()));
			
			String string_rejectedNew = null;
			int rejectedNew = 0;
			
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejectedNew = OverduePOM.clickStatutoryRejected().getText();	//Storing new value of Statutory Reject.
				rejectedNew = Integer.parseInt(string_rejectedNew);
			}
			else															//Going for Internal click
			{
				string_rejectedNew = OverduePOM.clickInternalRejected().getText();	//Storing old value of Internal Reject.
				rejectedNew = Integer.parseInt(string_rejectedNew);
			}
			if(rejectedNew == count1)
			{
				test.log(LogStatus.PASS, "After Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + count1 + " | Total Compliances count on Dashboard = " + rejectedNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + count1 + " | Total Compliances count on Dashboard = " + rejectedNew);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, Compliance +" Rejected count = "+rejected);
		}
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		
	}
	
	static void AssignTask( String task) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickComplianceLocation()));
		OverduePOM.clickComplianceLocation().click();	//Clicking on 'Compliance Location' text box
		Thread.sleep(500);
		CFOcountPOM.clickInternalSubmenu1().click();	//Clicking on first sub menu
		Thread.sleep(500);
		OverduePOM.SelectCheckBox().click();			//Clicking on second sub menu checkbox
		CFOcountPOM.clickInternalSubmenu2().click();	//Clicking on second sub menu name to close filter
		
		Thread.sleep(1000);
		OverduePOM.clickReportingLocation().click();	//Clicking on 'Reporting Location' text box
		elementsList = OverduePOM.clickSubLoacations();	//Getting all sub locations
		Thread.sleep(500);
		elementsList.get(0).click();						//Clicking on first sub location
		Thread.sleep(500);
		elementsList.get(1).click();						//Clicking on second sub location
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStartDate()));
		OverduePOM.clickStartDate().click();			//Clicking on Start Date text box
		OverduePOM.selectLastMonth().click();			//Clicking on arrow to get last month
		OverduePOM.selectDate().click();				//Clicking the actual date on calendar
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickSelectPerformer()));
		OverduePOM.clickSelectPerformer().click();	//Clicking the Performer drop down
		Thread.sleep(1000);
		OverduePOM.clickSearchedUser1().click();		//Clicking the first index user
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickSelectReviewer()));
		OverduePOM.clickSelectReviewer().click();		//Clicking the Performer drop down
		Thread.sleep(1000);
		if(task.equalsIgnoreCase("Main"))
			OverduePOM.clickSearchedUser2().click();		//Clicking the first index user
		else
			OverduePOM.clickSearchedUser1().click();		//Clicking the first index user
		
		Thread.sleep(700);
		OverduePOM.clickSaveButton1().click();		//Clicking on Save Button.
	}
	
	static void AddTask( int row, String compliance) throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(0);
	//	sheet = workbook.getSheetAt(0);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
		
		Thread.sleep(500);
		Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
		Cell c1 = null;
		if(compliance.equalsIgnoreCase("Internal"))		//If Task is of Internal
			c1 = row0.getCell(3);						//Selected cell (0 row,3 column)	(3 column = fourth column)
		else
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
	//Select subTaskType=new Select(OverduePOM.clickSubTaskType());
//	taskType.selectByIndex(1);
		Thread.sleep(1000);
		OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
		
		row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
		c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
		OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
		
		row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
		c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
		OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
		
		row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
		c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
		OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
	}
	
	public static void MyWorkComplianceClear( ExtentTest test) throws InterruptedException
	{
		//-------------------------------Create Main Task--------------------------------------
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick='CheckProduct();']")));	//Waiting for 'My Workspace' link to be visible.
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		OverduePOM.SelectStatusP().click();	
		Thread.sleep(1000);
		OverduePOM.SelectStatusOverdue().click();	
		Thread.sleep(4000);
		OverduePOM.ClickApply().click();	
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		Thread.sleep(8000);
		
		if(OverduePOM.ClearFilter().isEnabled()) {
			OverduePOM.ClearFilter().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Clear button working  Successfully");
		}else {
			test.log(LogStatus.PASS, "Clear button not working '");
		}
	}

	public static void UpdateTask( ExtentTest test, XSSFWorkbook workbook, String Compliance) throws InterruptedException, EncryptedDocumentException, IOException
	{
		//-------------------------------Create Main Task--------------------------------------
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick='CheckProduct();']")));	//Waiting for 'My Workspace' link to be visible.
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();			//Clicking on 'Compliance' under My Workspace
		
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		*/
		Thread.sleep(2000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
		
		OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
		
		wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
		try
		{
			if(Compliance.equalsIgnoreCase("Internal"))
			{
			//	test.log(LogStatus.INFO, "------------- Internal -------------");
				
				OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
				Thread.sleep(500); 
				Select drp = new Select(OverduePOM.clickInternalCompliance());
				drp.selectByIndex(1);
			}
			else
			{
				//test.log(LogStatus.INFO, "------------- Statutory -------------");
				
				OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
				Select drp = new Select(OverduePOM.clickActFilter());
				drp.selectByIndex(2);										//Selecting third Act
				
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
				OverduePOM.clickComplianceDropDown().click();			//Clicking on 'Compliance' drop down.
				drp = new Select(OverduePOM.clickComplianceDropDown());
				drp.selectByIndex(1);										//Selecting first Act	
			}
		}
		catch(Exception e)
		{
			
		}
		//OverduePOM.clickActFilter().click();	
		
		AddTask( 0, Compliance);								//0 - indicates Main Task Name row in sheet
		
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickTaskType()));
		OverduePOM.clickTaskType().click();		//Clicking on Task Type drop Down.
		Select drp = new Select(OverduePOM.clickTaskType());
		drp.selectByIndex(3);							//Selecting fourth option
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
		
	//	OverduePOM.clickSubTaskType().click();	//Clicking on Sub Task Type drop Down.
	//	drp = new Select(OverduePOM.clickSubTaskType());
	//	drp.selectByIndex(1);
		
		Thread.sleep(1000);
		/*wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickIsAfter()));
		OverduePOM.clickIsAfter().click();		//Clicking on Is After/Before drop Down.
		drp = new Select(OverduePOM.clickIsAfter());
		drp.selectByIndex(1);	*/						//Selecting 'After' option
	//	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlIsAfter']")).click();
		Thread.sleep(1500);
		String workingDir = System.getProperty("user.dir");
		OverduePOM.SampleFormUpload().sendKeys("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\PerformerResults.html");
		
		Thread.sleep(1000);
		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		
		Thread.sleep(3000);
		String saveMsg = OverduePOM.taskSavedMsg().getText();
		Thread.sleep(3000);
		OverduePOM.taskSavedMsg().click();
		Thread.sleep(3000);
		if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed - 'Task Saved Successfully'");
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - 'Task already exist.'");
		}
		
		Thread.sleep(1000);
		//OverduePOM.closeUpdateTasks().click();	//Closing the Update Tasks form.
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
		Thread.sleep(1000);
	/*	int total1 = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records displayed
		
		if(total1 > total)
		{
			test.log(LogStatus.PASS, "New Task added and displayed successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
		}*/
		
		//-------------------------------Create Sub Task--------------------------------------
		Thread.sleep(1500);
		OverduePOM.clickShow().click();						//Clicking on Show dropdown
		Select select = new Select(OverduePOM.clickShow());
		select.selectByIndex(3);									//Selecting 50
		
	/*	Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2000)");		//Scrolling down window by 2000 px.
		elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
		int no = elementsList1.size();
		
		Thread.sleep(1000);
		elementsList1.get(2).click();
		
	Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
		OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
		
		Thread.sleep(1500);
		Actions action = new Actions(getDriver());
		//action.moveToElement(OverduePOM.selectAllCheckbox()).click().perform();	//Clicking on Select All check box in Task Mapping
		action.moveToElement(OverduePOM.OK()).click().perform();	//Clicking on OK button
		//OverduePOM.clickTaskMapping().click();		//Clicking on Task Mapping text box								
				
		AddTask(, workbook, 6, Compliance);						//6 - indicates Sub Task Name row in sheet
				
		Thread.sleep(1500);			
		OverduePOM.SampleFormUpload().sendKeys(workingDir+"//Reports//PerformerResults.html");
		
		Thread.sleep(1000);
		OverduePOM.clickSaveButton().click();			//Clicking on 'Save' Button
			
		Thread.sleep(500);
		saveMsg = OverduePOM.taskSavedMsg().getText();	//Msg = Subtask Saved Successfully.
		
		test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg +"'");
			
		OverduePOM.closeUpdateTasks().click();		//Closing the Sub Task form.
		
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
		
		Thread.sleep(700);
		OverduePOM.clickMainTaskLink().click();		//CLicking on Main Task name to get back from sub task.
		
		//--------------------------Assign Main Task --------------------------
		
		Thread.sleep(1500);
		OverduePOM.clickShow().click();				//Clicking on Show dropdown
		select = new Select(OverduePOM.clickShow());
		select.selectByIndex(3);							//Selecting 50
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2000)");		//Scrolling down window by 2000 px.
		
		elementsList = OverduePOM.clickAssignTask();	//Getting all Assign buttons
		int n = elementsList.size();
		System.out.println("Assign Main Tasks - "+n);
		elementsList.get(n-1).click();						//Clicking on newly added task's assign button (last button)
		
		AssignTask(, "Main");							//Calling assign Task Method
		
		Thread.sleep(1500);
		try
		{
			if(!OverduePOM.checkRecordsTable1().isDisplayed())
			{
				test.log(LogStatus.FAIL, "Main task doesn't assigned to user");
			}
			else
			{
				test.log(LogStatus.PASS, "Main task assigned to user");
			}
		}
		catch(Exception e)
		{
			
		}
		
		OverduePOM.closeUpdateTasks1().click();	//Closing the Assign Compliance form.
		
		//----------------------------Assign Sub Task-----------------------------
		
		Thread.sleep(1500);
		OverduePOM.clickShow().click();				//Clicking on Show dropdown
		select = new Select(OverduePOM.clickShow());
		select.selectByIndex(3);							//Selecting 50
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1500)");		//Scrolling down window by 2000 px.
		elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
		no = elementsList1.size();
		elementsList1.get(no-1).click();
		
		Thread.sleep(700);
		js.executeScript("window.scrollBy(0,700)");			//Scrolling down window by 2000 px.
		
		elementsList = OverduePOM.clickAssignTask();	//Getting all Assign buttons
		n = elementsList.size();
		elementsList.get(n-1).click();						//Clicking on newly added task's assign button (last button)
		
		AssignTask(, "Sub");
			
		Thread.sleep(1500);
			
		if(!OverduePOM.checkRecordsTable().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Sub task doesn't assigned to user");
		}
		else
		{
			test.log(LogStatus.PASS, "Sub task assigned to user");
		}
		
		OverduePOM.closeUpdateTasks1().click();		//Closing the Sub Task assignment form.
		Thread.sleep(1000);*/
	}
	
	public static void EditTask( ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(),  50);
	OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(3000);
		OverduePOM.MyTasks().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(3000);
	/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(2000);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		*/
		Thread.sleep(500);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.ClickEditBtn().click();
		Thread.sleep(5000);
		OverduePOM.clickTaskTitle().clear();
		Thread.sleep(1000);
		OverduePOM.clickTaskTitle().sendKeys("Auto1616");
		Thread.sleep(1000);
		OverduePOM.clickDescription().clear();
		Thread.sleep(1000);
		OverduePOM.clickDescription().sendKeys("AutomationTesting1212");
		Thread.sleep(1000);
		Thread.sleep(2000);
		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		
		Thread.sleep(3000);
		String saveMsg = OverduePOM.EditSavedMsg().getText();
		OverduePOM.EditSavedMsg().click();
		Thread.sleep(3000);
		if(saveMsg.equalsIgnoreCase("Task Updated Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed - 'Task Updated Successfully.'");
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - 'Task Updated Successfully.'");
		}
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		Thread.sleep(500);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		//OverduePOM.ClickShowAssignment().click();
		Thread.sleep(5000);
	//	OverduePOM.ComplianceLocation().sendKeys("B Pvt Ltd");
		OverduePOM.ClickDeleteTask().click();
		Thread.sleep(2000);
		String deleteMsg=getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Task?"))
		{
			test.log(LogStatus.PASS, "Message displayed - 'Are you certain you want to delete this Task?'");
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - 'Are you certain you want to delete this Task? this msg not show'");
		}
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();	
		Thread.sleep(2000);
		String DleMsg=OverduePOM.AfterClickDelete().getText();
		if(DleMsg.equalsIgnoreCase("Task can not delete, Task already assigned"))
		{
			test.log(LogStatus.PASS, "Message displayed - 'Task can not delete, Task already assigned'");
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - 'Task can not delete, Task already assigned this msg not show'");
		}
		
		
	}
	
	public static void EditInternalTask( ExtentTest test) throws InterruptedException
	{
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (80));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(1000);
		OverduePOM.MyTasks().click();			//Clicking on 'Compliance' under My Workspace
		/*
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liTaskCreation']")));	//Waiting for records table to get visible
		*/
		Thread.sleep(3000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.ClickEditBtn().click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
		Thread.sleep(3000); 
		OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
		Thread.sleep(4000); 
		Select drp = new Select(OverduePOM.clickInternalCompliance());
		drp.selectByIndex(1);
		Thread.sleep(1000); 
		OverduePOM.clickDueDay().sendKeys("55");
		Thread.sleep(1000); 
		OverduePOM.clickTaskTitle().clear();
		Thread.sleep(2000);
		OverduePOM.clickTaskTitle().sendKeys("Auto1816");
		Thread.sleep(2000);
		OverduePOM.clickDescription().clear();
		Thread.sleep(2000);
		OverduePOM.clickDescription().sendKeys("AutomationTesting1312");
		Thread.sleep(1000);
		Thread.sleep(2000);
		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		
		Thread.sleep(4000);
		String saveMsg = OverduePOM.EditSavedMsg().getText();
		OverduePOM.EditSavedMsg().click();
		Thread.sleep(3000);
		if(saveMsg.equalsIgnoreCase("Task Updated Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed - 'Task Updated Successfully.'");
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - 'Task Updated Successfully.'");
		}
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		
	}
	
	
	static void EventBased_Statutory( ) throws InterruptedException
	{
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,800)");					//Scrolling down window by 2600 px.
		
		OverduePOM.selectStatutoryDropdown().click();
		Select drp = new Select(OverduePOM.selectStatutoryDropdown());
		drp.selectByIndex(1);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		Thread.sleep(1000);
		
				if(OverduePOM.fileUploadStatutory().isEnabled())
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
			OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
			Thread.sleep(300);
		//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fuSampleFile']")));	//Waiting till upload button get visible.
			String workingDir = System.getProperty("user.dir");
			OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
		}
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,800)");					//Scrolling down window by 2600 px.
		
		OverduePOM.selectDateStatutory().click();				//Clicking on date input box
		OverduePOM.selectLastMonth().click();					//Clicking on Last month arrow
		Thread.sleep(500);
		OverduePOM.selectDate().click();					//Clicking on date at second row and fourth column
	}
	
	public static void MyCalendarCompliance( ExtentTest test) throws InterruptedException
	{
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickStatutoryChecklist()));
	//	int oldStatutoryChecklistValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing old value of Statutory Checkilist.
	//	int oldOverdueStatutoryValue = Integer.parseInt(OverduePOM.clickStatutoryOverdue().getText());
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,650)");					//Scrolling down window by 2600 px.
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='badge badge-warning overdue'])[1]")));	//Waiting till the cornered count of compliance get visible.
		Thread.sleep(3000);
		CFOcountPOM.readDateComliance().click();					//Clicking on the compliance value on top corner
		elementsList = CFOcountPOM.clickDateCalendar1();			//Getting all red compliances
		elementsList.get(0).click();							//Clicking on first Red Compliance of the calendar.		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
		
		Thread.sleep(500);
		elementsList1 = OverduePOM.readCalendarCompType1();		//Getting all values of compliance Type 
		int n = elementsList1.size();
		String type = null;
		int notify = 0;
		int i;
		for(i = 0; i < n; i++)
		{
			elementsList1 = OverduePOM.readCalendarCompType1();
			type = elementsList1.get(i).getText();					//Reading name of Compliance Type
			if(type.contains("Statutory"))							//We will perform only Statutory compliances.
			{
				notify = 1;											//If compliance id Statutory then 1.
				break;
			}
			if(i == n-1)
			{
				if(CFOcountPOM.clickNextPage1().isEnabled())
				{
					CFOcountPOM.clickNextPage1().click();
					Thread.sleep(300);
					i = -1;
				}
			}
		}
		
		System.out.println(type);
		
		if(notify == 1)												//If Statutory compliance found.
		{
			elementsList = OverduePOM.clickCalenderAction();			//Getting all Action buttons
			wait.until(ExpectedConditions.visibilityOf(elementsList.get(0)));
			Thread.sleep(200);
			elementsList.get(i).click();							//Clicking on ith Action Button which is Statutory
			
			getDriver().switchTo().parentFrame();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			int flag = 0;
			if(type.equalsIgnoreCase("Statutory CheckList"))
			{
				test.log(LogStatus.INFO, "Checklist - Statutory compliance");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iChecklistPerformerFrame"));
				
				js.executeScript("window.scrollBy(0,800)");
				
				Thread.sleep(1000);
				if(OverduePOM.fileUploadStatutory().isEnabled())
				{
					Thread.sleep(500);
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
					OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
					Thread.sleep(300);
					//OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
				}
				else
				{
					String workingDir = System.getProperty("user.dir");	
					try
					{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fuSampleFile']")));	//Waiting till upload button get visible.
						
						OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//TestData//ComplianceSheet.xlsx");	//Uploading file by sending file to Upload Button.
					}
					catch(Exception e)
					{
						
					}
					
					try
					{
						OverduePOM.fileUploadStatutory().sendKeys(workingDir+"//TestData//PerformerResults.xlsx");	//Uploading file by sending file to Upload Button.
					}
					catch(Exception e)
					{
						
					}
				}
				
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,800)");					//Scrolling down window by 2600 px.
				
				flag = 1;
			}
			else if(type.equalsIgnoreCase("Event Based"))
			{
				test.log(LogStatus.INFO, "Overdue - Statutory Event Based compliance");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iPerformerFrame"));
				
				Thread.sleep(500);
				
				EventBased_Statutory();								//Calling Method
				
				flag = 2;
			}
			else if(type.equalsIgnoreCase("Statutory"))
			{
				test.log(LogStatus.INFO, "Overdue - Statutory compliance");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iPerformerFrame"));
				
				Thread.sleep(500);
				
				EventBased_Statutory();								//Calling method
				flag = 2;
			}
			js.executeScript("window.scrollBy(0,400)");						//Scrolling down window by 2600 px.
			
			Thread.sleep(1000);
			OverduePOM.remark().sendKeys("Automation Testing");		//Sending Remark
				
			Thread.sleep(1000);
			OverduePOM.clickComplianceSubmit().click();				//Click on Submit button.
				
			Thread.sleep(500);
			getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
			getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
			getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
			
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard
			
			Thread.sleep(500);
		//	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryChecklist()));
		/*	int newValue = 0;
			if(flag == 1)
			{
				newValue = Integer.parseInt(OverduePOM.clickStatutoryChecklist().getText());	//Storing new value of Statutory Checkilist.
				
				if(newValue < oldStatutoryChecklistValue)
				{
					test.log(LogStatus.PASS, "Statutory CheckList count decreased. Old count = "+oldStatutoryChecklistValue+ " | New count = "+newValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Statutory CheckList count doesn't decreased. Old count = "+oldStatutoryChecklistValue+ " | New count = "+newValue);
				}
			}
			else if(flag == 2)
			{
				newValue = Integer.parseInt(OverduePOM.clickStatutoryOverdue().getText());	//Storing new value of Statutory Checkilist.
				
				if(newValue < oldOverdueStatutoryValue)
				{
					test.log(LogStatus.PASS, "Overdue count decreased. Old count = "+oldOverdueStatutoryValue+ " | New count = "+newValue);
				}
				else
				{
					test.log(LogStatus.FAIL, "Overdue count doesn't decreased. Old count = "+oldOverdueStatutoryValue+ " | New count = "+newValue);
				}
			}*/
		}
		else
		{
			test.log(LogStatus.INFO, "Statutory Compliance didn't found. Skipping the test.");
		}
	}
	
	public static void UpdateLeave( ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (20));
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickMyWorkspace()));	//Waiting for 'My Workspace' link to be visible.
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Leave"
		
		int total = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records displayed
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_A2']")).click();
		OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
		
		Thread.sleep(500);
		OverduePOM.clickStartDate1().click();					//Clicking on Start Date input box 
		OverduePOM.selectNextMonth().click();					//Clicking on Next Month arrow.
		Thread.sleep(500);
		OverduePOM.selectDate().click();						//Clicking on date of second row and fourth column
		
		Thread.sleep(500);
		OverduePOM.clickEndDate().click();					//Clicking on Start Date input box 
		OverduePOM.selectNextMonth().click();					//Clicking on Next Month arrow.
		Thread.sleep(500);
		OverduePOM.selectDate2().click();						//Clicking on date of second row and fifth column
		
		Thread.sleep(500);
		OverduePOM.selectNewPerformer().click();				//Clicking on New Performer drop down
		Select drp = new Select(OverduePOM.selectNewPerformer());
		drp.selectByIndex(1);										//Selecting first performer user.
		
		Thread.sleep(500);
		OverduePOM.selectNewReviewer().click();				//Clicking on New Performer drop down
		drp = new Select(OverduePOM.selectNewReviewer());
		drp.selectByIndex(1);										//Selecting first reviewer user.
		
		Thread.sleep(500);
		OverduePOM.selectNewEventOwner().click();				//Clicking on New Performer drop down
		drp = new Select(OverduePOM.selectNewEventOwner());
		drp.selectByIndex(1);										//Selecting first event owner user.
		
		Thread.sleep(500);
		OverduePOM.clickSaveButton().click();
		
		Thread.sleep(500);
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(OverduePOM.progressGIF()));	//Waiting till progress gif goes off
		}
		catch(Exception e)
		{
			
		}
		String msg = OverduePOM.readMsgLeave().getText();
		test.log(LogStatus.INFO, "Message Diplayed - "+msg);
		
		Thread.sleep(500);
		OverduePOM.closeLeave().click();						//Closing the Leave window.
		
		Thread.sleep(500);
		int total1 = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records displayed
		
		if(total1 > total)
		{
			test.log(LogStatus.PASS, "Leave request displayed.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New leave request not added - '"+msg+"'"); 
		}
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();					//Clicking on Dashboard
	}
	
	public static void UpcomingComplianceADView( ExtentTest test) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(50));
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUpcomingStatutory()));	//Waiting for 'Upcoming Statutory' count to be clickable.
		OverduePOM.clickUpcomingStatutory().click();
		Thread.sleep(8000);
		Thread.sleep(1000);
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
	
		elementsList1 = OverduePOM.clickCalenderAction();	//Getting all action buttons (Statutory/Internal)
		elementsList1.get(1).click();					//Clicking on ith action button which has blue status 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ActDetails']")));	//Waiting for records table to get visible.
		
		OverduePOM.clickActDetails().click();
		Thread.sleep(3000);
		try {
		OverduePOM.clickAct().click();
		Thread.sleep(3000);
		String view=	OverduePOM.clickView().getText();
         	Thread.sleep(1000);
		if(view.equalsIgnoreCase("View"))
		{
			Thread.sleep(3000);
			OverduePOM.clickView().click();
			Thread.sleep(8000);
			OverduePOM.closeView().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View Button is present and View Successfully");
		}else {
			test.log(LogStatus.FAIL, "View Button is not present");
		}
		}catch(Exception e) {
			
			test.log(LogStatus.FAIL, "View Button is not present");
		}
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		OverduePOM.closeTab().click();
		Thread.sleep(3000);

		Thread.sleep(500);
		OverduePOM.clickDashboard().click();	
		
		
	}
	
	public static void PFR( ExtentTest test, String Compliance) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPFRStatutory()));	//Waiting for 'Upcoming Statutory' count to be clickable.
		
		int pendingCount = 0;
		int upcomingStatutory = 0;
		int pendingCountInternal = 0;
		int upcomingInternal = 0;
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
		
			OverduePOM.clickPFRStatutory().click();					//Clicking on Upcoming Statutory count.
		}
		else
		{
			
			OverduePOM.clickPFRInternal().click();					//Clicking on Upcoming Statutory count.
		}
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
		
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
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();	
		Thread.sleep(500);
		
	
	}
	
	public static void UpcomingCompliance( ExtentTest test, String Compliance, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUpcomingStatutory()));	//Waiting for 'Upcoming Statutory' count to be clickable.
		
		int pendingCount = 0;
		int upcomingStatutory = 0;
		int pendingCountInternal = 0;
		int upcomingInternal = 0;
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			pendingCount = Integer.parseInt(OverduePOM.readPendingReviewStatutory().getText());	//Reading old Pending for Review Count (Statutory)
			Thread.sleep(100);
			upcomingStatutory = Integer.parseInt(OverduePOM.clickUpcomingStatutory().getText());	//Reading Upcoming Statutory count
			
			OverduePOM.clickUpcomingStatutory().click();					//Clicking on Upcoming Statutory count.
		}
		else
		{
			pendingCountInternal = Integer.parseInt(OverduePOM.readPendingReviewInternal().getText());
			upcomingInternal = Integer.parseInt(OverduePOM.clickUpcomingInternal().getText());
			
			OverduePOM.clickUpcomingInternal().click();					//Clicking on Upcoming Statutory count.
		}
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
		
		Thread.sleep(500);
	getDriver().findElement(By.xpath("//div[@class = 'k-multiselect-wrap k-floatwrap']")).click();
		/*
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 2600 px.
		
		OverduePOM.clickAdvancedSearch();//.sendKeys(Keys.PAGE_UP);
		//OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
	//	OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		CFOcountPOM.readTotalItems4().click();
		String item1 = CFOcountPOM.readTotalItems4().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		
		if(bits1.length > 2)
		{
			Thread.sleep(2000);
			CFOcountPOM.readTotalItems4().click();
			item1 = CFOcountPOM.readTotalItems4().getText();
			bits1 = item1.split(" ");								//Splitting the String
		}
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
		if(compliancesCount1.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item1 = CFOcountPOM.readTotalItems4().getText();
			bits1 = item1.split(" ");									//Splitting the String
			compliancesCount1 = bits1[bits1.length - 2];
		}
		int count = Integer.parseInt(compliancesCount1);
		*/
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.Exportbtn().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);//C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 2600 px.
		
		OverduePOM.clickAdvancedSearch();//.sendKeys(Keys.PAGE_UP);
		//OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
	//	OverduePOM.clickAdvancedSearch().sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
	//	CFOcountPOM.readTotalItems4().click();
		String item1 = CFOcountPOM.readTotalItems4().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		
		if(bits1.length > 2)
		{
			Thread.sleep(2000);
		//	CFOcountPOM.readTotalItems4().click();
			item1 = CFOcountPOM.readTotalItems4().getText();
			bits1 = item1.split(" ");								//Splitting the String
		}
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
		if(compliancesCount1.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item1 = CFOcountPOM.readTotalItems4().getText();
			bits1 = item1.split(" ");									//Splitting the String
			compliancesCount1 = bits1[bits1.length - 2];
		}
		int count = Integer.parseInt(compliancesCount1);
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "  File downloaded successfully.");	
			
			
		}
		else
		{
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			if(upcomingStatutory == count)
			{
			//	test.log(LogStatus.PASS, "Before Perform :- Upcoming Statutory count matches to total number of compliances displayed.");
				test.log(LogStatus.PASS, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingStatutory);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Before Perform :- Upcoming Statutory count does not matches to total number of compliances displayed.");
				test.log(LogStatus.FAIL, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingStatutory);
			}
		}
		else
		{
			if(upcomingInternal == count)
			{
			//	test.log(LogStatus.PASS, "Before Perform :- Upcoming Internal count matches to total number of compliances displayed.");
				test.log(LogStatus.PASS, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingInternal);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Before Perform :- Upcoming Internal count does not matches to total number of compliances displayed.");
				test.log(LogStatus.FAIL, "Total Compliance Count in the Grid = "+count+" | Dashboard Compliance Count = "+upcomingInternal);
			}
		}
		
		elementsList1 = OverduePOM.clickCalenderAction();	//Getting all action buttons (Statutory/Internal)
		elementsList1.get(1).click();					//Clicking on ith action button which has blue status 
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			try {
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(1);
			}
			
			if(OverduePOM.fileUploadStatutory().isEnabled())
			{
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateStatutory().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate2().click();						//Clicking on date
			
			try
			{
				Thread.sleep(500);
				OverduePOM.valueSystem().sendKeys("100");				//Sending Value as per system.
				Thread.sleep(500);
				OverduePOM.valueReturn().sendKeys("50");				//Sending Value as per return.
			}
			catch(Exception e)
			{
				
			}
			}
			catch(Exception e1)
			{
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.remark()));
			OverduePOM.remark().sendKeys("Automation Remark");	//Sending remark to text area.
		}
		else
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			try {
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(1);
			}
			
			if(OverduePOM.fileUploadInternal().isEnabled())
			{
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,700)");					//Scrolling down window by 2600 px.
				
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLinkInternal().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateInternal().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate2().click();						//Clicking on date
			}
			catch(Exception e) {
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	
			}
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternalRemark()));
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Sending remark to text area.
		}
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
		Thread.sleep(3000);
		
			OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		
		}
		else {
			
			Thread.sleep(3000);
			OverduePOM.clickComplianceSubmit2().click();
		}
		Thread.sleep(1000);
		try
		{
			getDriver().switchTo().alert().accept();
		}
		catch(Exception e)
		{
			
		}
		try
		{
			getDriver().switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);/*
		OverduePOM.clickAdvancedSearch().click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable1()));	//Waiting for records table to get displayed.
		
		Thread.sleep(500);
		JavascriptExecutor js1 = (JavascriptExecutor) ;
		js1.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 2600 px.
		
		Thread.sleep(2000);
		CFOcountPOM.readTotalItems2().click();
		String item2 = CFOcountPOM.readTotalItems2().getText();
		String[] bits2 = item2.split(" ");								//Splitting the String
		
		if(bits2.length > 2)
		{
			Thread.sleep(2000);
			CFOcountPOM.readTotalItems2().click();
			item2 = CFOcountPOM.readTotalItems2().getText();
			bits2 = item2.split(" ");								//Splitting the String
		}
		String compliancesCount2 = bits2[bits2.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount2);
		
		elementsList1 = OverduePOM.clickCalenderAction1();	//Getting all action buttons (Statutory/Internal)
		elementsList1.get(1).click();					//Clicking on ith action button which has blue status 
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame1"));
			Thread.sleep(500);
			js1.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(1);
			}
			
			if(OverduePOM.fileUploadStatutory().isEnabled())
			{
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js1.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateStatutory().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate2().click();						//Clicking on date
			
			try
			{
				Thread.sleep(500);
				OverduePOM.valueSystem().sendKeys("100");				//Sending Value as per system.
				Thread.sleep(500);
				OverduePOM.valueReturn().sendKeys("50");				//Sending Value as per return.
			}
			catch(Exception e)
			{
				
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.remark()));
			OverduePOM.remark().sendKeys("Automation Remark");	//Sending remark to text area.
		}
		else
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame1"));
			Thread.sleep(500);
			js1.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(1);
			}
			
			if(OverduePOM.fileUploadInternal().isEnabled())
			{
				Thread.sleep(1000);
				js1.executeScript("window.scrollBy(0,700)");					//Scrolling down window by 2600 px.
				
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("C:\\Users\\mayurig\\Downloads\\Report .xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLinkInternal().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js1.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateInternal().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate2().click();						//Clicking on date
			
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternalRemark()));
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Sending remark to text area.
		}
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
		Thread.sleep(3000);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		}
		else {
			
			Thread.sleep(3000);
			OverduePOM.clickComplianceSubmit2().click();
		}
		Thread.sleep(500);
	//	OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

		Thread.sleep(1000);
		try
		{
			getDriver().switchTo().alert().accept();
		}
		catch(Exception e)
		{
			
		}
		try
		{
			.switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		getDriver().switchTo().parentFrame();
		//*[@id="ComplainceInternalPerformaer1"]/div/div/div[1]/button
		Thread.sleep(3000);
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			By locator2 = By.xpath("//*[@id='ComplaincePerformer1']/div/div/div[1]/button");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
		//	Thread.sleep(4000);

			WebElement ViewButton2 = getDriver().findElement(locator2);	
			Thread.sleep(4000);
		
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);		//Clicking on 'Submit' button.
		}
		else {
			
			By locator2 = By.xpath("//*[@id='ComplainceInternalPerformaer1']/div/div/div[1]/button");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
		

			WebElement ViewButton2 = getDriver().findElement(locator2);	
			Thread.sleep(4000);
		
		Thread.sleep(2000);
		js1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
		}
		
	
		getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
			Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));*/
		OverduePOM.clickDashboard().click();					//Clicking on 'Dashboard'
		
		Thread.sleep(5000);
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			int pendingcount1 = Integer.parseInt(OverduePOM.readPendingReviewStatutory().getText());	//Reading new Pending for Review Count (Statutory)
			int upcomingStatutoryNew = Integer.parseInt(OverduePOM.clickUpcomingStatutory().getText());
			
			if(upcomingStatutory > upcomingStatutoryNew)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Upcoming' Statutory count decreased.");
			//	test.log(LogStatus.PASS, "Old Compliance Count = "+upcomingStatutory+" | New Compliance Count = "+upcomingStatutoryNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Upcoming' Statutory count doesn't decreased.");
				//test.log(LogStatus.FAIL, "Old Compliance Count = "+upcomingStatutory+" | New Compliance Count = "+upcomingStatutoryNew);
			}
			
			if(pendingcount1 > pendingCount)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
			//	test.log(LogStatus.PASS, "Old Compliance Count = "+pendingCount+" | New Compliance Count = "+pendingcount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
				//test.log(LogStatus.FAIL, "Old Compliance Count = "+pendingCount+" | New Compliance Count = "+pendingcount1);
			}
		}
		else
		{
			int pendingcount1 = Integer.parseInt(OverduePOM.readPendingReviewInternal().getText());	//Reading new Pending for Review Count (Statutory)
			int upcomingInternalNew = Integer.parseInt(OverduePOM.clickUpcomingInternal().getText());
			
			if(upcomingInternal > upcomingInternalNew)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Upcoming' Internal count decreased.");
			//	test.log(LogStatus.PASS, "Old Compliance Count = "+upcomingInternal+" | New Compliance Count = "+upcomingInternalNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Upcoming' Internal count doesn't decreased.");
			//	test.log(LogStatus.FAIL, "Old Compliance Count = "+upcomingInternal+" | New Compliance Count = "+upcomingInternalNew);
			}
			
			if(pendingcount1 > pendingCountInternal)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Internal count increased.");
			//	test.log(LogStatus.PASS, "Old Compliance Count = "+pendingCountInternal+" | New Compliance Count = "+pendingcount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Internal count doesn't increased.");
			//	test.log(LogStatus.FAIL, "Old Compliance Count = "+pendingCountInternal+" | New Compliance Count = "+pendingcount1);
			}
		}
		//OverduePOM.clickDashboard().click();	
	}
	
	public static void UpcomingComplianceCri( ExtentTest test, String Compliance, XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUpcomingStatutory()));	//Waiting for 'Upcoming Statutory' count to be clickable.
		
		int pendingCount = 0;
		int upcomingStatutory = 0;
		int pendingCountInternal = 0;
		int upcomingInternal = 0;
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			pendingCount = Integer.parseInt(OverduePOM.readPendingReviewStatutory().getText());	//Reading old Pending for Review Count (Statutory)
			Thread.sleep(100);
			upcomingStatutory = Integer.parseInt(OverduePOM.clickUpcomingStatutory().getText());	//Reading Upcoming Statutory count
			
			OverduePOM.clickUpcomingStatutory().click();					//Clicking on Upcoming Statutory count.
		}
		else
		{
			pendingCountInternal = Integer.parseInt(OverduePOM.readPendingReviewInternal().getText());
			upcomingInternal = Integer.parseInt(OverduePOM.clickUpcomingInternal().getText());
			
			OverduePOM.clickUpcomingInternal().click();					//Clicking on Upcoming Statutory count.
		}
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.checkTable()));	//Waiting for records table to get displayed.
		
		Thread.sleep(8000);
	//getDriver().findElement(By.xpath("//div[@class = 'k-multiselect-wrap k-floatwrap']")).click();
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 2600 px.
		Thread.sleep(2000);

		
			CFOcountPOM.readTotalItems4().click();
		String item1 = CFOcountPOM.readTotalItems4().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		
		if(bits1.length > 2)
		{
			Thread.sleep(2000);
		//	CFOcountPOM.readTotalItems4().click();
			item1 = CFOcountPOM.readTotalItems4().getText();
			bits1 = item1.split(" ");								//Splitting the String
		}
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
		if(compliancesCount1.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item1 = CFOcountPOM.readTotalItems4().getText();
			bits1 = item1.split(" ");									//Splitting the String
			compliancesCount1 = bits1[bits1.length - 2];
		}
		int count = Integer.parseInt(compliancesCount1);
		
		
		
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			if(upcomingStatutory == count)
			{
			//	test.log(LogStatus.PASS, "Before Perform :- Upcoming Statutory count matches to total number of compliances displayed.");
				test.log(LogStatus.PASS, "Before Perform :- Total Upcoming Statutory Compliance Count in the Grid = "+count+" | Dashboard Upcoming Statutory Compliance Count = "+upcomingStatutory);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Before Perform :- Upcoming Statutory count does not matches to total number of compliances displayed.");
				test.log(LogStatus.FAIL, "Before Perform :- Total Upcoming Statutory Compliance Count in the Grid = "+count+" | Dashboard Upcoming Statutory Compliance Count = "+upcomingStatutory);
			}
		}
		else
		{
			if(upcomingInternal == count)
			{
			//	test.log(LogStatus.PASS, "Before Perform :- Upcoming Internal count matches to total number of compliances displayed.");
				test.log(LogStatus.PASS, "Before Perform :- Total Upcoming Internal Compliance Count in the Grid = "+count+" | Dashboard Upcoming Internal Compliance Count = "+upcomingInternal);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Before Perform :- Upcoming Internal count does not matches to total number of compliances displayed.");
				test.log(LogStatus.FAIL, "Before Perform :- Total Upcoming Internal Compliance Count in the Grid = "+count+" | Dashboard Upcoming Internal Compliance Count = "+upcomingInternal);
			}
		}
		
		elementsList1 = OverduePOM.clickCalenderAction();	//Getting all action buttons (Statutory/Internal)
		elementsList1.get(1).click();					//Clicking on ith action button which has blue status 
		
		
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			
			try {
			if(OverduePOM.text().isDisplayed()) {
				getDriver().switchTo().parentFrame();
				OverduePOM.close().click();	
				elementsList1 = OverduePOM.clickCalenderAction();	//Getting all action buttons (Statutory/Internal)
				elementsList1.get(1).click();					//Clicking on ith action button which has blue status 
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iPerformerFrame"));
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,550)");	
				//test.log(LogStatus.PASS, "Compliance related task is not yet completed.");
			}}catch(Exception e) {
				
			}
			try{
				try {
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(3);
			}
			
			if(OverduePOM.fileUploadStatutory().isEnabled())
			{
				Thread.sleep(2000);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadStatutory1().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateStatutory().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate4().click();						//Clicking on date
			
			try
			{
				Thread.sleep(500);
				OverduePOM.valueSystem().sendKeys("100");				//Sending Value as per system.
				Thread.sleep(500);
				OverduePOM.valueReturn().sendKeys("50");				//Sending Value as per return.
			}
			catch(Exception e1)
			{
				
			}
			}
			catch(Exception e1)
			{
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
				OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");
			}
			
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.remark()));
			OverduePOM.remark().sendKeys("Automation Remark");	//Sending remark to text area.
			
			OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
			Thread.sleep(5000);
			try
			{
				getDriver().switchTo().alert().accept();
			}
			catch(Exception e1)
			{
				
			}
			try
			{
				getDriver().switchTo().alert().dismiss();
			}
			catch(Exception e1)
			{
				
			}
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
			

			}catch(Exception e1)
			{
				
			}
		}
	
		else
		{
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,550)");					//Scrolling down window by 2600 px.
			try {
			if(OverduePOM.text1().isDisplayed()) {
				getDriver().switchTo().parentFrame();
				OverduePOM.close1().click();	
				elementsList1 = OverduePOM.clickCalenderAction();	//Getting all action buttons (Statutory/Internal)
				elementsList1.get(1).click();	
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iInternalPerformerFrame"));
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,550)");	
			}
			}catch(Exception e) {
			try {
			Thread.sleep(500);
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting dropdown box
			int k = status.getOptions().size();
			System.out.println("Options = "+ k);
			if(k > 1)
			{
				status.selectByIndex(1);
			}
			
			if(OverduePOM.fileUploadInternal().isEnabled())
			{
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,700)");					//Scrolling down window by 2600 px.
				
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
			//	OverduePOM.buttonAddLinkInternal().click();						//Clicking on 'Add Link' button of Compliance Documents
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");			//Getting current user directory.
				OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
			}
			
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
			
			Thread.sleep(500);
			OverduePOM.selectDateInternal().click();				//Clicking on Date input box
			OverduePOM.selectLastMonth().click();					//Clicking on Last Month arrow
			Thread.sleep(500);
			OverduePOM.selectDate2().click();						//Clicking on date
			}
			catch(Exception e1) {
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadInternal()));
				OverduePOM.fileUploadInternal().sendKeys("D:\\Automation File\\Charge.xlsx");	
			}
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternalRemark()));
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Sending remark to text area.
			Thread.sleep(5000);
			OverduePOM.clickComplianceSubmit2().click();
			Thread.sleep(5000);
			try
			{
				getDriver().switchTo().alert().accept();
			}
			catch(Exception e1)
			{
				
			}
			try
			{
				getDriver().switchTo().alert().dismiss();
			}
			catch(Exception e1)
			{
				
			}
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
			}
		}
		
	/*	if(Compliance.equalsIgnoreCase("Statutory"))
		{
		Thread.sleep(5000);
		
			OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
			Thread.sleep(5000);
		}
		else {
			
			Thread.sleep(3000);
			OverduePOM.clickComplianceSubmit2().click();
			Thread.sleep(5000);
		}
		Thread.sleep(1000);
		try
		{
			getDriver().switchTo().alert().accept();
		}
		catch(Exception e)
		{
			
		}
		try
		{
			getDriver().switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		*/
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();					//Clicking on 'Dashboard'
		
		Thread.sleep(5000);
		if(Compliance.equalsIgnoreCase("Statutory"))
		{
			int pendingcount1 = Integer.parseInt(OverduePOM.readPendingReviewStatutory().getText());	//Reading new Pending for Review Count (Statutory)
			int upcomingStatutoryNew = Integer.parseInt(OverduePOM.clickUpcomingStatutory().getText());
			
			if(upcomingStatutory > upcomingStatutoryNew)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Upcoming' Statutory count decreased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+upcomingStatutory+" | New Compliance Count = "+upcomingStatutoryNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Upcoming' Statutory count doesn't decreased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+upcomingStatutory+" | New Compliance Count = "+upcomingStatutoryNew);
			}
			
			if(pendingcount1 > pendingCount)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+pendingCount+" | New Compliance Count = "+pendingcount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+pendingCount+" | New Compliance Count = "+pendingcount1);
			}
		}
		else
		{
			int pendingcount1 = Integer.parseInt(OverduePOM.readPendingReviewInternal().getText());	//Reading new Pending for Review Count (Statutory)
			int upcomingInternalNew = Integer.parseInt(OverduePOM.clickUpcomingInternal().getText());
			
			if(upcomingInternal > upcomingInternalNew)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Upcoming' Internal count decreased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+upcomingInternal+" | New Compliance Count = "+upcomingInternalNew);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Upcoming' Internal count doesn't decreased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+upcomingInternal+" | New Compliance Count = "+upcomingInternalNew);
			}
			
			if(pendingcount1 > pendingCountInternal)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Internal count increased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+pendingCountInternal+" | New Compliance Count = "+pendingcount1);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Internal count doesn't increased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+pendingCountInternal+" | New Compliance Count = "+pendingcount1);
			}
		}
		//OverduePOM.clickDashboard().click();	
		}
	
	public static void WorkspaceADExportStatutory( ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		Thread.sleep(500);
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.

		Thread.sleep(3000);
		OverduePOM.clickAdvancedSearch().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(2000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.ASExportbtn().click();				//Exporting (Downloading) file
		
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
		
		Thread.sleep(500);
		OverduePOM.clickClose1().click();	
		Thread.sleep(500);
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();	
		Thread.sleep(500);
		
		
	}
	

	public static void WorkspaceOverdueStatutory( ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		Thread.sleep(500);
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		Thread.sleep(1000);
		OverduePOM.clickUserDropDown().click();		//Clicking on User DropDown
		Thread.sleep(300);
		OverduePOM.clickPerformer().click();			//CLicking on Performer under User DropDown.
		Thread.sleep(500);
		OverduePOM.selectType().click();				//Clicking on Overdue dropdown
		Thread.sleep(300);
		OverduePOM.clickOverdue().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(3000);
		OverduePOM.Period().click();			//Clicking on Status dropdown
		Thread.sleep(3000);
		OverduePOM.AllPeriod().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(3000);
		OverduePOM.clickApply().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(3000);
		Thread.sleep(1000);
		//litigationPerformer.MethodsPOM.progress();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		//StatutoryOverdue();							//Called the Method of Dashboard Statutory Overdue.
		
		Thread.sleep(1000);		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");
		
		CFOcountPOM.readTotalItems4().click();
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems4().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(compliancesCount);
				
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		
		Thread.sleep(500);
		OverdueCount.message();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickStatutoryOverdue()));
		String string_overdueStatutory = OverduePOM.clickStatutoryOverdue().getText();		//Storing old value of Statutory overdue.
		int overdueStatutory = Integer.parseInt(string_overdueStatutory);
			
		if(overdueStatutory == count)
		{
		//	test.log(LogStatus.PASS, "My Workspace - Statutory Overdue count matches to Dashboard Statutory Overdue count.");
			test.log(LogStatus.PASS, "My Workspace - Statutory Overdue count = " + count + " | Dashboard Statutory Overdue count = "+overdueStatutory); 
		}
		else
		{
			//test.log(LogStatus.FAIL, "My Workspace - Statutory Overdue count does not matches to Dashboard Statutory Overdue count.");
			test.log(LogStatus.FAIL, "My Workspace - Statutory Overdue count = " + count + " | Dashboard Statutory Overdue count = "+overdueStatutory);
		}
	}
	
	public static void WorkspaceADExportInternal( ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		Thread.sleep(500);
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.

		Thread.sleep(500);
		OverduePOM.clickAdvancedSearch().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(2000);
		
		OverduePOM.ComplianceType1().click();			//Clicking on 'Compliance' under My Workspace
		
		Thread.sleep(500);
		OverduePOM.SelectAll().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(2000);
		OverduePOM.SelectAll().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(2000);
		
		OverduePOM.SelectInternal1().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(2000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		OverduePOM.ASExportbtn().click();				//Exporting (Downloading) file
		
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
		
		Thread.sleep(2000);
		OverduePOM.clickClose1().click();	
		Thread.sleep(500);
		
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();	
		Thread.sleep(500);
		
		
	}
	
	public static void WorkspaceOverdueInternal( ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		Thread.sleep(500);
		//wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickMyWorkspace()));
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		Thread.sleep(500);
		OverduePOM.clickUserDropDown().click();		//Clicking on User DropDown
		Thread.sleep(300);
		OverduePOM.clickPerformer().click();			//CLicking on Performer under User DropDown.
		
		Thread.sleep(3000);
		OverduePOM.selectType().click();				//Clicking on Overdue dropdown
		Thread.sleep(2000);
		OverduePOM.clickOverdue().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(3000);
		OverduePOM.Period().click();			//Clicking on Status dropdown
		Thread.sleep(3000);
		OverduePOM.AllPeriod().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(3000);
		OverduePOM.ComplianceTypeIn().click();			//Clicking on Status dropdown
		Thread.sleep(3000);
		OverduePOM.StatutoryCT().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(1000);
		OverduePOM.StatutoryCheckListCT().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(1000);
		OverduePOM.StatutoryLicenseCT().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(1000);
		OverduePOM.EventBasedCT().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(1000);
		OverduePOM.InternalCT().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(1000);
		OverduePOM.InternalLicenseCT().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(1000);
		OverduePOM.clickApply().click();			//Clicking on 'Overdue' under Status dropdown
		Thread.sleep(3000);
		Thread.sleep(500);
	
			
		
		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
	//	StatutoryOverdue();							//Called the Method of Dashboard Statutory Overdue.
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");
		
		CFOcountPOM.readTotalItems4().click();
		Thread.sleep(500);
		String item1 = CFOcountPOM.readTotalItems4().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount1);
				
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		
		Thread.sleep(500);
		OverdueCount.message();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickInternalOverdue()));
		String string_overdueInternal = OverduePOM.clickInternalOverdue().getText();		//Storing old value of Statutory overdue.
		int overdueInternal = Integer.parseInt(string_overdueInternal);
		
		if(overdueInternal == count1)
		{
			//test.log(LogStatus.PASS, "My Workspace - Internal Overdue count matches to Dashboard Internal Overdue count.");
			test.log(LogStatus.PASS, "My Workspace - Internal Overdue count = " + count1 + " | Dashboard Internal Overdue count = "+overdueInternal); 
		}
		else
		{
		//	test.log(LogStatus.FAIL, "My Workspace - Internal Overdue count does not matches to Dashboard Internal Overdue count.");
		    test.log(LogStatus.FAIL, "My Workspace - Internal Overdue count = " + count1 + " | Dashboard Internal Overdue count = "+overdueInternal);
		}
	}

	public static void ReviewedApprovedCount( ExtentTest test, XSSFWorkbook workbook, String string) {
		// TODO Auto-generated method stub
		
	}
	
	public static void WorkspacePenaltyUpdation( ExtentTest test)throws InterruptedException
	{

		
  		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		Thread.sleep(500);
		OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		Thread.sleep(1000);
		OverduePOM.clickMoreActions().click();
		Thread.sleep(3000);
		OverduePOM.ClickUpdatePenalty().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']")));	//Waiting for records table to get visible.
		int total = Integer.parseInt(OverduePOM.ReadCount().getText());
		Thread.sleep(3000);
		elementsList=OverduePOM.clickActionBtn();
		elementsList.get(0).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_UpdatePanel1']/fieldset[1]/table")));	//Waiting for records table to get visible.
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtInterest']")).sendKeys("124");
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtPenalty']")).sendKeys("113");
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtremark']")).sendKeys("automation");
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")).click();
		Thread.sleep(3000);
		int total1 = Integer.parseInt(OverduePOM.ReadCount().getText());
		Thread.sleep(3000);
		if(total >total1)
		{
			test.log(LogStatus.PASS, "Update Penalty Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Penalty does not update");
		}
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(1000);
		
	}

	public static void PerformUpcomingStatutory( ExtentTest test)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTUpcomingStatutory()));
		//int DasCount = Integer.parseInt(OverduePOM.clickPTUpcomingStatutory().getText());
		
		
		String string_overdueStatutory = OverduePOM.clickPTUpcomingStatutory().getText();		//Storing old value of Statutory overdue.
		int	overdueStatutory = Integer.parseInt(string_overdueStatutory);
		String string_reviewStatutory = ReviewerPOM.ClickPendingForReviewStatutoryPer().getText();	//Storing old value of Pending Review.
		int	reviewStatutory = Integer.parseInt(string_reviewStatutory);
		
		Thread.sleep(500);
		OverduePOM.clickPTUpcomingStatutory().click();
		
		
		Thread.sleep(8000);
		//litigationPerformer.MethodsPOM.progress();
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = 'grid']")));
		//Thread.sleep(5000);
		//js.executeScript("window.scrollBy(0,2000)"," ");
		
//		Thread.sleep(5000);
//		CFOcountPOM.readTotalItems5().click();					//Clicking on total items count
//		Thread.sleep(500);
//		String item = CFOcountPOM.readTotalItems5().getText();	//Reading total items String value
//		String[] bits = item.split(" ");								//Splitting the String
//		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
//		int count = Integer.parseInt(compliancesCount);
		
		
//		if(overdueStatutory == count)
//		{
//		
//			test.log(LogStatus.PASS, "Before Perform :- Total Stautory 'Overdue' Compliance Count in the Grid = "+count+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Before Perform :- Total  Stautory 'Overdue' Count in the Grid = "+count+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
//		}
		
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		
		
		if(overdueStatutory == GridCount)
		{
		
			test.log(LogStatus.PASS, "Before Perform :- Total Stautory 'Overdue' Compliance Count in the Grid = "+GridCount+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		else
		{
			test.log(LogStatus.FAIL, "Before Perform :- Total  Stautory 'Overdue' Count in the Grid = "+GridCount+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
	
		getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
	
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(4000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
			Thread.sleep(500);
			Thread.sleep(2000);
			//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
			getDriver().switchTo().parentFrame();
			getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
			/*Thread.sleep(3000);
			if(DasCount ==GridCount)
			{
				test.log(LogStatus.PASS, "Dashboard count matches to grid count");
			}
			else
			{
				test.log(LogStatus.FAIL, "Dashboard count does not matches to grid count");
			}*/
		
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPTUpcomingStatutory()));
			Thread.sleep(1000);
			String string_overdueStatutoryNew = OverduePOM.clickPTUpcomingStatutory().getText();		//Storing old value of Statutory overdue.
			int	newOverdueStatutory = Integer.parseInt(string_overdueStatutoryNew);
			String string_reviewStatutoryNew = ReviewerPOM.ClickPendingForReviewStatutoryPer().getText();	//Storing old value of Pending Review.
			int newReviewStatutory = Integer.parseInt(string_reviewStatutoryNew);
			Thread.sleep(1000);
			if(overdueStatutory > newOverdueStatutory)
			{
				test.log(LogStatus.PASS, "After Perform :- Stautory 'Overdue' count decreased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- Stautory 'Overdue' count doesn't decreased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
			}
			
			if(newReviewStatutory > reviewStatutory)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
			}
		
	}
	
	public static void PerformUpcomingInternal( ExtentTest test)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		
		
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTUpcomingInternal()));
		int DasCount = Integer.parseInt(OverduePOM.clickPTUpcomingInternal().getText());

		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		OverduePOM.clickPTUpcomingInternal().click();
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
		
		getDriver().switchTo().frame("showdetails");	
		Thread.sleep(500);
		Select status1 = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box.
		status1.selectByIndex(1);								//Selecting 2nd value from dropdown.
		
	//	js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
		Thread.sleep(2000);
	//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		getDriver().switchTo().parentFrame();
		getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		if(DasCount ==GridCount)
		{
			test.log(LogStatus.PASS, "Dashboard count-" +DasCount+" matches to grid count-" +GridCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count does not matches to grid count");
		}
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(1000);
		
	}
	
	public static void PerformOverdueStatutory( ExtentTest test)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		
		
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTOverdueStatutory()));
		int DasCount = Integer.parseInt(OverduePOM.clickPTOverdueStatutory().getText());
		Thread.sleep(500);
		OverduePOM.clickPTOverdueStatutory().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
	
		getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
	
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
		Thread.sleep(2000);
	//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		getDriver().switchTo().parentFrame();
		getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		if(DasCount ==GridCount)
		{
			test.log(LogStatus.PASS, "Dashboard count-" +DasCount+" matches to grid count-" +GridCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count does not matches to grid count");
		}
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(1000);
		
	}
	
	public static void PerformOverdueInternal( ExtentTest test)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
	
		
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTOverdueInternal()));
		int DasCount = Integer.parseInt(OverduePOM.clickPTOverdueInternal().getText());

		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		OverduePOM.clickPTOverdueInternal().click();
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
		
		getDriver().switchTo().frame("showdetails");	
		Thread.sleep(500);
		Select status1 = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box.
		status1.selectByIndex(1);								//Selecting 2nd value from dropdown.
		
	//	js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
		Thread.sleep(2000);
	//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		getDriver().switchTo().parentFrame();
		getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		if(DasCount ==GridCount)
		{
			test.log(LogStatus.PASS, "Dashboard count-"+DasCount+" matches to grid count-"+GridCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count does not matches to grid count");
		}
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(1000);
		
	}
	
	public static void PerformRejectedStatutory( ExtentTest test)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
	
		
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTRejectedStatutory()));
		int DasCount = Integer.parseInt(OverduePOM.clickPTRejectedStatutory().getText());
		Thread.sleep(500);
		OverduePOM.clickPTRejectedStatutory().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);		
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
	//getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer_btnChangeStatus_0']")).click();
	Thread.sleep(4000);
	getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
	
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(2000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
		Thread.sleep(2000);
	//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		getDriver().switchTo().parentFrame();
		getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		if(DasCount ==GridCount)
		{
			test.log(LogStatus.PASS, "Dashboard count-" +DasCount+" matches to grid count-" +GridCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count does not matches to grid count");
		}
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(1000);
		
	}
	
	public static void PerformRejectedInternal( ExtentTest test)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		
		
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickPTRejectedInternal()));
		int DasCount = Integer.parseInt(OverduePOM.clickPTRejectedInternal().getText());

		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		OverduePOM.clickPTRejectedInternal().click();
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
		
		getDriver().switchTo().frame("showdetails");	
		Thread.sleep(500);
		Select status1 = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box.
		status1.selectByIndex(1);								//Selecting 2nd value from dropdown.
		
	//	js.executeScript("window.scrollBy(0,2000)"," ");		//Scrolling down window by 2000 px.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
		Thread.sleep(2000);
	//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		getDriver().switchTo().parentFrame();
		getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		if(DasCount ==GridCount)
		{
			test.log(LogStatus.PASS, "Dashboard count-"+DasCount+" matches to grid count-"+GridCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard count does not matches to grid count");
		}
		
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(1000);
		
	}
	
	public static void TaskReport( ExtentTest test)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//------------------------------------- Statutory ------------------------------------
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		OverduePOM.ClickTaskReport().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[4]")));	//Wait till records table gets visible
		Thread.sleep(500);
//		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
//			CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
			
			test.log(LogStatus.PASS, "While Click on Task Report All Assigned Task should be displayed Successfully");
		Thread.sleep(5000);
		CFOcountPOM.clickExportImage().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Statutory-Export Succefully");
		Thread.sleep(1000);
		}else {
			test.log(LogStatus.PASS, "no record found");
		}
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(5000);
		CFOcountPOM.clickExportExcel().click();
		Thread.sleep(2000);
		
		
		test.log(LogStatus.PASS, "Statutory-Advanced Search-Export Succefully");
		getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
		Thread.sleep(2000);
		//------------------------------------- Internal ------------------------------------
		
		getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[1]/span[2]/span/span[2]/span")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]")).click();
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Internal-Export Succefully");
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//*[@id='dvdropdownlistComplianceType1']/span/span/span[2]/span")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType1_listbox']/li[2]")).click();
		Thread.sleep(500);
		CFOcountPOM.clickExportExcel().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Internal- Advanced Search-Export Succefully");
		getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']")).click();
		Thread.sleep(2000);
		
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(1000);
	}
	
	public static void EventReport( ExtentTest test)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		Thread.sleep(2000);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
//	WebElement Scroll=	getDriver().findElement(By.xpath("//*[@id='ascrail2001']/div"));
//	((JavascriptExecutor)).executeScript("argument[0].scrollIntoView(true);",Scroll,500);
		Thread.sleep(3000);
		OverduePOM.ClickEventReport().click();
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		CFOcountPOM.clickExportExcel().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));	//Wait till records table gets visible
		Thread.sleep(500);
		
	/*	
		getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[1]/span/span")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("(//a[@class='k-link'])[37]")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[2]/span/span")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("(//a[@class='k-link'])[83]")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='Applybtn']")).click();
		Thread.sleep(3000);*/
		test.log(LogStatus.PASS, "Apply button is working");
		getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "clear button is working");
	OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
		Thread.sleep(2000);
	}
	
	public static void DetailedReportRisk(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		OverduePOM.ClickDropD().click();
		Thread.sleep(500);
		OverduePOM.SelectPerformer().click();
		Thread.sleep(500);
		OverduePOM.clickApply().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(3000);
		OverduePOM.clickRiskD().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorR));
		Thread.sleep(4000);
		WebElement clickHigh = getDriver().findElement(locatorR);	
		Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
	/*	getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-more-vertical'])[10]")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("(//li[@class='k-item k-columns-item k-state-default'])")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("(//li[@class='k-item k-state-default k-first'])[1]")).click();*/
		Thread.sleep(1000);

	
        Thread.sleep(8000);
	WebElement HighText=	getDriver().findElement(By.xpath("//*[@id='ddlrisk0']/span[1]"));
	Thread.sleep(1000);
	String Text=HighText.getText();
	Thread.sleep(1000);
	 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
	 int columns_count = Risks.size();
	 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
	 for (int column = 0; column < columns_count; column++) {
		 
		 String celtext = Risks.get(column).getText();
		 
		 if(celtext.equalsIgnoreCase("High")) 
		 {
				test.log(LogStatus.PASS, "Value Matching : "+"Risk Value-"+Text+" And Cell Value= "+celtext);
			}
			else
			{
				test.log(LogStatus.FAIL, "Value Not Matching :"+"Risk Value-"+Text+"And Cell Value="+celtext);
				test.log(LogStatus.FAIL, " All Value of Risk Cell is Not Matching to Selected Risk");
				break;
			} 
		
	 }
	 Thread.sleep(2000);
	 
	 OverduePOM.clickDashboard().click();
	
	 Thread.sleep(3000);
	
	
	}
	
	public static void DetailedReportCD(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		OverduePOM.ClickDropD().click();
		Thread.sleep(500);
		OverduePOM.SelectPerformer().click();
		Thread.sleep(500);
		OverduePOM.clickApply().click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(4000);
		OverduePOM.ComplianceType().click();
		Thread.sleep(500);
		OverduePOM.Statutory().click();
		Thread.sleep(1000);
		Thread.sleep(500);
		OverduePOM.StatutoryCheckList().click();
		Thread.sleep(1000);
		OverduePOM.Status().click();
		Thread.sleep(500);
		OverduePOM.ClosedTimely().click();
		Thread.sleep(1000);
		OverduePOM.clickApply().click();
		Thread.sleep(8000);	
	
	 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
	 int columns_count = Risks.size();
	 Thread.sleep(8000);	
	 for (int column = 0; column < columns_count; column++) {
		 
		 String celtext = Risks.get(column).getText();
		 Thread.sleep(3000);	
		 if(celtext.equalsIgnoreCase("Closed Timely")) 
		 {
				test.log(LogStatus.PASS, "while Selecting closed Timely status And Click Apply Button complaince should be display as closed Timely status.");
			}
			else
			{
				test.log(LogStatus.FAIL, "while click on Apply Button complaince should not display closed Timely status.");
				
				break;
			} 
		
	 }
	 Thread.sleep(3000);
	 /*
	 Thread.sleep(1000);
		OverduePOM.Status().click();
		Thread.sleep(500);
		OverduePOM.ClosedTimely().click();
		Thread.sleep(1000);
		OverduePOM.ClosedDelayed().click();
		Thread.sleep(1000);
		
		OverduePOM.clickApply().click();
		Thread.sleep(8000);	
	
	 List<WebElement> CD=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
	 int columns_count1 = CD.size();
	
	 for (int column = 0; column < columns_count1; column++) {
		 
		 String celtext = Risks.get(column).getText();
		 
		 if(celtext.equalsIgnoreCase("Closed Delayed")) 
		 {
				test.log(LogStatus.PASS, "while click on Apply Button complaince should be display as closed delayed status.");
			}
			else
			{
				test.log(LogStatus.FAIL, "while click on Apply Button complaince should be display as closed delayed status.");
				
				break;
			} 
		
	 }
	 Thread.sleep(2000);
	 */
	 
	 OverduePOM.clickDashboard().click();
	
	 Thread.sleep(3000);
	
	
	}
	
	public static void DetailedReport1(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		OverduePOM.ClickDropD().click();
		Thread.sleep(3000);
		OverduePOM.SelectPerformer().click();
		Thread.sleep(500);
		OverduePOM.clickApply().click();
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
		Thread.sleep(7000);
		OverduePOM.ClickDropDAd().click();
		Thread.sleep(500);
		OverduePOM.SelectPerformerAd().click();
		Thread.sleep(500);
		OverduePOM.clickApplyAd().click();
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
	/*	CFOcountPOM.selectMonth1().click();
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
			*/
			OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(3000);
			OverduePOM.clickDashboard().click();
	}

	public static void DetailedReportIn(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		OverduePOM.ClickDropD().click();
		Thread.sleep(500);
		OverduePOM.SelectPerformer().click();
		Thread.sleep(500);
		OverduePOM.clickApply().click();
		Thread.sleep(500);
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
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(7000);
		OverduePOM.ClickDropDAd().click();
		Thread.sleep(500);
		OverduePOM.SelectPerformerAd().click();
		Thread.sleep(500);
		OverduePOM.clickApplyAd().click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
//	OverduePOM.clickcomplianceTypeAS().click();
	Thread.sleep(1000);
//	OverduePOM.clickcomplianceStaAS().click();
	Thread.sleep(1000);
//	OverduePOM.clickcomplianceINAS().click();
	
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
		/*	CFOcountPOM.selectMonth1().click();
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
			*/
			OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);
			OverduePOM.clickDashboard().click();
	}
	
	public static void complianceRepository(ExtentTest test) throws InterruptedException, IOException
	{
		
		 WebDriverWait wait = new WebDriverWait(getDriver(), (160));
	 	    
	 		Thread.sleep(500);
	 		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
	 		
	 			Thread.sleep(2000);
	 		CFOcountPOM.clickActRepository().click();			//Clicking on 'Detailed Reports' 
	 		Thread.sleep(2000);
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
	 		Thread.sleep(1000);
	 		getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[11]/a")).click();
	 		Thread.sleep(4000);
	 		getDriver().findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button")).click();
	 		Thread.sleep(3000);
	 		test.log(LogStatus.PASS, "Overview successfully");
	 		OverduePOM.clickDashboard().click();
		
	}
	
	public static void complianceDocumentSta(ExtentTest test) throws InterruptedException, IOException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		 By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeViewDoc().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Download Successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeOverViewDoc().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "OverView Successfully");
			Thread.sleep(500);
			 By locator1 = By.xpath("//*[@id='sel_chkbxMain']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = getDriver().findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Mutiple checkBox check and download Successfully ");
				Thread.sleep(1000);
				OverduePOM.clickRisk().click();
				Thread.sleep(500);
				OverduePOM.clickRiskCritical().click();
				Thread.sleep(1000);
				OverduePOM.clickClearBtn().click();
				test.log(LogStatus.PASS, "Clear btn is working");
				Thread.sleep(4000);
				CFOcountPOM.clickAdvancedSearch().click();
				Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[23]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = getDriver().findElements(locator2);	
			Thread.sleep(3000);
			ViewButton1.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - View Successfully");
			ViewButton1.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - Download Successfully");
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			test.log(LogStatus.PASS, "Advanced Search - OverView Successfully");
			Thread.sleep(5000);
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = getDriver().findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				Thread.sleep(500);
				ChechBoxes1.get(1).click();
				Thread.sleep(500);
				ChechBoxes1.get(2).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Advanced Search - Mutiple checkBox check and download Successfully ");
				CFOcountPOM.closeDocumentAS().click();
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();	
	}
	
	public static void complianceDocumentIn(ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		OverduePOM.clickStatus().click();
		Thread.sleep(1000);
		OverduePOM.SelectInternal().click();
		Thread.sleep(7000);
		 By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeViewDoc().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn1().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Download Successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeOverViewDoc().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "OverView Successfully");
			Thread.sleep(500);
			 By locator1 = By.xpath("//*[@id='sel_chkbxMain']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = getDriver().findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);   
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Mutiple checkBox check and download Successfully ");
				Thread.sleep(1000);
				OverduePOM.clickRisk().click();
				Thread.sleep(500);
				OverduePOM.clickRiskCritical().click();
				Thread.sleep(1000);
				OverduePOM.clickClearBtn().click();
				test.log(LogStatus.PASS, "Clear btn is working");
				Thread.sleep(4000);
				CFOcountPOM.clickAdvancedSearch().click();
				Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			OverduePOM.clickStatusAS().click();
			Thread.sleep(500);
			OverduePOM.SelectInternalAS().click();
			Thread.sleep(5000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[23]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = getDriver().findElements(locator2);	
			Thread.sleep(3000);
			ViewButton1.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - View Successfully");
		/*	ViewButton1.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - Download Successfully");*/
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			test.log(LogStatus.PASS, "Advanced Search - OverView Successfully");
			Thread.sleep(5000);
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = getDriver().findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				Thread.sleep(500);
				ChechBoxes1.get(1).click();
				Thread.sleep(500);
				ChechBoxes1.get(2).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Advanced Search - Mutiple checkBox check and download Successfully ");
				CFOcountPOM.closeDocumentAS().click();
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();		
		
	}
	
	public static void SupportTicket(ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(),(40));
		Thread.sleep(1000);
		OverduePOM.ClickSupportTicket().click();
		Thread.sleep(4000);
		OverduePOM.TicketSub().sendKeys("XYZ");
		Thread.sleep(1000);
		Select SelectIssue = new Select(OverduePOM.ClickSelectIssue());
		Thread.sleep(2000);
		SelectIssue.selectByIndex(1);
		Thread.sleep(2000);
		OverduePOM.TicketMessage().sendKeys("ABc");
		Thread.sleep(1000);
		OverduePOM.ClickCreateTicket().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Msg Displayed -'Ticket raised Successfully'");
			
	}
	
	public static void ActDocuments(ExtentTest test) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickActDocuments().click();			//Clicking on 'Act Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[5]/a");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View Successfully'");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			getDriver().findElement(By.xpath("//*[@id='basic']/tbody/tr[3]/td[2]")).click();
			Thread.sleep(4000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Download Successfully'");
			performer.OverduePOM.clickDashboard().click();
		
	}
	
	public static void WhatsNew(ExtentTest test) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		Thread.sleep(3000);
		if(OverduePOM.WhatsNewIcon().isDisplayed()) {
		
			test.log(LogStatus.PASS, "On My Dashboard 'What’s New' Icon should be displayed");
			
		}
		OverduePOM.WhatsNewIcon().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(1000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(4000);
		
		OverduePOM.WhatsNewView().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		OverduePOM.WhatsNewViewClose().click();					//Clicking on 'My Documents'
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "While Click on 'view ' Button . Release Document should be Viewed.");
			
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		Thread.sleep(3000);
		Thread.sleep(500);
		OverduePOM.WhatsNewDownload().click();		//Exporting (Downloading) file
		Thread.sleep(5000);
		
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		}else {
			test.log(LogStatus.PASS,  "  No records found Displyed");
		}
		Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
	}
	
	public static void complianceDocumentStaCri(ExtentTest test) throws InterruptedException, IOException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		OverduePOM.Peroid().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		OverduePOM.AllPeroid().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		OverduePOM.Apply().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(8000);
		
		 By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Download Successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "OverView Successfully");
			Thread.sleep(500);
			 By locator1 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = getDriver().findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Mutiple checkBox check and download Successfully ");
				Thread.sleep(1000);
				
				OverduePOM.clickDashboard().click();	
	}
	
	public static void complianceDocumentInCri(ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		OverduePOM.Peroid().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		OverduePOM.AllPeroid().click();			//Clicking on 'Compliance Documents ' 

		Thread.sleep(3000);
		OverduePOM.clickStatus().click();
		Thread.sleep(1000);
		OverduePOM.SelectInternal().click();
		Thread.sleep(3000);
		OverduePOM.Apply().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(8000);
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[24]/a")));	//Wait till records table gets visible
		Thread.sleep(8000);
		 By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[24]/a");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn1().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Download Successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "OverView Successfully");
			Thread.sleep(500);
			 By locator1 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = getDriver().findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);   
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Mutiple checkBox check and download Successfully ");
				Thread.sleep(1000);
				
				OverduePOM.clickDashboard().click();		
		
	}
	
	public static void MyLeave(ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (180));
	    
		Thread.sleep(500);
	
		OverduePOM.UserIcon().click();
		Thread.sleep(1000);
		OverduePOM.MyLeave().click();
		Thread.sleep(8000);

		OverduePOM.TemporaryAssignment().click();
		Thread.sleep(8000);
		OverduePOM.AddNew().click();
		Thread.sleep(8000);
		OverduePOM.StartDateML().click();
		Thread.sleep(2000);
		OverduePOM.StartDateML1().click();
		Thread.sleep(8000);
		
		OverduePOM.EndDateML().click();
		Thread.sleep(2000);
		OverduePOM.EndDateML1().click();
		Thread.sleep(8000);
		
		OverduePOM.NewUserPerformer().click();
		Thread.sleep(2000);
		OverduePOM.NewUserPerformer1().click();
		Thread.sleep(8000);
	
		OverduePOM.NewUserReviewer().click();
		Thread.sleep(2000);
		OverduePOM.NewUserReviewer1().click();
		Thread.sleep(8000);
		
		OverduePOM.NewEventOwner().click();
		Thread.sleep(2000);
		OverduePOM.NewEventOwner1().click();
		Thread.sleep(8000);
		
		OverduePOM.CheckBox().click();
		Thread.sleep(8000);
		

		OverduePOM.Save().click();
		Thread.sleep(7000);
		
		test.log(LogStatus.PASS, "The compliance should get reassign to new users and leave detailes  should be seen on Temporary assignment page. ");
		Thread.sleep(1000);
		
				
				OverduePOM.clickDashboard().click();		
		
	}
	
	public static void MyLeaveIn(ExtentTest test) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (180));
	    
		Thread.sleep(500);
	
		OverduePOM.UserIcon().click();
		Thread.sleep(1000);
		OverduePOM.MyLeave().click();
		Thread.sleep(8000);

		OverduePOM.TemporaryAssignment().click();
		Thread.sleep(8000);
		OverduePOM.AddNew().click();
		Thread.sleep(8000);
		OverduePOM.Internal().click();
		Thread.sleep(8000);
		OverduePOM.StartDateML().click();
		Thread.sleep(2000);
		OverduePOM.StartDateML1().click();
		Thread.sleep(8000);
		
		OverduePOM.EndDateML().click();
		Thread.sleep(2000);
		OverduePOM.EndDateML1().click();
		Thread.sleep(8000);
		
		OverduePOM.NewUserPerformer().click();
		Thread.sleep(2000);
		OverduePOM.NewUserPerformer1().click();
		Thread.sleep(8000);
	
		OverduePOM.NewUserReviewer().click();
		Thread.sleep(2000);
		OverduePOM.NewUserReviewer1().click();
		Thread.sleep(8000);
		
		OverduePOM.NewEventOwner().click();
		Thread.sleep(2000);
		OverduePOM.NewEventOwner1().click();
		Thread.sleep(8000);
		
		OverduePOM.CheckBox().click();
		Thread.sleep(8000);
		

		OverduePOM.Save().click();
		Thread.sleep(7000);
		
		test.log(LogStatus.PASS, "The compliance should get reassign to new users and leave detailes  should be seen on Temporary assignment page. ");
		Thread.sleep(1000);
		
				
				OverduePOM.clickDashboard().click();		
		
	}
	
	
	
	public static void WorkspaceSR( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("test3",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void WorkspaceSRFm( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();				//Clicking on 'Compliance' under My Workspace
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		/*
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		*/
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	
	public static void SecondaryReDisplay( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		Thread.sleep(3000);

	
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("test3",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		
		OverduePOM.ComplianceLocationST().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationACD().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationACD1().click();
			Thread.sleep(3000);
			
			OverduePOM.CLLPvt().click();
				Thread.sleep(4000);
				OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.ReportingLocation().click();
		Thread.sleep(2000);
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(3000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		
		OverduePOM.Startdate().click();
		Thread.sleep(3000);
		OverduePOM.date18().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.TPerformer().click();
		Thread.sleep(3000);
		OverduePOM.abcExternal().click();
		Thread.sleep(8000);
		
		OverduePOM.TReviewer().click();
		Thread.sleep(3000);
		OverduePOM.abclawyer().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer221().click();
		Thread.sleep(3000);
		OverduePOM.TReviewer22().click();
		Thread.sleep(8000);
		
		OverduePOM.SaveBtn().click();
		Thread.sleep(8000);
		
	//	String Msg =	OverduePOM.TAmsg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The record of assignment of task to secondary reviewer should be seen on the popup of show assgnment details. " );
			Thread.sleep(3000);
		

			OverduePOM.CloseTab().click();
		Thread.sleep(5000);


	}
	
	public static void SecondaryReDisplayFm( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		Thread.sleep(3000);

	
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();	
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
	/*	
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		*/
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		
		OverduePOM.ComplianceLocationST().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationACD().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationACD1().click();
			Thread.sleep(3000);
			
			OverduePOM.CLLPvt().click();
				Thread.sleep(4000);
				OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.ReportingLocation().click();
		Thread.sleep(2000);
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(3000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		
		OverduePOM.Startdate().click();
		Thread.sleep(3000);
		OverduePOM.date18().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.TPerformer().click();
		Thread.sleep(3000);
		OverduePOM.abcExternal().click();
		Thread.sleep(8000);
		
		OverduePOM.TReviewer().click();
		Thread.sleep(3000);
		OverduePOM.abclawyer().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer221().click();
		Thread.sleep(3000);
		OverduePOM.TReviewer22().click();
		Thread.sleep(8000);
		
		OverduePOM.SaveBtn().click();
		Thread.sleep(8000);
		
	//	String Msg =	OverduePOM.TAmsg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The record of assignment of task to secondary reviewer should be seen on the popup of show assgnment details. " );
			Thread.sleep(3000);
		

			OverduePOM.CloseTab().click();
		Thread.sleep(5000);


	}
	
	
	public static void SRWorkspaceSRFm( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();					//Clicking on 'Compliance' under My Workspace
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		/*
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		*/
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.SubTask().click();			
		Thread.sleep(5000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void SRWorkspaceSR( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("test3",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.SubTask().click();			
		Thread.sleep(5000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void SRWorkspaceSRDis( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("test3",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.SubTask().click();			
		Thread.sleep(5000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(8000);
		
		
		OverduePOM.ComplianceLocationT().click();
		Thread.sleep(3000);
		
		
		OverduePOM.ComplianceLocationTABCD().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationTABCD1().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationTABCD2().click();
		Thread.sleep(3000);
	
		OverduePOM.LPvtLtd().click();
			Thread.sleep(3000);
			
			
				OverduePOM.ComplianceLocationT().click();
		Thread.sleep(3000);
		
		OverduePOM.ReportingLocation().click();
		Thread.sleep(2000);
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(3000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(8000);
		
		
		OverduePOM.Startdate().click();
		Thread.sleep(3000);
		OverduePOM.date18().click();
		Thread.sleep(8000);
		
		
		OverduePOM.STPerformer().click();
		Thread.sleep(3000);
		OverduePOM.abcExternal().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer().click();
		Thread.sleep(3000);
		OverduePOM.abclawyer1().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer221Fm().click();
		Thread.sleep(3000);
		OverduePOM.Reviewer221Fm1().click();
		Thread.sleep(8000);
		
		OverduePOM.SaveBtn().click();
		Thread.sleep(8000);
		
	//	String Msg =	OverduePOM.TAmsg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The record of assignment of sub-task to secondary reviewer should be seen on the popup of show assgnment details." );
			Thread.sleep(5000);
		

		
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void SRWorkspaceSRDisFm( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();				//Clicking on 'Compliance' under My Workspace
		
		/*//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		Thread.sleep(2000);
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		*/
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TypeofSearch().sendKeys("Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.SubTask().click();			
		Thread.sleep(5000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(8000);
		
		OverduePOM.ComplianceLocationT().click();
		Thread.sleep(3000);
		
		
		OverduePOM.ComplianceLocationTABCD().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationTABCD1().click();
		Thread.sleep(3000);
		OverduePOM.ComplianceLocationTABCD2().click();
		Thread.sleep(3000);
	
		OverduePOM.LPvtLtd().click();
			Thread.sleep(3000);
			
			
				OverduePOM.ComplianceLocationT().click();
		Thread.sleep(3000);
		
		OverduePOM.ReportingLocation().click();
		Thread.sleep(2000);
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(3000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(8000);
		
		
		OverduePOM.Startdate().click();
		Thread.sleep(3000);
		OverduePOM.date18().click();
		Thread.sleep(8000);
		
		
		OverduePOM.STPerformer().click();
		Thread.sleep(3000);
		OverduePOM.abcExternal().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer().click();
		Thread.sleep(3000);
		OverduePOM.abclawyer1().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer221Fm().click();
		Thread.sleep(3000);
		OverduePOM.Reviewer221Fm1().click();
		Thread.sleep(8000);
		
		OverduePOM.SaveBtn().click();
		Thread.sleep(8000);
		
	//	String Msg =	OverduePOM.TAmsg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The record of assignment of sub-task to secondary reviewer should be seen on the popup of show assgnment details." );
			Thread.sleep(5000);
		

		
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void WorkspaceSRIn( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		OverduePOM.TaskType().click();		
		Thread.sleep(2000);
		OverduePOM.TaskType1().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(4000);
		
		OverduePOM.TypeofSearch().sendKeys("Bill Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void SecondaryReDisplayIn( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		Thread.sleep(3000);

	
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		OverduePOM.TaskType().click();		
		Thread.sleep(2000);
		OverduePOM.TaskType1().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(4000);
		OverduePOM.TypeofSearch().sendKeys("Bill Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		
		OverduePOM.ComplianceLocationST().click();
		Thread.sleep(3000);
		//OverduePOM.ComplianceLocationACD().click();
		Thread.sleep(3000);
	//	OverduePOM.ComplianceLocationACD1().click();
			Thread.sleep(3000);
			
			OverduePOM.CLLPvt1().click();
				Thread.sleep(4000);
				OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.ReportingLocation().click();
		Thread.sleep(2000);
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(3000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		
		OverduePOM.Startdate().click();
		Thread.sleep(3000);
		OverduePOM.date18().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.TPerformer().click();
		Thread.sleep(3000);
		OverduePOM.abcExternal().click();
		Thread.sleep(8000);
		
		OverduePOM.TReviewer().click();
		Thread.sleep(3000);
		OverduePOM.abclawyer().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer221().click();
		Thread.sleep(3000);
		OverduePOM.TReviewer22().click();
		Thread.sleep(8000);
		
		OverduePOM.SaveBtn().click();
		Thread.sleep(8000);
		
	//	String Msg =	OverduePOM.TAmsg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The record of assignment of task to secondary reviewer should be seen on the popup of show assgnment details. " );
			Thread.sleep(3000);
		

			OverduePOM.CloseTab().click();
		Thread.sleep(5000);


	}
	
	public static void SRWorkspaceSRIn( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		OverduePOM.TaskType().click();		
		Thread.sleep(2000);
		OverduePOM.TaskType1().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(4000);
		OverduePOM.TypeofSearch().sendKeys("Bill Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.SubTask().click();			
		Thread.sleep(5000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	
	public static void SRWorkspaceSRDisIn( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TaskType().click();		
		Thread.sleep(2000);
		OverduePOM.TaskType1().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(4000);
		OverduePOM.TypeofSearch().sendKeys("Bill Payment",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.SubTask().click();			
		Thread.sleep(5000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(8000);
		
		
		OverduePOM.ComplianceLocationT().click();
		Thread.sleep(3000);
		
		
	//	OverduePOM.ComplianceLocationTABCD().click();
	//	Thread.sleep(3000);
	//	OverduePOM.ComplianceLocationTABCD1().click();
	//	Thread.sleep(3000);
	//	OverduePOM.ComplianceLocationTABCD2().click();
		Thread.sleep(3000);
	
		OverduePOM.CLLPvt1().click();
		Thread.sleep(4000);
			
			
				OverduePOM.ComplianceLocationT().click();
		Thread.sleep(3000);
		
		OverduePOM.ReportingLocation().click();
		Thread.sleep(2000);
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(3000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(8000);
		
		
		OverduePOM.Startdate().click();
		Thread.sleep(3000);
		OverduePOM.date18().click();
		Thread.sleep(8000);
		
		
		OverduePOM.STPerformer().click();
		Thread.sleep(3000);
		OverduePOM.abcExternal().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer().click();
		Thread.sleep(3000);
		OverduePOM.abclawyer1().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer221Fm().click();
		Thread.sleep(3000);
		OverduePOM.Reviewer221Fm1().click();
		Thread.sleep(8000);
		
		OverduePOM.SaveBtn().click();
		Thread.sleep(8000);
		
	//	String Msg =	OverduePOM.TAmsg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The record of assignment of sub-task to secondary reviewer should be seen on the popup of show assgnment details." );
			Thread.sleep(5000);
		

		
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void WorkspaceSRFmIn( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();		
		
	/*	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		*/
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(5000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		OverduePOM.TaskType().click();		
		Thread.sleep(2000);
		OverduePOM.TaskType1().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(4000);
		OverduePOM.TypeofSearch().sendKeys("testing p",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void SecondaryReDisplayFmIn( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		Thread.sleep(3000);

	
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();		
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
	/*	
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		*/
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TaskType().click();		
		Thread.sleep(2000);
		OverduePOM.TaskType1().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(4000);
		OverduePOM.TypeofSearch().sendKeys("testing p",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		
		OverduePOM.ComplianceLocationST().click();
		Thread.sleep(3000);
		//OverduePOM.ComplianceLocationACD().click();
		//Thread.sleep(3000);
	//	OverduePOM.ComplianceLocationACD1().click();
			Thread.sleep(3000);
			
			OverduePOM.CLLPvt1().click();
				Thread.sleep(4000);
				OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.ReportingLocation().click();
		Thread.sleep(2000);
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(3000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		
		OverduePOM.Startdate().click();
		Thread.sleep(3000);
		OverduePOM.date18().click();
		Thread.sleep(8000);
		OverduePOM.ComplianceLocation().click();
		Thread.sleep(3000);
		
		OverduePOM.TPerformer().click();
		Thread.sleep(3000);
		OverduePOM.TabcExternal().click();
		Thread.sleep(8000);
		
		OverduePOM.TReviewer().click();
		Thread.sleep(3000);
		OverduePOM.Tabclawyer().click();
		Thread.sleep(8000);
		
		OverduePOM.Reviewer221().click();
		Thread.sleep(3000);
		OverduePOM.TReviewer22().click();
		Thread.sleep(8000);
		
		OverduePOM.SaveBtn().click();
		Thread.sleep(8000);
		
	//	String Msg =	OverduePOM.TAmsg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The record of assignment of task to secondary reviewer should be seen on the popup of show assgnment details. " );
			Thread.sleep(3000);
		

			OverduePOM.CloseTab().click();
		Thread.sleep(5000);


	}
	
	public static void SRWorkspaceSRFmIn( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		OverduePOM.clickMyWorkspace1().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.MyTasks().click();		
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
	/*	
		OverduePOM.clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		
		Thread.sleep(500);
		elementsList = OverduePOM.selectAction();				//Getting all 'More Action' drop down option
		elementsList.get(4).click();								//Clicking on fifth option "Update Tasks"
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']")));	//Waiting for records table to get visible
		*/
		Thread.sleep(4000);
		OverduePOM.ClickTaskCreation().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']")));	//Waiting for records table to get visible
		
		OverduePOM.TaskType().click();		
		Thread.sleep(2000);
		OverduePOM.TaskType1().click();				//Clicking on 'Task Creation' tab
		Thread.sleep(4000);
		OverduePOM.TypeofSearch().sendKeys("testing p",Keys.ENTER);
		Thread.sleep(4000);
		
		OverduePOM.SubTask().click();			
		Thread.sleep(5000);
		
		OverduePOM.ShowAssingment().click();			
		Thread.sleep(5000);
		
		if(OverduePOM.Reviewer2().isDisplayed()) {
			test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
		}
		else {
			test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

		}
		Thread.sleep(2000);
		
		OverduePOM.Reviewer2Close().click();			
		Thread.sleep(5000);
		
		
		}
	
	public static void DueButNotSubmitted(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ReviewerTaskDBNSStatutoryPer()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ReviewerTaskDBNSStatutoryPer().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ReviewerTaskDBNSStatutoryPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		
		int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
		if(gridCountCompletedSta == DasCountCompletedSta)
		{
		//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
			test.log(LogStatus.PASS, "No of  Due But Not Submitted in the grid = "+gridCountCompletedSta+" | Dashboard  Due But Not Submitted Count = "+DasCountCompletedSta);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
			test.log(LogStatus.FAIL, "No of Due But Not Submitted in the grid = "+gridCountCompletedSta+" | Dashboard Due But Not Submitted Count = "+DasCountCompletedSta);
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void DueButNotSubmittedIn(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ReviewerTaskDBNSInternalPer()));	//Wait until Internal Pending For Review count gets visible.
		
		int DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ReviewerTaskDBNSInternalPer().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ReviewerTaskDBNSInternalPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		try {
		int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
		if(gridCountCompletedSta == DasCountCompletedSta)
		{
		//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
			test.log(LogStatus.PASS, "No of  Due But Not Submitted in the grid = "+gridCountCompletedSta+" | Dashboard  Due But Not Submitted Count = "+DasCountCompletedSta);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
			test.log(LogStatus.FAIL, "No of Due But Not Submitted in the grid = "+gridCountCompletedSta+" | Dashboard Due But Not Submitted Count = "+DasCountCompletedSta);
		}
		}catch(Exception e){
		String text =	ReviewerPOM.NoRecord().getText();	
		if(text.equalsIgnoreCase("No Records Found.")) {
			test.log(LogStatus.FAIL, "No of Due But Not Submitted in the grid = 0"+" | Dashboard Due But Not Submitted Count = "+DasCountCompletedSta);

		}
			
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void PendingForReview(ExtentTest test,String type)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		int DasCountCompletedSta = 0 ;
		
		if(type.equalsIgnoreCase("Statutory")) {
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRStatutoryPer()));	//Wait until Internal Pending For Review count gets visible.
		
		 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickReviewerTaskPFRStatutoryPer().getText());	//Reading old value of Internal Reject
		
		 
		 
		ReviewerPOM.ClickReviewerTaskPFRStatutoryPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		}
		else 
		{
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
			 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText());	//Reading old value of Internal Reject
			
			ReviewerPOM.ClickReviewerTaskPFRInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		}
		
		try
		{
			int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
			if(gridCountCompletedSta == DasCountCompletedSta)
			{
			//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
				test.log(LogStatus.PASS, "No of  Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard  Pending For Review Count = "+DasCountCompletedSta);
			}
			else
			{
			//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
				test.log(LogStatus.FAIL, "No of Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard Pending For Review Count = "+DasCountCompletedSta);
			}
		
		
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickActionPFR()));
			ReviewerPOM.clickActionPFR().click();					//Clicking on third action button.
			
			getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
			
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			ReviewerPOM.clickDownload2().click();
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();	
			Thread.sleep(1000);//Click on the Date text box
			OverduePOM.selectDate4().click();						//Clicking to get last month
			
			Thread.sleep(2000);
//			js.executeScript("window.scrollBy(0,300)"," ");					//Scrolling down window by 2000 px.
			
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyPFRTask()));
				ReviewerPOM.clickClosedTimelyPFRTask().click();				//Clicking on Closed-Delay radio button.
				
				Thread.sleep(2000);
				ReviewerPOM.insertTextArea1().sendKeys("NIL");				//Inserting remark in Text area
			
			
			Thread.sleep(4000);
			//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
				 By locator = By.xpath("//*[@id='btnSave']");
	
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					// retrieving "foo-button" HTML element
					WebElement ViewButton = getDriver().findElement(locator);	
					Thread.sleep(3000);
					JavascriptExecutor jse=(JavascriptExecutor) getDriver();
					jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
					String Msg=	OverduePOM.TaskReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
					test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
					getDriver().switchTo().parentFrame();
					getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
					Thread.sleep(2000);
					OverduePOM.clickDashboard().click();
		
				String string_newInternalOverdue = ReviewerPOM.ClickReviewerTaskPFRStatutoryPer().getText();		//Storing old value of Statutory overdue.
				int	newOverdueInternal = Integer.parseInt(string_newInternalOverdue);
					
				
				Thread.sleep(1000);
				if(DasCountCompletedSta > newOverdueInternal)
				{
					test.log(LogStatus.PASS, "After Review :- Stautory 'Pending for review' count decreased.");
					test.log(LogStatus.PASS, "Old Task Count = "+DasCountCompletedSta+" | New Task Count = "+newOverdueInternal);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Perform :- Stautory 'Overdue' count doesn't decreased.");
					test.log(LogStatus.FAIL, "Old Task Count = "+DasCountCompletedSta+" | New Task Count = "+newOverdueInternal);
				}
				}
				
				catch(Exception e)
				{
					String text =	ReviewerPOM.NoRecord1().getText();	
					if(text.equalsIgnoreCase("No Records Found.")) 
					{
						test.log(LogStatus.PASS, "No of Pending for Review in the grid = 0"+" | Dashboard Pending for Review Count = "+text);
					}
				}
	}
	public static void PendingForReviewInt(ExtentTest test,String type)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		int DasCountCompletedInt = 0 ;
		
		
		
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
			 DasCountCompletedInt = Integer.parseInt(ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText());	//Reading old value of Internal Reject
			
			ReviewerPOM.ClickReviewerTaskPFRInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		
		
		try
		{
			int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
			if(gridCountCompletedSta == DasCountCompletedInt)
			{
			//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
				test.log(LogStatus.PASS, "No of  Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard  Pending For Review Count = "+DasCountCompletedInt);
			}
			else
			{
			//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
				test.log(LogStatus.FAIL, "No of Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard Pending For Review Count = "+DasCountCompletedInt);
			}
		
		
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickActionPFR()));
			ReviewerPOM.clickActionPFR().click();					//Clicking on third action button.
			
			getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
			
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			ReviewerPOM.clickDownload2().click();
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();	
			Thread.sleep(1000);//Click on the Date text box
			OverduePOM.selectDate4().click();						//Clicking to get last month
			
			Thread.sleep(2000);
//			js.executeScript("window.scrollBy(0,300)"," ");					//Scrolling down window by 2000 px.
			
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyPFRTask()));
				ReviewerPOM.clickClosedTimelyPFRTask().click();				//Clicking on Closed-Delay radio button.
				
				Thread.sleep(2000);
				ReviewerPOM.insertTextArea1().sendKeys("NIL");				//Inserting remark in Text area
			
			
			Thread.sleep(4000);
			//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
				 By locator = By.xpath("//*[@id='btnSave']");
	
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					// retrieving "foo-button" HTML element
					WebElement ViewButton = getDriver().findElement(locator);	
					Thread.sleep(3000);
					JavascriptExecutor jse=(JavascriptExecutor) getDriver();
					jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
					String Msg=	OverduePOM.TaskReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
					test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
					getDriver().switchTo().parentFrame();
					getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
					Thread.sleep(2000);
					OverduePOM.clickDashboard().click();
		
				String string_newInternalOverdue = ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText();		//Storing old value of Statutory overdue.
				int	newOverdueInternal = Integer.parseInt(string_newInternalOverdue);
					
				
				Thread.sleep(1000);
				if(DasCountCompletedInt > newOverdueInternal)
				{
					test.log(LogStatus.PASS, "After Review :- Stautory 'Pending for review' count decreased.");
					test.log(LogStatus.PASS, "Old Task Count = "+DasCountCompletedInt+" | New Task Count = "+newOverdueInternal);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Perform :- Stautory 'Overdue' count doesn't decreased.");
					test.log(LogStatus.FAIL, "Old Task Count = "+DasCountCompletedInt+" | New Task Count = "+newOverdueInternal);
				}
				}
				
				catch(Exception e)
				{
					String text =	ReviewerPOM.NoRecord1().getText();	
					if(text.equalsIgnoreCase("No Records Found.")) 
					{
						test.log(LogStatus.PASS, "No of Pending for Review in the grid = 0"+" | Dashboard Pending for Review Count = "+text);
					}
				}
	}
	public static void PendingForReviewTaskRejected(ExtentTest test,String type)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		
		
		
		int overdueStatutory =0;
		int reviewStatutory=0;
		if(type.equalsIgnoreCase("Statutory")) {
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRStatutoryPer()));	//Wait until Internal Pending For Review count gets visible.
		
		 String string_overdueStatutory = ReviewerPOM.ClickReviewerTaskPFRStatutoryPer().getText();		//Storing old value of Statutory overdue.
		  overdueStatutory = Integer.parseInt(string_overdueStatutory);
		 String string_reviewStatutory = ReviewerPOM.ClickReviewerTaskRejectStatutoryPer().getText();	//Storing old value of Pending Review.
		  reviewStatutory = Integer.parseInt(string_reviewStatutory);
		
		 
		 
		ReviewerPOM.ClickReviewerTaskPFRStatutoryPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		}
		else 
		{
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
			overdueStatutory  = Integer.parseInt(ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText());	//Reading old value of Internal Reject
			
			ReviewerPOM.ClickReviewerTaskPFRInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		}
		
		try
		{
			int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
			if(gridCountCompletedSta == overdueStatutory)
			{
			//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
				test.log(LogStatus.PASS, "No of  Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard  Pending For Review Count = "+overdueStatutory);
			}
			else
			{
			//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
				test.log(LogStatus.FAIL, "No of Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard Pending For Review Count = "+overdueStatutory);
			}
		
		
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickActionPFR()));
			ReviewerPOM.clickActionPFR().click();					//Clicking on third action button.
			
			getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
			
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			ReviewerPOM.clickDownload2().click();
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();	
			Thread.sleep(1000);//Click on the Date text box
			OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
			
			Thread.sleep(2000);
//			js.executeScript("window.scrollBy(0,300)"," ");					//Scrolling down window by 2000 px.
			
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyPFRTask()));
				ReviewerPOM.clickClosedTimelyPFRTask().click();				//Clicking on Closed-Delay radio button.
				
				Thread.sleep(2000);
				ReviewerPOM.insertTextArea1().sendKeys("NIL");				//Inserting remark in Text area
			
			
			Thread.sleep(4000);
			//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
				 By locator = By.xpath("//*[@id='btnReject']");
	
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					// retrieving "foo-button" HTML element
					WebElement ViewButton = getDriver().findElement(locator);	
					Thread.sleep(3000);
					JavascriptExecutor jse=(JavascriptExecutor) getDriver();
					jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
					String Msg=	OverduePOM.TaskReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
					test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
					getDriver().switchTo().parentFrame();
					getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
					Thread.sleep(2000);
					OverduePOM.clickDashboard().click();
		
				String string_newOverdueStatutory = ReviewerPOM.ClickReviewerTaskPFRStatutoryPer().getText();		//Storing old value of Statutory overdue.
				int	newOverdueStatutory = Integer.parseInt(string_newOverdueStatutory);
				String string_newreviewStatutory = ReviewerPOM.ClickReviewerTaskRejectStatutoryPer().getText();	//Storing old value of Pending Review.
				 int newreviewStatutory = Integer.parseInt(string_newreviewStatutory);
				
				
				Thread.sleep(1000);
				if(overdueStatutory > newOverdueStatutory)
				{
					test.log(LogStatus.PASS, "After Review :- Stautory 'Pending for review' count decreased.");
					test.log(LogStatus.PASS, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Perform :- Stautory 'Overdue' count doesn't decreased.");
					test.log(LogStatus.FAIL, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
				}
				
				Thread.sleep(1000);
				if(newreviewStatutory > reviewStatutory)
				{
					test.log(LogStatus.PASS, "After Perform :- 'Rejected' Statutory count increased.");
					test.log(LogStatus.PASS, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newreviewStatutory);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Perform :- 'Rejected' Statutory count doesn't increased.");
					test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newreviewStatutory);
				}
				}
				
				catch(Exception e)
				{
					String text =	ReviewerPOM.NoRecord1().getText();	
					if(text.equalsIgnoreCase("No Records Found.")) 
					{
						test.log(LogStatus.PASS, "No of Pending for Review in the grid = 0"+" | Dashboard Pending for Review Count = "+text);
					}
				}
	}
	
	public static void PendingForReviewTaskInRejected(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		
		
		
		int overdueStatutory =0;
		int reviewStatutory=0;
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRInternalPer()));	//Wait until Internal Pending For Review count gets visible.
		
		 String string_overdueStatutory = ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText();		//Storing old value of Statutory overdue.
		  overdueStatutory = Integer.parseInt(string_overdueStatutory);
		 String string_reviewStatutory = ReviewerPOM.ClickReviewerTaskRejectInternalPer().getText();	//Storing old value of Pending Review.
		  reviewStatutory = Integer.parseInt(string_reviewStatutory);
		
		 
		 
		ReviewerPOM.ClickReviewerTaskPFRInternalPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		
		
		try
		{
			int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
			if(gridCountCompletedSta == overdueStatutory)
			{
			//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
				test.log(LogStatus.PASS, "No of  Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard  Pending For Review Count = "+overdueStatutory);
			}
			else
			{
			//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
				test.log(LogStatus.FAIL, "No of Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard Pending For Review Count = "+overdueStatutory);
			}
		
		
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickActionPFR()));
			ReviewerPOM.clickActionPFR().click();					//Clicking on third action button.
			
			getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
			
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			ReviewerPOM.clickDownload2().click();
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();	
			Thread.sleep(1000);//Click on the Date text box
			OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
			
			Thread.sleep(2000);
//			js.executeScript("window.scrollBy(0,300)"," ");					//Scrolling down window by 2000 px.
			
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyPFRTask()));
				ReviewerPOM.clickClosedTimelyPFRTask().click();				//Clicking on Closed-Delay radio button.
				
				Thread.sleep(2000);
				ReviewerPOM.insertTextArea1().sendKeys("NIL");				//Inserting remark in Text area
			
			
				Thread.sleep(4000);
			//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
				 By locator = By.xpath("//*[@id='btnReject']");
	
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					// retrieving "foo-button" HTML element
					WebElement ViewButton = getDriver().findElement(locator);	
					Thread.sleep(3000);
					JavascriptExecutor jse=(JavascriptExecutor) getDriver();
					jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
					String Msg=	OverduePOM.TaskReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
					test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
					getDriver().switchTo().parentFrame();
					getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
					Thread.sleep(2000);
					OverduePOM.clickDashboard().click();
		
				String string_newOverdueStatutory = ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText();		//Storing old value of Statutory overdue.
				int	newOverdueStatutory = Integer.parseInt(string_newOverdueStatutory);
				String string_newreviewStatutory = ReviewerPOM.ClickReviewerTaskRejectInternalPer().getText();	//Storing old value of Pending Review.
				 int newreviewStatutory = Integer.parseInt(string_newreviewStatutory);
				
				
				Thread.sleep(1000);
				if(overdueStatutory > newOverdueStatutory)
				{
					test.log(LogStatus.PASS, "After Review :- Internal 'Pending for review' count decreased.");
					test.log(LogStatus.PASS, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Review :- Internal 'Overdue' count doesn't decreased.");
					test.log(LogStatus.FAIL, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
				}
				
				Thread.sleep(1000);
				if(newreviewStatutory > reviewStatutory)
				{
					test.log(LogStatus.PASS, "After Review :- 'Rejected' Internal count increased.");
					test.log(LogStatus.PASS, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newreviewStatutory);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Review :- 'Rejected' Internal count doesn't increased.");
					test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newreviewStatutory);
				}
				
				}
				
				catch(Exception e)
				{
					String text =	ReviewerPOM.NoRecord1().getText();	
					if(text.equalsIgnoreCase("No Records Found.")) 
					{
						test.log(LogStatus.PASS, "No of Pending for Review in the grid = 0"+" | Dashboard Pending for Review Count = "+text);
					}
				}
	}
	public static void PendingForReviewInternalTask(ExtentTest test,String type)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		int DasCountCompletedSta = 0 ;
		
		
	
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskPFRInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
			 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText());	//Reading old value of Internal Reject
			
			ReviewerPOM.ClickReviewerTaskPFRInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		
		
		try
		{
			int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
			if(gridCountCompletedSta == DasCountCompletedSta)
			{
			//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
				test.log(LogStatus.PASS, "No of  Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard  Pending For Review Count = "+DasCountCompletedSta);
			}
			else
			{
			//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
				test.log(LogStatus.FAIL, "No of Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard Pending For Review Count = "+DasCountCompletedSta);
			}
		
		
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickActionPFR()));
			ReviewerPOM.clickActionPFR().click();					//Clicking on third action button.
			
			getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
			
			
			js.executeScript("window.scrollBy(0,500)"," ");					//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			ReviewerPOM.clickDownload2().click();
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
			
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();	
			Thread.sleep(1000);//Click on the Date text box
			OverduePOM.selectDate4().click();						//Clicking to get last month
			
			Thread.sleep(2000);
//			js.executeScript("window.scrollBy(0,300)"," ");					//Scrolling down window by 2000 px.
			
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.clickClosedTimelyPFRTask()));
				ReviewerPOM.clickClosedTimelyPFRTask().click();				//Clicking on Closed-Delay radio button.
				
				Thread.sleep(2000);
				ReviewerPOM.insertTextArea1().sendKeys("NIL");				//Inserting remark in Text area
			
			
				Thread.sleep(4000);
			//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
				 By locator = By.xpath("//*[@id='btnSave']");
	
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					// retrieving "foo-button" HTML element
					WebElement ViewButton = getDriver().findElement(locator);	
					Thread.sleep(3000);
					JavascriptExecutor jse=(JavascriptExecutor) getDriver();
					jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
					String Msg=	OverduePOM.TaskReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
					test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
					Thread.sleep(500);
					getDriver().switchTo().parentFrame();
					getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
					Thread.sleep(2000);
					OverduePOM.clickDashboard().click();
		
		String string_newInternalOverdue = ReviewerPOM.ClickReviewerTaskPFRInternalPer().getText();		//Storing old value of Statutory overdue.
		int	newOverdueInternal = Integer.parseInt(string_newInternalOverdue);
			
		
		Thread.sleep(1000);
		if(DasCountCompletedSta > newOverdueInternal)
		{
			test.log(LogStatus.PASS, "After Review :- Internal 'Pending for review' count decreased.");
			test.log(LogStatus.PASS, "Old Compliance Count = "+DasCountCompletedSta+" | New Compliance Count = "+newOverdueInternal);
		}
		else
		{
			test.log(LogStatus.FAIL, "After Perform :- Internal 'Overdue' count doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Compliance Count = "+DasCountCompletedSta+" | New Compliance Count = "+newOverdueInternal);
		}
		}
		
		catch(Exception e)
		{
			String text =	ReviewerPOM.NoRecord1().getText();	
			if(text.equalsIgnoreCase("No Records Found.")) 
			{
				test.log(LogStatus.PASS, "No of Pending for Review in the grid = 0"+" | Dashboard Pending for Review Count = "+text);
			}
		
		}	
	}
	
	
		

	
		
		
		
		
		
	
	
	public static void Rejectedtask(ExtentTest test,String type)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(1000);
		int DasCountCompletedSta = 0 ;
		if(type.equalsIgnoreCase("Statutory")) {
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskRejectStatutoryPer()));	//Wait until Internal Pending For Review count gets visible.
		
		 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickReviewerTaskRejectStatutoryPer().getText());	//Reading old value of Internal Reject
		
		 
		 
		ReviewerPOM.ClickReviewerTaskRejectStatutoryPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		}else {
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickReviewerTaskRejectInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
			 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickReviewerTaskRejectInternalPer().getText());	//Reading old value of Internal Reject
			
			ReviewerPOM.ClickReviewerTaskRejectInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		}
		
		try {
		int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
		if(gridCountCompletedSta == DasCountCompletedSta)
		{
		//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
			test.log(LogStatus.PASS, "No of  Rejected in the grid = "+gridCountCompletedSta+" | Dashboard  Rejected Count = "+DasCountCompletedSta);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
			test.log(LogStatus.FAIL, "No of Rejected in the grid = "+gridCountCompletedSta+" | Dashboard Rejected Count = "+DasCountCompletedSta);
		}
		}catch(Exception e){
		String text =	ReviewerPOM.NoRecord().getText();	
		if(text.equalsIgnoreCase("No Records Found.")) {
			
			if(DasCountCompletedSta==0) {
			test.log(LogStatus.PASS, "No of Rejected in the grid = 0"+" | Dashboard Rejected Count = "+DasCountCompletedSta);
			}else {
				test.log(LogStatus.FAIL, "No of Rejected in the grid = 0"+" | Dashboard Rejected Count = "+DasCountCompletedSta);
			}
		}
			
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	
	public static void PerformerTaskUpcoming(ExtentTest test,String type)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(1000);
		int DasCountCompletedSta = 0 ;
		
		int reviewStatutory = 0 ;
		if(type.equalsIgnoreCase("Statutory")) {
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickUpcomingStatutoryPer()));	//Wait until Internal Pending For Review count gets visible.
		
		 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickUpcomingStatutoryPer().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickUpcomingStatutoryPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		}
		else 
		{
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickUpcomingInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
			 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickUpcomingInternalPer().getText());	//Reading old value of Internal Reject
			
			 String string_reviewStatutory = ReviewerPOM.ClickPendingForReviewInternalPer().getText();	//Storing old value of Pending Review.
				reviewStatutory = Integer.parseInt(string_reviewStatutory);
			 
			 ReviewerPOM.ClickUpcomingInternalPer().click();		//Clicking on Statutory Review value.
			 Thread.sleep(8000);
		}
		

		
		
		try
		{
			
			int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());
			if(gridCountCompletedSta == DasCountCompletedSta)
			{
			
				test.log(LogStatus.PASS, "Before Perform :- Total 'Overdue' Internal Compliance Count in the Grid = "+gridCountCompletedSta+" | Dashboard 'Overdue' Internal Compliance Count = "+DasCountCompletedSta);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Before Perform :- Upcoming Internal count does not matches to total number of compliances displayed.");
				test.log(LogStatus.FAIL, "Before Perform :- Total 'Overdue' Internal Compliance Count in the Grid = "+gridCountCompletedSta+" | Dashboard 'Overdue' Internal Compliance Count = "+DasCountCompletedSta);
			}
		}
		catch(Exception e)
		{
			String text =	ReviewerPOM.NoRecord().getText();	
			if(text.equalsIgnoreCase("No Records Found.")) {
				test.log(LogStatus.FAIL, "No of Upcoming in the grid = 0"+" | Dashboard Upcoming Count = "+DasCountCompletedSta);

		}
		}
		
		
		
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
	
		getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
	
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(4000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
			Thread.sleep(500);
			Thread.sleep(2000);
			//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
			getDriver().switchTo().parentFrame();
			getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
		String string_newInternalOverdue = ReviewerPOM.ClickUpcomingInternalPer().getText();		//Storing old value of Statutory overdue.
		int	newOverdueInternal = Integer.parseInt(string_newInternalOverdue);
			String string_newInternalReview = ReviewerPOM.ClickPendingForReviewInternalPer().getText();	//Storing old value of Pending Review.
		int	newReviewInternal = Integer.parseInt(string_newInternalReview);
		
		Thread.sleep(1000);
		if(DasCountCompletedSta > newOverdueInternal)
		{
			test.log(LogStatus.PASS, "After Perform :- Stautory 'Overdue' count decreased.");
			test.log(LogStatus.PASS, "Old Compliance Count = "+DasCountCompletedSta+" | New Compliance Count = "+newOverdueInternal);
		}
		else
		{
			test.log(LogStatus.FAIL, "After Perform :- Stautory 'Overdue' count doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Compliance Count = "+DasCountCompletedSta+" | New Compliance Count = "+newOverdueInternal);
		}
		
		if(newReviewInternal > reviewStatutory)
		{
			test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
			test.log(LogStatus.PASS, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewInternal);
		}
		else
		{
			test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
			test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewInternal);
		}
		
		
	}
	
	public static void PerformerTaskOverdue(ExtentTest test,String type)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		
		Thread.sleep(1000);
		 int overdueStatutory = 0 ;
		  int reviewStatutory=0;
		 
		if(type.equalsIgnoreCase("Statutory")) 
		{
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueStatutoryPer()));	//Wait until Internal Pending For Review count gets visible.
			
			String string_overdueStatutory = ReviewerPOM.ClickOverdueStatutoryPer().getText();		//Storing old value of Statutory overdue.
			overdueStatutory = Integer.parseInt(string_overdueStatutory);
			String string_reviewStatutory = ReviewerPOM.ClickPendingForReviewStatutoryPer().getText();	//Storing old value of Pending Review.
			reviewStatutory = Integer.parseInt(string_reviewStatutory);
			
			ReviewerPOM.ClickOverdueStatutoryPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		}
		else 
		{
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
		 
			 String string_overdueStatutory = ReviewerPOM.ClickOverdueInternalPer().getText();		//Storing old value of Statutory overdue.
			  overdueStatutory = Integer.parseInt(string_overdueStatutory);
			 String string_reviewStatutory = ReviewerPOM.ClickPendingForReviewInternalPer().getText();	//Storing old value of Pending Review.
			  reviewStatutory = Integer.parseInt(string_reviewStatutory);
			
			ReviewerPOM.ClickOverdueInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		}

		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		
		
		
		if(overdueStatutory == GridCount)
		{
		
			test.log(LogStatus.PASS, "Before Perform :- Total Stautory 'Overdue' Compliance Count in the Grid = "+GridCount+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		else
		{
			test.log(LogStatus.FAIL, "Before Perform :- Total  Stautory 'Overdue' Count in the Grid = "+GridCount+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
	
		getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
	
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(4000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
			Thread.sleep(500);
			Thread.sleep(2000);
			//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
			getDriver().switchTo().parentFrame();
			getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
			
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.ClickOverdueStatutoryPer()));
		
			String string_newOverdueStatutory = ReviewerPOM.ClickOverdueStatutoryPer().getText();		//Storing old value of Statutory overdue.
			int newOverdueStatutory = Integer.parseInt(string_newOverdueStatutory);
			String string_newReviewStatutory = ReviewerPOM.ClickPendingForReviewStatutoryPer().getText();	//Storing old value of Pending Review.
			int newReviewStatutory = Integer.parseInt(string_newReviewStatutory);
				
	
			Thread.sleep(1000);
			if(overdueStatutory > newOverdueStatutory)
			{
				test.log(LogStatus.PASS, "After Perform :- Stautory 'Overdue' count decreased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- Stautory 'Overdue' count doesn't decreased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
			}
			
		
			if(newReviewStatutory > reviewStatutory)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
			}
		
		
		
	}
	
	public static void PerformerTaskOverdueInternal(ExtentTest test,String type)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	//Scrolling down window by 2000 px.
		
		
		Thread.sleep(1000);
		 int overdueStatutory = 0 ;
		  int reviewStatutory=0;
		 
	
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickOverdueInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
		 
			 String string_overdueStatutory = ReviewerPOM.ClickOverdueInternalPer().getText();		//Storing old value of Statutory overdue.
			  overdueStatutory = Integer.parseInt(string_overdueStatutory);
			 String string_reviewStatutory = ReviewerPOM.ClickPendingForReviewInternalPer().getText();	//Storing old value of Pending Review.
			  reviewStatutory = Integer.parseInt(string_reviewStatutory);
			
			ReviewerPOM.ClickOverdueInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
	
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']")));	//Waiting for records table to get visible
		Thread.sleep(3000);
		OverduePOM.ClickPerformReview().click();
		Thread.sleep(3000);
		int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
		
		
		
		if(overdueStatutory == GridCount)
		{
		
			test.log(LogStatus.PASS, "Before Perform :- Total Stautory 'Overdue' Compliance Count in the Grid = "+GridCount+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		else
		{
			test.log(LogStatus.FAIL, "Before Perform :- Total  Stautory 'Overdue' Count in the Grid = "+GridCount+" | Dashboard Stautory 'Overdue' Compliance Count = "+overdueStatutory);
		}
		Thread.sleep(500);
		elementsList=OverduePOM.ActionBtns();
		elementsList.get(1).click();
		Thread.sleep(4000);
	
		getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
	
		Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
		status.selectByIndex(1);											//Selecting 2nd value from dropdown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();					//Click on the Date text box
		OverduePOM.selectLastMonth().click();						//Clicking to get last month
		Thread.sleep(1000);
		OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
		
		Thread.sleep(500);
		OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(4000);
	//	OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
		 By locator = By.xpath("//*[@id='btnSave']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
			test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
			Thread.sleep(500);
			Thread.sleep(2000);
			//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
			getDriver().switchTo().parentFrame();
			getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
			
		
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.ClickOverdueStatutoryPer()));
			Thread.sleep(1000);
			String string_overdueStatutoryNew = ReviewerPOM.ClickOverdueInternalPer().getText();		//Storing old value of Statutory overdue.
			int	newOverdueStatutory = Integer.parseInt(string_overdueStatutoryNew);
			String string_reviewStatutoryNew = ReviewerPOM.ClickPendingForReviewInternalPer().getText();	//Storing old value of Pending Review.
			int newReviewStatutory = Integer.parseInt(string_reviewStatutoryNew);
	
			Thread.sleep(1000);
			if(overdueStatutory > newOverdueStatutory)
			{
				test.log(LogStatus.PASS, "After Perform :- Internal 'Overdue' count decreased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- Internal 'Overdue' count doesn't decreased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+overdueStatutory+" | New Compliance Count = "+newOverdueStatutory);
			}
			
		
			if(newReviewStatutory > reviewStatutory)
			{
				test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
				test.log(LogStatus.PASS, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
			}
			else
			{
				test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
				test.log(LogStatus.FAIL, "Old Compliance Count = "+reviewStatutory+" | New Compliance Count = "+newReviewStatutory);
			}
		
		
		
	}
	
	public static void PerformerTaskRejected(ExtentTest test,String Compliance)throws InterruptedException
	{

		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerRejectedStat']")));	//Waiting for 'Statutory Reject' value to get visible on Dashboard
		
		String string_rejected = null;
		int rejected = 0;
		Thread.sleep(1000);
		 int overdueStatutory = 0 ;
		  int reviewStatutory=0;
		
		for(int i = 0; i <= 0; i++)						//For loop used only to get 'break;' functionality in use.
		{
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejected = ReviewerPOM.ClickRejectedStatutoryPer().getText();	//Storing old value of Statutory Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				
				String string_reviewStatutory = ReviewerPOM.ClickPendingForReviewStatutoryPer().getText();	//Storing old value of Pending Review.
				reviewStatutory = Integer.parseInt(string_reviewStatutory);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				ReviewerPOM.ClickRejectedStatutoryPer().click();			//Clicking on Statutory overdue.
				
			
			}
			else															//Going for Internal click
			{
				string_rejected = ReviewerPOM.ClickRejectedInternalPer().getText();	//Storing old value of Internal Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				ReviewerPOM.ClickRejectedInternalPer().click();			//Clicking on Statutory overdue.
				Thread.sleep(3000);
			}
		}
		
		try
		{
			if(rejected > 0)
			{

				Thread.sleep(3000);
				int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
			if(rejected == GridCount)
			{
				test.log(LogStatus.PASS, "Before Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + GridCount + " | Total Compliances count on Dashboard = " + rejected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Before Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + GridCount + " | Total Compliances count on Dashboard = " + rejected);
			}
			
			
			Thread.sleep(500);
			elementsList=OverduePOM.ActionBtns();
			elementsList.get(0).click();
			Thread.sleep(4000);
		
			getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
		
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
			status.selectByIndex(1);											//Selecting 2nd value from dropdown.
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
			Thread.sleep(3000);
			OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,500)");
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();					//Click on the Date text box
			OverduePOM.selectLastMonth().click();						//Clicking to get last month
			Thread.sleep(1000);
			OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
			
			Thread.sleep(500);
			OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
			js.executeScript("window.scrollBy(0,100)");
			Thread.sleep(4000);
			//OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
			By locator = By.xpath("//*[@id='btnSave']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
				JavascriptExecutor jse=(JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(5000);
				String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
				test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
				Thread.sleep(500);
				Thread.sleep(2000);
				//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
				getDriver().switchTo().parentFrame();
				getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
				
				
				Thread.sleep(1000);
				OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.ClickOverdueStatutoryPer()));
			
				String string_newOverdueStatutory = ReviewerPOM.ClickRejectedStatutoryPer().getText();		//Storing old value of Statutory overdue.
				int newOverdueStatutory = Integer.parseInt(string_newOverdueStatutory);
				String string_newReviewStatutory = ReviewerPOM.ClickPendingForReviewStatutoryPer().getText();	//Storing old value of Pending Review.
				int newReviewStatutory = Integer.parseInt(string_newReviewStatutory);
					
		
				Thread.sleep(1000);
				if(rejected > newOverdueStatutory)
				{
					test.log(LogStatus.PASS, "After Perform :- Stautory 'Rejceted' count decreased.");
					test.log(LogStatus.PASS, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newOverdueStatutory);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Perform :- Stautory 'Rejceted' count doesn't decreased.");
					test.log(LogStatus.FAIL, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newOverdueStatutory);
				}
				
			
//				if(newReviewStatutory > reviewStatutory)
//				{
//					test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
//					test.log(LogStatus.PASS, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newReviewStatutory);
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
//					test.log(LogStatus.FAIL, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newReviewStatutory);
//				}
				
			}
		}
		
		catch(Exception e)
		{
			String text =	ReviewerPOM.NoRecord1().getText();	
			if(text.equalsIgnoreCase("No Records Found.")) 
			{
				test.log(LogStatus.PASS, "No of Rejected in the grid = 0"+" | Dashboard Rejected Count = "+rejected);
			}
		}
	
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		

		
	}
	public static void PerformerTaskRejectedInternal(ExtentTest test,String Compliance)throws InterruptedException
	{

		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerRejectedInt']")));	//Waiting for 'Statutory Reject' value to get visible on Dashboard
		
		String string_rejected = null;
		int rejected = 0;
		for(int i = 0; i <= 0; i++)						//For loop used only to get 'break;' functionality in use.
		{
			if(Compliance.equalsIgnoreCase("Statutory"))					//Going for statutory click
			{
				string_rejected = ReviewerPOM.ClickRejectedStatutoryPer().getText();	//Storing old value of Statutory Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				ReviewerPOM.ClickRejectedStatutoryPer().click();			//Clicking on Statutory overdue.
			}
			else															//Going for Internal click
			{
				string_rejected = ReviewerPOM.ClickRejectedInternalPer().getText();	//Storing old value of Internal Reject from Dashboard.
				rejected = Integer.parseInt(string_rejected);
				if(rejected == 0)
					break;
				Thread.sleep(500);
				ReviewerPOM.ClickRejectedInternalPer().click();			//Clicking on Statutory overdue.
				Thread.sleep(3000);
			}
		}
		
		try
		{
			if(rejected > 0)
			{

				Thread.sleep(3000);
				int GridCount=	Integer.parseInt(OverduePOM.ReadCountUpcoming().getText());
			if(rejected == GridCount)
			{
				test.log(LogStatus.PASS, "Before Perform ("+ Compliance +"):- Compliances count matches to Dashboard count. Total Compliances count in the grid = " + GridCount + " | Total Compliances count on Dashboard = " + rejected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Before Perform ("+ Compliance +"):- Compliances count doesn't matches to Dashboard count. Total Compliances count in the grid = " + GridCount + " | Total Compliances count on Dashboard = " + rejected);
			}
			
			
			Thread.sleep(500);
			elementsList=OverduePOM.ActionBtns();
			elementsList.get(0).click();
			Thread.sleep(4000);
		
			getDriver().switchTo().frame("showdetails");						//Switching 1st iFrame.
		
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting dropdown box
			status.selectByIndex(1);											//Selecting 2nd value from dropdown.
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadUpStatutory()));
			Thread.sleep(3000);
			OverduePOM.fileUploadUpStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
		//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,500)");
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
			OverduePOM.selectDateStatutory().click();					//Click on the Date text box
			OverduePOM.selectLastMonth().click();						//Clicking to get last month
			Thread.sleep(1000);
			OverduePOM.selectDate().click(); 							//Selecting date - second row and fifth column date from calendar
			
			Thread.sleep(500);
			OverduePOM.remark().sendKeys("Automation Testing");			//Sending Remark
			js.executeScript("window.scrollBy(0,100)");
			Thread.sleep(4000);
			//OverduePOM.clickComplianceSubmit1().click();				//Click on Submit button.
			By locator = By.xpath("//*[@id='btnSave']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
				JavascriptExecutor jse=(JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				String Msg=		OverduePOM.PerformReviewMsg().getText(); 							//Selecting date - second row and fifth column date from calendar
				test.log(LogStatus.PASS, "Perform Review Message Displayed :-"+Msg);
				Thread.sleep(500);
				Thread.sleep(2000);
				//	getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
				getDriver().switchTo().parentFrame();
				getDriver().findElement(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")).click();
				
				
				Thread.sleep(1000);
				OverduePOM.clickDashboard().click();						//Clicking on Dashboard link.
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(ReviewerPOM.ClickRejectedInternalPer()));
			
				String string_newOverdueStatutory = ReviewerPOM.ClickRejectedInternalPer().getText();		//Storing old value of Statutory overdue.
				int newOverdueStatutory = Integer.parseInt(string_newOverdueStatutory);
				String string_newReviewStatutory = ReviewerPOM.ClickPendingForReviewInternalPer().getText();	//Storing old value of Pending Review.
				int newReviewStatutory = Integer.parseInt(string_newReviewStatutory);
					
		
				Thread.sleep(1000);
				if(rejected > newOverdueStatutory)
				{
					test.log(LogStatus.PASS, "After Perform :- Internal 'Rejceted' count decreased.");
					test.log(LogStatus.PASS, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newOverdueStatutory);
				}
				else
				{
					test.log(LogStatus.FAIL, "After Perform :- Internal 'Rejceted' count doesn't decreased.");
					test.log(LogStatus.FAIL, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newOverdueStatutory);
				}
				
			
//				if(newReviewStatutory > rejected)
//				{
//					test.log(LogStatus.PASS, "After Perform :- 'Pending for Review' Statutory count increased.");
//					test.log(LogStatus.PASS, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newReviewStatutory);
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "After Perform :- 'Pending for Review' Statutory count doesn't increased.");
//					test.log(LogStatus.FAIL, "Old Compliance Count = "+rejected+" | New Compliance Count = "+newReviewStatutory);
//				}
			}
		}
		
		catch(Exception e)
		{
			String text =	ReviewerPOM.NoRecord1().getText();	
			if(text.equalsIgnoreCase("No Records Found.")) 
			{
				test.log(LogStatus.PASS, "No of Rejected in the grid = 0"+" | Dashboard Rejected Count = "+rejected);
			}
		}
	
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();						//Clicking on Dashboard link. 
		

		
	}
	
	public static void PerformerTaskPFR(ExtentTest test,String type)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(1000);
		int DasCountCompletedSta = 0 ;
		if(type.equalsIgnoreCase("Statutory")) {
		wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickPendingForReviewStatutoryPer()));	//Wait until Internal Pending For Review count gets visible.
		
		 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickPendingForReviewStatutoryPer().getText());	//Reading old value of Internal Reject
		
		ReviewerPOM.ClickPendingForReviewStatutoryPer().click();		//Clicking on Statutory Review value.
		Thread.sleep(8000);
		}else {
			wait.until(ExpectedConditions.visibilityOf(ReviewerPOM.ClickPendingForReviewInternalPer()));	//Wait until Internal Pending For Review count gets visible.
			
			 DasCountCompletedSta = Integer.parseInt(ReviewerPOM.ClickPendingForReviewInternalPer().getText());	//Reading old value of Internal Reject
			
			ReviewerPOM.ClickPendingForReviewInternalPer().click();		//Clicking on Statutory Review value.
			Thread.sleep(8000);
		}
		
		try {
		int gridCountCompletedSta = Integer.parseInt(ReviewerPOM.GridCount().getText());	
					
		
		if(gridCountCompletedSta == DasCountCompletedSta)
		{
		//	test.log(LogStatus.PASS, "Number of Activated Events  grid matches to Dashboard Activated Events Count.");
			test.log(LogStatus.PASS, "No of  Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard  Pending For Review Count = "+DasCountCompletedSta);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Activated Events  does not matches to Dashboard Activated Events  Count.");
			test.log(LogStatus.FAIL, "No of Pending For Review in the grid = "+gridCountCompletedSta+" | Dashboard Pending For Review Count = "+DasCountCompletedSta);
		}
		}catch(Exception e){
		String text =	ReviewerPOM.NoRecord().getText();	
		if(text.equalsIgnoreCase("No Records Found.")) {
			test.log(LogStatus.FAIL, "No of Pending For Review in the grid = 0"+" | Dashboard Pending For Review Count = "+DasCountCompletedSta);

		}
			
		}
		Thread.sleep(2000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void DeviationApplied(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(1000);
		
	//	OverduePOM.CalendarArrow().click();
		Thread.sleep(8000);
		OverduePOM.CalendarArrow1().click();
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));
		
		OverduePOM.ClickTriangle().click();
		Thread.sleep(2000);
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceIDcolumns().click();
		Thread.sleep(2000);
		
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(2000);
		OverduePOM.ClickFilter().click();
		Thread.sleep(2000);
	//	OverduePOM.search().sendKeys("");
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("//*[@class='k-label']"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "155446");
		Thread.sleep(6000);
		
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-button k-primary'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Filter");
		Thread.sleep(8000);
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(2000);
		OverduePOM.ClickEdit().click();
		Thread.sleep(4000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		Thread.sleep(3000);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_iPerformerFrame"));
		js.executeScript("window.scrollBy(0,500)");               
		OverduePOM.selectDropdown().click();
		Thread.sleep(3000);
		OverduePOM.selectDropdownDA().click();
		
	String text=	OverduePOM.ReasoverdueDelayCompletion().getText();
	String text1=	OverduePOM.DeviationClosureDate().getText();
	if(text.equalsIgnoreCase("Reason for Overdue/Delay Completion")&&text1.equalsIgnoreCase("Deviation Closure Date")) {
		test.log(LogStatus.PASS, " TThe selection of \"Deviation Applied\" status in the status dropdown, the three new fields (Reason for Overdue / Delay Compliance, Deviation Closure Date, Upload Supporting Document) should be visible in the update compliance status.");

	}else {
		test.log(LogStatus.FAIL, " The selection of \"Deviation Applied\" status in the status dropdown, the three new fields (Reason for Overdue / Delay Compliance, Deviation Closure Date, Upload Supporting Document) should not visible in the update compliance status.");

	}
	
	getDriver().switchTo().parentFrame();
	getDriver().switchTo().parentFrame();
	Thread.sleep(1000);
	OverduePOM.ClosePopup().click();
	Thread.sleep(3000);
	}
	
	
	public static void DeviationAppliedW(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(3000);
		
	//	OverduePOM.CalendarArrow().click();
		Thread.sleep(8000);
		OverduePOM.Complianceid().sendKeys("155445");
		Thread.sleep(3000);
		
		OverduePOM.clickApply().click();
		
		Thread.sleep(8000);
		
		OverduePOM.Edit().click();
		Thread.sleep(3000);
		
getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");	
		
		
		
	             try {  
		OverduePOM.selectStatutoryDropdown().click();
		Thread.sleep(3000);
		
		String textDA=	OverduePOM.selectDropdownDA().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")) {
			test.log(LogStatus.PASS, "The new status named \"Deviation Applied\" should reflects separately in the status dropdown.");

		}
		OverduePOM.selectDropdownDA().click();
		Thread.sleep(3000);
		
	String text=	OverduePOM.ReasoverdueDelayCompletion().getText();
	String text1=	OverduePOM.DeviationClosureDate().getText();
	if(text.equalsIgnoreCase("Reason for Overdue/Delay Completion")&&text1.equalsIgnoreCase("Deviation Closure Date")) {
		test.log(LogStatus.PASS, " TThe selection of \"Deviation Applied\" status in the status dropdown, the three new fields (Reason for Overdue / Delay Compliance, Deviation Closure Date, Upload Supporting Document) should be visible in the update compliance status.");

	}else {
		test.log(LogStatus.FAIL, " The selection of \"Deviation Applied\" status in the status dropdown, the three new fields (Reason for Overdue / Delay Compliance, Deviation Closure Date, Upload Supporting Document) should not visible in the update compliance status.");

	}
	             }catch(Exception e) {
	         		test.log(LogStatus.FAIL, " The new status named Deviation Applied should not reflects in the status dropdown.");
	             }
	
	getDriver().switchTo().parentFrame();
	
	Thread.sleep(1000);
	OverduePOM.ClosePopup1().click();
	Thread.sleep(3000);
	}
	
	public static void DeviationAppliedWS(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(3000);
		
	//	OverduePOM.CalendarArrow().click();
		Thread.sleep(8000);
		OverduePOM.Complianceid().sendKeys("155444");
		Thread.sleep(3000);
		
		OverduePOM.clickApply().click();
		
		Thread.sleep(8000);
		
		OverduePOM.Edit().click();
		Thread.sleep(3000);
		
getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");	
		
		
		
	             try {  
		OverduePOM.selectStatutoryDropdown().click();
		Thread.sleep(3000);
		
		OverduePOM.selectDropdownDA().click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();	
		Thread.sleep(1000);//Click on the Date text box
		OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
		Thread.sleep(3000);
		
		OverduePOM.txtdeviationreason().sendKeys("Reason");	
		Thread.sleep(1000);//Click on the Date text box
		OverduePOM.tbxDateDev().click();
		Thread.sleep(1000);
		OverduePOM.tbxDateDev1().click();						//Clicking to get last month
		Thread.sleep(3000);
		
		OverduePOM.clickComplianceSubmit().click();						//Clicking to get last month
		Thread.sleep(3000);
		
	String text =	getDriver().switchTo().alert().getText();
		
	test.log(LogStatus.PASS, "Message displayed : -"+text);
	
		getDriver().switchTo().alert().accept();								//Accepting msg of Successful Submittion.
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		
	
	             }catch(Exception e) {
	            	 
	            	 getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
	         		Thread.sleep(5000);
	         		OverduePOM.ClosePopup1().click();
	         		Thread.sleep(3000);
	         		test.log(LogStatus.FAIL, " The new status named Deviation Applied not reflects in the status dropdown.");
	             }
	
	
	
	Thread.sleep(1000);
	
	}
	
	
	public static void DeviationAppliedWD(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(3000);
		
	//	OverduePOM.CalendarArrow().click();
		Thread.sleep(8000);
		OverduePOM.Complianceid().sendKeys("155445");
		Thread.sleep(3000);
		
		OverduePOM.clickApply().click();
		
		Thread.sleep(8000);
		
		OverduePOM.Edit().click();
		Thread.sleep(3000);
		
getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");	
		
		
		
	             try {  
		OverduePOM.selectStatutoryDropdown().click();
		Thread.sleep(3000);
		
		OverduePOM.selectDropdownDA().click();
		Thread.sleep(3000);
		
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();	
		Thread.sleep(1000);//Click on the Date text box
		OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
		Thread.sleep(3000);
		
		OverduePOM.txtdeviationreason().sendKeys("Reason");	
		Thread.sleep(1000);//Click on the Date text box
		OverduePOM.tbxDateDev().click();
		Thread.sleep(1000);
		OverduePOM.tbxDateDev1().click();						//Clicking to get last month
		Thread.sleep(3000);
		
		OverduePOM.clickComplianceSubmit().click();						//Clicking to get last month
		Thread.sleep(3000);
		
	String text =	OverduePOM.Text().getText();
		
	test.log(LogStatus.PASS, "Message displayed : -"+text);
	
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		OverduePOM.ClosePopup1().click();
	
	             }catch(Exception e) {
	            	 
	            	 getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
	         		Thread.sleep(5000);
	         		OverduePOM.ClosePopup1().click();
	         		Thread.sleep(3000);
	         		test.log(LogStatus.FAIL, " The new status named Deviation Applied not reflects in the status dropdown.");
	             }
	
	
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationAppliedWR(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(3000);
		
	//	OverduePOM.CalendarArrow().click();
		Thread.sleep(8000);
		OverduePOM.Complianceid().sendKeys("155445");
		Thread.sleep(3000);
		
		OverduePOM.clickApply().click();
		
		Thread.sleep(8000);
		
		OverduePOM.Edit().click();
		Thread.sleep(3000);
		
getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");	
		
		
		
	             try {  
		OverduePOM.selectStatutoryDropdown().click();
		Thread.sleep(3000);
		
		OverduePOM.selectDropdownDA().click();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
		Thread.sleep(3000);
		OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	//	OverduePOM.buttonAddLink().click();						//Clicking on 'Add Link' button of Compliance Documents
		Thread.sleep(2000);
		
			
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,2500)"," ");				//Scrolling down window by 2000 px.
		
		wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectDateStatutory()));
		OverduePOM.selectDateStatutory().click();	
		Thread.sleep(1000);//Click on the Date text box
		OverduePOM.selectDateStatutory11().click();						//Clicking to get last month
		Thread.sleep(3000);
		
		OverduePOM.remark().sendKeys("Automation Testing");		
		Thread.sleep(3000);
		OverduePOM.clickComplianceSubmit().click();						//Clicking to get last month
		Thread.sleep(3000);
		
	String text =	OverduePOM.Text().getText();
		
	test.log(LogStatus.PASS, "Message displayed : -"+text);
	
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
		Thread.sleep(5000);
		OverduePOM.ClosePopup1().click();
	
	             }catch(Exception e) {
	            	 
	            	 getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
	         		Thread.sleep(5000);
	         		OverduePOM.ClosePopup1().click();
	         		Thread.sleep(3000);
	         		test.log(LogStatus.FAIL, " The new status named Deviation Applied not reflects in the status dropdown.");
	             }
	
	
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationAppliedWC(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		Thread.sleep(4000);
		
	//	OverduePOM.CalendarArrow().click();
		Thread.sleep(8000);
		OverduePOM.Complianceid().sendKeys("130662");
		Thread.sleep(3000);
		
		OverduePOM.clickApply().click();
		
		Thread.sleep(8000);
		
		OverduePOM.clickStatutoryChecklistActionDA().click();
		Thread.sleep(3000);
		
getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");	
		
		
		
	             try { 
	            	 try {
	            	 wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
	     			OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	     		//	OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
                        }catch(Exception e){
	            		 
	            	 }
	     			Thread.sleep(1000);
	     			js.executeScript("window.scrollBy(0,1500)"," ");				//Scrolling down window by 2000 px.
	     			OverduePOM.remark().sendKeys("Automation Testing");
	     			Thread.sleep(2000);
	     			
	     				
	     					Thread.sleep(2000);
	     					OverduePOM.clickClosedDelayed().click();	  //Clicking on 'Closed Delayed' button.
	     				
	     					Thread.sleep(1000);
	     				
	     			
	     			try
	     			{
	     				Thread.sleep(1000);
	     				getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
	     				Thread.sleep(2000);
	     				test.log(LogStatus.PASS, " Compliance should get Saved without showing the validation message for mandatory fields.(Reason for Overdue / Delay Compliance, Deviation Closure Date)");
	     			}
	     			catch(Exception e)
	     			{
	     				OverduePOM.clickClose().click();
	     				Thread.sleep(1000);
	     			}
		
	     			 getDriver().switchTo().parentFrame();		
		
		
	
	             }catch(Exception e) {
	            	 
	            	 getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
	         		Thread.sleep(5000);
	         		OverduePOM.ClosePopup1().click();
	         		Thread.sleep(3000);
	         		test.log(LogStatus.FAIL, " The new status named Deviation Applied not reflects in the status dropdown.");
	             }
	
	
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationAppliedWCD(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		OverduePOM.clickStatutoryChecklist().click();				//Clicking on Statutory Checklist value
		Thread.sleep(4000);
		
	//	OverduePOM.CalendarArrow().click();
		Thread.sleep(8000);
		OverduePOM.Complianceid().sendKeys("151993");
		Thread.sleep(3000);
		
		OverduePOM.clickApply().click();
		
		Thread.sleep(8000);
		
		OverduePOM.clickStatutoryChecklistActionDA().click();
		Thread.sleep(5000);
		
getDriver().switchTo().frame("iPerformerFrame");						//Switching 1st iFrame.
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)"," ");	
		
		Thread.sleep(5000);
		
	             try {  
	            	 try {
	            	 wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.fileUploadStatutory()));
	     			OverduePOM.fileUploadStatutory().sendKeys("D:\\Automation File\\Charge.xlsx");	//Providing Compliance Documents link
	     		//	OverduePOM.statutoryAddLinkButton().click();						//Clicking on 'Add Link' button of Compliance Documents
	            	 }catch(Exception e){
	            		 
	            	 }
	     			Thread.sleep(1000);
	     			js.executeScript("window.scrollBy(0,1500)"," ");				//Scrolling down window by 2000 px.
	     			OverduePOM.remark().sendKeys("Automation Testing");
	     			Thread.sleep(2000);
	     			
	     			OverduePOM.txtdeviationreason().sendKeys("Reason");	
	     			Thread.sleep(1000);//Click on the Date text box
	     			OverduePOM.tbxDateDev().click();
	     			Thread.sleep(1000);
	     			OverduePOM.tbxDateDev1().click();						//Clicking to get last month
	     			Thread.sleep(3000);
	     					
	     			OverduePOM.btnDeviationApplied().click();						//Clicking to get last month
	     			Thread.sleep(5000);
	     			
	     			
	     				String text =	getDriver().switchTo().alert().getText();
	     				
	     				test.log(LogStatus.PASS, "Message displayed : -"+text);
	     				Thread.sleep(1000);
	     				getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
	     				Thread.sleep(2000);
	     			
	     			getDriver().switchTo().parentFrame();	
	     			Thread.sleep(4000);
	
	             }catch(Exception e) {
	            	 
	            	 getDriver().switchTo().parentFrame();								//Switching back to parent frame from iFrame
	         		Thread.sleep(5000);
	         		OverduePOM.ClosePopup1().click();
	         		Thread.sleep(3000);
	         		
	             }
	
	
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationApproverCol(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(4000);
		
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationAppliedCol().click();
		Thread.sleep(2000);
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
	
String textDA=	OverduePOM.DeviationApprover().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Approver")) {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" should be display on the additional column of \"deviation approver\".");

		}else {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" not display on the additional column of \"deviation approver\".");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationClosureStatuscol(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		Thread.sleep(4000);
		
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationClosureStatuscol().click();
		Thread.sleep(2000);
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
	
String textDA=	OverduePOM.DeviationClosureStatus().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Closure Status")) {
			test.log(LogStatus.PASS, " The  name of \"Deviation Closure Status\" should be display on the additional column of \"Deviation Closure Statusr\".");

		}else {
			test.log(LogStatus.PASS, " The  name of \"Deviation Closure Status\" not display on the additional column of \"Deviation Closure Status\".");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationApproverColRE(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
		//Thread.sleep(4000);
		
		//ReviewerPOM.User().click();		//Clicking on 'My Workspace'
		
		//Thread.sleep(500);
		//ReviewerPOM.User1().click();			//Clicking on 'Compliance' under My Workspace
		//Thread.sleep(4000);
		//OverduePOM.clickApply().click();
		Thread.sleep(5000);
		
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationAppliedCol().click();
		Thread.sleep(2000);
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
	
		String textDA=	OverduePOM.DeviationApprover().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Approver")) {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" should be display on the additional column of \"deviation approver\".");

		}else {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" not display on the additional column of \"deviation approver\".");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationClosureStatuscolRE(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
        OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
//		Thread.sleep(4000);
//		
//		ReviewerPOM.User().click();		//Clicking on 'My Workspace'
//		
//		Thread.sleep(500);
//		ReviewerPOM.User1().click();			//Clicking on 'Compliance' under My Workspace
//		Thread.sleep(4000);
//		OverduePOM.clickApply().click();
		Thread.sleep(5000);
		
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationClosureStatuscol().click();
		Thread.sleep(2000);
		OverduePOM.ClickTriangle().click();
		Thread.sleep(3000);
	
		String textDA=	OverduePOM.DeviationClosureStatus().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Closure Status")) {
			test.log(LogStatus.PASS, " The  name of \"Deviation Closure Status\" should be display on the additional column of \"Deviation Closure Statusr\".");

		}else {
			test.log(LogStatus.PASS, " The  name of \"Deviation Closure Status\" not display on the additional column of \"Deviation Closure Status\".");

		}
	
	Thread.sleep(1000);
	
	}
	
	
	public static void ComplianceDocumentsDA(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(5000);
		
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		
		
	
     String textDA=	OverduePOM.DeviationApplied().getText();
     String textDR=	OverduePOM.DeviationRejected().getText();
     String textDAp=	OverduePOM.DeviationApproved().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  of my document page");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  of my document page");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void ComplianceDocumentsDAM(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(5000);
		
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		
		
	
     String textDA=	OverduePOM.DeviationAppliedCD().getText();
     String textDR=	OverduePOM.DeviationRejectedCD().getText();
     String textDAp=	OverduePOM.DeviationApprovedCD().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  of my document page");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  of my document page");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void ComplianceDocumentsDAMAu(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(5000);
		
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		
		
	
     String textDA=	OverduePOM.DeviationAppliedCD1().getText();
     String textDR=	OverduePOM.DeviationRejectedCD1().getText();
     String textDAp=	OverduePOM.DeviationApprovedCD1().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  of my document page");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  of my document page");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void DeviationApproverColCD(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(5000);
		
		
		
		
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		//OverduePOM.DeviationApplied().click();
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Deviation Applied");
			
		Thread.sleep(3000);
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
	//	OverduePOM.DeviationRejected().click();
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
		Thread.sleep(3000);
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		//OverduePOM.DeviationApproved().click();
		List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
		Thread.sleep(3000);
		OverduePOM.clickApply().click();
		Thread.sleep(8000);
		
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationAppliedCol().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(8000);
		
	
        List<String> li=new ArrayList<String>();
        
        li.add("Deviation Approver");
       
        Thread.sleep(3000);
        
	//	List<String> filter=new ArrayList<String>();	
	//	filter.add("Deviation Approver");
			
		
	 
		      
		
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[20]"));
	
	
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(DA);
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
		 if(!fail.isEmpty()) {
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
		 }	
		}else {
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
				test.log(LogStatus.PASS, " displayed : "+Pas);	
		//		System.out.println(filter.get(i)+" : "+Pas);
	 }
		}
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		
/*	
String textDA=	OverduePOM.DeviationApprover().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Approver")) {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" should be display on the additional column of \"deviation approver\".");

		}else {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" not display on the additional column of \"deviation approver\".");

		}
	*/
	
	
	}
	
	public static void DeviationApproverColCDAPP(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(5000);
		
		
		CFOcountPOM.PeriodD().click();					//Clicking on 'My Documents'
		Thread.sleep(1000);
		CFOcountPOM.AllPeriod().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		//OverduePOM.DeviationApplied().click();
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Deviation Applied");
			
		Thread.sleep(3000);
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
	//	OverduePOM.DeviationRejected().click();
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
		Thread.sleep(3000);
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		//OverduePOM.DeviationApproved().click();
		List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
		Thread.sleep(3000);
		OverduePOM.clickApply().click();
		Thread.sleep(8000);
		
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationAppliedCol().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(8000);
		
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[20]"));
	
	
		Thread.sleep(2000);

		for(int i=0; i<DA.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(DA);
				}
			
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(!text.get(l).isEmpty())
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : ");

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : ");
					System.out.println(i);

				}
				 }
		 if(!fail.isEmpty()) {
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
		 }	
		}else {
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
				test.log(LogStatus.PASS, " displayed : "+Pas);	
		//		System.out.println(filter.get(i)+" : "+Pas);
	 }
		}
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		
/*	
String textDA=	OverduePOM.DeviationApprover().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Approver")) {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" should be display on the additional column of \"deviation approver\".");

		}else {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" not display on the additional column of \"deviation approver\".");

		}
	*/
	
	
	}
	
	public static void DeviationApproverColCRE(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		 OverduePOM.clickMyWorkspace().click();		//Clicking on 'My Workspace'
			
			Thread.sleep(500);
			OverduePOM.clickCompliance().click();			//Clicking on 'Compliance' under My Workspace
			Thread.sleep(4000);
			
			ReviewerPOM.User().click();		//Clicking on 'My Workspace'
			
			Thread.sleep(500);
			ReviewerPOM.User1().click();			//Clicking on 'Compliance' under My Workspace
			Thread.sleep(4000);
		
		
		OverduePOM.StatusOverdue().click();
		Thread.sleep(3000);
		//OverduePOM.DeviationApplied().click();
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Deviation Applied");
			
		Thread.sleep(3000);
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
	//	OverduePOM.DeviationRejected().click();
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
		Thread.sleep(3000);
		OverduePOM.StatusCD().click();
		Thread.sleep(3000);
		//OverduePOM.DeviationApproved().click();
		List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
		Thread.sleep(3000);
		OverduePOM.clickApply().click();
		Thread.sleep(5000);
		
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationAppliedCol().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
	
        List<String> li=new ArrayList<String>();
        
        li.add("Deviation Approver");
       
        Thread.sleep(3000);
        
	//	List<String> filter=new ArrayList<String>();	
	//	filter.add("Deviation Approver");
			
		
	 
		      
		
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[20]"));
	
	
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(DA);
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
		 if(!fail.isEmpty()) {
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
		 }	
		}else {
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
				test.log(LogStatus.PASS, " displayed : "+Pas);	
		//		System.out.println(filter.get(i)+" : "+Pas);
	 }
		}
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		
/*	
String textDA=	OverduePOM.DeviationApprover().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Approver")) {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" should be display on the additional column of \"deviation approver\".");

		}else {
			test.log(LogStatus.PASS, " The  name of \"deviation approver\" not display on the additional column of \"deviation approver\".");

		}
	*/
	
	
	}
	
	public static void DeviationClosureStatuscolCD(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(5000);
		
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.DeviationClosureStatuscol().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
	
String textDA=	OverduePOM.DeviationClosureStatusCD().getText();
Thread.sleep(3000);
		if(textDA.equalsIgnoreCase("Deviation Closure Status")) {
			test.log(LogStatus.PASS, " The additional column of \"Deviation Closure Status\" should be display on the gird.");

		}else {
			test.log(LogStatus.FAIL, " The additional column of \\\"Deviation Closure Status\\\" not display on the gird.");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void PerformReviewEmailCol(ExtentTest test)throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(4000);
		CFOcountPOM.clickReport().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReports().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
	//	CFOcountPOM.Apply().click();
	//	Thread.sleep(4000);
		
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.PerformerEmailmenu().click();
		Thread.sleep(2000);
		OverduePOM.ReviewerEmailmenu().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
	//	WebElement scrollElement = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]"));
	//	Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,500)");	
	//	Thread.sleep(3000);
	//	js.executeScript("window.scrollBy(1000,0)");	
	//	js.executeScript("arguments[0].scrollLeft += 500;",scrollElement);	
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-500)");
//String textPC=	OverduePOM.Performercol().getText();
//String textRC=	OverduePOM.Reviewercol().getText();
Thread.sleep(6000);
if(OverduePOM.Performercol().isDisplayed()&& OverduePOM.Reviewercol().isDisplayed()) {
	test.log(LogStatus.PASS, "The additional column of \"Performer Email and Reviewer Email \" should be display on the gird.");
}else {
	test.log(LogStatus.FAIL, "The additional column of \"Performer Email and Reviewer Email\" not display on the gird.");
}
/*
		if(textPC.equalsIgnoreCase("Performer Email") && textRC.equalsIgnoreCase("Reviewer Email") ) {
			test.log(LogStatus.PASS, " The additional column of \"Performer Email and Reviewer Email \" should be display on the gird.");

		}else {
			test.log(LogStatus.FAIL, " The additional column of \"Performer Email and Reviewer Email\" not display on the gird.");

		}
	*/
	Thread.sleep(1000);
	
	}
	
	public static void PerformReviewEmailColIn(ExtentTest test)throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(4000);
		CFOcountPOM.clickReport().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReports().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
	//	CFOcountPOM.Apply().click();
	//	Thread.sleep(4000);
		
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
		OverduePOM.Clickcolumns().click();
		Thread.sleep(2000);
		OverduePOM.PerformerEmailmenu().click();
		Thread.sleep(2000);
		OverduePOM.ReviewerEmailmenu().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceIDtri().click();
		Thread.sleep(3000);
		
	//	WebElement scrollElement = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]"));
	//	Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,500)");	
	//	Thread.sleep(3000);
	//	js.executeScript("window.scrollBy(1000,0)");	
	//	js.executeScript("arguments[0].scrollLeft += 500;",scrollElement);	
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-500)");
//String textPC=	OverduePOM.Performercol().getText();
//String textRC=	OverduePOM.Reviewercol().getText();
Thread.sleep(6000);
if(OverduePOM.Performercol().isDisplayed()&& OverduePOM.Reviewercol().isDisplayed()) {
	test.log(LogStatus.PASS, "The additional column of \"Performer Email and Reviewer Email \" should be display on the gird.");
}else {
	test.log(LogStatus.FAIL, "The additional column of \"Performer Email and Reviewer Email\" not display on the gird.");
}
/*
		if(textPC.equalsIgnoreCase("Performer Email") && textRC.equalsIgnoreCase("Reviewer Email") ) {
			test.log(LogStatus.PASS, " The additional column of \"Performer Email and Reviewer Email \" should be display on the gird.");

		}else {
			test.log(LogStatus.FAIL, " The additional column of \"Performer Email and Reviewer Email\" not display on the gird.");

		}
	*/
	Thread.sleep(1000);
	
	}
	

	public static void DetailedReportDA(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(4000);
		
		OverduePOM.ClickDropD().click();
		Thread.sleep(3000);
		OverduePOM.SelectPerformer().click();
		Thread.sleep(2000);
		
		
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryRe().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		
		OverduePOM.StatusDR().click();
		Thread.sleep(3000);
		
		
	
     String textDA=	OverduePOM.DeviationAppliedDR().getText();
     String textDR=	OverduePOM.DeviationRejectedDR().getText();
     String textDAp=	OverduePOM.DeviationApprovedDR().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  of my document page");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  of my document page");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void DetailedReportDAM(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(4000);
	
		
		
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryRe().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		
		OverduePOM.StatusDR().click();
		Thread.sleep(3000);
		
		
	
     String textDA=	OverduePOM.DeviationAppliedDR().getText();
     String textDR=	OverduePOM.DeviationRejectedDR().getText();
     String textDAp=	OverduePOM.DeviationApprovedDR().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  of my document page");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  of my document page");

		}
	
	Thread.sleep(1000);
	
	}
	
	public static void OverdueDA(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		OverduePOM.clickStatutoryOverdue().click();		
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
	
	public static void DetailedReportSF(ExtentTest test) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		OverduePOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		OverduePOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		
		CFOcountPOM.ComplianceID().sendKeys("6696");
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton =getDriver() .findElement(locator);	
		Thread.sleep(3000);
		JavascriptExecutor jse= (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
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
		CFOcountPOM.closeDocument2().click();
	}

	public static void ComplianceDocumentsSF(ExtentTest test  ) throws InterruptedException, IOException
	{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
			Thread.sleep(1000);
			CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
			Thread.sleep(3000);
			CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents '
			
			Thread.sleep(3000);
			CFOcountPOM.PeriodD1().click();	
			
			Thread.sleep(3000);
			CFOcountPOM.AllPeriod().click();
			
			
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			Thread.sleep(3000);
			CFOcountPOM.ComplianceID1().sendKeys("6696");
			
			Thread.sleep(2000);
			CFOcountPOM.Apply().click();
			Thread.sleep(2000);
			By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a[3]");
			
			WebElement ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
			JavascriptExecutor jse= (JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
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
			CFOcountPOM.closeDocument2().click();
		}
	
	public static void IsSmetaColumn(ExtentTest test, String Status, int complianceCount)throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
       Thread.sleep(500);
		Actions action = new Actions(getDriver());
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	//	int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
	//	CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickNotCompleted().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);
//			Thread.sleep(2000);
//			CFOcountPOM.readHigh().click();	
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readMedium().click();
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readLow().click();
//			Thread.sleep(2000);
			
			}
		else if(Status.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickClosedDelayed().click();
			CFOcountPOM.readCritical().click();	
			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);
//			Thread.sleep(2000);
//			CFOcountPOM.readHigh().click();	
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readMedium().click();
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readLow().click();
//			Thread.sleep(2000);
				}
		else if(Status.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickClosedTimely().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);
//			Thread.sleep(2000);
//			CFOcountPOM.readHigh().click();	
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readMedium().click();
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readLow().click();
//			Thread.sleep(2000);
					}
		else if(Status.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickNotApplicableA().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);
//			Thread.sleep(2000);
//			CFOcountPOM.readHigh().click();	
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readMedium().click();
//			Thread.sleep(2000);
//			MethodsPOM.IsSmetaColum1(test,Status, complianceCount);	
//			Thread.sleep(2000);
//			CFOcountPOM.readLow().click();
//			Thread.sleep(2000);
					}
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.7);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		
			Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
	        
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
		// MgmtSonyMethod.ClickTri1().click();
	   //  Thread.sleep(1000);
	     
     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Not Completed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Completed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Completed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("Closed Delayed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Delayed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Delayed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Closed Timely"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Timely - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Timely - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Not Applicable"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Applicable - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Applicable - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}		
Thread.sleep(6000);
getDriver().switchTo().parentFrame();
Thread.sleep(1000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);
	Thread.sleep(5000);
	
	}
	
	
	

	public static void NotCompgraphIsSmetaColumn(ExtentTest test, String Status, int complianceCount)throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
       Thread.sleep(500);
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		Thread.sleep(5000);									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Overdue"))
		{
			CFOcountPOM.clickOverdue().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
			}
		else if(Status.equalsIgnoreCase("DueToday"))
		{
			CFOcountPOM.clickdueToday().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
				}
		else if(Status.equalsIgnoreCase("Pending For Review"))
		{
			CFOcountPOM.clickpendingForReview().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
					}
		else if(Status.equalsIgnoreCase("In Progress"))
		{
			CFOcountPOM.clickinProgress().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();
					}
		else if(Status.equalsIgnoreCase("Rejected"))
		{
			CFOcountPOM.clickRejected().click();
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();
		}
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.7);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
			Thread.sleep(1000);
		
	        
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
		 MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     
	  
		/*
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-500)");
*/
	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Overdue"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Overdue - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Overdue - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("DueToday"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "DueToday - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "DueToday - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Pending For Review"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Pending For Review - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Pending For Review - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("In Progress"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "In Progress - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "In Progress - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}	
			}
				else if(Status.equalsIgnoreCase("Rejected"))
				{
					if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
						test.log(LogStatus.PASS, "Rejected - The additional column of \"Is SMETA Compliance \" display on the gird.");
					}else {
						test.log(LogStatus.FAIL, "Rejected - The additional column of \"Is SMETA Compliance\" not display on the gird.");
					}	//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
		}
		else {
			test.log(LogStatus.PASS, "No Record Found");

		}
		
Thread.sleep(6000);
getDriver().switchTo().parentFrame();
Thread.sleep(1000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);
	Thread.sleep(5000);
	
	//CFOcountPOM.clickBack1().click();	//Clicking on Dashboard
	//Thread.sleep(1000);
	
	}
	public static void setZoomLevel(WebDriver driver, double zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
    }
	
	public static void IsSmetaColumnOverallFun(ExtentTest test, String Status, int complianceCount)throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
       Thread.sleep(500);
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);									//CLicking on 'Not Completed' count
	//	int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.clickIndustrySpeCriticalM().getText());	//Reading the High value of Labour compliance		
		Thread.sleep(1000);
									
		Thread.sleep(500);

		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely().click();
			Thread.sleep(2000);
			
			}
		else if(Status.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed().click();
			Thread.sleep(2000);
			
				}
		else if(Status.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable().click();
			Thread.sleep(2000);
			
					}
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.7);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		
			Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
	        
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
		 MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     
	  
		/*
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-500)");
*/
	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Closed Timely"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Timely - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Timely - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("Closed Delayed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Delayed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Delayed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Not Completed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Completed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Completed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Not Applicable"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Applicable - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Applicable - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
		
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(1000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);
	Thread.sleep(5000);
	
	}
	
	public static void IsSmetaColumnRisksummary(ExtentTest test, String Status)throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
       Thread.sleep(500);
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);									//CLicking on 'Not Completed' count
		Thread.sleep(1000);			
		Thread.sleep(500);

		if(Status.equalsIgnoreCase("Not Completed"))
		{		
			Thread.sleep(5000);
			CFOcountPOM.clickRiskCriticalNotCompleted().click();
			Thread.sleep(2000);
			
			}
		else if(Status.equalsIgnoreCase("Closed Delayed"))
		{
			  Thread.sleep(2000);
			CFOcountPOM.clickRiskHighClosedDelayed().click();
			Thread.sleep(2000);
			
				}
		else if(Status.equalsIgnoreCase("Closed Timely"))
		{
			
			CFOcountPOM.clickRiskHighClosedTimely().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("DueToday"))
		{
			
			CFOcountPOM.clickRiskHighDuetoday().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("Not Applicable"))
		{
			
			CFOcountPOM.clickRiskHighNotApplicable().click();
			Thread.sleep(2000);
			
					}
		
		
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.7);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		
			Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
	        
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
		 MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     
	  
		/*
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-500)");
*/
	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Closed Timely"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Timely - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Timely - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("Closed Delayed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Delayed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Delayed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Not Completed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Completed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Completed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("DueToday"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "DueToday - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "DueToday - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}	
			}
			else if(Status.equalsIgnoreCase("Not Applicable"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Applicable - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Applicable - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}	
				//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			
		
Thread.sleep(6000);
getDriver().switchTo().parentFrame();
Thread.sleep(1000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);
	Thread.sleep(5000);
	
	}
	
	
	public static void IsSmeta(ExtentTest test, String Status)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
	       Thread.sleep(500);
			Actions action = new Actions(getDriver());
			Thread.sleep(3000);		
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	try {
           // Set zoom level to 50% (0.5) for zooming out
          setZoomLevel(getDriver(), 0.7);
           // Wait to observe the effect
          Thread.sleep(2000);

       // Set zoom level back to 100% (1.0) to reset to normal        
		 // setZoomLevel(getDriver(), 1.0);
		} catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	
		Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");
        
	Thread.sleep(3000);
	MgmtSonyMethod.ClickTri1().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(5000);
	OverduePOM.IsSMETAColumnCheckBox().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri1().click();
     Thread.sleep(1000);     
     
     Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Closed Timely"))
		{
			if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
				test.log(LogStatus.PASS, "Closed Timely - The additional column of \"Is SMETA Compliance \" display on the gird.");
			}else {
				test.log(LogStatus.FAIL, "Closed Timely - The additional column of \"Is SMETA Compliance\" not display on the gird.");
			}				
		}
		else if(Status.equalsIgnoreCase("Closed Delayed"))
		{
			if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
				test.log(LogStatus.PASS, "Closed Delayed - The additional column of \"Is SMETA Compliance \" display on the gird.");
			}else {
				test.log(LogStatus.FAIL, "Closed Delayed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
			}				}
		else if(Status.equalsIgnoreCase("Not Completed"))
		{
			if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
				test.log(LogStatus.PASS, "Not Completed - The additional column of \"Is SMETA Compliance \" display on the gird.");
			}else {
				test.log(LogStatus.FAIL, "Not Completed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
			}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(Status.equalsIgnoreCase("DueToday"))
		{
			if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
				test.log(LogStatus.PASS, "DueToday - The additional column of \"Is SMETA Compliance \" display on the gird.");
			}else {
				test.log(LogStatus.FAIL, "DueToday - The additional column of \"Is SMETA Compliance\" not display on the gird.");
			}	
		}
		else if(Status.equalsIgnoreCase("Not Applicable"))
		{
			if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
				test.log(LogStatus.PASS, "Not Applicable - The additional column of \"Is SMETA Compliance \" display on the gird.");
			}else {
				test.log(LogStatus.FAIL, "Not Applicable - The additional column of \"Is SMETA Compliance\" not display on the gird.");
			}	
			//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		
	
Thread.sleep(6000);
getDriver().switchTo().parentFrame();
Thread.sleep(1000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);
Thread.sleep(5000);
}
	
	public static void IsSmetaColumnDepartSummary(ExtentTest test, String Status)throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
       Thread.sleep(500);
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);									//CLicking on 'Not Completed' count
		Thread.sleep(1000);			
		Thread.sleep(500);

		if(Status.equalsIgnoreCase("Overdue"))
		{		
			Thread.sleep(5000);
			CFOcountPOM.clickHROverduem().click();
			Thread.sleep(2000);			  
			}
		else if(Status.equalsIgnoreCase("Closed Delayed"))
		{
			  Thread.sleep(2000);
			CFOcountPOM.clickHumanClosedDelayed().click();
			Thread.sleep(2000);
			
				}
		else if(Status.equalsIgnoreCase("Closed Timely"))
		{
			
			CFOcountPOM.clickHumanClosedTimely().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("Pending For Review"))
		{
			
			CFOcountPOM.clickHRPendingReviewm1().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("In Progress"))
		{
			
			CFOcountPOM.clickAdminInprogress().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("Rejected"))
		{
			
			CFOcountPOM.clickAdminInRejected().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("Not Applicable"))
		{
			
			CFOcountPOM.clickAdminNotApplicable().click();
			Thread.sleep(2000);
			
					}
		else if(Status.equalsIgnoreCase("DueToday"))
		{
			
			CFOcountPOM.clickAdminDueToday().click();
			Thread.sleep(2000);
			
					}
		
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.7);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		
			Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
	        
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);   
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Overdue"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Overdue - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Overdue - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("Closed Delayed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Delayed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Delayed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Closed Timely"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Timely - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Timely - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Pending For Review"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Pending For Review - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Pending For Review - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("In Progress"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "In Progress - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "In Progress - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("In Progress"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "In Progress - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "In Progress - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Rejected"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Rejected - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Rejected - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}	
			}
			else if(Status.equalsIgnoreCase("Not Applicable"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Applicable - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Applicable - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}	
			}
			else if(Status.equalsIgnoreCase("DueToday"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "DueToday - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "DueToday - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}	
			}
		
Thread.sleep(6000);
getDriver().switchTo().parentFrame();
Thread.sleep(1000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);
	Thread.sleep(5000);
	
	}
	public static void IsSmetaColumnDueForPeriod(ExtentTest test, String Status)throws InterruptedException
	{
//		 Thread.sleep(500);		
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
//			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
//			Thread.sleep(3000);
//			CFOcountPOM.clickNotCompleted().click();
//       Thread.sleep(500);		
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Critical"))
		{			
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
			}
		else if(Status.equalsIgnoreCase("High"))
		{
			Thread.sleep(2000);
			CFOcountPOM.readHigh().click();	
				}
		else if(Status.equalsIgnoreCase("Medium"))
		{
			Thread.sleep(2000);
			CFOcountPOM.readMedium().click();	
					}
		else if(Status.equalsIgnoreCase("Low"))
		{
			Thread.sleep(2000);
			CFOcountPOM.readLow().click();
					}
		
		Thread.sleep(10000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.6);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));

			Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);
	     	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Critical"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, " Critical - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, " Critical - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("High"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "High - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "High - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Medium"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Medium - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Medium - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Low"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Low - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Low - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(3000);
CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
Thread.sleep(2000);

	Thread.sleep(5000);

	}
	
	public static void IsSmetaColumn(ExtentTest test, String Status)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Critical"))
		{			
			Thread.sleep(2000);
			CFOcountPOM.readCritical().click();	
			}
		else if(Status.equalsIgnoreCase("High"))
		{
			Thread.sleep(2000);
			CFOcountPOM.readHigh().click();	
				}
		else if(Status.equalsIgnoreCase("Medium"))
		{
			Thread.sleep(2000);
			CFOcountPOM.readMedium().click();	
					}
		else if(Status.equalsIgnoreCase("Low"))
		{
			Thread.sleep(2000);
			CFOcountPOM.readLow().click();
					}
		
		Thread.sleep(2000);
//		getDriver().switchTo().parentFrame();
//		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.6);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));

		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);
	     	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Critical"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, " Critical - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, " Critical - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("High"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "High - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "High - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Medium"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Medium - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Medium - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Low"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Low - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Low - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);

	Thread.sleep(5000);

	}
	
	public static void IsSmetaColumnDept(ExtentTest test, String Status)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Overdue"))
		{			
			Thread.sleep(2000);
			CFOcountPOM.clickFinanceOverdueDept().click();	
			}
		else if(Status.equalsIgnoreCase("Closed Delayed"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickClosedDelayedDept().click();	
				}
		else if(Status.equalsIgnoreCase("Closed Timely"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickClosedTimelyDpt().click();	
					}
		else if(Status.equalsIgnoreCase("Pending For Review"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickPendingReviewDept().click();
					}
		else if(Status.equalsIgnoreCase("In Progress"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickHumanInprogress().click();
					}
		else if(Status.equalsIgnoreCase("Rejected"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickHumanRejected().click();
					}
		else if(Status.equalsIgnoreCase("Not Applicable"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickHumanNotApplicable().click();
					}
		
		
		Thread.sleep(2000);
//		getDriver().switchTo().parentFrame();
//		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.6);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));

		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);
	     	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Overdue"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, " Overdue - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, " Overdue - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("Closed Delayed"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Delayed - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Delayed - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Closed Timely"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Closed Timely - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Closed Timely - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Pending For Review"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Pending For Review - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Pending For Review - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("In Progress"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "In Progress - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "In Progress - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Rejected"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Rejected - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Rejected - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Not Applicable"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Not Applicable - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Not Applicable - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);

	Thread.sleep(5000);

	}
	
	public static void IsSmetaColumnRiskSummNotComp(ExtentTest test, String Status)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Critical"))
		{						
			Thread.sleep(2000);
			CFOcountPOM.clickRiskCriticalNotCompletedDept().click();	
			}
		else if(Status.equalsIgnoreCase("High"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskHighNotCompletedDept().click();	
				}
		else if(Status.equalsIgnoreCase("Medium"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskMediumNotCompletedDept().click();	
					}
		else if(Status.equalsIgnoreCase("Low"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskLowNotCompletedDept().click();
					}
		
		Thread.sleep(2000);
//		getDriver().switchTo().parentFrame();
//		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.6);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));

		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);
	     	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Critical"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, " Critical - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, " Critical - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("High"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "High - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "High - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Medium"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Medium - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Medium - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Low"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Low - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Low - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);

	Thread.sleep(5000);

	}
	
	
	public static void IsSmetaColumnRiskSummCloDel(ExtentTest test, String Status)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Critical"))
		{						
			Thread.sleep(2000);
			CFOcountPOM.clickRiskCriticalClosedDelayedDpt().click();	
			}
		else if(Status.equalsIgnoreCase("High"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskHighClosedDelayedDpt().click();	
				}
		else if(Status.equalsIgnoreCase("Medium"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskMediumClosedDelayedDpt().click();	
					}
		else if(Status.equalsIgnoreCase("Low"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskLowClosedDelayedDpt().click();
					}
		
		Thread.sleep(2000);
//		getDriver().switchTo().parentFrame();
//		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.6);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));

		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);
	     	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Critical"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, " Critical - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, " Critical - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("High"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "High - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "High - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Medium"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Medium - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Medium - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Low"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Low - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Low - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);

	Thread.sleep(5000);

	}
	
	public static void IsSmetaColumnRiskSummCloTimely(ExtentTest test, String Status)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Critical"))
		{									
			Thread.sleep(2000);
			CFOcountPOM.clickRiskCriticalClosedTimelyDpt().click();	
			}
		else if(Status.equalsIgnoreCase("High"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskHighClosedTimelyDpt().click();	
				}
		else if(Status.equalsIgnoreCase("Medium"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskMediumClosedTimelyDpt().click();	
					}
		else if(Status.equalsIgnoreCase("Low"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskLowClosedTimelyDpt().click();
					}
		
		Thread.sleep(2000);
//		getDriver().switchTo().parentFrame();
//		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.6);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));

		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);
	     	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Critical"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, " Critical - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, " Critical - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("High"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "High - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "High - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Medium"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Medium - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Medium - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Low"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Low - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Low - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);

	Thread.sleep(5000);

	}
	public static void IsSmetaColumnRiskNotAppli(ExtentTest test, String Status)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(2000);
		if(Status.equalsIgnoreCase("Critical"))
		{						
						
			Thread.sleep(2000);
			CFOcountPOM.clickRiskCriticalNotApplicableDE().click();	
			}
		else if(Status.equalsIgnoreCase("High"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskHighNotApplicableDE().click();	
				}
		else if(Status.equalsIgnoreCase("Medium"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskMediumNotApplicableDE().click();	
					}
		else if(Status.equalsIgnoreCase("Low"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskLowNotApplicableDE().click();
					}
		
		Thread.sleep(2000);
//		getDriver().switchTo().parentFrame();
//		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		try {
	           // Set zoom level to 50% (0.5) for zooming out
	          setZoomLevel(getDriver(), 0.6);
	           // Wait to observe the effect
	          Thread.sleep(2000);

	       // Set zoom level back to 100% (1.0) to reset to normal        
			 // setZoomLevel(getDriver(), 1.0);
			} catch (InterruptedException e) {
		          e.printStackTrace();
		        }
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grid")));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));

		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		MgmtSonyMethod.ClickTri1().click();
	     Thread.sleep(1000);
	     MgmtSonyMethod.Columns().click();
	     Thread.sleep(5000);
		OverduePOM.IsSMETAColumnCheckBox().click();
		Thread.sleep(2000);
	//	 MgmtSonyMethod.ClickTri1().click();
	 //    Thread.sleep(1000);
	     	     
	     
	     Thread.sleep(2000);
			if(Status.equalsIgnoreCase("Critical"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, " Critical - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, " Critical - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				
			}
			else if(Status.equalsIgnoreCase("High"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "High - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "High - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}				}
			else if(Status.equalsIgnoreCase("Medium"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Medium - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Medium - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			else if(Status.equalsIgnoreCase("Low"))
			{
				if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
					test.log(LogStatus.PASS, "Low - The additional column of \"Is SMETA Compliance \" display on the gird.");
				}else {
					test.log(LogStatus.FAIL, "Low - The additional column of \"Is SMETA Compliance\" not display on the gird.");
				}					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			}
			
		
Thread.sleep(6000);

getDriver().switchTo().parentFrame();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
Thread.sleep(2000);

	Thread.sleep(5000);

	}
	public static void IsSMETA(ExtentTest test, String Status)throws InterruptedException
	{
//		test = extent.startTest("Pie Chart - Performance Summary - Completion Status- 'Is SMETA Column added' Verification");				
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,300)");			//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedA().getText());	//Reading value of 'After Due Date'
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyA().getText());	//Reading value of 'After Due Date'
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicableA().getText());	//Reading value of 'After Due Date'																
		Thread.sleep(5000);				
		int total = NotCompletedValue + ClosedDelayedValue + ClosedTimelyValue + NotApplicableValue;
		/*
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
		}
	*/
		
		if(total > 0)
		{
			if(NotCompletedValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Not Completed",NotCompletedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Completed' Status Compliance Count = "+NotCompletedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(ClosedDelayedValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Closed Delayed",ClosedDelayedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+ClosedDelayedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(ClosedTimelyValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Closed Timely",ClosedTimelyValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+ClosedTimelyValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(NotApplicableValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Not Applicable",NotApplicableValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+NotApplicableValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
//			Thread.sleep(500);
//			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
//			Thread.sleep(2000);
	}
		else
		{
			test.log(LogStatus.PASS, " 'Completion Status' Compliance Count = "+total);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}

	}
	
	public static void IsSMETA1(ExtentTest test, String Status)throws InterruptedException
	{
//		test = extent.startTest("Pie Chart - Performance Summary - Completion Status- 'Is SMETA Column added' Verification");				
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedA().getText());	//Reading value of 'After Due Date'
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyA().getText());	//Reading value of 'After Due Date'
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicableA().getText());	//Reading value of 'After Due Date'																
		Thread.sleep(5000);				
		int total = NotCompletedValue + ClosedDelayedValue + ClosedTimelyValue + NotApplicableValue;
		/*
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Not Completed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
		}
	*/
		
		if(total > 0)
		{
			if(NotCompletedValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Not Completed",NotCompletedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Completed' Status Compliance Count = "+NotCompletedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(ClosedDelayedValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Closed Delayed",ClosedDelayedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+ClosedDelayedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(ClosedTimelyValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Closed Timely",ClosedTimelyValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+ClosedTimelyValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(NotApplicableValue > 0)
			{
				MethodsPOM.IsSmetaColumn(test, "Not Applicable",NotApplicableValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+NotApplicableValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
//			Thread.sleep(500);
//			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
//			Thread.sleep(2000);
	}
		else
		{
			test.log(LogStatus.PASS, " 'Completion Status' Compliance Count = "+total);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}

	}
	
	public static void IsSMETANotCompletion(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
		int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());	//Reading value of 'Not Completed'			
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());	//Reading value of 'Not Completed'			
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'			
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejected().getText());	//Reading value of 'Not Completed'
		Thread.sleep(5000);				
		int total = OverdueValue + dueTodayValue + pendingForReviewValue + inProgressValue + rejectedValue;
		if(total > 0)
		{
			if(OverdueValue > 0)
			{
				//AuditorcountPOM.GraphCount( test, "Critical", critical, "Statutory");
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "Overdue",OverdueValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			

			}
			else
			{
				test.log(LogStatus.PASS, "'Overdue' Status Compliance Count = "+OverdueValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(dueTodayValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "DueToday",dueTodayValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'DueToday' Status Compliance Count = "+dueTodayValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(pendingForReviewValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "Pending For Review",pendingForReviewValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Pending For Review' Status Compliance Count = "+pendingForReviewValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(inProgressValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "In Progress",inProgressValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'In Progress' Status Compliance Count = "+inProgressValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			if(rejectedValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "Rejected",rejectedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Rejected' Status Compliance Count = "+rejectedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
//			Thread.sleep(500);
//			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
//			Thread.sleep(2000);
	}
		else
		{
			test.log(LogStatus.PASS, " 'Not Completion Status' Compliance Count = "+total);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
		}
		
	}
	
	public static void IsSMETANotCompletion1(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
		int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());	//Reading value of 'Not Completed'			
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());	//Reading value of 'Not Completed'			
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'			
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejected().getText());	//Reading value of 'Not Completed'
		Thread.sleep(5000);				
		int total = OverdueValue + dueTodayValue + pendingForReviewValue + inProgressValue + rejectedValue;
		if(total > 0)
		{
			if(OverdueValue > 0)
			{
				//AuditorcountPOM.GraphCount( test, "Critical", critical, "Statutory");
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "Overdue",OverdueValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			

			}
			else
			{
				test.log(LogStatus.PASS, "'Overdue' Status Compliance Count = "+OverdueValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(dueTodayValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "DueToday",dueTodayValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'DueToday' Status Compliance Count = "+dueTodayValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(pendingForReviewValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "Pending For Review",pendingForReviewValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Pending For Review' Status Compliance Count = "+pendingForReviewValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
			if(inProgressValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "In Progress",inProgressValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'In Progress' Status Compliance Count = "+inProgressValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			if(rejectedValue > 0)
			{
				MethodsPOM.NotCompgraphIsSmetaColumn(test, "Rejected",rejectedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Rejected' Status Compliance Count = "+rejectedValue);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
			}
			
//			Thread.sleep(500);
//			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
//			Thread.sleep(2000);
	}
		else
		{
			test.log(LogStatus.PASS, " 'Not Completion Status' Compliance Count = "+total);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
		}
		
	}
		
	public static void IsSMETAOverallFunction(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,925)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		CFOcountPOM.clickIndustrySpeCriticalM().click();
		Thread.sleep(3000);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;	
		if(total > 0)
		{
			if(ClosedTimely > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Closed Timely",ClosedTimely);
				Thread.sleep(500);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+ClosedTimely);
				Thread.sleep(500);
				
			}
			
			if(ClosedDelayed > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Closed Delayed",ClosedDelayed);
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+ClosedDelayed);
				Thread.sleep(500);
				
			}
			
			if(NotCompleted > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Not completed",NotCompleted);
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not completed' Status Compliance Count = "+NotCompleted);
				Thread.sleep(500);
				
			}
			
			if(NotApplicable > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Not Applicable",NotApplicable);
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+NotApplicable);
				Thread.sleep(500);
				
			}			
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
	}
		else
		{
			test.log(LogStatus.PASS, " 'Critical' Risk Compliance Count = "+total);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
		}
		
	}
	
	public static void IsSMETAOverallFunction1(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,800)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		CFOcountPOM.clickIndustrySpeCriticalM().click();
		Thread.sleep(3000);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;	
		if(total > 0)
		{
			if(ClosedTimely > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Closed Timely",ClosedTimely);
				Thread.sleep(500);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+ClosedTimely);
				Thread.sleep(500);
				
			}
			
			if(ClosedDelayed > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Closed Delayed",ClosedDelayed);
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+ClosedDelayed);
				Thread.sleep(500);
				
			}
			
			if(NotCompleted > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Not completed",NotCompleted);
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not completed' Status Compliance Count = "+NotCompleted);
				Thread.sleep(500);
				
			}
			
			if(NotApplicable > 0)
			{
				MethodsPOM.IsSmetaColumnOverallFun(test, "Not Applicable",NotApplicable);
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+NotApplicable);
				Thread.sleep(500);
				
			}			
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
	}
		else
		{
			test.log(LogStatus.PASS, " 'Critical' Risk Compliance Count = "+total);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
		}
		
	}
	
	public static void IsSMETARisksummary(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	//	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(3000);
		
		if(RiskHigh_NotCompleted > 0)
		{
		//	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			Thread.sleep(2000);
			MethodsPOM.IsSmetaColumnRisksummary(test, "Not completed");
			Thread.sleep(2000);
			
		}
		else
		{
			test.log(LogStatus.PASS, "'Not completed' Status Compliance Count = "+NotCompleted);
			Thread.sleep(500);
			
		}
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Not Completed");
		
		String CloseDelayed = CFOcountPOM.clickRiskHighClosedDelayed().getText();		//Reading the Closed Timely value of Human Resource
		CloseDelayed = CloseDelayed.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_ClosedDelayed = Integer.parseInt(CloseDelayed);
		Thread.sleep(500);
		
		String CloseTimely = CFOcountPOM.clickRiskHighClosedTimely().getText();		//Reading the Closed Timely value of Human Resource
		CloseTimely = CloseTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_ClosedTimely = Integer.parseInt(NotCompleted);
		
		String NotApplicable = CFOcountPOM.clickRiskHighNotApplicable().getText();		//Reading the Closed Timely value of Human Resource
		NotApplicable = NotApplicable.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotApplicable = Integer.parseInt(NotApplicable);
		
		String DueToday = CFOcountPOM.clickRiskHighDuetoday().getText();		//Reading the Closed Timely value of Human Resource
		DueToday = DueToday.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_DueToday = Integer.parseInt(DueToday);
		
		Thread.sleep(2000);
	//	int total = RiskHigh_NotCompleted + RiskCritical_ClosedDelayed + RiskCritical_ClosedTimely + RiskCritical_NotApplicable;	
		
			
			if(RiskCritical_ClosedDelayed > 0)
			{
				List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
				Thread.sleep(2000);
				MethodsPOM.IsSmetaColumnRisksummary(test, "Closed Delayed");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+RiskCritical_ClosedDelayed);
				Thread.sleep(500);
				
			}
			
			if(RiskCritical_ClosedTimely > 0)
			{
				MethodsPOM.IsSmetaColumnRisksummary(test, "Closed Timely");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+RiskCritical_ClosedTimely);
				Thread.sleep(500);
				
			}
			
			if(RiskCritical_DueToday > 0)
			{
				MethodsPOM.IsSmetaColumnRisksummary(test, "DueToday");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'DueToday' Status Compliance Count = "+RiskCritical_DueToday);
				Thread.sleep(500);
				
			}	
			
			if(RiskCritical_NotApplicable > 0)
			{
				MethodsPOM.IsSmetaColumnRisksummary(test, "Not Applicable");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+RiskCritical_NotApplicable);
				Thread.sleep(500);
				
			}			
//			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
//			Thread.sleep(2000);
//	}
//		else
//		{
//		test.log(LogStatus.PASS, " 'Critical' Risk Compliance Count = "+total);
//			
//			Thread.sleep(500);
////			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
//		}
		
	}

	public static void IsSMETARisksummary1(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1200)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(3000);
		
		String CloseDelayed = CFOcountPOM.clickRiskHighClosedDelayed().getText();		//Reading the Closed Timely value of Human Resource
		CloseDelayed = CloseDelayed.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_ClosedDelayed = Integer.parseInt(CloseDelayed);
		Thread.sleep(500);
		String CloseTimely = CFOcountPOM.clickRiskHighClosedTimely().getText();		//Reading the Closed Timely value of Human Resource
		CloseTimely = CloseTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_ClosedTimely = Integer.parseInt(NotCompleted);
		
		String NotApplicable = CFOcountPOM.clickRiskHighNotApplicable().getText();		//Reading the Closed Timely value of Human Resource
		NotApplicable = NotApplicable.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotApplicable = Integer.parseInt(NotApplicable);
		
		String DueToday = CFOcountPOM.clickRiskHighDuetoday().getText();		//Reading the Closed Timely value of Human Resource
		DueToday = DueToday.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_DueToday = Integer.parseInt(DueToday);
		
		Thread.sleep(2000);
		int total = RiskHigh_NotCompleted + RiskCritical_ClosedDelayed + RiskCritical_ClosedTimely + RiskCritical_NotApplicable;	
		if(total>0)
		{
			if(RiskHigh_NotCompleted > 0)
			{
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
				Thread.sleep(2000);
				MethodsPOM.IsSmetaColumnRisksummary(test, "Not completed");
				Thread.sleep(2000);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not completed' Status Compliance Count = "+NotCompleted);
				Thread.sleep(500);
				
			}
			
			if(RiskCritical_ClosedDelayed > 0)
			{
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
				Thread.sleep(2000);
				MethodsPOM.IsSmetaColumnRisksummary(test, "Closed Delayed");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+RiskCritical_ClosedDelayed);
				Thread.sleep(500);
				
			}
			
			if(RiskCritical_ClosedTimely > 0)
			{
				MethodsPOM.IsSmetaColumnRisksummary(test, "Closed Timely");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+RiskCritical_ClosedTimely);
				Thread.sleep(500);
				
			}
			
			if(RiskCritical_DueToday > 0)
			{
				MethodsPOM.IsSmetaColumnRisksummary(test, "DueToday");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'DueToday' Status Compliance Count = "+RiskCritical_DueToday);
				Thread.sleep(500);
				
			}	
			
			if(RiskCritical_NotApplicable > 0)
			{
				MethodsPOM.IsSmetaColumnRisksummary(test, "Not Applicable");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+RiskCritical_NotApplicable);
				Thread.sleep(500);
				
			}			
//			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
//			Thread.sleep(2000);
	}
		else
		{
		test.log(LogStatus.PASS, " 'Critical' Risk Compliance Count = "+total);
			
			Thread.sleep(500);
//			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
		}
		
	}

	
	
	public static void IsSMETADepSumm(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		
		String NotCompleted = CFOcountPOM.clickHROverduem().getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);	
		
		if(Overdue > 0)
		{
//			roc.click();
			Thread.sleep(500);
			MethodsPOM.IsSmetaColumnDepartSummary(test, "Overdue");
			Thread.sleep(2000);
			
		}
		else
		{
			test.log(LogStatus.PASS, "'Overdue' Status Compliance Count = "+Overdue);
			Thread.sleep(500);
			
		}

		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));		
		roc.click();
		Thread.sleep(3000);
		
		String ClosedDelayed = CFOcountPOM.clickHumanClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
		Thread.sleep(500);
		if(Closed_Delayed > 0)
		{
			//roc.click();
			Thread.sleep(500);
			MethodsPOM.IsSmetaColumnDepartSummary(test, "Closed Delayed");
			Thread.sleep(500);
			
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+Closed_Delayed);
			Thread.sleep(500);
			
		}
		
		Thread.sleep(3000);
		String ClosedTimely = CFOcountPOM.clickHumanClosedTimely().getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);	
		Thread.sleep(500);
		if(Closed_Timely > 0)
		{
			MethodsPOM.IsSmetaColumnDepartSummary(test, "Closed Timely");
			Thread.sleep(500);
			
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+Closed_Timely);
			Thread.sleep(500);
			
		}
		Thread.sleep(500);
		String PendingReview = CFOcountPOM.clickHRPendingReviewm1().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);
		
		if(Pending_Review > 0)
		{
			MethodsPOM.IsSmetaColumnDepartSummary(test, "Pending For Review");
			Thread.sleep(500);
			
		}
		else
		{
			test.log(LogStatus.PASS, "'Pending For Review' Status Compliance Count = "+Pending_Review);
			
			
		}	
		
		WebElement roc1 = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));	
		roc1.click();
		
		String InProgress = CFOcountPOM.clickAdminInprogress().getText();	//Reading the Pending For Review value of Human Resource
		InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
		int In_Progress = Integer.parseInt(InProgress);	

		Thread.sleep(500);
		if(In_Progress > 0)
		{
			MethodsPOM.IsSmetaColumnDepartSummary(test, "In Progress");
			Thread.sleep(500);
			
		}
		else
		{
			test.log(LogStatus.PASS, "'In Progress' Status Compliance Count = "+In_Progress);
			Thread.sleep(500);
			
		}	
		  
		
		String Rejected = CFOcountPOM.clickAdminInRejected().getText();	//Reading the Pending For Review value of Human Resource
		Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
		int R_ejected = Integer.parseInt(Rejected);
		Thread.sleep(500);
		
	if(R_ejected > 0)
	{
		MethodsPOM.IsSmetaColumnDepartSummary(test, "Rejected");
		Thread.sleep(500);
		
	}
	else
	{
		test.log(LogStatus.PASS, "'Rejected' Status Compliance Count = "+R_ejected);
		Thread.sleep(500);
		
	}	

		
		String NotApplicable = CFOcountPOM.clickAdminNotApplicable().getText();	//Reading the Pending For Review value of Human Resource
		NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
		int Not_Applicable = Integer.parseInt(NotApplicable);	
		WebElement r = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));	
		  r.click();
		  Thread.sleep(2000);
		  
			if(Not_Applicable > 0)
			{
				MethodsPOM.IsSmetaColumnDepartSummary(test, "Not Applicable");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+Not_Applicable);
				Thread.sleep(500);
				
			}	

		String DueToday = CFOcountPOM.clickAdminDueToday().getText();	//Reading the Pending For Review value of Human Resource
		DueToday = DueToday.replaceAll(" ","");								//Removing all white spaces from string. 
		int Due_Today = Integer.parseInt(DueToday);	
		Thread.sleep(2000);
		roc1.click();
		Thread.sleep(2000);
		if(Due_Today > 0)
		{
			MethodsPOM.IsSmetaColumnDepartSummary(test, "DueToday");
			Thread.sleep(500);
			
		}
		else
		{
			test.log(LogStatus.PASS, "'DueToday' Status Compliance Count = "+Due_Today);
			Thread.sleep(500);
			
		}	
	//	int total = Overdue + Closed_Delayed + Closed_Timely + Pending_Review + In_Progress + R_ejected + Not_Applicable + Due_Today ;	
//		if(total>0)
//		{
		
			
			
			
			

//	}
//		else
//		{
//		test.log(LogStatus.PASS, " 'Department wise' status Compliance Count = "+total);
//			
//			Thread.sleep(500);
//		}
		
	}

	public static void IsSMETADepSumm1(ExtentTest test, String Status)throws InterruptedException
	{
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1700)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		
		String NotCompleted = CFOcountPOM.clickHROverduem().getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);	
		
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));		
		roc.click();
		Thread.sleep(3000);
		
		String ClosedDelayed = CFOcountPOM.clickHumanClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
		Thread.sleep(500);
		Thread.sleep(3000);
		String ClosedTimely = CFOcountPOM.clickHumanClosedTimely().getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);			
		String PendingReview = CFOcountPOM.clickHRPendingReviewm1().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);
		
		String InProgress = CFOcountPOM.clickAdminInprogress().getText();	//Reading the Pending For Review value of Human Resource
		InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
		int In_Progress = Integer.parseInt(InProgress);	
		
		String Rejected = CFOcountPOM.clickAdminInRejected().getText();	//Reading the Pending For Review value of Human Resource
		Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
		int R_ejected = Integer.parseInt(Rejected);	
		
		String NotApplicable = CFOcountPOM.clickAdminNotApplicable().getText();	//Reading the Pending For Review value of Human Resource
		NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
		int Not_Applicable = Integer.parseInt(NotApplicable);	
		WebElement roc1 = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));	
		  roc1.click();
		  Thread.sleep(2000);
		String DueToday = CFOcountPOM.clickAdminDueToday().getText();	//Reading the Pending For Review value of Human Resource
		DueToday = DueToday.replaceAll(" ","");								//Removing all white spaces from string. 
		int Due_Today = Integer.parseInt(DueToday);	
		Thread.sleep(2000);
		roc1.click();
		Thread.sleep(2000);
		int total = Overdue + Closed_Delayed + Closed_Timely + Pending_Review + In_Progress + R_ejected + Not_Applicable + Due_Today ;	
		if(total>0)
		{
			if(Overdue > 0)
			{
				roc.click();
				Thread.sleep(500);
				MethodsPOM.IsSmetaColumnDepartSummary(test, "Overdue");
				Thread.sleep(2000);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Overdue' Status Compliance Count = "+Overdue);
				Thread.sleep(500);
				
			}
			
			if(Closed_Delayed > 0)
			{
				roc.click();
				Thread.sleep(500);
				MethodsPOM.IsSmetaColumnDepartSummary(test, "Closed Delayed");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Status Compliance Count = "+Closed_Delayed);
				Thread.sleep(500);
				
			}
			
			if(Closed_Timely > 0)
			{
				MethodsPOM.IsSmetaColumnDepartSummary(test, "Closed Timely");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Status Compliance Count = "+Closed_Timely);
				Thread.sleep(500);
				
			}
			
			if(Pending_Review > 0)
			{
				MethodsPOM.IsSmetaColumnDepartSummary(test, "Pending For Review");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Pending For Review' Status Compliance Count = "+Pending_Review);
				Thread.sleep(500);
				
			}	
				
			if(In_Progress > 0)
			{
				MethodsPOM.IsSmetaColumnDepartSummary(test, "In Progress");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'In Progress' Status Compliance Count = "+In_Progress);
				Thread.sleep(500);
				
			}		
			if(R_ejected > 0)
			{
				MethodsPOM.IsSmetaColumnDepartSummary(test, "Rejected");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Rejected' Status Compliance Count = "+R_ejected);
				Thread.sleep(500);
				
			}	
			
			if(Not_Applicable > 0)
			{
				MethodsPOM.IsSmetaColumnDepartSummary(test, "Not Applicable");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Status Compliance Count = "+Not_Applicable);
				Thread.sleep(500);
				
			}	
			if(Due_Today > 0)
			{
				MethodsPOM.IsSmetaColumnDepartSummary(test, "DueToday");
				Thread.sleep(500);
				
			}
			else
			{
				test.log(LogStatus.PASS, "'DueToday' Status Compliance Count = "+Due_Today);
				Thread.sleep(500);
				
			}	
	}
		else
		{
		test.log(LogStatus.PASS, " 'Department wise' status Compliance Count = "+total);
			
			Thread.sleep(500);
		}
		
	}



	public static void PeriodIsSMETAColumn(ExtentTest test)throws InterruptedException
	{
	
     Thread.sleep(500);		
	WebDriverWait wait = new WebDriverWait( getDriver(),(120));
	Thread.sleep(500);
	Actions action = new Actions(getDriver());
//	int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
//	int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
//	int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
//	int low = Integer.parseInt(CFOcountPOM.readLow().getText());	
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
	Thread.sleep(3000);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
	try {
	// Define statuses and their XPaths
		Thread.sleep(2000);
    Map<String, String> statusXpaths = new HashMap<>();
    statusXpaths.put("Not Completed", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']");
    statusXpaths.put("Closed Delayed", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']");
    statusXpaths.put("Closed Timely", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']");
    statusXpaths.put("Not Applicable", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']");
    statusXpaths.put("Upcoming", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']");

    // Define risks and their XPaths
    Map<String, String> riskXpaths = new HashMap<>();
    riskXpaths.put("Critical", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']");
    riskXpaths.put("High", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']");
    riskXpaths.put("Medium", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']");
    riskXpaths.put("Low", "//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 ']");

   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Iterate over each status
    for (Map.Entry<String, String> statusEntry : statusXpaths.entrySet()) {
        String status = statusEntry.getKey();
        String statusXPath = statusEntry.getValue();

        // Click the status (if needed to drill down to risks)
        WebElement statusElement = getDriver().findElement(By.xpath(statusXPath));
        statusElement.click();

        // Iterate over each risk
        for (Map.Entry<String, String> riskEntry : riskXpaths.entrySet()) {
            String risk = riskEntry.getKey();
            String riskXPath = riskEntry.getValue();

            // Click on the risk element
            WebElement riskElement = getDriver().findElement(By.xpath(riskXPath));
            riskElement.click();
            Thread.sleep(2000);
            getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
            // Wait for the popup to appear
        //    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("popup-id")));
            
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
    		Thread.sleep(8000);
    		try {
    	           // Set zoom level to 50% (0.5) for zooming out
    	          setZoomLevel(getDriver(), 0.7);
    	           // Wait to observe the effect
    	          Thread.sleep(2000);

    	       // Set zoom level back to 100% (1.0) to reset to normal        
    			 // setZoomLevel(getDriver(), 1.0);
    			} catch (InterruptedException e) {
    		          e.printStackTrace();
    		        }
    		
    		Thread.sleep(1000);
    		js.executeScript("window.scrollBy(0,1000)");
    	        
    		Thread.sleep(3000);
    		MgmtSonyMethod.ClickTri1().click();
    	     Thread.sleep(1000);
    	     MgmtSonyMethod.Columns().click();
    	     Thread.sleep(5000);
    		OverduePOM.IsSMETAColumnCheckBox().click();
    		Thread.sleep(2000);
    	//	 MgmtSonyMethod.ClickTri1().click();
    	 //    Thread.sleep(1000);   

    		// Check if "is smeta" column is present
            boolean isSmetaPresent = getDriver().findElements(By.xpath("//table//th[@data-field='IsSmetaCompliance']")).size() > 0;

            
//    		if(CFOcountPOM.IsSmetaColumn().isDisplayed()) {
//				test.log(LogStatus.PASS, " The additional column of \"Is SMETA Compliance \" display on the gird.");
//			}else {
//				test.log(LogStatus.FAIL, "The additional column of \"Is SMETA Compliance\" not display on the gird.");
//			}	

            // Log the result
            System.out.println("Status: " + status + ", Risk: " + risk + ", 'Is SMETA' column present: " + isSmetaPresent);

            getDriver().switchTo().parentFrame();
            Thread.sleep(1000);
            CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
            Thread.sleep(2000);
        }
            }
    
} catch (Exception e) {
    e.printStackTrace();
}
                                                            	
		Thread.sleep(3000);
		
	}
	}
	//614 81 63 758
