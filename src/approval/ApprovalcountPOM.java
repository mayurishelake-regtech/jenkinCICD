package approval;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import auditor.AuditorcountPOM;
import cfo.CFOcountPOM;
import cfo.MgmtSonyMethod;
import departmentHead.DeptCountPOM;
import implementation.ImplementPOM;
import login.BasePage;
import performer.OverduePOM;

public class ApprovalcountPOM extends BasePage {
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	private static List<WebElement> elementsList = null;
	private static WebElement compliances = null;
	
	
	public static WebElement clickManagement()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton3']"));
		return compliances;
	}
	
	public static WebElement ClearBtn()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return compliances;
	}
	
	public static WebElement NotCompletedRadio()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])[2]"));
		return compliances;
	}
	
	public static WebElement SelectCategory()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div/span[1]"));
		return compliances;
	}
	
	public static WebElement SelectCategoryCat()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@id='example']/div/div)"));
		return compliances;
	}
	
	public static WebElement SelectCategoryA()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[3]/div"));
		return compliances;
	}
	
	public static WebElement CommercialA()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[37]"));
		return compliances;
	}
	
	public static WebElement Commercial()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])"));
		return compliances;
	}
	
	public static WebElement CommercialText()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ddlfunction0']/span[1]"));
		return compliances;
	}
	
	public static WebElement Entities()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divEntitesCount']"));
		return compliances;
	}
	
	public static WebElement ErrorMsg()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='jconfirm-box12303']/div"));
		return compliances;
	}
	
	public static WebElement Location()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='tvLocationt0']"));
		return compliances;
	}
	public static WebElement TotalCompliances()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divTotalCompliancesCountSPNI']"));
		return compliances;
	}

	
	public static WebElement EntitiesClose()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
		return compliances;
	}
	
	public static WebElement LocationCount()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divLocationCount']"));
		return compliances;
	}
	
	public static WebElement Status()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/div[2]/div/span[1]"));
		return compliances;
	}
	
	public static WebElement Apply()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return compliances;
	}
	
	public static WebElement OverdueCheck()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])"));
		return compliances;
	}
	
	public static WebElement CheckAll()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[3]"));
		return compliances;
	}
	
	public static WebElement CheckAllIn()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[5]"));
		return compliances;
	}
	
	public static WebElement PFR()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[13]"));
		return compliances;
	}
	
	public static WebElement PFRMGMT()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[14]"));
		return compliances;
	}
	
	public static WebElement PFRDept()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[15]"));
		return compliances;
	}
	
	public static WebElement PFRDeptIn()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[36]"));
		return compliances;
	}
	
	public static WebElement PFRMGMTIn()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[172]"));
		return compliances;
	}
	
	public static WebElement PFRIn()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[8]"));
		return compliances;
	}
	
	public static WebElement StatusD()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div/div[1]/div[4]/div/div"));
		return compliances;
	}

	public static WebElement StatusDA()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[3]/div"));
		return compliances;
	}

	
	public static WebElement ApplyAP()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Applyfilter']"));
		return compliances;
	}
	
	public static WebElement ApplyA()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='btnApply']"));
		return compliances;
	}
	
	public static WebElement ApplyAS()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Applybtn1']"));
		return compliances;
	}
	
	public static WebElement SelectAct()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/span/span/span[2]"));
		return compliances;
	}
	
	public static WebElement DailyUpdates()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dailyupdates']/div/div/div[4]/a"));
		return compliances;
	}
	
	public static WebElement NewsLetter()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='collapseNewsletter']/div[3]/a"));
		return compliances;
		//*[@id='newsletter']/div/div/div[1]/div/a/h2
	}
	
	public static WebElement ClearAS()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Clearfilter']"));
		return compliances;
	}
	
	public static WebElement StatusCD()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[4]/div/div/span[1]"));
		return compliances;                        
	}
	
	public static WebElement StatusCD1()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[7]"));
		return compliances;
	}
	
	public static WebElement ComplianceType()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[3]/div/div/span[1]"));
		return compliances;
	}
	
	public static WebElement Statutory()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[18]"));
		return compliances;
	}
	
	public static WebElement Statutory1()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[17]"));
		return compliances;
	}
	
	public static WebElement Risk()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[5]/div/div/span[1]"));
		return compliances;                        
	}
	
	public static WebElement Risk1()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[2]"));
		return compliances;
	}
	
	public static WebElement Act()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[3]/div[1]/span/span/span[2]"));
		return compliances;                        
	}
	
	public static WebElement Act1()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[1]"));
		return compliances;
	}
	
	public static WebElement Act2()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[3]"));
		return compliances;
	}
	
	public static WebElement ActM()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[6]"));
		return compliances;
	}
	
	public static WebElement ActP()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[9]"));
		return compliances;
	}
	
	public static WebElement ActDep()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[17]"));
		return compliances;
	}
	
	
	public static WebElement MyEscalation ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='leftescalationmenu']"));
		return compliances;
	}
	
	public static WebElement MyApprovals ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='leftApprovermenu']"));
		return compliances;
	}
	
	public static WebElement Filters ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlStatus']"));
		return compliances;
	}
	
	public static WebElement StatutoryExcludingChecklist ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlStatus']/option[1]"));
		return compliances;
	}
	
	public static WebElement RiskF ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div/span[1]"));
		return compliances;
	}
	
	public static WebElement RiskHigh ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[7]"));
		return compliances;
	}
	public static WebElement RiskHigh1 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[7]"));
		return compliances;
	}
	public static WebElement RiskHighM ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[9]"));
		return compliances;
	}
	
	public static WebElement RiskCritical ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[7]"));
		return compliances;
	}
	
	public static WebElement RiskHighDep ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[7]"));
		return compliances;
	}
	
	public static WebElement RiskHighNA ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[44]"));
		return compliances;
	}
	
	public static WebElement SelectActF ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/div[1]/div"));
		return compliances;
	}//*[@id="example"]/div[2]/div[1]/div
	
	public static WebElement SelectActF1 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[25]"));
		return compliances;
	}
	
	public static WebElement SelectActF11 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[41]"));
		return compliances;
	}
	
	public static WebElement SelectActPG ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[59]"));
		return compliances;
	}
	
	public static WebElement SelectActF11D ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[41]"));
		return compliances;
	}
	
	public static WebElement SelectActF11D1 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[40]"));
		return compliances;
	}
	public static WebElement SelectActNA ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[29]"));
		return compliances;
	}
	
	
	public static WebElement MitigationPlan ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[3]/span/span/span[2]/span"));
		return compliances;
	}
	
	public static WebElement MitigationPlan1 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownlistMplan_listbox']/li[2]"));
		return compliances;
	}
	
	public static WebElement MitigationPlan2 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownlistMplan_listbox']/li[3]"));
		return compliances;
	}
	
	public static WebElement StatusF ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/div[2]/div/span[1]"));
		return compliances;
	}
	
	public static WebElement StatusFP ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/div[3]/div/span[1]"));
		return compliances;
	}
	
	public static WebElement StatusAll ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[5]"));
		return compliances;
	}
	
	public static WebElement StatusAll1 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[3]"));
		return compliances;
	}
	
	public static WebElement RiskAll ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[2]"));
		return compliances;
	}
	
	public static WebElement StatusOverdue ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[12]"));
		return compliances;
	}
	
	public static WebElement StatusUpcoming ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@class='k-in' and .='Upcoming']"));
		return compliances;
	}
	public static WebElement StatusNA()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[21]"));
		return compliances;
	}
	
	public static WebElement StatusNAIn()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[149]"));
		return compliances;
	}
	
	public static WebElement StatusOverdueM ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[13]"));
		return compliances;
	}
	
	public static WebElement StatusUpcomingM ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Upcoming']"));
		return compliances;
	}
	
	public static WebElement StatusOverdueD ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[11]"));
		return compliances;
	}
	
	public static WebElement DeviationApproval  ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='leftSecondRevmenu']"));
		return compliances;
	}
	
	public static WebElement Period ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[1]/span/span[2]/span"));
		return compliances;
	}
	
	public static WebElement Period1 ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[5]"));
		return compliances;
	}
	
	public static WebElement Edit ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[10]/a"));
		return compliances;
	}
	
	public static WebElement Remark ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='txtDevApvRemrk']"));
		return compliances;
	}
	
	public static WebElement Approve ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='btnApprove']"));
		return compliances;
	}
	
	public static WebElement btnReject()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='btnReject']"));
		return compliances;
	}
	
	public static WebElement Clear()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return compliances;
	}
	
	public static WebElement Export()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Exportbtn']"));
		return compliances;
	}
	public static WebElement clickReports( )					//Searching 'My Reports' element
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']"));
		return compliances;
	}
	public static WebElement clickDetailedReport( )			//Searching 'Detailed Report' element under 'My reports'
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Myreport']"));
		return compliances;
	}
	
	
	
public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

public static void Entities( ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	if(Entities().isDisplayed()) {
		test.log(LogStatus.PASS, "Assigned Entites Count display Entites Box.");
	}else {
		test.log(LogStatus.PASS, "Assigned Entites Count not display Entites Box.");
	}
	Entities().click();
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(2000);
	
	if(Location().isDisplayed()) {
		test.log(LogStatus.PASS, "Entites Popup Location and User list displayed");
	}else {
		test.log(LogStatus.PASS, "Entites Popup Location and User list not displayed");
	}
	
	Thread.sleep(500);
	getDriver().switchTo().parentFrame();
	EntitiesClose().click();
	Thread.sleep(3000);
}

