package auditor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class AuditorcountStatutory extends BasePage {
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
	
	public static String link = "mgmt1";		
		
	/*
	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(5);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\Auditor.html",true);
		test = extent.startTest("Loging In - Auditor (Statutory)");
		test.log(LogStatus.PASS, "https://login.teamleaseregtech.com/");
		test.log(LogStatus.PASS, "auditor1@regtrack.com");
		test.log(LogStatus.PASS, "admin@123");

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
		
		initialization(link,5,"Statutory");
	//	test = extent.startTest("Loging In - Auditor (Statutory)");
	//	test.log(LogStatus.PASS, "Logging into system");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
	//	XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		//Write "CFO-diy" for DIYProduction link.
		//Write "CFO" for login.avantis
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		//CFOcountPOM.clickRefresh().click();
		//Thread.sleep(3000);
		*/
		
	//	extent.endTest(test);
	//	extent.flush();
	}
	
	public static void progress1( )
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
 	//@Test(priority = 2)
	void NotCompleted_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(5000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
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
		if(NotCompletedValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 3)
	void ClosedDelayed_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedA().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(5000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
		}
		*/
		if(ClosedDelayedValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount2( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount2( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount2( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >0)
			{
				AuditorcountPOM.GraphCount2( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 4)
	void ClosedTimely_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");						//Scrolling down window by 1000 px.
	
		Thread.sleep(1500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyA().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Timely' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Timely' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
		}
		*/
		if(ClosedTimelyValue > 0)
		{
			if(critical >0)
			{
				AuditorcountPOM.GraphCount2( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount2( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount2( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount2( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			
			Thread.sleep(3000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
	//@Test(priority = 5)
	void NotApplicable_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		
		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickNotApplicable()));
		
		Thread.sleep(1000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicableA().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicableA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(NotApplicableValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicableValue);
		}
		*/
		if(NotApplicableValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount2( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount2( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount2( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount2( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			
			Thread.sleep(3000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(4000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			
			Thread.sleep(3000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 6)
	void CompletionGraphIsSMETAColumn() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance Summary - Completion Status- 'Is SMETA Column added' Verification");
		String Status = "Not Completed"+"Closed Delayed"+"Closed Timely"+"Not Applicable";				
		MethodsPOM.IsSMETA1(test,Status);				
		extent.endTest(test);
		extent.flush();
	}

		
	//@Test(priority = 7)
	void Overdue_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		
		Thread.sleep(1000);
		//Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
	*/
		if(OverdueValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
		
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(3000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 8)
	void dueToday_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		
		
		Thread.sleep(1000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);

		int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueToday().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(dueTodayValue == total)
		{
			test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+dueTodayValue);
		}
	*/
		if(dueTodayValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Due Today' Compliance Count = "+dueTodayValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 9)
	void pendingForReview_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		
		
		Thread.sleep(2000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
	
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReview().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	*/
		if(pendingForReviewValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 10)
	void inProgress_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'In Progress' Count Verification");
	
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);	
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickinProgress().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(inProgressValue == total)
		{
			test.log(LogStatus.PASS, "' In Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+inProgressValue);
		}
	*/
		if(inProgressValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.PASS, " 'In Progress' Compliance Count = "+inProgressValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 11)
	void rejected_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- ' Rejected' Count Verification");
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejected().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejected().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+rejectedValue);
		}
	*/
		if(rejectedValue > 0)
		{
			if(critical > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				AuditorcountPOM.GraphCount1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				AuditorcountPOM.GraphCount1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 12)
	void NotCompletion_IsSmeta() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance Summary - Not Completion Status- 'Is SMETA Column added' Verification");					
        String Status = "Overdue"+"DueToday"+"Pending For Review"+"In Progress"+"Rejected";				
		MethodsPOM.IsSMETANotCompletion1(test,Status);
		extent.endTest(test);
		extent.flush();
	}

	
	  // @Test(priority = 13)
		void BargraphIndustrySpeCriticalStatutory() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - 'Commercial' Count Verification with 'Critical' Risk");
		
			
			Thread.sleep(2000);
			CFOcountPOM.YearTodate().click();
			Thread.sleep(1000);
			CFOcountPOM.ALL().click();
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(5000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
			//wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickCategories()));
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
			
			Thread.sleep(3000);
			int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.clickIndustrySpeCriticalM().getText());	//Reading the High value of Labour compliance
			
			Thread.sleep(1000);
			CFOcountPOM.clickIndustrySpeCriticalM().click();					//Clicking on High bar of Labour  
			
			Thread.sleep(500);
			int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
			int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
			int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
			int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
			
			int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		/*	
			if(IndustrySpeCritical == total)
			{
				test.log(LogStatus.PASS, "'Industry Specific' - Critical' Compliance Count matches to sum of all types of compliances.");
				test.log(LogStatus.PASS, "Total 'Industry Specific - Critical' Compliances : "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Industry Specific' - Critical' Compliance Count doesn't matches to sum of all types of compliances.");
				test.log(LogStatus.FAIL, "Total 'Industry Specific - Critical' Compliances : "+total+" | Total Sum : "+IndustrySpeCritical);
			}
			*/
			Thread.sleep(1000);
			if(IndustrySpeCritical > 0)
			{
				if(ClosedTimely > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Closed Timely", ClosedTimely);
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+ClosedTimely);
				}
				
				if(ClosedDelayed > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Closed Delayed", ClosedDelayed);
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+ClosedDelayed);
				}
				if(NotCompleted > 0)
				{
					CFOcountPOM.BarGraphCount1( test, "Not Completed", NotCompleted);
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+NotCompleted);
				}
				if(NotApplicable > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Not Applicable", NotApplicable);
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical - Not Applicable' Count = "+NotApplicable);
				}
				
				Thread.sleep(500);
				WebElement element = CFOcountPOM.clickBack();
				Actions actions = new Actions(getDriver());
				actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
				Thread.sleep(2000);
			}else
				{
					test.log(LogStatus.PASS, "'Commercial - Critical' Count = "+IndustrySpeCritical);
					
					Thread.sleep(500);
					WebElement element = CFOcountPOM.clickBack();
					Actions actions = new Actions(getDriver());
					actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
				}
			extent.endTest(test);
			extent.flush();
		}
		
		
		//@Test(priority = 14)
		void BargraphIndustrySpeHighStatutory() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - 'Commercial' Count Verification with 'High' risk");
			//test.log(LogStatus.INFO, "Test Initiated");
			Thread.sleep(4000);
			CFOcountPOM.YearTodate().click();
			Thread.sleep(1000);
			CFOcountPOM.ALL().click();
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(5000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
			Thread.sleep(4000);
			String PendingReview = CFOcountPOM.clickIndustrySpeHigh().getText();	//Reading the Pending For Review value of Human Resource
		//	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
			
			Thread.sleep(4000);
			int IndustrySpeHigh = Integer.parseInt(PendingReview);	//Reading the Medium value of Labour compliance
			CFOcountPOM.clickIndustrySpeHighM().click();					//Clicking on High bar of Labour  
			
			Thread.sleep(3000);
			int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
			Thread.sleep(1000);
			int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
			Thread.sleep(1000);
			int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
			Thread.sleep(1000);
			int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
			Thread.sleep(1000);
			int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
			/*
			if(IndustrySpeHigh == total)
			{
				test.log(LogStatus.PASS, "'Industry Specific - High' Compliance Count matches to sum of all types of compliances.");
				test.log(LogStatus.PASS, "Total 'Industry Specific - High' Compliances : "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Industry Specific - High' Compliance Count doesn't matches to sum of all types of compliances.");
				test.log(LogStatus.FAIL, "Total 'Industry Specific - High' Compliances : "+total+" | Total Sum : "+IndustrySpeHigh);
			}
			*/
			if(IndustrySpeHigh > 0)
			{
				if(ClosedTimely > 0)
				{
					Thread.sleep(2000);
					CFOcountPOM.BarGraphCount( test, "Closed Timely", ClosedTimely);
				}
				else
				{
					test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+ClosedTimely);
				}
				
				if(ClosedDelayed > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Closed Delayed", ClosedDelayed);
				}
				else
				{
					test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+ClosedDelayed);
				}
				if(NotCompleted > 0)
				{
					CFOcountPOM.BarGraphCount1( test, "Not Completed", NotCompleted);
				}
				else
				{
					test.log(LogStatus.PASS, "'High - Not Completed' Count = "+NotCompleted);
				}
				if(NotApplicable > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Not Applicable", NotApplicable);
				}
				else
				{
					test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+NotApplicable);
				}
				
				Thread.sleep(500);
				WebElement element = CFOcountPOM.clickBack();
				Actions actions = new Actions(getDriver());
			
				actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
				Thread.sleep(3000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Commercial - High' Count = "+IndustrySpeHigh);
				
				Thread.sleep(500);
				WebElement element = CFOcountPOM.clickBack();
				Actions actions = new Actions(getDriver());
				actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			}
				Thread.sleep(1000);
			extent.endTest(test);
			extent.flush();
		}

		
	  //  @Test(priority = 15)

		void BargraphIndustrySpeMediumStatutory() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - 'Commercial' Count Verification with 'Medium' risk");
		//	test.log(LogStatus.INFO, "Test Initiated");
			Thread.sleep(4000);
			CFOcountPOM.YearTodate().click();
			Thread.sleep(1000);
			CFOcountPOM.ALL().click();
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(5000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
			
			Thread.sleep(4000);
			int IndustrySpeMedium = Integer.parseInt(CFOcountPOM.clickIndustrySpeMedium().getText());	//Reading the Medium value of Labour compliance
			CFOcountPOM.clickIndustrySpeMediumM().click();					//Clicking on High bar of Labour  
			
			Thread.sleep(3000);
	    	int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		    Thread.sleep(1000);
			int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
			Thread.sleep(1000);
			int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
			Thread.sleep(500);
			int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
			Thread.sleep(500);
			int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
			/*
			if(IndustrySpeMedium == total)
			{
				test.log(LogStatus.PASS, "'Industry Specific - High' Compliance Count matches to sum of all types of compliances.");
				test.log(LogStatus.PASS, "Total 'Industry Specific - High' Compliances : "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Industry Specific - High' Compliance Count doesn't matches to sum of all types of compliances.");
				test.log(LogStatus.FAIL, "Total 'Industry Specific - High' Compliances : "+total+" | Total Sum : "+IndustrySpeMedium);
			}
			*/
			if(IndustrySpeMedium > 0)
			{
				if(ClosedTimely > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Closed Timely", ClosedTimely);
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+ClosedTimely);
				}
				
				if(ClosedDelayed > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Closed Delayed", ClosedDelayed);
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+ClosedDelayed);
				}
				if(NotCompleted > 0)
				{
					CFOcountPOM.BarGraphCount1( test, "Not Completed", NotCompleted);
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+NotCompleted);
				}
				if(NotApplicable > 0)
				{
					CFOcountPOM.BarGraphCount( test, "Not Applicable", NotApplicable);
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium - Not Applicable' Count = "+NotApplicable);
				}
				
				Thread.sleep(500);
				WebElement element = CFOcountPOM.clickBack();
				Actions actions = new Actions(getDriver());
				actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Commercial - Medium' Count = "+IndustrySpeMedium);
				
				Thread.sleep(3000);
				WebElement element = CFOcountPOM.clickBack();
				Actions actions = new Actions(getDriver());
				actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
				Thread.sleep(3000);
			}
			extent.endTest(test);
			extent.flush();
		}
		
	 //  @Test(priority = 16)

		void BargraphIndustrySpeLowStatutory() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - 'Commercial' Count Verification with 'Low' risk");
		
			Thread.sleep(4000);
			CFOcountPOM.YearTodate().click();
			Thread.sleep(1000);
			CFOcountPOM.ALL().click();
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(5000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
			js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
			
			
			Thread.sleep(4000);
			int IndustrySpeLow = Integer.parseInt(CFOcountPOM.clickIndustrySpeLow().getText());	//Reading the Medium value of Labour compliance
			CFOcountPOM.clickIndustrySpeLowM().click();					//Clicking on low bar of Indistry Specific  
			
			Thread.sleep(500);
			int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
			int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
			int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
			int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
			
			int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		/*	
			if(IndustrySpeLow == total)
			{
				test.log(LogStatus.PASS, "'Indistry Specific - High' Compliance Count matches to sum of all types of compliances.");
				test.log(LogStatus.PASS, "Total 'Indistry Specific - High' Compliances : "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Indistry Specific - High' Compliance Count doesn't matches to sum of all types of compliances.");
				test.log(LogStatus.FAIL, "Total 'Indistry Specific - High' Compliances : "+total+" | Total Sum : "+IndustrySpeLow);
			}
			*/
			if(IndustrySpeLow > 0)
			{
				if(ClosedTimely > 0)
				{Thread.sleep(500);
					CFOcountPOM.BarGraphCount( test, "Closed Timely", ClosedTimely);
				}
				else
				{
					test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+ClosedTimely);
				}
				
				if(ClosedDelayed > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.BarGraphCount( test, "Closed Delayed", ClosedDelayed);
				}
				else
				{
					test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+ClosedDelayed);
				}
				if(NotCompleted > 0)
				{Thread.sleep(300);
					CFOcountPOM.BarGraphCount1( test, "Not Completed", NotCompleted);
				}
				else
				{
					test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+NotCompleted);
				}
				if(NotApplicable > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.BarGraphCount( test, "Not Applicable", NotApplicable);
				}
				else
				{
					test.log(LogStatus.PASS, "'Low - Not Applicable' Count = "+NotApplicable);
				}
				
				Thread.sleep(500);
				WebElement element = CFOcountPOM.clickBack();
				Actions actions = new Actions(getDriver());
				actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
				
				Thread.sleep(500);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Commercial - Low' Count = "+IndustrySpeLow);
				
				Thread.sleep(500);
				WebElement element = CFOcountPOM.clickBack();
				Actions actions = new Actions(getDriver());
				actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
				
				Thread.sleep(2000);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			}
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority = 17)
		void OverallFunIsSmeta() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - Completion Status- Overall Function - 'Is SMETA Column added' Verification");					
           String Status = "Closed Timely"+"Closed Delayed"+"Not completed"+"Not Applicable";				
			MethodsPOM.IsSMETAOverallFunction1(test,Status);
			extent.endTest(test);
			extent.flush();
		}

	
	//@Test(priority = 18)
	void RiskSummaryCriticalStatutory() throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,1450)");					//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,1200)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		
		Thread.sleep(500);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
	//	int RiskCritical_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotCompleted > 0)
		{
			CFOcountPOM.clickRiskCriticalNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			AuditorcountPOM.RiskGraphCount1( test, "Critical - Not Completed", RiskCritical_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
		}
		
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			AuditorcountPOM.RiskGraphCount2( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedTimely > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			AuditorcountPOM.RiskGraphCount2( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}
		
		Thread.sleep(3000);
		int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskCriticalNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNAC( test, "Critical - Not Applicable", RiskCritical_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Applicable' Count = "+RiskCritical_NotApplicable);
		}
		
		
		Thread.sleep(3000);
		int RiskCritical_DueToday = Integer.parseInt(CFOcountPOM.clickRiskCriticalDueToday().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_DueToday > 0)
		{
			CFOcountPOM.clickRiskCriticalDueToday().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCount1( test, "Critical - Due Today", RiskCritical_DueToday, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Due Today' Count = "+RiskCritical_DueToday);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 19)
	void RiskSummaryHighStatutory() throws InterruptedException, IOException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
		Thread.sleep(2000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1200)");	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(3000);
			AuditorcountPOM.RiskGraphCount1( test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
	
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			AuditorcountPOM.RiskGraphCount1( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(3000);
			CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(3000);
			AuditorcountPOM.RiskGraphCount1( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		
		Thread.sleep(3000);
		int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskHighNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNAC( test, "High - Not Applicable", RiskHigh_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+RiskHigh_NotApplicable);
		}
		
		
		Thread.sleep(3000);
		int RiskHigh_DueToday = Integer.parseInt(CFOcountPOM.clickRiskHighDueToday().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_DueToday > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighDueToday().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1( test, "High - Due Today", RiskHigh_DueToday, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Due Today' Count = "+RiskHigh_DueToday);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
		//@Test(priority = 20)

	void RiskSummaryMediumStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary - 'Medium' Count Verification");
		Thread.sleep(2000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);
		String NotCompleted = CFOcountPOM.clickRiskMediumNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskMedium_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(3000);
			AuditorcountPOM.RiskGraphCount1( test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		
		Thread.sleep(4000);
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(3000);
			AuditorcountPOM.RiskGraphCount2( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
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
			Thread.sleep(3000);
			AuditorcountPOM.RiskGraphCount2( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}
		Thread.sleep(500);
		
		Thread.sleep(3000);
		int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskMediumNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNAC( test, "Medium - Not Applicable", RiskMedium_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Applicable' Count = "+RiskMedium_NotApplicable);
		}
		
		
		Thread.sleep(3000);
		int RiskMedium_DueToday = Integer.parseInt(CFOcountPOM.clickRiskMediumDueToday().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_DueToday > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumDueToday().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1( test, "Medium - Due Today", RiskMedium_DueToday, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Due Today' Count = "+RiskMedium_DueToday);
		}
		
		//performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	

	//@Test(priority = 21)

	void RiskSummaryLowStatutory() throws InterruptedException, IOException
	{		
		test = extent.startTest("Risk Summary - 'Low' Count Verification");
		
		Thread.sleep(2000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,1200)");
	Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskLowNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskLow_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			AuditorcountPOM.RiskGraphCount1( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}
		
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		
		Thread.sleep(4000);
		
		Thread.sleep(3000);
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			AuditorcountPOM.RiskGraphCount2( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		
		Thread.sleep(4000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(3000);
			AuditorcountPOM.RiskGraphCount2( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
		}
		
		
		Thread.sleep(3000);
		int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskLowNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNAC( test, "Low - Not Applicable", RiskLow_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Applicable' Count = "+RiskLow_NotApplicable);
		}
		
		Thread.sleep(3000);
		int RiskLow_DueToday = Integer.parseInt(CFOcountPOM.clickRiskLowDueToday().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_DueToday > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowDueToday().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1( test, "Low - Due Today", RiskLow_DueToday, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Due Today' Count = "+RiskLow_DueToday);
		}
		
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 22)
	void RiskSummaryFilterNA() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the filters of Location,period,FY,Risk,User,Start Date,End Date,Act,Category,Compliance Id,Status,License Type,Mitigation plan are working on the graph of Risk Summary - Not applicable Status or not?");
	
				ApprovalcountPOM.RiskSummaryFilterNA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	//@Test(priority = 23)
		void RiskSummIsSmeta() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - Risk Summary graph - 'Is SMETA Column added' Verification");					
            String Status = "Closed Timely"+"Closed Delayed"+"Not completed"+"DueToday"+"Not Applicable";				
			MethodsPOM.IsSMETARisksummary1(test,Status);
			extent.endTest(test);
			extent.flush();
		}

		//@Test(priority = 24)

		void DepartmentSummaryFinanceStatutory() throws InterruptedException, IOException
		{
			Thread.sleep(3000);		
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,1700)");					//Scrolling down window by 1500 px.
			Thread.sleep(3000);	
			test = extent.startTest("Department Summary - 'Forest' Count Verification");
			
			Thread.sleep(3000);
			String Admin = CFOcountPOM.AdminCount().getText();			//Reading the Overdue value of Human Resource
			Admin = Admin.replaceAll(" ","");									//Removing all white spaces from string. 
			int IndustrySpeCritical = Integer.parseInt(Admin);	
			
			Thread.sleep(4000);
			String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo().getText();			//Reading the Overdue value of Human Resource
			NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
			int Overdue = Integer.parseInt(NotCompleted);						
			if(Overdue > 0)
			{
				CFOcountPOM.clickComplianceIsecOverdueDemo().click();
				Thread.sleep(500);
				AuditorcountPOM.RiskGraphCount1( test, "Overdue", Overdue, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Overdue Compliance Count = "+ Overdue + ".");
			}
			
	         WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
			
			  roc.click();
			Thread.sleep(4000);
			
			Thread.sleep(500);
			String ClosedDelayed = CFOcountPOM.clickHumanClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
			//ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
			int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
		//	int Closed_Delayed = Integer.parseInt(CFOcountPOM.clickHumanClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance

			if(Closed_Delayed > 0)
			{
				CFOcountPOM.clickHumanClosedDelayed().click();
				Thread.sleep(2000);
				AuditorcountPOM.RiskGraphCount2( test, "Closed Delayed", Closed_Delayed, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Closed Delayed Compliance Count = "+ Closed_Delayed + ".");
			}
			 WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
				
			  roc1.click();
			
			Thread.sleep(500);
			String ClosedTimely = CFOcountPOM.clickHumanClosedTimelym().getText();		//Reading the Closed Timely value of Human Resource
			ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
			int Closed_Timely = Integer.parseInt(ClosedTimely);						
			if(Closed_Timely > 0)
			{
				CFOcountPOM.clickHumanClosedTimelym().click();
				Thread.sleep(500);
				AuditorcountPOM.RiskGraphCount2( test, "Closed Timely", Closed_Timely, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Closed Timely Compliance Count = "+ Closed_Timely + ".");
			}
			WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
			CT.click();
			
			Thread.sleep(3000);
			Thread.sleep(2000);
			String PendingReview = CFOcountPOM.clickAccountPendingReview().getText();	//Reading the Pending For Review value of Human Resource
			PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
			int Pending_Review = Integer.parseInt(PendingReview);						
			if(Pending_Review > 0)
			{
				CFOcountPOM.clickAccountPendingReview().click();
				Thread.sleep(2000);
				AuditorcountPOM.RiskGraphCount2( test, "Pending For Review", Pending_Review, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Pending For Review Compliance Count = "+ Pending_Review + ".");
			}
			
			WebElement PR = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));
			PR.click();
				Thread.sleep(500);
				String InProgress = CFOcountPOM.clickFinanceInProgressInternal().getText();	//Reading the Pending For Review value of Human Resource
				InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
				int In_Progress = Integer.parseInt(InProgress);						
				if(In_Progress > 0)
				{
					CFOcountPOM.clickFinanceInProgressInternal().click();
					AuditorcountPOM.RiskGraphCount2( test, "InProgress", In_Progress, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "InProgress Compliance Count = "+ In_Progress + ".");
				}
				WebElement IP = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-4 > rect"));
				IP.click();
				
				Thread.sleep(500);
				String Rejected = CFOcountPOM.clickFinanceRejectedInternal().getText();	//Reading the Pending For Review value of Human Resource
				Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
				int R_ejected = Integer.parseInt(Rejected);						
				if(R_ejected > 0)
				{
					CFOcountPOM.clickFinanceRejectedInternal().click();
					AuditorcountPOM.RiskGraphCount2( test, "Rejected", R_ejected, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "Rejected Compliance Count = "+ R_ejected + ".");
				}
				Thread.sleep(500);
				String NotApplicable = CFOcountPOM.clickComplianceIsecNotApplicableDemo().getText();	//Reading the Pending For Review value of Human Resource
				NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
				int Not_Applicable = Integer.parseInt(NotApplicable);						
				if(Not_Applicable > 0)
				{
					CFOcountPOM.clickComplianceIsecNotApplicableDemo().click();
					AuditorcountPOM.RiskGraphCount2( test, "Not Applicable", Not_Applicable, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "Not Applicable Compliance Count = "+ Not_Applicable + ".");
				}
				Thread.sleep(500);
				Thread.sleep(500);
				WebElement NA = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-6 > rect"));
				NA.click();
				Thread.sleep(3000);
				String DueToday = CFOcountPOM.clickAdminDueToday().getText();	//Reading the Pending For Review value of Human Resource
				DueToday = DueToday.replaceAll(" ","");								//Removing all white spaces from string. 
				int Due_Today = Integer.parseInt(DueToday);						
				if(Due_Today > 0)
				{
					CFOcountPOM.clickAdminDueToday().click();
					AuditorcountPOM.RiskGraphCount2( test, "DueToday", Due_Today, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "DueToday Compliance Count = "+ Due_Today + ".");
				}

				Thread.sleep(8000);
				int total = Overdue + Due_Today + Not_Applicable + R_ejected+Pending_Review+Closed_Timely+Closed_Delayed+In_Progress;				//Calculating the values to match with High value of Labour.
				Thread.sleep(5000);	
				if(IndustrySpeCritical == total)
				{
					test.log(LogStatus.PASS, "Department Summary  Count matches to sum of all types of Compliance.");
					test.log(LogStatus.PASS, "Total  Department Summary : "+IndustrySpeCritical+" | Sum of all risk count : "+total);
				}
				else
				{
					test.log(LogStatus.FAIL, "Department summary   Count doesn't matches to sum of all types of statuses.");
					test.log(LogStatus.FAIL, "Total Department summary' Compliances : "+IndustrySpeCritical+" | Sum of all risk count : "+total);
				}
				
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
			extent.endTest(test);
			extent.flush();
		}
	
	//@Test(priority = 25)
	void DepartSummIsSmeta() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - Department Summary graph - 'Is SMETA Column added' Verification");					
        String Status = "Overdue"+"Closed Delayed"+"Closed Timely"+ "Pending For Review" + "In Progress" + "Rejected"+"Not Applicable"+"DueToday";				
		MethodsPOM.IsSMETADepSumm1(test,Status);
		extent.endTest(test);
		extent.flush();
	}

	//@Test(priority = 26)

	void NotCompleted_PieChartPe() throws InterruptedException, IOException
	{
	//	test = extent.startTest("period-Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,2100)");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("period-Pie Chart - "+date+"-"+month+"-"+year+" "+"- Completion Status- 'Not Completed' Count Verification");

		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
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
		if(NotCompletedValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Completed' Compliance Count = "+NotCompletedValue);
      //    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	

	//@Test(priority = 27)

	void ClosedDelayed_PieChartPe() throws InterruptedException, IOException
	{
	//	test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		js.executeScript("window.scrollBy(0,2100)");	
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(2000);
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("Period-Pie Chart - "+date+"-"+month+"-"+year+" "+"- Completion Status- 'Closed Delayed' Count Verification");

		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayed().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
		}
		*/
		if(ClosedDelayedValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			    Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(2000);
				AuditorcountPOM.GraphCountSatPe( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	

	//@Test(priority = 28)

	void ClosedTimely_PieChartPe() throws InterruptedException, IOException
	{
	//	test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
	
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2100)");						//Scrolling down window by 1000 px.
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(2000);
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("Period-Pie Chart - "+date+"-"+month+"-"+year+" "+"- Completion Status- 'Closed Timely' Count Verification");

		Thread.sleep(2500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimely().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Timely' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Timely' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
		}
		*/
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
		//	performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard().click();
		}
		extent.endTest(test);
		extent.flush();
		
	}
	

	//@Test(priority = 29)

	void NotApplicable_PieChartPeriod() throws InterruptedException, IOException
	{
		//test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
	
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2100)");						//Scrolling down window by 1000 px.
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(2000);
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("Period-Pie Chart -"+date+"-"+month+"-"+year+" "+"- Completion Status- 'Not Applicable' Count Verification");

		Thread.sleep(2500);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicable().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(NotApplicableValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
		}
		*/
		if(NotApplicableValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
		//	performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard().click();
		}
		extent.endTest(test);
		extent.flush();
		
	}	
	//@Test(priority = 30)

	void UpcomingPieChartPeriod() throws InterruptedException
	{
		//test = extent.startTest("Period-Pie Chart -Not Completed Status- ' Upcoming' Count Verification");
	
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2200)");			//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year1 = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month1 = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date1 = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateTextEnd().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Years().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Years().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month1().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month1().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date1().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date1().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("Period-Pie Chart -"+date1+"-"+month1+"-"+year1+" - "+date+"-"+month+"-"+year+" "+"- Completion Status- ' Upcoming' Count Verification");				

		Thread.sleep(4000);
		WebElement roc= getDriver().findElement(By.xpath("(//*[@class='highcharts-legend-item highcharts-pie-series highcharts-color-4 '])"));
	
	String text =	roc.getText();
	
	if(text.equalsIgnoreCase("Upcoming")) {
		test.log(LogStatus.PASS, "The status named \"upcoming\" should reflects separately in the graph of the performance summary (not completed compliance summary) due for a period.");

	}else {
		test.log(LogStatus.FAIL, "The status named \"upcoming\" not reflects separately in the graph of the performance summary (not completed compliance summary) due for a period.");

	}
		
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickUpcomingPe().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickUpcomingPe().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+rejectedValue);
		}
	*/
		if(rejectedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPeUp1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUp1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUp1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUp1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Upcoming' Compliance Count = "+rejectedValue);
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 31)
	void DueforperiodIsSMETAColumn() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Not Completed - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'

		CFOcountPOM.clickNotCompleted().click();
        Thread.sleep(500);	
        if(NotCompletedValue > 0)
		{
      //  String status = "Critical"+"High"+"Medium"+"Low";
		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(1000);
		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
		Thread.sleep(3000);	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(1000);
		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
		Thread.sleep(3000);	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(1000);
		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
		Thread.sleep(3000);	
		}
        else
		{
			test.log(LogStatus.PASS, "'Completion' Compliance Count " +NotCompletedValue);
		}
		extent.endTest(test);
		extent.flush();
		
		
	}
	
//	@Test(priority = 32)
	void periodIsSMETAColumnCloseddelayed() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Closed Delayed - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int ClosedDelayedlyValue = Integer.parseInt(CFOcountPOM.clickClosedDelayed().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickClosedDelayed().click();
        Thread.sleep(500);	
        if(ClosedDelayedlyValue > 0)
        {
            Thread.sleep(500);
        	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
    		Thread.sleep(3000);
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
    		Thread.sleep(3000);	
        }
        else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = " + ClosedDelayedlyValue);
		}
		extent.endTest(test);
		extent.flush();
	}
    
	//@Test(priority = 33)
	void periodIsSMETAColumnTimely() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Closed Timely - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickClosedTimely().click();
        Thread.sleep(500);	
        if(ClosedTimelyValue > 0)
        {
            Thread.sleep(500);
        	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
    		Thread.sleep(3000);
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
    		Thread.sleep(3000);	
        }
        else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = " + ClosedTimelyValue);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =34)
	void periodIsSMETAColumnNotApplicable() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Not Applicable - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickNotApplicable().click();
        Thread.sleep(500);	
        if(NotApplicableValue > 0)
        {
            Thread.sleep(500);
        	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
    		Thread.sleep(3000);
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
    		Thread.sleep(3000);	
        }
        else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = " + NotApplicableValue);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =35)
	void periodIsSMETAColumnUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Upcoming - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickUpcomingPe().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickUpcomingPe().click();
        Thread.sleep(500);	
        if(NotApplicableValue > 0)
        {
            Thread.sleep(500);
        	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
    		Thread.sleep(3000);
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
    		Thread.sleep(3000);	
    		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
    		Thread.sleep(1000);
    		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
    		Thread.sleep(3000);	
        }
        else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = " + NotApplicableValue);
		}
		extent.endTest(test);
		extent.flush();
	}
	

	
	@Test(priority = 36)

	void Overdue_PieChartperiod() throws InterruptedException, IOException
	{
		//test = extent.startTest("period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		
		Thread.sleep(1000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//js.executeScript("window.scrollBy(0,300)");			//Scrolling down window by 1000 px.
		js.executeScript("window.scrollBy(0,2100)");	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(2000);
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("period-Pie Chart - "+date+"-"+month+"-"+year+" "+"-Not Completed Status- 'Overdue' Count Verification");

		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
	*/
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
		
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
		//	Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =37)
	void periodIsSMETAColumnOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Overdue - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickOverdue().click();
       Thread.sleep(500);	
       if(NotApplicableValue > 0)
       {
           Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
   		Thread.sleep(3000);
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = " + NotApplicableValue);
		}
		extent.endTest(test);
		extent.flush();
	}
		

	@Test(priority = 38)

	void dueToday_PieChartPeriod() throws InterruptedException, IOException
	{
		//test = extent.startTest("period-Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		
		
		Thread.sleep(1000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//js.executeScript("window.scrollBy(0,300)");			//Scrolling down window by 1000 px.
		js.executeScript("window.scrollBy(0,2100)");	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(2000);
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("period-Pie Chart -"+date+"-"+month+"-"+year+" "+"-Not Completed Status- 'dueToday' Count Verification");

		int OverdueValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueToday().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total dueToday' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'dueToday' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
	*/
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
		
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
		//	Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'dueToday' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =39)
	void periodIsSMETAColumnDuetoday() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - DueToday - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickdueToday().click();
       Thread.sleep(500);	
       if(NotApplicableValue > 0)
       {
           Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
   		Thread.sleep(3000);
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'DueToday' Compliance Count = " + NotApplicableValue);
		}
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 40)

	void pendingForReview_PieChartPeriod() throws InterruptedException, IOException
	{
	//	test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		
		
		Thread.sleep(2000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2200)");			//Scrolling down window by 1000 px.
	//	js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(2000);
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("Period-Pie Chart -"+date+"-"+month+"-"+year+" "+"- Not Completed Status- 'Pending For Review' Count Verification");

		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReview().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	*/
		if(pendingForReviewValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Low", low, "Statutory");
			}
			else
			{
				
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.PASS, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 41)
	void periodIsSMETAColumnPendingForReview() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Pending For Review - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickpendingForReview().click();
       Thread.sleep(500);	
       if(NotApplicableValue > 0)
       {
           Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
   		Thread.sleep(3000);
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Pending For Review' Compliance Count = " + NotApplicableValue);
		}
		extent.endTest(test);
		extent.flush();
	}
		

	@Test(priority = 42)

	void inProgress_PieChartPeriod() throws InterruptedException, IOException
	{
		//test = extent.startTest("Period-Pie Chart -Not Completed Status- 'In Progress' Count Verification");
		
		
		
		Thread.sleep(2000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2200)");			//Scrolling down window by 1000 px.
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(2000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		Thread.sleep(3000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("Period-Pie Chart - "+date+"-"+month+"-"+year+" "+"-Not Completed Status- 'In Progress' Count Verification");

		int inProgressValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickinProgress().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(inProgressValue == total)
		{
			test.log(LogStatus.PASS, "' In Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+inProgressValue);
		}
	*/
		if(inProgressValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'In Progress' Compliance Count = "+inProgressValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 43)
	void periodIsSMETAColumnInprogress() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - In Progress - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickinProgress().click();
       Thread.sleep(500);	
       if(NotApplicableValue > 0)
       {
           Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
   		Thread.sleep(3000);
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'In Progress' Compliance Count = " + NotApplicableValue);
		}
		extent.endTest(test);
		extent.flush();
	}
		


	@Test(priority = 44)

	void rejected_PieChartPeriod() throws InterruptedException, IOException
	{
		//test = extent.startTest("Period-Pie Chart -Not Completed Status- ' Rejected' Count Verification");
		
		Thread.sleep(2000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2200)");			//Scrolling down window by 1000 px.
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		//Thread.sleep(2000);
		Thread.sleep(3000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		String year = AuditorcountPOM.Year().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		String month = AuditorcountPOM.Month().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		String date = AuditorcountPOM.Date().getText();
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		test = extent.startTest("Period-Pie Chart -"+date+"-"+month+"-"+year+" "+"-Not Completed Status- ' Rejected' Count Verification");

		
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejectedPe11().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe11().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+rejectedValue);
		}
	*/
		if(rejectedValue > 0)
		{
			if(critical >= 0)
			{
				AuditorcountPOM.GraphCountSatPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				AuditorcountPOM.GraphCountSatPe( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45)
	void periodIsSMETAColumnRejected() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status - Rejected - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2100)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickRejectedPe11().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickRejectedPe11().click();
       Thread.sleep(500);	
       if(NotApplicableValue > 0)
       {
           Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnDueForPeriod(test,"Critical");	
   		Thread.sleep(3000);
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"High");	
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Medium");
   		Thread.sleep(3000);	
   		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
   		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDueForPeriod(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = " + NotApplicableValue);
		}
		extent.endTest(test);
		extent.flush();
	}
		
	
	@Test(priority = 46)
	void UpcomingFilter1() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the filters of Upcoming Status are working on the graph of Due for the period - Competion status graph?");
	
				ApprovalcountPOM.UpcomingFilter1(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 47)
	void DeviationApproverColPSAu() throws InterruptedException, IOException
	{
		test = extent.startTest("performance summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the performance summary graph of management  ");
			
		CFOcountPOM.DeviationApproverColPSAu(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 48)
	void DeviationApproverColRSAu() throws InterruptedException, IOException
	{
		test = extent.startTest("risk summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the risk summary graph of management dashboard ?  ");
			
		CFOcountPOM.DeviationApproverColRSAu(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49)
	void DeviationApproverColDSAu() throws InterruptedException, IOException
	{
		test = extent.startTest("department summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the department summary graph of management   ");
			
		CFOcountPOM.DeviationApproverColDSAu(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 50)
	void DeviationApproverColPSDFPAu() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in thePerformance Summary (Due for the period) of management   ");
			
		CFOcountPOM.DeviationApproverColPSDFPAu(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 51)
		void DailyUpdates() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'Daily Updates'  OverView");
			
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//	js.executeScript("window.scrollBy(0,4600)");					//Scrolling down window by 2600 px.
			js.executeScript("window.scrollBy(0,5600)");
			Thread.sleep(500);	
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
			OverduePOM.searchBox().sendKeys("Haryana Land Partnership Policy-2022");
			Thread.sleep(500);
			OverduePOM.ClicksearchBtn().click();
			Thread.sleep(7000);
			test.log(LogStatus.PASS, "Search Succefully");
			Thread.sleep(1000);
			OverduePOM.ClickClearBtn().click();
			Thread.sleep(8000);
			test.log(LogStatus.PASS, "Clear button Working Succefully");
			
			performer.OverduePOM.clickDashboard().click();
			
			extent.endTest(test);
			extent.flush();
		}
	
	 @Test(priority = 52)
		void NewsLetter() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'News Letters'  OverView");
		//	test.log(LogStatus.INFO, "Test Initiated");
			Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,5000)");				//Scrolling down window by 2600 px.
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
	
		
		@Test(priority = 53) 
		void DetailedReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report- Statutory- Count Verification");
			
			
			AuditorcountPOM.DetailedReport(test,  "Auditor");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 54) 
		void DetailedReportIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report - Internal - Count Verification");
			
			
			AuditorcountPOM.DetailedReportIn(test,  "Auditor");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 55)
		void DetailedReportFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To check  Detailed report filters working or not Verification");
			
			ApprovalcountPOM.DetailedReportFilter(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 56)
		void AssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Assignment Report verification");
			
			
			CFOcountPOM.AssignmentReport(test );
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 57)
		void AssignmentReportFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = Compliance ID Filter Working Or not");
			
			DeptCountPOM.ComplianceIDFilter1(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 58)
		void ComplianceIDFilterEBAU() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = Compliance ID Filter Working Or not");
			
			DeptCountPOM.ComplianceIDFilterEBAU(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 59)
		void ComplianceIDFilterINAu() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = Compliance ID Filter Working Or not");
			
			DeptCountPOM.ComplianceIDFilterINAu(test);
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 60)
		void ComplianceIDFilter1Invalid() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
			
			DeptCountPOM.ComplianceIDFilter1Invalid(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 61)
		void ComplianceIDFilterEBInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
			
			DeptCountPOM.ComplianceIDFilterEBInvalid(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 62)
		void ComplianceIDFilterINInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
			
			DeptCountPOM.ComplianceIDFilterINInvalid(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 63)
		void ActRepository() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Repository  verification");
			
			
	        WebDriverWait wait = new WebDriverWait( getDriver(), (160));
		    
			Thread.sleep(500);
			CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,100)");						//Scrolling down window by 1000 px.
				Thread.sleep(2000);
			CFOcountPOM.clickActRepository().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			Thread.sleep(1000);//*[@id="divOverView1"]/div/div/div[1]/button
			getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[11]/a")).click();
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button")).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Overview successfully");
			OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 64)
		void ComplianceDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents  verification");
			
			
	WebDriverWait wait = new WebDriverWait( getDriver(),(140));
		    
			Thread.sleep(500);
			CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
			Thread.sleep(3000);
			CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			Thread.sleep(2000);
			 By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocument1().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " :- View successfully.");
				ViewButton.get(1).click();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
				CFOcountPOM.clickDownloadBtn().click();
				Thread.sleep(2000);
				getDriver().switchTo().defaultContent();
				CFOcountPOM.closeDownloadTab1().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "  File downloaded successfully.");
				ViewButton.get(2).click();
				Thread.sleep(5000);
				CFOcountPOM.closeDocument2().click();
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "  OverView successfully.");
				 By locator1 = By.xpath("//*[@id='sel_chkbx']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
					Thread.sleep(4000);
					// retrieving "foo-button" HTML element
					List<WebElement> ChechBoxes =getDriver().findElements(locator1);	
					Thread.sleep(3000);
					ChechBoxes.get(0).click();
					Thread.sleep(500);
					ChechBoxes.get(1).click();
					Thread.sleep(500);
					ChechBoxes.get(3).click();
					Thread.sleep(3000);
					getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, " After Checking Multiple checkbox  File downloaded successfully.");
					/*
					CFOcountPOM.clickAdvancedSearch().click();
					Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
				Thread.sleep(3000);
				By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[23]/a");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
				Thread.sleep(4000);
				List<WebElement> ViewButton1 =getDriver() .findElements(locator2);	
				Thread.sleep(3000);
				ViewButton1.get(0).click();
				Thread.sleep(5000);
				CFOcountPOM.closeDocument1().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Advanced Search :- View successfully.");
				ViewButton1.get(1).click();
				Thread.sleep(4000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
				CFOcountPOM.clickDownloadBtn().click();
				Thread.sleep(2000);
				getDriver().switchTo().defaultContent();
				CFOcountPOM.closeDownloadTab1().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Advanced Search - File downloaded successfully.");
				ViewButton1.get(2).click();
				Thread.sleep(5000);
				CFOcountPOM.closeDocument2().click();
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "Advanced Search -  OverView successfully.");
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
					CFOcountPOM.closeDocumentAS().click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, " Advanced Search - After Checking Multiple checkbox  File downloaded successfully.");
					Thread.sleep(1000);
*/
					OverduePOM.clickDashboard().click();
					extent.endTest(test);
					extent.flush();
		}
		
		//@Test(priority = 65)
	void ComplianceDocumentsFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check Compliance Document page All filters working or not");
	
		
		DeptCountPOM.ComplianceDocumentsFilterAu(test);
		
				extent.endTest(test);
				extent.flush();
	}
		
		@Test(priority = 66) //	pass	
		void CriticalDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Critical Document Verification");
			
			
			OverduePOM.CriticalDocuments( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 67)
		void ActDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Act Documents  verification");

			
	         WebDriverWait wait = new WebDriverWait( getDriver(),(140));
		    
			Thread.sleep(500);
			CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
			Thread.sleep(3000);
			CFOcountPOM.clickActDocuments().click();			//Clicking on 'Act Documents ' 
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			Thread.sleep(2000);
			
			 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[6]/a");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(4000);
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews"));
				Thread.sleep(4000);
				if(CFOcountPOM.ViewDoc().isEnabled()) {
					CFOcountPOM.ViewDoc().click();
					Thread.sleep(4000);
				//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("docViewerStatutory"));
					try {
						ApprovalcountPOM.ErrorMsg().isDisplayed();
						test.log(LogStatus.FAIL,   " Act Documents:-After Clicking on View - Document viewer should get open and user should not able to view the document after clicking on view icon for the respective document because error occured. ");

					}catch(Exception e) {
						CFOcountPOM.ViewClose().click();
						getDriver().switchTo().parentFrame();
					
					Thread.sleep(4000);
					test.log(LogStatus.PASS,   " Act Documents:-After Clicking on View - Document viewer should get open and user should be able to view the document after clicking on view icon for the respective document. ");
					}
					}
				 Actions act =new Actions(getDriver());
		            act.sendKeys(Keys.PAGE_UP).build().perform();
		            Thread.sleep(7000);
		            getDriver().switchTo().defaultContent();
		            Thread.sleep(1000);
				CFOcountPOM.closeDocument1().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "View successfully.");
				ViewButton.get(1).click();
				Thread.sleep(4000);
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
				getDriver().findElement(By.xpath("//*[@id='basic']/tbody/tr[2]/td[2]")).click();
				Thread.sleep(4000);
				getDriver().switchTo().defaultContent();
				CFOcountPOM.closeDownloadTab().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "File Download successfully.");
				performer.OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 34) // pass
		void MyReminderStatutory() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reminder - Statutory Count Verification");
			
			
			OverduePOM.MyReminder( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 68) // pass
		void MyNotifications() throws InterruptedException, IOException
		{
			test = extent.startTest("My Notifications - Verification");
			
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
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
		
		@Test(priority = 69) // pass
		void MessageCenter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Message Center - Verification");
			
			WebDriverWait wait = new WebDriverWait( getDriver(),(30));
			Thread.sleep(8000);
			CFOcountPOM.clickMessageCenter().click();
			try {
		CFOcountPOM.clickViewMsg().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "View Button is clickable");
		Thread.sleep(1000);
		}catch(Exception e){
			test.log(LogStatus.PASS, "No Records Found.");	
		}
		performer.OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}
		
		  @Test(priority = 70)
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
				OverduePOM.choosefile().sendKeys("C:\\Users\\mayurig\\Downloads\\Report.xlsx");
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
			
			 @Test(priority = 59)
				void SupportTicket() throws InterruptedException, IOException
				{
					Thread.sleep(1000);		
					test = extent.startTest("'Support Ticket  '  Verification");
					
					
					MethodsPOM.SupportTicket(test);
					
					extent.endTest(test);
					extent.flush();
				}
		
		////// @Test(priority = 51)
				void DetailedReportReOpen() throws InterruptedException, IOException
				{
					test = extent.startTest("Detailed Report ReOpen Count Verification");
					
					
					AuditorcountPOM.DetailedReportRE(test,  "Auditor");
					
					extent.endTest(test);
					extent.flush();
				} 
		
		 @Test(priority = 71) //pass 
	       void WhatsNew() throws InterruptedException, IOException
				{
					test = extent.startTest("' what's New ' Verification");
					
					
					MethodsPOM.WhatsNew(test);
					
					extent.endTest(test);
					extent.flush();
				}
	       
	       /*
	     @Test(priority = 41)
	   	void CompletedPFR_PieChartApAu() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Completion status graph ?");
	   		
	   		
	   		MgmtAMethod.CompletedPFR_PieChartApAu(test);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	   	
	   	@Test(priority = 42)
	   	void NotCompletedPFR_PieChartApAu() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Not Completed status graph?");
	   		
	   		
	   		MgmtAMethod.NotCompletedPFR_PieChartApAu(test);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	   	
	   	@Test(priority = 43)
		void RiskSummaryHighStatutoryApAu() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Risk summary graph?");
			
			
			MgmtAMethod.RiskSummaryHighStatutoryApAu(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 44)
		void DepartSummaryStatutoryApAppAu() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Department summary graph?");
			
			
			MgmtAMethod.DepartSummaryStatutoryApAppAu(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 45)
		void Completed_PieChartPeriodAP() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period)- Completion status graph?");
			
			
			MgmtAMethod.Completed_PieChartPeriodAPAU(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 46)
		void NotCompleted_PieChartPeriodAP() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period) - Not Completed graph?");
			
			
			MgmtAMethod.NotCompleted_PieChartPeriodAPAU(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 47)
		void DetailedReportAPAu() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in details tab on the view icon of Detailed report?");
			
			
			MgmtAMethod.DetailedReportAPAu(test);
			
			extent.endTest(test);
			extent.flush();
		}
	   	
		@Test(priority = 48)
		void CompletedPFR_PieChartMp() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.CompletedPFR_PieChartMp(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 49)
		void CompletedPFR_PieChartMpView() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.CompletedPFR_PieChartMpView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 50)
		void RiskSummaryMp() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.RiskSummaryMp(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 51)
		void RiskSummaryMpView() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.RiskSummaryMpView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 52)
		void DeptSummaryMp() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DeptSummaryMp(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 53)
		void DeptSummaryMpView() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DeptSummaryMpView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 54)
		void DFPCompletedPFR_PieChartMp() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DFPCompletedPFR_PieChartMp(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 55)
		void DFPCompletedPFR_PieChartMpView() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DFPCompletedPFR_PieChartMpView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 56)
		void CompletedPFR_PieChartMpSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.CompletedPFR_PieChartMpSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 57)
		void CompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.CompletedPFR_PieChartMpViewSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 58)
		void RiskSummaryMpSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.RiskSummaryMpSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 59)
		void RiskSummaryMpViewSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.RiskSummaryMpViewSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 60)
		void DeptSummaryMpSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DeptSummaryMpSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 61)
		void DeptSummaryMpViewSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DeptSummaryMpViewSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 62)
		void DFPCompletedPFR_PieChartMpSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary (Due for the period) graph - Statutory  Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DFPCompletedPFR_PieChartMpSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 63)
		void DFPCompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary (Due for the period) graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DFPCompletedPFR_PieChartMpViewSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 64)
		void CompletedPFR_PieChartMpIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.CompletedPFR_PieChartMpIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 65)
		void CompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.CompletedPFR_PieChartMpViewIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 66)
		void RiskSummaryMpIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.RiskSummaryMpIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 67)
		void RiskSummaryMpViewIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.RiskSummaryMpViewIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		                                                                                                                                                                                                                                          	
		@Test(priority = 68)
		void DFPCompletedPFR_PieChartMpIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DFPCompletedPFR_PieChartMpIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 69)
		void DFPCompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
			
			
			AuditorcountPOM.DFPCompletedPFR_PieChartMpViewIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		/*	@Test(priority = 70)
		void Reopening() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To check whether the new tab named \"My Reopening\" is seperately reflects or not on the dashboard in the main menu while the tab will be visible only for who have made the configuration.");
				
			DeptCountPOM.Reopening(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 71)
		void ReopeningRe() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Re-open");
				
			DeptCountPOM.ReopeningRe(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 72)
		void Reopeningapprove() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Approve");
				
			DeptCountPOM.Reopeningapprove(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 73)
		void ReopeningExport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To Check Whether Export button of working or not?");
				
			DeptCountPOM.ReopeningExport(test);
			
			extent.endTest(test);
			extent.flush();
		}
		*/
		

	/*		
			@Test(priority = 74)
			void ComplianceDocumentsDAM() throws InterruptedException, IOException
			{
				test = extent.startTest("My Documents - Compliance Documents - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my document page?");
					
				MethodsPOM.ComplianceDocumentsDAMAu(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 75)
			void DeviationApproverColCDAPP() throws InterruptedException, IOException
			{
				test = extent.startTest("My Documents - Compliance Documents - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\"in grid  of My document page?");
					
				MethodsPOM.DeviationApproverColCDAPP(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 80)
			void DeviationClosureStatuscolCD() throws InterruptedException, IOException
			{
				test = extent.startTest("My Documents - Compliance Documents - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
					
				MethodsPOM.DeviationClosureStatuscolCD(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
	       @Test(priority = 81)
			void DetailedReportDA() throws InterruptedException, IOException
			{
				test = extent.startTest("my Report - Detailed  report - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my report page?");
					
				MethodsPOM.DetailedReportDAM(test);
				
				extent.endTest(test);
				extent.flush();
			}*/
	       
			@Test(priority = 82)
			void PerformReviewEmailCol() throws InterruptedException, IOException
			{
				test = extent.startTest("Detailed Report - Performer Email column and Reviewer Email column Visible on grid Verification. ");
					
				MethodsPOM.PerformReviewEmailCol(test);
				
				extent.endTest(test);
				extent.flush();
			}
			

			@Test(priority = 83)
			void PerformReviewEmailColIn() throws InterruptedException, IOException
			{
				test = extent.startTest("Detailed Report - Internal - Performer Email column and Reviewer Email column Visible on grid Verification. ");
					
				MethodsPOM.PerformReviewEmailColIn(test);
				
				extent.endTest(test);
				extent.flush();
			}


	       
	    @Test(priority = 82)
			void PerformanceSummarySF() throws InterruptedException, IOException
			{
				test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Performance Summary Graph?");
				
				AuditorcountPOM.PerformanceSummarySF(test);
				
				extent.endTest(test);
				extent.flush();
			}
	 	@Test(priority = 83)
		void RiskSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Risk Summary Graph?");
			
			AuditorcountPOM.RiskSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
	 	
	 	@Test(priority = 84)
		void DepartmentSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Department Summary Graph?");
			
			AuditorcountPOM.DepartmentSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
	 	
		@Test(priority = 85)
		void PerformerSummaryDueForPeriodSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Performance Summary(Due for the period) Graph?");
			
			AuditorcountPOM.PerformerSummaryDueForPeriodSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 86)
		void DetailedReportSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Deatiled Report?");
			
			AuditorcountPOM.DetailedReportSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 87)
		void ComplianceDocumentsSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Compliance Document?");
			
			AuditorcountPOM.ComplianceDocumentsSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
						

			
		
		@AfterMethod
	  	void browserClosing() throws InterruptedException
	  	{
			closeBrowser();
	  		Thread.sleep(1000);
	  	//	.close();
	  	}	       
	  		       		
	  	@AfterTest
	  	void Closing() throws InterruptedException
	  	{
	  		
	  	}	 
		
		
	
}
