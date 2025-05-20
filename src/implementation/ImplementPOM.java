package implementation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ImplementPOM extends BasePage {
	
	private static WebElement implement = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> implementList = null;		
	
	public static WebElement clickManageUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return implement;
	}
	
	public static WebElement clickCustomers()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[4]/a"));
		return implement;
	}
	
	public static WebElement ClickAddNew()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddCustomer']"));
		return implement;
	}
	
	public static WebElement clickServiceProvider()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]"));
		return implement;
	}
	
	public static WebElement SelectAvantis ()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='ui-id-21']"));
		return implement;
	}
	
	public static WebElement CustomerName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxName']"));
		return implement;
	}
	
	public static WebElement BuyerName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerName']"));
		return implement;
	}
	
	public static WebElement BuyerContactNo()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerContactNo']"));
		return implement;
	}
	
	public static WebElement BuyerEmail()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBuyerEmail']"));
		return implement;
	}
	
	public static WebElement ClickSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_btnSave']"));
		return implement;
	}
	
	public static WebElement CustomerAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[1]/a"));
		return implement;
	}
	
	public static WebElement ClickAddNewCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddWidget']"));
		return implement;
	}
	
	public static WebElement SelectCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtComplince']"));
		return implement;
	}
	
	public static WebElement SelectPerformer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlNewUsers']"));
		return implement;
	}
	
	public static WebElement SelectRT()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlNewUsers']/option[2]"));
		return implement;
	}
	
	public static WebElement SelectReviewer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']"));
		return implement;
	}
	
	
	public static WebElement SelectAA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']/option[2]"));
		return implement;
	}
	
	public static WebElement SelectIA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlReviewerUsers']/option[3]"));
		return implement;
	}
	
	public static WebElement ClickSaveCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;
	}
	
	public static WebElement FilterCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement ClickEditCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomer_lbtEdit_5']"));
		return implement;
	}
	
	public static WebElement UpdateMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return implement;
	}
	
	public static WebElement CloseCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;
	}
	
	public static WebElement DeleteCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomer_lbtDelete_5']"));
		return implement;
	}
	
	public static WebElement ClickEditC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton1_5']/img"));
		return implement;
	}
	
	public static WebElement Address()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxAddress']"));
		return implement;
	}
	
	public static WebElement Delete()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton2_5']/img"));
		return implement;
	}
	
	public static WebElement Filter()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement clickSubEntity()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomer']/tbody/tr[8]/td[10]/a"));
		return implement;
	}
	
	public static WebElement SubEntityAddNew()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddCustomerBranch']"));
		return implement;
	}
	
	public static WebElement EnterName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;
	}
	
	public static WebElement SubEntityType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[4]/span[1]/a/span[1]"));
		return implement;
	}
	
	public static WebElement LegalEntity()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Legal Entity (Company)"));
		return implement;
	}//*[@id="ui-id-1661"]
	
	public static WebElement Type()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divCompanyType']/span/a/span[1]"));
		return implement;
	}
	
	public static WebElement DeemedPublicCompany()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Deemed Public Company"));
		return implement;
	}
	
	public static WebElement LLP()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Limited Liability Partnership (LLP)"));
		return implement;
	}
	
	public static WebElement Industry()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtIndustry']"));
		return implement;
	}
	
	public static WebElement ClickCheck()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptIndustry_chkIndustry_2']"));
		return implement;
	}
	
	public static WebElement AddressLine1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxAddressLine1']"));
		return implement;
	}
	
	public static WebElement State()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divState']/span[1]/input"));
		return implement;
	}
	
	public static WebElement Maharashtra()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Maharashtra"));
		return implement;
	}
	
	public static WebElement City()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[12]/span[1]/input"));
		return implement;
	}//*[@id="BodyContent_upCustomerBranches"]/div[1]/div[12]/span[1]/input
	
	public static WebElement Anagar()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Ahmednagar"));
		return implement;
	}
	
	public static WebElement ContactPerson()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxContactPerson']"));
		return implement;
	}
	
	public static WebElement ContactEmail()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxEmail']"));
		return implement;
	}
	
	public static WebElement SaveSE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;
	}
	
	public static WebElement FilterSE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;
	}
	
	public static WebElement ClickEditSE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomerBranch_LinkButton1_0']/img"));
		return implement;
	}
	
	public static WebElement ClickDeleteSE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomerBranch_LinkButton2_0']/img"));
		return implement;
	}
	
	public static WebElement ClickExport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;
	}                                          
	
	public static WebElement ClickDepartment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[2]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerDept()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return implement;                        
	}
	
	public static WebElement customer123()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("customer123"));
		return implement;                        
	}
	
	public static WebElement AddNewDept()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddUser']"));
		return implement;                     
	}
	
	public static WebElement DepartmentName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtFName']"));
		return implement;                        
	}
	
	public static WebElement DepartmentSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                        
	}
	
	public static WebElement DepartmentClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                        
	}
	
	public static WebElement DepartmentSaveMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return implement;                        
	}//*[@id="BodyContent_ctl03"]/ul/li
	
	public static WebElement DepartFilter()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                        
	}
	
	public static WebElement DepartEdit()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton1_0']/img"));
		return implement;                        
	}
	
	public static WebElement DepartUpdateMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl03']/ul/li"));
		return implement;                        
	}
	
	public static WebElement DepartDelete()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAuditor_LinkButton2_0']/img"));
		return implement;                        
	}
	
	public static WebElement ClickUserandBrach()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[5]/a"));
		return implement;                        
	}
	
	public static WebElement SelectCustomerUB()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']"));
		return implement;                        
	}
	
	public static WebElement ClickUsers()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rdoBtn_User']"));
		return implement;                        
	}
	
	public static WebElement ClickModifyAssignments()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnModifyAssignment_0']"));
		return implement;                        
	}
	
	public static WebElement ModifyAssignmentsClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                        
	}
	
	
	public static WebElement DepartmentDropdown()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[8]/td[4]/span/input"));
		return implement;                        
	}
	
	public static WebElement ClickBranches()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rdoBtn_Branch']"));
		return implement;                        
	}
	
	public static WebElement UploadFile()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                        
	}
	
	public static WebElement clickUpload()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
		return implement;                        
	}
	
	public static WebElement clickUsers()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[3]/a"));
		return implement;                      
	}
	
	public static WebElement SelectCustomerUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return implement;                        
	}
	
	public static WebElement customer123Users()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                        
	}
	
	public static WebElement UsersEmail()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxEmail']"));
		return implement;                        
	}
	
	public static WebElement UsersFirstName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxFirstName']"));
		return implement;                        
	}
	
	public static WebElement UsersLastName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxLastName']"));
		return implement;                        
	}
	
	public static WebElement UsersDesignation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxDesignation']"));
		return implement;                        
	}
	
	
	public static WebElement UsersMobileNo()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxContactNo']"));
		return implement;                        
	}
	
	public static WebElement UsersDepartment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_txtDepartment']"));
		return implement;                        
	}
	
	public static WebElement DepartmentTech()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_rptDepartment_chkDepartment_1']"));
		return implement;                        
	}
	
	public static WebElement UserComplianceRole()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']"));
		return implement;                        
	}
	
	public static WebElement UserCompanyAdmin()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']/option[3]"));
		return implement;                        
	}
	
	public static WebElement UserMGMt()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlRole']/option[5]"));
		return implement;                        
	}
	
	
	public static WebElement SelectHrRole()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']"));
		return implement;                        
	}
	
	public static WebElement HR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlHRRole']/option[2]"));
		return implement;                        
	}
	
	public static WebElement LoginSSO()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_chkSSOAccess']"));
		return implement;                        
	}
	
	public static WebElement DesktopAccess()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_chkDesktopUserRestricted']"));
		return implement;                        
	}
	
	public static WebElement UserSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_btnSave']"));
		return implement;                        
	}
	
	public static WebElement UserEdit()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEdit_0']/img"));
		return implement;                        
	}
	
	public static WebElement UserDelete()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnDelete_0']/img"));
		return implement;                        
	}
	
	public static WebElement ResetPass()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnReset_0']/img"));
		return implement;                        
	}
	
	public static WebElement SC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlCustomer']"));
		return implement;                        
	}
	
	public static WebElement ABC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlCustomer']/option[3]"));
		return implement;                        
	}
	
	public static WebElement ExportUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
		return implement;                        
	}
	
	public static WebElement SelectLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tbxBranch']"));
		return implement;                       
	}
	
	public static WebElement Location1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_tvBranchest1']"));
		return implement;                        
	}
	
	public static WebElement UsersUploadMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_vsUploadUtility']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement ProductMapping()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[6]/a"));
		return implement;                                     
	}
	
	public static WebElement PMCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divCustomer']/span[1]/a"));
		return implement;                                     
	}
	
	public static WebElement PMABCDPvtLtd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                                     
	}
	
	public static WebElement PMCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Compliance"));
		return implement;                                     
	}
	
	public static WebElement PMAddMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement PMProduct()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divProduct']/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement PMSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement PMClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                     
	}
	
	public static WebElement PMDelete()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnDelete_0']/img"));
		return implement;                                     
	}
	
	public static WebElement ModifyAssignments()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[9]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerMA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectABCD()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                                  
	}
	
	public static WebElement SelectBitademopune()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Bitademopune"));
		return implement;                                     
	}
	
	public static WebElement SelectUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"));
		return implement;                                  
	}
	
	public static WebElement SearchUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/input"));
		return implement;                                  
	}
	
	public static WebElement SelectDevanshNew()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Devansh New"));
		return implement;                                     
	}
	
	
	public static WebElement Selectaaa()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("aaea aaa"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformerUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Performer User"));
		return implement;                                     
	}
	
	public static WebElement SelectASs()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("abc abd"));
		return implement;                                     
	}
	
	public static WebElement SelectASs1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("abc abd"));
		return implement;                                     
	}
	
	public static WebElement SelectNewPerformerUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformerabcabd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("abc abd"));
		return implement;                                     
	}
	
	public static WebElement SelectPerformeraaaaa()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("aaa aa"));
		return implement;                                     
	}
	
	
	public static WebElement SelectNewReviewerUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[4]/span/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Selectaaaaaad()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("aaea aaa"));
		return implement;                                     
	}
	
	public static WebElement SelectASsd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("A Ss"));
		return implement;                                     
	}
	
	public static WebElement CheckBox0()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.id("BodyContent_grdComplianceInstances_chkCompliances_0"));
		return implement;                                             
	}
	
	public static WebElement CheckBox1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.id("BodyContent_grdComplianceInstances_chkCompliances_1"));
		return implement;                                                
	}
	
	public static WebElement CheckBox2()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceInstances_chkCompliances_2']"));
		return implement;                                    
	}
	
	public static WebElement CheckINBox0()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_0']"));
		return implement;                                   
	}
	
	public static WebElement CheckINBox1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_1']"));
		return implement;                                   
	}
	
	public static WebElement CheckINBox2()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_chkICompliances_2']"));
		return implement;                                    
	}
	
	public static WebElement ClicksaveBtn()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSaveAssignment']"));
		return implement;                                     
	}
	
	public static WebElement ClickStaEventBased()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_chkEvent']"));
		return implement;                                  
	}
	
	public static WebElement ClickStaCheckList()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_chkCheckList']"));
		return implement;                                   
	}
	
	public static WebElement ClickInternalRB()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rbtSelectionType_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickExclude()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rbtModifyAction_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickTask()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rbtSelectType_1']"));
		return implement;                                 
	}
	
	public static WebElement ChechBoxInTask0()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdTask_chkTask_0']"));
		return implement;                                           
	}
	
	public static WebElement ChechBoxInTask1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdTask_chkTask_1']"));
		return implement;                                     
	}
	
	public static WebElement ClickReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"));
		return implement;                                     
	}
	
	public static WebElement UsageReportCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[1]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerRe()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_DivCustomer1']/div/div/span[1]"));
		return implement;                                 
	}
	
	public static WebElement SelectABCpvtltd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[2]"));
		return implement;                                     
	}
	
	public static WebElement FromDate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Div31']/span/span/span/span"));
		return implement;                                     
	}
	
	public static WebElement January19()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("19"));
		return implement;                                     
	}
	
	public static WebElement ToDate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Div41']/span/span/span/span"));
		return implement;                                     
	}
	
	public static WebElement January25()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("25"));
		return implement;                                     
	}
	
	public static WebElement ClickExportRe()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
		return implement;                                     
	}
	
	public static WebElement ClickClearBtn()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='Clearfilter']"));
		return implement;                                     
	}
	
	public static WebElement ClickUsageReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:90']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerUR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[1]/td[2]/span[1]/a/span[1]"));
		return implement;                              
	}
	
	public static WebElement SelectCustomerURI()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
		return implement;                              
	}
	
	public static WebElement SelectCustomerURa()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divc']/span[1]/a/span[1]"));
		return implement;                              
	}
	
	public static WebElement SelectCustomerRER()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divcustomer']/span/a"));
		return implement;                              
	}

	public static WebElement SelectCustomerCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']"));
		return implement;                        //*[@id="BodyContent_customerdiv"]/span/a      
	}
	
	public static WebElement SelectCustomerC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span/a"));
		return implement;                             
	}
	
	public static WebElement SelectBitademopuneCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']/option[2]"));
		return implement;                              
	}
	
	public static WebElement SelectCustomerIC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divcustomer']/span[1]/a"));
		return implement;                           
	}
	
	public static WebElement SelectCustomerCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a"));
		return implement;                              
	}
	
	public static WebElement SelectCustomerAC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[1]/td[2]/span[1]/a"));
		return implement;                              
	}
	
	public static WebElement SelectBitademopuneAC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_DivCustomer']/option[2]"));
		return implement;                                    
	}
	
	public static WebElement SelectBitademopuneRE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_DivCustomer']/option[2]"));
		return implement;                                    
	}
	
	public static WebElement SelectABCDRE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']/option[4]"));
		return implement;                                    
	}
	
	public static WebElement SelectABitaPharmaCompany()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchest0']"));
		return implement;                                     
	}
	
	public static WebElement FromDateUR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtStartDate']"));
		return implement;                                     
	}
	
	public static WebElement ToDateUR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtEndDate']"));
		return implement;                                     
	}
	
	public static WebElement ExportToExcel()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnExportExcel']"));
		return implement;                                     
	}
	
	public static WebElement StatutoryAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:97']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerSA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']"));
		return implement;                                     
	}//*[@id="BodyContent_divcustomer"]/span/a
	
	public static WebElement SelectCustomerARR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/span/a"));
		return implement;                                     
	}
	
	public static WebElement SelectBitademopuneSA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement ClickExportSA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;                                     
	}
	
	public static WebElement SelectCustomerAR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[1]/span/span[3]/span"));
		return implement;                                     
	}
	
	public static WebElement BitademopuneAR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("(//*[@class='k-in'])[3]"));
		return implement;                                     
	}
	
	public static WebElement ClickApply()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return implement;                                     
	}
	
	public static WebElement ClickExportLR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
		return implement;                                     
	}
	
	public static WebElement ClickClearLR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return implement;                                     
	}
	
	public static WebElement CheckListAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:97']/li[4]/a"));
		return implement;                                     
	}
	
	public static WebElement EventBasedAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:97']/li[5]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:97']/li[6]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalCheckListAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:97']/li[7]/a"));
		return implement;                                     
	}
	
	public static WebElement StatutoryLabelReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:97']/li[8]/a"));
		return implement;                                     
	}
	
	public static WebElement InternalLabelReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:97']/li[9]/a"));
		return implement;                                     
	}
	
	public static WebElement AllReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:90']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement CompliaceCountReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:91']/li[12]/a"));
		return implement;                                     
	}
	
	public static WebElement SelectCategory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlfilterCatagory']"));
		return implement;                                     
	}
	
	public static WebElement Commercial()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlfilterCatagory']/option[4]"));
		return implement;                                     
	}
	
	public static WebElement SelectType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFilterType']"));
		return implement;                                     
	}
	
	public static WebElement Central()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFilterType']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement InternalCompliances()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"));
		return implement;                                   
	}
	
	public static WebElement ComplianceActivation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:68']/li[3]/a"));
		return implement;                                     
	}
	
	public static WebElement AssignCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:80']/li[1]/a"));
		return implement;                                    
	}
	
	public static WebElement SelectPerformerCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[2]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement SelectLocationCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return implement;                               
	}
	
	public static WebElement Expand()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1']/img"));
		return implement;                               
	}
	
	public static WebElement ABitaPharmCompany()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt2']"));
		return implement;                               
	}
	
	public static WebElement LocationCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn0']/img"));
		return implement;                                   
	}
	
	public static WebElement ASDAZFTextileA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt1']"));
		return implement;                                     
	}
	
	public static WebElement ASDAZFTextileA1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt2']"));
		return implement;                                     
	}
	
	public static WebElement ASDAZFTextileACB()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
		return implement;                                     
	}
	
	public static WebElement ALENAVENTURESLIMITED()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt5']"));
		return implement;                                     
	}//*[@id="BodyContent_tvFilterLocationt1"]
	
	public static WebElement ALENAVENTURESLIMITEDCB()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
		return implement;                                     
	}
	
	
	public static WebElement ComplianceCategory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[2]/span[1]/a/span[1]"));
		return implement;                                  
	}
	
	public static WebElement ABCD()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("ABCD"));
		return implement;                                     
	}
	
	public static WebElement AerodromeLicence()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Aerodrome Licence"));
		return implement;                                     
	}
	
	public static WebElement FEManager()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("FE Manager"));
		return implement;                                     
	}
	
	public static WebElement abcExternal()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("abc External"));
		return implement;                                     
	}
	
	public static WebElement FMManager()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("FM Manager"));
		return implement;                                     
	}
	
	public static WebElement abclawyer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("abc lawyer"));
		return implement;                                     
	}
	
	public static WebElement SelectReviewerCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[4]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement ClickCheckBox()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkAssign_0']"));
		return implement;                                     
	}
	
	public static WebElement ClickSaveBTn()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button1']"));
		return implement;                                     
	}
	
	public static WebElement IntermediateCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:80']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement ClickEdit()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnedit_2']"));
		return implement;                                   
	}
	
	public static WebElement ClickEdit1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnedit_0']"));
		return implement;                                   
	}
	
	public static WebElement EditUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_2']"));
		return implement;                             
	}
	
	public static WebElement EditUser1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath(" //*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_0']"));
		return implement;                                    
	}
	
	public static WebElement CheckEdit()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_Label2_2']"));
		return implement;                                     
	}
	
	public static WebElement CheckFilter()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_Label2_0']"));
		return implement;                                     
	}
	
	public static WebElement EditUseraaaaa()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_2']/option[124]"));
		return implement;                                    
	}
	
	public static WebElement EditUserFE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_ddlUserList_0']/option[122]"));
		return implement;                                  
	}
	
	public static WebElement ClickUpdate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnupdate_2']"));
		return implement;                                     
	}
	
	public static WebElement ClickUpdate1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnupdate_0']"));
		return implement;                                     
	}
	
	
	public static WebElement ClickDelete()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnDelete_0']"));
		return implement;                                     
	}
	
	public static WebElement ClickDelete1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_btnDelete_0']"));
		return implement;                                     
	}
	
	public static WebElement ActivateCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:80']/li[3]/a"));
		return implement;                                    
	}
	
	public static WebElement select()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnlocation']"));
		return implement;                                     
	}
	
	public static WebElement selectDate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return implement;                                     
	}
	

	public static WebElement Date11()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("11"));
		return implement;
	}
	
	public static WebElement Date2()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("2"));
		return implement;
	}
	
	public static WebElement Date4()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("4"));
		return implement;
	}
	
	
	public static WebElement ActivateCheckBox()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkActivate_0']"));
		return implement;                                     
	}
	
	public static WebElement ExportActivate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;                                    
	}
	
	public static WebElement AssignCheckList()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:80']/li[4]/a"));
		return implement;                                     
	}
	
	public static WebElement IntermediateCheckList()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:80']/li[5]/a"));
		return implement;                                     
	}
	
	public static WebElement ActivateCheckList()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:80']/li[6]/a"));
		return implement;                                     
	}
		
	public static WebElement Masters()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:70']/li[1]/a"));
		return implement;                                     
	}
		
	public static WebElement MastersComplianceCategory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:69']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement Compliancetype()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:69']/li[1]/a"));
		return implement;                                     
	}
	
	public static WebElement AddNewCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddIComplianceCategory']"));
		return implement;                                     
	}
	
	public static WebElement Customer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlcustomernew']"));
		return implement;                                     
	}
	
	public static WebElement Bitademopune()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlcustomernew']/option[2]"));
		return implement;                                     
	}
	
	public static WebElement name()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;                                    
	}
	
	public static WebElement Description()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxDescription']"));
		return implement;                                     
	}
	
	public static WebElement Save()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement FilterM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement NameCheck()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement EditComplianceCategory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdIComplianceCategory_LinkButton1_0']/img"));
		return implement;                                     
	}
	
	public static WebElement EditComplianceType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdIComplianceType_LinkButton1_0']/img"));
		return implement;                                     
	}
	
	public static WebElement DeleteComplianceCategory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdIComplianceCategory_LinkButton2_0']/img"));
		return implement;                                     
	}
	
	public static WebElement DeleteComplianceType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdIComplianceType_LinkButton2_0']/img"));
		return implement;                                     
	}
	
	public static WebElement Compliances()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:71']/li[3]/a"));
		return implement;                       
	}
	
	public static WebElement AddNewCompliances()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddCompliance']"));
		return implement;                                     
	}
	
	public static WebElement TypeName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[2]/span[1]/input"));
		return implement;                                     
	}
	
	public static WebElement MaharashtraC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Maharashtra"));
		return implement;                                     
	}
	
	public static WebElement  CategoryName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[3]/span[1]/input"));
		return implement;                                 
	}
	
	public static WebElement AnnualMaintenanceContract()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Annual Maintenance Contract"));
		return implement;                                     
	}
	
	public static WebElement ABCDCom()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("ABCD"));
		return implement;                                     
	}
	
	public static WebElement  ShortDescription()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtShortDescription']"));
		return implement;                                     
	}
	
	public static WebElement ShortForm()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtShortForm']"));
		return implement;                                     
	}
	
	public static WebElement DetailedDescription()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtdetaileddescription']"));
		return implement;                                     
	}
	
	public static WebElement Frequency()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divFrequency']/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Annual()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Annual"));
		return implement;                                     
	}
	
	public static WebElement FiveYearly1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("FiveYearly"));
		return implement;                                     
	}
	
	public static WebElement PriorityType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div[1]/div[15]/span[1]/a/span[1]"));
		return implement;                                     
	}
	
	public static WebElement Low()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Low"));
		return implement;                                     
	}
	
	public static WebElement SaveCom()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                     
	}
	
	public static WebElement RecordSavemsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement RecordClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                     
	}
	
	public static WebElement SelectCategoryMC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[1]/td[2]/span/a"));
		return implement;                                     
	}
	
	public static WebElement ABCDMC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlComplinceCatagory']/option[4]"));
		return implement;                                    
	}
	
	public static WebElement FilterType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                                     
	}
	
	public static WebElement EditCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtEdit_0']/img"));
		return implement;                                     
	}
	
	public static WebElement CatName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_Label11_0']"));
		return implement;                                     
	}
	
	public static WebElement DeleteCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtDelete_0']/img"));
		return implement;                                     
	}
	
	public static WebElement DisplayScheduleInformation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_LinkButton3_0']/img"));
		return implement;                                     
	}
	
	public static WebElement close()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                     
	}
	
	public static WebElement SaveDsI()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSaveSchedule']"));
		return implement;                                     
	}
	
	public static WebElement DsIMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary2']/ul/li"));
		return implement;                                     
	}
	
	public static WebElement EditCompliances()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:69']/li[4]/a"));
		return implement;                                    
	}
	
	public static WebElement EditCompliancesCN()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlICategory']"));
		return implement;                                     
	}
	
	public static WebElement DescriptionEC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtdetaileddescription1']"));
		return implement;                                     
	}
	
	public static WebElement EditCompliancesCNA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlICategory']/option[4]"));
		return implement;                                     
	}
	
	
	public static WebElement UploadUtility()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:70']/li[2]/a"));
		return implement;                                     
	}
	
	public static WebElement UploadAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:77']/li[2]/a"));
		return implement;                                 
	}
	
	public static WebElement SelectCustomerU()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement BitademopuneU()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Bitademopune"));
		return implement;                                 
	}
	
	public static WebElement UploadFileU()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                                 
	}
	
	public static WebElement ExportEA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
		return implement;                                 
	}
	
	public static WebElement Upload()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
		return implement;                                 
	}
	
	public static WebElement UploadMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                 
	}
	
	public static WebElement PreviousInternalComplianceDepartmentMapping()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:75']/li[3]/a"));
		return implement;                                 
	}
	
	public static WebElement SelectCustomerPICDM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFilterCustomer']"));
		return implement;                               
	}
	
	public static WebElement SelectCustomerEA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divcustomer']/span/a/span[1]"));
		return implement;                              
	}
	
	public static WebElement ABCDPvtLtd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFilterCustomer']/option[4]"));
		return implement;                                
	}
	
	public static WebElement  SelectEntityLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
		return implement;                              
	}
	
	public static WebElement  ExpandABCDPvtLtd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn0']/img"));
		return implement;                            
	}
	
	public static WebElement  AWSGFJBitaLimited()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement  ASDAZFTextile1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement  Export()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDownload']"));
		return implement;                               
	}
	
	public static WebElement  InternalComplianceID()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdClient']/tbody/tr[2]/td[2]"));
		return implement;                                 
	}
	
	public static WebElement  EntitiesAssignments()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:68']/li[4]/a"));
		return implement;                                 
	}
	
	public static WebElement  EntitiesAssignments1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:88']/li[1]/a"));
		return implement;                                 
	}
	
	public static WebElement  AddNew()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddComplianceType']"));
		return implement;                                 
	}
	
	public static WebElement CustomerAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divassigncustomer']/span[1]/a/span[1]"));
		return implement;                        
	}//*[@id="BodyContent_divassigncustomer"]/span[1]/a/span[1]
	
	public static WebElement CustomerAE1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']"));
		return implement;                        
	}
	
	public static WebElement ABCDPvtLtdEA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlcustomer']/option[4]"));
		return implement;                               
	}
	
	public static WebElement ABCDPvtLtdEA1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']/option[4]"));
		return implement;                               
	}
	
	
	public static WebElement Location()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return implement;                            
	}
	
	public static WebElement LocationExpand()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return implement;                                 
	}
	
	public static WebElement ASDAZFTextile()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement selectAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnselect']"));
		return implement;                                 
	}
	
	public static WebElement User()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliance']/div/div[6]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement User1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlUsers']"));
		return implement;                                 
	}//*[@id="BodyContent_upCompliance"]/div/div[7]/span[1]/a/span[1]
	
	
	public static WebElement mgmtf()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("CFO Finance"));
		return implement;                          
	}
	
	public static WebElement mgmtf1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("mgmt f"));
		return implement;                          
	}
	
	
	public static WebElement ComplianceCategoryAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel2']/div/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement ComplianceCategoryAE1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlComplianceCatagory']"));
		return implement;                                 
	}
	
	public static WebElement JuneCompliance ()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Companies Act, 1994"));
		return implement;                                 
	}
	
	public static WebElement SaveAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                 
	}
	
	public static WebElement SelectUserAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divFilterUsers']/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement DeleteEntities()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_LinkButton1']"));
		return implement;                                 
	}
	
	public static WebElement DeptDeleteEntities()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDeleteComplianceType']"));
		return implement;                                 
	}
	
	public static WebElement DeleteCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divDeletecustomer']/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement DeleteABCDPvtLtd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                                 
	}
	
	public static WebElement DeleteLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_TextBox1']"));
		return implement;                                 
	}
	
	public static WebElement DeleteExpand()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_TreeView1n0']/img"));
		return implement;                                 
	}
	
	public static WebElement DeleteExpand1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_TreeView1n1']/img"));
		return implement;                                 
	}
	
	public static WebElement DeleteTextile()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_TreeView1n1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement DeleteUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel3']/div/div[3]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement DeleteUsermgmtf()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("mgmt f"));
		return implement;                                 
	}
	
	public static WebElement DeleteUser1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_delddluser']"));
		return implement;                                 
	}
	
	public static WebElement Deletemgmtf()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_delddluser']/option[2]"));
		return implement;                                 
	}
	
	
	public static WebElement DeleteCategory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel5']/div/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement DeleteCategory1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_delddlcomcatagory']"));
		return implement;                                 
	}
	
	public static WebElement DeleteClientSpecific()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_delddlcomcatagory']/option[3]"));
		return implement;                                 
	}
	
	public static WebElement ClientSpecificC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Client Specific"));
		return implement;                                 
	}
	
	
	public static WebElement DeleteAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                 
	}
	
	public static WebElement DeleteClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button3']"));
		return implement;                                 
	}
	
	public static WebElement LicenseEntitiesAssignments()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:88']/li[2]/a"));
		return implement;                                 
	}
	
	public static WebElement LicenseCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divcustomer']/span/a/span[1]"));
		return implement;                            
	}
	
	public static WebElement LicenseCustomerAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divaddcustomer']/span[1]/a/span[1]"));
		return implement;                                 
	}//*[@id="BodyContent_divaddcustomer"]/span[1]/a/span[1]
	
	public static WebElement LicenseLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return implement;                                 
	}//*[@id="BodyContent_TextBox1"]
	
	public static WebElement LicenseExpand()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return implement;                                 
	}
	
	public static WebElement ABitaPharmaCompany()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn1CheckBox']"));
		return implement;                                 
	}
	
	public static WebElement selectAe()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnlocationpop']"));
		return implement;                                 
	}
	
	public static WebElement  Licenseuser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[2]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  CFOFinance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("CFO Finance"));
		return implement;                               
	}
	
	public static WebElement  Deptuser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliance']/div/div[2]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  DelDeptuser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDelete']/div/div[2]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	
	public static WebElement  RahulTesting()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Rahul Testing"));
		return implement;                               
	}
	
	public static WebElement  LicenseType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[3]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  aaaaaa()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("aaaaaa"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteEntities()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btndeleteComplianceType']"));
		return implement;                                
	}
	
	public static WebElement  LicenseDeleteEntities1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Delete entities"));
		return implement;                                
	}
	
	
	public static WebElement  LicenseDeleteC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divdelcustomer']/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteLoc()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_TextBox1']"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteLocExpand()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_TreeView1n1']/img"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteABitPharmaCompany()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_TreeView1t2']"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDeleteUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel3']/div/div[4]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	
	public static WebElement  LicenseDeleteType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel3']/div/div[5]/span[1]/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDelete()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDelete']"));
		return implement;                                 
	}
	
	public static WebElement  LicenseDelete1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                 
	}
	
	public static WebElement  ManageCompliances()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"));
		return implement;                              
	}
	
	public static WebElement  MastersMC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:17']/li[1]/a"));
		return implement;                            
	}
	
	public static WebElement  ActSelect()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtactList']"));
		return implement;                            
	}
	
	public static WebElement  Act1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActList_chkAct_0']"));
		return implement;                            
	}
	
	public static WebElement  Act2()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActList_chkAct_1']"));
		return implement;                            
	}
	
	public static WebElement  ActOk()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActList_btnRepeater']"));
		return implement;                            
	}
	
	public static WebElement  CompliancesMC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:18']/li[1]/a"));
		return implement;                                 
	}
	
	public static WebElement  ComplianceCatagory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[1]/td[1]/span/a/span[1]"));
		return implement;                                
	}
	
	public static WebElement  ClientSpecific()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Client Specific"));
		return implement;                                 
	}
	
	public static WebElement  ClientSpecific1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlComplianceCatagory']/option[3]"));
		return implement;                                 
	}
	
	public static WebElement  ActGroup()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[2]/td[1]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  ActDemo1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Act Demo1"));
		return implement;                                 
	}
	
	public static WebElement  CompliancesType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[1]/td[2]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  CentralMC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlComplianceType']/option[2]"));
		return implement;                                 
	}
	
	public static WebElement  DisplaySchedule()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_LinkButton3_0']"));
		return implement;            //*[@id="BodyContent_grdCompliances_LinkButton3_0"]                     
	}
	
	public static WebElement  DisplayScheduleClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                                 
	}
	
	public static WebElement  idMatch()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances']/tbody/tr[2]/td[1]"));
		return implement;                                 
	}
	
	public static WebElement  Acts()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:18']/li[2]/a"));
		return implement;                                 
	}
	
	public static WebElement  ActsCatrgory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upActList']/table/tbody/tr/td[1]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  ActsType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upActList']/table/tbody/tr/td[2]/span/a/span[1]"));
		return implement;                                 
	}
	
	public static WebElement  idCheck()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAct']/tbody/tr[2]/td[1]"));
		return implement;                                 
	}
	
	public static WebElement  EditComplianceMC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtEdit_0']"));
		return implement;                                 
	}
	
	public static WebElement  EditComplianceClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                 
	}
	
	public static WebElement  ComplianceDetails()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Compliance Details"));
		return implement;                          
	}
	
	public static WebElement  EditAct()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdAct_lbtEdit_0']"));
		return implement;                                 
	}
	
	public static WebElement  Act()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Act"));
		return implement;                                 
	}
	
	public static WebElement  EditActClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                                 
	}
	
	public static WebElement  HolidayMaster()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:18']/li[3]/a"));
		return implement;                              
	}
	
	public static WebElement SelectComplianceType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upHolidayList']/table/tbody/tr/td[1]/span/a/span[1]"));
		return implement;                              
	}
	
	public static WebElement ComplianceTypeCentral()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Central"));
		return implement;                              
	}
	
	public static WebElement AddNewHM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddHoliday']"));
		return implement;                              
	}
	
	public static WebElement Name()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;                              
	}
	
	public static WebElement TypeHM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlComplianceType']"));
		return implement;                              
	}
	
	public static WebElement Date()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxDate']"));
		return implement;                              
	}
	
	public static WebElement  Date15()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("15"));
		return implement;                                 
	}
	
	public static WebElement  Date16()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("16"));
		return implement;                                 
	}
	
	public static WebElement save()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
	
	public static WebElement savemsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                             
	}
	
	public static WebElement Close()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                              
	}
	
	public static WebElement namecheck()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdHoliday']/tbody/tr[2]/td[2]/div/span"));
		return implement;                              
	}
	
	public static WebElement EditHoliday()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdHoliday_lbtEdit_0']/img"));
		return implement;                              
	}
	
	public static WebElement DeleteHM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdHoliday_lbtDelete_0']/img"));
		return implement;                              
	}
	
	public static WebElement WidgetMaster()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:18']/li[4]/a"));
		return implement;                              
	}
	
	public static WebElement WidgetAddNew()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddWidget']"));
		return implement;                              
	}
	
	public static WebElement WidgetCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']"));
		return implement;                              
	}
	
	public static WebElement WidgetABCDPvtLtd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']/option[4]"));
		return implement;                              
	}
	
	public static WebElement WidgetLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return implement;                              
	}
	
	public static WebElement AWSGFJBitaLimited1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchest1']"));
		return implement;                              
	}
	
	public static WebElement WidgetName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
		return implement;                              
	}
	
	public static WebElement WidgetAct()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtACTName']"));
		return implement;                              
	}
	
	public static WebElement WidgetActCheckBox()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActs_chkACT_0']"));
		return implement;                              
	}
	
	public static WebElement WidgetActCheckBoxAll()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActs_ActSelectAll']"));
		return implement;                              
	}
	
	public static WebElement WidgetOk()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptActs_btnRepeater']"));
		return implement;                              
	}
	
	public static WebElement WidgetCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtComplince']"));
		return implement;                              
	}
	
	public static WebElement WidgetCompliancecheck()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptCompliances_chkcompliance_0']"));
		return implement;                              
	}
	
	public static WebElement WidgetComplianceOk()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptCompliances_btnRepeatersub']"));
		return implement;                              
	}
	
	public static WebElement WidgetSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
	
	public static WebElement WidgetSavemsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl04']/ul/li"));
		return implement;                              
	}
	
   public static WebElement WidgetClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                              
	}
	
   public static WebElement WidgetNameCheck()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdWidget']/tbody/tr[2]/td[3]/div/span"));
  		return implement;                              
  	}
   
   public static WebElement WidgetEdit()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdWidget_lbtEdit_0']/img"));
 		return implement;                              
 	}
  	
   public static WebElement WidgetDeletet()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdWidget_lbtDelete_0']/img"));
		return implement;                              
	}
	
   public static WebElement WidgeC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
 		return implement;                              
 	}
   
   public static WebElement ABCDPvtLtd1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
  		return implement;                              
  	}
 	
   public static WebElement UploadUtilityMC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:17']/li[2]/a"));
 		return implement;                              
 	}
   
   public static WebElement UploadUtilityIC()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:70']/li[2]/a"));
  		return implement;                              
  	}

	
   public static WebElement UploadInternalCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:77']/li[1]/a"));
		return implement;                 
	}
	
   public static WebElement CustomerMC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
 		return implement;         //*[@id="BodyContent_checklistcustomer"]/span[1]/a/span[1]                     
 	}
 
   public static WebElement checklistcustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath(" //*[@id='BodyContent_checklistcustomer']/span[1]/a/span[1]"));
		return implement;                            
	}
   
   public static WebElement UploadFileCM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                              
	}
   
   public static WebElement CheckListFileUpload()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_MasterCheckListFileUpload']"));
 		return implement;                              
 	}
 	
   public static WebElement UploadMC()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
  		return implement;                              
  	}
   
   public static WebElement ChecklistUploadFile()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnChecklistUploadFile']"));
 		return implement;                              
 	}
   	
   public static WebElement AddChecklist()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Tab3']"));
 		return implement;                              
 	}
	
   public static WebElement ReadMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                            
	}
   
   public static WebElement ReadMsg1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary2']/ul/li"));
  		return implement;                              
  	}
   
   public static WebElement UploadAssignmentMC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:27']/li[2]/a"));
 		return implement;                              
 	}
 
   public static WebElement UploadEventBasedComplianceAssignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:27']/li[3]/a"));
		return implement;                              
	}//*[@id="CMPMenuBar:submenu:27"]/li[3]/a
   
   public static WebElement UploadAssignmentAll()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:26']/li[1]/a"));
		return implement;                              
	}
	
   public static WebElement SelectCustomerUA()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr/td/table/tbody/tr[1]/td[2]/span/a/span[1]"));
  		return implement;                              
  	}
  	
   public static WebElement SelectCustomerUE()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']"));
 		return implement;                              
 	}
   
   public static WebElement BitademopuneUE()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']/option[2]"));
  		return implement;                              
  	}
   
   public static WebElement ComplianceAssignment()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:17']/li[3]/a"));
 		return implement;                              
 	}
 	
   public static WebElement AssignComplianceCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:32']/li[1]/a"));
		return implement;                             
	}
  
   public static WebElement ComplianceType()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[4]/span[1]/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement IntermediateComplianceCA()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:32']/li[2]/a"));
 		return implement;                              
 	}//*[@id="CMPMenuBar:submenu:32"]/li[2]/a
   
   public static WebElement ActivateComplianceCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:32']/li[3]/a"));
		return implement;                              
	}
  
   public static WebElement AssignCheckListCA()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:32']/li[4]/a"));
  		return implement;                              
  	}
   
   public static WebElement IntermediateCheckListCA()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:32']/li[5]/a"));
 		return implement;                              
 	}

   public static WebElement ActivateCheckListCA()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:32']/li[6]/a"));
  		return implement;                              
  	}
   
   public static WebElement EntitiesAssignmentsMC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:17']/li[4]/a"));
 		return implement;                              
 	}
 
   public static WebElement EntitiesAssignmentsMC1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:41']/li[1]/a"));
  		return implement;                            
  	}
   
   public static WebElement LicenseEntitiesAssignments1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:42']/li[2]/a"));
 		return implement;                              
 	}
   
   public static WebElement ClientSpecificConfiguration()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:17']/li[5]/a"));
		return implement;                              
	}
   
   public static WebElement DepartmentWiseReopeningofcompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[18]/a"));
		return implement;                              
	}
 
   public static WebElement DaysBeforeDueDate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[14]/a"));
		return implement;                              
	}
  
   public static WebElement CustomerDB()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='ImplementationProjectPopup']/div[1]/div/span/span/span[3]/span"));
  		return implement;                              
  	}
   
   public static WebElement test1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("(//span[@class='k-in'])[19]"));
 		return implement;                              
 	}
	
   public static WebElement Monthly()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[2]/span"));
  		return implement;                              
  	}
   
   public static WebElement Quarterly()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[2]/td[2]/span"));
 		return implement;                              
 	}
	
   public static WebElement HalfYearly()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[3]/td[2]/span"));
		return implement;                              
	}
	
   public static WebElement Annual1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[4]/td[2]/span"));
  		return implement;                              
  	}
	
   public static WebElement FourMonthly()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[5]/td[2]/span"));
 		return implement;                              
 	}
	
   public static WebElement TwoYearly()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[6]/td[2]/span"));
		return implement;                              
	}
   
   public static WebElement SevenYearly()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[7]/td[2]/span"));
		return implement;                              
	}
   
   public static WebElement ThreeYearly()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[8]/td[2]/span"));
  		return implement;                              
  	}
   
   public static WebElement FiveYearly()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[9]/td[2]/span"));
 		return implement;                              
 	}
   
   public static WebElement Fortnightly()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[10]/td[2]/span"));
		return implement;                              
	}
	
   public static WebElement SaveBtn()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='dvsubmit']"));
		return implement;                              
	}
   
   public static WebElement Text1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[2]/input"));
  		return implement;                              
  	}
   
   public static WebElement Text2()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[2]/td[2]/input"));
 		return implement;                              
 	}
   
   public static WebElement Text3()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[3]/td[2]/input"));
  		return implement;                              
  	}
   
   public static WebElement Text4()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[4]/td[2]/input"));
 		return implement;                              
 	}
	
   public static WebElement Text5()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[5]/td[2]/input"));
		return implement;                              
	}
   
   public static WebElement Text6()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[6]/td[2]/input"));
		return implement;                              
	}
	
   public static WebElement Text7()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[7]/td[2]/input"));
  		return implement;                              
  	}
	
   public static WebElement Text8()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[8]/td[2]/input"));
 		return implement;                              
 	}
	
   public static WebElement Text9()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[9]/td[2]/input"));
		return implement;                              
	}
   
   public static WebElement Text10()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[10]/td[2]/input"));
		return implement;                              
	}
   
   public static WebElement ReOpeningofCompliance()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[15]/a"));
 		return implement;                              
 	}
   
   public static WebElement CustomerReopen()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='form1']/div[3]/table/tbody/tr[3]/td/div/div[1]/span/span/span[2]/span"));
		return implement;                              
	}
	
   public static WebElement AvantisTest1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='dropdownlistCustomer_listbox']/li[48]"));
  		return implement;                              
  	}
   
   public static WebElement ApproverCB()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='chkApprover']"));
 		return implement;                              
 	}
  	
   public static WebElement AuditorCB()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='chkAuditor']"));
  		return implement;                              
  	}
   	
   public static WebElement SaveREOpen()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
 		return implement;                              
 	}
  	
   public static WebElement BlockScheduleInternal()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[11]/a"));
		return implement;                             
	}
 	
   public static WebElement CustomerBSI()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divc']/span[1]/a/span[1]"));
		return implement;                              
	}
   
   public static WebElement ComplianceCategoryBSI()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[2]/span[1]/a/span[1]"));
  		return implement;                             
  	}
   
   public static WebElement DescriptionBSI()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxdescription']"));
		return implement;                              
	}
	
   public static WebElement BlockDate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
		return implement;                              
	}
   
   public static WebElement Date14()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("7"));
 		return implement;                              
 	}
	
   public static WebElement BlockCheckBox()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkActivate_0']"));
		return implement;                              
	}
  
   public static WebElement keep()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button1']"));
		return implement;                              
	}
 
   public static WebElement BlockDelete()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return implement;                              
	}
 
   public static WebElement BlockScheduleStatutory()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[10]/a"));
  		return implement;                              
  	}
   
   public static WebElement DocumentMandatoryNonMandatory()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[8]/a"));
 		return implement;                              
 	}
 
   public static WebElement DocumentCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/table/tbody/tr[1]/td[1]/span[1]/a/span[1]"));
		return implement;                                
	}
 
   public static WebElement ExportBtn()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDownload']"));
		return implement;                              
	}
 
   public static WebElement StartDateChange()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[8]/a"));
  		return implement;                              
  	}
   
   public static WebElement StartDateCustomer()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/table[1]/tbody/tr[1]/td[2]/span[1]/a/span[1]"));
 		return implement;                              
 	}
	
   public static WebElement ActName()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/table[1]/tbody/tr[3]/td[2]/span[1]/a/span[1]"));
		return implement;                              
	}
	
   public static WebElement ActName1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Act as on 19052022"));
		return implement;                              
	}
   
   public static WebElement Compliance()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/table[1]/tbody/tr[4]/td[2]/span[1]/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement Compliance1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.linkText("Compliance as on 19052022_1"));
  		return implement;                              
  	}
	
   public static WebElement StartDateMsg()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl01']/ul/li"));
 		return implement;                              
 	}
  
   public static WebElement DeleteStart()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btndelete']"));
		return implement;                              
	}
 
   public static WebElement ChangeDueDate()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:46']/li[7]/a"));
 		return implement;                              
 	}
   
   public static WebElement Customerspecificduedateforstatutorycompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[7]/a"));
		return implement;                        
	}
   
   public static WebElement AddNew1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddFrequency']"));
		return implement;                              
	}
   
   public static WebElement CustomerName1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[2]/span[1]/a/span[1]"));
 		return implement;                            
 	}
   
   public static WebElement ActNameDueDate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[3]/span[1]/input"));
		return implement;                              
	}
   
   public static WebElement ActNameDueDateLatest()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("Customs Act, 1962 and Warehoused Goods (Removal) Regulations, 2016"));
 		return implement;                              
 	}
   
   public static WebElement ShortDescription1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[4]/span[1]/a/span[1]"));
		return implement;                              
	}
   
   public static WebElement ShortDescription12()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Owner to produce an acknowledgement issued by proper officer stating arrival of goods to bond officer"));
		return implement;                              
	}
   
   public static WebElement DueDate()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[5]/span[1]/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement DueDateSave()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
 		return implement;                              
 	}
 
   public static WebElement DueDateSaveMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_vsLicenseListPage']/ul/li"));
		return implement;                       
	}
   
   public static WebElement DueDateClose()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
		return implement;                              
	}

   public static WebElement ActNameText()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdClient']/tbody/tr[2]/td[3]/div/span"));
  		return implement;                              
  	}
   
   public static WebElement Edit()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdClient_lbtEdit_0']/img"));
 		return implement;                              
 	}
  
   public static WebElement DisplayScheduleInformation1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdClient_LinkButton3_0']/img"));
		return implement;                              
	}
 
   public static WebElement DisplayScheduleInformationSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSaveSchedule']"));
		return implement;                              
	}

   public static WebElement Choose()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_FU_Upload']"));
  		return implement;                              
  	}
   
   public static WebElement Upload1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadSave']"));
 		return implement;                              
 	}

   public static WebElement Uploadmsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_VSCompliance']/ul/li"));
		return implement;                              
	}

   public static WebElement CertificateFrequencyMapping()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[6]/a"));
  		return implement;                              
  	}

   public static WebElement AddNewC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddAct']"));
 		return implement;                              
 	}
   
   public static WebElement CustomerCertificate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upAct']/div/div[2]/span[1]/a/span[1]"));
		return implement;                              
	}
   
   public static WebElement FrequencyCertificate()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']"));
		return implement;                              
	}
  
   public static WebElement QuarterlyCertificate()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']/option[3]"));
  		return implement;                              
  	}
    
   public static WebElement DueDateCertificate()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlDueDate']"));
 		return implement;                              
 	}
   
   public static WebElement DueDateCertificate3()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlDueDate']/option[3]"));
		return implement;                              
	}
   
   public static WebElement SaveCertificate3()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
  		return implement;                              
  	}
   
   public static WebElement CloseCertificate3()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
 		return implement;                              
 	}
   
   public static WebElement CertificateMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
		return implement;                              
	}

   public static WebElement CertificateEdit()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCertificateFrequency_lbtEdit_0']/img"));
  		return implement;                              
  	}
   
   public static WebElement graceperiod()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ChkGracePeriodTwo']"));
 		return implement;                              
 	}
   
   public static WebElement ClientComplianceRiskMapping()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[5]/a"));
		return implement;                              
	}
   
   public static WebElement ClientCustomer()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"));
  		return implement;                              
  	}//*[@id="BodyContent_upComplianceTypeList"]/table/tbody/tr[1]/td[1]/span[1]/a/span[1]
   
   public static WebElement SelectComplianceTypeC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlComplinceType']"));
 		return implement;                              
 	}
  
   public static WebElement Statutory()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlComplinceType']/option[2]"));
  		return implement;                              
  	}
   
   public static WebElement ClientRisk()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_ddlrisk_0']"));
 		return implement;                              
 	}
   
   public static WebElement ClientRiskMedium()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_ddlrisk_0']/option[3]"));
		return implement;                              
	}
   
   public static WebElement ClientCheckBox()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_Chkselection_0']"));
 		return implement;                              
 	}
   
   public static WebElement ClientSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
   
   public static WebElement ClientSaveMsg()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
  		return implement;                              
  	}
    
   public static WebElement ExportClient()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnExport']/img"));
 		return implement;                              
 	}
   
   public static WebElement PreviousComplianceDepartmentMapping()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[4]/a"));
		return implement;                              
	}
   
   public static WebElement PreviousExport()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDownload']"));
  		return implement;                              
  	}
   
   public static WebElement ClientFrequencyMapping()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[3]/a"));
 		return implement;                              
 	}
   
   public static WebElement AddNewCF()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddFrequency']"));
		return implement;                              
	}
   
   public static WebElement ClientFrequency()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/div/div[6]/span[1]/a/span[1]"));
 		return implement;                              
 	}
   
   public static WebElement ClientFrequencyEdit()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdClient_lbtEdit_0']/img"));
		return implement;                              
	}
  
   public static WebElement ClientFrequencyDelete()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdClient_lbtDelete_0']/img"));
  		return implement;                              
  	}
   
   public static WebElement SampleFormatCF()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/table/tbody/tr[2]/td[4]/u/a"));
 		return implement;                              
 	}
   
   public static WebElement UploadMeg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl01']/ul/li"));
		return implement;                              
	}
   
   public static WebElement TemplateMsg()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl02']/ul/li"));
  		return implement;                              
  	}

   public static WebElement ComplianceCertificate()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:18']/li[5]/a"));
 		return implement;                              
 	}
    
   public static WebElement CustomerCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']"));
		return implement;                              
	}
   
   public static WebElement BitaConsultingPvtLtd()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']/option[2]"));
 		return implement;                              
 	}
    
   public static WebElement CCAddNew()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddAct']"));
		return implement;                              
	}
   
   public static WebElement TemplateField()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlContractTemplate']"));
  		return implement;                              
  	}
   
   public static WebElement CompliedStatutoryChecklist()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlContractTemplate']/option[2]"));
 		return implement;                              
 	}
   
   public static WebElement FromDateCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFromDate']"));
		return implement;                              
	}
    
   public static WebElement EndDateCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxEndDate']"));
		return implement;                              
	}
   
   public static WebElement SaveCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	}
   
   public static WebElement DownloadCC()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button1']"));
  		return implement;                              
  	}
   
   public static WebElement CloseCC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='form1']/div[5]/div[1]/button/span[1]"));
 		return implement;                              
 	}
     
   public static WebElement EditCC()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdTemplate_lbtEdit_0']/img"));
		return implement;                              
	}
   
   public static WebElement BranchName()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlContractTemplate']/option[2]"));
  		return implement;                              
  	}
   
   public static WebElement DeleteCC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdTemplate_lbtDelete_0']/img"));
 		return implement;                              
 	}
      
   public static WebElement ManageEvents()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"));
		return implement;                       
	}
     
   public static WebElement Uploadeventassignment()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[1]/a"));
  		return implement;                              
  	}
       
   public static WebElement SelectCustomerEvent()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']"));
 		return implement;                              
 	}
      
   public static WebElement EventABCDPvtLtd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerList']/option[4]"));
		return implement;                              
	}
     
   public static WebElement UploadFileEvent()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
  		return implement;                              
  	}
   
   public static WebElement UploadEvent()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
 		return implement;                              
 	}
   
   public static WebElement UploadEventMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                              
	}
  
   public static WebElement Event()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[2]/a"));
  		return implement;                         
  	}
   
   public static WebElement EditEvent()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdEventList_lbtEdit_0']/img"));
 		return implement;                              
 	}
   
   public static WebElement DescriptionEvent()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtDescription']"));
		return implement;                              
	}
   
   public static WebElement EventSave()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
  		return implement;                              
  	}
     
   public static WebElement EventClose()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
 		return implement;                              
 	}
    
   public static WebElement DeleteEvent()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdEventList_lbtDelete_0']/img"));
		return implement;                              
	}
   
   public static WebElement DeleteEventMsg()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_updivSubEventDelete']/div[2]"));
  		return implement;                              
  	}
   
   
   public static WebElement DeleteEventClose()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCloseSubEvent']"));
 		return implement;                              
 	}
  
   public static WebElement ComplianceEvent()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[3]/a"));
		return implement;                              
	}
 
   public static WebElement ComplianceCategoryEvent()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliancesList']/table/tbody/tr[1]/td[1]/span/a/span[1]"));
  		return implement;                              
  	}
   
   public static WebElement CommercialEvent()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("Commercial"));
 		return implement;                              
 	} 
   
   public static WebElement EditCompliance1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCompliances_lbtEdit_0']/img"));
		return implement;                              
	} 
   
   public static WebElement StartDate()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
  		return implement;                              
  	} 
     
   public static WebElement CloseCompliance1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
 		return implement;                              
 	} 
    
   public static WebElement Eventdeactivation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[4]/a"));
		return implement;                              
	} 
   
   public static WebElement Customerdeactivation()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upEvent']/table[1]/tbody/tr[1]/td[2]/span[1]/a"));
  		return implement;                              
  	} 
     
   public static WebElement SelectLocationdea()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
 		return implement;                            
 	} 
    
   public static WebElement ExpandABCDPvtLtd1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn0']/img"));
		return implement;                              
	} 
 
   public static WebElement ABCDAurangabadPvt()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationt4']"));
  		return implement;                              
  	} 
   
   public static WebElement ABCDAurangabadPvt1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1CheckBox']"));
 		return implement;                              
 	} 
   
   public static WebElement EventName()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upEvent']/table[1]/tbody/tr[3]/td[2]/span[1]/a/span[1]"));
 		return implement;                              
 	} 
   
   public static WebElement Amendmentfactorylicense()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Amendment in factory license"));
		return implement;                              
	} 
   
   public static WebElement EventNature()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upEvent']/table[1]/tbody/tr[4]/td[2]/span[1]/a/span[1]"));
  		return implement;                              
  	} 
   
   public static WebElement Licenseeventtest()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("License event test"));
 		return implement;                              
 	} 
  
   public static WebElement keep1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnKeep']"));
		return implement;                              
	} 
 
   public static WebElement Delete1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btndelete']"));
  		return implement;                              
  	} 
   
   public static WebElement Eventassignments()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[5]/a"));
 		return implement;                          
 	} 
   
   public static WebElement AddNewEvent()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAssigncompliances']"));
		return implement;                              
	} 
   
   public static WebElement EventClassification()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[1]/span[1]/a/span[1]"));
  		return implement;                            
  	} 
   
   public static WebElement Secretarial()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("Secretarial"));
 		return implement;                              
 	} 
  
   public static WebElement CustomerAssignE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']"));
		return implement;                            
	} 
   
   public static WebElement CustomerABCD()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerNew']/option[4]"));
  		return implement;                              
  	} 
     
   public static WebElement LocationAssignE()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
 		return implement;                              
 	} 
   
   public static WebElement ExpandABCDPvtLtdAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return implement;                              
	} 
   
   public static WebElement APvtltd()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchest1']"));
		return implement;                              
	} 
   
   public static WebElement SelectEventPerformer()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel1']/div[4]/span/input"));
  		return implement;                              
  	} 
   
   public static WebElement PerfomUser()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("Perfom User"));
 		return implement;                              
 	} 
   
   public static WebElement SelectEventReviewer()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divEvReviewer']/span/input"));
 		return implement;                              
 	} 
  
  public static WebElement ReviewerUser()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Reviewer User"));
		return implement;                              
	} 
  
  public static WebElement eventcheckbox()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdEventInstance_chkEvent_0']"));
		return implement;                              
	} 
   
  public static WebElement SaveEvent()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                              
	} 
   
  public static WebElement AssignCompliance1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnComplianceList']"));
 		return implement;                              
 	} 
    
  public static WebElement AssignComplianceReviewer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliance']/table/tbody/tr[2]/td[2]/span[1]/input"));
		return implement;                              
	} 
   
  public static WebElement AssignCompliancePerformer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCompliance']/table/tbody/tr[1]/td[4]/span[1]/input"));
		return implement;                              
	} 
   
  public static WebElement AssignComplianceCheckBox()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_gvComplianceListAssign_chkComplianceCheck']"));
 		return implement;                              
 	} 
   
  public static WebElement AssignComplianceSave()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_SaveComplianceList']"));
		return implement;                              
	} 
 
  public static WebElement Complianceassignments()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[6]/a"));
 		return implement;                              
 	} 
  
  public static WebElement Eventfrequencymapping()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[7]/a"));
		return implement;                              
	} 
   
  public static WebElement AddNewEFM()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddEFM']"));
 		return implement;                              
 	} 
   
  public static WebElement CustomerEFM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upEFM_Dialog']/div[1]/div[2]/span[1]/a/span[1]"));
		return implement;                              
	} 
 
  public static WebElement EventClassification1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlEventClassification']"));
 		return implement;                              
 	} 
   
  public static WebElement Secretarial1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlEventClassification']/option[3]"));
		return implement;                              
	} 
  
  public static WebElement EventNameEFM()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upEFM_Dialog']/div[1]/div[4]/span[1]/a/span[1]"));
 		return implement;                              
 	} 
   
  public static WebElement AlterationinArticle()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Alteration in Articles (Public Company)"));
		return implement;                              
	} 
  
  public static WebElement FrequencyEFM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']"));
		return implement;                              
	} 

  public static WebElement QuarterlyEFM()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']/option[3]"));
 		return implement;                              
 	} 
  
  public static WebElement MonthlyEFm()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlFrequency']/option[2]"));
		return implement;                              
	} 

  public static WebElement SaveMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                              
	} 

  public static WebElement EditConfiguration()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdEventFrequencyMap_lbtEdit_0']/img"));
		return implement;                              
	} 

  public static WebElement DeleteConfiguration()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdEventFrequencyMap_lbtDelete_0']/img"));
 		return implement;                              
 	} 
  
  public static WebElement DisplayScheduleInformationEFM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdEventFrequencyMap_lbtShowShedule_0']/img"));
		return implement;                              
	} 

  public static WebElement DSIEditConfiguration()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_lbtEdit_0']/img"));
		return implement;                              
	} 
  
  public static WebElement ScheduleDate()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_tbxDueDate_0']"));
 		return implement;                              
 	} 
  
  public static WebElement UpdateConfiguration()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_lbtUpdate_0']/img"));
		return implement;                              
	} 

  public static WebElement CancelConfiguration()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grvEFM_Schedule_lbtCancel_0']/img"));
 		return implement;                              
 	} 
  
  public static WebElement DisplayScheduleInformationEFMClopse()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='form1']/div[6]/div[1]/button/span[1]"));
 		return implement;                              
 	} 
  
  public static WebElement ChooseFile()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_FU_Upload']"));
		return implement;                              
	} 

  public static WebElement UploadEFM()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUpload']"));
 		return implement;                              
 	} 
  
  public static WebElement selectCustomer()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']"));
		return implement;                              
	} 

  public static WebElement ABCDPvtLtdEFM()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomerFilter']/option[3]"));
 		return implement;                              
 	} 

  public static WebElement UploadMsgEFM()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl01']/ul/li"));
		return implement;                              
	} 

  public static WebElement SampleFormat()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_up_EFM']/table/tbody/tr/td[5]/u/a"));
		return implement;                              
	} 
  
  public static WebElement HideMulticheckchecklist()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlChecklistHide']"));
 		return implement;                              
 	} 
   
  public static WebElement HideMulticheckchecklistYes()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlChecklistHide']/option[1]"));
		return implement;                              
	} 
 
  public static WebElement HideMulticheckchecklistNo()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_udcInputForm_ddlChecklistHide']/option[2]"));
 		return implement;                              
 	} 
  
  public static WebElement HideMulticheckchecklistEdit()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomer_LinkButton1_0']/img"));
		return implement;                              
	} 

  public static WebElement DownloadExcelFormat()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnExcelFormat']"));
 		return implement;                              
 	} 

  public static WebElement LogReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:93']/li[4]/a"));
		return implement;                           
	} 

  public static WebElement OtherReports()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:88']/li[7]"));
		return implement;                           
	} 

  public static WebElement SelectCustomerAllReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divcustomer']/span/a"));
		return implement;                                     
	}
	
  public static WebElement BitademopuneAllReport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Bitademopune"));
		return implement;                                     
	}
   
  public static WebElement SelectOwner()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divFilterUsers']/span/a"));
 		return implement;                                     
 	}
	
  public static WebElement Eventassignmentexportimport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:113']/li[8]/a"));
		return implement;                                     
	}
  
  public static WebElement SelectCustomerESEI()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_trCustEX']/td/span[2]/a"));
 		return implement;                                     
 	}
  
  public static WebElement SelectCustomerESEI1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tdEUCust']/span/a"));
		return implement;                                
	}
	
  public static WebElement SelectCustomerECSEI1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tdECUCust']/span/a"));
		return implement;                                
	}
	
  public static WebElement SelectCustomerECSI1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_trExComp1']/td/span[2]/a"));
 		return implement;                                
 	}

  public static WebElement MsgCheckbox()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                
	}
	
  public static WebElement Autoreconciliation()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:93']/li[6]/a"));
 		return implement;                                
 	}
	
  public static WebElement ExporttoExcel()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDownload']/img"));
 		return implement;                                
 	}
  
  public static WebElement InvalidMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
		return implement;                                
	}//*[@id="BodyContent_ValidationSummary1"]/ul/li
	
  public static WebElement ReassignmentExcludeReport()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:93']/li[8]/a"));
 		return implement;                                
 	}
