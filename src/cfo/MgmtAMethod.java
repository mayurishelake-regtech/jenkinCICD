package cfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

import approval.ApprovalcountPOM;
import auditor.AuditorcountPOM;
import login.BasePage;
import performer.OverduePOM;

public class MgmtAMethod extends BasePage{
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	public static List<WebElement> elementsList1 = null;
	
	public static void myTask( ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		Thread.sleep(3000);
		OverduePOM.ClickBtn().click();
		Thread.sleep(3000);
		CFOcountPOM.clickMyTask().click();
		Thread.sleep(4000);
		int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed

	//	wait.until(ExpectedConditions.invisibilityOf(OverduePOM.clickAddNew1()));		//Waiting for Add New button to get invisible. 
		Thread.sleep(3000);
		OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
		
		test.log(LogStatus.INFO, "------------- Statutory -------------");
		Thread.sleep(6000);
		OverduePOM.clickActFilter().click();					//Clicking on 'Act Filter' drop down.
		Select drp = new Select(OverduePOM.clickActFilter());
		drp.selectByIndex(2);										//Selecting third Act
		
		Thread.sleep(1000);
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickComplianceDropDown()));
		OverduePOM.clickComplianceDropDown().click();			//Clicking on 'Compliance' drop down.
		drp = new Select(OverduePOM.clickComplianceDropDown());
		drp.selectByIndex(1);										
		Thread.sleep(500);
   sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
		Cell c1 = null;
		row0= sheet.getRow(3);
		c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
	
	row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
	c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
	OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
	
	row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
	c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
	int day = (int) c1.getNumericCellValue();
	OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
	
  Select taskType=new Select(	OverduePOM.clickTaskType());
  taskType.selectByIndex(1);
  Thread.sleep(1000);

	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
	
	js.executeScript("window.scrollBy(0,2000)");
	row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
	c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
	OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
	
	row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
	c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
	OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
	
	row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
	c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
	OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
		
	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	Thread.sleep(1500);
//	String workingDir = System.getProperty("user.dir");
//	OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");
	
	Thread.sleep(1000);
	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
	
	Thread.sleep(500);
	String saveMsg = OverduePOM.taskSavedMsg().getText();
	OverduePOM.taskSavedMsg().click();
	
	if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
	}
	
	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
	Thread.sleep(3000);
	int total1 = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
	
	if(total1 > total)
	{
		test.log(LogStatus.PASS, "New Task added and displayed successfully.");
	}
	else
	{
		test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
	}
	
	//-----------------------------------Edit-----------------------------------------------
	
	OverduePOM.ClickEditBtn().click();
	Thread.sleep(5000);
	OverduePOM.clickStatutoryRB().click();
	Thread.sleep(5000);
	OverduePOM.clickTaskTitle().clear();
	Thread.sleep(1000);
	OverduePOM.clickTaskTitle().sendKeys("Auto1616");
	Thread.sleep(1000);
	OverduePOM.clickDescription().clear();
	Thread.sleep(1000);
	OverduePOM.clickDescription().sendKeys("AutomationTesting1212");
	Thread.sleep(1000);
	Thread.sleep(2000);
	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
	
	Thread.sleep(3000);
	String saveMsg1 = OverduePOM.EditSavedMsg().getText();
	OverduePOM.EditSavedMsg().click();
	Thread.sleep(3000);
	if(saveMsg1.equalsIgnoreCase("Task Updated Successfully."))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task Updated Successfully.'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task Updated Successfully.not displayed'");
	}
	Thread.sleep(1000);
	getDriver().findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button")).click();
	Thread.sleep(1000);
	Thread.sleep(500);
				
	Thread.sleep(500);
	
	Thread.sleep(5000);
	//-----------------------------------Show Assignment-----------------------------------------------
	
	OverduePOM.ClickShowAssignmentTask().click();
	Thread.sleep(5000);
	OverduePOM.ComplianceLocationTABCD().click();
	Thread.sleep(1000);
	OverduePOM.LPvtLtd().click();
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationT().click();
	Thread.sleep(1000);
	OverduePOM.ReportingLocation().click();
	Thread.sleep(1000);
	
	OverduePOM.ReportingLocationAB().click();
	Thread.sleep(1000);
	OverduePOM.ReportingLocationA().click();
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationT().click();
	Thread.sleep(2000);
	OverduePOM.Startdate().click();
	Thread.sleep(1000);
	OverduePOM.date18().click();
	Thread.sleep(2000);
	OverduePOM.ComplianceLocationT().click();
	Thread.sleep(3000);
	OverduePOM.TPerformer().click();	
	Thread.sleep(1000);
	
	OverduePOM.TabcExternal().click();	
	Thread.sleep(4000);
	OverduePOM.TReviewer().click();	
	Thread.sleep(1000);

	Thread.sleep(2000);
	OverduePOM.Tabclawyer().click();	
	Thread.sleep(2000);
	OverduePOM.SaveBtn().click();	
	Thread.sleep(2000);
	OverduePOM.CloseTab().click();	
	Thread.sleep(2000);
	
	
	
	
	//-----------------------------------Delete-----------------------------------------------
	OverduePOM.ClickDeleteTask().click();
	Thread.sleep(2000);
	String deleteMsg=getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Task?"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task?'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task? this msg not show'");
	}
	Thread.sleep(500);
	getDriver().switchTo().alert().accept();	
	Thread.sleep(2000);
	String DleMsg=OverduePOM.AfterClickDelete().getText();
	if(DleMsg.equalsIgnoreCase("Task can not delete, Task already assigned"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned this msg not show'");
	}	
		
	}
	
	public static void myTaskSubTask( ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		Thread.sleep(4000);
		//-------------------------------Create Sub Task--------------------------------------
	  
	  	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
	  	int no = elementsList1.size();

	  	Thread.sleep(2000);
	  	elementsList1.get(3).click();

	  	Thread.sleep(4000);

	  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
	  	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
	  	Thread.sleep(3000);
	  	 sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  		int row = 0;
	  		Thread.sleep(500);
	  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
	  		Cell c11 = null;
	  		row01= sheet.getRow(10);
	  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

	  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
	  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
	  	OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

	  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
	  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
	  	int day1 = (int) c11.getNumericCellValue();
	  	OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

	  	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

	  	js.executeScript("window.scrollBy(0,2000)");
	  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
	  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
	  	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

	  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
	  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
	  	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

	  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
	  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
	  	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
	  		
	  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	  	Thread.sleep(1500);
	  	//String workingDir = System.getProperty("user.dir");
	 // 	OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

	  	Thread.sleep(1000);
	  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
	  	Thread.sleep(500);
	  	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

	  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
	  		
	  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
	  	try
	  	{
	  		Thread.sleep(700);
	  		if(OverduePOM.checkRecordsTable().isDisplayed())
	  		{
	  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
	  		}
	  	}
	  	catch(Exception e)
	  	{
	  		
	  	}
	  	
	  	//----------------------Edit---------------------------------------
	  	
		OverduePOM.SubTaskEdit().click();	
		Thread.sleep(3000);
		OverduePOM.clickTaskTitle().clear();
		Thread.sleep(1000);
		row01= sheet.getRow(16);
  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());
		
	Thread.sleep(2000);
  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
  	Thread.sleep(1000);
  	String updateMsg1 = OverduePOM.UpdateMsg().getText();	//Msg = Subtask Saved Successfully.

  	test.log(LogStatus.INFO, "Message displayed - '"+ updateMsg1 +"'");
  		
  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
  
	//----------------------Show Assignment---------------------------------------
  	
  	OverduePOM.ClickShowAssignment().click();	
  	Thread.sleep(5000);
	OverduePOM.ComplianceLocationST().click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationACD().click();	
	Thread.sleep(1000);
	OverduePOM.CLLPvt().click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationST().click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocation().click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationAB().click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationA().click();	
	Thread.sleep(2000);
	OverduePOM.Startdate().click();	
	Thread.sleep(1000);
	OverduePOM.date18().click();	
	Thread.sleep(2000);
	OverduePOM.STPerformer().click();	
	Thread.sleep(1000);
	//OverduePOM.STPerformerText().sendKeys("abc External");	
	//Thread.sleep(1000);
	OverduePOM.abcExternal().click();	
	Thread.sleep(4000);
	OverduePOM.Reviewer().click();	
	Thread.sleep(1000);
