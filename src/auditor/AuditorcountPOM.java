package auditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;//

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

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import approval.ApprovalcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtSonyMethod;
import login.BasePage;
import performer.OverduePOM;

public class AuditorcountPOM extends BasePage {
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	private static WebElement date = null;		
	
	
	public static WebElement DateText()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='txtAdvStartDate']"));
		return date;
	}
	public static WebElement DateTextEnd()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='txtAdvEndDate']"));
		return date;
	}
	
	
	public static WebElement DateYear()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]"));
		return date;
	}
	
	public static WebElement Year()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]/option[8]"));
		return date;
	}
	
	public static WebElement Years()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]/option[12]"));
		return date;
	}
	public static WebElement DateMonth()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]"));
		return date;
	}
	
	public static WebElement Month()	
	//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]/option[4]"));
		return date;
	}
	public static WebElement Month1()	
	//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]/option[12]"));
		return date;
	}
	
	
	public static WebElement Date()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[7]/a"));
		return date;
	}
	public static WebElement Date1()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a"));
		return date;
	}

	
	public static WebElement Apply()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='btnTopSearch']"));
		return date;
	}
	
	public static WebElement Status()		//Method for closing Message Popup
	{
		date = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[3]"));
		return date;
	}
	
	public static WebElement clickReports( )					//Searching 'My Reports' element
	{
		date = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']"));
		return date;
	}
	public static WebElement clickDetailedReport( )			//Searching 'Detailed Report' element under 'My reports'
	{
		date = getDriver().findElement(By.xpath("//*[@id='Myreport']"));
		return date;
	}
	public static void GraphCount( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (80));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(1000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(10000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
//		Thread.sleep(4000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			try {
				CFOcountPOM.closeDocument().click();
				}catch(Exception e){
					CFOcountPOM.closeDocument1().click();
				}
		
			getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(2000);
		
	}else {
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
		
		
	}
	}
	
	public static void GraphCountLow( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(1000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[19]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
	}else {
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
		
		
	}
	}
	
	public static void GraphCount1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			Thread.sleep(500);
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(10000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	
		Thread.sleep(5000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(6000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		
		}else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void GraphCount2( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(),(140));
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	
		Thread.sleep(8000);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		Thread.sleep(8000);
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		Thread.sleep(8000);
		
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			/*
			ViewButton.get(4).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
			Thread.sleep(500);
			CFOcountPOM.EnterRemark().sendKeys("remark");
			Thread.sleep(1000);
			CFOcountPOM.ReOpen().click();
			Thread.sleep(8000);
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();
			test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
.switchTo().parentFrame();
Thread.sleep(5000);
	*/
		
		Thread.sleep(1000);

		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		
	}
	
	
	public static void RiskGraphCount( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (90));
		Actions action = new Actions(getDriver());
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void RiskGraphCount2( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
		Actions action = new Actions(getDriver());
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(5000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(4000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			/*ViewButton.get(4).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
			Thread.sleep(500);
			CFOcountPOM.EnterRemark().sendKeys("remark");
			Thread.sleep(1000);
			CFOcountPOM.ReOpen().click();
			Thread.sleep(8000);
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();
			test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
getDriver().switchTo().parentFrame();
Thread.sleep(5000);*/
		
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
	}
	
	
	public static void RiskGraphCount1( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Actions action = new Actions(getDriver());
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		Thread.sleep(4000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		
			try {
				CFOcountPOM.closeDocument().click();
				
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
				}
				Thread.sleep(3000);
			
			test.log(LogStatus.PASS, "overView Successfully");
		
	
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
	
	}
	
	public static void RiskGraphCount11( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Actions action = new Actions(getDriver());
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
		
	//	elementsList = CFOcountPOM.selectDropdown();				//It is a dropdown but don't have Select tag.
		//elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
	/*	if(Compliance.equalsIgnoreCase("Internal"))
		{
			action.moveToElement(CFOcountPOM.selectFirst1()).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
		}
		else
		{
			action.moveToElement(CFOcountPOM.selectFirst()).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING)
		}*/
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void RiskGraphCountIn( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		Actions action = new Actions(getDriver());
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		
		if(count1 == ComplianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");

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
			try {
				CFOcountPOM.closeDocument().click();
				}catch(Exception e){
					CFOcountPOM.closeDocument1().click();
				}
			Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		Thread.sleep(3000);
	}
	
	public static void RiskGraphCountIn1( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		Actions action = new Actions(getDriver());
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			itomsCount = "0";
		}
		int count1 = Integer.parseInt(itomsCount);
		
		
		if(count1 == ComplianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
/*By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[18]/a[3]");

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
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);*/
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			test.log(LogStatus.PASS, "View successfully");
			Thread.sleep(3000);
			
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(3000);
		
	}
	
	
	public static void DetailedReport(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(7000);
		OverduePOM.clickcomplianceType().click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceSta().click();
		Thread.sleep(1000);
		OverduePOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage2().click();			//Exporting (Downloading) file
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Export successfully");
		Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(1000);
		try {
		CFOcountPOM.closeDocument1().click();
		}
		catch(Exception e)
		{
			CFOcountPOM.closeDocument2().click();
			
		}
		test.log(LogStatus.PASS, "overView successfully");
		
		Thread.sleep(3000);
		OverduePOM.clickRiskd().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[2]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locatorR));
		Thread.sleep(4000);
		
		WebElement clickHigh = getDriver().findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclear().click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);
		
		/*
		Thread.sleep(4000);
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	//	clickExportExcel().click();
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Advanced Search - overView successfully");
		Thread.sleep(1000);
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = getDriver().findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportExcel().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search - Export successfully");
	/*	CFOcountPOM.selectMonth1().click();
		Thread.sleep(3000);
		
		CFOcountPOM.selectLastSixMon().click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel().click();
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = .findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor);
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search -After Selecting Month overView successfully");
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(4000);
			CFOcountPOM.clickExportExcel().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search -After Selecting Month - Export successfully");
			//clickStartDate1().click();
			CFOcountPOM.clickStartDate11().sendKeys("23-Nov-2022");
			CFOcountPOM.clickLastDate11().sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			CFOcountPOM.clickApplyAd().click();
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Advanced Search -Apply Button Working  successfully");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);
			*/
			performer.OverduePOM.clickDashboard().click();
	}
	
	public static void GraphCountIn( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(4000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		

			String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
			String[] bits = s1.split(" ");									//Splitting the String
			String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
			
			int count = 0;
			if(itomsCount.equalsIgnoreCase("to"))							//If not items found
			{
				Thread.sleep(2500);
				s1 = CFOcountPOM.readTotalItems().getText();
				bits = s1.split(" ");										//Splitting the String
				itomsCount = bits[bits.length - 2];
			}
			if(itomsCount.equalsIgnoreCase("to"))							//If not items found
			{
				count = 0;
			}
			else
			{
				count = Integer.parseInt(itomsCount);
			}
			
			
			if(count == complianceCount)
			{
				
				test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
			}
			else
			{
			
				test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
			}
			
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(3000);
	
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(2000);
					getDriver().switchTo().parentFrame();
					CFOcountPOM.closeCategories().click();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountIn1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(8000);
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			try {
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			}catch(Exception e) {
				CFOcountPOM.closeDocument1().click();
			}
		
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(3000);
	
	}
	
	public static void GraphCountIn3( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	}
	
	public static void GraphCount4( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(2000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (80));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(1000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(10000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			try {
				CFOcountPOM.closeDocument().click();
				}catch(Exception e){
					CFOcountPOM.closeDocument1().click();
				}
		
			getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(2000);
		
	}else {
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
		
		
	}
	}
	
	public static void GraphCountIn2( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(1000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		if(count == complianceCount)
		{
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					getDriver().switchTo().parentFrame();
					CFOcountPOM.closeCategories().click();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountInPe( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(5000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(getDriver(),(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(8000);
				js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
				Thread.sleep(1000);
				CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
				String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
				String[] bits = s1.split(" ");									//Splitting the String
				String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
				
				int count = 0;
				if(itomsCount.equalsIgnoreCase("to"))							//If not items found
				{
					Thread.sleep(2500);
					s1 = CFOcountPOM.readTotalItems().getText();
					bits = s1.split(" ");										//Splitting the String
					itomsCount = bits[bits.length - 2];
				}
				if(itomsCount.equalsIgnoreCase("to"))							//If not items found
				{
					count = 0;
				}
				else
				{
					count = Integer.parseInt(itomsCount);
				}
				
				
				if(count == complianceCount)
				{
				//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
					test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
				}
				else
				{
				//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
					test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
				}
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
			
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		
		Thread.sleep(3000);
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					getDriver().switchTo().parentFrame();
					Thread.sleep(3000);
					CFOcountPOM.closeCategories1().click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountInPe1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(4000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		try                                                          
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
//		JavascriptExecutor js = (JavascriptExecutor) ;
			js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
			String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
			String[] bits = s1.split(" ");									//Splitting the String
			String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
			
			int count = 0;
			if(itomsCount.equalsIgnoreCase("to"))							//If not items found
			{
				Thread.sleep(2500);
				s1 = CFOcountPOM.readTotalItems().getText();
				bits = s1.split(" ");										//Splitting the String
				itomsCount = bits[bits.length - 2];
			}
			if(itomsCount.equalsIgnoreCase("to"))							//If not items found
			{
				count = 0;
			}
			else
			{
				count = Integer.parseInt(itomsCount);
			}
			
			
			if(count == complianceCount)
			{
			//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
				test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
			}
			else
			{
			//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
				test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
			}
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
			
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			try {
				CFOcountPOM.closeDocument().click();
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
				}
	
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					getDriver().switchTo().parentFrame();
					Thread.sleep(3000);
					CFOcountPOM.closeCategories1().click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountSatPe( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			Thread.sleep(3000);
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
	
				String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
				String[] bits = s1.split(" ");									//Splitting the String
				String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
				
				int count = 0;
				if(itomsCount.equalsIgnoreCase("to"))							//If not items found
				{
					Thread.sleep(2500);
					s1 = CFOcountPOM.readTotalItems().getText();
					bits = s1.split(" ");										//Splitting the String
					itomsCount = bits[bits.length - 2];
				}
				if(itomsCount.equalsIgnoreCase("to"))							//If not items found
				{
					count = 0;
				}
				else
				{
					count = Integer.parseInt(itomsCount);
				}
				
				
				if(count == complianceCount)
				{
				//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
					test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
				}
				else
				{
				//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
					test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
				}
		
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
				AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
				Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			ViewButton.get(2).click();
			test.log(LogStatus.PASS, "Download Doc successfully");
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		
		}
		else {
			int count=0;
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					getDriver().switchTo().parentFrame();
					CFOcountPOM.closeCategories1().click();
					
					
					if(count==complianceCount) {
						test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
						
						}
						else {
							test.log(LogStatus.FAIL, "'"+risk+"' Compliance Count = "+ complianceCount + " | Total no of items from grid = "+ count);
						}	
				}
	}
	
	
	public static void GraphCountSatPe1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			Thread.sleep(3000);
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			Thread.sleep(3000);
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(4000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try                                                          
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		
						
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		int count = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			Thread.sleep(2500);
			s1 = CFOcountPOM.readTotalItems().getText();
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];
		}
		if(itomsCount.equalsIgnoreCase("to"))							//If not items found
		{
			count = 0;
		}
		else
		{
			count = Integer.parseInt(itomsCount);
		}
		
		
		if(count == complianceCount)
		{
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
			
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			try {
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
			
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
					Thread.sleep(3000);
				}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		
		}
		else {
					
					int count=0;
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					getDriver().switchTo().parentFrame();
					CFOcountPOM.closeCategories1().click();
					
				
					if(count==complianceCount) {
						test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
						
						}
						else {
							test.log(LogStatus.FAIL, "'"+risk+"' Compliance Count = "+ complianceCount + " | Total no of items from grid = "+ count);
						}		
				}
	}
	
	public static void DetailedReportIn(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (160));	    
		Thread.sleep(3000);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		OverduePOM.clickcomplianceType().click();
		Thread.sleep(1000);
	//	OverduePOM.clickcomplianceSta().click();
	//	Thread.sleep(1000);
		OverduePOM.clickcomplianceIN().click();
		Thread.sleep(4000);
		OverduePOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage2().click();			//Exporting (Downloading) file
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Export successfully");
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(1000);
		try {
			CFOcountPOM.closeDocument1().click();
			}
			catch(Exception e)
			{
				CFOcountPOM.closeDocument2().click();
				
			}
		//CFOcountPOM.closeDocument1().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
		OverduePOM.clickRiskd().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[2]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement clickHigh = getDriver().findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclear().click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);
		/*
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
/*	OverduePOM.clickcomplianceTypeAS().click();
	Thread.sleep(2000);
//	OverduePOM.clickcomplianceStaASA().click();
	By locatorR1 = By.xpath("(//*[@class='k-checkbox-wrapper'])[89]");
	wait.until(ExpectedConditions.presenceOfElementLocated(locatorR1));
	Thread.sleep(4000);
	
	WebElement click = .findElement(locatorR1);	
	Thread.sleep(4000);
jse.executeScript("arguments[0].click();", click);
	Thread.sleep(4000);
	By locatorR2 = By.xpath("(//*[@class='k-checkbox-wrapper'])[90]");
	wait.until(ExpectedConditions.presenceOfElementLocated(locatorR2));
	Thread.sleep(4000);
	
	WebElement click1 = .findElement(locatorR2);	
	Thread.sleep(4000);
jse.executeScript("arguments[0].click();", click1);
	Thread.sleep(4000);*/
	Thread.sleep(1000);
//	OverduePOM.clickcomplianceINASMA().click();
	/*
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = getDriver().findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
	test.log(LogStatus.PASS, "Advanced Search-overView successfully");
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportExcel().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Advanced Search-Export successfully");
	/*	CFOcountPOM.selectMonth1().click();
		Thread.sleep(3000);
		
		CFOcountPOM.selectLastSixMon().click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel().click();
			Thread.sleep(2000);//*[@id="grid1"]/div[3]/table/tbody/tr[1]/td[27]/a[1]
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 = .findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor);
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search-After Apply Month-overView success");
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(4000);
			CFOcountPOM.clickExportExcel().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search-After Apply Month-Export Succefully");
			//clickStartDate1().click();*/
	/*
			CFOcountPOM.clickStartDate11().sendKeys("23-Nov-2022");
			CFOcountPOM.clickLastDate11().sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			CFOcountPOM.clickApplyAd().click();
			Thread.sleep(3000);
	CFOcountPOM.clickExportExcel().click();
        	Thread.sleep(3000);
			OverduePOM.clickRiskDA().click();
			Thread.sleep(1000);
			By locatorRA = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[72]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorRA));
			Thread.sleep(4000);
			
			WebElement clickHighA = getDriver().findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
			
			OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);
			*/
			OverduePOM.clickDashboard().click();
	}
	
	public static void DetailedReportRE(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		Thread.sleep(4000);
		Thread.sleep(2000);
		CFOcountPOM.Status().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		//CFOcountPOM.Filter().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ClosedTimely().click();	
		Thread.sleep(2000);
		CFOcountPOM.ClosedDelayedA().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.NotApplicableA().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		//CFOcountPOM.ClickFilter().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a[2]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews5"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark().sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen().click();
		Thread.sleep(8000);
		String msg =getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
getDriver().switchTo().parentFrame();


Thread.sleep(2000);
performer.OverduePOM.clickDashboard().click();
Thread.sleep(2000);
	}
	
	
	public static	void CompletedPFR_PieChartMp( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartMpView( ExtentTest test) throws InterruptedException
	{
		
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(8000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void RiskSummaryMp( ExtentTest test) throws InterruptedException
	{
		
	
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void RiskSummaryMpView( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void DeptSummaryMp( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAdminOverdueA().click();
		Thread.sleep(2000);
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void DeptSummaryMpView( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAdminOverdueA().click();
		Thread.sleep(2000);
		
		
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void DFPCompletedPFR_PieChartMp( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2200)");	
	
		Thread.sleep(3000);
		
		
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
		
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[2]");
			 Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
try {
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
}

			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
			Thread.sleep(4000);
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpView( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2200)");	
	
		Thread.sleep(3000);
		
		
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
		
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			try {
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
			
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found to View");
		}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartMpSC( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	   	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc = getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartMpViewSC( ExtentTest test) throws InterruptedException
	{
		
	
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(8000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	   	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc =  getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void RiskSummaryMpSC( ExtentTest test) throws InterruptedException
	{
		
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1200)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	   	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc =  getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void RiskSummaryMpViewSC( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1250)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	   	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc =  getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void DeptSummaryMpSC( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAdminOverdueA().click();
		Thread.sleep(2000);
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       js.executeScript("window.scrollBy(0,200)");
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	//   	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc =  getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void DeptSummaryMpViewSC( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1700)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAdminOverdueA().click();
		Thread.sleep(2000);
		
		
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	   //	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc = getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void DFPCompletedPFR_PieChartMpSC( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2200)");	
	
		Thread.sleep(3000);
		
		
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
		
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	   //	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc = getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[2]");
			 Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
try {
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
}

			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
			Thread.sleep(4000);
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpViewSC( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2200)");	
	
		Thread.sleep(3000);
		
		
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
		
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(3000);
	       MgmtSonyMethod.ComplianceTypeCheck().click();
	       Thread.sleep(5000);
	       ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	  // 	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT1().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc = getDriver().findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			try {
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
			
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found to View");
		}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
	
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,200)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(8000);
		
		
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void RiskSummaryMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
	
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1200)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void RiskSummaryMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1200)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
		Thread.sleep(8000);
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
	
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static void DFPCompletedPFR_PieChartMpIn( ExtentTest test) throws InterruptedException
	{
		
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2200)");	
	
		Thread.sleep(3000);
		
		
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
		
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
			 Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
try {
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
}

			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
			Thread.sleep(4000);
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2200)");	
	
		Thread.sleep(3000);
		
		
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
		
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver(); 
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			try {
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
			
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found to View");
		}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
		
		public static void PerformanceSummarySF(ExtentTest test)throws InterruptedException
		{
				WebDriverWait wait = new WebDriverWait( getDriver(), (35));
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,300)");	
				Thread.sleep(3000);
				CFOcountPOM.clickNotCompleted().click();								//CLicking on 'Not Completed' count
				
				Thread.sleep(3000);
				CFOcountPOM.readCritical().click();		
				Thread.sleep(3000);
				
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				Thread.sleep(8000);
				CFOcountPOM.ComplianceID().sendKeys("66196");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[1]");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton =getDriver() .findElement(locator);	
				Thread.sleep(3000);
				JavascriptExecutor jse= (JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
			
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver()  .switchTo().frame(farme1);
				Thread.sleep(3000);
		      	CFOcountPOM.Details().click();
		      	Thread.sleep(5000);
		      	OverduePOM.Clickoverview().click();
			  	Thread.sleep(3000);
			  	OverduePOM.ClickoverviewClose().click();
			  	Thread.sleep(3000);
				test.log(LogStatus.PASS, "The view icon should get working and document should be displayed on the popup.");
			
			
				Thread.sleep(3000);
				File dir = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) 
				{
					test.log(LogStatus.PASS,  "File downloaded successfully.");
				} 
				else 
				{
				test.log(LogStatus.FAIL,  "File does not downloaded.");
				}
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
			
			
			
				CFOcountPOM.closeDocument().click();

				getDriver().switchTo().defaultContent();
				Thread.sleep(3000);
				CFOcountPOM.closeCategories().click();
				Thread.sleep(1000);
			}
		public static void RiskSummarySF(ExtentTest test)throws InterruptedException
		{
				WebDriverWait wait = new WebDriverWait( getDriver(), (35));
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,1000)");	
				Thread.sleep(3000);
				CFOcountPOM.clickRiskCriticalNotCompleted().click();								//CLicking on 'Not Completed' count
				
						
				Thread.sleep(3000);
				
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				Thread.sleep(8000);
				CFOcountPOM.ComplianceID().sendKeys("66196");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[1]");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton =getDriver() .findElement(locator);	
				Thread.sleep(3000);
				JavascriptExecutor jse= (JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
			
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver()  .switchTo().frame(farme1);
				Thread.sleep(3000);
		      	CFOcountPOM.Details().click();
		      	Thread.sleep(5000);
		      	OverduePOM.Clickoverview().click();
			  	Thread.sleep(3000);
			  	OverduePOM.ClickoverviewClose().click();
			  	Thread.sleep(3000);
				test.log(LogStatus.PASS, "The view icon should get working and document should be displayed on the popup.");
			
			
				Thread.sleep(3000);
				File dir = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) 
				{
					test.log(LogStatus.PASS,  "File downloaded successfully.");
				} 
				else 
				{
				test.log(LogStatus.FAIL,  "File does not downloaded.");
				}
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
			
			
			
				CFOcountPOM.closeDocument().click();

				getDriver().switchTo().defaultContent();
				Thread.sleep(3000);
				CFOcountPOM.closeCategories().click();
				Thread.sleep(1000);


		}
		public static void DepartmentSummarySF(ExtentTest test)throws InterruptedException
		{
				WebDriverWait wait = new WebDriverWait( getDriver(), (35));
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				Thread.sleep(1000);
				CFOcountPOM.ALL().click();
				Thread.sleep(1000);
				CFOcountPOM.clickApply().click();
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,1500)");	
				Thread.sleep(3000);
				CFOcountPOM.clickAdminOverdueA().click();								//CLicking on 'Not Completed' count
				
						
				Thread.sleep(3000);
				
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				Thread.sleep(8000);
				CFOcountPOM.ComplianceID().sendKeys("66196");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[1]");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton =getDriver() .findElement(locator);	
				Thread.sleep(3000);
				JavascriptExecutor jse= (JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
			
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
				Thread.sleep(3000);
		      	CFOcountPOM.Details().click();
		      	Thread.sleep(5000);
		      	OverduePOM.Clickoverview().click();
			  	Thread.sleep(3000);
			  	OverduePOM.ClickoverviewClose().click();
			  	Thread.sleep(3000);
				test.log(LogStatus.PASS, "The view icon should get working and document should be displayed on the popup.");
			
			
				Thread.sleep(3000);
				File dir = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) 
				{
					test.log(LogStatus.PASS,  "File downloaded successfully.");
				} 
				else 
				{
				test.log(LogStatus.FAIL,  "File does not downloaded.");
				}
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
			
			
			
				CFOcountPOM.closeDocument().click();

				getDriver().switchTo().defaultContent();
				Thread.sleep(3000);
				CFOcountPOM.closeCategories().click();
				Thread.sleep(1000);


		}
		public static void PerformerSummaryDueForPeriodSF(ExtentTest test)throws InterruptedException
		{
				WebDriverWait wait = new WebDriverWait( getDriver(), (35));
				JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
				
				
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,2500)");	
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));
				Thread.sleep(3000);
				CFOcountPOM.clickNotCompleted().click();								//CLicking on 'Not Completed' count
				Thread.sleep(3000);
				CFOcountPOM.readCritical().click();
					
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
				Thread.sleep(8000);
				CFOcountPOM.ComplianceID().sendKeys("66196");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton =getDriver() .findElement(locator);	
				Thread.sleep(3000);
				JavascriptExecutor jse= (JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);
			
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver()  .switchTo().frame(farme1);
				Thread.sleep(3000);
		      	CFOcountPOM.Details().click();
		      	Thread.sleep(5000);
		      	OverduePOM.Clickoverview().click();
			  	Thread.sleep(3000);
			  	OverduePOM.ClickoverviewClose().click();
			  	Thread.sleep(3000);
				test.log(LogStatus.PASS, "The view icon should get working and document should be displayed on the popup.");
			
			
				Thread.sleep(3000);
				File dir = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) 
				{
					test.log(LogStatus.PASS,  "File downloaded successfully.");
				} 
				else 
				{
				test.log(LogStatus.FAIL,  "File does not downloaded.");
				}
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
		}
		public static void DetailedReportSF(ExtentTest test) throws InterruptedException, IOException
		{		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		    
			Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.Apply().click();
			Thread.sleep(2000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			
			
			CFOcountPOM.ComplianceID().sendKeys("66196");
			Thread.sleep(4000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
			JavascriptExecutor jse= (JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
			getDriver()  .switchTo().frame(farme1);
			Thread.sleep(3000);
		  	CFOcountPOM.Details().click();
		  	Thread.sleep(5000);
		  	OverduePOM.Clickoverview().click();
		  	Thread.sleep(3000);
		  	OverduePOM.ClickoverviewClose().click();
		  	Thread.sleep(3000);
			test.log(LogStatus.PASS, "The view icon should get working and document should be displayed on the popup.");


			Thread.sleep(3000);
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			OverduePOM.Download().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) 
			{
				test.log(LogStatus.PASS,  "File downloaded successfully.");
			} 
			else 
			{
			test.log(LogStatus.FAIL,  "File does not downloaded.");
			}
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			
			Thread.sleep(3000);
			CFOcountPOM.closeDocument2().click();
		}

		public static void ComplianceDocumentsSF(ExtentTest test  ) throws InterruptedException, IOException
		{
			
				WebDriverWait wait = new WebDriverWait(getDriver(), (140));
		    
				Thread.sleep(1000);
				CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
				Thread.sleep(3000);
				CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents '
				
				Thread.sleep(3000);
				CFOcountPOM.PeriodD1().click();	
				
				Thread.sleep(3000);
				CFOcountPOM.AllPeriod().click();
				
				
				Thread.sleep(3000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
				Thread.sleep(3000);
				CFOcountPOM.ComplianceID1().sendKeys("66196");
				
				Thread.sleep(2000);
				CFOcountPOM.Apply().click();
				Thread.sleep(2000);
				By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a[2]");
				
				WebElement ViewButton =getDriver() .findElement(locator);	
				Thread.sleep(3000);
				JavascriptExecutor jse= (JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
				getDriver()  .switchTo().frame(farme1);
				Thread.sleep(3000);
			  	CFOcountPOM.Details().click();
			  	Thread.sleep(5000);
			  	OverduePOM.Clickoverview().click();
			  	Thread.sleep(3000);
			  	OverduePOM.ClickoverviewClose().click();
			  	Thread.sleep(3000);
				test.log(LogStatus.PASS, "The view icon should get working and document should be displayed on the popup.");


				Thread.sleep(3000);
				File dir = new File("C:\\Users\\snehalp\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\snehalp\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) 
				{
					test.log(LogStatus.PASS,  "File downloaded successfully.");
				} 
				else 
				{
				test.log(LogStatus.FAIL,  "File does not downloaded.");
				}
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
				
				Thread.sleep(3000);
				CFOcountPOM.closeDocument2().click();
			}
	
		public static void GridAndExcelCountMatch(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
		{
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        
	        js.executeScript("window.scrollBy(0,700)");
	        Thread.sleep(2000); 		
	        CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
			Thread.sleep(1000);
			String s = CFOcountPOM.readTotalItemsD().getText();
			Thread.sleep(8000);
			String[] bits = s.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   s = CFOcountPOM.readTotalItemsD().getText();
				bits = s.split(" ");
	        
			}
			
			Thread.sleep(2000);
	        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
	        
	        js1.executeScript("window.scrollBy(0,-1000)");
	        Thread.sleep(2000);

	Thread.sleep(1000);
//	Thread.sleep(4000);
//	 CFOcountPOM.clickExportImage().click();
//		Thread.sleep(4000);
//		test.log(LogStatus.PASS, "Excel file Export Successfully");
//		Thread.sleep(3000);
	File dir = new File("C:\\Users\\mayurig\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	try {
	CFOcountPOM.clickExportImage().click();
	Thread.sleep(9000);	
	}
	catch(Exception e)
	{
		CFOcountPOM.clickExportImage2().click();
	}
	test.log(LogStatus.PASS, "File downloaded successfully.");

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\mayurig\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{
		
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
		
		Thread.sleep(1000);
		fis = new FileInputStream(lastModifiedFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
		/*
		int no = sheet.getFirstRowNum();
		Row row = sheet.getRow(no);
		Cell c1 = row.getCell(0);
		int records =(int) c1.getNumericCellValue();
		*/
		sheet = workbook.getSheetAt(0);
		int columnNumber = 3;
		int rowCount = 0;
		int actualRow=0;
		
		for(Row row : sheet)
		{
			
			Cell cell =row.getCell(columnNumber);
			if(cell != null) {
				
				rowCount++;
				actualRow = rowCount-1;
			}
			
		}
		fis.close();
		
		if(count1 == actualRow)
		{
			//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
			test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
		}
		else
		{
			//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
			test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
		}
	}
	else
	{
		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}

			
		}
		
		
		public static void riskSummaryCriticalNotCompleted(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,1500)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryCriticalNotCompleted = Integer.parseInt(NotCompleted);
    	//int riskSummaryCriticalNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());
    	String risk1 = CFOcountPOM.clickRiskHighNotCompleted().getText();
    	risk1 = risk1.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighNotCompleted = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());
    	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	
    	int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status1().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusOverDue().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusPendingForReview().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusRejected().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusInProgress().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApplied().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApproved().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationRejected().click();
	    	Thread.sleep(2000);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	       	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}
		
		public static void riskSummaryCriticalNotCompletedAU(ExtentTest test,String risk,String text)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,1200)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryCriticalNotCompleted = Integer.parseInt(NotCompleted);
    	//int riskSummaryCriticalNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());
    	String risk1 = CFOcountPOM.clickRiskHighNotCompleted().getText();
    	risk1 = risk1.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighNotCompleted = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());
    	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	
    	int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			if(text.equalsIgnoreCase("Statutory")) {
				CFOcountPOM.StatutoryM().click();
				Thread.sleep(1000);
				CFOcountPOM.ComplianceTypeEventBased().click();
				Thread.sleep(5000);
				CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
				Thread.sleep(5000);
				CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
				Thread.sleep(5000);
				}else {
					CFOcountPOM.StatutoryM().click();
					Thread.sleep(1000);
					CFOcountPOM.ComplianceTypeEventBased().click();
					Thread.sleep(5000);
					
				}
			
	    	CFOcountPOM.Status1().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusOverDue().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusPendingForReview().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusRejected().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusInProgress().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApplied().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApproved().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationRejected().click();
	    	Thread.sleep(2000);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.calendar().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.calendar1().click();
	    	Thread.sleep(2000);
	    	
	    	CFOcountPOM.calendar2().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.calendar12().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}
		
		public static void riskSummaryCriticalNotCompletedEx(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,1500)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryCriticalNotCompleted = Integer.parseInt(NotCompleted);
    	//int riskSummaryCriticalNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());
    	String risk1 = CFOcountPOM.clickRiskHighNotCompleted().getText();
    	risk1 = risk1.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighNotCompleted = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());
    	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	
    	int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(5000);
	    	
	    	CFOcountPOM.Status1().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusOverDue().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusPendingForReview().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusRejected().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusInProgress().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApplied().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApproved().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationRejected().click();
	    	Thread.sleep(2000);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	       	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}
		
		
		public static void riskSummaryCriticalNotCompletedIn(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,1500)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryCriticalNotCompleted = Integer.parseInt(NotCompleted);
    	//int riskSummaryCriticalNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());
    	String risk1 = CFOcountPOM.clickRiskHighNotCompleted().getText();
    	risk1 = risk1.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighNotCompleted = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());
    	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	
    	int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.Innternal().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
	    	CFOcountPOM.Status1().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusOverDue().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusPendingForReview().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusRejected().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusInProgress().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApplied().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApproved().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationRejected().click();
	    	Thread.sleep(2000);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	       	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	

		
		public static void riskSummaryCriticalNotCompletedInAu(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,800)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryCriticalNotCompleted = Integer.parseInt(NotCompleted);
    	//int riskSummaryCriticalNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());
    	String risk1 = CFOcountPOM.clickRiskHighNotCompleted().getText();
    	risk1 = risk1.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighNotCompleted = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompleted().getText());
    	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	
    	int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.Innternal().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
	    	CFOcountPOM.Status1().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusOverDue().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusPendingForReview().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusRejected().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusInProgress().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApplied().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationApproved().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusDeviationRejected().click();
	    	Thread.sleep(2000);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.calendar().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.calendar1().click();
	    	Thread.sleep(2000);
	    	
	    	CFOcountPOM.calendar2().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.calendar12().click();
	    	Thread.sleep(2000);

	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Completed Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	



public static void riskSummaryClosedDelayed(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,1500)");
		Thread.sleep(3000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
    	int riskSummaryCriticalclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());
    	String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
    	risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());
    	int riskSummaryLowclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());
    	
    	int total = riskSummaryCriticalclosedDelayed+riskSummaryHighclosedDelayed+riskSummaryMediumclosedDelayed+riskSummaryLowclosedDelayed;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusClosedDelay().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	

public static void riskSummaryClosedDelayedAU(ExtentTest test,String risk,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1200)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int riskSummaryCriticalclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());
String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

int riskSummaryMediumclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());
int riskSummaryLowclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());

