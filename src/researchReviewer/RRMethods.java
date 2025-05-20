package researchReviewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import implementation.ImplementPOM;
import login.BasePage;

public class RRMethods extends BasePage {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	
	public static void MinistryMaster(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//-------------------------------Ministry Master - Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.MinistryMaster().click();
	      		  	 Thread.sleep(2000);
	      		  	RRLocators.MinistryMasterAddNew().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(4);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg = RRLocators.SaveMsg().getText();

	      			if (saveMsg.equalsIgnoreCase("Ministry saved successfully")) {
	      				test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
	      			} else {
	      				test.log(LogStatus.FAIL, "Message displayed -" + saveMsg );
	      			}
	      			RRLocators.Close().click();

	      		//-------------------------------Ministry Master -Check Dublication-------------------------------
	      	      
	      	      		  	 Thread.sleep(2000);
	      	      		  	RRLocators.MinistryMasterAddNew().click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  
	      	      			row0 = sheet.getRow(5);
	      	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	      			RRLocators.MinistryName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      	      			Thread.sleep(4000);
	      	      		 	RRLocators.Save().click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  	String saveMsg1 = RRLocators.SaveMsg().getText();

	      	      			
	      	      				test.log(LogStatus.PASS, " Check Dublication Validation Message displayed - " + saveMsg1);
	      	      			
	      	      			RRLocators.Close().click();

	      	      		//-------------------------------Ministry Master -Edit-------------------------------
	      		  	 
	      	      		row0 = sheet.getRow(4);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      	  	RRLocators.ClickEdit().click();
	      	  Thread.sleep(1000);
	      	  	RRLocators.MinistryName().clear();
	      	  	row0 = sheet.getRow(6);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg2 = RRLocators.SaveMsg().getText();

	      			
	      				test.log(LogStatus.PASS, "  Message displayed -" + saveMsg2);
	      			
	      			RRLocators.Close().click();
	      			 Thread.sleep(2000);
	      		//-------------------------------Ministry Master -Delete-------------------------------
	      			RRLocators.Filter().clear();
	      			 Thread.sleep(2000);
	      			row0 = sheet.getRow(6);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      			RRLocators.DeleteMinistryDetails().click();
	      			 Thread.sleep(2000);
	      			String DeleteMsg =getDriver() .switchTo().alert().getText();
	      			Thread.sleep(2000);
	      			getDriver().switchTo().alert().accept();
	      			Thread.sleep(2000);
	      			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
	}

	public static void RegulatorMaster(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//-------------------------------Regulator Master - Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.RegulatorMaster().click();
	      		  	 Thread.sleep(2000);
	      		  	RRLocators.MinistryMasterAddNew().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(8);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.RegulatorName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg = RRLocators.SaveMsg().getText();

	      			if (saveMsg.equalsIgnoreCase("Regulator saved successfully")) {
	      				test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
	      			} else {
	      				test.log(LogStatus.FAIL, "Message displayed -" + saveMsg );
	      			}
	      			RRLocators.Close().click();

	      		//-------------------------------Regulator Master -Check Dublication-------------------------------
	      	      
	      	      		  	 Thread.sleep(2000);
	      	      		  	RRLocators.MinistryMasterAddNew().click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  
	      	      			row0 = sheet.getRow(9);
	      	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	      			RRLocators.RegulatorName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      	      			Thread.sleep(4000);
	      	      		 	RRLocators.Save().click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  	String saveMsg1 = RRLocators.SaveMsg().getText();

	      	      			
	      	      				test.log(LogStatus.PASS, " Check Dublication Validation Message displayed - " + saveMsg1);
	      	      			
	      	      			RRLocators.Close().click();

	      	      		//-------------------------------Regulator Master -Edit-------------------------------
	      		  	 
	      	      		row0 = sheet.getRow(8);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      	  	RRLocators.ClickEdit().click();
	      	  Thread.sleep(1000);
	      	  	RRLocators.RegulatorName().clear();
	      	  	row0 = sheet.getRow(10);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.RegulatorName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg2 = RRLocators.SaveMsg().getText();

	      			
	      				test.log(LogStatus.PASS, "  Message displayed -" + saveMsg2);
	      			
	      			RRLocators.Close().click();
	      			 Thread.sleep(2000);
	      		//-------------------------------Ministry Master -Delete-------------------------------
	      			RRLocators.Filter().clear();
	      			 Thread.sleep(2000);
	      			row0 = sheet.getRow(10);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      			RRLocators.DeleteMinistryDetails().click();
	      			 Thread.sleep(2000);
	      			String DeleteMsg =getDriver() .switchTo().alert().getText();
	      			Thread.sleep(2000);
	      			getDriver().switchTo().alert().accept();
	      			Thread.sleep(2000);
	      			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
	}

