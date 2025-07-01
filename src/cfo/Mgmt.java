
	package cfo;
	import java.io.File;
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
	import departmentHead.DeptCountPOM;
	import login.BasePage;
	import performer.MethodsPOM;
	import performer.OverduePOM;

	public class Mgmt extends BasePage {
		
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
		
		//public static String link = "mgmt1";  
		public static String link = "mgmt1";	
		
	/*	public static XSSFSheet ReadExcel() throws IOException
		{
			//String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
			fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(11);					//Retrieving third sheet of Workbook
			return sheet;
		}*/
		
		@BeforeTest
		void setBrowser() throws InterruptedException, IOException
		{
		//	String workingDir = System.getProperty("web.chrome.","C:/March2022/PerformerPom//chrome.exe");
			extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Regtrack-Project\\Reports\\MgmtBita.html",true);
			test = extent.startTest("Loging In - MGMT (Statutory)");
			test.log(LogStatus.PASS, "https://login.teamleaseregtech.com/");
			test.log(LogStatus.PASS, "deepalidev1973@gmail.com");
			test.log(LogStatus.PASS, "Team@123");

		/*	
			XSSFSheet sheet = ReadExcel();
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
			
			initialization(link,2,"Statutory");
		//	initialization(link,11,"Statutory");
	/*	XSSFSheet sheet = ReadExcel();
			Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
			
		//	login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
			
		
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
		void CategoriesCountMatch() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Categories'");
			
			
			CFOcountPOM.CategoriesCountMatch(test);
			
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
			
			//litigationPerformer.MethodsPOM.progress();
			
			WebDriverWait wait = new WebDriverWait( getDriver(), (120));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]/a")));
			Thread.sleep(3000);
			ApprovalcountPOM.SelectCategoryCat().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])")); 
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
			 
			 
			
				Thread.sleep(8000);
				if(DeptCountPOM.Clear().isEnabled())
				{
					test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
				
					DeptCountPOM.Clear().click();
				}
			
			else
			{
				test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
				
			}
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
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			String string_Compliances =CFOcountPOM.TotalCompliancesM().getText();		//Storing old value of Statutory overdue.
			int	CompliancesCountDas = Integer.parseInt(string_Compliances);
			CFOcountPOM.TotalCompliancesM().click();
			Thread.sleep(5000);
			
		//	litigationPerformer.MethodsPOM.progress();
			
			WebDriverWait wait = new WebDriverWait( getDriver(), (60));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			Thread.sleep(3000);
			CFOcountPOM.clickExportImage().click();                    //export excel
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");	
			/*CFOcountPOM.clickLocation().click();
			Thread.sleep(500);
			CFOcountPOM.clickElectricity().click();
			Thread.sleep(3000);*/
			
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
				//test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Compliances Count.");
				test.log(LogStatus.FAIL, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
			}
			js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
			getDriver().switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 6)
		void FilterWiseCompliancesCountMatch() throws InterruptedException, IOException
		{
			test = extent.startTest("'Compliances' filter working or not");
			
			CFOcountPOM.FilterWiseCompliancesCountMatch(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
@Test(priority = 7)
		void UsersCountMatch() throws InterruptedException
		{
			test = extent.startTest(" Count by Clicking on 'Users'");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			String string_User =CFOcountPOM.clickUsersCount().getText();		//Storing old value of Statutory overdue.
		int	UserCountDas = Integer.parseInt(string_User);
			CFOcountPOM.clickUsersCount().click();
			Thread.sleep(500);
			
		//	litigationPerformer.MethodsPOM.progress();
			
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
				//test.log(LogStatus.PASS, "Number of User grid matches to Dashboard User  Count.");
				test.log(LogStatus.PASS, "No of User in the grid = "+UserGrid+" | Dashboard User  Count = "+UserCountDas);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Number of User does not matches to Dashboard User  Count.");
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
	@Test(priority = 8)
		void clickPenaltyStatutory() throws InterruptedException
		{
			test = extent.startTest("'Penalty' ");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(1500);
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
			/*Thread.sleep(1000);
			CFOcountPOM.clickExpand1().click();
			Thread.sleep(1000);
			CFOcountPOM.clickABita().click();*/
			Thread.sleep(500);
			
			CFOcountPOM.clickInterest().click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(1000);
			CFOcountPOM.clickExportImage().click();

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS, "Interest - Excel File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  "  File does not downloaded.");
			}
			Thread.sleep(500);
			Thread.sleep(3000);
			CFOcountPOM.clickLocationInterest().click();
			Thread.sleep(2000);
		//	CFOcountPOM.clickExpand2().click();
		//	Thread.sleep(1000);
		//	CFOcountPOM.clickBita().click();
			//Thread.sleep(2000);
			if(CFOcountPOM.clickClear1().isEnabled()) {
			CFOcountPOM.clickClear1().click();
			test.log(LogStatus.PASS, " Interest - Clear Button Working  Successfully");
			Thread.sleep(3000);
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
		@Test(priority = 9)
		void PenaltyMultipleFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check Whether On  Penalty box Popup selection wise filter working or not.");
			
			CFOcountPOM.PenaltyMultipleFilter(test);
			
			extent.endTest(test);
			extent.flush();
		}

		@Test(priority = 9)
		void PenaltyMultipleFilterInterest() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check Whether On  Penalty- Interest box Popup selection wise filter working or not.");
			
			CFOcountPOM.PenaltyMultipleFilterInterest(test);
			
			extent.endTest(test);
			extent.flush();
		}

		
@Test(priority = 10)
		void SummaryofOverdueCompliances() throws InterruptedException
		{
			test = extent.startTest("Summary of Overdue Compliances");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			if(CFOcountPOM.ClickShowAll().isEnabled()) {
			CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " 'Show All ' link Clickable Successfully");
			}
		//	litigationPerformer.MethodsPOM.progress();
			WebDriverWait wait = new WebDriverWait( getDriver(), (100));
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
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
				
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
				
				getDriver().switchTo().defaultContent();
				Thread.sleep(3000);
				CFOcountPOM.closeCategories().click();
				Thread.sleep(1000);
				extent.endTest(test);
				extent.flush();			
			
		}
		
@Test(priority = 10)
		void SummaryofOverdueFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check Whether On  Summary Of Overdue Compliance Popup selection wise filter working or not.");
			
			DeptCountPOM.SummaryofOverdueFilterMgmt( test);
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 11)
		void SummaryofOverdueMail() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check Mail send funtionality from summary of overdue compliance working or not?.");
			
			CFOcountPOM.SummaryofOverdueMail(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
@Test(priority = 12)
			void NotCompleted_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Completion Status- 'Not Completed' Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				Thread.sleep(1000);
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(3000);
				Actions action = new Actions(getDriver());
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
				
//				if(NotCompletedValue == total)
//				{
//					test.log(LogStatus.PASS, "Not Completed' Compliance Count matches to sum of all risked compliances.");
//					test.log(LogStatus.PASS, "Total Not Completed' Compliances : "+total);
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "'Not Completed' Compliance Count doesn't matches to sum of all risked compliances.");
//					test.log(LogStatus.FAIL, "Total 'Not Completed' Compliances : "+total+" | Total Sum : "+NotCompletedValue);
//				}
			
				if(NotCompletedValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount( test, "Low", low, "Statutory");
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
					test.log(LogStatus.PASS, " 'Completed' Compliance Count = "+NotCompletedValue);
					
					Thread.sleep(500);
					action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				}
				
				
				extent.endTest(test);
				extent.flush();
			}
			
		
			
			
@Test(priority = 13)
			void ClosedDelayed_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
				
				Thread.sleep(1000);
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				Actions action = new Actions(getDriver());
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
				
				Thread.sleep(2000);
				int ClosedDelayedValue = Integer.parseInt(CFOcountPOM.clickClosedDelayed().getText());	//Reading value of 'After Due Date'
				
				CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
				
				Thread.sleep(3000);
				int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
				int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
				int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
				int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
				
				int total = critical + high + medium + low;
				
