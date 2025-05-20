package cfo;
//import java.io.File;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import departmentHead.DeptCountPOM;
import login.BasePage;
import performer.OverduePOM;


public class CFOcountPOM extends BasePage
{static WebDriverWait wait = new WebDriverWait(getDriver(), 20);
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	private static WebElement categories = null;				//WebElement variable created for 'Categories' click
	private static WebElement compliances = null;				//WebElement variable created for 'Compliances' read and click
	private static List<WebElement> compliancesList = null;		//WebElement variable created for 'Compliances' read and click
	private static WebElement compliancesItomsCount = null;		//WebElement variable created for reading Items count after Compliances click
	private static WebElement users = null;						//WebElement variable created for 'Users' read and click
	private static WebElement penalty = null;					//WebElement variable created for 'Penalty' read and click
	private static List<WebElement> interestList = null;		//WebElement variable created for reading each interest.
	private static List<WebElement> penaltyList = null;			//WebElement variable created for reading each interest.
	private static WebElement nextPage = null;					//WebElement variable created for clicking on next page arrow.
	private static WebElement piechart = null;					//WebElement variable created for piechart elements. 
	private static List<WebElement> select = null;				//WebElement variable created for piechart elements.
	private static WebElement bargraph = null;					//WebElement variable created for bargraph elements.
	private static WebElement risksummary = null;				//WebElement variable created for Risk Summary elements.
	private static WebElement refresh = null;					//WebElement variable created for Refreshing web page.
	private static WebElement department = null;				//WebElement variable created for Department Summary elements. 
	private static WebElement penlatysummary = null;			//WebElement variable created for Penalty Summary elements.
	private static WebElement Internal = null;					//WebElement variable created for Internal Compliances Dashboard.
	private static WebElement grading = null;					//WebElement variable created for Grading Report elements.
	private static List<WebElement> totalRecords = null; 		//WebElement variable created for calculating total records displayed in Grading Report 
	private static WebElement calendar = null;					//WebElement variable created for Grading Report elements.
	private static WebElement reports = null;					//WebElement variable created for Reports elements.
	private static WebElement documents = null;					//WebElement variable created for Reports elements.
	private static List<WebElement> menus = null; 				//WebElement variable created for sub menu elements.
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	private static List<WebElement> elementsList2 = null;
	private static WebElement SummaryofOverdueCom = null;
	private static List<WebElement> viewList = null;
	public static WebElement clickCategories( )		//Method for closing Message Popup
	{
		categories = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divFunctionCount']"));
		return categories;
	}
	
	public static WebElement readCompliances( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement ClickAct( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[1]/span/span[2]"));
		return compliances;
	}
	
	public static WebElement ViewText( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowlocationpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]"));
		return compliances;                        
	}
	
