package criticalTestScripts;

import java.io.File;
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
import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import login.BasePage;
import performer.OverduePOM;

public class InternalMgmt extends BasePage {
	
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
	
	
	public static String link = "mgmt1";			//Check link in excel sheet first.
	
/*	public static XSSFSheet ReadExcel() throws IOException
	{
	
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(2);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{	
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\MgmtResultsInternal.html",true);
		//extent = new ExtentReports(System.getProperty("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\//CFOResultsInternal.html.html")+"//CFOResultsInternal.html.html",true);
		//extent.loadConfig(new File("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\extent-config.xml"));
		test = extent.startTest("Loging In - Mgmt (Internal)");
			test.log(LogStatus.PASS, "Logging id - bhagyesh@tlregtech.com , password - admin@123");
	
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
	
		initialization(link,2,"internal");
		/*
		XSSFSheet sheet = ReadExcel();
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
		
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		*/
	/*	Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(3000);
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(3000);*/
	}
	
	public static void progress1()
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (60));
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
		
		ApprovalcountPOM.Entities( test);
		extent.flush();
		extent.endTest(test);
		//extent.flush();
	}
	

   @Test(priority = 2)
	void LocationCount() throws InterruptedException, IOException
	{
		test = extent.startTest("Location");
		
		ApprovalcountPOM.LocationCount( test);
		extent.flush();
		extent.endTest(test);
		//extent.flush();
	}
	
@Test(priority = 3)
	void clickCategoriesInternal() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Categories'");
	
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	Thread.sleep(3000);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(500);
		
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		
		Thread.sleep(7000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		
		Thread.sleep(5000);
		
		CFOcountPOM.closeCategories().click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
		void ClickCompliancesInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("'Compliances' Count by Clicking on 'Compliances'");
	
			
			Thread.sleep(1500);
			WebDriverWait wait1 = new WebDriverWait( getDriver(),(60));
			wait1.until(ExpectedConditions.visibilityOf(CFOcountPOM.TotalCompliancesM()));
			int valueCompliances = Integer.parseInt(CFOcountPOM.TotalCompliancesM().getText());	//Storing value of 'Compliances' as a String to compare.
			
			CFOcountPOM.TotalCompliancesM().click();					//Clicking on 'Compliances'.
			
			Thread.sleep(500);
		//	litigationPerformer.MethodsPOM.progress();
			
			WebDriverWait wait = new WebDriverWait( getDriver(), (10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			
			Thread.sleep(1000);
//			CFOcountPOM.clickExportImage().click();                    //export excel
//			Thread.sleep(5000);
//			test.log(LogStatus.PASS, "Excel file download Successfully");
			AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
			Thread.sleep(3000);
	
			Thread.sleep(5000);
		
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,500)");				//Scrolling down window by 2000 px.
			
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD().click();				//Clicking on Total items count to scroll down.
			String getCount = CFOcountPOM.readTotalItemsD().getText();	//Storing 'Compliances' count as string.
			String[] bits = getCount.split(" ");							//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				getCount = CFOcountPOM.readCompliancesItems().getText();
				bits = getCount.split(" ");								//Splitting the String
				compliancesCount = bits[bits.length - 2];
			}
			
			int count = Integer.parseInt(compliancesCount);
			
			getDriver().switchTo().parentFrame();								//Switching back to parent frame. 
			Thread.sleep(500);
			CFOcountPOM.closeCategories().click();					//Closing the 'Compliance' window.
			
			if(valueCompliances == count)									//Comparing dashboard Compliance value with inside Compliance value
			{
				test.log(LogStatus.PASS, "'Compliances' count matches to total records count displayed. Dashboard Value = "+ valueCompliances+ " | Actual count = "+ count);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Compliances' count doesn't matches to total records count displayed. Dashboard Value = "+ valueCompliances+ " } Actual count = "+ count);
			}
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 7)
	void clickUsersInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("'Users' Count by Clicking on 'Users'");
	
		Thread.sleep(500);
		if(OverduePOM.closeMessage().isDisplayed())				//If Compliance Updation message popped up,
		{
			OverduePOM.closeMessage().click();					//then close the message.
		}
		
		Thread.sleep(1500);
		int valueUsers = Integer.parseInt(CFOcountPOM.clickUsersCount().getText());	//Storing value of 'Users' as a String to compare.
		
		CFOcountPOM.clickUsersCount().click();					//Clicking on 'Users'. 
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (15));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(5000);
//		CFOcountPOM.clickExportImage().click();                    //export excel
//		Thread.sleep(5000);
//		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		CFOcountPOM.readTotalItems4().click();
		
		String getCount = CFOcountPOM.readTotalItems4().getText();	//Storing no of Items 'Users' count as string.
		String[] bits = getCount.split(" ");							//Splitting the String
		String usersCount = bits[bits.length - 2];						//Getting the second last word (total number of users)
		if(usersCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2500);
			getCount = CFOcountPOM.readTotalItems4().getText();
			bits = getCount.split(" ");								//Splitting the String
			usersCount = bits[bits.length - 2];
		}
		int count = Integer.parseInt(usersCount);
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame. 
		Thread.sleep(1000);
		CFOcountPOM.closeCategories().click();					//Closing the 'Compliance' window.
		
		if(valueUsers == count)								//Checking if String getCount contains the Value (in string format) 
		{
			test.log(LogStatus.PASS, "'Users' count matches to 'Users' items. Dashboard Value = "+ valueUsers+ ", Actual Value = "+ getCount);
		}
		else
		{
			test.log(LogStatus.FAIL, "Users count does not matches. Dashboard Value = "+ valueUsers+ ", Actual Value = "+ getCount);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void SummaryofOverdueCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Summary of Overdue Compliances Internal");
	
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		if(CFOcountPOM.ClickShowAllIn().isEnabled()) {
			CFOcountPOM.ClickShowAllIn().click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		        
		Thread.sleep(3000);
	//	litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(3000); 
	
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
		 AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
			Thread.sleep(3000);
			Thread.sleep(4000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
		
			List<WebElement> ViewButtons = getDriver().findElements(locator);							
			ViewButtons.get(1).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
			
			getDriver().switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
	@Test(priority = 10)
	void ClosedTimely_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternal().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyInternal().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(5000);
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
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >=0)
			{
				CFOcountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
			
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 11)
	void ClosedDelayed_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedInternal().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedInternal().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
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
		Thread.sleep(500);
		
		if(ClosedDelayedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 12)
	void NotCompleted_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		Thread.sleep(500);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
	      JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		Thread.sleep(3000);
		int total = critical + high + medium + low;
		Thread.sleep(3000);
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+NotCompletedValue+" |  Sum of Total Risk Count: "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+NotCompletedValue+" |  Sum of Total Risk Count : "+total);
		}Thread.sleep(3000);
		if(NotCompletedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "Low", low, "Internal");
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
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 13)
	void NotApplicable_PieChartIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		Thread.sleep(1500);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickNotApplicable().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		Thread.sleep(1000);
		if(NotApplicable == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+NotApplicable+" | Sum of Total Risk Count: "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+NotApplicable+" | Sum of Total Risk Count: "+total);
		}
		
		if(NotApplicable > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+NotApplicable);
			
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
		
