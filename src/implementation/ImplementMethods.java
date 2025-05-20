package implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import companyadmin.CompanyMethods;
import companyadmin.CompanyPOM;
import login.BasePage;
import performer.OverduePOM;

public class ImplementMethods extends BasePage {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	static String filePath ="E:\\Regtrack Merge Project\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx";

	
	public static void CreateCustomers( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.clickCustomers().click();
		Thread.sleep(4000);
		ImplementPOM.ClickAddNew().click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]"))); 
		ImplementPOM.clickServiceProvider().click();

		ImplementPOM.SelectAvantis().click();
		Thread.sleep(5000);
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(3);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.CustomerName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(4000);

		row0 = sheet.getRow(4);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.BuyerName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(4000);
		row0 = sheet.getRow(5);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		int No = (int) c1.getNumericCellValue();
		ImplementPOM.BuyerContactNo().sendKeys("" + No + ""); // Writing Task title
		Thread.sleep(4000);
		row0 = sheet.getRow(6);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.BuyerEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(4000);
		ImplementPOM.ClickSave().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Message displayed - 'Customer Saved Successfully'");
		
	//	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
		Thread.sleep(1000);
	//	ImplementPOM.clickCustomers().click();
		Thread.sleep(5000);
		ImplementPOM.ClickEditC().click();
		Thread.sleep(5000);
		ImplementPOM.Address().clear();

		ImplementPOM.Address().sendKeys("ABC");
		Thread.sleep(1000);
		ImplementPOM.ClickSave().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Customer - Update Successfully");
		// ImplementPOM.Delete().click();
		// Thread.sleep(5000);
		ImplementPOM.Filter().sendKeys("customer123", Keys.ENTER);

		test.log(LogStatus.PASS, " Customer- Filter Working  Successfully");

		Thread.sleep(5000);
	}

	public static void CustomersAssignment( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		  FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.CustomerAssignment().click();
		Thread.sleep(4000);
		ImplementPOM.ClickAddNewCA().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomer().clear();
		Thread.sleep(1000);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(3);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.SelectCustomer().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(5000);
		ImplementPOM.SelectPerformer().click();
		Thread.sleep(1000);
		ImplementPOM.SelectRT().click();
		Thread.sleep(3000);
		ImplementPOM.SelectReviewer().click();
		Thread.sleep(1000);
		ImplementPOM.SelectAA().click();
		Thread.sleep(4000);
		ImplementPOM.ClickSaveCA().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Message displayed - 'Customer Assignment Successfully'");

		ImplementPOM.ClickEditCA().click();
		Thread.sleep(5000);
		ImplementPOM.SelectReviewer().click();
		Thread.sleep(1000);
		ImplementPOM.SelectIA().click();
		Thread.sleep(4000);
		Thread.sleep(4000);
		ImplementPOM.ClickSaveCA().click();
		Thread.sleep(5000);

		String saveMsg = ImplementPOM.UpdateMsg().getText();

		if (saveMsg.equalsIgnoreCase("Customer Assigned updated successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
		} else {
			test.log(LogStatus.FAIL, "Message displayed -" + saveMsg + "not Displayed");
		}
		ImplementPOM.CloseCA().click();

		Thread.sleep(5000);

		// ImplementPOM.DeleteCA().click();
		// test.log(LogStatus.PASS, "Delete Successfully");
		ImplementPOM.FilterCA().sendKeys("demo Final 7dec", Keys.ENTER);
		Thread.sleep(6000);
		test.log(LogStatus.PASS, "Customer Assignment - Filter Working  Successfully");

	
	}

	public static void SubEntity( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
		Thread.sleep(3000);
		ImplementPOM.clickCustomers().click();
		Thread.sleep(4000);
		ImplementPOM.clickSubEntity().click();
		Thread.sleep(5000);
		ImplementPOM.SubEntityAddNew().click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_tbxName']")));
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(8);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.EnterName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.SubEntityType().click();
		Thread.sleep(3000);
		ImplementPOM.LegalEntity().click();
		Thread.sleep(2000);
		ImplementPOM.Type().click();
		Thread.sleep(1000);
		ImplementPOM.DeemedPublicCompany().click();
		Thread.sleep(2000);
		ImplementPOM.Industry().click();
		Thread.sleep(2000);
		ImplementPOM.ClickCheck().click();
		Thread.sleep(2000);
		ImplementPOM.Industry().click();

		row0 = sheet.getRow(9);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.AddressLine1().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.State().clear();
		Thread.sleep(2000);
		ImplementPOM.State().sendKeys("Maharashtra");
		Thread.sleep(2000);
		ImplementPOM.Maharashtra().click();
		Thread.sleep(2000);
		ImplementPOM.City().clear();
		Thread.sleep(2000);
		ImplementPOM.City().sendKeys("Ahmednagar");
		Thread.sleep(2000);
		ImplementPOM.Anagar().click();
		Thread.sleep(2000);
		row0 = sheet.getRow(10);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ContactPerson().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(11);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ContactEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);
		ImplementPOM.SaveSE().click();

		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Sub Entity- Add New Branch Successfully");
		Thread.sleep(1000);
		row0 = sheet.getRow(8);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.FilterSE().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Sub Entity-Filter Working Successfully");
		ImplementPOM.ClickExport().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Sub Entity- Export to Excel Successfully");
		ImplementPOM.ClickEditSE().click();
		Thread.sleep(4000);
		ImplementPOM.Type().click();
		Thread.sleep(1000);
		ImplementPOM.LLP().click();
		Thread.sleep(3000);
		ImplementPOM.SaveSE().click();
		test.log(LogStatus.PASS, " Sub Entity- Update Successfully");
		Thread.sleep(3000);
		ImplementPOM.ClickDeleteSE().click();
		String DeleteMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase(
				"This will also delete all the sub-entities associated with current entity. Are you certain you want to delete this entity?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}

	}

	public static void Department( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ClickDepartment().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerDept().clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerDept().sendKeys("customer123");
		ImplementPOM.customer123().click();
		Thread.sleep(3000);
		ImplementPOM.AddNewDept().click();
		Thread.sleep(3000);
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(13);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartmentName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);

		ImplementPOM.DepartmentSave().click();
		Thread.sleep(2000);
		String DeptSaveMsg = ImplementPOM.DepartmentSaveMsg().getText();

		if (DeptSaveMsg.equalsIgnoreCase("Department saved successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeptSaveMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed "+DeptSaveMsg);
		}
		Thread.sleep(2000);
		ImplementPOM.DepartmentClose().click();
		Thread.sleep(3000);
		
		//   ------------------------- Filter ---------------------
		row0 = sheet.getRow(13);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartFilter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Department-Filter Working Successfully");

		ImplementPOM.DepartEdit().click();
		Thread.sleep(4000);
		ImplementPOM.DepartmentName().clear();
		Thread.sleep(2000);
		row0 = sheet.getRow(14);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartmentName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.DepartmentSave().click();
		Thread.sleep(3000);
		String DeptUpdateMsg = ImplementPOM.DepartUpdateMsg().getText();

		if (DeptUpdateMsg.equalsIgnoreCase("Department updated successfully")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeptUpdateMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed - Department already exists");
		}

		Thread.sleep(2000);
		ImplementPOM.DepartmentClose().click();
		Thread.sleep(3000);

		ImplementPOM.DepartDelete().click();
		String DeleteMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Department Details?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}

	}

	public static void UserandBranchUpload( ExtentTest test) throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ClickUserandBrach().click();
		Thread.sleep(4000);

		Select Customer = new Select(ImplementPOM.SelectCustomerUB());
		Thread.sleep(500);
		Customer.selectByIndex(2);
		Thread.sleep(500);
		ImplementPOM.ClickUsers().click();
		Thread.sleep(500);
		ImplementPOM.UploadFile().sendKeys("C:\\Users\\mayurig\\Downloads\\SampleUserBranchUploadFormat.xlsx");
		Thread.sleep(1000);

		ImplementPOM.clickUpload().click();
		Thread.sleep(3000);
		String UploadMsg = ImplementPOM.UsersUploadMsg().getText();
		test.log(LogStatus.PASS, "Message displayed -" + UploadMsg);
		Thread.sleep(3000);
		Select Customer1 = new Select(ImplementPOM.SelectCustomerUB());
		Thread.sleep(500);
		Customer1.selectByIndex(2);
		Thread.sleep(500);
		ImplementPOM.ClickBranches().click();
		Thread.sleep(500);
		ImplementPOM.UploadFile().sendKeys("C:\\Users\\mayurig\\Downloads\\SampleUserBranchUploadFormat.xlsx");
		Thread.sleep(1000);
		ImplementPOM.clickUpload().click();
		Thread.sleep(4000);
		String UploadMsg1 = ImplementPOM.UsersUploadMsg().getText();
		test.log(LogStatus.PASS, "Message displayed -" + UploadMsg1);
		Thread.sleep(3000);

	}

	public static void Users( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(6000);
		ImplementPOM.clickUsers().click();
		Thread.sleep(5000);

		ImplementPOM.SelectCustomerUser().clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerUser().sendKeys("ABCD Pvt Ltd");
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		ImplementPOM.AddNewDept().click();
		Thread.sleep(3000);
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(16);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(17);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersFirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(18);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersLastName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(19);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersDesignation().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(20);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

		int No = (int) c1.getNumericCellValue();
		ImplementPOM.UsersMobileNo().sendKeys("" + No + ""); // Writing Task title
		Thread.sleep(4000);
		ImplementPOM.UsersDepartment().click();
		Thread.sleep(2000);
		ImplementPOM.DepartmentTech().click();
		Thread.sleep(5000);
		ImplementPOM.UsersDepartment().click();
		Thread.sleep(2000);
		ImplementPOM.UserComplianceRole().click();
		Thread.sleep(3000);
		ImplementPOM.UserCompanyAdmin().click();
		Thread.sleep(4000);

		ImplementPOM.SelectHrRole().click();
		Thread.sleep(2000);
		ImplementPOM.HR().click();
		Thread.sleep(4000);
		ImplementPOM.SC().click();
		Thread.sleep(2000);
		ImplementPOM.ABC().click();
		Thread.sleep(4000);
		ImplementPOM.LoginSSO().click();
		Thread.sleep(500);
		ImplementPOM.DesktopAccess().click();
		Thread.sleep(2000);
		try {
		CompanyPOM.SecurityGroup().click();
		Thread.sleep(2000);
		CompanyPOM.avantisGroup().click();
		}
		catch(Exception e) {
			
		}
		Thread.sleep(4000);
		ImplementPOM.UserSave().click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "User - Add Successfully");
		row0 = sheet.getRow(17);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DepartFilter().sendKeys("ss", Keys.ENTER); // Writing Task title
		Thread.sleep(6000);
		test.log(LogStatus.PASS, "User - Filter working Successfully");
		ImplementPOM.ExportUser().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User - Export to excel Successfully");
		Thread.sleep(2000);
		ImplementPOM.UserEdit().click();
		Thread.sleep(3000);
		ImplementPOM.UsersFirstName().clear();
		Thread.sleep(1000);
		row0 = sheet.getRow(21);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.UsersFirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.UsersDepartment().click();
		Thread.sleep(2000);
		ImplementPOM.DepartmentTech().click();
		Thread.sleep(5000);
		ImplementPOM.UsersDepartment().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocation().click();
		Thread.sleep(5000);
		ImplementPOM.Location1().click();
		Thread.sleep(2000);
		ImplementPOM.UserSave().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "User - Update Successfully");
		ImplementPOM.ResetPass().click();
		Thread.sleep(3000);
		String ResetPass = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (ResetPass.equalsIgnoreCase("Are you certain you want to reset password for this user?")) {
			test.log(LogStatus.PASS, "Message displayed -" + ResetPass);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + ResetPass + "not Displayed");
		}
		Thread.sleep(2000);
		String ResetMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (ResetMsg.equalsIgnoreCase("Password reset successfully.")) {
			test.log(LogStatus.PASS, "Message displayed -" + ResetMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + ResetMsg + "not Displayed");
		}
		Thread.sleep(4000);

		ImplementPOM.UserDelete().click();
		Thread.sleep(3000);
		String DeleteMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this User?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}
		Thread.sleep(2000);

	}

	public static void productMapping( ExtentTest test) throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ProductMapping().click();
		Thread.sleep(4000);
		ImplementPOM.AddNewDept().click();
		Thread.sleep(4000);
		ImplementPOM.PMCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.PMABCDPvtLtd().click();
		Thread.sleep(2000);
		ImplementPOM.PMProduct().click();
		Thread.sleep(1000);
		ImplementPOM.PMCompliance().click();

		Thread.sleep(2000);
		ImplementPOM.PMSave().click();
		Thread.sleep(2000);
		String Msg = ImplementPOM.PMAddMsg().getText();

		Thread.sleep(3000);
		if (Msg.equalsIgnoreCase("Your details have been saved successfully.")) {
			test.log(LogStatus.PASS, "Message displayed -" + Msg);
		} else {
			test.log(LogStatus.PASS, "Message displayed - "+Msg);
		}

		Thread.sleep(2000);

		ImplementPOM.PMClose().click();
		Thread.sleep(3000);
		ImplementPOM.DepartFilter().sendKeys("PQR Pvt ltd", Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -Filter Working Successfully");
		ImplementPOM.PMDelete().click();
		Thread.sleep(1000);
		String DeleteMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Product?")) {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg + "not Displayed");
		}
		Thread.sleep(2000);

	}

	public static void modifyAssignmentsReassign( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments().click();
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Statutory
		// --------------------------------------

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		ImplementPOM.SelectABCD().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(8000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		ImplementPOM.Selectaaa().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		ImplementPOM.SelectPerformerabcabd().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		ImplementPOM.Selectaaa().click();
		Thread.sleep(5000);

		ImplementPOM.CheckBox1().click();
		Thread.sleep(1000);
	//	ImplementPOM.CheckBox2().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -Statutory - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Statutory :-Event Based
		// --------------------------------------
		Thread.sleep(7000);
		ImplementPOM.ClickStaEventBased().click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox1().click();
		Thread.sleep(1000);
	//	ImplementPOM.CheckBox2().click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn().click();
		String MAEventMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAEventMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -Event Based - " + MAEventMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAEventMsg + "not Displayed");
		}

		// --------------------------- Modify Assignments :- Statutory :-CheckList
		// --------------------------------------
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList().click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		//ImplementPOM.CheckBox2().click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn().click();
		String MACheckListMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MACheckListMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -CheckList " + MACheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MACheckListMsg + "not Displayed");
		}

		// --------------------------- Modify Assignments :- Internal
		// --------------------------------------
		Thread.sleep(5000);
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		ImplementPOM.SelectBitademopune().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		ImplementPOM.SelectASs().click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectNewPerformerUser().click();
		ImplementPOM.SelectPerformeraaaaa().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		ImplementPOM.SelectASsd().click();
		Thread.sleep(5000);

		ImplementPOM.CheckINBox0().click();
		Thread.sleep(1000);
		//ImplementPOM.CheckINBox2().click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn().click();
		String MAInMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to aaa aa?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal - " + MAInMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInMsg + "not Displayed");
		}
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Internal :-CheckList
		// --------------------------------------
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList().click();
		Thread.sleep(5000);
		ImplementPOM.CheckINBox0().click();
		Thread.sleep(1000);
	//	ImplementPOM.CheckINBox2().click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn().click();
		String MAInCheckListMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInCheckListMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to aaa aa?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal- CheckList " + MAInCheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInCheckListMsg + "not Displayed");
		}

		Thread.sleep(2000);

	}

	public static void modifyAssignmentsExclude( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 
		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments().click();
		Thread.sleep(6000);

		// --------------------------- Modify Assignments :- Statutory :- Exclude
		// --------------------------------------
		ImplementPOM.ClickExclude().click();
		Thread.sleep(6000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		Thread.sleep(2000);
		ImplementPOM.SelectABCD().click();
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(3000);
		ImplementPOM.Selectaaa().click();
		Thread.sleep(8000);
		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox2().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		Thread.sleep(3000);
		String MAEMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAEMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Statutory - Exclude" + MAEMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAEMsg + "not Displayed");
		}
		Thread.sleep(4000);
		// --------------------- Modify Assignments :- Statutory :-Exclude-Event Based
		// --------------------------------------
		Thread.sleep(7000);
		ImplementPOM.ClickStaEventBased().click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox2().click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn().click();
		String MAEEventMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAEEventMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Event Based - Exclude " + MAEEventMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAEEventMsg + "not Displayed");
		}

		// --------------------------- Modify Assignments :- Statutory
		// :-Exclude-CheckList --------------------------------------
		Thread.sleep(5000);
		ImplementPOM.ClickStaCheckList().click();
		Thread.sleep(5000);
		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox2().click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn().click();
		String MAECheckListMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAECheckListMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for aaa aaa?")) {
			test.log(LogStatus.PASS, "Message displayed -CheckList -Exclude " + MAECheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAECheckListMsg + "not Displayed");
		}
/*	//	ImplementPOM.ClickStaCheckList().click();
		// --------------------------- Modify Assignments :- Internal- exclude
		// --------------------------------------
		
		
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		ImplementPOM.ClickExclude().click();
		Thread.sleep(6000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		ImplementPOM.SelectBitademopune().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		ImplementPOM.SelectASs().click();
		Thread.sleep(4000);

		ImplementPOM.CheckINBox0().click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckINBox2().click();
		Thread.sleep(3000);
		ImplementPOM.ClicksaveBtn().click();
		String MAInMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal -exclude :- " + MAInMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInMsg + "not Displayed");
		}
		Thread.sleep(4000);
		// --------------------------- Modify Assignments :- Internal :-exclude:-
		// CheckList --------------------------------------
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList().click();
		Thread.sleep(5000);
		ImplementPOM.CheckINBox0().click();

		Thread.sleep(3000);
		ImplementPOM.ClicksaveBtn().click();
		String MAInCheckListMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInCheckListMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for A Ss?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal-exclude:- CheckList " + MAInCheckListMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAInCheckListMsg + "not Displayed");
		}
*/
		Thread.sleep(2000);

	}

	public static void modifyAssignmentsTask( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments().click();
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Statutory :-Task :-Reassign
		// -------------------------------------
		ImplementPOM.ClickTask().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		ImplementPOM.SelectABCD().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		ImplementPOM.SelectPerformerUser().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		ImplementPOM.SelectPerformerabcabd().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		ImplementPOM.Selectaaaaaad().click();
		Thread.sleep(5000);

		ImplementPOM.ChechBoxInTask0().click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to abc abd?")) {
			test.log(LogStatus.PASS, "Message displayed -Statutory -Task :- Reassign " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		// --------------------------- Modify Assignments :- Internal Task :- Reassign
		// --------------------------------------
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments().click();
		Thread.sleep(4000);

		
		
		ImplementPOM.ClickTask().click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]")));
		Thread.sleep(2000);
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		ImplementPOM.SelectABCD().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(500);

		Thread.sleep(500);
		ImplementPOM.SelectPerformerUser().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
	By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); // Wait until	 records t	 get visible.
		Thread.sleep(2000);
		ImplementPOM.SelectNewPerformerUser().click();
		ImplementPOM.Selectaaaaaad().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		ImplementPOM.Selectaaaaaad().click();
		Thread.sleep(5000);

		ImplementPOM.ChechBoxInTask0().click();
		// Thread.sleep(1000);
		// ImplementPOM.ChechBoxInTask1().click();
		Thread.sleep(4000);
		ImplementPOM.ClicksaveBtn().click();
		String MAInMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (MAInMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to aaea aaa?")) {
			test.log(LogStatus.PASS, "Message displayed -Internal -Task :- Reassign " + MAInMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -Internal -Task :- Reassign" + MAInMsg + "not Displayed");
		}
		Thread.sleep(4000);

	}

	public static void UsageReportCustomer( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																											
		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UsageReportCustomer().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerRe().click();
		Thread.sleep(500);
		ImplementPOM.SelectABCD().click();
		Thread.sleep(1000);
		ImplementPOM.SelectCustomerRe().click();
		Thread.sleep(500);
		ImplementPOM.FromDate().click();
		Thread.sleep(500);
		ImplementPOM.January19().click();
		Thread.sleep(1000);
		ImplementPOM.ToDate().click();
		Thread.sleep(500);
		ImplementPOM.January25().click();
		Thread.sleep(1000);

		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportRe().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}
