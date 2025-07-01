package criticalTestScripts;

import org.testng.annotations.Test;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import departmentHead.DeptCountPOM;
import login.BasePage;
import performer.MethodsPOM;
import reviewer.ReMethodsPOM;

public class AuditorStatutory extends BasePage {
	
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
	
	public static String link = "mgmt1";		
	//	In Auditor Loging(Internal) -Completion Status - Overall Functions graph -Internal Audit -'Not Completed' Compliances Count does not match with grid
	
	/*public static XSSFSheet ReadExcel() throws IOException
	{
		
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(5);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\Auditor.html",true);

		test = extent.startTest("Loging In - Auditor (Statutory)");
		test.log(LogStatus.PASS, "Logging id - auditor1@regtrack.com , password - Team@1234");
		
	
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
	
		initialization(link,5,"Statutory");
	/*	
		XSSFSheet sheet = ReadExcel();
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
	
	
	@Test(priority = 2)
	void NotCompleted_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(5000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+NotCompletedValue+" |  Sum of Total Risk Count: "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+NotCompletedValue+" |  Sum of Total Risk Count : "+total);
		}
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
	

	@Test(priority = 3)
	void ClosedDelayed_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,200)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayed().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(5000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		Thread.sleep(8000);
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+ClosedDelayedValue+" | Sum of Total Risk Count: "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+ClosedDelayedValue+" | Sum of Total Risk Count: "+total);
		}
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
	
	@Test(priority = 4)
	void ClosedTimely_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
	
		Thread.sleep(1500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimely().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		Thread.sleep(5000);
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Timely' Compliances : "+ClosedTimelyValue+" | Sum of Total Risk Count : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Timely' Compliances : "+ClosedTimelyValue+" | Sum of Total Risk Count : "+total);
		}
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
	
	@Test(priority = 5)
	void NotApplicable_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		
		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		Thread.sleep(1000);
		if(NotApplicableValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+NotApplicableValue+" | Sum of Total Risk Count: "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+NotApplicableValue+" | Sum of Total Risk Count: "+total);
		}
		Thread.sleep(1000);
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
		
	@Test(priority = 6)
	void Overdue_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		
		Thread.sleep(1000);
		//Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		Thread.sleep(3000);
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Overdue' Compliances : "+OverdueValue+" | Sum of Total Risk Count : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+OverdueValue+" | Sum of Total Risk Count : "+total);
		}
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
	
	@Test(priority = 7)
	void dueToday_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		
		
		Thread.sleep(1000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		Thread.sleep(5000);
		
		if(dueTodayValue == total)
		{
			test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'dueToday' Compliances : "+dueTodayValue+" | Sum of Total Risk Count : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'dueToday' Compliances : "+dueTodayValue+" | Sum of Total Risk Count : "+total);
		}
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
	
	@Test(priority = 8)
	void pendingForReview_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		
		
		Thread.sleep(2000);
	//	Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		Thread.sleep(4000);
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Pending For Review' Compliances : "+pendingForReviewValue+" | Sum of Total Risk Count : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Pending For Review' Compliances : "+pendingForReviewValue+" | Sum of Total Risk Count : "+total);
		}
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
	
	@Test(priority = 9)
	void inProgress_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'In Progress' Count Verification");
	
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		Thread.sleep(3000);
		
		if(inProgressValue == total)
		{
			test.log(LogStatus.PASS, "' In Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'In Progress' Compliances : "+inProgressValue+" |Sum of Total Risk Count: "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'In Progress' Compliances : "+inProgressValue+" |Sum of Total Risk Count: "+total);
		}
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

	@Test(priority = 10)
	void rejected_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- ' Rejected' Count Verification");
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		Thread.sleep(3000);
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Rejected' Compliances : "+rejectedValue+" | Sum of Total Risk Count : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+rejectedValue+" | Sum of Total Risk Count: "+total);
		}
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
	

    @Test(priority = 11)
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
		Thread.sleep(3000);
		Thread.sleep(500);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		Thread.sleep(3000);
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		if(IndustrySpeCritical == total)
		{
			test.log(LogStatus.PASS, "'Commercial' - Critical' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Commercial - Critical' Compliances : "+IndustrySpeCritical+" | Sum of Critical count statuses : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Commercial' - Critical' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Commercial - Critical' Compliances : "+IndustrySpeCritical+" | Sum of Critical count statuses : "+total);
		}
		Thread.sleep(1000);
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
	
	
	@Test(priority = 12)
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
		
		String PendingReview = CFOcountPOM.clickIndustrySpeHigh().getText();	//Reading the Pending For Review value of Human Resource
	//	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		
		Thread.sleep(4000);
		int IndustrySpeHigh = Integer.parseInt(PendingReview);	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickIndustrySpeHigh().click();					//Clicking on High bar of Labour  
		
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
		Thread.sleep(3000);
		if(IndustrySpeHigh == total)
		{
			test.log(LogStatus.PASS, "'Commercial - High' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Commercial - High' Compliances : "+IndustrySpeHigh+" | Sum of High count statuses: "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Commercial - High' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Commercial - High' Compliances : "+IndustrySpeHigh+" | Sum of High count statuses: "+total);
		}
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

	
    @Test(priority = 13)

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
		CFOcountPOM.clickIndustrySpeMedium().click();					//Clicking on High bar of Labour  
		
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
		Thread.sleep(5000);
		if(IndustrySpeMedium == total)
		{
			test.log(LogStatus.PASS, "'Commercial - Medium' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Commercial - Medium' Compliances : "+IndustrySpeMedium+" | Sum of Medium count statuses: : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'ICommercial - Medium' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Commercial - Medium' Compliances : "+IndustrySpeMedium+" | Sum of Medium count statuses: : "+total);
		}
		Thread.sleep(5000);
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
	
  @Test(priority = 14)

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
		CFOcountPOM.clickIndustrySpeLow().click();					//Clicking on low bar of Indistry Specific  
		
		Thread.sleep(5000);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		if(IndustrySpeLow == total)
		{
			test.log(LogStatus.PASS, "'Commercial - Low' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Commercial - Low' Compliances : "+IndustrySpeLow+" | Sum of Low count statuses: : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Commercial - Low' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Commercial - Low' Compliances : "+IndustrySpeLow+" | Sum of Low count statuses: : "+total);
		}Thread.sleep(500);
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
	
	@Test(priority = 15)
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
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	//	js.executeScript("window.scrollBy(0,1450)");					//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,1200)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryCritical().getText());
		Thread.sleep(4000);
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
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
		
		Thread.sleep(3000);
		Thread.sleep(2000);
		List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
		
		Thread.sleep(4000);
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
		
		Thread.sleep(8000);
		int total = RiskCritical_NotCompleted + RiskCritical_ClosedDelayed + RiskCritical_ClosedTimely + RiskCritical_NotApplicable+RiskCritical_DueToday;				//Calculating the values to match with High value of Labour.
		Thread.sleep(5000);	
		if(IndustrySpeCritical == total)
		{
			test.log(LogStatus.PASS, "Risk summary  Critical' Compliance Count matches to sum of all types of statuses.");
			test.log(LogStatus.PASS, "Total  Critical' Compliances : "+IndustrySpeCritical+" | Sum of Critical count statuses : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Risk summary  Critical' Compliance Count doesn't matches to sum of all types of statuses.");
			test.log(LogStatus.FAIL, "Total Critical' Compliances : "+IndustrySpeCritical+" | Sum of Critical count statuses : "+total);
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
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
		String High = CFOcountPOM.RiskSummaryHigh().getText();		//Reading the Closed Timely value of Human Resource
		High = High.replaceAll(" ","");									//Removing all white spaces from string. 
		int IndustrySpeCritical = Integer.parseInt(High);
	
		Thread.sleep(4000);
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
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
		List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
		
		Thread.sleep(3000);
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
		
		Thread.sleep(8000);
		int total = RiskHigh_NotCompleted + RiskHigh_ClosedDelayed + RiskHigh_ClosedTimely + RiskHigh_NotApplicable+RiskHigh_DueToday;				//Calculating the values to match with High value of Labour.
		Thread.sleep(5000);	
		if(IndustrySpeCritical == total)
		{
			test.log(LogStatus.PASS, "Risk summary  High' Compliance Count matches to sum of all types of statuses.");
			test.log(LogStatus.PASS, "Total  High' Compliances : "+IndustrySpeCritical+" | Sum of High count statuses : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Risk summary  High' Compliance Count doesn't matches to sum of all types of statuses.");
			test.log(LogStatus.FAIL, "Total High' Compliances : "+IndustrySpeCritical+" | Sum of High count statuses : "+total);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 17)

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
		Thread.sleep(1000);
		int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryMedium().getText());
		Thread.sleep(4000);
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
		List<WebElement>CD = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(CD, "Closed Delayed");
		List<WebElement>CT = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(CT, "Closed Timely");
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
	/*	int RiskMedium_DueToday = Integer.parseInt(CFOcountPOM.clickRiskMediumDueToday().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_DueToday > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumDueToday().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1( test, "Medium - Due Today", RiskMedium_DueToday, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Due Today' Count = "+RiskMedium_DueToday);
		}*/
		