	public static void ActDepartmentMaster(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//-------------------------------Department Master - Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.ActDepartmentMaster().click();
	      		  	 Thread.sleep(2000);
	      		  	RRLocators.MinistryMasterAddNew().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(12);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg = RRLocators.SaveMsg().getText();

	      			if (saveMsg.equalsIgnoreCase("Department saved successfully")) {
	      				test.log(LogStatus.PASS, "Message displayed -" + saveMsg);
	      			} else {
	      				test.log(LogStatus.FAIL, "Message displayed -" + saveMsg );
	      			}
	      			RRLocators.Close().click();

	      		//-------------------------------Department Master -Check Dublication-------------------------------
	      	      
	      	      		  	 Thread.sleep(2000);
	      	      		  	RRLocators.MinistryMasterAddNew().click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  
	      	      			row0 = sheet.getRow(13);
	      	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	      			RRLocators.MinistryName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      	      			Thread.sleep(4000);
	      	      		 	RRLocators.Save().click();
	      	      		  	 Thread.sleep(2000);
	      	      		  	 
	      	      		  	String saveMsg1 = RRLocators.SaveMsg().getText();

	      	      			
	      	      				test.log(LogStatus.PASS, " Check Dublication Validation Message displayed - " + saveMsg1);
	      	      			
	      	      			RRLocators.Close().click();

	      	      		//-------------------------------Department Master -Edit-------------------------------
	      		  	 
	      	      		row0 = sheet.getRow(12);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      	  	RRLocators.ClickEdit().click();
	      	  Thread.sleep(1000);
	      	  	RRLocators.MinistryName().clear();
	      	  	row0 = sheet.getRow(14);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.MinistryName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		 	RRLocators.Save().click();
	      		  	 Thread.sleep(2000);
	      		  	 
	      		  	String saveMsg2 = RRLocators.SaveMsg().getText();

	      			
	      				test.log(LogStatus.PASS, "  Message displayed -" + saveMsg2);
	      			
	      			RRLocators.Close().click();
	      			 Thread.sleep(2000);
	      		//-------------------------------Department Master -Delete-------------------------------
	      			RRLocators.Filter().clear();
	      			 Thread.sleep(2000);
	      			row0 = sheet.getRow(14);
	      	  		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      	  	RRLocators.Filter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
	      	  		Thread.sleep(4000);
	      			RRLocators.DeleteMinistryDetails().click();
	      			 Thread.sleep(2000);
	      			String DeleteMsg =getDriver() .switchTo().alert().getText();
	      			Thread.sleep(2000);
	      			getDriver().switchTo().alert().accept();
	      			Thread.sleep(2000);
	      			test.log(LogStatus.PASS, "Message displayed -" + DeleteMsg);
	}