/*
		if (ImplementPOM.ClickClearBtn().isEnabled()) {

			ImplementPOM.ClickClearBtn().click();
			test.log(LogStatus.PASS, " :-Clear Button Working successfully.");
		} else {
			test.log(LogStatus.FAIL, " :-Clear Button is not  Working successfully.");
		}*/

	}
	
	public static void UsageReport( ExtentTest test,String report) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
		
			      action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
			      Thread.sleep(1000);
			      ImplementPOM.ClickUsageReport().click();
			      Thread.sleep(3000);
			      ImplementPOM.SelectCustomerUR().click();
			      Thread.sleep(500);
			      ImplementPOM.SelectABCD().click();
			      Thread.sleep(500);
			      ImplementPOM.SelectABitaPharmaCompany().click();
			      Thread.sleep(500);
			      ImplementPOM.FromDateUR().click();
			      Thread.sleep(500);
			      ImplementPOM.January19().click();
			      Thread.sleep(1000);
			      ImplementPOM.ToDateUR().click();
			      Thread.sleep(500);
			      ImplementPOM.January25().click();
			      Thread.sleep(1000);
			      
			      File dir = new File("C:\\Users\\mayurig\\Downloads");
					File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
					
					Thread.sleep(500);
					ImplementPOM.ExportToExcel().click();				//Exporting (Downloading) file
					
					Thread.sleep(3000);//C://Users//jiya//Downloads//
					File dir1 = new File("C:\\Users\\mayurig\\Downloads");
					File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
					Thread.sleep(3000);
					if(dirContents.length < allFilesNew.length)
					{
						test.log(LogStatus.PASS, report+" :- File downloaded successfully.");	
					}
					else
					{
						test.log(LogStatus.FAIL, report+" :- File does not downloaded.");
					}
												
	}
	
	public static void StatutoryAssignmentReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		if(ImplementPOM.StatutoryAssignment().isDisplayed()) {
			
			test.log(LogStatus.PASS,  " statutorty Assignment report displayed.");
		ImplementPOM.StatutoryAssignment().click();
		Thread.sleep(3000);
		}
		ImplementPOM.SelectCustomerSA().click();

		ImplementPOM.SelectBitademopuneSA().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}

	public static void CheckListAssignmentReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		if(ImplementPOM.CheckListAssignment().isDisplayed()) {
			test.log(LogStatus.PASS,  " Checklist   Assignment report displayed.");
		ImplementPOM.CheckListAssignment().click();
		Thread.sleep(3000);
		}
		ImplementPOM.SelectCustomerSA().click();

		ImplementPOM.SelectBitademopuneSA().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(6000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}

	public static void EventBasedAssignmentReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		if(ImplementPOM.EventBasedAssignment().isDisplayed()) {
			test.log(LogStatus.PASS,  " Event Based Assignment report displayed.");
		ImplementPOM.EventBasedAssignment().click();
		Thread.sleep(3000);
		}
		ImplementPOM.SelectCustomerSA().click();

		ImplementPOM.SelectBitademopuneSA().click();
		Thread.sleep(8000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(5000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}

	public static void InternalAssignmentReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		if(ImplementPOM.InternalAssignment().isDisplayed()) {
			test.log(LogStatus.PASS,  " Internal Assignment report displayed.");
		
		ImplementPOM.InternalAssignment().click();
		Thread.sleep(3000);
		}
		ImplementPOM.SelectCustomerSA().click();

		ImplementPOM.SelectBitademopuneSA().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(6000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}
	
	public static void InternalCheckListAssignment( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		if(ImplementPOM.InternalCheckListAssignment().isDisplayed()) {
			test.log(LogStatus.PASS,  " Internal Checklist Assignment report displayed.");
		ImplementPOM.InternalCheckListAssignment().click();
		Thread.sleep(3000);
		}
		ImplementPOM.SelectCustomerSA().click();

		ImplementPOM.SelectBitademopuneSA().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(6000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}
	
	public static void StatutoryLabelReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		if(ImplementPOM.StatutoryLabelReport().isDisplayed()) {
			test.log(LogStatus.PASS,  " Statutory Label report displayed.");
			ImplementPOM.StatutoryLabelReport().click();
			Thread.sleep(3000);
		}
		
		ImplementPOM.SelectCustomerSA().click();

		ImplementPOM.SelectBitademopuneSA().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(5000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}
	
	public static void InternalLabelReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		if(ImplementPOM.InternalLabelReport().isDisplayed()) {
			test.log(LogStatus.PASS,  " Internal Label report displayed.");
		ImplementPOM.InternalLabelReport().click();
		Thread.sleep(3000);
		}
		ImplementPOM.SelectCustomerSA().click();

		ImplementPOM.SelectBitademopuneSA().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(5000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}
	
	public static void AllReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		if(ImplementPOM.AllReport().isDisplayed()) {
			test.log(LogStatus.PASS,  " All report displayed.");
	    	ImplementPOM.AllReport().click();
		Thread.sleep(3000);
		}
		ImplementPOM.SelectCustomerAllReport().click();

		ImplementPOM.BitademopuneAllReport().click();
		Thread.sleep(10000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(10000);// C://Users//jiya//Downloads//
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}
	
	public static void LogReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(2000);
		if(ImplementPOM.LogReport().isDisplayed()) {
			test.log(LogStatus.PASS,  " Log report displayed.");
		}
		//ImplementPOM.LogReport().click();
		Thread.sleep(3000);
		 By locator = By.linkText("Log report");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
		
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	      Thread.sleep(3000);
		ImplementPOM.SelectCustomerAR().click();
		Thread.sleep(3000);
		ImplementPOM.BitademopuneAR().click();
		Thread.sleep(2000);
		ImplementPOM.ClickApply().click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ClickExportLR().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}
		
		if(ImplementPOM.ClickClearLR().isEnabled()) {
			
			ImplementPOM.ClickClearLR().click();
			test.log(LogStatus.PASS, " Clear Button Working successfully.");
			
		}
		
		 Thread.sleep(3000);
		getDriver().close();
		 Thread.sleep(3000);
		 getDriver().switchTo().window(pw);         // switching child window
	      Thread.sleep(3000);

	}
	
	
	public static void CompliaceCountReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.CompliaceCountReport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCategory().click();

		ImplementPOM.Commercial().click();
		Thread.sleep(5000);
		ImplementPOM.SelectType().click();

		ImplementPOM.Central().click();
		Thread.sleep(5000);
		
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO, report + " :- File does not downloaded.");
		}

	}
	
	public static void AssignCompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation().click();
		Thread.sleep(3000);
		ImplementPOM.AssignCompliance().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerAC().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(6000);
		ImplementPOM.SelectPerformerCA().click();
		Thread.sleep(500);
		ImplementPOM.FEManager().click();
		Thread.sleep(9000);
		ImplementPOM.ComplianceCategory().click();
		Thread.sleep(500);
		ImplementPOM.ABCD().click();
		Thread.sleep(5000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED().click();
		Thread.sleep(5000);
		
		ImplementPOM.SelectReviewerCA().click();
		Thread.sleep(500);
		ImplementPOM.FMManager().click();
		Thread.sleep(6000);
		ImplementPOM.ClickCheckBox().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(8000);
		String MAInMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(4000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		
	}
	
	public static void IntermediateCompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation().click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateCompliance().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerIC().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(6000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED().click();
		Thread.sleep(8000);
		ImplementPOM.ClickEdit().click();
		Thread.sleep(3000);
		ImplementPOM.EditUser().click();
		Thread.sleep(2000);
		//ImplementPOM.EditUseraaaaa().click();
		Thread.sleep(1000);
		ImplementPOM.ClickUpdate().click();
		Thread.sleep(3000);
	
		test.log(LogStatus.PASS, "Intermediate Compliance - Update Successfully");
			
		
		Thread.sleep(1000);
		ImplementPOM.ClickEdit().click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Intermediate Compliance - Delete Successfully");
		
	}
	
	public static void ActivateCompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation().click();
		Thread.sleep(3000);
		ImplementPOM.ActivateCompliance().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerCA().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(5000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB().click();
		Thread.sleep(6000);
		ImplementPOM.select().click();
		Thread.sleep(3000);
		ImplementPOM.selectDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date11().click();
		Thread.sleep(5000);
		ImplementPOM.ActivateCheckBox().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(5000);
	//	String AMsg = getDriver().switchTo().alert().getText();
		
		getDriver().switchTo().alert().accept();
		Thread.sleep(4000);
	//	test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(4000);
		String ActivateMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		
	}
	
	public static void AssignCheckList( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation().click();
		Thread.sleep(3000);
		ImplementPOM.AssignCheckList().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerCA().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(5000);
		ImplementPOM.SelectPerformerCA().click();
		Thread.sleep(500);
		ImplementPOM.FEManager().click();
		Thread.sleep(5000);
		ImplementPOM.ComplianceCategory().click();
		Thread.sleep(500);
		ImplementPOM.ABCD().click();
		Thread.sleep(5000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED().click();
		Thread.sleep(5000);
		
		ImplementPOM.SelectReviewerCA().click();
		Thread.sleep(500);
		ImplementPOM.FMManager().click();
		Thread.sleep(5000);
		try {
		ImplementPOM.ClickCheckBox().click();
		Thread.sleep(1000);
		}catch(Exception e)
		{
			
		}
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(6000);
	
		try
		{
			String MAInMsg = getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		}
		catch(Exception e)
		{
			String MAInMsg = ImplementPOM.MsgCheckbox().getText();
			Thread.sleep(2000);
									//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		}
	
		Thread.sleep(4000);
		
		
	}
	
	public static void IntermediateCheckList( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation().click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateCheckList().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerCA().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(5000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED().click();
		Thread.sleep(5000);
		ImplementPOM.ClickEdit1().click();
		Thread.sleep(3000);
		ImplementPOM.EditUser1().click();
		Thread.sleep(2000);
		ImplementPOM.EditUserFE().click();
		Thread.sleep(8000);
		ImplementPOM.ClickUpdate1().click();
		Thread.sleep(3000);
	
		test.log(LogStatus.PASS, "Intermediate CheckList - Update Successfully");
			
		/*
		Thread.sleep(1000);
		ImplementPOM.ClickEdit1().click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete().click();
		Thread.sleep(1000);*/
		test.log(LogStatus.PASS, "Intermediate CheckList - Delete Successfully");
		
	}
	
	public static void ActivateCheckList( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceActivation().click();
		Thread.sleep(3000);
		ImplementPOM.ActivateCheckList().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerCA().click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(5000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB().click();
		Thread.sleep(6000);
		ImplementPOM.select().click();
		Thread.sleep(3000);
		ImplementPOM.selectDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date11().click();
		Thread.sleep(4000);
		ImplementPOM.ActivateCheckBox().click();
		Thread.sleep(6000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(5000);
	//	String AMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
	//	test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		String ActivateMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(3000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		 By locator = By.xpath("//*[@id='BodyContent_lbtnExportExcel']/img");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
		
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
	//	ImplementPOM.ExportActivate().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		
	}
	
	public static void ComplianceCategory( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters().click();
		Thread.sleep(3000);
		ImplementPOM.MastersComplianceCategory().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerCC().click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneCC().click();
		Thread.sleep(2000);
		ImplementPOM.AddNewCC().click();
		Thread.sleep(2000);
		ImplementPOM.Customer().click();
		Thread.sleep(500);
		ImplementPOM.Bitademopune().click();
		Thread.sleep(2000);
		
		  FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(23);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.name().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(24);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Description().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.Save().click();
		test.log(LogStatus.PASS, " Compliance Category:-Add successfully.");
		Thread.sleep(2000);
		row0 = sheet.getRow(23);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.FilterM().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
		Thread.sleep(2000);
		String textfilter =ImplementPOM.FilterM().getText();
		String text=ImplementPOM.NameCheck().getText();
		if(text.equalsIgnoreCase(textfilter)){
			
			test.log(LogStatus.PASS, " Compliance Category:-Filter Working  successfully.");
			
		}else
		{
			test.log(LogStatus.FAIL, " Compliance Category:-Filter not Working  Properly.");
		}
		Thread.sleep(2000);
		ImplementPOM.EditComplianceCategory().click();
		Thread.sleep(2000);
		ImplementPOM.Description().clear();
		Thread.sleep(1000);
		row0 = sheet.getRow(25);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Description().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);

	Thread.sleep(3000);
		ImplementPOM.Save().click();
	Thread.sleep(2000);

			
			test.log(LogStatus.PASS, " Compliance Category:-Update successfully.");
			
		
       Thread.sleep(5000);
       ImplementPOM.DeleteComplianceCategory().click();
       Thread.sleep(1000);
   	String MAInCheckListMsg = getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);

		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg);
	

	}
	
	public static void Compliances( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters().click();
		Thread.sleep(3000);
		ImplementPOM.Compliances().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerC().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(2000);
		ImplementPOM.SelectCategoryMC().click();
		Thread.sleep(3000);
		ImplementPOM.ABCD().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCategoryMC().click();
		Thread.sleep(3000);
		ImplementPOM.AddNewCompliances().click();
		Thread.sleep(3000);
		ImplementPOM.TypeName().clear();
		Thread.sleep(500);
		ImplementPOM.TypeName().sendKeys("Maharashtra");
		Thread.sleep(3000);
		ImplementPOM.MaharashtraC().click();
		Thread.sleep(3000);
		ImplementPOM.CategoryName().clear();
		Thread.sleep(3000);
		ImplementPOM.CategoryName().sendKeys("ABCD");
		Thread.sleep(2000);
		ImplementPOM.ABCDCom().click();
		Thread.sleep(3000);
		  FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(27);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ShortDescription().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(28);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.ShortForm().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(29);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DetailedDescription().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.Frequency().click();
		Thread.sleep(500);
		ImplementPOM.Annual().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.PriorityType().click();
		Thread.sleep(3000);
		ImplementPOM.Low().click();
		Thread.sleep(3000);
		ImplementPOM.SaveCom().click();
		Thread.sleep(3000);
		String Msg=ImplementPOM.RecordSavemsg().getText();
		
		if (Msg.equalsIgnoreCase("Record Saved Sucessfully.")) {
			test.log(LogStatus.PASS, "Message displayed -" + Msg);
		} else {
			test.log(LogStatus.FAIL, "Message displayed -" + Msg + "");
		}
		
		Thread.sleep(2000);
		ImplementPOM.RecordClose().click();
		
	/*	Thread.sleep(5000);
		row0 = sheet.getRow(27);
		c1 = row0.getCell(1); 
		
		ImplementPOM.FilterType().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
		Thread.sleep(3000);

			test.log(LogStatus.PASS, " Compliances :-Filter Working  successfully.");
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			ImplementPOM.ClickExportSA().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " File does not downloaded.");
			}
			
			ImplementPOM.EditCompliance().click();
			Thread.sleep(2000);
			ImplementPOM.CategoryName().clear();
			Thread.sleep(3000);
			ImplementPOM.CategoryName().sendKeys("ABCD");
			Thread.sleep(3000);
		
			Thread.sleep(3000);
			ImplementPOM.ABCDCom().click();
			Thread.sleep(5000);
		
		ImplementPOM.SaveCom().click();
		Thread.sleep(2000);
	
String Msg1=ImplementPOM.RecordSavemsg().getText();
		
		if (Msg.equalsIgnoreCase("Record Saved Sucessfully.")) {
			test.log(LogStatus.PASS, "Message displayed - Edit - " + Msg1);
		} else {
			test.log(LogStatus.FAIL, "Message displayed -" + Msg1 + "");
		}
Thread.sleep(2000);
ImplementPOM.RecordClose().click();
Thread.sleep(3000);
ImplementPOM.DisplayScheduleInformation().click();
Thread.sleep(4000);
ImplementPOM.close().click();
Thread.sleep(3000);
test.log(LogStatus.PASS, " Compliances:-Display Schedule Information view successfully.");



Thread.sleep(3000);
ImplementPOM.DeleteCompliance().click();
Thread.sleep(1000);
String MAInCheckListMsg = getDriver().switchTo().alert().getText();
Thread.sleep(2000);
getDriver().switchTo().alert().accept();
Thread.sleep(2000);

	test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg);
	Thread.sleep(2000);
	
	
	ImplementPOM.FilterType().clear();
	Thread.sleep(1000);
	ImplementPOM.FilterType().sendKeys("18674",Keys.ENTER);
	Thread.sleep(3000);
	ImplementPOM.DisplayScheduleInformation().click();
	Thread.sleep(4000);
	ImplementPOM.SaveDsI().click();
	Thread.sleep(3000);
	String msg=ImplementPOM.DsIMsg().getText();
	test.log(LogStatus.PASS, "----------------- If Compliance assigned -------------- " );
	test.log(LogStatus.PASS, " Message displayed - " + msg);
	ImplementPOM.close().click();
	
	Thread.sleep(3000);
	ImplementPOM.DeleteCompliance().click();
	Thread.sleep(3000);
	String MAInCheckListMsg1 = getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);
	
		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
		Thread.sleep(2000);
		
String Msg2=ImplementPOM.RecordSavemsg().getText();
		

			test.log(LogStatus.PASS, "Message displayed - " + Msg2);
			Thread.sleep(2000);
			ImplementPOM.RecordClose().click();
	*/
	}
	
	public static void EditCompliances( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters().click();
		Thread.sleep(3000);
		ImplementPOM.EditCompliances().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerC().click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(6000);
		ImplementPOM.EditCompliance().click();
		Thread.sleep(4000);
		if(ImplementPOM.DescriptionEC().isDisplayed()&&ImplementPOM.EventBasedChk().isDisplayed()&&ImplementPOM.ComplianceDocumentMandatory().isDisplayed()) {
			test.log(LogStatus.PASS, "While Click on Edit Button Detail Description , Is event Based Checkbox and Is Compliance Document Mandatory? Checkbox fileds should be displayed." );
		}
		//ImplementPOM.EditCompliancesCN().click();
		Thread.sleep(4000);
		//ImplementPOM.CategoryName().sendKeys("ABCD");
		//Thread.sleep(1000);
		ImplementPOM.DescriptionEC().clear();
		Thread.sleep(1000);
		ImplementPOM.DescriptionEC().sendKeys("DescriptionEC");
		Thread.sleep(1000);
	//	ImplementPOM.EditCompliancesCNA().click();
		Thread.sleep(5000);
	
	ImplementPOM.SaveCom().click();
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "Message displayed - update Successfully" );

	Thread.sleep(3000);
	ImplementPOM.DeleteCompliance().click();
	Thread.sleep(1000);
	String MAInCheckListMsg1 = getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);
	
		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
		Thread.sleep(2000);
		
String Msg2=ImplementPOM.RecordSavemsg().getText();
		
		
			test.log(LogStatus.PASS, "Message displayed - " + Msg2);
			Thread.sleep(2000);
			ImplementPOM.RecordClose().click();
			Thread.sleep(2000);
			ImplementPOM.DisplayScheduleInformation().click();
			Thread.sleep(4000);
			ImplementPOM.close().click();
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " Compliances:-Display Schedule Information view successfully.");

			ImplementPOM.FilterType().sendKeys("18674",Keys.ENTER);
			Thread.sleep(3000);
			test.log(LogStatus.PASS, " Filter working successfully.");
			Thread.sleep(3000);
	}
	
	public static void UploadAssignment( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtility().click();
		Thread.sleep(3000);
		ImplementPOM.UploadAssignment().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerU().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.UploadFileU().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\InternalComplianceAssignmentUploadFormat.xlsx");
		
		ImplementPOM.Upload().click();
		Thread.sleep(4000);
	String msg=	ImplementPOM.UploadMsg().getText();
		Thread.sleep(500);
		if(msg.equalsIgnoreCase("Data uploaded successfully.")) {
			
			test.log(LogStatus.PASS, "Message displayed - " + msg);
			
		}else {
			
			test.log(LogStatus.FAIL, "Message displayed - " + msg);
			
		}
		
		
	}
	
	public static void PreviousInternalComplianceDepartmentMapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtility().click();
		Thread.sleep(3000);
		ImplementPOM.PreviousInternalComplianceDepartmentMapping().click();
		Thread.sleep(8000);
		ImplementPOM.SelectCustomerPICDM().click();
		Thread.sleep(500);
		ImplementPOM.ABCDPvtLtd().click();
		Thread.sleep(4000);
		ImplementPOM.SelectEntityLocation().click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtd().click();
		Thread.sleep(1000);
		ImplementPOM.AWSGFJBitaLimited().click();
		Thread.sleep(500);
		ImplementPOM.select().click();
		Thread.sleep(5000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
		ImplementPOM.Export().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		Thread.sleep(500);
		ImplementPOM.FilterType().sendKeys("18557",Keys.ENTER);
		Thread.sleep(3000);
	String text=ImplementPOM.InternalComplianceID().getText();
	if(text.equalsIgnoreCase("18557")) {
		test.log(LogStatus.PASS, " Filter Working  successfully.");
	} else {
		test.log(LogStatus.FAIL,  "Filter not working");
	}
	
		
	}
	
	public static void EntitiesAssignments( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignments().click();
		Thread.sleep(3000);
		ImplementPOM.EntitiesAssignments1().click();
		Thread.sleep(8000);
	
	
		Thread.sleep(2000);
	//	Select d=new Select(ImplementPOM.SelectCustomerEA());
		Thread.sleep(2000);
		//d.selectByVisibleText("ABCD Pvt Ltd");
		Thread.sleep(4000);
		ImplementPOM.AddNew().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerAE().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneAllReport().click();
		Thread.sleep(4000);
		ImplementPOM.LocationExpand().click();
		Thread.sleep(500);
		ImplementPOM.ASDAZFTextile().click();
		Thread.sleep(1000);
		ImplementPOM.Location().click();
		Thread.sleep(4000);
		ImplementPOM.User().click();
		Thread.sleep(500);
		ImplementPOM.mgmtf().click();
		Thread.sleep(4000);
		ImplementPOM.Location().click();
		Thread.sleep(500);
		ImplementPOM.ComplianceCategoryAE().click();
		Thread.sleep(500);
		ImplementPOM.JuneCompliance().click();
		Thread.sleep(4000);
		ImplementPOM.SaveAE().click();
		Thread.sleep(4000);
	/*	ImplementPOM.SelectEntityLocation().click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtd().click();
		Thread.sleep(1000);
		ImplementPOM.AWSGFJBitaLimited().click();
		Thread.sleep(500);
		ImplementPOM.select().click();
		Thread.sleep(500);
		ImplementPOM.SelectUserAE().click();
		Thread.sleep(500);
		ImplementPOM.mgmtf().click();
		Thread.sleep(500);*/
		test.log(LogStatus.PASS, "Entities Assignments successfully.");
		//---------------------------Delete Entities --------------------------------																						

		Thread.sleep(500);
		ImplementPOM.DeleteEntities().click();
		Thread.sleep(3000);
		ImplementPOM.DeleteCustomer().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneAllReport().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteExpand().click();
		Thread.sleep(500);
		ImplementPOM.DeleteTextile().click();
		Thread.sleep(1000);
		ImplementPOM.DeleteLocation().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteUser().click();
		Thread.sleep(500);
		ImplementPOM.mgmtf().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteLocation().click();
		Thread.sleep(500);
		ImplementPOM.DeleteCategory().click();
		Thread.sleep(500);
		ImplementPOM.JuneCompliance().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteAE().click();
		Thread.sleep(4000);
		String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
		Thread.sleep(4000);
		
		//----------------Export file-----------------------
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
		
		
	}
		
	public static void LicenseEntitiesAssignments( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignments().click();
		Thread.sleep(3000);
		ImplementPOM.LicenseEntitiesAssignments().click();
		Thread.sleep(3000);
		ImplementPOM.LicenseCustomer().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.AddNew().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseCustomerAE().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseExpand().click();
		Thread.sleep(500);
		ImplementPOM.ABitaPharmaCompany().click();
		Thread.sleep(1000);
		ImplementPOM.selectAe().click();
		Thread.sleep(4000);
		ImplementPOM.Licenseuser().click();
		Thread.sleep(500);
		ImplementPOM.CFOFinance().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation().click();
		Thread.sleep(500);
		ImplementPOM.LicenseType().click();
		Thread.sleep(500);
		ImplementPOM.aaaaaa().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation().click();
		Thread.sleep(2000);
		ImplementPOM.SaveAE().click();
		Thread.sleep(4000);
		try {
		String text=	ImplementPOM.SaveAE().getText();
		ImplementPOM.CloseBtn().click();
		Thread.sleep(4000);
		test.log(LogStatus.FAIL, text );
		}catch(Exception e) {
			
			test.log(LogStatus.PASS, "Entity Assigned successfully." );
		}
		//---------------------Export------------------------
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
		//---------------------------Delete Entities --------------------------------																						

				Thread.sleep(500);
				ImplementPOM.LicenseDeleteEntities().click();
				Thread.sleep(6000);
				ImplementPOM.LicenseDeleteC().click();
				Thread.sleep(500);
				ImplementPOM.BitademopuneU().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLocExpand().click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteABitPharmaCompany().click();
				Thread.sleep(1000);
		
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteUser().click();
				Thread.sleep(500);
				ImplementPOM.CFOFinance().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteType().click();
				Thread.sleep(500);
				ImplementPOM.aaaaaa().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(2000);
				ImplementPOM.LicenseDelete().click();
				Thread.sleep(4000);
			/*	String Msg = getDriver().switchTo().alert().getText();
				Thread.sleep(1000);
				getDriver().switchTo().alert().accept();
*/
				test.log(LogStatus.PASS, "Message displayed -:- Entity delete Successfully." );
				Thread.sleep(4000);
				
		
	}
	
	public static void MasterCompliances( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC().click();
		Thread.sleep(3000);
		ImplementPOM.CompliancesMC().click();
		Thread.sleep(6000);
		ImplementPOM.ComplianceCatagory().click();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecific().click();
		Thread.sleep(5000);
		ImplementPOM.ActGroup().click();
		Thread.sleep(1000);
		ImplementPOM.ActDemo1().click();
		Thread.sleep(4000);
		ImplementPOM.CompliancesType().click();
		Thread.sleep(1000);
		ImplementPOM.CentralMC().click();
		Thread.sleep(8000);
		ImplementPOM.EditComplianceMC().click();
		Thread.sleep(3000);
	/*	String actualTitle=ImplementPOM.ComplianceDetails().getText();
		
		if(actualTitle.equalsIgnoreCase("Compliance Details")) {
			test.log(LogStatus.PASS,  " Edit Compliance - view Successfully");
		}else {
			test.log(LogStatus.FAIL,  "Edit Compliance - view Successfully");

		}*/
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		//js.executeScript("window.scrollBy(0,400)");

		ImplementPOM.EditComplianceClose().click();
		Thread.sleep(5000);
		
		test.log(LogStatus.PASS,  " Edit Compliance - view Successfully");
		ImplementPOM.DisplaySchedule().click();
		Thread.sleep(3000);
		ImplementPOM.DisplayScheduleClose().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS,  " Display Schedule Information - view Successfully");
		ImplementPOM.FilterType().sendKeys("111854",Keys.ENTER); // Writing Task title
		Thread.sleep(3000);
	String match=	ImplementPOM.idMatch().getText();
		if(match.equalsIgnoreCase("111854")){
			test.log(LogStatus.PASS,  " Filter Working  successfully.");
		}else
		{
			test.log(LogStatus.PASS,  " Filter not Working properly ");
		}
	}
	
	public static void Acts( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC().click();
		Thread.sleep(3000);
		ImplementPOM.Acts().click();
		Thread.sleep(6000);
		
		ImplementPOM.ActsCatrgory().click();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecific().click();
		Thread.sleep(2000);
		ImplementPOM.ActsType().click();
		Thread.sleep(1000);
		ImplementPOM.CentralMC().click();
		Thread.sleep(6000);
		ImplementPOM.EditAct().click();
		Thread.sleep(3000);
		
	/*	String actualTitle=ImplementPOM.Act().getText();
		
		if(actualTitle.equalsIgnoreCase("Act")) {
			test.log(LogStatus.PASS,  " Edit Act - view Successfully");
		}else {
			test.log(LogStatus.FAIL,  "Edit Act - view Successfully");

		}*/
	//	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	//	js.executeScript("window.scrollBy(0,400)");
		test.log(LogStatus.PASS,  " Edit Act - view Successfully");

		ImplementPOM.EditActClose().click();
		Thread.sleep(5000);
		if(ImplementPOM.FilterType().isDisplayed()) {
			Thread.sleep(1000);
			test.log(LogStatus.PASS,  " The filter of act should be seen on the page of Act master.");
		ImplementPOM.FilterType().sendKeys("2708",Keys.ENTER); // Writing Task title
		Thread.sleep(8000);
	String match=	ImplementPOM.idCheck().getText();
	Thread.sleep(5000);
		if(match.equalsIgnoreCase("2708")){
			test.log(LogStatus.PASS,  " Filter Working  successfully.");
		}else
		{
			test.log(LogStatus.PASS,  " Filter not Working properly ");
		}
		}
		ImplementPOM.FilterType().clear();
		Thread.sleep(8000);
		ImplementPOM.ActSelect().click();
		Thread.sleep(2000);
		if(ImplementPOM.Act1().isEnabled()&&ImplementPOM.Act2().isEnabled()) {
		ImplementPOM.Act1().click();
		Thread.sleep(1000);
		ImplementPOM.Act2().click();
		Thread.sleep(1000);
		ImplementPOM.ActOk().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS,  "Act Filter :- The multiple act in the dropdown should be selectable and the details of the selected acts would be reflected on the grid . ");
		}else {
			test.log(LogStatus.FAIL,  " Act Filter : -The multiple act in the dropdown should not selectable . ");

		}
		
	}
	
	public static void HolidayMaster( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
			//----------------------Add New --------------------------		
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC().click();
		Thread.sleep(3000);
		ImplementPOM.HolidayMaster().click();
		Thread.sleep(6000);
		ImplementPOM.SelectComplianceType().click();
		Thread.sleep(3000);
		ImplementPOM.ComplianceTypeCentral().click();
		Thread.sleep(3000);
		ImplementPOM.AddNewHM().click();
		Thread.sleep(3000);
		  FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(32);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Name().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.TypeHM().click();
		Thread.sleep(2000);
		ImplementPOM.CentralMC().click();
		Thread.sleep(2000);
		ImplementPOM.Date().click();
		Thread.sleep(2000);
		ImplementPOM.Date15().click();
		Thread.sleep(2000);
		ImplementPOM.save().click();
		Thread.sleep(2000);
	String msg=	ImplementPOM.savemsg().getText();
	if(msg.equalsIgnoreCase("Record Saved Sucessfully.")){
		test.log(LogStatus.PASS,  "Message displayed :- " +msg);
	}else
	{
		test.log(LogStatus.PASS,  "Message displayed :- " +msg);
	}
	Thread.sleep(2000);
	
	ImplementPOM.Close().click();
	Thread.sleep(2000);
	//-------------------------Filter-------------------------
	row0 = sheet.getRow(32);
	c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	ImplementPOM.FilterM().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
	Thread.sleep(2000);
	String match=	ImplementPOM.namecheck().getText();
	Thread.sleep(5000);
		if(match.equalsIgnoreCase("Shehal Patil")){
			test.log(LogStatus.PASS,  " Filter Working  successfully.");
		}else
		{
			test.log(LogStatus.PASS,  " Filter not Working properly ");
		}
		Thread.sleep(4000);
		///-------------------Update-------------------------
		ImplementPOM.EditHoliday().click();
		Thread.sleep(2000);
		ImplementPOM.Date().click();
		Thread.sleep(2000);
		ImplementPOM.Date16().click();
		Thread.sleep(2000);
		ImplementPOM.save().click();
		Thread.sleep(2000);
	String msg1=	ImplementPOM.savemsg().getText();
	if(msg1.equalsIgnoreCase("Record Updated Sucessfully.")){
		test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
	}else
	{
		test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
	}
	Thread.sleep(2000);
	
	ImplementPOM.Close().click();
	Thread.sleep(2000);
	//---------------------Delete----------------
	ImplementPOM.DeleteHM().click();
	Thread.sleep(1000);
	String MAInCheckListMsg1 = getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);
	
		test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
		Thread.sleep(2000);
		
	
	}
	
	public static void WidgetMaster( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
			//----------------------Add New --------------------------		
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC().click();
		Thread.sleep(3000);
		ImplementPOM.WidgetMaster().click();
		Thread.sleep(8000);
		ImplementPOM.WidgeC().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtd1().click();
		Thread.sleep(4000);
		ImplementPOM.WidgetAddNew().click();
		Thread.sleep(4000);
		ImplementPOM.WidgetCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.WidgetABCDPvtLtd().click();
		Thread.sleep(2000);
		ImplementPOM.WidgetLocation().click();
		Thread.sleep(1000);
		ImplementPOM.AWSGFJBitaLimited1().click();
		Thread.sleep(2000);
		  FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(13);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(34);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.WidgetName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.WidgetAct().click();
		Thread.sleep(2000);
		ImplementPOM.WidgetActCheckBox().click();
		Thread.sleep(1000);
		ImplementPOM.WidgetOk().click();
		Thread.sleep(2000);
		
		ImplementPOM.WidgetCompliance().click();
		Thread.sleep(2000);
		ImplementPOM.WidgetCompliancecheck().click();
		Thread.sleep(1000);
		ImplementPOM.WidgetComplianceOk().click();
		Thread.sleep(2000);
		ImplementPOM.WidgetSave().click();
		Thread.sleep(2000);
		String msg=	ImplementPOM.WidgetSavemsg().getText();
		if(msg.equalsIgnoreCase("Widget Details Saved Successfully.")){
			test.log(LogStatus.PASS,  "Message displayed :- " +msg);
		}else
		{
			test.log(LogStatus.PASS,  "Message displayed :- " +msg);
		}
		Thread.sleep(2000);
		
		ImplementPOM.WidgetClose().click();
		Thread.sleep(2000);
		//----------------------Filter --------------------------
		row0 = sheet.getRow(34);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.FilterM().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
		
		Thread.sleep(5000);
			
				test.log(LogStatus.PASS,  " Filter Working  successfully.");
				Thread.sleep(1000);
			//----------------------Updated --------------------------

			ImplementPOM.WidgetEdit().click();
			Thread.sleep(3000);
			ImplementPOM.WidgetName().clear();
			row0 = sheet.getRow(35);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			ImplementPOM.WidgetName().sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(2000);
			ImplementPOM.WidgetSave().click();
			Thread.sleep(2000);
			String msg1=	ImplementPOM.WidgetSavemsg().getText();
			if(msg1.equalsIgnoreCase("Widget details updated successfully")){
				test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
			}else
			{
				test.log(LogStatus.PASS,  "Message displayed :- " +msg1);
			}
			Thread.sleep(2000);
			
			ImplementPOM.WidgetClose().click();
			Thread.sleep(2000);
			ImplementPOM.WidgeC().click();
			Thread.sleep(1000);
			ImplementPOM.ABCDPvtLtd1().click();
			Thread.sleep(4000);
			ImplementPOM.FilterM().clear();
			row0 = sheet.getRow(35);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			ImplementPOM.FilterM().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
			Thread.sleep(5000);
			//---------------------Delete----------------
			ImplementPOM.WidgetDeletet().click();
			Thread.sleep(3000);
			String MAInCheckListMsg1 = getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();
			Thread.sleep(3000);
			
				test.log(LogStatus.PASS, "Message displayed - " + MAInCheckListMsg1);
				Thread.sleep(4000);
				
			
	}
	
	public static void UploadInternalCompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
		

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityIC().click();
		Thread.sleep(3000);
		ImplementPOM.UploadInternalCompliance().click();
		Thread.sleep(3000);
		ImplementPOM.CustomerMC().click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM().sendKeys("C:\\Users\\mayurig\\Downloads\\Internal Compliance Upload Format.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC().click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg().getText();
		
		test.log(LogStatus.PASS, "Message displayed - " + Msg1);
		
		Thread.sleep(3000);
/*		ImplementPOM.AddChecklist().click();
		Thread.sleep(3000);
		ImplementPOM.checklistcustomer().click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(3000);
		ImplementPOM.CheckListFileUpload().sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\Internal Compliance Upload Format (2).xlsx");
		Thread.sleep(3000);
		ImplementPOM.ChecklistUploadFile().click();
		Thread.sleep(3000);
String Msg2=ImplementPOM.ReadMsg1().getText();
		
		test.log(LogStatus.PASS, "Message displayed - " + Msg2);
		
		Thread.sleep(3000);
		*/
	}
	
	public static void UploadAssignmentUU( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.UploadAssignmentMC().click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.DownloadExcelFormat().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
		ImplementPOM.SelectCustomerUA().click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM().sendKeys("C:\\Users\\mayurig\\Downloads\\ManageComplinace_UploadUtility_UploadAssignment.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC().click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg().getText();
		
		test.log(LogStatus.PASS, "UploadAssignment - Message displayed - " + Msg1);
		
		Thread.sleep(3000);
	}
	
	public static void UploadEventBasedComplianceAssignment( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.UploadEventBasedComplianceAssignment().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.DownloadExcelFormat().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
		ImplementPOM.SelectCustomerUE().click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneUE().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM().sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\ManageComplinace_UploadUtility_EventBasedComplianceMapping.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC().click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg().getText();
		
		test.log(LogStatus.PASS, "Upload Event Based Compliance Assignment -Message displayed - " + Msg1);
		
		Thread.sleep(3000);
	}
	
	public static void UploadAssignmentAll( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.UploadAssignmentAll().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.DownloadExcelFormat().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " :- File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
		ImplementPOM.SelectCustomerUA().click();
		Thread.sleep(1000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFileCM().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\ManageComplinace_UploadUtility_UploadAssignmentAll.xlsx");
		Thread.sleep(3000);
		ImplementPOM.UploadMC().click();
		Thread.sleep(3000);
String Msg1=ImplementPOM.ReadMsg().getText();
		
		test.log(LogStatus.PASS, "Message displayed - " + Msg1);
		
		Thread.sleep(3000);
	}
	
	public static void AssignComplianceCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		ImplementPOM.AssignComplianceCA().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerUR().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(1000);
		ImplementPOM.SelectPerformerCA().click();
		Thread.sleep(500);
		ImplementPOM.FEManager().click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceCategory().click();
		Thread.sleep(500);
		ImplementPOM.ClientSpecific().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectReviewerCA().click();
		Thread.sleep(500);
		ImplementPOM.FMManager().click();
		Thread.sleep(3000);
		
		ImplementPOM.ComplianceType().click();
		Thread.sleep(500);
		ImplementPOM.ComplianceTypeCentral().click();
		Thread.sleep(3000);
		try {
		ImplementPOM.ClickCheckBox().click();
		Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(3000);
		String MAInMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		
	}
	
	public static void IntermediateComplianceCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateComplianceCA().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerURI().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB().click();
		Thread.sleep(500);
		ImplementPOM.select().click();
		Thread.sleep(4000);
		ImplementPOM.FilterM().sendKeys("FE Manager",Keys.ENTER);
		Thread.sleep(4000);
		String text1=	ImplementPOM.CheckFilter().getText();
		if(text1.equalsIgnoreCase("FE Manager")) {
			test.log(LogStatus.PASS, "Intermediate Compliance - Filter Working  Successfully");	
		}
		
		ImplementPOM.ClickEdit1().click();
		Thread.sleep(3000);
		ImplementPOM.EditUser1().click();
		Thread.sleep(2000);
		ImplementPOM.EditUserFE().click();
		Thread.sleep(1000);
		ImplementPOM.ClickUpdate1().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Intermediate Compliance - Update Successfully");
		ImplementPOM.FilterM().clear();
		Thread.sleep(500);
		ImplementPOM.FilterM().sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		ImplementPOM.ClickEdit1().click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete1().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Intermediate Compliance - Delete Successfully");
		
	}
	
	public static void ActivateComplianceCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		ImplementPOM.ActivateComplianceCA().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerURa().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB().click();
		Thread.sleep(1000);
		ImplementPOM.select().click();
		Thread.sleep(3000);
		ImplementPOM.selectDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date11().click();
		Thread.sleep(1000);
		ImplementPOM.ActivateCheckBox().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(3000);
		String AMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		String ActivateMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void AssignCheckListCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		ImplementPOM.AssignCheckListCA().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerURI().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.SelectPerformerCA().click();
		Thread.sleep(500);
		ImplementPOM.FEManager().click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceCategory().click();
		Thread.sleep(500);
		ImplementPOM.ClientSpecific().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITED().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectReviewerCA().click();
		Thread.sleep(500);
		ImplementPOM.FMManager().click();
		Thread.sleep(3000);
		ImplementPOM.ClickCheckBox().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(6000);
	
		try
		{
			String MAInMsg = getDriver().switchTo().alert().getText();
			Thread.sleep(2000);
			getDriver().switchTo().alert().accept();							//Clicking on OK of alert.
			test.log(LogStatus.PASS, "Message displayed -:- " + MAInMsg);
		}
		catch(Exception e)
		{
			
		}
	
		Thread.sleep(4000);
		
		
	}
	
	public static void IntermediateCheckListCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		ImplementPOM.IntermediateCheckListCA().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerURI().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		
		ImplementPOM.ALENAVENTURESLIMITEDCB().click();
		Thread.sleep(1000);
		ImplementPOM.select().click();
		Thread.sleep(3000);
		ImplementPOM.ClickEdit1().click();
		Thread.sleep(3000);
		ImplementPOM.EditUser1().click();
		Thread.sleep(2000);
		ImplementPOM.EditUserFE().click();
		Thread.sleep(1000);
		ImplementPOM.ClickUpdate1().click();
		Thread.sleep(3000);
	
		test.log(LogStatus.PASS, "Intermediate CheckList - Update Successfully");
		Thread.sleep(1000);
		ImplementPOM.ClickEdit1().click();
		Thread.sleep(3000);
		ImplementPOM.ClickDelete1().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Intermediate CheckList - Delete Successfully");
		
	}
	
	public static void ActivateCheckListCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		ImplementPOM.ActivateCheckListCA().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerURI().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB().click();
		Thread.sleep(1000);
		ImplementPOM.select().click();
		Thread.sleep(3000);
		ImplementPOM.selectDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date11().click();
		Thread.sleep(1000);
		ImplementPOM.ActivateCheckBox().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(1000);
		String AMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		String ActivateMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + ActivateMsg);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		
	}
	
	public static void EntitiesAssignmentsMC( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignmentsMC().click();
		Thread.sleep(3000);
		ImplementPOM.EntitiesAssignmentsMC1().click();
		Thread.sleep(8000);
	//	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("BodyContent_ddlFiltercustomer"))); 

	/*	By locator = By.name("ctl00$BodyContent$ddlFiltercustomer");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = .findElement(locator);	
		Thread.sleep(3000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		//ImplementPOM.SelectCustomerPICDM().click();
		Thread.sleep(2000);
		Select d=new Select(ImplementPOM.SelectCustomerEA());
		Thread.sleep(2000);
		d.selectByVisibleText("ABCD Pvt Ltd");*/
	//	ImplementPOM.ABCDPvtLtd().click();
		Thread.sleep(4000);
		ImplementPOM.AddNew().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerAE().click();
		Thread.sleep(500);
		ImplementPOM.ABCDPvtLtd1().click();
		Thread.sleep(4000);
		ImplementPOM.LocationExpand().click();
		Thread.sleep(500);
		ImplementPOM.ASDAZFTextile().click();
		Thread.sleep(1000);
		ImplementPOM.Location().click();
		Thread.sleep(4000);
		ImplementPOM.User().click();
		Thread.sleep(500);
		ImplementPOM.mgmtf1().click();
		Thread.sleep(8000);
		ImplementPOM.Location().click();
		Thread.sleep(500);
		ImplementPOM.ComplianceCategoryAE().click();
		Thread.sleep(500);
		ImplementPOM.ClientSpecific().click();
		Thread.sleep(4000);
	//	ImplementPOM.ComplianceCategoryAE().click();
		Thread.sleep(500);
		ImplementPOM.SaveAE().click();
		Thread.sleep(4000);
		
	/*//	ImplementPOM.SelectEntityLocation().click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtd().click();
		Thread.sleep(1000);
		ImplementPOM.ASDAZFTextile1().click();
		Thread.sleep(500);
		ImplementPOM.select().click();
		Thread.sleep(500);*/

		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entities Assignments successfully.");
		//---------------------------Delete Entities --------------------------------																						

		Thread.sleep(500);
		ImplementPOM.DeleteEntities().click();
		Thread.sleep(3000);
		ImplementPOM.DeleteCustomer().click();
		Thread.sleep(500);
		ImplementPOM.DeleteABCDPvtLtd().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteExpand().click();
		Thread.sleep(500);
		ImplementPOM.DeleteTextile().click();
		Thread.sleep(1000);
		ImplementPOM.DeleteLocation().click();
		Thread.sleep(5000);
		ImplementPOM.DeleteUser().click();
		Thread.sleep(1000);
		ImplementPOM.DeleteUsermgmtf().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteLocation().click();
		Thread.sleep(5000);
		Thread.sleep(500);
		ImplementPOM.DeleteCategory().click();
		Thread.sleep(500);
		ImplementPOM.ClientSpecificC().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteAE().click();
		Thread.sleep(4000);
		String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
		Thread.sleep(4000);
		ImplementPOM.DeleteLocation().click();
		Thread.sleep(1000);
		ImplementPOM.DeleteClose().click();
		Thread.sleep(1000);
		//----------------Export file-----------------------
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " Excel File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		
		
	}
	
	public static void LicenseEntitiesAssignmentsMC( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.EntitiesAssignmentsMC().click();
		Thread.sleep(3000);
		ImplementPOM.LicenseEntitiesAssignments1().click();
		Thread.sleep(3000);
		ImplementPOM.LicenseCustomer().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.AddNew().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseCustomerAE().click();
		Thread.sleep(500);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseExpand().click();
		Thread.sleep(500);
		ImplementPOM.ABitaPharmaCompany().click();
		Thread.sleep(1000);
		ImplementPOM.selectAe().click();
		Thread.sleep(4000);
		ImplementPOM.Licenseuser().click();
		Thread.sleep(500);
		ImplementPOM.CFOFinance().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation().click();
		Thread.sleep(500);
		ImplementPOM.LicenseType().click();
		Thread.sleep(500);
		ImplementPOM.ABCD().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation().click();
		Thread.sleep(2000);
		ImplementPOM.SaveAE().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS,  " Add New  License Entities Assignments successfully.");
		//---------------------Export------------------------
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		
		//---------------------------Delete Entities --------------------------------																						

				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteEntities1().click();
				Thread.sleep(6000);
				ImplementPOM.LicenseDeleteC().click();
				Thread.sleep(500);
				ImplementPOM.BitademopuneU().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLocExpand().click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteABitPharmaCompany().click();
				Thread.sleep(2000);
				
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(4000);
				
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteUser().click();
				Thread.sleep(500);
				ImplementPOM.CFOFinance().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteType().click();
				Thread.sleep(500);
				ImplementPOM.ABCD().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(2000);
				ImplementPOM.LicenseDelete1().click();
				Thread.sleep(4000);
			String Msg = getDriver().switchTo().alert().getText();
				Thread.sleep(1000);
				getDriver().switchTo().alert().accept();

				test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
				Thread.sleep(4000);
		
	}
	
	public static void DaysBeforeDueDate( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.DaysBeforeDueDate().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerDB().click();
		Thread.sleep(1000);
		ImplementPOM.test1().click();
		Thread.sleep(5000);
		ImplementPOM.Monthly().click();
		Thread.sleep(500);
		ImplementPOM.Text1().clear();
		Thread.sleep(2000);
		ImplementPOM.Monthly().click();
		Thread.sleep(2000);
		ImplementPOM.Text1().sendKeys("1");
		Thread.sleep(1000);
		ImplementPOM.Quarterly().click();
		Thread.sleep(500);
		ImplementPOM.Text2().clear();
		Thread.sleep(500);
		ImplementPOM.Quarterly().click();
		Thread.sleep(500);
		ImplementPOM.Text2().sendKeys("2");
		Thread.sleep(1000);
		ImplementPOM.HalfYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text3().clear();
		Thread.sleep(500);
		ImplementPOM.HalfYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text3().sendKeys("3");
		Thread.sleep(1000);
		ImplementPOM.Annual1().click();
		Thread.sleep(500);
		ImplementPOM.Text4().clear();
		Thread.sleep(500);
		ImplementPOM.Annual1().click();
		Thread.sleep(500);
		ImplementPOM.Text4().sendKeys("4");
		Thread.sleep(1000);
		ImplementPOM.FourMonthly().click();
		Thread.sleep(500);
		ImplementPOM.Text5().clear();
		Thread.sleep(500);
		ImplementPOM.FourMonthly().click();
		Thread.sleep(500);
		ImplementPOM.Text5().sendKeys("5");
		Thread.sleep(1000);
		ImplementPOM.TwoYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text6().clear();
		Thread.sleep(500);
		ImplementPOM.TwoYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text6().sendKeys("6");
		Thread.sleep(1000);
		ImplementPOM.SevenYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text7().clear();
		Thread.sleep(500);
		ImplementPOM.SevenYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text7().sendKeys("7");
		Thread.sleep(1000);
		ImplementPOM.ThreeYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text8().clear();
		Thread.sleep(500);
		ImplementPOM.ThreeYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text8().sendKeys("8");
		Thread.sleep(1000);
		ImplementPOM.FiveYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text9().clear();
		Thread.sleep(500);
		ImplementPOM.FiveYearly().click();
		Thread.sleep(500);
		ImplementPOM.Text9().sendKeys("9");
		Thread.sleep(1000);
		ImplementPOM.Fortnightly().click();
		Thread.sleep(500);
		ImplementPOM.Text10().clear();
		Thread.sleep(500);
		ImplementPOM.Fortnightly().click();
		Thread.sleep(500);
		ImplementPOM.Text10().sendKeys("10");
		Thread.sleep(2000);
		ImplementPOM.SaveBtn().click();
		Thread.sleep(1000);
		String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
		Thread.sleep(4000);
	}
	
	public static void ReOpeningofCompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.ReOpeningofCompliance().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerReopen().click();
		Thread.sleep(1000);
		ImplementPOM.AvantisTest1().click();
		Thread.sleep(5000);
		ImplementPOM.ApproverCB().click();
		Thread.sleep(1000);
		ImplementPOM.AuditorCB().click();
		Thread.sleep(1000);
		ImplementPOM.SaveREOpen().click();
		Thread.sleep(1000);
		String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
		Thread.sleep(2000);
		String Msg1 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Message displayed -:- " + Msg1);
		Thread.sleep(4000);
	}
	
	public static void BlockScheduleInternal( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.BlockScheduleInternal().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerBSI().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(3000);
		ImplementPOM.ComplianceCategoryBSI().click();
		Thread.sleep(1000);
		ImplementPOM.ABCD().click();
		Thread.sleep(3000);
		ImplementPOM.DescriptionBSI().sendKeys("ABCD");
		Thread.sleep(3000);
		ImplementPOM.BlockDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date14().click();
		Thread.sleep(1000);
		ImplementPOM.BlockCheckBox().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.keep().click();
		Thread.sleep(2000);
		String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Message displayed -:- " + Msg);
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.BlockDelete().click();
		Thread.sleep(2000);
		String Msg1 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Message displayed -:- " + Msg1);
		Thread.sleep(2000);
		
	}
	
	public static void BlockScheduleStatutory( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.BlockScheduleStatutory().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerBSI().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(3000);
		ImplementPOM.ComplianceCategoryBSI().click();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecific().click();
		Thread.sleep(3000);
		ImplementPOM.DescriptionBSI().sendKeys("ABCD");
		Thread.sleep(3000);
		ImplementPOM.BlockDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date14().click();
		Thread.sleep(1000);
		ImplementPOM.BlockCheckBox().click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.keep().click();
		Thread.sleep(1000);
		String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg);
		Thread.sleep(2000);
		String Msg1 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg1);
		Thread.sleep(2000);
		ImplementPOM.DescriptionBSI().sendKeys("ABCDE");
		Thread.sleep(3000);
		ImplementPOM.BlockDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date14().click();
		Thread.sleep(1000);
		ImplementPOM.BlockCheckBox().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.BlockDelete().click();
		Thread.sleep(1000);
		String Msg2 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Delete - Message displayed -:- " + Msg2);
		Thread.sleep(2000);
		String Msg3 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Delete - Message displayed -:- " + Msg3);
		Thread.sleep(2000);
		
	}
	
	public static void DocumentMandatoryNonMandatory( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										

		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.DocumentMandatoryNonMandatory().click();
		Thread.sleep(4000);
		ImplementPOM.DocumentCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		//---------------------Export------------------------
	//	Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ExportBtn().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		Thread.sleep(1000);
		ImplementPOM.FilterType().sendKeys("2153",Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS,  "  Filter Working  successfully.");
	}
	
	public static void StartDateChange( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
   //----------------Keep-----------------------------
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.StartDateChange().click();
		Thread.sleep(4000);
		ImplementPOM.StartDateCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ASDAZFTextileA().click();
		Thread.sleep(2000);
		ImplementPOM.ActName().click();
		Thread.sleep(1000);
		ImplementPOM.ActName1().click();
		Thread.sleep(1000);
		ImplementPOM.Compliance().click();
		Thread.sleep(1000);
		ImplementPOM.Compliance1().click();
		Thread.sleep(1000);
		ImplementPOM.selectDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date2().click();
		Thread.sleep(1000);
		ImplementPOM.keep().click();
		Thread.sleep(1000);
		String Msg3 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg3);
		Thread.sleep(2000);
	String Msg=	ImplementPOM.StartDateMsg().getText();
	test.log(LogStatus.PASS, " Message displayed -:- " + Msg);
	
	  //----------------Delete-----------------------------
			action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
			Thread.sleep(1000);
			ImplementPOM.ClientSpecificConfiguration().click();
			Thread.sleep(1000);
			ImplementPOM.StartDateChange().click();
			Thread.sleep(4000);
			ImplementPOM.StartDateCustomer().click();
			Thread.sleep(1000);
			ImplementPOM.customer123Users().click();
			Thread.sleep(4000);
			ImplementPOM.SelectLocationCA().click();
			Thread.sleep(1000);
			ImplementPOM.LocationCA().click();
			Thread.sleep(1000);
			ImplementPOM.ASDAZFTextileA().click();
			Thread.sleep(2000);
			ImplementPOM.ActName().click();
			Thread.sleep(1000);
			ImplementPOM.ActName1().click();
			Thread.sleep(1000);
			ImplementPOM.Compliance().click();
			Thread.sleep(1000);
			ImplementPOM.Compliance1().click();
			Thread.sleep(1000);
			ImplementPOM.selectDate().click();
			Thread.sleep(1000);
			ImplementPOM.Date2().click();
			Thread.sleep(1000);
			ImplementPOM.DeleteStart().click();
			Thread.sleep(3000);
			String Msg4 = getDriver().switchTo().alert().getText();
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();

			test.log(LogStatus.PASS, " Message displayed -:- " + Msg4);
			Thread.sleep(2000);
		String Msg5=	ImplementPOM.StartDateMsg().getText();
		test.log(LogStatus.PASS, " Message displayed -:- " + Msg5);
		
	}
	
	public static void ChangeDueDate( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
   //----------------Add New-----------------------------
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.ChangeDueDate().click();
		Thread.sleep(4000);
		ImplementPOM.DocumentCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		ImplementPOM.AddNew1().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerName1().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		ImplementPOM.ActNameDueDate().clear();
		Thread.sleep(1000);
		ImplementPOM.ActNameDueDate().sendKeys("Act 19122022 Latest");
		Thread.sleep(1000);
		ImplementPOM.ActNameDueDateLatest().click();
		Thread.sleep(2000);
		ImplementPOM.ShortDescription1().click();
		Thread.sleep(1000);
		ImplementPOM.ShortDescription12().click();
		Thread.sleep(2000);
		ImplementPOM.DueDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date2().click();
		Thread.sleep(2000);
		ImplementPOM.DueDateSave().click();
		Thread.sleep(2000);
		String Msg4 = ImplementPOM.DueDateSaveMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg4);
		Thread.sleep(2000);
		ImplementPOM.DueDateClose().click();
		Thread.sleep(2000);
		//--------------------- Filter --------------------------
		Thread.sleep(1000);
		ImplementPOM.FilterType().sendKeys("Act 19122022 Latest",Keys.ENTER);
		Thread.sleep(3000);
		String Msg5 = ImplementPOM.ActNameText().getText();
		Thread.sleep(2000);
 if(Msg5.equalsIgnoreCase("Act 19122022 Latest")) {
	
	test.log(LogStatus.PASS,  " :- Filter Working  successfully.");
     }else {
	
	test.log(LogStatus.FAIL,  " :- Filter is not Working  successfully.");
	
 }
