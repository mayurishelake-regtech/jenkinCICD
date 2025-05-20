package criticalTestScripts;

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
import departmentHead.DeptCountPOM;
import login.BasePage;
import performer.OverduePOM;

public class DeptInternal extends BasePage  {
	
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
		sheet = workbook.getSheetAt(7);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws Exception
	{
		
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\Department(Internal).html",true);
		test = extent.startTest("Loging In - Department Head (Internal)");
		test.log(LogStatus.PASS, "Logging into system");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
	
		initialization(link,7,"Internal");
		/*
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);	
		

		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		Thread.sleep(700);
		Select drp = new Select(CFOcountPOM.selectInternal());
		drp.selectByIndex(1);
		Thread.sleep(3000);
	
		Thread.sleep(1000);
	
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(1000);
		
		*/
	}
	
	public static void progress1( )
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
	void clickCategoriesInternal() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Department'");
		
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(6000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		

		Thread.sleep(3000);
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
			
			test.log(LogStatus.PASS, "No of Department in the grid = "+CatcountGrid+" | Dashboard Department  Count = "+CategoriesCountDas);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "No of Department in the grid = "+CatcountGrid+" | Dashboard Department  Count = "+CategoriesCountDas);
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
	void ClickCompliancesInternal() throws InterruptedException
	{
		test = extent.startTest("'Complainces' Count by Clicking on 'Compliances'");
		
		Thread.sleep(1500);
		WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
		wait1.until(ExpectedConditions.visibilityOf(CFOcountPOM.readCompliancesInternal()));
		int valueCompliances = Integer.parseInt(CFOcountPOM.readCompliancesInternal().getText());	//Storing value of 'Compliances' as a String to compare.
		
		getDriver().findElement(By.xpath("(//*[@class = 'titleMD'])[4]")).click();
					
		Thread.sleep(4000);
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
		
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
	
		Thread.sleep(500);
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
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();					//Closing the 'Compliance' window.
		Thread.sleep(3000);
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
	void clickUsersInternal() throws InterruptedException
	{
		test = extent.startTest("'Users' Count by Clicking on 'Users'");
		
		
		Thread.sleep(500);
		if(OverduePOM.closeMessage().isDisplayed())				//If Compliance Updation message popped up,
		{
			OverduePOM.closeMessage().click();					//then close the message.
		}
		
		Thread.sleep(1500);
		int valueUsers = Integer.parseInt(CFOcountPOM.clickUsersCount().getText());	//Storing value of 'Users' as a String to compare.
		Thread.sleep(500);
		CFOcountPOM.clickUsersCount().click();					//Clicking on 'Users'. 
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(2000);
		CFOcountPOM.clickExportImage().click();                    //export excel
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
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances Internal");
		
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		Thread.sleep(1000);
	
		Thread.sleep(8000);
		if(CFOcountPOM.ClickShowAllIn().isEnabled()) {
			CFOcountPOM.ClickShowAllIn().click();        //Clicking on Show All
			Thread.sleep(8000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
	//	litigationPerformer.MethodsPOM.progress();
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver() .switchTo().frame(farme);
      Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='grid'])[2]")));
		 Thread.sleep(3000); 
		 js.executeScript("window.scrollBy(0,550)");	
		 Thread.sleep(2000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(4000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButtons = getDriver().findElement(locator);							
			ViewButtons.click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			getDriver().switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
	@Test(priority = 9)
	void ClosedTimely_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Closed Timely' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2500);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternal().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyInternal().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
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
		
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
	
	@Test(priority = 10)
	void ClosedDelayed_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Closed Delayed' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedInternal().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedInternal().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
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
		
		if(ClosedDelayedValue > 0)
		{
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
	
	
	@Test(priority = 11)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Not Completed' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
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
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "Low", low, "Internal");
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
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void NotApplicable_PieChartIN() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Not Applicable' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickNotApplicable().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
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
		
		if(NotApplicableValue > 0)
		{
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
		}
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 13)
	void Overdue_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - 'Overdue' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		Thread.sleep(1000);
		Actions action = new Actions(getDriver());
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdueInternal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdueInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
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
			if(critical >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				DeptCountPOM.GraphCountIn( test, "Low", low, "Internal");
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
			test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void PFR_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- 'Pending For Review' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		Thread.sleep(4000);
		
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIND().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIND().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
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
				DeptCountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void inProgress_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- 'In Progress' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		
		Thread.sleep(2000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		
		
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int inProgressValue = Integer.parseInt(CFOcountPOM.clickInProgressDept().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickInProgressDept().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
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
				DeptCountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
			test.log(LogStatus.PASS, "'In Progress' Compliance Count = "+inProgressValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void Rejected_PieChartInternal() throws InterruptedException
	{
		test = extent.startTest("Pie Chart - Not Completed Status- ' Rejected' Count Verification");
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,100)");	
		Thread.sleep(500);
		
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(4000);
		DeptCountPOM.Refresh().click();
		Thread.sleep(4000);
		
		
		js.executeScript("window.scrollBy(0,600)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejectedIn().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedIn().click();									//CLicking on 'Not Completed' count
		
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
				DeptCountPOM.GraphCountIn1( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCountIn1( test, "Low", low, "Internal");
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
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
		//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
		void DepartmentSummaryInternal() throws InterruptedException
		{
			Thread.sleep(500);		
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//	js.executeScript("window.scrollBy(0,500)");		
			//Scrolling down window by 1500 px.
			DeptCountPOM.SelectYear().click();
			Thread.sleep(1000);
			DeptCountPOM.SelectAll().click();
			Thread.sleep(3000);
			
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(4000);
			DeptCountPOM.Refresh().click();
			Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1500)");
			
			test = extent.startTest("Department Summary - 'Admin' Count Verification");
			
			Thread.sleep(2000);
			Thread.sleep(3000);
			String Admin = CFOcountPOM.AdminCountD().getText();			//Reading the Overdue value of Human Resource
			Admin = Admin.replaceAll(" ","");									//Removing all white spaces from string. 
			int IndustrySpeCritical = Integer.parseInt(Admin);	
			
			Thread.sleep(4000);
			String FinaOverdue = CFOcountPOM.clickFinanceOverdueDept().getText();			//Reading the Overdue value of Human Resource
		//	FinaOverdue = FinaOverdue.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_Overdue = Integer.parseInt(FinaOverdue);						
			if(Fina_Overdue > 0)
			{Thread.sleep(3000);
				CFOcountPOM.clickFinanceOverdueDept().click();
				DeptCountPOM.RiskGraphCount1In( test, "Overdue", Fina_Overdue, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+ Fina_Overdue + ".");
			}
			Thread.sleep(2000); 
			By locator = By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect");
			WebDriverWait wait = new WebDriverWait( getDriver(), (100));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
		WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
			ViewButton.click();
				
			Thread.sleep(5000);
				
			Thread.sleep(5000);
			String financeClosedDelayed= CFOcountPOM.clickClosedDelayedDept().getText();	//Reading the Closed Delayed value of Human Resource
			financeClosedDelayed = financeClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
			int Finance_CloseDelayed= Integer.parseInt(financeClosedDelayed);						
			if(Finance_CloseDelayed > 0)
			{
				CFOcountPOM.clickClosedDelayedDept().click();
				DeptCountPOM.RiskGraphCountIn( test, " Closed Delayed ", Finance_CloseDelayed, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "Closed Delayed' Compliance Count = "+ Finance_CloseDelayed + ".");
			}
			 WebElement roc1 =getDriver() .findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(21) > g:nth-child(2) > g:nth-child(1) > g:nth-child(1) > text:nth-child(1) > tspan:nth-child(1)"));
				
			  roc1.click();
			//------------------------------------------------------
			
			Thread.sleep(500);
			String FinaClosedTimely = CFOcountPOM.clickClosedTimelyDpt().getText();		//Reading the Closed Timely value of Human Resource
			FinaClosedTimely = FinaClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_ClosedTimely = Integer.parseInt(FinaClosedTimely);						
			if(Fina_ClosedTimely > 0)
			{
				CFOcountPOM.clickClosedTimelyDpt().click();
				DeptCountPOM.RiskGraphCountIn( test, " -Closed Timely", Fina_ClosedTimely, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "' -Closed Timely' Complaince Count = "+ Fina_ClosedTimely + ".");
			}
			
			
			
			WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
			CT.click();
			Thread.sleep(2000);
					  String FinaPFReview = CFOcountPOM.clickPendingReviewDept().getText();			//Reading the Overdue value of Human Resource
			FinaPFReview = FinaPFReview.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_PFR = Integer.parseInt(FinaPFReview);						
			if(Fina_PFR > 0)
			{
				CFOcountPOM.clickPendingReviewDept().click();
				DeptCountPOM.RiskGraphCountIn( test, " -Pending For Review", Fina_PFR, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "' - Pending For Review' Compliance Count = "+ Fina_PFR + ".");
			}
			
			Thread.sleep(3000);
			By locators = By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > rect");
		//	WebDriverWait wait = new WebDriverWait( getDriver(), (100));
			wait.until(ExpectedConditions.presenceOfElementLocated(locators));
			Thread.sleep(4000);
			
		WebElement ViewButtons = getDriver().findElement(locators);	
			Thread.sleep(3000);
			ViewButtons.click();
			Thread.sleep(2000);
			String FinaInprogress = CFOcountPOM.clickHumanInprogress().getText();			//Reading the Overdue value of Human Resource
			FinaInprogress = FinaInprogress.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_InProgress = Integer.parseInt(FinaInprogress);						
			if(Fina_InProgress > 0)
			{
				CFOcountPOM.clickHumanInprogress().click();
				CFOcountPOM.RiskGraphCountIn( test, " -In Progress", Fina_InProgress, "Internal");
			}
			else
			{
				test.log(LogStatus.SKIP, "' - In Progress ' Complaince Count = "+ Fina_InProgress + ".");
			}
			WebElement IP = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-4 > rect"));
			IP.click();
			Thread.sleep(3000);
			String FinaRejected = CFOcountPOM.clickHumanRejected().getText();			//Reading the Overdue value of Human Resource
			FinaRejected = FinaRejected.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_Rejected= Integer.parseInt(FinaRejected);						
			if(Fina_Rejected > 0)
			{
				CFOcountPOM.clickHumanRejected().click();
				DeptCountPOM.RiskGraphCountIn( test, " -Rejected", Fina_Rejected, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "' - Rejected' Compliance Count = "+ Fina_Rejected + ".");
			}
			
			Thread.sleep(3000);
			String FinaNotAppli = CFOcountPOM.clickHumanNotApplicable().getText();			//Reading the Overdue value of Human Resource
			FinaNotAppli = FinaNotAppli.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_NotAppli= Integer.parseInt(FinaNotAppli);						
			if(Fina_NotAppli > 0)
			{
				CFOcountPOM.clickHumanNotApplicable().click();
				DeptCountPOM.RiskGraphCountIn( test, " -Not Applicable", Fina_NotAppli, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "' - Not Applicable' Compliance Count = "+ Fina_NotAppli + ".");
			}
			
			Thread.sleep(3000);
			Thread.sleep(8000);
			int total = Fina_Overdue + Fina_NotAppli + Fina_Rejected+Fina_InProgress+Fina_PFR+Fina_ClosedTimely+Finance_CloseDelayed;				//Calculating the values to match with High value of Labour.
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
		
		Thread.sleep(2000);
		
		//	js.executeScript("window.scrollBy(0,-1600)");			//Clicking on Dashboard
		//	performer.OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 18)
		void RiskSummaryCriticalInternal() throws InterruptedException, IOException
		{
		
			Thread.sleep(3000);
			DeptCountPOM.SelectYear().click();
			Thread.sleep(1000);
			DeptCountPOM.SelectAll().click();
			Thread.sleep(3000);
			
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(4000);
			DeptCountPOM.Refresh().click();
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 1000 px.cfo
		//	js.executeScript("window.scrollBy(0,600)");
			test = extent.startTest("Risk Summary - 'Critical' Count Verification");
			
			Thread.sleep(2000);
			int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryCriticalD().getText());
			Thread.sleep(4000);
			Thread.sleep(4000);
			String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompletedDept().getText();		
			Thread.sleep(2000);
			
			NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
			int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
		//	int RiskCritical_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompletedDeptIn().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskCritical_NotCompleted > 0)
			{
				CFOcountPOM.clickRiskCriticalNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
				Thread.sleep(2000);
				DeptCountPOM.RiskGraphCount1In( test, "Critical - Not Completed", RiskCritical_NotCompleted, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
			}
			Thread.sleep(2000);
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
				
			Thread.sleep(4000);
			int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskCritical_ClosedDelayed > 0)
			{
				CFOcountPOM.clickRiskCriticalClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				Thread.sleep(2000);
				DeptCountPOM.RiskGraphCountIn( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
			}
			
			Thread.sleep(3000);
			int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskCritical_ClosedTimely > 0)
			{
				CFOcountPOM.clickRiskCriticalClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				Thread.sleep(2000);
				DeptCountPOM.RiskGraphCountIn( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
			}
			
			Thread.sleep(2000);
			List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
			
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
			
			Thread.sleep(8000);
			int total = RiskCritical_NotCompleted + RiskCritical_ClosedDelayed + RiskCritical_NotApplicable;				//Calculating the values to match with High value of Labour.

			//int total = RiskCritical_NotCompleted + RiskCritical_ClosedDelayed + RiskCritical_ClosedTimely + RiskCritical_NotApplicable+RiskCritical_DueToday;				//Calculating the values to match with High value of Labour.
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
			
		@Test(priority = 19)
		void RiskSummaryHighInternal() throws InterruptedException
		{		
			test = extent.startTest("Risk Summary - 'High' Count Verification");
			DeptCountPOM.SelectYear().click();
			Thread.sleep(1000);
			DeptCountPOM.SelectAll().click();
			Thread.sleep(3000);
			
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(4000);
			DeptCountPOM.Refresh().click();
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2000)");
		//	js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(500);
			Thread.sleep(1000);
			String High = CFOcountPOM.RiskSummaryHighD().getText();		//Reading the Closed Timely value of Human Resource
			High = High.replaceAll(" ","");									//Removing all white spaces from string. 
			int IndustrySpeCritical = Integer.parseInt(High);
		
			Thread.sleep(4000);
			String NotCompleted = CFOcountPOM.clickRiskHighNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
			NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
			int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
		
			//int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskHigh_NotCompleted > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskHighNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCount1In( test, "High - Not Completed", RiskHigh_NotCompleted, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
			}
			
			Thread.sleep(2000);
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
				
			Thread.sleep(4000);
				
			Thread.sleep(2000);
			int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskHigh_ClosedDelayed > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskHighClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCountIn( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
			}
			
			Thread.sleep(3000);
			int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskHigh_ClosedTimely > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskHighClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCountIn( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
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
				DeptCountPOM.RiskGraphCountIn( test, "High - Not Applicable", RiskHigh_NotApplicable, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+RiskHigh_NotApplicable);
			}
			
			Thread.sleep(8000);
			int total = RiskHigh_NotCompleted + RiskHigh_ClosedDelayed + RiskHigh_ClosedTimely + RiskHigh_NotApplicable;				//Calculating the values to match with High value of Labour.
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
		
		@Test(priority = 20)
		void RiskSummaryMediumInternal() throws InterruptedException, IOException
		{		
			test = extent.startTest("Risk Summary - 'Medium' Count Verification");
			Thread.sleep(3000);
			DeptCountPOM.SelectYear().click();
			Thread.sleep(1000);
			DeptCountPOM.SelectAll().click();
			Thread.sleep(3000);
			
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(4000);
			DeptCountPOM.Refresh().click();
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2000)");
		//	js.executeScript("window.scrollBy(0,1400)");
			Thread.sleep(1000);
			int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryMedium().getText());
			Thread.sleep(4000);
			String NotCompleted = CFOcountPOM.clickRiskMediumNotCompletedDept().getText();		//Reased Timely value of Human Resource
			NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
			int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
		
			//int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskHigh_NotCompleted > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskMediumNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCount1In( test, "Medium - Not Completed", RiskHigh_NotCompleted, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
			}
			
			Thread.sleep(2000);
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
				
			Thread.sleep(4000);
				
			Thread.sleep(2000);
			int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskMedium_ClosedDelayed > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskMediumClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCountIn( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
			}
			else
			{
				test.log(LogStatus.FAIL, "'High - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
			}
			
			Thread.sleep(3000);
			int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskMedium_ClosedTimely > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskMediumClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCountIn( test, "High - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskMedium_ClosedTimely);
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
			
			Thread.sleep(8000);
			int total = RiskHigh_NotCompleted + RiskMedium_ClosedDelayed + RiskMedium_ClosedTimely + RiskMedium_NotApplicable;				//Calculating the values to match with High value of Labour.
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
		
		@Test(priority = 21)
		void RiskSummaryLowStatutory() throws InterruptedException, IOException
		{		
			test = extent.startTest("Risk Summary - 'Low' Count Verification");
			Thread.sleep(2000);
			DeptCountPOM.SelectYear().click();
			Thread.sleep(1000);
			DeptCountPOM.SelectAll().click();
			Thread.sleep(3000);
			
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(4000);
			DeptCountPOM.Refresh().click();
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2000)");
			Thread.sleep(3000);
			int IndustrySpeCritical = Integer.parseInt(CFOcountPOM.RiskSummaryLowD().getText());
			Thread.sleep(4000);
			
			int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompletedDept().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskLow_NotCompleted > 0)
			{
				Thread.sleep(2000);
				CFOcountPOM.clickRiskLowNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
				Thread.sleep(2000);
				DeptCountPOM.RiskGraphCount1In( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
			}
			Thread.sleep(2000);
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
				
			Thread.sleep(5000);
		
			
			int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskLow_ClosedDelayed > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskLowClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCountIn( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
			}
			
			Thread.sleep(3000);
			int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
			if(RiskLow_ClosedTimely > 0)
			{
				Thread.sleep(500);
				CFOcountPOM.clickRiskLowClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
				
				DeptCountPOM.RiskGraphCountIn( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
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
			Thread.sleep(8000);
			int total = RiskLow_NotCompleted + RiskLow_ClosedDelayed + RiskLow_ClosedTimely + RiskLow_NotApplicable;				//Calculating the values to match with High value of Labour.
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
			Thread.sleep(500);
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 22)
		void ClosedTimely_PieChartPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
			Thread.sleep(3000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);
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
			
			int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternalP().getText());	//Reading value of 'After Due Date'
			CFOcountPOM.clickClosedTimelyInternalP().click();								//CLicking on 'Not Completed' count
			
			Thread.sleep(500);
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
					DeptCountPOM.GraphCountInPe3( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Low", low, "Statutory");
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
				Thread.sleep(2000);
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
		
		@Test(priority = 23)
		void ClosedDelayed_PieChartPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
			Thread.sleep(3000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(3000);
		
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
			Thread.sleep(1500);
			int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedInternal().getText());	//Reading value of 'After Due Date'
			CFOcountPOM.clickClosedDelayedInternal().click();								//CLicking on 'Not Completed' count
			
			Thread.sleep(500);
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
					DeptCountPOM.GraphCountInPe3( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			}
			extent.endTest(test);
			extent.flush();
			
		}
		
		@Test(priority = 24)
		void NotCompleted_PieChartPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart - 'Not Completed' Count Verification");
		
			Thread.sleep(500);
			Thread.sleep(3000);
		
			Actions action = new Actions(getDriver());
		     JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			
			Thread.sleep(3000);
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
			if(NotCompletedValue > 0)
			{
				if(critical >= 0)
				{
					DeptCountPOM.GraphCountInPe2( test, "Critical", critical, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(200);
					DeptCountPOM.GraphCountInPe2( test, "High", high, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(200);
					DeptCountPOM.GraphCountInPe2( test, "Medium", medium, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(200);
					DeptCountPOM.GraphCountInPe2( test, "Low", low, "Internal");
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
				test.log(LogStatus.PASS, "'Not Completed' Compliance Count = "+NotCompletedValue);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBackPe()).click().build().perform();	//Clicking on Dashboard
				getDriver().switchTo().parentFrame();
			}
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 25)
			void NotApplicable_PieChartPeriod() throws InterruptedException
			{
				test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
				
				
				Actions action = new Actions(getDriver());
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				Thread.sleep(3000);
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
				
				Thread.sleep(1500);
				int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
				CFOcountPOM.clickNotApplicable().click();								//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
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
						DeptCountPOM.GraphCountInPe3( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe3( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe3( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low >= 0)
					{
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
						Thread.sleep(500);
						DeptCountPOM.GraphCountInPe3( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					Thread.sleep(3000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(3000);
					action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
					getDriver().switchTo().parentFrame();
					Thread.sleep(3000);
				}
				else
				{
					test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					
					Thread.sleep(500);
					action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				}
				extent.endTest(test);
				extent.flush();
				
			}
			
			@Test(priority = 26)
			void Upcoming_PieChartPeriod() throws InterruptedException, IOException
			{
			//	test = extent.startTest("Period-Pie Chart - Completion Status- ' Upcoming' Count Verification");
			
				Thread.sleep(2000);
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,2700)");			//Scrolling down window by 1000 px.
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
				test.log(LogStatus.PASS, "The status named \"upcoming\" should reflects separately in the graph of the performance summary (Completion compliance summary) due for a period.");

			}else {
				test.log(LogStatus.FAIL, "The status named \"upcoming\" not reflects separately in the graph of the performance summary (Completion compliance summary) due for a period.");

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
			
			
			
		@Test(priority = 27)
		void Overdue_PieChartInternalPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart - 'Overdue' Count Verification");
			
			Thread.sleep(500);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//	js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
			js.executeScript("window.scrollBy(0,2700)");
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(3000);
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
					DeptCountPOM.GraphCountInPe2( test, "Critical", critical, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe2( test, "High", high, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe2( test, "Medium", medium, "Internal");
				}
				else
				{
					
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe2( test, "Low", low, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				
				Thread.sleep(500);
				//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(4000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+OverdueValue);
				
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

			}
			extent.endTest(test);
			extent.flush();
		}
		
			@Test(priority = 28)
		void dueToday_PieChartPeriod() throws InterruptedException
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
					DeptCountPOM.GraphCountInPe2( test, "Critical", critical, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe2( test, "High", high, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe2( test, "Medium", medium, "Internal");
				}
				else
				{
					
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe2( test, "Low", low, "Internal");
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
		
		
		@Test(priority = 29)
		void PFR_PieChartInternalPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart - 'Pending For Review' Count Verification");
		
			
		
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			Thread.sleep(3000);
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
			Thread.sleep(500);
			if(pendingForReviewValue > 0)
			{
				if(critical >= 0)
				{
					DeptCountPOM.GraphCountInPe3( test, "Critical", critical, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "High", high, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Medium", medium, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Low", low, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				
				Thread.sleep(500);
			//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(8000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+pendingForReviewValue);
				
				Thread.sleep(500);
				//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

			}
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 30)
		void InProgress_PieChartInternalPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart - Not Completed Status - 'in Progress' Count Verification");
			
			
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait( getDriver(), 40);

			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,3000)");						//Scrolling down window by 1000 px.
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
					DeptCountPOM.GraphCountInPe3( test, "Critical", critical, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "High", high, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Medium", medium, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Low", low, "Internal");
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
		
	
		
	@Test(priority = 31)
		void Rejected_PieChartInternalPeriod() throws InterruptedException
		{
			test = extent.startTest("Period-Pie Chart - 'Rejected' Count Verification");
		
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2700)");						//Scrolling down window by 1000 px.
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait( getDriver(),(30));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
			Thread.sleep(500);
			Thread.sleep(3000);
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
					DeptCountPOM.GraphCountInPe3( test, "Critical", critical, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "High", high, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Medium", medium, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
					Thread.sleep(500);
					DeptCountPOM.GraphCountInPe3( test, "Low", low, "Internal");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				
				Thread.sleep(500);
			//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

			}
			else
			{
				test.log(LogStatus.PASS, "'Overdue' Compliance Count = "+rejectedValue);
				
				Thread.sleep(500);
				//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

			}
			extent.endTest(test);
			extent.flush();
		}
		
	
	 @Test(priority = 59)
		void DetailedReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report Count Verification");
			
			CFOcountPOM.DetailedReport1(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
	  
		@Test(priority = 62)
		void AssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Assignment Report verification");
			
			CFOcountPOM.AssignmentReportIn(test);
			
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
