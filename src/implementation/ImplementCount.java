package implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import companyadmin.CompanyMethods;
import login.BasePage;

public class ImplementCount extends BasePage{
	
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
	
	public static String link = "Shivraj";  

/*	public static XSSFSheet ReadExcel() throws IOException
	{
		fis = new FileInputStream("E:\\Regtrack Merge Project\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(13);					//Retrieving third sheet of Workbook
		return sheet;
	}
	*/
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("E:\\Regtrack Merge Project\\Regtrack-Project\\Reports\\Implementation.html",true);
		test = extent.startTest("Loging In - Implementation");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		
		initialization(link,13,"Statutory");
	//	test = extent.startTest("Loging In - Implementation ");
	//	test.log(LogStatus.PASS, "Test Passed");
	/*	XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);	
	//	XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		 c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		*/
		
		//extent.endTest(test);
	//	extent.flush();
	}
	
	public static void progress1()
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
	
	/*
	@Test(priority = 2)
	void CustomersCreate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Users - Customers Create");
		
		ImplementMethods.CreateCustomers(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3) 
	void CustomersAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Users - Customers Assignment");
		
		ImplementMethods.CustomersAssignment(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void SubEntity() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Sub Entity");
		
		ImplementMethods.SubEntity(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void Department() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Department");
		
		ImplementMethods.Department(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void Users() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Users");
		
		ImplementMethods.Users(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 7) //not run
	void UsersandBranchUpload() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Users");
		
		
		ImplementMethods.UserandBranchUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ProductMapping() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Product Mapping");
		
		ImplementMethods.productMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void ModifyAssignmentsR() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Modify Assignments - Reassign");
		
		ImplementMethods.modifyAssignmentsReassign(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void ModifyAssignmentsExclude() throws InterruptedException, IOException
	{
		test = extent.startTest("Manage Users - Modify Assignments - Exclude");
	
		ImplementMethods.modifyAssignmentsExclude(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11) 
	void ModifyAssignmentsTask() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Users - Modify Assignments - Task");
		
		ImplementMethods.modifyAssignmentsTask(test);
		
		extent.endTest(test);
		extent.flush();
	}

//	@Test(priority = 12)//not present
	void UsageReportCustomer() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Usage Report Customer");
		
		ImplementMethods.UsageReportCustomer(test,"Usage Report Customer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void UsageReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Usage Report ");
		
		
		ImplementMethods.UsageReport(test,"Usage Report ");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void StatutoryAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Other Reports - Statutory Assignment Report ");
		
		
		ImplementMethods.StatutoryAssignmentReport(test,"Statutory Assignment Report ");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void CheckListAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -  Other Reports  - CheckList Assignment Report  ");
	
		ImplementMethods.CheckListAssignmentReport(test,"CheckList Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void EventBasedAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - EventBased Assignment Report   ");
	
		
		ImplementMethods.EventBasedAssignmentReport(test,"EventBased Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void InternalAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - Internal Assignment Report   ");
		
		
		ImplementMethods.InternalAssignmentReport(test,"Internal Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 18)
	void InternalCheckListAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - Internal CheckList Assignment Report   ");
		
		ImplementMethods.InternalCheckListAssignment(test,"Internal CheckList Assignment Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void StatutoryLabelReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Other Reports - Statutory Label Report ");
		
		
		ImplementMethods.StatutoryLabelReport(test,"Statutory Label Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void InternalLabelReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports - Internal Label Report ");
		
		
		ImplementMethods.InternalLabelReport(test,"Internal Label Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void AllReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - All Report ");
		
		ImplementMethods.AllReport(test,"All Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22)
	void LogReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - log Report ");
	
		ImplementMethods.LogReport(test,"log Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//@Test(priority = 22) //not present 
	void CompliaceCountReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Compliace Count Report ");
		
		
		ImplementMethods.CompliaceCountReport(test,"Compliace Count Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 23)
	void ComplianceActivation() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Assign Compliance ");
		
		
		ImplementMethods.AssignCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void IntermediateCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Intermediate Compliance ");
		
		
		ImplementMethods.IntermediateCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25)
	void ActivateCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances- Compliance Activation -Activate Compliance  ");
		
		
		ImplementMethods.ActivateCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26)
	void AssignCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Assign CheckList");
		
		
		ImplementMethods.AssignCheckList(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27)
	void IntermediateCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Compliance Activation - Intermediate CheckList ");
	
		ImplementMethods.IntermediateCheckList(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28)
	void ActivateCheckList() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Compliance Activation -Activate CheckList  ");
		
		
		ImplementMethods.ActivateCheckList(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 29)
	void ComplianceCategory() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Compliances - Masters - Compliance Category  ");
		
		ImplementMethods.ComplianceCategory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 30)
	void Compliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Masters - Compliances");
		
		ImplementMethods.Compliances(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 31)
	void EditCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Masters - Edit Compliances");
		
		ImplementMethods.EditCompliances(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)
	void UploadAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Upload Utility - Upload Assignment");
		
		ImplementMethods.UploadAssignment(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33)
	void PreviousInternalComplianceDepartmentMapping () throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Upload Utility - Previous Internal Compliance Department Mapping");
		
		ImplementMethods.PreviousInternalComplianceDepartmentMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34)
	void EntitiesAssignments () throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances -Entities Assignments - Entities Assignments");
		
		ImplementMethods.EntitiesAssignments(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35)
	void LicenseEntitiesAssignments() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances -Entities Assignments -License Entities Assignments");
		
		ImplementMethods.LicenseEntitiesAssignments(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36)
	void MasterCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances- Masters - Compliances ");
		
		ImplementMethods.MasterCompliances(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void Acts() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters - Acts ");
		
		ImplementMethods.Acts(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38)
	void HolidayMaster() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters - Holiday Master ");
		
		ImplementMethods.HolidayMaster(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 39)
	void WidgetMaster() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters - Widget Master ");
		
		ImplementMethods.WidgetMaster(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 40)
		void UsersDeptDisplay() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage User - User - Modify Assignments");
			
			
			ImplementMethods.UsersDeptDisplay(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
//	@Test(priority = 41)
	void UploadInternalCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Internal Compliances - Upload Utility - Upload Internal Compliance");
		
		ImplementMethods.UploadInternalCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 42) //not run
	void UploadAssignmentUU() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Upload Utility - Upload Assignment");
		
		ImplementMethods.UploadAssignmentUU(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 43)//not run
	void UploadEventBasedComplianceAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Upload Utility - Upload Event  Based Compliance Assignment");
		
		ImplementMethods.UploadEventBasedComplianceAssignment(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 44)
	void UploadAssignmentAll() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Upload Utility - Upload Assignment All");
		
		ImplementMethods.UploadAssignmentAll(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45)
	void AssignComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Assign Compliance");
		
		ImplementMethods.AssignComplianceCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void IntermediateComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Intermediate Compliance");
		
		ImplementMethods.IntermediateComplianceCA(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 47)
	void ActivateComplianceCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Activate Compliance");
		
		ImplementMethods.ActivateComplianceCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48)
	void AssignCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment -Assign CheckList");
		
		ImplementMethods.AssignCheckListCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49)
	void IntermediateCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Intermediate CheckList");
		
		ImplementMethods.IntermediateCheckListCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50)
	void ActivateCheckListCA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Compliance Assignment - Activate CheckList");
		
		ImplementMethods.ActivateCheckListCA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 51)
	void EntitiesAssignmentsMC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Entities Assignment - Entities Assignments");
		
		ImplementMethods.EntitiesAssignmentsMC(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 52)
	void LicenseEntitiesAssignmentsMC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Entities Assignment - License Entities Assignments");
		
		
		ImplementMethods.LicenseEntitiesAssignmentsMC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 53)
	void DaysBeforeDueDate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Days Before Due Date");
		
		
		ImplementMethods.DaysBeforeDueDate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 54)
	void ReOpeningofCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Re-Opening of Compliance");
		
		
		ImplementMethods.ReOpeningofCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 55)
	void BlockScheduleInternal() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Block Schedule Internal");
		
		
		ImplementMethods.BlockScheduleInternal(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 56)
	void BlockScheduleStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Block Schedule Statutory ");
		
		
		ImplementMethods.BlockScheduleStatutory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 57)
	void DocumentMandatoryNonMandatory() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Document Mandatory Non Mandatory ");
		
		
		ImplementMethods.DocumentMandatoryNonMandatory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 58)  //not present
	void StartDateChange() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Start Date Change ");
		
		
		ImplementMethods.StartDateChange(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 59) //not present
	void ChangeDueDate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration - Change Due Date");
		
		
		ImplementMethods.ChangeDueDate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 60)
	void CertificateFrequencyMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Certificate Frequency Mapping");
		
		
		ImplementMethods.CertificateFrequencyMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 61)
	void ClientComplianceRiskMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Client Specific Configuration - Client Compliance Risk Mapping");
		
		
		ImplementMethods.ClientComplianceRiskMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 62)
	void PreviousComplianceDepartmentMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Previous  ComplianceDepartment Mapping");
		
		
		ImplementMethods.PreviousComplianceDepartmentMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 63)
	void ClientFrequencyMapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Client Frequency Mapping");
		
		
		ImplementMethods.ClientFrequencyMapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 64)
	void Targetdate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Client Specific Configuration -Target date");
		
		
		ImplementMethods.Targetdate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65)
	void DeReOpeningofComplianceDis() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Client Specific Configuration -  To check whether a new tab named \"Department Wise Re-opening Of Compliance is seperately reflects or not in Client Specific Configuration (Manage Compliance).");
		
		
		ImplementMethods.DeReOpeningofComplianceDis(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 66)
	void DeReOpeningofCompliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Client Specific Configuration - Department Wise Re-opening Of Compliance - To check whether the Customer, Department and User drop down are functionally working or not. ");
		
		
		ImplementMethods.DeReOpeningofCompliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65)
	void ComplianceCertificate() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances-Masters -Compliance Certificate");
		
		
		ImplementMethods.ComplianceCertificate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 66)
	void Uploadeventassignment() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events -Upload event assignment");
		
		
		ImplementMethods.Uploadeventassignment(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 67)
	void Event() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - event ");
		
		
		ImplementMethods.Event(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 68)
	void Compliance() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Compliance ");
		
		
		ImplementMethods.Compliance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 69)
	void Eventdeactivation() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event deactivation ");
		
		ImplementMethods.Eventdeactivation(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 70)//not run
	void Eventassignments() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments ");
		
		
		ImplementMethods.Eventassignments(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 71)
	void Eventfrequencymapping() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events -Event frequency mapping");
		
		
		ImplementMethods.Eventfrequencymapping(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 72)
	void HideMulticheckchecklist() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Customer - Add New - Hide Multicheckchecklist");
		
		
		ImplementMethods.HideMulticheckchecklist(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 73)
	void HideMulticheckchecklistEdit() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Customer -Edit - Hide Multicheckchecklist");
		
		
		ImplementMethods.HideMulticheckchecklistEdit(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 74)
	void UsersEA() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - User - Entites Assignment - Statutory - Clicking Assignment Radio button ");
		
		
		ImplementMethods.UsersEA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 75)
	void UsersEADelete() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - User - Entites Assignment - Statutory -Clicking Delete Radio button ");
		
		
		ImplementMethods.UsersEADelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 76)
	void UsersEAIn() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - User - Entites Assignment - Internal - Clicking Assignment Radio button ");
		
		
		ImplementMethods.UsersEAIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 77)
	void UsersEADeleteIN() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - User - Entites Assignment - Internal -Clicking Delete Radio button ");
		
		
		ImplementMethods.UsersEADeleteIN(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 78)
	void EventassignmentsExport() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments - Export");
		
		
		ImplementMethods.EventassignmentsExport(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 79)
	void Eventassignmentexportimport() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event");
		
		
		ImplementMethods.Eventassignmentexportimport(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 80)
	void EventassignmentexportimportD() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event");
		
		
		ImplementMethods.EventassignmentexportimportD(test,workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 81) 
	void UploadedFilewithOutFile() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event - Import ");
		
		
		ImplementMethods.UploadedFilewithOutFile(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 82)
	void ImportInvalidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event - Import - Invalid data ");
		
		
		ImplementMethods.ImportInvalidSheet(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 83)
	void UploadedFileisplay() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event - Import  ");
		
		
		ImplementMethods.UploadedFileisplay(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 84)
	void UploadedFileisplayEC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Import  ");
		
		
		ImplementMethods.UploadedFileisplayEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 85)
	void DownloadFileEC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Export   ");
		
		
		ImplementMethods.DownloadFileEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 86)
	void UploadedEC() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Import   ");
		
		
		ImplementMethods.UploadedEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 87)
	void InValidSheet() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Events - Event assignments  Export Import - Event Compliance - Import -Upload -Invalid File  ");
		
		
		ImplementMethods.InValidSheet(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 88)
	void Autoreconciliation() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Auto reconciliation ");
	
		ImplementMethods.Autoreconciliation(test,"Auto reconciliation");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 89)
	void AutoreconciliationWC() throws InterruptedException, IOException
	{
		test = extent.startTest("Report - Auto reconciliation -Without Customer selection click on \"Export \" Button ");
	
		ImplementMethods.AutoreconciliationWC(test,"Auto reconciliation");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 90)
	void ReassignmentExcludeReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports -Reassignment Exclude Report - Selecting Customer   ");
		
		
		ImplementMethods.ReassignmentExcludeReport(test,"Reassignment Exclude Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 91)
	void ReassignmentExcludeReportL() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports -Reassignment Exclude Report - Select Customer And Location  ");
		
		
		ImplementMethods.ReassignmentExcludeReportL(test,"Reassignment Exclude Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 92)
	void ReassignmentExcludeReportWC() throws InterruptedException, IOException
	{
		test = extent.startTest("Report -Other Reports -Reassignment Exclude Report - Without Customer Selection  ");
		
		
		ImplementMethods.ReassignmentExcludeReportWC(test,"Reassignment Exclude Report");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 93) //22/06/2023
		void Compliancetype() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal Compliances - Masters - Compliance Type  ");
			
			
			ImplementMethods.Compliancetype(test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 94) 
		void Complianceassignments() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Events - Compliance assignments  ");
			
			
			ImplementMethods.Complianceassignments(test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 95) 
		void Unsubscribe() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Users - Unsubscribe - with Valid Data ");
			
			
			ImplementMethods.Unsubscribe(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 96) 
		void UnsubscribeInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Users - Unsubscribe -  with InValid Data ");
			
			
			ImplementMethods.UnsubscribeInvalid(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 97) 
		void Unsubscribe2() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Users - Unsubscribe -  Enter Comma Seperated Email Id ");
			
			
			ImplementMethods.Unsubscribe2(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 98)
		void GroupingofCompliance() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Import - Sample Excel Format Downloaded Or not Verification");
			
			ImplementMethods.GroupingofCompliance(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 99)
		void GroupingofComplianceUploadw() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import - Upload - Without Selecting Customer,ComplianceType and Group type ");
			
			ImplementMethods.GroupingofComplianceUploadw(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 100)
		void GroupingofComplianceUpload() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Import - Upload - Customer level wise Upload Invalid data");
			
			ImplementMethods.GroupingofComplianceUpload(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 101)
		void GroupingofComplianceUploadLL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import -Upload - Location  level wise Upload Invalid data");
			
			ImplementMethods.GroupingofComplianceUploadLL(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 102)
		void GroupingofComplianceExport() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Export tab  - Export");
			
			ImplementMethods.GroupingofComplianceExport(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 103)
		void GroupingofComplianceUploadValidC() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance -Import - Upload - Customer level wise Upload Valid data");
			
			ImplementMethods.GroupingofComplianceUploadValidC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 104)
		void GroupingofComplianceUploadValidL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import -Upload - Location  level wise Upload Valid data");
			
			ImplementMethods.GroupingofComplianceUploadValidL(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 105)
		void Customerspecificduedateforstatutorycompliance() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Client Specific Configuration - Customerspecificduedateforstatutorycompliance -Sample Excel Format Downloaded Or not Verification");
			
			
			ImplementMethods.Customerspecificduedateforstatutorycompliance(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 106)
		void GroupingofComplianceUploadValidCL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import - Upload - Customer level wise Upload Valid data");
			
			ImplementMethods.GroupingofComplianceUploadValidCL(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 107)
		void GroupingofComplianceUploadValidLL() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances-Upload Utility - Grouping of Compliance - Import -Upload - Location  level wise Upload Valid data");
			
			
			ImplementMethods.GroupingofComplianceUploadValidLL(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 108)
		void BulkExcluding() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances - Upload Utility - Bulk Excluding - Export");
			
			
			ImplementMethods.BulkExcluding(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 109)
		void BulkExcludingImport() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliances - Upload Utility - Bulk Excluding - Import");
			
			
			ImplementMethods.BulkExcludingImport(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 109)
	void UploadActionableProcedure() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Upload Utility - Compliance Actionable Procedure - To check whether the Export Icon working or not on the tab of \"Compliance Actionable Procedure?");
		
		
		ImplementMethods.UploadActionableProcedure(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 109)
	void UploadActionableProcedureUpload() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Upload Utility - Compliance Actionable Procedure - To check whether the Upload functionality working or not on the page of Compliance Actionable Procedure?");
		
		
		ImplementMethods.UploadActionableProcedureUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 109)
	void UploadActionableProcedureUploadInvalid() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage Compliances - Upload Utility - Compliance Actionable Procedure - To check whether the error message displayed or not after uploding invalid sheet?");
		
		
		ImplementMethods.UploadActionableProcedureUploadInvalid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//	@Test(priority = 110)
		void ReleaseNoteDocument() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage User - Release Note Document  ");
			
			
			ImplementMethods.ReleaseNoteDocument(test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
	
	//@Test(priority = 110)
	void modifyAssignmentsCheck1() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Statutory -To check whether checkbox is seen for every schedule of compliance on status tab on the page of modify assignments or not.  ");
		
		
		ImplementMethods.modifyAssignmentsCheck1(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 111)
	void modifyAssignmentsCheckLi() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Statutory - To check whether checkbox is seen for every license based compliance on status tab on the page of modify assignments or not.");
		
		
		ImplementMethods.modifyAssignmentsCheckLi(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 112)
	void StatusDelete() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Statutory - To check whether delete button to delete the schedule one or more schedules is seen on status tab on the page of modify assignments or not.");
		
		
		ImplementMethods.StatusDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 113)
	void StatusDeleteWS() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Statutory - To check whether validation message is given or not if user clicks on delete button without selecting the checkboxes of schedules.");
		
		
		ImplementMethods.StatusDeleteWS(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 114)
	void modifyAssignmentsCheck1In() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Internal -To check whether checkbox is seen for every schedule of compliance on status tab on the page of modify assignments or not.  ");
		
		
		ImplementMethods.modifyAssignmentsCheck1In(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 115)
	void modifyAssignmentsCheckLiIn() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Internal - To check whether checkbox is seen for every license based compliance on status tab on the page of modify assignments or not.");
		
		
		ImplementMethods.modifyAssignmentsCheckLiIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 116)
	void StatusDeleteIn() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Internal - To check whether delete button to delete the schedule one or more schedules is seen on status tab on the page of modify assignments or not.");
		
		
		ImplementMethods.StatusDeleteIn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 117)
	void StatusDeleteWSIN() throws InterruptedException, IOException
	{
		test = extent.startTest(" Manage User - Modify Assignments - Internal - To check whether validation message is given or not if user clicks on delete button without selecting the checkboxes of schedules.");
		
		
		ImplementMethods.StatusDeleteWSIN(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 118)
	void SecondaryRe() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
		
		
		ImplementMethods.SecondaryRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 118)
	void SecondaryReDisplay() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
		
		
		ImplementMethods.SecondaryReDisplay(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 119)
	void STSecondaryRe() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
		
		
		ImplementMethods.STSecondaryRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//@Test(priority = 119)
	void STSecondaryReDisplay() throws InterruptedException, IOException
	{
		test = extent.startTest("Task - Task Details - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
		
		
		ImplementMethods.STSecondaryReDisplay(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 118)
		void SecondaryReIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details - Internal - To check whether the dropdown of secondary reviewer for the task is seen or not on the popup of show assignment details.");
			
			
			ImplementMethods.SecondaryReIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 118)
		void SecondaryReDisplayIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details - Internal - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of task is done to the secondary reviewer.");
			
			
			ImplementMethods.SecondaryReDisplayIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 119)
		void STSecondaryReIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details - Internal To check whether the dropdown of secondary reviewer for the sub-task is seen or not on the popup of show assignment details.");
			
			
			ImplementMethods.STSecondaryReIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 119)
		void STSecondaryReDisplayIn() throws InterruptedException, IOException
		{
			test = extent.startTest("Task - Task Details -  Internal - To check whether the record of assignment to secondary reviewer is seen or not on the popup of show assignment details after the assignment of sub-task is done to the secondary reviewer.");
			
			
			ImplementMethods.STSecondaryReDisplayIn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	
	//	@Test(priority = 119)
		void CustomersBrand() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage users  - customer -sub_entites - sub_entites - Add new - To check whether the Branch details should Saved with Brand name or not?");
			
			
			ImplementMethods.CustomersBrand(test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 119)
		void CustomersBrandW() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage users  - customer -sub_entites - sub_entites - Add new - To check whether the without Selected brand name the customer branch can be added or not?");
			
			
			ImplementMethods.CustomersBrandW(test,workbook);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 120)
		void ExcludeNotActivated() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliance  - Compliance assignment - Exclude not activated - To Check whether Statutory Not Activated Compliance Exclude Funcationality working or not?");
			
			
			ImplementMethods.ExcludeNotActivated(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 121)
		void ExcludeNotActivatedSC() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliance  - Compliance assignment - Exclude not activated - Statutory Checklist - To Check whether Statutory Checklist Not Activated Compliance Exclude Funcationality working or not?");
			
			
			ImplementMethods.ExcludeNotActivatedSC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 122)
		void ExcludeNotActivatedInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Compliance  - Compliance assignment - Exclude not activated - Internal Compliance - To Check whether Internal Not Activated Compliance Exclude Funcationality working or not?");
			
			
			ImplementMethods.ExcludeNotActivatedInternal(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 123)
		void ExcludeNotActivatedIC() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Compliance  - Compliance assignment - Exclude not activated - Internal Checklist Compliance - To Check whether Internal Checklist Not Activated Compliance Exclude Funcationality working or not?");
			
			
			ImplementMethods.ExcludeNotActivatedIC(test);
			
			extent.endTest(test);
			extent.flush();
		}	
		@Test(priority = 124)
		void ExcludeNotActivatedMultipleCompliance() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Compliance  - Compliance assignment - Exclude not activated  - To Check Statutory multiple Not Activated Compliance Exclude Funcationality working or not ?");
			
			
			ImplementMethods.ExcludeNotActivatedMultipleCompliance(test);
			
			extent.endTest(test);
			extent.flush();
		}	
		@Test(priority = 125)
		void ExcludeNotActivatedSCMultipleCompliance() throws InterruptedException, IOException
		{
			test = extent.startTest("Manage Compliance  - Compliance assignment - Exclude not activated  - To Check Statutory Checklist multiple Not Activated Compliance Exclude Funcationality working or not ?");
			
			
			ImplementMethods.ExcludeNotActivatedSCMultipleCompliance(test);
			
			extent.endTest(test);
			extent.flush();
		}	
		
		@Test(priority = 126)
		void ExcludeNotActivatedInternalMultipleCompliance() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliance  - Compliance assignment - Exclude not activated - Internal - To Check whether Intetnal multiple Not Activated Compliance Exclude Funcationality working or not?");
			
			
			ImplementMethods.ExcludeNotActivatedInternalMultipleCompliance(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 127)
		void ExcludeNotActivatedICMultipleCompliance() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliance  - Compliance assignment - Exclude not activated  - To Check whether Intetnal Checklist multiple Not Activated Compliance Exclude Funcationality working or not?");
			
			
			ImplementMethods.ExcludeNotActivatedICMultipleCompliance(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 128)
		void WithoutSelectCompliance() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Compliance  - Compliance assignment - Exclude not activated  - To Check whether excluded Not Activated page - without selecting Compliance click on Exclude Button validation message display or not ?");
			
			
			ImplementMethods.WithoutSelectCompliance(test);
			
			extent.endTest(test);
			extent.flush();
		}
		*/
//		@Test(priority = 129)
		void EventAssignmentExportImport() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Events  - Event Assignment Export Import- Entity wise data dowloaded or not?");
			
			
			ImplementMethods.EventAssignmentExportImport(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 130)
		void EventAssignmentTab() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Events  - Event Reassignment verification");
			
			
			ImplementMethods.EventAssignmentTab(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 130)
		void EventReassignment() throws InterruptedException, IOException
		{
			test = extent.startTest(" Manage Events  - Event Reassignment Upload");
			
			
			ImplementMethods.EventReassignment(test);
			
			extent.endTest(test);
			extent.flush();
		}

		
		
     	@AfterMethod
	  	void browserClosing() throws InterruptedException
	  	{
     		closeBrowser();
	  		Thread.sleep(1000);
	  	//	driver.close();
	  	}
     	
     	@AfterTest
      	void Closing() throws InterruptedException
      	{
      		
      	}	
	
    /* 	companyadmin@regtrack.com
     	reviewer@regtrack.com
     	department@regtrack.com
     	approver@regtrack.com
     	auditor@regtrack.com
     	department@abcd.com
     	Department@gmail.com
Approver@gmail.com
Auditor@gmail.com
*/
}