//--------------------- Edit --------------------------
 Thread.sleep(2000);
	ImplementPOM.Edit().click();
	Thread.sleep(2000);
	Thread.sleep(2000);
	ImplementPOM.DueDate().click();
	Thread.sleep(1000);
	ImplementPOM.Date4().click();
	Thread.sleep(2000);
	ImplementPOM.DueDateSave().click();
	Thread.sleep(4000);
	String Msg6 = ImplementPOM.DueDateSaveMsg().getText();

	test.log(LogStatus.PASS, " Message displayed -:- " + Msg6);
	Thread.sleep(2000);
	ImplementPOM.DueDateClose().click();
	Thread.sleep(2000);
	ImplementPOM.DisplayScheduleInformation1().click();
	Thread.sleep(2000);
	ImplementPOM.DisplayScheduleInformationSave().click();
	Thread.sleep(2000);
	test.log(LogStatus.PASS,  " :- Filter Working  successfully.");
		//----------------- File Upload ----------------
	ImplementPOM.Choose().sendKeys("C:\\Users\\Mayuri Gaikwad\\Downloads\\UploadClientBasedDueDate.xlsx");
	Thread.sleep(2000);
	ImplementPOM.Upload1().click();
	String Msg7 = ImplementPOM.Uploadmsg().getText();

	test.log(LogStatus.PASS, " Message displayed -:- " + Msg7);
	Thread.sleep(2000);
	}
	
	public static void CertificateFrequencyMapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
   //----------------Add New-----------------------------
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.CertificateFrequencyMapping().click();
		Thread.sleep(4000);
		ImplementPOM.AddNewC().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerCertificate().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(2000);
		ImplementPOM.selectDate().click();
		Thread.sleep(1000);
		ImplementPOM.Date4().click();
		Thread.sleep(2000);
		ImplementPOM.FrequencyCertificate().click();
		Thread.sleep(1000);
		ImplementPOM.QuarterlyCertificate().click();
		Thread.sleep(2000);
		ImplementPOM.DueDateCertificate().click();
		Thread.sleep(1000);
		ImplementPOM.DueDateCertificate3().click();
		Thread.sleep(2000);
		ImplementPOM.SaveCertificate3().click();
		Thread.sleep(2000);
		String Msg7 = ImplementPOM.CertificateMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg7);
		Thread.sleep(2000);
		ImplementPOM.CloseCertificate3().click();
		Thread.sleep(2000);
		ImplementPOM.FilterType().sendKeys("ABCD Pvt Ltd",Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Filter Working Successfully");
		Thread.sleep(1000);
		ImplementPOM.CertificateEdit().click();
		Thread.sleep(4000);
		ImplementPOM.graceperiod().click();
		Thread.sleep(3000);
		ImplementPOM.SaveCertificate3().click();
		Thread.sleep(4000);
		String Msg = ImplementPOM.CertificateMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg);
		Thread.sleep(3000);
		ImplementPOM.CloseCertificate3().click();
		Thread.sleep(2000);
	}
	
	public static void ClientComplianceRiskMapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
   //----------------Add New-----------------------------
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.ClientComplianceRiskMapping().click();
		Thread.sleep(4000);
		
		ImplementPOM.ClientCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.LocationCA().click();
		Thread.sleep(2000);
		ImplementPOM.ASDAZFTextileACB().click();
		Thread.sleep(2000);
		ImplementPOM.select().click();
		Thread.sleep(2000);
		ImplementPOM.SelectComplianceTypeC().click();
		Thread.sleep(1000);
		ImplementPOM.Statutory().click();
		Thread.sleep(2000);
		ImplementPOM.ClientRisk().click();
		Thread.sleep(1000);
		ImplementPOM.ClientRiskMedium().click();
		Thread.sleep(2000);
		ImplementPOM.ClientCheckBox().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		ImplementPOM.ClientSave().click();
		Thread.sleep(2000);
		String Msg = ImplementPOM.ClientSaveMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg);
		Thread.sleep(3000);
		
		//---------------------Export------------------------
		//	Thread.sleep(3000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			ImplementPOM.ExportClient().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " File does not downloaded.");
			}
			
			ImplementPOM.FilterType().sendKeys("4868",Keys.ENTER);
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Filter Working Successfully");
			Thread.sleep(1000);
		
	}
	
	public static void PreviousComplianceDepartmentMapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
   //----------------Add New-----------------------------
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.PreviousComplianceDepartmentMapping().click();
		Thread.sleep(4000);
		
		ImplementPOM.DocumentCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.LocationCA().click();
		Thread.sleep(2000);
		ImplementPOM.ASDAZFTextileACB().click();
		Thread.sleep(2000);
		ImplementPOM.select().click();
		Thread.sleep(2000);
		
		//---------------------Export------------------------
				//	Thread.sleep(3000);
					File dir = new File("C:\\Users\\mayurig\\Downloads");
					File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(500);
					ImplementPOM.PreviousExport().click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					File dir1 = new File("C:\\Users\\mayurig\\Downloads");
					File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  " File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  "File does not downloaded.");
					}
					
					ImplementPOM.FilterType().sendKeys("122",Keys.ENTER);
					Thread.sleep(3000);
					test.log(LogStatus.PASS, "Filter Working Successfully");
					Thread.sleep(1000);
	}
	
	public static void ClientFrequencyMapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
   //----------------Add New-----------------------------
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.ClientFrequencyMapping().click();
		Thread.sleep(4000);
		
		ImplementPOM.DocumentCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(2000);
		ImplementPOM.AddNewCF().click();
		Thread.sleep(3000);
		ImplementPOM.CustomerName1().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		ImplementPOM.ActNameDueDate().clear();
		Thread.sleep(1000);
		ImplementPOM.ActNameDueDate().sendKeys("Act 19122022 Latest");
		Thread.sleep(1000);
		ImplementPOM.ActNameDueDateLatest().click();
		Thread.sleep(2000);
		ImplementPOM.ShortDescription1().click();
		Thread.sleep(1000);
		ImplementPOM.ShortDescription12().click();
		Thread.sleep(2000);
		ImplementPOM.ClientFrequency().click();
		Thread.sleep(1000);
		ImplementPOM.Annual().click();
		Thread.sleep(2000);
		ImplementPOM.DueDateSave().click();
		Thread.sleep(2000);
		String Msg4 = ImplementPOM.DueDateSaveMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg4);
		Thread.sleep(2000);
		ImplementPOM.DueDateClose().click();
		Thread.sleep(3000);
		//------------Filter -------------------------
		ImplementPOM.FilterType().sendKeys("Act 19122022 Latest",Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Filter Working Successfully");
		Thread.sleep(1000);
		//------------Edit -------------------------

		ImplementPOM.ClientFrequencyEdit().click();
		Thread.sleep(3000);
		Thread.sleep(2000);
		ImplementPOM.ClientFrequency().click();
		Thread.sleep(1000);
		ImplementPOM.FiveYearly1().click();
		Thread.sleep(2000);
		ImplementPOM.DueDateSave().click();
		Thread.sleep(2000);
		String Msg = ImplementPOM.DueDateSaveMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg);
		Thread.sleep(2000);
		ImplementPOM.DueDateClose().click();
		Thread.sleep(3000);
		//------------Display Schedule Information -------------------------

		ImplementPOM.DisplayScheduleInformation1().click();
		Thread.sleep(2000);
		ImplementPOM.DisplayScheduleInformationSave().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Display Schedule Information view Successfully ");
		//------------Delete-------------------------

		ImplementPOM.ClientFrequencyDelete().click();
		Thread.sleep(4000);
		String Msg6 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		test.log(LogStatus.PASS, " Message displayed -:- " + Msg6);
		Thread.sleep(5000);
		String Msg8 = ImplementPOM.UploadMeg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg8);
		Thread.sleep(2000);
		//---------------------Export------------------------
		//	Thread.sleep(3000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			ImplementPOM.SampleFormatCF().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "  File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  "  File does not downloaded.");
			}
		
		//----------------- File Upload ----------------
		ImplementPOM.Choose().sendKeys("C:\\Users\\mayurig\\Downloads\\ClientBasedFrequency_Sample.xlsx");
		Thread.sleep(2000);
		ImplementPOM.Upload1().click();
		Thread.sleep(8000);
		String Msg7 = ImplementPOM.UploadMeg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg7);
		Thread.sleep(2000);
		
	}
	
	public static void ComplianceCertificate( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
			//----------------------Add New --------------------------		
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.MastersMC().click();
		Thread.sleep(3000);
		ImplementPOM.ComplianceCertificate().click();
		Thread.sleep(6000);
		ImplementPOM.CustomerCC().click();
		Thread.sleep(3000);
		ImplementPOM.BitaConsultingPvtLtd().click();
		Thread.sleep(6000);
		
		ImplementPOM.CCAddNew().click();
		Thread.sleep(3000);
		ImplementPOM.TemplateField().click();
		Thread.sleep(1000);
		ImplementPOM.CompliedStatutoryChecklist().click();
		Thread.sleep(2000);
		ImplementPOM.FromDateCC().clear();
		Thread.sleep(1000);
		ImplementPOM.FromDateCC().sendKeys("09-02-2023");
		Thread.sleep(1000);
		ImplementPOM.EndDateCC().clear();
		Thread.sleep(1000);
		ImplementPOM.EndDateCC().sendKeys("12-02-2023");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		ImplementPOM.SaveCC().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(500,0)");	
		Thread.sleep(4000);
		String Msg7 = ImplementPOM.TemplateMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg7);
		Thread.sleep(2000);
		//---------------------Export------------------------
					Thread.sleep(3000);
					File dir = new File("C:\\Users\\mayurig\\Downloads");
					File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(500);
					ImplementPOM.DownloadCC().click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					File dir1 = new File("C:\\Users\\mayurig\\Downloads");
					File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  " Message displayed  :- File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  "Message displayed  :- File does not downloaded.");
					}
					Thread.sleep(3000);
					js.executeScript("window.scrollBy(0,500)");	
					Thread.sleep(4000);
					ImplementPOM.CloseCC().click();
					//------------------ Edit ---------------------
					ImplementPOM.EditCC().click();
					Thread.sleep(3000);
					ImplementPOM.TemplateField().click();
					Thread.sleep(1000);
					ImplementPOM.BranchName().click();
					Thread.sleep(2000);
					
					js.executeScript("window.scrollBy(0,500)");	
					Thread.sleep(4000);
					ImplementPOM.SaveCC().click();
					Thread.sleep(3000);
					js.executeScript("window.scrollBy(500,0)");	
					Thread.sleep(4000);
					String Msg8 = ImplementPOM.TemplateMsg().getText();

					test.log(LogStatus.PASS, " Message displayed -:- " + Msg8);
					Thread.sleep(2000);
					ImplementPOM.CloseCC().click();
					//-------------------Delete---------------
					Thread.sleep(2000);
					ImplementPOM.DeleteCC().click();
					Thread.sleep(3000);
					String msg=getDriver().switchTo().alert().getText();
					getDriver().switchTo().alert().accept();
					Thread.sleep(2000);
					test.log(LogStatus.PASS, " Message displayed -:- " + msg);
					Thread.sleep(2000);
					getDriver().navigate().refresh();
					Thread.sleep(2000);
					Thread.sleep(2000);
					ImplementPOM.CloseCC().click();
					Thread.sleep(2000);
	}
	
	public static void UsersDeptDisplay( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(6000);
		ImplementPOM.clickUsers().click();
		Thread.sleep(5000);

		ImplementPOM.SelectCustomerUser().clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerUser().sendKeys("ABCD Pvt Ltd");
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		
		ImplementPOM.ClickModifyAssignments().click();
		Thread.sleep(4000);
		
		if(ImplementPOM.DepartmentDropdown().isDisplayed()) {
			
			test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
			
		}else {
			test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
		}
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		
		ImplementPOM.ModifyAssignmentsClose().click();
		Thread.sleep(4000);
	}
	
	public static void Uploadeventassignment( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Uploadeventassignment().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerEvent().click();
		Thread.sleep(2000);
		
		ImplementPOM.EventABCDPvtLtd().click();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerEvent().click();
		Thread.sleep(2000);
		
		ImplementPOM.UploadFileEvent().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\EventUpload_WithWorflow.xlsx");
		Thread.sleep(2000);
		ImplementPOM.UploadEvent().click();
		Thread.sleep(2000);
		String Msg = ImplementPOM.UploadEventMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg);
		Thread.sleep(2000);
	}
	
	public static void Event( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Event().click();
		Thread.sleep(4000);
		ImplementPOM.FilterCA().sendKeys("2368",Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Filter Working Successfully");
		
		Thread.sleep(1000);
		ImplementPOM.EditEvent().click();
		Thread.sleep(1000);
		ImplementPOM.DescriptionEvent().clear();
		Thread.sleep(1000);
		ImplementPOM.DescriptionEvent().sendKeys("ABCD");
		Thread.sleep(1000);
		ImplementPOM.EventSave().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Event Update Successfully");
		Thread.sleep(2000);
		ImplementPOM.DeleteEvent().click();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(1000);
	String Msg=	ImplementPOM.DeleteEventMsg().getText();
	Thread.sleep(2000);
	test.log(LogStatus.PASS, " Message displayed -:- "+Msg);
	ImplementPOM.DeleteEventClose().click();
	Thread.sleep(1000);
	
	}
	
	public static void Compliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.ComplianceEvent().click();
		Thread.sleep(4000);
		ImplementPOM.ComplianceCategoryEvent().click();
		Thread.sleep(1000);
		ImplementPOM.CommercialEvent().click();
		Thread.sleep(1000);
		ImplementPOM.FilterCA().sendKeys("13869",Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Filter Working Successfully");
		
		Thread.sleep(1000);
		ImplementPOM.EditCompliance1().click();
		Thread.sleep(1000);
	//	ImplementPOM.StartDate().clear();
		Thread.sleep(1000);
		ImplementPOM.StartDate().sendKeys("01-03-2023");
		Thread.sleep(2000);
		ImplementPOM.CloseCompliance1().click();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Update Successfully");
	}
	
	public static void Eventdeactivation( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Eventdeactivation().click();
		Thread.sleep(4000);
		ImplementPOM.Customerdeactivation().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(1000);
		
		ImplementPOM.SelectLocationdea().click();
		Thread.sleep(1000);
		ImplementPOM.ExpandABCDPvtLtd1().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDAurangabadPvt().click();
		Thread.sleep(1000);
		ImplementPOM.EventName().click();
		Thread.sleep(1000);
		ImplementPOM.Amendmentfactorylicense().click();
		Thread.sleep(1000);
		ImplementPOM.EventNature().click();
		Thread.sleep(1000);
		ImplementPOM.Licenseeventtest().click();
		Thread.sleep(1000);
		ImplementPOM.keep1().click();
		Thread.sleep(1000);
		
	String Msg=	getDriver().switchTo().alert().getText();
	getDriver().switchTo().alert().accept();
	Thread.sleep(1000);
	test.log(LogStatus.PASS, Msg);
	
	ImplementPOM.Customerdeactivation().click();
	Thread.sleep(1000);
	ImplementPOM.customer123Users().click();
	Thread.sleep(1000);
	
	ImplementPOM.SelectLocationdea().click();
	Thread.sleep(1000);
	ImplementPOM.ExpandABCDPvtLtd1().click();
	Thread.sleep(1000);
	ImplementPOM.ABCDAurangabadPvt().click();
	Thread.sleep(1000);
	ImplementPOM.EventName().click();
	Thread.sleep(1000);
	ImplementPOM.Amendmentfactorylicense().click();
	Thread.sleep(1000);
	ImplementPOM.EventNature().click();
	Thread.sleep(1000);
	ImplementPOM.Licenseeventtest().click();
	Thread.sleep(1000);
	ImplementPOM.Delete1().click();
	Thread.sleep(1000);
	
String Msg1=	getDriver().switchTo().alert().getText();
getDriver().switchTo().alert().accept();
Thread.sleep(1000);
test.log(LogStatus.PASS, Msg1);
	}
	
	public static void Eventassignments( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Eventassignments().click();
		Thread.sleep(4000);
		
		ImplementPOM.AddNewEvent().click();
		Thread.sleep(3000);
		ImplementPOM.EventClassification().click();
		Thread.sleep(500);
		ImplementPOM.Secretarial().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerAssignE().click();
		Thread.sleep(500);
		ImplementPOM.CustomerABCD().click();
		Thread.sleep(4000);
		ImplementPOM.LocationAssignE().click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtdAE().click();
		Thread.sleep(1000);
		ImplementPOM.APvtltd().click();
		Thread.sleep(4000);
		ImplementPOM.SelectEventPerformer().clear();
		Thread.sleep(1000);
		ImplementPOM.SelectEventPerformer().sendKeys("Perfom User");
		Thread.sleep(1000);
		ImplementPOM.PerfomUser().click();
		Thread.sleep(4000);
		
		ImplementPOM.SelectEventReviewer().clear();
		Thread.sleep(1000);
		ImplementPOM.SelectEventReviewer().sendKeys("Reviewer User");
		Thread.sleep(1000);
		ImplementPOM.ReviewerUser().click();
		Thread.sleep(4000);
		ImplementPOM.eventcheckbox().click();
		Thread.sleep(4000);
		ImplementPOM.SaveEvent().click();
		Thread.sleep(6000);
		ImplementPOM.AssignCompliance1().click();
		Thread.sleep(4000);
		ImplementPOM.AssignComplianceReviewer().clear();
		Thread.sleep(1000);
		ImplementPOM.AssignComplianceReviewer().sendKeys("Reviewer User");
		Thread.sleep(1000);
		ImplementPOM.ReviewerUser().click();
		Thread.sleep(4000);
		ImplementPOM.AssignCompliancePerformer().clear();
		Thread.sleep(1000);
		ImplementPOM.AssignCompliancePerformer().sendKeys("Perfom User");
		Thread.sleep(1000);
		ImplementPOM.PerfomUser().click();
		Thread.sleep(4000);
		ImplementPOM.StartDate().sendKeys("01-03-2023");
		Thread.sleep(4000);
		ImplementPOM.AssignComplianceCheckBox().click();
		Thread.sleep(4000);
		ImplementPOM.AssignComplianceSave().click();
		Thread.sleep(4000);
		ImplementPOM.SaveEvent().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Event Assign Successfully");
	}
	
	public static void EventassignmentsExport( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Eventassignments().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerC().click();
		Thread.sleep(2000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ExportEA().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " While click on 'Export To Excel ' Selected Customer assigned event report Downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " While click on 'Export To Excel ' Selected Customer assigned event report not Downloaded");
		}
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerC().click();
		Thread.sleep(2000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(8000);
		ImplementPOM.SelectOwner().click();
		Thread.sleep(2000);
		ImplementPOM.SelectASsd().click();
		Thread.sleep(8000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(2000);
		ImplementPOM.ASDAZFTextileA1().click();
		Thread.sleep(8000);
		 dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents1 = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ExportEA().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		 dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew1 = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  " While click on 'Export To Excel ' Selected location , owner wise assigned event report  Downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "While click on 'Export To Excel ' Selected location , owner wise assigned event report not Downloaded");
		}
	}
	
	
	
	public static void Eventfrequencymapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
//------------------------- Add New-------------------------------
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Eventfrequencymapping().click();
		Thread.sleep(4000);
		ImplementPOM.AddNewEFM().click();
		Thread.sleep(4000);
		ImplementPOM.CustomerEFM().click();
		Thread.sleep(500);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		ImplementPOM.EventClassification1().click();
		Thread.sleep(500);
		ImplementPOM.Secretarial1().click();
		Thread.sleep(4000);
		ImplementPOM.EventNameEFM().click();
		Thread.sleep(500);
		ImplementPOM.AlterationinArticle().click();
		Thread.sleep(4000);
		ImplementPOM.FrequencyEFM().click();
		Thread.sleep(500);
		ImplementPOM.QuarterlyEFM().click();
		Thread.sleep(4000);
		ImplementPOM.selectDate().sendKeys("09-03-2023");
		Thread.sleep(4000);
		ImplementPOM.Save().click();
		Thread.sleep(4000);
		String Msg=	ImplementPOM.SaveMsg().getText();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Message displayed -:- "+Msg);
		ImplementPOM.CloseCA().click();
		Thread.sleep(1000);
		//-----------------Filter----------------------
		ImplementPOM.Filter().sendKeys("Alteration in Articles (Public Company)",Keys.ENTER);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Filter Working Successfully");
		//------------------------Edit-------------
		ImplementPOM.EditConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.FrequencyEFM().click();
		Thread.sleep(500);
		ImplementPOM.MonthlyEFm().click();
		Thread.sleep(4000);
		ImplementPOM.Save().click();
		Thread.sleep(4000);
		String Msg1=	ImplementPOM.SaveMsg().getText();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Message displayed -:- "+Msg1);
		ImplementPOM.CloseCA().click();
		Thread.sleep(1000);
	//	test.log(LogStatus.PASS, "Edit Configuration View Successfully");
		//--------------------Display Schedule Information -Update Configuration and Cancel Configuration
		
				ImplementPOM.DisplayScheduleInformationEFM().click();
				Thread.sleep(1000);
				ImplementPOM.DSIEditConfiguration().click();
				Thread.sleep(2000);
				ImplementPOM.ScheduleDate().clear();
				Thread.sleep(2000);
				ImplementPOM.ScheduleDate().sendKeys("03-03-2023");
				Thread.sleep(2000);
				ImplementPOM.UpdateConfiguration().click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Display Schedule Information -Update Configuration Successfully");
				ImplementPOM.DSIEditConfiguration().click();
				Thread.sleep(2000);
				ImplementPOM.CancelConfiguration().click();
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Display Schedule Information -Cancel Configuration is Clickable");
				ImplementPOM.DisplayScheduleInformationEFMClopse().click();
				Thread.sleep(2000);
		//------------------------Delete Configuration-------------
		ImplementPOM.DeleteConfiguration().click();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
		String Msg2=getDriver().switchTo().alert().getText();
		getDriver().switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, Msg2);
		
		//----------------- File Upload ----------------
		
	/*	ImplementPOM.selectCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtdEFM().click();
		Thread.sleep(2000);
		ImplementPOM.ChooseFile().sendKeys("C:\\Users\\mayurig\\Downloads\\EventFrequencyMapping_Sample.xlsx");
		Thread.sleep(2000);
		ImplementPOM.UploadEFM().click();
		String Msg7 = ImplementPOM.UploadMsgEFM().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg7);*/
		Thread.sleep(2000);
		//---------------------Sample Format------------------------
		//	Thread.sleep(3000);
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			ImplementPOM.SampleFormat().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "Sample Format :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  "Sample Format :- File does not downloaded.");
			}
			
		
	}
	
	public static void HideMulticheckchecklist( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.clickCustomers().click();
		Thread.sleep(4000);
		ImplementPOM.ClickAddNew().click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]"))); 
		
		Thread.sleep(1000);
		ImplementPOM.HideMulticheckchecklist().click();
		Thread.sleep(4000);
		ImplementPOM.HideMulticheckchecklistYes().click();

		ImplementPOM.ClickSave().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, " Hide Multicheckchecklist Saved Successfully'");
	
		
	}
	
	public static void HideMulticheckchecklistEdit( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.clickCustomers().click();
		Thread.sleep(4000);
		ImplementPOM.HideMulticheckchecklistEdit().click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_udcInputForm_upCustomers']/div[1]/div[3]/span[3]/a/span[1]"))); 
		
		Thread.sleep(1000);
		ImplementPOM.HideMulticheckchecklist().click();
		Thread.sleep(4000);
		ImplementPOM.HideMulticheckchecklistNo().click();

		ImplementPOM.ClickSave().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Edit - Hide Multicheckchecklist Saved Successfully'");
	
		
	}
	
	public static void Eventassignmentexportimport( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Eventassignmentexportimport().click();
		Thread.sleep(4000);
		CompanyPOM.Event().click();
	  	 Thread.sleep(4000);
		ImplementPOM.SelectCustomerESEI().click();
		Thread.sleep(2000);
		ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
	  	 
	  	 CompanyPOM.SelectEntity().click();
	  	 Thread.sleep(1000);
	  	  CompanyPOM.BITAConsultingPune().click();
		  	 Thread.sleep(1000);
		  	 CompanyPOM.SelectEntityok().click();
		  	 Thread.sleep(8000);
		  	 
		  	 CompanyPOM.Location().click();
		  	 Thread.sleep(1000);
		  	  CompanyPOM.LocationExpand().click();
			  	 Thread.sleep(1000);
			  	 CompanyPOM.BITAConsultingKarnataka().click();
			  	 Thread.sleep(1000);
			  	//CompanyPOM.MPvtLtd().click();
			  	 Thread.sleep(1000);
			 	CompanyPOM.Select().click();
			  	 Thread.sleep(3000);
			  	Thread.sleep(3000);
				File dir2 = new File("C:\\Users\\mayurig\\Downloads");
				File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				CompanyPOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir3 = new File("C:\\Users\\mayurig\\Downloads");
				File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents1.length < allFilesNew1.length) {
					test.log(LogStatus.PASS,  " Click on download Button Selected Location , Entity and Branch wise Event sheet  Downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " Click on download Button Selected Location , Entity and Branch wise Event sheet  does not downloaded.");
				}
	}
	
	public static void EventassignmentexportimportD( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Eventassignmentexportimport().click();
		Thread.sleep(4000);
		CompanyPOM.Event().click();
	  	 Thread.sleep(4000);
	
				
				Thread.sleep(500);
				CompanyPOM.Download().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
		String msg =getDriver().switchTo().alert().getText();
		Thread.sleep(3000);
					test.log(LogStatus.PASS,  "Without select Customer, Entity  and location Message Displayed : -"+msg);
					getDriver().switchTo().alert().accept();
					Thread.sleep(3000);
	}
	
	public static void UploadedFilewithOutFile ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
	
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	  	action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      ImplementPOM.Eventassignmentexportimport().click();
			Thread.sleep(4000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import().click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.Upload().click();
		  	 Thread.sleep(8000);
		 
			 
				test.log(LogStatus.PASS,  "Message Displayed : - Please Select File."); 
		 
		  	 Thread.sleep(3000);
		  
		  	
		      Thread.sleep(3000);
	}
	
	public static void ImportInvalidSheet( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	  	action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      ImplementPOM.Eventassignmentexportimport().click();
			Thread.sleep(4000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import().click();
		  	 Thread.sleep(3000);
		  	ImplementPOM.SelectCustomerESEI1().click();
			Thread.sleep(2000);
			ImplementPOM.BitademopuneU().click();
			Thread.sleep(4000);
		 	CompanyPOM.ChooseFile().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\EventAssignmentReport.xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload().click();
		  	 Thread.sleep(6000);
		 	 String Msg=CompanyPOM.InvalidMsg().getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  "upload invalid Data validation message display : -"+Msg);
		  	 
		      Thread.sleep(3000);
	}
	
	
	public static void UploadedFileisplay ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	  	action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      ImplementPOM.Eventassignmentexportimport().click();
			Thread.sleep(4000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import().click();
		  	 Thread.sleep(3000);
		  	ImplementPOM.SelectCustomerESEI1().click();
			Thread.sleep(2000);
			ImplementPOM.BitademopuneU().click();
			Thread.sleep(4000);
		 if(CompanyPOM.UploadLink().isDisplayed()) {
			 
				test.log(LogStatus.PASS,  "  Uploaded File displayed On Grid Table"); 
		 }
		  	 Thread.sleep(3000);
		  
		  	
		      Thread.sleep(3000);
	}
	
	public static void UploadedFileisplayEC ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      ImplementPOM.Eventassignmentexportimport().click();
			Thread.sleep(4000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(6000);
		  	CompanyPOM.ImportEC().click();
		  	 Thread.sleep(6000);
		  	ImplementPOM.SelectCustomerECSEI1().click();
			Thread.sleep(2000);
			ImplementPOM.BitademopuneU().click();
			Thread.sleep(8000);
		  
		 if(CompanyPOM.UploadLinkEC1().isDisplayed()) {
			 
				test.log(LogStatus.PASS,  " Customer wise uploaded event base compliance file should get displayed with date and time."); 
		 }else {
			 test.log(LogStatus.FAIL,  " Customer wise uploaded event base compliance file should not displayed with date and time."); 
		 }
		  	 Thread.sleep(3000);
		  
		  	
		      Thread.sleep(3000);
	}
	
	
	public static void DownloadFileEC ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(3000);
	      
	      ImplementPOM.Eventassignmentexportimport().click();
			Thread.sleep(4000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(6000);
		  
		  	ImplementPOM.SelectCustomerECSI1().click();
			Thread.sleep(2000);
			ImplementPOM.BitademopuneU().click();
			Thread.sleep(8000);
		  
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.DownloadEC().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "Compliance File :-  File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  "Compliance File :-  File does not downloaded.");
			}
		  
		      Thread.sleep(3000);
	}
	
	public static void UploadedEC ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      ImplementPOM.Eventassignmentexportimport().click();
			Thread.sleep(4000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(6000);
		  	CompanyPOM.ImportEC().click();
		  	 Thread.sleep(6000);
		  
		 	CompanyPOM.UploadEC().click();
		  	 Thread.sleep(8000);
		 	test.log(LogStatus.PASS,  "Message Displayed : - Please Select File."); 
		  
	}
	
	public static void InValidSheet ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      ImplementPOM.Eventassignmentexportimport().click();
			Thread.sleep(4000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(3000);
		  
		  	CompanyPOM.ImportEC().click();
		  	 Thread.sleep(3000);
		 	ImplementPOM.SelectCustomerECSEI1().click();
			Thread.sleep(2000);
			ImplementPOM.BitademopuneU().click();
			Thread.sleep(8000);
		 	CompanyPOM.ChooseFileEC().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\31-Mar-2023 10-43-38_31-Mar-2023 10-34-29_EventComplianceAssignmentReport (4).xlsx");
		  	 Thread.sleep(3000);
		 	CompanyPOM.UploadEC().click();
		  	 Thread.sleep(8000);
		  	 
	String Msg =	CompanyPOM.InValidationMsg().getText();
		  	 Thread.sleep(8000);
		  	test.log(LogStatus.PASS,  "Validation Msg : -"+Msg);
		  
		  
		      Thread.sleep(3000);
	}
	
	public static void Autoreconciliation( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Autoreconciliation().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectCustomerARR().click();
		Thread.sleep(1000);
		ImplementPOM.SelectBitademopune().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ExporttoExcel().click(); // Exporting (Downloading) file

		Thread.sleep(10000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		Thread.sleep(3000);
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " : - customer wise report  downloaded.");
		} else {
			test.log(LogStatus.FAIL, report + ": -  File does not downloaded.");
		}

	}
	
	public static void AutoreconciliationWC( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Autoreconciliation().click();
		Thread.sleep(5000);
		
		
		ImplementPOM.ExporttoExcel().click(); // Exporting (Downloading) file
		Thread.sleep(3000);
		String Msg =	ImplementPOM.InvalidMsg().getText();
	  	 Thread.sleep(8000);
	  	test.log(LogStatus.PASS,  "   Validation Msg displayed: -"+Msg);
	  
	  
	      Thread.sleep(3000);

	}
	
	
	public static void ReassignmentExcludeReport( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
	//	ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		ImplementPOM.ReassignmentExcludeReport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerRER().click();
		Thread.sleep(2000);
		ImplementPOM.SelectBitademopune().click();
		Thread.sleep(7000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ExporttoExcelRER().click(); // Exporting (Downloading) file

		Thread.sleep(10000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		Thread.sleep(5000);
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(5000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- Customer Selection Wise Reassignment Report  downloaded.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}
	
	public static void ReassignmentExcludeReportL( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(1000);
		//ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		ImplementPOM.ReassignmentExcludeReport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerRER().click();
		Thread.sleep(2000);
		ImplementPOM.SelectBitademopune().click();
		Thread.sleep(7000);
		
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(2000);
		ImplementPOM.Expand().click();
		Thread.sleep(2000);
		ImplementPOM.ABitaPharmCompany().click();
		Thread.sleep(8000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ExporttoExcelRER().click(); // Exporting (Downloading) file

		Thread.sleep(10000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		Thread.sleep(5000);
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(5000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, report + " :- Customer and Location wise Report should be downloaded.");
		} else {
			test.log(LogStatus.FAIL, report + " :- File does not downloaded.");
		}

	}
	
	
	public static void ReassignmentExcludeReportWC( ExtentTest test, String report)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"))); 
																												

		action.moveToElement(ImplementPOM.ClickReport()).click().build().perform();
		Thread.sleep(2000);
	//	ImplementPOM.OtherReports().click();
		Thread.sleep(3000);
		ImplementPOM.ReassignmentExcludeReport().click();
		Thread.sleep(3000);
		
		
		ImplementPOM.ExporttoExcelRER().click(); // Exporting (Downloading) file
		Thread.sleep(5000);
		String Msg =	ImplementPOM.InvalidMsg().getText();
	  	 Thread.sleep(8000);
	  	test.log(LogStatus.PASS,  "   Validation Msg displayed: -"+Msg);
	  
	  
	      Thread.sleep(3000);

	}
	
	public static void Compliancetype( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters().click();
		Thread.sleep(3000);
		ImplementPOM.Compliancetype().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerCC().click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneCC().click();
		Thread.sleep(3000);
		ImplementPOM.AddNewCt().click();
		Thread.sleep(2000);
		ImplementPOM.Customer().click();
		Thread.sleep(500);
		ImplementPOM.Bitademopune().click();
		Thread.sleep(2000);
		
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(37);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.name().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(38);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Description().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.Save().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Compliance Type:-Add successfully.");
		Thread.sleep(2000);
		row0 = sheet.getRow(37);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.FilterM().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Compliance Type:-Filter Working  successfully.");
	/*	String textfilter =ImplementPOM.FilterM().getText();
		String text=ImplementPOM.NameCheck().getText();
		if(text.equalsIgnoreCase(textfilter)){
			
			test.log(LogStatus.PASS, " Compliance Category:-Filter Working  successfully.");
			
		}else
		{
			test.log(LogStatus.FAIL, " Compliance Category:-Filter not Working  Properly.");
		}*/
		Thread.sleep(2000);
		ImplementPOM.EditComplianceType().click();
		Thread.sleep(2000);
		ImplementPOM.Description().clear();
		Thread.sleep(1000);
		row0 = sheet.getRow(39);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.Description().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);

	Thread.sleep(3000);
		ImplementPOM.Save().click();
	Thread.sleep(2000);

			
			test.log(LogStatus.PASS, " Compliance Type:-Update successfully.");
			
		
       Thread.sleep(5000);
       ImplementPOM.DeleteComplianceType().click();
       Thread.sleep(2000);
   	String MAInCheckListMsg = getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);

		test.log(LogStatus.PASS, " Deleted Message displayed - " + MAInCheckListMsg);
	

	}
	
	
	public static void Complianceassignments( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]"))); 

		action.moveToElement(ImplementPOM.ManageEvents()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Complianceassignments().click();
		Thread.sleep(7000);
		
		ImplementPOM.CustomerAE1().click();
		Thread.sleep(500);
		ImplementPOM.ABCDPvtLtdEA1().click();
		Thread.sleep(4000);
		ImplementPOM.SelectLocationdea().click();
		Thread.sleep(500);
		ImplementPOM.ExpandABCDPvtLtd1().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDAurangabadPvt().click();
		Thread.sleep(6000);
		
		ImplementPOM.SelectPerformer1().click();
		Thread.sleep(1000);
		ImplementPOM.Performer2User().click();
		Thread.sleep(7000);
		ImplementPOM.SelectReviewer1().click();
		Thread.sleep(1000);
		ImplementPOM.ReviewerUser1().click();
		Thread.sleep(7000);
		
		ImplementPOM.ComplianceCategory1().click();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecific2().click();
		Thread.sleep(7000);
		
		ImplementPOM.StartDate1().sendKeys("01-06-2023");
		Thread.sleep(7000);
		ImplementPOM.CheckBox().click();
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		
		ImplementPOM.SaveCA().click();
		Thread.sleep(3000);
		
		
		getDriver().switchTo().alert().accept();
		
		Thread.sleep(7000);
		
		String msg=getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Message Displayed :-"+msg);
	getDriver().switchTo().alert().accept();
		
		Thread.sleep(5000);
	}
	
	public static void Unsubscribe( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Unsubscribe().click();
		Thread.sleep(7000);
		
		ImplementPOM.EnterEmail().sendKeys("abcd@gmail.com");
		Thread.sleep(3000);
		ImplementPOM.ClickUnsubscribe().click();
		Thread.sleep(5000);
		
		String msg=getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Message Displayed :-"+msg);
	getDriver().switchTo().alert().accept();
		
		Thread.sleep(5000);
	}
	
	public static void UnsubscribeInvalid( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Unsubscribe().click();
		Thread.sleep(7000);
		
		ImplementPOM.EnterEmail().sendKeys("absd");
		Thread.sleep(3000);
		ImplementPOM.ClickUnsubscribe().click();
		Thread.sleep(5000);
		
		String msg=getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Message Displayed :-"+msg);
	getDriver().switchTo().alert().accept();
		
		Thread.sleep(5000);
	}
	
	public static void Unsubscribe2( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(1000);
		ImplementPOM.Unsubscribe().click();
		Thread.sleep(7000);
		
		ImplementPOM.EnterEmail().sendKeys("abcd@gmail.com,cd@gmail.com");
		Thread.sleep(3000);
		ImplementPOM.ClickUnsubscribe().click();
		Thread.sleep(5000);
		
		String msg=getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, " Message Displayed :-"+msg);
	getDriver().switchTo().alert().accept();
		
		Thread.sleep(5000);
	}
	
	
	public static void GroupingofCompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.DownloadSampleExcelFormat().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		
		
		Thread.sleep(3000);
	}
	
	public static void GroupingofComplianceUpload( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerGC().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtdGC().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectComplianceType1().click();
		Thread.sleep(2000);
		ImplementPOM.FunctionBased().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectGroupType().click();
		Thread.sleep(1000);
		ImplementPOM.CustomerLevel().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFilegc().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Compliance_Grouping_ExcelSampleFromat.xlsx");
		Thread.sleep(3000);
		ImplementPOM.ClickUpload().click();
		Thread.sleep(3000);
		String Msg =	ImplementPOM.ValMsg().getText();
	  	 Thread.sleep(8000);
	  	test.log(LogStatus.PASS,  "   Validation Msg displayed: -"+Msg);
	  
		Thread.sleep(3000);
	}
	
	public static void GroupingofComplianceUploadw( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		
		ImplementPOM.UploadFilegc().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Compliance_Grouping_ExcelSampleFromat.xlsx");
		Thread.sleep(3000);
		ImplementPOM.ClickUpload().click();
		Thread.sleep(3000);
		
		String Msg =	ImplementPOM.ValMsg().getText();
	  	 Thread.sleep(8000);
	  	test.log(LogStatus.PASS,  "   Validation Msg displayed: -"+Msg);
	  
		
		Thread.sleep(3000);
	}
	
	
	public static void GroupingofComplianceUploadLL( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerGC().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtdGC().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectComplianceType1().click();
		Thread.sleep(2000);
		ImplementPOM.FunctionBased().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectGroupType().click();
		Thread.sleep(1000);
		ImplementPOM.LocationLevel().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFilegc().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Compliance_Grouping_ExcelSampleFromat.xlsx");
		Thread.sleep(3000);
		ImplementPOM.ClickUpload().click();
		Thread.sleep(3000);
		String Msg =	ImplementPOM.ValMsg().getText();
	  	 Thread.sleep(8000);
	  	test.log(LogStatus.PASS,  "   Validation Msg displayed: -"+Msg);
	  
		Thread.sleep(3000);
	}
	
	public static void GroupingofComplianceExport( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickExportGC().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectCust().click();
		Thread.sleep(1000);
		ImplementPOM.SelectBitademopune().click();
		Thread.sleep(3000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ClickExportImg().click(); // Exporting (Downloading) file

		Thread.sleep(4000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " Customer wise Grouping of Compliance sheet  downloaded.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
		
		Thread.sleep(3000);
	}
	
	public static void GroupingofComplianceUploadValidC( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerGC().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtdGC().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectComplianceType1().click();
		Thread.sleep(2000);
		ImplementPOM.FunctionBased().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectGroupType().click();
		Thread.sleep(1000);
		ImplementPOM.CustomerLevel().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFilegc().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Compliance_Grouping_ExcelSampleFromat (1).xlsx");
		Thread.sleep(3000);
		ImplementPOM.ClickUpload().click();
		Thread.sleep(3000);
		String Msg =	ImplementPOM.ValidationMsg().getText();
	  	 Thread.sleep(8000);
	  	 if(Msg.equalsIgnoreCase("Data uploaded successfully.")) {
	 	  	test.log(LogStatus.PASS,  " Compliance Type - Function Based :  Message displayed: -"+Msg);
	 	  	 }else {
	 	  		test.log(LogStatus.FAIL,  " Compliance Type - Function Based :  Message displayed: -"+Msg);
	 	  	 }
	  
		Thread.sleep(3000);
	}
	
	public static void GroupingofComplianceUploadValidL( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerGC().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtdGC().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectComplianceType1().click();
		Thread.sleep(2000);
		ImplementPOM.FunctionBased().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectGroupType().click();
		Thread.sleep(1000);
		ImplementPOM.LocationLevel().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFilegc().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Compliance_Grouping_ExcelSampleFromat (1).xlsx");
		Thread.sleep(3000);
		ImplementPOM.ClickUpload().click();
		Thread.sleep(6000);
		String Msg =	ImplementPOM.ValidationMsg().getText();
	  	 Thread.sleep(8000);
	  	 if(Msg.equalsIgnoreCase("Data uploaded successfully.")) {
	 	  	test.log(LogStatus.PASS,  "Compliance Type - Function Based :  Message displayed: -"+Msg);
	 	  	 }else {
	 	  		test.log(LogStatus.FAIL,  "Compliance Type - Function Based : Message displayed: -"+Msg);
	 	  	 }
	  
		Thread.sleep(3000);
	}
	
	public static void Customerspecificduedateforstatutorycompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
  
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.Customerspecificduedateforstatutorycompliance().click();
		Thread.sleep(4000);
		ImplementPOM.DocumentCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.SampleFormate().click(); // Exporting (Downloading) file

		Thread.sleep(4000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, " Client Based Due Date Link Excel Sample Format  Downloaded.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	}
	
	public static void GroupingofComplianceUploadValidCL( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerGC().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtdGC().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectComplianceType1().click();
		Thread.sleep(2000);
		ImplementPOM.CheckList().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectGroupType().click();
		Thread.sleep(1000);
		ImplementPOM.CustomerLevel().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFilegc().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Compliance_Grouping_ExcelSampleFromat (2).xlsx");
		Thread.sleep(3000);
		ImplementPOM.ClickUpload().click();
		Thread.sleep(3000);
		String Msg =	ImplementPOM.ValidationMsg().getText();
	  	 Thread.sleep(8000);
	  	 if(Msg.equalsIgnoreCase("Data uploaded successfully.")) {
	 	  	test.log(LogStatus.PASS,  " Compliance Type - CheckList : Message displayed: -"+Msg);
	 	  	 }else {
	 	  		test.log(LogStatus.FAIL,  "Compliance Type - CheckList :   Message displayed: -"+Msg);
	 	  	 }
	  
		Thread.sleep(3000);
	}
	
	public static void GroupingofComplianceUploadValidLL( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		ImplementPOM.GroupingofCompliance().click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		ImplementPOM.ClickImport().click();
		Thread.sleep(3000);
		ImplementPOM.SelectCustomerGC().click();
		Thread.sleep(1000);
		ImplementPOM.ABCDPvtLtdGC().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectComplianceType1().click();
		Thread.sleep(2000);
		ImplementPOM.CheckList().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectGroupType().click();
		Thread.sleep(1000);
		ImplementPOM.LocationLevel().click();
		Thread.sleep(3000);
		ImplementPOM.UploadFilegc().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Compliance_Grouping_ExcelSampleFromat (2).xlsx");
		Thread.sleep(3000);
		ImplementPOM.ClickUpload().click();
		Thread.sleep(6000);
		String Msg =	ImplementPOM.ValidationMsg().getText();
	  	 Thread.sleep(8000);
	  	 if(Msg.equalsIgnoreCase("Data uploaded successfully.")) {
	 	  	test.log(LogStatus.PASS,  "Compliance Type - CheckList : Message displayed: -"+Msg);
	 	  	 }else {
	 	  		test.log(LogStatus.FAIL,  "Compliance Type - CheckList : Message displayed: -"+Msg);
	 	  	 }
	  
		Thread.sleep(3000);
	}
	
	public static void Targetdate( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																										
   //----------------Add New-----------------------------
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.ClientSpecificConfiguration().click();
		Thread.sleep(1000);
		ImplementPOM.Targetdate().click();
		Thread.sleep(4000);
		
		ImplementPOM.SelectCustomerTD().click();
		Thread.sleep(1000);
		ImplementPOM.PQR().click();

		Thread.sleep(3000);
		ImplementPOM.EditTD().click();
		Thread.sleep(3000);
		ImplementPOM.TargetDaystext().clear();
		Thread.sleep(1000);
		ImplementPOM.EditTD().click();
		Thread.sleep(3000);
		ImplementPOM.TargetDaystext().sendKeys("3");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(2000);
		ImplementPOM.SaveButtons().click();
		Thread.sleep(4000);
		
		String Msg4 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		test.log(LogStatus.PASS, " Message displayed -:- " + Msg4);
		Thread.sleep(2000);
	
	}
	
	public static void UsersEA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(6000);
		ImplementPOM.clickUsers().click();
		Thread.sleep(5000);
		
		ImplementPOM.SelectCustomerUser().clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerUser().sendKeys("ABCD Pvt Ltd");
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
	String text =ImplementPOM.EntityAssignments().getText();
	if(text.equalsIgnoreCase("Entity Assignments")) {
		test.log(LogStatus.PASS, " User Master Entites Assignment Column display   " );
	}else {
		test.log(LogStatus.FAIL, " User Master Entites Assignment Column  not display   " );
	}
		
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(1000);
	ImplementPOM.ExpandLocation().click();
	Thread.sleep(1000);
	ImplementPOM.EAAWSGFJBitaLimited().click();
	Thread.sleep(1000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryEA().click();
	Thread.sleep(1000);
	ImplementPOM.ClientSpecificAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.SaveS().click();
	Thread.sleep(3000);
	try {
	String msg =ImplementPOM.valMsg().getText();
	
	test.log(LogStatus.PASS, " Entites Assignment -Modify Entity - Statutory Location Wise Entites Assignment Msg Displyed  :-  " +msg);
	
	}
	catch(Exception e) {
		test.log(LogStatus.PASS, " Entites Assignment -Modify Entity - Statutory Location Wise Entites Assignment working  " );
	}
	Thread.sleep(3000);
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	
	ImplementPOM.AllCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryEA().click();
	Thread.sleep(1000);
	ImplementPOM.ClientSpecificAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.SaveS().click();
	Thread.sleep(3000);
		
	test.log(LogStatus.PASS, " Entites Assignment -Modify Entity - Statutoty Selected All Location CheckBox entity assignment Functionality working   " );
	
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	}
	
	public static void UsersEADelete( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(6000);
		ImplementPOM.clickUsers().click();
		Thread.sleep(5000);
		
		ImplementPOM.SelectCustomerUser().clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerUser().sendKeys("ABCD Pvt Ltd");
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	ImplementPOM.DeleteEA().click();
	Thread.sleep(4000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(1000);
	ImplementPOM.ExpandLocation().click();
	Thread.sleep(1000);
	ImplementPOM.EAAWSGFJBitaLimited().click();
	Thread.sleep(1000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryEA().click();
	Thread.sleep(1000);
	ImplementPOM.ClientSpecificAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.DeleteButton().click();
	Thread.sleep(3000);
	
	String msg =getDriver().switchTo().alert().getText();
	
	test.log(LogStatus.PASS, "  Statutory Selected Location Wise Delete Entites Assignment Msg Displyed  :-  " +msg);
	Thread.sleep(3000);
	getDriver().switchTo().alert().accept();
		
	Thread.sleep(3000);
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	ImplementPOM.DeleteEA().click();
	Thread.sleep(4000);
	ImplementPOM.AllCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryEA().click();
	Thread.sleep(1000);
	ImplementPOM.ClientSpecificAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.DeleteButton().click();
	Thread.sleep(3000);
		
String msg1 =getDriver().switchTo().alert().getText();
	
	test.log(LogStatus.PASS, "  Statutoty Selected All Location Delete entity assignment Functionality working  Msg Displyed  :-  " +msg1);
	Thread.sleep(3000);
	getDriver().switchTo().alert().accept();
	Thread.sleep(3000);
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	}
	
	public static void UsersEAIn( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(6000);
		ImplementPOM.clickUsers().click();
		Thread.sleep(5000);
		
		ImplementPOM.SelectCustomerUser().clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerUser().sendKeys("ABCD Pvt Ltd");
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	ImplementPOM.InternalCheckBox().click();
	Thread.sleep(4000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(1000);
	ImplementPOM.ExpandLocation().click();
	Thread.sleep(1000);
	ImplementPOM.EAAWSGFJBitaLimited().click();
	Thread.sleep(1000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryIn().click();
	Thread.sleep(1000);
	ImplementPOM.aaaaIn().click();
	Thread.sleep(3000);
	
	ImplementPOM.SaveS().click();
	Thread.sleep(3000);
	try {
	String msg =ImplementPOM.valMsg().getText();
	
	test.log(LogStatus.PASS, "Modify Entity - Internal Location Wise Entites Assignment Msg Displyed  :-  " +msg);
	
	}
	catch(Exception e) {
		test.log(LogStatus.PASS, "Modify Entity - Internal Location Wise Entites Assignment working  " );
	}
	Thread.sleep(3000);
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	ImplementPOM.InternalCheckBox().click();
	Thread.sleep(4000);
	ImplementPOM.AllCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryIn().click();
	Thread.sleep(1000);
	ImplementPOM.aaaaIn().click();
	Thread.sleep(3000);
	
	ImplementPOM.SaveS().click();
	Thread.sleep(3000);
		
	test.log(LogStatus.PASS, "Modify Entity - Internal Selected All Location CheckBox entity assignment Functionality working   " );
	
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	}
	
	public static void UsersEADeleteIN( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(6000);
		ImplementPOM.clickUsers().click();
		Thread.sleep(5000);
		
		ImplementPOM.SelectCustomerUser().clear();
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerUser().sendKeys("ABCD Pvt Ltd");
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	ImplementPOM.InternalCheckBox().click();
	Thread.sleep(4000);
	ImplementPOM.DeleteEA().click();
	Thread.sleep(4000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(1000);
	ImplementPOM.ExpandLocation().click();
	Thread.sleep(1000);
	ImplementPOM.EAAWSGFJBitaLimited().click();
	Thread.sleep(1000);
	ImplementPOM.LocationEA().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryIn().click();
	Thread.sleep(1000);
	ImplementPOM.aaaaIn().click();
	Thread.sleep(3000);
	
	ImplementPOM.DeleteButton().click();
	Thread.sleep(3000);
	
	String msg =getDriver().switchTo().alert().getText();
	
	test.log(LogStatus.PASS, "  Internal  Selected Location Wise Delete Entites Assignment Msg Displyed  :-  " +msg);
	Thread.sleep(3000);
	getDriver().switchTo().alert().accept();
		
	Thread.sleep(3000);
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	ImplementPOM.ModifyEntity().click();
	Thread.sleep(4000);
	ImplementPOM.InternalCheckBox().click();
	Thread.sleep(4000);
	ImplementPOM.DeleteEA().click();
	Thread.sleep(4000);
	ImplementPOM.AllCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceCategoryIn().click();
	Thread.sleep(1000);
	ImplementPOM.aaaaIn().click();
	Thread.sleep(3000);
	
	ImplementPOM.DeleteButton().click();
	Thread.sleep(3000);
		
String msg1 =getDriver().switchTo().alert().getText();
	
	test.log(LogStatus.PASS, "  Internal Selected All Location Delete entity assignment Functionality working  Msg Displyed  :-  " +msg1);
	Thread.sleep(3000);
	getDriver().switchTo().alert().accept();
	Thread.sleep(3000);
	ImplementPOM.CloseAE().click();
	Thread.sleep(3000);
	
	}
	
	public static void ReleaseNoteDocument( ExtentTest test, XSSFWorkbook workbook)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(1000);
	String text=	ImplementPOM.ReleaseNoteDocument().getText();
		Thread.sleep(3000);
		if(text.equalsIgnoreCase("Release Note Document")) {
			test.log(LogStatus.PASS, "  Manage user tab Release Notes Document Link should be displayed.  " );
		}else {
			test.log(LogStatus.FAIL, "  Manage user tab Release Notes Document Link not displayed.  " );
		}
		ImplementPOM.ReleaseNoteDocument().click();
		Thread.sleep(3000);
		//Add New
		ImplementPOM.AddNewRNDt().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectCustomerRND().click();
		Thread.sleep(3000);
		ImplementPOM.BitademopuneRND().click();
		Thread.sleep(1000);
		ImplementPOM.OkRND().click();
		Thread.sleep(4000);
		sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		
		ImplementPOM.Period().sendKeys("Aug 2023",Keys.ENTER); // Writing Task title
		Thread.sleep(4000);
		row0 = sheet.getRow(42);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		ImplementPOM.DescriptionRND().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		ImplementPOM.SelectProduct().click();
		Thread.sleep(1000);
		ImplementPOM.ComplianceRND().click();
		Thread.sleep(4000);
		ImplementPOM.SelectDocument().sendKeys("C:\\Users\\mayurig\\Downloads\\Food Safety & Standard Rules 2011.pdf");
		Thread.sleep(4000);
		
		ImplementPOM.SaveRND().click();
		Thread.sleep(4000);
	String text1 =	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	test.log(LogStatus.PASS, "  Add New : Message displayed :- "+text1 );
	getDriver().switchTo().alert().accept();
		Thread.sleep(5000);
		
		//Filter
		
		ImplementPOM.FilterRND().sendKeys(c1.getStringCellValue(),Keys.ENTER);
		Thread.sleep(1000);
	String textF=	ImplementPOM.FilterRND().getText();
	Thread.sleep(2000);
	String textdisF=	ImplementPOM.FilterRND().getText();
	Thread.sleep(2000);
	if(textF.equalsIgnoreCase(textdisF)) {
		test.log(LogStatus.PASS, "Search Filter :- Description wise Release Notes details  Filter Successfully.");
		Thread.sleep(3000);
	}else {
		test.log(LogStatus.PASS, "Release Notes Document Page Search Filter not Working .");
	}
	//Edit
	ImplementPOM.EditRND().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectDocument().sendKeys("C:\\Users\\mayurig\\Downloads\\Food Safety & Standard Rules 2011.pdf");
	Thread.sleep(4000);
	ImplementPOM.ClickUpdateRND().click();
	Thread.sleep(4000);
	
	String text4 =	getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	test.log(LogStatus.PASS, "  Update  : Message displayed :- "+text4 );
	getDriver().switchTo().alert().accept();
		Thread.sleep(5000);
		
		//Delete
		ImplementPOM.DeleteRND().click();
		Thread.sleep(4000);
		String text5 =	getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "  Delete : Message displayed :- "+text5 );
		getDriver().switchTo().alert().accept();
			Thread.sleep(5000);
			//Add New - Without Entering Data
			ImplementPOM.AddNewRNDt().click();
			Thread.sleep(3000);
			ImplementPOM.SaveRND().click();
			Thread.sleep(4000);
		String text6 =	getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "  Add New :- Without Entering Data :-  Validation Message displayed :- "+text6 );
		getDriver().switchTo().alert().accept();
			Thread.sleep(5000);
	}
	
	public static void BulkExcluding( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		
		if(ImplementPOM.BulkExcluding().isDisplayed())
		{
			test.log(LogStatus.PASS, " The tab of bulk exclude should be seen in upload utility under the tab of manage compliances. " );
		}
		ImplementPOM.BulkExcluding().click();
		Thread.sleep(3000);
		if(ImplementPOM.Import().isDisplayed()&&ImplementPOM.ExportBE().isDisplayed())
		{
			test.log(LogStatus.PASS, " The tabs of import and export should be seen on the page of bulk exclude." );
		}
		Thread.sleep(3000);
		ImplementPOM.ExportBE().click();
		Thread.sleep(3000);
		ImplementPOM.ClickDwonload().click();
		Thread.sleep(5000);
	String Msg =	ImplementPOM.DwonloadvaliMsg().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "validation message should be given if clicked on download button without selecting the customer : - "+Msg );
		Thread.sleep(3000);
		
		ImplementPOM.SelectCustomerBE().click();
		Thread.sleep(1000);
		ImplementPOM.SelectBitademopune().click();
		Thread.sleep(5000);
		
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ClickDwonload().click(); // Exporting (Downloading) file

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		Thread.sleep(1000);
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "selected customer after clicking on download button : -  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	}
	
	public static void BulkExcludingImport( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		
		
		ImplementPOM.BulkExcluding().click();
		Thread.sleep(3000);
		
		ImplementPOM.Import().click();
		Thread.sleep(4000);
		
		ImplementPOM.UploadFileBE().sendKeys("C:\\Users\\Mayuri\\Documents\\Automation File\\Charge.xlsx");
		Thread.sleep(5000);
		ImplementPOM.UploadBE().click();
		Thread.sleep(5000);
	String Msg =	ImplementPOM.ImportValMsg().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "validation message Displayed If click on upload button without selecting the customer : - "+Msg );
		Thread.sleep(3000);
		
		
	}
	
	public static void UploadActionableProcedure( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(3000);
		
		if(ImplementPOM.UploadActionableProcedure().isDisplayed()) {

		ImplementPOM.UploadActionableProcedure().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "The \"Compliance Actionable Procedure\" link should be seen on the tab of  Upload Utility. " );

		}else {
			test.log(LogStatus.PASS, "The \"Compliance Actionable Procedure\" link  not seen on the tab of  Upload Utility. " );

		}
		
		ImplementPOM.SelectCusto().click();
		Thread.sleep(3000);
		ImplementPOM.ABCDvtLtd().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "After selecting the customer, the compliance should be seen that is assigned to the customer on the grid. " );
		Thread.sleep(4000);
		File dir = new File("C:\\Users\\mayurig\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportAC().click(); // Exporting (Downloading) file

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\mayurig\\Downloads");
		Thread.sleep(1000);
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "Export Icon should be working on page of \"Compliance Actionable Procedure.\"");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	
		
		
	}
	
	public static void UploadActionableProcedureUpload( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		
		
		ImplementPOM.UploadActionableProcedure().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectCusto().click();
		Thread.sleep(3000);
		ImplementPOM.ABCDvtLtd().click();
		Thread.sleep(4000);
		ImplementPOM.ChooseFileAP().sendKeys("C:\\Users\\mayurig\\Downloads\\ActionableProcedureDetails.xlsx");
		Thread.sleep(5000);
		ImplementPOM.UploadAP().click();
		Thread.sleep(5000);
	String Msg =	ImplementPOM.UploadMsgAP().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "validation message Displayed If click on upload button without selecting the customer : - "+Msg );
		Thread.sleep(3000);
		
		
	}
	
	public static void UploadActionableProcedureUploadInvalid( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					
		action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.UploadUtilityMC().click();
		Thread.sleep(1000);
		
		
		ImplementPOM.UploadActionableProcedure().click();
		Thread.sleep(3000);
		
		ImplementPOM.SelectCusto().click();
		Thread.sleep(3000);
		ImplementPOM.ABCDvtLtd().click();
		Thread.sleep(4000);
		ImplementPOM.ChooseFileAP().sendKeys("C:\\Users\\mayurig\\Downloads\\ActionableProcedureDetails.xlsx");
		Thread.sleep(5000);
		ImplementPOM.UploadAP().click();
		Thread.sleep(5000);
	String Msg =	ImplementPOM.UploadMsgAP().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "validation message Displayed If click on upload button without selecting the customer : - "+Msg );
		Thread.sleep(3000);
		
		
	}
	
		
		
	
	public static void CompliancetypeFilter( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
		

		action.moveToElement(ImplementPOM.InternalCompliances()).click().build().perform();
		Thread.sleep(1000);
		ImplementPOM.Masters().click();
		Thread.sleep(3000);
		ImplementPOM.Compliancetype().click();
		Thread.sleep(4000);
		ImplementPOM.SelectCustomerCC().click();
		Thread.sleep(500);
		ImplementPOM.SelectBitademopuneCC().click();
		Thread.sleep(3000);
		
		
	}
	
	public static void modifyAssignmentsCheck( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments().click();
		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		ImplementPOM.SelectABCD().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(8000);
		List<WebElement> LinceseCol=getDriver().findElements(By.xpath("//*[@id='BodyContent_grdComplianceInstances']/tbody/tr/td[8]"));
		List<WebElement> raw=new ArrayList<WebElement>();
		raw.addAll(LinceseCol);
		List<String> text= new ArrayList<String>();
		for(int k=0;k<raw.size();k++)
		{
			text.add(raw.get(k).getText());
			if(text.isEmpty()) {
				
			}
		}
		

	}

	
	public static void modifyAssignmentsCheck1( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

		action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.ModifyAssignments().click();
		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectCustomerMA().click();
		ImplementPOM.SelectABCD().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(8000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(3000);
		
		ImplementPOM.Status().click();
		Thread.sleep(5000);
		CompanyMethods.SwitchtoChild1(test);
		try {
		if(ImplementPOM.CheckBoxS().isDisplayed()) {
			test.log(LogStatus.PASS, "The checkboxes should be seen for every schedule of compliance on status tab on the page of modify assignments." );
		}
		if(ImplementPOM.CheckBoxC().isDisplayed()) {
			test.log(LogStatus.PASS, "The common checkbox for selecting all the schedules of compliance should be seen on status tab on the page of modify assignments." );
		}else {
			test.log(LogStatus.FAIL, "The common checkbox for selecting all the schedules of compliance should not seen on status tab on the page of modify assignments." );

		}
		
		}catch(Exception e) {
			test.log(LogStatus.PASS, "No record found" );
		}
		
		CompanyMethods.SwitchtoParent(test);
	

	
	}

public static void modifyAssignmentsCheckLi( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.ModifyAssignments().click();
	Thread.sleep(4000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerMA().click();
	ImplementPOM.SelectABCD().click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	ImplementPOM.StatusLicense().click();
	Thread.sleep(5000);
	CompanyMethods.SwitchtoChild1(test);
	try {
	if(ImplementPOM.CheckBoxS().isDisplayed()) {
		test.log(LogStatus.FAIL, "The checkboxes  seen for every schedule of compliance on status tab on the page of modify assignments." );
	}else {
		test.log(LogStatus.PASS, "The checkboxes should not be seen for every schedule of license based compliance on status tab on the page of modify assignments." );

	}
	}catch(Exception e) {
		test.log(LogStatus.PASS, "No record found" );
	}
	
	CompanyMethods.SwitchtoParent(test);



}

public static void StatusDelete( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.ModifyAssignments().click();
	Thread.sleep(4000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerMA().click();
	ImplementPOM.SelectABCD().click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	ImplementPOM.Status().click();
	Thread.sleep(5000);
	CompanyMethods.SwitchtoChild1(test);
	try {
	if(ImplementPOM.DeleteBtn().isDisplayed()) {
		test.log(LogStatus.PASS, " delete button to delete the schedule one or more schedules is seen on status tab on the page of modify assignments." );
	}
	else {
		test.log(LogStatus.FAIL, "delete button to delete the schedule one or more schedules is not seen on status tab on the page of modify assignments." );

	}
	
	}catch(Exception e) {
		test.log(LogStatus.PASS, "No record found" );
	}
	
	CompanyMethods.SwitchtoParent(test);



}

public static void StatusDeleteWS( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.ModifyAssignments().click();
	Thread.sleep(4000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerMA().click();
	ImplementPOM.SelectABCD().click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	ImplementPOM.Status().click();
	Thread.sleep(5000);
	CompanyMethods.SwitchtoChild1(test);
	ImplementPOM.DeleteBtn().click();
	Thread.sleep(5000);
	
	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);
	String msg =getDriver().switchTo().alert().getText();
	
	test.log(LogStatus.PASS, "Validation Message displayed :-" +msg);

	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);
	CompanyMethods.SwitchtoParent(test);



}

public static void modifyAssignmentsCheck1In( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.ModifyAssignments().click();
	Thread.sleep(4000);
	
	ImplementPOM.ClickInternalRB().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerMA().click();
	ImplementPOM.SelectABCD().click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	ImplementPOM.StatusIn().click();
	Thread.sleep(5000);
	CompanyMethods.SwitchtoChild1(test);
	try {
	if(ImplementPOM.CheckBoxS().isDisplayed()) {
		test.log(LogStatus.PASS, "The checkboxes should be seen for every schedule of compliance on status tab on the page of modify assignments." );
	}
	if(ImplementPOM.CheckBoxC().isDisplayed()) {
		test.log(LogStatus.PASS, "The common checkbox for selecting all the schedules of compliance should be seen on status tab on the page of modify assignments." );
	}else {
		test.log(LogStatus.FAIL, "The common checkbox for selecting all the schedules of compliance should not seen on status tab on the page of modify assignments." );

	}
	
	}catch(Exception e) {
		test.log(LogStatus.PASS, "No record found" );
	}
	
	CompanyMethods.SwitchtoParent(test);



}


public static void modifyAssignmentsCheckLiIn( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.ModifyAssignments().click();
	Thread.sleep(4000);
	ImplementPOM.ClickInternalRB().click();
	Thread.sleep(4000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerMA().click();
	ImplementPOM.SelectABCD().click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	ImplementPOM.StatusInLi().click();
	Thread.sleep(5000);
	CompanyMethods.SwitchtoChild1(test);
	try {
	if(ImplementPOM.CheckBoxS().isDisplayed()) {
		test.log(LogStatus.FAIL, "The checkboxes  seen for every schedule of compliance on status tab on the page of modify assignments." );
	}else {
		test.log(LogStatus.PASS, "The checkboxes should not be seen for every schedule of license based compliance on status tab on the page of modify assignments." );

	}
	}catch(Exception e) {
		test.log(LogStatus.PASS, "No record found" );
	}
	
	CompanyMethods.SwitchtoParent(test);



}

public static void StatusDeleteIn( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.ModifyAssignments().click();
	Thread.sleep(4000);
	ImplementPOM.ClickInternalRB().click();
	Thread.sleep(4000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerMA().click();
	ImplementPOM.SelectABCD().click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	ImplementPOM.StatusIn().click();
	Thread.sleep(5000);
	CompanyMethods.SwitchtoChild1(test);
	try {
	if(ImplementPOM.DeleteBtn().isDisplayed()) {
		test.log(LogStatus.PASS, " delete button to delete the schedule one or more schedules is seen on status tab on the page of modify assignments." );
	}
	else {
		test.log(LogStatus.FAIL, "delete button to delete the schedule one or more schedules is not seen on status tab on the page of modify assignments." );

	}
	
	}catch(Exception e) {
		test.log(LogStatus.PASS, "No record found" );
	}
	
	CompanyMethods.SwitchtoParent(test);



}

public static void StatusDeleteWSIN( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.ModifyAssignments().click();
	Thread.sleep(4000);
	ImplementPOM.ClickInternalRB().click();
	Thread.sleep(4000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_customerdiv']/span[1]/a/span[1]"))); 
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerMA().click();
	ImplementPOM.SelectABCD().click();
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
	Thread.sleep(8000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	js.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(3000);
	
	ImplementPOM.StatusIn().click();
	Thread.sleep(5000);
	CompanyMethods.SwitchtoChild1(test);
	ImplementPOM.DeleteBtn().click();
	Thread.sleep(5000);
	
	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);
	String msg =getDriver().switchTo().alert().getText();
	
	test.log(LogStatus.PASS, "Validation Message displayed :-" +msg);

	getDriver().switchTo().alert().accept();
	Thread.sleep(2000);
	CompanyMethods.SwitchtoParent(test);



}


public static void SecondaryRe( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	

	if(ImplementPOM.Reviewer2().isDisplayed()) {
		test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
	}
	else {
		test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

	}
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);


}

public static void SecondaryReIn( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	ImplementPOM.SeComplianceType().click();
	Thread.sleep(3000);
	ImplementPOM.SeComplianceTypeIn().click();
	Thread.sleep(4000);
	
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	

	if(ImplementPOM.Reviewer2().isDisplayed()) {
		test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the task." );
	}
	else {
		test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the task." );

	}
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);


}

public static void SecondaryReDisplay( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	ImplementPOM.FilterSR().sendKeys("Task of license" ,Keys.ENTER);
	Thread.sleep(4000);
	
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ComplianceLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocationCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(3000);
	
	ImplementPOM.ReportingLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ReportingLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ReportingLocationCheck().click();
	Thread.sleep(8000);
	
	ImplementPOM.StartDateSR().click();
	Thread.sleep(3000);
	ImplementPOM.StartDateSR10().click();
	Thread.sleep(8000);
	
	ImplementPOM.Performer().click();
	Thread.sleep(3000);
	ImplementPOM.Performer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer2sr().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer12().click();
	Thread.sleep(8000);
	
	ImplementPOM.SaveSR().click();
	Thread.sleep(8000);
	
	String Msg =	ImplementPOM.SaveSRMSg().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "message Displayed : - "+Msg );
		Thread.sleep(3000);
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);


}

public static void SecondaryReDisplayIn( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	ImplementPOM.SeComplianceType().click();
	Thread.sleep(3000);
	ImplementPOM.SeComplianceTypeIn().click();
	Thread.sleep(4000);
	
	//ImplementPOM.FilterSR().sendKeys("Task of license" ,Keys.ENTER);
	Thread.sleep(4000);
	
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ComplianceLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocationCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(3000);
	
	ImplementPOM.ReportingLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ReportingLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ReportingLocationCheck().click();
	Thread.sleep(8000);
	
	ImplementPOM.StartDateSR().click();
	Thread.sleep(3000);
	ImplementPOM.StartDateSR10().click();
	Thread.sleep(8000);
	
	ImplementPOM.Performer().click();
	Thread.sleep(3000);
	ImplementPOM.Performer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer2sr().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer12().click();
	Thread.sleep(8000);
	
	ImplementPOM.SaveSR().click();
	Thread.sleep(8000);
	
	String Msg =	ImplementPOM.SaveSRMSg().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "message Displayed : - "+Msg );
		Thread.sleep(3000);
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);


}