int total = riskSummaryCriticalclosedDelayed+riskSummaryHighclosedDelayed+riskSummaryMediumclosedDelayed+riskSummaryLowclosedDelayed;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedDelay().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void riskSummaryClosedDelayedEx(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1500)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int riskSummaryCriticalclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());
String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

int riskSummaryMediumclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());
int riskSummaryLowclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());

int total = riskSummaryCriticalclosedDelayed+riskSummaryHighclosedDelayed+riskSummaryMediumclosedDelayed+riskSummaryLowclosedDelayed;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(4000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(2000);
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedDelay().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void riskSummaryClosedDelayedIn(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1500)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int riskSummaryCriticalclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());
String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

int riskSummaryMediumclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());
int riskSummaryLowclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());

int total = riskSummaryCriticalclosedDelayed+riskSummaryHighclosedDelayed+riskSummaryMediumclosedDelayed+riskSummaryLowclosedDelayed;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	CFOcountPOM.StatusClosedDelay().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void riskSummaryClosedDelayedInAu(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1200)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int riskSummaryCriticalclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayed().getText());
String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

int riskSummaryMediumclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayed().getText());
int riskSummaryLowclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayed().getText());

int total = riskSummaryCriticalclosedDelayed+riskSummaryHighclosedDelayed+riskSummaryMediumclosedDelayed+riskSummaryLowclosedDelayed;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	CFOcountPOM.StatusClosedDelay().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);

	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Delayed Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	