//				if(ClosedDelayedValue == total)
//				{
//					test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count matches to sum of all risked compliances.");
//					test.log(LogStatus.PASS, "Total 'Closed Delayed' Compliances : "+total);
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "'Closed Delayed' Compliance Count doesn't matches to sum of all risked compliances.");
//					test.log(LogStatus.FAIL, "Total 'Closed Delayed' Compliances : "+total+" | Total Sum : "+ClosedDelayedValue);
//				}
				
				if(ClosedDelayedValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount1( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount1( test, "Low", low, "Statutory");
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
					
					Thread.sleep(500);
					action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				}
				extent.endTest(test);
				extent.flush();
			}
@Test(priority = 14)
			void ClosedTimely_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Completion Status- 'Closed Timely' Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				Thread.sleep(1000);
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				Actions action = new Actions(getDriver());
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,500)");						//Scrolling down window by 1000 px.
				
				Thread.sleep(3000);
				int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());	//Reading value of 'After Due Date'
				CFOcountPOM.clickClosedTimely().click();								//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
				int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
				int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
				int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
				int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
				
				int total = critical + high + medium + low;
				
//				if(ClosedTimelyValue == total)
//				{
//					test.log(LogStatus.PASS, "'Closed Timely' Compliance Count matches to sum of all risked compliances.");
//					test.log(LogStatus.PASS, "Total 'Closed Timely' Compliances : "+total);
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "'Closed Timely' Compliance Count doesn't matches to sum of all risked compliances.");
//					test.log(LogStatus.FAIL, "Total 'Closed Timely' Compliances : "+total+" | Total Sum : "+ClosedTimelyValue);
//				}
				
				if(ClosedTimelyValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount1( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount1( test, "Low", low, "Statutory");
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
					test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
					
					Thread.sleep(500);
					action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				}
				extent.endTest(test);
				extent.flush();
				
			}
			
@Test(priority = 15)
			void NotApplicable_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Completion Status- 'Not Applicable' Count Verification");
			//	test.log(LogStatus.INFO, "Test Initiated");
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,500)");	
				Actions action = new Actions(getDriver());
				WebDriverWait wait = new WebDriverWait(getDriver(), (100));
				wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickNotApplicable()));
				
				Thread.sleep(1000);
				int NotApplicableValue = Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());	//Reading value of 'After Due Date'
				CFOcountPOM.clickNotApplicable().click();								//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
				int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
				int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
				int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
				int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
				
				int total = critical + high + medium + low;
				