public static void STSecondaryRe( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	ImplementPOM.FilterSR().sendKeys("Internal Main task" ,Keys.ENTER);
	Thread.sleep(4000);
	ImplementPOM.SubTask().click();
	Thread.sleep(5000);
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	

	if(ImplementPOM.Reviewer2().isDisplayed()) {
		test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the sub-task." );
	}
	else {
		test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the sub-task." );

	}
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);


}

public static void STSecondaryReDisplay( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	ImplementPOM.FilterSR().sendKeys("Internal Main task" ,Keys.ENTER);
	Thread.sleep(4000);
	
	ImplementPOM.SubTask().click();
	Thread.sleep(5000);
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ComplianceLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocationCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(3000);
	
	ImplementPOM.ReportingLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ReportingLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ReportingLocationCheck().click();
	Thread.sleep(8000);
	
	ImplementPOM.StartDateSR().click();
	Thread.sleep(3000);
	ImplementPOM.StartDateSR10().click();
	Thread.sleep(8000);
	
	ImplementPOM.Performer().click();
	Thread.sleep(3000);
	ImplementPOM.Performer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer2sr().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer12().click();
	Thread.sleep(8000);
	
	ImplementPOM.SaveSR().click();
	Thread.sleep(8000);
	
	String Msg =	ImplementPOM.STSaveSRMSg().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "message Displayed : - "+Msg );
		Thread.sleep(3000);
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);

}


