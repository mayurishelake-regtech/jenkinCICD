package researchReviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class RRLocators extends BasePage {
	
private static WebElement researchReviewer = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> researchReviewerList = null;		
	
	public static WebElement clickManageCompliance()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return researchReviewer;                        
	}

	public static WebElement MinistryMaster()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[7]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement MinistryMasterAddNew()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return researchReviewer;                                         
	}
	
	public static WebElement MinistryName()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtFName']"));
		return researchReviewer;               
	}
	
	public static WebElement Save()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return researchReviewer;                        
	}
	
	public static WebElement SaveMsg()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return researchReviewer;                                        
	}
	
	public static WebElement Close()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return researchReviewer;                        
	}
	
	public static WebElement Filter()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return researchReviewer;                        
	}
	
	public static WebElement ClickEdit()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton1_0']/img"));
		return researchReviewer;                     
	}
	
	public static WebElement DeleteMinistryDetails()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton2_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement RegulatorMaster()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[8]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement RegulatorName()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtFName1']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDepartmentMaster()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[9]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement Act()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[2]/a"));
		return researchReviewer;                        
	}
	
	
	public static WebElement ActAddNew()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddAct']"));
		return researchReviewer;                        
	}
	
	public static WebElement Name()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return researchReviewer;                        
	}
	
	public static WebElement Actgroup()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[3]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDemo()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.linkText("Act Demo1"));
		return researchReviewer;                        
	}
	
	public static WebElement ActApplicabilityRules()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxdescription']"));
		return researchReviewer;                        
	}
	
	public static WebElement ShortForm()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtshortform']"));
		return researchReviewer;                        
	}
	
	public static WebElement CompanyType()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtCompanyType']"));
		return researchReviewer;                        
	}
	
	
	public static WebElement SelectAll()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptCompanyType_CompanyTypeSelectAll']"));
		return researchReviewer;                        
	}
	
	public static WebElement Ok()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptCompanyType_btnRepeaterCompanyType']"));
		return researchReviewer;                        
	}
	
	public static WebElement BusinessActivity()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtBusinessActivityType']"));
		return researchReviewer;                        
	}
	
	
	public static WebElement SelectAllBA()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptBusinessActivityType_BusinessActivityTypeSelectAll']"));
		return researchReviewer;                        
	}
	
	public static WebElement OkBA()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptBusinessActivityType_btnBusinessActivityType']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActApplicability()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtActApplicability']"));
		return researchReviewer;                        
	}
	
	public static WebElement SelectAllAA()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActApplicability_ActApplicabilitySelectAll']"));
		return researchReviewer;                        
	}
	
	public static WebElement OkAA()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActApplicability_btnActApplicability']"));
		return researchReviewer;                        
	}
	
	public static WebElement Type()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[11]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement Central()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.linkText("Central"));
		return researchReviewer;                        
	}
	
	public static WebElement Category()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[12]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement ClientSpecific()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.linkText("Client Specific"));
		return researchReviewer;                        
	}
	
	public static WebElement StartDate()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return researchReviewer;                        
	}
	
	public static WebElement Industry()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtIndustry']"));
		return researchReviewer;                        
	}
	
	public static WebElement Agriculture()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptIndustry_chkIndustry_0']"));
		return researchReviewer;                        
	}
	
	public static WebElement AgricultureOk()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptIndustry_btnRepeater']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDocumentType()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/div/fieldset/div[1]/span[1]/a/span[1]"));
		return researchReviewer;                        
	}
	
	public static WebElement ActRule()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.linkText("Act / Rules / Regulations"));
		return researchReviewer;                        
	}
	
	public static WebElement File()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_ActFile_upload']"));
		return researchReviewer;                      
	}
	
	public static WebElement SaveAct()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return researchReviewer;                        
	}
	
	public static WebElement SaveActMsg()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return researchReviewer;                        
	}
	
	public static WebElement CloseAct()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return researchReviewer;                        
	}
	
	public static WebElement FilterAct()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActEdit()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAct_lbtEdit_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement Country()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlcountry']"));
		return researchReviewer;                        
	}
	
	public static WebElement CountryIndia()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlcountry']/option[36]"));
		return researchReviewer;                        
	}
	
	public static WebElement ClickDownload()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_GrdforFileName_lbkDownload_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement ActDelete()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAct_lbtDelete_0']/img"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroup()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[3]/a"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupAdd()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddEvent']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupName()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtName']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupSave()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupFilter()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return researchReviewer;                        
	}
	
	public static WebElement ActGroupText()		//Method for closing Message Popup
	{
		researchReviewer = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdActGroup_Label1_0']"));
		return researchReviewer;                        
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