	public static WebElement ViewTextIOR( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowSummarypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]"));
		return compliances;                        
	}
	
	public static WebElement clickRiskHighNA( )			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[18]"));
		return risksummary;
	}
	public static WebElement clickIndustrySpeCriticalMDemo( )			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		return bargraph;
	}
	

	public static WebElement clickRiskMediumNA( )			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[19]"));
		return risksummary;
	}
	public static WebElement clickAdmiInprogress( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[37]"));
		return department;
	}

	public static WebElement clickRiskLowNA( )			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[20]"));
		return risksummary;
	}

	public static WebElement clickadminNotApplicable( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	public static WebElement clickUpcomingPe1( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("//div[@id='perStatusPieChartDiv']//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return department;
	}
	
	
	public static WebElement NotApplicableCritical( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	
	public static WebElement ViewTextIORIn( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowInternalSummarypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]"));
		return compliances;                        
	}
	public static WebElement ClearBtn()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return compliances;
	}
	
	public static WebElement ViewTextUser( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowuserpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]"));
		return compliances;                        
	}
	
	public static WebElement ViewTextLoIn( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowInternallocationpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[62]/div"));
		return compliances;                        
	}
	
	public static WebElement ViewTextUserIn( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowInternaluserpopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div"));
		return compliances;                        
	}
	
	public static WebElement ViewTextCategory( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowCategorypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]"));
		return compliances;                        
	}
	
	public static WebElement ViewTextCategoryIn( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowInternalCategorypopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div"));
		return compliances;                        
	}
	
	public static WebElement ViewTextRisk( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowriskpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]"));
		return compliances;                        
	}
	
	public static WebElement ViewTextRiskIn( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowInternalriskpopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div"));
		return compliances;                        
	}
	
	public static WebElement ViewTextCritical( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='windowcriticalriskpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[129]/div"));
		return compliances;                        
	}
	
	public static WebElement uniqueCompliances( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divUniqueCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement TotalCompliances( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divTotalCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement TotalCompliancesM( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divCompliancesCount']"));
		return compliances;
	}
	
	public static WebElement RefreshNow( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label"));
		return compliances;
	}
	public static WebElement clickHumanNotApplicableDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[73]"));
		return department;
	}
	public static WebElement clickRiskCriticalNotCompletedDeptDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[85]"));
		

		return risksummary;
	}
	public static WebElement clickRiskCriticalNotApplicableDEDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[97]"));
		return risksummary;
	}
	public static WebElement clickRiskMediumNotCompletedDeptDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[86]"));
		

		return risksummary;
	}
	public static WebElement clickRiskHighClosedTimelyDptDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[94]"));
		return risksummary;
	}
	public static WebElement clickRiskHighNotApplicableDEDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[98]"));
		return risksummary;
	}
	public static WebElement clickRiskMediumClosedTimelyDptDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[95]"));
		return risksummary;
	}
	public static WebElement clickRiskMediumNotApplicableDEDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[99]"));
		return risksummary;
	}
	public static WebElement clickRiskLowNotCompletedDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[88]"));
		

		return risksummary;
	}
	public static WebElement clickRiskLowNotApplicableDEDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[100]"));
		return risksummary;
	}
	public static WebElement clickRiskLowClosedDelayedDptDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[92]"));
		return risksummary;                        
	}
	public static WebElement clickRiskHighClosedDelayedDptDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[90]"));
		return risksummary;                        
	}
	public static WebElement clickRiskCriticalClosedTimelyDptDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[93]"));
		return risksummary;
	}
	public static WebElement clickAccountOverdueDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[60]"));
		return department;
	}
	public static WebElement clickAccountInprogressDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[82]"));
		return department;
	}
	public static WebElement clickHumanInprogressDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[49]"));
		return department;
	}
	public static WebElement clickHumanRejectedDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[61]"));
		return department;
	}
	public static WebElement clickPendingReviewDeptDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[37]"));
		return department;
	}
	
	public static WebElement clickFinanceOverdueDeptDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[25]"));
		return department;
	}
	public static WebElement clickClosedTimelyDptDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[13]"));
		return department;
	}
	
	public static WebElement clickAccountDuetodayDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[115]"));
		return department;
	}

	public static WebElement clickAccountNADemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[104]"));
		return department;
	}

	public static WebElement clickAccountRejectedDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[93]"));
		return department;
	}
	
	public static WebElement clickAccountClosedDelayedDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return department;
	}
	public static WebElement clickAccountPendingReviewDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[71]"));
		return department;
	}

	public static WebElement clickAccountClosedTimelyDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[49]"));
		return department;
	}

	
	public static WebElement RefreshNowD( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh']/label"));
		return compliances;
	}

	public static WebElement clickIndustrySpeHighMDemo( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[14]"));
		return bargraph;
	}
	
	public static WebElement  clickIndustrySpeLowMDemo( )				//"Statutory" Method to search Labour compliance low risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return bargraph;
	}

	
	
	public static WebElement readCompliancesInternal( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divCompliancesCount']"));
		return compliances;//*[@id="ContentPlaceHolder1_divCompliancesCount"]
	}      
	
	public static WebElement clickLocation( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[1]/span/span[2]"));
		return compliances;
	} //*[@id="example"]/div[1]/div[1]/div/span[1]
	
	public static WebElement clickLocationIn( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[1]/div/span[1]"));
		return compliances;                       
	}
	
	public static WebElement clickLocationShow( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[1]/div"));
		return compliances;                       
	}
	
	public static WebElement clickLocationPe( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/div[1]/div/span[1]"));
		return compliances;                       
	} 
	
	public static WebElement clickCkecjke( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[34]"));
		return compliances;                       
	} 
	
	public static WebElement StartDate( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtAdvStartDate']"));
		return compliances;                       
	} 
	
	public static WebElement StartDate1( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.linkText("3"));
		return compliances;                       
	} 
	
	public static WebElement EndDate( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtAdvEndDate']"));
		return compliances;                       
	} 
	
	public static WebElement Clear( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnClear']"));
		return compliances;                       
	} 
	
	public static WebElement EndDate1( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.linkText("17"));
		return compliances;                       
	} 
	
	public static WebElement clickLocationInterest( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/div[1]/div/span[1]"));
		return compliances;                       
	} 
	
	public static WebElement YearTodate( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']"));
		return compliances;
	} 
	
	public static WebElement ALL( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlperiod']/option[7]"));
		return compliances;
	} 
	
	public static WebElement ViewClose( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
		return compliances;
	} 
	
	public static WebElement clickExpand1( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-expand']"));
		return compliances;
	} 
	
	public static WebElement clickExpand2( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-collapse']"));
		return compliances;
	} 
	
	public static WebElement clickBita( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[8]"));
		return compliances;
	} 
	
	public static WebElement clickAR( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[10]"));
		return compliances;
	} 
	
	public static WebElement clickABita( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[9]"));
		return compliances;
	} 
	
	public static WebElement EnterRemark( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='txt_Remark']"));
		return compliances;
	} 
	
	public static WebElement ReOpen( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='btn_Remark']"));
		return compliances;
	} 
	
	public static WebElement ViewDoc( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]/a"));
		return compliances;
	} 
	

	
	public static WebElement clickAVIPL( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[10]"));
		return compliances;
	} 
	
	public static WebElement clickBitaAurangabad( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//li[@class='k-item k-first'])[2]"));
		return compliances;
	} 
	
	public static WebElement clickElectricity( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[1]"));
		return compliances;
	} 
	
	
	public static WebElement clickBPVT( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[7]"));
		return compliances;
	} 
	
	public static WebElement clickClear( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return compliances;
	} 
	
	
	
	public static List<WebElement> readCompliancesList( )	//Method for reading list of compliances after clicking Categories. 
	{
		compliancesList = getDriver().findElements(By.xpath("//*[contains(@onclick,'openpopup')]"));
		return compliancesList;
	}
	
	public static List<WebElement> readUserList( )	//Method for reading list of compliances after clicking Categories. 
	{
		compliancesList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[3]/div"));
		return compliancesList;
	}
	
	public static List<WebElement> readUserList1( )	//Method for reading list of compliances after clicking Categories. 
	{
		compliancesList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[3]/a"));
		return compliancesList;
	}
	
	public static WebElement closeCategories( )				//Closing Categories pop up.
	{                                             
		categories = getDriver().findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
	//	categories = getDriver().findElement(By.xpath("//body/form/div[@id='example']/div[1]"));
		return categories;//body/form/div[@id='example']/div[1]
	}  
	//*[@id="divreports"]/div/div/div[1]/button
	public static WebElement closeCategories1( )				//Closing Categories pop up.
	{                                             
		categories = getDriver().findElement(By.xpath("//*[@id='divreportsNewGraph']/div/div/div[1]/button"));
		
		return categories;
	}  
	
	public static WebElement closePopup( )				//Closing Categories pop up.
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divGRreports']/div/div/div[1]/button"));
		return categories;
	}
	
	public static WebElement closeView_cal( )				//Closing Categories pop up.
	{
		categories = getDriver().findElement(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
		return categories;                        //*[@id="divOverView"]/div/div/div[1]/button
	}
	
	public static WebElement clickAll( )				//Closing Categories pop up.
	{
		categories = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdbcalender_1']"));
		return categories;
	}
	
	public static WebElement closeCategories_Compliances( )	//Closing Compliances pop up opened within Categories pup up.
	{
	//	categories = getDriver().findElement(By.xpath("//div[@id='divApiOverView']/div/div/div[1]/button"));
		categories = getDriver().findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
		
		return categories;//*[@id="divApiOverView"]/div/div/div[1]/button
	}
	
	public static WebElement readCompliancesItems( )			//Method for read total items in Compliances.
	{
		compliancesItomsCount = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span"));
		return compliancesItomsCount;
	}
	
	public static WebElement clickUsersCount( )				//Method to search 'Users' image link to click on 
	{
		users = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divUsersCount']"));
		return users;                       
	}//*[@id="ContentPlaceHolder1_divUsersCount"]
	
	public static WebElement readUsersCount( )				//Method to read total users items in Users.
	{
		users = getDriver().findElement(By.xpath("//*[@id='grid']/div[5]/span"));
		return users;
	}
	
	public static WebElement readUsersCount1( )				//Method to read total users items in Users.
	{
		users = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return users;
	}
	
	public static WebElement ClickShowAll( )				//Method to read total users items in Users.
	{
		SummaryofOverdueCom = getDriver().findElement(By.xpath("//*[@id='lnkOverdueCompliance']"));
		return SummaryofOverdueCom;
	}
	
	public static WebElement ClickShowAllIn( )				//Method to read total users items in Users.
	{
		SummaryofOverdueCom = getDriver().findElement(By.xpath("//*[@id='lnkInternalOverdueCompliance']"));
		return SummaryofOverdueCom;                   
	}
	
	public static List<WebElement> ActionviewList( )			//Method to read all interests in Penalty.
	{
		viewList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td/a[1]"));
		return viewList;
	}
	
	public static WebElement readUsersCount2( )				//Method to read total users items in Users.
	{
		users = getDriver().findElement(By.xpath("//*[@class = 'k-pager-info k-label']"));
		return users;
	}
	//*[@id="grid"]/div[4]/span[2]
	public static WebElement readPenaltyCount( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_divPenalty']"));
		return penalty;
	}
	public static WebElement Location( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/div[1]"));
		return penalty;
	}
	public static WebElement Location1( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.cssSelector("#example > div:nth-child(2) > div:nth-child(2) > div > span.k-input.k-readonly"));
		return penalty;
	}

	
	public static WebElement LocationDD( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("(//span[.='Regtrack Pvt Ltd'])[2]"));
		return penalty;
	}

	public static WebElement LocationDD1( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("(//div[@class='k-animation-container']//div//ul//li//span[@class='k-checkbox-wrapper'])[1]"));
		return penalty;
	}

	
	public static WebElement SelectAll( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("(//span[.='Select All'])[2]"));
		return penalty;
	}

	public static WebElement LocationDropdown( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("//span[normalize-space()='Branch Mumbai']"));
		return penalty;
	}

	public static WebElement Act( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/span[2]"));
		return penalty;
	}
	public static WebElement Act1( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.cssSelector("#example > div:nth-child(2) > span:nth-child(4) > span > span.k-input"));
		return penalty;
	}

	
	public static WebElement ActDD( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[14]"));
		return penalty;
	}

	public static WebElement ActDD1( )				//Method to read and click on Penalty.
	{
		penalty = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[24]"));
		return penalty;
	}

	
	public static WebElement clickInterest( )
	{
		penalty = getDriver().findElement(By.xpath("//*[@id='liGraph']"));
		return penalty;
	}//*[@id="liGraph"]
	
	public static List<WebElement> readInterest( )			//Method to read all interests in Penalty.
	{
		interestList = getDriver().findElements(By.xpath("//table[@data-role='selectable']/tbody/tr/td[7]"));
		return interestList;
	}
	
	public static List<WebElement> readPenalty( )			//Method to read all penalties in Penalty.
	{
		penaltyList = getDriver().findElements(By.xpath("//table[@data-role='selectable']/tbody/tr/td[7]"));
		return penaltyList;
	}
	
	public static WebElement loadGrid( )
	{
		penalty = getDriver().findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']"));
		return penalty;
	}
	
	public static WebElement ClearButton( )
	{
		penalty = getDriver().findElement(By.xpath("//*[@id = 'ClearfilterMain']"));
		return penalty;
	}
	
	public static WebElement clickNextPage( )				//Method to search next page arrow button.
	{
		nextPage = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/a[3]/span"));
		return nextPage;
	}
	
	public static List<WebElement> checkTotalIndexes( )				//Method to search next page arrow button.
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class = 'k-pager-numbers k-reset']/li"));
		return elementsList;
	}
	
	public static WebElement clickNextPage1( )				//Method to search next page arrow button.
	{
		nextPage = getDriver().findElement(By.xpath("//*[@title='Go to the next page']"));
		return nextPage;
	}
	
	public static WebElement readTotalItems( )				//Method to read all items in Penalty click.
	{
		nextPage = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span"));
		return nextPage;
	}
	
	public static WebElement clickNotCompleted( )			//Method to search Not Completed count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
	//	piechart = getDriver().findElement(By.xpath("//*[@id='highcharts-2']/svg/g[3]/g[2]/text/tspan"));

		return piechart;
	}//*[@id="highcharts-2"]/svg/g[3]/g[2]/text/tspan
	
	public static WebElement IsSmetaColumn( )			//Method to search Not Completed count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//table//th[@data-field='IsSmetaCompliance']"));

		return piechart;
	}
	
	
	public static WebElement clickNotCompletedInternal( )			//Method to search Not Completed count to click on from Pie Chart.
	{
	//	piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));

		return piechart;                        //*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']
	}
	
	public static WebElement clickNotCompletedInternalA( )			//Method to search Not Completed count to click on from Pie Chart.
	{
		
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		
		return piechart;                        //*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']
	}
	
	public static WebElement clickNotApplInternalA( )			//Method to search Not Completed count to click on from Pie Chart.
	{
		
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		
		return piechart;                        
	}
	
	public static WebElement clickAfterDueDate( )			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayed( )			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayedA( )			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedDelayedInternal( )			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label']"));
		return piechart;                                   
	}
	
	public static WebElement clickNotCompliedInternal( )			//Method to search After Due Date count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])"));
		return piechart;
	}
	
	public static WebElement clickInTime( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickClosedTimely( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label']"));
		return piechart;                       
	}
	
	public static WebElement clickClosedTimelyA( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		return piechart;                       
	}
	
	public static WebElement clickClosedTimelyInternal( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
		return piechart;                                                             
	}
	
	public static WebElement clickClosedTimelyInternalP( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label']"));
		return piechart;                                   
	}
	
	public static WebElement clickNotApplicable( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickNotApplicableA( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickNotApplicableInternal( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickOverdue( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickOverdueInternal( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickOverdueInternalApp( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
		return piechart;
	}
	
	public static WebElement clickdueToday( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickdueTodayInernal( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickpendingForReview( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickpendingForReviewDept( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickInProgressDept( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	
	public static WebElement clickpendingForReviewIN( )					//Method to search In Time count to click on from Pie Chart.
	{                       
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[2]"));
		return piechart;                         
	}
	
	public static WebElement clickpendingForReviewIND( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickinProgress()					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])[2]"));
		return piechart;                                       
	}
	
	public static WebElement clickRejected( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label'])"));
		return piechart;
	}                                           
	
	public static WebElement clickRejectedIn( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickRejectedDept( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickRejectedPe( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickUpcomingPe( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label']"));
		return piechart;
	}
	
	public static WebElement clickRejectedPe1( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	
	public static WebElement clickRejectedPe11( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[name()='g'][@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label'])[2]"));
		return piechart;
	}
	public static WebElement clickRejectedPe12( )					//Method to search In Time count to click on from Pie Chart.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label'])[3]"));
		return piechart;
	}
	
	
	public static WebElement readCritical( )						//Method to read High risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
		return piechart;
	}
	
	public static WebElement readHigh( )					//Method to read Medium risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
		return piechart;                        
	}
	
	public static WebElement readHigh1( )					//Method to read Medium risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@id='highcharts-0']/svg/g[3]/g[2]"));
		return piechart;                        
	}
	
	public static WebElement readMedium( )						//Method to read Low risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
		return piechart;
	}
	
	public static WebElement readLow( )						//Method to read Low risk Value (For all types)
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
		return piechart;
	}
	
	public static List<WebElement> selectDropdown( )			//Method to search drop downs in Not Completed click
	{
		select = getDriver().findElements(By.xpath("//*[@class='k-multiselect-wrap k-floatwrap']"));
		return select;
	}
	
	public static WebElement selectFirst( )					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("//*[contains(text(),'BITA Consulting Private Limited')][@class='k-in']"));
		return piechart;
	}
	
	public static WebElement SelectLocation( )					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("//*[@id='example']/div/div/div"));
		return piechart;
	}
	
	public static WebElement ClickIocon( )					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-expand']"));
		return piechart;
	}
	
	public static WebElement ClickABCMall( )					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[3]"));
		return piechart;
	}
	
	public static WebElement ClickAPVT( )					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[15]"));
		return piechart;
	}
	
	
	public static WebElement selectFirst1( )					//Method to select first option in the first drop down
	{
		piechart = getDriver().findElement(By.xpath("//*[contains(text(),'ABCD Pvt Ltd')][@class='k-in']"));
		return piechart;
	}
	
	public static WebElement selectfirst( )
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='k-in k-state-selected']"));
		return piechart;
	}
	
	public static WebElement readTotalItems1( )				//Method to read total no of items.
	{
	//	piechart = getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		piechart=getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return piechart;//*[@id="grid"]/div[4]/span[2]
	}//*[@id="grid1"]/div[4]/span[2]//*[@id="grid"]/div[5]/span[2]
	
	public static WebElement readTotalItems2( )				//Method to read total no of items.
	{
	
		piechart=getDriver().findElement(By.xpath("//*[@id='grid1']/div[4]/span[2]"));
		return piechart;
	}
	
	public static WebElement readTotalItems3( )				//Method to read total no of items.
	{
	
		piechart=getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		return piechart;
	}
	
	public static WebElement readTotalItems4( )				//Method to read total no of items.
	{
	
		piechart=getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return piechart;
	}
	
	public static WebElement readTotalItems5( )				//Method to read total no of items.
	{
	
		piechart=getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return piechart;
	}
	
	
	public static WebElement readTotalItemsD( )				//Method to read total no of items.
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
	
		return piechart;
	}
	
	public static WebElement readTotalItemsD1( )				//Method to read total no of items.
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class='k-pager-info k-label'])"));
	
		return piechart;
	}
	
	public static WebElement Norecord( )				//Method to read total no of items.
	{
		piechart = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/div[1]/div"));
	
		return piechart;
	}
	
	public static WebElement NorecordAS( )				//Method to read total no of items.
	{
		piechart = getDriver().findElement(By.xpath("//*[@id='grid1']/div[3]/div[1]/div"));
	
		return piechart;
	}
	
	public static WebElement clickBack1( )
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class=' highcharts-button-box'])[2]"));
		return piechart;
	}
	
	public static WebElement clickBackPe( )
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-button highcharts-drillup-button']"));
		return piechart;
	}
	
	public static WebElement clickBackPe1( )
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-button highcharts-drillup-button highcharts-button-normal']"));
		return piechart;                                  
	}
	
	public static WebElement clickBack2( )
	{
		piechart = getDriver().findElement(By.xpath("(//*[@class=' highcharts-button-box'])[3]"));
		return piechart;
	}//*[@id="highcharts-4"]/svg/g[5]
	
	public static WebElement clickBack4( )
	{
		piechart = getDriver().findElement(By.xpath("//*[@class='highcharts-button highcharts-drillup-button highcharts-button-normal']//*[@class=' highcharts-button-box']"));
		return piechart;
	}//*[@id="highcharts-4"]/svg/g[5]
	
	
	public static WebElement clickBack3( )
	{
		piechart = getDriver().findElement(By.xpath("//*[@id='highcharts-4']/svg/g[5]"));
		return piechart;
	}
	
	public static WebElement clickIndustrySpeCritical( )			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeCriticalM( )			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[2]"));
		return bargraph;
	}
	public static WebElement clickIndustrySpeCriticalDemo( )			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[1]"));
		return bargraph;
	}
	public static WebElement clickIndustrySpeCriticalM1( )			//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])"));
		return bargraph;
	}
	public static WebElement clickIndustrySpeHigh( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[14]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeHighM( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[9]"));
		return bargraph;
	}
	public static WebElement clickIndustrySpeHighDemo( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[2]"));
		return bargraph;
	}
	public static WebElement clickBSECritical( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[2]"));
		return bargraph;
	}
	public static WebElement clickInternalComplianceCritialDemo( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[14]"));
		return bargraph;
	}
	public static WebElement clickInternalComplianceHighDemo( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[38]"));
		return bargraph;
	}
	public static WebElement clickBSEHigh( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[4]"));
		//(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[4]
		return bargraph;
	}
	
	public static WebElement clickBSEMedium( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		//(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]
		return bargraph;
	}
	public static WebElement clickInternalComplianceMediumDemo( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[62]"));
		//(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]
		return bargraph;
	}
	public static WebElement clickBSELow( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[8]"));
		//(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[8]
		return bargraph;
	}
	public static WebElement clickInternalComplianceLowDemo( )				//"Statutory" Method to search Labour compliance High risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[86]"));
		//(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[8]
		return bargraph;
	}
	public static WebElement clickIndustrySpeMedium( )			//"Statutory" Method to search Labour compliance Medium risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[22]"));
		return bargraph;
	}
	
	public static WebElement clickIndustrySpeMediumM( )			//"Statutory" Method to search Labour compliance Medium risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[16]"));
		return bargraph;
	}
	public static WebElement clickIndustrySpeMediumDemo( )			//"Statutory" Method to search Labour compliance Medium risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[3]"));
		return bargraph;
	}
	
	public static WebElement clickLabourMedium1( )			//Method to search Labour compliance Medium risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[15]"));
		return bargraph;
	}
	
	public static WebElement  clickIndustrySpeLow( )				//"Statutory" Method to search Labour compliance low risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return bargraph;
	}
	
	public static WebElement  clickIndustrySpeLowM( )				//"Statutory" Method to search Labour compliance low risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[23]"));
		return bargraph;
	}
	public static WebElement  clickIndustrySpeLowDemo( )				//"Statutory" Method to search Labour compliance low risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[4]"));
		return bargraph;
	}
	public static WebElement clickLabourLow1( )				//Method to search Labour compliance low risk value.
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[25]"));
		return bargraph;
	}
	
	public static WebElement clickBarInTime( )				//Method to search Labour In Time compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return bargraph;
	}
	
	public static WebElement clickBarClosedTimely( )				//Method to search Labour In Time compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return bargraph;
	}
	
	public static WebElement clickBarAfterDueDate( )			//Method to search Labour After Due Date compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return bargraph;
	}
	
	public static WebElement clickBarClosedDelayed( )			//Method to search Labour After Due Date compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return bargraph;
	}
	
	public static WebElement clickBarNotCompleted( )			//Method to search Labour Not Completed compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		return bargraph;
	}
	
	public static WebElement clickBarNotApplicable( )			//Method to search Labour Not Completed compliance
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return bargraph;
	}
	
	public static WebElement clickBack( )					//Method to search Back button of Completion Status Bar Graph
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class=' highcharts-button-box'])[3]"));
		return bargraph;
	}
	
	public static WebElement clickView( )					//Method to search View button of document to view
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]"));
		return bargraph;
	}
	
	public static WebElement closeDocument( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
		return bargraph;                         //*[@id="divreports"]/div/div/div[1]/button                
	}  
	public static WebElement closeDocuments( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
		return bargraph;                         //*[@id="divreports"]/div/div/div[1]/button                
	}  
	
	public static WebElement closeDocumentA( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
		return bargraph;                                         
	}       
	
	public static WebElement closeDocument1( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
		return bargraph;                                  
	}                                 
	
	public static WebElement closeDocument2( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button"));
		return bargraph;                                       
	}                                           //*[@id="divOverView1"]/div/div/div[1]/button
	
	public static WebElement closeDocumentAS( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
		return bargraph;                                       
	} 
	
	public static WebElement closeViewDoc( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divOverViewMain']/div/div/div[1]/button"));
		return bargraph;                           
	}  
	//*[@id="divOverView"]/div/div/div[1]/button
	public static WebElement closeViewDocGR( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divGRreports']/div/div/div[1]/button"));
		return bargraph;                           
	}  
	
	public static WebElement closeOverViewDoc( )				//Method to search cross of document to close it.
	{
		bargraph = getDriver().findElement(By.xpath("//*[@id='divOverViewMain1']/div/div/div[1]/button"));
		return bargraph;                            
	}  //*[@id="divOverView1"]/div/div/div[1]/button
	
	public static WebElement downloadDocument( )				//Method to search download button of first document. 
	{
		bargraph = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-download k-grid-edit2'])[1]"));
		return bargraph;
	}
	
	public static WebElement clickRiskCriticalNotCompleted( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));

		return risksummary;
	}
	
	public static WebElement clickRiskCriticalNotCompletedDept( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		

		return risksummary;
	}
	
	public static WebElement clickRiskHighNotCompletedDept( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		

		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompletedDept( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		

		return risksummary;
	}
	
	public static WebElement clickRiskLowNotCompletedDept( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		

		return risksummary;
	}
	
	public static WebElement clickRiskCriticalNotCompletedDeptIn( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		

		return risksummary;
	}
	
	/*[name()='svg'][1]/*[name()='g'][10]/*[name()='g'][1]/*[name()='text'][1]*/
	public static WebElement clickRiskCriticalClosedDelayed( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskCriticalClosedDelayedA( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskCriticalClosedDelayedD( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskCriticalClosedDelayedDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskHighClosedDelayedDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[13]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskMediumClosedDelayedDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[14]"));
		return risksummary;                        
	}
	
	public static WebElement clickRiskLowClosedDelayedDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[15]"));
		return risksummary;                        
	}
	
	
	public static WebElement clickRiskCriticalClosedTimely( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	public static WebElement clickRiskCriticalDueToday( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[13]"));
		return risksummary;
	}
	public static WebElement clickRiskHighDuetoday( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[14]"));
		return risksummary;
	}
	
	public static WebElement clickRiskCriticalNotApplicable( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[17]"));
		return risksummary;
	}
	public static WebElement clickRiskCriticalNotApplicableDemo( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return risksummary;
	}
	public static WebElement clickRiskHighNotApplicable( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[18]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotApplicableD( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[42]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotApplicable( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[19]"));

		return risksummary;
	}
	public static WebElement RiskLowNotApplicable( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[44]"));
		return risksummary;
	}

	public static WebElement RiskMediumNotApplicable( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[36]"));

		return risksummary;
	}

	
	public static WebElement clickRiskMediumNotApplicableSEC( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return risksummary;
	}

	public static WebElement RiskHighNotApplicable( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[35]"));
		return risksummary;
	}

	
	public static WebElement clickRiskLowNotApplicable( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[20]"));
		return risksummary;
	}
	
	public static WebElement clickRiskCriticalNotApplicableDE( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[20]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotApplicableDE( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[21]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotApplicableDE( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[22]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowNotApplicableDE( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[23]"));
		return risksummary;
	}
	
	
	public static WebElement clickRiskCriticalClosedTimelyA( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	
	public static WebElement clickRiskCriticalClosedTimelyD( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[37]"));
		return risksummary;
	}
	
	public static WebElement clickRiskCriticalClosedTimelyDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedTimelyDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[17]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedTimelyDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[18]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedTimelyDpt( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[19]"));
		return risksummary;
	}
	
	
	public static WebElement clickRiskHighNotCompleted( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotCompletedD( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[58]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighNotCompletedDIn( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[30]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighAfterDueDate( )	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedDelayed( )	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedDelayedA( )	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedDelayedD( )	//Method to search 'High Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return risksummary;
	}
	
	
	public static WebElement clickRiskHighInTime( )			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return risksummary;
	}
	
	public static WebElement clickRiskHighClosedTimely( )			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return risksummary;
	}
	public static WebElement clickRiskHighDueToday( )			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[14]"));
		return risksummary;
	}
	public static WebElement clickRiskHighClosedTimelyIN( )			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return risksummary;
	}
	
	
	public static WebElement clickRiskHighClosedTimelyA( )			//Method to search 'High Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompleted( )	//Method to search 'Medium Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		//	risksummary = getDriver().findElement(By.xpath("//*[@id='highcharts-6']/svg/g[5]/g[1]/rect[1]"));

		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompletedD( )	//Method to search 'Medium Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[59]"));
		//	risksummary = getDriver().findElement(By.xpath("//*[@id='highcharts-6']/svg/g[5]/g[1]/rect[1]"));

		return risksummary;
	}
	
	public static WebElement clickRiskMediumNotCompletedDIn( )	//Method to search 'High Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[31]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumAfterDueDate( )	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedDelayed( )	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedDelayedD( )	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[35]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedDelayedA( )	//Method to search 'Medium Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumInTime( )		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedTimely( )		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumDueToday( )		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[15]"));
		return risksummary;
	}

	public static WebElement clickRiskMediumClosedTimelyA( )		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return risksummary;
	}
	
	public static WebElement clickRiskMediumClosedTimelyD( )		//Method to search 'Medium Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return risksummary;
	}
	
	
	public static WebElement clickRiskLowNotCompleted( )		//Method to search 'Low Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowNotCompletedD( )		//Method to search 'Low Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[60]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowNotCompletedDIn( )		//Method to search 'Low Risk - Not Completed' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[32]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowAfterDueDate( )		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedDelayed( )		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedDelayedA( )		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedDelayedDIN( )		//Method to search 'Low Risk - After Due Date' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[36]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowInTime( )			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedTimely( )			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return risksummary;
	}
	public static WebElement clickRiskLowDueToday( )			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
		return risksummary;
	}
	public static WebElement clickRiskLowClosedTimelyA( )			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return risksummary;
	}
	
	public static WebElement clickRiskLowClosedTimelyD( )			//Method to search 'Low Risk - In Time' compliance of Risk Summary.
	{
		risksummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[40]"));
		return risksummary;
	}
	
	
	public static WebElement clickRefresh( )					//Method to search 'Refresh' button on the web page.
	{
		refresh = getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_btnRefresh1']"));
		return refresh;
	}
	
	public static WebElement clickDepartmentHighHuman( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return department;
	}
	
	public static WebElement clickAdminNotComplInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[53]"));
		return department;
	}
	
	public static WebElement clickFinanceClosedDelayedInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return department;
	}
	
	
	public static WebElement clickAccountClosedDelayedInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return department;
	}
	
	
	public static WebElement clickFinanceClosedTimelyInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[31]"));
		return department;
	}
	
	public static WebElement clickFinanceOverdueInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return department;
	}
	
	public static WebElement clickFinanceClosedTimelyInternalD( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return department;
	}
	
	public static WebElement clickAdminClosedTimelyInternalDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return department;
	}
	public static WebElement clickAccountOverdueInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[31]"));
		return department;
	}
	
	public static WebElement clickAccountOverdueInternalD( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
		return department;
	}
	
	public static WebElement clickFinancePenFReviewInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return department;
	}
	
	public static WebElement clickAccountPenFReviewInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[32]"));
		return department;
	}
	
	public static WebElement clickAccountPenFReviewInternalD( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[13]"));
		return department;
	}
	public static WebElement clickAdminPenFReviewInternalDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		return department;
	}

	
	public static WebElement clickFinanceInProgressInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[37]"));
		return department;
	}
	public static WebElement clickAdminInProgressInternalDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return department;
	}
	
	public static WebElement clickFinanceRejectedInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return department;
	}
	
	public static WebElement clickAccountRejectedInternalD( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[21]"));
		return department;
	}
	public static WebElement clickAdminRejectedInternalDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return department;
	}
	
	public static WebElement clickAccountRejectedInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return department;
	}
	                         
	public static WebElement clickFinanceNotAppliInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	public static WebElement DueToday( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[54]"));
		return department;
	}
	
	public static WebElement clickAccountNotAppliInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[25]"));
		return department;
	}
	public static WebElement clickAdminNotAppliInternalDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return department;
	}
	
	public static WebElement clickBTRNotComplInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[56]"));
		return department;
	}
	
	public static WebElement clickDSSNotComplInternal( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[57]"));
		return department;
	}
	
	public static WebElement clickHumanClosedDelayed( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return department;
	}
	
	public static WebElement clickClosedDelayedDept( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
		return department;
	}
	
	public static WebElement clickHRClosedDelayed( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return department;
	}
	
	public static WebElement clickAccountClosedDelayed( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return department;
	}
	
	public static WebElement clickFinanceClosedDelayed( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	
	public static WebElement clickAdminClosedDelayed( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[33]"));
		return department;
	}
	
	public static WebElement clickHumanClosedTimely( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[36]"));
		return department;
	}
	
	public static WebElement clickHumanClosedTimelym( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return department;
	}
	
	public static WebElement clickClosedTimelyDpt( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
		return department;
	}
	
	public static WebElement clickHRClosedTimelym( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
		return department;
	}
	
	public static WebElement clickAccountClosedTimely( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[36]"));
		return department;
	}
	
	public static WebElement clickAccountClosedTimelyIn( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[41]"));
		return department;
	}
	
	
	public static WebElement clickAccountClosedTimelyA( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return department;
	}
	
	public static WebElement clickAccountClosedTimelyA1( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[36]"));
		return department;
	}
	
	public static WebElement clickComplianceIsecClosedTimelyDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return department;
	}
	public static WebElement clickFinanceClosedTimely( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[50]"));
		return department;
	}
	
	public static WebElement clickHumanOverdue( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[59]"));
		return department;
	}
	
	public static WebElement clickHumanOverduem( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[35]"));
		return department;
	}
	
	public static WebElement clickHROverduem( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[41]"));
		return department;
	}
	
	public static WebElement clickHROverduem1( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[42]"));
		return department;
	}
	
	
	public static WebElement clickAccountOverdue( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	
	public static WebElement clickAccountOverdueA( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[20]"));
		return department;
	}
	
	public static WebElement clickAdminOverdueA( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	public static WebElement clickComplianceIsecOverdueDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[35]"));
		return department;
	}
	public static WebElement clickAdminOverdueAIn( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[37]"));
		return department;
	}
	
	public static WebElement clickAdminOverdueM( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	
	public static WebElement clickHROverdueM( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	
	public static WebElement clickAdminOverdueDeptIn( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return department;
	}
	
	
	public static WebElement clickFinanceOverdue( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[60]"));
		return department;
	}
	
	public static WebElement clickFinanceOverdueDept( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
		return department;
	}
	
	public static WebElement clickAccountOverdueDept( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
		return department;
	}
	
	public static WebElement clickHumanPendingReview( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[72]"));
		return department;
	}
	
	public static WebElement clickHumanPendingReviewm( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[45]"));
		return department;
	}
	
	public static WebElement clickHRPendingReviewm( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[20]"));
		return department;
	}
	

	public static WebElement clickHRPendingReviewm1( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[42]"));
		return department;
	}
	
	public static WebElement clickAccountPendingReview( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[36]"));
		return department;
	}
	
	public static WebElement clickAccountPendingReviewApp( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	
	public static WebElement clickAccountPendingReviewA( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[21]"));
		return department;
	}
	
	public static WebElement clickInProgress( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[45]"));
		return department;
	}

	
	
	public static WebElement clickAccountRejected( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[48]"));
		return department;
	}
	public static WebElement clickAccountInprogress( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[45]"));
		return department;
	}

	public static WebElement clickFinancePendingReview( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[70]"));
		return department;
	}
	
	public static WebElement clickAdminPendingReview( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[43]"));
		return department;
	}
	public static WebElement clickComplianceIsecPendingReviewDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[45]"));
		return department;
	}
	public static WebElement clickAdminPendingReviewIn( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[42]"));
		return department;
	}
	public static WebElement clickAdminInProgressIn( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[45]"));
		return department;
	}
	public static WebElement clickAdminRejectedIn( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[48]"));
		return department;
	}

	
	public static WebElement clickFinancePendingReviewDept( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[36]"));
		return department;
	}
	
	public static WebElement clickPendingReviewDept( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
		return department;
	}
	
	
	public static WebElement ClickInProgress( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[13]"));
		return department;
	}
	
	public static WebElement ClickRejected( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
		return department;
	}
	

	
	
	
	public static WebElement clickRejectDept( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
		return department;
	}
	
	public static WebElement clickinprogressDept( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[13]"));
		return department;
	}
	

	
	
	public static WebElement clickRejectSony( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[22]"));
		return department;
	}
	
	public static WebElement clickHumanNotApplicable( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
		return department;
	}
	
	public static WebElement clickHumanInprogress( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
		return department;
	}

	public static WebElement clickHumanRejected( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
		return department;
	}

	public static WebElement clickAdminNotApplicable( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[51]"));
		return department;
	}
	public static WebElement clickComplianceIsecNotApplicableDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[39]"));
		return department;
	}
	public static WebElement clickAdminDuetodayIn( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[54]"));
		return department;
	}

	
	public static WebElement clickAdminDueToday( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[40]"));
		return department;
	}

	public static WebElement clickAdminInprogress( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[45]"));
		return department;
	}
	public static WebElement clickAdminInRejected( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return department;
	}
	public static WebElement clickComplianceIsecInRejectedDemo( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[38]"));
		return department;
	}
	public static WebElement clickHRNotApplicable( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[24]"));
		return department;
	}
	
	public static WebElement clickDepartmentHighHuman1( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[32]"));
		return department;
	}
	
	public static WebElement clickDepartmentHighHuman2( )		//Method to search 'High Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[25]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman( )	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[26]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman1( )	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[41]"));
		return department;
	}
	
	public static WebElement clickDepartmentMediumHuman2( )	//Method to search 'Medium Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[29]"));
		return department;
	}


	public static WebElement clickDepartmentLowHuman( )		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman1( )		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[50]"));
		return department;
	}
	
	public static WebElement clickDepartmentLowHuman2( )		//Method to search 'Low Risk' bar of Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[33]"));
		return department;
	}
	
	public static WebElement clickDepartmentInTime( )		//Method to search 'In Time' bar under Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return department;
	}
	
	public static WebElement clickDepartmentAfterDueDate( )	//Method to search 'After Due Date' bar under Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
		return department;
	}
	
	public static WebElement clickDepartmentNotCompleted( )	//Method to search 'Not Completed' bar under Department Summary.
	{
		department = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
		return department;
	}
	
	public static WebElement clickDepartmentBack( )			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("(//*[@class=' highcharts-button-box'])[5]"));
		return department;
	}
	
	public static WebElement clickViewAllDU( )			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("//*[@id='dailyupdates']/div/div/div[4]/a"));
		return department;
	}
	
	
	
	public static WebElement clickView1( )			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdDailyUpdateList']/tbody/tr[2]/td[4]/a"));
		return department;
	}
	
	public static WebElement closeNewsView( )			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("//*[@id='NewsModal']/div/div/div[1]/button"));
		return department;
	}
	
	public static WebElement clickViewAllNL( )			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("//*[@id='collapseNewsletter']/div[3]/a"));
		return department;
	}
	
	public static WebElement clickView2( )			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdNewsLetterList']/tbody/tr[2]/td[4]/a"));
		return department;
	}
	
	public static WebElement closeNewsLView( )			//Method to search Back button of Completion Status Bar Graph
	{
		department = getDriver().findElement(By.xpath("//*[@id='myModal']/div/div/div[1]/button"));
		return department;
	}
	
	public static WebElement clickPenaltyCritical( )		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[27]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHigh( )		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril( )		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[27]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril1( )		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[58]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyHighApril2( )		//Method to search 'High Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMedium( )		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[40]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril( )		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[36]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril1( )		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[60]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyMediumApril2( )		//Method to search 'Medium Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[39]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLow( )			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[44]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril( )			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[39]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril1( )			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[62]"));
		return penlatysummary;
	}
	
	public static WebElement clickPenaltyLowApril2( )			//Method to search 'Low Risk' bar of Penalty Summary.
	{
		penlatysummary = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[42]"));
		return penlatysummary;
	}
	
	public static WebElement selectInternal( )				//Method to search Dropdown box to click on Internal in filters
	{
		Internal = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlStatus']"));
		return Internal;
	}
	
	public static WebElement clickApply( )					//Method to search Apply button after clicking on Internal in filters dropdown
	{
		Internal = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnTopSearch']"));
		return Internal;
	}//*[@id="ContentPlaceHolder1_btnTopSearch"]
	//*[@id="Applybtn1"]
	public static WebElement clickBSEHighInternal( )			//Searching 'High' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[2]"));
		return Internal;
	}
	
	public static WebElement clickBSEMediumInternal( )		//Searching 'Medium' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[6]"));
		return Internal;
	}
	
	public static WebElement clickBSELowInternal( )			//Searching 'Low' bar of BSE compliance in Performance Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[10]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccHigh( )		//Searching 'High' bar of Account compliance in Department Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[22]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccMedium( )		//Searching 'Medium' bar of Account compliance in Department Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[26]"));
		return Internal;
	}
	
	public static WebElement clickDepartmentAccLow( )		//Searching 'Medium' bar of Account compliance in Department Summary (Internal)
	{
		Internal = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[30]"));
		return Internal;
	}
	
	public static List<WebElement> readCategoriesList( )		//Method to read all interests in Penalty.
	{
		interestList = getDriver().findElements(By.xpath("//*[@onclick='window.parent.fCompliancesRahul();']"));
		return interestList;
	}
	
	public static List<WebElement> clickExpandGrading( )				//Method to search second red box of Grading Report
	{
		interestList = getDriver().findElements(By.xpath("//*[@class='tree-icon tree-closed']"));
		return interestList;
	}
	
	public static WebElement clickRedGrading( )				//Method to search second red box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating3'])[1]"));
		return grading;//*[@id="basic"]/tbody/tr[2]/td[3]
	}//*[@id="basic"]/tbody/tr[2]/td[4]
	public static WebElement clickRedGrading1( )				//Method to search second red box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating3'])[46]"));
		return grading;//*[@id="basic"]/tbody/tr[2]/td[3]
	}
	public static WebElement clickRedGrading2()				//Method to search second red box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating3'])[134]"));
		return grading;//*[@id="basic"]/tbody/tr[2]/td[3]
	}
	public static WebElement clickYellowGrading( )			//Method to search first yellow box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating2'])[1]"));
		return grading;
	}
	
	public static WebElement clickGreenGrading( )			//Method to search first green box of Grading Report
	{
		grading = getDriver().findElement(By.xpath("(//*[@class='GradingRating1'])[1]"));
		return grading;
	}
	
	public static WebElement clickDropdown( )				//Searching dropdown in Grading Report
	{
		grading = getDriver().findElement(By.xpath("//select[@name='ddlPageSize']"));
		return grading;
	}
	
	public static WebElement readTotalPagesGrading( )		//Searching total pages count element
	{
		grading = getDriver().findElement(By.xpath("//span[@id='lTotalCount']"));
		return grading;
	}
	
	public static WebElement clickNextArrow( )				//Searching next page arrow button in Grading Report
	{
		grading = getDriver().findElement(By.xpath("//input[@id='lBNext']"));
		return grading;
	}
	
	public static List<WebElement> countRecordsGrading( )	//Searching all serial numbers to count total records. 
	{
		totalRecords = getDriver().findElements(By.xpath("//*[@align='center']"));
		return totalRecords;
	}
	
	public static WebElement clickDetailsGrading( )			//Searching 'Details' link to click
	{
		grading = getDriver().findElement(By.xpath("//a[@id='lnkDetails']"));
		return grading;
	}
	
	public static WebElement clickGraphGrading( )			//Searching all values inside each bar of graph.
	{
		grading = getDriver().findElement(By.xpath("//li[@id='liGraph']"));
		return grading;
	}
	
	public static List<WebElement> readGraphCount( )			//Searching all the values inside each bar.
	{
		totalRecords = getDriver().findElements(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined ']"));
		return totalRecords; 
	}
	
	public static WebElement readDateComliance( )			//Searching the cornered value of the Red date
	{
		calendar = getDriver().findElement(By.xpath("(//*[@class='badge badge-warning overdue'])[1]"));
		return calendar;
	}
	
	public static WebElement clickDateCalendar( )			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = getDriver().findElement(By.xpath("(//div[@class='day sat past active'])[1]"));
		return calendar;
	}
	
	public static WebElement clickDateCalendar2( )			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = getDriver().findElement(By.xpath("(//*[@data-day='1'])[1]"));
		return calendar;
	}
	
	public static WebElement clickCalendarProgress( )			//CLicking the date on the calendar(first date of Red colour)
	{
		calendar = getDriver().findElement(By.xpath("//*[@id='imgcaldate']"));
		return calendar;
	}
	
	public static List<WebElement> clickDateCalendar1( )		//CLicking the date on the calendar(first date of Red colour)
	{
		elementsList = getDriver().findElements(By.xpath("(//*[@style='background-color: rgb(255, 0, 0);'])[1]"));
		return elementsList;
	}
	
	public static WebElement clickAllChecklist( )			//Searching "All(Including Checklist)" radio button
	{
		calendar = getDriver().findElement(By.xpath("//label[@for='ContentPlaceHolder1_rdbcalender_1']"));
		return calendar;
	}
	
	public static WebElement clickReports()					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']"));
		return reports;
	}
	public static WebElement clickReport()					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']//a"));
		return reports;
	}

	
	public static WebElement clickStandardReport( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Kendoreport']/a"));
		return reports;
	}
	
	public static WebElement clickSRInternal( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_myFunctionShowInternal']"));
		return reports;
	}
	
	
	public static WebElement closeExport( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-button k-bare k-button-icon k-window-action'])[3]"));
		return reports;
	}
	
	public static WebElement ClickDownload( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='grid12']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadLocation( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridLocation']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadUser( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridUser']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadCategory( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridCategory']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadRisk( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridRisk']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadDetaild( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridDetaild']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	public static WebElement ClickDownloadCriticalRisk( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridCriticalRisk']/div[2]/table/tbody/tr[1]/td[4]/a[1]"));
		return reports;
	}
	
	
	public static WebElement ClickPreview( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='grid12']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewLocation( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridLocation']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewUser( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridUser']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewCategory( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridCategory']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewRisk( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridRisk']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewDetailed( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridDetaild']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement ClickPreviewCriticalR( )					//Searching 'My Reports' element
	{
		reports = getDriver().findElement(By.xpath("//*[@id='gridCriticalRisk']/div[2]/table/tbody/tr[1]/td[4]/a[2]"));
		return reports;
	}
	
	public static WebElement clickDetailedReport( )			//Searching 'Detailed Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Myreport']"));
		return reports;
	}
	public static WebElement clickDetailedReports( )			//Searching 'Detailed Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Myreport']"));
		return reports;
	}

	public static WebElement SMETAReport( )			//Searching 'Detailed Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='SmetaMyreport']/a"));
		return reports;
	}
	
	public static WebElement clickActRepository( )			//Searching 'Detailed Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ActReporeport']/a"));
		return reports;
	}
	
	public static WebElement clickComplianceDropDown( )		//Searching the Compliance drop down
	{
		//reports = getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[2]"));
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div/div[1]/div[3]/div/div"));
		return reports;
	}
	
	public static List<WebElement> selectComplianceMenus( )	//Searching all sub menus of Compliance Dropdown
	{
		//menus = getDriver().findElements(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li"));
		menus = getDriver().findElements(By.xpath("//*[@id='1b781922-765f-4a56-a9cd-af38f09df1eb']//ul//li"));
		return menus;
	}
	
	public static WebElement clickMonthDropDown( )			//Searching Month dropdown
	{
		reports = getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[3]"));
		return reports;
	}
	
	public static WebElement clickAllMonths( )				//Selecting 'All' for  Month Dropdown
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownlistTypePastdata_listbox']/li[5]"));
		return reports;
	}
	
	public static WebElement clickAdvancedSearch( )				//Selecting 'All' for  Month Dropdown
	{
		reports = getDriver().findElement(By.xpath("//*[@id='AdavanceSearch']"));
		return reports;
	}
	
	
	public static WebElement selectDropDownMenu( )			//Searching Expanding arrow under dropdown box
	{
		reports = getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-expand'])[1]"));
		return reports;
	}
	
	public static WebElement selectMenu( )					//Searching the 18th checkbox to select
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[18]"));
		return reports;
	}
	
	public static WebElement selectMenu1( )					//Searching the 15th checkbox to select
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[15]"));
		return reports;
	}
	
	public static WebElement clickLastPageArrow( )			//Method to search arrow button to get last page
	{
		reports = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-arrow-end-right']"));
		return reports;
	}
	
	public static WebElement clickExportImage( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='export']"));
		return reports;
	}
	
	public static WebElement clickExportImageM( )
	{
		reports = getDriver().findElement(By.xpath("(//*[@id='export'])[2]"));
		return reports;
	}
	
	public static WebElement clickExportImage2( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
		return reports;
	}
	
	public static WebElement clickExportImage1( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Export']"));
		return reports;
	}
	
	
	
	public static WebElement clickStartDate1( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/span[2]/span/span/span"));
		return reports;
	}
	
	public static WebElement clickStartDate11( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Startdatepicker']"));
		return reports;
	}

	public static WebElement clickLastDate11( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Lastdatepicker']"));
		return reports;
	}
	
	public static WebElement clickAssignmentReport( )		//Searching 'Assignment Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Myreport1']/a"));
		return reports;
	}
	
	
	//button[@id='export']
	public static WebElement clickDropDown1( )				//Searching Entity DropDown in Assignment Report
	{
		reports = getDriver().findElement(By.xpath("//*[@class='txtbox']"));
		return reports;
	}
	
	public static WebElement clickEntity( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/div"));
		return reports;
	}
	
	public static WebElement clickExpand( )
	{
		reports = getDriver().findElement(By.xpath("//*[@data-role='treeview']/ul/li/div/span[1]"));
		return reports;
	}
	
	public static WebElement selectType( )				//Searching Entity DropDown in Assignment Report
	{
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return reports;
	}
	
	public static WebElement selectType2( )
	{
		reports = getDriver().findElement(By.xpath("(//*[@id='example']/div[1]/div/div)[1]"));
		return reports;
	}
	
	public static WebElement Status( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[4]/div/div/span[1]"));
		return reports;
	}
	
	public static WebElement Filter( )
	{
		reports = getDriver().findElement(By.xpath("//li[@class='k-item k-filter-item k-state-default k-last']"));
		return reports;
	}
	
	public static WebElement NotApplicable( )
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-label']/input)[3]"));
		return reports;
	}
	
	
	public static WebElement ClosedDelayed( )
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-label']/input)[4]"));
		return reports;
	}
	
	public static WebElement ClosedTimely( )
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[11]"));
		return reports;
	}
	
	public static WebElement ClosedDelayedA( )
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[10]"));
		return reports;
	}
	
	public static WebElement NotApplicableA( )
	{
		reports = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[15]"));
		return reports;
	}
	
	
	public static WebElement ClickFilter( )
	{
		reports = getDriver().findElement(By.xpath("//button[@class='k-button k-primary']"));
		return reports;
	}
	
	public static WebElement clickDocuments( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return documents;
	}
	
	public static WebElement clickComplianceDocuments( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='ComplianceDocumentList']"));
		return documents;
	}
	
	public static WebElement clickActDocuments( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='ActDocumentList']"));
		return documents;
	}
	
	public static WebElement clickMyEscalation( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='leftescalationmenu']/a"));
		return documents;
	}
	
	public static WebElement clickMyNotifications( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='alert_notificatoin_bar']/a/i"));
		return documents;
	}
	
	public static WebElement clickMessageCenter( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//i[@class='icon-envelope-l topmailbox']"));
		return documents;
	}
	
	public static WebElement clickViewBtnNO( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_GridNotifications_lnkShowDetails_0']"));
		return documents;
	}
	
	public static WebElement clickViewMsg( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdUserReminder']/tbody/tr[2]/td[6]/a"));
		return documents;
	}
	
	public static WebElement CloseViewNO( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']"));
		return documents;
	}
	
	public static WebElement clickDownloadBtn( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='rptComplianceVersion_btnComplinceVersionDoc_0']"));
		return documents;                      
	}
	
	public static WebElement clickDownloadBtn1( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='rptIComplianceVersion_btnComplinceVersionDoc_0']"));
		return documents;                      
	}
	
	public static WebElement closeDownloadTab( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='divDownloadView']/div/div/div[1]/button"));
		return documents;                      //*[@id="divOverViewMain1"]/div/div/div[1]/button
	}
	//*[@id="divDownloadView"]/div/div/div[1]/button
	public static WebElement closeDownloadTab1( )					//Searching 'My Reports' element
	{
		documents = getDriver().findElement(By.xpath("//*[@id='divDownloadView1']/div/div/div[1]/button"));
		return documents;                        //*[@id="divDownloadView1"]/div/div/div[1]/button
	}//*[@id="divDownloadView1"]/div/div/div[1]/button
	
	public static List<WebElement> clickType2( )
	{
		menus = getDriver().findElements(By.xpath("//div[@class = 'k-widget k-treeview']/ul/li"));
		return menus;                        
	}
	
	public static List<WebElement> clickSubMenu( )			//Searching first menu in Entity DropDown in Assignment Report
	{
		menus = getDriver().findElements(By.xpath("//*[@class='ContentPlaceHolder1_tvFilterLocation_2']"));
		return menus;
	}
	
	public static List<WebElement> clickDropDown2( )			//Searching for dropdown of 'No of Records' and 'Compliances'
	{
		menus = getDriver().findElements(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return menus;
	}
	
	public static WebElement clickShowDropDown( )		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']"));
		return reports;
	}
	
	public static WebElement clickAllDropDown( )		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_ddlStatus']"));
		return reports;
	}
	
	public static WebElement clickInternalSubmenu1( )		//Method to search Internal Compliance's Entity's first sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt1']"));
		return reports;
	}
	
	public static WebElement clickInternalSubmenu2( )		//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt2']"));
		return reports;
	}
	
	public static WebElement clickApply1( )					//Method to search 'Apply' button
	{
		reports = getDriver().findElement(By.xpath("//input[@value='Apply']"));
		return reports;
	}
	
	public static WebElement clickApplyAd( )					//Method to search 'Apply' button
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Applybtn1']"));
		return reports;
	}
	
	public static WebElement clickApplyF( )					//Method to search 'Apply' button
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Applyfilter']"));
		return reports;
	}
	
	public static WebElement clickApply3( )					//Method to search 'Apply' button
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnSearchPenalty']"));
		return reports;
	}
	
	public static WebElement readTotalPages( ) 				//Method to search Total pages count string
	{
		reports = getDriver().findElement(By.xpath("//span[@id='ContentPlaceHolder1_lTotalCount']"));
		return reports;
	}
	
	public static WebElement readTotalPages1( ) 				//Method to search Total pages count string
	{
		reports = getDriver().findElement(By.xpath("//span[@class='k-pager-info k-label']"));
		return reports;//*[@id="grid"]/div[4]/span[2]
	}
	
	public static WebElement clickNextButton( )				//Method to click on 'Next Button' arrow
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_lBNext']"));
		return reports;
	}
	
	public static WebElement clickExport1( )					//Searching Export to Excel button 
	{
		reports = getDriver().findElement(By.xpath("//input[@value='Export to Excel']"));
		return reports;
	}
	
	public static WebElement clickExportExcel( )					//Searching Export to Excel button 
	{
		reports = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
		return reports;
	}
	
	public static WebElement clickUsageReport( )				//Searching 'Usage Report' element under 'My reports'
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Myreport2']"));
		return reports;
	}
	
	public static WebElement clickStartDate( )				//Searching Start Date input box
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtStartDate']"));
		return reports;
	}
	
	public static WebElement clickEndDate( )					//Searching End Date input box
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_txtEndDate']"));
		return reports;
	}
	
	public static WebElement clickExport( )					//Searching Export to Excel button 
	{
		reports = getDriver().findElement(By.xpath("//input[@value='Export To Excel']"));
		return reports;
	}
	
	public static WebElement clickAuditReport( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='Auditreport']"));
		return reports;
	}
	
	public static WebElement clickEntityDropdown( )
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return reports;
	}
	
	public static WebElement clickExportReport( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddNew']"));
		return reports;
	}
	
	public static List<WebElement> getVendorNames( )
	{
		menus = getDriver().findElements(By.xpath("//*[@data-placement='bottom']"));
		return menus;
	}
	
	public static WebElement clickInternalSubmenu3( )	//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationt7']"));
		return reports;
	}
	
	public static WebElement clickAllYear( )			//Method to search Internal Compliance's Entity's second sub menu
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rbFinancialYearFunctionSummery_2']"));
		return reports;
	}
	
	public static WebElement waitProgress( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/div/div[1]"));
		return reports;
	}
	
	public static WebElement selectInternal1( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[4]"));
		return reports; 
	}
	
	public static WebElement clickType( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/span[1]"));
		return reports; 
	}
	
	public static WebElement selectType1( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownType_listbox']/li[4]"));
		return reports; 
	}
	
	public static WebElement clickFirstEntity( )
	{
		reports = getDriver().findElement(By.xpath("//*[contains(@id,'tv_active')]/div/span[2]/span"));
		return reports; 
	}
	
	public static WebElement clickPenaltyYear( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFinancialYear']"));
		return reports; 
	}
	
	public static WebElement clickYear( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlYearGrading']"));
		return reports; 
	}
	
	public static WebElement clickApply2( )
	{
		reports = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnGradingSearch']"));
		return reports; 
	}
	
	public static WebElement clickComplianceType( )
	{
		reports = getDriver().findElement(By.xpath("//*[@aria-owns='dropdownlistComplianceType_listbox']"));
		return reports; 
	}
	
	public static WebElement selectTypeInternal( )
	{
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
		return reports; 
	}
	
	public static WebElement selectMonth( )
	{
		//reports = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[3]"));
		reports = getDriver().findElement(By.xpath("//*[@id='example']/div/div[2]/span/span"));
		return reports; //*[@id="divAdvanceSearchModel"]/div[2]/span[2]/span/span[2]
	}
	public static WebElement StatusAll ()		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[3]"));
		return compliances;
	}
	public static WebElement selectMonth1( )
	{
		
		reports = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[2]/span/span[2]"));
		return reports; 
	}
	
	public static WebElement selectLastSixMon( )
	{
		
		reports = getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[3]"));
		return reports; 
	}//li[@class='k-item k-state-hover']
	
	public static WebElement clickTpes1( )
	{
		reports = getDriver().findElement(By.xpath(""));
		return reports; 
	}
	
	public static WebElement clickTyeps1( )
	{
		reports = getDriver().findElement(By.xpath(""));
		return reports; 
	}
	
	public static WebElement clickMyTask( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='main-content']/header/div[2]/ul/li[4]/ul/li[4]"));
		return compliances;
	} 
	
	public static WebElement Message( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='txtmsg']"));
		return compliances;
	} 
	
	public static WebElement Send( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Button3']"));
		return compliances;
	} 
	
	public static WebElement MessageClose( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='DivSendEmail']/div/div/div[1]/button"));
		return compliances;
	} 
	
	public static WebElement MessageDis( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Label1']"));
		return compliances;
	} 
	
	public static WebElement ComplianceType( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[normalize-space()='Compliance Type'])[1]"));
		return compliances;
	} 
	
	public static WebElement Statutory( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[20]"));
		return compliances;
	} 
	
	public static WebElement StatutoryM( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[20]"));
		return compliances;
	} 
	public static WebElement Innternal( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[normalize-space()='Internal'])[1]"));
		return compliances;
	} 

	public static WebElement InnternalCheck( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//span[normalize-space()='Internal CheckList'])[1]"));
		return compliances;
	} 

	
	public static WebElement EventBased( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[22]"));
		return compliances;
	} 
	
	public static WebElement EventBasedCheckList( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[25]"));
		return compliances;
	} 
	
	public static WebElement Internal( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[37]"));
		return compliances;
	} 
	
	public static WebElement StatutoryRe( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[20]"));
		return compliances;
	} 
	
	public static WebElement InternalM( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[18]"));
		return compliances;
	} 
	
	
	public static WebElement InternalRe( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[21]"));
		return compliances;
	} 
	
	
	public static WebElement Apply( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return compliances;
	} 
	
	public static WebElement ComplianceID( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='txtSearchComplianceID']"));
		return compliances;
	} 
	public static WebElement ComplianceID1( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='txtSearchComplianceID1']"));
		return compliances;
	} 
	public static WebElement Details( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='lidocuments']"));
		return compliances;
	} 
	public static WebElement Details1( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='lidocuments1']"));
		return compliances;
	} 
	public static WebElement APText( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='lblActionableProcedureText']"));
		return compliances;
	} 
	
	public static WebElement Period( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[2]/div[1]/span/span/span[2]/span"));
		return compliances;
	} 
	
	public static WebElement AllPeriod( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[5]"));
		return compliances;
	} 
	
	public static WebElement PeriodD( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[1]/span/span[2]/span"));
		return compliances;
	} 
	public static WebElement PeriodD1( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[1]/span/span[1]"));
		return compliances;
	} 
	public static WebElement ShortReport( )		//Method for reading Compliances value on Dashboard
	{
		compliances = getDriver().findElement(By.xpath("//*[@id='Myreport7']/a"));
		return compliances;
	} 
	
	 public static WebElement ComplianceTypeEventBased()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Event Based']"));
			return compliances;
	   	 
	    }
	    public static WebElement ComplianceTypeStatutoryCheckList()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Statutory CheckList']"));
			return compliances;
	   	 
	    }
	    public static WebElement ComplianceTypeEventBasedCheckList()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Event Based CheckList']"));
			return compliances;
	   	 
	    }
	    public static WebElement Status1()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Status']"));
			return compliances;
	   	 
	    }

	    public static WebElement Risk()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Risk']"));
			return compliances;
	   	 
	    }
	    public static WebElement SelectAllRisk()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label' and .='Select All'])[1]"));
			return compliances;
	   	 
	    }
	    
	    
	    public static WebElement RiskCritical()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Critical']"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskHigh()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='High']"));
			return compliances;
	    }
	    public static WebElement RiskMedium()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Medium']"));
			return compliances;
	    }
	    public static WebElement RiskLow()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Low']"));
			return compliances;
	    }
	    public static WebElement PeriodDropDown()
	    {
	    	compliances = getDriver().findElement(By.xpath("//div[@class='dashboard']//div//div[2]//div[1]//span[1]//span[1]//span[2]//span[1]"));
			return compliances;
	    }
	    public static WebElement PeriodAll()
	    {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[5]"));
			return compliances;
	    }
	    public static WebElement calendar()
	    {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[2]/div[2]/span[1]/span/span/span"));
			return compliances;
	    }
	    
	    public static WebElement calendar1()
	    {
	    	compliances = getDriver().findElement(By.linkText("1"));
			return compliances;
	    }
	    
	    
	    public static WebElement calendar2()
	    {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[2]/div[2]/span[2]/span/span/span"));
			return compliances;
	    }
	    
	    public static WebElement calendar12()
	    {
	    	compliances = getDriver().findElement(By.linkText("31"));
			return compliances;
	    }
	    
	    public static WebElement EndDate2()
	    {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='Lastdatepicker']"));
			return compliances;
	    }
	    public static WebElement Apply1()
	    {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
			return compliances;
	    }
	    public static WebElement readTotalItemsD11()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-pager-info k-label'])[1]"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement StartDate2()
	    {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='Startdatepicker']"));
			return compliances;
	    }
	    
	    
	    
	    
	   
	    public static WebElement RiskSummaryCriticalDueToday()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[13]"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusDueToday()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='DueToday']"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryCriticalClosedTimely()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusClosedTimely()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Closed Timely']"));
			return compliances;
	   	 
	    }
	   
	    public static WebElement StatusRejected()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Rejected']"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusNotApplicable()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Not Applicable']"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusPendingReview()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='In Progress']"));
			return compliances;
	   	 
	    }
	    
	  
	  
	    public static WebElement RiskSummaryCriticalClosedDelay()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
			return compliances;
	   	
	    }
	    public static WebElement StatusClosedDelay()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Closed Delayed']"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryCriticalNotCompleted()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusOverDue()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Overdue']"));
			return compliances;
	   	 
	    }
	    

	    public static WebElement StatusUpcoming()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Upcoming']"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusPendingForReview()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Pending For Review']"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement StatusInProgress()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='In Progress']"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusDeviationApplied()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Deviation Applied']"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusDeviationRejected()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Deviation Rejected']"));
			return compliances;
	   	 
	    }
	    public static WebElement StatusDeviationApproved()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Deviation Approved']"));
			return compliances;
	   	 
	    }
	    public static WebElement DepartmentFilter()
	    {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='dvDepartment']/div"));
			return compliances;
	   	 
	    }
	    public static WebElement DepartmentvalueAdmin()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='Admin']"));
			return compliances;
	   	 
	    }
	    
	  
	    public static WebElement RiskSummaryHighNotApplicable()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[18]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryHighDueToday()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[14]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryHighClosedTimely()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryHighClosedDelay()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryHighNotCompleted()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryMediumNotApplicable()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[19]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryMediumDueToday()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[15]"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryCritical()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("body > form:nth-child(1) > div:nth-child(10) > section:nth-child(2) > section:nth-child(2) > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(11) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > svg:nth-child(1) > g:nth-child(13) > text:nth-child(1) > tspan:nth-child(1)"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryHigh()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-6 > svg > g.highcharts-stack-labels > text:nth-child(2) > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryMedium()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-6 > svg > g.highcharts-stack-labels > text:nth-child(3) > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryLow()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-6 > svg > g.highcharts-stack-labels > text:nth-child(4) > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryCriticalD()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-8 > svg > g.highcharts-stack-labels > text:nth-child(1) > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryHighD()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-6 > svg > g.highcharts-stack-labels > text:nth-child(2) > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryMediumD()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-6 > svg > g.highcharts-stack-labels > text:nth-child(3) > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryLowD()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-6 > svg > g.highcharts-stack-labels > text:nth-child(4) > tspan"));
			return compliances;
	   	 
	    }
	    
	    
	    public static WebElement AdminCount()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-stack-labels > text:nth-child(1) > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement AdminCountD()
	    {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-stack-labels > text > tspan"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement RiskSummaryMediumClosedTimely()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[11]"));
			return compliances;
	   	
	    }
	    public static WebElement RiskSummaryMediumClosedDelay()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryMediumNotCompleted()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryLowNotApplicable()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[20]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryLowDueToday()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[16]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryLowClosedTimely()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[12]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryLowClosedDelay()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[8]"));
			return compliances;
	   	 
	    }
	    public static WebElement RiskSummaryLowNotCompleted()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
			return compliances;
	   	
	    }
	    public static WebElement DashBoardAfterCount()
	    {
	    	compliances = getDriver().findElement(By.xpath("//span[normalize-space()='My Dashboard']"));
			return compliances;
	   	 
	    }
	    
	    public static WebElement ClickTri()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[3]"));
			return compliances;
	   	
	    }
	    
	    public static WebElement ClickTri1()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[7]"));
			return compliances;
	   	
	    }
	    
	    public static WebElement ClickFilter1()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-filter'])[3]"));
			return compliances;
	   	
	    }
	    
	    public static WebElement ClickFilter2()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//button[@type='submit'][normalize-space()='Filter'])[2]"));
			return compliances;
	   	
	    }
	    
	    public static WebElement Search()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@placeholder='Search'])[3]"));
			return compliances;
	   	
	    }
	    
	    public static WebElement SearchCommercial()
	    {
	    	compliances = getDriver().findElement(By.xpath("//label[normalize-space()='Commercial']"));
			return compliances;
	   	
	    }
	    
	    public static WebElement SearchIA()
	    {
	    	compliances = getDriver().findElement(By.xpath("//label[normalize-space()='Internal Audit']"));
			return compliances;
	   	
	    }
	 
	    public static WebElement Clickcolumns()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-columns'])"));
			return compliances;
	   	
	    }
	    
	    public static WebElement ClickCat()
	    {
	    	compliances = getDriver().findElement(By.xpath("(//*[@data-field='ComCategoryName'])[2]"));
			return compliances;
	   	
	    }
	    
	    public static WebElement SatPerformerNotcompletedCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label'])[1]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement SatPerformerNotcompleted() {
	   	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label')]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedMediumCount() {
	    	compliances = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedCriticalCount() {
	    	compliances = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedHighCount() {
	    	compliances = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedLowCount() {
	    	compliances = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedoverdue() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 highcharts-drilldown-data-label'])[2]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedpendingforreview() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[2]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedRejected() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 highcharts-drilldown-data-label'])[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedInprogress() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])[2]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedOverdueName() {
	    	compliances = getDriver().findElement(By.cssSelector("#highcharts-4 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-pie-series.highcharts-color-0 > rect"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerNotcompletedduetoday() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])[2]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement Performersummaryclosedtimely() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 highcharts-drilldown-data-label'])[1]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement SatPerformerClosedtimelyCriticalCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerClosedtimelyHighCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerClosedtimelyMediumCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerClosedtimelyLowCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement SatPerformerCloseddelayCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 highcharts-drilldown-data-label'])"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement SatPerformerCloseddealyCriticalCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerCloseddealyHighCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerCloseddealyMediumCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement SatPerformerCloseddealyLowCount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 '])[1]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtmyreport() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']/a/span[1]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtdetailreport() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id=\"Myreport\"]/a"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtdetailreportcompliancetype() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[3]/div"));
	   	 	return compliances;
	   	 }
	    
	    public static WebElement mgmtdetailreportcompliancetypeselction() {
	    	compliances = getDriver().findElement (By.xpath("(//*[@class='k-checkbox-wrapper'])[20]"));
	   	 return compliances;
	   	 }
	    public static WebElement mgmtdetailreportcompliancestatus() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[4]/div"));
	   	 	return compliances;
	   	 }
	    public static WebElement mgmtdetailreportcompliancestatustype() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[11]"));
	   	 	return compliances;
	   	 }
	    public static WebElement mgmtdetailreportcompliancestatuscloseddelayed() {
	    	compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[10]"));
	   		 	return compliances;
	   		 }
	    
	    public static WebElement mgmtdetailreportcompliancestatuOvardue() {
	    	compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[7]"));
	   		 	return compliances;
	   		 }
	    
	    public static WebElement mgmtdetailreportcompliancestatuDuetoday() {
	    	compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[6]"));
	   		 	return compliances;
	   		 }
	    
	    public static WebElement mgmtdetailreportcompliancestatuPFR() {
	    	compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[8]"));
	   		 	return compliances;
	   		 }
	    
	    public static WebElement mgmtdetailreportcompliancestatuInpro() {
	    	compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[16]"));
	   		 	return compliances;
	   		 }
	    
	    public static WebElement mgmtdetailreportcompliancestatuRejected() {
	    	compliances = getDriver().findElement(By.xpath("(//span[@class='k-in'])[9]"));
	   		 	return compliances;
	   		 }
	    
	    public static WebElement mgmtdetailreportperiod() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[2]/div[1]/span"));
	   		 	return compliances;
	   		 }
	    public static WebElement mgmtdetailreportperiodselection() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[2]"));
	   		 	return compliances;
	   		 }
	    
	    public static WebElement mgmtdetailreportstatussel() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id=\"ffaed7a0-86e9-40d8-9638-a7e920d083d4_tv_active\"]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtdetailreportStatutorystatus() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[4]/div/div"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtdetailreportStatutorchecklistystatus() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[23]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtdetailreportEventbasestatus() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[22]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtdetailreportEventbasecheckliststatus() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[25]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtdetailreportperoid() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[2]/div[1]/span/span"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtdetailreportAllperoid() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[5]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtdetailreportstartdate() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='Startdatepicker']"));
	   	 	return compliances;
	   	 
	    }

	    public static WebElement mgmtdetailreportenddate() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='Lastdatepicker']"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtdetailreportApply() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement detailreportcount() {
	    	compliances = getDriver().findElement(By.xpath("//*[@id='grid']/div[5]/span[2]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtdetailreportcompliancestatusDueToday() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[6]"));
	   	 	return compliances;
	   }
	    public static WebElement mgmtdetailreportcompliancestatusOverdue() {
	    	compliances = getDriver().findElement(By.xpath("/html/body/div[10]/div/div[2]/ul/li[3]/div/span[2]"));
	   	 	return compliances;
	   	 
	    }
	    
	   public static WebElement mgmtdetailreportcompliancestatusPendingForReview() {
		   compliances = getDriver().findElement(By.xpath("/html/body/div[10]/div/div[2]/ul/li[4]/div/span[2]"));
	   	 	return compliances;
	   	 
	    }
	   public static WebElement mgmtdetailreportcompliancestatusRejected() {
		   compliances = getDriver().findElement(By.xpath("/html/body/div[10]/div/div[2]/ul/li[5]/div/span[2]"));
	   	 	return compliances;
	   	 
	   }
	    public static WebElement mgmtdetailreportcompliancestatusInprogress() {
	    	compliances = getDriver().findElement(By.xpath("/html/body/div[10]/div/div[2]/ul/li[12]/div/span[2]"));
	   	 	return compliances;
	   	 
	    }

	    public static WebElement mgmtdetailreportcompliancestatusNA() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='k-in'])[15]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtdashboardVotApplicablecount() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 highcharts-drilldown-data-label'])"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtCompletionStatusOverallCriticalFinanceandTaxation() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined highcharts-drilldown-data-label'])[3]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtCompletionStatusCriticalFinanceandTaxationClosedTimely() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtCompletionStatusCriticalFinanceandTaxationClosedDealyed() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
	   	 	return compliances;
	   	 
	    }
	    
	    public static WebElement mgmtCompletionStatusCriticalFinanceandTaxationNotCompleted() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
	   	 	return compliances;
	   	 
	    }
	    public static WebElement mgmtCompletionStatusCriticalFinanceandTaxationNotApplicable() {
	    	compliances = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
	   	 	return compliances;
	   	 
	    }
	   

	
	
	
	public static void CategoriesCountMatch(  ExtentTest test) throws InterruptedException, IOException
	{
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =CFOcountPOM.clickCategories().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		CFOcountPOM.clickCategories().click();
		Thread.sleep(5000);
		
	//	litigationPerformer.MethodsPOM.progress(getDriver());
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (200));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[3]/a")));
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItems4().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItems4().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
	/*	elementsList1 = CFOcountPOM.readCompliancesList(getDriver());
		elementsList1.get(1).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage(getDriver()).click();                    //export excel
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		.switchTo().parentFrame();								//Switching back to parent frame.
		Thread.sleep(3000);
		CFOcountPOM.closeCategories_Compliances(getDriver()).click();		//Closing the 'Compliances' pup up.
		Thread.sleep(2000);
	
		int n1 = elementsList1.size();
		int value = 0;
		int count1 = 0;
	//	for(int i = 0; i < n1; i++)
	//	{		
			Thread.sleep(500);
			elementsList1 = CFOcountPOM.readCompliancesList(getDriver());
			value = Integer.parseInt(elementsList1.get(1).getText());
			elementsList1.get(1).click();
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress(getDriver());
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));	//Wait until frame get visible and switch to it.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-grid-content k-auto-scrollable']")));
			Thread.sleep(4000);
			js.executeScript("window.scrollBy(0,3000)");				//Scrolling down window by 2000 px.
			Thread.sleep(1000);
			CFOcountPOM.readTotalItemsD(getDriver()).click();
			
			Thread.sleep(1000);
			String item1 = CFOcountPOM.readTotalItemsD(getDriver()).getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			
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
			CFOcountPOM.closeCategories_Compliances(getDriver()).click();		//Closing the 'Compliances' pup up.
			Thread.sleep(2000);
	//	}	*/
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
		
	}
	
	public static void Compliances(  ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Compliances =CFOcountPOM.readCompliances().getText();		//Storing old value of Statutory overdue.
	int	CompliancesCountDas = Integer.parseInt(string_Compliances);
		CFOcountPOM.readCompliances().click();
		Thread.sleep(7000);
		
	//	litigationPerformer.MethodsPOM.progress(getDriver());
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(10000);
		CFOcountPOM.clickExportImage().click();                    //export excel
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");	
		CFOcountPOM.clickLocation().click();
		Thread.sleep(500);
		CFOcountPOM.clickBitaAurangabad( ).click();
		Thread.sleep(1000);
		CFOcountPOM.clickClear( ).click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Clear Button is working Successfully");	
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		CFOcountPOM.readTotalItemsD( ).click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CFOcountPOM.readTotalItemsD( ).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int ComcountGrid = Integer.parseInt(compliancesCount);
		if(CompliancesCountDas == ComcountGrid)
		{
			test.log(LogStatus.PASS, "Number of Compliances grid matches to Dashboard Compliances  Count.");
			test.log(LogStatus.PASS, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		else
		{
			test.log(LogStatus.FAIL, "Number of compliances does not matches to Dashboard Statutory Compliances Count.");
			test.log(LogStatus.FAIL, "No of Compliances in the grid = "+ComcountGrid+" | Dashboard Compliances  Count = "+CompliancesCountDas);
		}
		js.executeScript("window.scrollBy(500,0)");						//Scrolling UP window by 2000 px.
		getDriver().switchTo().defaultContent();
		Thread.sleep(3000);
		CFOcountPOM.closeCategories( ).click();
	}
	
/*	public static void CountGrading( , ExtentTest test, String Risk) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Switching to iFrame.
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='k-grid-content k-auto-scrollable']")));
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,400)");
		Actions action = new Actions(getDriver());
		action.moveToElement(CFOcountPOM.readTotalItems1(getDriver())).click().perform();		//clicking on total pages count to scroll window down
		
		Thread.sleep(1000);
		CFOcountPOM.readTotalItems1(getDriver()).click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		for(int i = 0; i <= 3; i++)
		{
			if(itomsCount.equalsIgnoreCase("to"))							//If not items found
			{
				Thread.sleep(2500);
				s1 = CFOcountPOM.readTotalItems1(getDriver()).getText();
				bits = s1.split(" ");										//Splitting the String
				itomsCount = bits[bits.length - 2];
			}
			else
			{
				break;
			}
		}
		int count = Integer.parseInt(itomsCount);
		js.executeScript("window.scrollBy(0,-300)");
		
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFiles = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportImage(getDriver()).click();			//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads\\");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(allFiles.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, Risk+" :- File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(500);		
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			workbook.write(fos);
			fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			if(count == SheetRecords)
			{
				test.log(LogStatus.PASS, "Total records count displayed on grid matches with the number of records in the Excel Report.");
				test.log(LogStatus.PASS, "Total records count from grid = "+count+" | Total records count in the Excel Report = "+SheetRecords);
			}
			else
			{
				test.log(LogStatus.FAIL, "Total records count displayed on grid doesn't matches with the number of records in the Excel Report.");
				test.log(LogStatus.FAIL, "Total records count from grid = "+count+" | Total records count in the Excel Report = "+SheetRecords);
			}
		}
		else
		{
			test.log(LogStatus.PASS, Risk+" :- File didn't downloaded successfully.");
		}
		
		.switchTo().parentFrame();
		CFOcountPOM.closePopup(getDriver()).click();
	}*/
	
	public static void CountPenalty(  ExtentTest test, int valuePenalty) throws InterruptedException
	{
		int interest = 0;					//Variable created for reading Interest
		int penalty1 = 0;						//Variable created for reading Penalty
		
		Thread.sleep(500);
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 2000 px.
		CFOcountPOM.clickNextPage1( ).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		CFOcountPOM.readTotalItemsD( ).click();
		String s1 = CFOcountPOM.readTotalItemsD( ).getText();
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		int count = 0;
		int loop = 0;
		if(itomsCount.equalsIgnoreCase("to"))							//If items not found
		{
			for(int i = 0; i < 4; i++)
			{
				Thread.sleep(2000);
				s1 = CFOcountPOM.readTotalItemsD( ).getText();
				bits = s1.split(" ");									//Splitting the String
				itomsCount = bits[bits.length - 2];
				if(!itomsCount.equalsIgnoreCase("to"))					//If not items found
				{
					break;
				}
			}
		}
		count = Integer.parseInt(itomsCount);
		loop = count / 10;									//Dividing by 10, as total number of items in a list is 10
		
		int n2 = 0;
		for(int no = 0; no < loop+1; no++)
		{
			Thread.sleep(200);
			elementsList2 = CFOcountPOM.readPenalty( );			//Searching all values of Penalty
			n2 = elementsList2.size();
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			CFOcountPOM.clickNextPage1( ).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(50);			
			for(int i = 0; i < n2; i++)
			{
				action.moveToElement(elementsList2.get(i)).doubleClick().build().perform();
				Thread.sleep(50);
				int j = Integer.parseInt(elementsList2.get(i).getText());	//Reading each Compliance value.
				penalty1 = penalty1 + j;										//Calculating the read Compliance values.
			}
			
			if(CFOcountPOM.clickNextPage1( ).isEnabled())
			{
				Thread.sleep(100);
				CFOcountPOM.readTotalItemsD( ).click();				//Clicking to escape unwanted tooltips
				CFOcountPOM.clickNextPage1( ).click();
			}
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(1000,0)");						//Scrolling Up window by 2000 px.
		CFOcountPOM.clickInterest( ).click();						//Clicking on 'Interest' link/menu.
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("IFGradingGraphDisplay"));
		
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.loadGrid( )));	//Wait until the Interest Values displays
		Thread.sleep(100);
		CFOcountPOM.ClearButton( ).sendKeys(Keys.PAGE_DOWN);
		js.executeScript("window.scrollBy(0,2000)");						//Scrolling down window by 2000 px.
		
		Thread.sleep(1000);
		for(int no = 0; no < loop+1; no++)
		{
			Thread.sleep(200);
			elementsList1 = CFOcountPOM.readInterest( );			//Searching all values of Interest 
			int n1 = elementsList1.size();
			js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 2000 px.
			
			CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(100);
			for(int i = 0; i < n1; i++)
			{
				action.moveToElement(elementsList1.get(i)).doubleClick().build().perform();
				Thread.sleep(50);
				int j = Integer.parseInt(elementsList1.get(i).getText());	//Reading each Compliance value.
				interest = interest + j;									//Calculating the read Compliance values.
			}
			
			if(CFOcountPOM.clickNextPage1().isEnabled())
			{
				Thread.sleep(100);
				CFOcountPOM.readTotalItemsD().click();				//Clicking to escape unwanted tool tips
				CFOcountPOM.clickNextPage1().click();
			}
		}
		
		CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
		getDriver().switchTo().parentFrame();								//Switching back to Interest's parent frame.
		Thread.sleep(500);
		CFOcountPOM.closeCategories().click();					//Closing the 'Penalty' pop up.
		
		int total = interest + penalty1;
		
		if(total == valuePenalty)
		{
			test.log(LogStatus.PASS, "'Penalty' count matches to sum. Dashboard Value = " + valuePenalty + " | Sum of Penalty from 'Penalty' click = "+ total);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Penalty' count doesn't matches. Dashboard Value = " + valuePenalty + " | Sum of Penalty from 'Penalty' click = "+ total);
		}
	}
	
 	public static void GraphCount(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
 		
 		WebDriverWait wait = new WebDriverWait(getDriver(),(100));
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
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
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
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
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
			
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse= (JavascriptExecutor) getDriver();
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
	/*	try
		{
			elementsList = CFOcountPOM.selectDropdown();				//It is a dropdown but don't have Select tag.
			elementsList.get(0).click();									//Clicking on first 'Entity Location' Drop down.
			
			Thread.sleep(300);
			Actions action = new Actions(getDriver());
			if(Compliance.equalsIgnoreCase("Statutory"))
			{
				action.moveToElement(CFOcountPOM.selectFirst(getDriver())).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING PVT LTD)
			}
			else
			{
				action.moveToElement(CFOcountPOM.selectFirst1(getDriver())).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
			}
		}
		catch(Exception e)
		{
			
		}*/
		
//		CFOcountPOM.clickExportImage().click();
//		Thread.sleep(4000);
//		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
	
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
		
		
	}
 	
 	public static void GraphCount3(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
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
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(4000);
		}
		catch(Exception e)
		{
			
		}
		
	//	 CFOcountPOM.clickExportImage().click();
		//	Thread.sleep(4000);
	//		test.log(LogStatus.PASS, "Excel file Export Successfully");
		//	Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[3]/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton =getDriver() .findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		
		Thread.sleep(500);
	/*	try
		{
			elementsList = CFOcountPOM.selectDropdown();				//It is a dropdown but don't have Select tag.
			elementsList.get(0).click();									//Clicking on first 'Entity Location' Drop down.
			
			Thread.sleep(300);
		
			if(Compliance.equalsIgnoreCase("Statutory"))
			{
				action.moveToElement(CFOcountPOM.selectFirst()).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING PVT LTD)
			}
			else
			{
				action.moveToElement(CFOcountPOM.selectFirst1()).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
			}
		}
		catch(Exception e)
		{
			
		}*/
		
		CFOcountPOM.clickExportImage().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		//JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
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
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
		
		
	}
	
	
 	public static void GraphCountM(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		try
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));
			Thread.sleep(8000);
		}
		catch(Exception e)
		{
			
		}
		
	//	 CFOcountPOM.clickExportImage().click();
		//	Thread.sleep(4000);
	//		test.log(LogStatus.PASS, "Excel file Export Successfully");
		//	Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[17]/a");

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
	/*	try
		{
			elementsList = CFOcountPOM.selectDropdown();				//It is a dropdown but don't have Select tag.
			elementsList.get(0).click();									//Clicking on first 'Entity Location' Drop down.
			
			Thread.sleep(300);
		
			if(Compliance.equalsIgnoreCase("Statutory"))
			{
				action.moveToElement(CFOcountPOM.selectFirst()).click().build().perform();	//Selecting first option of the drop down. (BITA CONSULTING PVT LTD)
			}
			else
			{
				action.moveToElement(CFOcountPOM.selectFirst1()).click().build().perform();	//Selecting first option of the drop down. (ABCD PVT LTD)
			}
		}
		catch(Exception e)
		{
			
		}*/
		
		CFOcountPOM.clickExportImage().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
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
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
	}
	
 	
 	public static void GraphCountIn(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
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
		
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
			AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
			Thread.sleep(3000);
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

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
			Thread.sleep(3000);
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		
}else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
 	public static void GraphCountIn1(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(1000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(8000);
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
		
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(8000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
				AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
				Thread.sleep(3000);
			Thread.sleep(3000);
			
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "View Successfully");
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			test.log(LogStatus.PASS, "Doc Download Successfully");
			Thread.sleep(3000);
			ViewButton.get(2).click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
			Thread.sleep(1000);
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
		

			getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		
		Thread.sleep(3000);
}else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			Thread.sleep(1000);
			
		}
	}
	
 	public static void GraphCountInPe(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
			Thread.sleep(3000);
			
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(6000);
			
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(6000);
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
			
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
	
		
//		Thread.sleep(2000);
//		File dir = new File("C:\\Users\\shitalb\\Downloads");
//		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//		
//		Thread.sleep(500);
//		CFOcountPOM.clickExportImage().click();	//Exporting (Downloading) file
//		
//		Thread.sleep(3000);
//		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
//		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//		
//		Thread.sleep(3000);
//		if (dirContents.length < allFilesNew.length) {
//			test.log(LogStatus.PASS,  " Excel file Export Successfully.");
//		} else {
//			test.log(LogStatus.FAIL, " Excel file does not downloaded.");
//		}
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
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
 	
 	public static void GraphCountInPec(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(6000);
			
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(6000);
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
			
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
	
		
		Thread.sleep(2000);
//		File dir = new File("C:\\Users\\shitalb\\Downloads");
//		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//		
//		Thread.sleep(500);
//		CFOcountPOM.clickExportImage().click();	//Exporting (Downloading) file
//		
//		Thread.sleep(3000);
//		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
//		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//		
//		Thread.sleep(3000);
//		if (dirContents.length < allFilesNew.length) {
//			test.log(LogStatus.PASS,  " Excel file Export Successfully.");
//		} else {
//			test.log(LogStatus.FAIL, " Excel file does not downloaded.");
//		}
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
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
 	
	public static void GraphCountInPeUp(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
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
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		
		Thread.sleep(3000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(6000);
					
		List<WebElement> ViewButton = getDriver().findElements(locator);	
		Thread.sleep(6000);
					
		ViewButton.get(0).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "overView successfully");
		CFOcountPOM.closeDocument().click();
		Thread.sleep(3000);
					
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
			
				
		Thread.sleep(2000);
//		File dir = new File("C:\\Users\\shitalb\\Downloads");
//		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//				
//		Thread.sleep(500);
//		CFOcountPOM.clickExportImage().click();	//Exporting (Downloading) file
//				
//		Thread.sleep(3000);
//		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
//		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//				
//		Thread.sleep(3000);
//		if (dirContents.length < allFilesNew.length) {
//			test.log(LogStatus.PASS,  " Excel file Export Successfully.");
//		} else {
//		test.log(LogStatus.FAIL, " Excel file does not downloaded.");
//		}
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
				
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
	}
		else 
		{
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
 	
	public static void GraphCountInPeUp1(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
	{
		Thread.sleep(3000);
		if(risk.equalsIgnoreCase("Critical"))
		{
			CFOcountPOM.readCritical().click();					//Clicking on Critical value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("High"))
		{
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			CFOcountPOM.readMedium().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			CFOcountPOM.readLow().click();						//Clicking on Low value of Pie Chart of 'Not Completed'.
			Thread.sleep(1000);
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
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		
		Thread.sleep(3000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(6000);
					
		List<WebElement> ViewButton = getDriver().findElements(locator);	
		Thread.sleep(6000);
					
		ViewButton.get(0).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "overView successfully");
		CFOcountPOM.closeDocument().click();
		Thread.sleep(3000);
					
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
			
				
		Thread.sleep(2000);
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
				
		Thread.sleep(500);
		CFOcountPOM.clickExportImage().click();	//Exporting (Downloading) file
				
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
				
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " Excel file Export Successfully.");
		} else {
		test.log(LogStatus.FAIL, " Excel file does not downloaded.");
		}
		
		Thread.sleep(3000);
		if(CFOcountPOM.clickClear().isEnabled())
		{
				Thread.sleep(3000);
				CFOcountPOM.clickClear().click();
				test.log(LogStatus.PASS,"Clear Button Working Properly");
		}
		else
		{
			test.log(LogStatus.FAIL,"Clear Button does not Working Properly");
		}
				
		Thread.sleep(500);
		//ClearBtn().click();
	//	test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
	}
		else 
		{
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
 	
	
	public static void GraphCountInPeUpIn(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		//	test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		
		
		Thread.sleep(3000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(6000);
					
		List<WebElement> ViewButton = getDriver().findElements(locator);	
		Thread.sleep(6000);
					
		ViewButton.get(0).click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "overView successfully");
		CFOcountPOM.closeDocument().click();
		Thread.sleep(3000);
					
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
			
				
		Thread.sleep(2000);
//		File dir = new File("C:\\Users\\shitalb\\Downloads");
//		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//				
//		Thread.sleep(500);
//		CFOcountPOM.clickExportImage().click();	//Exporting (Downloading) file
//				
//		Thread.sleep(3000);
//		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
//		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//				
//		Thread.sleep(3000);
//		if (dirContents.length < allFilesNew.length) {
//			test.log(LogStatus.PASS,  " Excel file Export Successfully.");
//		} else {
//		test.log(LogStatus.FAIL, " Excel file does not downloaded.");
//		}
		
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
		Thread.sleep(3000);
		if(CFOcountPOM.clickClear().isEnabled())
		{
				Thread.sleep(3000);
				CFOcountPOM.clickClear().click();
				test.log(LogStatus.PASS,"while click On Clear Button selected filter should be cleared");
		}
		else
		{
			test.log(LogStatus.FAIL,"while click On Clear Button selected filter should not be cleared");
		}
				
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
	}
		else 
		{
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
 	
 	
 	public static void GraphCountInPe1(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		Thread.sleep(5000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
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
		
		Thread.sleep(2000);
//		File dir = new File("C:\\Users\\shitalb\\Downloads");
//		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//		
//		Thread.sleep(500);
//		CFOcountPOM.clickExportImage().click();	//Exporting (Downloading) file
//		
//		Thread.sleep(3000);//C://Users//jiya//Downloads//
//		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
//		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//		
//		Thread.sleep(3000);
//		if (dirContents.length < allFilesNew.length) {
//			test.log(LogStatus.PASS,  " Excel file Export Successfully.");
//		} else {
//			test.log(LogStatus.FAIL, " Excel file File does not downloaded.");
//		}
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(2000);
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories1().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
 	public static void GraphCountInPe1c(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		Thread.sleep(5000);
		getDriver().switchTo().parentFrame();
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

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
		
		Thread.sleep(2000);
//		File dir = new File("C:\\Users\\shitalb\\Downloads");
//		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//		
//		Thread.sleep(500);
//		CFOcountPOM.clickExportImage().click();	//Exporting (Downloading) file
//		
//		Thread.sleep(3000);//C://Users//jiya//Downloads//
//		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
//		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//		
//		Thread.sleep(3000);
//		if (dirContents.length < allFilesNew.length) {
//			test.log(LogStatus.PASS,  " Excel file Export Successfully.");
//		} else {
//			test.log(LogStatus.FAIL, " Excel file File does not downloaded.");
//		}
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
		Thread.sleep(2000);
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories1().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
 	
 	public static void GraphCountIn2(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[3]");

			Thread.sleep(3000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			ViewButton.get(1).click();
			test.log(LogStatus.PASS, "View Successfully");
			Thread.sleep(3000);
			ViewButton.get(2).click();
			test.log(LogStatus.PASS, "Doc Download Successfully");
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "overView Successfully");
			Thread.sleep(1000);
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			
			
		//JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
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
		//	test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count does not matches to numbers of Items.");
			test.log(LogStatus.FAIL, "'"+risk+"' risk compliance count = " + complianceCount + " | Total number of items from grid = "+count);
		}
		}
		else {
					
					Thread.sleep(2000);
					js.executeScript("window.scrollBy(300,0)");	
					Thread.sleep(2000);
					getDriver().switchTo().parentFrame();
					Thread.sleep(1000);
					CFOcountPOM.closeCategories().click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
						
				}
	}
	
 	public static void GraphCountIn3(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		Thread.sleep(3000);
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
		
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			Thread.sleep(3000);
			
  By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

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
		Thread.sleep(500);
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(3000);
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
		}
else {
			
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "'"+risk+"' risk  compliance count matches to numbers of items from grid.= 0");
				
		}
	}
	
 	
 	public static void GraphCount1(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(160));
		
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
			/*	ViewButton.get(3).click();
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
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
				AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
				Thread.sleep(3000);
	
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
		
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
 	
 	public static void PerformanceSummaryReopen(  ExtentTest test, String risk)throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(3000);
		CFOcountPOM.clickClosedTimely().click();
		Thread.sleep(4000);
	
			CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
	
			Thread.sleep(8000);
		WebDriverWait wait = new WebDriverWait(getDriver(),(160));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
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
		
		
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(3000);
				
				ViewButton.get(3).click();
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
					test.log(LogStatus.PASS, "Message Display :-  " +msg);
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(5000);
					
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(5000);
		
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	
 	
 	public static void GraphCount2(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException, IOException
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
		
		WebDriverWait wait = new WebDriverWait(getDriver(),(160));
		
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
		
		
		
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(0).click();
				Thread.sleep(5000);
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
		
//				CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
				AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
				Thread.sleep(3000);

		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
		Thread.sleep(1000);
		
		}else {
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "'"+risk+"' risk compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
 	
 	
	public static void BarGraphCount(  ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickBarClosedTimely().click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickBarClosedDelayed().click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickBarNotCompleted().click();			//Clicking on Not Completed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			Thread.sleep(2000);
			CFOcountPOM.clickBarNotApplicable().click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(),(200));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
		Thread.sleep(8000);
		
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItemsD().getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		if(count == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		
//		CFOcountPOM.clickExportImage().click();
//		Thread.sleep(4000);
//		test.log(LogStatus.PASS, "Excel file Export Successfully");
//		Thread.sleep(3000);
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
	
	
		Thread.sleep(2000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(2000);//Switching back to parent frame.
		CFOcountPOM.closeCategories().click();					//Closing the In Time compliance window.
		Thread.sleep(2000);
		
		}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(2000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void BarGraphCount1(  ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely().click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed().click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted().click();			//Clicking on Not Completed bar of Labour Category
			
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable().click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(500);
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
		
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItemsD().getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		if(count == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
		//	test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
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
	/*	
		elementsList = CFOcountPOM.selectDropdown();				//It is a dropdown but don't have Select tag.
		elementsList.get(0).click();									//Clicking on first dropdown
		Thread.sleep(500);
		action.moveToElement(CFOcountPOM.selectFirst()).click().build().perform();	//Selecting first option of the drop down.
		*/
		Thread.sleep(1000);
	
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories().click();					//Closing the In Time compliance window.
		
		}else {
			
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			Thread.sleep(1000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
		}
	}
	
	public static void BarGraphCountIn(  ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely().click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed().click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted().click();			//Clicking on Not Completed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable().click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		Thread.sleep(4000);
		
	
		String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
		String[] bits = s1.split(" ");									//Splitting the String
		String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
		
		if(itomsCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			s1 = CFOcountPOM.readTotalItemsD().getText();			//Reading total number of items.
			bits = s1.split(" ");										//Splitting the String
			itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
		}
		int count = Integer.parseInt(itomsCount);
		
		
		if(count == ComplianceCount)
		{
			//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
		}
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
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
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories().click();					//Closing the In Time compliance window.
		
		
	}else {
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(300,0)");	
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
		
		
		
	}
	}
	
	public static void BarGraphCountIn1(  ExtentTest test, String ComplianceType, int ComplianceCount)throws InterruptedException, IOException
	{
		Thread.sleep(500);
		if(ComplianceType.equalsIgnoreCase("Closed Timely"))
		{
			CFOcountPOM.clickBarClosedTimely().click();			//Clicking on Closed Timely bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Closed Delayed"))
		{
			CFOcountPOM.clickBarClosedDelayed().click();			//Clicking on Closed Delayed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Completed"))
		{
			CFOcountPOM.clickBarNotCompleted().click();			//Clicking on Not Completed bar of Labour Category
		}
		else if(ComplianceType.equalsIgnoreCase("Not Applicable"))
		{
			CFOcountPOM.clickBarNotApplicable().click();			//Clicking on Not Applicable bar of Labour Category
		}
		
		Thread.sleep(500);
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		
			CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
			String s1 = CFOcountPOM.readTotalItemsD().getText();		//Reading total number of items.
			String[] bits = s1.split(" ");									//Splitting the String
			String itomsCount = bits[bits.length - 2];						//Getting the second last word (total number of items)
			
			if(itomsCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				s1 = CFOcountPOM.readTotalItemsD().getText();			//Reading total number of items.
				bits = s1.split(" ");										//Splitting the String
				itomsCount = bits[bits.length - 2];							//Getting the second last word (total number of items)
			}
			int count = Integer.parseInt(itomsCount);
			
			
			if(count == ComplianceCount)
			{
				//test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count matches to numbers of items from grid.");
				test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
			}
			else
			{
				//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count doesn't matches to numbers of items from grid.");
				test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliances Count = " + ComplianceCount + " | Total number of items from grid = "+count);
			}
		Thread.sleep(4000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			Thread.sleep(3000);
			
By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
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
		getDriver().switchTo().parentFrame();								//Switching back to parent frame.
		CFOcountPOM.closeCategories().click();					//Closing the In Time compliance window.
		
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "'"+ComplianceType+"'  compliance count matches to numbers of items from grid.= 0");
			
			
			
		}
	}
	
	
	public static void RiskGraphCount(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
			Thread.sleep(4000);
//			CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
			AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
			Thread.sleep(3000);
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
				
				Thread.sleep(5000);
				 ViewButton.get(1).click();
			
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "Download Doc successfully");
			
				Thread.sleep(4000);
				ViewButton.get(2).click();
			
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				
			/*	ViewButton.get(3).click();
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
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(500);
	
	}
	
	public static void RiskGraphCountInternal(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
			Thread.sleep(4000);
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
			
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				
			/*	ViewButton.get(3).click();
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
		
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(500);
	
	}
	
	
	public static void RiskGraphCountNA(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		
		Thread.sleep(4000);
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
			Thread.sleep(3000);
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");

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
		Thread.sleep(500);
	
	}
	
	public static void RiskGraphCountNAC(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
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
				
				ViewButton.get(2).click();
			
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "overView successfully");
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);

		
		
		Thread.sleep(5000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(500);
	
	}
	
	public static void RiskGraphCountNAInternal(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	
		
		Thread.sleep(8000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
			test.log(LogStatus.PASS, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance Count doesn't matches to number of items from grid.");
			test.log(LogStatus.FAIL, "'"+ComplianceType+"' Compliance  Count = "+ ComplianceCount + " | Total no of items from grid = "+ count1);
		}
		Thread.sleep(4000);
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

		
		
		Thread.sleep(5000);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(500);
	
	}
	
	
	public static void RiskGraphReOpen(  ExtentTest test)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		Thread.sleep(4000);
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
		
		Thread.sleep(4000);
		List<WebElement>roc =getDriver() .findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		Thread.sleep(3000);
		CFOcountPOM.clickRiskMediumClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			Thread.sleep(7000);
		}
		catch(Exception e)
		{
			
		}
		
		
			
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				List<WebElement> ViewButton = getDriver().findElements(locator);	
				Thread.sleep(3000);
				ViewButton.get(3).click();
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
					test.log(LogStatus.PASS, "Message Display : - " +msg);
		Thread.sleep(1000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(5000);
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
	}
	
	
	public static void RiskGraphCount1(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");						//Scrolling down window by 1000 px.
		Thread.sleep(2000);
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
	/*	ApprovalcountPOM.Status().click();
		Thread.sleep(1000);
		
		ApprovalcountPOM.PFRDept().click();
		Thread.sleep(1000);
		ApprovalcountPOM.Status().click();
		Thread.sleep(4000);
		*/
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
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView Successfully");
			try
			{	Thread.sleep(2000);
				CFOcountPOM.closeDocument().click();
			
			}
			catch(Exception e)
			{
				Thread.sleep(2000);
				CFOcountPOM.closeDocument1().click();
			}
			Thread.sleep(3000);
		
		
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
	
	
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(500);
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		Thread.sleep(2000);
		
	}
	
	public static void RiskGraphCountIn(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Switching to iFrame.
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait until records table get visible.
			
		}
		catch(Exception e)
		{
			
		}
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
						//Closing the Not Completed compliance window.
		
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
		Thread.sleep(4000);
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
		     Thread.sleep(4000);
			test.log(LogStatus.PASS, "overView success");
			CFOcountPOM.closeDocument().click();
			Thread.sleep(3000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();	

	}
	
	public static void RiskGraphCountIn1(  ExtentTest test, String ComplianceType, int ComplianceCount, String Compliance)throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
	
		
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
//		 CFOcountPOM.clickExportImage().click();
//			Thread.sleep(4000);
//			test.log(LogStatus.PASS, "Excel file Export Successfully");
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
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
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(1000);
			}catch(Exception e) {
				CFOcountPOM.closeDocument().click();
				Thread.sleep(1000);
			}
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		CFOcountPOM.closeCategories().click();					//Closing the Not Completed compliance window.
		
		
	}
	
	public static void DetailedReportIn1(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(clickComplianceDropDown()));
		clickComplianceDropDown().click();		//Clicking on Compliance drop down.
		Thread.sleep(500);
	}
	
	public static void StandardReportOverall(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_header1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowSummarypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowSummarypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		
		if(ViewTextIOR().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Overall - View");
		}else {
			test.log(LogStatus.FAIL, " Overall - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownload().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Overall Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " Overall -Download");
				}
		
		ClickPreview().click();
		Thread.sleep(8000);
		Set w = getDriver().getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver() .switchTo().window(ch);         // switching child window
	    
	      getDriver().close();
	      test.log(LogStatus.PASS, " Overall -Preview");
	      getDriver() .switchTo().window(pw);         // switching parent window
	 //   //performer.OverduePOM.clickDashboard().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportLocation(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowlocationpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowlocationpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		
		if(ViewText().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Location - View");
		}else {
			test.log(LogStatus.FAIL, " Location - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownloadLocation().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Location Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " Location -Download");
				}
		
		ClickPreviewLocation().click();
		//Thread.sleep(5000);
		Thread.sleep(8000);
		Set w = getDriver().getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	    
	      getDriver() .close();
	      test.log(LogStatus.PASS, " Location -Preview");
	      getDriver().switchTo().window(pw);  
		////performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportUser(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton2']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowuserpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowuserpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		
		if(ViewTextUser().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Location - View");
		}else {
			test.log(LogStatus.FAIL, " Location - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownloadUser().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "User Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " User -Download");
				}
		 
		ClickPreviewUser().click();
		Thread.sleep(8000);
		Set w = getDriver().getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver() .switchTo().window(ch);         // switching child window
	    
	      getDriver() .close();
	      test.log(LogStatus.PASS, " User -Preview");
	      getDriver() .switchTo().window(pw);  
		////performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCategory(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton3']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowCategorypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowCategorypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		
		if(ViewTextCategory().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Location - View");
		}else {
			test.log(LogStatus.FAIL, " Location - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		 
		ClickDownloadCategory().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Category Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " Category -Download");
				}
		 
		ClickPreviewCategory().click();
		Thread.sleep(8000);
		Set w = getDriver().getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	    
	      getDriver() .close();
	      test.log(LogStatus.PASS, " Category -Preview");
	      getDriver().switchTo().window(pw);  
	//	//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportRisk(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton4']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowriskpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowriskpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		
		if(ViewTextRisk().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Location - View");
		}else {
			test.log(LogStatus.FAIL, " Location - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownloadRisk().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver() .switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Risk Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " Risk -Download");
				}
		 
		
		ClickPreviewRisk().click();
		Thread.sleep(8000);
		Set w = getDriver().getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	    
	      getDriver().close();
	      test.log(LogStatus.PASS, " Risk -Preview");
	      getDriver().switchTo().window(pw);  
	//	//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportDetailed (ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	
		Thread.sleep(4000);
		ClickDownloadDetaild().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Detailed Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " Detailed -Download");
				}
		
		ClickPreviewDetailed().click();
		Thread.sleep(8000);
		Set w = getDriver().getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	    
	      getDriver() .close();
	      test.log(LogStatus.PASS, " Detailed -Preview");
	      getDriver().switchTo().window(pw);  
		////performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCriticalRisk(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton6']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowcriticalriskpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[129]/div")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowcriticalriskpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[129]/div")));	//Wait until records table get visible.

		
		if(ViewTextCritical().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Location - View");
		}else {
			test.log(LogStatus.FAIL, " Location - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownloadCriticalRisk().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver() .switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Critical Risk  Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, " Critical Risk  -Download");
				}
		
		ClickPreviewCriticalR().click();
		Thread.sleep(8000);
		Set w =getDriver() .getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver() .switchTo().window(ch);         // switching child window
	    
	      getDriver().close();
	      test.log(LogStatus.PASS, "Critical Risk -Preview");
	      getDriver().switchTo().window(pw);  
		//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportOverallIn(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(4000);
		
	
		Thread.sleep(4000);
By locator1 = By.cssSelector("#ContentPlaceHolder1_myFunctionShowInternal");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(3000);
		
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
      JavascriptExecutor jse=(JavascriptExecutor) getDriver();
     
	jse.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(4000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_header1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(3000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalSummarypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalSummarypopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		
		if(ViewTextIORIn().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Overall - View");
		}else {
			test.log(LogStatus.FAIL, " Overall - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownload().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver() .switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Overall Internal-Download");	
				}
	//	test.log(LogStatus.PASS, "Overall Internal-Download");
		ClickPreview().click();
		Thread.sleep(8000);
		Set w =getDriver() .getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver() .switchTo().window(ch);         // switching child window
	    
	      getDriver()  .close();
	      test.log(LogStatus.PASS, "Overall Internal-Preview");
	      getDriver()  .switchTo().window(pw);         // switching parent window
	    //performer.OverduePOM.clickDashboard().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportLocationIN(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
By locator1 = By.cssSelector("#ContentPlaceHolder1_myFunctionShowInternal");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(3000);
		
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
      JavascriptExecutor jse=(JavascriptExecutor) getDriver();
     
	jse.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(4000);
	
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton1']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/*[@id='windowInternallocationpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[62]/div")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/*[@id='windowInternallocationpopup']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[62]/div")));	//Wait until records table get visible.

		
		if(ViewTextLoIn().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Location - View");
		}else {
			test.log(LogStatus.FAIL, " Location - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
	ClickDownloadLocation().click();
		Thread.sleep(4000);
try {
	String msg =getDriver() .switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
	test.log(LogStatus.PASS, "Message displayed -:- " + msg);
			
		}
		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Location Internal-Download");	
		}
		//test.log(LogStatus.PASS, "Location Internal-Download");
		ClickPreviewLocation().click();
		//Thread.sleep(5000);
		Thread.sleep(8000);
		Set w =getDriver() .getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver()  .switchTo().window(ch);         // switching child window
		    
	      getDriver()  .close();
	      test.log(LogStatus.PASS, "Location Internal-Perview");
	      getDriver()  .switchTo().window(pw);  
		//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportUserIN(ExtentTest test, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
By locator1 = By.cssSelector("#ContentPlaceHolder1_myFunctionShowInternal");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(3000);
		
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		Thread.sleep(4000);
      JavascriptExecutor jse=(JavascriptExecutor) getDriver();
     
	jse.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(4000);
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton2']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewTextUserIn']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewTextUserIn']/div/div[2]/div[2]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[13]/div[1]")));	//Wait until records table get visible.

		
		if(ViewTextUserIn().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " User - View");
		}else {
			test.log(LogStatus.FAIL, " User - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownloadUser().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver() .switchTo().alert().getText();
			Thread.sleep(2000);
		getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "User Internal-Download");	
				}
		//test.log(LogStatus.PASS, "User Internal-Download");
		ClickPreviewUser().click();
		Thread.sleep(8000);
		Set w =getDriver() .getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver()   .switchTo().window(ch);         // switching child window
	    
	      getDriver()   .close();
	      test.log(LogStatus.PASS, "User Internal-Preview");
	      getDriver() .switchTo().window(pw);  
		//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCategoryIN(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(8000);
By locator1 = By.cssSelector("#ContentPlaceHolder1_myFunctionShowInternal");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(3000);
		
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
      JavascriptExecutor jse=(JavascriptExecutor) getDriver();
     
	jse.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(4000);
		
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton3']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(2000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalCategorypopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalCategorypopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div")));	//Wait until records table get visible.

		
		if(ViewTextCategoryIn().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Category - View");
		}else {
			test.log(LogStatus.FAIL, " Category - View page not load");
		}
		closeExport().click();
		Thread.sleep(4000);
		
		ClickDownloadCategory().click();
		Thread.sleep(5000);
		try {
			String msg =getDriver() .switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Category Internal-Download");	
				}
	//	test.log(LogStatus.PASS, "Category Internal-Download");
		ClickPreviewCategory().click();
		Thread.sleep(8000);
		Set w =getDriver() .getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver()  .switchTo().window(ch);         // switching child window
	    
	      getDriver()  .close();
	      test.log(LogStatus.PASS, "Category Internal-Preview");
	      getDriver()  .switchTo().window(pw);  
		//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportRiskIN(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
By locator1 = By.cssSelector("#ContentPlaceHolder1_myFunctionShowInternal");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(3000);
		
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		Thread.sleep(4000);
      JavascriptExecutor jse=(JavascriptExecutor) getDriver();
     
	jse.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
		
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton4']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
//	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalriskpopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalriskpopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div")));	//Wait until records table get visible.

		
		if(ViewTextRiskIn().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Risk - View");
		}else {
			test.log(LogStatus.FAIL, " Risk - View page not load");
		}
		closeExport().click();
	
		Thread.sleep(4000);
		ClickDownloadRisk().click();
		Thread.sleep(3000);
		try {
			String msg = getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Risk Internal-Download");	
				}
		//test.log(LogStatus.PASS, "Risk Internal-Download");
		ClickPreviewRisk().click();
		Thread.sleep(8000);
		Set w =getDriver() .getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver()  .switchTo().window(ch);         // switching child window
	    
	      getDriver()  .close();
	     test.log(LogStatus.PASS, "Risk Internal-Preview");
	      getDriver() .switchTo().window(pw);  
		//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportDetailedIN (ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
By locator1 = By.cssSelector("#ContentPlaceHolder1_myFunctionShowInternal");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(3000);
		
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
      JavascriptExecutor jse=(JavascriptExecutor) getDriver();
     
	jse.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,600)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	
		Thread.sleep(3000);
		ClickDownloadDetaild().click();
		Thread.sleep(3000);
		try {
			String msg =getDriver() .switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Detailed Internal-Download");	
				}
	//	test.log(LogStatus.PASS, "Detailed Internal-Download");
		Thread.sleep(5000);
		ClickPreviewDetailed().click();
		Thread.sleep(8000);
		Set w =getDriver() .getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver()   .switchTo().window(ch);         // switching child window
	    
	      getDriver()  .close();
	     
	      getDriver()  .switchTo().window(pw);  
	      test.log(LogStatus.PASS, "Detailed  Internal-Preview");
		//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportCriticalRiskIN(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
  By locator1 = By.cssSelector("#ContentPlaceHolder1_myFunctionShowInternal");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(3000);
		
		WebElement ViewButton1 = getDriver().findElement(locator1);	
		Thread.sleep(4000);
      JavascriptExecutor jse=(JavascriptExecutor) getDriver();
     
	jse.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton6']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalriskpopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div")));	//Wait until records table get visible.

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='windowInternalriskpopup']/div/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div")));	//Wait until records table get visible.

		
		if(ViewTextRiskIn().isDisplayed())							//If not items found
		{
			test.log(LogStatus.PASS, " Critical Risk - View");
		}else {
			test.log(LogStatus.FAIL, "Critical Risk - View page not load");
		}*/
		test.log(LogStatus.PASS, "Critical Risk Internal-Export");
		closeExport().click();
		Thread.sleep(4000);
		ClickDownloadCriticalRisk().click();
		Thread.sleep(3000);
		try {
			String msg = getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
		getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + msg);
					
				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Critical Internal-Download");	
				}
		// test.log(LogStatus.PASS, "Critical Risk Internal-Download");
		ClickPreviewCriticalR().click();
		Thread.sleep(8000);
		Set w = getDriver().getWindowHandles();    // window handles
	      
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	    
	      getDriver().close();
	     
	      getDriver() .switchTo().window(pw); 
	      test.log(LogStatus.PASS, "Critical Risk Internal-Preview");
		//performer.OverduePOM.clickDashboard().click();
	//	ClickPreview().click();
		Thread.sleep(5000);
		
	}
	
	public static void StandardReportDepartment(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton7']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Critical Risk Internal-Export");
		closeExport().click();
		Thread.sleep(4000);

		//performer.OverduePOM.clickDashboard().click();
	
		Thread.sleep(5000);
		
	}
	
	
	
	public static void StandardReportDepartmentIN(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickStandardReport().click();
		Thread.sleep(7000);
		clickSRInternal().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1100)");					//Scrolling down window by 2600 px.
		Thread.sleep(1000);
	//	clickOverallImg().click();
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_ImageButton7']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Critical Risk Internal-Export");
		closeExport().click();
		Thread.sleep(4000);

		//performer.OverduePOM.clickDashboard().click();
	
		Thread.sleep(5000);
		
	}
	
	
	
	public static void DetailedReport1(ExtentTest test,  String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
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
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		
		Thread.sleep(4000);
//		CFOcountPOM.clickExportImage2().click();			//Exporting (Downloading) file
//		Thread.sleep(5000);
//		test.log(LogStatus.PASS, "Export file successfully");
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
		
	//	By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument2().click();
		test.log(LogStatus.PASS, "overView successfully");
	//	CFOcountPOM.closeDocument1().click();
		Thread.sleep(4000);
		//test.log(LogStatus.PASS, " : -Clear Button Working Successfully ");
	/*	clickAdvancedSearch().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	//	clickExportExcel().click();
		Thread.sleep(3000);//*[@id="grid"]/div[2]/table/tbody/tr[1]/td/a
	//	By locator1 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor);
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "AdvancedSearch - overView successfully");
		Thread.sleep(1000);
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close =getDriver() .findElement(locator3);	
		Thread.sleep(4000);
	//JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
		Thread.sleep(4000);
	//	CFOcountPOM.closeDocument2().click();
		Thread.sleep(4000);
		clickExportExcel().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "AdvancedSearch - Exporting (Downloading) file successfully");
	/*	selectMonth1().click();
		Thread.sleep(3000);
		
		selectLastSixMon().click();
		Thread.sleep(2000);
		clickApplyAd().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel().click();
			Thread.sleep(2000);//*[@id="grid1"]/div[2]/table/tbody/tr[1]/td/a
			By locator2 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 =getDriver() .findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor);
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			//test.log(LogStatus.PASS, "AdvancedSearch - overView successfully");
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(4000);
			clickExportExcel().click();
			Thread.sleep(3000);
			//clickStartDate1().click();
			clickStartDate11().sendKeys("23-Nov-2022");
			clickLastDate11().sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			clickApplyAd().click();
			Thread.sleep(2000);
			closeDocumentAS().click();
			Thread.sleep(2000);*/
		//	test.log(LogStatus.PASS, "Advanced Search : -Clear Button Working Successfully ");
			//performer.OverduePOM.clickDashboard().click();
	}
	
	public static void DetailedReportReOpen(ExtentTest test  ) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	    
		Thread.sleep(3000);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
	//	CFOcountPOM.StatutoryM().click();
		 List<WebElement>entitytype =getDriver() .findElements(By.xpath("(//*[@class='k-checkbox-wrapper'])"));
			selectOptionFromDropDown_bs(entitytype, "Statutory");
		
			Thread.sleep(2000);
			
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(4000);
		
		CFOcountPOM.Period().click();
		Thread.sleep(4000);
		CFOcountPOM.AllPeriod().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a")));
		/*Status().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		Filter().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		ClosedTimely().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		ClosedDelayed().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(1000);
		ClickFilter().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(5000);*/
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		By	 locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a[2]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement	 ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark().sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen().click();
		Thread.sleep(8000);
		String msg =getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		test.log(LogStatus.PASS, "Message Display : -" +msg);
