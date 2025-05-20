package departmentHead;

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
import cfo.MgmtAMethod;
import login.BasePage;
import performer.MethodsPOM;

public class DeptStatutory extends BasePage {
	
	
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
	
	public static String link = "mgmt1";           //Check link in excel sheet first.
			
		
	/*
	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(7);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack\\Regtrack-Project\\Reports\\Department.html",true);
		test = extent.startTest("Loging In - Department Head (Statutory)");
		test.log(LogStatus.PASS, "Logging into system");
		
	
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
	
		initialization(link,7,"Statutory");
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
	
		Row row1 = sheet.getRow(4);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		*/
	}
	
	public static void progress1()
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
	
	
	/*@Test(priority = 1)
	void Entities() throws InterruptedException, IOException
	{
		test = extent.startTest("Entities");
		
		ApprovalcountPOM.Entities( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2)
	void LocationCount() throws InterruptedException, IOException
	{
		test = extent.startTest("Location");
		
		ApprovalcountPOM.LocationCount( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void DepartmentCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Department'");
		
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(5000);
		
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD1().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD1().getText();	//Reading total items String value
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
		
		Thread.sleep(4000);
		
		CFOcountPOM.closeCategories().click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void CompliancesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Compliances'");
		
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Compliances =CFOcountPOM.readCompliances().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.readCompliances().click();
		Thread.sleep(2000);
		
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
	
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			//test.log(LogStatus.PASS, "Number of Compliances grid matches to Dashboard Compliances  Count.");
			test.log(LogStatus.PASS, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.FAIL, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
	//	js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		getDriver().switchTo().defaultContent();
		Thread.sleep(4000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 6)
	void CompliancesCount() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance count changes after selection of filter.");
		
		ApprovalcountPOM.CompliancesCountChanges(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	
 @Test(priority = 7)
	void UsersCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Users'");
		
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_User =CFOcountPOM.clickUsersCount().getText();		//Storing old value of Statutory overdue.
	int	UserCountDas = Integer.parseInt(string_User);
		CFOcountPOM.clickUsersCount().click();
		Thread.sleep(2000);
		
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
		//	test.log(LogStatus.PASS, "Number of User grid matches to Dashboard User  Count.");
			test.log(LogStatus.PASS, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of User does not matches to Dashboard User  Count.");
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
	}*/
	
