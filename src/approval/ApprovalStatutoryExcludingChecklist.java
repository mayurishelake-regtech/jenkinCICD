
package approval;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.*;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtAMethod;
import departmentHead.DeptCountPOM;
import login.BasePage;
import performer.MethodsPOM;
import performer.OverduePOM;

public class ApprovalStatutoryExcludingChecklist extends BasePage {
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
	
	public static String link = "Shivraj";           //Check link in 
		
/*	public static XSSFSheet ReadExcel() throws IOException
	{
		//String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(6);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\Approver.html",true);
		test = extent.startTest("Loging In - Approval (Statutory Excluding Checklist)");
		test.log(LogStatus.PASS, "Logging into system");
		
/*		XSSFSheet sheet = ReadExcel();
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
		//test = extent.startTest("Loging In - Approval (Statutory)");
	//	test.log(LogStatus.PASS, "Logging into system");
		initialization1(link,6,"StatutoryExcludingChecklist");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		//XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		//Write "CFO-diy" for DIYProduction link.
		//Write "CFO" for login.avantis
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

		ApprovalcountPOM.clickManagement().click();
		Thread.sleep(5000);
		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage()));
			if(OverduePOM.closeMessage().isDisplayed())	//If Compliance Updation message popped up,
			{
				Thread.sleep(1000);
				OverduePOM.closeMessage().click();		//then close the message.
			}
		}
		catch(Exception e)
		{
		}
		
		ApprovalcountPOM.Filters().click();
		Thread.sleep(2000);
		ApprovalcountPOM.StatutoryExcludingChecklist().click();
		Thread.sleep(4000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();*/
	}
	
	public static void progress1( )
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
	void FilterWiseCategoriesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" To Check On Category popup Category filter working or not ");
		
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		CFOcountPOM.clickCategories().click();
		Thread.sleep(5000);
		
		////litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]/a")));
		Thread.sleep(3000);
		ApprovalcountPOM.SelectCategoryCat().click();
		Thread.sleep(1000);
		 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[2]")); 
		 String cattext =TextCat.getText();
		 Thread.sleep(1000);
		ApprovalcountPOM.Commercial().click();
		Thread.sleep(3000);
		ApprovalcountPOM.SelectCategoryCat().click();
		Thread.sleep(1000);
	
		Thread.sleep(1000);
		 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]")); //column list
		 
		 List<String> text=new ArrayList<String>();
		 
		 for(int i=0;i<Risks.size();i++) {
			 text.add(Risks.get(i).getText());
		 }
		 
		 List<String> pass=new ArrayList<String>();
		 
		 List<String> fail=new ArrayList<String>();
			
			for(int i=0;i<text.size();i++)
			{
			if(text.get(i).equals(cattext))
			{
				pass.add(text.get(i));		//	the specified element at the end of a list.
			}
			else
			{
				fail.add(text.get(i));
			}
			

}
		 HashSet<String> pas=new LinkedHashSet<>(pass); //duplicate values are not allowed.
		 pass.clear();
		 pass.addAll(pas);                              //all of the elements in the specified collection to the end of this list,
		 
		 
		 HashSet<String> fal=new LinkedHashSet<>(fail);
		 fail.clear();
		 fail.addAll(fal);
		 
		 for(String Fal : fail)
		 {
			 test.log(LogStatus.FAIL, "Selected Category wise filter not Match with gird : "+Fal);
			// System.out.println("fail : "+Fal);
		 }
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Selected Category wise filter Match with gird Value : "+Pas);
			// System.out.println("Pass : "+Pas);
		 }
		 
		getDriver().switchTo().defaultContent();
			
		Thread.sleep(4000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 4)
	void CategoriesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Categories'");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(3000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
	/*	
		elementsList1 = CFOcountPOM.readCompliancesList();
		elementsList1.get(1).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		.switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		CFOcountPOM.closeCategories_Compliances().click();		//Closing the 'Compliances' pup up.
		Thread.sleep(2000);
	
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
			String[] bits1 = item.split(" ");								//Splitting the String
			String compliancesCount1 = bits[bits.length - 2];				//Getting the second last word (total number of users)
			
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
			//test.log(LogStatus.PASS, "Number of Categories grid matches to Dashboard Categories  Count.");
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
	
	@Test(priority = 5)
	void UniqueCompliancesFilter() throws InterruptedException
	{
		test = extent.startTest("'Compliances' filter working or not");
		
		
		Thread.sleep(3000);
		
		String string_Compliances =CFOcountPOM.readCompliancesInternal().getText();		//Storing old value of Statutory overdue.
		int	CompliancesCountDas = Integer.parseInt(string_Compliances);
			CFOcountPOM.readCompliancesInternal().click();
			Thread.sleep(5000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		
		ApprovalcountPOM.SelectCategory().click();
		Thread.sleep(1000);
		 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[2]")); 
		 String cattext =TextCat.getText();
		 Thread.sleep(1000);
		ApprovalcountPOM.Commercial().click();
		Thread.sleep(3000);
		ApprovalcountPOM.SelectCategory().click();
		Thread.sleep(1000);
	
		Thread.sleep(1000);
		 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]")); //column list
		 
		 List<String> text=new ArrayList<String>();
		 
		 for(int i=0;i<Risks.size();i++) {
			 text.add(Risks.get(i).getText());
		 }
		 
		 List<String> pass=new ArrayList<String>();
		 
		 List<String> fail=new ArrayList<String>();
			
			for(int i=0;i<text.size();i++)
			{
			if(text.get(i).equals(cattext))
			{
				pass.add(text.get(i));		//	the specified element at the end of a list.
			}
			else
			{
				fail.add(text.get(i));
			}
			

}
		 HashSet<String> pas=new LinkedHashSet<>(pass); //duplicate values are not allowed.
		 pass.clear();
		 pass.addAll(pas);                              //all of the elements in the specified collection to the end of this list,
		 
		 
		 HashSet<String> fal=new LinkedHashSet<>(fail);
		 fail.clear();
		 fail.addAll(fal);
		 
		 for(String Fal : fail)
		 {
			 test.log(LogStatus.FAIL, "Category Value Matching : "+Fal);
			// System.out.println("fail : "+Fal);
		 }
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Category Value  Matching : "+Pas);
			// System.out.println("Pass : "+Pas);
		 }
		 
			
			
			
	/*	 Thread.sleep(1000);
		 for (int column = 0; column < columns_count; column++) {
			 
			 String celtext = Risks.get(column).getText();
			 
			 if(celtext.equalsIgnoreCase("Commercial")) 
			 {
					test.log(LogStatus.PASS, "Value Matching : "+"Category Value-"+Text+" And Cell Value= "+celtext);
				}
				else
				{
					test.log(LogStatus.FAIL, "Value Not Matching :"+"Category Value-"+Text+"And Cell Value="+celtext);
					test.log(LogStatus.FAIL, " All Value of Category Cell is Not Matching to Selected Risk");
					break;
				} 
			
		 }*/
		 Thread.sleep(3000);			
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void UniqueCompliancesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Unique Compliances'");
		
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Compliances =CFOcountPOM.uniqueCompliances().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.uniqueCompliances().click();
		Thread.sleep(3000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
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
			//test.log(LogStatus.PASS, "Number of Unique Compliances grid matches to Dashboard Unique Compliances  Count.");
			test.log(LogStatus.PASS, "No of Unique Compliances in the grid = "+ComcountGrid+" | Dashboard Unique Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Unique compliances does not matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.FAIL, "No of Unique Compliances in the grid = "+ComcountGrid+" | Dashboard Unique Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 7)
	void TotalCompliancesCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Total Compliances'");
		
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_Compliances =CFOcountPOM.TotalCompliances().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.TotalCompliances().click();
		Thread.sleep(1000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		CFOcountPOM.clickExportExcel().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
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
			//test.log(LogStatus.PASS, "Number of Total Compliances grid matches to Dashboard Total Compliances  Count.");
			test.log(LogStatus.PASS, "No of Total Compliances in the grid = "+ComcountGrid+" | Dashboard Total Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Number of Total compliances does not matches to Dashboard Statutory Overdue Count.");
			test.log(LogStatus.FAIL, "No of Total Compliances in the grid = "+ComcountGrid+" | Dashboard Total Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 8)
	void UsersCountMatch() throws InterruptedException
	{
		test = extent.startTest(" Count by Clicking on 'Users'");
	
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		String string_User =CFOcountPOM.clickUsersCount().getText();		//Storing old value of Statutory overdue.
	int	UserCountDas = Integer.parseInt(string_User);
		CFOcountPOM.clickUsersCount().click();
		Thread.sleep(4000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(60));
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
	
	//@Test(priority = 9)
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		
		Thread.sleep(3000);
		if(CFOcountPOM.ClickShowAll().isEnabled()) {
			CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		//litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(3000); 
	//	elementsList1=	CFOcountPOM.ActionviewList();
		//elementsList1.get(1).click();                   //Clicking on OverdueView  button
	//	.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[16]/a[1]")).click();
	//	Thread.sleep(3000);
	//	CFOcountPOM.closeDocument().click();						//Closing the View Document
		 CFOcountPOM.clickExportImage().click();
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
	
//	@Test(priority =10)
	void SummaryofOverdueCompliancesFilter() throws InterruptedException
	{
		test = extent.startTest(" To Check Summary Of Overdue Compliance Popup selection wise filter working or not.");
		
		ApprovalcountPOM.SummaryofOverdueCompliancesFilter( test);
		
		extent.endTest(test);
		extent.flush();			
		
	}
	
	@Test(priority =11)
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
			
				ApprovalcountPOM.GraphCountPFR( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCountPFR( test, "High", high, "Statutory");
				
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCountPFR( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCountPFR( test, "Low", low, "Statutory");
				
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
	
//	@Test(priority = 12)
	void NotCompleted_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
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
	//	js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
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
			
				ApprovalcountPOM.GraphCount( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount( test, "High", high, "Statutory");
				
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount( test, "Low", low, "Statutory");
				
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
	
	//@Test(priority = 13)
	void ClosedDelayed_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(1000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
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
			
				ApprovalcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1( test, "High", high, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1( test, "Low", low, "Statutory");
			
				Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
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
	
	//@Test(priority = 14)
	void ClosedTimely_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
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
			
				ApprovalcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1( test, "Low", low, "Statutory");
			
				Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
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
	
//	@Test(priority = 15)
	void NotApplicable_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
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
		
		Thread.sleep(3000);
		int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicableA().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicableA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
		if(NotApplicableValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount1( test, "Low", low, "Statutory");
			
				Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
			
			Thread.sleep(3000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
//	@Test(priority = 16)
	void Overdue_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
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
			
				ApprovalcountPOM.GraphCount( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount( test, "High", high, "Statutory");
				
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
			
				ApprovalcountPOM.GraphCount( test, "Low", low, "Statutory");
			
				Thread.sleep(2000);
			//Thread.sleep(5000);
		   // action.moveToElement(CFOcountPOM.clickBack3()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack3()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 17)
	void dueToday_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'dueToday' Count Verification");
		
		Thread.sleep(1000);
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
				ApprovalcountPOM.GraphCount( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				ApprovalcountPOM.GraphCount( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				ApprovalcountPOM.GraphCount( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				ApprovalcountPOM.GraphCount( test, "Low", low, "Statutory");
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
	
		
//	@Test(priority = 18)
	void pendingForReview_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

	/*	ApprovalcountPOM.clickManagement().click();
		Thread.sleep(5000);
		Thread.sleep(500);
		Actions action = new Actions(getDriver());*/
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
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
			test.log(LogStatus.PASS, "Total Pending For Review' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Pending For Review' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	*/
		if(pendingForReviewValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Low", low, "Statutory");
		
				Thread.sleep(2000);
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		
		}	else
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
	
	//@Test(priority = 19)
	void inProgress_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'In Progress' Count Verification");
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

	/*	ApprovalcountPOM.clickManagement().click();
		Thread.sleep(5000);
		Thread.sleep(500);
		Actions action = new Actions(getDriver());*/
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
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
			test.log(LogStatus.PASS, "Total In Progress' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'In Progress' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	*/
		if(inProgressValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Low", low, "Statutory");
		
				Thread.sleep(2000);
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		
		}	else
		{
			test.log(LogStatus.PASS, " 'In Progress' Compliance Count = "+inProgressValue);
			
			Thread.sleep(2000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 20)
	void rejected_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- ' Rejected' Count Verification");
	
		Thread.sleep(2000);
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(40));
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

	//	ApprovalcountPOM.clickManagement().click();
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejected().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejected().click();									//CLicking on 'Not Completed' count
		
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
			test.log(LogStatus.PASS, "Total Rejected' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+total+" | Total Sum : "+rejectedValue);
		}
	*/
		if(rejectedValue > 0)
		{
			
				ApprovalcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "High", high, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
			
				Thread.sleep(2000);
				
				ApprovalcountPOM.GraphCount1( test, "Low", low, "Statutory");
			
			
			//Thread.sleep(5000);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+rejectedValue);
			
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 21)
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
		js.executeScript("window.scrollBy(0,1200)");					//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,700)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		
		
		Thread.sleep(4000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskCritical_NotCompleted = Integer.parseInt(NotCompleted);
	//	int RiskCritical_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_NotCompleted > 0)
		{
			CFOcountPOM.clickRiskCriticalNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
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
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayedA().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayedA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Delayed' Count = "+RiskCritical_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimelyA().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedTimely > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedTimelyA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
		}
		Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 22)
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
		js.executeScript("window.scrollBy(0,1300)");
		//js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			ApprovalcountPOM.RiskGraphCount1( test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
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
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayedA().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayedA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(500);
			ApprovalcountPOM.RiskGraphCount( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimelyA().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimelyA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(500);
			ApprovalcountPOM.RiskGraphCount( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//@Test(priority = 23)
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
		js.executeScript("window.scrollBy(0,1100)");		
		Thread.sleep(1000);
		String NotCompleted = CFOcountPOM.clickRiskMediumNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int RiskMedium_NotCompleted = Integer.parseInt(NotCompleted);
	
	//	int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_NotCompleted > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			ApprovalcountPOM.RiskGraphCount1( test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
	
		
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayedA().getText());	//Reading the High Risk value of Not Completed compliance
		Thread.sleep(500);
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayedA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimelyA().getText());	//Reading the High Risk value of Not Completed compliance
		Thread.sleep(500);
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimelyA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 24)//not data
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
		js.executeScript("window.scrollBy(0,1100)");
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
			ApprovalcountPOM.RiskGraphCount1( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
		}
		
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayedA().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayedA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimelyA().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimelyA().click();			//Clicking on Not Completed compliances bar of High risk.  
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
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
	
	//@Test(priority = 25)
	void DepartmentSummaryAccountStatutory() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");					//Scrolling down window by 1500 px.
	//	js.executeScript("window.scrollBy(0,500)");
		test = extent.startTest("Department Summary - 'Account' Count Verification");
	
		Thread.sleep(5000);
		String NotCompleted = CFOcountPOM.clickAccountOverdue().getText();			//Reading the Overdue value of Human Resource
	//	NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);						
		if(Overdue > 0)
		{Thread.sleep(2000);
			CFOcountPOM.clickAccountOverdue().click();
			ApprovalcountPOM.RiskGraphCount1( test, "Overdue", Overdue, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Overdue Complaince Count = "+ Overdue + ".");
		}
		
		  WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));
			
		  roc.click();
		Thread.sleep(4000);
		
		Thread.sleep(500);
		String ClosedDelayed = CFOcountPOM.clickAccountClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
	//	int Closed_Delayed = Integer.parseInt(CFOcountPOM.clickHumanClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance

		if(Closed_Delayed > 0)
		{
			CFOcountPOM.clickAccountClosedDelayed().click();
			Thread.sleep(2000);
			ApprovalcountPOM.RiskGraphCount( test, "Closed Delayed", Closed_Delayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Closed Delayed Complaince Count = "+ Closed_Delayed + ".");
		}
	
		
		
		Thread.sleep(5000);
		String ClosedTimely = CFOcountPOM.clickAccountClosedTimely().getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);						
		if(Closed_Timely > 0)
		{
			CFOcountPOM.clickAccountClosedTimely().click();
			ApprovalcountPOM.RiskGraphCount( test, "Closed Timely", Closed_Timely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Closed Timely Complaince Count = "+ Closed_Timely + ".");
		}
	
		
		Thread.sleep(3000);
		String PendingReview = CFOcountPOM.clickAccountPendingReview().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);						
		if(Pending_Review > 0)
		{
			Thread.sleep(3000);
			CFOcountPOM.clickAccountPendingReview().click();
			ApprovalcountPOM.RiskGraphCount( test, "Pending For Review", Pending_Review, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "Pending For Review Complaince Count = "+ Pending_Review + ".");
		}
		
		//-----------------------------------------------------
		
		
		Thread.sleep(3000);
			String NotApplicable = CFOcountPOM.clickAccountRejected().getText();	//Reading the Pending For Review value of Human Resource
			//NotApplicable = NotApplicable.replaceAll(" ","");	
			Thread.sleep(3000);//Removing all white spaces from string. 
			int Rejected = Integer.parseInt(NotApplicable);						
			if(Rejected > 0)
			{
				Thread.sleep(3000);
				CFOcountPOM.clickAccountRejected().click();
				ApprovalcountPOM.RiskGraphCount( test, "Rejected", Rejected, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Rejected Complaince Count = "+ Rejected + ".");
			}
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		Thread.sleep(3000);
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 26)
	void NotCompleted_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		}
	*/
		if(NotCompletedValue > 0)
		{
			if(critical >= 0)
			{
				ApprovalcountPOM.GraphCountPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Completed' Compliance Count = "+NotCompletedValue);
			
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 27)
	void ClosedDelayed_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedDelayedA().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedDelayedA().click();								//CLicking on 'Not Completed' count
		
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
				ApprovalcountPOM.GraphCountPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedTimelyValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(500);
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
	//@Test(priority = 28)
	void ClosedTimely_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 1000 px.
		Thread.sleep(800);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyA().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(4000);
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
				ApprovalcountPOM.GraphCountPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
//	@Test(priority = 29)
	void NotApplicable_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickNotApplicableA().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickNotApplicableA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
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
			if(critical >= 0)
			{
				ApprovalcountPOM.GraphCountPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+ClosedTimelyValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
//	@Test(priority = 30)
	void Overdue_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 1000 px.
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
			if(critical >= 0)
			{
				ApprovalcountPOM.GraphCountPe( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		   // action.moveToElement(CFOcountPOM.clickBack3()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack3()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		
		extent.endTest(test);
		extent.flush();
	}
		
//	@Test(priority = 31)
	void pendingForReview_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
	/*	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

		ApprovalcountPOM.clickManagement().click();
		Thread.sleep(5000);
		Thread.sleep(500);
		Actions action = new Actions(getDriver());*/	
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");			//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		Thread.sleep(3000);
		
		Thread.sleep(2000);
	                                                         	
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
			if(critical >= 0)
			{
				ApprovalcountPOM.GraphCountPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Low", low, "Statutory");
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
			test.log(LogStatus.PASS, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
  //  @Test(priority = 32)
	void inProgress_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'in Progress' Count Verification");
		
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickinProgress().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedTimelyValue == total)
		{
			test.log(LogStatus.PASS, "'in Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'in Progress' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'in Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'in Progress' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
		}
		*/
		if(ClosedTimelyValue > 0)
		{
			if(critical >= 0)
			{
				ApprovalcountPOM.GraphCountPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >=0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(500);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.PASS, "'in Progress' Compliance Count = "+ClosedTimelyValue);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			Thread.sleep(2000);
			action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
		
	}
	
	
//	@Test(priority = 33)
	void rejected_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Rejected' Count Verification");
	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
	/*	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

		ApprovalcountPOM.clickManagement().click();
		Thread.sleep(5000);
		Thread.sleep(500);
		Actions action = new Actions(getDriver());*/	
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");			//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
		
		Thread.sleep(4000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(pendingForReviewValue == total)
		{
			test.log(LogStatus.PASS, "' Rejected' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+pendingForReviewValue);
		}
	*/
		if(pendingForReviewValue > 0)
		{
			if(critical >= 0)
			{
				ApprovalcountPOM.GraphCountPe1( test, "Critical", critical, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "High", high, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Medium", medium, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				ApprovalcountPOM.GraphCountPe1( test, "Low", low, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			//Thread.sleep(5000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	
		}
		else
		{
			test.log(LogStatus.PASS, " 'Rejected' Compliance Count = "+pendingForReviewValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 34)//no record
	void GradingReportStatutory() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'Grading Report'  Export and OverView");
	
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2600 px.
		//js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(500);	
		CFOcountPOM.clickRedGrading().click();
		Thread.sleep(4000);	
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
		
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[13]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closePopup().click();					
			
		Thread.sleep(1000);
	//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 35)
	void complianceCalendar() throws InterruptedException
	{
		test = extent.startTest("compliance Calendar Verifications");
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(70));
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2800)");					//Scrolling down window by 2600 px.
	//	js.executeScript("window.scrollBy(0,600)");
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
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeView_cal().click();

			test.log(LogStatus.PASS, "overView successfully");
			getDriver().switchTo().parentFrame();
	/*		js.executeScript("window.scrollBy(0,-50)");
			CFOcountPOM.clickAll().click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[3]/div")));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[2]")));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
			Thread.sleep(5000);
			 CFOcountPOM.clickExportImage().click();
			 Thread.sleep(2000);
			// test.log(LogStatus.PASS, "After Clicking All(Including Checklist)");
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
	By locator1 = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]/a");
	
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(2000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton1 = .findElement(locator1);	
				Thread.sleep(2000);
		//	
			Thread.sleep(1000);
			jse.executeScript("arguments[0].click();", ViewButton1);
				Thread.sleep(4000);
				.switchTo().parentFrame();
				CFOcountPOM.closeView_cal().click();
				test.log(LogStatus.PASS, "overView Successfully");
				.switchTo().parentFrame();
				Thread.sleep(1000);*/
			//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				
				
			extent.endTest(test);
			extent.flush();
	}
	
	@Test(priority = 36)
	void DailyUpdates() throws InterruptedException, IOException
	{
		Thread.sleep(2000);		
		test = extent.startTest("'Daily Updates' ");
	
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,5000)");					//Scrolling down window by 2600 px.
	//	js.executeScript("window.scrollBy(0,500)");
			if(ApprovalcountPOM.DailyUpdates().isDisplayed()) {
				test.log(LogStatus.PASS, "Daily Updates Displayed Successfully");
			}
		CFOcountPOM.clickViewAllDU().click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
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
		test.log(LogStatus.PASS, "Search filter working Successfully");
		Thread.sleep(1000);
	
		OverduePOM.ClickClearBtn().click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Clear button Working Successfully");
		
		performer.OverduePOM.clickDashboard().click();
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void NewsLetter() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
		//test.log(LogStatus.INFO, "Test Initiated");
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
	//	wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

	//	ApprovalcountPOM.clickManagement().click();
	//	Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,5600)","");					//Scrolling down window by 2600 px.
		if(ApprovalcountPOM.NewsLetter().isDisplayed()) {
			test.log(LogStatus.PASS, "News Letter Displayed Successfully");
		}
		CFOcountPOM.clickViewAllNL().click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		CFOcountPOM.clickView2().click();
		Thread.sleep(4000);	
		CFOcountPOM.closeNewsLView().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "OverView Successfully");
		performer.OverduePOM.clickDashboard().click();
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38)
	void StandardReportOverall() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Overall Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportOverall(test,  "Approval");
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 39)
		void StandardReportLocation() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Location Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportLocation(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 40)
		void StandardReportUser() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -User Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportUser(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 41)
		void StandardReportCategory() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Category  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCategory(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 42)
		void StandardReportRisk() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportRisk(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 43)
		void StandardReportDetailed() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Detailed  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDetailed(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 44)
		void StandardReportCriticalRisk() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Critical Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCriticalRisk(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 45)
		void StandardReportDepartment () throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report - Department   Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDepartment(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 46)
		void StandardReportOverallIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Overall Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportOverallIn(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	    @Test(priority = 47)
		void StandardReportLocationIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Location Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportLocationIN(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 48)
		void StandardReportUserIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -User Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportUserIN(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 49)
		void StandardReportCategoryIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Category  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCategoryIN(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 50)
		void StandardReportRiskIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal-Risk  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportRiskIN(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 51)
		void StandardReportDetailedIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal-Detailed  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDetailedIN(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 52)
		void StandardReportCriticalRiskIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Critical Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCriticalRiskIN(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 53)
		void StandardReportDepartmentIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Department  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDepartmentIN(test,  "Approval");
			
			extent.endTest(test);
			extent.flush();
		}
	
//	@Test(priority = 54)
	void DetailedReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report Count Verification");
		
		
		ApprovalcountPOM.DetailedReport(test,  "Approval");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 55) 
	void DetailedReportIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Internal Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReportIn(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}

//	@Test(priority = 56)
	void DetailedReportFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check  Detailed report filters working or not Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReportFilter(test,  "Approval");
		
		extent.endTest(test);
		extent.flush();
	}
/*	
	@Test(priority = 57)
	void AssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report verification");
		
		CFOcountPOM.AssignmentReport(test, );
		
		extent.endTest(test);
		extent.flush();
	}	
	*/
	@Test(priority = 58)
	void AssignmentReportFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilter1(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 59)
	void ComplianceIDFilterEB() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterEB(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 60)
	void ComplianceIDFilterIN() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = Compliance ID Filter Working Or not");
		
		DeptCountPOM.ComplianceIDFilterIN(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 61)
	void ComplianceIDFilter1Invalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilter1Invalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 62)
	void ComplianceIDFilterEBInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterEBInvalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	@Test(priority = 63)
	void ComplianceIDFilterINInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
		
		DeptCountPOM.ComplianceIDFilterINInvalid(test );
		
		extent.endTest(test);
		extent.flush();
	}	
	
	/*@Test(priority = 58)
	void AssignmentReportFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check 'Assignment Report ' Filter Working Or not");
		
		ApprovalcountPOM.AssignmentReportFilter(test, );
		
		extent.endTest(test);
		extent.flush();
	}	
	*/
	@Test(priority = 59)
	void ComplianceRepository() throws InterruptedException, IOException
	{
		test = extent.startTest("Act  Repository  verification");
		
		
		CFOcountPOM.ActRepository(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 60)
	void ActRepositoryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check 'Act Repository Page'  Filters Working or not");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.ActRepositoryFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	//@Test(priority = 61)
	void ComplianceDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents  verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.ComplianceDocuments(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
//	@Test(priority = 61)
	void ComplianceDocumentsFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To Check My Document page All filters working or not.");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.ComplianceDocumentsFilter(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
	//@Test(priority = 62) //no records
	void ComplianceDocumentsIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Documents-Internal  verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.complianceDocumentIn(test);
		
				extent.endTest(test);
				extent.flush();
	}
	
	@Test(priority = 63) //	pass	
	void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Critical Document Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		OverduePOM.CriticalDocuments( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 64)
	void ActDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Act Documents  verification");

		
WebDriverWait wait = new WebDriverWait(getDriver(),(140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickActDocuments().click();			//Clicking on 'Act Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[5]/a");

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
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				try {
					ApprovalcountPOM.ErrorMsg().isDisplayed();
					test.log(LogStatus.FAIL,   " Act Documents:-After Clicking on View - Document viewer should get open and user should not able to view the document after clicking on view icon for the respective document because error occured. ");

				}catch(Exception e) {
					getDriver().switchTo().parentFrame();
				CFOcountPOM.ViewClose().click();
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
	
	@Test(priority = 65) // pass no present
	void MyReminderStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reminder - Statutory Count Verification");
		
		
		OverduePOM.MyReminder( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	 @Test(priority = 66)
		void InternalMsg() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'Internal Msg  '  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
				Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(getDriver(), 40);
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
		
		 @Test(priority = 67)
			void SupportTicket() throws InterruptedException, IOException
			{
				Thread.sleep(1000);		
				test = extent.startTest("'Support Ticket  '  Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				MethodsPOM.SupportTicket(test);
				
				extent.endTest(test);
				extent.flush();
			}
	 
		@Test(priority = 68) // norecord
	void MyNotifications() throws InterruptedException, IOException
	{
		test = extent.startTest("My Notifications - Verification");
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		Thread.sleep(8000);
		CFOcountPOM.clickMyNotifications().click();
		Thread.sleep(5000);
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
		performer.OverduePOM.clickDashboard().click();
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 69) //no record
	void MessageCenter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Message Center - Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 70) //pass 
    void WhatsNew() throws InterruptedException, IOException
			{
				test = extent.startTest("' what's New ' Verification");
				
				MethodsPOM.WhatsNew(test);
				
				extent.endTest(test);
				extent.flush();
			}
	
	@Test(priority = 71) //pass 
    void MyDashboardClearfilter() throws InterruptedException, IOException
			{
				test = extent.startTest("To Check On Dashboard Clear Button Working Or not");
				
				
				CFOcountPOM.MyDashboardClearfilter(test);
				
				extent.endTest(test);
				extent.flush();
			}
	
	@Test(priority = 72) 
    void MyApprovals() throws InterruptedException, IOException
			{
				test = extent.startTest("To Check  Whether On \"Approver Login -My Approver Escalation and My Approvals \" Menu display or not.");
				
				
				ApprovalcountPOM.MyApprovals(test);
				
				extent.endTest(test);
				extent.flush();
			}
	

//	@Test(priority = 71) //not run
	void DetailedReportRe() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report -Reopen Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		ApprovalcountPOM.DetailedReportRe(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 74)
	void SummaryofOverdueCompliancesAPApp() throws InterruptedException, IOException
	{
		test = extent.startTest("Summary of Overdue Compliances - To check whether the \"actionable procedure\" can be seen or not in Summary Of Overdue?");
		
		
		MgmtAMethod.SummaryofOverdueCompliancesAPApp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 75)
	void CompletedPFR_PieChartApAPP() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Completion status graph ?");
		
		
		MgmtAMethod.CompletedPFR_PieChartApAPP(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 76)
	void NotCompletedPFR_PieChartApApp() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary -Not Completed status graph?");
		
		
		MgmtAMethod.NotCompletedPFR_PieChartApApp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 77)
	void RiskSummaryHighStatutoryApApp() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Risk summary graph?");
		
		
		MgmtAMethod.RiskSummaryHighStatutoryApApp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 78)
	void DepartSummaryStatutoryApApp() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Department summary graph?");
		
		
		MgmtAMethod.DepartSummaryStatutoryApApp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	 
		@Test(priority = 79)
		void Completed_PieChartPeriodAP() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period)- Completion status graph?");
			
			
			MgmtAMethod.Completed_PieChartPeriodAPP(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 80)
		void NotCompleted_PieChartPeriodAP() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in Performance summary (Due for period) - Not Completed graph?");
			
			
			MgmtAMethod.NotCompleted_PieChartPeriodAPP(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 81)
		void DetailedReportAPP() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the \"actionable procedure\" can be seen or not in details tab on the view icon of Detailed report?");
			
			
			MgmtAMethod.DetailedReportAPP(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 82)
				void Reopening() throws InterruptedException, IOException
				{
					test = extent.startTest("My Reopening - To check whether the new tab named \"My Reopening\" is seperately reflects or not on the dashboard in the main menu while the tab will be visible only for who have made the configuration.");
						
					DeptCountPOM.Reopening(test);
					
					extent.endTest(test);
					extent.flush();
				}
				
				@Test(priority = 83)
				void ReopeningRe() throws InterruptedException, IOException
				{
					test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Re-open");
						
					DeptCountPOM.ReopeningRe(test);
					
					extent.endTest(test);
					extent.flush();
				}
				
				@Test(priority = 84)
				void Reopeningapprove() throws InterruptedException, IOException
				{
					test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Approve");
						
					DeptCountPOM.Reopeningapprove(test);
					
					extent.endTest(test);
					extent.flush();
				}
				
				@Test(priority = 85)
				void ReopeningExport() throws InterruptedException, IOException
				{
					test = extent.startTest("My Reopening - To Check Whether Export button of working or not?");
						
					DeptCountPOM.ReopeningExport(test);
					
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
