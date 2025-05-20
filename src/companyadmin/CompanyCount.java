package companyadmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import implementation.ImplementMethods;
import login.BasePage;
import performer.MethodsPOM;

public class CompanyCount extends BasePage {

//	public static WebDriver driver = null;		//WebDriver instance created
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
	
	
	public static String link = "compayAdmin";  
	
	/*public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(12);					//Retrieving third sheet of Workbook
		return sheet;
	}*/
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\Regtrack Merge Project\\Regtrack-Project\\Reports\\Implementation.html",true);
		test = extent.startTest("Loging In - Company Admin");
		test.log(LogStatus.PASS, "Logging into system");
		
		/*XSSFSheet sheet = ReadExcel();
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
		
		initialization1(link,12,"Statutory");
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
	
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		*/
	
	}
	
	public static void progress1(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//*[@id='imgcaldate']"))));
		}
		catch(Exception e)
		{
			
		}
	}
	
	
//	@Test(priority = 1)
	void AllReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports - All Report");
		
		
		CompanyMethods.AllReport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
//	@Test(priority = 2)
	void LogReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports - Log Report");
		
		
		CompanyMethods.LogReport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 3)
	void UserLogReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports - User Log Report");
		
		
		CompanyMethods.UserLogReport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void ReassignmentExcludeReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports - Reassignment Exclude Report");
		
		CompanyMethods.ReassignmentExcludeReport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