Thread.sleep(1000);
getDriver().switchTo().parentFrame();
		}else {
			test.log(LogStatus.PASS, "No records found.");
		}

Thread.sleep(2000);
//performer.OverduePOM.clickDashboard().click();
Thread.sleep(2000);
	}
	
	
	public static void DetailedReport2(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		Thread.sleep(2000);
	WebElement select=getDriver().findElement(By.xpath("//*[@id='example']/div/div[1]/div[1]/span"));
	select.click();//*[@id="divAdvanceSearchModel"]/div[1]/div[1]/span
	getDriver() .findElement(By. xpath("//*[@id='dropdownlistUserRole_listbox']/li[3]")).click();
		Thread.sleep(1000);
		getDriver() .findElement(By.xpath("//*[@id='Applybtn']")).click();
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();			//Exporting (Downloading) file
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Excel file Export Successfully");
		By locator = By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td/a[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		CFOcountPOM.closeDocument1().click();
		test.log(LogStatus.PASS, "overView Successfully");
	//	CFOcountPOM.closeDocument1().click();
		Thread.sleep(4000);
		clickAdvancedSearch().click();
		Thread.sleep(4000);
		WebElement select1=getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/span"));
		select1.click();//*[@id="divAdvanceSearchModel"]/div[1]/div[1]/span
		getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole1_listbox']/li[3]")).click();
			Thread.sleep(1000);
			getDriver().findElement(By.xpath("//*[@id='Applybtn1']")).click();
			Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(5000);
	//	clickExportExcel().click();
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a[1]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
	
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		
		WebElement close =getDriver() .findElement(locator3);	
		Thread.sleep(4000);

	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", close);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "AdvancedSearch - overView successfully");
		Thread.sleep(4000);
		clickExportExcel().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "AdvancedSearch - Exporting (Downloading) file successfully");
	/*	selectMonth1().click();
		Thread.sleep(3000);
		
		selectLastSixMon().click();
		Thread.sleep(2000);
		clickApplyAd().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
		Thread.sleep(5000);
		//	clickExportExcel().click();
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a[1]");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 =getDriver() .findElement(locator1);	
			Thread.sleep(4000);
		JavascriptExecutor jse2=(JavascriptExecutor);
		Thread.sleep(2000);
		jse1.executeScript("arguments[0].click();", ViewButton2);
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Advanced Search : -overView success");
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(4000);
			clickExportExcel().click();
			Thread.sleep(3000);
			//clickStartDate1().click();
			clickStartDate11().sendKeys("23-Nov-2022");
			clickLastDate11().sendKeys("30-Nov-2022");
			Thread.sleep(2000);
			clickApplyAd().click();
			Thread.sleep(2000);*/
			closeDocumentAS().click();
			Thread.sleep(4000);
		/*	.findElement(By.xpath("//*[@id='txtSearchComplianceID']")).sendKeys("93635");
			Thread.sleep(4000);
			.findElement(By.xpath("//*[@id='Applybtn']")).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			Thread.sleep(2000);
			.findElement(By.xpath("//*[@id='divLocationMain']/div")).click();
			Thread.sleep(4000);
			.findElement(By.xpath("//*[@id='db873bda-b92d-4edb-91c3-e644f7d4b04d_tv_active']/div/span[1]")).click();
			Thread.sleep(4000);*/
			test.log(LogStatus.PASS, "Advanced Search : -Clear Button Working Successfully ");
			//performer.OverduePOM.clickDashboard().click();
	}
	
	
	
	public static void DetailedReport(ExtentTest test, String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (70));
	    
		Thread.sleep(500);
		clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
		
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickUserDropDown()));
		//OverduePOM.clickUserDropDown().click();		//Clicking on User DropDown
		Thread.sleep(300);
		//OverduePOM.clickReviewer().click();			//CLicking on Performer under User DropDown.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
	/*	
	
		Thread.sleep(500);
		action.moveToElement(CFOcountPOM.selectMonth()).click().perform();		//Clicking on Months drop down.
		Thread.sleep(500);
		action.moveToElement(clickAllMonths()).click().perform();		//Select 'All' from drop down.
		*/
		Thread.sleep(3000);
		CFOcountPOM.selectMonth().click();
		clickAllMonths().click();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(500);
		DetailedCompliances(test,0,"Statutory");
		/*DetailedCompliances(test,,1,"Internal");
		DetailedCompliances(test,,2,"Event Based");
		DetailedCompliances(test,,3,"Statutory Checklist");
		DetailedCompliances(test,,4,"Internal Checklist");
		DetailedCompliances(test,,5,"Event Based Checklist");
		DetailedCompliances(test,,6,"All Types");
		*/
		Thread.sleep(500);
		//performer.OverduePOM.clickDashboard().click();
	}
	
	public static void DetailedCompliances(ExtentTest test, int i, String Compliance) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),  (30));
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,-1000)");				//Scrolling window up.
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(clickComplianceDropDown()));
		clickComplianceDropDown().click();		//Clicking on Compliance drop down.
		Thread.sleep(500);
		menus = selectComplianceMenus();			//Getting menus list
    	 menus.indexOf(i);                                           //Selecting ith menu
		//menus.get(i).click();	
		 
		Thread.sleep(500);
		try 
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		}
		catch(Exception e)
		{
			
		}
		
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
		Thread.sleep(500);
		String s1 = CFOcountPOM.readTotalItemsD().getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		
		if(bits.length - 2 < 2)
		{
			Thread.sleep(1000);
			s1 = CFOcountPOM.readTotalItemsD().getText();	//Reading the total items count in String
			bits = s1.split(" ");								//Splitting the String
			itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		}
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.PASS, "No records found for '"+Compliance+"'.");
			getDriver().navigate().refresh();
		}
		else
		{
			js.executeScript("window.scrollBy(0,-1000)");					//Scrolling down window by 2600 px.
			
		//	String file = "//home//ashitosh-avantis//Downloads//Detailed Report .xlsx";
			String file = "C:\\Users\\shitalb\\Downloads\\Report.xlsx";
			Detailed( file, Compliance, test);
		}
		 
	}
	

	public static void Detailed( String file, String compliance, ExtentTest test) throws InterruptedException, IOException
	{
		File dir = new File("C://Users//snehalp//Downloads");
		File[] allFiles = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(1000);
		CFOcountPOM.clickExportImage().click();			//Exporting (Downloading) file
		
		Thread.sleep(4000);
		File dir1 = new File("C://Users//snehalp//Downloads");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(allFiles.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, compliance+" :- File downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
		   
			Thread.sleep(500);		
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
		//	FileOutputStream fos = new FileOutputStream(lastModifiedFile);
		//	workbook.write(fos);
		//	fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
			js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 2600 px.
			
			if(compliance.equalsIgnoreCase("Statutory CheckList"))
				Thread.sleep(1500);
			else
				Thread.sleep(500);
			CFOcountPOM.readTotalItemsD();				//clicking on Total items count to scroll down.
			
			String s1 = CFOcountPOM.readTotalItemsD().getText();	//Reading the total items count in String
			String[] bits = s1.split(" ");								//Splitting the String
			String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
			int count;
			if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
			{
				count = 0;
			}
			else
			{
				count = Integer.parseInt(itomsCount);
			}
			
			if(count == SheetRecords)
			{
				test.log(LogStatus.PASS, compliance + " :- No of Records in sheet matches to the number of items.");
				test.log(LogStatus.PASS, "Number of records in downloaded sheet = " +SheetRecords+ " | No of items in grid = "+count);
			}
			else
			{
				test.log(LogStatus.FAIL, compliance + " :- No of Records in sheet doesn't matches to the number of items.");
				test.log(LogStatus.FAIL, "Number of records in downloaded sheet = " +SheetRecords+ " | No of items in grid = "+count);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, compliance+" :- File does not downloaded.");
		}
	}
	
	public static void ActDocuments(ExtentTest test  ) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(5000);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickActDocuments().click();			//Clicking on 'Act Documents ' 
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		
		 By locator = By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[2]/td[5]/a");
		//*[@id="grid"]/div[4]/table/tbody/tr[1]/td[5]/a[1]
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews"));
			Thread.sleep(4000);
			if(CFOcountPOM.ViewDoc().isDisplayed()) {
				test.log(LogStatus.PASS,   " Act Documents:-After Clicking on View - View document Button Displyed ");
			}
			Thread.sleep(3000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDocument1().click();
		Thread.sleep(3000);
			test.log(LogStatus.PASS,   " Act Documents:-View Successfully ");
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews"));
			getDriver().findElement(By.xpath("//*[@id='basic']/tbody/tr[2]/td[2]")).click();
			Thread.sleep(4000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS,   " Act Documents:-Download Successfully ");
			//performer.OverduePOM.clickDashboard().click();
			Thread.sleep(3000);
	}
	
	public static void ComplianceDocuments(ExtentTest test  ) throws InterruptedException, IOException
	{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
			Thread.sleep(1000);
			CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
			Thread.sleep(3000);
			CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
			Thread.sleep(2000);
			By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "  View successfully.");
			CFOcountPOM.closeViewDoc().click();
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
			CFOcountPOM.closeOverViewDoc().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "  OverView successfully.");
			 By locator1 = By.xpath("//*[@id='sel_chkbxMain']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes =getDriver() .findElements(locator1);	
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
			/*	elementsList = CFOcountPOM.selectDropdown();				//It is a dropdown but don't have Select tag.
					elementsList.get(0).click();									//Clicking on first dropdown
					Thread.sleep(500);
				
					
					action.moveToElement(CFOcountPOM.selectFirst()).click().build().perform();	//Selecting first option of the drop down.
					Thread.sleep(500);
					CFOcountPOM.clickClear().click();
					Thread.sleep(1000);*/
					test.log(LogStatus.PASS, "Clear Button Working");
				CFOcountPOM.clickAdvancedSearch().click();
				Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='k-selectable'])[2]")));	//Wait till records table gets visible
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[4]")).click();
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a");

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
				CFOcountPOM.closeDocumentAS().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " Advanced Search - After Checking Multiple checkbox  File downloaded successfully.");
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Advanced Search - Clear Button Working");
				//OverduePOM.clickDashboard().click();
		
	}
	
	public static void ComplianceDocumentsSta(ExtentTest test  ) throws InterruptedException, IOException
	{
		
WebDriverWait wait = new WebDriverWait(getDriver(),(140));
	    
		Thread.sleep(1000);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
		CFOcountPOM.PeriodD().click();
		Thread.sleep(4000);
		CFOcountPOM.AllPeriod().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		 By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a");
		
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
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "  File downloaded successfully.");
			ViewButton.get(1).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "  OverView successfully.");
			 By locator1 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes =getDriver() .findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				ChechBoxes.get(1).click();
				Thread.sleep(500);
				ChechBoxes.get(3).click();
				Thread.sleep(3000);
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " After Checking Multiple checkbox  File downloaded successfully.");
			
				//OverduePOM.clickDashboard().click();
		
	}
	
	public static void ActRepository(ExtentTest test  ) throws InterruptedException, IOException
	{
		
           WebDriverWait wait = new WebDriverWait(getDriver(), (160));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		
//		Actions a = new Actions();
//		//scroll down a page
//		a.sendKeys(Keys.PAGE_DOWN).build().perform();				//Scrolling down window by 1000 px.
			Thread.sleep(3000);
		CFOcountPOM.clickActRepository().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);//*[@id="divOverView1"]/div/div/div[1]/button
		getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[11]/a")).click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "OverView Successfully");
		Thread.sleep(3000);
		//OverduePOM.clickDashboard().click();
		
	}
	
	public static void AuditReport(ExtentTest test  ) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(30));
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();				//Clicking on 'My Reports'
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(500);
		CFOcountPOM.clickAuditReport().click();			//Clicking on 'Assignment Report'
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(CFOcountPOM.clickShowDropDown()));
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickAllDropDown()));
		
		String vendors = "All Vendors";
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles();					//Counting number of files in directory before download
		
		Thread.sleep(500);
	
