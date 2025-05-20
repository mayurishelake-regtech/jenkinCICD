package reviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ReviewerPOM extends BasePage
{
	private static WebElement statutoryReview = null;		//WebElement variable created for clicking on value of Statutory 'Pending for Review'
	private static WebElement statutoryAction = null;		//WebElement variable created for clicking on Action button.
	private static WebElement download = null;				//WebElement variable created for clicking on 'Download' link.
	private static WebElement view = null; 					//WebElement variable created for clicking on 'View' link.
	private static WebElement closeView = null;				//WebElement variable created for clicking on Close View cross button.
	private static WebElement closedDelay = null;			//WebElement variable created for clicking on Closed-Delayed radio button.
	private static WebElement closedTimely = null;			//WebElement variable created for clicking on Closed-Timely radio button.
	private static WebElement checkBox = null;				//WebElement variable created for clicking on Checkbox
	private static WebElement liability1 = null;			//WebElement variable created for inserting Liability as per system
	private static WebElement liability2 = null;			//WebElement variable created for inserting Liability as per return
	private static WebElement liability3 = null;			//WebElement variable created for inserting Liability paid
	private static WebElement textArea = null;				//WebElement variable created for inserting Remark
	private static WebElement approve = null;				//WebElement variable created for clicking on Approve button
	private static WebElement reject = null;				//WebElement variable created for clicking on Reject button
	private static WebElement statutoryRejectValue = null;	//WebElement variable created for reading Statutory Reject value 
	private static WebElement dashboard = null;				//WebElement variable created for clicking on dashboard link
	private static WebElement internalReview = null;		//WebElement variable created for clicking on value of Internal 'Pending For Review'
	private static WebElement closeViewInternal = null;		//WebElement variable created for clicking on Close View cross button.
	private static WebElement closedTimelyInternal = null;	//WebElement variable created for clicking on Closed-Timely radio button.
	private static WebElement textAreaInternal = null;		//WebElement variable created for inserting Remark for Internal click Text area
	private static WebElement internalRejectValue = null;	//WebElement variable created for reading Internal Reject value.
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	private static WebElement AdavanceSearch = null;		//WebElement variable created for clicking on value of Statutory 'Pending for Review'

	public static WebElement ComplainceInternalReviewer()
	{
		statutoryReview = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalReviewer']/div/div/div[1]/button"));
		return statutoryReview;
	}
	
	public static WebElement clickStatutoryReview()		//Method for searching Statutory Review value element.
	{
		statutoryReview = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyReviewerPendingforReviewercount']"));
		return statutoryReview;
	}
	
	public static WebElement clickAction()			//Method for searching action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//div[@id='grid']/div[4]/table/tbody/tr[1]/td[17]/a"));	//XPath for clicking third action button  
		return statutoryAction;
	}
	
	public static WebElement clickAdavanceSearch()			//Method for searching action button
	{
		AdavanceSearch = getDriver().findElement(By.xpath("//*[@id='AdavanceSearch']"));	//XPath for clicking third action button  
		return AdavanceSearch;
	}
	
	public static WebElement clickAction1()			//Method for searching action button
	{
		statutoryAction = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]"));	//XPath for clicking first action button  
		return statutoryAction;
	}
	public static WebElement clickActionPFR()			//Method for searching action button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskReviewer_btnChangeStatusReviewer_0']"));	//XPath for clicking first action button  
		return statutoryAction;
	}
	public static List<WebElement> clickAction2()			//Method for searching action button
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr/td[24]/a[1]"));	//XPath for clicking first action button  
		return elementsList;
	}
	//*[@class='k-button k-button-icontext ob-overview k-grid-edit2'])[1]
	public static List<WebElement> clickActions()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-edit2']"));
		return elementsList;
	}
	
	public static WebElement clickDownload()		//Method searching Download link
	{
		download = getDriver().findElement(By.linkText("Download"));
		return download;
	}
	
	public static WebElement CloseAS()		//Method searching Download link
	{
		download = getDriver().findElement(By.linkText("/html/body/div[35]/div[1]/div/a"));
		return download;
	}
	
	public static WebElement clickDownload1()		//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//*[@id = 'rptComplianceVersion_lblpathDownload_0']"));
		return download;
	}
	
	public static WebElement clickDownload1Document()		//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//a[@id='rptComplianceDocumnets_lblCompDocpathDownload_0']"));
		return download;
	}
	
	public static WebElement clickDownload2()				//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//*[@id = 'rptComplianceVersion_btnComplinceVersionDoc_0']"));
		return download;
	}
	
	public static WebElement clickDownloadInternal1()		//Method searching Download link
	{
		download = getDriver().findElement(By.xpath("//*[@id='rptComplianceVersion3_btnComplinceVersionDoc1_0']"));
		return download;
	}
	
	public static WebElement clickView()			//Method for searching View link
	{
		view = getDriver().findElement(By.linkText("View"));
		return view;
	}
	
	public static WebElement clickView1()			//Method for searching View link
	{
		view = getDriver().findElement(By.xpath("//a[@id='rptComplianceVersion_lnkViewDoc_0']"));
		return view;
	}
	
	public static WebElement clickCloseView()		//Method for searching Close View cross
	{
		closeView = getDriver().findElement(By.xpath("//div[@id='DocumentReviewPopUp1']/div/div/div[1]/button"));
		return closeView;
	}
	
	public static WebElement clickCloseView1()		//Method for searching Close View cross
	{
		closeView = getDriver().findElement(By.xpath("//div[@id='DocumentPopUpSampleForm']/div/div/div[1]/button"));
		return closeView;
	}
	
	public static WebElement clickCloseViewInternal()	//Method for searching Internal Close View cross 
	{
		closeViewInternal = getDriver().findElement(By.xpath("//div[@id='DocumentReviewPopUp']/div/div/div[1]/button"));
		return closeViewInternal;
	}
	
	public static WebElement clickCloseViewInternal1()	//Method for searching Internal Close View cross 
	{
		closeViewInternal = getDriver().findElement(By.xpath("//*[@id='modalDocumentReviewerViewerInternal']/div/div/div[1]/button"));
		return closeViewInternal;
	}
	
	public static WebElement clickClosedDelayed()		//Method searching Closed-Delayed radio button
	{
		closedDelay = getDriver().findElement(By.xpath("//*[@id = 'rdbtnStatus1_0']"));
		return closedDelay;
	}
	
	public static WebElement clickClosedTimely()		//Method for searching Closed-Timely radio button
	{
		closedTimely = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus1']/tbody/tr/td[2]/label"));
		return closedTimely;
	}
	public static WebElement clickClosedTimelyPFRTask()		//Method for searching Closed-Timely radio button
	{
		closedTimely = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus']/tbody/tr/td[2]/label"));
		return closedTimely;
	}
	public static WebElement clickClosedTimelyAS()		//Method for searching Closed-Timely radio button
	{
		closedTimely = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus1_1']"));
		return closedTimely;
	}
	
	public static WebElement clickDownloadAS()		//Method for searching Closed-Timely radio button
	{
		closedTimely = getDriver().findElement(By.xpath("//*[@id='rptComplianceVersion_btnComplinceVersionDoc_0']"));
		return closedTimely;
	}
	
	public static WebElement clickInternalDownloadAS()		//Method for searching Closed-Timely radio button
	{
		closedTimely = getDriver().findElement(By.xpath("(//*[@id='rptComplianceVersion3_btnComplinceVersionDoc1_0'])"));
		return closedTimely;
	}
	
	
	public static WebElement clickClosedTimelyInternal()	//Method for closing View opened in Internal View
	{
		closedTimelyInternal = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus3_1']"));
		return closedTimelyInternal;
	}
	
	public static WebElement clickCheckBox()			//Method for searching check box
	{
		checkBox = getDriver().findElement(By.xpath("//*[@id='chkPenaltySaveReview']"));
		return checkBox;
	}
	
	public static WebElement insertLiability1()			//Method for searching Liability for System text box
	{
		liability1 = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerSystem']"));
		return liability1;
	}
	
	public static WebElement insertLiability2()			//Method for searching Liability for return text box
	{
		liability2 = getDriver().findElement(By.xpath("//input[@id='txtValueAsPerReturn']"));
		return liability2;
	}
	
	public static WebElement insertLiability3()			//Method for searching Liability Paid text box
	{
		liability3 = getDriver().findElement(By.xpath("//input[@id='txtLiabilityPaid']"));
		return liability3;
	}
	
	public static WebElement insertTextArea()			//Method for searching text area
	{
		textArea = getDriver().findElement(By.xpath("//*[@id='tbxRemarks1']"));
		return textArea;
	}
	public static WebElement insertTextArea1()			//Method for searching text area
	{
		textArea = getDriver().findElement(By.xpath("//*[@id='tbxRemarks']"));
		return textArea;
	}
	public static WebElement insertTextAreaInternal()	//Method for searching Internal text area
	{
		textAreaInternal = getDriver().findElement(By.xpath("//textarea[@id='tbxRemarks3']"));
		return textAreaInternal;
	}
	
	public static WebElement clickApprove()				//Method for searching Approve button
	{
		approve = getDriver().findElement(By.xpath("//input[@value='Approve']"));
		return approve;
	}
	
	public static WebElement clickReject()				//Method searching Reject button
	{
		reject = getDriver().findElement(By.xpath("//input[@value='Reject']"));
		return reject;
	}
	public static WebElement clickSubmit()				//Method searching Reject button
	{
		reject = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
		return reject;
	}
	public static WebElement readStatutoryReject()		//Method for searching Statutory Reject button to read statutory value  
	{
		statutoryRejectValue = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyRejectedcount']"));
		return statutoryRejectValue;
	}
	
	public static WebElement clickDashboard()			//Method for searching 'My Dashboard' link
	{
		dashboard = getDriver().findElement(By.linkText("My Dashboard "));
		return dashboard;
	}
	
	public static WebElement clickInternalReview()		//Method for searching Internal Review value element.
	{
		internalReview = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyReviewerPendingforReviewerInternalcount']"));
		return internalReview;
	}
	
	public static WebElement readInternalReject()
	{
		internalRejectValue = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyRejectedInternalcount']"));
		return internalRejectValue;
	}
	
	public static List<WebElement> clickStatus() 		//Method to get list of action buttons on web page
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(text(),'Status')][@class='k-link']"));
		return elementsList;
	}
	
	public static WebElement clickLastPage()			//Searching Last Page arrow button
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@title='Go to the last page']"));
		return statutoryAction;
	}
	
	public static WebElement InterimApproveRadio()		//Searching radio button for Interim Approve
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='rdbtnStatus1_0']"));
		return statutoryAction;
	}
	
	public static WebElement clickMyEscalation()		//Searching 'My Escalation' link
	{
		statutoryAction = getDriver().findElement(By.linkText("My Escalation"));
		return statutoryAction;
	}
	
	public static WebElement clickShowDropdown()		//Clicking on Show dropdown
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlPageSize']"));
		return statutoryAction;
	}
	
	public static WebElement checkEscalationTable()		//Searching records table to check visibility
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdReviewerComplianceDocument']"));
		return statutoryAction;
	}
	
	public static List<WebElement> clickWorkFileText()	//Searching all 'Work File Timeline' text boxes
	{
	//	elementsList = getDriver().findElements(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr/td[9]/input"));
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[11]/input"));
		return elementsList;
	}
	
	public static List<WebElement> clickOverView()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[26]/a"));
		return elementsList;
	}
	
	public static List<WebElement> clickOverView1()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[26]/a[2]"));
		return elementsList;
	}
	
	
	public static List<WebElement> clickOverViewAEPer()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]/a[2]"));
		return elementsList;
	}
	
	public static List<WebElement> clickOverViewE()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[9]/a[2]"));
		return elementsList;//*[@id="grid"]/div[3]/table/tbody/tr[1]/td[7]/a
	}//*[@id="grid"]/div[3]/table/tbody/tr[1]/td[9]/a[2]
	
	public static List<WebElement> clickOverViewAE()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[7]/a"));
		return elementsList;
	}
	
	public static List<WebElement> clickOverViewPer()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a[2]"));
		return elementsList;
	}
	
	public static List<WebElement> clickOverViewCE()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[8]/a"));
		return elementsList;
	}
	
	public static List<WebElement> clickOverViewPerCE()	//Searching all 'Work File Timeline' text boxes
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[8]/a"));
		return elementsList;
	}
	
	public static List<WebElement> clickEscalationText()	//Searching all 'Escalation' text boxes
	{
		//elementsList = getDriver().findElements(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr/td[10]/input"));
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[12]/input"));
		return elementsList;
	}
	
	public static WebElement loadNextPage()				//Searching Next Page load button.
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lBNext']"));
		return statutoryAction;
	}
	
	public static List<WebElement> getAllButtons()		//Searching all 'Action' buttons
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return elementsList;
	}
	
	public static WebElement clickFirstAction()		//Searching all 'Action' buttons
	{
		statutoryAction = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit' and not(@disabled)])[1]"));
		return statutoryAction;
	}
	//*[@class = 'k-checkbox-label k-no-text']
	public static WebElement clickUpdate()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@class='k-button k-button-icontext k-primary k-grid-update']"));
		return statutoryAction;
	}
	
	public static WebElement CloseOverview()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement CloseOverview1()
	{
		statutoryAction = getDriver().findElement(By.cssSelector("a[aria-label='Close']"));
		return statutoryAction;
	}
	
	
	public static WebElement ReadCount()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid']/div[5]/span[2]"));
		return statutoryAction;
	}
	
	public static WebElement ReadCount1()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid1']/div[4]/span[2]"));
		return statutoryAction;
	}
	
	public static WebElement ReadCountEvent()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/span[2]"));
		return statutoryAction;
	}
	//*[@id="grid1"]/div[4]/span[2]
	public static WebElement CalendarDownload()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='export']"));
		return statutoryAction;
	}
	
	public static WebElement ReopenAS()
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid1']/div[3]/table/tbody/tr[1]/td[24]/a[5]"));
		return statutoryAction;
	}
	
	
	public static List<WebElement> clickCheckboxes()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[1]"));
	//	elementsList = getDriver().findElements(By.xpath("//*[@class='k-checkbox-label k-no-text']"));
		return elementsList;                          
	}
	
	public static WebElement clickSaveButton()			//Searching drop down of User to Assign
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id = 'btnsave']"));
		return statutoryAction;
	}
	
	public static WebElement clickRisk()			//Searching drop down of User to Assign
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div[2]"));
		return statutoryAction;
	}
	
	public static WebElement clickCritical()			//Searching drop down of User to Assign
	{
		statutoryAction = getDriver().findElement(By.xpath("(//li[@class='k-item k-first'])[1]"));
		return statutoryAction;
	}
	
	public static WebElement clickClear()			//Searching drop down of User to Assign
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return statutoryAction;
	}
	
	
	public static WebElement selectUserAssign()			//Searching drop down of User to Assign
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlNewUsers']"));
		return statutoryAction;
	}
	
	public static WebElement readAssignedUser()			//Searching name of user assigned in first row.
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdComplianceInstances_lbluser_0']"));
		return statutoryAction;
	}
	
	public static WebElement clickFirstCheckbox()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdComplianceInstances_chkCompliances_0']"));
		return statutoryAction;
	}
	
	public static WebElement ClickReviewerTaskPFRStatutory()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerPendingReviewStat']"));
		return statutoryAction;
	}
	
	public static WebElement ClickReviewerTaskPFRInternal()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerPendingReviewInt']"));
		return statutoryAction;
	}
	
	public static WebElement ClickReviewerTaskPFRStatutoryPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerPendingReviewStat']"));
		return statutoryAction;
	}
	
	public static WebElement ClickReviewerTaskPFRInternalPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerPendingReviewInt']"));
		return statutoryAction;
	}
	
	public static WebElement ClickReviewerTaskRejectStatutoryPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerRejectedStat']"));
		return statutoryAction;
	}
	
	public static WebElement ClickReviewerTaskRejectInternalPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerRejectedInt']"));
		return statutoryAction;
	}
	
	public static WebElement ReviewerTaskDBNSStatutory()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerDueNotSubStat']"));
		return statutoryAction;
	}
	
	public static WebElement ReviewerTaskDBNSStatutoryPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerDueNotSubStat']"));
		return statutoryAction;
	}
	
	public static WebElement ReviewerTaskDBNSInternal()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerDueNotSubInt']"));
		return statutoryAction;
	}
	
	public static WebElement ReviewerTaskDBNSInternalPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivReviewerDueNotSubInt']"));
		return statutoryAction;
	}
	
	public static WebElement Clickclose()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ComplainceReviewer1']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement ClickINclose()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ComplainceInternalReviewer1']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement ClickCompletedSta()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyCompletedcount']"));
		return statutoryAction;
	}
	
	public static WebElement ClickCompletedIn()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyCompletedInternalcount']"));
		return statutoryAction;//*[@id="grid"]/div[4]/table/tbody/tr[1]/td[25]/a[5]
	}
	
	public static WebElement ClickOverdueSta()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyDueButNotSubmittedcount']"));
		return statutoryAction;
	}
	
	public static WebElement ClickOverdueIn()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyDueButNotSubmittedInternalcount']"));
		return statutoryAction;
	}
	
	public static WebElement ClickRejectedSta()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyRejectedcount']"));
		return statutoryAction;
	}
	
	public static WebElement ClickRejectedIn()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRevieweronlyRejectedInternalcount']"));
		return statutoryAction;
	}
	
	public static WebElement ClickEvents()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divOverdueEventReviewer']"));
		return statutoryAction;
	}
	
	public static WebElement ClickActivatedEvents()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActivatedEventReviewer']"));
		return statutoryAction;
	}
	
	public static WebElement ClickClosedEvents()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedEventReviewer']"));
		return statutoryAction;
	}
	
	public static WebElement ClickClosedEventsPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divClosedEventPEOcount']"));
		return statutoryAction;
	}
	
	
	public static WebElement closeAS()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
		return statutoryAction;
	}
	
	public static WebElement sledtre()					//
	{
		statutoryAction = getDriver().findElement(By.xpath(""));
		return statutoryAction;
	}
	
	public static WebElement EventID()				//
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='txtSearchEventID']"));
		return statutoryAction;
	}
	
	public static WebElement EntitySubEntity()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/div/span[1]"));
		return statutoryAction;
	}
	
	public static WebElement EntitySubEntityE()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div[2]/div[1]/div/span[1]"));
		return statutoryAction;
	}
	
	public static WebElement EntitySubEntityR()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/div/div[1]/div/span[1]"));
		return statutoryAction;
	}
	
	
	public static WebElement MitigationPlan()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='example']/div[2]/span[5]/span/span[2]"));
		return statutoryAction;
	}

	public static WebElement MitigationPlan1()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='dropdownlistMplan_listbox']/li[3]"));
		return statutoryAction;
	}
	
	public static WebElement Apply()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return statutoryAction;
	}
	
	public static WebElement MyEscalation ()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='leftescalationmenu']/a"));
		return statutoryAction;
	}
	
	
	public static WebElement MitigationPlanVD ()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grid']/div[4]/table/tbody/tr[1]/td[23]/a[3]"));
		return statutoryAction;
	}
	
	public static WebElement MPDownload()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grdDocument_lnkDownloadDocument_0']/img"));
		return statutoryAction;
	}
	
	public static WebElement ViewDoc()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='grdDocument_lnkViewDocument_0']/img"));
		return statutoryAction;
	}
	
	public static WebElement CloseViewDoc()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='DocumentPriview']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement CloseMp()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='divMitigationCompliance']/div/div/div[1]/button"));
		return statutoryAction;
	}
	
	public static WebElement GridCount()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return statutoryAction;
	}
	
	public static WebElement NoRecord()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskReviewer']/tbody/tr[2]/td"));
		return statutoryAction;
	}
	public static WebElement NoRecord1()				
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdTaskPerformer']/tbody/tr[2]/td"));
		return statutoryAction;
	}
	
	public static WebElement ClickUpcomingStatutoryPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerUpcomingStat']"));
		return statutoryAction;
	}
	
	public static WebElement ClickUpcomingInternalPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerUpcomingInt']"));
		return statutoryAction;
	}
	
	public static WebElement ClickOverdueStatutoryPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerOverdueStat']"));
		return statutoryAction;
	}
	
	public static WebElement ClickOverdueInternalPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerOverdueInt']"));
		return statutoryAction;
	}
	
	public static WebElement ClickRejectedStatutoryPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerRejectedStat']"));
		return statutoryAction;
	}
	
	public static WebElement ClickRejectedInternalPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerRejectedInt']"));
		return statutoryAction;
	}
	
	public static WebElement ClickPendingForReviewStatutoryPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerPendingReviewStat']"));
		return statutoryAction;
	}
	
	public static WebElement ClickPendingForReviewInternalPer()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivPerformerPendingReviewInt']"));
		return statutoryAction;
	}
	
	public static WebElement User()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='example']/div[1]/span[1]/span/span[2]/span"));
		return statutoryAction;
	}
	
	public static WebElement User1()		//Searching first checkbox
	{
		statutoryAction = getDriver().findElement(By.xpath("//*[@id='dropdownlistUserRole_listbox']/li[2]"));
		return statutoryAction;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}