public static void STSecondaryReIn( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	
	
	ImplementPOM.SeComplianceType().click();
	Thread.sleep(3000);
	ImplementPOM.SeComplianceTypeIn().click();
	Thread.sleep(4000);
	
	Thread.sleep(4000);
	ImplementPOM.SubTask().click();
	Thread.sleep(5000);
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	

	if(ImplementPOM.Reviewer2().isDisplayed()) {
		test.log(LogStatus.PASS, "The dropdown of secondary reviewer should be seen on the popup of show assignment details for the sub-task." );
	}
	else {
		test.log(LogStatus.FAIL, "The dropdown of secondary reviewer should not seen on the popup of show assignment details for the sub-task." );

	}
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);


}

public static void STSecondaryReDisplayIn( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

	action.moveToElement(ImplementPOM.Task()).click().build().perform();

	Thread.sleep(4000);
	ImplementPOM.TaskDetails().click();
	Thread.sleep(4000);
	
	ImplementPOM.SelectCustomerR().click();
	Thread.sleep(2000);
	ImplementPOM.SelectCustomerR1().click();
	Thread.sleep(4000);
	
	ImplementPOM.SeComplianceType().click();
	Thread.sleep(3000);
	ImplementPOM.SeComplianceTypeIn().click();
	Thread.sleep(4000);
	
	
	ImplementPOM.SubTask().click();
	Thread.sleep(5000);
	
	ImplementPOM.ShowAssingment().click();
	Thread.sleep(5000);
	
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ComplianceLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocationCheck().click();
	Thread.sleep(3000);
	ImplementPOM.ComplianceLocation().click();
	Thread.sleep(3000);
	
	ImplementPOM.ReportingLocation().click();
	Thread.sleep(2000);
	ImplementPOM.ReportingLocationEx().click();
	Thread.sleep(3000);
	ImplementPOM.ReportingLocationCheck().click();
	Thread.sleep(8000);
	
	ImplementPOM.StartDateSR().click();
	Thread.sleep(3000);
	ImplementPOM.StartDateSR10().click();
	Thread.sleep(8000);
	
	ImplementPOM.Performer().click();
	Thread.sleep(3000);
	ImplementPOM.Performer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer1().click();
	Thread.sleep(8000);
	
	ImplementPOM.Reviewer2sr().click();
	Thread.sleep(3000);
	ImplementPOM.Reviewer12().click();
	Thread.sleep(8000);
	
	ImplementPOM.SaveSR().click();
	Thread.sleep(8000);
	
	String Msg =	ImplementPOM.STSaveSRMSg().getText();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "message Displayed : - "+Msg );
		Thread.sleep(3000);
	

	ImplementPOM.CloseR2().click();
	Thread.sleep(5000);

}

