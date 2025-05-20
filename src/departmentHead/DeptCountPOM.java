package departmentHead;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import javax.sql.RowSet;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import approval.ApprovalcountPOM;
import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtSonyMethod;
import implementation.ImplementPOM;
import login.BasePage;
import performer.OverduePOM;

public class DeptCountPOM extends BasePage {
	
	private static WebElement categories = null;		
	
	public static WebElement SelectYear()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']"));
		return categories;
	}

	public static WebElement SelectAll()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']/option[7]"));
		return categories;
	}
	public static WebElement Refresh()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh']/label"));
		return categories;
	}
	
	
	public static WebElement ClickApply()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnTopSearch']"));
		return categories;
	}
	
	public static WebElement ClickDepartment()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='example']/div/span/span/span[2]/span"));
		return categories;
	}
	
	public static WebElement ClickDepartmentList()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='dropdowndept_listbox']/li[1]"));
		return categories;
	}
	
	public static WebElement ClickFrequency()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[2]/span/span[2]/span"));
		return categories;
	}
	
	public static WebElement EntityLocation()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/div/span[1]"));
		return categories;
	}
	
	public static WebElement EntityLocationDe()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/div[1]/div/div[1]/div/span[1]"));
		return categories;
	}
	
	public static WebElement ComplianceID()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='txtSearchComplianceID']"));
		return categories;
	}
	
	public static WebElement EntityLocationExpand()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//span[@class='k-checkbox-label checkbox-span']"));
		return categories;
	}
	
	public static WebElement SelectAll1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//span[.='Select All'])[1]"));
		return categories;
	}

	
	
	public static WebElement EntityLocationExpand1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[14]"));
		return categories;
	}
	
	public static WebElement ABPvtLtd1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[7]"));
		return categories;
	}
	
	public static WebElement ABPvtLtd11()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[9]"));
		return categories;
	}
	
	public static WebElement ABPvtLtd()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[34]"));
		return categories;
	}
	
	public static WebElement EntityLocationExpand1RE()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[18]"));
		return categories;
	}
	
	public static WebElement Status()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[2]/div/span[1]"));
		//*[@id='childrow']/div/div[1]/div[1]/div[3]/div/span[1]
		return categories;
	}
	
	public static WebElement Apply1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//button[@id='Applybtn']"));
		
		return categories;
	}

	public static WebElement Period()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[1]"));
		
		return categories;
	}

	
	public static WebElement PeriodDD()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//li[.='All Period']"));
		
		return categories;
	}

	
	public static WebElement StatusDe()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/div[1]/div/div[3]/div"));
		return categories;
	}
	
	public static WebElement Status1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[18]"));
		return categories;
	}
	
	public static WebElement Status1DE()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[25]"));
		return categories;
	}
	
	
	public static WebElement Status1RE()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[18]"));
		return categories;
	}
	
	public static WebElement EntityLocationAS()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='dvdropdowntree1']/div/div/span[1]"));
		return categories;
	}
	
	public static WebElement EntityLocationExpandAS()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-expand'])[8]"));
		return categories;
	}
	
	public static WebElement EntityLocationExpandASAudi()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-expand'])[13]"));
		return categories;
	}
	
	public static WebElement EntityLocationExpandASDept()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-expand'])[10]"));
		return categories;
	}
	
	public static WebElement Clear()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		
		return categories;
	}
	
	public static WebElement Clear1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='Clearfilter']"));
		return categories;
	}
	
	public static WebElement EntityLocationExpandAS1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[30]"));
		return categories;
	}
	
	public static WebElement EntityLocationExpandAS1Dept()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[49]"));
		return categories;
	}
	
	
	public static WebElement EntityLocationExpandASAu()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[3]"));
		return categories;
	}
	
	public static WebElement EntityLocationExpandASAuDi()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[67]"));
		return categories;
	}
	
	public static WebElement EntityLocationExpandASDe()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[19]"));
		return categories;
	}
	
	
	public static WebElement StatusAS()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='dvdropdownlistStatus1']/div/div"));
		return categories;
	}
	
	public static WebElement Type()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[1]/div"));
		return categories;
	}
	
	public static WebElement StatutoryCheckList()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[2]"));
		return categories;
	}
	
	public static WebElement EventBasedChecklist()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[3]"));
		return categories;
	}
	
	public static WebElement EventBased()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[4]"));
		return categories;
	}
	
	public static WebElement Internal()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[5]"));
		return categories;
	}
	
	public static WebElement InternalCheckList()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[6]"));
		return categories;
	}
	
	public static WebElement TypeAll()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@class='k-checkbox-label']"));
		return categories;
	}
	
	public static WebElement Apply()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='btnApply']"));
		return categories;
	}
	
	
	public static WebElement Status1AS()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[57]"));
		return categories;
	}
	
	public static WebElement Status1ASAU()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[122]"));
		return categories;
	}
	
	public static WebElement Act()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[1]/span/span[2]"));
		return categories;
	}
	
	public static WebElement Act1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[127]"));
		return categories;
	}
	
	public static WebElement ActMgmt()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[6]"));
		return categories;
	}
	
	public static WebElement Actper()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[2]"));
		return categories;
	}
	
	public static WebElement Risk()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div/span[1]"));
		return categories;
	}
	
	public static WebElement Category()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[5]/div/div/span[1]"));
		return categories;
	}
	
	public static WebElement Risk1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[2]"));
		return categories;
	}
	
	public static WebElement StatusM()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/div[2]"));
		return categories;
	}
	
	public static WebElement StatusP()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[4]/div/div/span[1]"));
		return categories;
	}
	
	public static WebElement StatusGR()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/div[2]/div/span[1]"));
		return categories;
	}
	
	public static WebElement StatusM1()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])[30]"));
		return categories;
	}
	
	public static WebElement RiskM()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@class='k-in'])"));
		return categories;
	}
	
	public static WebElement Norecord()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.linkText("No records found"));
		return categories;
	}
	
	public static WebElement Reopening()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("(//*[@id='leftApprovermenu']/a/span[1])[2]"));
		return categories;
	}
	
	public static WebElement Export()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='btnexport']"));
		return categories;
	}
	
	public static WebElement EntitySubEntityLocation()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/div/span[1]"));
		return categories;
	}
	
	public static WebElement ComplianceType()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[2]/div/span[1]"));
		return categories;
	}
	
	public static WebElement ComplianceIDRE()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='txtSearchComplianceID1']"));
		return categories;
	}
	
	public static WebElement period()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[2]/span/span[2]/span"));
		return categories;
	}
	
	public static WebElement Allperiod()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[7]"));
		return categories;
	}
	
	public static WebElement apply()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='Applybtn1']"));
		return categories;
	}
	
	
	public static WebElement ClickEdit()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[12]/a[1]"));
		return categories;
	}
	
	public static WebElement Approve()		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//*[@id='btn_Approver']"));
		return categories;
	}
	
	public static WebElement clickReports( )					//Searching 'My Reports' element
	{
		categories = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']"));
		return categories;
	}
	public static WebElement clickDetailedReport( )			//Searching 'Detailed Report' element under 'My reports'
	{
		categories = getDriver().findElement(By.xpath("//*[@id='Myreport']"));
		return categories;
	}
	
	
	
	public static void GraphCount( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			Thread.sleep(3000);
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
			Thread.sleep(3000);
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
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
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(6000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(8000);
			
	  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");
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
				
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
				}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		Thread.sleep(5000);
	}
	
	public static void GraphCount1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(8000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(8000);
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(8000);
				// retrieving "foo-button" HTML element
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(5000);
				ViewButton.get(0).click();
				Thread.sleep(7000);
				CFOcountPOM.closeDocument1().click();
				test.log(LogStatus.PASS, "View successfully");
				Thread.sleep(3000);
				
				ViewButton.get(1).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Download Doc successfully");
				ViewButton.get(2).click();
			//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			//jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
		Thread.sleep(500);
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
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
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
	}
	
	public static void GraphCount2( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(220));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
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
		
		
		Thread.sleep(8000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(8000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			Thread.sleep(8000);
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]/a");
				Thread.sleep(8000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(7000);
				// retrieving "foo-button" HTML element
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(4000);
				ViewButton.get(0).click();
				Thread.sleep(6000);
				CFOcountPOM.closeDocument1().click();
				test.log(LogStatus.PASS, "View successfully");
				Thread.sleep(3000);
				
				ViewButton.get(1).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Download Doc successfully");
				ViewButton.get(2).click();
			//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			//jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
	
		Thread.sleep(500);
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		
		
	}
	
	public static void GraphCountSta( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(1000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(5000);
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(220));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(5000);
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
		Thread.sleep(6000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(8000);
		
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");
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
			
			}catch(Exception e) {
				CFOcountPOM.closeDocument1().click();
			}
	
	Thread.sleep(500);
	getDriver().switchTo().parentFrame();
	CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
	
	Thread.sleep(5000);					//Closing the High Risk Window.
		
		
		
	}
	
	
	public static void RiskGraphCount1( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(60));
	
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(10000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
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
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
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
		
		
}else {		
             int count=0;
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			if(count==ComplianceCount) {
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  Compliances count matches to numbers of items from grid.= 0");
			
			}
			else {
				test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
			}
			
		}
	}
	
	public static void RiskGraphCount1In( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(60));
	
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(2000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
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
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
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
				Thread.sleep(3000);
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
				}
		
		Thread.sleep(1000);
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
}else {
			
	int count=0;
	
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(300,0)");	
	Thread.sleep(1000);
	getDriver().switchTo().parentFrame();
	CFOcountPOM.closeCategories().click();
	Thread.sleep(1000);
	if(count==ComplianceCount) {
	test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
	
	}
	else {
		test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
	}
	
			
		}
	}
	
	public static void RiskGraphCount( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
		
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(10000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
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
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(8000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
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
		//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		//jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
}else {
	

	int count=0;
	
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(300,0)");	
	Thread.sleep(1000);
	getDriver().switchTo().parentFrame();
	CFOcountPOM.closeCategories().click();
	Thread.sleep(1000);
	if(count==ComplianceCount) {
	test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
	
	}
	else {
		test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
	}
	
			
		}
	}
	
	public static void RiskGraphCountDept( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
		
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(10000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
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
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(8000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
}else {
	

	int count=0;
	
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(300,0)");	
	Thread.sleep(1000);
	getDriver().switchTo().parentFrame();
	CFOcountPOM.closeCategories().click();
	Thread.sleep(1000);
	if(count==ComplianceCount) {
	test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
	
	}
	else {
		test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
	}
	
			
		}
	}
	
	
	public static void RiskGraphCountIn( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
		
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
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
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
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
		
	
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(3000);
		
}else {
			
int count=0;
	
	Thread.sleep(3000);
	js.executeScript("window.scrollBy(300,0)");	
	Thread.sleep(1000);
	getDriver().switchTo().parentFrame();
	CFOcountPOM.closeCategories().click();
	Thread.sleep(1000);
	if(count==ComplianceCount) {
	test.log(LogStatus.PASS, "'"+ComplianceType+"'  Compliance count matches to numbers of items from grid.= 0");
	
	}
	else {
		test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
	}
			
		}
	}
	
	
	public static void RiskGraphCountRE( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
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
		//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		//jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
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
getDriver().switchTo().parentFrame();
Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.INFO, "'"+ComplianceType+"' Complaince Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void GraphCountInPe1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(),(60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a[1]");

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
				}catch(Exception e){
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
					CFOcountPOM.closeCategories1().click();
					
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	public static void GraphCountInPe4( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
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
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		
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
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(1000);
					getDriver().switchTo().parentFrame();
					CFOcountPOM.closeCategories1().click();
					
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
	
	public static void GraphCountInPe( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {	
			Thread.sleep(3000);
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]/a");

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
		//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		//jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(3000);
		
		}	else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
				
		}
	}
	
	public static void GraphCountInPeSta( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(8000);
		if(!s.equalsIgnoreCase("No items to display")) {	
			Thread.sleep(3000);
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[23]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			
			ViewButton.get(2).click();
		//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		//jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(3000);
		
		}	else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
				
		}
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
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
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
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
				}catch(Exception e){
					CFOcountPOM.closeDocument1().click();
				}
			
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
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
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			
			test.log(LogStatus.PASS, "View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Doc Download Successfully");
			ViewButton.get(2).click();
		//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		//jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
	}
 	
 	public static void GraphCountInPe2( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
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
			//test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
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
		
	
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories1().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void GraphCountInPe3( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(500);
		}
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
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
	
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
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
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View successfully");
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Download Doc successfully");
			ViewButton.get(2).click();
		
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(3000);
		
}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories1().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
		
	}
	
	public static void DetailedReportIn(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		WebElement select=	getDriver().findElement(By.xpath("//*[@id='example']/div/div[1]/div[1]/span"));
		select.click();
		getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[3]")).click();
			Thread.sleep(1000);
			getDriver().findElement(By.xpath("//*[@id='Applybtn']")).click();
			Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		OverduePOM.clickcomplianceType().click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceSta().click();
		Thread.sleep(1000);
		OverduePOM.clickcomplianceIN().click();
		Thread.sleep(4000);
		CFOcountPOM.clickExportImage().click();			//Exporting (Downloading) file
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Export successfully");
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(1000);
		CFOcountPOM.closeDocument1().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
		OverduePOM.clickRiskD().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement clickHigh = getDriver().findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclearBtn().click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(8000);
		WebElement select1=	getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/span"));
		select1.click();
		getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole1_listbox']/li[3]")).click();
			Thread.sleep(1000);
			getDriver().findElement(By.xpath("//*[@id='Applybtn1']")).click();
			Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
/*	OverduePOM.clickcomplianceTypeAS().click();
	Thread.sleep(2000);
	OverduePOM.clickcomplianceStaASD().click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceStaASDIN().click();
	*/
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
		
		WebElement close = getDriver().findElement(locator3);	
		Thread.sleep(4000);
	
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
	test.log(LogStatus.PASS, "Advanced Search-overView successfully");
		Thread.sleep(4000);
	
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
			Thread.sleep(2000);
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
			//clickStartDate1().click();
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
			
			WebElement clickHighA = .findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
			*/
			OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);
			OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
	}
	
	public static void complianceDocuments(ExtentTest test ) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, " :- View successfully.");
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "  File downloaded successfully.");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "  OverView successfully.");
			 By locator1 = By.xpath("//*[@id='sel_chkbxMain']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = getDriver().findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " After Checking Multiple checkbox  File downloaded successfully.");
			/*	OverduePOM.clickRiskDE().click();
				Thread.sleep(2000);
				OverduePOM.clickHighDE().click();
				Thread.sleep(2000);
				OverduePOM.clickclearBtn().click();
				Thread.sleep(2000);*/
				test.log(LogStatus.PASS, "Clear Button Working");
				CFOcountPOM.clickAdvancedSearch().click();
				Thread.sleep(3000);
				
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			By locator2 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[3]/td[19]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = getDriver().findElements(locator2);	
			Thread.sleep(3000);
			ViewButton1.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search :- View successfully.");
			ViewButton1.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - File downloaded successfully.");
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search -  OverView successfully.");
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = getDriver().findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				Thread.sleep(500);
				ChechBoxes1.get(1).click();
				Thread.sleep(500);
				ChechBoxes1.get(2).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, " Advanced Search - After Checking Multiple checkbox  File downloaded successfully.");
			/*	OverduePOM.SelectStatus().click();
				Thread.sleep(1000);
				OverduePOM.SelectstatusCD().click();
				Thread.sleep(2000);
				OverduePOM.clickclearBtnA().click();*/
				getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/div/a[4]")).click();
				test.log(LogStatus.PASS, "Clear Button Working");
			//	CFOcountPOM.closeDocumentAS().click();
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}

	public static void GraphCountPFR( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.Status().click();
		Thread.sleep(1000);
		ApprovalcountPOM.CheckAll().click();
		ApprovalcountPOM.CheckAll().click();
		Thread.sleep(1000);
		ApprovalcountPOM.PFRDept().click();
		Thread.sleep(1000);
		ApprovalcountPOM.Status().click();
		Thread.sleep(10000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(1000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(4000);
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(3000);
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			test.log(LogStatus.PASS,"'"+risk+"'Risk: "+ "View successfully");
			Thread.sleep(3000);
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			ViewButton.get(1).click();
			
			Thread.sleep(3000);//C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS, "'"+risk+"'Risk: "+ "Download Doc successfully");
			} else {
				test.log(LogStatus.FAIL,"'"+risk+"'Risk: "+ "  Document does not downloaded.");
			}
			

		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		
		
	}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance : - No records found Displyed");
			Thread.sleep(1000);
			
		}
	}
	
	public static void GraphCountPFRIn( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(500);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		ApprovalcountPOM.Status().click();
		Thread.sleep(1000);
		ApprovalcountPOM.CheckAllIn().click();
		ApprovalcountPOM.CheckAllIn().click();
		Thread.sleep(2000);
		ApprovalcountPOM.PFRDeptIn().click();
		Thread.sleep(2000);
		ApprovalcountPOM.Status().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(1000);
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
		Thread.sleep(3000);
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			test.log(LogStatus.PASS,"'"+risk+"'Risk: "+ "View successfully");
			Thread.sleep(3000);
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			ViewButton.get(1).click();
			
			Thread.sleep(3000);//C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS, "'"+risk+"'Risk: "+ "Download Doc successfully");
			} else {
				test.log(LogStatus.FAIL,"'"+risk+"'Risk: "+ "  Document does not downloaded.");
			}
			

		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		
		
	}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance : - No records found Displyed");
			Thread.sleep(1000);
			
		}
	}

	public static void FilterWiseDepartmentCountMatch( ExtentTest test)throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		CFOcountPOM.clickCategories().click();
		Thread.sleep(5000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]/a")));
		Thread.sleep(5000);
		ClickDepartment().click();
		Thread.sleep(1000);
		 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdowndept_listbox']/li[1]")); 
		 String cattext =TextCat.getText();
		 Thread.sleep(1000);
		 TextCat.click();
		//ApprovalcountPOM.Commercial().click();
		Thread.sleep(3000);
		
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
			 test.log(LogStatus.FAIL, "Selected Department wise filter not Match with gird : "+Fal);
			// System.out.println("fail : "+Fal);
		 }
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Selected Department  wise filter Match with gird Value : "+Pas);
			// System.out.println("Pass : "+Pas);
		 }
		 
		getDriver().switchTo().defaultContent();
			
		Thread.sleep(4000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
	}

	public static void FilterWiseCompliancesCountMatch( ExtentTest test)throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		CFOcountPOM.readCompliances().click();
		Thread.sleep(5000);
		
	//	litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]/a")));
		Thread.sleep(3000);
		ApprovalcountPOM.SelectCategory().click();
		Thread.sleep(1000);
		 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[2]")); 
		 String cattext =TextCat.getText();
		 Thread.sleep(1000);
	//	 TextCat.click();
		 ApprovalcountPOM.Commercial().click();
		Thread.sleep(5000);
    js.executeScript("window.scrollBy(0,200)");	
    Thread.sleep(4000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(3000);
		if(!s.equalsIgnoreCase("No items to display")) {
		
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
			 test.log(LogStatus.FAIL, "Selection wise all filter should not working : "+Fal);
			 System.out.println("fail : "+Fal);
		 }
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Selection wise all filter should be working Properly : "+Pas);
			 System.out.println("Pass : "+Pas);
		 }
		}
		else{
			Thread.sleep(3000);
			 test.log(LogStatus.PASS, "No records found");
		}
		Thread.sleep(4000);
		getDriver().switchTo().defaultContent();
			
		Thread.sleep(4000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
	}

	public static void FilterWiseCompliancesCountMatchIn( ExtentTest test)throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		CFOcountPOM.readCompliances().click();
		Thread.sleep(5000);
		
		//litigationPerformer.MethodsPOM.progress();
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]/a")));
		Thread.sleep(3000);
		ClickFrequency().click();
		Thread.sleep(1000);
		 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdownFrequency_listbox']/li[1]")); 
		 String cattext =TextCat.getText();
		 Thread.sleep(1000);
		 TextCat.click();
		// ApprovalcountPOM.Commercial().click();
		Thread.sleep(5000);
    js.executeScript("window.scrollBy(0,200)");	
		
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(3000);
		if(!s.equalsIgnoreCase("No items to display")) {
			
		Thread.sleep(1000);
		 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[4]")); //column list
		 
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
			 test.log(LogStatus.FAIL, "Selection wise all filter should be working Properly : "+Fal);
			// System.out.println("fail : "+Fal);
		 }
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Selection wise all filter should not working : "+Pas);
			// System.out.println("Pass : "+Pas);
		 }
		}
		else{
			Thread.sleep(3000);
			 test.log(LogStatus.PASS, "No records found");
		}
		 
		getDriver().switchTo().defaultContent();
			
		Thread.sleep(4000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
	}
	
	public static void ComplianceDocumentsFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		/*Thread.sleep(3000);
		EntityLocation().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		String locationtext =EntityLocationExpand1().getText();
       Thread.sleep(500);
       EntityLocationExpand1().click();
       Thread.sleep(500);
       EntityLocation().click();*/
       Thread.sleep(3000);
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1DE().getText();
       Thread.sleep(500);
       Status1DE().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(500);
        List<String> li=new ArrayList<String>();
        
       // li.add(locationtext);
        li.add(Statustext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		//filter.add("Location");
		filter.add("Status");	
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		//List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[4]"));
		//entitycol.get(0).click();
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[15]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

//				if(i==0)
//				{
//					raw.addAll(entitycol);
//				}
			 if(i==0)
				{
					raw.addAll(statuscol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
	/*	Thread.sleep(3000);
		
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		EntityLocationAS().click();
		Thread.sleep(500);
		EntityLocationExpandAS().click();
		Thread.sleep(500);
		EntityLocationExpandAS().click();
		Thread.sleep(500);
      String locationtextAS =EntityLocationExpandAS1().getText();
       Thread.sleep(500);
       EntityLocationExpandAS1().click();
       Thread.sleep(500);
       EntityLocationAS().click();
       Thread.sleep(3000);
       StatusAS().click();
       Thread.sleep(500);
       String StatustextAS =Status1AS().getText();
       Thread.sleep(500);
       Status1AS().click();
       Thread.sleep(500);
     //  StatusAS().click();
       Thread.sleep(500);
        List<String> liAS=new ArrayList<String>();
        
        liAS.add(locationtextAS);
        liAS.add(StatustextAS);
        Thread.sleep(3000);
        
		List<String> filterAS=new ArrayList<String>();	
		filterAS.add("Location");
		filterAS.add("Status");	
		
		js.executeScript("window.scrollBy(0,600)");	
		Thread.sleep(2000);
	//	CFOcountPOM.readTotalItemsD1().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD1().getText();
		if(!s1.equalsIgnoreCase("No items to display")) {
		Thread.sleep(3000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[6]"));
		entitycol.get(0).click();
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[14]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(entitycol);
				}
			else if(i==1)
				{
					raw.addAll(statuscol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL,"Advanced Search : -"+ filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Advanced Search : -"+ filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"Advanced Search : - No records found");	
		}
		Thread.sleep(3000);
		CFOcountPOM.closeDocumentAS().click();*/
		Thread.sleep(3000);
	
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceDocumentsFilterRE(ExtentTest test ) throws InterruptedException, IOException
	{	
	    
		Thread.sleep(2000);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		/*Thread.sleep(3000);
		EntityLocation().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
      	String locationtext =EntityLocationExpand1RE().getText();
       Thread.sleep(500);
       EntityLocationExpand1RE().click();
       Thread.sleep(500);
       EntityLocation().click();*/
       Thread.sleep(3000);
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1RE().getText();
       Thread.sleep(500);
       Status1RE().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(500);
        List<String> li=new ArrayList<String>();
        
        //li.add(locationtext);
        li.add(Statustext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		//filter.add("Location");
		filter.add("Status");	
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		//List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[4]"));
		//entitycol.get(0).click();
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[13]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

//				if(i==0)
//				{
//					raw.addAll(entitycol);
//				}
			 if(i==0)
				{
					raw.addAll(statuscol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		
		
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceDocumentsFilterAu(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		EntityLocation().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		SelectAll1().click();
		Thread.sleep(500);
      String locationtext =EntityLocationExpandASAu().getText();
       Thread.sleep(500);
       EntityLocationExpandASAu().click();
       Thread.sleep(500);
       EntityLocation().click();
       Thread.sleep(3000);
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1().getText();
       Thread.sleep(500);
       Status1().click();
       Thread.sleep(500);
     //  Status().click();
    //   Thread.sleep(6000);
       Period().click();
       Thread.sleep(6000);
       PeriodDD().click();
       Thread.sleep(6000);     
       Apply1().click();
       Thread.sleep(6000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[6]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[15]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(entitycol);
				}
			else if(i==1)
				{
					raw.addAll(statuscol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		/*
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		EntityLocationAS().click();
		Thread.sleep(500);
		EntityLocationExpandASAudi().click();
		Thread.sleep(500);
		EntityLocationExpandASAudi().click();
		Thread.sleep(500);
      String locationtextAS =EntityLocationExpandASAuDi().getText();
       Thread.sleep(500);
       EntityLocationExpandASAuDi().click();
       Thread.sleep(500);
       EntityLocationAS().click();
       Thread.sleep(3000);
       StatusAS().click();
       Thread.sleep(500);
       String StatustextAS =Status1ASAU().getText();
       Thread.sleep(500);
       Status1ASAU().click();
     
       Thread.sleep(5000);
        List<String> liAS=new ArrayList<String>();
        
        liAS.add(locationtextAS);
        liAS.add(StatustextAS);
        Thread.sleep(3000);
        
		List<String> filterAS=new ArrayList<String>();	
		filterAS.add("Location");
		filterAS.add("Status");	
		
	
		Thread.sleep(3000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[6]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[14]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(entitycol);
				}
			else if(i==1)
				{
					raw.addAll(statuscol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL,"Advanced Search : -"+ filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Advanced Search : -"+ filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		
		Thread.sleep(3000);
		
		CFOcountPOM.closeDocumentAS().click();
		Thread.sleep(3000);
		*/
	
				OverduePOM.clickDashboard().click();
		
	}

	public static void ComplianceDocumentsFilterDept(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		EntityLocationDe().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(1000);
      String locationtext =EntityLocationExpandASDe().getText();
       Thread.sleep(1000);
       EntityLocationExpandASDe().click();
      
     //  EntityLocationDe().click();
       Thread.sleep(3000);
       StatusDe().click();
       Thread.sleep(1000);
       String Statustext =Status1DE().getText();
       Thread.sleep(500);
       Status1DE().click();
       Thread.sleep(500);
    
       Thread.sleep(6000);
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[4]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(entitycol);
				}
			else if(i==1)
				{
					raw.addAll(statuscol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		/*
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		EntityLocationAS().click();
		Thread.sleep(5000);
		By locator = By.xpath("(//*[@class='k-icon k-i-expand'])[10]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = .findElement(locator);	
		Thread.sleep(3000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//EntityLocationExpandASDept().click();
		Thread.sleep(400);
		EntityLocationExpandASDept().click();
		Thread.sleep(500);
      String locationtextAS =EntityLocationExpandAS1Dept().getText();
       Thread.sleep(500);
       EntityLocationExpandAS1Dept().click();
       Thread.sleep(500);
       EntityLocationAS().click();
       Thread.sleep(3000);
       StatusAS().click();
       Thread.sleep(500);
       String StatustextAS =Status1ASAU().getText();
       Thread.sleep(500);
       Status1ASAU().click();
     
       Thread.sleep(5000);
        List<String> liAS=new ArrayList<String>();
        
        liAS.add(locationtextAS);
        liAS.add(StatustextAS);
        Thread.sleep(3000);
        
		List<String> filterAS=new ArrayList<String>();	
		filterAS.add("Location");
		filterAS.add("Status");	
		
	
		Thread.sleep(3000);
	
		List<WebElement> entitycol=.findElements(By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td[6]"));
		
		List<WebElement> statuscol=.findElements(By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td[12]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(entitycol);
				}
			else if(i==1)
				{
					raw.addAll(statuscol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL,"Advanced Search : -"+ filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Advanced Search : -"+ filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		
		Thread.sleep(3000);
		CFOcountPOM.closeDocumentAS().click();
		Thread.sleep(3000);
	*/
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceIDFilter1(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilter(test,"Statutory",129028);
		ComplianceIDFilter(test,"Statutory CheckList",145118);
		
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterMgmt(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilter(test,"Statutory",57377);
		ComplianceIDFilter(test,"Statutory CheckList",53980);
		
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterEB(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		ComplianceIDFilter(test,"EventBased Checklist",130794);
		ComplianceIDFilter(test,"EventBased",66976);
	
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterEBMgmt(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		ComplianceIDFilter(test,"EventBased Checklist",58445);
		ComplianceIDFilter(test,"EventBased",9123);
	
		OverduePOM.clickDashboard().click();
	}
	
	
	public static void ComplianceIDFilterEBDe(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		ComplianceIDFilter(test,"EventBased Checklist",8697);
		ComplianceIDFilter(test,"EventBased",8692);
	
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterEBAU(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		ComplianceIDFilter(test,"EventBased Checklist",70184);
		ComplianceIDFilter(test,"EventBased",9090);
	
		OverduePOM.clickDashboard().click();
	}
	
	
	public static void ComplianceIDFilterIN(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilter(test,"Internal",55722);
		ComplianceIDFilter(test,"Internal CheckList",55038);
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterINMgmt(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilter(test,"Internal",27472);
		ComplianceIDFilter(test,"Internal CheckList",27474);
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterINDe(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilter(test,"Internal",56635);
		ComplianceIDFilter(test,"Internal CheckList",56638);
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterINAu(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilter(test,"Internal",55038);
		ComplianceIDFilter(test,"Internal CheckList",15945);
		OverduePOM.clickDashboard().click();
	}


	public static void ComplianceIDFilter(ExtentTest test, String type,int no ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	   
		
       if(ComplianceID().isDisplayed()) {
			test.log(LogStatus.PASS,type+ " Type :- User  able to see the Compliance id search box Filter.");	
		}
		
		
		if(type.equalsIgnoreCase("Statutory")) {
			ComplianceID().sendKeys(""+no+"",Keys.ENTER);
			Thread.sleep(3000);
		}else 
		if(type.equalsIgnoreCase("Statutory CheckList")) {
			
			Type().click();
			Thread.sleep(500);
			TypeAll().click();
			TypeAll().click();
			Thread.sleep(3000);
			StatutoryCheckList().click();
			Thread.sleep(500);
			Apply().click();
			Thread.sleep(3000);
			ComplianceID().clear();
			Thread.sleep(500);
			ComplianceID().sendKeys(""+no+"",Keys.ENTER);
			Thread.sleep(500);
		}else 
			if(type.equalsIgnoreCase("EventBased Checklist")) {
				
				Type().click();
				Thread.sleep(500);
				TypeAll().click();
				TypeAll().click();
				Thread.sleep(3000);
				EventBasedChecklist().click();
				Thread.sleep(500);
				Apply().click();
				Thread.sleep(3000);
				ComplianceID().clear();
				Thread.sleep(500);
				ComplianceID().sendKeys(""+no+"",Keys.ENTER);
				Thread.sleep(500);
			}
			else 
				if(type.equalsIgnoreCase("EventBased")) {
					
					Type().click();
					Thread.sleep(500);
					TypeAll().click();
					TypeAll().click();
					Thread.sleep(3000);
					EventBased().click();
					Thread.sleep(500);
					Apply().click();
					Thread.sleep(3000);
					ComplianceID().clear();
					Thread.sleep(500);
					ComplianceID().sendKeys(""+no+"",Keys.ENTER);
					Thread.sleep(500);
				}
		
				else 
					if(type.equalsIgnoreCase("Internal")) {
						
						Type().click();
						Thread.sleep(500);
						TypeAll().click();
						TypeAll().click();
						Thread.sleep(3000);
						Internal().click();
						Thread.sleep(500);
						Apply().click();
						Thread.sleep(3000);
						ComplianceID().clear();
						Thread.sleep(500);
						ComplianceID().sendKeys(""+no+"",Keys.ENTER);
						Thread.sleep(500);
					}
					else 
						if(type.equalsIgnoreCase("Internal CheckList")) {
							
							Type().click();
							Thread.sleep(500);
							TypeAll().click();
							TypeAll().click();
							Thread.sleep(3000);
							InternalCheckList().click();
							Thread.sleep(500);
							Apply().click();
							Thread.sleep(3000);
							ComplianceID().clear();
							Thread.sleep(500);
							ComplianceID().sendKeys(""+no+"",Keys.ENTER);
							Thread.sleep(500);
						}
		Thread.sleep(5000);
		
    //  String IDtext =no;
       Thread.sleep(500);
     
       Thread.sleep(500);
        List<String> li=new ArrayList<String>();
        
        li.add(""+no+"");
       
        Thread.sleep(3000);
        
	//	List<String> filter=new ArrayList<String>();	
	//	filter.add("Statutory");
			
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
	//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> IDcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
		

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(IDcol);
				}
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, type+" Type shows incorrect  Compliance ID value in column : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  type+" Type :-Compliance ID' filter should be working and record should be displayed on the grid properly."+Pas);
				
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,type+" :- No records found");	
		}
		Thread.sleep(3000);
		
		//Clear().click();
				
		//Thread.sleep(3000);
	}
	

	public static void ComplianceIDFilterInvalid(ExtentTest test, String type,int no ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	   
		
     
		
		if(type.equalsIgnoreCase("Statutory")) {
			ComplianceID().sendKeys(""+no+"",Keys.ENTER);
			Thread.sleep(3000);
		}else 
		if(type.equalsIgnoreCase("Statutory CheckList")) {
			
			Type().click();
			Thread.sleep(500);
			TypeAll().click();
			TypeAll().click();
			Thread.sleep(3000);
			StatutoryCheckList().click();
			Thread.sleep(500);
			Apply().click();
			Thread.sleep(3000);
			ComplianceID().clear();
			Thread.sleep(500);
			ComplianceID().sendKeys(""+no+"",Keys.ENTER);
			Thread.sleep(500);
		}else 
			if(type.equalsIgnoreCase("EventBased Checklist")) {
				
				Type().click();
				Thread.sleep(500);
				TypeAll().click();
				TypeAll().click();
				Thread.sleep(3000);
				EventBasedChecklist().click();
				Thread.sleep(500);
				Apply().click();
				Thread.sleep(3000);
				ComplianceID().clear();
				Thread.sleep(500);
				ComplianceID().sendKeys(""+no+"",Keys.ENTER);
				Thread.sleep(500);
			}
			else 
				if(type.equalsIgnoreCase("EventBased")) {
					
					Type().click();
					Thread.sleep(500);
					TypeAll().click();
					TypeAll().click();
					Thread.sleep(3000);
					EventBased().click();
					Thread.sleep(500);
					Apply().click();
					Thread.sleep(3000);
					ComplianceID().clear();
					Thread.sleep(500);
					ComplianceID().sendKeys(""+no+"",Keys.ENTER);
					Thread.sleep(500);
				}
		
				else 
					if(type.equalsIgnoreCase("Internal")) {
						
						Type().click();
						Thread.sleep(500);
						TypeAll().click();
						TypeAll().click();
						Thread.sleep(3000);
						Internal().click();
						Thread.sleep(500);
						Apply().click();
						Thread.sleep(3000);
						ComplianceID().clear();
						Thread.sleep(500);
						ComplianceID().sendKeys(""+no+"",Keys.ENTER);
						Thread.sleep(500);
					}
					else 
						if(type.equalsIgnoreCase("Internal CheckList")) {
							
							Type().click();
							Thread.sleep(500);
							TypeAll().click();
							TypeAll().click();
							Thread.sleep(3000);
							InternalCheckList().click();
							Thread.sleep(500);
							Apply().click();
							Thread.sleep(3000);
							ComplianceID().clear();
							Thread.sleep(500);
							ComplianceID().sendKeys(""+no+"",Keys.ENTER);
							Thread.sleep(500);
						}
		Thread.sleep(5000);
		
    //  String IDtext =no;
       Thread.sleep(500);
     
       Thread.sleep(500);
        List<String> li=new ArrayList<String>();
        
        li.add(""+no+"");
       
        Thread.sleep(3000);
        
	//	List<String> filter=new ArrayList<String>();	
	//	filter.add("Statutory");
			
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
	//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> IDcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
		

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(IDcol);
				}
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, type+" Type shows incorrect  Compliance ID value in column : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  type+" Type :-Compliance ID' filter should be working and record should be displayed on the grid properly."+Pas);
				
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,type+" Type :- The data should not be displayed on the grid after entering invalid data in compliance ID search box Filter.");	
		}
		Thread.sleep(3000);
		
		//Clear().click();
				
		//Thread.sleep(3000);
	}
	
	public static void ComplianceIDFilter1Invalid(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilterInvalid(test,"Statutory",11118);
		ComplianceIDFilterInvalid(test,"Statutory CheckList",666);
		
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterEBInvalid(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		ComplianceIDFilterInvalid(test,"EventBased Checklist",66666);
		ComplianceIDFilterInvalid(test,"EventBased",66666);
	
		OverduePOM.clickDashboard().click();
	}
	
	public static void ComplianceIDFilterINInvalid(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
       Thread.sleep(5000);
       wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		Thread.sleep(3000);
		
		
		ComplianceIDFilterInvalid(test,"Internal",9938);
		ComplianceIDFilterInvalid(test,"Internal CheckList",9938);
		OverduePOM.clickDashboard().click();
	}

	public static void SummaryofOverdueFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
		Thread.sleep(500);
		CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
		Thread.sleep(3000);
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver() .switchTo().frame(farme);
      Thread.sleep(55000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(4000); 
	
		 Act().click();
		Thread.sleep(2000);
		
      String Acttext =Act1().getText();
       Thread.sleep(500);
       Act1().click();
      
       Thread.sleep(3000);
   
       Risk().click();
       Thread.sleep(500);
       String Risktext =Risk1().getText();
       Thread.sleep(500);
       Risk1().click();
       Thread.sleep(2000);
      
        List<String> li=new ArrayList<String>();
        
        li.add(Acttext);
        li.add(Risktext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Act");
		filter.add("Risk");	
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	       MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(3000);
		      
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
	
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[15]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Actcol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
	
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void SummaryofOverdueFilterIn(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
		Thread.sleep(500);
		CFOcountPOM.ClickShowAllIn().click();        //Clicking on Show All
		Thread.sleep(3000);
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver() .switchTo().frame(farme);
      Thread.sleep(55000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(4000); 
	
		 Act().click();
		Thread.sleep(2000);
		
      String Acttext =Act1().getText();
       Thread.sleep(500);
       Act1().click();
      
       Thread.sleep(3000);
   
       Risk().click();
       Thread.sleep(500);
       String Risktext =Risk1().getText();
       Thread.sleep(500);
       Risk1().click();
       Thread.sleep(2000);
      
        List<String> li=new ArrayList<String>();
        
        li.add(Acttext);
        li.add(Risktext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Act");
		filter.add("Risk");	
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	       MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(3000);
		      
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
	
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[15]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Actcol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
				}
	
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
		
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
	
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void SummaryofOverdueFilterMgmt(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
	    
		Thread.sleep(500);
		CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
		Thread.sleep(3000);
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(4000); 
	
		 Act().click();
		Thread.sleep(2000);
		
      String Acttext =ActMgmt().getText();
       Thread.sleep(500);
       ActMgmt().click();
      
       Thread.sleep(3000);
   
       Risk().click();
       Thread.sleep(500);
       String Risktext =RiskM().getText();
       Thread.sleep(500);
       RiskM().click();
       Thread.sleep(2000);
       Risk().click();
       Thread.sleep(3000);
       
       StatusM().click();
       Thread.sleep(500);
       String Statustext =StatusM1().getText();
       Thread.sleep(500);
       StatusM1().click();
       Thread.sleep(2000);
       
       CFOcountPOM.clickApplyF().click();
       Thread.sleep(3000);
        List<String> li=new ArrayList<String>();
        
        li.add(Acttext);
        li.add(Risktext);
        li.add(Statustext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Act");
		filter.add("Risk");	
		filter.add("Status");	
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	       MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(3000);
		      
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
	
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Actcol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
				}
			else if(i==2)
			{
				raw.addAll(Statuscol);
			}

				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
	
				OverduePOM.clickDashboard().click();
		
	}
	
	
	
	public static	void CompletedPFR_PieChartMp( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
	//	CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =getDriver() .findElement(locator);	
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

			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
		
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
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
	
	public static void RiskSummaryMp( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompletedDept().click();							//CLicking on 'Not Completed' count
		
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
	
	public static	void RiskSummaryMpView( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompletedDept().click();							//CLicking on 'Not Completed' count
		
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
			
			WebElement ViewButton =getDriver() .findElement(locator);	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static void DeptSummaryMp( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickFinanceOverdueDept().click();
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton =getDriver() .findElement(locator);	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static	void DeptSummaryMpView( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickFinanceOverdueDept().click();
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
				
				WebElement ViewButton =getDriver() .findElement(locator);	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static void DFPCompletedPFR_PieChartMp( ExtentTest test) throws InterruptedException
	{
		
		
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
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
				
				WebElement ViewButton =getDriver() .findElement(locator);	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpView( ExtentTest test) throws InterruptedException
	{
		
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
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
	
	public static	void CompletedPFR_PieChartMpSC( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
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
	 //  	MgmtSonyMethod.ClickTriA().click();
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
				
				WebElement ViewButton =getDriver() .findElement(locator);	
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
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
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
	   	List<WebElement>roc =getDriver() .findElements(By.xpath("//*[@class='k-item']/label"));
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton =getDriver() .findElement(locator);	
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
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
	
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompletedDept().click();							//CLicking on 'Not Completed' count
		
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
				
				WebElement ViewButton =getDriver() .findElement(locator);	
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
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompletedDept().click();							//CLicking on 'Not Completed' count
		
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
	 //  	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc =getDriver() .findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static void DeptSummaryMpSC( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickFinanceOverdueDept().click();
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
	//   	MgmtSonyMethod.ClickTriA().click();
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton =getDriver() .findElement(locator);	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static	void DeptSummaryMpViewSC( ExtentTest test) throws InterruptedException
	{
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
	
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickFinanceOverdueDept().click();
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static void DFPCompletedPFR_PieChartMpSC( ExtentTest test) throws InterruptedException
	{
		
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
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
	   	MgmtSonyMethod.ClickTriACT1().click();
	       Thread.sleep(2000);
	       MgmtSonyMethod.Filter().click();
	       Thread.sleep(2000);
	   	List<WebElement>roc =getDriver() .findElements(By.xpath("//*[@class='k-item']/label"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "StatutoryChecklist");
			
		   MgmtSonyMethod.FilterBtn().click();
	       Thread.sleep(5000);
	
	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpViewSC( ExtentTest test) throws InterruptedException
	{
		
		performer.OverduePOM.clickDashboard().click();	
		Thread.sleep(3000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
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
			
			test.log(LogStatus.PASS, "No record found ");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		
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
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompletedDIn().click();							//CLicking on 'Not Completed' count
		
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
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompletedDIn().click();							//CLicking on 'Not Completed' count
		
		
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
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void DeptSummaryMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAdminOverdueDeptIn().click();
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
			
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
	
	public static	void DeptSummaryMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAdminOverdueDeptIn().click();
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
			
			test.log(LogStatus.PASS, "No record found");
			
			
		}
	}
	
	public static void DFPCompletedPFR_PieChartMpIn( ExtentTest test) throws InterruptedException
	{
		
		
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
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
		
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
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
	
	public static	void Reopening( ExtentTest test) throws InterruptedException
	{
		
		
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		Thread.sleep(3000);
		
		String s = DeptCountPOM.Reopening().getText();
		
		if(s.equalsIgnoreCase("My ReOpening's ")) {
			test.log(LogStatus.PASS, "The new tab named \"My Reopening\" should reflects seperately with Closed timely and closed delayed compliance of particular department.");
		
	}
		Thread.sleep(3000);
		DeptCountPOM.Reopening().click();
		Thread.sleep(8000);
		if(EntitySubEntityLocation().isDisplayed()&&ComplianceType().isDisplayed()&&ComplianceIDRE().isDisplayed()) {
			test.log(LogStatus.PASS, "The all filters named \"Entity / Sub Location / Location, Compliance Type, Compliance ID, Period Filter (Current YTD), Start-End Date, and Risk\" shlould displayed while clicking on new tab named My Reopening and it should be working.");
		
	}else {
		test.log(LogStatus.FAIL, "The all filters named \"Entity / Sub Location / Location, Compliance Type, Compliance ID, Period Filter (Current YTD), Start-End Date, and Risk\" shlould displayed while clicking on new tab named My Reopening and it not working.");

	}
	}
		
		public static	void ReopeningRe( ExtentTest test) throws InterruptedException
		{
			
			
			Thread.sleep(3000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			DeptCountPOM.Reopening().click();
			Thread.sleep(3000);
			
		
			DeptCountPOM.period().click();
			Thread.sleep(3000);
			DeptCountPOM.Allperiod().click();
			DeptCountPOM.apply().click();
			Thread.sleep(8000);
			DeptCountPOM.ClickEdit().click();
			Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (100));
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
			
}
		
		public static	void Reopeningapprove( ExtentTest test) throws InterruptedException
		{
			
			
			Thread.sleep(3000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			DeptCountPOM.Reopening().click();
			Thread.sleep(3000);
			
		
			DeptCountPOM.period().click();
			Thread.sleep(3000);
			DeptCountPOM.Allperiod().click();
			DeptCountPOM.apply().click();
			Thread.sleep(8000);
			DeptCountPOM.ClickEdit().click();
			Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(getDriver(), (100));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
			Thread.sleep(500);
			CFOcountPOM.EnterRemark().sendKeys("remark");
			Thread.sleep(1000);
			DeptCountPOM.Approve().click();
			Thread.sleep(8000);
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();
			test.log(LogStatus.PASS, "Message Display " +msg);
Thread.sleep(1000);
getDriver().switchTo().parentFrame();
			
}
		
		public static void ReopeningExport( ExtentTest test) throws InterruptedException
		{
			
			
			Thread.sleep(3000);
			Actions action = new Actions(getDriver());
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			DeptCountPOM.Reopening().click();
			Thread.sleep(3000);
			
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			DeptCountPOM.Export().click(); // Exporting (Downloading) file

			Thread.sleep(6000);// C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}

}
		public static void SummaryofOverdueSF(  ExtentTest test)throws InterruptedException
		{
			
			
				Thread.sleep(5000);
				CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
				Thread.sleep(8000);
				WebDriverWait wait = new WebDriverWait(getDriver(), (100));
			
				WebElement farme=getDriver().findElement(By.xpath("//*[@id='showdetails']"));
				getDriver().switchTo().frame(farme);
				Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
				Thread.sleep(3000); 
				CFOcountPOM.ComplianceID().sendKeys("6697");
				//Thread.sleep(3000);
				
				//CFOcountPOM.clickApplyF().click();
				Thread.sleep(8000);
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButtons = getDriver().findElements(locator);							
				ViewButtons.get(0).click();
				Thread.sleep(3000);
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
				File dir = new File("C:\\Users\\shitalb\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\shitalb\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {
					test.log(LogStatus.PASS,  "File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  "File does not downloaded.");
				}
					Thread.sleep(3000);
					getDriver().switchTo().parentFrame();
					Thread.sleep(3000);
					CFOcountPOM.closeDocument().click();
					Thread.sleep(3000);
					getDriver().switchTo().defaultContent();
					Thread.sleep(3000);
					CFOcountPOM.closeCategories().click();
					Thread.sleep(1000);
			
			
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
				js.executeScript("window.scrollBy(0,500)");	
				Thread.sleep(3000);
				CFOcountPOM.clickNotCompleted().click();								//CLicking on 'Not Completed' count
				
				Thread.sleep(3000);
				CFOcountPOM.readCritical().click();		
				Thread.sleep(3000);
				
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				Thread.sleep(8000);
				CFOcountPOM.ComplianceID().sendKeys("122344");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[21]/a");
			
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
				File dir = new File("C:\\Users\\shitalb\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
				js.executeScript("window.scrollBy(0,1500)");	
				Thread.sleep(3000);
				CFOcountPOM.clickRiskCriticalNotCompletedDept().click();								//CLicking on 'Not Completed' count
				
						
				Thread.sleep(3000);
				
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				Thread.sleep(8000);
				CFOcountPOM.ComplianceID().sendKeys("122344");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[21]/a");
			
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
				File dir = new File("C:\\Users\\shitalb\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
				js.executeScript("window.scrollBy(0,1000)");	
				Thread.sleep(3000);
				CFOcountPOM.clickFinanceOverdueDept().click();								//CLicking on 'Not Completed' count
				
						
				Thread.sleep(3000);
				
				
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
				Thread.sleep(8000);
				CFOcountPOM.ComplianceID().sendKeys("81");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a");
			
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
				File dir = new File("C:\\Users\\shitalb\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
				CFOcountPOM.ComplianceID().sendKeys("122344");
				
				Thread.sleep(8000);
				
				
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
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
				File dir = new File("C:\\Users\\shitalb\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			OverduePOM.Download().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
				By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/a[2]");
				
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
				File dir = new File("C:\\Users\\shitalb\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				OverduePOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
		
		public static void SMETAReportFilterMgmt(ExtentTest test ) throws InterruptedException, IOException
		{	
			
	       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		    
			Thread.sleep(500);
			CFOcountPOM.clickReports().click();	
			 Thread.sleep(4000); 
			CFOcountPOM.SMETAReport().click();
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			 Thread.sleep(4000); 
		
			 OverduePOM.Act().click();
			Thread.sleep(2000);
			
			List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@id='dropdownACT_listbox']/li)"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Demo Act");
	      
	       Thread.sleep(3000);
	       
	       CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Statutory");
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(4000);
			
			
			Category().click();
			List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "General");
	       Thread.sleep(3000);
	       
	       StatusP().click();
	       Thread.sleep(500);
	       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
	       Thread.sleep(2000);
	       
	       CFOcountPOM.Apply().click();
			Thread.sleep(2000);
	       Thread.sleep(3000);
	        List<String> li=new ArrayList<String>();
	        
	        li.add("Demo Act");
	        li.add("General");
	        li.add("Overdue");
	        Thread.sleep(3000);
	        
			List<String> filter=new ArrayList<String>();	
			filter.add("Act");
			filter.add("Category");	
			filter.add("Status");	
			MgmtSonyMethod.ClickTri().click();
		       Thread.sleep(1000);
		       MgmtSonyMethod.Columns().click();
		       Thread.sleep(500);
		       MgmtSonyMethod.CategoryCheck().click();
		       Thread.sleep(1000);
		      
		       MgmtSonyMethod.ClickTri().click();
		       Thread.sleep(3000);
			      
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(4000);
			
			js.executeScript("window.scrollBy(0,500)");
			js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
			
			Thread.sleep(8000);
			CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItemsD().getText();
			Thread.sleep(3000);
			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[8]"));
		
			List<WebElement> catcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]"));
			List<WebElement> Statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(Actcol);
					}
				else if(i==1)
					{
						raw.addAll(catcol);
					}
				else if(i==2)
				{
					raw.addAll(Statuscol);
				}

					
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
						{
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.PASS,"No records found");	
			}
			Thread.sleep(8000);
			
			Actions a = new Actions(getDriver());
			
			a.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(8000);
			if(Clear1().isEnabled())
			{
				test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
			
			Clear1().click();
			}
		
		else
		{
			test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
			
		}
		
					OverduePOM.clickDashboard().click();
			
		}
	
		public static void SMETAReportFilterMgmt1(ExtentTest test ) throws InterruptedException, IOException, AWTException
		{	
			
	       WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		    
			Thread.sleep(500);
			CFOcountPOM.clickReports().click();	
			 Thread.sleep(4000); 
			 Robot robot = new Robot();
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_SUBTRACT);
			  robot.keyRelease(KeyEvent.VK_SUBTRACT);
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_SUBTRACT);
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_SUBTRACT);
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_SUBTRACT);
			  robot.keyPress(KeyEvent.VK_CONTROL);
			  robot.keyPress(KeyEvent.VK_SUBTRACT);
			  robot.keyRelease(KeyEvent.VK_CONTROL);
				
				
				Thread.sleep(5000);
			CFOcountPOM.SMETAReport().click();
			
			try {
		           

	            // Set zoom level to 50% (0.5) for zooming out
	         //   setZoomLevel(getDriver(), 0.9);

	            // Wait to observe the effect
	            Thread.sleep(2000);
	            // Set zoom level back to 100% (1.0) to reset to normal
	            setZoomLevel(getDriver(), 1.0);

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
			 Thread.sleep(4000); 
		
			 OverduePOM.Act().click();
			Thread.sleep(2000);
			
			List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@id='dropdownACT_listbox']/li)"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Demo Act");
	      
	       Thread.sleep(3000);
	       
	       CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			
			List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Statutory");
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(4000);
			
			
			Category().click();
			List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "General");
	       Thread.sleep(3000);
	       
	       StatusP().click();
	       Thread.sleep(500);
	       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
	       Thread.sleep(2000);
	       
	       CFOcountPOM.Apply().click();
			Thread.sleep(2000);
	       Thread.sleep(3000);
	        List<String> li=new ArrayList<String>();
	        
	        li.add("Demo Act");
	        li.add("General");
	        li.add("Overdue");
	        Thread.sleep(3000);
	        
			List<String> filter=new ArrayList<String>();	
			filter.add("Act");
			filter.add("Category");	
			filter.add("Status");	
			MgmtSonyMethod.ClickTri().click();
		       Thread.sleep(1000);
		       MgmtSonyMethod.Columns().click();
		       Thread.sleep(500);
		       MgmtSonyMethod.CategoryCheck().click();
		       Thread.sleep(1000);
		      
		       MgmtSonyMethod.ClickTri().click();
		       Thread.sleep(3000);
		       JavascriptExecutor js = (JavascriptExecutor) getDriver() ;    
			
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(4000);
			
			js.executeScript("window.scrollBy(0,500)");
			js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=5000");
			
			Thread.sleep(8000);
			CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItemsD().getText();
			Thread.sleep(3000);
			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[8]"));
		
			List<WebElement> catcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]"));
			List<WebElement> Statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(Actcol);
					}
				else if(i==1)
					{
						raw.addAll(catcol);
					}
				else if(i==2)
				{
					raw.addAll(Statuscol);
				}

					
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
						{
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.PASS,"No records found");	
			}
			Thread.sleep(8000);
			
			Actions a = new Actions(getDriver());
			
			a.sendKeys(Keys.PAGE_UP).build().perform();
			Thread.sleep(8000);
			if(Clear1().isEnabled())
			{
				test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
			
			Clear1().click();
			}
		
		else
		{
			test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
			
		}
		
					OverduePOM.clickDashboard().click();
			
		}
		
		public static void NCcompletionVsNCOverdue (ExtentTest test)throws InterruptedException
		{
			CFOcountPOM.RefreshNow().click();
			
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
			js.executeScript("window.scroll(0,600)");
			Thread.sleep(3000);
			int satPerformrNotcompleted=Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());
			Thread.sleep(5000);
			int satPerformrsummNotcompletedoverdue=Integer.parseInt(CFOcountPOM.clickOverdue().getText());
			int dueTodayValue = Integer.parseInt(CFOcountPOM.clickdueToday().getText());
			    int satPerformrsummNotcompletedPendingforreview=Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());
			    Thread.sleep(5000);
		 	int satPerformrsummNotcompletedInprogress=Integer.parseInt(CFOcountPOM.clickinProgress().getText());
		 	Thread.sleep(5000);
		  
		    int overduetotal=dueTodayValue+satPerformrsummNotcompletedoverdue+satPerformrsummNotcompletedPendingforreview+satPerformrsummNotcompletedInprogress;

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
		
		
		public static void setZoomLevel(WebDriver driver, double zoomLevel) 
		{
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
	    }
		
		
		public static void DetailedreportVsdashboardNotCompletedcountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);
		js.executeScript("window.scroll(0,600)");
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
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
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
//			CFOcountPOM.StatusDeviationApplied().click();
			Thread.sleep(2000);
//			CFOcountPOM.StatusDeviationApproved().click();
//			Thread.sleep(2000);
//			CFOcountPOM.StatusDeviationRejected().click();
			
			CFOcountPOM.PeriodDropDown().click();
			Thread.sleep(2000);
			CFOcountPOM.PeriodAll().click();
			Thread.sleep(2000);
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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
		
		public static void DetailedreportVsdashboardCloseddealyedcountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);
		js.executeScript("window.scroll(0,600)");
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
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			
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
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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
		
		public static void DetailedreportVsdashboardclosedtimelycountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);
		js.executeScript("window.scroll(0,600)");
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
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			
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
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void DetailedreportVsdashboardNAcountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,600)");
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
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			
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
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void DetailedreportVsOverduecountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,600)");
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
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			
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
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void DetailedreportVsPFRcountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,600)");
		Thread.sleep(5000);
		String NotCompleted = CFOcountPOM.clickpendingForReviewDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int NotCompletedIn = Integer.parseInt(NotCompleted);

			Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			
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
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void DetailedreportVsINprocountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,600)");
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
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			
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
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void DetailedreportVsRejectedcountUp(ExtentTest test)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,600)");
		Thread.sleep(5000);
		String NotCompleted = CFOcountPOM.clickRejectedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int NotCompletedIn = Integer.parseInt(NotCompleted);

			Thread.sleep(500);
			clickReports().click();					//Clicking on 'My Reports'
			Thread.sleep(3000);
			clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
			Thread.sleep(2000);
			CFOcountPOM.ComplianceType().click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			CFOcountPOM.StatutoryM().click();
			Thread.sleep(1000);
			CFOcountPOM.ComplianceTypeEventBased().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
			Thread.sleep(5000);
			CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
			Thread.sleep(5000);
			
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
		   	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void DepartmentSummaryOverdue(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,1600)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickFinanceOverdueDept().getText();			//Reading the Overdue value of Human Resource
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("06-Apr-2025");
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
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,1600)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		Thread.sleep(1000);
		  roc.click();
		  Thread.sleep(3000);
		String ClosedDelayed = CFOcountPOM.clickClosedDelayedDept().getText();	//Reading the Closed Delayed value of Human Resource
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		
		public static void DepartmentSummaryClosedT(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,1600)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		Thread.sleep(1000);
		  roc.click();
			Thread.sleep(3000);
		String ClosedTimely = CFOcountPOM.clickClosedTimelyDpt().getText();		//Reading the Closed Timely value of Human Resource
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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
		
		public static void DepartmentSummaPR(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,1600)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		Thread.sleep(1000);
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(21) > g:nth-child(2) > g:nth-child(1) > g:nth-child(1) > text:nth-child(1) > tspan:nth-child(1)"));
			
		  roc1.click();
		  Thread.sleep(4000);
		  WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
			CT.click();
			Thread.sleep(2000);
		String PendingReview = CFOcountPOM.clickPendingReviewDept().getText();	//Reading the Pending For Review value of Human Resource
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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
	
		
		public static void DepaINPROGRESSR(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,1600)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		Thread.sleep(1000);
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(21) > g:nth-child(2) > g:nth-child(1) > g:nth-child(1) > text:nth-child(1) > tspan:nth-child(1)"));
			
		  roc1.click();
		  Thread.sleep(4000);
		  WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
			CT.click();
		String InProgress = CFOcountPOM.clickHumanInprogress().getText();	//Reading the Pending For Review value of Human Resource
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
	    	Thread.sleep(2000);
	    	CFOcountPOM.EndDate2().sendKeys("06-Apr-2025");
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
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,1600)");
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		Thread.sleep(1000);
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(21) > g:nth-child(2) > g:nth-child(1) > g:nth-child(1) > text:nth-child(1) > tspan:nth-child(1)"));
			
		  roc1.click();
		  Thread.sleep(4000);
		  WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
			CT.click();
		String Rejected = CFOcountPOM.clickHumanRejected().getText();	//Reading the Pending For Review value of Human Resource
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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
	
		public static void DepaNotApplic(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,1600)");
		Thread.sleep(3000);
		Thread.sleep(3000);
		WebElement roc =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
		Thread.sleep(1000);
		  roc.click();
		  WebElement roc1 =getDriver() .findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(21) > g:nth-child(2) > g:nth-child(1) > g:nth-child(1) > text:nth-child(1) > tspan:nth-child(1)"));
			
		  roc1.click();
		  Thread.sleep(4000);
		  WebElement CT = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
			CT.click();
			WebElement PR =getDriver() .findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-3 > rect"));
			Thread.sleep(1000);
			PR.click();
			WebElement IP = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-4 > rect"));
			IP.click();
		String NotApplicable = CFOcountPOM.clickHumanNotApplicable().getText();	//Reading the Pending For Review value of Human Resource
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void riskSummaryCriticalNotCompleted(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,2100)");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskCriticalNotCompletedDept().getText();		//Reading the Closed Timely value of Human Resource
		NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryCriticalNotCompleted = Integer.parseInt(NotCompleted);
    	//int riskSummaryCriticalNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskCriticalNotCompleted().getText());
    	String risk1 = CFOcountPOM.clickRiskHighNotCompletedDept().getText();
    	risk1 = risk1.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighNotCompleted = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskMediumNotCompletedDept().getText());
    	int riskSummaryLowNotCompleted=Integer.parseInt(CFOcountPOM.clickRiskLowNotCompletedDept().getText());
    	
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
	       	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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
		
		public static void riskSummaryClosedDelayed(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,2100)");
		Thread.sleep(3000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
    	int riskSummaryCriticalclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedDelayedDpt().getText());
    	String risk1 = CFOcountPOM.clickRiskHighClosedDelayedDpt().getText();
    	risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
		int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
		
    	int riskSummaryMediumclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskMediumClosedDelayedDpt().getText());
    	int riskSummaryLowclosedDelayed=Integer.parseInt(CFOcountPOM.clickRiskLowClosedDelayedDpt().getText());
    	
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void riskSummaryClosedTimely(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,2100)");
		Thread.sleep(3000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		Thread.sleep(5000);
		int RiskCritical_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskCriticalClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
		int RiskHigh_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskHighClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance

//    	String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//    	risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//		int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
		
		int RiskMedium_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskMediumClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
		int RiskLow_ClosedTimely = Integer.parseInt(CFOcountPOM.clickRiskLowClosedTimelyDpt().getText());	//Reading the High Risk value of Not Completed compliance
    	
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void riskSummaryNotApplicable(ExtentTest test,String risk)throws InterruptedException
		{
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		DeptCountPOM.SelectYear().click();
		Thread.sleep(1000);
		DeptCountPOM.SelectAll().click();
		Thread.sleep(3000);
		DeptCountPOM.ClickApply().click();
		
		Thread.sleep(8000);

		js.executeScript("window.scroll(0,2100)");
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
		int RiskCritical_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskCriticalNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance

//    	String risk1 = CFOcountPOM.clickRiskHighClosedDelayed().getText();
//    	risk = risk.replaceAll(" ","");									//Removing all white spaces from string. 
//		int riskSummaryHighclosedDelayed = Integer.parseInt(risk1);  	
		int RiskHigh_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskHighNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance

		int RiskMedium_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskMediumNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance
		
		int RiskLow_NotApplicable = Integer.parseInt(CFOcountPOM.clickRiskLowNotApplicableDE().getText());	//Reading the High Risk value of Not Completed compliance
	
			
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
	    	CFOcountPOM.StartDate2().sendKeys("18-Jan-2020");
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

		public static void NCcompletionVsNCOverdueP (ExtentTest test)throws InterruptedException
		{
			CFOcountPOM.RefreshNow().click();
			Thread.sleep(3000);
			DeptCountPOM.SelectYear().click();
			Thread.sleep(1000);
			DeptCountPOM.SelectAll().click();
			Thread.sleep(3000);
			DeptCountPOM.ClickApply().click();
			
			Thread.sleep(8000);

			
			JavascriptExecutor js = (JavascriptExecutor) getDriver()  ;
			js.executeScript("window.scrollBy(0,2600)");			//Scrolling down window by 1000 px.cfo
//			js.executeScript("window.scrollBy(0,100)");
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
		  
		    int overduetotal=dueTodayValue+satPerformrsummNotcompletedoverdue+satPerformrsummNotcompletedPendingforreview+satPerformrsummNotcompletedInprogress;

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


}

	

