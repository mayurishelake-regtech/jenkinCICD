package cfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

public class MgmtAvantis extends BasePage {

	//public static Web  = null;		//Web instance created
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
	
	public static String link = "amruta";  
	
	/*public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(14);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws Exception
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\CFOResultsStatotory.html",true);
		
		test = extent.startTest("Loging In - MGMT (Statutory)");
		test.log(LogStatus.PASS, "Logging into system");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization1(link,14,"Statutory");
		/*
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
	//	login.Login.BrowserSetup(URL);	
		
	
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
		WebDriverWait wait = new WebDriverWait( getDriver(),20);
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
/*	@Test(priority = 2)
	void MyTaskStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Task - Statutory");
		
		
		MgmtAMethod.myTask(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void myTaskSubTaskSta() throws InterruptedException, IOException
	{
		test = extent.startTest("My Task - Statutory :- Sub Task");
		
		
		MgmtAMethod.myTaskSubTask(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void MyTaskInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("My Task - Internal");
		
		
		MgmtAMethod.myTaskInternal(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void MyTaskSTInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("My Task :- Internal :- Sub Task ");
		
		
		MgmtAMethod.myTaskSubTaskIn(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	 @Test(priority = 6) //pass 
       void EventReport() throws InterruptedException
			{
				test = extent.startTest("Event Report Verification");
				
				
				MethodsPOM.EventReport(test);
				
				extent.endTest(test);
				extent.flush();
			}
	
	@Test(priority = 7)
	void SummaryofOverdueCompliancesAP() throws InterruptedException, IOException
	{
		test = extent.startTest("Summary of Overdue Compliances - To check whether the \"actionable procedure\" can be seen or not in Summary Of Overdue?");
		
		
		MgmtAMethod.SummaryofOverdueCompliancesAP(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void CompletedPFR_PieChartAp() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Completion status graph ?");
		
		
		MgmtAMethod.CompletedPFR_PieChartAp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void NotCompletedPFR_PieChartAp() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Not Completed status graph?");
		
		
		MgmtAMethod.NotCompletedPFR_PieChartAp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void RiskSummaryHighStatutoryAp() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Risk summary graph?");
		
		
		MgmtAMethod.RiskSummaryHighStatutoryAp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	 
	@Test(priority = 11)
	void Completed_PieChartPeriodAP() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period)- Completion status graph?");
		
		
		MgmtAMethod.Completed_PieChartPeriodAP(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void NotCompleted_PieChartPeriodAP() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period) - Not Completed graph?");
		
		
		MgmtAMethod.NotCompleted_PieChartPeriodAP(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void DetailedReportAP() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in details tab on the view icon of Detailed report?");
		
		
		MgmtAMethod.DetailedReportAP(test,);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void CompletedPFR_PieChartMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.CompletedPFR_PieChartMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void CompletedPFR_PieChartMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.CompletedPFR_PieChartMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void RiskSummaryMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.RiskSummaryMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void RiskSummaryMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.RiskSummaryMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void DeptSummaryMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DeptSummaryMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 17)
	void DeptSummaryMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DeptSummaryMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 18)
	void DFPCompletedPFR_PieChartMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DFPCompletedPFR_PieChartMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void DFPCompletedPFR_PieChartMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DFPCompletedPFR_PieChartMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void GradingMpD() throws InterruptedException, IOException
	{
		test = extent.startTest("Grading Report graph - Mitigation Plan - Statutory - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.GradingMpD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void DFPCompletedPFR_PieChartMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Grading Report graph  - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DFPCompletedPFR_PieChartMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void CompletedPFR_PieChartMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.CompletedPFR_PieChartMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23)
	void CompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.CompletedPFR_PieChartMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void RiskSummaryMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.RiskSummaryMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void RiskSummaryMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.RiskSummaryMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void DeptSummaryMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DeptSummaryMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 17)
	void DeptSummaryMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DeptSummaryMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 18)
	void DFPCompletedPFR_PieChartMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory  Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DFPCompletedPFR_PieChartMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void DFPCompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DFPCompletedPFR_PieChartMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
//	@Test(priority = 20)
	void CompletedPFR_PieChartMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.CompletedPFR_PieChartMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 21)
	void CompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.CompletedPFR_PieChartMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 22)
	void RiskSummaryMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.RiskSummaryMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 23)
	void RiskSummaryMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.RiskSummaryMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void DeptSummaryMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DeptSummaryMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 25)
	void DeptSummaryMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DeptSummaryMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 26)
	void DFPCompletedPFR_PieChartMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DFPCompletedPFR_PieChartMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27)
	void DFPCompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		MgmtAMethod.DFPCompletedPFR_PieChartMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
		@AfterMethod
	  	void browserClosing() throws InterruptedException
	  	{
			closeBrowser();
			Thread.sleep(1000);
	  	//	getDriver().close();
	  	}	  
	 
}