//	OverduePOM.ReviewerText().sendKeys("abc lawyer");
	Thread.sleep(2000);
	OverduePOM.abclawyer().click();	
	Thread.sleep(2000);
	OverduePOM.SaveBtn().click();	
	Thread.sleep(2000);
String msg=	OverduePOM.TAmsg().getText();	
	Thread.sleep(2000);
	
	test.log(LogStatus.PASS, "Message displayed - "+msg);
	Thread.sleep(2000);
	OverduePOM.CloseTab().click();	
	Thread.sleep(2000);
  	
	//----------------------Delete---------------------------------------
	Thread.sleep(3000);
  	OverduePOM.SubTaskDelete().click();
  	Thread.sleep(1000);
  	String deleteMsg=getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Sub task?"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task?'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task? this msg not show'");
	}
	Thread.sleep(500);
	getDriver().switchTo().alert().accept();	
	Thread.sleep(2000);
	String DleMsg=OverduePOM.STAfterClickDelete().getText();
	if(DleMsg.equalsIgnoreCase("Sub Task can not delete, Sub task already assigned"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assigned'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assignedthis msg not show'");
	}	
	Thread.sleep(2000);
	OverduePOM.BacktoTask().click();
	Thread.sleep(3000);
	OverduePOM.clickDashboard().click();
	Thread.sleep(4000);
	}
	
	public static void myTaskInternal( ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{

		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		Thread.sleep(3000);
		OverduePOM.ClickBtn().click();
		Thread.sleep(3000);
		CFOcountPOM.clickMyTask().click();
		Thread.sleep(4000);
		int total = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed

		Thread.sleep(3000);
		OverduePOM.clickAddNew1().click();					//Clicking on 'Add New' button
		Thread.sleep(6000);
		test.log(LogStatus.INFO, "------------- Internal -------------");
		
		OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
		Thread.sleep(5000); 
		Select drp = new Select(OverduePOM.clickInternalCompliance());
		drp.selectByIndex(1);
		Thread.sleep(5000);
		
	   sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row);					//Selected 0th index row (First row)
			Cell c1 = null;
			row0= sheet.getRow(3);
			c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
		OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
		Thread.sleep(1000);
		row0 = sheet.getRow(4);							//Selected 1st index row (Second row)
		c1 = row0.getCell(1);							//Selected cell (1 row,2 column)
		OverduePOM.clickDescription().sendKeys(c1.getStringCellValue());	//Writing description
		
		row0 = sheet.getRow(5);							//Selected 2nd index row (Third row)
		c1 = row0.getCell(1);							//Selected cell (2 row,2 column)
		int day = (int) c1.getNumericCellValue();
		OverduePOM.clickDueDay().sendKeys(""+day+"");	//Writing Due days
		
	  Select taskType=new Select(	OverduePOM.clickTaskType());
	  taskType.selectByIndex(1);
	  Thread.sleep(2000);

		OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox
		
		js.executeScript("window.scrollBy(0,2000)");
		row0 = sheet.getRow(6);							//Selected 3rd index row (Fourth row)
		c1 = row0.getCell(1);							//Selected cell (3 row,2 column)
		OverduePOM.clickConditionalMessage().sendKeys(c1.getStringCellValue());	//Writing condition message
		
		row0 = sheet.getRow(7);							//Selected 4th index row (Fifth row)
		c1 = row0.getCell(1);							//Selected cell (4 row,2 column)
		OverduePOM.clickYesMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'Yess message' text box
		
		row0 = sheet.getRow(8);							//Selected 5th index row (Sixth row)
		c1 = row0.getCell(1);							//Selected cell (5 row,2 column)
		OverduePOM.clickNoMsg().sendKeys(c1.getStringCellValue());	//Writing message in 'No message' text box
			
		js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
		Thread.sleep(1500);
	//	String workingDir = System.getProperty("user.dir");
	//	OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");
		
		Thread.sleep(1000);
		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		
		Thread.sleep(500);
		String saveMsg = OverduePOM.taskSavedMsg().getText();
		OverduePOM.taskSavedMsg().click();
		
		if(saveMsg.equalsIgnoreCase("Task Saved Successfully."))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task Saved Successfully'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task already exist.'");
		}
		
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();
		Thread.sleep(1000);
		
		int total1 = Integer.parseInt(OverduePOM.readReminder1().getText());	//Reading total records displayed
		
		if(total1 > total)
		{
			test.log(LogStatus.PASS, "New Task added and displayed successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Task doesn't added and displayed.");
				
		}
		
		//----------------------Edit Internal---------------------------------------
		OverduePOM.ClickEditBtnIn().click();
		Thread.sleep(1000); 
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickInternaRadioButton()));
		Thread.sleep(500); 
		OverduePOM.clickInternaRadioButton().click();	//Clicking on Radio button of 'Internal' tasks
		Thread.sleep(500); 
		
		OverduePOM.clickTaskTitle().clear();
		Thread.sleep(1000);
		row0= sheet.getRow(17);
		c1 = row0.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	OverduePOM.clickTaskTitle().sendKeys(c1.getStringCellValue());	//Writing Task title
	
		
		Thread.sleep(3000);
		OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
		
		Thread.sleep(4000);
		String saveMsg1 = OverduePOM.EditSavedMsg().getText();
		OverduePOM.EditSavedMsg().click();
		Thread.sleep(3000);
		if(saveMsg1.equalsIgnoreCase("Task Updated Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed - 'Task Updated Successfully.'");
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed - 'Task Updated Successfully.' not shown");
		}
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//*[@id='divTaskDetailsDialog']/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		
		//-----------------------------------Show Assignment - Internal-----------------------------------------------
		
		OverduePOM.ClickShowAssignmentTaskIn().click();
		Thread.sleep(5000);
		OverduePOM.ComplianceLocationTABCD().click();
		Thread.sleep(1000);
		OverduePOM.BPvtLtd().click();
		Thread.sleep(1000);
		OverduePOM.ComplianceLocationT().click();
		Thread.sleep(1000);
		OverduePOM.ReportingLocation().click();
		Thread.sleep(1000);
		
		OverduePOM.ReportingLocationAB().click();
		Thread.sleep(1000);
		OverduePOM.ReportingLocationA().click();
		Thread.sleep(1000);
		OverduePOM.ComplianceLocationT().click();
		Thread.sleep(4000);
		OverduePOM.Startdate().click();
		Thread.sleep(1000);
		OverduePOM.date18().click();
		Thread.sleep(2000);
		OverduePOM.ComplianceLocationT().click();
		Thread.sleep(3000);
		OverduePOM.TPerformer().click();	
		Thread.sleep(1000);
		
		OverduePOM.TabcExternal().click();	
		Thread.sleep(4000);
		OverduePOM.TReviewer().click();	
		Thread.sleep(1000);

		Thread.sleep(2000);
		OverduePOM.Tabclawyer().click();	
		Thread.sleep(2000);
		OverduePOM.SaveBtn().click();	
		Thread.sleep(2000);
		OverduePOM.CloseTab().click();	
		Thread.sleep(2000);
		
		
		
		
		//-----------------------------------Delete-----------------------------------------------
		OverduePOM.ClickDeleteTaskIn().click();
		Thread.sleep(2000);
		String deleteMsg=getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Task?"))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task?'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Task? this msg not show'");
		}
		Thread.sleep(500);
		getDriver().switchTo().alert().accept();	
		Thread.sleep(2000);
		String DleMsg=OverduePOM.AfterClickDelete().getText();
		if(DleMsg.equalsIgnoreCase("Task can not delete, Task already assigned"))
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned'");
		}
		else
		{
			test.log(LogStatus.INFO, "Message displayed - 'Task can not delete, Task already assigned this msg not show'");
		}	
			

	}
	
	public static void myTaskSubTaskIn( ExtentTest test,XSSFWorkbook workbook)throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		Thread.sleep(4000);
		//-------------------------------Create Sub Task--------------------------------------
	  
	  	elementsList1 = OverduePOM.clickSubTask();	//Getting all Sub Task elements list
	  	int no = elementsList1.size();

	  	Thread.sleep(2000);
	  	elementsList1.get(2).click();

	  	Thread.sleep(4000);

	  	wait.until(ExpectedConditions.visibilityOf(OverduePOM.clickAddNew2()));	//Wait till 'Add New' button gets visible in Sub Task
	  	OverduePOM.clickAddNew2().click();			//Clicking on 'Add New' in Sub Task.
	  	Thread.sleep(3000);
	  	 sheet = workbook.getSheetAt(14);					//Retrieving fourth sheet of Workbook(Named - Update Tasks)
	  		int row = 0;
	  		Thread.sleep(500);
	  		Row row01 = sheet.getRow(row);					//Selected 0th index row (First row)
	  		Cell c11 = null;
	  		row01= sheet.getRow(10);
	  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
	  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());	//Writing Task title

	  	row01 = sheet.getRow(11);							//Selected 1st index row (Second row)
	  	c11 = row01.getCell(1);							//Selected cell (1 row,2 column)
	  	OverduePOM.clickDescription().sendKeys(c11.getStringCellValue());	//Writing description

	  	row01 = sheet.getRow(12);							//Selected 2nd index row (Third row)
	  	c11 = row01.getCell(1);							//Selected cell (2 row,2 column)
	  	int day1 = (int) c11.getNumericCellValue();
	  	OverduePOM.clickDueDay().sendKeys(""+day1+"");	//Writing Due days

	  	OverduePOM.clickConditionCheckbox().click();	//Clicking on 'Is Task Conditional' checkbox

	  	js.executeScript("window.scrollBy(0,2000)");
	  	row01 = sheet.getRow(13);							//Selected 3rd index row (Fourth row)
	  	c11 = row01.getCell(1);							//Selected cell (3 row,2 column)
	  	OverduePOM.clickConditionalMessage().sendKeys(c11.getStringCellValue());	//Writing condition message

	  	row01 = sheet.getRow(14);							//Selected 4th index row (Fifth row)
	  	c11 = row01.getCell(1);							//Selected cell (4 row,2 column)
	  	OverduePOM.clickYesMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'Yess message' text box

	  	row01 = sheet.getRow(15);							//Selected 5th index row (Sixth row)
	  	c11 = row01.getCell(1);							//Selected cell (5 row,2 column)
	  	OverduePOM.clickNoMsg().sendKeys(c11.getStringCellValue());	//Writing message in 'No message' text box
	  		
	  	js.executeScript("window.scrollBy(0,1000)");	//Scrolling down window by 2000 px.
	  	Thread.sleep(1500);
	  	//String workingDir = System.getProperty("user.dir");
	 // 	OverduePOM.SampleFormUpload().sendKeys("C:/March2022/PerformerPom/Reports/PerformerResults.html");

	  	Thread.sleep(1000);
	  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
	  	Thread.sleep(500);
	  	String saveMsg1 = OverduePOM.taskSavedMsg1().getText();	//Msg = Subtask Saved Successfully.

	  	test.log(LogStatus.INFO, "Message displayed - '"+ saveMsg1 +"'");
	  		
	  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
	  	try
	  	{
	  		Thread.sleep(700);
	  		if(OverduePOM.checkRecordsTable().isDisplayed())
	  		{
	  			test.log(LogStatus.PASS, "New Sub Task added and displayed successfully.");
	  		}
	  		else
	  		{
	  			test.log(LogStatus.FAIL, "New Sub Task doesn't added and displayed.");
	  		}
	  	}
	  	catch(Exception e)
	  	{
	  		
	  	}
	  	
	  	//----------------------Edit---------------------------------------
	  	
		OverduePOM.SubTaskEdit().click();	
		Thread.sleep(3000);
		OverduePOM.clickTaskTitle().clear();
		Thread.sleep(1000);
		row01= sheet.getRow(16);
  		c11 = row01.getCell(1);						//Selected cell (0 row,2 column)	(2 column = third column)
  	OverduePOM.clickTaskTitle().sendKeys(c11.getStringCellValue());
		
	Thread.sleep(2000);
  	OverduePOM.clickSaveButton().click();		//Clicking on 'Save' Button
  	Thread.sleep(1000);
  	String updateMsg1 = OverduePOM.UpdateMsg().getText();	//Msg = Subtask Saved Successfully.

  	test.log(LogStatus.INFO, "Message displayed - '"+ updateMsg1 +"'");
  		
  	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")).click();		//Closing the Sub Task form.
  
	//----------------------Show Assignment---------------------------------------
  	
  	OverduePOM.ClickShowAssignment().click();	
  	Thread.sleep(5000);
	OverduePOM.ComplianceLocationST().click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationACD().click();	
	Thread.sleep(1000);
	OverduePOM.CLLPvt().click();	
	Thread.sleep(1000);
	OverduePOM.ComplianceLocationST().click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocation().click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationAB().click();	
	Thread.sleep(1000);
	OverduePOM.ReportingLocationA().click();	
	Thread.sleep(2000);
	OverduePOM.Startdate().click();	
	Thread.sleep(1000);
	OverduePOM.date18().click();	
	Thread.sleep(2000);
	OverduePOM.STPerformer().click();	
	Thread.sleep(1000);
	//OverduePOM.STPerformerText().sendKeys("abc External");	
	//Thread.sleep(1000);
	OverduePOM.abcExternal().click();	
	Thread.sleep(4000);
	OverduePOM.Reviewer().click();	
	Thread.sleep(1000);