//	@Test(priority = 8)
	void clickPenaltyStatutory() throws InterruptedException
	{
		test = extent.startTest("'Penalty' ");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		Thread.sleep(2000);
	//	String oldStr = CFOcountPOM.readPenaltyCount().getText();
	//	String newStr = oldStr.replaceAll(",","");		//Removing comma () from the read input.
	//	int valuePenalty = Integer.parseInt(newStr);	//Storing old value of 'Compliances'.
		
		CFOcountPOM.readPenaltyCount().click();					//Clicking on 'Penalty'.
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Penalty - Excel file Export Successfully");
		CFOcountPOM.clickLocationPe().click();
		Thread.sleep(2000);
		CFOcountPOM.Location().click();
		 Thread.sleep(2000);
		 CFOcountPOM.LocationDD().click();
		 Thread.sleep(2000);
		 CFOcountPOM.Location().click();
	//	CFOcountPOM.Location().click();
	//	 Thread.sleep(2000);
	//	 CFOcountPOM.LocationDD().click();
	//	 Thread.sleep(2000);
		/*Thread.sleep(1000);
		CFOcountPOM.clickExpand1().click();
		Thread.sleep(1000);
		CFOcountPOM.clickABita().click();*/
		Thread.sleep(1000);
		CFOcountPOM.clickClear().click();
		test.log(LogStatus.PASS, " Penalty - Clear Button Working  Successfully");
		Thread.sleep(1000);
		CFOcountPOM.clickInterest().click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));	//Wait until frame get visible and switch to it.

		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "Interest - Excel File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		Thread.sleep(500);
		Thread.sleep(1000);
	//	CFOcountPOM.clickLocationInterest().click();
	//	Thread.sleep(2000);
		 CFOcountPOM.Location().click();
		 Thread.sleep(2000);
		 CFOcountPOM.LocationDD().click();
		 Thread.sleep(2000);
	//	 CFOcountPOM.Location().click();
	//	 Thread.sleep(2000);
	//	CFOcountPOM.clickExpand2().click();
	//	Thread.sleep(1000);
	//	CFOcountPOM.clickBita().click();
		//Thread.sleep(2000);
		if(CFOcountPOM.clickClear().isEnabled()) {
		CFOcountPOM.clickClear().click();
		test.log(LogStatus.PASS, " Interest - Clear Button Working  Successfully");
		Thread.sleep(1000);
		}
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		
		Thread.sleep(3000);
		
		//CFOcountPOM.CountPenalty( test, valuePenalty);
		
		extent.endTest(test);
		extent.flush();
	}

	//	@Test(priority = 9)
		void PenaltyMultipleFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check Whether On  Penalty box Popup selection wise filter working or not.");
			
			CFOcountPOM.PenaltyMultipleFilter(test);
			
			extent.endTest(test);
			extent.flush();
		}

		//	@Test(priority = 10)
		void PenaltyMultipleFilterInterest() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check Whether On  Penalty- Interest box Popup selection wise filter working or not.");
			
			CFOcountPOM.PenaltyMultipleFilterInterest(test);
			
			extent.endTest(test);
			extent.flush();
		}

		
	
	
		//@Test(priority = 11)
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		if(CFOcountPOM.ClickShowAll().isEnabled()) {
			CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		
		Thread.sleep(3000);
	//	litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait( getDriver(), (100));
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(55000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(4000); 
					
		 CFOcountPOM.clickExportImage1().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(4000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td/a[1]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButtons = getDriver().findElements(locator);							
			ViewButtons.get(1).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			getDriver().switchTo().defaultContent();
			
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
	
	//	@Test(priority = 12)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
	
		
		Thread.sleep(2000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");			//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCount( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount( test, "Low", low, "Statutory");
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
	
		@Test(priority = 13)
	void ClosedDelayed_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(4000);
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountSta( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
	
	  @Test(priority = 14)
	void ClosedTimely_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
	
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimely().click();								//CLicking on 'Not Completed' count
		
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountSta( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
	@Test(priority = 15)
	void NotApplicable_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicable().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedTimelyValue == total)
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
		if(ClosedTimelyValue > 0)
		{
			if(critical > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountSta( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
	@Test(priority = 16)
	void IsSMETAColumnNotcom() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status - Not Completed status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'After Due Date'
		Thread.sleep(500);	
		CFOcountPOM.clickNotCompleted().click();
       Thread.sleep(500);	
       if(NotApplicableValue > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumn(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumn(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count = " + NotApplicableValue);
		}
       extent.endTest(test);
		extent.flush();
       
	}
		
	@Test(priority = 17)
	void IsSMETAColumnclosedDel() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status - Closed Delayed status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
        int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayed().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayed().click();
       Thread.sleep(500);	
       if(ClosedDelayedValue > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumn(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumn(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = " + ClosedDelayedValue);
		}	
       extent.endTest(test);
		extent.flush();
       
	}

	@Test(priority = 18)
	void IsSMETAColumnclosedTime() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status - Closed Timely status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimely().click();
       Thread.sleep(500);	
       if(ClosedTimelyValue > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumn(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumn(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = " + ClosedTimelyValue);
		}	
       extent.endTest(test);
		extent.flush();
       
	}
	
	@Test(priority = 19)
	void IsSMETAColumnNotApp() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status - Not Applicable status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		int NotAppliValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicable().click();	
       Thread.sleep(500);	
       if(NotAppliValue > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumn(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumn(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = " + NotAppliValue);
		}	
       extent.endTest(test);
		extent.flush();
       
	}
		@Test(priority = 20)
	void Overdue_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		Thread.sleep(2000);
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");			//Scrolling down window by 1000 px.
		
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
				DeptCountPOM.GraphCount( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount( test, "Low", low, "Statutory");
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
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 21)
		void IsSMETAColumnoverdue() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Not Completion Status - Overdue status - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
			Thread.sleep(3000);
			int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
			CFOcountPOM.clickOverdue().click();	
	       Thread.sleep(500);	
	       if(OverdueValue > 0)
	       {
	        Thread.sleep(500);
	       	MethodsPOM.IsSmetaColumn(test,"Critical");	
	   		Thread.sleep(3000);
	   		MethodsPOM.IsSmetaColumn(test,"High");	
	   		Thread.sleep(3000);	
	   		MethodsPOM.IsSmetaColumn(test,"Medium");
	   		Thread.sleep(3000);	
	   		MethodsPOM.IsSmetaColumn(test,"Low");
	   		Thread.sleep(3000);	
	       }
	       else
			{
				test.log(LogStatus.PASS, "'Overdue' Compliance Count = " + OverdueValue);
			}	
	       extent.endTest(test);
			extent.flush();
	       
		}

		@Test(priority = 22)
	void pendingForReview_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		
		
		Thread.sleep(3000);
		Thread.sleep(2000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewDept().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewDept().click();									//CLicking on 'Not Completed' count
		
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountSta( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Low", low, "Statutory");
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
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
		
		
		@Test(priority = 23)
		void IsSMETAColumnPFR() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Not Completion Status - Pending For Review status - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
			Thread.sleep(3000);
			int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewDept().getText());	//Reading value of 'Not Completed'
			CFOcountPOM.clickpendingForReviewDept().click();
	       Thread.sleep(500);	
	       if(pendingForReviewValue > 0)
	       {
	        Thread.sleep(500);
	       	MethodsPOM.IsSmetaColumn(test,"Critical");	
	   		Thread.sleep(3000);
	   		MethodsPOM.IsSmetaColumn(test,"High");	
	   		Thread.sleep(3000);	
	   		MethodsPOM.IsSmetaColumn(test,"Medium");
	   		Thread.sleep(3000);	
	   		MethodsPOM.IsSmetaColumn(test,"Low");
	   		Thread.sleep(3000);	
	       }
	       else
			{
				test.log(LogStatus.PASS, "'Pending For Review' Compliance Count = " + pendingForReviewValue);
			}	
	       extent.endTest(test);
			extent.flush();
	       
		}

	
		@Test(priority = 24)
	void inProgress_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'In Progress' Count Verification");
		
		
		Thread.sleep(500);
		Thread.sleep(2000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickInProgressDept().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickInProgressDept().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
				DeptCountPOM.GraphCountSta( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountSta( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Low", low, "Statutory");
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
			test.log(LogStatus.PASS, " 'In Progress' Compliance Count = "+inProgressValue);
			
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
	void IsSMETAColumnInProg() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Not Completion Status - In Progress status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickInProgressDept().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickInProgressDept().click();	
       Thread.sleep(500);	
       if(inProgressValue > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumn(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumn(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumn(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'In Progress' Compliance Count = " + inProgressValue);
		}	
       extent.endTest(test);
		extent.flush();
       
	}

	
		@Test(priority = 26)
	void rejected_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Rejected' Count Verification");
		
		
		Thread.sleep(500);
		Thread.sleep(2000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(4000);
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickRejectedDept().getText());	//Reading value of 'Not Completed'
		Thread.sleep(3000);
		CFOcountPOM.clickRejectedDept().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(inProgressValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+inProgressValue);
		}
	*/
		if(inProgressValue > 0)
		{
			if(critical > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountSta( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountSta( test, "Low", low, "Statutory");
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
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+inProgressValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
		
		@Test(priority = 27)
		void IsSMETAColumnRejected() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Not Completion Status - Rejected status - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 1000 px.
			Thread.sleep(3000);
			int inProgressValue = Integer.parseInt(CFOcountPOM.clickInProgressDept().getText());	//Reading value of 'Not Completed'
			CFOcountPOM.clickInProgressDept().click();	
	       Thread.sleep(500);	
	       if(inProgressValue > 0)
	       {
	        Thread.sleep(500);
	       	MethodsPOM.IsSmetaColumn(test,"Critical");	
	   		Thread.sleep(3000);
	   		MethodsPOM.IsSmetaColumn(test,"High");	
	   		Thread.sleep(3000);	
	   		MethodsPOM.IsSmetaColumn(test,"Medium");
	   		Thread.sleep(3000);	
	   		MethodsPOM.IsSmetaColumn(test,"Low");
	   		Thread.sleep(3000);	
	       }
	       else
			{
				test.log(LogStatus.PASS, "'Rejected' Compliance Count = " + inProgressValue);
			}	
	       extent.endTest(test);
			extent.flush();
	       
		}

	
	@Test(priority = 28)
	void CompletionStatusFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the filters of Location,period,FY,Risk,User,Start Date,End Date,Act,Category,Compliance Id,Status,License Type,Mitigation plan are working on the graph of \"Performance Summary Graph for Completion Status - Critical Risk or not?");
	
				ApprovalcountPOM.DepCompletionStatusFilter(test );
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29)
	void NotCompletionStatusFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("o check whether the filters of Location,period,FY,Risk,User,Start Date,End Date,Act,Category,Compliance Id,Status,License Type,Mitigation plan are working on the graph of \"Performance Summary Graph for Not Completed Status  -  Critical Risk or not?");
	
				ApprovalcountPOM.DepNotCompletionStatusFilter(test );
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30)
	void DepartmentSummaryFinanceStatutory() throws InterruptedException
	{
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(4000);
		Thread.sleep(500);		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1300)");					//Scrolling down window by 1500 px.
		
		test = extent.startTest("Department Summary - 'Admin' Count Verification");
		
		Thread.sleep(4000);
		
		String NotCompleted = CFOcountPOM.clickFinanceOverdueDept().getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);						
		if(Overdue > 0)
		{
			CFOcountPOM.clickFinanceOverdueDept().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount1( test, "Overdue", Overdue, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Overdue Compliance Count = "+ Overdue + ".");
		}
		Thread.sleep(2900);
		
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		
		  roc.click();
		Thread.sleep(4000);
		String ClosedDelayed = CFOcountPOM.clickClosedDelayedDept().getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);	

		if(Closed_Delayed > 0)
		{
			CFOcountPOM.clickClosedDelayedDept().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Closed Delayed", Closed_Delayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Closed Delayed Compliance Count = "+ Closed_Delayed + ".");
		}
		
	
		Thread.sleep(3000);
	
		String ClosedTimely = CFOcountPOM.clickClosedTimelyDpt().getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);						
		if(Closed_Timely > 0)
		{
			CFOcountPOM.clickClosedTimelyDpt().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Closed Timely", Closed_Timely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Closed Timely Compliance Count = "+ Closed_Timely + ".");
		}
		
		
		Thread.sleep(2000);
		
		Thread.sleep(500);
		String PendingReview = CFOcountPOM.clickPendingReviewDept().getText();	//Reading the Pending For Review value of Human Resource
	//	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);						
		if(Pending_Review > 0)
		{
			CFOcountPOM.clickPendingReviewDept().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCountDept( test, "Pending For Review", Pending_Review, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Pending For Review Compliance Count = "+ Pending_Review + ".");
		}
		
		
		Thread.sleep(3000);
		String InProgress = CFOcountPOM.ClickInProgress().getText();	//Reading the Pending For Review value of Human Resource
	//	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int In_Progress = Integer.parseInt(InProgress);						
		if(In_Progress > 0)
		{
			CFOcountPOM.ClickInProgress().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCountDept( test, "In Progress", In_Progress, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "In Progress Compliance Count = "+ In_Progress + ".");
		}

		Thread.sleep(3000);
		
		String Rejected = CFOcountPOM.ClickRejected().getText();	//Reading the Pending For Review value of Human Resource
	//	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Rejected_d = Integer.parseInt(Rejected);						
		if(Rejected_d > 0)
		{
			CFOcountPOM.ClickRejected().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCountDept( test, "Rejected", Rejected_d, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Rejected Compliance Count = "+ Rejected_d + ".");
		}

		
			Thread.sleep(3000);
			
			String NotApplicable = CFOcountPOM.clickHumanNotApplicable().getText();	//Reading the Pending For Review value of Human Resource
			NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
			int Not_Applicable = Integer.parseInt(NotApplicable);						
			if(Not_Applicable > 0)
			{
				CFOcountPOM.clickHumanNotApplicable().click();
				DeptCountPOM.RiskGraphCountDept( test, "Not Applicable", Not_Applicable, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Not Applicable Compliance Count = "+ Not_Applicable + ".");
			}
	
		
		Thread.sleep(2000);
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void IsSMETAColumnDeptSumm() throws InterruptedException, IOException
	{
        Thread.sleep(2000);
		
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		test = extent.startTest("Bar Graph - Department Summary - - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1300)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickFinanceOverdueDept().getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);	
       Thread.sleep(500);	
       if(Overdue > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnDept(test,"Overdue");	
   		Thread.sleep(3000);
   		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		roc.click();
		Thread.sleep(2000);
   		MethodsPOM.IsSmetaColumnDept(test,"Closed Delayed");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnDept(test,"Closed Timely");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnDept(test,"Pending For Review");
   		Thread.sleep(3000);
   		WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > rect"));
		roc1.click();
		Thread.sleep(1000);
   		MethodsPOM.IsSmetaColumnDept(test,"In Progress");
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumnDept(test,"Rejected");
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumnDept(test,"Not Applicable");
   		Thread.sleep(3000);
   		
       }
       else
		{
			test.log(LogStatus.PASS, "'Department Summary' Compliance Count = " + Overdue);
		}	
       extent.endTest(test);
		extent.flush();
       
	}

	
	@Test(priority = 32)
	void DeptSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the filters of Location,period,FY,Risk,User,Start Date,End Date,Act,Category,Compliance Id,Lable,Status,Department,License Type,Mitigation plan are working on the graph of Department Summary - Overdue Status or not?");
	
				ApprovalcountPOM.DeptSummaryFilterDept(test );
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 33)
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
		js.executeScript("window.scrollBy(0,1700)");					//Scrolling down window by 1000 px.cfo
	
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		
		
		Thread.sleep(4000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
	//	int RiskCritical_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotCompleted > 0)
		{
			CFOcountPOM.clickRiskCriticalNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount1( test, "Critical - Not Completed", RiskCritical_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
		}
		
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedTimely > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}
		
		Thread.sleep(3000);
		int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskCriticalNotApplicableDE().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNA( test, "Critical - Not Applicable", RiskCritical_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Applicable' Count = "+RiskCritical_NotApplicable);
		}
		
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	

	
		@Test(priority = 34)
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
		js.executeScript("window.scrollBy(0,1700)");
		//js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			ApprovalcountPOM.RiskGraphCount1S( test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		
		Thread.sleep(2000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(500);
			ApprovalcountPOM.RiskGraphCountS( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(500);
			ApprovalcountPOM.RiskGraphCountS( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		
		Thread.sleep(3000);
		int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskHighNotApplicableDE().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNAC( test, "High - Not Applicable", RiskHigh_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+RiskHigh_NotApplicable);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 35)
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
		js.executeScript("window.scrollBy(0,1900)");		
		Thread.sleep(1000);
		String NotCompleted = CFOcountPOM.clickRiskMediumNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskMedium_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			ApprovalcountPOM.RiskGraphCount1S( test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
	
		
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		Thread.sleep(500);
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCountS( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
		Thread.sleep(500);
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCountS( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}
		
		Thread.sleep(3000);
		int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskMediumNotApplicableDE().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNAC( test, "Medium - Not Applicable", RiskMedium_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Applicable' Count = "+RiskMedium_NotApplicable);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36)
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
		js.executeScript("window.scrollBy(0,1700)");
		Thread.sleep(4000);
		String NotCompleted = CFOcountPOM.clickRiskLowNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskLow_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount1S( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc =getDriver() .findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCountS( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCountS( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
		}
		
		Thread.sleep(3000);
		int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotApplicable > 0)
		{
			CFOcountPOM.clickRiskLowNotApplicableDE().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			CFOcountPOM.RiskGraphCountNAC( test, "Low - Not Applicable", RiskLow_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Applicable' Count = "+RiskLow_NotApplicable);
		}
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void RiskSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the filters of Location,period,FY,Risk,User,Start Date,End Date,Act,Category,Compliance Id,Status,License Type,Mitigation plan are working on the graph of Risk Summary - Critical Risk or not?");
	
				ApprovalcountPOM.RiskSummaryFilterDep(test );
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38)
	void IsSMETAColumnNotComp() throws InterruptedException, IOException
	{
		test = extent.startTest(" Risk Summary Graph - Not Completed status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);	
       Thread.sleep(500);	
       if(RiskCritical_NotCompleted > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnRiskSummNotComp(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumnRiskSummNotComp(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskSummNotComp(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskSummNotComp(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count = " + RiskCritical_NotCompleted);
		}	
       extent.endTest(test);
		extent.flush();
       
	}

	@Test(priority = 39)
	void IsSMETAColumnClosedDel() throws InterruptedException, IOException
	{
		test = extent.startTest(" Risk Summary Graph - Closed Delayed status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		List<WebElement>roc =getDriver() .findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(500);
		String NotCompleted = CFOcountPOM.clickRiskCriticalClosedDelayedDpt().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);	
       Thread.sleep(500);	
       if(RiskCritical_NotCompleted > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnRiskSummCloDel(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumnRiskSummCloDel(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskSummCloDel(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskSummCloDel(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = " + RiskCritical_NotCompleted);
		}	
       extent.endTest(test);
		extent.flush();
       
	}

	@Test(priority = 40)
	void IsSMETAColumnClosedTimely() throws InterruptedException, IOException
	{
		test = extent.startTest(" Risk Summary Graph - Closed Timely status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		List<WebElement>roc =getDriver() .findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(500);
		String NotCompleted = CFOcountPOM.clickRiskCriticalClosedTimelyDpt().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);	
       Thread.sleep(500);	
       if(RiskCritical_NotCompleted > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnRiskSummCloTimely(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumnRiskSummCloTimely(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskSummCloTimely(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskSummCloTimely(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = " + RiskCritical_NotCompleted);
		}	
       extent.endTest(test);
		extent.flush();
       
	}

	@Test(priority = 41)
	void IsSMETAColumnNotAppli() throws InterruptedException, IOException
	{
		test = extent.startTest(" Risk Summary Graph - Not Applicable status - Is SMETA Column Count Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(),(120));
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");					//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		List<WebElement>roc =getDriver() .findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(500);
		
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotApplicableDE().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);	
       Thread.sleep(500);	
       if(RiskCritical_NotCompleted > 0)
       {
        Thread.sleep(500);
       	MethodsPOM.IsSmetaColumnRiskNotAppli(test,"Critical");	
   		Thread.sleep(3000);
   		MethodsPOM.IsSmetaColumnRiskNotAppli(test,"High");	
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskNotAppli(test,"Medium");
   		Thread.sleep(3000);	
   		MethodsPOM.IsSmetaColumnRiskNotAppli(test,"Low");
   		Thread.sleep(3000);	
       }
       else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = " + RiskCritical_NotCompleted);
		}	
       extent.endTest(test);
		extent.flush();
       
	}

	
	@Test(priority = 42)
		void NotCompleted_PieChartPeriod() throws InterruptedException
		{
			//test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
			Thread.sleep(2000);
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
		//	js.executeScript("window.scrollBy(0,100)");
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);
			
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
	
			Thread.sleep(5000);
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
			}*/
		
			if(NotCompletedValue > 0)
			{
				if(critical >= 0)
				{
					DeptCountPOM.GraphCountInPe1( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe1( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe1( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe1( test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(1000);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
			}
			else
			{
				test.log(LogStatus.PASS, " 'Not Completed' Compliance Count = "+NotCompletedValue);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(500);
			}
			
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 43)
		void ClosedDelayed_PieChartPeriod() throws InterruptedException
		{
		//	test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);

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
	
			Thread.sleep(5000);
			
			int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedA().getText());	//Reading value of 'After Due Date'
			CFOcountPOM.clickClosedDelayedA().click();								//CLicking on 'Not Completed' count
			
			Thread.sleep(500);
			int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
			int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
			int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
			int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
			
			int total = critical + high + medium + low;
			/*
			if(ClosedTimelyValue == total)
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
				test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
				test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
			}
			*/
			if(ClosedTimelyValue > 0)
			{
				if(critical >= 0)
				{
					DeptCountPOM.GraphCountInPeSta( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >=0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(1000);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(1000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedTimelyValue);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			}
			extent.endTest(test);
			extent.flush();
			
		}
		
		@Test(priority = 44)
		void ClosedTimely_PieChartPeriod() throws InterruptedException
		{
			//test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);

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
				if(critical >= 0)
				{
					DeptCountPOM.GraphCountInPeSta( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(1000);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(1000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			}
			extent.endTest(test);
			extent.flush();
			
		}
		
		@Test(priority = 45)
		void NotApplicable_PieChartPeriod() throws InterruptedException
		{
			//test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
			
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);
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

			
			int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
			CFOcountPOM.clickNotApplicable().click();								//CLicking on 'Not Completed' count
			
			Thread.sleep(500);
			int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
			int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
			int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
			int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
			
			int total = critical + high + medium + low;
			/*
			if(ClosedTimelyValue == total)
			{
				test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
				test.log(LogStatus.INFO, "Total 'Closed Timely' Compliances : "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
				test.log(LogStatus.INFO, "Total 'Closed Timely' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
			}
			*/
			if(ClosedTimelyValue > 0)
			{
				if(critical >= 0)
				{
					DeptCountPOM.GraphCountInPeSta( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPeSta( test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				getDriver().switchTo().parentFrame();
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+ClosedTimelyValue);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			}
			extent.endTest(test);
			extent.flush();
			
		}
		
		@Test(priority = 46)
			void Upcoming_PieChartPeriod() throws InterruptedException
			{
			//	test = extent.startTest("Period-Pie Chart - Completed Status- ' Upcoming' Count Verification");
			
				Thread.sleep(2000);
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2600)");			//Scrolling down window by 1000 px.
				Thread.sleep(800);
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(4000);
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
				WebElement roc=getDriver() .findElement(By.xpath("(//*[@class='highcharts-legend-item highcharts-pie-series highcharts-color-4 '])"));
			
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
		
		@Test(priority = 47)
		void DueforperiodIsSMETAColumn() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Not Completed - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
		
		@Test(priority = 48)
		void periodIsSMETAColumnCloseddelayed() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Closed Delayed - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
	    
		@Test(priority = 49)
		void periodIsSMETAColumnTimely() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Closed Timely - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
		
		@Test(priority =50)
		void periodIsSMETAColumnNotApplicable() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Not Applicable - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
		
		@Test(priority =51)
		void periodIsSMETAColumnUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Upcoming - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
		
		
		
		@Test(priority = 52)
			void Overdue_PieChartPeriod() throws InterruptedException
			{
				//test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
				
				
				Thread.sleep(500);
				Actions action = new Actions(getDriver());
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				Thread.sleep(2000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
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
		
				Thread.sleep(1500);
				int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
				CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
				
				Thread.sleep(1000);
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
				}*/
			
				if(OverdueValue > 0)
				{
					if(critical >= 0)
					{
						DeptCountPOM.GraphCountInPe1( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe1( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe1( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe1( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
				//	Thread.sleep(5000);
				//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(3000);
			
				}
				else
				{
					test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
					
					Thread.sleep(500);
					action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			
				}
				
				extent.endTest(test);
				extent.flush();
			}
			
		@Test(priority =53)
		void periodIsSMETAColumnOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Overdue - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
		
		@Test(priority = 54)
			void dueToday_PieChartPeriod() throws InterruptedException
			{
				//test = extent.startTest("Period-Pie Chart -Not Completed Status- 'dueToday' Count Verification");
				
				
				Thread.sleep(3000);
			
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
				Thread.sleep(800);
				WebDriverWait wait = new WebDriverWait( getDriver(),(30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);

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
		
				Thread.sleep(1500);
				int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());	//Reading value of 'Not Completed'
				CFOcountPOM.clickdueToday().click();									//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
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
					if(critical >= 0)
					{
						DeptCountPOM.GraphCountInPe1( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe1( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe1( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe1( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
					//Thread.sleep(5000);
				//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(2000);
				}
				else
				{
					Thread.sleep(2000);
					test.log(LogStatus.PASS, " 'Due Today' Compliance Count = "+dueTodayValue);
					getDriver().switchTo().defaultContent();
					Thread.sleep(2000);
				//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			
				}
				
				extent.endTest(test);
				extent.flush();
			}
		
		@Test(priority =55)
		void periodIsSMETAColumnDuetoday() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - DueToday - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
			
		@Test(priority = 56)
			void pendingForReview_PieChartPeriod() throws InterruptedException
			{
				//test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
			
				
				Thread.sleep(3000);
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
				Thread.sleep(800);
				WebDriverWait wait = new WebDriverWait( getDriver(),(30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
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
		
				Thread.sleep(1500);
				
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
				}*/
			
				if(pendingForReviewValue > 0)
				{
					if(critical >= 0)
					{
						DeptCountPOM.GraphCountInPeSta( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
					//Thread.sleep(5000);
					//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(3000);
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
		
		@Test(priority = 57)
		void periodIsSMETAColumnPendingForReview() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Pending For Review - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
			
			@Test(priority = 58)
			void Inprogress_PieChartPeriod() throws InterruptedException
			{
				test = extent.startTest("Period-Pie Chart -Not Completed Status- 'In Progress' Count Verification");
				
				Thread.sleep(3000);
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
				Thread.sleep(2000);
				WebDriverWait wait = new WebDriverWait( getDriver(),(30));
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
		
				Thread.sleep(1500);
				
				int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'
				CFOcountPOM.clickinProgress().click();									//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
				int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
				int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
				int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
				int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
				
				int total = critical + high + medium + low;
				/*
				if(pendingForReviewValue == total)
				{
					test.log(LogStatus.PASS, "' In-progress' Compliance Count matches to sum of all risked compliances.");
					test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
				}
				else
				{
					test.log(LogStatus.FAIL, "In-progress' Compliance Count doesn't matches to sum of all risked compliances.");
					test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
				}
			*/
				if(pendingForReviewValue > 0)
				{
					if(critical >= 0)
					{
						DeptCountPOM.GraphCountInPeSta( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high >=0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium >=0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
					//Thread.sleep(5000);
					//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
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
			
			@Test(priority = 59)
			void periodIsSMETAColumnInprogress() throws InterruptedException, IOException
			{
				test = extent.startTest("Period-Pie Chart -Completion Status - In Progress - Is SMETA Column Count Verification");
				WebDriverWait wait = new WebDriverWait( getDriver(),(120));
				Thread.sleep(500);
				Actions action = new Actions(getDriver());
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
				

			
		@Test(priority = 60)
			void rejected_PieChartPeriod() throws InterruptedException
			{
				test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Rejected' Count Verification");
				
				Thread.sleep(3000);
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
				Thread.sleep(800);
				WebDriverWait wait = new WebDriverWait( getDriver(),(30));
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
				test = extent.startTest("Period-Pie Chart -"+date+"-"+month+"-"+year+" "+"-Not Completed Status- ' Rejected' Count Verification");
		
				Thread.sleep(1500);
				
				int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickRejectedPe11().getText());	//Reading value of 'Not Completed'
				CFOcountPOM.clickRejectedPe11().click();									//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
				int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
				int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
				int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
				int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
				
				int total = critical + high + medium + low;
				/*
				if(pendingForReviewValue == total)
				{
					test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
					test.log(LogStatus.PASS, "Total Rejected' Compliances : "+total);
				}
				else
				{
					test.log(LogStatus.FAIL, "Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
					test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
				}
			*/
				if(pendingForReviewValue > 0)
				{
					if(critical >= 0)
					{
						DeptCountPOM.GraphCountInPeSta( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high >=0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPeSta( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
					//Thread.sleep(5000);
					//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(2000);
				}
				else
				{
					test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+pendingForReviewValue);
					
					Thread.sleep(500);
				//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			
				}
				
				extent.endTest(test);
				extent.flush();
			}
					
		@Test(priority = 61)
		void periodIsSMETAColumnRejected() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status - Rejected - Is SMETA Column Count Verification");
			WebDriverWait wait = new WebDriverWait( getDriver(),(120));
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
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
			
		@Test(priority = 62)
		void UpcomingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the filters of Upcoming Status are working on the graph of Due for the period - Competion status graph?");
		
					ApprovalcountPOM.UpcomingFilter(test);
			
			extent.endTest(test);
			extent.flush();
		}
			@Test(priority = 63)
			void complianceCalendar() throws InterruptedException
			{
				test = extent.startTest("compliance Calendar Verifications");
				
				
				WebDriverWait wait = new WebDriverWait( getDriver(), (70));
			
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2600 px.
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']")));
				Thread.sleep(5000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
				Thread.sleep(5000);
				 CFOcountPOM.clickExportImage().click();
				 Thread.sleep(2000);
					test.log(LogStatus.PASS, "Excel file Export Successfully");
			
						getDriver().switchTo().parentFrame();
						Thread.sleep(1000);
						performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
						Thread.sleep(2000);
						
					extent.endTest(test);
					extent.flush();
			}
			
			 @Test(priority = 64)
				void DetailedReport() throws InterruptedException, IOException
				{
					test = extent.startTest("Detailed Report Count Verification");
					
					CFOcountPOM.DetailedReport1(test,  "cfo");
					
					extent.endTest(test);
					extent.flush();
				}
				
				
			@Test(priority = 65) 
				void DetailedReportIn() throws InterruptedException, IOException
				{
					test = extent.startTest("Detailed Report - Internal - Count Verification");
					
					
					AuditorcountPOM.DetailedReportIn(test,  "Auditor");
					
					extent.endTest(test);
					extent.flush();
				}

			  
			@Test(priority = 66)
				void PerformReviewEmailCol() throws InterruptedException, IOException
				{
					test = extent.startTest("Detailed Report - Performer Email column and Reviewer Email column Visible on grid Verification. ");
						
					MethodsPOM.PerformReviewEmailCol(test);
					
					extent.endTest(test);
					extent.flush();
				}


			@Test(priority = 67)
			void PerformReviewEmailColIn() throws InterruptedException, IOException
			{
				test = extent.startTest("Detailed Report - Internal - Performer Email column and Reviewer Email column Visible on grid Verification. ");
					
				MethodsPOM.PerformReviewEmailColIn(test);
				
				extent.endTest(test);
				extent.flush();
			}

		
			@Test(priority = 68)
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
			
		
	/*
	@Test(priority = 0)
	void CompletedPFR_PieChartMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	/*
	//@Test(priority = 15)
	void CompletedPFR_PieChartMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 16)
	void RiskSummaryMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 17)
	void RiskSummaryMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 16)
	void DeptSummaryMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

//	@Test(priority = 17)
	void DeptSummaryMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 18)
	void DFPCompletedPFR_PieChartMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 19)
	void DFPCompletedPFR_PieChartMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 22)
	void CompletedPFR_PieChartMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 23)
	void CompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 16)
	void RiskSummaryMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 17)
	void RiskSummaryMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 16)
	void DeptSummaryMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

//	@Test(priority = 17)
	void DeptSummaryMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 18)
	void DFPCompletedPFR_PieChartMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory  Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 19)
	void DFPCompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 20)
	void CompletedPFR_PieChartMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 21)
	void CompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 22)
	void RiskSummaryMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 23)
	void RiskSummaryMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 24)
	void DeptSummaryMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

//	@Test(priority = 25)
	void DeptSummaryMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 26)
	void DFPCompletedPFR_PieChartMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 27)
	void DFPCompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 28)
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
	}
	*/
				
		/*
	//	@Test(priority = 0)
		void SummaryofOverdueSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Summary of Overdue Compliances?");
			
			DeptCountPOM.SummaryofOverdueSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 40)
		void PerformanceSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Performance Summary Graph?");
			
			DeptCountPOM.PerformanceSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 41)
		void DepartmentSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Department Summary Graph?");
			
			DeptCountPOM.DepartmentSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 42)
		void RiskSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Risk Summary Graph?");
			
			DeptCountPOM.RiskSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
	
		@Test(priority = 43)
		void PerformerSummaryDueForPeriodSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Performance Summary(Due for the period) Graph?");
			
			DeptCountPOM.PerformerSummaryDueForPeriodSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		/*
		@Test(priority = 45)
		void DetailedReportSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Deatiled Report?");
			
			DeptCountPOM.DetailedReportSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 46)
		void ComplianceDocumentsSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Compliance Document?");
			
			DeptCountPOM.ComplianceDocumentsSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	*/
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		Thread.sleep(1000);
  	//	getDriver().close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}	 
	

}