//		action.moveToElement(CFOcountPOM.clickExportReport()).click().build().perform();	//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles();					//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, "File downloaded successfully.");
			
		/*	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(3000);		
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			
			elementsList1 = CFOcountPOM.getVendorNames();
			int n = elementsList1.size();
			int flag = 0;
			int noVendors = n - 5;							//Counting displayed vendors to match with sheet count.
			for(int i = 5; i < n; i++)						//i = 5 as first five elements are other than required.
			{
				String vendor = elementsList1.get(i).getText();
				int no = sheet.getLastRowNum();
				for(int j = 3; j < no; j++)					//j = 3 as first three rows of sheet are of no use
				{
					Row r = sheet.getRow(j);				//Here j refers to row no. (Row no varies)
					Cell c1 = r.getCell(1);					//Getting vendor name from column 1 (Column no is static)
					String vendor1 = c1.getStringCellValue();	//Reading vendor name from cell;
					if(vendor.equalsIgnoreCase(vendor1))
					{
						flag = flag + 1;
						break;
					}
				}			
			}
			
			if (flag == noVendors)
			{
				test.log(LogStatus.PASS, vendors + " - Displayed vendor names are present in sheet");	
			}
			else
			{
				test.log(LogStatus.PASS, vendors + " - Displayed vendor names are not present in sheet");
			}*/
		}
		else
		{
			test.log(LogStatus.FAIL, "File does not downloaded.");
		}
		Thread.sleep(500);
		
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdReviewerComplianceDocument_lbkView_0']")).click();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//*[@id='divViewDocument']/div/div/div[1]/button")).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS,"View Successfully");
		//performer.OverduePOM.clickDashboard().click();
		Thread.sleep(3000);
	}
	
	
	public static void AssignmentReport(ExtentTest test  ) throws InterruptedException, IOException
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
		
		selectType2().click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2();
		elementsList.get(1).click();
		
		String file = "D:\\Automation File\\Charge.xlsx";
		String compliance = "Statutory";
		Assignment( test, file, compliance);