	public static void ActAddNew(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.Act().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActAddNew().click();
	      		  	 Thread.sleep(3000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(16);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.Name().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		  RRLocators.Actgroup().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ActDemo().click();
	      		  	 Thread.sleep(3000);
	      		  	row0 = sheet.getRow(17);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.ActApplicabilityRules().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      			row0 = sheet.getRow(18);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.ShortForm().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		  RRLocators.CompanyType().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.SelectAll().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.Ok().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.BusinessActivity().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.SelectAllBA().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.OkBA().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActApplicability().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.SelectAllAA().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.OkAA().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.Type().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.Central().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.Category().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ClientSpecific().click();
	      		  	 Thread.sleep(3000);
	      		  	
	      			RRLocators.StartDate().sendKeys("23-03-2023"); // Writing Task title
	      			Thread.sleep(4000);
	      			 RRLocators.Industry().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.Agriculture().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.AgricultureOk().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActDocumentType().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ActRule().click();
	      		  	 Thread.sleep(4000);
	      		 // 	RRLocators.File().sendKeys("C:\\Users\\Mayuri\\Downloads\\Department.html"); // Writing Task title
	      			Thread.sleep(4000);
	      		  RRLocators.SaveAct().click();
	      		  	 Thread.sleep(1000);
	      		String Msg =   RRLocators.SaveActMsg().getText();
	      		  	 Thread.sleep(3000);
	      		  	test.log(LogStatus.PASS, "Message displayed -" + Msg);
	      		  RRLocators.CloseAct().click();
	      		  	 Thread.sleep(1000);
	}
	
	
	public static void Actupdate(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.Act().click();
	      		  	 Thread.sleep(3000);
	      			sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(16);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.FilterAct().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
	      			Thread.sleep(4000);
	      			
	      			 RRLocators.ActEdit().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.Country().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.CountryIndia().click();
	      		  	
	      		   Thread.sleep(3000);
	      		   RRLocators.ActDocumentType().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ActRule().click();
	      		  	 Thread.sleep(4000);
	      		   RRLocators.SaveAct().click();
	      		  	 Thread.sleep(8000);
	      		String Msg =   RRLocators.SaveActMsg().getText();
	      		  	
	      		  	test.log(LogStatus.PASS, "Message displayed -" + Msg);
	      		  	
	      	/*	  File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	      		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	      		Thread.sleep(6000);
	      		RRLocators.ClickDownload().click(); // Exporting (Downloading) file

	      		Thread.sleep(3000);// C://Users//jiya//Downloads//
	      		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	      		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	      		Thread.sleep(3000);
	      		if (dirContents.length < allFilesNew.length) {
	      			test.log(LogStatus.PASS, "  File downloaded successfully.");
	      		} else {
	      			test.log(LogStatus.FAIL,  "  File does not downloaded.");
	      		}*/
	      		  	
	      		  RRLocators.CloseAct().click();
	      		  	 Thread.sleep(3000);
	}
	
	
	public static void ActDelete(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Delete-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.Act().click();
	      		  	 Thread.sleep(3000);
	      			sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(16);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.FilterAct().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
	      			Thread.sleep(4000);
	      			
	      			 RRLocators.ActDelete().click();
	      		  	 Thread.sleep(3000);
	      		String Mag= getDriver() .switchTo().alert().getText();
	      		test.log(LogStatus.PASS, "Message displayed -" + Mag);
	      		 getDriver().switchTo().alert().accept();
	      		 Thread.sleep(3000);
	}
	
	
	public static void ActGroupAddNew(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.ActGroup().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActGroupAdd().click();
	      		  	 Thread.sleep(3000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(21);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.ActGroupName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		
	      			Thread.sleep(4000);
	      		  RRLocators.ActGroupSave().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActGroupFilter().sendKeys(c1.getStringCellValue(),Keys.ENTER);
	      		  	 Thread.sleep(3000);
	      	String msg=	   RRLocators.ActGroupText().getText();
	      	Thread.sleep(3000);
	      		if(msg.equalsIgnoreCase("ABCD")) {
	      		  	test.log(LogStatus.PASS, "Act Group Added Successfully." );
	      		}else {
	      			test.log(LogStatus.FAIL, "Act Group not Added " );
	      		}
	      		  
	}
	
	
	public static void MinistryMasterAddNew(ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]")));	//Wait until records table get visible.
//------------------------------- Add New-------------------------------
	      action.moveToElement(RRLocators.clickManageCompliance()).click().build().perform();
	      Thread.sleep(1000);
	      RRLocators.ActGroup().click();
	      		  	 Thread.sleep(3000);
	      		   RRLocators.ActGroupAdd().click();
	      		  	 Thread.sleep(3000);
	      		  	 
	      		  	sheet = workbook.getSheetAt(22); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
	      			int row = 0;
	      			Thread.sleep(500);
	      			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
	      			Cell c1 = null;
	      			row0 = sheet.getRow(21);
	      			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
	      			RRLocators.ActGroupName().sendKeys(c1.getStringCellValue()); // Writing Task title
	      			Thread.sleep(4000);
	      		
	      			Thread.sleep(4000);
	      		  RRLocators.ActGroupSave().click();
	      		  	 Thread.sleep(1000);
	      		   RRLocators.ActGroupFilter().sendKeys(c1.getStringCellValue(),Keys.ENTER);
	      		  	 Thread.sleep(3000);
	      	String msg=	   RRLocators.ActGroupSave().getText();
	      		if(msg.equalsIgnoreCase("ABCD")) {
	      		  	test.log(LogStatus.PASS, "Act Group Added Successfully." );
	      		}else {
	      			test.log(LogStatus.FAIL, "Act Group not Added " );
	      		}
	      		  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