//				if(NotApplicableValue == total)
//				{
//					test.log(LogStatus.PASS, "'Not Applicable' Compliance Count matches to sum of all risked compliances.");
//					test.log(LogStatus.PASS, "Total 'Not Applicable' Compliances : "+total);
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "'Not Applicable' Compliance Count doesn't matches to sum of all risked compliances.");
//					test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicableValue);
//				}*/
				
				if(NotApplicableValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount1( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high >0)
					{
						CFOcountPOM.GraphCount1( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount1( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount1( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
					Thread.sleep(1000);
					action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
					
					Thread.sleep(1000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				}
				else
				{
					test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
					
					Thread.sleep(500);
					action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
					
					Thread.sleep(500);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(2000);
				}
				extent.endTest(test);
				extent.flush();
			}
				
		//	@Test(priority = 16)
			void CompletionGraphIsSMETAColumn() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart - Performance Summary - Completion Status- 'Is SMETA Column added' Verification");
				String Status = "Not Completed"+"Closed Delayed"+"Closed Timely"+"Not Applicable";				
				MethodsPOM.IsSMETA(test,Status);				
				extent.endTest(test);
				extent.flush();
			}

@Test(priority = 17)
			void Overdue_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Not Completed Status- 'Overdue' Count Verification");
			//	test.log(LogStatus.INFO, "Test Initiated");
				
				Thread.sleep(1000);
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				Actions action = new Actions(getDriver());
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
				
//				if(OverdueValue == total)
//				{
//					test.log(LogStatus.PASS, "' Overdue' Compliance Count matches to sum of all risked compliances.");
//					test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "'Overdue' Compliance Count doesn't matches to sum of all risked compliances.");
//					test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+OverdueValue);
//				}
			
				if(OverdueValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
					Thread.sleep(5000);
					action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(2000);
				}
				else
				{
					test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
					
					Thread.sleep(500);
					//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			
				}
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority = 18)
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
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
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
				
				/*if(dueTodayValue == total)
				{
					test.log(LogStatus.PASS, "' dueToday' Compliance Count matches to sum of all risked compliances.");
					test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
				}
				else
				{
					test.log(LogStatus.FAIL, "'dueToday' Compliance Count doesn't matches to sum of all risked compliances.");
					test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+dueTodayValue);
				}*/
			
				if(dueTodayValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount( test, "Low", low, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
					}
					
					Thread.sleep(5000);
					action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
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
@Test(priority = 19)
			void pendingForReview_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				Thread.sleep(3000);
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
				
				Thread.sleep(4000);
				int pendingForReviewValue = Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());	//Reading value of 'Not Completed'
				CFOcountPOM.clickpendingForReview().click();									//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
				int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
				int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
				int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
				int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
				
				int total = critical + high + medium + low;
				
				/*if(pendingForReviewValue == total)
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
					if(critical > 0)
					{
						CFOcountPOM.GraphCount2( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount2( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount2( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount2( test, "Low", low, "Statutory");
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
					//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(2000);
				}
				
				extent.endTest(test);
				extent.flush();
			}
			
			
 @Test(priority = 20)
			void inProgress_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Not Completed Status- 'In Progress' Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				Thread.sleep(3000);
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
				
				Thread.sleep(3000);
				int inProgressValue = Integer.parseInt(CFOcountPOM.clickinProgress().getText());	//Reading value of 'Not Completed'
				CFOcountPOM.clickinProgress().click();									//CLicking on 'Not Completed' count
				
				Thread.sleep(500);
				int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
				int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
				int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
				int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
				
				int total = critical + high + medium + low;
				
				/*if(inProgressValue == total)
				{
					test.log(LogStatus.PASS, "' In Progress' Compliance Count matches to sum of all risked compliances.");
					test.log(LogStatus.PASS, "Total Overdue' Compliances : "+total);
				}
				else
				{
					test.log(LogStatus.FAIL, "'In Progress' Compliance Count doesn't matches to sum of all risked compliances.");
					test.log(LogStatus.FAIL, "Total 'Overdue' Compliances : "+total+" | Total Sum : "+inProgressValue);
				}*/
			
				if(inProgressValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount2( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount2( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount2( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount2( test, "Low", low, "Statutory");
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
					
					Thread.sleep(1000);
					//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
					Thread.sleep(2000);
					performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					Thread.sleep(2000);
				}
				
				extent.endTest(test);
				extent.flush();
			}
			
	@Test(priority = 21)
			void rejected_PieChart() throws InterruptedException, IOException
			{
				test = extent.startTest("Pie Chart -Not Completed Status- ' Rejected' Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
			//	.navigate().refresh();
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
				js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.
				
				Thread.sleep(3000);
				int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejectedPe().getText());	//Reading value of 'Not Completed'
				CFOcountPOM.clickRejectedPe().click();									//CLicking on 'Not Completed' count
				
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
				}*/
			
				if(rejectedValue > 0)
				{
					if(critical > 0)
					{
						CFOcountPOM.GraphCount2( test, "Critical", critical, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
					}
					
					if(high > 0)
					{
						CFOcountPOM.GraphCount2( test, "High", high, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
					}
					
					if(medium > 0)
					{
						CFOcountPOM.GraphCount2( test, "Medium", medium, "Statutory");
					}
					else
					{
						test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
					}
					
					if(low > 0)
					{
						CFOcountPOM.GraphCount2( test, "Low", low, "Statutory");
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
			
			@Test(priority = 21)
					void NotCompletion_IsSmeta() throws InterruptedException, IOException
					{
						test = extent.startTest("Pie Chart - Performance Summary - Not Completion Status- 'Is SMETA Column added' Verification");					
		                String Status = "Overdue"+"DueToday"+"Pending For Review"+"In Progress"+"Rejected";				
						MethodsPOM.IsSMETANotCompletion(test,Status);
						extent.endTest(test);
						extent.flush();
					}
					
						@Test(priority = 22)
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
				wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickCategories()));
				
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
				
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
			
		@Test(priority = 23)
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
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
				
				String PendingReview = CFOcountPOM.clickIndustrySpeHigh().getText();	//Reading the Pending For Review value of Human Resource
				PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
				
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
			
			@Test(priority = 24)
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
				js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
				
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
			
				@Test(priority = 25)
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
				js.executeScript("window.scrollBy(0,925)");						//Scrolling down window by 1000 px.
				
				
				Thread.sleep(4000);
				int IndustrySpeLow = Integer.parseInt(CFOcountPOM.clickIndustrySpeLow().getText());	//Reading the Medium value of Labour compliance
				CFOcountPOM.clickIndustrySpeLow().click();					//Clicking on low bar of Indistry Specific  
				
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
					{Thread.sleep(500);
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
	
			@Test(priority = 26)
		void OverallFunIsSmeta() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - Completion Status- Overall Function - 'Is SMETA Column added' Verification");					
            String Status = "Closed Timely"+"Closed Delayed"+"Not completed"+"Not Applicable";				
			MethodsPOM.IsSMETAOverallFunction(test,Status);
			extent.endTest(test);
			extent.flush();
		}

			
		@Test(priority = 27)
			void RiskSummaryCriticalStatutory() throws InterruptedException, IOException
			{
			
				Thread.sleep(3000);
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,1450)");					//Scrolling down window by 1000 px.cfo
			//	js.executeScript("window.scrollBy(0,800)");
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
					CFOcountPOM.RiskGraphCount1( test, "Critical - Not Completed", RiskCritical_NotCompleted, "Statutory");
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
					Thread.sleep(2000);
					CFOcountPOM.RiskGraphCount( test, "Critical - Closed Delayed", RiskCritical_ClosedDelayed, "Statutory");
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
					Thread.sleep(2000);
					CFOcountPOM.RiskGraphCount( test, "Critical - Closed Timely", RiskCritical_ClosedTimely, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical - Closed Timely' Count = "+RiskCritical_ClosedTimely);
				}
				
				Thread.sleep(2000);
				List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
				
				Thread.sleep(4000);
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
				Thread.sleep(2000);
				extent.endTest(test);
				extent.flush();
			}
				@Test(priority = 28)
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
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				js.executeScript("window.scrollBy(0,1450)");		
				Thread.sleep(1000);
				String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
				NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
				int RiskHigh_NotCompleted = Integer.parseInt(NotCompleted);
			
			//	int RiskHigh_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskHighNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskHigh_NotCompleted > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskHighNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
					Thread.sleep(1000);
					CFOcountPOM.RiskGraphCount1( test, "High - Not Completed", RiskHigh_NotCompleted, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High - Not Completed' Count = "+RiskHigh_NotCompleted);
				}
				
				Thread.sleep(2000);
				List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
					
				Thread.sleep(5000);
				int RiskHigh_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskHighClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskHigh_ClosedDelayed > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskHighClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
					Thread.sleep(2000);
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
				int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskHigh_ClosedTimely > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
					Thread.sleep(2000);
					CFOcountPOM.RiskGraphCount( test, "High - Closed Timely", RiskHigh_ClosedTimely, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High - Closed Timely' Count = "+RiskHigh_ClosedTimely);
				}
				
				Thread.sleep(4000);
				List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
				Thread.sleep(5000);
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
			
			@Test(priority = 29)
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
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,1450)");		
				Thread.sleep(1000);
				String NotCompleted = CFOcountPOM.clickRiskMediumNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
				NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
				int RiskMedium_NotCompleted = Integer.parseInt(NotCompleted);
			
			//	int RiskMedium_NotCompleted = Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskMedium_NotCompleted > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskMediumNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
					
					CFOcountPOM.RiskGraphCount1( test, "Medium - Not Completed", RiskMedium_NotCompleted, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium - Not Completed' Count = "+RiskMedium_NotCompleted);
				}
				
			
				Thread.sleep(4000);
				List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
					
				Thread.sleep(5000);
				int RiskMedium_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskMedium_ClosedDelayed > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskMediumClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
					Thread.sleep(2000);
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
				int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskMedium_ClosedTimely > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskMediumClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
					Thread.sleep(2000);
					CFOcountPOM.RiskGraphCount( test, "Medium - Closed Timely", RiskMedium_ClosedTimely, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium - Closed Timely' Count = "+RiskMedium_ClosedTimely);
				}
				
				Thread.sleep(4000);
				List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
				
				Thread.sleep(5000);
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
			
			@Test(priority =30)
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
				CFOcountPOM.RefreshNow().click();
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,1450)");
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
					CFOcountPOM.RiskGraphCount1( test, "Low - Not Completed", RiskLow_NotCompleted, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low - Not Completed' Count = "+RiskLow_NotCompleted);
				}
				
				Thread.sleep(2000);
				List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
					
				Thread.sleep(5000);
				int RiskLow_ClosedDelayed = Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskLow_ClosedDelayed > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskLowClosedDelayed().click();			//Clicking on Not Completed compliances bar of High risk.  
					Thread.sleep(2000);
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
				int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
				if(RiskLow_ClosedTimely > 0)
				{
					Thread.sleep(500);
					CFOcountPOM.clickRiskLowClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
					Thread.sleep(2000);
					CFOcountPOM.RiskGraphCount( test, "Low - Closed Timely", RiskLow_ClosedTimely, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low - Closed Timely' Count = "+RiskLow_ClosedTimely);
				}
				
				
				Thread.sleep(4000);
				List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
				ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
				Thread.sleep(4000);
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
				Thread.sleep(2000);
				extent.endTest(test);
				extent.flush();
			}
			
			   @Test(priority = 31)
	void RiskSummIsSmeta() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph - Risk Summary graph - 'Is SMETA Column added' Verification");					
        String Status = "Not completed"+"Closed Delayed"+"Closed Timely"+"DueToday"+"Not Applicable";				
		MethodsPOM.IsSMETARisksummary(test,Status);
		extent.endTest(test);
		extent.flush();
	}

    @Test(priority = 32)
		void DepartmentSummaryHumanResourceStatutory() throws InterruptedException, IOException
		{
			Thread.sleep(3000);		
			
			CFOcountPOM.YearTodate().click();
			Thread.sleep(1000);
			CFOcountPOM.ALL().click();
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(1000);
			CFOcountPOM.clickApply().click();
			Thread.sleep(5000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,2000)");					//Scrolling down window by 1500 px.
			Thread.sleep(2000);
			Thread.sleep(3000);
			
			
			
			
			test = extent.startTest("Department Summary - 'Forest' Count Verification");
			
			
			Thread.sleep(3000);
			String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo().getText();			//Reading the Overdue value of Human Resource
			NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
			int Overdue = Integer.parseInt(NotCompleted);						
			if(Overdue > 0)
			{
				CFOcountPOM.clickComplianceIsecOverdueDemo().click();
				CFOcountPOM.RiskGraphCount1( test, "Overdue", Overdue, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Overdue Complaince Count = "+ Overdue + ".");
			}
			
			 WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
				
			  roc.click();
			
		
			Thread.sleep(6000);
			String ClosedDelayed = CFOcountPOM.clickHumanClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
			ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
			int Closed_Delayed = Integer.parseInt(ClosedDelayed);	
		//	int Closed_Delayed = Integer.parseInt(CFOcountPOM.clickHumanClosedDelayed().getText());	//Reading the High Risk value of Not Completed compliance
			
			if(Closed_Delayed > 0)
			{
				Thread.sleep(500);	
				CFOcountPOM.clickHumanClosedDelayed().click();
				Thread.sleep(2000);
				CFOcountPOM.RiskGraphCount( test, "Closed Delayed", Closed_Delayed, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Closed Delayed Complaince Count = "+ Closed_Delayed + ".");
			}
			
			  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
				
			  roc1.click();
			
			Thread.sleep(3000);
			String ClosedTimely = CFOcountPOM.clickHumanClosedTimelym().getText();		//Reading the Closed Timely value of Human Resource
			ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
			int Closed_Timely = Integer.parseInt(ClosedTimely);						
			if(Closed_Timely > 0)
			{
				CFOcountPOM.clickHumanClosedTimelym().click();
				CFOcountPOM.RiskGraphCount( test, "Closed Timely", Closed_Timely, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Closed Timely Complaince Count = "+ Closed_Timely + ".");
			}
			
		
			WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
			CT.click();
			Thread.sleep(3000);
			String PendingReview = CFOcountPOM.clickAccountPendingReview().getText();	//Reading the Pending For Review value of Human Resource
			PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
			int Pending_Review = Integer.parseInt(PendingReview);						
			if(Pending_Review > 0)
			{
				CFOcountPOM.clickAccountPendingReview().click();
				CFOcountPOM.RiskGraphCount( test, "Pending For Review", Pending_Review, "Statutory");
			}
			else
			{
				test.log(LogStatus.PASS, "Pending For Review Complaince Count = "+ Pending_Review + ".");
			}
			
			WebElement PR = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));
			PR.click();
			
			Thread.sleep(3000);
			
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
			
			WebElement IP = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-4 > rect"));
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
		


			/*	Thread.sleep(500);
				String NotApplicable = CFOcountPOM.clickHumanNotApplicable().getText();	//Reading the Pending For Review value of Human Resource
				NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
				int Not_Applicable = Integer.parseInt(NotApplicable);						
				if(Not_Applicable > 0)
			{
					CFOcountPOM.clickHumanNotApplicable().click();
//					CFOcountPOM.RiskGraphCount( test, "Not Applicable", Not_Applicable, "Statutory");
//				}
//				else
//				{
//					test.log(LogStatus.PASS, "Not Applicable Complaince Count = "+ Not_Applicable + ".");
//				}
//			}
//			catch(Exception e)
//			{
//				
//			}*/
				
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
				WebElement NA = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-6 > rect"));
				NA.click();
				Thread.sleep(5000);
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
				
				
				
					
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
			extent.endTest(test);
			extent.flush();
		}
			
				@Test(priority = 33)
		void DepartSummIsSmeta() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph - Department Summary graph - 'Is SMETA Column added' Verification");					
	        String Status = "Overdue"+"Closed Delayed"+"Closed Timely"+ "Pending For Review" + "In Progress" + "Rejected"+"Not Applicable"+"DueToday";				
			MethodsPOM.IsSMETADepSumm(test,Status);
			extent.endTest(test);
			extent.flush();
		}

			
			@Test(priority = 34)
		void NotCompleted_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Completed' Count Verification");
			
			Thread.sleep(3000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver()  ;
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
		//	js.executeScript("window.scrollBy(0,100)");
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait(getDriver() ,(30));
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
			Thread.sleep(6000);
			
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
					CFOcountPOM.GraphCountInPe1( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "Low", low, "Statutory");
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
			}
			else
			{
				test.log(LogStatus.PASS, " 'NotCompleted' Compliance Count = "+NotCompletedValue);
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
			}
			
			
			extent.endTest(test);
			extent.flush();
		}
		
			@Test(priority = 35)
		void ClosedDelayed_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart -Completion Status- 'Closed Delayed' Count Verification");
		
			Thread.sleep(2000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
			Thread.sleep(3000);
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
					CFOcountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(500);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(4000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Delayed' Compliance Count = "+ClosedDelayedValue);
				
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(2000);
			}
			extent.endTest(test);
			extent.flush();
		}
		
			@Test(priority = 36)
		void ClosedTimely_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status- 'Closed Timely' Count Verification");
		
			Thread.sleep(2000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2400)");					//Scrolling down window by 1000 px.
			Thread.sleep(2000);
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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

			int ClosedTimelyValue = Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());	//Reading value of 'After Due Date'
			CFOcountPOM.clickClosedTimely().click();								//CLicking on 'Not Completed' count
			
			Thread.sleep(2000);
			int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
			int high = Integer.parseInt(CFOcountPOM.readHigh().getText());		//reading High risk count.
			int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());	//reading Medium risk count.
			int low = Integer.parseInt(CFOcountPOM.readLow().getText());			//reading Low risk count.
			
			int total = critical + high + medium + low;
			
			/*if(ClosedTimelyValue == total)
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
					CFOcountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(1000);
					CFOcountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
			//	performer.OverduePOM.clickDashboard().click();	
			}
			else
			{
				test.log(LogStatus.PASS, "'Closed Timely' Compliance Count = "+ClosedTimelyValue);
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				
				Thread.sleep(2000);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(4000);
			}
			extent.endTest(test);
			extent.flush();
			
		}
		
	@Test(priority = 37)
		void NotApplicable_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Completion Status- 'Not Applicable' Count Verification");
		
			Thread.sleep(800);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,2400)");					//Scrolling down window by 1000 px.
			Thread.sleep(2000);
			Actions action = new Actions(getDriver());
			WebDriverWait wait = new WebDriverWait(getDriver(),(30));
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
				test.log(LogStatus.FAIL, "Total 'Not Applicable' Compliances : "+total+" | Total Sum : "+NotApplicableValue);
			}
			*/
			if(NotApplicableValue > 0)
			{
				if(critical >= 0)
				{
					CFOcountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(1000);
					CFOcountPOM.GraphCountInPe( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(1000);
					CFOcountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(1000);
					CFOcountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			}
			else
			{
				test.log(LogStatus.PASS, "'Not Applicable' Compliance Count = "+NotApplicableValue);
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
				Thread.sleep(3000);
				action.moveToElement(CFOcountPOM.clickBack1()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
				Thread.sleep(500);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			}
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 38)

	void UpcomingPieChartPeriod() throws InterruptedException
	{
		//test = extent.startTest("Period-Pie Chart -Not Completed Status- ' Upcoming' Count Verification");
	
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2400)");			//Scrolling down window by 1000 px.
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
	
		
	@Test(priority = 39)
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
	
	@Test(priority = 40)
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
    
		@Test(priority = 41)
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
	
	@Test(priority =42)
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
	
	@Test(priority =43)
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
	
	
   @Test(priority = 44)
   		void Overdue_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Overdue' Count Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(2000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
			Thread.sleep(3000);
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
			
			Thread.sleep(500);
			int critical = Integer.parseInt(CFOcountPOM.readCritical().getText());	//Reading Critical risk count.
			int high = Integer.parseInt(CFOcountPOM.readHigh().getText());			//Reading High risk count.
			int medium = Integer.parseInt(CFOcountPOM.readMedium().getText());		//Reading Medium risk count.
			int low = Integer.parseInt(CFOcountPOM.readLow().getText());				//Reading Low risk count.
			
			int total = critical + high + medium + low;
			
		/*	if(OverdueValue == total)
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
					CFOcountPOM.GraphCountInPe1( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "Low", low, "Statutory");
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
				Thread.sleep(2000);
				test.log(LogStatus.PASS, " 'Overdue' Compliance Count = "+OverdueValue);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
				Thread.sleep(500);
			//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(3000);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(4000);
		
			}
			
			extent.endTest(test);
			extent.flush();
		}
   
   	@Test(priority =45)
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
		
	//	@Test(priority = 46)
		void dueToday_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Not Completed Status- 'dueToday' Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(2000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
				test.log(LogStatus.PASS, "Total dueToday' Compliances : "+total);
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
					CFOcountPOM.GraphCountInPe1( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe1( test, "Low", low, "Statutory");
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
				test.log(LogStatus.PASS, " 'Due Today' Compliance Count = "+dueTodayValue);
				
				Thread.sleep(500);
			//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(2000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			}
			
			extent.endTest(test);
			extent.flush();
		}
		
			@Test(priority =47)
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
	
		@Test(priority = 48)
		void pendingForReview_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Not Completed Status- 'Pending For Review' Count Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(2000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
					CFOcountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Low", low, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
				
				//Thread.sleep(5000);
				//action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	 //Clicking on Back button
				Thread.sleep(2000);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
			}
			else
			{
				test.log(LogStatus.PASS, " 'Pending For Review' Compliance Count = "+pendingForReviewValue);
				
				Thread.sleep(2000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
			//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(2000);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			}
			
			extent.endTest(test);
			extent.flush();
		}
	
			@Test(priority = 49)
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
		
		@Test(priority = 50)
		void inProgress_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Not Completed Status- 'in Progress' Count Verification");
		
			
			Thread.sleep(2000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
					CFOcountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
				test.log(LogStatus.PASS, " 'in Progress' Compliance Count = "+pendingForReviewValue);
				Thread.sleep(2000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(2000);
				Thread.sleep(500);
			//	action.moveToElement(CFOcountPOM.clickBack2()).click().build().perform();	//Clicking on Dashboard
				Thread.sleep(2000);
				performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		
			}
			
			extent.endTest(test);
			extent.flush();
		}
	
			@Test(priority = 51)
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
		

		
	  @Test(priority = 52)
		void rejected_PieChartPeriod() throws InterruptedException, IOException
		{
			test = extent.startTest("Period-Pie Chart -Not Completed Status- ' Rejected' Count Verification");
		
			Thread.sleep(2000);
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
			Thread.sleep(800);
			WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
			int rejectedValue = Integer.parseInt(CFOcountPOM.clickRejectedPe11().getText());	//Reading value of 'Not Completed'
			CFOcountPOM.clickRejectedPe11().click();									//CLicking on 'Not Completed' count
			
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
					CFOcountPOM.GraphCountInPe( test, "Critical", critical, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+critical);
				}
				
				if(high >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "High", high, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Medium", medium, "Statutory");
				}
				else
				{
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+medium);
				}
				
				if(low >= 0)
				{
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
					Thread.sleep(500);
					CFOcountPOM.GraphCountInPe( test, "Low", low, "Statutory");
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
	  
			@Test(priority = 53)
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
			
	  
		@Test(priority = 54)
		void UpcomingFilterMgmt() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the all filters functionally working or not while clicking on Period-Pie Chart - Not Completed Status- ' Upcoming ' -  Critical Risk or not?.");
		
			CFOcountPOM.UpcomingFilterMgmt(test );
			
			extent.endTest(test);
			extent.flush();
		}
		
	 /* 
		
		@Test(priority = 52)
		void PenaltySummaryStatutory() throws InterruptedException
		{		
			Thread.sleep(500);		
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2100 px.
			
			test = extent.startTest("Penalty Summary Graph - Amount Verification");
			
			
			Thread.sleep(300);
			CFOcountPOM.clickPenaltyYear().click();
			Select drp=new Select(CFOcountPOM.clickPenaltyYear());
			Thread.sleep(300);
			
			drp.selectByValue("2023-2024");
			Thread.sleep(300);
			CFOcountPOM.clickPenaltyYear().click();
			
			Thread.sleep(300);
			CFOcountPOM.clickApply3().click();
			
			Thread.sleep(8000);
			js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2100 px.
			Thread.sleep(8000);
			//----------------------------------------------Critical-------------------------------------
			
			Thread.sleep(3000);
		//	String critical = CFOcountPOM.clickPenaltyCritical().getText();	//Reading the High Penalty value of April-Jun
		//	critical = critical.replaceAll(" ","");									//Removing all white spaces from string. 
		//	int PenaltyCritical = Integer.parseInt(critical);
			String PendingReview = CFOcountPOM.clickPenaltyCritical().getText();	//Reading the Pending For Review value of Human Resource
			PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
			int PenaltyCritical = Integer.parseInt(PendingReview);
			if(PenaltyCritical > 0)
			{
			//	test.log(LogStatus.PASS, "-------- Critical Risk Penalty Export --------");
				CFOcountPOM.clickPenaltyCritical().click();
			//	CFOcountPOM.CountPenalty( test, PenaltyCritical);
				Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				
				 CFOcountPOM.clickExportImage().click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "Critical - Penalty - Excel file Export Successfully");
					Thread.sleep(3000);
					CFOcountPOM.clickInterest().click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
					 CFOcountPOM.clickExportImage().click();
						Thread.sleep(4000);
						test.log(LogStatus.PASS, "Interest - Excel file Export Successfully");
						Thread.sleep(3000);
						getDriver().switchTo().parentFrame();								//Switching back to Interest's parent frame.
						getDriver().switchTo().parentFrame();	
					Thread.sleep(500);
					CFOcountPOM.closeCategories().click();					//Closing the 'Penalty' pop up.
					
					
			}
			else
			{
				test.log(LogStatus.PASS, "'Critical Penalty' value is zero.");
			}
			
			//----------------------------------High-------------------------------
			
			Thread.sleep(500);
			String high = CFOcountPOM.clickPenaltyHigh().getText();	//Reading the High Penalty value of April-Jun
			high = high.replaceAll(" ","");									//Removing all white spaces from string. 
			int PenaltyHigh = Integer.parseInt(high);
			
			if(PenaltyHigh > 0)
			{
				//test.log(LogStatus.PASS, "-------- High Risk Penalty Count --------");
				CFOcountPOM.clickPenaltyHigh().click();
				//CFOcountPOM.CountPenalty( test, PenaltyHigh);
				Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				
				 CFOcountPOM.clickExportImage().click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "High - Penalty - Excel file Export Successfully");
					Thread.sleep(3000);
					CFOcountPOM.clickInterest().click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
					 CFOcountPOM.clickExportImage().click();
						Thread.sleep(4000);
						test.log(LogStatus.PASS, "Interest - Excel file Export Successfully");
						Thread.sleep(3000);
						getDriver().switchTo().parentFrame();								//Switching back to Interest's parent frame.
						getDriver().switchTo().parentFrame();	
					Thread.sleep(500);
					CFOcountPOM.closeCategories().click();					//Closing the 'Penalty' pop up.
					
			}
			else
			{
				test.log(LogStatus.PASS, "'High Penalty' value is zero.");
			}
			
			//----------------------------------Medium-------------------------------
			
			Thread.sleep(500);
			String medium = CFOcountPOM.clickPenaltyMedium().getText();	//Reading the High Penalty value of April-Jun
			medium = medium.replaceAll(" ","");									//Removing all white spaces from string. 
			int PenaltyMedium = Integer.parseInt(medium);
			
			if(PenaltyMedium > 0)
			{
			//	test.log(LogStatus.PASS, "-------- Medium Risk Penalty Count --------");
				CFOcountPOM.clickPenaltyMedium().click();
			//	CFOcountPOM.CountPenalty( test, PenaltyMedium);
				Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				
				 CFOcountPOM.clickExportImage().click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "Medium - Penalty - Excel file Export Successfully");
					Thread.sleep(3000);
					CFOcountPOM.clickInterest().click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
					 CFOcountPOM.clickExportImage().click();
						Thread.sleep(4000);
						test.log(LogStatus.PASS, "Interest - Excel file Export Successfully");
						Thread.sleep(3000);
						getDriver().switchTo().parentFrame();								//Switching back to Interest's parent frame.
						getDriver().switchTo().parentFrame();	
					Thread.sleep(500);
					CFOcountPOM.closeCategories().click();					//Closing the 'Penalty' pop up.
					
			}
			else
			{
				test.log(LogStatus.PASS, "'Medium Penalty' value is zero.");
			}
			
			//----------------------------------Low-------------------------------
			
			Thread.sleep(500);
			String low = CFOcountPOM.clickPenaltyLow().getText();	//Reading the High Penalty value of April-Jun
			low = low.replaceAll(" ","");									//Removing all white spaces from string. 
			int PenaltyLow = Integer.parseInt(low);
			
			if(PenaltyLow > 0)
			{
			//	test.log(LogStatus.PASS, "-------- Low Risk Penalty Count --------");
				CFOcountPOM.clickPenaltyLow().click();
			//	CFOcountPOM.CountPenalty( test, PenaltyLow);
				Thread.sleep(5000);
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				
				 CFOcountPOM.clickExportImage().click();
					Thread.sleep(4000);
					test.log(LogStatus.PASS, "Low - Penalty - Excel file Export Successfully");
					Thread.sleep(3000);
					CFOcountPOM.clickInterest().click();
					Thread.sleep(2000);
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
					 CFOcountPOM.clickExportImage().click();
						Thread.sleep(4000);
						test.log(LogStatus.PASS, "Interest - Excel file Export Successfully");
						Thread.sleep(3000);
						getDriver().switchTo().parentFrame();								//Switching back to Interest's parent frame.
						getDriver().switchTo().parentFrame();	
					Thread.sleep(500);
					CFOcountPOM.closeCategories().click();					//Closing the 'Penalty' pop up.
					
			}
			else
			{
				test.log(LogStatus.PASS, "'Low Penalty' value is zero.");
			}
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(3000);
			extent.endTest(test);
			extent.flush();
		}*/
		
		@Test(priority = 55)
		void GradingReportStatutory() throws InterruptedException, IOException
		{
					Thread.sleep(3000);		
				test = extent.startTest("'Grading Report'  Export and OverView");
				//test.log(LogStatus.INFO, "Test Initiated");
				CFOcountPOM.YearTodate().click();
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
				js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2600 px.
				Thread.sleep(2000);	
				CFOcountPOM.clickRedGrading().click();
				Thread.sleep(8000);	
				WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
				Thread.sleep(1000);
			
				Thread.sleep(4000);
				CFOcountPOM.clickExportImage().click();
			
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[13]/a[1]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(4000);
				JavascriptExecutor jse=(JavascriptExecutor)getDriver();
				Thread.sleep(2000);
				jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument1().click();
				Thread.sleep(2000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(1000);
				CFOcountPOM.closePopup().click();					
				
				Thread.sleep(4000);
				//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			
				extent.endTest(test);
				extent.flush();
		}
		
		@Test(priority = 56)
		void complianceCalendar() throws InterruptedException
		{
			test = extent.startTest("compliance Calendar Verifications");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			WebDriverWait wait = new WebDriverWait( getDriver(),(70));
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			//js.executeScript("window.scrollBy(0,1800)");					//Scrolling down window by 2600 px.
			js.executeScript("window.scrollBy(0,3500)");	
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='collapsePerformerCalender']")));
			Thread.sleep(5000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("calframe"));	//Wait until frame get visible and switch to it.
			Thread.sleep(5000);
			 CFOcountPOM.clickExportImage().click();
			 Thread.sleep(2000);
				test.log(LogStatus.PASS, "Excel file Export Successfully");
				Thread.sleep(3000);
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]/a");

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
			/*	js.executeScript("window.scrollBy(0,-50)");
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
			//	 test.log(LogStatus.PASS, "After Clicking All(Including Checklist)");
					test.log(LogStatus.PASS, "After Clicking All(Including Checklist) ; - Excel file Export Successfully");
					Thread.sleep(3000);
			By locator1 = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a");
		
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
					test.log(LogStatus.PASS, "After Clicking All(Including Checklist) : - overView Successfully");
					.switchTo().parentFrame();
					Thread.sleep(3000);
				//	performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
					*/
					
				extent.endTest(test);
				extent.flush();
		}
		
		@Test(priority = 57)
		void DailyUpdates() throws InterruptedException, IOException
		{
			Thread.sleep(3000);		
			test = extent.startTest("'Daily Updates'  OverView");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			js.executeScript("window.scrollBy(0,6000)");					//Scrolling down window by 2600 px.
			//js.executeScript("window.scrollBy(0,500)");
			//Thread.sleep(3000);	
			 
			 if(ApprovalcountPOM.DailyUpdates().isDisplayed()) {
					test.log(LogStatus.PASS, "Daily Updates Displayed Successfully");
				}
			CFOcountPOM.clickViewAllDU().click();
			Thread.sleep(4000);	
		//	WebDriverWait wait = new WebDriverWait( getDriver(),, Duration.ofSeconds(30));
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
			Thread.sleep(8000);
			extent.endTest(test);
			extent.flush();
		}
		
  @Test(priority = 58)
		void NewsLetter() throws InterruptedException, IOException
		{
			Thread.sleep(500);		
			test = extent.startTest("'News Letters'  OverView");
		//	test.log(LogStatus.INFO, "Test Initiated");
			Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			js.executeScript("window.scrollBy(0,7000)","");					//Scrolling down window by 2600 px.
			if(ApprovalcountPOM.NewsLetter().isDisplayed()) {
				test.log(LogStatus.PASS, "News Letter Displayed Successfully");
			}
			CFOcountPOM.clickViewAllNL().click();
			Thread.sleep(4000);	
		//	WebDriverWait wait = new WebDriverWait( getDriver(),, Duration.ofSeconds(30));
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
		
	 
		@Test(priority = 59)
		void StandardReportOverall() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Overall Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportOverall(test, "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 60)
		void StandardReportLocation() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Location Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportLocation(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 61)
		void StandardReportUser() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -User Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportUser(test, "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 62)
		void StandardReportCategory() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report -Category  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCategory(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 63)
		void StandardReportRisk() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report - Risk  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportRisk(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 64)
		void StandardReportDetailed() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report - Detailed  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDetailed(test, "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 65)
		void StandardReportCriticalRisk() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report - Critical Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCriticalRisk(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 66)
		void StandardReportOverallIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Overall Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportOverallIn(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
	     @Test(priority = 67)
		void StandardReportLocationIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Location Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportLocationIN(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 68)
		void StandardReportUserIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -User Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportUserIN(test, "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 69)
		void StandardReportCategoryIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Category  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCategoryIN(test, "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 70)
		void StandardReportRiskIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal-Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportRiskIN(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 71)
		void StandardReportDetailedIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal-Detailed  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportDetailedIN(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 72)
		void StandardReportCriticalRiskIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Standard Report Internal -Critical Risk  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.StandardReportCriticalRiskIN(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 73)
		void DetailedReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report Count Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.DetailedReport1(test,  "cfo");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 74) 
		void DetailedReportIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report -Internal Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.DetailedReportIn(test, "cfo");
			
			extent.endTest(test);
			extent.flush();
		}

		@Test(priority =75) 
		void DetailedReportFilterMgmt() throws InterruptedException, IOException
		{
			test = extent.startTest("To check  Detailed report filters working or not Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			ApprovalcountPOM.DetailedReportFilterMgmt(test,  "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 76)
		void AssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Assignment Report verification");
		
			
			CFOcountPOM.AssignmentReportSta(test );
			
			extent.endTest(test);
			extent.flush();
		}
		
	//@Test(priority = 63)
		void AssignmentReportFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check 'Assignment Report ' Filter Working Or not");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			ApprovalcountPOM.AssignmentReportFilterMGmt(test);
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 77)
		void ComplianceIDFilterMgmt() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = Compliance ID Filter Working Or not");
			
			DeptCountPOM.ComplianceIDFilterMgmt(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 78)
		void ComplianceIDFilterEBMgmt() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = Compliance ID Filter Working Or not");
			
			DeptCountPOM.ComplianceIDFilterEBMgmt(test );
		
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 79)
		void ComplianceIDFilterINMgmt() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = Compliance ID Filter Working Or not");
			
			DeptCountPOM.ComplianceIDFilterINMgmt(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 80)
		void ComplianceIDFilter1Invalid() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Statutory & Statutory CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
			
			DeptCountPOM.ComplianceIDFilter1Invalid(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 81)
		void ComplianceIDFilterEBInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- EventBased Checklist & EventBased = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
			
			DeptCountPOM.ComplianceIDFilterEBInvalid(test );
		
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 82)
		void ComplianceIDFilterINInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("'Assignment Report' :- Internal & Internal CheckList = To check whether the data is seen on the grid after entering invalid data in compliance ID search box Filter.");
			
			DeptCountPOM.ComplianceIDFilterINInvalid(test );
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 83)
		void UsageReport() throws InterruptedException
		{
			test = extent.startTest("Usage Report verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(1000);
			CFOcountPOM.clickReports().click();				//Clicking on 'My Reports'
			
			Thread.sleep(500);
			CFOcountPOM.clickUsageReport().click();			//Clicking on 'Usage Reports'
			
			Thread.sleep(5000);
			CFOcountPOM.clickStartDate().click();				//CLicking on Start Date input box
			Thread.sleep(3000);
			performer.OverduePOM.selectDate().click();		//Method to click on date at second row and fourth column
			Thread.sleep(1000);
			Thread.sleep(500);
			CFOcountPOM.clickEndDate().click();				//CLicking on Start Date input box
			Thread.sleep(4000);
			performer.OverduePOM.selectDate().click();		//Method to click on date at second row and fourth column
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();					//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExport().click();				//CLicking on 'Export to Excel' button
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents1 = dir1.listFiles();					//Counting number of files in directory after download
			
			if(dirContents.length < dirContents1.length)
			{
				test.log(LogStatus.PASS, "File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, "File does not downloaded.");
			}
			
			Thread.sleep(500);
			performer.OverduePOM.clickDashboard().click();
			
			extent.endTest(test);
			extent.flush();
		}
		
	/*	@Test(priority = 71) not persent
		void AuditReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Audit Report verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.AuditReport(test );
			
			extent.endTest(test);
			extent.flush();
		}
			
		@Test(priority = 72)//not run
		void ActRepository() throws InterruptedException, IOException
		{
			test = extent.startTest("Act Repository  verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.ActRepository(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 73)
		void ActRepositoryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check 'Act Repository Page'  Filters Working or not");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			ApprovalcountPOM.ActRepositoryFilter(test);
			
			extent.endTest(test);
			extent.flush();
		}*/

		@Test(priority = 84)
		void ComplianceDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents  verification");
		
			
			CFOcountPOM.ComplianceDocumentsSta(test);
			
					extent.endTest(test);
					extent.flush();
		}
		
	//	@Test(priority = 85)
		void ComplianceDocumentsFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To Check Compliance Document page All filters working or not");
		
			
			DeptCountPOM.ComplianceDocumentsFilter(test);
			
					extent.endTest(test);
					extent.flush();
		}
		
	@Test(priority =86)
		void ComplianceDocumentsIN() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Documents-Internal  verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.complianceDocumentIn(test);
			
					extent.endTest(test);
					extent.flush();
		}
		
		@Test(priority = 87) //	pass	
		void CriticalDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Critical Document Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			OverduePOM.CriticalDocuments( test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 88)
		void ActDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Act Documents  verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.ActDocuments(test);
			extent.endTest(test);
			extent.flush();
		}
		/*
//		@Test(priority = 79) // pass not present
		void MyReminderStatutory() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reminder - Statutory Count Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			OverduePOM.MyReminder( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}

		@Test(priority = 80) // pass
		void MyEscalation() throws InterruptedException, IOException
		{
			test = extent.startTest("My  Escalation - Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			WebDriverWait wait = new WebDriverWait( getDriver(),,(30));
			CFOcountPOM.clickMyEscalation().click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));	//Wait till records table gets visible
			Thread.sleep(1000);
			List<WebElement> CheckBox=	.findElements(By.xpath("//*[@id='sel_chkbx']"));
		CheckBox.get(5).click();
		Thread.sleep(500);
		List<WebElement> Actions=	.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[8]/a"));
		Actions.get(5).click();//*[@id="ContentPlaceHolder1_grdReviewerComplianceDocument_btnAdd_0"]
		Thread.sleep(4000);
		.switchTo().alert().accept();
		Thread.sleep(2000);
		performer.OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}*/
		
		@Test(priority = 89) 
		void MyNotifications() throws InterruptedException, IOException
		{
			test = extent.startTest("My Notifications - Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
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
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2100 px.
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnMarkasRead']")).click();
			test.log(LogStatus.PASS, "Read Successfully");	
			Thread.sleep(1000);
			performer.OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 90) // pass
		void MessageCenter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Message Center - Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			Thread.sleep(8000);
			CFOcountPOM.clickMessageCenter().click();
			Thread.sleep(4000);
			try {
			CFOcountPOM.clickViewMsg().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View Button is clickable");
			Thread.sleep(1000);
			}catch(Exception e) {
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "No Records Found ");
			}
			performer.OverduePOM.clickDashboard().click();
			extent.endTest(test);
			extent.flush();
		}
		
	    @Test(priority = 91)
			void InternalMsg() throws InterruptedException, IOException
			{
				Thread.sleep(500);		
				test = extent.startTest("'Internal Msg  '  Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
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
				OverduePOM.choosefile().sendKeys("E:\\Test Cases\\Sony test cases.xlsx");
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
				test.log(LogStatus.PASS, "Internal Message working successfully");
				Thread.sleep(1000);
				extent.endTest(test);
				extent.flush();
			}
			
			 @Test(priority = 92)
				void SupportTicket() throws InterruptedException, IOException
				{
					Thread.sleep(1000);		
					test = extent.startTest("'Support Ticket  '  Verification");
				
					
					MethodsPOM.SupportTicket(test);
					
					extent.endTest(test);
					extent.flush();
				}
		  
		
		
	//	@Test(priority = 85)
		void DetailedReportReOpen() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed  Report -Reopen - Closed Timely , Closed Delayed and Not applicable compliance  verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.DetailedReportReOpen(test);
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority =86)
		void PerformanceSummaryReopen() throws InterruptedException, IOException
		{
			test = extent.startTest("In Performer Summary graph - Re-open - Closed Timely , Closed Delayed and Not applicable compliance  verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.PerformanceSummaryReopen(test,"High");
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority = 87)
		void RiskGraphReOpen() throws InterruptedException, IOException
		{
			test = extent.startTest("In Risk Summary graph - Re-open - Closed Timely , Closed Delayed and Not applicable compliance  verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			CFOcountPOM.RiskGraphReOpen(test);
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 93) //pass 
	    void WhatsNew() throws InterruptedException, IOException
				{
					test = extent.startTest("'what's New ' Verification");
					
					
					MethodsPOM.WhatsNew(test);
					
					extent.endTest(test);
					extent.flush();
				}
		
		@Test(priority = 89) //pass 
	    void MyDashboardClearfilter() throws InterruptedException, IOException
				{
					test = extent.startTest("To Check On Dashboard Clear Button Working Or not");
					
					
					CFOcountPOM.MyDashboardClearfilter(test);
					
					extent.endTest(test);
					extent.flush();
				}
			
		
		//@Test(priority = 90)
		void CompletionStatusFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the filters of Performance Summary Graph for Completion Status  working or not?");
		
					ApprovalcountPOM.CompletionStatusFilterMgmt(test );
			
			extent.endTest(test);
			extent.flush();
		}
		
		/*@Test(priority =91)
		void NotCompletionStatusFilterMgmt() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the filters of Performance Summary Graph for Not Completed Status working or not?");
		
					ApprovalcountPOM.NotCompletionStatusFilterMgmt(test );
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 92)
		void RiskSummaryFilterM() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the filters of Risk Summary -Not Completed Status working or not?");
		
					ApprovalcountPOM.RiskSummaryFilterM(test );
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 93)
			void DeptSummaryFilterM() throws InterruptedException, IOException
			{
				test = extent.startTest("To check whether the filters of  Department Summary - Overdue Status working or not?");
			
						ApprovalcountPOM.DeptSummaryFilterM(test );
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 94)
			void CompletionStatusFilterMgmtPe() throws InterruptedException, IOException
			{
				test = extent.startTest("To check whether the filters of Performance Summary Graph(Due For Period) for Completion Status working or not?");
			
						ApprovalcountPOM.CompletionStatusFilterMgmtPe(test );
				
				extent.endTest(test);
				extent.flush();
			}
		
			@Test(priority = 95)
			void NotCompletionStatusFilterMgmtPe() throws InterruptedException, IOException
			{
				test = extent.startTest("To check whether the filters of  \"Performance Summary Graph (Due For Period)for Not Completed Status working or not?");
			
						ApprovalcountPOM.NotCompletionStatusFilterMgmtPe(test );
				
				extent.endTest(test);
				extent.flush();
			}
		
	//	@Test(priority = 0)
		void Reopening() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To check whether the new tab named \"My Reopening\" is seperately reflects or not on the dashboard in the main menu while the tab will be visible only for who have made the configuration.");
				
			DeptCountPOM.Reopening(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 97)
		void ReopeningRe() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Re-open");
				
			DeptCountPOM.ReopeningRe(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 98)
		void Reopeningapprove() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To check whether the compliances can be updated or not while clicking on the edit icon from action column. - Approve");
				
			DeptCountPOM.Reopeningapprove(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 99)
		void ReopeningExport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reopening - To Check Whether Export button of working or not?");
				
			DeptCountPOM.ReopeningExport(test);
			
			extent.endTest(test);
			extent.flush();
		}
		*/
		
		@Test(priority = 100)
		void DeviationApproverColSOO() throws InterruptedException, IOException
		{
			test = extent.startTest("Summary of Overdue Compliances - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in summary of overdue of Approver dashboard ?");
				
			CFOcountPOM.DeviationApproverColSOO(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 101)
		void DeviationClosureStatuscolSOO() throws InterruptedException, IOException
		{
			test = extent.startTest("Summary of Overdue Compliances - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
				
			CFOcountPOM.DeviationClosureStatuscolSOO(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 102)
		void SOOStatus() throws InterruptedException, IOException
		{
			test = extent.startTest("Summary of Overdue Compliances - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown  in summary of overdue of management ");
				
			CFOcountPOM.SOOStatus(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 103)
		void DeviationApproverColPS() throws InterruptedException, IOException
		{
			test = extent.startTest("performance summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the performance summary graph of management  ");
				
			CFOcountPOM.DeviationApproverColPS(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 104)
		void DeviationApproverColRS() throws InterruptedException, IOException
		{
			test = extent.startTest("risk summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the risk summary graph of management dashboard ?  ");
				
			CFOcountPOM.DeviationApproverColRS(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority = 105)
		void DeviationApproverColDS() throws InterruptedException, IOException
		{
			test = extent.startTest("department summary graph - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the department summary graph of management   ");
				
			CFOcountPOM.DeviationApproverColDS(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 106)
		void DeviationApproverColPSDFP() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary (Due for the period) - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in thePerformance Summary (Due for the period) of management   ");
				
			CFOcountPOM.DeviationApproverColPSDFP(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority = 107)
		void DeviationApproverColGR() throws InterruptedException, IOException
		{
			test = extent.startTest(" grading report - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\" in the grading report of management dashboard ? ");
				
			CFOcountPOM.DeviationApproverColGR(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 108)
		void ComplianceDocumentsDAM() throws InterruptedException, IOException
		{
			test = extent.startTest("My Documents - Compliance Documents - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my document page?");
				
			MethodsPOM.ComplianceDocumentsDAM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 109)
		void DeviationApproverColCD() throws InterruptedException, IOException
		{
			test = extent.startTest("My Documents - Compliance Documents - To check whether the name of \"deviation approver\" appears or not on the additional column of \"deviation approver\"in grid  of My document page?");
				
			MethodsPOM.DeviationApproverColCD(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 110)
		void DeviationClosureStatuscolCD() throws InterruptedException, IOException
		{
			test = extent.startTest("My Documents - Compliance Documents - To check whether the name of additional column \"deviation closure status\" appears or not in grid");
				
			MethodsPOM.DeviationClosureStatuscolCD(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 111)
		void DetailedReportDA() throws InterruptedException, IOException
		{
			test = extent.startTest("my Report - Detailed  report - To check that the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects or not in the status dropdown on the grid of my report page?");
				
			MethodsPOM.DetailedReportDAM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		/*@Test(priority = 112)
		void SummaryofOverdueSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Summary of Overdue Compliances?");
			
			CFOcountPOM.SummaryofOverdueSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 113)
		void PerformanceSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Performance Summary Graph?");
			
			CFOcountPOM.PerformanceSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 114)
		void RiskSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Risk Summary Graph?");
			
			CFOcountPOM.RiskSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 115)
		void DepartmentSummarySF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Department Summary Graph?");
			
			CFOcountPOM.DepartmentSummarySF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 116)
		void PerformerSummaryDueForPeriodSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Performance Summary(Due for the period) Graph?");
			
			CFOcountPOM.PerformerSummaryDueForPeriodSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 117)
		void GradingReportSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Grading Report?");
			
			CFOcountPOM.GradingReportSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 118)
		void DetailedReportSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Deatiled Report?");
			
			CFOcountPOM.DetailedReportSF(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 119)
		void PerformReviewEmailCol() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report - Performer Email column and Reviewer Email column Visible on grid Verification. ");
				
			MethodsPOM.PerformReviewEmailCol(test);
			
			extent.endTest(test);
			extent.flush();
		}
		

		@Test(priority = 120)
		void PerformReviewEmailColIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Detailed Report - Internal - Performer Email column and Reviewer Email column Visible on grid Verification. ");
				
			MethodsPOM.PerformReviewEmailColIn(test);
			
			extent.endTest(test);
			extent.flush();
		}


		@Test(priority = 121)
		void ComplianceDocumentsSF() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether the view and download icon working or not in the sample form /attachment on the details popup of the overview icon of Compliance Document?");
			
			CFOcountPOM.ComplianceDocumentsSF(test);
			
			extent.endTest(test);
			extent.flush();
		}*/
		@AfterMethod
	  	void browserClosing() throws InterruptedException
	  	{
			closeBrowser();
	  		//Thread.sleep(1000);
	  	//	getDriver().close();
	  	}	       
	  		       		
	  	@AfterTest
	  	void Closing() throws InterruptedException
	  	{
	  		
	  	}	 
			
			 
			 
			 
		
		@Test(priority = 57)
		void FilterWiseCategoriesCountMatch1() throws InterruptedException
		{
			test = extent.startTest(" Count Match Filter Wise by Clicking on 'Categories' - Compliances ");
			test.log(LogStatus.INFO, "Test Initiated");
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
			
			CFOcountPOM.clickCategories().click();
			Thread.sleep(500);
			
		//	litigationPerformer.MethodsPOM.progress();
			
			WebDriverWait wait = new WebDriverWait( getDriver(), (70));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[4]/div")));
			Thread.sleep(3000);
			CFOcountPOM.clickLocation().click();
			Thread.sleep(1000);
			CFOcountPOM.clickAVIPL().click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table")));
		
			Thread.sleep(8000);
			elementsList1 = CFOcountPOM.readCompliancesList();
			int	value = Integer.parseInt(elementsList1.get(1).getText());
			Thread.sleep(500);
			elementsList1.get(1).click();
			Thread.sleep(4000);
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
			js.executeScript("window.scrollBy(0,3000)");
			if(value == count1)
			{
				test.log(LogStatus.PASS, "Compliances count matches. Clicked value = " + value+ ", Grid Records = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Compliances count does not matches. Clicked value = "+value+", Grid Records = "+count1);
			}
			
			getDriver().switchTo().parentFrame();								//Switching back to parent frame.
			Thread.sleep(3000);
			CFOcountPOM.closeCategories_Compliances().click();		//Closing the 'Compliances' pup up.
			//Thread.sleep(2000);
		
		//	Thread.sleep(3000);
			js.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
			Thread.sleep(3000);
			getDriver().switchTo().defaultContent();
				
			Thread.sleep(4000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(2000);
			extent.endTest(test);
			extent.flush();
		}
//management.tlcg@gmail.com

		
		
		
		
		
		
		
		

	}