//		Thread.sleep(1000);
//		OverduePOM.clickClearBtn().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS,"Clicking Clear Button - clear Data Succefully");
		Thread.sleep(1000);
		
		//------------------------------------- Event Based ------------------------------------
	/*	
		selectType2().click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2();
		elementsList.get(1).click();					//Unselecting preselected 'Statutory' checkbox
		elementsList.get(3).click();					//Selecting 'Event Based' checkbox.
				
		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
				
		file = "C://Users//jiya//Downloads//InternalReport.xlsx";
		compliance = "Event Based";
		//Assignment(, test, file, compliance);
		*/
		//------------------------------------- Internal ------------------------------------
		
		selectType2().click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2();
		elementsList.get(1).click();					//Unselecting preselected 'Event Based' checkbox
		elementsList.get(4).click();					//Selecting 'Internal' checkbox.
		
		Thread.sleep(500);
//		//litigationPerformer.MethodsPOM.progress();
		
		file = "D:\\Automation File\\Charge.xlsx";
		compliance = "Internal";
		Assignment( test, file, compliance);
		Thread.sleep(1000);
		/*OverduePOM.clickClearBtn().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS,"Clicking Clear Button - clear Data Succefully");
		Thread.sleep(1000);*/
		//OverduePOM.clickDashboard().click();
	}
	
	public static void AssignmentReportSta(ExtentTest test  ) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(1000);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		selectType2().click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2();
		elementsList.get(1).click();
		
		String file = "C:\\Users\\mayurig\\Downloads\\Report.xlsx";
		String compliance = "Statutory";
		Assignment( test, file, compliance);
		Thread.sleep(1000);
		
		//OverduePOM.clickDashboard().click();
	}
	
	
	public static void AssignmentReportIn(ExtentTest test  ) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(),(50));
		
	//	Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		
		Thread.sleep(500);
		CFOcountPOM.clickAssignmentReport().click();			//Clicking on 'Assignment Report'
		
		//------------------------------------ Statutory ------------------------------------
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='k-selectable']")));	//Wait till records table gets visible
		
		
		
		//------------------------------------- Internal ------------------------------------
		
		selectType2().click();					//Clicking on Type drop down
		Thread.sleep(500);
		elementsList = clickType2();
		//elementsList.get(3).click();					//Unselecting preselected 'Event Based' checkbox
		elementsList.get(5).click();					//Selecting 'Internal' checkbox.
	//	elementsList.get(5).click();
		Thread.sleep(1000);
		//litigationPerformer.MethodsPOM.progress();
		
		String	file = "C:\\Users\\mayurig\\Downloads\\Report.xlsx";
		String	compliance = "Internal";
		Assignment(test, file, compliance);
		Thread.sleep(1000);
		Thread.sleep(1000);
		OverduePOM.clickDashboard().click();
	}
	
	
	
	public static void Assignment(  ExtentTest test, String file, String compliance) throws InterruptedException, IOException
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
//Thread.sleep(4000);
// CFOcountPOM.clickExportImage().click();
//	Thread.sleep(4000);
//	test.log(LogStatus.PASS, "Excel file Export Successfully");
//	Thread.sleep(3000);
File dir = new File("C:\\Users\\mayurig\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
CFOcountPOM.clickExportExcel().click();
Thread.sleep(9000);	
test.log(LogStatus.PASS, compliance +" :- File downloaded successfully.");

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
	test.log(LogStatus.FAIL, compliance +" :- File does not downloaded.");
}

		//AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		//Thread.sleep(3000);
