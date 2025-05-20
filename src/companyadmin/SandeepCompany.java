package companyadmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

import login.BasePage;

public class SandeepCompany extends BasePage {
	
	public static WebDriver driver = null;		//WebDriver instance created
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
	
/*	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(12);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\Regtrack Merge Project\\Regtrack-Project\\Reports\\CompanyAdminResults.html",true);
		test = extent.startTest("Loging In - Company Admin");
		test.log(LogStatus.PASS, "Logging into system");
		
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,12,"Statutory");
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(2);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		*/
		
	}
	
	public static void progress1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
	

//	@Test(priority = 4)
	void GroupingMaster() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - To check whether the tab of Grouping Master is seen under manage compliances or not.  ");
		
		
		CompanyMethods.GroupingMaster(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	//@Test(priority = 5)
	void GroupingMasterDis() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - To check whether the sub tabs of group master and compliance tagging are seen under the tab of grouping master or not");
		
		
		CompanyMethods.GroupingMasterDis(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 6)
	void GroupMaster() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters -Grouping Master - To check whether the group master tab Clickable or not.");
		
		
		CompanyMethods.GroupMaster(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 7)
	void GroupMasterAN() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - To check whether the Add New tab Clickable or not.");
		
		
		CompanyMethods.GroupMasterAN(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 8)
	void GroupMasterANW() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - To check whether the field of group name is mandatory or not on the popup of add new on the tab of group master..");
		
		
		CompanyMethods.GroupMasterANW(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 9)
	void AddNewGM() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - Add New -  To check whether new group can be added or not.");
		
		
		CompanyMethods.AddNewGM(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 10)
	void AddNewAE() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - Add New - To check whether duplicate group can be added or not.");
		
		
		CompanyMethods.AddNewAE(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 11)
	void UpdateGM() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - Edit - To check whether group can be updated or not.");
		
		
		CompanyMethods.UpdateGM(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 12)
	void DeleteGM() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - To check whether group can be deleted or not.");
		
		
		CompanyMethods.DeleteGM(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 13)
	void DeleteGMT() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - To check whether the group gets deleted or not if compliances are tagged to the group.");
		
		
		CompanyMethods.DeleteGMT(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 14)
	void FilterGM() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Group Master - To check whether the search box is working or not on the tab of group master.");
		
		
		CompanyMethods.FilterGM(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 15)
	void ComplianceTagging() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - To check whether the Compliance Tagging tab Clickable or not.");
		
		
		CompanyMethods.ComplianceTagging(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 16)
	void ComplianceTaggingAN() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Compliance Tagging - To check whether the Add New tab Clickable or not.");
		
		
		CompanyMethods.ComplianceTaggingAN(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 17)
	void FilterCT() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Grouping Master - Compliance Tagging - To check whether the search box is working or not on the tab of compliance tagging .");
		
		
		CompanyMethods.FilterCT(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	//@Test(priority = 20)
	void SecondaryRe() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
		
		
		CompanyMethods.SecondaryRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 21)
	void SecondaryReDisplay() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
		
		
		CompanyMethods.SecondaryReDisplay(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 22)
	void STSecondaryRe() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
		
		
		CompanyMethods.STSecondaryRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 23)
	void STSecondaryReDisplay() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
		
		
		CompanyMethods.STSecondaryReDisplay(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 24)
		void SecondaryReIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details - Internal - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
			
			
			CompanyMethods.SecondaryReIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 25)
		void SecondaryReDisplayIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details - Internal - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
			
			
			CompanyMethods.SecondaryReDisplayIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	//	@Test(priority = 26)
		void STSecondaryReIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details - Internal - To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
			
			
			CompanyMethods.STSecondaryReIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 27)
		void STSecondaryReDisplayIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details - Internal - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
			
			
			CompanyMethods.STSecondaryReDisplayIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		

		
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		Thread.sleep(1000);
  		//driver.close();
  	}	
	
	

}
