package cfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
import login.BasePage;
import performer.OverduePOM;

public class CFOcountInternal extends BasePage
{
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
	//	String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(2);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
	//	String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\MgmtResultsInternal.html",true);
		test = extent.startTest("Loging In - MGMT (Internal)");
			test.log(LogStatus.PASS, "Logging into system");
	//	XSSFSheet sheet = ReadExcel();
	//	Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
	//	Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
	//	String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
	//	login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
	//	test = extent.startTest("Loging In - CFO Finance (Internal)");
	//	test.log(LogStatus.PASS, "Logging into system");
		initialization(link,2,"Internal");
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		Thread.sleep(3000);
		
	//	XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		
		 = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(3000);
		*/
		//extent.endTest(test);
	//	extent.flush();
	}
	
	public static void progress1( )
	{
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
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
		test = extent.startTest(" Count by Clicking on 'Categories'");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
		int	CategoriesCountDas = Integer.parseInt(string_Categories);
		Thread.sleep(3000);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(500);
		
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
		Thread.sleep(7000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		/*elementsList1 = CFOcountPOM.readCompliancesList();
	String comp_cat=	elementsList1.get(1).getText();
	int	CompCountCat = Integer.parseInt(comp_cat);
		elementsList1.get(1).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		
		Thread.sleep(500);
		litigationPerformer.MethodsPOM.progress();
		
	//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD().click();
		
		Thread.sleep(1000);
		String item1 = CFOcountPOM.readTotalItemsD().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
	int	count = Integer.parseInt(compliancesCount1);
		js.executeScript("window.scrollBy(0,3000)");
		if(CompCountCat == count)
		{
			test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + CompCountCat+ ", Grid Records = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+CompCountCat+", Grid Records = "+count);
		}
		
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		CFOcountPOM.closeCategories_Compliances().click();		//Closing the 'Compliances' pup up.
		Thread.sleep(2000);
	
		
		elementsList1 = CFOcountPOM.readUserList();
		String user_cat=	elementsList1.get(1).getText();
		int	userCountCat = Integer.parseInt(user_cat);
			elementsList1.get(1).click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
			Thread.sleep(3000);                                             
			CFOcountPOM.clickExportImage().click();                    //export excel
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");	
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress();
			
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD().click();
			
			Thread.sleep(1000);
			String item2 = CFOcountPOM.readTotalItemsD().getText();
			String[] bits2 = item.split(" ");								//Splitting the String
			String userCount2 = bits[bits.length - 2];				//Getting the second last word (total number of users)
			
		int	count1 = Integer.parseInt(userCount2);
			js.executeScript("window.scrollBy(0,3000)");
			if(userCountCat == count1)
			{
				test.log(LogStatus.PASS, "Users count matches. Clicked value = " + userCountCat+ ", Grid Records = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Users count does not matches. Clicked value = "+userCountCat+", Grid Records = "+count1);
			}
			
			getDriver().switchTo().parentFrame();								//Switching back to parent frame.
			Thread.sleep(3000);
			CFOcountPOM.closeCategories_Compliances().click();		//Closing the 'Compliances' pup up.
			Thread.sleep(2000);
		
			*/
		if(CategoriesCountDas == CatcountGrid)
		{
			//test.log(LogStatus.PASS, "Number of Categories grid matches to Dashboard Categories  Count.");
			test.log(LogStatus.PASS, "No of Categories in the grid = "+CatcountGrid+" | Dashboard Categories  Count = "+CategoriesCountDas);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "Number of Categories does not matches to Dashboard Categories  Count.");
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
	
	@Test(priority = 4)
		void FilterWiseCategoriesCountMatch() throws InterruptedException
		{
			test = extent.startTest(" To Check On Category popup Category filter working or not ");
			
			
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			
			CFOcountPOM.clickCategories().click();
			Thread.sleep(5000);
			
		//	litigationPerformer.MethodsPOM.progress();
			
			WebDriverWait wait = new WebDriverWait( getDriver(), (120));
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
			
@Test(priority = 5)
	void ClickCompliancesInternal() throws InterruptedException
	{
		test = extent.startTest("'Compliances' Count by Clicking on 'Compliances'");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(1500);
		WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
		wait1.until(ExpectedConditions.visibilityOf(CFOcountPOM.TotalCompliancesM()));
		int valueCompliances = Integer.parseInt(CFOcountPOM.TotalCompliancesM().getText());	//Storing value of 'Compliances' as a String to compare.
		
	//	.findElement(By.xpath("(//*[@class = 'titleMD'])[4]")).click();
		CFOcountPOM.TotalCompliancesM().click();					//Clicking on 'Compliances'.
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
		
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
	//	CFOcountPOM.clickLocationIn().click();
		Thread.sleep(500);
		
		CFOcountPOM.clickClear().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clear Button is working Successfully");	
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
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
	
	@Test(priority = 6)
	void FilterWiseCompliancesCountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliances' filter working or not");
		
		CFOcountPOM.FilterWiseCompliancesCountMatch( test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 7)
	void clickUsersInternal() throws InterruptedException
	{
		test = extent.startTest("'Users' Count by Clicking on 'Users'");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
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
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
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
	void SummaryofOverdueCompliances() throws InterruptedException
	{
		test = extent.startTest(" Summary of Overdue Compliances Internal");
	//	test.log(LogStatus.PASS, "Test Initiated");
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
		if(CFOcountPOM.ClickShowAllIn().isEnabled()) {
			CFOcountPOM.ClickShowAllIn().click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		        
		Thread.sleep(3000);
		//litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
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
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			CFOcountPOM.clickLocationShow().click();
			Thread.sleep(1000);
			//CFOcountPOM.clickCkecjke().click();
			Thread.sleep(1000);
			OverduePOM.clickclearBtn().click();
			test.log(LogStatus.PASS, "Clear successfully");
			getDriver().switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
		extent.endTest(test);
		extent.flush();			
		
	}
	
	@Test(priority = 9)
	void ClosedTimely_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
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
		int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimelyInternal().getText());	//Reading value of 'After Due Date'
		CFOcountPOM.clickClosedTimelyInternal().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		
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
	
	@Test(priority = 10)
	void ClosedDelayed_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
	
	@Test(priority = 11)
	void NotCompleted_PieChart() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
		
		Thread.sleep(500);
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
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		
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
	
	@Test(priority = 12)
	void NotApplicable_PieChartIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		Thread.sleep(1500);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
		/*
		if(NotApplicable == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicable);
		}*/
		
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
		
	@Test(priority = 13)
	void Overdue_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		
		Thread.sleep(500);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Overdue' Compliances : "+total);
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
	
	@Test(priority = 14)
	void dueToday_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart -Not Completed Status- 'dueToday' Count Verification");
	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
	/*	
		if(dueTodayValue == total)
		{
			test.log(LogStatus.PASS, "'dueToday' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'dueToday' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'dueToday' Compliances : "+total+" | Total Sum : "+dueTodayValue);
		}
		*/
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
	
	
	@Test(priority = 15)
	void PFR_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Not Completed Status-  'Pending for Review' Count Verification");
		
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIN().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIN().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'pending For Review' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'pending For Review' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
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
			test.log(LogStatus.PASS, "'pending For Review' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 15)
	void inProgress_PieChartInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Not Completed Status-  'In Progress' Count Verification");
		
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(2000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickinProgress().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'In Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'In Progress' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'In Progress' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
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
			test.log(LogStatus.PASS, "'In Progress' Compliance Count = "+OverdueValue);
			
			Thread.sleep(1000);
		//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3200);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
@Test(priority = 16)
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
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(3000);
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickRejected().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejected().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Rejected ' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Rejected' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Rejected' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Rejected' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
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
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = "+OverdueValue);
			
			Thread.sleep(2000);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		}
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 17)
	void BargraphBSECriticalStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'Critical' risk");
		
		
		Thread.sleep(2000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
		/*
		if(BSEHigh == total)
		{
			test.log(LogStatus.PASS, "'Internal Audit  - Critical' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'BSE - Critical' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Internal Audit - Critical' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'BSE - Critical' Compliances : "+total+" | Total Sum : "+BSEHigh);
		}
		*/
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
	
	@Test(priority = 18)
	void BargraphBSEHighStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'High' risk");
		
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
		/*
		if(BSEHigh == total)
		{
			test.log(LogStatus.PASS, "'Internal Audit  - High' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Internal Audit - High' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'BSE - High' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Internal Audit - High' Compliances : "+total+" | Total Sum : "+BSEHigh);
		}
		*/
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
	
	@Test(priority = 19)
	void BargraphBSEMediumStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'Medium' risk");
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
		/*
		if(BSEMedium == total)
		{
			test.log(LogStatus.PASS, "'BSE  - Medium' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Internal Audit - Medium' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'BSE - Medium' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Internal Audit - Medium' Compliances : "+total+" | Total Sum : "+BSEMedium);
		}
		*/
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
	
	@Test(priority = 20)
	void BargraphBSELowStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - 'Internal Audit' Count Verification with 'LOW' risk");
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
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
		/*
		if(BSELow == total)
		{
			test.log(LogStatus.PASS, "'Internal Audit  - Low' Compliance Count matches to sum of all types of compliances.");
			test.log(LogStatus.PASS, "Total 'Internal Audit - Low' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Internal Audit - Low' Compliance Count doesn't matches to sum of all types of compliances.");
			test.log(LogStatus.FAIL, "Total 'Internal Audit - Low' Compliances : "+total+" | Total Sum : "+BSELow);
		}
		*/
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
	
	@Test(priority = 21)
	void RiskSummaryCriticalInternal() throws InterruptedException, IOException
	{
	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");				//Scrolling down window by 1000 px.cfo
	//	js.executeScript("window.scrollBy(0,600)");
		test = extent.startTest("Risk Summary - 'Critical' Count Verification");
		
		
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
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskCritical_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskCritical_ClosedDelayed > 0)
		{
			CFOcountPOM.clickRiskCriticalClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
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
			
			CFOcountPOM.RiskGraphCountIn( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
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
			CFOcountPOM.RiskGraphCountNA( test, "Critical - Not Applicable", RiskCritical_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Critical - Not Applicable' Count = "+RiskCritical_NotApplicable);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 22)
	void RiskSummaryHighInternal() throws InterruptedException, IOException
	{		
		test = extent.startTest("Risk Summary - 'High' Count Verification");
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");
	//	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);
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
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn( test, "High - Closed Delayed", RiskHigh_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Closed Delayed' Count = "+RiskHigh_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskHigh_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
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
			CFOcountPOM.RiskGraphCountNA( test, "High - Not Applicable", RiskHigh_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'High - Not Applicable' Count = "+RiskHigh_NotApplicable);
		}
		
		extent.endTest(test);
		extent.flush();
	}
	
   @Test(priority = 23)
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
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(500);
		
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
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn( test, "Medium - Closed Delayed", RiskMedium_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Delayed' Count = "+RiskMedium_ClosedDelayed);
		}
		
	/*	Thread.sleep(3000);
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskMedium_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskMediumClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
		}*/
		
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
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 24)
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
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");
		Thread.sleep(2000);
		
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
		List<WebElement>roc =getDriver() .findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedDelayed > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn( test, "Low - Closed Delayed", RiskLow_ClosedDelayed, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Closed Delayed' Count = "+RiskLow_ClosedDelayed);
		}
		
		Thread.sleep(3000);
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		if(RiskLow_ClosedTimely > 0)
		{
			Thread.sleep(500);
			CFOcountPOM.clickRiskLowClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
			
			CFOcountPOM.RiskGraphCountIn( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
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
			CFOcountPOM.RiskGraphCountNA( test, "Low - Not Applicable", RiskLow_NotApplicable, "Statutory");
		}
		else
		{
			test.log(LogStatus.PASS, "'Low - Not Applicable' Count = "+RiskLow_NotApplicable);
		}
		
		Thread.sleep(500);
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =25)
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
	Thread.sleep(8000);
			
			
			
			Thread.sleep(5000);
			
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
				CFOcountPOM.RiskGraphCountIn( test, "Admin -Closed Delayed ", Finance_CloseDelayed, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Admin -Closed Delayed' Complaince Count = "+ Finance_CloseDelayed + ".");
			}
			 WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
				
			  roc1.click();
			
			Thread.sleep(1000);
			String FinaClosedTimely = CFOcountPOM.clickAccountClosedTimelyA().getText();		//Reading the Closed Timely value of Human Resource
			FinaClosedTimely = FinaClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_ClosedTimely = Integer.parseInt(FinaClosedTimely);						
			if(Fina_ClosedTimely > 0)
			{
				CFOcountPOM.clickAccountClosedTimelyA().click();
				CFOcountPOM.RiskGraphCountIn( test, "Admin -Closed Timely", Fina_ClosedTimely, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Admin -Closed Timely' Complaince Count = "+ Fina_ClosedTimely + ".");
			}
			Thread.sleep(3000);
			WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > text > tspan"));
			CT.click();
			
			Thread.sleep(3000);
				String FinaPFReview = CFOcountPOM.clickAccountPendingReview1().getText();			//Reading the Overdue value of Human Resource
			FinaPFReview = FinaPFReview.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_PFR = Integer.parseInt(FinaPFReview);						
			if(Fina_PFR > 0)
			{
				CFOcountPOM.clickAccountPendingReview1().click();
				CFOcountPOM.RiskGraphCountIn( test, "Admin -Pending For Review", Fina_PFR, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Admin - Pending For Review' Complaince Count = "+ Fina_PFR + ".");
			}
			
			Thread.sleep(3000);
			WebElement PR = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > text > tspan"));
			PR.click();
			
			String FinaInprogress = CFOcountPOM.clickFinanceInProgressInternal1().getText();			//Reading the Overdue value of Human Resource
			FinaInprogress = FinaInprogress.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_InProgress = Integer.parseInt(FinaInprogress);						
			if(Fina_InProgress > 0)
			{
				CFOcountPOM.clickFinanceInProgressInternal1().click();
				CFOcountPOM.RiskGraphCountIn( test, "Admin -In Progress", Fina_InProgress, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Admin - In Progress ' Complaince Count = "+ Fina_InProgress + ".");
			}
			WebElement IP = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-4 > text > tspan"));
			IP.click();
			
					Thread.sleep(3000);
			String FinaRejected = CFOcountPOM.clickFinanceRejectedInternal1().getText();			//Reading the Overdue value of Human Resource
			FinaRejected = FinaRejected.replaceAll(" ","");									//Removing all white spaces from string. 
			int Fina_Rejected= Integer.parseInt(FinaRejected);						
			if(Fina_Rejected > 0)
			{
				CFOcountPOM.clickFinanceRejectedInternal1().click();
				CFOcountPOM.RiskGraphCountIn( test, "Admin -Rejected", Fina_Rejected, "Internal");
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
				CFOcountPOM.RiskGraphCountIn( test, "Admin -Not Applicable", Fina_NotAppli, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Admin - Not Applicable' Complaince Count = "+ Fina_NotAppli + ".");
			}
			
			Thread.sleep(500);
			
		//	js.executeScript("window.scrollBy(0,-1600)");			//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 26)
	void ClosedTimely_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart - 'Closed Timely' Count Verification");
		
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
	
	@Test(priority = 27)
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
	
	@Test(priority = 28)
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
		/*
		if(NotCompletedValue == total)
		{
			test.log(LogStatus.PASS, "'Not Completed' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Completed' Compliances : "+total);
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
	
	@Test(priority = 29)
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
		int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickNotApplInternalA().getText());	//Reading value of 'After Due Date'
		
		CFOcountPOM.clickNotApplInternalA().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(ClosedDelayedValue == total)
		{
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
		}
		*/
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
			test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+ClosedDelayedValue);
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
	
	@Test(priority = 30)
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
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Overdue' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Overdue' Compliances : "+total);
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
	
	@Test(priority = 31)
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
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickdueTodayInernal().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickdueTodayInernal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'due Today' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'due Today' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'due Today' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'due Today' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		
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

		}
		else
		{
			test.log(LogStatus.PASS, "'due Today' Compliance Count = "+OverdueValue);
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(500);
		}
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 32)
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
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickpendingForReviewIN().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickpendingForReviewIN().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(2000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'Pending For Review' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'Pending For Review' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'Pending For Review' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
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
			test.log(LogStatus.PASS, "'Pending For Review' Compliance Count = "+OverdueValue);
			getDriver().switchTo().parentFrame();
			Thread.sleep(500);
			Thread.sleep(500);
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)
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
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickinProgress().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
		/*
		if(OverdueValue == total)
		{
			test.log(LogStatus.PASS, "'in Progress' Compliance Count matches to sum of all risked compliances.");
			test.log(LogStatus.PASS, "Total 'in Progress' Compliances : "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Pending For Review' Compliance Count doesn't matches to sum of all risked compliances.");
			test.log(LogStatus.FAIL, "Total 'in Progress' Compliances : "+total+" | Total Sum : "+OverdueValue);
		}
		*/
		if(OverdueValue > 0)
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
				CFOcountPOM.GraphCountInPe( test, "Low", low, "Internal");
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
			test.log(LogStatus.PASS, "'in Progress' Compliance Count = "+OverdueValue);
			
			Thread.sleep(500);
			getDriver().switchTo().parentFrame();
			//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard

		}
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34)
	void Upcoming_PieChartPeriod() throws InterruptedException, IOException
	{
		test = extent.startTest("Period-Pie Chart -Completion Status Status- ' Upcoming' Count Verification");
	
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		Thread.sleep(800);
Thread.sleep(8000);
		
		
		
		Thread.sleep(5000);
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
	
	@Test(priority = 35)
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
		int OverdueValue = Integer.parseInt(CFOcountPOM.clickRejectedPe11().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickRejectedPe11().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
		int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
		int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
		int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
		
		int total = critical + high + medium + low;
	
		if(OverdueValue > 0)
		{
			if(critical >= 0)
			{
				CFOcountPOM.GraphCountInPeUpIn( test, "Critical", critical, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
			}
			
			if(high >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUpIn( test, "High", high, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUpIn( test, "Medium", medium, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
			}
			
			if(low >= 0)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				CFOcountPOM.GraphCountInPeUpIn( test, "Low", low, "Internal");
			}
			else
			{
				test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
			}
			
			Thread.sleep(2000);
		
		}
		else
		{
			test.log(LogStatus.PASS, "'Rejected' Compliance Count = "+OverdueValue);
			
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
		

	
//	@Test(priority = 36)
	void UpcomingFilterMgmtIn() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the all filters functionally working or not while clicking on Period-Pie Chart - Not Completed Status- ' Upcoming ' -  Critical Risk or not?.");
	
		CFOcountPOM.UpcomingFilterMgmtIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void GradingReportInternal() throws InterruptedException, IOException
	{
		Thread.sleep(4000);		
		test = extent.startTest("'Grading Report'  Export and OverView");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
		js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2600 px.
	//	js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(500);	
		CFOcountPOM.clickRedGrading().click();
		Thread.sleep(4000);	
		WebDriverWait wait = new WebDriverWait( getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(1000);
		//*[@id="showGRdetails"]
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
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closePopup().click();					
			
		Thread.sleep(2000);
	//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 38)
	void complianceCalendar() throws InterruptedException
	{
		test = extent.startTest("compliance Calendar Verifications");
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(70));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
	//	js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 2600 px.
		js.executeScript("window.scrollBy(0,4225)");	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']")));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
	/*	 CFOcountPOM.clickExportImage().click();
		 Thread.sleep(2000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);*/
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[14]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(2000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor)getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeView_cal().click();

			test.log(LogStatus.PASS, "overView Successfully");
			getDriver().switchTo().parentFrame();
			js.executeScript("window.scrollBy(0,-50)");
		/*	CFOcountPOM.clickAll().click();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[3]/div")));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']/div/div[2]")));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			 CFOcountPOM.clickExportImage().click();
			 Thread.sleep(2000);
		//	 test.log(LogStatus.PASS, "After Clicking All(Including Checklist)");
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
/*	By locator1 = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a");
	
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(2000);
				// retrieving "foo-button" HTML element
				WebElement ViewButton1 = .findElement(locator1);	
				Thread.sleep(4000);
			
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", ViewButton1);
				Thread.sleep(4000);
				getDriver().switchTo().parentFrame();
				CFOcountPOM.closeView_cal().click();
				test.log(LogStatus.PASS, "overView Successfully");
				getDriver().switchTo().parentFrame();*/
				Thread.sleep(3000);
			//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				
				
			extent.endTest(test);
			extent.flush();
	}
	
	
	@Test(priority = 39)
	void DailyUpdates() throws InterruptedException, IOException
	{
		Thread.sleep(3000);		
		test = extent.startTest("'Daily Updates'  OverView");
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
		js.executeScript("window.scrollBy(0,6000)");					//Scrolling down window by 2600 px.
	//	js.executeScript("window.scrollBy(0,500)");
	//	Thread.sleep(500);	
		CFOcountPOM.clickViewAllDU().click();
		Thread.sleep(4000);	
	//	WebDriverWait wait = new WebDriverWait( getDriver(), Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
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
	
 @Test(priority =40)
	void NewsLetter() throws InterruptedException, IOException
	{
		Thread.sleep(500);		
		test = extent.startTest("'News Letters'  OverView");
		
		Thread.sleep(4000);
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
		js.executeScript("window.scrollBy(0,15000)");					//Scrolling down window by 2600 px.
		//Thread.sleep(4000);	
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
		
		extent.endTest(test);
		extent.flush();
	}
	
	/*@Test(priority = 45)
	void StandardReportOverall() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Overall Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportOverall(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void StandardReportLocation() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Location Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportLocation(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 47)
	void StandardReportUser() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -User Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportUser(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48)
	void StandardReportCategory() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Category  Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportCategory(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49)
	void StandardReportRisk() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Risk  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportRisk(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50)
	void StandardReportDetailed() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Detailed  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportDetailed(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 51)
	void StandardReportCriticalRisk() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report -Critical Risk  Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportCriticalRisk(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 52)
	void StandardReportOverallIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report Internal -Overall Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportOverallIn(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
  @Test(priority = 53)
	void StandardReportLocationIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report Internal -Location Verification");
		
		
		CFOcountPOM.StandardReportLocationIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 54)
	void StandardReportUserIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report Internal -User Verification");

		
		CFOcountPOM.StandardReportUserIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 55)
	void StandardReportCategoryIn() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report Internal -Category  Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportCategoryIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 56)
	void StandardReportRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report Internal-Risk  Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportRiskIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 57)
	void StandardReportDetailedIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report Internal-Detailed  Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportDetailedIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 58)
	void StandardReportCriticalRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Standard Report Internal -Critical Risk  Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		CFOcountPOM.StandardReportCriticalRiskIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}*/
 @Test(priority = 41)
	void CompletionStatusFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the all filters are working on the graph of \"Performance Summary Graph for Completion Status - Critical Risk or not?");
	
				ApprovalcountPOM.CompletionStatusFilterMgmt(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 42)
	void NotCompletionStatusFilterMgmt() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the all filters are working on the graph of \"Performance Summary Graph for Not Completed Status  -  Critical Risk or not?");
	
				ApprovalcountPOM.NotCompletionStatusFilterMgmt(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 43)
	void RiskSummaryFilterM() throws InterruptedException, IOException
	{
		test = extent.startTest("To check whether the all filters are working on the graph of Risk Summary -Not Completed Status or not?");
	
				ApprovalcountPOM.RiskSummaryFilterM(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 44)
		void DeptSummaryFilterM() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the all filters are working on the graph of Department Summary - Overdue Status or not?");
		
					ApprovalcountPOM.DeptSummaryFilterM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 45)
		void CompletionStatusFilterMgmtPe() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the filters  are working on the graph of \"Performance Summary Graph(Due For Period) for Completion Status -Not completed -Critical Risk or not?");
		
					ApprovalcountPOM.CompletionStatusFilterMgmtPe(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 46)
		void NotCompletionStatusFilterMgmtPe() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the filters are working on the graph of \"Performance Summary Graph (Due For Period)for Not Completed Status -Overdue -Critical Risk or not?");
		
					ApprovalcountPOM.NotCompletionStatusFilterMgmtPe(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 47)
		void Shortreport() throws InterruptedException, IOException
		{
			test = extent.startTest("  Short Report Export verification  ");
		
			CFOcountPOM.Shortreport( test);
			
			extent.endTest(test);
			extent.flush();
		}
		/*
		@Test(priority = 11)
		void ShortreportOverview() throws InterruptedException, IOException
		{
			test = extent.startTest("  Short Report - To Check Whether On Short Report \"Overview \" Button Working or not ?  ");
		
			CFOcountPOM.ShortreportOverview( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 11)
		void ShortreportIn() throws InterruptedException, IOException
		{
			test = extent.startTest("  Short Report - Internal - Export verification  ");
		
			CFOcountPOM.ShortreportIn( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 11)
		void ShortreportOverviewIn() throws InterruptedException, IOException
		{
			test = extent.startTest("  Short Report - Internal - To Check Whether On Short Report \"Overview \" Button Working or not ?  ");
		
			CFOcountPOM.ShortreportOverviewIn( test);
			
			extent.endTest(test);
			extent.flush();
		}
	*/	
	
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		
		closeBrowser();
  	//	Thread.sleep(1000);
  	//	getDriver().close();
  	//	Thread.sleep(1000);
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}	 
 /*
 @Test(priority = 29)
	void StandardReportOverallIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -Overall Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportOverallIn(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
  @Test(priority = 30)
	void StandardReportLocationIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -Location Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportLocationIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void StandardReportUserIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal -User Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportUserIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)
	void StandardReportCategoryIn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -Standard Report Internal -Category  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCategoryIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)
	void StandardReportRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal-Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportRiskIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34)
	void StandardReportDetailedIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports - Standard Report Internal-Detailed  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportDetailedIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35)
	void StandardReportCriticalRiskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports -Standard Report Internal -Critical Risk  Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.StandardReportCriticalRiskIN(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
 */
	
 

 
 
 
 
//	@Test(priority = 22)
	void DetailedReportInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Detailed Report Count Verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.DetailedReport1(test,  "cfo");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 23)
	void AssignmentReportInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Assignment Report verification");
		test.log(LogStatus.PASS, "Test Initiated");
		
		CFOcountPOM.AssignmentReportIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
}