//			File dir = new File("C:\\Users\\shitalb\\Downloads");
//			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//			
//			Thread.sleep(500);
//			CFOcountPOM.clickExportExcel().click();				//Exporting (Downloading) file
//			
//			Thread.sleep(3000);//C://Users//jiya//Downloads//
//			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
//			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//			
//			if(dirContents.length < allFilesNew.length)
//			{
//				test.log(LogStatus.PASS, compliance +" :- File downloaded successfully.");	
//				
//			
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, compliance +" :- File does not downloaded.");
//			}
		//}
	}
	
	public static void DetailedReportIn(ExtentTest test,   String user) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), (160));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
		Thread.sleep(7000);
		
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(1000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(1000);
		CFOcountPOM.InternalRe().click();
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(1000);
		
		//CFOcountPOM.Apply().click();
		//Thread.sleep(8000);
//		CFOcountPOM.clickExportImage2().click();			//Exporting (Downloading) file
//		Thread.sleep(8000);
//		test.log(LogStatus.PASS, "Export successfully");
		AuditorcountPOM.GridAndExcelCountMatch(test,workbook);
		Thread.sleep(3000);
		Thread.sleep(4000);//*[@id="grid"]/div[2]/table/tbody/tr[1]/td/a
		//By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[23]/a");
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(3000);
		CFOcountPOM.closeDocument2().click();
		test.log(LogStatus.PASS, "overView successfully");
	
		Thread.sleep(3000);
	/*	OverduePOM.clickRiskD().click();
		Thread.sleep(1000);
		By locatorR = By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[8]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement clickHigh =getDriver() .findElement(locatorR);	
		Thread.sleep(4000);
	jse.executeScript("arguments[0].click();", clickHigh);
		Thread.sleep(4000);
		
		OverduePOM.clickclearBtn().click();
		test.log(LogStatus.PASS, "Clear Button is working");
		Thread.sleep(7000);*/
	/*		CFOcountPOM.clickAdvancedSearch().click();
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]")));	//Wait till records table gets visible
	Thread.sleep(1000);
/*	OverduePOM.clickcomplianceTypeAS().click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceStaASM().click();
	Thread.sleep(1000);
	OverduePOM.clickcomplianceINASM().click();
	
		Thread.sleep(3000);
		By locator1 = By.xpath("//*[@id='grid1']/div[2]/table/tbody/tr[1]/td/a");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton1 =getDriver() .findElement(locator1);	
		Thread.sleep(4000);
	JavascriptExecutor jse1=(JavascriptExecutor);
	Thread.sleep(2000);
	jse1.executeScript("arguments[0].click();", ViewButton1);
		Thread.sleep(5000);
		
		By locator3 = By.xpath("//*[@id='divOverView1']/div/div/div[1]/button");
		  
		wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		WebElement close =getDriver() .findElement(locator3);	
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
			Thread.sleep(2000);
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[27]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			// retrieving "foo-button" HTML element
			WebElement ViewButton2 =getDriver() .findElement(locator1);	
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
			
			WebElement clickHighA =getDriver() .findElement(locatorRA);	
			Thread.sleep(4000);
		jse.executeScript("arguments[0].click();", clickHighA);
			Thread.sleep(4000);
		
		//	OverduePOM.clickclearBtnA().click();
			Thread.sleep(4000);
		//	test.log(LogStatus.PASS, "Advanced Search-Clear Button is working");
			CFOcountPOM.closeDocumentAS().click();
			Thread.sleep(2000);*/
			//OverduePOM.clickDashboard().click();
	}
	
	public static void complianceDocumentIn(ExtentTest test  ) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (140));
	    
		Thread.sleep(500);
		CFOcountPOM.clickDocuments().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		CFOcountPOM.clickComplianceDocuments().click();			//Clicking on 'Compliance Documents ' 
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
		Thread.sleep(2000);
		OverduePOM.Peroid().click();					//Clicking on 'My Documents'
		Thread.sleep(3000);
		OverduePOM.AllPeroid().click();			//Clicking on 'Compliance Documents '  
		Thread.sleep(3000);
		OverduePOM.clickStatus().click();
		Thread.sleep(1000);
		OverduePOM.SelectInternal().click();	
		Thread.sleep(3000);
		OverduePOM.Apply().click();			//Clicking on 'Compliance Documents '
		Thread.sleep(8000);
		Thread.sleep(8000);
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a")));	//Wait till records table gets visible
		Thread.sleep(8000);
		 By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a");
			Thread.sleep(8000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			List<WebElement> ViewButton = getDriver().findElements(locator);	
			Thread.sleep(3000);
			ViewButton.get(0).click();
			Thread.sleep(4000);
			CFOcountPOM.closeDocument1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "View Successfully");
			Thread.sleep(3000);
			ViewButton.get(1).click();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("DownloadViews1"));
			CFOcountPOM.clickDownloadBtn1().click();
			Thread.sleep(2000);
			getDriver().switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Download Successfully");
			ViewButton.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Internal-OverView Successfully");
			Thread.sleep(500);
			 By locator1 = By.xpath("//*[@id='sel_chkbx']");
			
				wait.until(ExpectedConditions.presenceOfElementLocated(locator1));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes = getDriver().findElements(locator1);	
				Thread.sleep(3000);
				ChechBoxes.get(0).click();
				Thread.sleep(500);
				
				Thread.sleep(3000);   
				getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Internal-Mutiple checkBox check and download Successfully ");
				Thread.sleep(1000);
			/*	OverduePOM.clickRisk().click();
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
			By locator2 = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[22]/a");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			List<WebElement> ViewButton1 = .findElements(locator2);	
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
			.switchTo().defaultContent();
			CFOcountPOM.closeDownloadTab1().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Advanced Search - Download Successfully");
			ViewButton1.get(2).click();
			Thread.sleep(5000);
			CFOcountPOM.closeDocument2().click();
			test.log(LogStatus.PASS, " Internal-Advanced Search - OverView Successfully");
			Thread.sleep(5000);
			 By locator3 = By.xpath("//*[@id='sel_chkbx']");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator3));
				Thread.sleep(4000);
				// retrieving "foo-button" HTML element
				List<WebElement> ChechBoxes1 = .findElements(locator3);	
				Thread.sleep(3000);
				ChechBoxes1.get(0).click();
				
				Thread.sleep(3000);
				.findElement(By.xpath("//*[@id='dvbtndownloadDocument']")).click();
				Thread.sleep(4000);
				test.log(LogStatus.PASS, " Internal-Advanced Search - Mutiple checkBox check and download Successfully ");
				CFOcountPOM.closeDocumentAS().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "Internal- Advanced Search  Clear btn is working");*/
		
		
	}
	
	
	
public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

public static void Entities(  ExtentTest test)throws InterruptedException
{
//	Thread.sleep(3000);
//	if(ApprovalcountPOM.Entities().isDisplayed()) {
//		test.log(LogStatus.PASS, "Assigned Entites Count display Entites Box.");
//	}else {
//		test.log(LogStatus.PASS, "Assigned Entites Count not display Entites Box.");
//	}
//	
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
	 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
		
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
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		ViewButton.get(1).click();
		
		Thread.sleep(3000);//C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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

public static void GraphCountPFRIn(  ExtentTest test, String risk, int complianceCount, String Compliance)throws InterruptedException
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
//	ApprovalcountPOM.Status().click();
//	Thread.sleep(1000);
//	ApprovalcountPOM.CheckAllIn().click();
//	ApprovalcountPOM.CheckAllIn().click();
//	Thread.sleep(2000);
//	ApprovalcountPOM.PFRMGMTIn().click();
//	Thread.sleep(2000);
//	ApprovalcountPOM.Status().click();
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
	 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a");
		
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
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		ViewButton.get(1).click();
		
		Thread.sleep(3000);//C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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

public static void FilterWiseCompliancesCountMatch(  ExtentTest test)throws InterruptedException
{
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	
	CFOcountPOM.readCompliancesInternal().click();
	Thread.sleep(8000);
	
	//litigationPerformer.MethodsPOM.progress();
	
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[4]/a")));
	Thread.sleep(3000);
	ClickAct().click();
	Thread.sleep(1000);
	 WebElement TextCat=getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li[6]")); 
	 String cattext =TextCat.getText();
	 Thread.sleep(1000);
	 TextCat.click();
	// ApprovalcountPOM.Commercial().click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,500)");	
	
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(3000);
	if(!s.equalsIgnoreCase("No items to display")) {
	
		Thread.sleep(1000);
	 List<WebElement> Risks=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[2]")); //column list
	 
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
		// System.out.println("fail : "+Fal);
	 }
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS, "Selection wise all filter should be working Properly : "+Pas);
		// System.out.println("Pass : "+Pas);
	 }
	}
	else{
		Thread.sleep(3000);
		 test.log(LogStatus.PASS, "No records found");
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
	Thread.sleep(3000);
}

public static void MyDashboardClearfilter(  ExtentTest test)throws InterruptedException
{
	
	
	Thread.sleep(5000);
/*	CFOcountPOM.StartDate().click();
	Thread.sleep(1000);
	CFOcountPOM.StartDate1().click();
	Thread.sleep(2000);
	CFOcountPOM.EndDate().click();
	Thread.sleep(1000);
	CFOcountPOM.EndDate1().click();
	Thread.sleep(2000);*/
	if(CFOcountPOM.Clear().isEnabled()) {
	CFOcountPOM.Clear().click();
	Thread.sleep(2000);
	 test.log(LogStatus.PASS, "while click On Clear Button selected filter should be cleared");
	}else {
		 test.log(LogStatus.FAIL, "while click On Clear Button selected filter should not cleared");
	}
	
}

public static void SummaryofOverdueMail(  ExtentTest test)throws InterruptedException
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
	 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]/a[2]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		List<WebElement> ViewButtons = getDriver().findElements(locator);							
		ViewButtons.get(1).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("SendEmailApi"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		CFOcountPOM.Message().sendKeys("test");
		Thread.sleep(3000);
		CFOcountPOM.Send().click();        //Clicking on Show All
		Thread.sleep(7000);
	String msg=	CFOcountPOM.MessageDis().getText();
	Thread.sleep(3000);
	 test.log(LogStatus.PASS, "Message displayed :-"+msg);
	 
	getDriver().switchTo().parentFrame();
	CFOcountPOM.MessageClose().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	getDriver().switchTo().defaultContent();
	Thread.sleep(3000);
	CFOcountPOM.closeCategories().click();
	Thread.sleep(1000);
	
	
}

public static void Shortreport(  ExtentTest test) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	Thread.sleep(500);
	wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
	CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
	
	Thread.sleep(1000);
	if(CFOcountPOM.ShortReport().isDisplayed()) {
	CFOcountPOM.ShortReport().click();        //Clicking on Show All
	Thread.sleep(3000);
	test.log(LogStatus.PASS, " Under Detail Report short report tab should be displayed.");
	}
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");				//Scrolling down window by 2600 px.
		
		Thread.sleep(3000);
		CFOcountPOM.readTotalPages1().click();					//CLicking on Total Pages value to scroll down
		Thread.sleep(500);
		String s1 = CFOcountPOM.readTotalPages1().getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		int TotalRecords;
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.PASS, " does not have any records to download.");
		}
		else
		{
			TotalRecords = Integer.parseInt(itomsCount);				//Reading total number of pages to click next
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2600 px.
			
	
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportExcel().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);//C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(500);
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			workbook.write(fos);
			fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			if(SheetRecords == TotalRecords)
			{
				test.log(LogStatus.PASS, " :- No of records displayed = " + TotalRecords + " matches to No of records in excel sheet = "+SheetRecords);
			}
			else
			{
				test.log(LogStatus.FAIL, " :- No of records displayed = " + TotalRecords + " doesn't matches to No of records in excel sheet = "+SheetRecords);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, " :- File does not downloaded.");
		}
	}
}

public static void ShortreportOverview(  ExtentTest test) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	Thread.sleep(500);
	wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
	CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
	
	Thread.sleep(1000);
	
	CFOcountPOM.ShortReport().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(4000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
Thread.sleep(2000);
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	CFOcountPOM.closeDocument2().click();
	test.log(LogStatus.PASS, "overView successfully");
	
	
}


public static void ShortreportIn(  ExtentTest test) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	Thread.sleep(500);
	wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
	CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
	
	Thread.sleep(1000);
	
	CFOcountPOM.ShortReport().click();        //Clicking on Show All
	
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.InternalM().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");				//Scrolling down window by 2600 px.
		
		Thread.sleep(3000);
		CFOcountPOM.readTotalPages1().click();					//CLicking on Total Pages value to scroll down
		Thread.sleep(500);
		String s1 = CFOcountPOM.readTotalPages1().getText();	//Reading the total items count in String
		String[] bits = s1.split(" ");								//Splitting the String
		String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
		int TotalRecords;
		if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
		{
			test.log(LogStatus.PASS, " does not have any records to download.");
		}
		else
		{
			TotalRecords = Integer.parseInt(itomsCount);				//Reading total number of pages to click next
			
			Thread.sleep(500);
			js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2600 px.
			
	
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		CFOcountPOM.clickExportExcel().click();				//Exporting (Downloading) file
		
		Thread.sleep(3000);//C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
		
		if(dirContents.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(500);
			fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
			Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
			c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
			FileOutputStream fos = new FileOutputStream(lastModifiedFile);
			workbook.write(fos);
			fos.close();
			
			int no = sheet.getLastRowNum();
			int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
			
			if(SheetRecords == TotalRecords)
			{
				test.log(LogStatus.PASS, " :- No of records displayed in the grid = " + TotalRecords + " matches to No of records in excel sheet = "+SheetRecords);
			}
			else
			{
				test.log(LogStatus.FAIL, " :- No of records displayed = " + TotalRecords + " doesn't matches to No of records in excel sheet = "+SheetRecords);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, " :- File does not downloaded.");
		}
	}
}