//	OverduePOM.ReviewerText().sendKeys("abc lawyer");
	Thread.sleep(2000);
	OverduePOM.abclawyer().click();	
	Thread.sleep(2000);
	OverduePOM.SaveBtn().click();	
	Thread.sleep(2000);
String msg=	OverduePOM.TAmsg().getText();	
	Thread.sleep(2000);
	
	test.log(LogStatus.PASS, "Message displayed - "+msg);
	Thread.sleep(2000);
	OverduePOM.CloseTab().click();	
	Thread.sleep(2000);
  	
	//----------------------Delete---------------------------------------
	Thread.sleep(3000);
  	OverduePOM.SubTaskDelete().click();
  	Thread.sleep(1000);
  	String deleteMsg=getDriver().switchTo().alert().getText();
	Thread.sleep(1000);
	if(deleteMsg.equalsIgnoreCase("Are you certain you want to delete this Sub task?"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task?'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Are you certain you want to delete this Sub task? this msg not show'");
	}
	Thread.sleep(500);
	getDriver().switchTo().alert().accept();	
	Thread.sleep(2000);
	String DleMsg=OverduePOM.STAfterClickDelete().getText();
	if(DleMsg.equalsIgnoreCase("Sub Task can not delete, Sub task already assigned"))
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assigned'");
	}
	else
	{
		test.log(LogStatus.INFO, "Message displayed - 'Sub Task can not delete, Sub task already assignedthis msg not show'");
	}	
	Thread.sleep(2000);
	OverduePOM.BacktoTask().click();
	Thread.sleep(3000);
	OverduePOM.clickDashboard().click();
	Thread.sleep(4000);
	}
	
	public	static void SummaryofOverdueCompliancesAP( ExtentTest test) throws InterruptedException
	{
	
		CFOcountPOM.ClickShowAll().click();       
		 Thread.sleep(8000); 
		
		//litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(8000); 
		 
		 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
		 Thread.sleep(3000); 
		
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButtons = getDriver().findElements(locator);							
			ViewButtons.get(0).click();
			Thread.sleep(3000);
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
			getDriver().switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview view icon of Summary Of Overdue.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should not in the Details tab on the Overview view icon of Summary Of Overdue.");

		      }
			
			getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			CFOcountPOM.closeDocument().click();
			 Thread.sleep(3000);
			 getDriver().switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			
		
	}
	
	public	static void SummaryofOverdueCompliancesAPApp( ExtentTest test) throws InterruptedException
	{

		CFOcountPOM.ClickShowAll().click();       
		 Thread.sleep(8000); 
		
		//litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver().switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(8000); 
		 
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(3000); 
		
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			List<WebElement> ViewButtons = getDriver().findElements(locator);							
			ViewButtons.get(0).click();
			Thread.sleep(3000);
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
			getDriver().switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview view icon of Summary Of Overdue.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should not in the Details tab on the Overview view icon of Summary Of Overdue.");

		      }
			
		      getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			CFOcountPOM.closeDocument().click();
			 Thread.sleep(3000);
			 getDriver().switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			
		
	}
	
	
	public	static void SummaryofOverdueCompliancesAPDept( ExtentTest test) throws InterruptedException
	{
	
		CFOcountPOM.ClickShowAll().click();       
		 Thread.sleep(8000); 
		
		//litigationPerformer.MethodsPOM.progress();
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		
	WebElement farme=	getDriver().findElement(By.xpath("//*[@id='showdetails']"));
	getDriver() .switchTo().frame(farme);
      Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']")));
		 Thread.sleep(8000); 
		 
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(8000); 
	
			By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[18]/a[1]");
			Thread.sleep(8000); 
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			
		WebElement ViewButtons = getDriver().findElement(locator);							
			ViewButtons.click();
			Thread.sleep(8000);
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
			getDriver() .switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview view icon of Summary Of Overdue.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should not in the Details tab on the Overview view icon of Summary Of Overdue.");

		      }
			
			getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			CFOcountPOM.closeDocument().click();
			 Thread.sleep(3000);
			 getDriver().switchTo().defaultContent();
			Thread.sleep(3000);
			CFOcountPOM.closeCategories().click();
			Thread.sleep(1000);
			
		
	}
	
	
	public static	void CompletedPFR_PieChartAp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		CFOcountPOM.clickClosedDelayed().click();										//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, " High risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
		
	}
	
	public static	void CompletedPFR_PieChartMp( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void CompletedPFR_PieChartMpView( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(8000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
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
		Thread.sleep(8000);
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
			Thread.sleep(4000);
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
	
	public static	void CompletedPFR_PieChartMpSC( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		
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
	   	MgmtSonyMethod.ClickTriA().click();
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void CompletedPFR_PieChartMpViewSC( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(8000);
		
		
		CFOcountPOM.clickNotCompleted().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
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
	   	MgmtSonyMethod.ClickTriA().click();
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
		Thread.sleep(8000);
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
			Thread.sleep(4000);
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
	
	public static void RiskSummaryMp( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void RiskSummaryMpView( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
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
	
	public static void RiskSummaryMpSC( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
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
	   	MgmtSonyMethod.ClickTriA().click();
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void RiskSummaryMpViewSC( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
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
	   	MgmtSonyMethod.ClickTriA().click();
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
	
		CFOcountPOM.clickHROverduem().click();
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickHROverduem().click();
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
			
			WebElement ViewButton =getDriver().findElement(locator);	
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickHROverduem().click();
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickHROverduem().click();
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
	
	
	public static void NotCompletedPFR_PieChartAp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		CFOcountPOM.clickpendingForReview().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Not Completed status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary - Not Completed status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, " No Record Found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartApAu( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(3000);
	/*	CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);*/
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,300)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		CFOcountPOM.clickClosedDelayed().click();										//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		Thread.sleep(8000);
		CFOcountPOM.ComplianceID().sendKeys("113009",Keys.ENTER);
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		//	 CFOcountPOM.ComplianceID().sendKeys("113009",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, " No Record Found");
			
			
		}
	}
	
	public static void NotCompletedPFR_PieChartApAu( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
	/*	CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);*/
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,300)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		CFOcountPOM.clickpendingForReview().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();	
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("113009",Keys.ENTER);
		 Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			// CFOcountPOM.ComplianceID().sendKeys("113009",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Not Completed status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary - Not Completed status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No Record Found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartApAPP( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		CFOcountPOM.clickClosedDelayed().click();										//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("129029",Keys.ENTER);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		//	 CFOcountPOM.ComplianceID().sendKeys("127153",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, " No Record Found");
			
			
		}
	}
	
	public static void NotCompletedPFR_PieChartApApp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		CFOcountPOM.clickpendingForReview().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("127153",Keys.ENTER);
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		//	 CFOcountPOM.ComplianceID().sendKeys("127153",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Not Completed status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary - Not Completed status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, " No Record Found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartApD( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		CFOcountPOM.clickClosedDelayed().click();										//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();			
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(3000); 
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		//	 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");
		 Thread.sleep(8000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary -Completion status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No Record Found");
			
			
		}
	}
	
	public static void NotCompletedPFR_PieChartApD( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		CFOcountPOM.clickpendingForReview().click();									//CLicking on 'Not Completed' count
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();			
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			// CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");
		 Thread.sleep(8000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the Details tab on the Overview icon of Performance summary -Not Completed status graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the Details tab on the Overview icon of Performance summary - Not Completed status graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No Record Found");
			
			
		}
	}
	
	
	
	public static void RiskSummaryHighStatutoryAp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
		Thread.sleep(1000);
		Thread.sleep(3000);
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
		Thread.sleep(8000);
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Risk summary graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the details tab on the Overview view icon of Risk summary graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void RiskSummaryHighStatutoryApAu( ExtentTest test) throws InterruptedException
	{
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
	/*	CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		*/
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1150)");		
		Thread.sleep(1000);
		Thread.sleep(3000);
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		CFOcountPOM.clickRiskCriticalClosedTimely().click();			
		Thread.sleep(8000);
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		CFOcountPOM.ComplianceID().sendKeys("93636",Keys.ENTER);
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			// CFOcountPOM.ComplianceID().sendKeys("93636",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Risk summary graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the details tab on the Overview view icon of Risk summary graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	
	public static void RiskSummaryHighStatutoryApApp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
		Thread.sleep(1000);
		Thread.sleep(3000);
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
		Thread.sleep(8000);
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		 CFOcountPOM.ComplianceID().sendKeys("127153",Keys.ENTER);
		 Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			// CFOcountPOM.ComplianceID().sendKeys("127153",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Risk summary graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the details tab on the Overview view icon of Risk summary graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "  No Record Found");
			
			
		}
	}
	
	
	public static void RiskSummaryHighStatutoryApD( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
		Thread.sleep(1000);
		Thread.sleep(3000);
		Thread.sleep(2000);
		List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0'])"));
		ApprovalcountPOM.selectOptionFromDropDown_bs(roc, "Not Completed");
			
		CFOcountPOM.clickRiskCriticalClosedTimelyDpt().click();			//Clicking on Not Completed compliances bar of High risk.  
		Thread.sleep(8000);
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		//	 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");
		 Thread.sleep(8000);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(8000);
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Risk summary graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the details tab on the Overview view icon of Risk summary graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "No record found .");
			
			
		}
	}
	
	
	public static void DepartmentSummaryAp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
		
		Thread.sleep(3000);
		
		  WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
			
		  roc.click();
		  Thread.sleep(3000);
		  
		CFOcountPOM.clickRiskHighClosedTimely().click();			//Clicking on Not Completed compliances bar of High risk.  
		Thread.sleep(8000);
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Risk summary graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the details tab on the Overview view icon of Risk summary graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void Completed_PieChartPeriodAP( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, " High risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void NotCompleted_PieChartPeriodAP( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickpendingForReview().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, " High risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void Completed_PieChartPeriodAPAU( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("113009",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, " High risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void NotCompleted_PieChartPeriodAPAU( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickpendingForReview().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("113009",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[22]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, " High risk compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	public static void Completed_PieChartPeriodAPP( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No Record Found");
			
			
		}
	}
	
	public static void NotCompleted_PieChartPeriodAPP( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickpendingForReview().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, " No Record Found");
			
			
		}
	}
	
	
	public static void Completed_PieChartPeriodAPD( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickClosedDelayed().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Completion  graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, " No Record Found");
			
			
		}
	}
	
	public static void NotCompleted_PieChartPeriodAPD( ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");			//Scrolling down window by 1000 px.cfo
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		CFOcountPOM.clickpendingForReview().click();								//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readCritical().click();						//Clicking on High value of Pie Chart of 'Not Completed'.
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(8000); 
		
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver().switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed  graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the Overview view icon of Performance summary (Due for period)- Not Completed graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "No Record Found");
			
			
		}
	}
	
	public static void PenaltySummaryStatutoryAP( ExtentTest test) throws InterruptedException
	{
		Thread.sleep(500);		
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,3000)");	
		
		CFOcountPOM.clickPenaltyYear().click();
		Select drp=new Select(CFOcountPOM.clickPenaltyYear());
		Thread.sleep(300);
		
		drp.selectByValue("2021-2022");
		Thread.sleep(300);
		CFOcountPOM.clickPenaltyYear().click();
		
		Thread.sleep(300);
		CFOcountPOM.clickApply3().click();
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,3000)");					//Scrolling down window by 2100 px.
		Thread.sleep(3000);
		
		CFOcountPOM.clickPenaltyLow().click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		
	}
	
	public static void DetailedReportAP(ExtentTest test ) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.EventBased().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBasedCheckList().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(6000);
		
		CFOcountPOM.Period().click();
		Thread.sleep(4000);
		CFOcountPOM.AllPeriod().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		
		 CFOcountPOM.ComplianceID().sendKeys("76811",Keys.ENTER);
		 Thread.sleep(8000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a")));
			Thread.sleep(8000);
		 Thread.sleep(8000);
		 JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		
		try {
			
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
			getDriver() .switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }
			
			getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			 CFOcountPOM.closeDocument2().click();
			Thread.sleep(3000);
			}catch(Exception e) {
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument1().click();
			}
		}else {
			
			test.log(LogStatus.PASS, "No record found.");
			
		}
	
			performer.OverduePOM.clickDashboard().click();
	}
	
	public static void DetailedReportAPAu(ExtentTest test ) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBased().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBasedCheckList().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(6000);
		
		CFOcountPOM.Period().click();
		Thread.sleep(4000);
		CFOcountPOM.AllPeriod().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		
		 CFOcountPOM.ComplianceID().sendKeys("113009",Keys.ENTER);
		 Thread.sleep(8000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a")));
			Thread.sleep(8000);
		 Thread.sleep(8000);
		 JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		
		try {
			
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
			getDriver().switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }
			
			getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			 CFOcountPOM.closeDocument2().click();
			Thread.sleep(3000);
			}catch(Exception e) {
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument1().click();
			}
		}else {
			
			test.log(LogStatus.PASS, "No record found.");
			
		}
	
			performer.OverduePOM.clickDashboard().click();
	}
	
	public static void DetailedReportAPD(ExtentTest test ) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.EventBased().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBasedCheckList().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(6000);
		
		CFOcountPOM.Period().click();
		Thread.sleep(4000);
		CFOcountPOM.AllPeriod().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(8000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a")));
			Thread.sleep(8000);
		 Thread.sleep(8000);
		 JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		
		try {
			
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
			getDriver().switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }
			
			getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			 CFOcountPOM.closeDocument2().click();
			Thread.sleep(3000);
			}catch(Exception e) {
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument1().click();
			}
		}else {
			
			test.log(LogStatus.PASS, "No record found.");
			
		}
	
			performer.OverduePOM.clickDashboard().click();
	}
	
	public static void DetailedReportAPP(ExtentTest test ) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBased().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBasedCheckList().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(6000);
		
		CFOcountPOM.Period().click();
		Thread.sleep(4000);
		CFOcountPOM.AllPeriod().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		
		 CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(8000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a")));
			Thread.sleep(8000);
		 Thread.sleep(8000);
		 JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		
		try {
			
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
			getDriver()  .switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }
			
			getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			 CFOcountPOM.closeDocument2().click();
			Thread.sleep(3000);
			}catch(Exception e) {
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument1().click();
			}
		}else {
			
			test.log(LogStatus.PASS, "No record found.");
			
		}
	
			performer.OverduePOM.clickDashboard().click();
	}
	
	
	public static void DepartSummaryStatutoryApApp( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
		CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
		
		Thread.sleep(3000);
	
		  WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
			
		  roc.click();
		Thread.sleep(4000);
		CFOcountPOM.clickAccountPendingReview().click();			//Clicking on Not Completed compliances bar of High risk.  
		Thread.sleep(8000);
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		CFOcountPOM.ComplianceID().sendKeys("110124",Keys.ENTER);
		 Thread.sleep(3000); 
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		//	 CFOcountPOM.ComplianceID().sendKeys("127153",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[19]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Department summary graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the details tab on the Overview view icon of Department  summary graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, " No Record Found");
			
			
		}
	}
	
	public static void DepartSummaryStatutoryApAppAu( ExtentTest test) throws InterruptedException
	{
		
		/*CFOcountPOM.YearTodate().click();
		Thread.sleep(1000);
	/*	CFOcountPOM.ALL().click();
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		Thread.sleep(3000);*/
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1500)");		
		
		Thread.sleep(3000);
	
		  WebElement roc = getDriver().findElement(By.cssSelector("#highcharts-12 > svg > g.highcharts-legend > g > g > g.highcharts-legend-item.highcharts-column-series.highcharts-color-undefined.highcharts-series-2 > rect"));
			
		  roc.click();
		Thread.sleep(4000);
		CFOcountPOM.clickAdminPendingReview().click();			//Clicking on Not Completed compliances bar of High risk.  
		Thread.sleep(8000);
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (100));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		 CFOcountPOM.ComplianceID().sendKeys("129027",Keys.ENTER);
		 Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(5000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
			// CFOcountPOM.ComplianceID().sendKeys("129027",Keys.ENTER);
			 Thread.sleep(3000); 
		Thread.sleep(5000);
		
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[21]/a[3]");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			try {
				
				WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='APIOverView']"));
				getDriver() .switchTo().frame(farme1);
			      Thread.sleep(3000);
			      CFOcountPOM.Details().click();
			      Thread.sleep(3000);
			      if(  CFOcountPOM.APText().isDisplayed()) {
			  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the Overview view icon of Department summary graph.");

			      }else {
			    	  
				  		test.log(LogStatus.FAIL, "The actionable procedure not seen in the details tab on the Overview view icon of Department  summary graph.");

			      }
				
				getDriver().switchTo().parentFrame();
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument().click();
				Thread.sleep(3000);
				}catch(Exception e) {
					 Thread.sleep(3000);
					CFOcountPOM.closeDocument1().click();
				}
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories().click();
			
			test.log(LogStatus.PASS, "  compliance count matches to numbers of items from grid.= 0");
			
			
		}
	}
	
	
	public static void DetailedReportAPer(ExtentTest test ) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(),(180));
	    
		Thread.sleep(500);
		CFOcountPOM.clickReports().click();					//Clicking on 'My Reports'
		Thread.sleep(3000);
		CFOcountPOM.clickDetailedReport().click();			//Clicking on 'Detailed Reports' 
		Thread.sleep(2000);
		OverduePOM.ClickDropD().click();
		Thread.sleep(3000);
		OverduePOM.SelectPerformer().click();
		Thread.sleep(3000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.StatutoryM().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBased().click();
		Thread.sleep(4000);
		CFOcountPOM.EventBasedCheckList().click();
		Thread.sleep(4000);
		CFOcountPOM.ComplianceType().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(6000);
		
		CFOcountPOM.Period().click();
		Thread.sleep(4000);
		CFOcountPOM.AllPeriod().click();
		Thread.sleep(2000);
		CFOcountPOM.Apply().click();
		Thread.sleep(8000);
		
		 CFOcountPOM.ComplianceID().sendKeys("127153",Keys.ENTER);
		 Thread.sleep(8000);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a")));
			Thread.sleep(8000);
		 Thread.sleep(8000);
		 JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,300)");	
		
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
		
		By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td/a");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	Thread.sleep(2000);
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		
		try {
			
			WebElement farme1=	getDriver().findElement(By.xpath("//*[@id='OverViews1']"));
			getDriver().switchTo().frame(farme1);
		      Thread.sleep(3000);
		      CFOcountPOM.Details().click();
		      Thread.sleep(3000);
		      if(  CFOcountPOM.APText().isDisplayed()) {
		  		test.log(LogStatus.PASS, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }else {
		    	  
			  		test.log(LogStatus.FAIL, "The actionable procedure should be seen in the details tab on the view icon of Detailed report.");

		      }
			
			getDriver().switchTo().parentFrame();
			 Thread.sleep(3000);
			 CFOcountPOM.closeDocument2().click();
			Thread.sleep(3000);
			}catch(Exception e) {
				 Thread.sleep(3000);
				CFOcountPOM.closeDocument1().click();
			}
		}else {
			
			test.log(LogStatus.PASS, "No record found.");
			
		}
	
			performer.OverduePOM.clickDashboard().click();
	}
	
	
	public static void DFPCompletedPFR_PieChartMp( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
		Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
			 Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
try {
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
}

			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
			Thread.sleep(4000);
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpView( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
		Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			try {
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
			
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found to View");
		}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static void DFPCompletedPFR_PieChartMpSC( ExtentTest test) throws InterruptedException
	{
		
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
		Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
			 Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
try {
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
}

			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
			Thread.sleep(4000);
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpViewSC( ExtentTest test) throws InterruptedException
	{
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
		Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
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
	       ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	  // 	MgmtSonyMethod.ClickTriA().click();
	    Thread.sleep(1000);
	   	MgmtSonyMethod.ClickTriACT1().click();
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
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			try {
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
			
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found to View");
		}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	
	public static	void GradingMpView( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
	//	JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,3500)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRedGrading().click();
		Thread.sleep(8000);	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(4000);
		//ApprovalcountPOM.MitigationPlan().click();
	    //   Thread.sleep(500);
	     
	    //   ApprovalcountPOM. MitigationPlan2().click();
	    //   Thread.sleep(2000);
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
	
	public static	void GradingMpD( ExtentTest test) throws InterruptedException
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,3500)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRedGrading().click();
		Thread.sleep(8000);	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showGRdetails"));	//Wait until frame get visible and switch to it.
		Thread.sleep(5000);
		//ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	   //    ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
	//	Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[11]/a[2]");
		
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
try {
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}

}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
}
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closePopup().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closePopup().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static	void CompletedPFR_PieChartMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void CompletedPFR_PieChartMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");			//Scrolling down window by 1000 px.cfo
	
		Thread.sleep(8000);
		
		
		CFOcountPOM.clickNotCompletedInternal().click();									//CLicking on 'Not Completed' count
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
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
		Thread.sleep(8000);
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
			Thread.sleep(4000);
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
	
	public static void RiskSummaryMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void RiskSummaryMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,1450)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickRiskHighNotCompleted().click();							//CLicking on 'Not Completed' count
		
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
	
	
	public static void DeptSummaryMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickHROverduem().click();
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void DeptSummaryMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2000)");		
	
		Thread.sleep(3000);
		
		
		CFOcountPOM.clickHROverduem().click();
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
	
	public static void DeptSummaryMpInApp( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
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

			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
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
	
	public static	void DeptSummaryMpViewInApp( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
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
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
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
	
	public static void DFPCompletedPFR_PieChartMpIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
		Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
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
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
			 Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
try {
			File dir = new File("C:\\Users\\mayurig\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			OverduePOM.Dwounload().click();				//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\mayurig\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " :- File downloaded successfully.");	
			}
			else
			{
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
}catch(Exception e) {
	test.log(LogStatus.FAIL, " :- No file Found");
}

			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
			Thread.sleep(4000);
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
	public static	void DFPCompletedPFR_PieChartMpViewIn( ExtentTest test) throws InterruptedException
	{
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		Thread.sleep(1000);
		
		CFOcountPOM.clickApply().click();
		Thread.sleep(5000);
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(1000);
		Thread.sleep(3000);
		Actions action = new Actions(getDriver());
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,2500)");	
	
		Thread.sleep(3000);
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
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
		
		Thread.sleep(500);
		
		Thread.sleep(3000);
		CFOcountPOM.readHigh().click();		
		Thread.sleep(8000);
		getDriver().switchTo().parentFrame();
	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetailsNewGraph"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
	
		ApprovalcountPOM.MitigationPlan().click();
	       Thread.sleep(500);
	     
	       ApprovalcountPOM. MitigationPlan2().click();
	       Thread.sleep(2000);
		Thread.sleep(8000);
	
		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(8000);
		CFOcountPOM.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(8000);
		String s = CFOcountPOM.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			
		try {
		 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[4]");
		
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		}catch(Exception e) {
			 By locator = By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[20]/a[2]");
				
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
				
				WebElement ViewButton = getDriver().findElement(locator);	
				Thread.sleep(3000);
			JavascriptExecutor jse=(JavascriptExecutor) getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
				Thread.sleep(4000);
		}
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frameMitigationOverViews"));	//Wait until frame get visible and switch to it.
			Thread.sleep(4000);
			try {
			OverduePOM.View().click();
			Thread.sleep(4000);	
            OverduePOM.ViewClose().click();
			
			Thread.sleep(4000);	
			
	
			test.log(LogStatus.PASS, " The document should get viewed after clicking on the view icon in the popup of the compliance mitigation plan.");	
		}catch(Exception e) {
			test.log(LogStatus.FAIL, " :- No file Found to View");
		}
			
			getDriver().switchTo().parentFrame();
			Thread.sleep(4000);
			OverduePOM.CloseMpPopUp().click();
			Thread.sleep(4000);
			
			
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();					//Closing the High Risk Window.
			
		
		}else {
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(300,0)");	
			Thread.sleep(1000);
			getDriver().switchTo().parentFrame();
			CFOcountPOM.closeCategories1().click();
			
			test.log(LogStatus.PASS, "Mitigation Plan Not Updated found");
			
			
		}
	}
	
}