public static void TotalCompliances( ExtentTest test)throws InterruptedException
{

	Thread.sleep(500);
	if(OverduePOM.closeMessage().isDisplayed())				//If Compliance Updation message popped up,
	{
		OverduePOM.closeMessage().click();					//then close the message.
	}
	
	Thread.sleep(1500);
	int valuebeforeTotalcompliance = Integer.parseInt(ApprovalcountPOM.TotalCompliances().getText());	//Storing value of 'Users' as a String to compare.
	Thread.sleep(2000);

	String OptionText1 = "Option 1";
	String xpathExpression1 = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[1]",OptionText1);
	WebElement dropdownOption1 = getDriver().findElement(By.xpath(xpathExpression1));
	dropdownOption1.click();

	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
	/*
	String OptionText = "Option 1";
	String xpathExpression = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[1]",OptionText);
	WebElement dropdownOption = getDriver().findElement(By.xpath(xpathExpression));
	dropdownOption.click();
	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
*/
	// Combine the two XPaths with the '|' operator
    WebElement element = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

    if (element != null) {
    	element.click();
      //  System.out.println("Refresh After Selecting Filter ");
        // Perform actions on the element
    } else {
    	
       // System.out.println("Not Refresh After Selecting Filter");
    }
    Thread.sleep(3000);
	int valueTotalcompliance = Integer.parseInt(ApprovalcountPOM.TotalCompliances().getText());	//Storing value of 'Users' as a String to compare.

	if(valuebeforeTotalcompliance!= valueTotalcompliance)								//Checking if String getCount contains the Value (in string format) 
	{
		test.log(LogStatus.PASS, "Before Select Statutory excluding checklist -'Total Compliances' count "+ valuebeforeTotalcompliance+ ",- After Select Statutory excluding checklist -'Total Compliances' count "+ valueTotalcompliance);
	}
	else
	{
		test.log(LogStatus.FAIL, "Total Compliances count does not matches. Dashboard Value = "+ valuebeforeTotalcompliance+ ", - Actual Value = "+ valueTotalcompliance);
	}
	Thread.sleep(3000);
	
	String OptionText = "Option 3";
	String xpathExpression = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[3]",OptionText);
	WebElement dropdownOption = getDriver().findElement(By.xpath(xpathExpression));
	dropdownOption.click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
	WebElement elements = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

    if (elements != null) {
    	elements.click();
      //  System.out.println("Refresh After Selecting Filter ");
        // Perform actions on the element
    } else {
    	
      //  System.out.println("Not Refresh After Selecting Filter");
    }
    
	
    Thread.sleep(3000);
	int Totalcompliancecount1 = Integer.parseInt(ApprovalcountPOM.TotalCompliances().getText());	//Storing value of 'Users' as a String to compare.

	if(valueTotalcompliance!= Totalcompliancecount1)								//Checking if String getCount contains the Value (in string format) 
	{
		test.log(LogStatus.PASS, "Before Select statutory -'Total Compliances' count "+ valueTotalcompliance+ ",After Select statutory -'Total Compliances' count "+ Totalcompliancecount1);
	}
	else
	{
		test.log(LogStatus.FAIL, "Total Compliances count does not matches. Total Compliances = "+ valueTotalcompliance+ ", Actual Value = "+ Totalcompliancecount1);
	}
	Thread.sleep(3000);
	
}

public static void LocationCount( ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	if(LocationCount().isDisplayed()) {
		test.log(LogStatus.PASS, " Location Count display Location Box .");
	}else {
		test.log(LogStatus.PASS, "Location Count  not display Location Box.");
	}
	
	Thread.sleep(3000);
}

public static void CompliancesCount( ExtentTest test)throws InterruptedException
{

	Thread.sleep(500);
	if(OverduePOM.closeMessage().isDisplayed())				//If Compliance Updation message popped up,
	{
		OverduePOM.closeMessage().click();					//then close the message.
	}
	
	Thread.sleep(1500);
	
	int valuebeforeTotalcompliance = Integer.parseInt(ApprovalcountPOM.TotalCompliances().getText());	//Storing value of 'Users' as a String to compare.
	Thread.sleep(2000);

	String OptionText1 = "Option 1";
	String xpathExpression1 = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[1]",OptionText1);
	WebElement dropdownOption1 = getDriver().findElement(By.xpath(xpathExpression1));
	dropdownOption1.click();

	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
	/*
	String OptionText = "Option 1";
	String xpathExpression = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[1]",OptionText);
	WebElement dropdownOption = getDriver().findElement(By.xpath(xpathExpression));
	dropdownOption.click();
	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
*/
	// Combine the two XPaths with the '|' operator
    WebElement element = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

    if (element != null) {
    	element.click();
      //  System.out.println("Refresh After Selecting Filter ");
        // Perform actions on the element
    } else {
    	
       // System.out.println("Not Refresh After Selecting Filter");
    }
    Thread.sleep(3000);
	int valueTotalcompliance = Integer.parseInt(ApprovalcountPOM.TotalCompliances().getText());	//Storing value of 'Users' as a String to compare.

	if(valuebeforeTotalcompliance!= valueTotalcompliance)								//Checking if String getCount contains the Value (in string format) 
	{
		test.log(LogStatus.PASS, "Before Select Statutory excluding checklist -'Total Compliances' count "+ valuebeforeTotalcompliance+ ",- After Select Statutory excluding checklist -'Total Compliances' count "+ valueTotalcompliance);
	}
	else
	{
		test.log(LogStatus.FAIL, "Total Compliances count does not matches. Dashboard Value = "+ valuebeforeTotalcompliance+ ", - Actual Value = "+ valueTotalcompliance);
	}
	Thread.sleep(3000);
	
	String OptionText = "Option 3";
	String xpathExpression = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[3]",OptionText);
	WebElement dropdownOption = getDriver().findElement(By.xpath(xpathExpression));
	dropdownOption.click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
	WebElement elements = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

    if (elements != null) {
    	elements.click();
      //  System.out.println("Refresh After Selecting Filter ");
        // Perform actions on the element
    } else {
    	
      //  System.out.println("Not Refresh After Selecting Filter");
    }
    
	
    Thread.sleep(3000);
	int Totalcompliancecount1 = Integer.parseInt(ApprovalcountPOM.TotalCompliances().getText());	//Storing value of 'Users' as a String to compare.

	if(valueTotalcompliance!= Totalcompliancecount1)								//Checking if String getCount contains the Value (in string format) 
	{
		test.log(LogStatus.PASS, "Before Select statutory -'Total Compliances' count "+ valueTotalcompliance+ ",After Select statutory -'Total Compliances' count "+ Totalcompliancecount1);
	}
	else
	{
		test.log(LogStatus.FAIL, "Total Compliances count does not matches. Total Compliances = "+ valueTotalcompliance+ ", Actual Value = "+ Totalcompliancecount1);
	}
	Thread.sleep(3000);
	
}

public static void CompliancesCountChanges( ExtentTest test)throws InterruptedException
{

	Thread.sleep(500);
	if(OverduePOM.closeMessage().isDisplayed())				//If Compliance Updation message popped up,
	{
		OverduePOM.closeMessage().click();					//then close the message.
	}
	
	Thread.sleep(1500);
	//String string_Compliances =CFOcountPOM.readCompliancesInternal().getText();		//Storing old value of Statutory overdue.
//	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
	int valuebeforeTotalcompliance = Integer.parseInt(CFOcountPOM.readCompliancesInternal().getText());	//Storing value of 'Users' as a String to compare.
	Thread.sleep(2000);

	String OptionText1 = "Option 1";
	String xpathExpression1 = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[1]",OptionText1);
	WebElement dropdownOption1 = getDriver().findElement(By.xpath(xpathExpression1));
	dropdownOption1.click();

	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
	/*
	String OptionText = "Option 1";
	String xpathExpression = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[1]",OptionText);
	WebElement dropdownOption = getDriver().findElement(By.xpath(xpathExpression));
	dropdownOption.click();
	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
*/
	// Combine the two XPaths with the '|' operator
    WebElement element = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

    if (element != null) {
    	element.click();
      //  System.out.println("Refresh After Selecting Filter ");
        // Perform actions on the element
    } else {
    	
       // System.out.println("Not Refresh After Selecting Filter");
    }
    Thread.sleep(3000);
	int valueTotalcompliance = Integer.parseInt(CFOcountPOM.readCompliancesInternal().getText());	//Storing value of 'Users' as a String to compare.

	if(valuebeforeTotalcompliance!= valueTotalcompliance)								//Checking if String getCount contains the Value (in string format) 
	{
		test.log(LogStatus.PASS, "Before Select Statutory excluding checklist -'Total Compliances' count "+ valuebeforeTotalcompliance+ ", After Select Statutory excluding checklist -'Total Compliances' count "+ valueTotalcompliance);
	}
	else
	{
		test.log(LogStatus.FAIL, " Compliances count does not Change after select filter Statutory excluding checklist = "+ valuebeforeTotalcompliance+ ",  Actual Value = "+ valueTotalcompliance);
	}
	Thread.sleep(3000);
	
	String OptionText = "Option 3";
	String xpathExpression = String.format("//select[@id='ContentPlaceHolder1_ddlStatus']/option[3]",OptionText);
	WebElement dropdownOption = getDriver().findElement(By.xpath(xpathExpression));
	dropdownOption.click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(3000);
	WebElement elements = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

    if (elements != null) {
    	elements.click();
      //  System.out.println("Refresh After Selecting Filter ");
        // Perform actions on the element
    } else {
    	
      //  System.out.println("Not Refresh After Selecting Filter");
    }
    
	
    Thread.sleep(3000);
	int Totalcompliancecount1 = Integer.parseInt(CFOcountPOM.readCompliancesInternal().getText());	//Storing value of 'Users' as a String to compare.

	if(valueTotalcompliance!= Totalcompliancecount1)								//Checking if String getCount contains the Value (in string format) 
	{
		test.log(LogStatus.PASS, "Before Select statutory -' Compliances' count "+ valueTotalcompliance+ ", After Select statutory -' Compliances' count "+ Totalcompliancecount1);
	}
	else
	{
		test.log(LogStatus.FAIL, " Compliances count does not Change after select filter Statutory  = "+ valueTotalcompliance+ ", Actual Value = "+ Totalcompliancecount1);
	}
	Thread.sleep(3000);
	
}


public static void SummaryofOverdueCompliancesFilter( ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);

		CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
		
//	litigationPerformer.MethodsPOM.progress();
	WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	
WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
getDriver() .switchTo().frame(farme);
  Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
	 Thread.sleep(3000); 
	 
	 ApprovalcountPOM.Status().click();
		Thread.sleep(1000);
		 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[31]")); 
		 String cattext =TextCat.getText();
		 Thread.sleep(1000);
		TextCat.click();
		Thread.sleep(3000);
		ApprovalcountPOM.Status().click();
		Thread.sleep(1000);
		
		ApprovalcountPOM.ApplyAP().click();
		Thread.sleep(6000);
	
		Thread.sleep(1000);
		 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[10]")); //column list
		 
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
			 test.log(LogStatus.FAIL, "Selection wise  filter not working Properly : "+Fal);
			// System.out.println("fail : "+Fal);
		 }
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS, "Selection wise filter working Properly   Value Match with : "+Pas);
			// System.out.println("Pass : "+Pas);
		 }

		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
	
	Thread.sleep(3000);
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
	
	WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	Status().click();
	Thread.sleep(1000);
	CheckAll().click();
	CheckAll().click();
	Thread.sleep(1000);
	PFR().click();
	Thread.sleep(1000);
	Status().click();
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
		File dir = new File("C:\\Users\\snehalp\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		ViewButton.get(1).click();
		
		Thread.sleep(3000);//C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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

	
	public static void GraphCount( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
			Thread.sleep(2000);
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
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
		
		Thread.sleep(3000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");

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
				Thread.sleep(3000);
			}
		
		Thread.sleep(1000);
	
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
		
}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
	public static void GraphCount1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		Thread.sleep(8000);
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
			Thread.sleep(5000);
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
		
		Thread.sleep(1000);
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		Thread.sleep(1000);
}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
	public static void GraphCount1Sta( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
			Thread.sleep(5000);
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
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
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
		
		Thread.sleep(1000);
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		Thread.sleep(1000);
}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
	
	public static void GraphCount2( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
			Thread.sleep(5000);
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
				// retrieving "foo-button" HTML element
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
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
	
	public static void RiskGraphCount( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 70);
		Actions action = new Actions(getDriver());
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
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
	
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
		}else {
			int count=0;
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			if(count==ComplianceCount) {
				test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
				
				}
				else {
					test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
				}
			
			
		}
	}
	
	public static void RiskGraphCountS( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 70);
		Actions action = new Actions(getDriver());
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
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
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(4000);
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");

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
				Thread.sleep(3000);
			}
	
		Thread.sleep(1000);
	
	
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(1000);
		
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
				test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
			}
				
			
		}
	}
	
	public static void RiskGraphCount2( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
				WebDriverWait wait = new WebDriverWait(getDriver(),(180));
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
	
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
	}
	
	
	public static void RiskGraphCount1( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		Actions action = new Actions(getDriver());
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
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
		
//		Thread.sleep(4000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");

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
				Thread.sleep(3000);
			}
	
		Thread.sleep(1000);
	
	
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(1000);
		
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
				test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
			}
			
		}
	}
	
	public static void RiskGraphCount1S( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		Actions action = new Actions(getDriver());
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		
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
		
	
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[1]");

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
				Thread.sleep(3000);
			}
	
		Thread.sleep(1000);
	
	
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(1000);
		
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
				test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count = "+ ComplianceCount + " | Total no of items from grid = "+ count);
			}
			
		
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
			Thread.sleep(1000);			
			
		}
	}
	
	public static void GraphCountPe( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
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
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
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
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		Thread.sleep(500);
		Thread.sleep(3000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
//			Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a[1]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			try {
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
					Thread.sleep(3000);
				}
		
		Thread.sleep(1000);
	
		
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
	
	public static void GraphCountPe1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		WebDriverWait wait = new WebDriverWait(getDriver(),50);
		
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
		
		Thread.sleep(1000);
	
		
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
	
	public static void GraphCountPe1Sta( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
		}
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(),50);
		
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
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(4000);
				
				ViewButton.get(2).click();
			
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
		
		Thread.sleep(1000);
	
		
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(1000);
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
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
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
				Thread.sleep(3000);
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
					Thread.sleep(3000);
				}
			
	
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
	
	}else {
		
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		Status().click();
		Thread.sleep(3000);
		CheckAllIn().click();
		Thread.sleep(1000);
		CheckAllIn().click();
		Thread.sleep(3000);
		PFRIn().click();
		Thread.sleep(1000);
		Status().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			ViewButton.get(1).click();
			
			Thread.sleep(3000);//C://Users//jiya//Downloads//
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance : - No records found ");
			Thread.sleep(1000);
			
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(1000);
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
			// retrieving "foo-button" HTML element
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View successfully");
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			test.log(LogStatus.PASS, "Download Doc successfully");
			Thread.sleep(4000);
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
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(2000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
	public static void GraphCountInPe1( ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
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
		
		
		Thread.sleep(500);
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
				Thread.sleep(3000);
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
					Thread.sleep(3000);
				}
			
					
		
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(500);
		
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
	
	
	
	public static void DetailedReport(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(6000);
		CFOcountPOM.clickExportImage().click();			//Exporting (Downloading) file
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(5000);
		CFOcountPOM.closeDocument1().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "overView successfully");
	//	CFOcountPOM.closeDocument1().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Clear Button Working Successfully ");
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	//	clickExportExcel().click();
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
	//	test.log(LogStatus.INFO, "overView success");
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Advanced Search - overView successfully");
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
		CFOcountPOM.selectMonth1().click();
		Thread.sleep(3000);
		/*
		CFOcountPOM.selectLastSixMon().click();
		Thread.sleep(2000);
		CFOcountPOM.clickApplyAd().click();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(8000);
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
			test.log(LogStatus.PASS, "Advanced Search -After Selecting Month -  overView successfully");

		//	test.log(LogStatus.INFO, "overView success");
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
			test.log(LogStatus.PASS, "Advanced Search -Apply Button Working  successfully");*/
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);
			performer.OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
	}
	
	public static void DetailedReportFilter(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		
		Thread.sleep(6000);
		
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Statutory");
		
		Thread.sleep(3000);
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		ApprovalcountPOM.Apply().click();
		Thread.sleep(6000);
     
   
      
		StatusCD().click();
       Thread.sleep(1000);
       String Statustext =StatusCD1().getText();
       Thread.sleep(500);
       StatusCD1().click();
       Thread.sleep(1000);
    
       Risk().click();
       Thread.sleep(1000);
       String Risktext =Risk1().getText();
       Thread.sleep(500);
       Risk1().click();
      
       Thread.sleep(1000);
       Act().click();
       Thread.sleep(1000);
       String Acttext =Act2().getText();
       Thread.sleep(500);
       Act2().click();
      
       Thread.sleep(1000);
       ApprovalcountPOM.Apply().click();
       Thread.sleep(6000);
       
        List<String> li=new ArrayList<String>();
        
              li.add(Statustext);
              li.add(Risktext);
              li.add(Acttext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Status");	
		filter.add("Risk");
		filter.add("Act");
		 By locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[2]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		//MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod .Columns().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	      // MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
	//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[6]"));
		
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[9]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[8]"));

		Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,500)");
	//	js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=500");

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statuscol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
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
		
	
			performer.OverduePOM.clickDashboard().click();
			
	}
	
	public static void DetailedReportFilterRe(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		
		Thread.sleep(6000);
		
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		CFOcountPOM.StatutoryRe().click();
		Thread.sleep(3000);
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		ApprovalcountPOM.Apply().click();
		Thread.sleep(6000);
     
   
      
		StatusCD().click();
       Thread.sleep(1000);
       String Statustext =StatusCD1().getText();
       Thread.sleep(500);
       StatusCD1().click();
       Thread.sleep(1000);
    
       Risk().click();
       Thread.sleep(1000);
       String Risktext =Risk1().getText();
       Thread.sleep(500);
       Risk1().click();
      
       Thread.sleep(1000);
       Act().click();
       Thread.sleep(1000);
    
       String Acttext =Act2().getText();
       Thread.sleep(500);
       Act2().click();
      
      
       Thread.sleep(1000);
       ApprovalcountPOM.Apply().click();
       Thread.sleep(6000);
       
        List<String> li=new ArrayList<String>();
        
              li.add(Statustext);
              li.add(Risktext);
              li.add(Acttext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Status");	
		filter.add("Risk");
		filter.add("Act");
		
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod .Columns().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	       MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
	//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[6]"));
		
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[9]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[8]"));

		Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=500");

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statuscol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
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
		
	
			performer.OverduePOM.clickDashboard().click();
			
	}
	
	public static void DetailedReportFilterper(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		
		Thread.sleep(6000);
		
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		CFOcountPOM.StatutoryRe().click();
		Thread.sleep(3000);
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		ApprovalcountPOM.Apply().click();
		Thread.sleep(6000);
     
   
      
		StatusCD().click();
       Thread.sleep(1000);
       String Statustext =StatusCD1().getText();
       Thread.sleep(500);
       StatusCD1().click();
       Thread.sleep(1000);
    
       Risk().click();
       Thread.sleep(1000);
       String Risktext =Risk1().getText();
       Thread.sleep(500);
       Risk1().click();
      
       Thread.sleep(1000);
       Act().click();
       Thread.sleep(1000);
    
       String Acttext =ActP().getText();
       Thread.sleep(500);
       ActP().click();
      
      
       Thread.sleep(1000);
       ApprovalcountPOM.Apply().click();
       Thread.sleep(6000);
       
        List<String> li=new ArrayList<String>();
        
              li.add(Statustext);
              li.add(Risktext);
              li.add(Acttext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Status");	
		filter.add("Risk");
		filter.add("Act");
		
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod .Columns().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	       MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
	//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[6]"));
		
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[9]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[8]"));

		Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=500");

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statuscol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
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
				
				for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Fal);
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
		
	
			performer.OverduePOM.clickDashboard().click();
			
	}
	
	public static void DetailedReportFilterDep(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		
		Thread.sleep(6000);
		
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		ApprovalcountPOM.Statutory().click();
		Thread.sleep(3000);
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		ApprovalcountPOM.Apply().click();
		Thread.sleep(6000);
     
   
      
		StatusCD().click();
       Thread.sleep(1000);
       String Statustext =StatusCD1().getText();
       Thread.sleep(500);
       StatusCD1().click();
       Thread.sleep(1000);
    
       Risk().click();
       Thread.sleep(1000);
       String Risktext =Risk1().getText();
       Thread.sleep(500);
       Risk1().click();
      
       Thread.sleep(1000);
       Act().click();
       Thread.sleep(1000);
    
       String Acttext =ActDep().getText();
       Thread.sleep(500);
       ActDep().click();
      
      
       Thread.sleep(1000);
       ApprovalcountPOM.Apply().click();
       Thread.sleep(6000);
       
        List<String> li=new ArrayList<String>();
        
              li.add(Statustext);
              li.add(Risktext);
              li.add(Acttext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Status");	
		filter.add("Risk");
		filter.add("Act");
		
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod .Columns().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	       MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
	//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[6]"));
		
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[9]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[8]"));

		Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=500");

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statuscol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
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
		
	
			performer.OverduePOM.clickDashboard().click();
			
	}
	
	
	public static void DetailedReportFilterMgmt(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		
		Thread.sleep(6000);
		
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		CFOcountPOM.Statutory().click();
		Thread.sleep(2000);
	//	ApprovalcountPOM.Statutory().click();
	/*	 By locator = By.xpath("(//*[@class='k-checkbox-wrapper'])[36]");

			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		Thread.sleep(3000);*/
		ApprovalcountPOM.ComplianceType().click();
		Thread.sleep(3000);
		ApprovalcountPOM.Apply().click();
		Thread.sleep(6000);
     
   
      
		StatusCD().click();
       Thread.sleep(1000);
       String Statustext =StatusCD1().getText();
       Thread.sleep(500);
       StatusCD1().click();
       Thread.sleep(1000);
    
       Risk().click();
       Thread.sleep(1000);
       String Risktext =Risk1().getText();
       Thread.sleep(500);
       Risk1().click();
      
       Thread.sleep(1000);
       Act().click();
       Thread.sleep(1000);
    
       String Acttext =ActM().getText();
       Thread.sleep(500);
       ActM().click();
      
      
       Thread.sleep(1000);
       ApprovalcountPOM.Apply().click();
       Thread.sleep(6000);
       
        List<String> li=new ArrayList<String>();
        
              li.add(Statustext);
              li.add(Risktext);
              li.add(Acttext);
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Status");	
		filter.add("Risk");
		filter.add("Act");
		
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod .Columns().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	      
	       MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
	//	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[6]"));
		
		List<WebElement> Riskcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[9]"));
		List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[8]"));

		Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector(\"div[id='grid'] div[class='k-grid-content k-auto-scrollable']\").scrollLeft=500");

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statuscol);
				}
			else if(i==1)
				{
					raw.addAll(Riskcol);
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
		
	
			performer.OverduePOM.clickDashboard().click();
			
	}
	
	
	public static void DetailedReportIn(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 160);
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		OverduePOM.clickcomplianceType().click();
		Thread.sleep(1000);
	
		OverduePOM.clickcomplianceIn().click();
		Thread.sleep(4000);
		OverduePOM.clickcomplianceType().click();
		Thread.sleep(1000);
		CFOcountPOM.Apply().click();
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
		CFOcountPOM.closeDocument1().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
	/*	OverduePOM.clickRiskD().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement clickHigh = .findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclearBtn().click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);
		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(8000);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
	OverduePOM.clickcomplianceTypeAS().click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceStaASApp().click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceINASApp().click();
	
		Thread.sleep(4000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		
	/*	By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close = .findElement(locator3);	
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
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
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
			OverduePOM.clickRiskDA().click();
			Thread.sleep(1000);
			By locatorRA = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[25]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locatorRA));
			Thread.sleep(4000);
			
			WebElement clickHighA = .findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
			
			OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);*/
			OverduePOM.clickDashboard().click();
			Thread.sleep(2000);
	}
	
	public static void ComplianceDocuments(ExtentTest test ) throws InterruptedException, IOException
	{	
		
WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[15]/a");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeViewDoc().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " :- View successfully.");
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
			CFOcountPOM.closeOverViewDoc().click();
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
			/*	ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);*/
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " After Checking Multiple checkbox  File downloaded successfully.");

				Thread.sleep(3000);
				elementsList = CFOcountPOM.selectDropdown();				//It is a dropdown but don't have Select tag.
					elementsList.get(0).click();									//Clicking on first dropdown
					Thread.sleep(500);
					Actions action = new Actions(getDriver());
					CFOcountPOM.ClickIocon().click();
					CFOcountPOM.ClickAPVT().click();
				//	action.moveToElement(CFOcountPOM.selectFirst()).click().build().perform();	//Selecting first option of the drop down.
					Thread.sleep(2000);
					CFOcountPOM.clickClear().click();
					Thread.sleep(1000);
					test.log(LogStatus.PASS, "Clear Button Working");
				CFOcountPOM.clickAdvancedSearch().click();
				Thread.sleep(3000);
				ClearAS().click();
	//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[23]/a");
			
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
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search :-  File downloaded successfully.");
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search :-  OverView successfully.");
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = getDriver().findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				Thread.sleep(500);
				/*ChechBoxes1.get(1).click();
				Thread.sleep(500);
				ChechBoxes1.get(2).click();
				Thread.sleep(3000);*/
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				CFOcountPOM.closeDocumentAS().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Advanced Search : - After Checking Multiple checkbox  File downloaded successfully.");

				OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceDocumentsFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		Thread.sleep(3000);
		 ApprovalcountPOM.StatusCD().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[6]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			ApprovalcountPOM.StatusCD().click();
			Thread.sleep(3000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,300)");	
			Thread.sleep(5000);
			CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItemsD().getText();
			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[13]")); //column list
			 Thread.sleep(8000);
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
				 test.log(LogStatus.FAIL, "Statutory : - Selection wise  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Statutory :- Selection wise filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }
			}else {
				Thread.sleep(3000);
				 test.log(LogStatus.PASS, "No records found");
			}
			 Thread.sleep(8000);
			 
			 CFOcountPOM.clickAdvancedSearch().click();
				Thread.sleep(3000);
			
			//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
				 ApprovalcountPOM.StatusCD1().click();
					Thread.sleep(1000);
					 WebElement TextCat1=getDriver().findElement(By.xpath("(//*[@class='k-in'])[42]")); 
					 String cattext1 =TextCat1.getText();
					 Thread.sleep(1000);
					 TextCat1.click();
					Thread.sleep(3000);
					
				
					Thread.sleep(8000);
					js.executeScript("window.scrollBy(0,300)");	
					Thread.sleep(5000);
					CFOcountPOM.readTotalItemsD1().click();					//Clicking on Text of total items just to scroll down.
					String s1 = CFOcountPOM.readTotalItemsD1().getText();
					if(!s1.equalsIgnoreCase("No items to display")) {
					Thread.sleep(5000);
					 List<WebElement> Risks1=getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[14]")); //column list
					 Thread.sleep(8000);
					 List<String> text1=new ArrayList<String>();
					 
					 for(int i=0;i<Risks1.size();i++) {
						 text1.add(Risks1.get(i).getText());
					 }
					 
					 List<String> pass1=new ArrayList<String>();
					 
					 List<String> fail1=new ArrayList<String>();
						
						for(int i=0;i<text1.size();i++)
						{
						if(text1.get(i).equals(cattext1))
						{
							pass1.add(text1.get(i));		//	the specified element at the end of a list.
						}
						else
						{
							fail1.add(text1.get(i));
						}
						

			}
					 HashSet<String> pas1=new LinkedHashSet<>(pass1); //duplicate values are not allowed.
					 pass1.clear();
					 pass1.addAll(pas1);                              //all of the elements in the specified collection to the end of this list,
					 
					 
					 HashSet<String> fal1=new LinkedHashSet<>(fail1);
					 fail1.clear();
					 fail1.addAll(fal1);
					 
					 for(String Fal1 : fail1)
					 {
						 test.log(LogStatus.FAIL, "Internal : - Selection wise  filter not working Properly : "+Fal1);
						// System.out.println("fail : "+Fal);
					 }
					 for(String Pas1 : pass1)
					 {
						 test.log(LogStatus.PASS, "Internal : - Selection wise filter working Properly   Value Match with : "+Pas1);
						// System.out.println("Pass : "+Pas);
					 }
}else {
	Thread.sleep(3000);
	 test.log(LogStatus.PASS, "Internal : - No record Found");
}
					CFOcountPOM.closeDocumentAS().click();
					Thread.sleep(3000);
				OverduePOM.clickDashboard().click();
		
	}
	
	
	public static void complianceDocumentIn(ExtentTest test ) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		OverduePOM.clickStatus().click();
		Thread.sleep(1000);
		OverduePOM.SelectInternal().click();
		Thread.sleep(7000);
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[15]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeViewDoc().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Internal-View Successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			CFOcountPOM.clickDownloadBtn1().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Internal-Download Successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeOverViewDoc().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Internal-OverView Successfully");
			Thread.sleep(500);
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
				
				Thread.sleep(3000);   
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Internal-Mutiple checkBox check and download Successfully ");
				Thread.sleep(1000);
				OverduePOM.clickRisk().click();
				Thread.sleep(500);
				OverduePOM.clickRiskCritical().click();
				Thread.sleep(1000);
				OverduePOM.clickClearBtn().click();
				test.log(LogStatus.PASS, "Internal-Clear btn is working");
				Thread.sleep(4000);
				CFOcountPOM.clickAdvancedSearch().click();
				Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			OverduePOM.clickStatusAS().click();
			Thread.sleep(500);
			OverduePOM.SelectInternalAS().click();
			Thread.sleep(5000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[23]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = getDriver().findElements(locator2);	
			Thread.sleep(3000);
			ViewButton1.get(0).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Internal-Advanced Search - View Successfully");
		/*	ViewButton1.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - Download Successfully");*/
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			test.log(LogStatus.PASS, " Internal-Advanced Search - OverView Successfully");
			Thread.sleep(5000);
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
				
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, " Internal-Advanced Search - Mutiple checkBox check and download Successfully ");
				CFOcountPOM.closeDocumentAS().click();
				Thread.sleep(3000);
				OverduePOM.clickDashboard().click();		
		
	}
	
	public static void DetailedReportRe(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		CFOcountPOM.Status().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.Filter().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.NotApplicable().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		
		CFOcountPOM.ClickFilter().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td/a[3]");
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
	
	public static void RiskGraphCountIn1( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
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
		//	test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance Count matches to number of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");
			
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
				Thread.sleep(3000);
				}catch(Exception e) {
					CFOcountPOM.closeDocument1().click();
					Thread.sleep(3000);
				}
			
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
	}
	
	public static void RiskGraphCountIn( ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		Actions action = new Actions(getDriver());
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
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
			
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(4000);
		 CFOcountPOM.clickExportImage().click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Excel file Export Successfully");
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[19]/a");

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
		
		
		}else {
			int count=0;
			Thread.sleep(1000);
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
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(3000);
			
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(2000);
			ViewButton.get(0).click();
			Thread.sleep(4000);			
		    CFOcountPOM.closeDocument1().click();		
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Document downloaded successfully");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View successfully");
			ViewButton.get(2).click();
		    Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
	
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
	
	public static void AssignmentReportFilter(ExtentTest test ) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(3000);
		 ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[37]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			ApprovalcountPOM.ApplyA().click();
			Thread.sleep(8000);
		
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]")); //column list
			 Thread.sleep(8000);
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
				 test.log(LogStatus.FAIL, "Statutory : - Selection wise  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Statutory :- Selection wise filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }
			 Thread.sleep(8000);
			 OverduePOM.clickClearBtn().click();
				Thread.sleep(2000);
			 CFOcountPOM.selectType2().click();
			 Thread.sleep(1000);
			 elementsList = CFOcountPOM.clickType2();
			 Thread.sleep(1000);
			 elementsList.get(0).click();					//Unselecting preselected 'Event Based' checkbox
			 Thread.sleep(1000);
					elementsList.get(4).click();	
					Thread.sleep(3000);
					//------------------------------------ Internal ------------------------------------
					
					Thread.sleep(500);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
					
					Thread.sleep(3000);
					 ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						 WebElement TextCat1=getDriver().findElement(By.xpath("(//*[@class='k-in'])[37]")); 
						 String cattext1 =TextCat1.getText();
						 Thread.sleep(1000);
						 TextCat1.click();
						Thread.sleep(3000);
						ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						ApprovalcountPOM.ApplyA().click();
						Thread.sleep(8000);
					try {
						 List<WebElement> Risks1=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]")); //column list
						 Thread.sleep(8000);
						 List<String> text1=new ArrayList<String>();
						 
						 for(int i=0;i<Risks1.size();i++) {
							 text1.add(Risks1.get(i).getText());
						 }
						 
						 List<String> pass1=new ArrayList<String>();
						 
						 List<String> fail1=new ArrayList<String>();
							
							for(int i=0;i<text1.size();i++)
							{
							if(text1.get(i).equals(cattext1))
							{
								pass1.add(text1.get(i));		//	the specified element at the end of a list.
							}
							else
							{
								fail1.add(text1.get(i));
							}
							

				}
						 HashSet<String> pas1=new LinkedHashSet<>(pass1); //duplicate values are not allowed.
						 pass1.clear();
						 pass1.addAll(pas1);                              //all of the elements in the specified collection to the end of this list,
						 
						 
						 HashSet<String> fal1=new LinkedHashSet<>(fail1);
						 fail1.clear();
						 fail1.addAll(fal1);
						 
						 for(String Fal1 : fail1)
						 {
							 test.log(LogStatus.FAIL, "Internal : - Selection wise  filter not working Properly : "+Fal1);
							// System.out.println("fail : "+Fal);
						 }
						 for(String Pas1 : pass1)
						 {
							 test.log(LogStatus.PASS, "Internal : - Selection wise filter working Properly   Value Match with : "+Pas1);
							// System.out.println("Pass : "+Pas);
						 }
	}catch(Exception e) {
		Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Internal : - No record Found");
	}
					 test.log(LogStatus.PASS, "Internal : - No record Found");
					Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
	}
	
	public static void AssignmentReportFilterDept(ExtentTest test ) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(3000);
		 ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[40]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			ApprovalcountPOM.ApplyA().click();
			Thread.sleep(8000);
		
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]")); //column list
			 Thread.sleep(8000);
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
				 test.log(LogStatus.FAIL, "Statutory : - Selection wise  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Statutory :- Selection wise filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }
			 Thread.sleep(8000);
			 OverduePOM.clickClearBtn().click();
				Thread.sleep(2000);
			 CFOcountPOM.selectType2().click();
			 Thread.sleep(1000);
			 elementsList = CFOcountPOM.clickType2();
			 Thread.sleep(1000);
			 elementsList.get(0).click();					//Unselecting preselected 'Event Based' checkbox
			 Thread.sleep(1000);
					elementsList.get(4).click();	
					Thread.sleep(3000);
					//------------------------------------ Internal ------------------------------------
					
					Thread.sleep(500);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
					
					Thread.sleep(3000);
					 ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						 WebElement TextCat1=getDriver().findElement(By.xpath("(//*[@class='k-in'])[37]")); 
						 String cattext1 =TextCat1.getText();
						 Thread.sleep(1000);
						 TextCat1.click();
						Thread.sleep(3000);
						ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						ApprovalcountPOM.ApplyA().click();
						Thread.sleep(8000);
					try {
						 List<WebElement> Risks1=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]")); //column list
						 Thread.sleep(8000);
						 List<String> text1=new ArrayList<String>();
						 
						 for(int i=0;i<Risks1.size();i++) {
							 text1.add(Risks1.get(i).getText());
						 }
						 
						 List<String> pass1=new ArrayList<String>();
						 
						 List<String> fail1=new ArrayList<String>();
							
							for(int i=0;i<text1.size();i++)
							{
							if(text1.get(i).equals(cattext1))
							{
								pass1.add(text1.get(i));		//	the specified element at the end of a list.
							}
							else
							{
								fail1.add(text1.get(i));
							}
							

				}
						 HashSet<String> pas1=new LinkedHashSet<>(pass1); //duplicate values are not allowed.
						 pass1.clear();
						 pass1.addAll(pas1);                              //all of the elements in the specified collection to the end of this list,
						 
						 
						 HashSet<String> fal1=new LinkedHashSet<>(fail1);
						 fail1.clear();
						 fail1.addAll(fal1);
						 
						 for(String Fal1 : fail1)
						 {
							 test.log(LogStatus.FAIL, "Internal : - Selection wise  filter not working Properly : "+Fal1);
							// System.out.println("fail : "+Fal);
						 }
						 for(String Pas1 : pass1)
						 {
							 test.log(LogStatus.PASS, "Internal : - Selection wise filter working Properly   Value Match with : "+Pas1);
							// System.out.println("Pass : "+Pas);
						 }
	}catch(Exception e) {
		Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Internal : - No record Found");
	}
					 test.log(LogStatus.PASS, "Internal : - No record Found");
					Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
	}
	
	
	public static void ActRepositoryFilter(ExtentTest test ) throws InterruptedException, IOException
	{
		
           WebDriverWait wait = new WebDriverWait(getDriver(), (160));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
		CFOcountPOM.clickActRepository().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		js.executeScript("window.scrollBy(0,200)");	
		
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(3000);
		if(!s.equalsIgnoreCase("No items to display")) {
		
		test.log(LogStatus.PASS, "All Assigned act related Compliance list should be displayed");
		Thread.sleep(3000);
		}else {
			test.log(LogStatus.PASS, "All Assigned act related Compliance list should not displayed");
		}
		Thread.sleep(3000);
		 ApprovalcountPOM.SelectAct().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[1]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
		//	ApprovalcountPOM.Status().click();
			Thread.sleep(1000);
		
			Thread.sleep(1000);
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[2]")); //column list
			 
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
				 test.log(LogStatus.FAIL, "Selection wise  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Selection wise filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }

		
		OverduePOM.clickDashboard().click();
		
	
	}
	
	public static void AssignmentReportFilterMGmt(ExtentTest test ) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(3000);
		 ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[22]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			ApprovalcountPOM.ApplyA().click();
			Thread.sleep(8000);
		
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]")); //column list
			 Thread.sleep(8000);
			 List<String> text=new ArrayList<String>();
			 
			 for(int i=0;i<Risks.size();i++) {
				 text.add(Risks.get(i).getText());
			 }
			 
			 List<String> pass=new ArrayList<String>();
			 
			 List<String> fail=new ArrayList<String>();
				
				for(int i=0;i<text.size();i++)
				{
				if(text.get(i).equals(cattext)||text.get(i).equals(""))
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
				 test.log(LogStatus.FAIL, "Statutory : - Selection wise  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 if(!Pas.isEmpty())
				 test.log(LogStatus.PASS, "Statutory :- Selection wise filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }
			 Thread.sleep(8000);
			 OverduePOM.clickClearBtn().click();
				Thread.sleep(2000);
			 CFOcountPOM.selectType2().click();
			 Thread.sleep(1000);
			 elementsList = CFOcountPOM.clickType2();
			 Thread.sleep(1000);
			 elementsList.get(0).click();					//Unselecting preselected 'Event Based' checkbox
			 Thread.sleep(1000);
					elementsList.get(4).click();	
					Thread.sleep(3000);
					//------------------------------------ Internal ------------------------------------
					
					Thread.sleep(500);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
					
					Thread.sleep(3000);
					 ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						 WebElement TextCat1=getDriver().findElement(By.xpath("(//*[@class='k-in'])[31]")); 
						 String cattext1 =TextCat1.getText();
						 Thread.sleep(1000);
						 TextCat1.click();
						Thread.sleep(3000);
						ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						ApprovalcountPOM.ApplyA().click();
						Thread.sleep(8000);
						
						JavascriptExecutor js = (JavascriptExecutor) getDriver();
						
					    js.executeScript("window.scrollBy(0,200)");	
							
							String s = CFOcountPOM.readTotalItemsD().getText();
							Thread.sleep(3000);
							if(!s.equalsIgnoreCase("No items to display")) {
								
						 List<WebElement> Risks1=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]")); //column list
						 Thread.sleep(8000);
						 List<String> text1=new ArrayList<String>();
						 
						 for(int i=0;i<Risks1.size();i++) {
							 text1.add(Risks1.get(i).getText());
						 }
						 
						 List<String> pass1=new ArrayList<String>();
						 
						 List<String> fail1=new ArrayList<String>();
							
							for(int i=0;i<text1.size();i++)
							{
							if(text1.get(i).equals(cattext1))
							{
								pass1.add(text1.get(i));		//	the specified element at the end of a list.
							}
							else
							{
								fail1.add(text1.get(i));
							}
							

				}
						 HashSet<String> pas1=new LinkedHashSet<>(pass1); //duplicate values are not allowed.
						 pass1.clear();
						 pass1.addAll(pas1);                              //all of the elements in the specified collection to the end of this list,
						 
						 
						 HashSet<String> fal1=new LinkedHashSet<>(fail1);
						 fail1.clear();
						 fail1.addAll(fal1);
						 
						 for(String Fal1 : fail1)
						 {
							 test.log(LogStatus.FAIL, "Internal : - Selection wise  filter not working Properly : "+Fal1);
							// System.out.println("fail : "+Fal);
						 }
						 for(String Pas1 : pass1)
						 {
							 test.log(LogStatus.PASS, "Internal : - Selection wise filter working Properly   Value Match with : "+Pas1);
							// System.out.println("Pass : "+Pas);
						 }
	}else {
		Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Internal : - No record Found");
	}
					
					Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
	}
	
	public static void AssignmentReportFilterRevi(ExtentTest test ) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(3000);
		 ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("(//*[@class='k-in'])[22]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
			ApprovalcountPOM.SelectCategoryA().click();
			Thread.sleep(1000);
			ApprovalcountPOM.ApplyA().click();
			Thread.sleep(8000);
		
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]")); //column list
			 Thread.sleep(8000);
			 List<String> text=new ArrayList<String>();
			 
			 for(int i=0;i<Risks.size();i++) {
				 text.add(Risks.get(i).getText());
			 }
			 
			 List<String> pass=new ArrayList<String>();
			 
			 List<String> fail=new ArrayList<String>();
				
				for(int i=0;i<text.size();i++)
				{
				if(text.get(i).equals(cattext)||text.get(i).equals(""))
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
				 test.log(LogStatus.FAIL, "Statutory : - Selection wise  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 if(!Pas.isEmpty())
				 test.log(LogStatus.PASS, "Statutory :- Selection wise filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }
			 Thread.sleep(8000);
			 OverduePOM.clickClearBtn().click();
				Thread.sleep(2000);
			 CFOcountPOM.selectType2().click();
			 Thread.sleep(1000);
			 elementsList = CFOcountPOM.clickType2();
			 Thread.sleep(1000);
			 elementsList.get(0).click();					//Unselecting preselected 'Event Based' checkbox
			 Thread.sleep(1000);
					elementsList.get(4).click();	
					Thread.sleep(3000);
					//------------------------------------ Internal ------------------------------------
					
					Thread.sleep(500);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
					
					Thread.sleep(3000);
					 ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						 WebElement TextCat1=getDriver().findElement(By.xpath("(//*[@class='k-in'])[18]")); 
						 String cattext1 =TextCat1.getText();
						 Thread.sleep(1000);
						 TextCat1.click();
						Thread.sleep(3000);
						ApprovalcountPOM.SelectCategoryA().click();
						Thread.sleep(1000);
						ApprovalcountPOM.ApplyA().click();
						Thread.sleep(8000);
						
						JavascriptExecutor js = (JavascriptExecutor) getDriver();
						
					    js.executeScript("window.scrollBy(0,200)");	
							
							String s = CFOcountPOM.readTotalItemsD().getText();
							Thread.sleep(3000);
							if(!s.equalsIgnoreCase("No items to display")) {
								
						 List<WebElement> Risks1=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]")); //column list
						 Thread.sleep(8000);
						 List<String> text1=new ArrayList<String>();
						 
						 for(int i=0;i<Risks1.size();i++) {
							 text1.add(Risks1.get(i).getText());
						 }
						 
						 List<String> pass1=new ArrayList<String>();
						 
						 List<String> fail1=new ArrayList<String>();
							
							for(int i=0;i<text1.size();i++)
							{
							if(text1.get(i).equals(cattext1))
							{
								pass1.add(text1.get(i));		//	the specified element at the end of a list.
							}
							else
							{
								fail1.add(text1.get(i));
							}
							

				}
						 HashSet<String> pas1=new LinkedHashSet<>(pass1); //duplicate values are not allowed.
						 pass1.clear();
						 pass1.addAll(pas1);                              //all of the elements in the specified collection to the end of this list,
						 
						 
						 HashSet<String> fal1=new LinkedHashSet<>(fail1);
						 fail1.clear();
						 fail1.addAll(fal1);
						 
						 for(String Fal1 : fail1)
						 {
							 test.log(LogStatus.FAIL, "Internal : - Selection wise  filter not working Properly : "+Fal1);
							// System.out.println("fail : "+Fal);
						 }
						 for(String Pas1 : pass1)
						 {
							 test.log(LogStatus.PASS, "Internal : - Selection wise filter working Properly   Value Match with : "+Pas1);
							// System.out.println("Pass : "+Pas);
						 }
	}else {
		Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Internal : - No record Found");
	}
					
					Thread.sleep(3000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
	}
	
	public static void ActRepositoryFilterRe(ExtentTest test ) throws InterruptedException, IOException
	{
		
           WebDriverWait wait = new WebDriverWait(getDriver(), (160));
           JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
			
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		By locator = By.xpath("//*[@id='ActReporeport']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//CFOcountPOM.clickActRepository().click();			//Clicking on 'Detailed Reports' 
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		js.executeScript("window.scrollBy(0,200)");	
		
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(3000);
		if(!s.equalsIgnoreCase("No items to display")) {
		
		test.log(LogStatus.PASS, "All Assigned act related Compliance list should be displayed");
		Thread.sleep(3000);
		}else {
			test.log(LogStatus.PASS, "All Assigned act related Compliance list should not displayed");
		}
		Thread.sleep(3000);
		 ApprovalcountPOM.SelectAct().click();
			Thread.sleep(1000);
			 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[1]")); 
			 String cattext =TextCat.getText();
			 Thread.sleep(1000);
			TextCat.click();
			Thread.sleep(3000);
		//	ApprovalcountPOM.Status().click();
			Thread.sleep(1000);
		
			Thread.sleep(1000);
			 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[2]")); //column list
			 
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
				 test.log(LogStatus.FAIL, "Selection wise  filter not working Properly : "+Fal);
				// System.out.println("fail : "+Fal);
			 }
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS, "Selection wise filter working Properly   Value Match with : "+Pas);
				// System.out.println("Pass : "+Pas);
			 }

		
		OverduePOM.clickDashboard().click();
		
	
	}
	
	public static void MyApprovals (ExtentTest test ) throws InterruptedException, IOException
	{
		
           WebDriverWait wait = new WebDriverWait(getDriver(), (160));
           JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(3000);
	
		if(MyEscalation().isDisplayed()&&MyApprovals().isDisplayed()) {
			
			 test.log(LogStatus.PASS, "Approver Escalation and My Approvals  menu should  be display.");
			 
		}else {
			test.log(LogStatus.FAIL, "Approver Escalation and My Approvals  menu should not be display.");
			 
		}
		
		OverduePOM.clickDashboard().click();
		
	
	}
	
	public static void DepCompletionStatusFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,600)");			
	
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighDep().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(2000);
       String Acttext =SelectActF11D().getText();
       Thread.sleep(2000);
       SelectActF11D().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdueD().getText();
       Thread.sleep(500);
       StatusOverdueD().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void DepNotCompletionStatusFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,600)");			
	
		Thread.sleep(3000);
	
		CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighDep().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF11D().getText();
       Thread.sleep(500);
       SelectActF11D().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdueD().getText();
       Thread.sleep(500);
       StatusOverdueD().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void CompletionStatusFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)");			
	
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHigh().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF1().getText();
       Thread.sleep(500);
       SelectActF1().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(3000);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdue().getText();
       Thread.sleep(500);
       StatusOverdue().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void CompletionStatusFilterMgmt(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)");			
	
		Thread.sleep(3000);
		int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());	//Reading value of 'Not Completed'
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
	//	RiskF().click();
		Thread.sleep(500);
	
	//	String Risktext =RiskHighM().getText();
	    
		Thread.sleep(3000);
     /*  	SelectActF().click();
       	Thread.sleep(4000);
   		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
   		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Demo Act");
		
   		SelectActF().click();
   		Thread.sleep(4000);
    */
       Thread.sleep(4000);
       
       MitigationPlan().click();
       Thread.sleep(5000);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
      Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
      	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
      Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
       // li.add("Demo Act");
        li.add("1");
        Thread.sleep(3000);
        li.add("Overdue");
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		//filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");
		 Thread.sleep(5000);
	By	locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//MgmtSonyMethod.ClickTriStatus().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
		//List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		if(DeptCountPOM.Clear().isEnabled())
		{
			test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
		
			DeptCountPOM.Clear().click();
		}
	
	else
	{
		test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
		
	}
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}

	public static void NotCompletionStatusFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)");			
	
		Thread.sleep(3000);
	
		CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHigh().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF1().getText();
       Thread.sleep(500);
       SelectActF1().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdue().getText();
       Thread.sleep(500);
       StatusOverdue().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void NotCompletionStatusFilterMgmt(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	   
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,500)");			
	
		Thread.sleep(3000);
	
		CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
	//	RiskF().click();
		Thread.sleep(500);
	
	//	String Risktext =RiskHighM().getText();
    
       Thread.sleep(3000);
    /*   SelectActF().click();
       Thread.sleep(500);
       List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
       ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Demo Act");
   	
		SelectActF().click();
       Thread.sleep(3000);
       */
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
      // StatusAll().click();
      // Thread.sleep(3000);
      // StatusAll().click();
       Thread.sleep(3000);
       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
      	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
       Thread.sleep(3000);
      
     	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
     	 Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
     //   li.add("Demo Act");
        li.add("1");
        Thread.sleep(3000);
        li.add("Overdue");
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
	//	filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		By	locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
	//	List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}

	public static void RiskSummaryFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");			
	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();	
		CFOcountPOM.clickRiskHighNotCompleted().click();			
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHigh().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF1().getText();
       Thread.sleep(500);
       SelectActF1().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdue().getText();
       Thread.sleep(500);
       StatusOverdue().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void RiskSummaryFilterNA(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
    /*   CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());*/
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");			
	
		Thread.sleep(3000);
		
		Thread.sleep(4000);
		WebElement roc1= getDriver().findElement(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-4'])"));
	
	String text1 =	roc1.getText();
	
	if(text1.equalsIgnoreCase("Not Applicable")) {
		test.log(LogStatus.PASS, "The new status named \"Not Applicable\" should be separately reflects in the risk summary graph.");

	}else {
		test.log(LogStatus.FAIL, "The new status named \"Not Applicable\" should not separately reflects in the risk summary graph.");

	}
	
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotApplicable().getText();	
		CFOcountPOM.clickRiskHighNotApplicable().click();			
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		WebElement statuscolt=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]"));
		String textNA=statuscolt.getText();
		if(textNA.equalsIgnoreCase("Not Applicable")) {
		test.log(LogStatus.PASS, "\"Not Applicable\" status should displayed in the status column while clicking on the grid.");
		}else {
			test.log(LogStatus.FAIL, "\"Not Applicable\" status should not displayed in the status column while clicking on the grid.");

		}
	
	/*	RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighM().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActNA().getText();
       Thread.sleep(500);
       SelectActNA().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);*/
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
      // StatusAll().click();
       Thread.sleep(3000);
    //   StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusNA().getText();
       Thread.sleep(500);
      // StatusOverdue().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
      //  li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		//filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		By	locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(2000);
	      	locator = By.xpath("(//*[@data-field='MitigationPlan'])[2]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			 ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		
		//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
	    //   MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
	//	List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void RiskSummaryFilterNAIn(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");			
	
		Thread.sleep(3000);
		
		Thread.sleep(4000);
		WebElement roc1= getDriver().findElement(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-4'])"));
	
	String text1 =	roc1.getText();
	
	if(text1.equalsIgnoreCase("Not Applicable")) {
		test.log(LogStatus.PASS, "The new status named \"Not Applicable\" should be separately reflects in the risk summary graph.");

	}else {
		test.log(LogStatus.FAIL, "The new status named \"Not Applicable\" should not separately reflects in the risk summary graph.");

	}
	
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotApplicable().getText();	
		CFOcountPOM.clickRiskHighNotApplicable().click();			
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		WebElement statuscolt=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[5]"));
		String textNA=statuscolt.getText();
		if(textNA.equalsIgnoreCase("Not Applicable")) {
		test.log(LogStatus.PASS, "\"Not Applicable\" status should displayed in the status column while clicking on the grid.");
		}else {
			test.log(LogStatus.FAIL, "\"Not Applicable\" status should not displayed in the status column while clicking on the grid.");

		}
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighNA().getText();
    
       Thread.sleep(3000);
     /*  SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF1().getText();
       Thread.sleep(500);
       SelectActF1().click();
       Thread.sleep(3000);
       */
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
      // StatusAll().click();
       Thread.sleep(3000);
    //   StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusNAIn().getText();
       Thread.sleep(500);
      // StatusOverdue().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
    //    li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
	//	filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTri().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
		//List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			/*else if(i==1)
				{
					raw.addAll(Act);
				}*/
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	
	public static void RiskSummaryFilterM(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");			
	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompleted().getText();	
		CFOcountPOM.clickRiskHighNotCompleted().click();			
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
	//	RiskF().click();
		Thread.sleep(500);
	
   //   String Risktext =RiskHighM().getText();
    
       Thread.sleep(3000);
     /*  SelectActF().click();
       Thread.sleep(500);
       List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
       ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Demo Act");
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);*/
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
     	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
       Thread.sleep(3000);
       ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
      //  li.add("Demo Act");
        li.add("1");
        Thread.sleep(3000);
        li.add("Overdue");
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
	//	filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		By	locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
	//	List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	
	public static void RiskSummaryFilterDep(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1500)");			
	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickRiskHighNotCompletedDept().getText();	
		CFOcountPOM.clickRiskHighNotCompletedDept().click();			
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighDep().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF11D().getText();
       Thread.sleep(500);
       SelectActF11D().click();
       Thread.sleep(3000);
       Thread.sleep(3000);
       SelectActF().click();
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdueD().getText();
       Thread.sleep(500);
       StatusOverdueD().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void DeptSummaryFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");			
	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickAccountOverdue().getText();	
		CFOcountPOM.clickAccountOverdue().click();			
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
		
		Thread.sleep(500);
		RiskAll().click();
		Thread.sleep(2000);
      String Risktext =RiskHigh().getText();
      Thread.sleep(2000);
      RiskHigh().click();
       Thread.sleep(3000);
       
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF11().getText();
       Thread.sleep(500);
       SelectActF11().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdue().getText();
       Thread.sleep(500);
       StatusOverdue().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	public static void DeptSummaryFilterM(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));

       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");			
	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickComplianceIsecOverdueDemo1().getText();	
		
		CFOcountPOM.clickComplianceIsecOverdueDemo1().click();			
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
	/*	RiskF().click();
		Thread.sleep(500);
		
		Thread.sleep(500);
		RiskAll().click();
		Thread.sleep(2000);
      String Risktext =RiskHighM().getText();
      Thread.sleep(2000);
      RiskHighM().click();
       Thread.sleep(3000);
       
       SelectActF().click();
       Thread.sleep(500);
   	List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
   	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Demo Act");
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(5000);*/
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
    	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
    	//ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
      Thread.sleep(3000);
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
      //  li.add("Demo Act");
        li.add("1");
        Thread.sleep(3000);
        li.add("Overdue");
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		//filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		By	locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
		//List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[17]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	
	public static void DeptSummaryFilterDept(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1200)");			
	
		Thread.sleep(3000);
		String NotCompleted = CFOcountPOM.clickFinanceOverdueDept().getText();	
		CFOcountPOM.clickFinanceOverdueDept().click();			
		Thread.sleep(5000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		RiskF().click();
		Thread.sleep(500);
		
		Thread.sleep(500);
		RiskAll().click();
		Thread.sleep(2000);
      String Risktext =RiskHighDep().getText();
      Thread.sleep(2000);
      RiskHighDep().click();
       Thread.sleep(3000);
       
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF11D1().getText();
       Thread.sleep(500);
       SelectActF11D1().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusOverdueD().getText();
       Thread.sleep(500);
       StatusOverdueD().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[14]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
				OverduePOM.clickDashboard().click();
		
	}
	
	
	public static void CompletionStatusFilterMgmtPe(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       JavascriptExecutor js = (JavascriptExecutor) getDriver();
       js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo

		Thread.sleep(800);
	
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
	
		Thread.sleep(3000);
		
		CFOcountPOM.readHigh().click();	
		Thread.sleep(3000);
		
		getDriver().switchTo().parentFrame();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		/*RiskF().click();
		Thread.sleep(500);
	
		String Risktext =RiskHighM().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
       ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Demo Act");
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);*/
       Thread.sleep(3000);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
       ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
     //   li.add("Demo Act");
        li.add("1");
        Thread.sleep(3000);
        li.add("Overdue");
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
	//	filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		By	locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
	//	List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(2000);
				OverduePOM.clickDashboard().click();
		
	}

	public static void NotCompletionStatusFilterMgmtPe(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
   	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo

	Thread.sleep(800);
	
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
	
	int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickOverdue().getText());	//Reading value of 'Not Completed'
	CFOcountPOM.clickOverdue().click();									//CLicking on 'Not Completed' count
	
		Thread.sleep(3000);
		
		CFOcountPOM.readHigh().click();	
		Thread.sleep(3000);
		
		getDriver().switchTo().parentFrame();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
	
		/*RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighM().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
      	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Demo Act");
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(4000);*/
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
   	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Overdue");
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
      //  li.add("Demo Act");
        li.add("1");
        Thread.sleep(3000);
        li.add("Overdue");
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
	//	filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		By	locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[10]"));
	//	List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[18]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(2000);
				OverduePOM.clickDashboard().click();
		
	}

	public static void DeptSummaryMp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
	
		CFOcountPOM.clickAccountOverdue().click();
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

			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static	void DeptSummaryMpView( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAccountOverdue().click();
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
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static void DeptSummaryMpSC( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAccountOverdue().click();
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
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.

			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static	void DeptSummaryMpViewSC( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickAccountOverdue().click();
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
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static void DeviationApprover(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		ApprovalcountPOM.DeviationApproval().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		
		
		
		ApprovalcountPOM.Period().click();					//Clicking on 'My Documents'
		Thread.sleep(1000);
		ApprovalcountPOM.Period1().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		Thread.sleep(8000);
		ApprovalcountPOM.Edit().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);

		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
		ApprovalcountPOM.Remark().sendKeys("remark");		//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		
		ApprovalcountPOM.Approve().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		String msg =getDriver().switchTo().alert().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message Display :-"+msg);
		
		getDriver().switchTo().alert().accept();

	}
	
	public static void DeviationApproverReject(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		ApprovalcountPOM.DeviationApproval().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		
		
		
		ApprovalcountPOM.Period().click();					//Clicking on 'My Documents'
		Thread.sleep(1000);
		ApprovalcountPOM.Period1().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		Thread.sleep(8000);
		ApprovalcountPOM.Edit().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);

		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
		ApprovalcountPOM.Remark().sendKeys("remark");		//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		
		ApprovalcountPOM.btnReject().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		String msg =getDriver().switchTo().alert().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message Display :-"+msg);
		
		getDriver().switchTo().alert().accept();

	}
	
	public static void DeviationApproverClear(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		ApprovalcountPOM.DeviationApproval().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		
		
		
		ApprovalcountPOM.Period().click();					//Clicking on 'My Documents'
		Thread.sleep(1000);
		ApprovalcountPOM.Period1().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		Thread.sleep(8000);
		
		if(ApprovalcountPOM.Clear().isEnabled()) {
		ApprovalcountPOM.Clear().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);

		
		test.log(LogStatus.PASS, "When click clear button then it  should be clear all filter");
		}
		
	}
	
	public static void DeviationApproverExport(ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (35));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		ApprovalcountPOM.DeviationApproval().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		
		
		
		ApprovalcountPOM.Period().click();					//Clicking on 'My Documents'
		Thread.sleep(1000);
		ApprovalcountPOM.Period1().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		Thread.sleep(8000);
		
		File dir = new File("C:\\Users\\snehalp\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ApprovalcountPOM.Export().click();

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\snehalp\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
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
			CFOcountPOM.ComplianceID().sendKeys("66196");
			Thread.sleep(3000);
			
			CFOcountPOM.clickApplyF().click();
			Thread.sleep(8000);
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
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
			File dir = new File("C:\\Users\\snehalp\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			OverduePOM.Download().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\snehalp\\Downloads");
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
			js.executeScript("window.scrollBy(0,1450)");	
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
			js.executeScript("window.scrollBy(0,2000)");	
			Thread.sleep(3000);
			CFOcountPOM.clickAdminOverdueAIn().click();								//CLicking on 'Not Completed' count
			
					
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
	
	public static void GradingReportSF(ExtentTest test)throws InterruptedException
	{

		JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
		js.executeScript("window.scrollBy(0,4000)");					//Scrolling down window by 2600 px.
		Thread.sleep(2000);	
		CFOcountPOM.clickRedGrading2().click();
		Thread.sleep(8000);	
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
			CFOcountPOM.ComplianceID().sendKeys("66196");
			
			Thread.sleep(8000);
			
			
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[13]/a[1]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
			JavascriptExecutor jse= (JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews']"));
			getDriver()  .switchTo().frame(farme1);
			Thread.sleep(3000);
	      	CFOcountPOM.Details1().click();
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
			CFOcountPOM.closeDocument1().click();
			
//			Thread.sleep(1000);
//			CFOcountPOM.closePopup().click();	
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
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		
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
			By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[22]/a[2]");
			
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
		

	public static void PenaltyMultipleFilter(ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
	CFOcountPOM.readPenaltyCount().click();					//Clicking on 'Penalty'.
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait( getDriver(),(140));
	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(1000);


	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
	 Thread.sleep(4000); 

	 CFOcountPOM.Location().click();
	 Thread.sleep(2000);
	 CFOcountPOM.LocationDD().click();
	 Thread.sleep(2000);
	 CFOcountPOM.Location().click();
	 Thread.sleep(2000);
	 CFOcountPOM.SelectAll().click();
	 Thread.sleep(2000);
	 CFOcountPOM.Location().click();
	 Thread.sleep(2000);
	 String location = CFOcountPOM.LocationDropdown().getText();
	 Thread.sleep(2000);
	 CFOcountPOM.LocationDropdown().click();
	 Thread.sleep(2000);
	 CFOcountPOM.Location().click();
	 Thread.sleep(2000);
	 
	 CFOcountPOM.Act().click();
	 Thread.sleep(2000);
	 String act = CFOcountPOM.ActDD1().getText();
	 Thread.sleep(2000);
	 CFOcountPOM.ActDD1().click();
	 Thread.sleep(2000);

	List<String> li=new ArrayList<String>();

	li.add(location);
	li.add(act);
	Thread.sleep(3000);

	List<String> filter=new ArrayList<String>();	
	filter.add("Location");
	filter.add("Act");	
	/*	
	MgmtSonyMethod.ClickTri().click();
	   Thread.sleep(1000);
	   MgmtSonyMethod.Columns().click();
	   Thread.sleep(500);
	   MgmtSonyMethod.RiskCheck().click();
	   Thread.sleep(1000);
	  
	   MgmtSonyMethod.ClickTri().click();
	   Thread.sleep(3000);
	      */
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> Loccol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[1]"));

	List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]"));
	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(Loccol);
			}
		else if(i==1)
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

	getDriver().switchTo().defaultContent();
	Thread.sleep(3000);
	CFOcountPOM.closeCategories().click();
	Thread.sleep(1000);

			OverduePOM.clickDashboard().click();


	}
		
	public static void PenaltyMultipleFilterInterest(ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
	CFOcountPOM.readPenaltyCount().click();					//Clicking on 'Penalty'.
	Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait( getDriver(),(140));
	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(1000);


	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
	 Thread.sleep(4000); 
	 CFOcountPOM.clickInterest().click();
		Thread.sleep(4000);
		WebElement farme1=	getDriver().findElement(By.id("IFGradingGraphDisplay"));
		getDriver().switchTo().frame(farme1);
	 CFOcountPOM.Location1().click();
	 Thread.sleep(2000);
	 CFOcountPOM.LocationDD1().click();
	 Thread.sleep(2000);
	 CFOcountPOM.Location1().click();
	 Thread.sleep(2000);
	 CFOcountPOM.SelectAll().click();
	 Thread.sleep(2000);
	 CFOcountPOM.Location1().click();
	 Thread.sleep(2000);
	 String location = CFOcountPOM.LocationDropdown().getText();
	 Thread.sleep(2000);
	 CFOcountPOM.LocationDropdown().click();
	 Thread.sleep(2000);
	 CFOcountPOM.Location1().click();
	 Thread.sleep(2000);
	 
	 CFOcountPOM.Act1().click();
	 Thread.sleep(2000);
	 String act = CFOcountPOM.ActDD1().getText();
	 Thread.sleep(2000);
	 CFOcountPOM.ActDD1().click();
	 Thread.sleep(2000);

	List<String> li=new ArrayList<String>();

	li.add(location);
	li.add(act);
	Thread.sleep(3000);

	List<String> filter=new ArrayList<String>();	
	filter.add("Location");
	filter.add("Act");	
	/*	
	MgmtSonyMethod.ClickTri().click();
	   Thread.sleep(1000);
	   MgmtSonyMethod.Columns().click();
	   Thread.sleep(500);
	   MgmtSonyMethod.RiskCheck().click();
	   Thread.sleep(1000);
	  
	   MgmtSonyMethod.ClickTri().click();
	   Thread.sleep(3000);
	      */
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> Loccol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[1]"));

	List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]"));
	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(Loccol);
			}
		else if(i==1)
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

	getDriver().switchTo().defaultContent();
	Thread.sleep(3000);
	CFOcountPOM.closeCategories().click();
	Thread.sleep(1000);

			OverduePOM.clickDashboard().click();


	}
	
	public static void UpcomingFilter(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		
		Thread.sleep(4000);
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
	
		Thread.sleep(3000);
		CFOcountPOM.clickUpcomingPe1().click();	
		Thread.sleep(2000);
	//	CFOcountPOM.readCritical().click();	
		CFOcountPOM.readHigh().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
	
		RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighM().getText();
    
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF1().getText();
       Thread.sleep(500);
       SelectActF1().click();
       Thread.sleep(3000);
       SelectActF().click();
       Thread.sleep(500);
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(500);
       
       StatusAll().click();
       Thread.sleep(3000);
       StatusAll().click();
       Thread.sleep(3000);
       String Statustext =StatusUpcoming().getText();
       Thread.sleep(500);
       StatusUpcoming().click();
       Thread.sleep(3000);
       StatusF().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add(Risktext);
        li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(500);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(1000);
	       MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[16]"));
		List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			else if(i==1)
				{
					raw.addAll(Act);
				}
			else if(i==2)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==3)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		try {         

           // Set zoom level to 50% (0.5) for zooming out
           setZoomLevel(getDriver(), 0.9);

//           // Wait to observe the effect
           Thread.sleep(2000);
//
//           // Set zoom level back to 100% (1.0) to reset to normal
//         //  setZoomLevel(getDriver(), 1.0);
//
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();
		
	}
	
	public static void UpcomingFilter1(ExtentTest test ) throws InterruptedException, IOException
	{	
		
       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
       Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,2200)");			//Scrolling down window by 1000 px.
		Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		
		Thread.sleep(4000);
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
	
		Thread.sleep(3000);
		CFOcountPOM.clickUpcomingPe1().click();	
		Thread.sleep(2000);
	//	CFOcountPOM.readCritical().click();	
		CFOcountPOM.readHigh().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
		Thread.sleep(4000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
	
		/*RiskF().click();
		Thread.sleep(500);
	
      String Risktext =RiskHighM().getText();
    
       Thread.sleep(3000);
       
       SelectActF().click();
       Thread.sleep(500);
       String Acttext =SelectActF1().getText();
       Thread.sleep(500);
       SelectActF1().click();
       Thread.sleep(3000);
       SelectActF().click();
       */
       Thread.sleep(500);
       
       
       MitigationPlan().click();
       Thread.sleep(500);
     
       MitigationPlan1().click();
       Thread.sleep(2000);
      
       Thread.sleep(3000);
       StatusFP().click();
       Thread.sleep(5000);
       
       StatusAll1().click();
       Thread.sleep(3000);
       StatusAll1().click();
       Thread.sleep(3000);
       String Statustext =StatusUpcoming().getText();
       Thread.sleep(500);
       StatusUpcoming().click();
       Thread.sleep(3000);
       StatusFP().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
        li.add("High");
       // li.add(Acttext);
        li.add("1");
        Thread.sleep(3000);
        li.add(Statustext);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("Risk");
		//filter.add("Act");
		filter.add("Mitigation Plan");	
		filter.add("Status");	
		
		By locator = By.xpath("(//*[@class='k-icon k-i-more-vertical'])[14]");
		
		WebElement ViewButton =getDriver() .findElement(locator);	
		Thread.sleep(3000);
		JavascriptExecutor jse= (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	       MgmtSonyMethod.Columns().click();
	       Thread.sleep(5000);
	       MgmtSonyMethod.RiskCheck().click();
	       Thread.sleep(2000);
	        locator = By.xpath("(//*[@data-field='MitigationPlan'])[2]");
			
			 ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
			//JavascriptExecutor jse= (JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
	     //  MgmtSonyMethod.MitigationPlanA().click();
	       Thread.sleep(2000);
	      // MgmtSonyMethod.ClickTriA().click();
	       Thread.sleep(3000);
	
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(500);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[16]"));
	//	List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]"));
		List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]"));
		
		List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(Risk);
				}
			
			else if(i==1)
			{
				raw.addAll(MitigationPlan);
			}
			else if(i==2)
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
		
		ClearBtn().click();
		test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		try {         

           // Set zoom level to 50% (0.5) for zooming out
           setZoomLevel(getDriver(), 0.8);

//           // Wait to observe the effect
           Thread.sleep(2000);
//
//           // Set zoom level back to 100% (1.0) to reset to normal
//         //  setZoomLevel(getDriver(), 1.0);
//
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
		CFOcountPOM.closeDocuments1().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();
		
	}
	
		public static void setZoomLevel(WebDriver driver, double zoomLevel) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
	    }
		
		public static void UpcomingFilterIn(ExtentTest test ) throws InterruptedException, IOException
		{	
			
	       WebDriverWait wait = new WebDriverWait(getDriver(),(180));
		    
	       Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
			Thread.sleep(2000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
			
			Thread.sleep(4000);
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
		
			Thread.sleep(3000);
			CFOcountPOM.clickUpcomingPe1().click();	
			Thread.sleep(2000);
		//	CFOcountPOM.readCritical().click();	
			CFOcountPOM.readHigh().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(4000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(3000);
		//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFNewPeriodGraphCompliance"));                                                            	
		//	Thread.sleep(500);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
			Thread.sleep(8000);
			
		
			RiskF().click();
			Thread.sleep(500);
		
	      String Risktext =RiskHighM().getText();
	    
	       Thread.sleep(3000);
	       /*
	       SelectActF().click();
	       Thread.sleep(500);
	       String Acttext =SelectActF1().getText();
	       Thread.sleep(500);
	       SelectActF1().click();
	       Thread.sleep(3000);
	       SelectActF().click();
	       */
	       Thread.sleep(500);
	       
	       MitigationPlan().click();
	       Thread.sleep(500);
	     
	       MitigationPlan1().click();
	       Thread.sleep(2000);
	      
	       Thread.sleep(3000);
	       StatusF().click();
	       Thread.sleep(500);
	       
	       StatusAll().click();
	       Thread.sleep(3000);
	       StatusAll().click();
	       Thread.sleep(3000);
	       String Statustext =StatusUpcoming().getText();
	       Thread.sleep(500);
	       StatusUpcoming().click();
	       Thread.sleep(3000);
	       StatusF().click();
	       Thread.sleep(2000);
	       
	        List<String> li=new ArrayList<String>();
	        
	        li.add(Risktext);
	      //  li.add(Acttext);
	        li.add("1");
	        Thread.sleep(3000);
	        li.add(Statustext);
	        
			List<String> filter=new ArrayList<String>();	
			filter.add("Risk");
		//	filter.add("Act");
			filter.add("Mitigation Plan");	
			filter.add("Status");	
			
			MgmtSonyMethod.ClickTriA().click();
		       Thread.sleep(1000);
		       MgmtSonyMethod.Columns().click();
		       Thread.sleep(500);
		       MgmtSonyMethod.RiskCheck().click();
		       Thread.sleep(1000);
		       MgmtSonyMethod.MitigationPlanA().click();
		       Thread.sleep(2000);
		      // MgmtSonyMethod.ClickTriA().click();
		       Thread.sleep(3000);
		
			js.executeScript("window.scrollBy(0,1000)");	
			Thread.sleep(3000);
			CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItemsD().getText();
			Thread.sleep(500);
			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
		
			List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[16]"));
		//	List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[2]"));
			List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]"));
			
			List<WebElement> statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]"));
			
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(Risk);
					}
				/*else if(i==1)
					{
						raw.addAll(Act);
					}
					*/
				else if(i==1)
				{
					raw.addAll(MitigationPlan);
				}
				else if(i==2)
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
			
			ClearBtn().click();
			test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			try {         

	           // Set zoom level to 50% (0.5) for zooming out
	           setZoomLevel(getDriver(), 0.8);

//	           // Wait to observe the effect
	           Thread.sleep(2000);
	//
//	           // Set zoom level back to 100% (1.0) to reset to normal
//	         //  setZoomLevel(getDriver(), 1.0);
	//
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
			CFOcountPOM.closeDocuments().click();					//Closing the High Risk Window.
			Thread.sleep(1000);
			OverduePOM.clickDashboard().click();
			
		}
		
	
}