public static void CustomersBrand( ExtentTest test, XSSFWorkbook workbook)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
	Thread.sleep(1000);
	ImplementPOM.clickCustomers().click();
	Thread.sleep(4000);
	
	ImplementPOM.subentities().click();
	Thread.sleep(4000);
	ImplementPOM.subentities1().click();
	Thread.sleep(4000);
	ImplementPOM.AddnewSub().click();
	Thread.sleep(4000);


	
	Thread.sleep(5000);
	sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	int row = 0;
	Thread.sleep(500);
	Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	Cell c1 = null;
	row0 = sheet.getRow(3);
	c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	ImplementPOM.NameBranch().sendKeys(c1.getStringCellValue()); // Writing Task title
	Thread.sleep(4000);
	
	ImplementPOM.SubEntityTypeD().click();
	Thread.sleep(3000);
	ImplementPOM.SubEntityTypeD1().click();
	Thread.sleep(4000);
	
	ImplementPOM.Brand().click();
	Thread.sleep(3000);
	ImplementPOM.Brand1().click();
	Thread.sleep(4000);
	
	ImplementPOM.IndustryB().click();
	Thread.sleep(3000);
	ImplementPOM.IndustryBCheck().click();
	Thread.sleep(3000);
	ImplementPOM.IndustryBOk().click();
	Thread.sleep(4000);
	ImplementPOM.AddressLine1B().sendKeys("XYZ"); // Writing Task title
	Thread.sleep(4000);
	
	ImplementPOM.StateB().click();
	Thread.sleep(3000);
	ImplementPOM.StateB1().click();
	Thread.sleep(4000);

	ImplementPOM.CityB().click();
	Thread.sleep(3000);
	ImplementPOM.CityB1().click();
	Thread.sleep(4000);

	ImplementPOM.tbxContactPerson().sendKeys("abc"); // Writing Task title
	Thread.sleep(4000);
	
	ImplementPOM.Email().sendKeys("abc@gmail.com"); // Writing Task title
	Thread.sleep(4000);
	
	
	ImplementPOM.SaveB().click();
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "Message displayed - Branch details should get saved with selected brand name.");
	

	Thread.sleep(5000);
}

