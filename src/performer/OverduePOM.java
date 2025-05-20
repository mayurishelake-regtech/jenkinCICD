package performer;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import login.BasePage;

public class OverduePOM extends BasePage
{
	private static WebElement msg = null;				//WebElement variable created for popup message button
	private static WebElement overdue = null;			//WebElement variable created for Statutory Overdue click
	private static WebElement statutoryAction = null;	//WebElement variable created for clicking on Action Image
	private static WebElement review = null;			//WebElement variable created for clicking on Action Image
	private static WebElement dropdown = null;			//WebElement variable created for Compliance Status dropdown box
	private static WebElement upload = null;			//WebElement variable created for uploading file
	private static WebElement date = null;				//WebElement variable created for selecting date
	private static WebElement value = null;				//WebElement variable created for inserting value in textbox
	private static WebElement selectDate = null;		//WebElement variable created for selecting date from second row and fifth column
	private static WebElement dashboard = null;			//WebElement variable created for clicking on dashboard
	private static WebElement submit = null;			//WebElement variable created for Submit button click
	private static WebElement lastMonth = null;			//WebElement variable created for clicking on arrow on calendar which shows last month
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting action button from multiple action buttons
	private static WebElement msgElement = null;			//WebElement variable created for checking Message after action button click in Internal Overdue
	private static WebElement close = null;					//WebElement variable created for closing window of internal compliance if disabled submit button 
	private static WebElement nextPage = null;				//WebElement variable created for clicking on next page arrow (if compliance without message notfound)
	private static WebElement statutoryChecklist = null;	//WebElement variable created for uploading file
	private static List<WebElement> checkboxesList = null;	//WebElement list created for selecting action button from multiple action buttons
	private static WebElement checklistSubmit = null;		//WebElement variable created for clicking on Submit button.
	private static WebElement checklistNotApplicable = null;	//WebElement variable created for clicking on Not Applicable button through Check boxes.
	private static WebElement actionNotApplicable = null;	//WebElement variable created for clicking on Not Applicable button through action button.
	private static WebElement internalChecklist = null;		//WebElement variable created for uploading file
	private static WebElement activatedEvents = null;	//WebElement list created for selecting date text box from multiple date text boxes
	private static WebElement assignedEvents = null;	//WebElement variable created for clicking on Assigned Events value.
	private static List<WebElement> checkboxes = null;	//WebElement list created for selecting action button from multiple action buttons
	private static List<WebElement> textboxes = null;	//WebElement list created for selecting text box from multiple text boxes
	private static List<WebElement> dates = null;		//WebElement list created for selecting date text box from multiple date text boxes
	private static List<WebElement> viewEvent = null;	//WebElement list created for clicking on View Event from multiple View Events
	private static WebElement closeView = null;			//WebElement variable created to close opened View Event
	private static List<WebElement> activate = null;	//WebElement list created for clicking 'Activate Button' image from multiple buttons
	private static WebElement save = null;				//WebElement variable created to click on save button.
	private static WebElement performer = null;			//WebElement variable created to click on Performer dropdown.
	private static WebElement reviewer = null;			//WebElement variable created to click on Reviewer dropdown.
	private static WebElement approver = null;			//WebElement variable created to click on Approver dropdown.
	private static WebElement checkbox = null;			//WebElement variable created to click on checkbox to select all checkboxes.
	
	public static WebElement closeMessage( )					//Method for closing Message Popup
	{
		msg = getDriver().findElement(By.xpath("//*[@id='divNotification']/div/div/div[1]/button"));
		return msg;
	}
	
	public static WebElement clickStatutoryOverdue( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOverduePEOcount']"));
		return overdue;
	}
	
