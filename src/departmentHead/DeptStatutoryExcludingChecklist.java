package departmentHead;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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
import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtAMethod;
import login.BasePage;
import performer.MethodsPOM;
import performer.OverduePOM;

public class DeptStatutoryExcludingChecklist extends BasePage{
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
	
	public static String link = "Department1";           //Check link in excel sheet first.
			
		/*
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(7);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\Department.html",true);
		test = extent.startTest("Loging In - Department Head (StatutoryExcludingChecklist)");
		test.log(LogStatus.PASS, "Logging into system");
		
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
	//	test = extent.startTest("Loging In - Department Head (Statutory)");
		//test.log(LogStatus.PASS, "Logging into system");
		initialization(link,7,"StatutoryExcludingChecklist");
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
	//	XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(4);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		
	//	extent.endTest(test);
	//	extent.flush();*/
	}
	
	public static void progress1()
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf( getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
//	@Test(priority = 2)
	void  FilterWiseDepartmentCountMatch1() throws InterruptedException
	{
		test = extent.startTest(" Count Match Filter Wise by Clicking on 'Depatment' - Compliances");
		
		
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(500);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(140));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(3000);
		CFOcountPOM.SelectLocation().click();
		Thread.sleep(3000);
		CFOcountPOM.ClickIocon().click();
		CFOcountPOM.ClickABCMall().click();
		Thread.sleep(4000);
		WebElement CompCat=	getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[4]/div"));
		int	value = Integer.parseInt(CompCat.getText());
		Thread.sleep(1000);
		CompCat.click();
		Thread.sleep(500);

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD().click();
		
		Thread.sleep(1000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount1 = bits[bits.length - 2];				//Getting the second last word (total number of users)
		
	int	count1 = Integer.parseInt(compliancesCount1);
		
		
		if(value == count1)
		{
			test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + value+ ", Grid Records = "+count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+value+", Grid Records = "+count1);
		}
		
		getDriver().switchTo().parentFrame();	//Switching back to parent frame.
		Thread.sleep(500);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", CFOcountPOM.closeCategories_Compliances());
	//	CFOcountPOM.closeCategories_Compliances().click();		//Closing the 'Compliances' pup up.
		
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']")).click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clear Button is working Successfully");
	//	Thread.sleep(3000);
		js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
		Thread.sleep(2000);
		getDriver().switchTo().defaultContent();
			
		Thread.sleep(4000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 1)
	void Entities() throws InterruptedException, IOException
	{
		test = extent.startTest("Entities");
		
		ApprovalcountPOM.Entities( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 2)
	void LocationCount() throws InterruptedException, IOException
	{
		test = extent.startTest("Location");
		
		ApprovalcountPOM.LocationCount( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 3)
	void DepartmentCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Department'");
		
		
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(5000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
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
		/*
		elementsList1 = CFOcountPOM.readCompliancesList();
		elementsList1.get(1).click();
		Thread.sleep(3000);
		.switchTo().defaultContent();	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();                    //export excel
	//	Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		//.switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		//.switchTo().defaultContent();	
		CFOcountPOM.closeCategories_Compliances().click();		//Closing the 'Compliances' pup up.
		Thread.sleep(3000);
		/*
		int n1 = elementsList1.size();
		int value = 0;
		int count1 = 0;
		for(int i = 0; i < n1; i++)
		{		
			Thread.sleep(500);
			elementsList1 = CFOcountPOM.readCompliancesList();
			value = Integer.parseInt(elementsList1.get(i).getText());
			elementsList1.get(i).click();
			
			Thread.sleep(500);
			//litigationPerformer.MethodsPOM.progress();
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD().click();
			
			Thread.sleep(1000);
			String item1 = CFOcountPOM.readTotalItemsD().getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits.length - 2];				//Getting the second last word (total number of users)
			
			count1 = Integer.parseInt(compliancesCount1);
			js.executeScript("window.scrollBy(0,3000)");
			if(value == count1)
			{
				test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + value+ ", Grid Records = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+value+", Grid Records = "+count1);
			}
			.switchTo().parentFrame();								//Switching back to parent frame.
			Thread.sleep(3000);
			CFOcountPOM.closeCategories_Compliances().click();		//Closing the 'Compliances' pup up.
			Thread.sleep(2000);
		}	*/
		if(CategoriesCountDas == CatcountGrid)
		{
		//	test.log(LogStatus.PASS, "Number of Categories grid matches to Dashboard Categories  Count.");
			test.log(LogStatus.PASS, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
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
	
//	@Test(priority = 4)
	void FilterWiseDepartmentCountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest(" To Check On Department popup Category filter working or not");
		
		DeptCountPOM.FilterWiseDepartmentCountMatch( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 5)
	void CompliancesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Compliances'");
		
		
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Compliances =CFOcountPOM.readCompliances().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.readCompliances().click();
		Thread.sleep(2000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
	/*	CFOcountPOM.clickLocation().click();
		Thread.sleep(500);
		CFOcountPOM.clickAVIPL().click();
		Thread.sleep(2000);*/
		CFOcountPOM.clickClear().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clear Button is working");
		
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
	
	//@Test(priority = 6)
		void FilterWiseCompliancesCountMatch() throws InterruptedException, IOException
		{
			test = extent.startTest("'Compliances' filter working or not");
			
			DeptCountPOM.FilterWiseCompliancesCountMatch( test);
			
			extent.endTest(test);
			extent.flush();
		}

//	@Test(priority = 7)
	void UsersCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Users'");
		
		
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
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
	}
	
//	@Test(priority = 8)
	void clickPenaltyStatutory() throws InterruptedException
	{
		test = extent.startTest("'Penalty' Export");
	
		
		Thread.sleep(1500);
	//	String oldStr = CFOcountPOM.readPenaltyCount().getText();
	//	String newStr = oldStr.replaceAll(",","");		//Removing comma (,) from the read input.
	//	int valuePenalty = Integer.parseInt(newStr);	//Storing old value of 'Compliances'.
		
		CFOcountPOM.readPenaltyCount().click();					//Clicking on 'Penalty'.
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		CFOcountPOM.clickLocationPe().click();
		Thread.sleep(1000);
		CFOcountPOM.clickExpand1().click();
		Thread.sleep(1000);
		CFOcountPOM.clickAR().click();
		Thread.sleep(500);
		CFOcountPOM.clickClear().click();
		test.log(LogStatus.PASS, "Clear Button is working Successfully");
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		
		Thread.sleep(3000);
		
		//CFOcountPOM.CountPenalty( test, valuePenalty);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 9)
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances");
		
		Thread.sleep(4000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		if(CFOcountPOM.ClickShowAll().isEnabled()) {
			CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		
		Thread.sleep(3000);
		//litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait( getDriver(), (100));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(55000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(4000); 
	//	elementsList1=	CFOcountPOM.ActionviewList();
		//elementsList1.get(1).click();                   //Clicking on OverdueView  button
	//	.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[16]/a[1]")).click();
	//	Thread.sleep(3000);
	//	CFOcountPOM.closeDocument().click();						//Closing the View Document
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
			OverduePOM.clickRiskShowAll().click();
			Thread.sleep(1000);
			OverduePOM.clickRiskSAhigh().click();
			Thread.sleep(1000);
			OverduePOM.clickclearBtn().click();
			getDriver().switchTo().defaultContent();
			test.log(LogStatus.PASS, "Clear Button is working Successfully");
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
//@Test(priority = 6)
	void SummaryofOverdueFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliances' filter working or not");
		
		DeptCountPOM.SummaryofOverdueFilter( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 10)
	void NotCompletedPFR_PieChart() throws InterruptedException
	{
		test = extent.startTest("performance summary - Completion Status- 'Not Completed'- Selecting Status - Pending For Review Verify");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		if(NotCompletedValue > 0)
		{
			
			DeptCountPOM.GraphCountPFR( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
			
				DeptCountPOM.GraphCountPFR( test, "High", high, "Statutory");
				
				Thread.sleep(2000);
			
				DeptCountPOM.GraphCountPFR( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				DeptCountPOM.GraphCountPFR( test, "Low", low, "Statutory");
				
				Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(1000);
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 11)
	void NotCompleted_PieChart() throws InterruptedException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
	
		
		Thread.sleep(2000);
		/*DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);*/
		Actions action = new Actions(getDriver());
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
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
	
	//@Test(priority = 12)
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
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(4000);
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedA().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickClosedDelayedA().click();								//CLicking on 'Not Completed' count
		
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
				DeptCountPOM.GraphCount2( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount2( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount2( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount2( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 13)
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
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCount2( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount2( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount2( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount2( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 14)
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
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickNotApplicableA().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicableA().click();								//CLicking on 'Not Completed' count
		
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
				DeptCountPOM.GraphCount2( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount2( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount2( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount2( test, "Low", low, "Statutory");
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
			
	//@Test(priority = 15)
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
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
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
	

	//@Test(priority = 16)
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
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
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
				DeptCountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount1( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 17)
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
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
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
				DeptCountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount1( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 18)
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
				DeptCountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				DeptCountPOM.GraphCount1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				DeptCountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				DeptCountPOM.GraphCount1( test, "Low", low, "Statutory");
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
		
//	@Test(priority = 19)
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
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 1500 px.
		
		test = extent.startTest("Department Summary - 'Finance' Count Verification");
		
		Thread.sleep(2000);
		
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
			test.log(LogStatus.PASS, "Overdue Complaince Count = "+ Overdue + ".");
		}
		Thread.sleep(2900);
		
		WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));
		
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
			test.log(LogStatus.PASS, "Closed Delayed Complaince Count = "+ Closed_Delayed + ".");
		}
		
	
		Thread.sleep(500);
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
			test.log(LogStatus.PASS, "Closed Timely Complaince Count = "+ Closed_Timely + ".");
		}
		
		
		Thread.sleep(2000);
		Thread.sleep(500);
		String PendingReview = CFOcountPOM.clickPendingReviewDept().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);						
		if(Pending_Review > 0)
		{
			CFOcountPOM.clickPendingReviewDept().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Pending For Review", Pending_Review, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Pending For Review Complaince Count = "+ Pending_Review + ".");
		}
		
	
		
	/*	try
		{
			Thread.sleep(500);
			String NotApplicable = CFOcountPOM.clickHumanNotApplicable().getText();	//Reading the Pending For Review value of Human Resource
			NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
			int Not_Applicable = Integer.parseInt(NotApplicable);						
			if(Not_Applicable > 0)
			{
				CFOcountPOM.clickHumanNotApplicable().click();
				DeptCountPOM.RiskGraphCountRE( test, "Not Applicable", Not_Applicable, "Statutory");
			}
			else
			{
				test.log(LogStatus.SKIP, "Not Applicable Complaince Count = "+ Not_Applicable + ".");
			}
		}
		catch(Exception e)
		{
			
		}*/
		
		Thread.sleep(2000);
		Thread.sleep(500);
		String reject = CFOcountPOM.clickRejectDept().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = reject.replaceAll(" ","");								//Removing all white spaces from string. 
		int Rejected = Integer.parseInt(PendingReview);						
		if(Pending_Review > 0)
		{
			CFOcountPOM.clickRejectDept().click();
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Rejected", Rejected, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Rejected Complaince Count = "+ Rejected + ".");
		}
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 20) 
	void RiskSummaryCriticalStatutory() throws InterruptedException
	{
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		Thread.sleep(2000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,1450)");					//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,1500)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		
		
		Thread.sleep(500);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
	//	int RiskCritical_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotCompleted > 0)
		{
			CFOcountPOM.clickRiskCriticalNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			DeptCountPOM.RiskGraphCount1( test, "Critical - Not Completed", RiskCritical_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Completed' Count = "+RiskCritical_NotCompleted);
		}
		
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		
		Thread.sleep(4000);
	
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
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
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 21)
	void RiskSummaryHighStatutory() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount1( test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
		}
		
		Thread.sleep(4000);
		List<WebElement>roc =getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		
		Thread.sleep(4000);
		
		Thread.sleep(2000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
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
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 22)
	void RiskSummaryMediumStatutory() throws InterruptedException
	{
		test = extent.startTest("Risk Summary - 'Medium' Count Verification");
		
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskMediumNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskMedium_NotCompleted = Integer.parseInt(NotCompleted);
	
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount1( test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
		Thread.sleep(4000);
	/*	int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		*/
		Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 23)
	void RiskSummaryLowStatutory() throws InterruptedException
	{		
		test = extent.startTest("Risk Summary - 'Low' Count Verification");
		Thread.sleep(3000);
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		Thread.sleep(4000);
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");
		
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskLowNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskLow_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskLow_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskLowNotCompletedD().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount1( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}
		
		Thread.sleep(4000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		
		Thread.sleep(4000);
		
		
		Thread.sleep(2000);
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayedDpt().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayedDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
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
			Thread.sleep(8000);
			DeptCountPOM.RiskGraphCount( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
		}
	
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 24)
	void NotCompleted_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Completed' Count Verification");
	
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
	
//	@Test(priority = 25)
	void ClosedDelayed_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
	
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
			if(critical > 0)
			{
				DeptCountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low > 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 26)
	void ClosedTimely_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
	
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
				DeptCountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 27)
	void NotApplicable_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		
		Actions action = new Actions(getDriver());
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");						//Scrolling down window by 1000 px.
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
				DeptCountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 28)
	void Overdue_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		
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
	
//	@Test(priority = 29)
	void dueToday_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		
		
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
	
//	@Test(priority = 30)
	void pendingForReview_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
	
		
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
				DeptCountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 31)
	void Inprogress_PieChartPeriod() throws InterruptedException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'In Progress' Count Verification");
		
		Thread.sleep(3000);
		
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
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
				DeptCountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
	
//	@Test(priority = 32)
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
		
		int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickRejectedPe1().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe1().click();									//CLicking on 'Not Completed' count
		
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
				DeptCountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				DeptCountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
	
	
//	@Test(priority = 33) not present
	void GradingReportStatutory() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'Grading Report'  Export and OverView");
		
		
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2600 px.
		Thread.sleep(2000);	
		CFOcountPOM.clickRedGrading().click();
		Thread.sleep(7000);	
		WebDriverWait wait = new WebDriverWait( getDriver(),(150));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		
		Thread.sleep(4000);
		
		
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[12]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(1000);
			 CFOcountPOM.clickExportImage().click();
				
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);

				getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					
			
		Thread.sleep(1000);
	//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	
	
//	@Test(priority = 34)
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
	/*		Thread.sleep(3000);
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[6]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = .findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			.switchTo().parentFrame();
			CFOcountPOM.closeView_cal().click();

			test.log(LogStatus.INFO, "overView success");
			.switchTo().parentFrame();
			js.executeScript("window.scrollBy(0,-50)");
			CFOcountPOM.clickAll().click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[3]/div")));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[2]")));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			 CFOcountPOM.clickExportImage().click();
			 Thread.sleep(2000);
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
	By locator1 = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[6]/a");
	
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(2000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton1 = .findElement(locator1);	
				Thread.sleep(4000);
		//	
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", ViewButton1);
				Thread.sleep(4000);
				.switchTo().parentFrame();
				CFOcountPOM.closeView_cal().click();
				test.log(LogStatus.INFO, "overView success");*/
			getDriver().switchTo().parentFrame();
				Thread.sleep(1000);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
				
			extent.endTest(test);
			extent.flush();
	}
	
	/*@Test(priority = 35)
	void DailyUpdates() throws InterruptedException, IOException
	{
		Thread.sleep(2000);		
		test = extent.startTest("'Daily Updates'  OverView");
		
		
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,4800)");					//Scrolling down window by 2600 px.
	//	js.executeScript("window.scrollBy(0,3800)");
		Thread.sleep(1000);	
		if(ApprovalcountPOM.DailyUpdates().isDisplayed()) {
			test.log(LogStatus.PASS, "Daily Updates Displayed.");
		}
		CFOcountPOM.clickViewAllDU().click();
		Thread.sleep(1000);	
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
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 36)
	void NewsLetter() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
	
		 JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,5000)","");					//Scrolling down window by 2600 px.
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
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "OverView Successfully");
		performer.OverduePOM.clickDashboard().click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}		
	
	//@Test(priority = 33)
	void DetailedReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report Count Verification");
		
		
		CFOcountPOM.DetailedReport2(test,  "Department");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 34) 
	void DetailedReportIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Internal Count Verification");
		
		
		DeptCountPOM.DetailedReportIn(test,  "Department");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 56) 
	void DetailedReportFilterDep() throws InterruptedException, IOException
	{
		test = extent.startTest("To check  Detailed report filters working or not Verification");
		
		
		ApprovalcountPOM.DetailedReportFilterDep(test,  "Reviewer");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 35)
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report verification");
		
		
		CFOcountPOM.AssignmentReport(test );
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 58)
	void AssignmentReportFilterDept() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check 'Assignment Report ' Filter Working Or not");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.AssignmentReportFilterDept(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 58)
	void AssignmentReportFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilter1(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 59)
	void ComplianceIDFilterEBDe() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterEBDe(test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 60)
	void ComplianceIDFilterINDe() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterINDe(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 61)
	void ComplianceIDFilter1Invalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilter1Invalid(test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 62)
	void ComplianceIDFilterEBInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterEBInvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 63)
	void ComplianceIDFilterINInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterINInvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 64)
	void ActRepository() throws InterruptedException, IOException
	{
		test = extent.startTest("Act Repository  verification");
		
		
		CFOcountPOM.ActRepository(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65)
	void ActRepositoryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check 'Act Repository Page'  Filters Working or not");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.ActRepositoryFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 61)
	void ComplianceDocumentsFilterDept() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check My Document page All filters working or not.");
		
		DeptCountPOM.ComplianceDocumentsFilterDept(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
/*	@Test(priority = 37)
	void ComplianceDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents  verification");
	
		
		DeptCountPOM.complianceDocuments(test);
				extent.endTest(test);
				extent.flush();
	}*/
	
	//@Test(priority = 38) //	pass	
	void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Critical Document Verification");
		
		
		OverduePOM.CriticalDocuments( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 39)//no record
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
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[5]/a");
		
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
				CFOcountPOM.ViewClose().click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS,   " Act Documents:-After Clicking on View - Document viewer should get open and user should be able to view the document after clicking on view icon for the respective document. ");
			}
			 Actions act =new Actions(getDriver());
	            act.sendKeys(Keys.PAGE_UP).build().perform();
	            Thread.sleep(7000);
	            getDriver().switchTo().defaultContent();
	            Thread.sleep(1000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "  OverView successfully.");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			getDriver().findElement(By.xpath("//*[@id='basic']/tbody/tr[2]/td[2]")).click();
			Thread.sleep(4000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "  File downloaded successfully.");
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	/*
	@Test(priority = 40) // pass
	void MyReminderStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Statutory Count Verification");
		
		OverduePOM.MyReminder( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 41) // pass
	void MyEscalation() throws InterruptedException, IOException
	{
		test = extent.startTest("My  Escalation - Verification");
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		CFOcountPOM.clickMyEscalation().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));	//Wait till records table gets visible
		Thread.sleep(1000);
		List<WebElement> CheckBox=	.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
	CheckBox.get(0).click();
	Thread.sleep(500);
	.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/input")).clear();
	Thread.sleep(1000);
	.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/input")).sendKeys("6");
	Thread.sleep(1000);         
	.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[12]/input")).clear();
	.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[12]/input")).sendKeys("4");
	Thread.sleep(2000);
	.findElement(By.xpath("//*[@id='btnsave']")).click();
	Thread.sleep(2000);
	//List<WebElement> Actions=	.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[13]/a"));
	//Actions.get(1).click();
	Thread.sleep(4000);
	.switchTo().alert().accept();
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "Escalated Successfully");	
	Thread.sleep(1000);
	performer.OverduePOM.clickDashboard().click();
	Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	*/
/*	@Test(priority = 42) // pass
	void MyNotifications() throws InterruptedException, IOException
	{
		test = extent.startTest("My Notifications - Verification");
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		Thread.sleep(8000);
		CFOcountPOM.clickMyNotifications().click();
		Thread.sleep(4000);
		try {
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
		}catch(Exception e){
			test.log(LogStatus.PASS, "No Notifications Found.");	
		}
	//	performer.OverduePOM.clickDashboard().click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 43) // pass
	void MessageCenter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Message Center - Verification");
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		Thread.sleep(8000);
		CFOcountPOM.clickMessageCenter().click();
		Thread.sleep(4000);
		try {
			CFOcountPOM.clickViewMsg().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View Button is clickable");
			Thread.sleep(1000);
			}catch(Exception e){
				test.log(LogStatus.PASS, "No Records Found.");	
			}
		performer.OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	
	 @Test(priority = 44)
		void InternalMsg() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'Internal Msg  '  Verification");
			
				Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait( getDriver(),(40));
			Thread.sleep(500);
			OverduePOM.ClickInternalMsg().click();
			Thread.sleep(4000);
			OverduePOM.ClickTo().sendKeys("mayuri@tlregtech.in");
			Thread.sleep(500);
			OverduePOM.ClickSub().sendKeys("Automation");
			Thread.sleep(1000);
			OverduePOM.TypeMsg().sendKeys("Automation testing");
			Thread.sleep(1000);
			OverduePOM.choosefile().sendKeys("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\Approver.html");
			Thread.sleep(1000);
			//OverduePOM.send().click();
			By locator = By.xpath("//*[@id='btnsendmailNew']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =  getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)  getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Internal Message working Succefully");
			Thread.sleep(1000);
			extent.endTest(test);
			extent.flush();
		}
		
		 @Test(priority = 45)
			void SupportTicket() throws InterruptedException, IOException
			{
				Thread.sleep(1000);		
				test = extent.startTest("'Support Ticket  '  Verification");
				
				
				MethodsPOM.SupportTicket(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 68)
			void DetailedReportReOpen() throws InterruptedException, IOException
			{
				test = extent.startTest("Detailed  Report -Reopen - Closed Timely , Closed Delayed and Not applicable compliance  verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				CFOcountPOM.DetailedReportReOpen(test);
				extent.endTest(test);
				extent.flush();
			}
	 
	
	@Test(priority = 69) //pass 
    void WhatsNew() throws InterruptedException, IOException
			{
				test = extent.startTest("' what's New ' Verification");
				
				MethodsPOM.WhatsNew(test);
				
				extent.endTest(test);
				extent.flush();
			}
	
   @Test(priority = 70)
	void SummaryofOverdueCompliancesAP() throws InterruptedException, IOException
	{
		test = extent.startTest("Summary of Overdue Compliances - To check whether the \"actionable procedure\" can be seen or not in Summary Of Overdue?");
		
		
		MgmtAMethod.SummaryofOverdueCompliancesAPDept(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 71)
	void CompletedPFR_PieChartApD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Completion status graph ?");
		
		
		MgmtAMethod.CompletedPFR_PieChartApD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 72)
	void NotCompletedPFR_PieChartApD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Not Completed status graph?");
		
		
		MgmtAMethod.NotCompletedPFR_PieChartApD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 73)
	void RiskSummaryHighStatutoryApD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Risk summary graph?");
		
		
		MgmtAMethod.RiskSummaryHighStatutoryApD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	 
	@Test(priority = 74)
	void Completed_PieChartPeriodAPD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period)- Completion status graph?");
		
		
		MgmtAMethod.Completed_PieChartPeriodAPD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 75)
	void NotCompleted_PieChartPeriodAPD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period) - Not Completed graph?");
		
		
		MgmtAMethod.NotCompleted_PieChartPeriodAPD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 76)
	void DetailedReportAPD() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in details tab on the view icon of Detailed report?");
		
		
		MgmtAMethod.DetailedReportAPD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 77)
	void CompletedPFR_PieChartMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 78)
	void CompletedPFR_PieChartMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
		@Test(priority = 79)
	void RiskSummaryMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 80)
	void RiskSummaryMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 81)
	void DeptSummaryMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 82)
	void DeptSummaryMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 83)
	void DFPCompletedPFR_PieChartMp() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 84)
	void DFPCompletedPFR_PieChartMpView() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 85)
	void CompletedPFR_PieChartMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 86)
	void CompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 87)
	void RiskSummaryMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 88)
	void RiskSummaryMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 89)
	void DeptSummaryMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 90)
	void DeptSummaryMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 91)
	void DFPCompletedPFR_PieChartMpSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory  Checklist - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 92)
	void DFPCompletedPFR_PieChartMpViewSC() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Statutory Checklist - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpViewSC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 93)
	void CompletedPFR_PieChartMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 94)
	void CompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.CompletedPFR_PieChartMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 95)
	void RiskSummaryMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 96)
	void RiskSummaryMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Risk Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.RiskSummaryMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 97)
	void DeptSummaryMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 98)
	void DeptSummaryMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Department Summary Graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DeptSummaryMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 99)
	void DFPCompletedPFR_PieChartMpIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be download or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 100)
	void DFPCompletedPFR_PieChartMpViewIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) graph - Internal - Mitigation Plan - To check whether the file can be view or not in the popup of compliance mitigation plan?");
		
		
		DeptCountPOM.DFPCompletedPFR_PieChartMpViewIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 101)
	void Reopening() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reopening - To check whether the new tab named \"My Reopening\" is seperately reflects or not on the dashboard in the main menu while the tab will be visible only for who have made the configuration.");
			
		DeptCountPOM.Reopening(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 102)
	void ReopeningRe() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Re-open");
			
		DeptCountPOM.ReopeningRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 103)
	void Reopeningapprove() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Approve");
			
		DeptCountPOM.Reopeningapprove(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 104)
	void ReopeningExport() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reopening - To Check Whether Export button of working or not?");
			
		DeptCountPOM.ReopeningExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 36)
	void DeviationApproverColSOOD() throws InterruptedException, IOException
	{
		test = extent.startTest("Summary of Overdue Compliances - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in summary of overdue of Approver dashboard ?");
			
		CFOcountPOM.DeviationApproverColSOOD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void DeviationClosureStatuscolSOOD() throws InterruptedException, IOException
	{
		test = extent.startTest("Summary of Overdue Compliances - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
			
		CFOcountPOM.DeviationClosureStatuscolSOOD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void DeviationApproverColPSD() throws InterruptedException, IOException
	{
		test = extent.startTest("performance summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the performance summary graph of management  ");
			
		CFOcountPOM.DeviationApproverColPSD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	*/
//	@Test(priority = 37)
	void DeviationApproverColRSD() throws InterruptedException, IOException
	{
		test = extent.startTest("risk summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the risk summary graph of management dashboard ?  ");
			
		CFOcountPOM.DeviationApproverColRSD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
//	@Test(priority = 37)
			void DeviationApproverColDSD() throws InterruptedException, IOException
			{
				test = extent.startTest("department summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the department summary graph of management   ");
					
				CFOcountPOM.DeviationApproverColDSD(test);
				
				extent.endTest(test);
				extent.flush();
			}
	
//	@Test(priority = 37)
	void DeviationApproverColPSDFPD() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance Summary (Due for the period) - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in thePerformance Summary (Due for the period) of management   ");
			
		CFOcountPOM.DeviationApproverColPSDFPD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//	@Test(priority = 38)
		void DetailedReportDA() throws InterruptedException, IOException
		{
			test = extent.startTest("my Report - Detailed  report - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my report page?");
				
			MethodsPOM.DetailedReportDAM(test);
			
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