public static void ShortreportOverviewIn(  ExtentTest test) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait(getDriver(), (100));
	Thread.sleep(500);
	wait.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.clickReports()));
	CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
	
	Thread.sleep(1000);
	
	CFOcountPOM.ShortReport().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.InternalM().click();
	Thread.sleep(4000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(4000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
Thread.sleep(2000);
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	CFOcountPOM.closeDocument2().click();
	test.log(LogStatus.PASS, "overView successfully");
	
	
}

public static void UpcomingFilterMgmt(ExtentTest test  ) throws InterruptedException, IOException
{	
	
   WebDriverWait wait = new WebDriverWait(getDriver(), 140);
    
   JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
	Thread.sleep(800);
	
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
	
	CFOcountPOM.clickUpcomingPe().click();									//CLicking on 'Not Completed' count
	
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
	Thread.sleep(8000);
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);

	ApprovalcountPOM.RiskF().click();
	Thread.sleep(500);

  String Risktext =ApprovalcountPOM.RiskCritical().getText();

  /*Thread.sleep(3000);
   ApprovalcountPOM.SelectActF().click();
  Thread.sleep(500);
  String Acttext =ApprovalcountPOM.SelectActPG().getText();
   Thread.sleep(500);
   ApprovalcountPOM.SelectActPG().click();*/
   Thread.sleep(3000);
   
   ApprovalcountPOM. MitigationPlan().click();
   Thread.sleep(500);

   ApprovalcountPOM.MitigationPlan1().click();
   Thread.sleep(2000);  
   Thread.sleep(3000);
   ApprovalcountPOM.StatusF().click();
   Thread.sleep(500);
   
   
   StatusAll().click();
   Thread.sleep(3000);
   StatusAll().click();
   Thread.sleep(3000);
   List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
  	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Upcoming");
   Thread.sleep(3000);
   ApprovalcountPOM. StatusF().click();
   
   //String Statustext =ApprovalcountPOM.StatusUpcomingM().getText();
   Thread.sleep(500);
 
//   Thread.sleep(3000);
//   ApprovalcountPOM.StatusF().click();
   
   //Thread.sleep(3000);
  // ApprovalcountPOM.StatusUpcomingM().click();
   
   Thread.sleep(2000);
   
    List<String> li=new ArrayList<String>();
    
    li.add(Risktext);
    //li.add(Acttext);
    li.add("1");
    Thread.sleep(3000);
    li.add("Upcoming");
    
	List<String> filter=new ArrayList<String>();	
	filter.add("Risk");
	//filter.add("Act");
	filter.add("Mitigation Plan");	
	filter.add("Status");	
	
	MgmtSonyMethod.ClickTriA().click();
       Thread.sleep(1000);
       MgmtSonyMethod.Columns().click();
       Thread.sleep(500);
       MgmtSonyMethod.RiskCheck().click();
      Thread.sleep(1000);
       MgmtSonyMethod.MitigationPlanA().click();
     //  Thread.sleep(2000);
     // MgmtSonyMethod.ClickTriA().click();
       Thread.sleep(3000);

	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[16]"));
	//List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
	List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]"));
	
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
//		else if(i==1)
//			{
//				raw.addAll(Act);
//			}
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
	
	//ApprovalcountPOM.ClearBtn().click();
	test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
	Thread.sleep(3000);
	getDriver().switchTo().parentFrame();
	CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
	Thread.sleep(1000);
			//OverduePOM.clickDashboard().click();

}

public static void UpcomingFilterMgmtIn(ExtentTest test ) throws InterruptedException, IOException
{	
	
   WebDriverWait wait = new WebDriverWait(getDriver(), 140);
    
   JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.
	Thread.sleep(800);
	
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
	
	CFOcountPOM.clickUpcomingPe().click();									//CLicking on 'Not Completed' count
	
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
	Thread.sleep(8000);
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);

	ApprovalcountPOM.RiskF().click();
	Thread.sleep(500);

 String Risktext =ApprovalcountPOM.RiskCritical().getText();

   Thread.sleep(3000);
 /*  ApprovalcountPOM.SelectActF().click();
   Thread.sleep(500);
   String Acttext =ApprovalcountPOM.SelectActPG().getText();
   Thread.sleep(500);
   ApprovalcountPOM.SelectActPG().click();
   Thread.sleep(3000);*/
   
  ApprovalcountPOM. MitigationPlan().click();
   Thread.sleep(500);
 
   ApprovalcountPOM.MitigationPlan1().click();
   Thread.sleep(2000);
  
   Thread.sleep(3000);
   ApprovalcountPOM.StatusF().click();
   Thread.sleep(500);
   
   
   String Statustext =ApprovalcountPOM.StatusUpcomingM().getText();
   Thread.sleep(500);
 
   Thread.sleep(3000);
   ApprovalcountPOM.StatusF().click();
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
	
//	MgmtSonyMethod.ClickTriA().click();
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

	List<WebElement> Risk=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[16]"));
	//List<WebElement> Act=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
	List<WebElement> MitigationPlan=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]"));
	
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
	
	ApprovalcountPOM.ClearBtn().click();
	test.log(LogStatus.PASS, "The applied filter should get cleared after clicking on the clear button.");
	Thread.sleep(3000);
getDriver().switchTo().parentFrame();
	CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
	Thread.sleep(1000);
			OverduePOM.clickDashboard().click();
	
}

public static void DeviationApproverColSOO(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
	
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Deviation Applied");
		
	Thread.sleep(3000);
	

	List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
	Thread.sleep(3000);
	
	
	List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
	Thread.sleep(3000);
	 CFOcountPOM.clickApplyF().click();
     Thread.sleep(3000);
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

    List<String> li=new ArrayList<String>();
    
    li.add("Deviation Approver");
   
    Thread.sleep(3000);
    
//	List<String> filter=new ArrayList<String>();	
//	filter.add("Deviation Approver");
		
	
 
	      
	
	js.executeScript("window.scrollBy(0,200)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]"));


	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
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
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColSOOD(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	
	performer.OverduePOM.clickDashboard().click();	
	Thread.sleep(4000);
	CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
	
	
      MgmtSonyMethod.ClickTriStatus().click();
      Thread.sleep(1000);
      MgmtSonyMethod.ColumnsS().click();
      Thread.sleep(500);
      List<WebElement>roc = getDriver().findElements(By.xpath("//*[@class='k-label']"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Deviation Applied");
		Thread.sleep(6000);
		
		List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-button k-primary'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Filter");
		Thread.sleep(8000);
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     List<WebElement>roc2 = getDriver().findElements(By.xpath("//*[@class='k-link']"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Columns");
		Thread.sleep(8000);
		 List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@data-field='DeviationApprover'])"));
			ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Deviation Approver");
			Thread.sleep(8000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}


public static void DeviationClosureStatuscolSOO(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
	
      MgmtSonyMethod.ClickTri().click();
      Thread.sleep(1000);
      MgmtSonyMethod.Columns().click();
      Thread.sleep(500);
	OverduePOM.DeviationClosureStatuscol().click();
	Thread.sleep(2000);
	   MgmtSonyMethod.ClickTri().click();
	      Thread.sleep(3000);

String textDA=	OverduePOM.DeviationClosureStatusM().getText();
Thread.sleep(5000);             
	if(textDA.equalsIgnoreCase("Deviation Closure Status")) {
		test.log(LogStatus.PASS, " The additional column of \"Deviation Closure Status\" should be display on the gird.");

	}else {
		test.log(LogStatus.FAIL, " The additional column of \\\"Deviation Closure Status\\\" not display on the gird.");

	}

Thread.sleep(1000);
getDriver().switchTo().defaultContent();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();
Thread.sleep(1000);

}

public static void DeviationClosureStatuscolSOOD(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	performer.OverduePOM.clickDashboard().click();	
	Thread.sleep(3000);
	CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
	
      MgmtSonyMethod.ClickTri().click();
      Thread.sleep(1000);
      MgmtSonyMethod.Columns().click();
      Thread.sleep(500);
      List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@data-field='Deviation_Closure_Status'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Deviation Closure Status");
		Thread.sleep(8000);
	   MgmtSonyMethod.ClickTri().click();
	      Thread.sleep(3000);

String textDA=	OverduePOM.DeviationClosureStatusM().getText();
Thread.sleep(5000);             
	if(textDA.equalsIgnoreCase("Deviation Closure Status")) {
		test.log(LogStatus.PASS, " The additional column of \"Deviation Closure Status\" should be display on the gird.");

	}else {
		test.log(LogStatus.FAIL, " The additional column of \\\"Deviation Closure Status\\\" not display on the gird.");

	}

Thread.sleep(1000);
getDriver().switchTo().defaultContent();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();
Thread.sleep(1000);

}


public static void SOOStatus(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	CFOcountPOM.ClickShowAll().click();        //Clicking on Show All
	Thread.sleep(3000);
	
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
	
	
      DeptCountPOM.StatusM().click();
  	Thread.sleep(3000);
	
	

 String textDA=	OverduePOM.DeviationAppliedM().getText();
 String textDR=	OverduePOM.DeviationRejectedM().getText();
 String textDAp=	OverduePOM.DeviationApprovedM().getText();
	
	if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
		test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

	}else {
		test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

	}

Thread.sleep(1000);

getDriver().switchTo().defaultContent();
Thread.sleep(3000);
CFOcountPOM.closeCategories().click();
Thread.sleep(1000);

}

public static void DeviationApproverColPS(ExtentTest test)throws InterruptedException
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
	CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
	
	Thread.sleep(3000);
	CFOcountPOM.readHigh().click();		
	Thread.sleep(3000);
	
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMG().getText();
	 String textDR=	OverduePOM.DeviationRejectedMG().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMG().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "Closed Delayed");
			
		Thread.sleep(3000);
	
	List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Deviation Applied");
		
	Thread.sleep(3000);
	

	List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
	Thread.sleep(3000);
	
	
	List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
	Thread.sleep(3000);
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

    List<String> li=new ArrayList<String>();
    
    li.add("Deviation Approver");
   
    Thread.sleep(3000);
    
//	List<String> filter=new ArrayList<String>();	
//	filter.add("Deviation Approver");
		
	
 
	      
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
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
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColPSApp(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	Thread.sleep(1000);
	CFOcountPOM.YearTodate().click();
	Thread.sleep(1000);
	CFOcountPOM.ALL().click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,500)");	
	Thread.sleep(3000);
	CFOcountPOM.clickNotCompleted().click();							//CLicking on 'Not Completed' count
	
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();		
	Thread.sleep(3000);
	
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMG().getText();
	 String textDR=	OverduePOM.DeviationRejectedMG().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMG().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "DueToday");
			
		Thread.sleep(3000);
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "In Progress");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

  
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of deviation approver not  display in some rows of column of the \"deviation approver\". ");
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of deviation approver  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColPSD(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	Thread.sleep(1000);
	performer.OverduePOM.clickDashboard().click();	
	Thread.sleep(4000);
	CFOcountPOM.YearTodate().click();
	Thread.sleep(1000);
	CFOcountPOM.ALL().click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,500)");	
	Thread.sleep(3000);
	CFOcountPOM.clickNotCompleted().click();							//CLicking on 'Not Completed' count
	
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();		
	Thread.sleep(3000);
	
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMGPD().getText();
	 String textDR=	OverduePOM.DeviationRejectedMGPD().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGPD().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "DueToday");
			
		Thread.sleep(3000);
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "In Progress");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

  
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of deviation approver not  display in some rows of column of the \"deviation approver\". ");
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of deviation approver  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColPSAu(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	Thread.sleep(1000);
	
	js.executeScript("window.scrollBy(0,200)");	
	Thread.sleep(3000);
	CFOcountPOM.clickNotCompleted().click();							//CLicking on 'Not Completed' count
	
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();		
	Thread.sleep(3000);
	
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedAu().getText();
	 String textDR=	OverduePOM.DeviationRejectedAU().getText();
	 String textDAp=	OverduePOM.DeviationApprovedAu().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD1, "Upcoming");
			
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "DueToday");
			
		Thread.sleep(3000);
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "In Progress");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

  
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of deviation approver not  display in some rows of column of the \"deviation approver\". ");
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of deviation approver  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}


public static void DeviationApproverColRS(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
	js.executeScript("window.scrollBy(0,1450)");		
	Thread.sleep(1000);
	
	List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
		
	Thread.sleep(5000);
	CFOcountPOM.clickRiskCriticalNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMG().getText();
	 String textDR=	OverduePOM.DeviationRejectedMG().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMG().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "Closed Delayed");
			
		Thread.sleep(3000);
	
	List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Deviation Applied");
		
	Thread.sleep(3000);
	

	List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
	Thread.sleep(3000);
	
	
	List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
	Thread.sleep(3000);
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

    List<String> li=new ArrayList<String>();
    
    li.add("Deviation Approver");
   
    Thread.sleep(3000);
    
//	List<String> filter=new ArrayList<String>();	
//	filter.add("Deviation Approver");
		
	
 
	      
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
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
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of "+Fal+" not  display in some rows of column of the \"deviation approver\". ");
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of "+Pas+"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColRSAPP(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
	CFOcountPOM.YearTodate().click();
	Thread.sleep(1000);
	CFOcountPOM.ALL().click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,1500)");		
		
	Thread.sleep(5000);
	CFOcountPOM.clickRiskCriticalNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMG().getText();
	 String textDR=	OverduePOM.DeviationRejectedMG().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMG().getText();
	 
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
	
		Thread.sleep(3000);
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "In Progress");
			
		Thread.sleep(3000);
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of deviation approver not  display in some rows of column of the \"deviation approver\". ");
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of deviation approver  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColRSD(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
	performer.OverduePOM.clickDashboard().click();	
	Thread.sleep(4000);
	CFOcountPOM.YearTodate().click();
	Thread.sleep(1000);
	CFOcountPOM.ALL().click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,1500)");		
		
	Thread.sleep(5000);
	CFOcountPOM.clickRiskCriticalNotCompletedDept().click();			//Clicking on Not Completed compliances bar of High risk.  
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMGPD().getText();
	 String textDR=	OverduePOM.DeviationRejectedMGPD().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGPD().getText();
	 
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD1, "DueToday");
			
		Thread.sleep(3000);
		Thread.sleep(3000);
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "In Progress");
			
		Thread.sleep(3000);
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of deviation approver not  display in some rows of column of the \"deviation approver\". ");
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of deviation approver  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColRSAu(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
	
	js.executeScript("window.scrollBy(0,1200)");		
		
	Thread.sleep(5000);
	CFOcountPOM.clickRiskCriticalNotCompleted().click();			//Clicking on Not Completed compliances bar of High risk.  
	Thread.sleep(2000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	

	 String textDA=	OverduePOM.DeviationAppliedAu().getText();
	 String textDR=	OverduePOM.DeviationRejectedAU().getText();
	 String textDAp=	OverduePOM.DeviationApprovedAu().getText();
		
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		Thread.sleep(3000);
		List<WebElement>rocA4 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA4, "Upcoming");
	
		Thread.sleep(3000);
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "In Progress");
			
		Thread.sleep(3000);
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of deviation approver not  display in some rows of column of the \"deviation approver\". ");
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of deviation approver  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}



public static void DeviationApproverColDS(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
	js.executeScript("window.scrollBy(0,2000)");	
	Thread.sleep(2000);
	CFOcountPOM.clickHROverdueM().click();
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationRejectedMG().getText();
	 String textDR=	OverduePOM.DeviationApprovedMG().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGD().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "Overdue");
			
		Thread.sleep(3000);
	
	/*List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Deviation Applied");
		
	Thread.sleep(3000);
	

	List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
	Thread.sleep(3000);
	
	
	List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
	Thread.sleep(3000);
	*/
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	
 }
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


}

public static void DeviationApproverColDSAPP(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
	CFOcountPOM.YearTodate().click();
	Thread.sleep(1000);
	CFOcountPOM.ALL().click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,2000)");	
	Thread.sleep(2000);
	CFOcountPOM.clickAccountOverdue().click();
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000); 
	
	String textDA=	OverduePOM.DeviationRejectedMG().getText();
	 String textDR=	OverduePOM.DeviationApprovedMG().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGD().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "Overdue");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	      
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColDSD(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
	performer.OverduePOM.clickDashboard().click();	
	Thread.sleep(4000);
	CFOcountPOM.YearTodate().click();
	Thread.sleep(1000);
	CFOcountPOM.ALL().click();
	Thread.sleep(1000);
	CFOcountPOM.clickApply().click();
	Thread.sleep(5000);
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(2000);
	CFOcountPOM.clickAccountOverdueDept().click();
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000); 
	
	String textDA=	OverduePOM.DeviationAppliedMGPD().getText();
	 String textDR=	OverduePOM.DeviationRejectedMGPD().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGPD().getText();
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocD1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD1, "DueToday");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	      
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}

public static void DeviationApproverColDSAu(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
	
	js.executeScript("window.scrollBy(0,1700)");	
	Thread.sleep(3000);
	CFOcountPOM.clickAdminOverdueM().click();
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000); 
	
	 String textDA=	OverduePOM.DeviationAppliedAu().getText();
	 String textDR=	OverduePOM.DeviationRejectedAU().getText();
	 String textDAp=	OverduePOM.DeviationApprovedAu().getText();
		
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocD1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD1, "Upcoming");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	      
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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


}



public static void DeviationApproverColPSDFP(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;

	js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
	Thread.sleep(3000);
	
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
	
	
	CFOcountPOM.clickClosedDelayed().click();								
	Thread.sleep(3000);
	CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
	Thread.sleep(500);
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMGP().getText();
	 String textDR=	OverduePOM.DeviationRejectedMGP().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGP().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		
		List<WebElement>rocD = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocD, "Closed Delayed");
			
		Thread.sleep(3000);
	
	List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Deviation Applied");
		
	Thread.sleep(3000);
	

	List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
	Thread.sleep(3000);
	
	
	List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
	Thread.sleep(3000);
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(3000);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

    List<String> li=new ArrayList<String>();
    
    li.add("Deviation Approver");
   
    Thread.sleep(3000);
    
//	List<String> filter=new ArrayList<String>();	
//	filter.add("Deviation Approver");
		
	
 
	      
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]"));


	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
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
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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
	CFOcountPOM.closeCategories1().click();	


}

public static void DeviationApproverColPSDFPAPP(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;

	js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
	Thread.sleep(3000);
	
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
	
	
	CFOcountPOM.clickNotCompleted().click();					
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
	Thread.sleep(500);
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMGP().getText();
	 String textDR=	OverduePOM.DeviationRejectedMGP().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGP().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		List<WebElement>rocA4 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA4, "DueToday");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "Upcoming");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(3000);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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
	CFOcountPOM.closeCategories1().click();	


}

public static void DeviationApproverColPSDFPD(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	performer.OverduePOM.clickDashboard().click();	
	Thread.sleep(4000);
	js.executeScript("window.scrollBy(0,2500)");					//Scrolling down window by 1000 px.
	Thread.sleep(3000);
	
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
	
	
	CFOcountPOM.clickNotCompleted().click();					
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
	Thread.sleep(500);
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMGPD().getText();
	 String textDR=	OverduePOM.DeviationRejectedMGPD().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGPD().getText();
	 
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		List<WebElement>rocA4 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA4, "DueToday");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "Upcoming");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(3000);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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
	CFOcountPOM.closeCategories1().click();	


}


public static void DeviationApproverColPSDFPAu(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;

	js.executeScript("window.scrollBy(0,2200)");					//Scrolling down window by 1000 px.
	Thread.sleep(3000);
	
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
	
	
	CFOcountPOM.clickNotCompleted().click();					
	Thread.sleep(3000);
	CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
	Thread.sleep(500);
	
	getDriver().switchTo().parentFrame();
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
	Thread.sleep(8000);
	
	
      DeptCountPOM.StatusM().click();
	Thread.sleep(3000);
	
	String textDA=	OverduePOM.DeviationAppliedMGP().getText();
	 String textDR=	OverduePOM.DeviationRejectedMGP().getText();
	 String textDAp=	OverduePOM.DeviationApprovedMGP().getText();
		
		if(textDA.equalsIgnoreCase("Deviation Applied")&&textDR.equalsIgnoreCase("Deviation Rejected")&&textDAp.equalsIgnoreCase("Deviation Approved")) {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) are reflects in the status dropdown  ");

		}else {
			test.log(LogStatus.PASS, " the 3 new status (Deviation Applied, Deviation Approved, Deviation Rejected) not reflects in the status dropdown  ");

		}
		List<WebElement>rocA4 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA4, "DueToday");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA, "Overdue");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA1, "Pending For Review");
			
		Thread.sleep(3000);
		
		List<WebElement>rocA2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA2, "Rejected");
			
		Thread.sleep(3000);
		List<WebElement>rocA3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(rocA3, "Upcoming");
			
		Thread.sleep(3000);
	
	
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(3000);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[22]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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
	CFOcountPOM.closeCategories1().click();	


}


public static void DeviationApproverColGR(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
	js.executeScript("window.scrollBy(0,3500)");					//Scrolling down window by 2600 px.
	Thread.sleep(2000);	
	CFOcountPOM.clickRedGrading().click();
	Thread.sleep(8000);	
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(1000);
	
      DeptCountPOM.StatusGR().click();
	Thread.sleep(3000);
	
	List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Deviation Applied");
		
	Thread.sleep(3000);
	

	List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
	Thread.sleep(3000);
	
	
	List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
	Thread.sleep(3000);
	 CFOcountPOM.clickApplyF().click();
     Thread.sleep(3000);
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	

    List<String> li=new ArrayList<String>();
    
    li.add("Deviation Approver");
   
    Thread.sleep(3000);
    
//	List<String> filter=new ArrayList<String>();	
//	filter.add("Deviation Approver");
		
	
 
	      
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
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
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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
	CFOcountPOM.closePopup().click();			
	Thread.sleep(1000);


}

public static void DeviationApproverColGR1(ExtentTest test)throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (35));
	JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
	js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2600 px.
	Thread.sleep(2000);	
	CFOcountPOM.clickRedGrading().click();
	Thread.sleep(8000);	
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
	Thread.sleep(1000);
	
      DeptCountPOM.StatusGR().click();
	Thread.sleep(3000);
	
	List<WebElement>roc3 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc3, "Deviation Applied");
		
	Thread.sleep(3000);
	

	List<WebElement>roc1 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc1, "Deviation Rejected");
	Thread.sleep(3000);
	
	
	List<WebElement>roc2 = getDriver().findElements(By.xpath("(//*[@class='k-in'])"));
	ApprovalcountPOM.selectOptionFromDropDown_bs(roc2, "Deviation Approved");
	Thread.sleep(3000);
	 CFOcountPOM.clickApplyF().click();
     Thread.sleep(3000);
	
     MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
     MgmtSonyMethod.Columns().click();
     Thread.sleep(500);
	OverduePOM.DeviationAppliedCol().click();
	Thread.sleep(2000);
	 MgmtSonyMethod.ClickTri().click();
     Thread.sleep(1000);
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);
	CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItemsD().getText();
	Thread.sleep(500);
	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> DA=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[20]"));


	Thread.sleep(2000);

	for(int i=0; i<DA.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(DA);
			}
		
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

			for(int l=0;l<text.size();l++)
				{
			if(!text.get(l).isEmpty())
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : ");

				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : ");
				System.out.println(i);

			}
			 }
	 if(!fail.isEmpty()) {
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, " The  name of \"deviation approver\" not  display in some rows of column of the \"deviation approver\". "+Fal);
	 }	
	}else {
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  "The  name of \\\"deviation approver\\\"  display on the additional column of \\\"deviation approver\\\".");
			test.log(LogStatus.PASS, " displayed : "+Pas);	
	//		System.out.println(filter.get(i)+" : "+Pas);
 }
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
	CFOcountPOM.closePopup().click();			
	Thread.sleep(1000);


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
		CFOcountPOM.ComplianceID().sendKeys("6696");
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
		CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(3000);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		CFOcountPOM.ComplianceID().sendKeys("83902");
		
		Thread.sleep(8000);
		
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[3]");
	
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
		js.executeScript("window.scrollBy(0,1450)");	
		Thread.sleep(3000);
		CFOcountPOM.clickRiskHighNotCompleted().click();								//CLicking on 'Not Completed' count
		
				
		Thread.sleep(3000);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		CFOcountPOM.ComplianceID().sendKeys("6696");
		
		Thread.sleep(8000);
		
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[3]");
	
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
		js.executeScript("window.scrollBy(0,2000)");	
		Thread.sleep(3000);
		CFOcountPOM.clickHROverduem().click();								//CLicking on 'Not Completed' count
		
				
		Thread.sleep(3000);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		CFOcountPOM.ComplianceID().sendKeys("6696");
		
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
		CFOcountPOM.readHigh().click();
			
		Thread.sleep(3000);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		CFOcountPOM.ComplianceID().sendKeys("6696");
		
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
	
public static void GradingReportSF(ExtentTest test)throws InterruptedException
{

	JavascriptExecutor js = (JavascriptExecutor) getDriver(); ;
	js.executeScript("window.scrollBy(0,3500)");					//Scrolling down window by 2600 px.
	Thread.sleep(2000);	
	CFOcountPOM.clickRedGrading1().click();
	Thread.sleep(8000);	
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		CFOcountPOM.ComplianceID().sendKeys("6696");
		
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
		CFOcountPOM.closeDocument1().click();
		
		Thread.sleep(1000);
		CFOcountPOM.closePopup().click();	
}