	public static WebElement ComplianceType( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='example']/div/div[1]/div[3]/div/div/span[1]"));
		return overdue;
	}
	
	public static WebElement ComplianceType1( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='dvdropdownlistComplianceType1']/div/div/span[1]"));
		return overdue;
	}
	
	public static WebElement TaskType( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTaskTypeCreation']"));
		return overdue;
	}
	
	public static WebElement TaskType1( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlTaskTypeCreation']/option[3]"));
		return overdue;
	}
	
	public static WebElement SelectAll( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("/html/body/div[22]/div/div[1]/span"));
		return overdue;
	}
	
	public static WebElement SelectInternal1( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[33]"));
		return overdue;
	}
	
	public static WebElement StatutoryCheckList( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[4]"));
		return overdue;
	}
	
	public static WebElement Statutory( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[1]"));
		return overdue;
	}
	
	public static WebElement Status( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='example']/div/div[1]/div[4]/div/div/span[1]"));
		return overdue;                            
	}
	
	public static WebElement StatusOverdue( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[2]/span/span[2]"));
		return overdue;                            
	}
	
	public static WebElement ClosedDelayed( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[17]"));
		return overdue;
	}
	
	public static WebElement ClosedTimely( )		//Method for clicking on Statutory Overdue value
	{
		overdue = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[18]"));
		return overdue;
	}
	
	public static WebElement readPendingReviewStatutory( )	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerPendingforReviewPEOcount']"));
		return review;
	}
	
	public static WebElement text( )	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//*[@id='lbltask']"));
		return review;
	}
	
	public static WebElement text1( )	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//*[@id='lbltaskinternal']"));
		return review;
	}
	
	public static WebElement close( )	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer']/div/div/div[1]/button"));
		return review;
	}
	
	public static WebElement close1( )	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalPerformaer']/div/div/div[1]/button"));
		return review;
	}
	
	public static WebElement clickStatutoryAction( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[2]/td[17]/a"));
		return statutoryAction;
	}
	
	public static WebElement clickMitigationPlan( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[26]/a[3]"));
		return statutoryAction;
	}
	
	public static WebElement clickMitigationPlanCheck( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[23]/a[3]"));
		return statutoryAction;
	}
	
	public static WebElement Reason( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='txt_Reason']"));
		return statutoryAction;
	}
	
	public static WebElement Legal( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='txt_Legal']"));
		return statutoryAction;
	}
	
	public static WebElement RemediationSteps( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='txt_Remediation']"));
		return statutoryAction;
	}
	
	public static WebElement Timeline( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='txtTimelineClosure']"));
		return statutoryAction;
	}
	
	public static WebElement Date28( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.linkText("25"));
		return statutoryAction;
	}
	
	public static WebElement submit( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='btn_Remark']"));
		return statutoryAction;
	}
	
	public static WebElement UploadFiles( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='fuSampleFile']"));
		return statutoryAction;
	}
	
	public static WebElement DeleteDoc( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grdDocument_lnkDeleteDocument_0']/img"));
		return statutoryAction;
	}
	
	public static WebElement CloseMpPopUp( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='divMitigationCompliance']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement Dwounload( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grdDocument_lnkDownloadDocument_0']/img"));
		return statutoryAction;
	}
	
	public static WebElement View( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grdDocument_lnkViewDocument_0']/img"));
		return statutoryAction;
	}
	
	public static WebElement ViewClose( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='DocumentPriview']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement txtSearchComplianceID( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='txtSearchComplianceID']"));
		return statutoryAction;
	}
	
	public static WebElement MsgText( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']/ul/li"));
		return statutoryAction;
	}
	
	public static WebElement MsgText1( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='InternalVD']/ul/li"));
		return statutoryAction;
	}
	
	public static WebElement CloseEdit( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement CloseEditIn( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalPerformaer']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement NotComplied( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='dvbtnNotCompliedSubmit']"));
		return statutoryAction;
	}
	
	public static WebElement ReadCount( )			//Method to click on Third row action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return statutoryAction;
	}
	
	public static List<WebElement> clickStatutoryActionButton( )
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static List<WebElement> clickStatutoryActionButton1( )
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overviewMain k-grid-edit2']"));
		return elementsList;
	}
	
	public static List<WebElement> ActionButtons( )
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static List<WebElement> ActionButtons1( )
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overviewMain k-grid-edit2']"));
		return elementsList;
	}
	
	public static WebElement CalendarIcon( )		//Method to search dropdown box
	{
		dropdown = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnexcel']/img"));
		return dropdown;
	}
	
	
	public static WebElement selectStatutoryDropdown( )		//Method to search dropdown box
	{
		dropdown = getDriver().findElement(By.xpath("//select[@id='ddlStatus']"));
		return dropdown;
	}
	
	public static WebElement selectStatutoryDropdown1( )		//Method to search dropdown box
	{
		dropdown = getDriver().findElement(By.xpath("//*[@id='ddlStatus2']"));
		return dropdown;
	}
	//*[@id="ddlStatus"]
	public static WebElement complianceDocLink( )
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='TxtworkingdocumentlnkStatutory']"));
		return dropdown;
	}
	
	public static WebElement buttonAddLink( )
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='UploadlinkWorkingfileStatutory']"));
		return dropdown;
	}
	
	public static WebElement fileUploadStatutory( )			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//*[@id='fuSampleFile']"));
		return upload;
	}
	public static WebElement clickDateChecklist( )			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//*[@id='tbxNewDate']"));
		return upload;
	}
	public static WebElement selectDateChecklist( )			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[6]/a"));
		return upload;
	}
	public static WebElement fileUploadUpStatutory( )			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//*[@id='fuTaskDoc']"));
		return upload;
	}
	
	public static WebElement fileUploadStatutory1( )			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//input[@id='FileUpload1']"));
		return upload;
	}
	
	public static WebElement fileUploadStatutory2( )			//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//*[@id='fuSampleFile2']"));
		return upload;
	}
	
	public static WebElement selectDateStatutory( )			//Method to search Date Box
	{
		date = getDriver().findElement(By.xpath("//*[@id='tbxDate']"));
		return date;
	}
	public static WebElement selectDateStatutoryChecklist( )			//Method to search Date Box
	{
		date = getDriver().findElement(By.xpath("//*[@id='tbxNewDate']"));
		return date;
	}
	public static WebElement selectDateStatutory11( )			//Method to search Date Box
	{
		date = getDriver().findElement(By.linkText("3"));
	//	date = getDriver().findElement(By.xpath("//*[@class='ui-state-default ui-state-highlight ui-state-active']"));
		//*[@class="ui-state-default ui-state-highlight ui-state-active"]
		return date;
	}
	
	
	public static WebElement selectDateStatutory1( )			//Method to search Date Box
	{
		date = getDriver().findElement(By.xpath("//*[@id='tbxDate2']"));
		return date;
	}
	
	public static WebElement valueSystem( )					//Method to search text box
	{
		value = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerSystem']"));
		return value;
	}
	
	public static WebElement valueReturn( )					//Method to search text box
	{
		value = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerReturn']"));
		return value;
	}
	
	public static WebElement remark( )						//Method created to search text area 
	{
		value = getDriver().findElement(By.xpath("//textarea[@id='tbxRemarks']"));
		return value;//*[@id="tbxRemarks"]//*[@id="tbxRemarks"]
	}
	
	public static WebElement remark1( )						//Method created to search text area 
	{
		value = getDriver().findElement(By.xpath("//*[@id='tbxRemarks2']"));
		return value;
	}
	
	public static WebElement remark2( )						//Method created to search text area 
	{
		value = getDriver().findElement(By.xpath("//*[@id='tbxRemarks3']"));
		return value;
	}
	
	
	public static WebElement ClickRadioBtn( )						//Method created to search text area 
	{
		value = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus3_1']"));
		return value;
	}
	
	public static WebElement clickComplianceSubmit3( )		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//*[@id='btnClosedDelayed']"));
		//*[@id='btnSave']
		
		return submit;
	}
	public static WebElement clickComplianceSubmit( )		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
		
		return submit;
	}
	
	public static WebElement clickComplianceSubmitAS( )		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//*[@id='btnSaveDOCNotCompulsory']"));
		return submit;
	}
	
	public static WebElement clickComplianceSubmit2( )		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//*[@id='btnSave2']"));
		return submit;
	}
	
	public static WebElement clickComplianceSubmit1( )		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
		return submit;
	}
	
	public static WebElement clickClosedDelayed( )		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//*[@id='btnClosedDelayed']"));
		return submit;
	}
	
	public static WebElement btnDeviationApplied( )		//Method for searching button for Submit Form
	{
		submit = getDriver().findElement(By.xpath("//*[@id='btnDeviationApplied']"));
		return submit;
	}
	
	public static WebElement clickDashboard( )				//Method to search Dashboard Link
	{
		dashboard = getDriver().findElement(By.xpath("//*[@id='leftdashboardmenu']"));
		//dashboard = getDriver().findElement(By.xpath("//*[@id='leftdashboardmenu']/a/span[1]"));
		return dashboard;
	}
	
	public static WebElement clickAdvancedSearch( )
	{
	//	dashboard = getDriver().findElement(By.xpath("//button[@id='AdavanceSearch']"));
		dashboard = getDriver().findElement(By.xpath("//*[@id='AdavanceSearch']"));
		return dashboard;
	}
	
	public static WebElement clickClose( )
	{
	
		dashboard = getDriver().findElement(By.xpath("//*[@id='btnCancel']"));
		return dashboard;
	}
	
	public static WebElement clickClose2( )
	{
	
		dashboard = getDriver().findElement(By.xpath("//*[@id='btnCancel2']"));
		return dashboard;
	}
	
	public static WebElement clickClose1( )
	{
	
		dashboard = getDriver().findElement(By.xpath("/html/body/div[38]/div[1]/div/a"));
		return dashboard;
	}
	
	public static WebElement chooseFile( )
	{
	
		dashboard = getDriver().findElement(By.xpath("//*[@id='fuSampleFile']"));
		return dashboard;
	}
	
	public static WebElement clickInternalOverdue( )			//Method for clicking on Internal Overdue value
	{
		overdue = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOverdueInternalPEOcount']"));
		return overdue;
	}
	
	public static WebElement readPendingReviewInternal( )	//Method to read Statutory Pending Review
	{
		review = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerPendingforRevieweInternalPEOcount']"));
		return review;
	}
	
	public static List<WebElement> clickActionButtonList( ) 	//Method to get list of action buttons on web page
	{
		//elementsList = getDriver().findElements(By.xpath("//*[@role='button'][@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
	//	elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[24]/a[1]"));
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[26]/a"));
		
		return elementsList;
	}
	
	public static List<WebElement> clickActionButtonList1( ) 	//Method to get list of action buttons on web page
	{
		//elementsList = getDriver().findElements(By.xpath("//*[@role='button'][@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[23]/a[1]"));
		//elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[24]/a[1]"));
		
		return elementsList;
	}
	
	public static WebElement msgCheck( )						//Method to check message -"Compliance related task is not yet completed."
	{
		msgElement = getDriver().findElement(By.xpath("//span[@id='lbltaskinternal']"));
		return msgElement;
	}
	
	public static WebElement closeCompliance( )				//Method to close compliance popup.
	{
		close = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalPerformaer']/div/div/div[1]/button"));
		return close;
	}
	
	public static WebElement selectInternalDropdown( )		//Method to search Dropdown.
	{
		dropdown = getDriver().findElement(By.xpath("//select[@id='ddlStatus2']"));
		return dropdown;
	}
	
	public static WebElement selectDropdown( )		//Method to search Dropdown.
	{
		dropdown = getDriver().findElement(By.xpath("//*[@id='ddlStatus']"));
		return dropdown;
	}
	
	public static WebElement ClosePopup( )		//Method to search Dropdown.
	{
		dropdown = getDriver().findElement(By.xpath("//*[@id='divreports']/div/div/div[1]/button"));
		return dropdown;
	}
	
	public static WebElement ClosePopup1( )		//Method to search Dropdown.
	{
		dropdown = getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer']/div/div/div[1]/button"));
		return dropdown;
	}
	
	
	public static WebElement selectDropdownDA( )		//Method to search Dropdown.
	{
		dropdown = getDriver().findElement(By.xpath("//*[@id='ddlStatus']/option[4]"));
		return dropdown;
	}
	
	public static WebElement complianceDocLinkInternal( )
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='TxtCompliancedocumentlnk']"));
		return dropdown;
	}
	
	public static WebElement buttonAddLinkInternal( )
	{
		dropdown = getDriver().findElement(By.xpath("//input[@name='UploadlinkCompliancefile']"));
		return dropdown;
	}
	
	public static WebElement fileUploadInternal( )			//Method to search Choose File button.
	{
		upload = getDriver().findElement(By.xpath("//*[@id='fuSampleFile2']"));
		return upload;
	}
	
	public static WebElement selectDateInternal( )			//Method to search Date box
	{
		date = getDriver().findElement(By.xpath("//input[@id='tbxDate2']"));
		return date;
	}
	
	public static WebElement selectDate( )					//Method to click on date at second row and fourth column
	{
		selectDate = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[2]/a"));
		return selectDate;
	}
	public static WebElement selectDate4( )					//Method to click on date at second row and fourth column
	{
		selectDate = getDriver().findElement(By.linkText("3"));
		return selectDate;
	}
	public static WebElement selectDate2( )					//Method to click on date at second row and fifth column
	{
		selectDate = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[3]/a"));
		return selectDate;
	}
	
	public static WebElement selectDate3( )					//Method to click on date at second row and fifth column
	{
		selectDate = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a"));
		return selectDate;
	}
	
	public static WebElement selectLastMonth( )				//Method to click on arrow which shows last month
	{
		lastMonth = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span"));
		return lastMonth;
	}
	
	public static WebElement loadNextPage( )					//Method to search the forward arrow to load next page records 
	{
		nextPage = getDriver().findElement(By.xpath("//div[@id='grid']/div[5]/a[3]/span"));
		return nextPage;
	}
	
	public static WebElement CalendarCount( )					//Method to search the forward arrow to load next page records 
	{
		nextPage = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return nextPage;
	}
	
	public static WebElement CalendarCount1( )					//Method to search the forward arrow to load next page records 
	{
		nextPage = getDriver().findElement(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[1]/div/div[3]/div[6]/a"));
		return nextPage;
	}
	
	public static WebElement clickStatutoryChecklist( )		//Method to click on Statutory Checklist value
	{
		statutoryChecklist = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerChecklistPEOcount']"));
		return statutoryChecklist;
	}
	
	public static List<WebElement> readCalendarCompType( )			//Method to check type compliance displayed
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[3]"));
		return elementsList;
	}
	
	public static List<WebElement> readCalendarCompType1( )			//Method to check type compliance displayed
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
		return elementsList;
	}
	
	public static List<WebElement> clickCheckboxesList( ) 	//Method to get list of action buttons on web page
	{
	//	checkboxesList = getDriver().findElements(By.xpath("//input[@id='sel_chkbx']"));
		//*[@id='sel_chkbx']
		checkboxesList = getDriver().findElements(By.xpath("//*[@id='sel_chkbx']"));
		return checkboxesList;
	}
	
	public static WebElement clickSubmit( )					//Method to search Submit button.
	{
		checklistSubmit = getDriver().findElement(By.xpath("//*[@id='dvbtnSubmit']"));
		return checklistSubmit;
	}
	
	public static WebElement ClickClosedDelayed( )					//Method to search Submit button.
	{
		checklistSubmit = getDriver().findElement(By.xpath("//*[@id='dvbtnClosedDelayed']"));
		return checklistSubmit;
	}
	
	public static WebElement clickCheckboxesNotApplicable( )	//Method to click on 'Not Applicable' button after clicking multiple check boxes. (Independent of Statutory or Internal)
	{
		checklistNotApplicable = getDriver().findElement(By.xpath("//button[@id='dvbtnNotApplicableSubmit']"));
		return checklistNotApplicable;
	}
	
	public static List<WebElement> clickStatutoryChecklistAction( )	//Method to click on Action button. (Independent of Statutory or Internal)
	{
		elementsList = getDriver().findElements(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit3']"));
		//elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[23]/a"));
		return elementsList;
	}
	
	public static WebElement clickStatutoryChecklistActionDA( )	//Method to click on Action button. (Independent of Statutory or Internal)
	{
		//elementsList = getDriver().findElements(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit3']"));
		checklistSubmit = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[23]/a[1]"));
		return checklistSubmit;
	}
	
	public static List<WebElement> clickStatutoryChecklistAction1( )	//Method to click on Action button. (Independent of Statutory or Internal)
	{
		//elementsList = getDriver().findElements(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit3']"));
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[21]/a[1]"));
		return elementsList;
	}
	
	public static WebElement clickActionNotApplicable( )	//Method to click on 'Not Applicable' button through action button.
	{
		actionNotApplicable = getDriver().findElement(By.xpath("//input[@value='Not Applicable']"));
		return actionNotApplicable;
	}
	
	public static WebElement statutoryComplianceDoc( )
	{
		checkbox = getDriver().findElement(By.xpath("//input[@name = 'TxtChecklistDocument']"));
		return checkbox;
	}
	
	public static WebElement statutoryAddLinkButton( )
	{
		checkbox = getDriver().findElement(By.xpath("//input[@name = 'Uploadlingchecklistfile']"));
		return checkbox;
	}
	
	public static WebElement clickInternalChecklist( )	//Method to click on Internal Checklist value
	{
		internalChecklist = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerChecklistInternalPEOcount']"));
		return internalChecklist;
	}
	//div[@class = 'k-multiselect-wrap k-floatwrap']
	public static WebElement readActivatedEvents( )		//Method to click on Internal Checklist value
	{
		activatedEvents = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActivatedEventPEOcount']"));
		return activatedEvents;                        //*[@id="ContentPlaceHolder1_divActivatedEventPEOcount"]
	}
	
	public static WebElement readActivatedEventsOw( )		//Method to click on Internal Checklist value
	{
		activatedEvents = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActivatedEventPREOcount']"));
		return activatedEvents;                       
	}
	
	public static WebElement clickAssignedEvents( )		//Method to click on Internal Checklist value
	{
		assignedEvents = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divAssignedEventPEOcount']"));
		return assignedEvents;                        //*[@id="ContentPlaceHolder1_divAssignedEventPEOcount"]
	}
	
	public static WebElement clickAssignedEventsOw( )		//Method to click on Internal Checklist value
	{
		assignedEvents = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divAssignedEventPREOcount']"));
		return assignedEvents;                        //*[@id="ContentPlaceHolder1_divAssignedEventPEOcount"]
	}
	
	public static WebElement readTotalItemsD( )		//Method to click on Internal Checklist value
	{
		assignedEvents = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return assignedEvents;                        //*[@id="ContentPlaceHolder1_divAssignedEventPEOcount"]
	}                                                
	
	public static List<WebElement> clickCheckBoxes( )	//Method to search multiple check boxes for CheckList count
	{
		checkboxes = getDriver().findElements(By.xpath("//label[@class='k-checkbox-label k-no-text']"));
		return checkboxes;
	}
	
	public static List<WebElement> clickTextBoxes( )		//Method to search multiple text boxes for CheckList count
	{
		textboxes = getDriver().findElements(By.xpath("//input[@type='text'][@class='k-textbox']"));
		return textboxes;//*[@id="grid"]/div[3]/table/tbody/tr[1]/td[5]/input
	}
	
	public static List<WebElement> clickDates( )			//Method to search multiple date textboxes
	{//tbody/tr[1]/td[5]/input[1]
		//dates = getDriver().findElements(By.xpath("//input[@type='date'][@class='k-textbox']"));
		dates = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/input"));
		//dates = getDriver().findElements(By.xpath("//tbody/tr[1]/td[5]/input[1]"));
		return dates;
	}
	
	public static List<WebElement> viewEvent( )			//Method to search multuple 'View' button image
	{
		viewEvent = getDriver().findElements(By.xpath("//a[@class = 'k-button k-button-icontext ob-overview k-grid-edit1']"));
		return viewEvent;
	}//label[@class='k-checkbox-label k-no-text']//*[@id="grid"]/div[3]/table/tbody/tr[1]/td[6]/a[2]
	
	public static WebElement closeViewEvent( )			//Method to search 'Back' button of opened view.
	{
		closeView = getDriver().findElement(By.xpath("//a[@class='k-button k-bare k-button-icon k-window-action']"));
		return closeView;                       
	}
	
	public static List<WebElement> clickActivate( )		//Method to search multiple Activate buttons.
	{
		activate = getDriver().findElements(By.xpath("//a[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return activate;
	}
	
	public static WebElement clickSave( )				//Method to search Save button.
	{
		save = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_btnAllSavechk']"));
		return save;
	}
	
	public static WebElement clickAssigneCompliance( )	//Method to search 'Assign Compliance' button
	{
		msgElement = getDriver().findElement(By.xpath("//input[@value='Assign Compliance']"));
		return msgElement;
	}
	
	public static WebElement selectPerformer( )			//Method to search dropdown to select performer user
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlFilterPerformer']"));
		return performer;
	}
	
	public static WebElement selectReviewer( )			//Method to search dropdown to select reviewer user
	{
		reviewer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlFilterReviewer']"));
		return reviewer;
	}
	
	public static WebElement selectApprover( )			//Method to search dropdown to select approver user
	{
		approver = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlFilterApprover']"));
		return approver;
	}
	
	public static WebElement selectDate1( )				//Method to search date text box.
	{
		date = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_tbxStartDate']"));
		return date;
	}
	
	public static WebElement selectEvent( )				//Method to search dropdown to select Event
	{
		date = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ucEventDashboards_ddlEvent']"));
		return date;
	}
	
	public static WebElement clickSave1( )				//Method to search Save button.
	{
		save = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_SaveComplianceList']"));
		return save;
	}
	
	public static WebElement clickCheckbox( )			//Method to search checkbox of Select all.
	{
		checkbox = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_ucEventDashboards_gvComplianceListAssign_chkComplianceCheck']"));
		return checkbox;
	}
	
	public static WebElement clickMyWorkspace( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenuLic']"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement ClickDropD( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[1]/span/span/span[2]/span"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement ClickDropDAd( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[1]/span/span/span[2]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	
	public static WebElement SelectPerformer( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement Selectreviwer()			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[2]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	
	public static WebElement SelectPerformerAd( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole1_listbox']/li[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickApply( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement ComplianceTypeIn( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div/span[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement StatutoryCT( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement InternalCT( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[2]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement EventBasedCT( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[3]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement StatutoryCheckListCT( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[4]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement StatutoryLicenseCT( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[5]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement InternalLicenseCT( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[6]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickApplyAd( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Applybtn1']"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickRiskD( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='example']/div/div[2]/div[1]/div"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickRiskd( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[5]/div"));	//*[@onclick='CheckProduct();']
		return performer;
	}

	
	
	public static WebElement clickRiskShowAll( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div/span[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickRiskSAhigh( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[2]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickRiskDE( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/div[1]/div/div[3]/div/span[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement SelectStatus( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dvdropdownUser']/div/div"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement SelectstatusCD( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[18]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickHighDE( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[6]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickRiskDA( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[4]/div"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	
	public static WebElement clickHigh( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//span[@class='k-in k-state-selected']"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickclearBtn( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickclear( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//button[@id='Clearfilter']"));	//*[@onclick='CheckProduct();']
		return performer;
	}

	
	
	public static WebElement clickclearBtnA( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Clearfilter']"));	//*[@onclick='CheckProduct();']
		return performer;
	}

	public static WebElement clickcomplianceType( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[3]/div/div/span[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceTypeAS( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/div[1]/div/span[1]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	
	public static WebElement clickcomplianceSta( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-in'])[20]"));	//*[@onclick='CheckProduct();']
		return performer;
	}

	public static WebElement clickcomplianceStaAS( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[54]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceIn( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[21]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceStaASM( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[70]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceStaASD( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[77]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceStaASDIN( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[70]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceStaASA( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[89]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	
	public static WebElement clickcomplianceStaASApp( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[41]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceStaASR( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[114]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceIN( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-in'])[21]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceINAS( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[55]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceINASM( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[71]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceINASMA( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[90]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceINASApp( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-wrapper'])[42]"));	//*[@onclick='CheckProduct();']
		return performer;
	}
	
	public static WebElement clickcomplianceINASR( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[115]"));	//*[@onclick='CheckProduct();']
		return performer;
	}

	
	
	public static WebElement clickMyWorkspace1( )			//Searching 'My Workspace' element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenuLic']/a/span[1]"));
	//	performer = getDriver().findElement(By.xpath("//*[@onclick='CheckProduct()']"));	//*[@onclick='CheckProduct();']
		return performer;
	}//*[@id="leftworkspacemenuLic"]/a/span[1]
	
	public static WebElement clickCompliance( )			//Searching Compliance element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='LiComplist']"));
		return performer;
	}
	
	public static WebElement MyTasks( )			//Searching Compliance element.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='liMyTask']/a"));
		return performer;
	}
	
	public static WebElement clickUserDropDown( )		//Searching dropdown to select User
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[1]"));
		return performer;
	}
	
	public static WebElement clickPerformer( )			//Selecting performer in User Dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[1]"));
		return performer;
	}
	
	public static WebElement clickReviewer( )			//Selecting performer in User Dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[2]"));
		return performer;
	}
	
	public static WebElement selectType( )			//Searching Overdue type dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[2]"));
		return performer;
	}
	//*[@class='k-list k-reset'])[1]/li[1]
	public static WebElement clickStatutory( )			//Searching 'Statutory' sub menu of dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-list k-reset'])[1]/li[1]"));
		return performer;
	}
	
	public static WebElement clickInternal( )			//Searching 'Statutory' sub menu of dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-list k-reset'])[1]/li[2]"));
		return performer;
	}//*[@class='k-list k-reset'])[1]/li[2]
	
	public static WebElement selectStatus( )				//Searching Status dropdown
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[3]"));
		return performer;
	}
	
	public static WebElement ClickMoreActions( )				//Searching Status dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[2]"));
		return performer;
	}
	
	public static WebElement ClickUpdatePenalty( )				//Searching Status dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistMoreLink_listbox']/li[2]"));
		return performer;
	}
	
	public static WebElement ReadCountNC( )				//Searching Status dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grid']/div[5]/span[2]"));
		return performer;
	}
	
	public static List<WebElement> clickActionBtn( )		//Searching action button on form near to calendar
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_grdRviseCompliances']/tbody/tr/td[8]/a[2]/img"));
		return elementsList;                        
	}
	
	
	public static WebElement clickOverdue( )				//Searching 'Overdue' sub menu status of dropdown
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[3]"));
	//	performer = getDriver().findElement(By.xpath("//*[@id='be186438-b9fc-43cb-99d5-938839dd18b1']"));				//(//*[@class='k-list-scroller'])[2]/ul/li[3]
		return performer;
	}//*[@id="example"]/div[1]/span[2]/span
	//li[@id='81b76d1a-9a00-42cb-972c-42433cb3382d']
	public static WebElement clickUser( )				//Searching User dropdown.
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-dropdown-wrap k-state-default k-state-hover']"));
		return performer;
	}
	
	public static WebElement clickMonthDropDown( )		//Searching Month dropdown
	{
		performer = getDriver().findElement(By.xpath("(//span[@class='k-dropdown-wrap k-state-default'])[3]"));
		return performer;
	}

	public static List<WebElement> clickCalenderAction( )		//Searching action button on form near to calendar
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;                        
	}//*[@role='button'][@class='k-button k-button-icontext ob-overview k-grid-edit2']]
	
	public static List<WebElement> clickCalenderAction1( )		//Searching action button on form near to calendar
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overviewMain k-grid-edit2']"));
		return elementsList;                        
	}
	
	
	public static WebElement clickMyReminder( )			//Searching 'My Reminder' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftremindersmenu']"));
		return performer;
	}
	
	public static WebElement CalenderGrid( )				//Searching 'Add New' button to add reminder
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]"));
		return performer;
	}
	
	public static WebElement clickAddNew( )				//Searching 'Add New' button to add reminder
	{
		performer = getDriver().findElement(By.xpath("//*[@value='Add New']"));
		return performer;
	}
	
	public static WebElement clickAddNewReminder( )		//Searching 'Add New' button to add reminder
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'Addnew']"));
		return performer;
	}
	
	public static WebElement selectComplianceType( )		//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlComType']"));
		return performer;
	}
	
	public static WebElement selectComplianceType1( )	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//div[@id='ddlComType_chosen']"));
		return performer;
	}
	
	public static WebElement rejectStauDelete( )	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grdDocument_lnkDeleteDocument_0']/img"));
		return performer;
	}
	
	public static WebElement rejectInDelete( )	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grdInternalDocument_lnkDeleteInternalDocument_0']/img"));
		return performer;
	}
	
	public static WebElement CloseRS( )	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer']/div/div/div[1]/button"));
		return performer;//*[@id="ComplaincePerformer1"]/div/div/div[1]/button
	}
	
	public static WebElement CloseRADS( )	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer1']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement CloseRIn( )	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalPerformaer']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement CloseRADIn( )	//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalPerformaer1']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement selectInternalType( )		//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ddlComType_chosen']/div/ul/li[2]"));
		return performer;
	}
	
	public static WebElement selectLocation( )			//Searching 'Location' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlBranch']"));
		return performer;
	}
	
	public static WebElement clickLocation( )			//Searching 'Location' drop down
	{
		performer = getDriver().findElement(By.xpath("//div[@id='ddlBranch_chosen']"));
		return performer;
	}
	
	public static List<WebElement> selectLocation1( )
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='ddlBranch_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement selectCompliance( )			//Searching 'Compliance' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlCompliance']"));
		return performer;
	}
	
	public static WebElement clickCompliance1( )			//Searching 'Compliance' drop down
	{
		performer = getDriver().findElement(By.xpath("//div[@id = 'ddlCompliance_chosen']"));
		return performer;
	}
	
	public static List<WebElement> selectCompliance1( )			//Searching 'Compliance' drop down
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id = 'ddlCompliance_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement selectRole( )				//Searching 'Role' drop down
	{
		performer = getDriver().findElement(By.xpath("//select[@id='ContentPlaceHolder1_ddlRole']"));
		return performer;
	}
	
	public static WebElement ClickTaskReport( )				//Searching 'Role' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Myreporttask']"));
		return performer;
	}
	
	public static WebElement ClickEventReport( )				//Searching 'Role' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Eventreportnew']"));
		return performer;
	}
	
	public static WebElement clickRole( )
	{
		performer = getDriver().findElement(By.xpath("//div[@id = 'ddlRole_chosen']"));
		return performer;
	}
	
	public static List<WebElement> selectRole1( )
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id = 'ddlRole_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickDate( )				//Searching 'Date' input box
	{
		performer = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_tbxDate']"));
		return performer;
	}
	
	public static WebElement clickSaveButton( )			//Searching 'Compliance Type' drop down
	{
		performer = getDriver().findElement(By.xpath("//input[@value='Save']"));
		return performer;
	}
		
	public static WebElement selectNextMonth( )			//Method to click on arrow which shows last month
	{
		lastMonth = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span"));
		return lastMonth;
	}
	
	public static WebElement readReminder( )				//Searching total reminders count
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return performer;
	}
	
	public static WebElement readReminder1( )				//Searching total reminders count
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecordTask']"));
		return performer;
	}
	
	public static WebElement readReminderMsg( )			//Searching after Save Message in My Reminders
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ValidationSummary1']/ul/li"));
		return performer;
	}
	
	public static WebElement readReminderMsg1( )			//Searching after Save Message in My Reminders
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ValidationSummary1']/ul/li"));
		return performer;
	}
	
	public static WebElement closeReminder( )			//Method to close compliance popup.
	{
		close = getDriver().findElement(By.xpath("//*[@class='close']"));
		return close;
	}
	
	public static WebElement selectInternal( )			//Searching 'Internal' compliance for My Reminders
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlDocType']"));
		return performer;
	}
	
	public static WebElement clickComplianceType( )
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-multiselect-wrap k-floatwrap'])[2]"));
		return performer;
	}
	
	public static WebElement clickInternalCheckbox( )
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[2]"));
		return performer;
	}
	
	public static WebElement clickStatutoryCheckbox( )
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-wrapper'])[1]"));
		return performer;
	}
	
	public static WebElement clickMyDocuments( )			//Searching 'My Documents'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return performer;
	}
	
	public static WebElement clickMyEscalation( )			//Searching 'My Documents'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftescalationmenu']"));
		return performer;
	}
	
	public static WebElement clickCriticalDocuments( )	//Searching 'Critical Document' under My Documents
	{
		performer = getDriver().findElement(By.xpath("//*[@id='DocumentShareListNew']"));
		return performer;
	}
	
	public static WebElement clickNew( )					//Searching '+New' folder element
	{
		performer = getDriver().findElement(By.xpath("//*[@id='menu1']"));
		return performer;
	}
	
	public static WebElement clickNewFolder( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAddNewFolder']"));
		return performer;
	}
	
	public static WebElement clickClearBtn( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return performer;
	}
	
	public static WebElement clickStatus( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[2]/span/span[2]"));
		return performer;
	}
	
	public static WebElement clickStatusAS( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dvdropdownlistComplianceType1']/span/span/span[2]"));
		return performer;
	}
	
	
	public static WebElement SelectInternal( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType1_listbox']/li[2]"));
		return performer;
	}
	
	public static WebElement SelectInternalAS( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType1_listbox']/li[2]"));
		return performer;
	}
	
	public static WebElement clickRisk( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div[1]/div[2]/div"));
		return performer;
	}
	
	public static WebElement clickRiskCritical( )			//Searching 'New Folder' after clicking on '+New'
	{
		performer = getDriver().findElement(By.xpath("(//li[@class='k-item k-first'])[1]"));
		return performer;
	}
	
	public static WebElement clickIsUniversal( )			//Searching Input box to write folder name
	{
		performer = getDriver().findElement(By.xpath("//input[@id = 'ContentPlaceHolder1_chkIsUnivers']"));
		return performer;
	}
	
	public static WebElement writeFolderName( )			//Searching Input box to write folder name
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']"));
		return performer;
	}
	
	public static WebElement clickCreate( )				//Searching 'Create' button after writing folder name
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_btnCreateFolder1']"));
		return performer;
	}
	//*[@id="ContentPlaceHolder1_FolderValidation"]/ul/li[1]
	
	public static WebElement readFolderMsg( )			//Searching Message after creating folder.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_FolderValidation']/ul/li"));
		return performer;
	}
	
	public static WebElement closeFolderPoppup( )		//Closing Create folder pop up.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divOpenNewFolderPopup']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement readFolderName( )			//Searching first folder name
	{
		performer = getDriver().findElement(By.xpath("(//*[@align='left'])[1]"));
		return performer;
	}
	
	public static WebElement clickShareFolder( )			//Searching Share Folder image
	{
		performer = getDriver().findElement(By.xpath("//*[@class='sharedrive']"));
		return performer;
	}
	
	public static WebElement clickPeople( )				//Searching People input box 
	{
		performer = getDriver().findElement(By.xpath("//*[@class='multiselect dropdown-toggle btn btn-default']"));
		return performer;
	}
	
	public static WebElement clickSearchPeople( )		//Searching 'Search People' input box
	{
		performer = getDriver().findElement(By.xpath("//*[@class='form-control multiselect-search']"));
		return performer;
	}
	
	public static WebElement clickPeopleCheckBox( )		//Clicking on Checkbox in front of name
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]/div[3]/div/span/div/ul/li[25]/a/label"));
		return performer;                        //*[@id="divOpenPermissionPopup"]/div/div/div[2]/div[3]/div/span/div/ul/li[25]/a/label/text()
	}
	
	public static WebElement clickPeopleCheckBox1( )		//Clicking on Checkbox in front of name
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]/div[3]/div/span/div/ul/li[5]/a/label"));
		return performer;                        //*[@id="divOpenPermissionPopup"]/div/div/div[2]/div[3]/div/span/div/ul/li[25]/a/label/text()
	}

	
	public static WebElement clickLabel( )				//Searching label to click on it.
	{
		performer = getDriver().findElement(By.xpath("//*[@class='modal-header-custom']"));
		return performer;
	}
	
	public static WebElement clickDone( )				//Searching 'Done' button
	{
		//performer = getDriver().findElement(By.xpath("//*[@value='Done']"));
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnPermission']"));
		return performer;
	}
	
	public static WebElement checkShared( )				//Searching share file button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']"));
		return performer;
	}
	
	public static WebElement closeSharePoppup( )			//Searching close share file poppup button.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement clickNewFile( )				//Searching New File button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkAddNewDocument']"));
		return performer;
	}
	
	public static WebElement uploadNewFile( )			//Searching upload New File button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ContractFileUpload']"));
		return performer;
	}
	
	public static WebElement clickUploadDocument( )		//Searching upload document button
	{
		performer = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnUploadDoc']"));
		return performer;
	}
	
	public static WebElement clickUserRole( )			//Searching 'More Actions' drop down 
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[1]"));
		return performer;
	}
	
	public static List<WebElement> selectUserRole( )		//Selecting third option 'Revise Compliance'
	{
		viewEvent = getDriver().findElements(By.xpath("//*[@id='dropdownlistUserRole-list']/div[2]/ul/li"));
		return viewEvent;
	}
	
	public static WebElement clickMoreActions( )			//Searching 'More Actions' drop down 
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[6]"));
		return performer;
	}//*[@id='ContentPlaceHolder1_btnAddPromotor']
	
	public static WebElement clickMoreActions1( )			//Searching 'More Actions' drop down 
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[6]"));
		return performer;
	}
	
	public static List<WebElement> selectAction( )		//Selecting third option 'Revise Compliance'
	{
		viewEvent = getDriver().findElements(By.xpath("//*[@id='dropdownlistMoreLink-list']/div[2]/ul/li"));
		return viewEvent;
	}
	
	public static WebElement clickAction( )				//Searching first action button
	{
		performer = getDriver().findElement(By.xpath("(//a[contains(@id,'ContentPlaceHolder1_grdRviseCompliances_lnkReviseCompliances')])[1]"));
		return performer;
	}
	
	public static WebElement clickRemark( )				//Searching 'Remark' textarea.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxRemarks']"));
		return performer;
	}
	
	public static WebElement upload1( )					//Searching upload button in action
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_FileUpload1']"));
		return performer;//*[@id="ContentPlaceHolder1_FileUpload1"]
	}
	
	public static WebElement clickInterest( )			//Searching Interest input box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtInterest']"));
		return performer;
	}
	
	public static WebElement clickPenalty( )				//Searching Penalty input box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtPenalty']"));
		return performer;
	}
	
	public static WebElement clickTaskAction( )			//Clicking on action button (edit image)
	{
		performer = getDriver().findElement(By.xpath("(//input[contains(@id,'ContentPlaceHolder1_grdTaskPerformer_btnChangeStatus')])[1]"));
		return performer;
	}
	
	public static WebElement TaskUpload( )				//Searching Upload button
	{
		performer = getDriver().findElement(By.xpath("//input[@id='fuTaskDoc']"));
		return performer;
	}
	
	public static WebElement clickStatutoryRejected( )	//Searching Statutory Reject value to click 
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerRejectedPEOcount']"));
		return performer;
	}
	
	public static WebElement clickInternalRejected( )	//Searching Internal Reject value to click
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerRejectedInternalPEOcount']"));
		return performer;
	}
	
	public static WebElement clickInternalRemark( )		//Searching Remark text area.
	{
		performer = getDriver().findElement(By.xpath("//textarea[@id='tbxRemarks2']"));
		return performer;
	}
	
	public static WebElement clickMoreLink( )			//Searching 'More Link' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddTaskDetails']"));
		return performer;
	}
	
	public static WebElement clickTaskDetails( )			//Searching 'Task Details' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddTask']"));
		return performer;
	}
	
	
	
	public static WebElement clickAddNew1( )				//Searching 'Add New' button.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
		return performer;
	}
	
	public static WebElement clickActFilter( )			//Searching 'Act Filter' drop down.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlActTask']"));
		return performer;                       
	}
	
	public static WebElement clickComplianceDropDown( )	//Searching 'Compliance' drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlCompliance']"));
		return performer;
	}
	
	public static WebElement clickTaskTitle( )			//Searching 'Task Title' text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtTaskTitle']"));
		return performer;
	}
	
	public static WebElement clickDescription( )			//Searching 'Description' TextArea
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtDescription']"));
		return performer;
	}
	
	public static WebElement clickDueDay( )				//Searching Due Day text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtDueDays']"));
		return performer;
	}
	
	public static WebElement clickTaskType( )			//Searching Task Type Drop Down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlAllTaskType']"));
		return performer;
	}
	
	public static WebElement clickStatutoryRB( )			//Searching Task Type Drop Down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoStatutory']"));
		return performer;
	}
	
	public static WebElement ShowAssignment( )			//Searching Task Type Drop Down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_LinkButton3_1']"));
		return performer;
	}
	
	
	
	public static WebElement clickSubTaskType( )			//Searching Sub Task Type Drop Down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlSubTaskType']"));
		return performer;
	}//*[@id="ContentPlaceHolder1_ddlSubTaskType"]
	
	public static WebElement clickIsAfter( )				//Searching Is After/Before drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlIsAfter']"));
		return performer;
	}
	
	public static WebElement clickConditionCheckbox( )	//Searching Condition CheckBox 
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ChkIsTaskConditional']"));
		return performer;
	}
	
	public static WebElement clickConditionalMessage( )	//Searching Condition CheckBox 
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtConditionalMessage']"));
		return performer;
	}
	
	public static WebElement clickYesMsg( )				//Searching Yes Message box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtYesMessage']"));
		return performer;
	}
	
	
	
	public static WebElement clickNoMsg( )				//Searching No Message box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtNoMessage']"));
		return performer;
	}
	
	public static WebElement SampleFormUpload( )
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_fuSampleFile']"));
		return performer;
	}
	
	public static WebElement taskSavedMsg( )				//Searching element of Successful Save of task.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl04']/ul/li"));
		
		return performer;
	}
	
	public static WebElement EditSavedMsg( )				//Searching element of Successful Save of task.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl04']/ul/li"));
		
		return performer;
	}
	
	public static WebElement taskSavedMsg1( )				//Searching element of Successful Save of task.
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl03']/ul/li"));
		
		return performer;
	}
	
	public static WebElement closeUpdateTasks( )			//Searching cross to close the form
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement closeUpdateTasks1( )			//Searching cross to close the form
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAssignmentDetailsDialog']/div/div/div[1]/button"));
		return performer;
	}
	public static List<WebElement> deleteTask( )			//Searching element to delete the added task 
	{
		elementsList = getDriver().findElements(By.xpath("//a[contains(@id,'ContentPlaceHolder1_grdTask_lbtDelete')]"));
		return elementsList;
	}
	
	public static WebElement deleteMsg( )				//Searching the msg element of Successful deletion
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl01']"));
		return performer;
	}
	
	public static List<WebElement> clickSubTask( )		//Searching all subtask elements.
	{
		elementsList = getDriver().findElements(By.linkText("sub-tasks"));
		return elementsList;
	}
	
	public static WebElement clickAddNew2( )				//Searching add new in Sub Task
	{
		//performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddSubTask']"));
		performer = getDriver().findElement(By.xpath("//a[@id='ContentPlaceHolder1_btnAddSubTask']"));
		return performer;                        //*[@id="ContentPlaceHolder1_btnAddSubTask"]
	}
	//*[@id='ContentPlaceHolder1_grdTaskPerformer']
	public static WebElement selectAllCheckbox1( )		//Searching 'Select All' checkbox in sub task
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rptTask_TaskSelectAll']"));
		return performer;
	}
	
	public static WebElement OK( )						//Searching OK button
	{
		performer = getDriver().findElement(By.xpath("//*[@value='Ok']"));
		return performer;
	}
	
	public static WebElement clickTaskMapping( )			//Searching 'Task Mapping' text box in Sub Task.
	{
		performer = getDriver().findElement(By.xpath("//*[@value='< Select Task >']"));
		return performer;
	}
	
	public static List<WebElement> clickAssignTask( )	//Searching all Assign task buttons.
	{
		elementsList = getDriver().findElements(By.xpath("//a[contains(@id,'ContentPlaceHolder1_grdTask_LinkButton3')]"));
		return elementsList;
	}
	
	public static WebElement clickComplianceLocation( )	//Searching Compliance Location text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return performer;
	}
	
	public static WebElement SubTaskEdit( )	//Searching Compliance Location text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_lbtEdit_0']"));
		return performer;
	}
	
	public static WebElement UpdateMsg( )	//Searching Compliance Location text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl03']/ul/li"));
		return performer;
	}
	
	public static WebElement SubTaskDelete( )	//Searching Compliance Location text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_lbtDelete_0']"));
		return performer;
	}
	
	
	public static WebElement clickReportingLocation( )	//Searching Reporting Location text box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocationTask']"));
		return performer;
	}
	
	public static List<WebElement> clickSubLoacations( )	//Searching Sub Loactions
	{
		elementsList = getDriver().findElements(By.xpath("//a[contains(@id,'ContentPlaceHolder1_tvFilterLocationTaskt')]"));
		return elementsList;
	}
	
	public static WebElement clickStartDate( )			//Searching Start date box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxStartDate']"));
		return performer;
	}
	
	public static WebElement clickStartDate1( )			//Searching Start date box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtStartDate']"));
		return performer;//*[@id="ContentPlaceHolder1_txtStartDateassign"]
	}
	
	public static WebElement clickEndDate( )				//Searching Start date box
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtEndDate']"));
		return performer;
	}
	
	public static WebElement clickSelectPerformer( )		//Searching Performers drop down
	{
		performer = getDriver().findElement(By.xpath("//div[contains(@id,'ContentPlaceHolder1_ddlPerformer')]"));
		return performer;
	}
	
	public static WebElement clickSelectReviewer( )		//Searching reviewers drop down
	{
		performer = getDriver().findElement(By.xpath("//div[contains(@id,'ContentPlaceHolder1_ddlReviewer')]"));
		return performer;
	}
	
	public static WebElement checkRecordsTable( )		//Searching assigned data table
	{
		performer = getDriver().findElement(By.xpath("//*[@class='clsROWgrid']"));
		return performer;
	}
	
	public static WebElement checkRecordsTable1( )		//Searching assigned data table
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_GrdAssigment']/tbody/tr[2]"));
		return performer;
	}
	
	public static WebElement clickSearchedUser1( )		//Searching searched user
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-option-array-index='1'])[1]"));
		return performer;
	}
	
	public static WebElement clickSearchedUser2( )		//Searching searched user
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-option-array-index='1'])[2]"));
		return performer;
	}
	
	public static WebElement clickSaveButton1( )			//Searching Save button
	{
		performer = getDriver().findElement(By.xpath("//input[@id='ContentPlaceHolder1_btnSaveTaskAssignment']"));
		return performer;
	}
	
	public static WebElement SelectCheckBox( )			//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationn2CheckBox']"));
		return performer;
	}
	
	public static WebElement clickMainTaskLink( )		//Searching Main Task link to go back from Sub Task
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_dlBreadcrumb']"));
		return performer;
	}
	
	public static WebElement clickInternaRadioButton( )	//Searching radio button for Internal Tasks
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rdoInternal']"));
		return performer;
	}
	
	public static WebElement clickInternalCompliance( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlInternalCompliance']"));
		return performer;
	}
	
	public static WebElement selectAllCheckbox( )		//Searching 'Select All' checkbox
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grdGstMappedCompliance_chkComplianceAll']"));
		return performer;
	}
	
	public static WebElement selectNewPerformer( )		//Searching new Performer drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewPerformerUsers']"));
		return performer;
	}
	
	public static WebElement selectNewReviewer( )		//Searching new Reviewer drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewReviewerUsers']"));
		return performer;
	}
	
	public static WebElement selectNewEventOwner( )		//Searching new Event Owner drop down
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewEventOwnerUsers']"));
		return performer;
	}
	
	public static WebElement progressGIF( )				//Searching Progress GIF Loading image
	{
		performer = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return performer;
	}
	
	public static WebElement readMsgLeave( )				//Searching Message after Save
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_VDS']"));
		return performer;
	}
	
	public static WebElement closeLeave( )				//Searching cross to close window
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divLeaveDialog']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement clickUpcomingStatutory( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divupcomingPEOcount']"));
		return performer;
	}
	
	public static WebElement clickPFRStatutory( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerPendingforReviewPEOcount']"));
		return performer;
	}
	
	public static WebElement clickPFRInternal( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPerformerPendingforRevieweInternalPEOcount']"));
		return performer;
	}
	
	public static WebElement clickUpcomingInternal( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divupcomingInternalPEOcount']"));
		return performer;
	}
	
	public static WebElement checkTable( )				//Searching table
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']"));
		return performer;
	}
	
	public static WebElement clickActDetails( )				//Searching table
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ActDetails']/div/div/div/div[1]/div/div/a"));
		return performer;
	}
	
	public static WebElement clickAct( )				//Searching table
	{
		performer = getDriver().findElement(By.xpath("//*[@id='basic']/tbody/tr[1]/td/span"));
		return performer;
	}
	
	public static WebElement clickView( )				//Searching table
	{
		performer = getDriver().findElement(By.xpath("//*[@id='basic']/tbody/tr[2]/td[3]"));
		return performer;
	}
	
	public static WebElement closeView( )				//Searching table
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divPerActOverView']/div/div/div[1]/button"));
		return performer;
	}
	
	
	public static WebElement closeTab( )				//Searching table
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ComplaincePerformer']/div/div/div[1]/button"));
		return performer;
	}
	
	
	public static WebElement checkTable1( )				//Searching table
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-grid-content k-auto-scrollable'])[2]"));
		return performer;
	}
	
	public static List<WebElement> readStatus( )			//Searching all Upcoming status
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr/td[8]"));
		return elementsList;
	}
	
	public static WebElement fileUploadUpcoming( )		//Method to search Choose File button. 
	{
		upload = getDriver().findElement(By.xpath("//*[@id='FileUpload1']"));
		return upload;
	}
	
	public static WebElement clickShow( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']"));
		return performer;
	}
	
	public static WebElement clickShow1( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSizeTask']"));
		return performer;
	}//*[@id='ContentPlaceHolder1_grdTaskPerformer']
	
	public static WebElement ClickTaskCreation( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_liTaskCreation']"));
		return performer;
	}
	
	public static WebElement ClickPerformReview( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_liPerformerReviewer']"));
		return performer;
	}
	
	public static WebElement PerformReviewMsg( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='vsTaskPerformer']/ul/li"));
		return performer;
	}
	public static WebElement TaskReviewMsg( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='vsTaskReviewer']"));
		return performer;
	}
	public static WebElement Period( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[1]/span/span[2]"));
		return performer;
	}
	
	public static WebElement AllPeriod( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistTypePastdata_listbox']/li[7]"));
		return performer;
	}
	
	public static WebElement ClickEditBtn( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_lbtEdit_0']"));
		return performer;                       
	}
	
	public static WebElement ClickEditBtnIn( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_lbtEdit_2']"));
		return performer;                       
	}
	
	public static WebElement ClickShowAssignment( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_LinkButton3_0']"));
		return performer;
	}
	
	public static WebElement ClickShowAssignmentTask( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_LinkButton3_0']"));
		return performer;
	}
	
	public static WebElement ClickShowAssignmentTaskIn( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_LinkButton3_2']"));
		return performer;
	}
	
	public static WebElement ClickDeleteTask( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_lbtDelete_0']"));
		return performer;                         
	}
	
	public static WebElement ClickDeleteTaskIn( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_lbtDelete_2']"));
		return performer;                         
	}
	
	public static WebElement AfterClickDelete( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl02']/ul/li"));
		return performer;
	}
	
	public static WebElement STAfterClickDelete( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl01']/ul/li"));
		return performer;
	}
	
	public static WebElement BacktoTask( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_dlBreadcrumb']/span/a"));
		return performer;                        
	}
	
	
	public static WebElement ComplianceLocation( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation1']"));
		return performer;                        
	}
	
	public static WebElement ComplianceLocationST( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n1']/img"));
		return performer;                        //*[@id="ContentPlaceHolder1_tvFilterLocationn1"]/img
	}
	                                             
	public static WebElement ComplianceLocationACD( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n2']/img"));
		return performer;                        
	}
	
	public static WebElement ComplianceLocationACD1( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n3']/img"));
		return performer;                        
	}
	
	public static WebElement CLLPvt( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n4CheckBox']"));
		return performer;                        
	}
	
	public static WebElement CLLPvt1( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n2CheckBox']"));
		return performer;                        
	}
	
	public static WebElement ReportingLocation( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocationTask']"));
		return performer;                        
	}
	
	public static WebElement ReportingLocationAB( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationTaskn0']"));
		return performer;                       
	}
	
	public static WebElement ReportingLocationA( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationTaskt2']"));
		return performer;                      
	}
	
	public static WebElement STPerformer( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPerformerAssign_chosen']/a"));
		return performer;                       
	}
	
	public static WebElement TPerformer( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPerformer_chosen']/a"));
		return performer;                       
	}
	
	public static WebElement STPerformerText( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPerformerAssign_chosen']/div/div/input"));
		return performer;                        
	}
	
	public static WebElement abcExternal( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPerformerAssign_chosen']/div/ul/li[2]"));
		return performer;                             
	}
	
	public static WebElement TabcExternal( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPerformer_chosen']/div/ul/li[2]"));
		return performer;                             
	}
	
	public static WebElement Reviewer( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewerAssign_chosen']/a/div/b"));
		return performer;                        
	}
	
	public static WebElement TReviewer( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewer_chosen']/a"));
		return performer;                        
	}
	
	
	public static WebElement ReviewerText( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewerAssign_chosen']/div/div/input"));
		return performer;                        
	}
	
	public static WebElement abclawyer( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewer_chosen']/div/ul/li[3]"));
		return performer;                        
	}
	
	public static WebElement abclawyer1( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewerAssign_chosen']/div/ul/li[3]"));
		return performer;                        
	}
	
	public static WebElement Tabclawyer( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewer_chosen']/div/ul/li[3]"));
		return performer;                        
	}
	
	public static WebElement Reviewer221( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewer2_chosen']/a"));
		return performer;                        
	}
	
	public static WebElement TReviewer22( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewer2_chosen']/div/ul/li[4]"));
		return performer;                        
	}
	
	public static WebElement Reviewer221Fm( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewerAssign2_chosen']/a"));
		return performer;                        
	}
	
	public static WebElement Reviewer221Fm1( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlReviewerAssign2_chosen']/div/ul/li[5]"));
		return performer;                        
	}
	
	public static WebElement SaveBtn( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveTaskAssignment']"));
		return performer;                        
	}
	
	public static WebElement Startdate( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxStartDate']"));
		return performer;                                   
	}
	
	public static WebElement date18( )		//
	{
		performer = getDriver().findElement(By.linkText("18"));
		return performer;                        
	}
	
	public static WebElement TAmsg( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ctl09']/ul/li"));
		return performer;                        
	}
	
	public static WebElement CloseTab( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAssignmentDetailsDialog']/div/div/div[1]/button"));
		return performer;                        
	}
	
	public static WebElement ComplianceLocationT( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));
		return performer;                                    
	}
	
	public static WebElement ComplianceLocationTABCD( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationn1']/img"));
		return performer;                       //*[@id="ContentPlaceHolder1_tvFilterLocation1n1"] 
	}
	
	public static WebElement ComplianceLocationTABCD1( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationn2']/img"));
		return performer;                      
	}
	
	public static WebElement ComplianceLocationTABCD2( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationn3']/img"));
		return performer;                      
	}
	
	public static WebElement LPvtLtd( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationn4CheckBox']"));
		return performer;                        
	}
	
	public static WebElement BPvtLtd( )		//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n2CheckBox']"));
		return performer;                        
	}
	
	
	public static WebElement clickMyWorkspace2( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'leftworkspacemenuLic']/a"));
		return performer;
	}
	
	public static WebElement ComplianceDocumentLink	( )				//
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_TxtComplianceDocument']"));
		return performer;
	}
	
	public static WebElement PenaltyRemark( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id = 'ContentPlaceHolder1_txtremark']"));
		return performer;
	}
	
	public static WebElement clickPTUpcomingStatutory( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerUpcomingStat']"));
		return performer;
	}
	
	public static WebElement ReadCountUpcoming( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return performer;
	}
	
	public static List<WebElement> ActionBtns( )			//Searching all Upcoming status
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='btnss']"));
		return elementsList;
	}
	
	
	public static WebElement clickPTUpcomingInternal( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerUpcomingInt']"));
		return performer;
	}
	
	public static WebElement clickPTOverdueStatutory( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerOverdueStat']"));
		return performer;
	}
	
	public static WebElement clickPTOverdueInternal( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerOverdueInt']"));
		return performer;
	}
	
	public static WebElement clickPTRejectedStatutory( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerRejectedStat']"));
		return performer;
	}
	
	public static WebElement Peroid( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[2]/span[1]/span/span[2]/span"));
		return performer;
	}
	
	public static WebElement AllPeroid( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownPastData_listbox']/li[5]"));
		return performer;
	}
	
	public static WebElement clickPTRejectedInternal( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerRejectedInt']"));
		return performer;
	}
	
	public static WebElement clickStaBtnCale( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[1]/div/div[3]/div[12]/a"));
		return performer;
	}
	
	public static WebElement clickStaBtnCaleRe( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[1]/div/div[3]/div[16]/a"));
		return performer;
	}
	
	public static WebElement Exportbtn( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Exportbtn']"));
		return performer;
	}
	
	public static WebElement ASExportbtn( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Exportbtn1']"));
		return performer;
	}
	
	public static WebElement Exportbtn1( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='exportAdvanced']"));
		return performer;
	}
	public static WebElement Exportbtn2( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='exportAdvanced2']"));
		return performer;
	}
	
	public static WebElement clickInterBtnCale( )	//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[1]/div/div[3]/div[5]/a"));
		return performer;
	}

	
	public static WebElement sletre( )					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletlere( )				//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletre( )					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement sledtre( )					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletldere( )				//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement seletdre( )					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement ClickBtn( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='main-content']/header/div[2]/ul/li[4]/a/b"));
		return performer;
	}
	
	public static WebElement ClickMyLeave( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='main-content']/header/div[2]/ul/li[4]/ul/li[3]"));
		return performer;
	}
	
	public static WebElement ClickAddNew( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
		return performer;
	}
	
	public static WebElement ClickTemAss( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_liSubmitted']"));
		return performer;
	}
	
	public static WebElement StartDate( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtStartDate']"));
		return performer;
	}
	
	public static WebElement StartDateAssign( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtStartDateassign']"));
		return performer;
	}
	
	public static WebElement EndDate( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtEndDate']"));
		return performer;
	}//*[@id="ContentPlaceHolder1_txtStartDateassign"]
	
	public static WebElement EndDateAssign( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtEndDateassign']"));
		return performer;
	}
	
	public static WebElement userPerformer( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewPerformerUsers']"));
		return performer;
	}
	
	public static WebElement userPerformerAssign( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewPerformerUsersassign']"));
		return performer;
	}
	
	public static WebElement userReviewer( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewReviewerUsers']"));
		return performer;
	}
	
	public static WebElement userReviewerAsssign( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewReviewerUsersassign']"));
		return performer;
	}
	
	public static WebElement ClickEventOwer( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewEventOwnerUsersassign']"));
		return performer;
	}
	
	public static WebElement clickCheckBox( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdassignedcompliance_Chkselection_0']"));
		return performer;
	}
	
	public static WebElement saveBtn( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']"));
		return performer;
	}
	
	public static WebElement saveBtnCancel( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancelSave']"));
		return performer;
	}
	
	public static WebElement saveBtnAssign( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnassignSave']"));
		return performer;
	}
	
	public static WebElement cancelLeave( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLeave_lbtDelete_3']"));
		return performer;
	}
	
	public static WebElement searchBox( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtSearchType']"));
		return performer;
	}
	
	public static WebElement ClicksearchBtn( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSearch1']"));
		return performer;
	}
	
	public static WebElement ClickClearBtn( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkBtnClearFilter']"));
		return performer;
	}
	
	public static WebElement ClickLivechat( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@class='tawk-custom-color tawk-custom-border-color tawk-button tawk-button-circle tawk-button-large']"));
		return performer;                                    
	}
	
	public static WebElement ClickInternalMsg( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='emailicon']"));
		return performer;                                    
	}
	
	public static WebElement ClickTo( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='txttomail']"));
		return performer;                                    
	}
	
	public static WebElement ClickSub( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='txtsub']"));
		return performer;                                    
	}
	
	public static WebElement TypeMsg( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='txtmsgbody']"));
		return performer;                                    
	}
	
	public static WebElement choosefile( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='FileUpload1']"));
		return performer;                                    
	}
	
	public static WebElement send( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id=btnsendmailNew']"));
		return performer;                                    
	}
	
	public static WebElement EmailtextBox( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='l6t4hrn3npk81671521536673']"));
		return performer;
	}
	
	public static WebElement TicketSub( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ticketsubject']"));
		return performer;                                    
	}
	
	public static WebElement ClickSelectIssue( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='issues']"));
		return performer;                                    
	}
	
	public static WebElement ReasoverdueDelayCompletion( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divDeviation']/table/tbody/tr[1]/td[1]/label[2]"));
		return performer;                                    
	}
	
	public static WebElement DeviationClosureDate( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='lbldateDev']"));
		return performer;                                    
	}
	
	
	public static WebElement TicketMessage( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ticketmessage']"));
		return performer;                                    
	}
	
	public static WebElement ClickCreateTicket( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='btnsendmail']"));
		return performer;                                    
	}
	
	
	public static WebElement ClickSupportTicket( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ticketicon']"));
		return performer;                                    
	}
	
	public static WebElement StratChat( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='tawk-form-container']/div/div/div[2]/button[1]/p"));
		return performer;
	}
	
	public static WebElement cancelChat( )					//
	{
		performer = getDriver().findElement(By.xpath(""));
		return performer;
	}
	
	public static WebElement MitigationPFilter( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/div/span[5]/span/span[2]"));
		return performer;
	}
	
	public static WebElement Apply( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return performer;
	}
	
	public static WebElement Clicktri( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-more-vertical']"));
		return performer;
	}
	
	public static WebElement Column( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow']"));
		return performer;
	}
	
	public static WebElement MitigationPlanCheck( )					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-link k-menu-link'])[10]/input"));
		return performer;
	}
	
	public static WebElement MitigationPlanCheck1( )					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-link k-menu-link'])[14]/input"));
		return performer;
	}
	
	public static WebElement SelectStatusP( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[2]/span/span[2]"));
		return performer;
	}
	
	public static WebElement SelectStatusOverdue( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[3]"));
		return performer;
	}
	
	public static WebElement ClearFilter( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return performer;
	}
	
	public static WebElement ClickApply( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return performer;
	}
	
	public static WebElement WhatsNewIcon( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='WhatsNew_notificatoin_bar']/a/i"));
		return performer;
	}
	
	public static WebElement WhatsNewView( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grdTaskActivity']/div[3]/table/tbody/tr[1]/td[7]/a[1]"));
		return performer;
	}
	
	public static WebElement WhatsNewViewClose( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divViewDocument']/div/div/button"));
		return performer;
	}
	
	public static WebElement WhatsNewDownload( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grdTaskActivity']/div[3]/table/tbody/tr[1]/td[7]/a[2]"));
		return performer;
	}
	
	public static WebElement UserIcon( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='main-content']/header/div[2]/ul/li[5]/a"));
		return performer;
	}
	
	public static WebElement MyLeave( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='main-content']/header/div[2]/ul/li[5]/ul/li[3]/a"));
		return performer;
	}
	
	public static WebElement TemporaryAssignment( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_Tab2']"));
		return performer;
	}
	
	public static WebElement AddNew( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddPromotor']"));
		return performer;
	}
	
	public static WebElement StartDateML( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtStartDateassign']"));
		return performer;
	}
	
	public static WebElement StartDateML1( )					//
	{
		performer = getDriver().findElement(By.linkText("7"));
		return performer;
	}
	
	public static WebElement EndDateML( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtEndDateassign']"));
		return performer;
	}
	
	public static WebElement EndDateML1( )					//
	{
		performer = getDriver().findElement(By.linkText("7"));
		return performer;
	}
	
	public static WebElement NewUserPerformer( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewPerformerUsersassign']"));
		return performer;
	}
	
	public static WebElement NewUserPerformer1( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewPerformerUsersassign']/option[4]"));
		return performer;
	}
	
	public static WebElement NewUserReviewer( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewReviewerUsersassign']"));
		return performer;
	}
	
	public static WebElement NewUserReviewer1( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewReviewerUsersassign']/option[7]"));
		return performer;
	}
	
	public static WebElement NewEventOwner( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewEventOwnerUsersassign']"));
		return performer;
	}
	
	public static WebElement NewEventOwner1( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewEventOwnerUsersassign']/option[2]"));
		return performer;
	}
	
	public static WebElement CheckBox( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdassignedcompliance_Chkselection_0']"));
		return performer;
	}
	
	public static WebElement Save( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnassignSave']"));
		return performer;
	}
	
	public static WebElement Internal( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_rblcompliancetype_1']"));
		return performer;
	}
	
	public static WebElement TypeofSearch( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']"));
		return performer;
	}
	
	public static WebElement ShowAssingment( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask_LinkButton3_0']"));
		return performer;
	}
	
	public static WebElement Reviewer2( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRev2']/label[2]"));
		return performer;
	}
	
	public static WebElement Reviewer2Close( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAssignmentDetailsDialog']/div/div/div[1]/button"));
		return performer;
	}
	

	public static WebElement SubTask( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTask']/tbody/tr[2]/td[5]/a"));
		return performer;
	}
	
	public static WebElement CalendarArrow( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[1]/div/div[1]/a[1]/div"));
		return performer;
	}
	
	public static WebElement CalendarArrow1( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='collapsePerformerCalender']/div/div[1]/div[1]/div/div[3]/div[4]/a"));
		return performer;
	}
	
	public static WebElement ClickTriangle( )					//
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-more-vertical']"));
		return performer;
	}
	
	public static WebElement Clickcolumns()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow']"));
		return performer;
	}
	
	public static WebElement Clickcolumns1()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[3]"));
		return performer;
	}
	
	public static WebElement ClickcolumnsCD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[35]"));
		return performer;
	}
	
	public static WebElement ComplianceIDcolumns()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-field='ComplianceID'])[2]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedCol()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-field='DeviationApprover'])[2]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedColD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-field='DeviationApprover'])[3]"));
		return performer;
	}
	
	public static WebElement DeviationClosureStatuscol()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-field='Deviation_Closure_Status'])[2]"));
		return performer;
	}
	public static WebElement PerformerEmailmenu()					//
	{
		performer = getDriver().findElement(By.xpath("//div[@class='k-animation-container']//ul//li[13]"));
		return performer;
	}
	public static WebElement IsSMETAColumnCheckBox()					//
	{
		performer = getDriver().findElement(By.xpath("//input[@data-field='IsSmetaCompliance']"));
		return performer;
	}

	
	public static WebElement ReviewerEmailmenu()					//
	{
		performer = getDriver().findElement(By.xpath("//div[@class='k-animation-container']//ul//li[15]"));
		return performer;
	}

	
	public static WebElement DeviationClosureStatuscolD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@data-field='Deviation_Closure_Status'])[3]"));
		return performer;
	}
	
	public static WebElement DeviationApprover()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-link'])[25]"));
		return performer;
	}
	
	public static WebElement DeviationClosureStatus()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-link'])[24]"));
		return performer;
	}
	
	public static WebElement DeviationClosureStatusCD()					//
	{
		performer = getDriver().findElement(By.xpath("//a[.='Deviation Closure Status']"));
		return performer;
	}
	public static WebElement Performercol()					//
	{
		performer = getDriver().findElement(By.xpath("//table[@role='grid']//colgroup/col[8]"));
		return performer;
	}

	public static WebElement Reviewercol()					//
	{
		performer = getDriver().findElement(By.xpath("//table[@role='grid']//colgroup/col[10]"));
		return performer;
	}

	public static WebElement DeviationClosureStatusM()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-link'])[19]"));
		return performer;
	}
	
	
	public static WebElement ComplianceIDtri()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[5]"));
		return performer;
	}
	
	public static WebElement ClickFilter()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-right k-menu-expand-arrow'])[4]"));
		return performer;
	}
	
	public static WebElement ClickEdit()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a[1]"));
		return performer;
	}
	
	
	public static WebElement search()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@placeholder='Search'])[3]"));
		return performer;
	}
	
	public static WebElement Filter()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-button k-primary'])[3]"));
		return performer;
	}

	public static WebElement Complianceid()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='txtSearchComplianceID']"));
		return performer;
	}
	
	public static WebElement Edit()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[26]/a[1]"));
		return performer;
	}
	
	public static WebElement txtdeviationreason()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='txtdeviationreason']"));
		return performer;
	}
	
	public static WebElement tbxDateDev()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='tbxDateDev']"));
		return performer;
	}
	
	public static WebElement tbxDateDev1()					//
	{
		performer = getDriver().findElement(By.linkText("22"));
		return performer;
	}
	
	public static WebElement Text()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Labelmsg']"));
		return performer;
	}
	
	public static WebElement StatusCD()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='divAdvanceSearchModel']/div[1]/div[2]/div"));
		return performer;
	}
	
	public static WebElement StatusDR()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[1]/div[4]/div/div/span[1]"));
		return performer;
	}
	
	public static WebElement DeviationApplied()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[25]"));
		return performer;
	}
	
	public static WebElement DeviationRejected()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[26]"));
		return performer;
	}
	
	public static WebElement DeviationApproved()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[26]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedCD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[99]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedCD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[100]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedCD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[101]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedCD1()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[25]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedCD1()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[26]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedCD1()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[27]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedDR()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[17]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedDR()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[18]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedDR()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[19]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedO()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[8]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedO()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[9]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedO()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[10]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedM()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[32]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedM()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[33]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedM()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[34]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedMG()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[20]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedMG()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[21]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedMG()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[22]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedAu()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[22]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedAU()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[23]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedAu()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[24]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedMGD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[23]"));
		return performer;
	}
	
	public static WebElement DeviationAppliedMGP()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[23]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedMGP()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[24]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedMGP()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[25]"));
		return performer;
	}
	
	
	public static WebElement DeviationAppliedMGPD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[22]"));
		return performer;
	}
	
	public static WebElement DeviationRejectedMGPD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[23]"));
		return performer;
	}
	
	public static WebElement DeviationApprovedMGPD()					//
	{
		performer = getDriver().findElement(By.xpath("(//*[@class='k-in'])[24]"));
		return performer;
	}
	
	public static WebElement Clickoverview( )			//Searching 'My Reminder' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='viewSampleDoc']"));
		return performer;
	}
	
	public static WebElement ClickoverviewClose( )			//Searching 'My Reminder' button
	{
		performer = getDriver().findElement(By.xpath("//*[@id='DocumentReviewPopUp2']/div/div/div[1]/button"));
		return performer;
	}
	
	public static WebElement Download()					//
	{
		performer = getDriver().findElement(By.xpath("//*[@id='downloadSampleDoc']"));
		return performer;
	}
	public static WebElement clickReports( )					//Searching 'My Reports' element
	{
		performer = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu1']"));
		return performer;
	}
	public static WebElement clickDetailedReport( )			//Searching 'Detailed Report' element under 'My reports'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='Myreport']"));
		return performer;
	}
	
	public static WebElement Act( )			//Searching 'Detailed Report' element under 'My reports'
	{
		performer = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div[2]/div[3]/span/span/span[2]/span"));
		return performer;
	}
	
	public static void MyReminder(  ExtentTest test, String compliance) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		WebDriverWait wait1 = new WebDriverWait(getDriver(), (30));
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickMyReminder()));
		//Actions action = new Actions(driver);
		//action.moveToElement(clickMyReminder(driver)).click().perform();	//Clicking on 'My Reminder'
		clickMyReminder().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(clickComplianceType()));
		clickComplianceType().click();
		Thread.sleep(500);
		if(compliance.equalsIgnoreCase("Internal"))
		{
			clickInternalCheckbox().click();
		}
		else
		{
			clickStatutoryCheckbox().click();
		}
		
		Thread.sleep(8000);
		//litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		wait1.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.readTotalItems1()));
		CFOcountPOM.readTotalItems1().click();
		String item = CFOcountPOM.readTotalItems1().getText();
		String[] bits = item.split(" ");							//Splitting the String
		String remindersCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		for(int i = 0; i <= 1; i++)
		{
			if(remindersCount.equalsIgnoreCase("to"))
			{
				js.executeScript("window.scrollBy(0,1000)");
				try
				{			//Waiting till the grid's second row's fifth column data gets clickable.
					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-grid-content k-auto-scrollable']/table/tbody/tr[2]/td[5]")));
				}
				catch(Exception e)
				{
					
				}
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");									//Splitting the String
				remindersCount = bits[bits.length - 2];
			}
			else
			{
				break;
			}
		}
		
		int count = Integer.parseInt(remindersCount);				//Reading number of records.
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(500);
		clickAddNewReminder().click();								//Clicking on 'Add New' button 
		
		Thread.sleep(500);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		wait.until(ExpectedConditions.visibilityOf(selectComplianceType1()));
		
		if(compliance.equalsIgnoreCase("Internal"))
		{
			selectComplianceType1().click();				//Clicking on 'Compliance Type' drop down 
			Thread.sleep(500);
			selectInternalType().click();					//Clicking on 'Internal' menu.
			Thread.sleep(1500);
		}
		
		Thread.sleep(1000);
		clickLocation().click();							//Clicking on 'Location' drop down
		Thread.sleep(500);
		elementsList = selectLocation1();
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		elementsList.get(2).click();							//Selecting third menu from drop down.
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(clickCompliance1()));
		clickCompliance1().click();						//Clicking on 'Compliance' drop down
		elementsList = selectCompliance1();
	//	elementsList.get(2).click();							//Selecting second menu from drop down.CFO
		elementsList.get(1).click();                           //Auditor
		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		clickRole().click();								//Clicking on 'Role' drop down.
		elementsList = selectRole1();
		elementsList.get(1).click();							//Selecting second menu from drop down.
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		selectDateStatutory().click();					//Clicking on 'Date' input box
		Thread.sleep(300);
		selectNextMonth().click();						//Clicking on Next month arrow on calendar
		Thread.sleep(300);
		selectDate().click();								//Clicking on date at second row and fourth column
		
		Thread.sleep(500);
		clickSaveButton().click();						//Clicking 'Save' button.
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress(driver);
		
		Thread.sleep(500);
		String actualMsg = readReminderMsg1().getText();	//Reading Message after Save
		String expectedMsg1 = "Reminder Saved Sucessfully.";	//Expected message
		
		getDriver().switchTo().parentFrame();
		closeReminder().click();							//Closing the Reminder popped window
		//*[@id = 'ValidationSummary1']/ul/li
		test.log(LogStatus.PASS, actualMsg);
		
		Thread.sleep(1000);
		getDriver().navigate().refresh();
		Thread.sleep(500);
		wait1.until(ExpectedConditions.visibilityOf(clickComplianceType()));
		wait.until(ExpectedConditions.elementToBeClickable(clickComplianceType()));
		clickComplianceType().click();
		Thread.sleep(500);
		if(compliance.equalsIgnoreCase("Internal"))
		{
			clickInternalCheckbox().click();
		}
		else
		{
			clickStatutoryCheckbox().click();
		}
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
				
		js.executeScript("window.scrollBy(0,1000)");
		
		wait1.until(ExpectedConditions.elementToBeClickable(CFOcountPOM.readTotalItems1()));
		CFOcountPOM.readTotalItems1().click();
		item = CFOcountPOM.readTotalItems1().getText();
		bits = item.split(" ");							//Splitting the String
		remindersCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		for(int i = 0; i <= 1; i++)
		{
			if(remindersCount.equalsIgnoreCase("to"))
			{
				js.executeScript("window.scrollBy(0,1000)");
				try
				{			//Waiting till the grid's second row's fifth column data gets clickable.
					wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-grid-content k-auto-scrollable']/table/tbody/tr[2]/td[5]")));
				}
				catch(Exception e)
				{
					
				}
				item = CFOcountPOM.readTotalItems1().getText();
				bits = item.split(" ");									//Splitting the String
				remindersCount = bits[bits.length - 2];
			}
			else
			{
				break;
			}
		}
		
		int count1 = Integer.parseInt(remindersCount);				//Reading number of records.
		
		if(actualMsg.equalsIgnoreCase(expectedMsg1))
		{
			if(count < count1)
			{
				test.log(LogStatus.PASS, compliance + " - Reminder count updated. Old count = "+count+" New count = "+count1);
			}
			else
			{
				test.log(LogStatus.PASS, compliance + " - Reminder count doesn't updated. Old count = "+count+" New count = "+count1);
			}
		}
		else
		{
			if(count == count1)
			{
				test.log(LogStatus.PASS, compliance + " - Reminder count doesn't updated. Old count = "+count+" New count = "+count1);
			}
			else
			{
				test.log(LogStatus.FAIL, compliance + " - Reminder count updated. Old count = "+count+" New count = "+count1);
			}
		}
		Thread.sleep(4000);
		OverduePOM.clickDashboard().click();
		Thread.sleep(4000);
	}
	
	public static void CriticalDocuments(  ExtentTest test) throws InterruptedException
	{
		Thread.sleep(1000);
		clickMyDocuments().click();					//Clicking on 'My Documents'
		
		Thread.sleep(1000);
		clickCriticalDocuments().click();				//Clicking on 'Critical Documents'
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail']")));	//Wating till the content table gets visible
		
		Thread.sleep(500);
		String name = readFolderName().getText();		//Reading the folder name to create new folder.
		
		String folder = name+"A"; 
		
		clickNew().click();							//Clicking on '+New' button.
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		clickNewFolder().click();						//Clicking on 'New Folder'
		
		Thread.sleep(2000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(300);
		clickIsUniversal().click();
		
		Thread.sleep(1000);
		writeFolderName().sendKeys(folder);			//Writing Folder name.
		
		Thread.sleep(1000);
		clickCreate().click();						//Clicking on create button.
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
	//	String msg = driver.switchTo().alert().getText();
		//test.log(LogStatus.INFO, msg);
		Thread.sleep(500);
		try {
			String t = OverduePOM.readFolderMsg().getText();
			test.log(LogStatus.PASS, t);
			//getDriver().switchTo().alert().accept();
		}catch(Exception e) {
			
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		name = readFolderName().getText();				//Reading the folder name we had created
		
		if(folder.equalsIgnoreCase(name))
		{
			test.log(LogStatus.PASS, "Created folder '"+folder+"' displayed in the records.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Created folder '"+folder+"' doesn't displayed in the records.");
		}
		
		Thread.sleep(4000);
		readFolderName().click();						//Clicking on folder name we had created.
		Thread.sleep(1000);
		readFolderName().click();						//Clicking on folder name we had created.
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNew()));
		clickNew().click();							//Clicking on 'New'
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		//Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNewFile()));
		clickNewFile().click();						//CLicking on 'New File'
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		String workingDir = System.getProperty("user.dir");
		uploadNewFile().sendKeys("E:\\Ethics Committee Details.xlsx");	//uploading new file		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickUploadDocument()));
		
		Thread.sleep(5000);
		clickUploadDocument().click();				//Clicking on 'Upload Document'
		
		Thread.sleep(5000);
	    // Switching to Alert        
        Alert alert = getDriver().switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= getDriver().switchTo().alert().getText();	
        
        Thread.sleep(3000);
        test.log(LogStatus.PASS, alertMessage);
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        
        		
        // Accepting alert		
        alert.accept();		
		
		
		
		Thread.sleep(100);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		readFolderName().click();						//Clicking on file we had uploaded.
		
		
		
		
		
//		if(readFolderName().isDisplayed())			//Checking if file got created or not.
//			test.log(LogStatus.PASS, "Uploaded file displayed.");
//		else
//			test.log(LogStatus.PASS, "Uploaded file does not displayed.");
//		
		//readFolderName().click();						//Clicking on file we had uploaded.
				
		Thread.sleep(500);
		clickShareFolder().click();					//Clicking on Share Folder image.
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickPeople()));
		clickPeople().click();						//Clicking on People drop down 
		clickSearchPeople().click();					//Clicking on Search People drop down.
		
		Thread.sleep(500);
	//	clickSearchPeople(driver).sendKeys("aayush tripathi");			//Writing user name to search for  CFO
	//	clickSearchPeople().sendKeys("Company");	        // Auditor
	//	clickSearchPeople().sendKeys("Amit shaha");	//Approver
		//Thread.sleep(4000);
		
		clickSearchPeople().sendKeys("Approver User");	//Department
		Thread.sleep(3000);
		
		clickPeopleCheckBox1().click();	
		Thread.sleep(3000);//Clicking on label to get out from people search box
		getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]")).click();
		
		Thread.sleep(1000);
		clickDone().click();	//Clicking on 'Done' to share folder.
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		
		Thread.sleep(1000);
		readFolderName().click();						//Clicking on file name we had uploaded.
		
		Thread.sleep(500);
		clickShareFolder().click();					//Clicking on Share File image.
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']")));	//Waiting till the share element gets visible
		
		//Thread.sleep(1000);
		if(checkShared().isDisplayed())				//Checking if folder gor shared or not.
			test.log(LogStatus.PASS, "Uploaded file shared.");
		else
			test.log(LogStatus.PASS, "Uploaded file does not shared.");
		
		Thread.sleep(500);
		closeSharePoppup().click();
		Thread.sleep(500);
		Thread.sleep(1000);
		readFolderName().click();	
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[5]")).click();
		Thread.sleep(3000);
	String Msg=	getDriver().switchTo().alert().getText();
	test.log(LogStatus.PASS, Msg);
	getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkMyDrive']")).click();
		Thread.sleep(3000);
		//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);   //search folder
	/*	
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_lnkEditFolder_0']")).click();
		Thread.sleep(1000);
	
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).clear();
		Thread.sleep(3000);
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).sendKeys("Automated");
		Thread.sleep(1000);
		
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCreateFolder1']")).click();
	*/	Thread.sleep(3000);
	test.log(LogStatus.PASS, "Rename Successfully");
	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);   //search folder
		test.log(LogStatus.PASS, "Filter Working Successfully");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	}

	public static void ReviseCompliance(  ExtentTest test, int no) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (20));
		Thread.sleep(1500);
		Actions action = new Actions(getDriver());
		//action.moveToElement(clickMyWorkspace1()).click().perform();
		clickMyWorkspace().click();				//Clicking on 'My Workspace'
		
		Thread.sleep(500);
		clickCompliance().click();				//Clicking on 'Compliance' under My Workspace
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@role='grid'][@data-role='selectable'])[1]")));	//Waiting for records table to get visible.
		
		clickMoreActions().click();				//Clicking on 'More Actions' drop down.
		Thread.sleep(3000);
		elementsList = selectAction();			//Clicking on drop down option
		elementsList.get(no).click();
		Thread.sleep(3000);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(readReminder()));
		
		int complianceCount = Integer.parseInt(readReminder().getText());		//Reading total number of compliances before action
				
		String compliance = null;
		if(no == 1)
		{
			compliance = "Update Penalty";
			
			action.moveToElement(clickAction()).click().perform();
			
			Thread.sleep(1000);
			clickInterest().sendKeys("100");
			
			Thread.sleep(500);
			clickPenalty().sendKeys("50000");
			
			Thread.sleep(500);
			PenaltyRemark().sendKeys("Automation Testing");
			
			Thread.sleep(500);
		}
		if(no == 2)
		{
			compliance = "Revised Compliance";
			action.moveToElement(clickAction()).click().perform();
			
			Thread.sleep(1500);
			wait.until(ExpectedConditions.elementToBeClickable(clickDate()));
			clickDate().click();								//Clicking on Revise Date.
			
			Thread.sleep(500);
			selectLastMonth().click();
			Thread.sleep(700);
			selectDate().click();								//Selecting second row fourth date.
			
			Thread.sleep(500);
			clickRemark().sendKeys("Automation Testing");		//Sending remark to Text area.
			
			Thread.sleep(4000);
			//fileUploadStatutory().sendKeys("C:/Users/sandip/Downloads/Holiday List 2022.xlsx");
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_fuSampleFile']")).sendKeys("E:\\Test Cases\\Act Sub_Industry Test Cases.xlsx");
			Thread.sleep(2000);
			String workingDir = System.getProperty("user.dir");			
			//upload1().sendKeys("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Reports\\PerformerResults.htm");	//uploading new file
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(clickSaveButton()));
		clickSaveButton().click();							//Clicking on save button
		
		Thread.sleep(1000);
		int complianceCountNew = Integer.parseInt(readReminder().getText());		//Reading total number of compliances after action
		Thread.sleep(1000);
		if(complianceCountNew < complianceCount) {
			test.log(LogStatus.PASS, compliance + " - Compliances count decreased. Old count = "+complianceCount+" | New count = "+complianceCountNew);
		}else {
			test.log(LogStatus.FAIL, compliance + " - Compliances count doesn't decreased. Old count = "+complianceCount+" | New count = "+complianceCountNew);
	}
		Thread.sleep(1000);
		if(no == 1) {
			Thread.sleep(500);
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upDocumentDownload']/div/div/div/section/div[2]/a")).click();
		}else {
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upDocumentDownload']/div/div/div[2]/section/div/div[1]/div[7]/a")).click();
		}
		test.log(LogStatus.PASS, "Back Button working Succefully ");
		Thread.sleep(2000);
		getDriver().navigate().back();
		Thread.sleep(2000);
	}

	
	
}
	
	
	
	
	