//	@Test(priority = 4)
	void Reports() throws InterruptedException, IOException
	{
		test = extent.startTest("Reports");
		
		
		CompanyMethods.Reports(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	/*
	@Test(priority = 5)
	void Department() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Department ");
		
		
		CompanyMethods.Department(test);
		
		extent.endTest(test);
		extent.flush();
	}

 	@Test(priority = 6)
 
	void User() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - User ");
		
		
		CompanyMethods.User(test);
		
		extent.endTest(test);
		extent.flush();
	}
 	
 	
	@Test(priority = 7)
	 
	void MyCompanies() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - My Companies ");
		
		
		CompanyMethods.MyCompanies(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
 	
	@Test(priority = 8)
	void BlockScheduleStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Block Schedule Statutory  ");
		
		
		CompanyMethods.BlockScheduleStatutory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void BlockScheduleInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Block Schedule Internal  ");
		
		
		CompanyMethods.BlockScheduleInternal(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void UserDepartmentdis() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Users-Modify Assignments - Check Department Dropdown display or not");
		
		
		CompanyMethods.UserDept(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)
	void ModifyAssignmentsDepartmentdis() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Check Department Dropdown display or not");
		
		
		CompanyMethods.ModifyAssignmentsDept(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void modifyAssignmentsTask() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Reassign Statutory task ");
		
		
		CompanyMethods.modifyAssignmentsTask(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void modifyAssignmentsTaskIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Reassign Internal  task ");
		
		
		CompanyMethods.modifyAssignmentsTaskIN(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void modifyAssignmentsCom() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Statutory Compliance Reassign  ");
		
		
		CompanyMethods.modifyAssignmentsCom(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void modifyAssignmentsComEB() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Statutory Compliance Reassign - Event Based ");
		
		
		CompanyMethods.modifyAssignmentsComEB(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void modifyAssignmentsComChecklist() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Statutory Compliance Reassign - CheckList ");
		
		
		CompanyMethods.modifyAssignmentsComChecklist(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void modifyAssignmentsComIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Internal  Compliance Reassign ");
		
		
		CompanyMethods.modifyAssignmentsComIN(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18)
	void modifyAssignmentsComINChecklist() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Internal  Compliance Reassign - Checklist  ");
		
		
		CompanyMethods.modifyAssignmentsComINChecklist(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void modifyAssignmentsComExclude() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Exclude Statutory Compliance  ");
		
		
		CompanyMethods.modifyAssignmentsComExclude(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void modifyAssignmentsComExcludeEB() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments -Exclude Statutory Compliance -  Event Based ");
		
		
		CompanyMethods.modifyAssignmentsComExcludeEB(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void modifyAssignmentsComExcludeCL() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments - Exclude Statutory Compliance - Checklist ");
		
		
		CompanyMethods.modifyAssignmentsComExcludeCL(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 22)
	void modifyAssignmentsComExcludeIN() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments -Exclude Internal Compliance ");
		
		
		CompanyMethods.modifyAssignmentsComExcludeIN(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23)
	void modifyAssignmentsComExcludeINCL() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -Modify Assignments -Exclude Internal Compliance- Checklist ");
		
		
		CompanyMethods.modifyAssignmentsComExcludeINCL(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void IPAddressAddNew() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -IP Address - To check whether IP Address \"Add New\" button is functionally working or not.");
		
		
		CompanyMethods.IPAddressAddNew(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25)
	void IPAddressFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -IP Address - To check whether IP Address \"Filter\" funcationality working or not.");
		
		
		CompanyMethods.IPAddressFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26)
	void IPAddressUpload() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -IP Address - To check whether IP Address \"Upload \" funcationality working or not.");
		
		
		CompanyMethods.IPAddressUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27)
	void IPAddressSampleFormat() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -IP Address - To check whether IP Address \"Sample Format\" Dwonloaded or not ?");
		
		
		CompanyMethods.IPAddressSampleFormat(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28)
	void IPAddressEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users -IP Address - To check whether IP Address \"Edit Address Details\" functionally working or not.");
		
		
		CompanyMethods.IPAddressEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29)
	void IPAddressDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - IP Address - To check whether IP Address \"Delete\" functionally working or not.");
		
		
		CompanyMethods.IPAddressDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30)
	void IPAddressDeleteAll() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - IP Address - To check whether IP Address \"Select All Checkbox \" functionally working or not.");
		
		
		CompanyMethods.IPAddressDeleteAll(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void IPAddressExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - IP Address - To Check Whether IP Address Page \"Export to Excel \" Button Working or not ?");
		
		
		CompanyMethods.IPAddressExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)
	void IPAddressAddNewWD() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - IP Address - To Check Whether IP address Add New Popup without Entering Data Click on \"Save \" Button  validation message display or not ?");
		
		
		CompanyMethods.IPAddressAddNewWD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)
	void SecurityGroup() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Security Group - To check whether Security Group \"Add New\" button functionally working or not?");
		
		
		CompanyMethods.SecurityGroup(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34)
	void SecurityGroupFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Security Group - To check whether Security Group master \"Filter\" funcationality working or not.");
		
		
		CompanyMethods.SecurityGroupFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35)
	void SecurityGroupEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Security Group - To check whether Security Group Master \"Edit Security Group Details\" functionally working or not.");
		
		
		CompanyMethods.SecurityGroupEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36)
	void SecurityGroupDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Security Group - To check whether Security Group master \"Delete Security Group Details\" functionally working or not.");
		
		
		CompanyMethods.SecurityGroupDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void SecurityGroupAdd() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Security Group - To Check Whether security Group Master add New Popup Validation Message display or not ?");
		
		
		CompanyMethods.SecurityGroupAdd(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38)
	void Fortnightlycompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - FortNightly Compliance Document - Statutory and internal document downloaded or not.");
		
		
		CompanyMethods.Fortnightlycompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	@Test(priority = 39)
	void EventAssignments() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event Assignments");
		
		
		CompanyMethods.EventAssignments(test);
		
		extent.endTest(test);
		extent.flush();
	}
		
	@Test(priority = 40)
	void Eventassignmentexportimport() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event - Export");
		
		
		CompanyMethods.Eventassignmentexportimport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority =41)
	void EventassignmentexportimportValidation() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event - Export");
		
		
		CompanyMethods.EventassignmentexportimportValidation(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 42)
	void ImportBlankScript() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.ImportBlankScript(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 43)
	void ImportInvalidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.ImportInvalidSheet(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 44)
	void ImportValidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.ImportValidSheet(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45)
	void UploadedFileisplay() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event -Import");
		
		
		CompanyMethods.UploadedFileisplay(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void UploadedFileisplayEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance - Export ");
		
		
		CompanyMethods.UploadedFileisplayEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 47)
	void DownloadEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance - Export ");
		
		
		CompanyMethods.DownloadEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48)
	void InValidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance - Import");
		
		
		CompanyMethods.InValidSheet(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49)
	void ValidSheetEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance - Import ");
		
		
		CompanyMethods.ValidSheetEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50)
	void ValidationEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Events - Event assignment export import -Event Compliance - Import");
		
		
		CompanyMethods.ValidationEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	
	@Test(priority = 51)
	void ComplianceFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances - Masters - Compliances - To Check whether filters of \"Compliance\"  working or not");
		
		
		CompanyMethods.ComplianceFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 52)
	void Acts() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Acts  ");
		
		
		CompanyMethods.Acts(test);
		
		extent.endTest(test);
		extent.flush();
	}
	 
	@Test(priority = 53)
	void ComplianceCategoriesFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Compliances category - To Check whether  compliance category master page Filters working or not");
		
		
		CompanyMethods.ComplianceCategoriesFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 54)
	void ComplianceTypeFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Masters - Compliances Type - To Check whether  compliance Type master page Filters working or not");
		
		
		CompanyMethods.ComplianceTypeFilter(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 55)
		void WidgetMaster() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Compliances - Masters - Widget Master  ");
			
			
			CompanyMethods.WidgetMaster(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 56)
	void WidgetMasterSF() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances - Masters - Widget Master - To Check whether widget Details Uploaded or not? ");
		
		
		CompanyMethods.WidgetMasterSF(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 57)
	void AssignComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances -Compliance Assignment -Compliance Assignment - To Check whether On Compliance Assigment funcationality is working or not? ");
		
		
		CompanyMethods.ComplianceAssignment(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 58)
	void IntermediateComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances - Compliance Assignment - Intermediate Assignment - To Check whether On Intermediate Assignment funcationality is working or not? ");
		
		
		CompanyMethods.IntermediateComplianceCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 59)
	void ActivateComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances - Compliance Assignment - Activate Assignment - To Check whether On Activate Assignment funcationality is working or not? ");
		
		
		CompanyMethods.ActivateComplianceCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 60)
	void ComplianceMappingCopy() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances - Compliance Assignment - Compliance Mapping Copy - To Check whether Compliance Mapping Copy funcationality is working or not? ");
		
		
		CompanyMethods.ComplianceMappingCopy(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 61)
	void AssignCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Checklist Assignment - Assign CheckList");
		
		CompanyMethods.AssignCheckListCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 62)
	void IntermediateCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Checklist Assignment - Intermediate CheckList");
		
		CompanyMethods.IntermediateCheckListCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 63)
	void ActivateCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Checklist Assignment - Activate CheckList");
		
		CompanyMethods.ActivateCheckListCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 64)
	void ReOpeningofCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances -  Configuration - Re-Opening of Compliance");
		
		
		CompanyMethods.ReOpeningofCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65)
	void ClientComplianceRiskMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Configuration - Change Risk of Compliance ");
		
		
		CompanyMethods.ClientComplianceRiskMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 66)
	void ClientFrequencyMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Configuration - Client based checklist compliance frequency mapping");
		
		
		CompanyMethods.ClientFrequencyMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 67)
	void Targetdate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Target date");
		
		
		CompanyMethods.Targetdate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 68)
	void DocumentNotApplicable() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Client Specific Configuration - Document Not Applicable");
		
		
		CompanyMethods.DocumentNotApplicable(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 69)
	void DepartmentReassignmentExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Configuration - Department Reassignment - To check whether the Export button is working or not ");
		
		
		CompanyMethods.DepartmentReassignmentExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 70)
	void DepartmentReassignmentUpload() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Compliances- Configuration - Department Reassignment - To check whether the Upload button is working or not ");
		
		
		CompanyMethods.DepartmentReassignmentUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 69)
		void EntitiesAssignmentsMC() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Entities Assignment - Entities Assignments");
			
			CompanyMethods.EntitiesAssignmentsMC(test);
			
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority = 70)
	void DepartmentEntitiesAssignmentsMC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Department Entities Assignments- License Entities Assignments");
		
		
		CompanyMethods.DepartmentEntitiesAssignmentsMC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 71)
		void LicenseEntitiesAssignmentsMC() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Entities Assignment - License Entities Assignments");
			
			
			CompanyMethods.LicenseEntitiesAssignmentsMC(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 71)
		void UsageReport() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances - Report - Usage Report");
			
			
			CompanyMethods.UsageReport(test);
			
			extent.endTest(test);
			extent.flush();
		}
*/
//		@Test(priority = 71)
		void LicenceList() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances - Report - Licence List");
			
			
			CompanyMethods.LicenceList(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		/*
	@Test(priority = 72) 
    void WhatsNew() throws InterruptedException, IOException
			{
				test = extent.startTest("' what's New ' Verification");
				
				MethodsPOM.WhatsNew(test);
				
				extent.endTest(test);
				extent.flush();
			}
    
	@Test(priority = 73) 
    void EditCompliances() throws InterruptedException, IOException
			{
				test = extent.startTest("Internal Compliances - Edit Compliances");
				
				CompanyMethods.EditCompliances(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 74) 
			void AssignComplianceInternal() throws InterruptedException, IOException
			{
				test = extent.startTest("Internal Compliances - Assign Compliance ");
				
				CompanyMethods.AssignComplianceInternal(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			
	*/
//		@Test(priority = 74) 
		void UploadInternalData() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances - Upload Internal Data ");
			
			CompanyMethods.UploadInternalData(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 74) 
		void LicenseEntitiesAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances - License Entities Assignments ");
			
			CompanyMethods.LicenseEntitiesAssignment(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 74) 
		void EntitiesAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances -  Entities Assignments ");
			
			CompanyMethods.EntitiesAssignment(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 74) 
		void UploadAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances -  Upload Assignment ");
			
			CompanyMethods.UploadAssignment(test);
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 74) 
		void ActivateChecklist() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances -  Activate Checklist ");
			
			CompanyMethods.ActivateChecklist(test);
			
			extent.endTest(test);
			extent.flush();
		}
		/*
		@Test(priority = 74) 
		void ComplianceAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances - Compliance Assignment ");
			
			CompanyMethods.ComplianceAssignments(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 74) 
		void Compliance() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances - Compliance ");
			
			CompanyMethods.Compliance(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 74) 
		void ComplianceAddnewlink() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances - Compliance ");
			
			CompanyMethods.ComplianceAddnewlink(test);
			
			extent.endTest(test);
			extent.flush();
		}
		*/
		
	@AfterMethod
  	void browserClosing() throws InterruptedException
  	{
		closeBrowser();
  		Thread.sleep(1000);
  		
  	}	
	
	
	
	
	
}