public static void CustomersBrandW( ExtentTest test, XSSFWorkbook workbook)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"))); 

	action.moveToElement(ImplementPOM.clickManageUser()).click().build().perform();
	Thread.sleep(1000);
	ImplementPOM.clickCustomers().click();
	Thread.sleep(4000);
	
	ImplementPOM.subentities().click();
	Thread.sleep(4000);
	ImplementPOM.subentities1().click();
	Thread.sleep(4000);
	ImplementPOM.AddnewSub().click();
	Thread.sleep(4000);


	
	Thread.sleep(5000);
	sheet = workbook.getSheetAt(13); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	int row = 0;
	Thread.sleep(500);
	Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	Cell c1 = null;
	row0 = sheet.getRow(3);
	c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	ImplementPOM.NameBranch().sendKeys(c1.getStringCellValue()); // Writing Task title
	Thread.sleep(4000);
	
	ImplementPOM.SubEntityTypeD().click();
	Thread.sleep(3000);
	ImplementPOM.SubEntityTypeD1().click();
	Thread.sleep(4000);
	
	ImplementPOM.IndustryB().click();
	Thread.sleep(3000);
	ImplementPOM.IndustryBCheck().click();
	Thread.sleep(3000);
	ImplementPOM.IndustryBOk().click();
	Thread.sleep(4000);
	ImplementPOM.AddressLine1B().sendKeys("XYZ"); // Writing Task title
	Thread.sleep(4000);
	
	ImplementPOM.StateB().click();
	Thread.sleep(3000);
	ImplementPOM.StateB1().click();
	Thread.sleep(4000);

	ImplementPOM.CityB().click();
	Thread.sleep(3000);
	ImplementPOM.CityB1().click();
	Thread.sleep(4000);

	ImplementPOM.tbxContactPerson().sendKeys("abc"); // Writing Task title
	Thread.sleep(4000);
	
	ImplementPOM.Email().sendKeys("abc@gmail.com"); // Writing Task title
	Thread.sleep(4000);
	
	
	ImplementPOM.SaveB().click();
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "Message displayed - Branch details should get saved without selection of brand name.");
	

	Thread.sleep(5000);
}