public static void riskSummaryClosedTimely(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,1500)");
		Thread.sleep(3000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

//    	String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//    	risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//		int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
		
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
    	
    	int total = RiskCritical_ClosedTimely+RiskHigh_ClosedTimely+RiskMedium_ClosedTimely+RiskLow_ClosedTimely;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusClosedTimely().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	

public static void riskSummaryClosedTimelyAU(ExtentTest test,String risk,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1200)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

//String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

int total = RiskCritical_ClosedTimely+RiskHigh_ClosedTimely+RiskMedium_ClosedTimely+RiskLow_ClosedTimely;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedTimely().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void riskSummaryClosedTimelyEx(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1500)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

//String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

int total = RiskCritical_ClosedTimely+RiskHigh_ClosedTimely+RiskMedium_ClosedTimely+RiskLow_ClosedTimely;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(4000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(2000);
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedTimely().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	
		
public static void riskSummaryClosedTimelyIn(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1500)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

//String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

//int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
//int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

int total = RiskCritical_ClosedTimely+RiskHigh_ClosedTimely;//+RiskMedium_ClosedTimely+RiskLow_ClosedTimely;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedTimely().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void riskSummaryClosedTimelyInAu(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1200)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(5000);
int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	

int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance
int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimely().getText());	//Reading the High Risk value of Not Completed compliance

int total = RiskCritical_ClosedTimely+RiskHigh_ClosedTimely+RiskMedium_ClosedTimely+RiskLow_ClosedTimely;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedTimely().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);

	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Closed Timely Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void riskSummaryNotApplicable(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,1500)");
		Thread.sleep(3000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		
		Thread.sleep(2000);
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
		Thread.sleep(2000);
		List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
		Thread.sleep(5000);
		int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

//    	String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//    	risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//		int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
		int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

		int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
		
		int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance
	
			
    	int total = RiskCritical_NotApplicable+RiskHigh_NotApplicable+RiskMedium_NotApplicable+RiskLow_NotApplicable;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusNotApplicable().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(total==count1)
			    {
			    	test.log(LogStatus.PASS, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	

public static void riskSummaryNotApplicableAU(ExtentTest test,String risk,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1200)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	

Thread.sleep(2000);
List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
Thread.sleep(2000);
List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
Thread.sleep(5000);
int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

//String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

	
int total = RiskCritical_NotApplicable+RiskHigh_NotApplicable+RiskMedium_NotApplicable+RiskLow_NotApplicable;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void riskSummaryNotApplicableEx(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1500)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	

Thread.sleep(2000);
List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
Thread.sleep(2000);
List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
Thread.sleep(5000);
int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

//String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

	
int total = RiskCritical_NotApplicable+RiskHigh_NotApplicable+RiskMedium_NotApplicable+RiskLow_NotApplicable;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(4000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(2000);
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void riskSummaryNotApplicableIn(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1500)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(2000);
List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
Thread.sleep(2000);
List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
Thread.sleep(5000);

int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

//String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

	
int total = RiskCritical_NotApplicable+RiskHigh_NotApplicable+RiskMedium_NotApplicable+RiskLow_NotApplicable;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void riskSummaryNotApplicableInAu(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1200)");
Thread.sleep(3000);
List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
	
Thread.sleep(2000);
List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Closed Delayed");
Thread.sleep(2000);
List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2'])"));
ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Closed Timely");
Thread.sleep(5000);

int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

//String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicable().getText());	//Reading the High Risk value of Not Completed compliance

	
int total = RiskCritical_NotApplicable+RiskHigh_NotApplicable+RiskMedium_NotApplicable+RiskLow_NotApplicable;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);

	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(total==count1)
	    {
	    	test.log(LogStatus.PASS, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Total of Risk Summary Not Applicable Count="+total+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void DepartmentSummaryOverdue(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo().getText();			//Reading the Overdue value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int Overdue = Integer.parseInt(NotCompleted);
    	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusOverDue().click();
	    	Thread.sleep(2000);
//	    	CFOcountPOM.StatusPendingForReview().click();
//	    	Thread.sleep(2000);
//	    	CFOcountPOM.StatusRejected().click();
//	    	Thread.sleep(2000);
//	    	CFOcountPOM.StatusInProgress().click();
//	    	Thread.sleep(2000);
//	    	CFOcountPOM.StatusDeviationApplied().click();
//	    	Thread.sleep(2000);
//	    	CFOcountPOM.StatusDeviationApproved().click();
//	    	Thread.sleep(2000);
//	    	CFOcountPOM.StatusDeviationRejected().click();
//	    	Thread.sleep(2000);
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentFilter().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentvalueAdmin().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(Overdue==count1)
			    {
			    	test.log(LogStatus.PASS, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	
		
public static void DepartmentSummaryOverdueAU(ExtentTest test,String risk,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1700)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo().getText();			//Reading the Overdue value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int Overdue = Integer.parseInt(NotCompleted);
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusOverDue().click();
	Thread.sleep(2000);
//	CFOcountPOM.StatusPendingForReview().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusRejected().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusInProgress().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApplied().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApproved().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationRejected().click();
//	Thread.sleep(2000);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Overdue==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	



public static void DepartmentSummaryOverdueEx(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,2000)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo().getText();			//Reading the Overdue value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int Overdue = Integer.parseInt(NotCompleted);
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(4000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(2000);
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusOverDue().click();
	Thread.sleep(2000);
//	CFOcountPOM.StatusPendingForReview().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusRejected().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusInProgress().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApplied().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApproved().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationRejected().click();
//	Thread.sleep(2000);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Overdue==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void DepartmentSummaryOverdueIn(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,2000)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo().getText();			//Reading the Overdue value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int Overdue = Integer.parseInt(NotCompleted);
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusOverDue().click();
	Thread.sleep(2000);
//	CFOcountPOM.StatusPendingForReview().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusRejected().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusInProgress().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApplied().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApproved().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationRejected().click();
//	Thread.sleep(2000);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Overdue==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DepartmentSummaryOverdueInAu(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1700)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo().getText();			//Reading the Overdue value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int Overdue = Integer.parseInt(NotCompleted);
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusOverDue().click();
	Thread.sleep(2000);
//	CFOcountPOM.StatusPendingForReview().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusRejected().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusInProgress().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApplied().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApproved().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationRejected().click();
//	Thread.sleep(2000);
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);

	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Overdue==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary Overdue Count="+Overdue+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	




	public static void DepartmentSummaryClosedDelayed(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
		
		  roc.click();
		  Thread.sleep(3000);
		String ClosedDelayed = CFOcountPOM.clickAdminClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
		ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
		int Closed_Delayed = Integer.parseInt(ClosedDelayed);
    	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusClosedDelay().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentFilter().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentvalueAdmin().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(Closed_Delayed==count1)
			    {
			    	test.log(LogStatus.PASS, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	

	public static void DepartmentSummaryClosedDelayedAU(ExtentTest test,String risk,String text)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  Thread.sleep(3000);
	String ClosedDelayed = CFOcountPOM.clickHumanClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
	ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
	int Closed_Delayed = Integer.parseInt(ClosedDelayed);
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(text.equalsIgnoreCase("Statutory")) {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			}else {
				CFOcountPOM.StatutoryM().click();
				Thread.sleep(1000);
				CFOcountPOM.ComplianceTypeEventBased().click();
				Thread.sleep(5000);
				
			}
		
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedDelay().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar1().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.calendar2().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar12().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Delayed==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	
	public static void DepartmentSummaryClosedDelayedEx(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  Thread.sleep(3000);
	String ClosedDelayed = CFOcountPOM.clickAdminClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
	ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
	int Closed_Delayed = Integer.parseInt(ClosedDelayed);
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeEventBased().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedDelay().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
       	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Delayed==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	
	public static void DepartmentSummaryClosedDelayedIn(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  Thread.sleep(3000);
	String ClosedDelayed = CFOcountPOM.clickAdminClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
	ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
	int Closed_Delayed = Integer.parseInt(ClosedDelayed);
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedDelay().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
       	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Delayed==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	public static void DepartmentSummaryClosedDelayedInAU(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  Thread.sleep(3000);
	String ClosedDelayed = CFOcountPOM.clickAdminClosedDelayed().getText();	//Reading the Closed Delayed value of Human Resource
	ClosedDelayed = ClosedDelayed.replaceAll(" ","");								//Removing all white spaces from string. 
	int Closed_Delayed = Integer.parseInt(ClosedDelayed);
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedDelay().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	Thread.sleep(2000);
    	CFOcountPOM.calendar().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar1().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.calendar2().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar12().click();
    	Thread.sleep(2000);

    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Delayed==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Delayed Count="+Closed_Delayed+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	

	public static void DepartmentSummaryClosedT(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
		
		  roc.click();
			Thread.sleep(3000);
		String ClosedTimely = CFOcountPOM.clickComplianceIsecClosedTimelyDemo().getText();		//Reading the Closed Timely value of Human Resource
		ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
		int Closed_Timely = Integer.parseInt(ClosedTimely);	
    	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusClosedTimely().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentFilter().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentvalueAdmin().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(Closed_Timely==count1)
			    {
			    	test.log(LogStatus.PASS, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	
	
	public static void DepartmentSummaryClosedTAU(ExtentTest test,String risk,String text)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
		Thread.sleep(3000);
	String ClosedTimely = CFOcountPOM.clickComplianceIsecClosedTimelyDemo().getText();		//Reading the Closed Timely value of Human Resource
	ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
	int Closed_Timely = Integer.parseInt(ClosedTimely);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(text.equalsIgnoreCase("Statutory")) {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			}else {
				CFOcountPOM.StatutoryM().click();
				Thread.sleep(1000);
				CFOcountPOM.ComplianceTypeEventBased().click();
				Thread.sleep(5000);
				
			}
		
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedTimely().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar1().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.calendar2().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar12().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Timely==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	
	public static void DepartmentSummaryClosedTEx(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
		Thread.sleep(3000);
	String ClosedTimely = CFOcountPOM.clickComplianceIsecClosedTimelyDemo().getText();		//Reading the Closed Timely value of Human Resource
	ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
	int Closed_Timely = Integer.parseInt(ClosedTimely);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeEventBased().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedTimely().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Timely==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	
	public static void DepartmentSummaryClosedTIn(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
		Thread.sleep(3000);
	String ClosedTimely = CFOcountPOM.clickComplianceIsecClosedTimelyDemo().getText();		//Reading the Closed Timely value of Human Resource
	ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
	int Closed_Timely = Integer.parseInt(ClosedTimely);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedTimely().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Timely==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	
	
	public static void DepartmentSummaryClosedTInAU(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
		Thread.sleep(3000);
	String ClosedTimely = CFOcountPOM.clickComplianceIsecClosedTimelyDemo().getText();		//Reading the Closed Timely value of Human Resource
	ClosedTimely = ClosedTimely.replaceAll(" ","");									//Removing all white spaces from string. 
	int Closed_Timely = Integer.parseInt(ClosedTimely);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusClosedTimely().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar1().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.calendar2().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar12().click();
    	Thread.sleep(2000);

    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Closed_Timely==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Closed Timely Count="+Closed_Timely+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	
	
	
		
	public static void DepartmentSummaPR(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
		
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
			
		  roc1.click();
		  Thread.sleep(4000);
		String PendingReview = CFOcountPOM.clickAccountPendingReview().getText();	//Reading the Pending For Review value of Human Resource
		PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
		int Pending_Review = Integer.parseInt(PendingReview);	
    	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusPendingForReview().click();
	    	Thread.sleep(2000);	   
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentFilter().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentvalueAdmin().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
			 Thread.sleep(8000); 	
			CFOcountPOM.readTotalItemsD().click();
			 Thread.sleep(8000); 	
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(Pending_Review==count1)
			    {
			    	test.log(LogStatus.PASS, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	
	
	public static void DepartmentSummaPRAU(ExtentTest test,String risk,String text)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(4000);
	String PendingReview = CFOcountPOM.clickAccountPendingReview().getText();	//Reading the Pending For Review value of Human Resource
	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
	int Pending_Review = Integer.parseInt(PendingReview);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(text.equalsIgnoreCase("Statutory")) {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			}else {
				CFOcountPOM.StatutoryM().click();
				Thread.sleep(1000);
				CFOcountPOM.ComplianceTypeEventBased().click();
				Thread.sleep(5000);
				
			}
		
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusPendingForReview().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	 CFOcountPOM.calendar().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar1().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar2().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar12().click();
     	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		 Thread.sleep(8000); 	
		CFOcountPOM.readTotalItemsD().click();
		 Thread.sleep(8000); 	
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Pending_Review==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	
	
	public static void DepartmentSummaPREx(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(4000);
	String PendingReview = CFOcountPOM.clickComplianceIsecPendingReviewDemo().getText();	//Reading the Pending For Review value of Human Resource
	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
	int Pending_Review = Integer.parseInt(PendingReview);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeEventBased().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusPendingForReview().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		 Thread.sleep(8000); 	
		CFOcountPOM.readTotalItemsD().click();
		 Thread.sleep(8000); 	
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Pending_Review==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	public static void DepartmentSummaPRIn(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(4000);
	String PendingReview = CFOcountPOM.clickFinancePendingReviewDept().getText();	//Reading the Pending For Review value of Human Resource
	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
	int Pending_Review = Integer.parseInt(PendingReview);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusPendingForReview().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		 Thread.sleep(8000); 	
		CFOcountPOM.readTotalItemsD().click();
		 Thread.sleep(8000); 	
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Pending_Review==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	
	public static void DepartmentSummaPRInAu(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(4000);
	String PendingReview = CFOcountPOM.clickFinancePendingReviewDept().getText();	//Reading the Pending For Review value of Human Resource
	PendingReview = PendingReview.replaceAll(" ","");								//Removing all white spaces from string. 
	int Pending_Review = Integer.parseInt(PendingReview);	
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusPendingForReview().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	Thread.sleep(2000);
    	CFOcountPOM.calendar().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar1().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.calendar2().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar12().click();
    	Thread.sleep(2000);

    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		 Thread.sleep(8000); 	
		CFOcountPOM.readTotalItemsD().click();
		 Thread.sleep(8000); 	
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(Pending_Review==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary  Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Pending Review Count="+Pending_Review+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	


	public static void DepaINPROGRESSR(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
		
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
			
		  roc1.click();
		  Thread.sleep(3000);
		String InProgress = CFOcountPOM.clickFinanceInProgressInternal().getText();	//Reading the Pending For Review value of Human Resource
		InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
		int In_Progress = Integer.parseInt(InProgress);		
    	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusInProgress().click();
	    	Thread.sleep(2000);	   
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentFilter().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentvalueAdmin().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(In_Progress==count1)
			    {
			    	test.log(LogStatus.PASS, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	
	
	public static void DepaINPROGRESSRAU(ExtentTest test,String risk,String text)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	String InProgress = CFOcountPOM.clickFinanceInProgressInternal().getText();	//Reading the Pending For Review value of Human Resource
	InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
	int In_Progress = Integer.parseInt(InProgress);		
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeEventBased().click();
    	Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
    	Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusInProgress().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	 CFOcountPOM.calendar().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar1().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar2().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar12().click();
     	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(In_Progress==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	
	
	public static void DepaINPROGRESSREx(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	String InProgress = CFOcountPOM.clickComplianceIsecInRejectedDemo().getText();	//Reading the Pending For Review value of Human Resource
	InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
	int In_Progress = Integer.parseInt(InProgress);		
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeEventBased().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusInProgress().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(In_Progress==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	
		
	
	public static void DepaINPROGRESSRIn(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	  WebElement roc2 =getDriver() .findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(13) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(25) > g:nth-child(2) > g:nth-child(1) > g:nth-child(4) > rect:nth-child(2)"));
		
	  roc2.click();
	  Thread.sleep(3000);
	String InProgress = CFOcountPOM.clickFinanceInProgressInternal().getText();	//Reading the Pending For Review value of Human Resource
	InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
	int In_Progress = Integer.parseInt(InProgress);		
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusInProgress().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(In_Progress==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	
	
	public static void DepaINPROGRESSRInAu(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	  WebElement roc2 =getDriver() .findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(13) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(25) > g:nth-child(2) > g:nth-child(1) > g:nth-child(4) > rect:nth-child(2)"));
		
	  roc2.click();
	  Thread.sleep(3000);
	String InProgress = CFOcountPOM.clickFinanceInProgressInternal().getText();	//Reading the Pending For Review value of Human Resource
	InProgress = InProgress.replaceAll(" ","");								//Removing all white spaces from string. 
	int In_Progress = Integer.parseInt(InProgress);		
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusInProgress().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar1().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.calendar2().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar12().click();
    	Thread.sleep(2000);

    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(In_Progress==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary In_Progress Count="+In_Progress+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	
	

	public static void DepaRejectedR(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
		
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
			
		  roc1.click();
		  Thread.sleep(3000);
		String Rejected = CFOcountPOM.clickComplianceIsecInRejectedDemo().getText();	//Reading the Pending For Review value of Human Resource
		Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
		int R_ejected = Integer.parseInt(Rejected);			
    	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusRejected().click();
	    	Thread.sleep(2000);	   
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentFilter().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentvalueAdmin().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(R_ejected==count1)
			    {
			    	test.log(LogStatus.PASS, "Department Summary R_ejected Count="+R_ejected+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Department Summary R_ejected Count="+R_ejected+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	
	
	public static void DepaRejectedRAU(ExtentTest test,String risk,String text)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	String Rejected = CFOcountPOM.clickFinanceRejectedInternal().getText();	//Reading the Pending For Review value of Human Resource
	Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
	int R_ejected = Integer.parseInt(Rejected);			
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		if(text.equalsIgnoreCase("Statutory")) {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			}else {
				CFOcountPOM.StatutoryM().click();
				Thread.sleep(1000);
				CFOcountPOM.ComplianceTypeEventBased().click();
				Thread.sleep(5000);
				
			}
		
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusRejected().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	 CFOcountPOM.calendar().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar1().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar2().click();
     	Thread.sleep(2000);
     	CFOcountPOM.calendar12().click();
     	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(R_ejected==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary R_ejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary R_ejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	
	public static void DepaRejectedREx(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	String Rejected = CFOcountPOM.clickComplianceIsecInRejectedDemo().getText();	//Reading the Pending For Review value of Human Resource
	Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
	int R_ejected = Integer.parseInt(Rejected);			
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
    	CFOcountPOM.ComplianceTypeEventBased().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusRejected().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(R_ejected==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary R_ejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary R_ejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	public static void DepaRejectedRIn(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,2000)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	String Rejected = CFOcountPOM.clickComplianceIsecInRejectedDemo().getText();	//Reading the Pending For Review value of Human Resource
	Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
	int R_ejected = Integer.parseInt(Rejected);			
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusRejected().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
    	Thread.sleep(2000);
    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(R_ejected==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Rejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Rejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	

	public static void DepaRejectedRInAu(ExtentTest test,String risk)throws InterruptedException
	{
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scroll(0,1700)");
	Thread.sleep(3000);
	WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	
	  roc.click();
	  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
		
	  roc1.click();
	  Thread.sleep(3000);
	String Rejected = CFOcountPOM.clickComplianceIsecInRejectedDemo().getText();	//Reading the Pending For Review value of Human Resource
	Rejected = Rejected.replaceAll(" ","");								//Removing all white spaces from string. 
	int R_ejected = Integer.parseInt(Rejected);			
	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
			
    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
    	Thread.sleep(3000);
    	Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		CFOcountPOM.Innternal().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
    	CFOcountPOM.Status().click();
    	Thread.sleep(2000);
    	CFOcountPOM.StatusRejected().click();
    	Thread.sleep(2000);	   
    	CFOcountPOM.Status().click();
    	Thread.sleep(500);
    	CFOcountPOM.Risk().click();
    	Thread.sleep(2000);
    	CFOcountPOM.RiskCritical().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskHigh().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskMedium().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.RiskLow().click();
    	Thread.sleep(2000);	
    	CFOcountPOM.PeriodDropDown().click();
    	Thread.sleep(2000);
    	CFOcountPOM.PeriodAll().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar1().click();
    	Thread.sleep(2000);
    	
    	CFOcountPOM.calendar2().click();
    	Thread.sleep(2000);
    	CFOcountPOM.calendar12().click();
    	Thread.sleep(2000);

    	CFOcountPOM.DepartmentFilter().click();
    	Thread.sleep(2000);
    	CFOcountPOM.DepartmentvalueAdmin().click();
    	Thread.sleep(2000);
    	CFOcountPOM.Apply().click();
    	Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

    // Reading Total Count of Detail Report Count
    	js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(8000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
		 Thread.sleep(8000); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
        CFOcountPOM.readTotalItemsD().click();
        Thread.sleep(8000);
		String item = CFOcountPOM.readTotalItemsD().getText();
		if(!item.equalsIgnoreCase("No items to display")) 
		{
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = CFOcountPOM.readTotalItemsD().getText();
			bits = item.split(" ");
       	}
		
		
			if(R_ejected==count1)
		    {
		    	test.log(LogStatus.PASS, "Department Summary Rejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }
		    else
		    {
		    	test.log(LogStatus.FAIL, "Department Summary Rejected Count="+R_ejected+" | Detailed Report Total ="+count1);
		    }			    	
	}else 
	{
		test.log(LogStatus.PASS, "No records found.");
	}
    	CFOcountPOM.DashBoardAfterCount().click();
 	}	


public static void DepaNotApplic(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scroll(0,2000)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
		
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
			
		  roc1.click();
		  Thread.sleep(3000);
		String NotApplicable = CFOcountPOM.clickComplianceIsecNotApplicableDemo().getText();	//Reading the Pending For Review value of Human Resource
		NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
		int Not_Applicable = Integer.parseInt(NotApplicable);			
    	//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
    			
	    //	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	    	Thread.sleep(3000);
	    	Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(4000);
			CFOcountPOM.Apply().click();
			Thread.sleep(4000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBased().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StatusNotApplicable().click();
	    	Thread.sleep(2000);	   
	    	CFOcountPOM.Status().click();
	    	Thread.sleep(500);
	    	CFOcountPOM.Risk().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.RiskCritical().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskHigh().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskMedium().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.RiskLow().click();
	    	Thread.sleep(2000);	
	    	CFOcountPOM.PeriodDropDown().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.PeriodAll().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentFilter().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.DepartmentvalueAdmin().click();
	    	Thread.sleep(2000);
	    	CFOcountPOM.Apply().click();
	    	Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	    // Reading Total Count of Detail Report Count
	    	js.executeScript("window.scrollBy(0,500)");
	        Thread.sleep(8000); 
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
			 Thread.sleep(8000); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
	        CFOcountPOM.readTotalItemsD().click();
	        Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
	       	}
			
			
				if(Not_Applicable==count1)
			    {
			    	test.log(LogStatus.PASS, "Department Summary NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
			    }
			    else
			    {
			    	test.log(LogStatus.FAIL, "Department Summary  NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
			    }			    	
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
	 	}	
		
public static void DepaNotApplicAU(ExtentTest test,String risk,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1700)");
Thread.sleep(3000);
WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));

  roc.click();
  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
	
  roc1.click();
  Thread.sleep(3000);
String NotApplicable = CFOcountPOM.clickComplianceIsecNotApplicableDemo().getText();	//Reading the Pending For Review value of Human Resource
NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
int Not_Applicable = Integer.parseInt(NotApplicable);			
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);	   
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	 CFOcountPOM.calendar().click();
 	Thread.sleep(2000);
 	CFOcountPOM.calendar1().click();
 	Thread.sleep(2000);
 	CFOcountPOM.calendar2().click();
 	Thread.sleep(2000);
 	CFOcountPOM.calendar12().click();
 	Thread.sleep(2000);
	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Not_Applicable==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary  NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void DepaNotApplicEx(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,2000)");
Thread.sleep(3000);
WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));

  roc.click();
  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
	
  roc1.click();
  Thread.sleep(3000);
String NotApplicable = CFOcountPOM.clickComplianceIsecNotApplicableDemo().getText();	//Reading the Pending For Review value of Human Resource
NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
int Not_Applicable = Integer.parseInt(NotApplicable);			
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(4000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(2000);
	
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);	   
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Not_Applicable==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary  NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

		
public static void DepaNotApplicIn(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,2000)");
Thread.sleep(3000);
WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));

  roc.click();
  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
	
  roc1.click();
  Thread.sleep(3000);
String NotApplicable = CFOcountPOM.clickComplianceIsecNotApplicableDemo().getText();	//Reading the Pending For Review value of Human Resource
NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
int Not_Applicable = Integer.parseInt(NotApplicable);			
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);	   
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("27-Mar-2025");
	Thread.sleep(2000);
	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Not_Applicable==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary  NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DepaNotApplicInAu(ExtentTest test,String risk)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,1700)");
Thread.sleep(3000);
WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));

  roc.click();
  WebElement roc1 =getDriver() .findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-0 > text"));
	
  roc1.click();
  Thread.sleep(3000);
String NotApplicable = CFOcountPOM.clickComplianceIsecNotApplicableDemo().getText();	//Reading the Pending For Review value of Human Resource
NotApplicable = NotApplicable.replaceAll(" ","");								//Removing all white spaces from string. 
int Not_Applicable = Integer.parseInt(NotApplicable);			
//int total = riskSummaryCriticalNotCompleted+riskSummaryHighNotCompleted+riskSummaryMediumNotCompleted+riskSummaryLowNotCompleted;
		
//	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompleted().getText());
	Thread.sleep(3000);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	CFOcountPOM.Status().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(2000);	   
	CFOcountPOM.Status().click();
	Thread.sleep(500);
	CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);

	CFOcountPOM.DepartmentFilter().click();
	Thread.sleep(2000);
	CFOcountPOM.DepartmentvalueAdmin().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(8000); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
		if(Not_Applicable==count1)
	    {
	    	test.log(LogStatus.PASS, "Department Summary NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Department Summary  NotApplicable Count="+Not_Applicable+" | Detailed Report Total ="+count1);
	    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void NCcompletionVsNCOverdue (ExtentTest test)throws InterruptedException
{
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,200)");
	int satPerformrNotcompleted=Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());
	Thread.sleep(5000);
	int satPerformrsummNotcompletedoverdue=Integer.parseInt(CFOcountPOM.clickOverdue().getText());
	int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());
	    int satPerformrsummNotcompletedPendingforreview=Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());
	    Thread.sleep(5000);
 	int satPerformrsummNotcompletedInprogress=Integer.parseInt(CFOcountPOM.clickinProgress().getText());
 	Thread.sleep(5000);
    int satPerformrsummNotcompletedRejected=Integer.parseInt(CFOcountPOM.clickRejectedPe().getText());
    int overduetotal=dueTodayValue+satPerformrsummNotcompletedoverdue+satPerformrsummNotcompletedPendingforreview+satPerformrsummNotcompletedInprogress+satPerformrsummNotcompletedRejected;

if(satPerformrNotcompleted==overduetotal)
{
	test.log(LogStatus.PASS, "Performer summary completion status graph Not Completed Status count="+satPerformrNotcompleted+" | Sum of Not completed statuses of Performer Summary Not Completed graph="+overduetotal);
	
}
 else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Performer summary completion status graph Not Completed Status count ="+satPerformrNotcompleted+" | Count of Performer summary Not completed status="+overduetotal);
    }
}


public static void NCcompletionVsNCOverdueP (ExtentTest test)throws InterruptedException
{
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver()  ;
	js.executeScript("window.scrollBy(0,2200)");			//Scrolling down window by 1000 px.cfo
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

	Thread.sleep(5000);
	int satPerformrsummNotcompletedoverdue=Integer.parseInt(CFOcountPOM.clickOverdue().getText());
	int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());
	    int satPerformrsummNotcompletedPendingforreview=Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());
	    Thread.sleep(5000);
 	int satPerformrsummNotcompletedInprogress=Integer.parseInt(CFOcountPOM.clickinProgress().getText());
 	Thread.sleep(5000);
    int satPerformrsummNotcompletedRejected=Integer.parseInt(CFOcountPOM.clickRejectedPe().getText());
    int overduetotal=dueTodayValue+satPerformrsummNotcompletedoverdue+satPerformrsummNotcompletedPendingforreview+satPerformrsummNotcompletedInprogress+satPerformrsummNotcompletedRejected;

if(NotCompletedValue==overduetotal)
{
	test.log(LogStatus.PASS, "Performer summary(Due for the period) completion status graph Not Completed Status count="+NotCompletedValue+" | Sum of Not completed statuses of Performer Summary Not Completed graph="+overduetotal);
	
}
 else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Performer summary(Due for the period) completion status graph Not Completed Status count ="+NotCompletedValue+" | Count of Performer summary Not completed status="+overduetotal);
    }


}

public static void DetailedreportVsdashboardNotCompletedcountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickNotCompleted().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	Thread.sleep(5000);
	if(text.equalsIgnoreCase("Statutory")) {
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	Thread.sleep(5000);
	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	Thread.sleep(5000);
	}else {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		
	}
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusOverDue().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusDueToday().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusPendingForReview().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusRejected().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusInProgress().click();
	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApplied().click();
	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApproved().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationRejected().click();
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Not Completed Count="+NotCompletedIn+" | Total Not Completed count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Not Completed Count="+NotCompletedIn+" | Total Not Completed count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}

public static void DetailedreportVsdashboardclosedtimelycountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickClosedTimely().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	Thread.sleep(5000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedTimely().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Closed Timely Count="+NotCompletedIn+" | Total Closed Timely count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Closed Timely Count="+NotCompletedIn+" | Total Closed Timely count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void DetailedreportVsdashboardCloseddealyedcountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickClosedDelayed().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(5000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusClosedDelay().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Closed Delayed Count="+NotCompletedIn+" | Total Closed Delayed count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Closed Delayed Count="+NotCompletedIn+" | Total Closed Delayed count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DetailedreportVsdashboardNAcountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickNotApplicable().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusNotApplicable().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Not Applicable Count="+NotCompletedIn+" | Total Not Applicable count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Not Applicable Count="+NotCompletedIn+" | Total Not Applicable count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DetailedreportVsOverduecountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickOverdue().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusOverDue().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Overdue Count="+NotCompletedIn+" | Total Overdue count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Overdue Count="+NotCompletedIn+" | Total Overdue count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DetailedreportVsDueTodaycountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickdueToday().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	Thread.sleep(5000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusDueToday().click();
	Thread.sleep(5000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of DueToday Count="+NotCompletedIn+" | Total DueToday count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of DueToday Count="+NotCompletedIn+" | Total DueToday count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DetailedreportVsPFRcountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickpendingForReviewIN().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusPendingForReview().click();
	Thread.sleep(5000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Pending For Review Count="+NotCompletedIn+" | Total Pending For Review count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Pending For Review Count="+NotCompletedIn+" | Total Pending For Review count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DetailedreportVsINprocountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickinProgress().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusInProgress().click();
	Thread.sleep(5000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of In Progress Count="+NotCompletedIn+" | Total In Progress count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of In Progress Count="+NotCompletedIn+" | Total In Progress count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	

public static void DetailedreportVsRejectedcountUp(ExtentTest test,String text)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickRejected().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
	CFOcountPOM.StatusRejected().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));

// Reading Total Count of Detail Report Count
	js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(8000); 
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
    CFOcountPOM.readTotalItemsD().click();
    Thread.sleep(8000);
	String item = CFOcountPOM.readTotalItemsD().getText();
	if(!item.equalsIgnoreCase("No items to display")) 
	{
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CFOcountPOM.readTotalItemsD().getText();
		bits = item.split(" ");
   	}
	
	
	if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Rejected Count="+NotCompletedIn+" | Total Rejected count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Rejected Count="+NotCompletedIn+" | Total Rejected count of Detail report ="+count1);
    }			    	
}else 
{
	test.log(LogStatus.PASS, "No records found.");
}
	CFOcountPOM.DashBoardAfterCount().click();
	}	


public static void DetailedreportVsCommercialCriticalcount(ExtentTest test,String text)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,700)");						//Scrolling down window by 1000 px.
	
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickIndustrySpeCriticalM().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(5000);
    try {
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
    	 Thread.sleep(5000);
        }catch(Exception e) {
        	
        }
    Thread.sleep(5000);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[3]")));
	 CFOcountPOM.ClickTri().click();
		Thread.sleep(2000);
		CFOcountPOM.Clickcolumns().click();
		Thread.sleep(2000);	
		CFOcountPOM.ClickCat().click();
		Thread.sleep(8000);	
		
		 CFOcountPOM.ClickTri1().click();
			Thread.sleep(2000);
			CFOcountPOM.ClickFilter1().click();
			Thread.sleep(2000);	
			CFOcountPOM.Search().sendKeys("Commercial");
			Thread.sleep(3000);
			CFOcountPOM.SearchCommercial().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
			js.executeScript("window.scrollBy(0,500)");
		    Thread.sleep(8000); 
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		    CFOcountPOM.readTotalItemsD().click();
		    Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);

			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
		   	}
    if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total  Commercial Critical Count="+NotCompletedIn+" | Total Commercial Critical count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Commercial Critical Count="+NotCompletedIn+" | Total Commercial Critical count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsCommercialHighcount(ExtentTest test,String text)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,700)");						//Scrolling down window by 1000 px.
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickIndustrySpeHighM().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(8000);
    	 Thread.sleep(5000);
    	 try {
    			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
    			 Thread.sleep(5000);
    		    }catch(Exception e) {
    		    	
    		    }
    			 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[3]")));
	 Thread.sleep(5000);
	 CFOcountPOM.ClickTri().click();
		Thread.sleep(2000);
		CFOcountPOM.Clickcolumns().click();
		Thread.sleep(2000);	
		CFOcountPOM.ClickCat().click();
		Thread.sleep(8000);	
		
		 CFOcountPOM.ClickTri1().click();
			Thread.sleep(2000);
			CFOcountPOM.ClickFilter1().click();
			Thread.sleep(2000);	
			CFOcountPOM.Search().sendKeys("Commercial");
			Thread.sleep(3000);
			CFOcountPOM.SearchCommercial().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
			js.executeScript("window.scrollBy(0,700)");
		    Thread.sleep(8000); 
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		    CFOcountPOM.readTotalItemsD().click();
		    Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);

			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
		   	}
    if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total  Commercial High Count="+NotCompletedIn+" | Total Commercial High count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Commercial High Count="+NotCompletedIn+" | Total Commercial High count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsCommercialMediumcount(ExtentTest test,String text)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,700)");						//Scrolling down window by 1000 px.
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickIndustrySpeMediumM().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(8000);
    try {
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(5000);
    }catch(Exception e) {
    	
    }
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[3]")));
	 Thread.sleep(2000);
	 CFOcountPOM.ClickTri().click();
		Thread.sleep(2000);
		CFOcountPOM.Clickcolumns().click();
		Thread.sleep(2000);	
		CFOcountPOM.ClickCat().click();
		Thread.sleep(8000);	
		
		 CFOcountPOM.ClickTri1().click();
			Thread.sleep(2000);
			CFOcountPOM.ClickFilter1().click();
			Thread.sleep(2000);	
			CFOcountPOM.Search().sendKeys("Commercial");
			Thread.sleep(3000);
			CFOcountPOM.SearchCommercial().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
			js.executeScript("window.scrollBy(0,500)");
		    Thread.sleep(8000); 
		//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		    CFOcountPOM.readTotalItemsD().click();
		    Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);

			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
		   	}
    if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total  Commercial Medium Count="+NotCompletedIn+" | Total Commercial Medium count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Commercial Medium Count="+NotCompletedIn+" | Total Commercial Medium count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
   
}

public static void DetailedreportVsCommercialLowcount(ExtentTest test,String text)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,700)");						//Scrolling down window by 1000 px.
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickIndustrySpeLowM().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	if(text.equalsIgnoreCase("Statutory")) {
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(1000);
		CFOcountPOM.ComplianceTypeEventBased().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
		Thread.sleep(5000);
		CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
		Thread.sleep(5000);
		}else {
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			
		}
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar1().click();
	Thread.sleep(2000);
	
	CFOcountPOM.calendar2().click();
	Thread.sleep(2000);
	CFOcountPOM.calendar12().click();
	Thread.sleep(2000);
	
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(8000);
    try {
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
    	 Thread.sleep(5000);
        }catch(Exception e) {
        	
        }	 Thread.sleep(5000);
	 
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[3]")));
		Thread.sleep(2000);
	 CFOcountPOM.ClickTri().click();
		Thread.sleep(2000);
		CFOcountPOM.Clickcolumns().click();
		Thread.sleep(2000);	
		CFOcountPOM.ClickCat().click();
		Thread.sleep(8000);	
		
		 CFOcountPOM.ClickTri1().click();
			Thread.sleep(2000);
			CFOcountPOM.ClickFilter1().click();
			Thread.sleep(2000);	
			CFOcountPOM.Search().sendKeys("Commercial");
			Thread.sleep(3000);
			CFOcountPOM.SearchCommercial().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
			js.executeScript("window.scrollBy(0,500)");
		    Thread.sleep(8000); 
		//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-pager-info k-label'])")));	//Wait until records table get visible.
		    CFOcountPOM.readTotalItemsD().click();
		    Thread.sleep(8000);
			String item = CFOcountPOM.readTotalItemsD().getText();
			if(!item.equalsIgnoreCase("No items to display")) 
			{
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of r)
			int count1 = Integer.parseInt(compliancesCount);

			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = CFOcountPOM.readTotalItemsD().getText();
				bits = item.split(" ");
		   	}
    if(count1==NotCompletedIn)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total  Commercial Low Count="+NotCompletedIn+" | Total Commercial Low count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Commercial Low Count="+NotCompletedIn+" | Total Commercial Low count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}























		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}