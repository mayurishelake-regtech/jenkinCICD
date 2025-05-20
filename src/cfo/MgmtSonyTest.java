package cfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import approval.ApprovalcountPOM;
import login.BasePage;
import performer.OverduePOM;

public class MgmtSonyTest extends BasePage {
	
//	public static Web  = null;		//Web instance created
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
	
	public static String link = "cfo";  
	
	/*public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		fis = new FileInputStream("C:\\Users\\Mayuri\\Desktop\\Compliance\\AvacomAll\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(11);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\Regtrack Merge Project\\Regtrack-Project\\Reports\\MgmtBita.html",true);
		test = extent.startTest("Loging In - MGMT (Statutory)- Sony");
		test.log(LogStatus.PASS, "Logging into system");
	
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		
		initialization(link,11,"Statutory");
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
	
	
	public static void progress1( )
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	@Test(priority = 1)
	void Entities() throws InterruptedException, IOException
	{
		test = extent.startTest("Entities");
		
		ApprovalcountPOM.Entities(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 0)
	void TotalComplianceCountChange() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Total Compliances'");
		
        ApprovalcountPOM.TotalCompliances(test);
		
		extent.endTest(test);
		extent.flush();
	

	}
	
	@Test(priority = 2)
	void clickTotalCompliance() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Total Compliances'");
		
		
		Thread.sleep(500);
		if(OverduePOM.closeMessage().isDisplayed())				//If Compliance Updation message popped up,
		{
			OverduePOM.closeMessage().click();					//then close the message.
		}
		
		Thread.sleep(1500);
		int valueUsers = Integer.parseInt(ApprovalcountPOM.TotalCompliances().getText());	//Storing value of 'Users' as a String to compare.
		Thread.sleep(500);
		ApprovalcountPOM.TotalCompliances().click();					//Clicking on 'Users'. 
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(2000);
		CFOcountPOM.clickExportImage2().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();
		
		String getCount = CFOcountPOM.readTotalItemsD().getText();	//Storing no of Items 'Users' count as string.
		String[] bits = getCount.split(" ");							//Splitting the String
		String usersCount = bits[bits.length - 2];						//Getting the second last word (total number of users)
		if(usersCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2500);
			getCount = CFOcountPOM.readTotalItemsD().getText();
			bits = getCount.split(" ");								//Splitting the String
			usersCount = bits[bits.length - 2];
		}
		int count = Integer.parseInt(usersCount);
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame. 
		Thread.sleep(1000);
		CFOcountPOM.closeCategories().click();					//Closing the 'Compliance' window.
		
		if(valueUsers == count)								//Checking if String getCount contains the Value (in string format) 
		{
			test.log(LogStatus.PASS, "'Total Compliances' count matches to 'Total Compliances' items. Dashboard Value = "+ valueUsers+ ", Actual Value = "+ getCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Compliances count does not matches. Dashboard Value = "+ valueUsers+ ", Actual Value = "+ getCount);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2)
	void CompliancesCountMatch() throws InterruptedException
	{
		
		test = extent.startTest(" Count by Clicking on 'Compliances'");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Compliances =CFOcountPOM.TotalCompliancesM().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.TotalCompliancesM().click();
		Thread.sleep(5000);
		
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (1600));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		CFOcountPOM.clickExportImage2().click();                    //export excel
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		
	//	CFOcountPOM.clickClear().click();
		Thread.sleep(2000);
	//	test.log(LogStatus.PASS, "Clear Button is working Successfully");	
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void UsersCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Users'");
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_User =CFOcountPOM.clickUsersCount().getText();		//Storing old value of Statutory overdue.
	int	UserCountDas = Integer.parseInt(string_User);
		CFOcountPOM.clickUsersCount().click();
		Thread.sleep(500);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.

		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int UserGrid = Integer.parseInt(compliancesCount);
		if(UserCountDas == UserGrid)
		{
			
			test.log(LogStatus.PASS, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
		}
		
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void ComplianceDue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Statutory Ex. Checklist Compliance Due verification");
		
		
		MgmtSonyMethod.ComplianceDue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 5)
	void ComplianceDueFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the all the filters are working on the box of Statutory Ex. Checklist Compliance Due or not");
		
		
		MgmtSonyMethod.ComplianceDueFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void ComplianceReported() throws InterruptedException, IOException
	{
		test = extent.startTest("Statutory Ex. Checklist Compliance Reported verification");
		
		
		MgmtSonyMethod.ComplianceReported(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void CompliancereportedFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the all the filters are working on the box of Statutory Ex. Checklist Compliance Reported or not");
		
		
		MgmtSonyMethod.CompliancereportedFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ComplianceOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Statutory Ex. Checklist Overdue Compliance verification");
		
		
		MgmtSonyMethod.ComplianceOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void OverdurComplianceFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the all the filters are working on the box of Statutory Ex. Checklist Overdue Compliance or not");
		
		
		MgmtSonyMethod.OverdurComplianceFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void PerformanceSummaryCS() throws InterruptedException
	{
	
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");					//Scrolling down window by 1000 px.cfo
	
		test = extent.startTest("Performance Summary  - Completion Status - Overall Verification");
		
		
		Thread.sleep(4000);
		String NotCompleted = MgmtSonyMethod.NotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Risk_NotCompleted = Integer.parseInt(NotCompleted);
	
		MgmtSonyMethod.NotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount( test, " Not Completed", Risk_NotCompleted);
		Thread.sleep(2000);
		
		
		int Risk_ClosedDelayed = Integer.parseInt(MgmtSonyMethod.ClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		
		MgmtSonyMethod.ClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount2( test, "Closed Delayed", Risk_ClosedDelayed);
			Thread.sleep(2000);
			
			
		int ClosedTimely = Integer.parseInt(MgmtSonyMethod.ClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		
		MgmtSonyMethod.ClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount2( test, " Closed Timely", ClosedTimely);
		Thread.sleep(2000);
		
int NotApplicable = Integer.parseInt(MgmtSonyMethod.NotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		
		MgmtSonyMethod.NotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount2( test, " Not Applicable", NotApplicable);
	
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)
	void PerformanceSummaryNCS() throws InterruptedException
	{
	
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");					//Scrolling down window by 1000 px.cfo
	
		test = extent.startTest("Performance Summary  - Not Completed Status - Overall Verification");
		
		
		Thread.sleep(4000);
		String NotCompleted = MgmtSonyMethod.Overdue().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Risk_NotCompleted = Integer.parseInt(NotCompleted);
	
		MgmtSonyMethod.Overdue().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount( test, " Overdue ", Risk_NotCompleted);
		Thread.sleep(2000);
		
		
		int Risk_ClosedDelayed = Integer.parseInt(MgmtSonyMethod.DueToday().getText());	//Reading the High Risk value of Not Completed compliance
		
		MgmtSonyMethod.DueToday().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount( test, "Due Today ", Risk_ClosedDelayed);
			Thread.sleep(2000);
			
			
		int ClosedTimely = Integer.parseInt(MgmtSonyMethod.PendingForReview().getText());	//Reading the High Risk value of Not Completed compliance
		
		MgmtSonyMethod.PendingForReview().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount2( test, "Pending For Review ", ClosedTimely);
		Thread.sleep(2000);
		
int NotApplicable = Integer.parseInt(MgmtSonyMethod.Rejected().getText());	//Reading the High Risk value of Not Completed compliance
		
		MgmtSonyMethod.Rejected().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.GraphCount2( test, "Rejected ", NotApplicable);
	
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void RiskSummaryCriticalStatutory() throws InterruptedException, IOException
	{
	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
						
		js.executeScript("window.scrollBy(0,800)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		
		
		Thread.sleep(4000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
		if(RiskCritical_NotCompleted > 0)
		{
			CFOcountPOM.clickRiskCriticalNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.RiskGraphCount1( test, "Critical - Not Completed", RiskCritical_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
		}
		
		Thread.sleep(5000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedTimely > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void RiskSummaryHighStatutory() throws InterruptedException, IOException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,800)");		
		Thread.sleep(1000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(1000);
			MgmtSonyMethod.RiskGraphCount1( test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void RiskSummaryMediumStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary - 'Medium' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,800)");		
		Thread.sleep(1000);
		String NotCompleted = CFOcountPOM.clickRiskMediumNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskMedium_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			MgmtSonyMethod.RiskGraphCount1( test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
	
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void RiskSummaryLowStatutory() throws InterruptedException, IOException
	{		
		test = extent.startTest("Risk Summary - 'Low' Count Verification");
		
		Thread.sleep(500);
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(4000);
		String NotCompleted = CFOcountPOM.clickRiskLowNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskLow_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			MgmtSonyMethod.RiskGraphCount1( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc =getDriver() .findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
		}
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 16)
	void DepartmentSummaryHumanResourceStatutory() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");					//Scrolling down window by 1500 px.
		
		test = extent.startTest("Department Summary - 'HR' Count Verification");
		
		
		Thread.sleep(3000);
		
		String NotCompleted = CFOcountPOM.clickHROverduem().getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);						
		if(Overdue > 0)
		{
			CFOcountPOM.clickHROverduem().click();
			MgmtSonyMethod.RiskGraphCount1( test, "Overdue", Overdue, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Overdue Complaince Count = "+ Overdue + ".");
		}
		
		WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-8 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-bar-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		
		  roc.click();
		Thread.sleep(4000);
		
		String ClosedDelayed = CFOcountPOM.clickHRClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
	//	int Closed_Delayed = Integer.parseInt(CFOcountPOM.clickHumanClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		
		if(Closed_Delayed > 0)
		{
			Thread.sleep(500);	
			CFOcountPOM.clickHRClosedDelayed().click();
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount( test, "Closed Delayed", Closed_Delayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Closed Delayed Complaince Count = "+ Closed_Delayed + ".");
		}
		
		//-----------------------------------------------------
		
		Thread.sleep(3000);
		String ClosedTimely = CFOcountPOM.clickHRClosedTimelym().getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);						
		if(Closed_Timely > 0)
		{
			CFOcountPOM.clickHRClosedTimelym().click();
			CFOcountPOM.RiskGraphCount( test, "Closed Timely", Closed_Timely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Closed Timely Complaince Count = "+ Closed_Timely + ".");
		}
		
		
		
		Thread.sleep(3000);
		String PendingReview = CFOcountPOM.clickHRPendingReviewm().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);						
		if(Pending_Review > 0)
		{
			CFOcountPOM.clickHRPendingReviewm().click();
			CFOcountPOM.RiskGraphCount( test, "Pending For Review", Pending_Review, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Pending For Review Complaince Count = "+ Pending_Review + ".");
		}
		Thread.sleep(3000);
		String reject = CFOcountPOM.clickRejectSony().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = reject.replaceAll(" ","");								//Removing all white spaces from string. 
		int Rejected = Integer.parseInt(PendingReview);						
		if(Rejected > 0)
		{
			CFOcountPOM.clickRejectSony().click();
			Thread.sleep(3000);
			CFOcountPOM.RiskGraphCount( test, "Rejected", Rejected, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Rejected Complaince Count = "+ Rejected + ".");
		}
		
		/*
			Thread.sleep(3000);
			String NotApplicable = CFOcountPOM.clickHRNotApplicable().getText();	//Reading the Pending For Review value of Human Resource
			NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
			int Not_Applicable = Integer.parseInt(NotApplicable);						
			if(Not_Applicable > 0)
			{
				CFOcountPOM.clickHRNotApplicable().click();
				Thread.sleep(3000);
				CFOcountPOM.RiskGraphCount( test, "Not Applicable", Not_Applicable, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Not Applicable Complaince Count = "+ Not_Applicable + ".");
			}
		*/
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
/*	@Test(priority = 17)
	void complianceCalendar() throws InterruptedException
	{
		test = extent.startTest("compliance Calendar Verifications");
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(70));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1800)");					//Scrolling down window by 2600 px.
	//	js.executeScript("window.scrollBy(0,4000)");	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
		 CFOcountPOM.clickExportImage().click();
		 Thread.sleep(2000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = .findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor);
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			.switchTo().parentFrame();
			CFOcountPOM.closeView_cal().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			.switchTo().parentFrame();
		
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(4000);
				
			extent.endTest(test);
			extent.flush();
	}
	
	@Test(priority = 18)
	void DailyUpdates() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		test = extent.startTest("'Daily Updates'  OverView");
	
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 2600 px.
		//js.executeScript("window.scrollBy(0,500)");
		//Thread.sleep(3000);	
		 
		 if(ApprovalcountPOM.DailyUpdates().isDisplayed()) {
				test.log(LogStatus.PASS, "Daily Updates Displayed Successfully");
			}
		CFOcountPOM.clickViewAllDU().click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait( getDriver(), Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		CFOcountPOM.clickView1().click();
		Thread.sleep(4000);	
		CFOcountPOM.closeNewsView().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "view Succefully");
		OverduePOM.searchBox().sendKeys("NSE issued the MFSS Settlement Calendar");
		Thread.sleep(500);
		OverduePOM.ClicksearchBtn().click();
		Thread.sleep(7000);
		test.log(LogStatus.PASS, "Search Succefully");
		Thread.sleep(1000);
		OverduePOM.ClickClearBtn().click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Clear button Working Succefully");
	
		performer.OverduePOM.clickDashboard().click();
		Thread.sleep(8000);
		extent.endTest(test);
		extent.flush();
	}
	
    @Test(priority = 19)
	void NewsLetter() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
	
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,7000)","");					//Scrolling down window by 2600 px.
		if(ApprovalcountPOM.NewsLetter().isDisplayed()) {
			test.log(LogStatus.PASS, "News Letter Displayed Successfully");
		}
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
		Thread.sleep(4000);	
		extent.endTest(test);
		extent.flush();
	}
	*/
	
	@Test(priority = 20)
	void ColourCT() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the green colour can be seen or not for the status of closed timely  in the graph of completion status  performance summary ");
		
		MgmtSonyMethod.ColourCT(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void ColourCD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the yellow colour can be seen or not for the status of closed delayed  in the graph of completion status  performance summary ");
		
		MgmtSonyMethod.ColourCD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void ColourCTR() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the green colour can be seen or not for the status of closed timely  in the graph of Risk summary ");
		
		MgmtSonyMethod.ColourCTR(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23)
	void ColourCDR() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the yellow colour can be seen or not for the status of closed delayed  in the graph of Risk summary ");
		
		MgmtSonyMethod.ColourCDR(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void ColourCTD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the green colour can be seen or not for the status of closed timely  in the graph of Department  summary ");
		
		MgmtSonyMethod.ColourCTD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25)
	void ColourCDD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the yellow colour can be seen or not for the status of closed delayed  in the graph of Department summary ");
		
		MgmtSonyMethod.ColourCDD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		//Thread.sleep(1000);
  		//getDriver().close();
  	}	 
	

}