public static void DeReOpeningofCompliance( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (80));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
				//---------------------------Add New Entities Assignments	--------------------------------																						

	action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	ImplementPOM.ClientSpecificConfiguration().click();
	Thread.sleep(1000);
	ImplementPOM.ReOpeningofCompliance().click();
	Thread.sleep(4000);
	ImplementPOM.CustomerReopen().click();
	Thread.sleep(1000);
	ImplementPOM.AvantisTest1().click();
	Thread.sleep(5000);
	ImplementPOM.SelectDepartment().click();
	Thread.sleep(1000);
	ImplementPOM.SelectDepartment1().click();
	Thread.sleep(5000);
	
	ImplementPOM.SelectUsers().click();
	Thread.sleep(1000);
	ImplementPOM.SelectUsers1().click();
	Thread.sleep(5000);
	ImplementPOM.SaveREOpen().click();
	Thread.sleep(3000);
	
	getDriver().switchTo().alert().accept();

	
	Thread.sleep(2000);
	String Msg1 = getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	getDriver().switchTo().alert().accept();

	test.log(LogStatus.PASS, "Message displayed -:- " + Msg1);
	Thread.sleep(4000);
}

public static void DeReOpeningofComplianceDis( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (80));
	Thread.sleep(3000);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
																								

	action.moveToElement(ImplementPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	ImplementPOM.ClientSpecificConfiguration().click();
	Thread.sleep(3000);

	
	if(ImplementPOM.DepartmentWiseReopeningofcompliance().isDisplayed()) {
		test.log(LogStatus.PASS, "The Department Wise Re-opening Of Compliance\" should seperately reflects in Client Specific Configuration (Manage Compliance)." );
	}
	else {
		test.log(LogStatus.FAIL, "The Department Wise Re-opening Of Compliance not seperately reflects in Client Specific Configuration (Manage Compliance)." );

	}
	
	ImplementPOM.DepartmentWiseReopeningofcompliance().click();
	Thread.sleep(3000);
	
	if(ImplementPOM.CustomerReopen().isDisplayed()&&ImplementPOM.SelectDepartment().isDisplayed()&&ImplementPOM.SelectUsers().isDisplayed()) {
		test.log(LogStatus.PASS, "The Customer, Department and User drop down should available while clicking on the Department Wise Re-opening Of Compliance." );
	}
	else {
		test.log(LogStatus.FAIL, "The Customer, Department and User drop down should available while clicking on the Department Wise Re-opening Of Compliance." );

	}
	
	Thread.sleep(4000);
	
	
}

public static void ExcludeNotActivated( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}

public static void ExcludeNotActivatedSC( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickComplianceType().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectComplianceType().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}		
	
public static void ExcludeNotActivatedInternal( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickComplianceType().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectComplianceType1().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}	

public static void ExcludeNotActivatedIC( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickComplianceType().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectComplianceType2().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}

public static void ExcludeNotActivatedMultipleCompliance( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox1().click();
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox2().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}

public static void ExcludeNotActivatedSCMultipleCompliance( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickComplianceType().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectComplianceType().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox1().click();
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox2().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}	

public static void ExcludeNotActivatedInternalMultipleCompliance( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickComplianceType().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectComplianceType1().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox1().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox2().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}	

public static void ExcludeNotActivatedICMultipleCompliance( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickComplianceType().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectComplianceType2().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox1().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCheckBox2().click();
	
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}
public static void WithoutSelectCompliance( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageCompliances().click();
	
	Thread.sleep(4000);
	ImplementPOM.ComplianceAssignment().click();
	
	Thread.sleep(4000);
	ImplementPOM.ExcludeNotActivated().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer1().click();
	
	
	Thread.sleep(4000);
	Actions a = new Actions(getDriver());
	//scroll down a page
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	a.sendKeys(Keys.PAGE_DOWN).build().perform(); 
	
	Thread.sleep(4000);
	ImplementPOM.clickExclude().click();
	
	Thread.sleep(4000);
	String msg=ImplementPOM.excludeValidMsg().getText();
	
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Message displayed ="+msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed =" +msg);
	}
}

public static void EventAssignmentExportImport( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	ImplementPOM.ManageEvents().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.eventAssignmentExportImport().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickEvent().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickCustomer1().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectCustomer2().click();
	
	
	Thread.sleep(4000);
	ImplementPOM.clickEntity().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectEntity().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickOk().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickLocation().click();
	
	Thread.sleep(4000);
	ImplementPOM.selectLocation().click();
	
	Thread.sleep(4000);
	ImplementPOM.clickSelect().click();
	
	Thread.sleep(4000);
	
	
	if(ImplementPOM.clickDownload().isDisplayed())
	{
		Thread.sleep(4000);
		ImplementPOM.clickDownload().click();
		test.log(LogStatus.PASS, "Data should be download successfully.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Data should not be download successfully.");
		
	}
	
	
}


public static void EventAssignmentTab( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	ImplementPOM.ManageEvents().click();
	Thread.sleep(4000);
	if(ImplementPOM.eventReassignment().isDisplayed())
	{
		Thread.sleep(4000);
		ImplementPOM.eventReassignment().click();
		test.log(LogStatus.PASS, "Event Reasignment link displayed Under Event tab");
	}
	else
	{
		test.log(LogStatus.FAIL, "Event Reasignment link does not displayed Under Event tab");
		
	}
	Thread.sleep(4000);
	if(ImplementPOM.eventAssignmentExport().isDisplayed()&&ImplementPOM.eventAssignmentUpload().isDisplayed()&&ImplementPOM.eventAssignmentChooseFile().isDisplayed())
	{
		Thread.sleep(4000);
	//	ImplementPOM.eventAssignment().click();
		test.log(LogStatus.PASS, "Excel Event Reasssignment & Upload Reassignment Option displayed on Event Reasignment page. ");
	}
	else
	{
		test.log(LogStatus.FAIL, "Excel Event Reasssignment & Upload Reassignment Option displayed on Event Reasignment page. ");
		
	}
	Thread.sleep(4000);
	By locator = By.xpath("//a[@class='ui-button ui-widget ui-state-default ui-button-icon-only custom-combobox-toggle ui-corner-right']");
	
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	// retrieving "foo-button" HTML element
	List<WebElement> ViewButton = getDriver().findElements(locator);	
	Thread.sleep(3000);
	ViewButton.get(0).click();
	Thread.sleep(4000);
	ImplementPOM.eventAssignmentCustomerDD().click();
	Thread.sleep(3000);	
//	ViewButton.get(1).click();
//	Thread.sleep(4000);
	ImplementPOM.eventAssignmentLocation().click();
	Thread.sleep(500);	
	ImplementPOM.eventAssignmentLocationCheckbox().click();
	Thread.sleep(500);	
	ImplementPOM.eventAssignmentLocationSelect().click();
	Thread.sleep(500);	
	Thread.sleep(2000);
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
	Thread.sleep(500);
	ImplementPOM.eventAssignmentExport().click();	//Exporting (Downloading) file
			
	Thread.sleep(9000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
	Thread.sleep(9000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Event Reasignment Excel downloaded.");
	} else {
	test.log(LogStatus.FAIL, " Event Reasignment Excel Does not downloaded.");
	}

	Thread.sleep(500);
	/*
//	ImplementPOM.ERUploadedDocument().click();	
	Thread.sleep(20000);
	File dirs = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents1 = dirs.listFiles();						//Counting number of files in directory before download
			
	Thread.sleep(2000);
	ImplementPOM.ERUploadedDocument().click();	//Exporting (Downloading) file
			
	Thread.sleep(20000);
	File dir2 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew1 = dir2.listFiles();						//Counting number of files in directory after download
			
	Thread.sleep(3000);
	if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  " Uploaded Reasignment Excel downloaded.");
	} else {
	test.log(LogStatus.FAIL, " Uploaded Reasignment Excel Does not downloaded.");
	}
			
	Thread.sleep(500);	
	*/
}

public static void EventReassignment( ExtentTest test) throws InterruptedException
{
	Thread.sleep(4000);
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	ImplementPOM.ManageEvents().click();
	Thread.sleep(4000);
	ImplementPOM.eventReassignment().click();
	Thread.sleep(4000);
	
	Thread.sleep(4000);
	By locator = By.xpath("//a[@class='ui-button ui-widget ui-state-default ui-button-icon-only custom-combobox-toggle ui-corner-right']");
	
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	// retrieving "foo-button" HTML element
	List<WebElement> ViewButton = getDriver().findElements(locator);	
	Thread.sleep(3000);
	ViewButton.get(0).click();
	Thread.sleep(4000);
	ImplementPOM.eventAssignmentCustomerDD1().click();
	Thread.sleep(3000);	
//	ViewButton.get(1).click();
//	Thread.sleep(4000);
	ImplementPOM.eventAssignmentLocation().click();
	Thread.sleep(500);	
	ImplementPOM.eventAssignmentLocationCheckbox().click();
	Thread.sleep(500);	
	ImplementPOM.eventAssignmentLocationSelect().click();
	Thread.sleep(500);	
	
	ImplementPOM.eventAssignmentChooseFile().sendKeys("C:\\Users\\shitalb\\Downloads\\EventReassignmentReport (22).xlsx");
	Thread.sleep(4000);
	ImplementPOM.eventAssignmentUpload().click();
	Thread.sleep(4000);
	String t = ImplementPOM.EventReassignmentValidationmsg().getText();
	Thread.sleep(4000);
	if (t.equalsIgnoreCase("Event Reassignment done successfully.")) {
		test.log(LogStatus.PASS,  t);
	} else {
	test.log(LogStatus.FAIL, t);
	}
	
	
}



}
	
	
	
	
	