@Test(priority = 14)
	void Overdue_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		Thread.sleep(500);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdueInternal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdueInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
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
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(4000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 15)
	void dueToday_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'dueToday' Count Verification");
	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
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
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn3( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn3( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn3( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn3( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'dueToday' Compliance Count = "+dueTodayValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 16)
	void PFR_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Not Completed Status-  'Pending for Review' Count Verification");
		
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIN().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIN().click();									//CLicking on 'Not Completed' count
		
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
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 17)
	void inProgress_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Not Completed Status-  'In Progress' Count Verification");
		
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
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
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3200);
		}
		else
		{
			test.log(LogStatus.PASS, "'In Progress' Compliance Count = "+inProgressValue);
			
			Thread.sleep(1000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3200);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
@Test(priority = 18)
	void Rejected_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- 'Rejected' Count Verification");
		
		Thread.sleep(500);
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejected().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejected().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				CFOcountPOM.GraphCountIn1( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(2000);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 19)
	void BargraphBSECriticalStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'Critical' risk");
		
		
		Thread.sleep(2000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(4000);
		int BSEHigh = Integer.parseInt(CFOcountPOM.clickBSECritical().getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSECritical().click();					//Clicking on High bar of Labour  
		
		Thread.sleep(2000);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		Thread.sleep(5000);	
		if(BSEHigh == total)
		{
			test.log(LogStatus.PASS, "'Internal Audit' - Critical' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Internal Audit - Critical' Compliances : "+BSEHigh+" | Sum of Critical count statuses : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Internal Audit' - Critical' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Internal Audit - Critical' Compliances : "+BSEHigh+" | Sum of Critical count statuses : "+total);
		}
		if(BSEHigh > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCountIn1( test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Not Applicable", NotApplicable);
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
				}
		else
		{
			test.log(LogStatus.PASS, "'Internal Audit ' - Critical' Count = "+BSEHigh);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(2000);
		}
				extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void BargraphBSEHighStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'High' risk");
		
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		String FinaOverdue = CFOcountPOM.clickBSEHigh().getText();			//Reading the Overdue value of Human Resource
		FinaOverdue = FinaOverdue.replaceAll(" ","");									//Removing all white spaces from string. 
		int BSEHigh = Integer.parseInt(FinaOverdue);
		Thread.sleep(4000);
	//	int BSEHigh = Integer.parseInt(CFOcountPOM.clickBSEHigh().getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSEHigh().click();					//Clicking on High bar of Labour  
		
		Thread.sleep(2000);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		Thread.sleep(3000);
		if(BSEHigh == total)
		{
			test.log(LogStatus.PASS, "'Internal Audit - High' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Internal Audit - High' Compliances : "+BSEHigh+" | Sum of High count statuses: "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Internal Audit - High' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Internal Audit - High' Compliances : "+BSEHigh+" | Sum of High count statuses: "+total);
		}
		Thread.sleep(3000);
		if(BSEHigh > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCountIn1( test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Internal Audit - High' Count = "+BSEHigh);
			
			Thread.sleep(500);
			WebElement element = CFOcountPOM.clickBack();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void BargraphBSEMediumStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'Medium' risk");
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
     	js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(4000);
		int BSEMedium = Integer.parseInt(CFOcountPOM.clickBSEMedium().getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSEMedium().click();					//Clicking on High bar of Labour  
		
		Thread.sleep(3000);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.
		Thread.sleep(5000);
		if(BSEMedium == total)
		{
			test.log(LogStatus.PASS, "'Internal Audit - Medium' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Internal Audit - Medium' Compliances : "+BSEMedium+" | Sum of Medium count statuses: : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Internal Audit - Medium' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Internal Audit - Medium' Compliances : "+BSEMedium+" | Sum of Medium count statuses: : "+total);
		}
		Thread.sleep(5000);
		if(BSEMedium > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted > 0)
			{
				CFOcountPOM.BarGraphCountIn1( test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Not Applicable", NotApplicable);
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
			test.log(LogStatus.PASS, "'Internal Audit - 'Medium Count = "+BSEMedium);
			
			Thread.sleep(1000);
			WebElement element = CFOcountPOM.clickBack();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void BargraphBSELowStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'LOW' risk");
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	     js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
		
		
		Thread.sleep(4000);
		int BSELow = Integer.parseInt(CFOcountPOM.clickBSELow().getText());	//Reading the Medium value of Labour compliance
		CFOcountPOM.clickBSELow().click();					//Clicking on High bar of Labour  
		
		Thread.sleep(3000);
		int ClosedTimely = Integer.parseInt(CFOcountPOM.clickBarClosedTimely().getText());			//reading Closed Timely count.
		int ClosedDelayed = Integer.parseInt(CFOcountPOM.clickBarClosedDelayed().getText());	//reading Closed Delayed count.
		int NotCompleted = Integer.parseInt(CFOcountPOM.clickBarNotCompleted().getText());	//reading Not Completed count.
		int NotApplicable = Integer.parseInt(CFOcountPOM.clickBarNotApplicable().getText());	//reading Not Applicable count.
		
		int total = ClosedTimely + ClosedDelayed + NotCompleted + NotApplicable;				//Calculating the values to match with High value of Labour.

		if(BSELow == total)
		{
			test.log(LogStatus.PASS, "'Internal Audit - Low' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Internal Audit - Low' Compliances : "+BSELow+" | Sum of Low count statuses: : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Internal Audit - Low' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Internal Audit - Low' Compliances : "+BSELow+" | Sum of Low count statuses: : "+total);
		}
		Thread.sleep(5000);
		if(BSELow > 0)
		{
			if(ClosedTimely > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Timely", ClosedTimely);
			}
			else
			{
				test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+ClosedTimely);
			}
			
			if(ClosedDelayed > 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Closed Delayed", ClosedDelayed);
			}
			else
			{
				test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+ClosedDelayed);
			}
			if(NotCompleted >= 0)
			{
				CFOcountPOM.BarGraphCountIn1( test, "Not Completed", NotCompleted);
			}
			else
			{
				test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+NotCompleted);
			}
			if(NotApplicable >= 0)
			{
				CFOcountPOM.BarGraphCountIn( test, "Not Applicable", NotApplicable);
			}
			else
			{
				test.log(LogStatus.PASS, "'Low - Not Applicable' Count = "+NotApplicable);
			}
			
			Thread.sleep(1000);
			WebElement element = CFOcountPOM.clickBack();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Internal Audit - Low' Count = "+BSELow);
			
			Thread.sleep(1000);
			WebElement element = CFOcountPOM.clickBack();
			Actions actions = new Actions(getDriver());
			actions.moveToElement(element).click().perform();				//Clicking on Back button of Bar Graph.
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23)
	void RiskSummaryCriticalInternal() throws InterruptedException, IOException
	{
	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");				//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,600)");
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
			
			CFOcountPOM.RiskGraphCountIn1( test, "Critical - Not Completed", RiskCritical_NotCompleted, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc1 = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
		
		Thread.sleep(3000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedTimely > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc2 = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
		
		
		Thread.sleep(3000);
		int RiskCritical_DueToday = Integer.parseInt(CFOcountPOM.clickRiskCriticalDueToday().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_DueToday > 0)
		{
			CFOcountPOM.clickRiskCriticalDueToday().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount1( test, "Critical - Due Today", RiskCritical_DueToday, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Due Today' Count = "+RiskCritical_DueToday);
		}
		
		
		Thread.sleep(3000);
		int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskCriticalNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNA( test, "Critical - Not Applicable", RiskCritical_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Applicable' Count = "+RiskCritical_NotApplicable);
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
	
	
	@Test(priority =24)
	void RiskSummaryHighInternal() throws InterruptedException, IOException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");
	//	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
		String High = CFOcountPOM.RiskSummaryHigh().getText();		//Reading the Closed Timely value of Human Resource
		High = High.replaceAll(" ","");									//Removing all white spaces from string. 
		int IndustrySpeCritical = Integer.parseInt(High);
	
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
		//int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn1( test, "High - Not Completed", RiskHigh_NotCompleted, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
			
		Thread.sleep(2000);
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		Thread.sleep(2000);
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
		
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc2 = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
		
		
		Thread.sleep(3000);
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
		
		Thread.sleep(3000);
		int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskHighNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNA( test, "High - Not Applicable", RiskHigh_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+RiskHigh_NotApplicable);
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
	
   @Test(priority =25)
	void RiskSummaryMediumStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary - 'Medium' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(500);
		int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryMedium().getText());
		Thread.sleep(4000);
		int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn1( test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		Thread.sleep(2000);
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
		
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}
		Thread.sleep(2000);
		List<WebElement>roc2 = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
		
		
		Thread.sleep(3000);
		
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
		
		Thread.sleep(3000);
		int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskMediumNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNA( test, "Medium - Not Applicable", RiskMedium_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Applicable' Count = "+RiskMedium_NotApplicable);
		}
		
		Thread.sleep(8000);
		int total = RiskMedium_NotCompleted + RiskMedium_ClosedDelayed + RiskMedium_ClosedTimely + RiskMedium_NotApplicable+RiskMedium_DueToday;				//Calculating the values to match with High value of Labour.
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
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 26)
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
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryLow().getText());
		Thread.sleep(4000);
		int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotCompleted > 0)
		{
			Thread.sleep(2000);
			CFOcountPOM.clickRiskLowNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountIn1( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
					Thread.sleep(5000);
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		Thread.sleep(2000);
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
		
		Thread.sleep(3000);
		Thread.sleep(3000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCount( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
		}
		Thread.sleep(2000);
		List<WebElement>roc2 = getDriver().findElements(By.cssSelector("#highcharts-6 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text > tspan"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
		
		
		Thread.sleep(3000);
		
		
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
		
		Thread.sleep(3000);
		int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskLowNotApplicable().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNA( test, "Low - Not Applicable", RiskLow_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Applicable' Count = "+RiskLow_NotApplicable);
		}
		
		Thread.sleep(500);
		Thread.sleep(8000);
		int total = RiskLow_NotCompleted + RiskLow_ClosedDelayed + RiskLow_ClosedTimely + RiskLow_NotApplicable+RiskLow_DueToday;				//Calculating the values to match with High value of Labour.
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
	
	@Test(priority =27)
	void DepartmentSummaryInternal() throws InterruptedException, IOException
	{
		Thread.sleep(3000);	
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 1500 px.
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);
		String Admin = CFOcountPOM.AdminCount().getText();			//Reading the Overdue value of Human Resource
		Admin = Admin.replaceAll(" ","");									//Removing all white spaces from string. 
		int IndustrySpeCritical = Integer.parseInt(Admin);	
		
		Thread.sleep(4000);
		test = extent.startTest("Department Summary - 'Admin' Count Verification");
		Thread.sleep(1000);
		String FinaOverdue = CFOcountPOM.clickHumanOverduem().getText();			//Reading the Overdue value of Human Resource
		FinaOverdue = FinaOverdue.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_Overdue = Integer.parseInt(FinaOverdue);						
		if(Fina_Overdue > 0)
		{
			CFOcountPOM.clickHumanOverduem().click();
			CFOcountPOM.RiskGraphCountIn1( test, "Admin -Overdue", Fina_Overdue, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Admin - Overdue' Complaince Count = "+ Fina_Overdue + ".");
		}
		
		  WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
			
		  roc.click();
				Thread.sleep(3000);
		String financeClosedDelayed= CFOcountPOM.clickHRClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
		financeClosedDelayed = financeClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Finance_CloseDelayed= Integer.parseInt(financeClosedDelayed);						
		if(Finance_CloseDelayed > 0)
		{
			CFOcountPOM.clickHRClosedDelayed().click();
			CFOcountPOM.RiskGraphCount( test, "Admin -Closed Delayed ", Finance_CloseDelayed, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Admin -Closed Delayed' Complaince Count = "+ Finance_CloseDelayed + ".");
		}
		 WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
			
		  roc1.click();
		
		Thread.sleep(1000);
		String FinaClosedTimely = CFOcountPOM.clickHumanClosedTimelym().getText();		//Reading the Closed Timely value of Human Resource
		FinaClosedTimely = FinaClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_ClosedTimely = Integer.parseInt(FinaClosedTimely);						
		if(Fina_ClosedTimely > 0)
		{
			CFOcountPOM.clickHumanClosedTimelym().click();
			CFOcountPOM.RiskGraphCount( test, "Admin -Closed Timely", Fina_ClosedTimely, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Admin -Closed Timely' Complaince Count = "+ Fina_ClosedTimely + ".");
		}
		Thread.sleep(3000);
		WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > text > tspan"));
		CT.click();
		
		Thread.sleep(3000);
			String FinaPFReview = CFOcountPOM.clickAccountPendingReview().getText();			//Reading the Overdue value of Human Resource
		FinaPFReview = FinaPFReview.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_PFR = Integer.parseInt(FinaPFReview);						
		if(Fina_PFR > 0)
		{
			CFOcountPOM.clickAccountPendingReview().click();
			CFOcountPOM.RiskGraphCount( test, "Admin -Pending For Review", Fina_PFR, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Admin - Pending For Review' Complaince Count = "+ Fina_PFR + ".");
		}
		
		Thread.sleep(3000);
		WebElement PR = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > text > tspan"));
		PR.click();
		
		String FinaInprogress = CFOcountPOM.clickFinanceInProgressInternal().getText();			//Reading the Overdue value of Human Resource
		FinaInprogress = FinaInprogress.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_InProgress = Integer.parseInt(FinaInprogress);						
		if(Fina_InProgress > 0)
		{
			CFOcountPOM.clickFinanceInProgressInternal().click();
			CFOcountPOM.RiskGraphCount( test, "Admin -In Progress", Fina_InProgress, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Admin - In Progress ' Complaince Count = "+ Fina_InProgress + ".");
		}
		WebElement IP = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-4 > text > tspan"));
		IP.click();
		
				Thread.sleep(3000);
		String FinaRejected = CFOcountPOM.clickFinanceRejectedInternal().getText();			//Reading the Overdue value of Human Resource
		FinaRejected = FinaRejected.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_Rejected= Integer.parseInt(FinaRejected);						
		if(Fina_Rejected > 0)
		{
			CFOcountPOM.clickFinanceRejectedInternal().click();
			CFOcountPOM.RiskGraphCount( test, "Admin -Rejected", Fina_Rejected, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Admin - Rejected' Complaince Count = "+ Fina_Rejected + ".");
		}
		WebElement NA = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-5 > text > tspan"));
		NA.click();
		
		Thread.sleep(3000);
		String FinaNotAppli = CFOcountPOM.clickFinanceNotAppliInternal().getText();			//Reading the Overdue value of Human Resource
		FinaNotAppli = FinaNotAppli.replaceAll(" ","");									//Removing all white spaces from string. 
		int Fina_NotAppli= Integer.parseInt(FinaNotAppli);						
		if(Fina_NotAppli > 0)
		{
			CFOcountPOM.clickFinanceNotAppliInternal().click();
			CFOcountPOM.RiskGraphCount( test, "Admin -Not Applicable", Fina_NotAppli, "Internal");
		}
		else
		{
			test.log(LogStatus.PASS, "'Admin - Not Applicable' Complaince Count = "+ Fina_NotAppli + ".");
		}
		
		Thread.sleep(500);
		Thread.sleep(8000);
		int total = Fina_Overdue  + Fina_NotAppli + Fina_Rejected+Fina_InProgress+Fina_PFR+Fina_ClosedTimely+Finance_CloseDelayed;				//Calculating the values to match with High value of Labour.
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
	//	js.executeScript("window.scrollBy(0,-1600)");			//Clicking on Dashboard
		performer.OverduePOM.clickDashboard().click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28)
	void ClosedTimely_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - 'Closed Timely' Count Verification");
		test.log(LogStatus.INFO, "Select Start date 01-04-2021");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1500);   
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternal().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyInternal().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
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
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPec( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29)
	void ClosedDelayed_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - 'Closed Delayed' Count Verification");
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1500);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedInternal().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedInternal().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
				CFOcountPOM.GraphCountInPec( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(3000);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30)
	void NotCompleted_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - 'Not Completed' Count Verification");
		
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
	      JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		Thread.sleep(1500);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
				CFOcountPOM.GraphCountInPe1c( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1c( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(200);
				CFOcountPOM.GraphCountInPe1c( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(200);
				CFOcountPOM.GraphCountInPe1c( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count = "+NotCompletedValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void NotApplicable_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - Completion Status- 'Not Applicable' Count Verification");
		Thread.sleep(1000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1500);
		
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplInternalA().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickNotApplInternalA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
		Thread.sleep(3000);
		if(NotApplicableValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPec( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(3000);
			action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 38)
	void Upcoming_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status Status- ' Upcoming' Count Verification");
	
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		
		Thread.sleep(4000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		
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
				CFOcountPOM.GraphCountInPeUpIn( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUpIn( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUpIn( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUpIn( test, "Low", low, "Statutory");
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
			test.log(LogStatus.PASS, " 'UpComing' Compliance Count = "+rejectedValue);
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
	
	
	@Test(priority = 32)
	void Overdue_PieChartInternalPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - Not Completed Status-'Overdue' Count Verification");
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		js.executeScript("window.scrollBy(0,2500)");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdueInternal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdueInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
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
				CFOcountPOM.GraphCountInPe1c( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1c( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1c( test, "Medium", medium, "Internal");
			}
			else
			{
				
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1c( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)
	void dueToday_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - Not Completed Status-'due Today' Count Verification");
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	Thread.sleep(3000);
		
	//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		js.executeScript("window.scrollBy(0,2500)");
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(1000);
		Thread.sleep(1000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueTodayInernal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueTodayInernal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		Thread.sleep(500);
		if(dueTodayValue == total)
		{
			test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'dueToday' Compliances : "+dueTodayValue+" | Total Sum of all risk: "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'dueToday' Compliances : "+dueTodayValue+" | Total Sum of all risk: "+total);
		}
		Thread.sleep(500);
		
		if(dueTodayValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPe1c( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1c( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1c( test, "Medium", medium, "Internal");
			}
			else
			{
				
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPe1c( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		else
		{
			test.log(LogStatus.PASS, "'due Today' Compliance Count = "+dueTodayValue);
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(500);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 34)
	void PFR_PieChartInternalPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
	
		Thread.sleep(3000);
		
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
	//	js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		Thread.sleep(1000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIN().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIN().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
		Thread.sleep(500);
		if(pendingForReviewValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPec( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Pending For Review' Compliance Count = "+pendingForReviewValue);
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35)
	void InProgress_PieChartInternalPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - Not Completed Status - 'in Progress' Count Verification");
		
		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(), 40);
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

	//	ApprovalcountPOM.clickManagement().click();
		Thread.sleep(5000);
		
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
	//	WebDriverWait wait = new WebDriverWait( getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		Thread.sleep(1000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickinProgress().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		Thread.sleep(5000);
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' in Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'in Progress' Compliances : "+pendingForReviewValue+" | Total Sum of all risks : "+total);

		}
		else
		{
			test.log(LogStatus.FAIL, "'in Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'in Progress' Compliances : "+pendingForReviewValue+" | Total Sum of all risks : "+total);
		}
		Thread.sleep(3000);
		if(pendingForReviewValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPec( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'in Progress' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	

@Test(priority = 37)
	void Rejected_PieChartInternalPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - Not Completed Status- 'Rejected' Count Verification");
		
		Thread.sleep(500);
		Thread.sleep(3000);
	
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
		Thread.sleep(500);
		Thread.sleep(1000);
		AuditorcountPOM.DateText().click();	
		Thread.sleep(1000);
		AuditorcountPOM.DateYear().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Year().click();	
		Thread.sleep(3000);
		AuditorcountPOM.DateMonth().click();	
		Thread.sleep(1000);
		AuditorcountPOM.Month().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Date().click();	
		Thread.sleep(3000);
		AuditorcountPOM.Apply().click();	
		Thread.sleep(5000);
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
			test.log(LogStatus.PASS, "Total 'Rejected' Compliances : "+rejectedValue+" | Total Sum of all risks : "+rejectedValue);

		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+rejectedValue+" | Total Sum of all risks : "+rejectedValue);
		}
		if(rejectedValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPec( test, "Critical", critical, "Internal");
				//GraphCountInPeUpIn
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPec( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(2000);
		
		}
		else
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(500);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 59) 
	void DetailedReportIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Internal Count Verification");
		
		
		CFOcountPOM.DetailedReportIn(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 61)
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report verification");
	
		
		CFOcountPOM.AssignmentReportIn(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 76)
	void ComplianceDocumentsIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents-Internal  verification");
		
		
		CFOcountPOM.complianceDocumentIn(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 78)
	void NCcompletionVsNCOverdueIn() throws InterruptedException {
		test=extent.startTest("Performer Summary Completion Status(Not Completed) and Not Completed Status graph count Verification");
		CFOcountPOM.NCcompletionVsNCOverdueIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority = 79)
	void DetailedreportVsdashboardNotCompletedcountIn() throws InterruptedException {
		test=extent.startTest("Performer Summary Completion Status(Not Completed) dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsdashboardNotCompletedcountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority = 80)
		void DetailedreportVsdashboardclosedtimelycountIn() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status - Closed Timely dashboard count match with Detailed Report Count Verification");
			CFOcountPOM.DetailedreportVsdashboardclosedtimelycountIn(test);
	        extent.endTest(test);
	        extent.flush();
	    }
		
		@Test(priority = 81)
		void DetailedreportVsdashboardCloseddealyedcountIn() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status - Closed Delayed dashboard count match with Detailed Report Count Verification");
			CFOcountPOM.DetailedreportVsdashboardCloseddealyedcountIn(test);
	        extent.endTest(test);
	        extent.flush();
	    }
		
		@Test(priority = 82)
		void DetailedreportVsdashboardNAcountIn() throws InterruptedException {
			test=extent.startTest("Performer Summary Completion Status - Not Applicable dashboard count match with Detailed Report Count Verification");
			CFOcountPOM.DetailedreportVsdashboardNAcountIn(test);
	        extent.endTest(test);
	        extent.flush();
	    }
	
	
	@Test(priority = 83)
	void DetailedreportVsOverduecountIn() throws InterruptedException {
		test=extent.startTest("Performer Summary Not Completed Status - Overdue dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsOverduecountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority = 84)
	void DetailedreportVsDueTodaycountIn() throws InterruptedException {
		test=extent.startTest("Performer Summary Not Completed Status - DueToday dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsDueTodaycountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority = 85)
	void DetailedreportVsPFRcountIn() throws InterruptedException {
		test=extent.startTest("Performer Summary Not Completed Status - Pending For Review dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsPFRcountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority = 86)
	void DetailedreportVsINprocountIn() throws InterruptedException {
		test=extent.startTest("Performer Summary Not Completed Status - In Progress dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsINprocountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority = 87)
	void DetailedreportVsRejectedcountIn() throws InterruptedException {
		test=extent.startTest("Performer Summary Not Completed Status -Rejected dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsRejectedcountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	
	@Test(priority =88) 
	void DetailedreportVsCommercialCriticalcountIn() throws InterruptedException {
		test=extent.startTest("Completion Status - Overall Functions - Internal Audit - Critial dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsCommercialCriticalcountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority =89) 
	void DetailedreportVsCommercialHighcountIn() throws InterruptedException {
		test=extent.startTest("Completion Status - Overall Functions - Internal Audit - High dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsCommercialHighcountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority =90) 
	void DetailedreportVsCommercialMediumcountIn() throws InterruptedException {
		test=extent.startTest("Completion Status - Overall Functions - Internal Audit - Medium dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsCommercialMediumcountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	@Test(priority =91) 
	void DetailedreportVsCommercialLowcountIn() throws InterruptedException {
		test=extent.startTest("Completion Status - Overall Functions - Internal Audit - Low dashboard count match with Detailed Report Count Verification");
		CFOcountPOM.DetailedreportVsCommercialLowcountIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	 @Test(priority = 92)
	void riskSummaryCriticalNotCompletedIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk summary Not Completed dashboard count match with Detailed Report Count Verification");
		AuditorcountPOM.riskSummaryCriticalNotCompletedIn( test, "Critical");
		
		extent.endTest(test);
		extent.flush();
    	
	}
	 
	 @Test(priority = 93)
		void riskSummaryClosedDelayedIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk summary Closed Delayed dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.riskSummaryClosedDelayedIn( test, "Critical");
			extent.endTest(test);
			extent.flush();
	    	
		}
	 
	@Test(priority = 94)
		void riskSummaryClosedTimely() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk summary Closed Timely dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.riskSummaryClosedTimelyIn( test, "Critical");
			extent.endTest(test);
			extent.flush();
	    	
		}
		
		// @Test(priority = 95)
		void riskSummaryNotApplicable() throws InterruptedException, IOException
		{
			test = extent.startTest("Risk summary Not Applicable dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.riskSummaryNotApplicableIn( test, "Critical");
			extent.endTest(test);
			extent.flush();
	    	
		}
	
	 @Test(priority = 96)
	void DepartmentSummaryOverdueIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Overdue dashboard count match with Detailed Report Count Verification");
		AuditorcountPOM.DepartmentSummaryOverdueIn( test, "Critical");
		extent.endTest(test);
		extent.flush();
    	
	}
	
	@Test(priority = 97)
		void DepartmentSummaryClosedDelayedIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Closed Delayed dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DepartmentSummaryClosedDelayedIn( test, "Critical");
			extent.endTest(test);
			extent.flush();
	    	
		}
	
	 @Test(priority = 98)
	void DepartmentSummaryClosedTIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Closed Timely dashboard count match with Detailed Report Count Verification");
		AuditorcountPOM.DepartmentSummaryClosedTIn( test, "Critical");
		extent.endTest(test);
		extent.flush();
    	
	}
	
	@Test(priority = 99)
		void DepartmentSummaPRIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Pending Review dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DepartmentSummaPRIn( test, "Critical");
			extent.endTest(test);
			extent.flush();
	    	
		}
	
	// @Test(priority = 100)
	void DepaINPROGRESSR() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary In Progress dashboard count match with Detailed Report Count Verification");
		AuditorcountPOM.DepaINPROGRESSRIn( test, "Critical");
		extent.endTest(test);
		extent.flush();
    	
	}
	
	 @Test(priority = 101)
		void DepartmentSummaryRejectedIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Rejected dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DepaRejectedRIn( test, "Critical");
			extent.endTest(test);
			extent.flush();
	    	
		}
	
//	@Test(priority = 102)
		void DepartmentSummaryNotApplicableIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Department Summary Not Applicable dashboard count match with Detailed Report Count Verification");
			AuditorcountPOM.DepaNotApplicIn( test, "Critical");
			extent.endTest(test);
			extent.flush();
	    	
		}
	
	 @Test(priority = 103)
	void NCcompletionVsNCOverduePIn() throws InterruptedException {
		test=extent.startTest("Performer Summary(Due for the period) Completion Status(Not Completed) and Not Completed Status graph count Verification");
		CFOcountPOM.NCcompletionVsNCOverduePIn(test);
        extent.endTest(test);
        extent.flush();
    }
	
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
//		extent.flush();
//		extent.endTest(test);
		
		closeBrowser();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		//extent.close();
  	}	 

}
