package performer;

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

import login.BasePage;

public class MyLeave extends BasePage  {
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
	
	public static String link = "amruta";           //Check link in excel sheet first.
			
		
	/*
	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("C:/March2022/PerformerPom/TestData/ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(10);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("C:/March2022/PerformerPom/Reports/CFOResultsStatotory.html",true);
		test = extent.startTest("Verify OpenBrowser");
		test.log(LogStatus.INFO, "Browser test is initiated");
		
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		
		initialization(link,10,"Statutory");
	/*	test = extent.startTest("Loging In - CFO Finance (Statutory)");
		test.log(LogStatus.INFO, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();*/
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
	
//	@Test(priority = 2)//pass
	void ApplyLeave() throws InterruptedException
	{
		test = extent.startTest("Apply Leave Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		Thread.sleep(3000);
		OverduePOM.ClickBtn().click();
		Thread.sleep(3000);
		OverduePOM.ClickMyLeave().click();
		Thread.sleep(2000);
		OverduePOM.ClickAddNew().click();
		Thread.sleep(2000);
		OverduePOM.StartDate().sendKeys("19-12-2022");
		Thread.sleep(500);
		OverduePOM.EndDate().sendKeys("22-12-2022");
		Thread.sleep(1000);
		Select performer=new Select(OverduePOM.userPerformer());
		Thread.sleep(1000);
		performer.selectByIndex(4);
		Thread.sleep(4000);
		Select Reviewer=new Select(OverduePOM.userReviewer());
		Thread.sleep(1000);
		Reviewer.selectByIndex(2);
		Thread.sleep(4000);
		OverduePOM.saveBtn().click();
		Thread.sleep(1000);
		
		OverduePOM.clickDashboard().click();	
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Add new Leave Succefully");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)//pass
	void TemporaryAssignmentSat() throws InterruptedException
	{
		test = extent.startTest("Temporary Assignment Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		Thread.sleep(3000);
		OverduePOM.ClickBtn().click();
		Thread.sleep(3000);
		OverduePOM.ClickMyLeave().click();
		Thread.sleep(2000);
		OverduePOM.ClickTemAss().click();
		OverduePOM.ClickTemAss().click();
		Thread.sleep(8000);
		OverduePOM.ClickAddNew().click();
		Thread.sleep(7000);
	OverduePOM.StartDateAssign().sendKeys("18-12-2022");
		Thread.sleep(500);
		OverduePOM.EndDateAssign().sendKeys("22-12-2022");
		Thread.sleep(1000);
		Select performer=new Select(OverduePOM.userPerformerAssign());
		Thread.sleep(1000);
		performer.selectByIndex(4);
		Thread.sleep(4000);
		Select Reviewer=new Select(OverduePOM.userReviewerAsssign());
		Thread.sleep(1000);
		Reviewer.selectByIndex(4);
		
	//	Select owner=new Select(OverduePOM.ClickEventOwer());
		//Thread.sleep(1000);
	//	Reviewer.selectByIndex(1);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,300)");	
		OverduePOM.clickCheckBox().click();
		Thread.sleep(500);
		
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
		Thread.sleep(500);
		OverduePOM.saveBtnAssign().click();
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();	
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Temporary Assignment Add Succefully");
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 4)//pass
	void TemporaryAssignmentIn() throws InterruptedException
	{
		test = extent.startTest("Temporary Assignment-Internal Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		Thread.sleep(3000);
		OverduePOM.ClickBtn().click();
		Thread.sleep(3000);
		OverduePOM.ClickMyLeave().click();
		Thread.sleep(2000);
		OverduePOM.ClickTemAss().click();
		
		Thread.sleep(8000);
		OverduePOM.ClickAddNew().click();
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_rblcompliancetype']/tbody/tr/td[2]/label")));
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rblcompliancetype']/tbody/tr/td[2]/label")).click();
		Thread.sleep(7000);
	OverduePOM.StartDateAssign().sendKeys("18-12-2022");
		Thread.sleep(500);
		OverduePOM.EndDateAssign().sendKeys("22-12-2022");
		Thread.sleep(1000);
		Select performer=new Select(OverduePOM.userPerformerAssign());
		Thread.sleep(1000);
		performer.selectByIndex(4);
		Thread.sleep(4000);
		Select Reviewer=new Select(OverduePOM.userReviewerAsssign());
		Thread.sleep(1000);
		Reviewer.selectByIndex(5);
		
		Thread.sleep(1000);
		OverduePOM.clickCheckBox().click();
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
		Thread.sleep(500);
		OverduePOM.saveBtnAssign().click();
		Thread.sleep(500);
		OverduePOM.clickDashboard().click();	
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Temporary Assignment Add Succefully");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)//pass
	void EditLeave() throws InterruptedException
	{
		test = extent.startTest("Edit Leave Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		Thread.sleep(3000);
		OverduePOM.ClickBtn().click();
		Thread.sleep(3000);
		OverduePOM.ClickMyLeave().click();
		Thread.sleep(7000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']")).click();
		Thread.sleep(500);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']/option[4]")).click();
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLeave_LinkButton1_3']")).click();
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='AuditAssignmentnew']")));
		Thread.sleep(500);
		Select performer=new Select(OverduePOM.userPerformerAssign());
		Thread.sleep(1000);
		performer.selectByIndex(6);
		Thread.sleep(4000);
		Select Reviewer=new Select(OverduePOM.userReviewerAsssign());
		Thread.sleep(1000);
		Reviewer.selectByIndex(2);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
		Thread.sleep(500);
		OverduePOM.saveBtnAssign().click();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Edit Leave Succefully");
		OverduePOM.cancelLeave().click();
		Thread.sleep(4000);
		OverduePOM.saveBtnCancel().click();
		Thread.sleep(1000);
		test.log(LogStatus.INFO, "Cancel Leave Succefully");
		OverduePOM.clickDashboard().click();	
		Thread.sleep(1000);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		//Thread.sleep(1000);
  	//	get().close();
  	}
	
}