//*[@id="CMPMenuBar:submenu:93"]/li[8]/a
  public static WebElement ExporttoExcelRER()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img"));
		return implement;                                
	}
	
  public static WebElement AddNewCt()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddIComplianceType']"));
 		return implement;                                
 	}
 	
  
  public static WebElement SelectPerformer1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[2]/span[1]/a"));
		return implement;                                
	}
	
  public static WebElement Performer2User()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Performer2 User"));
		return implement;                                
	}
  
  public static WebElement SelectReviewer1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[4]/span[1]/a"));
 		return implement;                                
 	}
 	
   public static WebElement ReviewerUser1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("Reviewer User"));
 		return implement;                                
 	}
   
  
   public static WebElement ComplianceCategory1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[4]/td[2]/span/a"));
		return implement;                                
	}
  
   public static WebElement ClientSpecific2()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Client Specific"));
		return implement;                                
	}
  
  
   public static WebElement StartDate1()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
  		return implement;                                
  	}
  
   public static WebElement CheckBox()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceRoleMatrix_chkAssign_0']"));
 		return implement;                                
 	}
 
   public static WebElement SaveCA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return implement;                                
	}
  
   public static WebElement Unsubscribe()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[12]/a"));
		return implement;                                
	}
 
   public static WebElement EnterEmail()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtEmail']"));
 		return implement;                                
 	}
  
   
   public static WebElement ClickUnsubscribe()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUnsubscribe']"));
		return implement;                                
	}
  
  
   public static WebElement GroupingofCompliance()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:26']/li[2]/a"));
		return implement;                              
	}
  
   public static WebElement ClickImport()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Imp']"));
  		return implement;                              
  	}
  
  
   public static WebElement DownloadSampleExcelFormat()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnExcelFormat']"));
 		return implement;                              
 	}
 
   public static WebElement SelectCustomerGC()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/span/a"));
  		return implement;                              
  	}
  
   public static WebElement SelectComplianceType1()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/span/a"));
 		return implement;                              
 	}
  
   public static WebElement FunctionBased ()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Function Based"));
		return implement;                              
	}

   public static WebElement SelectGroupType()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span/a"));
		return implement;                              
	}
  
   public static WebElement CustomerLevel ()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.linkText("Customer Level"));
  		return implement;                              
  	}
   
   public static WebElement LocationLevel ()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.linkText("Location Level"));
 		return implement;                              
 	}
  
   public static WebElement UploadFilegc()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
  		return implement;                              
  	}
  
   public static WebElement ClickUpload()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
 		return implement;                              
 	}
 
   public static WebElement ValMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul"));
		return implement;                          
	}

   public static WebElement ClickExportGC()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Exp']"));
  		return implement;                          
  	}
  
   public static WebElement SelectCust()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/span/a"));
 		return implement;                          
 	}
 
   public static WebElement ClickExportImg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDownload']/img"));
		return implement;                          
	}
  
   public static WebElement ValidationMsg()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul"));
  		return implement;                     //     Data uploaded successfully.
  	}
    
   public static WebElement ABCDPvtLtdGC ()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
		return implement;                              
	}
  
   public static WebElement SampleFormate()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/table/tbody/tr[1]/td[5]/u/a"));
 		return implement;                    
 	}
   
   public static WebElement CheckList()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("CheckList"));
		return implement;                    
	}
   
   public static WebElement Targetdate()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:44']/li[16]"));
  		return implement;                    
  	}
   
   public static WebElement SelectCustomerTD()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='ImplementationProjectPopup']/div[1]/div/span/span/span[3]"));
 		return implement;                    
 	}
   
   public static WebElement PQR()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@class='k-in']"));
		return implement;                    
	}
   
   public static WebElement EditTD()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[2]"));
 		return implement;                    
 	}
    
   public static WebElement TargetDaystext()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[2]/input"));
		return implement;                    
	}
   
   public static WebElement SaveButtons()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='dvsubmit']"));
  		return implement;                    
  	}
     
   public static WebElement EntityAssignments()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser']/tbody/tr[2]/th[10]"));
 		return implement;                    
 	}
     
   public static WebElement ModifyEntity()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEntityAssignment_3']"));
		return implement;                    
	}
   
   public static WebElement LocationEA()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
  		return implement;                    
  	}
   
   public static WebElement ExpandLocation()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
 		return implement;                    
 	}
   
   public static WebElement EAAWSGFJBitaLimited()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn2CheckBox']"));
		return implement;                    
	}
   
   public static WebElement ComplianceCategoryEA()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel3']/div/span[1]/a"));
		return implement;                    
	}
   
   public static WebElement ClientSpecificAE()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Client Specific"));
		return implement;                    
	}
   
   public static WebElement ComplianceCategoryIn()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel5']/div/span[1]/a"));
  		return implement;                    
  	}
     
     public static WebElement aaaaIn()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.linkText("aaaa"));
  		return implement;                    
  	}
     
   
   public static WebElement SaveS()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_BtnentitySave']"));
		return implement;                    
	}
  
   public static WebElement CloseAE()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button5']"));
  		return implement;                    
  	}
   
   public static WebElement valMsg()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl07']/ul/li"));
 		return implement;                    
 	}
   
   public static WebElement DeleteEA()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_RadioButtonList1_1']"));
 		return implement;                    
 	}
   
   public static WebElement AllCheck()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_chkallLocation']"));
		return implement;                    
	}
   
   public static WebElement DeleteButton()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDelete']"));
  		return implement;                    
  	}
   
   public static WebElement InternalCheckBox()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_RadioButtonEntityList_1']"));
 		return implement;                    
 	}
  
   public static WebElement ReleaseNoteDocument()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[13]/a"));
		return implement;                    
	}
 
   public static WebElement AddNewRNDt()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddIComplianceCategory']"));
		return implement;                    
	}
   
   public static WebElement SelectCustomerRND()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtcustomerListNew']"));
  		return implement;                    
  	}
   
   public static WebElement BitademopuneRND()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptCustomerListNew_chkCustomerNew_0']"));
  		return implement;                    
  	}
   
   public static WebElement OkRND()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptCustomerListNew_btnRepeaterNew']"));
 		return implement;                    
 	}
   
   public static WebElement Period()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxDate']"));
		return implement;                    
	}
  
   public static WebElement DescriptionRND()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxDescription']"));
  		return implement;                    
  	}
   
   public static WebElement SelectProduct()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upIComplianceCategory']/div/div[5]/span[1]/a"));
 		return implement;                    
 	}
   
   public static WebElement ComplianceRND()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.linkText("Compliance"));
		return implement;                    
	}
   
   public static WebElement SelectDocument()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Fileupload']"));
		return implement;                    
	} 
   
   public static WebElement SaveRND()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
  		return implement;                    
  	} 
   
   public static WebElement CloseRND()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnCancel']"));
 		return implement;                    
 	} 
     
   public static WebElement FilterRND()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
		return implement;                    
	}  
   
   public static WebElement DiscolRND()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdReleaseDocument_Label_1_0']"));
  		return implement;                    
  	} 
   
   public static WebElement EditRND()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdReleaseDocument_LinkButton1_0']/img"));
 		return implement;                    
 	} 
  
   public static WebElement ClickUpdateRND()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='btnUpdate']"));
		return implement;                    
	} 
   
   public static WebElement DeleteRND()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdReleaseDocument_LinkButton2_0']/img"));
  		return implement;                    
  	} 
     
   public static WebElement BulkExcluding()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:26']/li[4]/a"));
 		return implement;                   
 	} 
   
   public static WebElement UploadActionableProcedure()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:26']/li[5]/a"));
		return implement;                   
	} 
   
   public static WebElement SelectCusto()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/span/a/span[1]"));
 		return implement;                   
 	} 
   
   public static WebElement ABCDvtLtd()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
  		return implement;                    
  	} 
   
   public static WebElement ExportAC()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnDownload']"));
 		return implement;                    
 	} 
    
   public static WebElement Import()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Imp']"));
		return implement;                    
	} 
   
   public static WebElement ExportBE()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_Exp']"));
  		return implement;                    
  	} 
     
   public static WebElement ClickDwonload()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_BtnDownloadAssignment']"));
 		return implement;                    
 	} 
    
   public static WebElement DwonloadvaliMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary2']/ul"));
		return implement;                    
	} 
   
   public static WebElement SelectCustomerBE()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceDetails']/table/tbody/tr[2]/td/div[2]/div[2]/table/tbody/tr[1]/td[2]/span/a/span[1]"));
  		return implement;                    
  	} 
   
   public static WebElement UploadFileBE()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_FileUpload']"));
 		return implement;                    
 	} 
  
   public static WebElement ImportValMsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul"));
		return implement;                    
	} 
   
   public static WebElement UploadBE()		//Method for closing Message Popup
  	{
  		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
  		return implement;                    
  	} 
 
   public static WebElement EventBasedChk()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_chkEvent1']"));
 		return implement;                    
 	} 

   public static WebElement ComplianceDocumentMandatory()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_chkComplianceDocumentMandatory1']"));
		return implement;                    
	} 
   
   public static WebElement SaveText()		//Method for closing Message Popup
 	{
 		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul"));
 		return implement;                    
 	} 
    
   public static WebElement CloseBtn()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnClose']"));
		return implement;                    
	} 
   
   public static WebElement Status()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceInstances_lblApprover21_2']"));
		return implement;                    
	} 
   
   public static WebElement StatusIn()		//Method for closing Message Popup
  	{
  	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_lblApprover211_0']"));
  		return implement;                    
  	} 
  
   public static WebElement StatusInLi()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdInternalComplianceInstances_lblApprover211_43']"));
 		return implement;                    
 	} 
 
   
   public static WebElement License()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceInstances']/tbody/tr/td[8]"));
		return implement;                    
	} 
 
   public static WebElement CheckBoxS()		//Method for closing Message Popup
  	{
  	   implement = getDriver().findElement(By.xpath("//*[@id='grdComplianceTransactions_chkCompliances_0']"));
  		return implement;                    
  	} 
   
   public static WebElement CheckBoxC()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='grdComplianceTransactions_chkCompliancesHeader']"));
 		return implement;                    
 	} 
   
   public static WebElement StatusLicense()		//Method for closing Message Popup
  	{
  	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceInstances_lblApprover21_5']"));
  		return implement;                    
  	} 
   
   public static WebElement DeleteBtn()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='btnDeleteAssignment']"));
 		return implement;                    
 	} 
   
   public static WebElement ChooseFileAP()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_MasterFileUpload']"));
		return implement;                    
	} 
  
   public static WebElement UploadAP()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnUploadFile']"));
 		return implement;                    
 	} 
   
   public static WebElement UploadMsgAP()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li/ol"));
		return implement;                    
	} 
  
   public static WebElement Task()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"));
		return implement;                    
	} 
   
   public static WebElement TaskCA()		//Method for closing Message Popup
  	{
  	   implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[7]/a"));
  		return implement;                    
  	} 
     
   
   public static WebElement TaskDetails()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:152']/li/a"));
		return implement;                    
	} 
   
   public static WebElement TaskDetailsCA()		//Method for closing Message Popup
  	{
  	   implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:100']/li/a"));
  		return implement;                    
  	} 
 
   public static WebElement SelectCustomerR()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']"));
 		return implement;                    
 	} 
   
   public static WebElement SelectCustomerR1()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlCustomer']/option[4]"));
		return implement;                    
	} 
  
   public static WebElement ShowAssingment()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdTask_LinkButton3_0']/img"));
		return implement;                    
	} 
 
   public static WebElement  Reviewer2()		//Method for closing Message Popup
  	{
  	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divRev2']/label[2]"));
  		return implement;                    
  	} 
 
   public static WebElement  CloseR2()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='form1']/div[5]/div[1]/button/span[1]"));
 		return implement;                    
 	} 
   
   public static WebElement  FilterSR()		//Method for closing Message Popup
  	{
  	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilter']"));
  		return implement;                    
  	} 
   
   public static WebElement  ComplianceLocation()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocation']"));
 		return implement;                    
 	} 
   
   public static WebElement  ComplianceLocationEx()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn1']/img"));
		return implement;                    
	} 
   
   public static WebElement  ComplianceLocationCheck()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationn2CheckBox']"));
		return implement;                    
	} 
    
   public static WebElement  ReportingLocation()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxFilterLocationTask']"));
		return implement;                    
	} 
  
  public static WebElement  ReportingLocationEx()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationTaskn0']/img"));
		return implement;                    
	} 
  
  public static WebElement  ReportingLocationCheck()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvFilterLocationTaskt1']"));
		return implement;                    
	} 
  
  public static WebElement  StartDateSR()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxStartDate']"));
 		return implement;                    
 	} 
  
  public static WebElement  StartDateSR10()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.linkText("10"));
		return implement;                    
	} 
    
  public static WebElement  Performer()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel2']/div[4]/span/a/span[1]"));
		return implement;                    
	} 
  
  public static WebElement  Performer1()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.linkText("aaea aaa"));
		return implement;                    
	} 
  
  public static WebElement  Performer1CA()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.linkText("a a"));
		return implement;                    
	} 

  
  public static WebElement  Reviewer()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_UpdatePanel2']/div[5]/span/a/span[1]"));
 		return implement;                    
 	} 
   
   public static WebElement  Reviewer1()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.linkText("abc abd"));
 		return implement;                    
 	} 
   
   public static WebElement  Reviewer1CA()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.linkText("Aashna Jain"));
		return implement;                    
	} 
   
   public static WebElement  Reviewer2sr()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divRev2']/span/a"));
		return implement;                    
	} 
  
  public static WebElement  Reviewer12()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.linkText("ABC Lawyer"));
		return implement;                    
	} 
  
  public static WebElement  Reviewer12CA()		//Method for closing Message Popup
 	{
 	   implement = getDriver().findElement(By.linkText("aayush tripathi"));
 		return implement;                    
 	} 
  
  public static WebElement  SaveSR()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSaveTaskAssignment']"));
		return implement;                    
	} 
  
  public static WebElement  SaveSRMSg()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl08']/ul/li"));
		return implement;            //*[@id="BodyContent_ctl06"]/ul/li[1]        
	} 
  
  public static WebElement  SubTask()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdTask']/tbody/tr[2]/td[6]/a"));
		return implement;                    
	} 
  
  public static WebElement  SubTaskCA()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdTask']/tbody/tr[3]/td[6]/a"));
		return implement;                    
	} 
   
  public static WebElement  STSaveSRMSg()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl06']/ul/li[1]"));
		return implement;                    
	} 
  
  public static WebElement  SeComplianceType()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlTaskType']"));
		return implement;                    
	} 
 