public static void DetailedReportSF(ExtentTest test) throws InterruptedException, IOException
{		
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
    
	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
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
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='k-selectable']")));	//Wait till records table gets visible
	
	
	CFOcountPOM.ComplianceID().sendKeys("6696");
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
		CFOcountPOM.ComplianceID1().sendKeys("6696");
		
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(2000);
		By locator = By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[22]/a[3]");
		
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
 String act = CFOcountPOM.ActDD().getText();
 Thread.sleep(2000);
 CFOcountPOM.ActDD().click();
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
 String act = CFOcountPOM.ActDD().getText();
 Thread.sleep(2000);
 CFOcountPOM.ActDD().click();
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
		

public static void NCcompletionVsNCOverdue (ExtentTest test)throws InterruptedException
{
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
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



public static void NCcompletionVsNCOverdueIn (ExtentTest test)throws InterruptedException
{
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	int satPerformrNotcompleted=Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());
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

public static void NCcompletionVsNCOverdueInAu (ExtentTest test)throws InterruptedException
{
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,200)");
	int satPerformrNotcompleted=Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());
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

public static void DetailedreportVsdashboardclosedtimelycount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	int satPerformrsummclosedtimely=Integer.parseInt(CFOcountPOM.clickClosedTimely().getText());
	Thread.sleep(5000);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
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
	Thread.sleep(5000);

    CFOcountPOM.Status1().click();
    CFOcountPOM.StatusClosedTimely().click();
    Thread.sleep(5000);
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
      js.executeScript("window.scroll(0,500)");
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
  		
    Thread.sleep(5000);
    Thread.sleep(5000);
    if(count1==satPerformrsummclosedtimely)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Closed Timely Count="+satPerformrsummclosedtimely+" | Total ClosedTimely count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Closed Timely Count="+satPerformrsummclosedtimely+" | Total ClosedTimely count of Detail report ="+count1);
    }
  		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsdashboardCloseddealyedcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	int SatPerformerCloseddelayCount=Integer.parseInt(CFOcountPOM.clickClosedDelayed().getText());
	Thread.sleep(5000);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
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
	Thread.sleep(5000);
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
    CFOcountPOM.StatusClosedDelay().click();
    Thread.sleep(5000);
    CFOcountPOM.PeriodDropDown().click();
  	Thread.sleep(2000);
  	CFOcountPOM.PeriodAll().click();
  	Thread.sleep(2000);
     	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
  	Thread.sleep(2000);
  	CFOcountPOM.EndDate2().sendKeys("24-Mar-2025");
  	Thread.sleep(2000);
  	CFOcountPOM.Apply().click();
  	Thread.sleep(8000);
      js.executeScript("window.scroll(0,500)");
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
  		
    Thread.sleep(5000);
    if(count1==SatPerformerCloseddelayCount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Closed Delayed Count="+SatPerformerCloseddelayCount+" | Total Closed Delayed count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Closed Delayed Count="+SatPerformerCloseddelayCount+" | Total Closed Delayed count of Detail report ="+count1);
    }
  		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsdashboardNotCompletedcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	int SatPerformerNotcompletedCount=Integer.parseInt(CFOcountPOM.clickNotCompleted().getText());
	Thread.sleep(5000);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
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
	CFOcountPOM.StatusDueToday().click();
	Thread.sleep(5000);
    CFOcountPOM.StatusOverDue().click();
    Thread.sleep(5000);
    
    CFOcountPOM.StatusPendingForReview().click();
    Thread.sleep(5000);
    CFOcountPOM.StatusRejected().click();
    Thread.sleep(3000);
    CFOcountPOM.StatusInProgress().click();
    Thread.sleep(5000);
    CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("24-Mar-2025");
	Thread.sleep(2000);
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
    js.executeScript("window.scroll(0,500)");
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
		
    Thread.sleep(5000);
    if(count1==SatPerformerNotcompletedCount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Not Completed Count="+SatPerformerNotcompletedCount+" | Total Not Completed count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Not Completed Count="+SatPerformerNotcompletedCount+" | Total Not Completed count of Detail report ="+count1);
    }
		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsdashboardNotCompletedcountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickNotCompletedInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	//CFOcountPOM.InnternalCheck().click();
	Thread.sleep(4000);
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

public static void DetailedreportVsdashboardNotCompletedcountInAU(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickNotCompletedInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

	Thread.sleep(500);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
	Thread.sleep(2000);
	CFOcountPOM.ComplianceType().click();
	Thread.sleep(2000);
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	//CFOcountPOM.InnternalCheck().click();
	Thread.sleep(4000);
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


public static void DetailedreportVsdashboardNotCompletedcountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
//	CFOcountPOM.StatusDeviationApplied().click();
	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationApproved().click();
//	Thread.sleep(2000);
//	CFOcountPOM.StatusDeviationRejected().click();
	
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

public static void DetailedreportVsdashboardNotCompletedcountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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

public static void DetailedreportVsdashboardclosedtimelycountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickClosedTimelyInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

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
	CFOcountPOM.StatusClosedTimely().click();
	Thread.sleep(5000);
	
	
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

public static void DetailedreportVsdashboardclosedtimelycountInAu(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(3000);
String NotCompleted = CFOcountPOM.clickClosedTimelyInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

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


public static void DetailedreportVsdashboardclosedtimelycountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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



public static void DetailedreportVsdashboardclosedtimelycountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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



public static void DetailedreportVsdashboardCloseddealyedcountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickClosedDelayedInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

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
	CFOcountPOM.StatusClosedDelay().click();
	Thread.sleep(5000);
	
	
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

public static void DetailedreportVsdashboardCloseddealyedcountInAu(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickClosedDelayedInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

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

public static void DetailedreportVsdashboardCloseddealyedcountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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

public static void DetailedreportVsdashboardCloseddealyedcountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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


public static void DetailedreportVsdashboardNAcountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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

public static void DetailedreportVsdashboardNAcountInAu(ExtentTest test)throws InterruptedException
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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


public static void DetailedreportVsdashboardNAcountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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

public static void DetailedreportVsdashboardNAcountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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

public static void DetailedreportVsOverduecountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickOverdueInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

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
	Thread.sleep(5000);
	
	
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

public static void DetailedreportVsOverduecountInAu(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,200)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickOverdueInternal().getText();		//Reading the Closed Timely value of Human Resource
NotCompleted = NotCompleted.replaceAll(" ","");									//Removing all white spaces from string. 
int NotCompletedIn = Integer.parseInt(NotCompleted);

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

public static void DetailedreportVsOverduecountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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

public static void DetailedreportVsOverduecountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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

public static void DetailedreportVsDueTodaycountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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

public static void DetailedreportVsDueTodaycountInAu(ExtentTest test)throws InterruptedException
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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


public static void DetailedreportVsDueTodaycountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	CFOcountPOM.StatusDueToday().click();
	Thread.sleep(5000);
	
	
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


public static void DetailedreportVsDueTodaycountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	
	
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


public static void DetailedreportVsPFRcountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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

public static void DetailedreportVsPFRcountInAu(ExtentTest test)throws InterruptedException
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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


public static void DetailedreportVsPFRcountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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


public static void DetailedreportVsPFRcountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
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


public static void DetailedreportVsINprocountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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

public static void DetailedreportVsINprocountInAu(ExtentTest test)throws InterruptedException
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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

public static void DetailedreportVsINprocountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,600)");
Thread.sleep(5000);
String NotCompleted = CFOcountPOM.clickInProgressDept().getText();		//Reading the Closed Timely value of Human Resource
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
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2025");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("09-Apr-2025");
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

public static void DetailedreportVsINprocountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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


public static void DetailedreportVsRejectedcountIn(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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

public static void DetailedreportVsRejectedcountInAu(ExtentTest test)throws InterruptedException
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
	CFOcountPOM.Innternal().click();
	Thread.sleep(4000);
	
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

public static void DetailedreportVsRejectedcountUp(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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

public static void DetailedreportVsRejectedcountUpEx(ExtentTest test)throws InterruptedException
{
JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
js.executeScript("window.scroll(0,500)");
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
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
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


public static void DetailedreportVsdashboardNAcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	int SatPerformerNACount=Integer.parseInt(CFOcountPOM.clickNotApplicable().getText());
	Thread.sleep(5000);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
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
	Thread.sleep(5000);
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
    CFOcountPOM.StatusNotApplicable().click();
    Thread.sleep(5000);
    Thread.sleep(5000);
    CFOcountPOM.PeriodDropDown().click();
  	Thread.sleep(2000);
  	CFOcountPOM.PeriodAll().click();
  	Thread.sleep(2000);
     	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
  	Thread.sleep(2000);
  	CFOcountPOM.EndDate2().sendKeys("24-Mar-2025");
  	Thread.sleep(2000);
  	CFOcountPOM.Apply().click();
  	Thread.sleep(8000);
      js.executeScript("window.scroll(0,500)");
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
  		
    Thread.sleep(5000);
    if(count1==SatPerformerNACount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Not Applicable Count="+SatPerformerNACount+" | Total Not Applicable count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Not Applicable Count="+SatPerformerNACount+" | Total Not Applicable count of Detail report ="+count1);
    }
  		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}
public static void MgmtOverallFunctionFinanceCriticalCount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,1000)");
	Thread.sleep(5000);
	int OverallFunctionFinanceCritical=Integer.parseInt(CFOcountPOM.mgmtCompletionStatusOverallCriticalFinanceandTaxation().getText());
	Thread.sleep(5000);
	CFOcountPOM.mgmtCompletionStatusOverallCriticalFinanceandTaxation().click();
	Thread.sleep(5000);
	int satoverallFinanceTaxationCriticalClosedT=Integer.parseInt(CFOcountPOM.mgmtCompletionStatusCriticalFinanceandTaxationClosedTimely().getText());
	Thread.sleep(5000);
	    int satoverallFinanceTaxationCriticalClosedD=Integer.parseInt(CFOcountPOM.mgmtCompletionStatusCriticalFinanceandTaxationClosedDealyed().getText());
	   // int satoverallFinanceTaxationCriticalClosedNC=Integer.parseInt(CFOcountPOM.mgmtCompletionStatusCriticalFinanceandTaxationNotComplied().getText());
	    int satoverallFinanceTaxationCriticalClosedNotCompleted=Integer.parseInt(CFOcountPOM.mgmtCompletionStatusCriticalFinanceandTaxationNotCompleted().getText());
	    Thread.sleep(5000);
	    int satoverallFinanceTaxationCriticalNA=Integer.parseInt(CFOcountPOM.mgmtCompletionStatusCriticalFinanceandTaxationNotApplicable().getText());
	    Thread.sleep(5000);
	    int FinancecriticalRisktotal=satoverallFinanceTaxationCriticalClosedT+satoverallFinanceTaxationCriticalClosedD+satoverallFinanceTaxationCriticalClosedNotCompleted+satoverallFinanceTaxationCriticalNA;
	    Thread.sleep(5000);
	    if(OverallFunctionFinanceCritical==FinancecriticalRisktotal)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Overall Function Finance and Taxation critical risk count ="+OverallFunctionFinanceCritical+" | Sum of Critical count statuses ="+FinancecriticalRisktotal);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Overall Function Finance and Taxation critical risk count ="+OverallFunctionFinanceCritical+" | Sum of Critical count statuses ="+FinancecriticalRisktotal);
    }
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsOverduecount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,600)");
	Thread.sleep(3000);
	int SatPerformerCloseddelayCount=Integer.parseInt(CFOcountPOM.clickOverdue().getText());
	Thread.sleep(5000);
	clickReports().click();					//Clicking on 'My Reports'
	Thread.sleep(3000);
	clickDetailedReport().click();	Thread.sleep(5000);				//Clicking on 'Detailed Reports' 
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
	Thread.sleep(5000);
	CFOcountPOM.Status1().click();
	Thread.sleep(2000);
    CFOcountPOM.StatusOverDue().click();
    Thread.sleep(5000);
    Thread.sleep(5000);
    CFOcountPOM.PeriodDropDown().click();
  	Thread.sleep(2000);
  	CFOcountPOM.PeriodAll().click();
  	Thread.sleep(2000);
     	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
  	Thread.sleep(2000);
  	CFOcountPOM.EndDate2().sendKeys("24-Mar-2025");
  	Thread.sleep(2000);
  	CFOcountPOM.Apply().click();
  	Thread.sleep(8000);
      js.executeScript("window.scroll(0,500)");
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
    if(count1==SatPerformerCloseddelayCount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Overdue Count="+SatPerformerCloseddelayCount+" | Total Overdue count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Overdue Count="+SatPerformerCloseddelayCount+" | Total Overdue count of Detail report ="+count1);
    }
  		}else 
		{
			test.log(LogStatus.PASS, "No records found.");
		}
	    	CFOcountPOM.DashBoardAfterCount().click();
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsDueTodaycount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	int SatPerformerCloseddelayCount=Integer.parseInt(CFOcountPOM.clickdueToday().getText());
	Thread.sleep(5000);
	clickReports().click();	
	Thread.sleep(5000);
	clickDetailedReport().click();	Thread.sleep(5000);			
	Thread.sleep(5000);
	CFOcountPOM.ComplianceType().click();	
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancetypeselction().click();
	CFOcountPOM.mgmtdetailreportEventbasecheckliststatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportStatutorchecklistystatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportEventbasestatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancestatus().click();
	Thread.sleep(1000);
    CFOcountPOM.StatusDueToday().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportAllperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportstartdate().sendKeys("01-Apr-2024");
    CFOcountPOM.mgmtdetailreportenddate().sendKeys("24-Mar-2025");
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportApply().click();
    Thread.sleep(5000);
    js.executeScript("window.scroll(0,500)");
    Thread.sleep(5000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(5000);
   String item = CFOcountPOM.readTotalItemsD().getText();	
 
	String[] bits = item.split(" "); //Splitting the String

    String compliancesCount = bits[bits.length - 2]; //Getting the second last word (total number of users)

    int count1 = Integer.parseInt(compliancesCount);  //Convert it into integer
    Thread.sleep(5000);
    if(count1==SatPerformerCloseddelayCount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of DueToday Count="+SatPerformerCloseddelayCount+" | Total DueToday count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of DueToday Count="+SatPerformerCloseddelayCount+" | Total DueToday count of Detail report ="+count1);
    }
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsPFRcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	int SatPerformerCloseddelayCount=Integer.parseInt(CFOcountPOM.clickpendingForReview().getText());
	Thread.sleep(5000);
	clickReports().click();	
	Thread.sleep(5000);
	clickDetailedReport().click();	Thread.sleep(5000);			
	Thread.sleep(5000);
	CFOcountPOM.ComplianceType().click();	
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancetypeselction().click();
	CFOcountPOM.mgmtdetailreportEventbasecheckliststatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportStatutorchecklistystatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportEventbasestatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancestatus().click();
	Thread.sleep(1000);
    CFOcountPOM.StatusPendingForReview().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportAllperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportstartdate().sendKeys("01-Apr-2024");
    CFOcountPOM.mgmtdetailreportenddate().sendKeys("24-Mar-2025");
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportApply().click();
    Thread.sleep(5000);
    js.executeScript("window.scroll(0,500)");
    Thread.sleep(5000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(5000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(5000);
   String item = CFOcountPOM.readTotalItemsD().getText();	
 
	String[] bits = item.split(" "); //Splitting the String

    String compliancesCount = bits[bits.length - 2]; //Getting the second last word (total number of users)

    int count1 = Integer.parseInt(compliancesCount);  //Convert it into integer
    Thread.sleep(5000);
    if(count1==SatPerformerCloseddelayCount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Pending For Review Count="+SatPerformerCloseddelayCount+" | Total Pending For Review count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Pending For Review Count="+SatPerformerCloseddelayCount+" | Total Pending For Review count of Detail report ="+count1);
    }
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsINprocount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	int SatPerformerCloseddelayCount=Integer.parseInt(CFOcountPOM.clickinProgress().getText());
	Thread.sleep(5000);
	clickReports().click();	
	Thread.sleep(5000);
	clickDetailedReport().click();	Thread.sleep(5000);			
	Thread.sleep(5000);
	CFOcountPOM.ComplianceType().click();	
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancetypeselction().click();
	CFOcountPOM.mgmtdetailreportEventbasecheckliststatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportStatutorchecklistystatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportEventbasestatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancestatus().click();
	Thread.sleep(1000);
    CFOcountPOM.StatusInProgress().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportAllperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportstartdate().sendKeys("01-Apr-2024");
    CFOcountPOM.mgmtdetailreportenddate().sendKeys("24-Mar-2025");
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportApply().click();
    Thread.sleep(5000);
    js.executeScript("window.scroll(0,500)");
    Thread.sleep(5000);
   String item = CFOcountPOM.readTotalItemsD().getText();	
 
	String[] bits = item.split(" "); //Splitting the String

    String compliancesCount = bits[bits.length - 2]; //Getting the second last word (total number of users)

    int count1 = Integer.parseInt(compliancesCount);  //Convert it into integer
    Thread.sleep(5000);
    if(count1==SatPerformerCloseddelayCount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of In Progress Count="+SatPerformerCloseddelayCount+" | Total In Progress count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of In Progress Count="+SatPerformerCloseddelayCount+" | Total In Progress count of Detail report ="+count1);
    }
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsRejectedcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) CFOcountPOM.getDriver() ;
	js.executeScript("window.scroll(0,500)");
	Thread.sleep(3000);
	int SatPerformerCloseddelayCount=Integer.parseInt(CFOcountPOM.clickRejectedPe().getText());
	Thread.sleep(5000);
	clickReports().click();	
	Thread.sleep(5000);
	clickDetailedReport().click();	Thread.sleep(5000);			
	Thread.sleep(5000);
	CFOcountPOM.ComplianceType().click();	
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancetypeselction().click();
	CFOcountPOM.mgmtdetailreportEventbasecheckliststatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportStatutorchecklistystatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportEventbasestatus().click();
	Thread.sleep(5000);
	CFOcountPOM.mgmtdetailreportcompliancestatus().click();
	Thread.sleep(1000);
    CFOcountPOM.StatusRejected().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportAllperoid().click();
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportstartdate().sendKeys("01-Apr-2024");
    CFOcountPOM.mgmtdetailreportenddate().sendKeys("24-Mar-2025");
    Thread.sleep(5000);
    CFOcountPOM.mgmtdetailreportApply().click();
    Thread.sleep(5000);
    js.executeScript("window.scroll(0,500)");
    Thread.sleep(5000);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
	 Thread.sleep(5000);
   String item = CFOcountPOM.readTotalItemsD().getText();	
 
	String[] bits = item.split(" "); //Splitting the String

    String compliancesCount = bits[bits.length - 2]; //Getting the second last word (total number of users)

    int count1 = Integer.parseInt(compliancesCount);  //Convert it into integer
    Thread.sleep(5000);
    if(count1==SatPerformerCloseddelayCount)
    {
    	System.out.println("Pass");
    	test.log(LogStatus.PASS, "Total of Rejected Count="+SatPerformerCloseddelayCount+" | Total Rejected count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total of Rejected Count="+SatPerformerCloseddelayCount+" | Total Rejected count of Detail report ="+count1);
    }
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsCommercialCriticalcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
	
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
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
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

public static void DetailedreportVsCommercialCriticalcountEx(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
	
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
	Thread.sleep(2000);
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
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


public static void DetailedreportVsCommercialCriticalcountIn(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
	
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSECritical().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit Critical Count="+NotCompletedIn+" | Total Internal Audit Critical count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit Critical Count="+NotCompletedIn+" | Total Internal Audit Critical count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
			CFOcountPOM.DashBoardAfterCount().click();
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}

public static void DetailedreportVsCommercialCriticalcountInAu(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
	
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSECritical().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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

	
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskCritical().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit Critical Count="+NotCompletedIn+" | Total Internal Audit Critical count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit Critical Count="+NotCompletedIn+" | Total Internal Audit Critical count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
			CFOcountPOM.DashBoardAfterCount().click();
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}



public static void DetailedreportVsCommercialHighcountIn(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
	
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSEHigh().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskHigh().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit High Count="+NotCompletedIn+" | Total Internal Audit High count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit High Count="+NotCompletedIn+" | Total Internal Audit High count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
			CFOcountPOM.DashBoardAfterCount().click();
}

public static void DetailedreportVsCommercialHighcountInAU(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
	
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSEHigh().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit High Count="+NotCompletedIn+" | Total Internal Audit High count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit High Count="+NotCompletedIn+" | Total Internal Audit High count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
			CFOcountPOM.DashBoardAfterCount().click();
}


public static void DetailedreportVsCommercialMediumcountIn(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSEMedium().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskMedium().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit Medium Count="+NotCompletedIn+" | Total Internal Audit Medium count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit Medium Count="+NotCompletedIn+" | Total Internal Audit Medium count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
			CFOcountPOM.DashBoardAfterCount().click();
}

public static void DetailedreportVsCommercialMediumcountInAu(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSEMedium().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit Medium Count="+NotCompletedIn+" | Total Internal Audit Medium count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit Medium Count="+NotCompletedIn+" | Total Internal Audit Medium count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
			CFOcountPOM.DashBoardAfterCount().click();
}


public static void DetailedreportVsCommercialLowcountIn(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
	
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSELow().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
	Thread.sleep(2000);
	
    CFOcountPOM.Risk().click();
	Thread.sleep(2000);
	CFOcountPOM.RiskLow().click();
	Thread.sleep(2000);	
	 CFOcountPOM.Risk().click();
		Thread.sleep(2000);
    CFOcountPOM.Apply().click();
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit Low Count="+NotCompletedIn+" | Total Internal Audit Low count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit Low Count="+NotCompletedIn+" | Total Internal Audit Low count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
			CFOcountPOM.DashBoardAfterCount().click();
}

public static void DetailedreportVsCommercialLowcountInAu(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	WebDriverWait wait = new WebDriverWait(getDriver(), (60));
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,800)");						//Scrolling down window by 1000 px.
	
	Thread.sleep(3000);
	
	String IndustrySpeCritical = CFOcountPOM.clickBSELow().getText();		//Reading the Closed Timely value of Human Resource
	IndustrySpeCritical = IndustrySpeCritical.replaceAll(" ","");									//Removing all white spaces from string. 
	int NotCompletedIn = Integer.parseInt(IndustrySpeCritical);
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
    Thread.sleep(5000);
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='k-loading-color']")));	//Wait until records table get visible.
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
			CFOcountPOM.Search().sendKeys("Internal Audit");
			Thread.sleep(3000);
			CFOcountPOM.SearchIA().click();
			Thread.sleep(2000);	
			CFOcountPOM.ClickFilter2().click();
			
			Thread.sleep(8000);	
    
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
    	test.log(LogStatus.PASS, "Total  Internal Audit Low Count="+NotCompletedIn+" | Total Internal Audit Low count of Detail report ="+count1);
    }
    else
    {
    	System.out.println("Fail");
    	test.log(LogStatus.FAIL, "Total Internal Audit Low Count="+NotCompletedIn+" | Total Internal Audit Low count of Detail report ="+count1);
    }
			}else 
			{
				test.log(LogStatus.PASS, "No records found.");
			}
    
    
			CFOcountPOM.DashBoardAfterCount().click();
}


public static void DetailedreportVsCommercialHighcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
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
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	Thread.sleep(5000);
	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	Thread.sleep(5000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("26-Mar-2025");
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

public static void DetailedreportVsCommercialHighcountEx(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
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
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("26-Mar-2025");
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


public static void DetailedreportVsCommercialMediumcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
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
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	CFOcountPOM.ComplianceTypeEventBasedCheckList().click();
	Thread.sleep(5000);
	CFOcountPOM.ComplianceTypeStatutoryCheckList().click();
	Thread.sleep(5000);
	
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
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

public static void DetailedreportVsCommercialMediumcountEx(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
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
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(8000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
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
    
    
    //CFOcountPOM.mgmtdetailreportstartpassing().click();
}


public static void DetailedreportVsCommercialLowcount(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
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
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
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

public static void DetailedreportVsCommercialLowcountEx(ExtentTest test)throws InterruptedException
{
	Thread.sleep(3000);
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");						//Scrolling down window by 1000 px.
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
	CFOcountPOM.StatutoryM().click();
	Thread.sleep(1000);
	CFOcountPOM.ComplianceTypeEventBased().click();
	Thread.sleep(5000);
	
	
	CFOcountPOM.Apply().click();
	Thread.sleep(4000);
	
	CFOcountPOM.PeriodDropDown().click();
	Thread.sleep(2000);
	CFOcountPOM.PeriodAll().click();
	Thread.sleep(2000);
   	CFOcountPOM.StartDate2().sendKeys("01-Apr-2024");
	Thread.sleep(2000);
	CFOcountPOM.EndDate2().sendKeys("02-May-2025");
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





public static void NCcompletionVsNCOverdueP (ExtentTest test)throws InterruptedException
{
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
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


public static void NCcompletionVsNCOverduePIn(ExtentTest test)throws InterruptedException
{
	CFOcountPOM.RefreshNow().click();
	
	Thread.sleep(3000);
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
	
	int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());	//Reading value of 'Not Completed'

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


public static void NCcompletionVsNCOverduePInAu(ExtentTest test)throws InterruptedException
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
	
	int NotCompletedValue = Integer.parseInt(CFOcountPOM.clickNotCompletedInternal().getText());	//Reading value of 'Not Completed'

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




}


	