		Thread.sleep(8000);
		int total = RiskMedium_NotCompleted + RiskMedium_ClosedDelayed + RiskMedium_ClosedTimely + RiskMedium_NotApplicable;//+RiskMedium_DueToday;				//Calculating the values to match with High value of Labour.
		Thread.sleep(5000);	
		if(IndustrySpeCritical == total)
		{
			test.log(LogStatus.PASS, "Risk summary  Medium' Compliance Count matches to sum of all types of statuses.");
			test.log(LogStatus.PASS, "Total  Medium' Compliances : "+IndustrySpeCritical+" | Sum of Medium count statuses : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Risk summary  Medium' Compliance Count doesn't matches to sum of all types of statuses.");
			test.log(LogStatus.FAIL, "Total Medium' Compliances : "+IndustrySpeCritical+" | Sum of Medium count statuses : "+total);
		}
		
		//performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 18)

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
			Thread.sleep(4000);Thread.sleep(4000);
			int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryLow().getText());
			Thread.sleep(4000);
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
		List<WebElement>CD = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(CD, "Closed Delayed");
		List<WebElement>CT = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(CT, "Closed Timely");
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
	/*	int RiskLow_DueToday = Integer.parseInt(CFOcountPOM.clickRiskLowDueToday().getText());	//Reading the High Risk value of Not Completed compliance
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
		*/
		Thread.sleep(8000);
		int total = RiskLow_NotCompleted + RiskLow_ClosedDelayed + RiskLow_ClosedTimely + RiskLow_NotApplicable;//+RiskLow_DueToday;				//Calculating the values to match with High value of Labour.
		Thread.sleep(5000);	
		if(IndustrySpeCritical == total)
		{
			test.log(LogStatus.PASS, "Risk summary  Low' Compliance Count matches to sum of all types of statuses.");
			test.log(LogStatus.PASS, "Total  Low' Compliances : "+IndustrySpeCritical+" | Sum of Low count statuses : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Risk summary  Low' Compliance Count doesn't matches to sum of all types of statuses.");
			test.log(LogStatus.FAIL, "Total Low' Compliances : "+IndustrySpeCritical+" | Sum of Low count statuses : "+total);
		}
		
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 19)

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
	
	@Test(priority = 20)

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
		Thread.sleep(3000);
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+NotCompletedValue+" | Total Sum of all risks : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+NotCompletedValue+" | Total Sum of all risks : "+total);
		}
		Thread.sleep(3000);
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
	

	@Test(priority = 21)

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
		Thread.sleep(3000);
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+ClosedDelayedValue+" | Total Sum of all risks: "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+ClosedDelayedValue+" | Total Sum of all risks: "+total);
		}
		Thread.sleep(3000);
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
	

	@Test(priority = 22)

	void ClosedTimely_PieChartPe() throws InterruptedException, IOException
	{
		//test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
	
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
		Thread.sleep(3000);
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Closed Timely' Compliances : "+ClosedTimelyValue+" | Total Sum of all risks: "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Closed Timely' Compliances : "+ClosedTimelyValue+" | Total Sum of all risks: "+total);
		}
		Thread.sleep(3000);
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
	

	@Test(priority = 23)

	void NotApplicable_PieChartPeriod() throws InterruptedException, IOException
	{
	//	test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
	
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
		Thread.sleep(3000);
		if(NotApplicableValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+NotApplicableValue+" | Total Sum : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+NotApplicableValue+" | Total Sum : "+total);
		}
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
		
	@Test(priority = 24)

	void UpcomingPieChartPeriod() throws InterruptedException, IOException
	{
		//test = extent.startTest("Period-Pie Chart -Not Completed Status- ' Upcoming' Count Verification");
	
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2100)");			//Scrolling down window by 1000 px.
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
		test.log(LogStatus.PASS, "The status named \"upcoming\" should reflects separately in the graph of the performance summary (completion compliance summary) due for a period.");

	}else {
		test.log(LogStatus.FAIL, "The status named \"upcoming\" not reflects separately in the graph of the performance summary (completion compliance summary) due for a period.");

	}
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickUpcomingPe().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickUpcomingPe().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		Thread.sleep(3000);
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' upcoming' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'upcoming' Compliances : "+rejectedValue+" | Total Sum of all risks: "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'upcoming' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'upcoming' Compliances : "+rejectedValue+" | Total Sum of all risks: "+total);
		}
		Thread.sleep(3000);
		if(rejectedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPeUp( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUp( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUp( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUp( test, "Low", low, "Statutory");
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
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+rejectedValue);
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
	


	@Test(priority = 25)

	void Overdue_PieChartperiod() throws InterruptedException, IOException
	{
	//	test = extent.startTest("period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		
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
		Thread.sleep(500);
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Overdue' Compliances : "+OverdueValue+" | Total Sum : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+OverdueValue+" | Total Sum : "+total);
		}
		Thread.sleep(500);
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
	

	@Test(priority = 26)

	void dueToday_PieChartPeriod() throws InterruptedException, IOException
	{
	//	test = extent.startTest("period-Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		
		
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
		Thread.sleep(500);
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'dueToday' Compliances : "+OverdueValue+" | Total Sum of all risks : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'dueToday' Compliances : "+OverdueValue+" | Total Sum of all risks : "+total);
		}
		Thread.sleep(500);
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
	

	@Test(priority = 27)

	void pendingForReview_PieChartPeriod() throws InterruptedException, IOException
	{
		//test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		
		
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
		Thread.sleep(500);
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Pending For Review' Compliances : "+pendingForReviewValue+" | Total Sum of all risks : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Pending For Review' Compliances : "+pendingForReviewValue+" | Total Sum of all risks : "+total);
		}
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
	

	@Test(priority = 28)

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
		
		Thread.sleep(5000);
		if(inProgressValue == total)
		{
			test.log(LogStatus.PASS, "' in Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'in Progress' Compliances : "+inProgressValue+" | Total Sum of all risks : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'in Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'in Progress' Compliances : "+inProgressValue+" | Total Sum of all risks : "+total);
		}
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
	
	@Test(priority = 29)

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
		Thread.sleep(3000);
		if(rejectedValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Rejected' Compliances : "+rejectedValue+" | Total Sum of all risks : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+rejectedValue+" | Total Sum of all risks : "+total);
		}
		Thread.sleep(3000);
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
	
	 @Test(priority = 30)
		void DetailedReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report Count Verification");
			
			CFOcountPOM.DetailedReport1(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority = 31) 
		void SMETAReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reports - SMETA Report Verification");
			
			
			ReMethodsPOM.SMETAReport(test, "Statutory");

			extent.endTest(test);
			extent.flush();
		}
		
	//	//@Test(priority = 32) 
		void SMETAReportFilterMgmt() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reports - To Check Whether Smeta Report Grid all filter working or not ? ");
			
			
			DeptCountPOM.SMETAReportFilterMgmt(test);

			extent.endTest(test);
			extent.flush();
		}
	  
		@Test(priority = 60)
		void AssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Assignment Report verification");
			
			CFOcountPOM.AssignmentReportSta(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 74)
		void ComplianceDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents  verification");
		
			
			CFOcountPOM.ComplianceDocumentsSta(test);
			
					extent.endTest(test);
					extent.flush();
		}
		
		@Test(priority = 75)
		void NCcompletionVsNCOverdue() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status(Not Completed) and Not Completed Status graph count Verification");
			AuditorcountPOM.NCcompletionVsNCOverdue(test);
	        extent.endTest(test);
	        extent.flush();
	    }
		
		 @Test(priority = 76)
		void NCcompletionVsNCOverdueP() throws InterruptedException {
			test=extent.startTest("Performer Summary(Due for the period) Completion Status(Not Completed) and Not Completed Status graph count Verification");
			AuditorcountPOM.NCcompletionVsNCOverdueP(test);
	        extent.endTest(test);
	        extent.flush();
	    }
		
		 @Test(priority = 79)
		void DetailedreportVsdashboardNotCompletedcount() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status(Not Completed) dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsdashboardNotCompletedcountUp(test,"Statutory");
			
	        extent.endTest(test);
	        extent.flush();
	    }
		
		 @Test(priority = 80)
		void DetailedreportVsdashboardCloseddealyedcount() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status - Closed Delayed dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsdashboardCloseddealyedcountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
		
	@Test(priority = 81)
		void DetailedreportVsdashboardclosedtimelycount() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status - Closed Timely dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsdashboardclosedtimelycountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
	
	 @Test(priority = 82)//19/03/2025
		void DetailedreportVsdashboardNAcount() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status - Not Applicable dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsdashboardNAcountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
		
	@Test(priority = 83)
		void DetailedreportVsOverduecount() throws InterruptedException {
			test=extent.startTest("Performer Summary Not Completed Status - Overdue dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsOverduecountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
		
		 @Test(priority = 84)
		void DetailedreportVsDueTodaycount() throws InterruptedException {
			test=extent.startTest("Performer Summary Not Completed Status - DueToday dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsDueTodaycountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
		
		 @Test(priority = 85)
		void DetailedreportVsPFRcount() throws InterruptedException {
			test=extent.startTest("Performer Summary Not Completed Status - Pending For Review dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsPFRcountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
		
		@Test(priority = 86)
		void DetailedreportVsINprocount() throws InterruptedException {
			test=extent.startTest("Performer Summary Not Completed Status - In Progress dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsINprocountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
		
		 @Test(priority = 87)
		void DetailedreportVsRejectedcount() throws InterruptedException {
			test=extent.startTest("Performer Summary Not Completed Status - Rejected dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DetailedreportVsRejectedcountUp(test,"Statutory");
	        extent.endTest(test);
	        extent.flush();
	    }
		
		@Test(priority =88) //20/03/2025
			void DetailedreportVsCommercialCriticalcount() throws InterruptedException {
				test=extent.startTest("Completion Status - Overall Functions - Commercial - Critial dashboard count match with Detailed Report Count Verification");
				AuditorcountPOM.DetailedreportVsCommercialCriticalcount(test,"Statutory");
		        extent.endTest(test);
		        extent.flush();
		    }
		
			 @Test(priority = 89)
			void DetailedreportVsCommercialHighcount() throws InterruptedException {
				test=extent.startTest("Completion Status - Overall Functions - Commercial - High dashboard count match with Detailed Report Count Verification");
				AuditorcountPOM.DetailedreportVsCommercialHighcount(test,"Statutory");
		        extent.endTest(test);
		        extent.flush();
		    }
			
			@Test(priority = 90)
			void DetailedreportVsCommercialMediumcount() throws InterruptedException {
				test=extent.startTest("Completion Status - Overall Functions - Commercial - Medium dashboard count match with Detailed Report Count Verification");
				AuditorcountPOM.DetailedreportVsCommercialMediumcount(test,"Statutory");
		        extent.endTest(test);
		        extent.flush();
		    }
			
			@Test(priority = 91)
			void DetailedreportVsCommercialLowcount() throws InterruptedException {
				test=extent.startTest("Completion Status - Overall Functions - Commercial - Low dashboard count match with Detailed Report Count Verification");
				AuditorcountPOM.DetailedreportVsCommercialLowcount(test,"Statutory");
		        extent.endTest(test);
		        extent.flush();
		    }
		
			@Test(priority = 92)
				void riskSummaryCriticalNotCompleted1() throws InterruptedException, IOException
				{
					test = extent.startTest("Risk summary Not Completed dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.riskSummaryCriticalNotCompletedAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 93)
				void riskSummaryClosedDelayed() throws InterruptedException, IOException
				{
					test = extent.startTest("Risk summary Closed Delayed dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.riskSummaryClosedDelayedAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 94)
				void riskSummaryClosedTimely() throws InterruptedException, IOException
				{
					test = extent.startTest("Risk summary Closed Timely dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.riskSummaryClosedTimelyAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 95)
				void riskSummaryNotApplicable() throws InterruptedException, IOException
				{
					test = extent.startTest("Risk summary Not Applicable dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.riskSummaryNotApplicableAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 96)
				void DepartmentSummaryOverdue() throws InterruptedException, IOException
				{
					test = extent.startTest("Department Summary Overdue dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.DepartmentSummaryOverdueAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 97)
				void DepartmentSummaryClosedDelayed() throws InterruptedException, IOException
				{
					test = extent.startTest("Department Summary Closed Delayed dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.DepartmentSummaryClosedDelayedAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 98)
				void DepartmentSummaryClosedT() throws InterruptedException, IOException
				{
					test = extent.startTest("Department Summary Closed Timely dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.DepartmentSummaryClosedTAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 99)
				void DepartmentSummaPR() throws InterruptedException, IOException
				{
					test = extent.startTest("Department Summary Pending Review dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.DepartmentSummaPRAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 100)
				void DepaINPROGRESSR() throws InterruptedException, IOException
				{
					test = extent.startTest("Department Summary In Progress dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.DepaINPROGRESSRAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 101)
				void DepartmentSummaryRejected() throws InterruptedException, IOException
				{
					test = extent.startTest("Department Summary Rejected dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.DepaRejectedRAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
				
				 @Test(priority = 102)
				void DepartmentSummaryNotApplicable() throws InterruptedException, IOException
				{
					test = extent.startTest("Department Summary Not Applicable dashboard count match with Detailed Report Count Verification");
					AuditorcountPOM.DepaNotApplicAU( test, "Critical","Statutory");
					extent.endTest(test);
					extent.flush();
			    	
				}
			
				
		
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		Thread.sleep(1000);
  		//getDriver().close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}	 
	
	
	

}