public static WebElement  SeComplianceTypeIn()		//Method for closing Message Popup
	{
	   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ddlTaskType']/option[3]"));
		return implement;                    
	} 

  public static WebElement  subentities()		//Method for closing Message Popup
   {
   implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomer']/tbody/tr[3]/td[10]/a"));
	return implement;                    
   }
  
  public static WebElement  subentities1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdCustomerBranch']/tbody/tr[3]/td[8]/a"));
	return implement;                    
  }
   
  public static WebElement  AddnewSub()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnAddCustomerBranch']"));
	return implement;                    
  }
   
  public static WebElement  NameBranch()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxName']"));
	return implement;                    
  }
  
  public static WebElement  SubEntityTypeD()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[5]/span[1]/a/span[1]"));
	return implement;                    
  }
   
  public static WebElement  SubEntityTypeD1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.linkText("aaa"));
	return implement;                    
  } 
   
  public static WebElement  Brand()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divbrandType']/span/a/span[1]"));
	return implement;                    
  }
   
  public static WebElement  Brand1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.linkText("Corporate Office"));
	return implement;                    
  } 
   
  public static WebElement  IndustryB()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtIndustry']"));
	return implement;                    
  }
  
  public static WebElement  IndustryBCheck()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptIndustry_chkIndustry_0']"));
	return implement;                    
  }
  
  public static WebElement  IndustryBOk()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptIndustry_btnRepeater']"));
	return implement;                    
  }
  
  public static WebElement  AddressLine1B()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxAddressLine1']"));
	return implement;                    
  }
  
  public static WebElement  StateB()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_divState']/span[1]/a/span[1]"));
	return implement;                    
  }
  
  public static WebElement  StateB1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.linkText("Maharashtra"));
	return implement;                    
  }
  
  public static WebElement  CityB()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upCustomerBranches']/div[1]/div[11]/span[1]/a/span[1]"));
	return implement;                    
  }
  
  public static WebElement  CityB1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.linkText("Ahmednagar"));
	return implement;                    
  }
   
  public static WebElement  tbxContactPerson()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxContactPerson']"));
	return implement;                    
  }
  
  public static WebElement  Email()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxEmail']"));
	return implement;                    
  }
   
  public static WebElement  SaveB()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
	return implement;                    
  }
   
  public static WebElement  SelectDepartment()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='form1']/div[3]/table/tbody/tr[3]/td/div/div[2]/span/span/span[2]/span"));
	return implement;                    
  }
  
  public static WebElement  SelectDepartment1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='dropdownlistDepartment_listbox']/li[1]"));
	return implement;                    
  }
  
  public static WebElement  SelectUsers()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='dvWC']/div/div"));
	return implement;                    
  }
  
  public static WebElement  SelectUsers1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@class='k-checkbox-wrapper']"));
	return implement;                    
  }
  
  public static WebElement  ExcludeNotActivated()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:33']/li[7]/a"));
	return implement;                    
  }
  public static WebElement  clickCustomer()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[2]/td[2]/span[1]/a/span[1]"));
	return implement;                    
  }
  public static WebElement  selectCustomer1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='ui-id-6']"));
	return implement;                    
  }
  public static WebElement  selectCheckBox()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceNA_chkAssign_0']"));
	return implement;                    
  }
  public static WebElement  selectCheckBox1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceNA_chkAssign_1']"));
	return implement;                    
  }
  public static WebElement  selectCheckBox2()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdComplianceNA_chkAssign_2']"));
	return implement;                    
  }
  public static WebElement  clickExclude()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
	return implement;                    
  }
  public static WebElement  excludeValidMsg()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary1']/ul/li"));
	return implement;                    
  }
  public static WebElement  clickComplianceType()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_upComplianceTypeList']/center/table/tbody/tr[3]/td[4]/span/a/span[1]"));
	return implement;                    
  }
  public static WebElement  selectComplianceType()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.linkText("Statutory Checklist"));
	return implement;                    
  }
  public static WebElement  selectComplianceType1()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.linkText("Internal"));
	return implement;                    
  }
  public static WebElement  selectComplianceType2()		//Method for closing Message Popup
  {
  implement = getDriver().findElement(By.linkText("Internal Checklist"));
	return implement;                    
  }
  
 public static WebElement eventAssignmentExportImport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:120']/li[8]/a"));
		return implement;                       
	}
 public static WebElement eventReassignment()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:120']/li[10]/a"));
		return implement;                       
	}
 public static WebElement eventAssignmentExport()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//a[@id='BodyContent_lbtnDownloadAssignment']/img"));
		return implement;                       
	}
 public static WebElement eventAssignmentCustomerDD()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='ui-id-1']//li[2]"));
		return implement;                       
	}
 public static WebElement eventAssignmentCustomerDD1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//ul[@id='ui-id-1']//li[90]"));
		return implement;                       
	}
 public static WebElement ERUploadedDocument()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdEventUpData']/tbody/tr[3]/td[3]/div/a"));
		return implement;                       
	}
 public static WebElement eventAssignmentLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//input[@id='BodyContent_tbxFilterLocation']"));
		return implement;                       
	}
 public static WebElement eventAssignmentLocationCheckbox()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//input[@id='BodyContent_tvFilterLocationn0CheckBox']"));
		return implement;                       
	}
 public static WebElement eventAssignmentLocationSelect()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//input[@id='BodyContent_btnlocation']"));
		return implement;                       
	}


 public static WebElement eventAssignmentUpload()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//input[@id='BodyContent_btnEUploadFile']"));
		return implement;                       
	}
 public static WebElement EventReassignmentValidationmsg()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_ValidationSummary2']//li"));
		return implement;                       
	}


 public static WebElement eventAssignmentChooseFile()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//input[@id='BodyContent_EMasterFileUpload']"));
		return implement;                       
	}

 public static WebElement clickEvent()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbEvent']"));
		return implement;                       
	}
 public static WebElement clickCustomer1()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_trCustEX']/td/span[2]/a/span[1]"));
		return implement;                       
	}
 public static WebElement selectCustomer2()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='ui-id-3']"));
		return implement;                       
	}
 public static WebElement clickEntity()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_txtEntity']"));
		return implement;                       
	}
 public static WebElement selectEntity()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptEntity_chkEntity_1']"));
		return implement;                       
	}
 public static WebElement clickOk()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_rptEntity_btnRepeater']"));
		return implement;                       
	}
  
 public static WebElement clickLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return implement;                       
	}
 public static WebElement selectLocation()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0CheckBox']"));
		return implement;                       
	}
 public static WebElement clickSelect()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_btnselect']"));
		return implement;                       
	}
 public static WebElement clickDownload()		//Method for closing Message Popup
	{
		implement = getDriver().findElement(By.xpath("//*[@id='BodyContent_BtnDownloadEvent']"));
		return implement;                       
	}
  
  
  
  
  
  
  
   
}
