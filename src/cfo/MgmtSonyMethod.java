package cfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import approval.ApprovalcountPOM;
import login.BasePage;
import performer.OverduePOM;



public class MgmtSonyMethod extends BasePage{
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	private static WebElement sony = null;	
	
	
	public static WebElement ComplianceDue()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divComplianceDueTitle']"));
		return sony;
	}
	
	public static WebElement ReadComplianceDue()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DueCompliance']"));
		return sony;
	}
	
	public static WebElement ReadComplianceDueG()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@id='grid']/div[4]/span[2])"));
		return sony;
	}
	
	public static WebElement View()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@id='grid']/div[4]/span[2])"));
		return sony;
	}
	
	public static WebElement EntityLocation()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[1]/div/span[1]"));
		return sony;
	}
	
	public static WebElement EntityLocationExpand()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-expand']"));
		return sony;
	}
	
	public static WebElement EntityLocationExpandIn()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-expand'])[8]"));
		return sony;
	}
	
	public static WebElement EntityLocationExpand1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[42]"));
		return sony;
	}
	
	public static WebElement EntityLocationExpand1In()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[2]"));
		return sony;
	}
	
	public static WebElement EntityLocationExpandIn1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-top']/span)[3]"));
		return sony;
	}
	
	public static WebElement KarnatakaPvtLtddIn1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-bot']/span)[19]"));
		return sony;
	}
	
	public static WebElement Status()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[3]/div"));
		return sony;
	}
	
	public static WebElement Status1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[13]"));
		return sony;
	}
	
	public static WebElement Status1In()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[59]"));
		return sony;
	}
	
	public static WebElement Status1InCT()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[62]"));
		return sony;
	}
	
	public static WebElement Status1R()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[16]"));
		return sony;
	}
	
	public static WebElement Category()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div/span[1]"));
		return sony;
	}
	
	public static WebElement Category1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[49]"));
		return sony;
	}
	
	public static WebElement CategoryDue()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[45]"));
		return sony;
	}
	
	public static WebElement ClickTri()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[2]"));
		return sony;
	}
	public static WebElement ClickTri1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//th[@class='k-header k-with-icon']//a//span"));
		return sony;
	}
	
	public static WebElement ClickTriStatus()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[9]"));
		return sony;
	}
	
	public static WebElement ClickTriA()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]"));
		return sony;
	}
	
	public static WebElement ClickTriACT()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[16]"));
		return sony;
	}
	
	public static WebElement ClickTriACT1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[7]"));
		return sony;
	}
	
	
	public static WebElement Columns()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow']"));
		return sony;
	}
	
	public static WebElement Filter()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[4]"));
		return sony;
	}
	
	public static WebElement FilterBtn()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-button k-primary'])[2]"));
		return sony;
	}
	
	
	public static WebElement ColumnsE()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[3]"));
		return sony;
	}
	
	public static WebElement ColumnsS()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[2]"));
		return sony;
	}
	
	public static WebElement ColumnsMP()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[5]"));
		return sony;
	}
	
	public static WebElement Columns1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[9]"));
		return sony;
	}
	
	public static WebElement CategoryCheck()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='ComCategoryName'])[2]"));
		return sony;
	}
	
	public static WebElement InternalCheck()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='InternalType'])[2]"));
		return sony;
	}
	
	public static WebElement RiskCheck()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='RiskCategory'])[2]"));
		return sony;
	}
	
	public static WebElement ComplianceTypeCheck()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='ReportType'])[2]"));
		return sony;
	}
	
	
	public static WebElement RiskCheck1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='RiskCategory'])[6]"));
		return sony;
	}
	
	public static WebElement EventIdcol()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='ID'])[3]"));
		return sony;
	}
	
	public static WebElement MitigationPlan()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='MitigationPlan'])[5]"));
		return sony;
	}
	
	public static WebElement MitigationPlanA()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='MitigationPlan'])[2]"));
		return sony;
	}
	
	
	
	public static WebElement DepCheck()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@data-field='DepartmentName'])[2]"));
		return sony;
	}
	
	public static WebElement Risk()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[4]/div/span[1]"));
		return sony;
	}
	
	public static WebElement RiskAll()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[2]"));
		return sony;
	}
	
	public static WebElement RiskHigh()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[18]"));
		return sony;
	}
	
	public static WebElement RiskCritical()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='k-in'])[8]"));
		return sony;
	}
	
	public static WebElement SelectType()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[1]/span/span[2]/span"));
		return sony;
	}
	
	public static WebElement SelectType1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[3]"));
		return sony;
	}
	
	
	public static WebElement Act()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[1]/span/span[2]"));
		return sony;
	}
	
	public static WebElement Act1()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[94]"));
		return sony;
	}
	
	public static WebElement ClearFilter()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return sony;
	}
	
	public static WebElement ComplianceReported()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divComplianceReportedTitle']"));
		return sony;
	}
	
	public static WebElement readComplianceReported()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rpdcompliance']"));
		return sony;
	}
	
	public static WebElement OverdueCompliance()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOverdueComplianceTitle']"));
		return sony;
	}
	
	public static WebElement ReadOverdueCompliance()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_overDueCompliance']"));
		return sony;
	}
	
	public static WebElement NotCompleted()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
		return sony;
	}
	
	public static WebElement Overdue()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[2]"));
		return sony;
	}
	
	public static WebElement ClosedDelayed()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
		return sony;
	}
	
	public static WebElement DueToday()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[2] "));
		return sony;
	}
	
	public static WebElement ClosedTimely()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
		return sony;
	}
	
	public static WebElement PendingForReview()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[2] "));
		return sony;
	}
	
	public static WebElement NotApplicable()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
		return sony;
	}
	
	public static WebElement Rejected()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[2] "));
		return sony;
	}
	
	public static WebElement Department()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[2]/span/span[2]/span"));
		return sony;
	}
	
	public static WebElement DepartmentHR()		//Method for reading Compliances value on Dashboard
	{
		sony = getDriver().findElement(By.xpath("//*[@id='dropdownDept_listbox']/li[2]"));
		return sony;
	}
	
	
	public static void ComplianceDue( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		String string_CompliancesText =MgmtSonyMethod.ComplianceDue().getText();		//Storing old value of Statutory overdue.
		
		if(string_CompliancesText.equalsIgnoreCase("Statutory Ex. Checklist Compliance Due")) {
			test.log(LogStatus.PASS, "The Statutory Ex. Checklist Compliance Due box should be seen on the my dashboard page");	
		}else {
			test.log(LogStatus.FAIL, "The Statutory Ex. Checklist Compliance Due box should be seen on the my dashboard page");	
		}
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		String string_Compliances =MgmtSonyMethod.ReadComplianceDue().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
	MgmtSonyMethod.ReadComplianceDue().click();
	Thread.sleep(8000);
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		                
		File dir = new File("C:\\Users\\Mayuri\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();     
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		MgmtSonyMethod.ReadComplianceDueG().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MgmtSonyMethod.ReadComplianceDueG().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Statutory compliance due in the grid = "+ComcountGrid+" | Dashboard Statutory Compliances due  Count = "+CompliancesCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of Statutory compliance due in the grid = "+ComcountGrid+" | Dashboard Statutory compliance due  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
	}
	
	public static void ComplianceDueFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait( getDriver(), 140);
	    
		Thread.sleep(500);
		MgmtSonyMethod.ReadComplianceDue().click();
		Thread.sleep(8000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			Thread.sleep(8000);
		
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
       EntityLocation().click();
       Thread.sleep(3000);
       
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1().getText();
       Thread.sleep(500);
       Status1().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(500);
       
       Act().click();
       Thread.sleep(500);
       String ActText =Act1().getText();
       Thread.sleep(500);
       Act1().click();
       Thread.sleep(500);
       
       Risk().click();
       Thread.sleep(500);
       RiskAll().click();
       Thread.sleep(500);
       String riskText =RiskCritical().getText();
       Thread.sleep(500);
       RiskCritical().click();
       Thread.sleep(500);
       Risk().click();
       Thread.sleep(500);
       
       Department().click();
       Thread.sleep(500);
       String DepText =DepartmentHR().getText();
       Thread.sleep(500);
       DepartmentHR().click();
       Thread.sleep(500);
       
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        li.add(ActText);
        li.add(riskText);
        li.add(DepText);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		filter.add("Act");	
		filter.add("Risk");	
		filter.add("Department");	
		
		ClickTri().click();
	       Thread.sleep(1000);
	       Columns().click();
	       Thread.sleep(500);
	       RiskCheck().click();
	       Thread.sleep(1000);
	       DepCheck().click();
	       Thread.sleep(1000);
	      
	       ClickTri().click();

		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Deptcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[13]"));
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
			else if(i==2)
			{
				raw.addAll(Actcol);
			}
			else if(i==3)
			{
				raw.addAll(Riskcol);
			}
			else if(i==4)
			{
				raw.addAll(Deptcol);
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
		  
		if(ClearFilter().isEnabled()) {
			ClearFilter().click();
			test.log(LogStatus.PASS, "The applied filter should get cleared  after clicking on the clear button");
		}
		
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceReported( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		String string_CompliancesText =MgmtSonyMethod.ComplianceReported().getText();		//Storing old value of Statutory overdue.
		
		if(string_CompliancesText.equalsIgnoreCase("Statutory Ex. Checklist Compliance Reported")) {
			test.log(LogStatus.PASS, "The Statutory Ex. Checklist Compliance Reported box should be seen on the my dashboard page");	
		}else {
			test.log(LogStatus.FAIL, "The Statutory Ex. Checklist Compliance Reported box should be seen on the my dashboard page");	
		}
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		String string_Compliances =MgmtSonyMethod.readComplianceReported().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
	MgmtSonyMethod.readComplianceReported().click();
	Thread.sleep(8000);
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		                
		File dir = new File("C:\\Users\\Mayuri\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();     
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

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
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		MgmtSonyMethod.ReadComplianceDueG().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MgmtSonyMethod.ReadComplianceDueG().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Statutory Ex. Checklist Compliance Reported in the grid = "+ComcountGrid+" | Dashboard Statutory Compliances reported  Count = "+CompliancesCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of Statutory Ex. Checklist Compliance Reported reported in the grid = "+ComcountGrid+" | Dashboard Statutory compliance reported  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
	}
	
	public static void CompliancereportedFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait( getDriver(), 140);
	    
		Thread.sleep(2000);
		MgmtSonyMethod.readComplianceReported().click();
		Thread.sleep(8000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			Thread.sleep(8000);
		
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
       EntityLocation().click();
       Thread.sleep(3000);
       
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1R().getText();
       Thread.sleep(500);
       Status1R().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(500);
       
       Act().click();
       Thread.sleep(500);
       String ActText =Act1().getText();
       Thread.sleep(500);
       Act1().click();
       Thread.sleep(500);
       
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        li.add(ActText);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		filter.add("Act");	
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
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
			else if(i==2)
			{
				raw.addAll(Actcol);
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
		  
		if(ClearFilter().isEnabled()) {
			ClearFilter().click();
			test.log(LogStatus.PASS, "The applied filter should get cleared  after clicking on the clear button");
		}
		
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceOverdue( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		String string_CompliancesText =MgmtSonyMethod.OverdueCompliance().getText();		//Storing old value of Statutory overdue.
		
		if(string_CompliancesText.equalsIgnoreCase("Statutory Ex. Checklist Overdue Compliance")) {
			test.log(LogStatus.PASS, "The Statutory Ex. Checklist Overdue Compliance box should be seen on the my dashboard page");	
		}else {
			test.log(LogStatus.FAIL, "TheStatutory Ex. Checklist Overdue Compliance box should be seen on the my dashboard page");	
		}
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		String string_Compliances =MgmtSonyMethod.ReadOverdueCompliance().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
	MgmtSonyMethod.ReadOverdueCompliance().click();
	Thread.sleep(8000);
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		                
		File dir = new File("C:\\Users\\Mayuri\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();     
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[1]");

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
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		MgmtSonyMethod.ReadComplianceDueG().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MgmtSonyMethod.ReadComplianceDueG().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Statutory Ex. Checklist Overdue Compliance in the grid = "+ComcountGrid+" | Dashboard Statutory Overdue Compliance  Count = "+CompliancesCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of Statutory Ex. Checklist Overdue Compliance in the grid = "+ComcountGrid+" | Dashboard Statutory Overdue Compliance  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
	}
	
	public static void OverdurComplianceFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait( getDriver(), 140);
	    
		Thread.sleep(500);
		MgmtSonyMethod.ReadOverdueCompliance().click();
		Thread.sleep(8000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			Thread.sleep(8000);
		
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
       EntityLocation().click();
       Thread.sleep(3000);
       
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1().getText();
       Thread.sleep(500);
       Status1().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(500);
       
       Act().click();
       Thread.sleep(500);
       String ActText =Act1().getText();
       Thread.sleep(500);
       Act1().click();
       Thread.sleep(500);
       
       Risk().click();
       Thread.sleep(500);
       RiskAll().click();
       Thread.sleep(500);
       String riskText =RiskCritical().getText();
       Thread.sleep(500);
       RiskCritical().click();
       Thread.sleep(500);
       Risk().click();
       Thread.sleep(500);
       
       Department().click();
       Thread.sleep(500);
       String DepText =DepartmentHR().getText();
       Thread.sleep(500);
       DepartmentHR().click();
       Thread.sleep(500);
       
       
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        li.add(ActText);
        li.add(riskText);
        li.add(DepText);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		filter.add("Act");
		filter.add("Risk");	
		filter.add("Department");	
		
		ClickTri().click();
	       Thread.sleep(1000);
	       Columns().click();
	       Thread.sleep(500);
	       RiskCheck().click();
	       Thread.sleep(1000);
	       DepCheck().click();
	       Thread.sleep(1000);
	      
	       ClickTri().click();

		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Deptcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[13]"));
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
			else if(i==2)
			{
				raw.addAll(Actcol);
			}
			else if(i==3)
			{
				raw.addAll(Riskcol);
			}
			else if(i==4)
			{
				raw.addAll(Deptcol);
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
		  
		if(ClearFilter().isEnabled()) {
			ClearFilter().click();
			test.log(LogStatus.PASS, "The applied filter should get cleared  after clicking on the clear button");
		}
		
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void GraphCount( ExtentTest test, String risk, int complianceCount)throws InterruptedException
	{
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (100));
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

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
		
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExportImage().click();     
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
			} else {
				test.log(LogStatus.FAIL, "  File does not downloaded.");
			}
		Thread.sleep(3000);
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
		
			test.log(LogStatus.PASS, "'"+risk+"'  Compliance  count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "'"+risk+"'  Compliance  count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"'  Compliance  count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void GraphCount2( ExtentTest test, String risk, int complianceCount)throws InterruptedException
	{
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(160));
		
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
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			
		}
		
		
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
		
		
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExportImage().click();     
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
			} else {
				test.log(LogStatus.FAIL, "  File does not downloaded.");
			}
		
			
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
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
		
			test.log(LogStatus.PASS, "'"+risk+"'  Compliance  count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"'  Compliance  count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"'  Compliance  count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void ComplianceDueIn( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		String string_CompliancesText =MgmtSonyMethod.ComplianceDue().getText();		//Storing old value of Statutory overdue.
		
		if(string_CompliancesText.equalsIgnoreCase("Internal Compliance Due")) {
			test.log(LogStatus.PASS, "The Internal compliance due box should be seen on the my dashboard page");	
		}else {
			test.log(LogStatus.FAIL, "The Internal compliance due box should be seen on the my dashboard page");	
		}
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		String string_Compliances =MgmtSonyMethod.ReadComplianceDue().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
	MgmtSonyMethod.ReadComplianceDue().click();
	Thread.sleep(8000);
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		                
		File dir = new File("C:\\Users\\Mayuri\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();     
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		MgmtSonyMethod.ReadComplianceDueG().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MgmtSonyMethod.ReadComplianceDueG().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Internal compliance due in the grid = "+ComcountGrid+" | Dashboard Internal Compliances due  Count = "+CompliancesCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of  Internal compliance due in the grid = "+ComcountGrid+" | Dashboard Internal compliance due  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
	}
	
	public static void ComplianceDueInFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait( getDriver(), 140);
	    
		Thread.sleep(500);
		MgmtSonyMethod.ReadComplianceDue().click();
		Thread.sleep(8000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			Thread.sleep(8000);
		
		EntityLocation().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
      String locationtext =EntityLocationExpandIn1().getText();
       Thread.sleep(500);
       EntityLocationExpandIn1().click();
       Thread.sleep(500);
       EntityLocation().click();
       Thread.sleep(3000);
       
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1In().getText();
       Thread.sleep(500);
       Status1In().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(2000);
       
       Category().click();
       Thread.sleep(500);
       String CatText =CategoryDue().getText();
       Thread.sleep(500);
       CategoryDue().click();
       Thread.sleep(500);
       Category().click();
       Thread.sleep(500);
       
       Risk().click();
       Thread.sleep(500);
       RiskAll().click();
       Thread.sleep(500);
       String RiskText =RiskHigh().getText();
       Thread.sleep(500);
       RiskHigh().click();
       Thread.sleep(500);
       Risk().click();
       Thread.sleep(500);
       
       SelectType().click();
       Thread.sleep(500);
       String InText =SelectType1().getText();
       Thread.sleep(500);
       SelectType1().click();
       Thread.sleep(1000);
     
      
      
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        li.add(CatText);
        li.add(RiskText);
        li.add(InText);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		filter.add("Category");	
		filter.add("Risk");	
		filter.add("Internal Type");	
		
		ClickTri().click();
	       Thread.sleep(1000);
	       Columns().click();
	       Thread.sleep(500);
	       RiskCheck().click();
	       Thread.sleep(1000);
	       CategoryCheck().click();
	       Thread.sleep(1000);
	       InternalCheck().click();
	       Thread.sleep(500);
	       ClickTri().click();

		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		List<WebElement> Catcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
		List<WebElement> InTypecol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[15]"));
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
		     	else if(i==2)
			{
		   		raw.addAll(Catcol);
			}
			else if(i==3)
			{
				raw.addAll(Riskcol);
			}
			else if(i==4)
			{
				raw.addAll(InTypecol);
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
		  
		if(ClearFilter().isEnabled()) {
			ClearFilter().click();
			test.log(LogStatus.PASS, "The applied filter should get cleared  after clicking on the clear button");
		}
		
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceReportedIn( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		String string_CompliancesText =MgmtSonyMethod.ComplianceReported().getText();		//Storing old value of Statutory overdue.
		
		if(string_CompliancesText.equalsIgnoreCase("Internal Compliance Reported")) {
			test.log(LogStatus.PASS, "The  Internal Compliance Reported box should be seen on the my dashboard page");	
		}else {
			test.log(LogStatus.FAIL, "The Internal Compliance Reported box should be seen on the my dashboard page");	
		}
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		String string_Compliances =MgmtSonyMethod.readComplianceReported().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
	MgmtSonyMethod.readComplianceReported().click();
	Thread.sleep(8000);
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		                
		File dir = new File("C:\\Users\\Mayuri\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();     
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		MgmtSonyMethod.ReadComplianceDueG().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MgmtSonyMethod.ReadComplianceDueG().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of  Internal Compliance Reported in the grid = "+ComcountGrid+" | Dashboard Internal Compliances reported  Count = "+CompliancesCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of  Internal Compliance Reported in the grid = "+ComcountGrid+" | Dashboard Internal compliance reported  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
	}
	
	public static void RiskGraphCount1( ExtentTest test, String ComplianceType, int ComplianceCount, String Complaince)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (60));
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
			
 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[19]/a");

			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
	
		Thread.sleep(1000);
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
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(2000);
		if(count1 == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Complaince Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"'Compliance   Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Complaince Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	public static void CompliancereportedInFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait( getDriver(), 140);
	    
		Thread.sleep(2000);
		MgmtSonyMethod.readComplianceReported().click();
		Thread.sleep(8000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			Thread.sleep(8000);
		
		EntityLocation().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
      String locationtext =KarnatakaPvtLtddIn1().getText();
       Thread.sleep(500);
       KarnatakaPvtLtddIn1().click();
       Thread.sleep(500);
       EntityLocation().click();
       Thread.sleep(3000);
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1InCT().getText();
       Thread.sleep(500);
       Status1InCT().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(500);
       
       Risk().click();
       Thread.sleep(500);
       RiskAll().click();
       Thread.sleep(500);
       String RiskText =RiskHigh().getText();
       Thread.sleep(500);
       RiskHigh().click();
       Thread.sleep(500);
       Risk().click();
       Thread.sleep(500);
      
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        li.add(RiskText);
      
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		filter.add("Risk");	
		ClickTri().click();
	       Thread.sleep(1000);
	       Columns().click();
	       Thread.sleep(500);
	       RiskCheck().click();
	       Thread.sleep(1000);
	    
	       ClickTri().click();

		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
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
			else if(i==2)
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
		  
		if(ClearFilter().isEnabled()) {
			ClearFilter().click();
			test.log(LogStatus.PASS, "The applied filter should get cleared  after clicking on the clear button");
		}
		
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceOverdueIn( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
		String string_CompliancesText =MgmtSonyMethod.OverdueCompliance().getText();		//Storing old value of Statutory overdue.
		
		if(string_CompliancesText.equalsIgnoreCase("Internal Overdue Compliance")) {
			test.log(LogStatus.PASS, "The Internal compliance reported box should be seen on the my dashboard page");	
		}else {
			test.log(LogStatus.FAIL, "The Internal compliance reported box should be seen on the my dashboard page");	
		}
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		String string_Compliances =MgmtSonyMethod.ReadOverdueCompliance().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
	MgmtSonyMethod.ReadOverdueCompliance().click();
	Thread.sleep(8000);
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		                
		File dir = new File("C:\\Users\\Mayuri\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();     
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a[1]");

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
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		MgmtSonyMethod.ReadComplianceDueG().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MgmtSonyMethod.ReadComplianceDueG().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			
			test.log(LogStatus.PASS, "No of Internal Overdue Compliance in the grid = "+ComcountGrid+" | Dashboard Internal Overdue Compliance  Count = "+CompliancesCountDas);
		}
		else
		{
			
			test.log(LogStatus.FAIL, "No of Internal Overdue Compliance in the grid = "+ComcountGrid+" | Dashboard Internal Overdue Compliance  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
	}
	
	public static void OverdurComplianceInFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait( getDriver(), 140);
	    
		Thread.sleep(500);
		MgmtSonyMethod.ReadOverdueCompliance().click();
		Thread.sleep(8000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
			Thread.sleep(8000);
		
		EntityLocation().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(500);
		EntityLocationExpand().click();
		Thread.sleep(1000);
      String locationtext =EntityLocationExpandIn1().getText();
       Thread.sleep(500);
       EntityLocationExpandIn1().click();
       Thread.sleep(500);
       EntityLocation().click();
       Thread.sleep(3000);
       
       Status().click();
       Thread.sleep(500);
       String Statustext =Status1In().getText();
       Thread.sleep(500);
       Status1In().click();
       Thread.sleep(500);
       Status().click();
       Thread.sleep(500);
       
       Category().click();
       Thread.sleep(500);
       String CatText =CategoryDue().getText();
       Thread.sleep(500);
       CategoryDue().click();
       Thread.sleep(500);
       Category().click();
       Thread.sleep(500);
       
       Risk().click();
       Thread.sleep(500);
       RiskAll().click();
       Thread.sleep(500);
       String RiskText =RiskHigh().getText();
       Thread.sleep(500);
       RiskHigh().click();
       Thread.sleep(500);
       Risk().click();
       Thread.sleep(500);
       
        List<String> li=new ArrayList<String>();
        
        li.add(locationtext);
        li.add(Statustext);
        li.add(CatText);
        li.add(RiskText);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Location");
		filter.add("Status");	
		filter.add("Category");	
		filter.add("Risk");	
		
		ClickTri().click();
	       Thread.sleep(1000);
	       Columns().click();
	       Thread.sleep(500);
	       RiskCheck().click();
	       Thread.sleep(1000);
	       CategoryCheck().click();
	       Thread.sleep(500);
	       ClickTri().click();

		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		List<WebElement> Catcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
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
			else if(i==2)
			{
				raw.addAll(Catcol);
			}
			else if(i==3)
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
		  
		if(ClearFilter().isEnabled()) {
			ClearFilter().click();
			test.log(LogStatus.PASS, "The applied filter should get cleared  after clicking on the clear button");
		}
		
		Thread.sleep(3000);
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void GraphCountIn( ExtentTest test, String risk, int complianceCount)throws InterruptedException
	{
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (100));
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
			File dir = new File("C:\\Users\\Mayuri\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			CFOcountPOM.clickExportImage().click();     
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\Mayuri\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "  Excel report should get downloaded after clicking on the button of export to excel");
			} else {
				test.log(LogStatus.FAIL, "  File does not downloaded.");
			}
		Thread.sleep(3000);
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
		
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		
			test.log(LogStatus.FAIL, "'"+risk+"'  compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"'  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	
	public static void ColourCT( ExtentTest test)throws InterruptedException
	{
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (100));
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		sony = getDriver().findElement(By.cssSelector("#highcharts-0 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-pie-series.highcharts-color-2 > text"));
		String text=	sony.getText();
		if(text.equalsIgnoreCase("Closed Timely")) {
			
		Thread.sleep(3000);
		sony = getDriver().findElement(By.cssSelector("#highcharts-0 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-pie-series.highcharts-color-2 > rect"));
	String colour=	sony.getCssValue("fill");
		
	String hex=	Color.fromString(colour).asHex();
	
	if(hex.equalsIgnoreCase("#276221")) {
		
		test.log(LogStatus.PASS,  "The green colour should be seen  for the status of closed timely  in the graph of completion status  performance summary");
	}else {
		
	
	test.log(LogStatus.FAIL,  "The green colour should not for the status of closed timely  in the graph of completion status  performance summary");
	}
			
		}
	
	}


public static void ColourCD( ExtentTest test)throws InterruptedException
{
	Thread.sleep(2000);
	
	WebDriverWait wait = new WebDriverWait( getDriver(), (100));
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,300)");	
	sony = getDriver().findElement(By.cssSelector("#highcharts-0 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-pie-series.highcharts-color-1 > text"));
	String text=	sony.getText();
	if(text.equalsIgnoreCase("Closed Delayed")) {
		
	Thread.sleep(3000);
	sony = getDriver().findElement(By.cssSelector("#highcharts-0 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-pie-series.highcharts-color-1 > rect"));
String colour=	sony.getCssValue("fill");
	
String hex=	Color.fromString(colour).asHex();

if(hex.equalsIgnoreCase("#FFBF00")) {
	
	test.log(LogStatus.PASS,  " The yellow colour should be seen  for the status of closed delayed  in the graph of completion status  performance summary ");
}else {
	

test.log(LogStatus.FAIL,  " The yellow colour should not  for the status of closed delayed  in the graph of completion status  performance summary ");
}
		
	}

}

public static void ColourCTR( ExtentTest test)throws InterruptedException
{
	Thread.sleep(2000);
	
	WebDriverWait wait = new WebDriverWait( getDriver(), (100));
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,800)");	
	sony = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > text"));
	String text=	sony.getText();
	if(text.equalsIgnoreCase("Closed Timely")) {
		
	Thread.sleep(3000);
	sony = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
String colour=	sony.getCssValue("fill");
	
String hex=	Color.fromString(colour).asHex();

if(hex.equalsIgnoreCase("#276221")) {
	
	test.log(LogStatus.PASS,  "The green colour should be seen  for the status of closed timely  in the graph of Risk summary. ");
}else {
	

test.log(LogStatus.FAIL,  "The green colour should not for the status of closed timely  in the graph of Risk summary. ");
}
		
	}

}

public static void ColourCDR( ExtentTest test)throws InterruptedException
{
Thread.sleep(2000);

WebDriverWait wait = new WebDriverWait( getDriver(), (100));

JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scrollBy(0,800)");	
sony = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > text"));
String text=	sony.getText();
if(text.equalsIgnoreCase("Closed Delayed")) {
	
Thread.sleep(3000);
sony = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-1 > rect"));
String colour=	sony.getCssValue("fill");

String hex=	Color.fromString(colour).asHex();

if(hex.equalsIgnoreCase("#FFBF00")) {

test.log(LogStatus.PASS,  " The yellow colour should be seen  for the status of closed delayed  in the graph of Risk summary.  ");
}else {


test.log(LogStatus.FAIL,  " The yellow colour should not  for the status of closed delayed  in the graph of Risk summary. ");
}
	
}

}


public static void ColourCTD( ExtentTest test)throws InterruptedException
{
	Thread.sleep(2000);
	
	WebDriverWait wait = new WebDriverWait( getDriver(), (100));
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,1500)");	
	sony = getDriver().findElement(By.cssSelector("#highcharts-8 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-bar-series.highcharts-color-undefined.highcharts-series-1 > text"));
	String text=	sony.getText();
	if(text.equalsIgnoreCase("Closed Timely")) {
		
	Thread.sleep(3000);
	sony =getDriver() .findElement(By.cssSelector("#highcharts-8 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-bar-series.highcharts-color-undefined.highcharts-series-1 > rect"));
String colour=	sony.getCssValue("fill");
	
String hex=	Color.fromString(colour).asHex();

if(hex.equalsIgnoreCase("#276221")) {
	
	test.log(LogStatus.PASS,  "The green colour should be seen  for the status of closed timely  in the graph of  Department summary.");
}else {
	

test.log(LogStatus.FAIL,  "The green colour should not for the status of closed timely  in the graph of  Department summary.");
}
		
	}

}

public static void ColourCDD( ExtentTest test)throws InterruptedException
{
Thread.sleep(2000);

WebDriverWait wait = new WebDriverWait( getDriver(), (100));

JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scrollBy(0,1500)");	
sony = getDriver().findElement(By.cssSelector("#highcharts-8 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-bar-series.highcharts-color-undefined.highcharts-series-0 > text"));
String text=	sony.getText();
if(text.equalsIgnoreCase("Closed Delayed")) {
	
Thread.sleep(3000);
sony =  getDriver().findElement(By.cssSelector("#highcharts-8 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-bar-series.highcharts-color-undefined.highcharts-series-0 > rect"));
String colour=	sony.getCssValue("fill");

String hex=	Color.fromString(colour).asHex();

if(hex.equalsIgnoreCase("#FFBF00")) {

test.log(LogStatus.PASS,  " The yellow colour should be seen  for the status of closed delayed  in the graph of  Department summary.");
}else {


test.log(LogStatus.FAIL,  " The yellow colour should not  for the status of closed delayed  in the graph of  Department summary.");
}
	
}

}




}

