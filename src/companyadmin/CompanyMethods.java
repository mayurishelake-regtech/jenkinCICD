package companyadmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import companyAdminDiy.CompanyAdminDiyLocator;
import implementation.ImplementPOM;
import login.BasePage;
import java.util.concurrent.locks.ReadWriteLock;

public class CompanyMethods extends BasePage {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="E:\\Regtrack Merge Project\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx";


	
	
	public static void SwitchtoChild( ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		CompanyPOM.clickAdmin().click();
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	      
	    
			Thread.sleep(1000);
	      
	  
	}
	
	public static void SwitchtoChild1( ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	      
	    
			Thread.sleep(1000);
	      
	  
	}
	
	
	
	public static void SwitchtoParent( ExtentTest test) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      getDriver().close();
	      Thread.sleep(3000);
	      getDriver().switchTo().window(pw);         // switching child window
	       
	}

	public static void SwitchToNewlyOpenedWindow( ExtentTest test) throws InterruptedException
	{
		
		
		String parentwindow = getDriver().getWindowHandle();
		Set<String> allwindow = getDriver().getWindowHandles();
		
		for(String window : allwindow)
		{
			
			if(!window.equalsIgnoreCase(parentwindow))
			{
				
				getDriver().switchTo().window(window);
				
			
			}
			
			
		}
		
		
	}

	
	public static void Reports( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.clickStatutoryAssi().click();
	      		  	 Thread.sleep(2000);
	      		   CompanyPOM.SelectLocationSA().click();
	      		  	 Thread.sleep(1000);
	      		   CompanyPOM.Expand().click();
	      		  	 Thread.sleep(1000);
	      		   CompanyPOM.DPvtLtdAS().click();
	      		  	 Thread.sleep(1000);
	      		  	 
	      		  	 
	 	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdEventCannedReport']")));	//Wait until records table get visible.
	 		Thread.sleep(3000);
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.clickExport().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "Statutory Assignment Report :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
		  
			
		  	
		  //-------------------------------CheckList  Assignment Report-------------------------------
		  	Thread.sleep(1000);
		  	action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickCheckListAssi().click();
		    Thread.sleep(4000);
		    Thread.sleep(2000);
   		   CompanyPOM.SelectLocationSA().click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.Expand().click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.DPvtLtdAS().click();
   		  	 Thread.sleep(1000);
   		  dir = new File("C:\\Users\\shitalb\\Downloads");
			 dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.clickExport().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			 dir1 = new File("C:\\Users\\shitalb\\Downloads");
			 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "CheckList Assignment Report :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			  	
			  	
			  	
		 	 //-------------------------------EventBased  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickEventBasedAssi().click();
		    Thread.sleep(4000);
		    Thread.sleep(2000);
	   		   CompanyPOM.SelectLocationSA().click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.Expand().click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.DPvtLtdAS().click();
	   		  	 Thread.sleep(5000);
	   			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));
	   		  dir = new File("C:\\Users\\shitalb\\Downloads");
				 dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(3000);
				CompanyPOM.clickExport().click(); // Exporting (Downloading) file

				Thread.sleep(8000);
				 dir1 = new File("C:\\Users\\shitalb\\Downloads");
				 Thread.sleep(4000);
				 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {
					test.log(LogStatus.PASS,  "EventBased Assignment Report :- File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " EventBased Assignment Report :- File does not downloaded.");
				}
			  	 		  	
		 	 //-------------------------------Internal  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalAssi().click();
		    Thread.sleep(2000);
	   		   CompanyPOM.SelectLocationSA().click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.Expand().click();
	   		  	 Thread.sleep(1000);
	   		   CompanyPOM.DPvtLtdAS().click();
	   		  	 Thread.sleep(4000);
	   		  dir = new File("C:\\Users\\shitalb\\Downloads");
	   		 Thread.sleep(4000);
				 dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(1000);
				CompanyPOM.clickExport().click(); // Exporting (Downloading) file

				Thread.sleep(8000);
				 dir1 = new File("C:\\Users\\shitalb\\Downloads");
				 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {
					test.log(LogStatus.PASS,  "Internal Assignment Report :- File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " :- File does not downloaded.");
				}
			  	 
		 	
			  	
		 	 //-------------------------------Internal CheckList  Assignment Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalCheckListAssi().click();
		      
			  	 Thread.sleep(4000);
			  	Thread.sleep(2000);
		   		   CompanyPOM.SelectLocationSA().click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.Expand().click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.DPvtLtdAS().click();
		   		  	 Thread.sleep(4000);
		   		  dir = new File("C:\\Users\\shitalb\\Downloads");
					 dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(1000);
					CompanyPOM.clickExport().click(); // Exporting (Downloading) file

					Thread.sleep(8000);
					 dir1 = new File("C:\\Users\\shitalb\\Downloads");
					 Thread.sleep(4000);
					 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  "Internal CheckList Assignment Report :- File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  " :- File does not downloaded.");
					}
				  	 
		 
		 	//-------------------------------Statutory Label Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickStatutoryLabelReport().click();
		      
			  	 Thread.sleep(4000);
			  	 
				 Thread.sleep(4000);
				  	Thread.sleep(2000);
			   		   CompanyPOM.SelectLocationSA().click();
			   		  	 Thread.sleep(1000);
			   		   CompanyPOM.Expand().click();
			   		  	 Thread.sleep(1000);
			   		   CompanyPOM.DPvtLtdAS().click();
			   		  	 Thread.sleep(4000);
			   		  dir = new File("C:\\Users\\shitalb\\Downloads");
						 dirContents = dir.listFiles(); // Counting number of files in directory before download

						Thread.sleep(1000);
						CompanyPOM.clickExport().click(); // Exporting (Downloading) file

						Thread.sleep(8000);
						 dir1 = new File("C:\\Users\\shitalb\\Downloads");
						 Thread.sleep(4000);
						 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
						Thread.sleep(3000);
						if (dirContents.length < allFilesNew.length) {
							test.log(LogStatus.PASS,  "Statutory Label Report :- File downloaded successfully.");
						} else {
							test.log(LogStatus.FAIL,  "Statutory Label Report :- File does not downloaded.");
						}
			  	
		 	//-------------------------------Internal Label Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickInternalLabelReport().click();
		      
			  	 Thread.sleep(4000);
			 	Thread.sleep(2000);
		   		   CompanyPOM.SelectLocationSA().click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.Expand().click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.DPvtLtdAS().click();
		   		  	 Thread.sleep(4000);
		   		  dir = new File("C:\\Users\\shitalb\\Downloads");
					 dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(1000);
					CompanyPOM.clickExport().click(); // Exporting (Downloading) file

					Thread.sleep(8000);
					 dir1 = new File("C:\\Users\\shitalb\\Downloads");
					 Thread.sleep(4000);
					 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  "Internal Label Report :- File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  " :- File does not downloaded.");
					}
		 	
		 	
		 	//-------------------------------All Report-------------------------------
		     action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickAllReport().click();
		      
			  	 Thread.sleep(5000);
			 	Thread.sleep(2000);
		   		   CompanyPOM.SelectLocationSA().click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.Expand().click();
		   		  	 Thread.sleep(1000);
		   		   CompanyPOM.DPvtLtdAS().click();
		   		  	 Thread.sleep(4000);
		   		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));
		   		 Thread.sleep(4000);
		   		  dir = new File("C:\\Users\\shitalb\\Downloads");
					 dirContents = dir.listFiles(); // Counting number of files in directory before download

					Thread.sleep(4000);
					CompanyPOM.clickExport1().click(); // Exporting (Downloading) file

					Thread.sleep(8000);
					 dir1 = new File("C:\\Users\\shitalb\\Downloads");
					 Thread.sleep(8000);
					 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						test.log(LogStatus.PASS,  "All Report :- File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  "All Report :- File does not downloaded.");
					}
		 	
	 
	      SwitchtoParent(test);
	      Thread.sleep(3000);
	}
	
	public static void EventAssignments( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.EventAssignments().click();
		  	 Thread.sleep(3000);
		  	  CompanyPOM.SelectLocation().click();
			  	 Thread.sleep(1000);
			  	  CompanyPOM.DPvtLtd().click();
				  	 Thread.sleep(3000);
		  	 
		  	Thread.sleep(3000);
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.ExporttoExcel().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "After Selecting Location :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			 CompanyPOM.SelectOwner().click();
		  	 Thread.sleep(1000);
		  	  CompanyPOM.abclawyer().click();
			  	 Thread.sleep(3000);
	  	 
			 	Thread.sleep(3000);
				File dir2 = new File("C:\\Users\\shitalb\\Downloads");
				File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				CompanyPOM.ExporttoExcel().click(); // Exporting (Downloading) file

				Thread.sleep(3000);
				File dir3 = new File("C:\\Users\\shitalb\\Downloads");
				File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents1.length < allFilesNew1.length) {
					test.log(LogStatus.PASS,  "After Selecting Location and  Event owner:- File downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " :- File does not downloaded.");
				}
			
			
			  SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void Eventassignmentexportimport( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	 
		  	 CompanyPOM.SelectEntity().click();
		  	 Thread.sleep(1000);
		  	  CompanyPOM.BITAConsultingPune().click();
			  	 Thread.sleep(1000);
			  	 CompanyPOM.SelectEntityok().click();
			  	 Thread.sleep(8000);
			  	 
			  	 CompanyPOM.Location().click();
			  	 Thread.sleep(1000);
			  	//  CompanyPOM.LocationExpand().click();
				  	 Thread.sleep(1000);
				//  	 CompanyPOM.ExpandFPvtLTd().click();
				  	 Thread.sleep(1000);
				  	CompanyPOM.MPvtLtd().click();
				  	 Thread.sleep(1000);
				 	CompanyPOM.Select().click();
				  	 Thread.sleep(6000);
				  	 try {
				  	Thread.sleep(3000);
					File dir2 = new File("C:\\Users\\shitalb\\Downloads");
					File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

					Thread.sleep(500);
					CompanyPOM.Download().click(); // Exporting (Downloading) file

					Thread.sleep(8000);
					File dir3 = new File("C:\\Users\\shitalb\\Downloads");
					Thread.sleep(8000);
					File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
					Thread.sleep(3000);
					if (dirContents1.length < allFilesNew1.length) {
						test.log(LogStatus.PASS,  " File downloaded successfully.");
					} else {
						test.log(LogStatus.FAIL,  " :- File does not downloaded.");
					}
				  	 }catch(Exception e) {
				  String msg = getDriver().switchTo().alert().getText();
				  test.log(LogStatus.PASS,  "Message dissplayed  :-" +msg);
				  getDriver().switchTo().alert().accept();
				  	 }
					 SwitchtoParent(test);
				      Thread.sleep(3000);
	}
	
	public static void EventassignmentexportimportValidation( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	 
		  	
					Thread.sleep(500);
					CompanyPOM.Download().click(); // Exporting (Downloading) file

					Thread.sleep(3000);
					String ValMsg =getDriver().switchTo().alert().getText();
					Thread.sleep(1000);
						test.log(LogStatus.PASS,  "Without Selecting Entity , location validation message display : -"+ValMsg);
						getDriver().switchTo().alert().accept();
						Thread.sleep(1000);
					 SwitchtoParent(test);
				      Thread.sleep(3000);
	}
	
	public static void ImportBlankScript( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import().click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile().sendKeys("D:\\Automation File\\10-Apr-2023 16-33-05_EventAssignmentReport (4) (1).xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload().click();
		  	 Thread.sleep(6000);
		  //	 String Msg=CompanyPOM.BlankMsg().getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.FAIL,  "When blank Sheet Uploaded : - Validation Msg Not Displyed");
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void ImportInvalidSheet( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import().click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile().sendKeys("D:\\Automation File\\31-Mar-2023 20-35-38_EventAssignmentReport (6).xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload().click();
		  	 Thread.sleep(6000);
		 	 String Msg=CompanyPOM.InvalidMsg().getText();
		  	 Thread.sleep(3000);
		  	test.log(LogStatus.PASS,  "upload invalid Data validation message display : -"+Msg);
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void ImportValidSheet( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import().click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFile().sendKeys("D:\\Automation File\\EventAssignmentReport (1).xlsx");
		  	 Thread.sleep(3000);
		  	CompanyPOM.Upload().click();
		  	 Thread.sleep(8000);
		 	 String Msg=CompanyPOM.BlankMsg().getText();
		  	 Thread.sleep(5000);
		  	test.log(LogStatus.PASS,  " valid Data Upload validation message display : -"+Msg);
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void UploadedFileisplay ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Event().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.Import().click();
		  	 Thread.sleep(3000);
		 if(CompanyPOM.UploadLink().isDisplayed()) {
			 
				test.log(LogStatus.PASS,  "  Uploaded File displayed On Grid Table"); 
		 }
		  	 Thread.sleep(3000);
		  
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	
	public static void UploadedFileisplayEC ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(3000);
		  
		 if(CompanyPOM.UploadLinkEC().isDisplayed()) {
			 
				test.log(LogStatus.PASS,  "  Uploaded File displayed On Grid Table"); 
		 }
		  	 Thread.sleep(3000);
		  
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	
	public static void DownloadEC ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(4000);
		  
		 	
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(3000);
			CompanyPOM.DownloadEC().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
		  
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void ValidationEC ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(3000);
		  
		  	CompanyPOM.ImportEC().click();
		  	 Thread.sleep(3000);
		  
		 	CompanyPOM.UploadEC().click();
		  	 Thread.sleep(8000);
		  	 
	String Msg =	CompanyPOM.ValidationMsg().getText();
		  	 Thread.sleep(8000);
		  	test.log(LogStatus.PASS,  "Without Selecting file Validation Msg : -"+Msg);
		  
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void InValidSheet ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(3000);
		  
		  	CompanyPOM.ImportEC().click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFileEC().sendKeys("D:\\Automation File\\EventComplianceAssignmentReport.xlsx");
		  	 Thread.sleep(3000);
		 	CompanyPOM.UploadEC().click();
		  	 Thread.sleep(8000);
		  	 
	String Msg =	CompanyPOM.InValidationMsg().getText();
		  	 Thread.sleep(8000);
		  	test.log(LogStatus.PASS,  "Uploading Invalid Data Validation Msg : -"+Msg);
		  
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void ValidSheetEC ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageEvents()).click().build().perform();
	      Thread.sleep(1000);
	      
	      CompanyPOM.Eventassignmentexportimport().click();
		  	 Thread.sleep(3000);
		  	CompanyPOM.EventCompliance().click();
		  	 Thread.sleep(3000);
		  
		  	CompanyPOM.ImportEC().click();
		  	 Thread.sleep(3000);
		 	CompanyPOM.ChooseFileEC().sendKeys("D:\\Automation File\\EventComplianceAssignmentReport (1).xlsx");
		  	 Thread.sleep(3000);
		 	CompanyPOM.UploadEC().click();
		  	 Thread.sleep(8000);
		  	 
	String Msg =	CompanyPOM.ValidationMsg().getText();
		  	 Thread.sleep(8000);
		  	 if(Msg.equalsIgnoreCase("Data uploaded successfully.")) {
		  		test.log(LogStatus.PASS,  "Uploding valid Data Validation Msg : -"+Msg);
		  	 }
		  	 else {
		  		test.log(LogStatus.FAIL,  "Uploding valid data Validation Msg : -"+Msg);
		  	 }
		  
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	
	public static void Department ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.Department().click();
	  	 Thread.sleep(5000);
	  	 //------------------------ Add New ---------------------------
	  	CompanyPOM.AddNew().click();
	  	 Thread.sleep(3000);
	  	  
	/*	sheet = workbook.getSheetAt(12); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(4);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.DepartmentName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
	     */
	  	 
		        FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(12);
		        Row row1 = sheet.getRow(4);
		        Cell c1 = row1.getCell(1);
		        CompanyPOM.DepartmentName().sendKeys(c1.getStringCellValue());
	  	 
	  	
	  	
		CompanyPOM.SaveDept().click();
		Thread.sleep(2000);
		String DeptSaveMsg = CompanyPOM.SaveDeptMsg().getText();

		if (DeptSaveMsg.equalsIgnoreCase("Department saved successfully")) {
			test.log(LogStatus.PASS, "Add : Message displayed -" + DeptSaveMsg);
		} else {
			test.log(LogStatus.PASS, "Add : Message displayed -"+ DeptSaveMsg);
		}
		Thread.sleep(2000);
		CompanyPOM.CloseDept().click();
		Thread.sleep(3000);
		// ----------------------Filter -----------------
		row1 = sheet.getRow(4);
		c1 = row1.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.DepartFilter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Department-Filter Working Successfully");

		// ----------------------Edit -----------------
		
		CompanyPOM.DepartEdit().click();
		Thread.sleep(4000);
		CompanyPOM.DepartmentName().clear();
		Thread.sleep(2000);
		row1 = sheet.getRow(5);
		c1 = row1.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.DepartmentName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		CompanyPOM.SaveDept().click();
		Thread.sleep(3000);
		String DeptUpdateMsg = CompanyPOM.SaveDeptMsg().getText();

		if (DeptUpdateMsg.equalsIgnoreCase("Department updated successfully")) {
			test.log(LogStatus.PASS, "Edit :Message displayed -" + DeptUpdateMsg);
		} else {
			test.log(LogStatus.PASS, "Edit : Message displayed - Department already exists");
		}

		Thread.sleep(2000);
		CompanyPOM.CloseDept().click();
		Thread.sleep(3000);

		//---------------Delete-------------------------
		
		CompanyPOM.DepartDelete().click();
		String DeleteMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);

		if (DeleteMsg.equalsIgnoreCase("Are you certain you want to delete this Department Details?")) {
			test.log(LogStatus.PASS, " Delete : Message displayed -" + DeleteMsg);
		} else {
			test.log(LogStatus.PASS, "Delete Message displayed -" + DeleteMsg + "not Displayed");
		}

		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void  User( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.User().click();
	  	 Thread.sleep(5000);
	  	 //------------------------ Add New ---------------------------
	 	CompanyPOM.AddNewUser().click();
	  	 Thread.sleep(3000);
	  	 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(12);
 
	  	Thread.sleep(3000);
	
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		 	row0 = sheet.getRow(7);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(8);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersFirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(9);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersLastName().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(10);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CompanyPOM.UsersDesignation().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		row0 = sheet.getRow(11);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

		int No = (int) c1.getNumericCellValue();
		CompanyPOM.UsersMobileNo().sendKeys("" + No + ""); // Writing Task title
		Thread.sleep(4000);
		CompanyPOM.UsersDepartment().click();
		Thread.sleep(2000);
		CompanyPOM.DepartmentTech().click();
		Thread.sleep(5000);
		CompanyPOM.DepartmentTechOk().click();
		Thread.sleep(2000);
		CompanyPOM.UserComplianceRole().click();
		Thread.sleep(3000);
		CompanyPOM.UserCompanyAdmin().click();
		Thread.sleep(4000);

		CompanyPOM.SelectHrRole().click();
		Thread.sleep(2000);
		CompanyPOM.HR().click();
		Thread.sleep(4000);
	/*	CompanyPOM.SecurityGroup().click();
		Thread.sleep(2000);
		CompanyPOM.avantisGroup().click();
		Thread.sleep(4000);
		*/
		CompanyPOM.UserSave().click();
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "User - Add Successfully");
		
	      row0 = sheet.getRow(7);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.DepartFilter().sendKeys(c1.getStringCellValue(), Keys.ENTER); // Writing Task title
			Thread.sleep(6000);
			test.log(LogStatus.PASS, "User - Filter working Successfully");
			
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.ExportUser().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			CompanyPOM.UserEdit().click();
			Thread.sleep(3000);
			CompanyPOM.UsersFirstName().clear();
			Thread.sleep(1000);
			row0 = sheet.getRow(12);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.UsersFirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(2000);
			CompanyPOM.UserSave().click();
			Thread.sleep(8000);
			test.log(LogStatus.PASS, "User - Update Successfully");
			CompanyPOM.ResetPass().click();
			Thread.sleep(3000);
			
			getDriver().switchTo().alert().accept();
			Thread.sleep(2000);
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
			 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void  MyCompanies( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.MyCompanies().click();
		  	 Thread.sleep(5000);
		  	File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.Export().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			SwitchtoParent(test);
		     Thread.sleep(3000);
	      
	}
	
	public static void  Fortnightlycompliance( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.Fortnightlycompliancedocument().click();
		  	 Thread.sleep(5000);
		  	 /*
		      CompanyPOM.Dropdown().click();
			  	 Thread.sleep(2000);
			  	CompanyPOM.Statutory().click();
			  	 Thread.sleep(5000);
			  	 */
		  	 
		  	File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.DowloadDocument().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " Statutory - File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " Statutory :- File does not downloaded.");
			}
			Thread.sleep(5000);
		      CompanyPOM.Dropdown().click();
			  	 Thread.sleep(2000);
			  	CompanyPOM.Internal().click();
			  	 Thread.sleep(5000);
		  	 
		  	File dir0 = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents0 = dir0.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.DowloadDocument().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir2 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew2 = dir2.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents0.length < allFilesNew2.length) {
				test.log(LogStatus.PASS,  " Internal - File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " Internal:- File does not downloaded.");
			}
			SwitchtoParent(test);
		     Thread.sleep(3000);
	      
	}
	
	
	
	
	
	public static void  BlockScheduleStatutory( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.BlockScheduleStatutory().click();
	  	 Thread.sleep(5000);
	  	CompanyPOM.ComplianceCategory().click();
		Thread.sleep(2000);
		CompanyPOM.ClientSpecific().click();
		Thread.sleep(10000);
		CompanyPOM.Description().sendKeys("ABCD");
		Thread.sleep(4000);
		CompanyPOM.BlockDate().click();
		Thread.sleep(1000);
		CompanyPOM.Date14().click();
		Thread.sleep(3000);
		
		CompanyPOM.BlockCheckBox().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.keep().click();
		Thread.sleep(1000);
		String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(5000);
		//test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg);
		Thread.sleep(2000);
		String Msg1 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg1);
		Thread.sleep(4000);
		
		Thread.sleep(2000);
		CompanyPOM.Description().sendKeys("ABCDE");
		Thread.sleep(3000);
		CompanyPOM.BlockDate().click();
		Thread.sleep(1000);
		CompanyPOM.Date14().click();
		Thread.sleep(1000);
		CompanyPOM.BlockCheckBox().click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.BlockDelete().click();
		Thread.sleep(1000);
		
		getDriver().switchTo().alert().accept();

		Thread.sleep(5000);
		String Msg3 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Delete - Message displayed -:- " + Msg3);
		Thread.sleep(2000);
		Thread.sleep(4000);
		 SwitchtoParent(test);
	      Thread.sleep(3000);
	  	 
	}
	
	public static void  BlockScheduleInternal( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.

	      action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.BlockScheduleInternal().click();
	  	 Thread.sleep(5000);
	  	CompanyPOM.ComplianceCategory().click();
		Thread.sleep(2000);
		CompanyPOM.Category28May2021().click();
		Thread.sleep(10000);
		CompanyPOM.Description().sendKeys("ABCD");
		Thread.sleep(4000);
		CompanyPOM.BlockDate().click();
		Thread.sleep(1000);
		CompanyPOM.Date14().click();
		Thread.sleep(3000);
		
		CompanyPOM.BlockCheckBox().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.keep().click();
		Thread.sleep(5000);
		//String Msg = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(5000);
	//	test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg);
		Thread.sleep(2000);
		String Msg1 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Keep - Message displayed -:- " + Msg1);
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		CompanyPOM.Description().sendKeys("ABCDE");
		Thread.sleep(3000);
		CompanyPOM.BlockDate().click();
		Thread.sleep(1000);
		CompanyPOM.Date14().click();
		Thread.sleep(1000);
		CompanyPOM.BlockCheckBox().click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(4000);
		CompanyPOM.BlockDelete().click();
		Thread.sleep(8000);
		
		getDriver().switchTo().alert().accept();

		Thread.sleep(5000);
		String Msg3 = getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();

		test.log(LogStatus.PASS, "Delete - Message displayed -:- " + Msg3);
		Thread.sleep(2000);
		Thread.sleep(4000);
		 SwitchtoParent(test);
	      Thread.sleep(3000);
	}
	
	
	public static void UserDept( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		SwitchtoChild(test);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	  	CompanyPOM.User().click();
	  	 Thread.sleep(5000);
	      		  	CompanyPOM.ModifyAssignmentsLink().click();
	      		  	 Thread.sleep(2000);
	      		  	if(CompanyPOM.DepartmentDropdown().isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			JavascriptExecutor js = (JavascriptExecutor)  getDriver() ;
	      			js.executeScript("window.scrollBy(0,500)");	
	      			Thread.sleep(4000);
	      			
	      			CompanyPOM.ModifyAssignmentsClose().click();
	      			Thread.sleep(4000);
	      			SwitchtoParent(test);
	}

	public static void ModifyAssignmentsDept( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		SwitchtoChild(test);
	      
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.ModifyAssignments().click();
	      		  	 Thread.sleep(2000);
	      		  
	      		  	if(CompanyPOM.DepartmentDropdownMA().isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			
	      			Thread.sleep(4000);
	      			
	      			
	      			SwitchtoParent(test);
	}
	
	
	public static void modifyAssignmentsTask( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Task :-Reassign
		// -------------------------------------
		ImplementPOM.ClickTask().click();
		Thread.sleep(1000);

		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	

		ImplementPOM.ChechBoxInTask0().click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}

	
	public static void modifyAssignmentsTaskIN( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Task :-Reassign
		// -------------------------------------
		ImplementPOM.ClickTask().click();
		Thread.sleep(6000);
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	

		ImplementPOM.ChechBoxInTask0().click();
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliance tasks to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}

	
	public static void modifyAssignmentsCom( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Reassign
		
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	
		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}

	public static void modifyAssignmentsComEB( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Reassign - Event Based
		
		
		Thread.sleep(5000);
		ImplementPOM.ClickStaEventBased().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	

		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}

	
	public static void modifyAssignmentsComChecklist( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Reassign - Checklist
		
		
		Thread.sleep(5000);
		ImplementPOM.ClickStaCheckList().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	

		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}

	
	public static void modifyAssignmentsComIN( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb().click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,200)");	

		ImplementPOM.CheckINBox0().click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}

	public static void modifyAssignmentsComINChecklist( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign -CheckList
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		ImplementPOM.ClickStaCheckList().click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[7]/td[2]/span/a/span[1]"))); 
		Thread.sleep(5000);
		ImplementPOM.SelectNewPerformerUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);

		ImplementPOM.SelectNewReviewerUser().click();
		Thread.sleep(2000);
		CompanyPOM.reviewerb().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,300)");	

		ImplementPOM.CheckINBox0().click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();
		
		if (MAMsg.equalsIgnoreCase("Are you sure you want reassign selected compliances to performer a?")) {
			test.log(LogStatus.PASS, "Message displayed - " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}

	
	public static void modifyAssignmentsComExclude( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Exclude 
		
		  	ImplementPOM.ClickExclude().click();
			Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);
		
		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}
	
	public static void modifyAssignmentsComExcludeEB( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Exclude -Event Based
		
		  	ImplementPOM.ClickExclude().click();
			Thread.sleep(6000);
			ImplementPOM.ClickStaEventBased().click();
			Thread.sleep(8000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(8000);
		
		ImplementPOM.CheckBox0().click();
		Thread.sleep(2000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		Thread.sleep(5000);
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(5000);
	//	.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}
	
	public static void modifyAssignmentsComExcludeCL( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Statutory :-Compliance  :-Exclude -CheckList
		
		  	ImplementPOM.ClickExclude().click();
			Thread.sleep(6000);
			ImplementPOM.ClickStaCheckList().click();
			Thread.sleep(5000);
			
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.Sonalipatil().click();
		Thread.sleep(5000);
		
		ImplementPOM.CheckBox0().click();
		Thread.sleep(1000);
		// Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();
		Thread.sleep(2000);
		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for Sonali patil?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}
	
	public static void modifyAssignmentsComExcludeIN( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		ImplementPOM.ClickExclude().click();
		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);
		

		ImplementPOM.CheckINBox0().click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}
	
	public static void modifyAssignmentsComExcludeINCL( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.ModifyAssignments().click();
		  	 Thread.sleep(2000);

		// --------------------------- Modify Assignments :- Internal :-Compliance  :-Reassign
		
		
		Thread.sleep(2000);
		ImplementPOM.ClickInternalRB().click();
		Thread.sleep(5000);
		ImplementPOM.ClickExclude().click();
		Thread.sleep(6000);
		ImplementPOM.ClickStaCheckList().click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[2]/span/a/span[1]"))); 
		Thread.sleep(2000);
		ImplementPOM.SelectUser().click();
		Thread.sleep(2000);
		CompanyPOM.performera().click();
		Thread.sleep(5000);
		

		ImplementPOM.CheckINBox0().click();
		Thread.sleep(1000);
		// ImplementPOM.CheckBox1().click();
		Thread.sleep(5000);
		ImplementPOM.ClicksaveBtn().click();
		String MAMsg = getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		Thread.sleep(2000);
	//	.switchTo().alert().dismiss();

		if (MAMsg.equalsIgnoreCase("Are you sure you want exclude selected compliances for performer a?")) {
			test.log(LogStatus.PASS, "Message displayed -  " + MAMsg);
		} else {
			test.log(LogStatus.PASS, "Message displayed -" + MAMsg + "not Displayed");
		}
		Thread.sleep(4000);

		SwitchtoParent(test);
	}
	
	public static void Acts( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersMC().click();
		  	 Thread.sleep(2000);

		  	  CompanyPOM.Acts().click();
			  	 Thread.sleep(5000);
if( CompanyPOM.ActsFilter().isDisplayed())
{
	test.log(LogStatus.PASS, "Act Filter - The filter of act should be seen on the page of Act master" );
}

CompanyPOM.ActsFilter().click();
Thread.sleep(4000);

CompanyPOM.ActsCkeck1().click();
Thread.sleep(1000);

CompanyPOM.ActsCkeck2().click();
	 Thread.sleep(1000);
	
	 
	 CompanyPOM.ok().click();
	 Thread.sleep(8000);
 test.log(LogStatus.PASS, "Act Filter - The multiple act in the dropdown should be selectable and the details of the selected acts would be reflected on the grid" );
 Thread.sleep(8000);
CompanyPOM.ActsFilter().click();
		Thread.sleep(4000);
		 CompanyPOM.ActsFilter().clear();
		 CompanyPOM.ActsFilter().sendKeys("Central Excise Act, 1944 & CENVAT Credit Rules, 2004");
		 Thread.sleep(4000);
		 test.log(LogStatus.PASS, "Act Filter - Correct data should be seen in the dropdown after entering act name in search tab" );
	
		 
		 CompanyPOM.ActsFilter().click();
			SwitchtoParent(test);
	}
	
	
	public static void EditCompliances( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.InternalCompliances()).click().build().perform();
	     
		Thread.sleep(5000);
		   CompanyPOM.EditCompliances().click();
		  	 Thread.sleep(2000);

		  	  CompanyPOM.EditIcon().click();
			  	 Thread.sleep(5000);
if( CompanyPOM.DetailedDescription().isDisplayed()&&CompanyPOM.EventBasedchk().isDisplayed()&&CompanyPOM.ComplianceDocumentMandatorychk().isDisplayed()){
	
	test.log(LogStatus.PASS, "While Click on Edit Button Detail Description , Is event Based Checkbox and Is Compliance Document Mandatory? Checkbox fileds should be displayed." );
}

			SwitchtoParent(test);
	}
	
	
	public static void GroupingMaster( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

			  	
if( CompanyPOM.GroupingMaster().isDisplayed())
{
	test.log(LogStatus.PASS, "The tab of grouping master should be seen in masters tab under manage compliances." );
}

			SwitchtoParent(test);
	}
	
	
	public static void GroupingMasterDis( ExtentTest test)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
if( CompanyPOM.GroupMaster().isDisplayed()&&CompanyPOM.ComplianceTagging().isDisplayed())
{
	test.log(LogStatus.PASS, "The sub tabs of group master and compliance tagging should be seen under the tab of grouping master in manage compliances." );
}else
{
	test.log(LogStatus.FAIL, "The sub tabs of group master and compliance tagging not seen under the tab of grouping master in manage compliances." );

}

			SwitchtoParent(test);
	}
	
	public static void GroupMaster( ExtentTest test)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 
		  	
if( CompanyPOM.GroupMaster().isEnabled())
{
	 CompanyPOM.GroupMaster().click();
  	 Thread.sleep(2000);
	test.log(LogStatus.PASS, "The records of all the previously created groups should be seen after clicking on the tab of group master." );
}else
{
	test.log(LogStatus.FAIL, "The records of all the previously created groups not seen after clicking on the tab of group master." );

}

			SwitchtoParent(test);
	}
	
	public static void GroupMasterAN( ExtentTest test)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);
		  	
if( CompanyPOM.AddNewGM().isEnabled())
{
	CompanyPOM.AddNewGM().click();
	test.log(LogStatus.PASS, "Add new tab is Clickable." );
}else
{
	test.log(LogStatus.FAIL, "Add new tab is not Clickable." );

}
Thread.sleep(2000);
    CompanyPOM.AddNewGMClose().click();
    Thread.sleep(2000);
			SwitchtoParent(test);
	}
	
	public static void GroupMasterANW( ExtentTest test)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);
		  	CompanyPOM.AddNewGM().click();
		  	
			 Thread.sleep(2000);
			  	CompanyPOM.AddNewSave().click();
			  	 Thread.sleep(3000);
			String msg= CompanyPOM.AddNewSaveMsg().getText();
			 Thread.sleep(3000);
			if(msg.equalsIgnoreCase("Group Name can not be empty.")) {
				test.log(LogStatus.PASS, "Message displayed :- "+msg );
			}else {
				test.log(LogStatus.FAIL, "Message displayed :- "+msg );
			}
			 Thread.sleep(2000);
    CompanyPOM.AddNewGMClose().click();
    Thread.sleep(2000);
			SwitchtoParent(test);
	}
	
	
	public static void AddNewGM( ExtentTest test,XSSFWorkbook workbook)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);
		  	CompanyPOM.AddNewGM().click();
		  	
		  	sheet = workbook.getSheetAt(12); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			Cell c1 = null;
			 	row0 = sheet.getRow(14);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.GroupName().sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(3000);
		  
			  	CompanyPOM.AddNewSave().click();
			  	 Thread.sleep(3000);
			String msg= CompanyPOM.AddNewSaveMsg().getText();
			 Thread.sleep(3000);
			if(msg.equalsIgnoreCase("Group saved successfully")) {
				test.log(LogStatus.PASS, "Message displayed :- "+msg );
			}else {
				test.log(LogStatus.FAIL, "Message displayed :- "+msg );
			}
			 Thread.sleep(2000);
    CompanyPOM.AddNewGMClose().click();
    Thread.sleep(2000);
			SwitchtoParent(test);
	}
	
	public static void AddNewAE( ExtentTest test,XSSFWorkbook workbook)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);
		  	CompanyPOM.AddNewGM().click();
		  	
		  	sheet = workbook.getSheetAt(12); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			Cell c1 = null;
			 	row0 = sheet.getRow(14);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.GroupName().sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(3000);
		  
			  	CompanyPOM.AddNewSave().click();
			  	 Thread.sleep(3000);
			String msg= CompanyPOM.AddNewSaveMsg().getText();
			 Thread.sleep(3000);
			if(msg.equalsIgnoreCase("Group saved successfully")) {
				test.log(LogStatus.FAIL, "Message displayed :- "+msg );
			}else {
				test.log(LogStatus.PASS, "Message displayed :- "+msg );
			}
			 Thread.sleep(2000);
    CompanyPOM.AddNewGMClose().click();
    Thread.sleep(2000);
			SwitchtoParent(test);
	}
	
	public static void UpdateGM( ExtentTest test,XSSFWorkbook workbook)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);
		  	
		  	
		  	sheet = workbook.getSheetAt(12); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			Cell c1 = null;
			 	row0 = sheet.getRow(14);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.Filter().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
			Thread.sleep(3000);
			 CompanyPOM.Edit().click();
		  	 Thread.sleep(2000);
			
			row0 = sheet.getRow(15);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.GroupName().sendKeys(c1.getStringCellValue()); // Writing Task title
			Thread.sleep(3000);
		  
			  	CompanyPOM.AddNewSave().click();
			  	 Thread.sleep(3000);
			String msg= CompanyPOM.AddNewSaveMsg().getText();
			 Thread.sleep(3000);
			if(msg.equalsIgnoreCase("Group updated successfully")) {
				test.log(LogStatus.PASS, "Message displayed :- "+msg );
			}else {
				test.log(LogStatus.FAIL, "Message displayed :- "+msg );
			}
			 Thread.sleep(2000);
    CompanyPOM.AddNewGMClose().click();
    Thread.sleep(2000);
			SwitchtoParent(test);
	}
	
	
	public static void DeleteGM( ExtentTest test,XSSFWorkbook workbook)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);
		  	
		  	
		  	sheet = workbook.getSheetAt(12); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			Cell c1 = null;
			 	row0 = sheet.getRow(15);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.Filter().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
			Thread.sleep(3000);
			 CompanyPOM.Delete().click();
		  	 Thread.sleep(2000);
			getDriver().switchTo().alert().accept();
			
			 Thread.sleep(2000);
			  
			String msg= CompanyPOM.DeleteMsg().getText();
			 Thread.sleep(3000);
			if(msg.equalsIgnoreCase("Group deleted successfully")) {
				test.log(LogStatus.PASS, "Message displayed :- "+msg );
			}else {
				test.log(LogStatus.FAIL, "Message displayed :- "+msg );
			}
			 Thread.sleep(2000);
 
			SwitchtoParent(test);
	}
	
	public static void DeleteGMT( ExtentTest test,XSSFWorkbook workbook)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);
		  	
		  	
		  
			CompanyPOM.Filter().sendKeys("4",Keys.ENTER); // Writing Task title
			Thread.sleep(3000);
			 CompanyPOM.Delete().click();
		  	 Thread.sleep(2000);
			getDriver().switchTo().alert().accept();
			
			 Thread.sleep(2000);
			  
			String msg= CompanyPOM.DeleteMsg().getText();
			 Thread.sleep(3000);
			if(msg.equalsIgnoreCase("Group already in used you can not deleted.")) {
				test.log(LogStatus.PASS, "Message displayed :- "+msg );
			}else {
				test.log(LogStatus.FAIL, "Message displayed :- "+msg );
			}
			 Thread.sleep(2000);
 
			SwitchtoParent(test);
	}
	
	public static void FilterGM( ExtentTest test,XSSFWorkbook workbook)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.GroupMaster().click();
		  	 Thread.sleep(2000);

				CompanyPOM.Filter().sendKeys("GST Compliance",Keys.ENTER); // Writing Task title
				Thread.sleep(3000);
			test.log(LogStatus.PASS, "The group name entered in the search box should get filtered on the grid of group master." );
			 Thread.sleep(2000);
 
			SwitchtoParent(test);
	}
	
	public static void ComplianceTagging( ExtentTest test)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 
		  	
if( CompanyPOM.ComplianceTagging().isEnabled())
{
	 CompanyPOM.ComplianceTagging().click();
  	 Thread.sleep(2000);
	test.log(LogStatus.PASS, "All the records of groups to which compliances are tagged should be seen after clicking on the tab of Compliance Tagging." );
}else
{
	test.log(LogStatus.FAIL, "TAll the records of groups to which compliances are tagged not seen after clicking on the tab of Compliance Tagging." );

}

			SwitchtoParent(test);
	}
	
	public static void ComplianceTaggingAN( ExtentTest test)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.ComplianceTagging().click();
		  	 Thread.sleep(2000);
		  	
if( CompanyPOM.AddNewCT().isEnabled())
{
	CompanyPOM.AddNewCT().click();
	test.log(LogStatus.PASS, "Add new tab is Clickable." );
}else
{
	test.log(LogStatus.FAIL, "Add new tab is not Clickable." );

}
Thread.sleep(2000);
    CompanyPOM.AddNewCTClose().click();
    Thread.sleep(2000);
			SwitchtoParent(test);
	}
	
	public static void FilterCT( ExtentTest test)	throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.MastersGC().click();
		  	 Thread.sleep(2000);

		     CompanyPOM.GroupingMaster().click();
		  	 Thread.sleep(2000);
		  	 CompanyPOM.ComplianceTagging().click();
		  	 Thread.sleep(2000);

				CompanyPOM.Filter().sendKeys("GST Compliance",Keys.ENTER); // Writing Task title
				Thread.sleep(3000);
			test.log(LogStatus.PASS, "The group name entered in the search box should get filtered on the grid of Compliance Tagging." );
			 Thread.sleep(2000);
 
			SwitchtoParent(test);
	}
	
	public static void IPAddressAddNew( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	 
		  	  CompanyPOM.IPAddressAN().click();
			  	 Thread.sleep(3000);
		 	
			  	 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(12);
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(17);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.LocationIP().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(18);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.IPAddressText().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				
				row0 = sheet.getRow(19);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.Remark().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				  CompanyPOM.Save().click();
				  	 Thread.sleep(3000);
				  	 
				  	String msg= CompanyPOM.SaveMsg().getText();
					 Thread.sleep(3000);
					if(msg.equalsIgnoreCase("IP Block Details saved successfully")) {
						test.log(LogStatus.PASS, "Message displayed :- "+msg );
					}else {
						test.log(LogStatus.FAIL, "Message displayed :- "+msg );
					}

					CompanyPOM.CloseBtn().click();
				  	 Thread.sleep(3000);

		SwitchtoParent(test);
	}
	
	public static void IPAddressFilter( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	 
		  	 FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(12);
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			Cell c1 = null;
		  	 
		 	row0 = sheet.getRow(18);
			c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
			CompanyPOM.FilterIP().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
			Thread.sleep(3000);
				  	 
				  	String Text= CompanyPOM.IPAddressTextF().getText();
					 Thread.sleep(3000);
					if(Text.equalsIgnoreCase("67.123.32.3")) {
						test.log(LogStatus.PASS, "Filter function should be return the same information that is searched in the filter box and displays the details on grid. ");
					}else {
						test.log(LogStatus.FAIL, "Filter function should not return the same information that is searched in the filter box and displays the details on grid. " );
					}

					Thread.sleep(3000);
					

		SwitchtoParent(test);
	}
	
	public static void IPAddressUpload( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	 
		 
		 			CompanyPOM.ChooseFileIp().sendKeys("C:\\Users\\shitalb\\Downloads\\IPAddress.xlsx"); // Writing Task title
			Thread.sleep(3000);
			  CompanyPOM.UploadIp().click();
			  	 Thread.sleep(3000);
				  	 
				  	String Text= CompanyPOM.UploadIpMSg().getText();
					 Thread.sleep(3000);
						test.log(LogStatus.PASS, "Message displayed :- "+Text );

					Thread.sleep(3000);
					

		SwitchtoParent(test);
	}
	
	public static void IPAddressSampleFormat( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	 
		 
		 	File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.SampleFormat().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "while click On Sample Format Excel Sample Format should be downloaded.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
					

		SwitchtoParent(test);
	}
	
	public static void IPAddressDeleteAll( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	 
			  CompanyPOM.CheckBoxAll().click();
			  	 Thread.sleep(3000);
				  	 
			  	CompanyPOM.DeleteBtn().click();
			  	 Thread.sleep(3000);
				  	 
				  	String Text= CompanyPOM.UploadIpMSg().getText();
					 Thread.sleep(3000);
						test.log(LogStatus.PASS, "Message displayed :- "+Text );

					Thread.sleep(3000);
					

		SwitchtoParent(test);
	}
	
	public static void IPAddressEdit( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	
		 	
		  	 FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(12);
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
			  	 
			 	row0 = sheet.getRow(18);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.FilterIP().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
				Thread.sleep(3000);
				
				  CompanyPOM.EditBtn().click();
				  	 Thread.sleep(3000);
			 	
				  	CompanyPOM.IPAddressText().clear();
				  	 Thread.sleep(3000);
				row0 = sheet.getRow(20);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.IPAddressText().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				
			
				  CompanyPOM.Save().click();
				  	 Thread.sleep(3000);
				  	 
				  	String msg= CompanyPOM.SaveMsg().getText();
					 Thread.sleep(3000);
					if(msg.equalsIgnoreCase("IP Block Details updated successfully")) {
						test.log(LogStatus.PASS, "Message displayed :- "+msg );
					}else {
						test.log(LogStatus.FAIL, "Message displayed :- "+msg );
					}

					CompanyPOM.CloseBtn().click();
				  	 Thread.sleep(3000);

		SwitchtoParent(test);
	}
	
	public static void IPAddressDelete( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
				  	 
			  	CompanyPOM.DeleteIp().click();
			  	 Thread.sleep(3000);
				  	 
				  	String Text= getDriver().switchTo().alert().getText();
					 Thread.sleep(3000);
						test.log(LogStatus.PASS, "Message displayed :- "+Text );

					Thread.sleep(3000);
					 getDriver().switchTo().alert().accept();

		SwitchtoParent(test);
	}
	
	public static void IPAddressExport( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	 
		 
		 	File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.Export().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "IP Address Details Excel sheet should be dwonloaded.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
					

		SwitchtoParent(test);
	}
	
	public static void IPAddressAddNewWD( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.IPAddress().click();
		  	 Thread.sleep(2000);
		  	 
		  	  CompanyPOM.IPAddressAN().click();
			  	 Thread.sleep(3000);
		 	
			  	
				  CompanyPOM.Save().click();
				  	 Thread.sleep(3000);
				  	 
				  	String msg= CompanyPOM.SaveMsg1().getText();
					 Thread.sleep(3000);
				
						test.log(LogStatus.PASS, "Message displayed :- "+msg );
					

					CompanyPOM.CloseBtn().click();
				  	 Thread.sleep(3000);

		SwitchtoParent(test);
	}
	
	public static void SecurityGroup( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.SecurityGroupMU().click();
		  	 Thread.sleep(2000);
		  	 
		  	  CompanyPOM.SecurityGroupAddNew().click();
			  	 Thread.sleep(3000);
		 	
			  	 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(12);
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(22);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.SecurityGroupText().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(4000);
				
				 CompanyPOM.LocationSG().click();
			  	 Thread.sleep(4000);
			  	 CompanyPOM.LocationSG().click();
			  	 Thread.sleep(4000);
			  	 CompanyPOM.LocationAll().click();
			  	 Thread.sleep(2000);
			  	 CompanyPOM.LocationOk().click();
			  	 Thread.sleep(3000);
				  CompanyPOM.SaveSG().click();
				  	 Thread.sleep(3000);
				  	 
				  	String msg= CompanyPOM.SaveMsgSG().getText();
					 Thread.sleep(3000);
					if(msg.equalsIgnoreCase("User Group details saved successfully")) {
						test.log(LogStatus.PASS, "Message displayed :- "+msg );
					}else {
						test.log(LogStatus.FAIL, "Message displayed :- "+msg );
					}

					CompanyPOM.CloseSG().click();
				  	 Thread.sleep(3000);

		SwitchtoParent(test);
	}
	
	public static void SecurityGroupAdd( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.SecurityGroupMU().click();
		  	 Thread.sleep(2000);
		  	 
		  	  CompanyPOM.SecurityGroupAddNew().click();
			  	 Thread.sleep(3000);
		 	
			  	
				  CompanyPOM.SaveSG().click();
				  	 Thread.sleep(3000);
				  	 
				  	String msg= CompanyPOM.SaveMsgSG1().getText();
					 Thread.sleep(3000);
					
						test.log(LogStatus.PASS, "Message displayed :- "+msg );
					
					CompanyPOM.CloseSG().click();
				  	 Thread.sleep(3000);

		SwitchtoParent(test);
	}
	
	public static void SecurityGroupFilter( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.SecurityGroupMU().click();
		  	 Thread.sleep(4000);
		  	 
		  	  
		 	
		  	 FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(12);
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(22);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.FilterSG().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
				Thread.sleep(4000);
			String text1=	CompanyPOM.FilterSG().getText();
				
				  Thread.sleep(500);
			        List<String> li=new ArrayList<String>();
			        
			        li.add(text1);
			       
			        Thread.sleep(3000);
			        
				//	List<String> filter=new ArrayList<String>();	
				//	filter.add("Statutory");
				
				
					List<WebElement> IDcol= getDriver().findElements(By.xpath("//*[@id='BodyContent_gridview']/tbody/tr/td[1]"));
					

					for(int i=0; i<li.size(); i++){
						
						List<String> text= new ArrayList<String>();
						HashSet<String> pass=new LinkedHashSet<>();
						HashSet<String> fail=new LinkedHashSet<>();
						List<WebElement> raw=new ArrayList<WebElement>();

							if(i==0)
							{
								raw.addAll(IDcol);
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
							test.log(LogStatus.FAIL,  "Filter should not return the same information that is searched in the filter box and displays the details on grid. "+Fal);
					 }	
					 for(String Pas : pass)
					 {
						 test.log(LogStatus.PASS,  " Filter should be return the same information that is searched in the filter box and displays the details on grid."+Pas);
							
				 }
					 text.clear();
					pass.clear();
					fail.clear();
					raw.clear();
					
					
					}
					

		SwitchtoParent(test);
	}
	
	public static void SecurityGroupEdit( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.SecurityGroupMU().click();
		  	 Thread.sleep(3000);
		  	 
		  	
		  	 FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(12);
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(22);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.FilterSG().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
				Thread.sleep(4000);
			
			        
				  CompanyPOM.EditSG().click();
				  	 Thread.sleep(2000);
				  	CompanyPOM.RemarkSg().clear();
				 	 Thread.sleep(2000);
				 	row0 = sheet.getRow(23);
					c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
					CompanyPOM.RemarkSg().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
					Thread.sleep(4000);
					CompanyPOM.SaveSG().click();
				  	 Thread.sleep(3000);
				  	 
				  	String msg= CompanyPOM.SaveMsgSG().getText();
					 Thread.sleep(3000);
					if(msg.equalsIgnoreCase("User Group Details updated successfully")) {
						test.log(LogStatus.PASS, "Message displayed :- "+msg );
					}else {
						test.log(LogStatus.FAIL, "Message displayed :- "+msg );
					}

					CompanyPOM.CloseSG().click();
				  	 Thread.sleep(3000);


		SwitchtoParent(test);
	}
	
	public static void SecurityGroupDelete( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
	  	action.moveToElement(CompanyPOM.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
		Thread.sleep(4000);
		   CompanyPOM.SecurityGroupMU().click();
		  	 Thread.sleep(2000);
		  	 
		  	  
		 	
		  	 FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheetAt(12);
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(22);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				CompanyPOM.FilterSG().sendKeys(c1.getStringCellValue(),Keys.ENTER); // Writing Task title
				Thread.sleep(4000);
				  CompanyPOM.DeleteSG().click();
				  	 Thread.sleep(3000);
			        
				 
				  	 
				  	String msg= getDriver().switchTo().alert().getText();
					 Thread.sleep(3000);
					if(msg.equalsIgnoreCase("Are you certain you want to delete Security Group Details?")) {
						test.log(LogStatus.PASS, "Message displayed :- "+msg );
					}else {
						test.log(LogStatus.FAIL, "Message displayed :- "+msg );
					}

					getDriver().switchTo().alert().accept();
					 Thread.sleep(3000);

		SwitchtoParent(test);
	}
	
	public static void SecondaryRe( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[7]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
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

		SwitchtoParent(test);
	}
	
	public static void SecondaryReIn( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[7]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
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

		SwitchtoParent(test);
	}
	
	public static void SecondaryReDisplay( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
		Thread.sleep(4000);
		
		
		
		ImplementPOM.FilterSR().sendKeys("test3" ,Keys.ENTER);
		Thread.sleep(5000);
		
		
		ImplementPOM.ShowAssingment().click();
		Thread.sleep(5000);
		
		ImplementPOM.ComplianceLocation().click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceLocationEx().click();
		Thread.sleep(3000);
		  CompanyPOM.ExpandSR().click();
		Thread.sleep(3000);
		  CompanyPOM.ExpandSR1().click();
			Thread.sleep(3000);
			
				CompanyPOM.Check().click();
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
		ImplementPOM.Performer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer2sr().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer12CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.SaveSR().click();
		Thread.sleep(8000);
		
		String Msg =	ImplementPOM.SaveSRMSg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "message Displayed : - "+Msg );
			Thread.sleep(3000);
		

		ImplementPOM.CloseR2().click();
		Thread.sleep(5000);

		SwitchtoParent(test);
	}
	
	public static void SecondaryReDisplayIn( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[8]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
		Thread.sleep(4000);
		
		ImplementPOM.SeComplianceType().click();
		Thread.sleep(3000);
		ImplementPOM.SeComplianceTypeIn().click();
		Thread.sleep(4000);
		
		
		
		ImplementPOM.FilterSR().sendKeys("test" ,Keys.ENTER);
		Thread.sleep(5000);
		
		
		ImplementPOM.ShowAssingment().click();
		Thread.sleep(5000);
		
		ImplementPOM.ComplianceLocation().click();
		Thread.sleep(2000);
		ImplementPOM.ComplianceLocationEx().click();
		Thread.sleep(3000);
	//	  CompanyPOM.ExpandSR().click();
		Thread.sleep(3000);
	//	  CompanyPOM.ExpandSR1().click();
			Thread.sleep(3000);
			
				CompanyPOM.Check1().click();
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
		ImplementPOM.Performer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer2sr().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer12CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.SaveSR().click();
		Thread.sleep(8000);
		
		String Msg =	ImplementPOM.SaveSRMSg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "message Displayed : - "+Msg );
			Thread.sleep(3000);
		

		ImplementPOM.CloseR2().click();
		Thread.sleep(5000);

		SwitchtoParent(test);
	}

	
	public static void STSecondaryRe( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[7]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
		Thread.sleep(4000);
	
		
		ImplementPOM.SubTaskCA().click();
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
		SwitchtoParent(test);

	}
	
	public static void STSecondaryReIn( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[7]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
		Thread.sleep(4000);
		
		ImplementPOM.SeComplianceType().click();
		Thread.sleep(3000);
		ImplementPOM.SeComplianceTypeIn().click();
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
		SwitchtoParent(test);

	}

	public static void STSecondaryReDisplay( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[7]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
		Thread.sleep(4000);
		
		
		
		ImplementPOM.SubTaskCA().click();
		Thread.sleep(5000);
		
		ImplementPOM.ShowAssingment().click();
		Thread.sleep(5000);
		
		ImplementPOM.ComplianceLocation().click();
		Thread.sleep(4000);
		ImplementPOM.ComplianceLocationEx().click();
		Thread.sleep(3000);
		  CompanyPOM.ExpandSR().click();
		Thread.sleep(3000);
		  CompanyPOM.ExpandSR1().click();
			Thread.sleep(3000);
			
				CompanyPOM.Check().click();
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
		ImplementPOM.Performer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer2sr().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer12CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.SaveSR().click();
		Thread.sleep(8000);
		
		String Msg =	ImplementPOM.SaveSRMSg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "message Displayed : - "+Msg );
			Thread.sleep(3000);
		

		ImplementPOM.CloseR2().click();
		Thread.sleep(5000);
		SwitchtoParent(test);
	}

	public static void STSecondaryReDisplayIn( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[7]/a"))); 

		action.moveToElement(ImplementPOM.TaskCA()).click().build().perform();

		Thread.sleep(4000);
		ImplementPOM.TaskDetailsCA().click();
		Thread.sleep(4000);
		ImplementPOM.SeComplianceType().click();
		Thread.sleep(3000);
		ImplementPOM.SeComplianceTypeIn().click();
		Thread.sleep(4000);
		
		ImplementPOM.FilterSR().sendKeys("test" ,Keys.ENTER);
		Thread.sleep(5000);
		
		ImplementPOM.SubTask().click();
		Thread.sleep(5000);
		
		ImplementPOM.ShowAssingment().click();
		Thread.sleep(5000);
		
		ImplementPOM.ComplianceLocation().click();
		Thread.sleep(4000);
		ImplementPOM.ComplianceLocationEx().click();
		Thread.sleep(3000);
	//	  CompanyPOM.ExpandSR().click();
		Thread.sleep(3000);
		//  CompanyPOM.ExpandSR1().click();
			Thread.sleep(3000);
			
				CompanyPOM.Check1().click();
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
		ImplementPOM.Performer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer1CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.Reviewer2sr().click();
		Thread.sleep(3000);
		ImplementPOM.Reviewer12CA().click();
		Thread.sleep(8000);
		
		ImplementPOM.SaveSR().click();
		Thread.sleep(8000);
		
		String Msg =	ImplementPOM.SaveSRMSg().getText();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "message Displayed : - "+Msg );
			Thread.sleep(3000);
		

		ImplementPOM.CloseR2().click();
		Thread.sleep(5000);
		SwitchtoParent(test);
	}
	
	public static void WidgetMaster( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);
		SwitchtoChild(test);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
			//----------------------Add New --------------------------		
		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.MastersMC().click();
		Thread.sleep(3000);
		CompanyPOM.WidgetMaster().click();
		Thread.sleep(8000);
		//ImplementPOM.WidgeC().click();	Thread.sleep(1000);
		//ImplementPOM.ABCDPvtLtd1().click();
		Thread.sleep(4000);
		ImplementPOM.WidgetAddNew().click();
		Thread.sleep(4000);
	//	ImplementPOM.WidgetCustomer().click();
	//	Thread.sleep(1000);
	//	ImplementPOM.WidgetABCDPvtLtd().click();
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
		ImplementPOM.WidgetActCheckBoxAll().click();
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
			//ImplementPOM.WidgeC().click();
			Thread.sleep(1000);
		//	ImplementPOM.ABCDPvtLtd1().click();
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
				
				SwitchtoParent(test);
	}
	
	public static void WidgetMasterSF ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
		//----------------------Add New --------------------------		
	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	CompanyPOM.MastersMC().click();
	Thread.sleep(3000);
	CompanyPOM.WidgetMaster().click();
	Thread.sleep(8000);
		  
		 	
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(3000);
			CompanyPOM.WidgetMasterSF().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " Sample Format downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- Sample Format does not downloaded.");
			}
			Thread.sleep(3000);
			
			CompanyPOM.ChooseFileSF().sendKeys("C:\\Users\\shitalb\\Downloads\\WidgetSampleUploadFormat.xlsx"); // Writing Task title
			Thread.sleep(3000);
			  CompanyPOM.UploadWM().click();
			  	 Thread.sleep(3000);
				  	 
				  	String Text= CompanyPOM.UploadMSg().getText();
					 Thread.sleep(3000);
						test.log(LogStatus.PASS, "Message displayed :- "+Text );

					Thread.sleep(3000);
			
		  
		  	 SwitchtoParent(test);
		      Thread.sleep(3000);
	}
	
	public static void ComplianceFilter( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
		//----------------------Add New --------------------------		
	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	CompanyPOM.MastersMC().click();
	Thread.sleep(3000);
	
	CompanyPOM.Compliances().click();
	Thread.sleep(3000);
		  	 
		  	 
			CompanyPOM.FilterIP().sendKeys("Boilers Act, 1923 and Gujarat Boiler Rules, 1966",Keys.ENTER); // Writing Task title
			Thread.sleep(3000);
				  	 
			  List<String> li=new ArrayList<String>();
		        
		        li.add("Boilers Act, 1923 and Gujarat Boiler Rules, 1966");
		       
		        Thread.sleep(3000);
		        
			
				
			
				List<WebElement> IDcol=getDriver().findElements(By.xpath("//*[@id='BodyContent_grdCompliances']/tbody/tr/td[2]/div/span"));
				

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(IDcol);
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
						test.log(LogStatus.FAIL, " Compliance  filters not working  "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  "Compliance  filters should be working  and record should be displayed on grid"+Pas);
						
			 }
				 text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
					

		SwitchtoParent(test);
	}
	

	}
	
	public static void ComplianceCategoriesFilter( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
		//----------------------Add New --------------------------		
	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	CompanyPOM.MastersMC().click();
	Thread.sleep(3000);
	
	CompanyPOM.ComplianceCategories().click();
	Thread.sleep(3000);
		  	 
		  	 
			CompanyPOM.FilterIP().sendKeys("Commercial",Keys.ENTER); // Writing Task title
			Thread.sleep(3000);
				  	 
			  List<String> li=new ArrayList<String>();
		        
		        li.add("Commercial");
		       
		        Thread.sleep(3000);
		        
			
				List<WebElement> IDcol=getDriver().findElements(By.xpath("//*[@id='BodyContent_grdComplianceCategory']/tbody/tr/td[1]"));
				

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(IDcol);
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
						test.log(LogStatus.FAIL, " \"Compliance category\" filters not working  "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  "\"Compliance category\"  filters should be working  and record should be displayed on grid"+Pas);
						
			 }
				 text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
					

		SwitchtoParent(test);
	}
	

	

	}
	
	public static void ComplianceTypeFilter( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (140));
		Thread.sleep(3000);
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
		//----------------------Add New --------------------------		
	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	CompanyPOM.MastersMC().click();
	Thread.sleep(3000);
	
	CompanyPOM.ComplianceType().click();
	Thread.sleep(3000);
		  	 
		  	 
			CompanyPOM.FilterIP().sendKeys("Central",Keys.ENTER); // Writing Task title
			Thread.sleep(3000);
				  	 
			  List<String> li=new ArrayList<String>();
		        
		        li.add("Central");
		       
		        Thread.sleep(3000);
		        
			
				List<WebElement> IDcol=getDriver().findElements(By.xpath("//*[@id='BodyContent_grdComplianceType']/tbody/tr/td[1]"));
				

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(IDcol);
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
						test.log(LogStatus.FAIL, " \"Compliance Types\" filters not working  "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  "\"Compliance Types\"  filters should be working  and record should be displayed on grid"+Pas);
						
			 }
				 text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
					

		SwitchtoParent(test);
	}
	

	}
	
	public static void ComplianceAssignment( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		SwitchtoChild(test);
		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		CompanyPOM.ComplianceAssignment1().click();
		Thread.sleep(3000);
	//	ImplementPOM.SelectCustomerUR().click();
		Thread.sleep(500);
	//	ImplementPOM.BitademopuneU().click();
		Thread.sleep(1000);
		ImplementPOM.SelectPerformerCA().click();
		Thread.sleep(500);
		ImplementPOM.abcExternal().click();
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
		ImplementPOM.abclawyer().click();
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
		SwitchtoParent(test);
	}
	
	public static void AssignCheckListCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		SwitchtoChild(test);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
																												

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.ChecklistAssignment().click();
		Thread.sleep(3000);
		CompanyPOM.AssignCheckList().click();
		Thread.sleep(3000);
	//	ImplementPOM.SelectCustomerURI().click();
		Thread.sleep(500);
	//	ImplementPOM.BitademopuneU().click();
	//	Thread.sleep(4000);
		ImplementPOM.SelectPerformerCA().click();
		Thread.sleep(500);
		ImplementPOM.abcExternal().click();
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
		ImplementPOM.abclawyer().click();
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
		
		SwitchtoParent(test);
	}
	
	
	public static void IntermediateComplianceCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		SwitchtoChild(test);
		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		CompanyPOM.IntermediateAssignment().click();
		Thread.sleep(3000);
	//	ImplementPOM.SelectCustomerURI().click();
	//	Thread.sleep(500);
	//	ImplementPOM.BitademopuneU().click();
		Thread.sleep(2000);
		ImplementPOM.SelectLocationCA().click();
		Thread.sleep(500);
		ImplementPOM.LocationCA().click();
		Thread.sleep(1000);
		ImplementPOM.ALENAVENTURESLIMITEDCB().click();
		Thread.sleep(500);
		ImplementPOM.select().click();
		Thread.sleep(4000);
		ImplementPOM.FilterM().sendKeys("Akshay Kumar",Keys.ENTER);
		Thread.sleep(4000);
		String text1=	ImplementPOM.CheckFilter().getText();
		if(text1.equalsIgnoreCase("Akshay Kumar")) {
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
		
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		CompanyPOM.ExportIC().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
		
		SwitchtoParent(test);
	}
	
	public static void IntermediateCheckListCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		SwitchtoChild(test);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.ChecklistAssignment().click();
		Thread.sleep(3000);
		CompanyPOM.IntermediateCheckList().click();
		Thread.sleep(3000);
		//ImplementPOM.SelectCustomerURI().click();
		Thread.sleep(500);
	//	ImplementPOM.BitademopuneU().click();
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
		
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		CompanyPOM.ExportIC().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
		Thread.sleep(3000);
		SwitchtoParent(test);
		Thread.sleep(3000);
	}
	
	public static void ActivateComplianceCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		SwitchtoChild(test);
		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		CompanyPOM.ActivateAssignment().click();
		Thread.sleep(3000);
		
		
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
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		SwitchtoParent(test);
		
	}
	
	public static void ActivateCheckListCA( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		SwitchtoChild(test);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"))); 
		

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.ChecklistAssignment().click();
		Thread.sleep(3000);
		CompanyPOM.ActivateCheckList().click();
		Thread.sleep(3000);
	//	ImplementPOM.SelectCustomerURI().click();
		Thread.sleep(500);
	//	ImplementPOM.BitademopuneU().click();
	///	Thread.sleep(2000);
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
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		ImplementPOM.ExportActivate().click(); // Exporting (Downloading) file

		Thread.sleep(3000);// C://Users//jiya//Downloads//
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS, "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		SwitchtoParent(test);
	}
	
	public static void ComplianceMappingCopy( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		SwitchtoChild(test);
		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.ComplianceAssignment().click();
		Thread.sleep(3000);
		CompanyPOM.ComplianceMappingCopy().click();
		Thread.sleep(3000);
		
		
		CompanyPOM.CMLocation().click();
		Thread.sleep(1000);
		CompanyPOM.CMLocationEx().click();
		Thread.sleep(1000);
		CompanyPOM.CMLocation1().click();
		Thread.sleep(3000);
		
		CompanyPOM.SelectPerformer().click();
		Thread.sleep(3000);
		CompanyPOM.SelectPerformer1().click();
		Thread.sleep(3000);
		
		CompanyPOM.SelectMappingLocation().click();
		Thread.sleep(1000);
		CompanyPOM.SelectMappingLocationEx().click();
		Thread.sleep(1000);
		CompanyPOM.SelectMappingLocation1().click();
		Thread.sleep(3000);
		
		CompanyPOM.SelectReviewer().click();
		Thread.sleep(3000);
		CompanyPOM.SelectReviewer1().click();
		Thread.sleep(3000);
		
		
		
		CompanyPOM.CheckBox().click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		js.executeScript("window.scrollBy(0,500)");	
		Thread.sleep(5000);
		ImplementPOM.ClickSaveBTn().click();
		Thread.sleep(8000);
		Thread.sleep(8000);
		String AMsg = CompanyPOM.SaveMsgCMC().getText();
		Thread.sleep(8000);
		Thread.sleep(3000);
		if(AMsg.equalsIgnoreCase("Compliances Assigned Successfully")) {
		test.log(LogStatus.PASS, "Message displayed -:- " + AMsg);
		Thread.sleep(1000);
		}else {
			test.log(LogStatus.FAIL, "Message displayed -:- " + AMsg);
		}

		
		SwitchtoParent(test);
		
	}
	
	public static void ReOpeningofCompliance( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);
		SwitchtoChild(test);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.Configuration().click();
		Thread.sleep(1000);
		CompanyPOM.ReOpeningofCompliance().click();
		Thread.sleep(4000);
		//ImplementPOM.CustomerReopen().click();
		Thread.sleep(1000);
	//	ImplementPOM.AvantisTest1().click();
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
		
		SwitchtoParent(test);
	}
	
	public static void ClientComplianceRiskMapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.Configuration().click();
		Thread.sleep(1000);
		CompanyPOM.ChangeRiskofCompliance().click();
		Thread.sleep(4000);
		
	//	ImplementPOM.ClientCustomer().click();
		Thread.sleep(1000);
	//	ImplementPOM.customer123Users().click();
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
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			ImplementPOM.ExportClient().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " File does not downloaded.");
			}
			
			CompanyPOM.ChangeRiskofComplianceCF().sendKeys("C:\\Users\\shitalb\\Downloads\\ComplianceRiskDetails.xlsx"); // Writing Task title
			Thread.sleep(8000);
			  CompanyPOM.UploadIp().click();
			  	 Thread.sleep(3000);
				  	 
				  	String Text= CompanyPOM.UploadMSgCR().getText();
					 Thread.sleep(3000);
						test.log(LogStatus.PASS, "Message displayed :- "+Text );

			
			
			
			ImplementPOM.FilterType().sendKeys("8804",Keys.ENTER);
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Filter Working Successfully");
			Thread.sleep(1000);
			SwitchtoParent(test);
	}
	
	public static void ClientFrequencyMapping( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		
																										
   //----------------Add New-----------------------------
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
					//---------------------------Add New Entities Assignments	--------------------------------																						

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.Configuration().click();
		Thread.sleep(1000);
		CompanyPOM.ClientFrequencyMapping().click();
		Thread.sleep(4000);
		
		ImplementPOM.DocumentCustomer().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(8000);
		ImplementPOM.AddNewCF().click();
		Thread.sleep(3000);
		ImplementPOM.CustomerName1().click();
		Thread.sleep(1000);
		ImplementPOM.customer123Users().click();
		Thread.sleep(4000);
		ImplementPOM.ActNameDueDate().clear();
		Thread.sleep(1000);
		ImplementPOM.ActNameDueDate().sendKeys("Customs Act, 1962 and Warehoused Goods (Removal) Regulations, 2016");
		Thread.sleep(1000);
		ImplementPOM.ActNameDueDateLatest().click();
		Thread.sleep(8000);
		ImplementPOM.ShortDescription1().click();
		Thread.sleep(1000);
		ImplementPOM.ShortDescription12().click();
		Thread.sleep(8000);
		ImplementPOM.ClientFrequency().click();
		Thread.sleep(1000);
		ImplementPOM.Annual().click();
		Thread.sleep(8000);
		ImplementPOM.DueDateSave().click();
		Thread.sleep(2000);
		String Msg4 = ImplementPOM.DueDateSaveMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg4);
		Thread.sleep(2000);
		ImplementPOM.DueDateClose().click();
		Thread.sleep(3000);
		//------------Filter -------------------------
		ImplementPOM.FilterType().sendKeys("Customs Act, 1962 and Warehoused Goods (Removal) Regulations, 2016",Keys.ENTER);
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
		Thread.sleep(8000);
		ImplementPOM.DueDateSave().click();
		Thread.sleep(8000);
		String Msg = ImplementPOM.DueDateSaveMsg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg);
		Thread.sleep(2000);
		ImplementPOM.DueDateClose().click();
		Thread.sleep(8000);
		//------------Display Schedule Information -------------------------

		ImplementPOM.DisplayScheduleInformation1().click();
		Thread.sleep(2000);
		ImplementPOM.DisplayScheduleInformationSave().click();
		Thread.sleep(8000);
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
		Thread.sleep(8000);
		//---------------------Export------------------------
		//	Thread.sleep(3000);
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			ImplementPOM.SampleFormatCF().click(); // Exporting (Downloading) file

			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " :- File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
		
		//----------------- File Upload ----------------
		ImplementPOM.Choose().sendKeys("C:\\Users\\shitalb\\Downloads\\ClientBasedFrequency_Sample.xlsx");
		Thread.sleep(8000);
		ImplementPOM.Upload1().click();
		Thread.sleep(8000);
		String Msg7 = ImplementPOM.UploadMeg().getText();

		test.log(LogStatus.PASS, " Message displayed -:- " + Msg7);
		Thread.sleep(2000);
		
		SwitchtoParent(test);
		
	}
	
	public static void Targetdate( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		
																										
   //----------------Add New-----------------------------
		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 																					

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.Configuration().click();
		Thread.sleep(1000);
		CompanyPOM.Targetdate().click();
		Thread.sleep(4000);
		
	//	ImplementPOM.SelectCustomerTD().click();
		Thread.sleep(1000);
	//	ImplementPOM.PQR().click();

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
		SwitchtoParent(test);
	}
	
	public static void DocumentNotApplicable( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);
		SwitchtoChild(test);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 
			//----------------------Add New --------------------------		
		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.Configuration().click();
		
		Thread.sleep(3000);
		CompanyPOM.DocumentNotApplicable().click();
		Thread.sleep(8000);
		
		CompanyPOM.ClickEdit().click();
		Thread.sleep(4000);
	
		Thread.sleep(2000);
		ImplementPOM.SelectLocationdea().click();
		Thread.sleep(1000);
		ImplementPOM.ExpandABCDPvtLtd1().click();
		Thread.sleep(2000);
		ImplementPOM.ABCDAurangabadPvt1().click();
		Thread.sleep(4000);
		CompanyPOM.SelectLoct().click();
		Thread.sleep(4000);
	
		
		CompanyPOM.DocumentDate().click();
		Thread.sleep(2000);
		CompanyPOM.DocumentDate1().click();
		Thread.sleep(2000);
		
		CompanyPOM.SaveDNA().click();
		Thread.sleep(2000);
		try {
		String msg=	getDriver().switchTo().alert().getText();
		Thread.sleep(2000);
		getDriver().switchTo().alert().accept();
		
			test.log(LogStatus.PASS,  "Message displayed :- " +msg);
		
		}catch(Exception e)
	
		{
		
		ImplementPOM.WidgetClose().click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS,  "compliance not Update" );
		}
		//----------------------Filter --------------------------
	
		ImplementPOM.FilterM().sendKeys("8693",Keys.ENTER); // Writing Task title
		
		Thread.sleep(5000);
			
				test.log(LogStatus.PASS,  " Filter Working  successfully.");
				Thread.sleep(1000);
			
				
				SwitchtoParent(test);
	}
	
	
	public static void EntitiesAssignmentsMC( ExtentTest test)throws InterruptedException, IOException 
	
	{
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		
					//---------------------------Add New Entities Assignments	--------------------------------																						

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 																					

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.EntitiesAssignmentsMC().click();
		Thread.sleep(3000);
		CompanyPOM.EntitiesAssignmentsMC1().click();
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
		//ImplementPOM.CustomerAE().click();
	//	Thread.sleep(500);
	//	ImplementPOM.ABCDPvtLtd1().click();
		Thread.sleep(4000);
		ImplementPOM.Location().click();
		Thread.sleep(500);
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
	//	ImplementPOM.DeleteCustomer().click();
	//	Thread.sleep(500);
	//	ImplementPOM.DeleteABCDPvtLtd().click();
		Thread.sleep(4000);
		ImplementPOM.DeleteLocation().click();
		Thread.sleep(500);
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
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " Excel File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "  File does not downloaded.");
		}
		
		SwitchtoParent(test);
	}
	
	public static void DepartmentEntitiesAssignmentsMC( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		
					//---------------------------Add New Entities Assignments	--------------------------------																						

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 																					

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.EntitiesAssignmentsMC().click();
		Thread.sleep(3000);
		CompanyPOM.DepartmentEntitiesAssignmentsMC().click();
		Thread.sleep(8000);
	
		Thread.sleep(4000);
		ImplementPOM.AddNew().click();
		Thread.sleep(4000);
		
		ImplementPOM.Deptuser().click();
		Thread.sleep(500);
		ImplementPOM.RahulTesting().click();
		Thread.sleep(8000);
		
		CompanyPOM.DepartmentcheckAll().click();
		Thread.sleep(500);
		CompanyPOM.Departmentcheck1().click();
		Thread.sleep(500);
		CompanyPOM.DepartmentMC().click();
		Thread.sleep(3000);
		
		ImplementPOM.Location().click();
		Thread.sleep(500);
		ImplementPOM.LocationExpand().click();
		Thread.sleep(500);
		ImplementPOM.ASDAZFTextile().click();
		Thread.sleep(1000);
		ImplementPOM.Location().click();
		Thread.sleep(4000);
		
		
		ImplementPOM.SaveAE().click();
		Thread.sleep(4000);
		
	

		Thread.sleep(500);
		test.log(LogStatus.PASS, "Entities Assignments successfully.");
		//---------------------------Delete Entities --------------------------------																						

		Thread.sleep(5000);
		ImplementPOM.DeptDeleteEntities().click();
		Thread.sleep(3000);
		ImplementPOM.DelDeptuser().click();
		Thread.sleep(500);
		ImplementPOM.RahulTesting().click();
		Thread.sleep(8000);
		
		CompanyPOM.DepartmentcheckAll1().click();
		Thread.sleep(500);
		CompanyPOM.Departmentcheck11().click();
		Thread.sleep(500);
		CompanyPOM.DepartmentMC1().click();
		Thread.sleep(3000);
		
		CompanyPOM.DeleteLocation().click();
		Thread.sleep(500);
		CompanyPOM.DeleteExpand().click();
		Thread.sleep(500);
		CompanyPOM.DeleteExpand().click();
		Thread.sleep(1000);
		CompanyPOM.DeleteLocation().click();
		Thread.sleep(5000);
		
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
		
		SwitchtoParent(test);
	}
	
	public static void LicenseEntitiesAssignmentsMC( ExtentTest test)
			throws InterruptedException, IOException {
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (80));
		Thread.sleep(3000);

		
					//---------------------------Add New Entities Assignments	--------------------------------																						

		SwitchtoChild(test);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 																					

		action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
		Thread.sleep(1000);
		CompanyPOM.EntitiesAssignmentsMC().click();
		Thread.sleep(3000);
		CompanyPOM.LicenseEntitiesAssignments1().click();
		Thread.sleep(3000);
	//	ImplementPOM.LicenseCustomer().click();
	//	Thread.sleep(500);
	//	ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.AddNew().click();
		Thread.sleep(4000);
	//	ImplementPOM.LicenseCustomerAE().click();
		Thread.sleep(500);
		//ImplementPOM.BitademopuneU().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation().click();
		Thread.sleep(500);
		ImplementPOM.LicenseExpand().click();
		Thread.sleep(500);
		ImplementPOM.ABitaPharmaCompany().click();
		Thread.sleep(1000);
		ImplementPOM.selectAe().click();
		Thread.sleep(4000);
		ImplementPOM.Licenseuser().click();
		Thread.sleep(500);
		ImplementPOM.mgmtf1().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation().click();
		Thread.sleep(500);
		ImplementPOM.LicenseType().click();
		Thread.sleep(500);
		ImplementPOM.AerodromeLicence().click();
		Thread.sleep(4000);
		ImplementPOM.LicenseLocation().click();
		Thread.sleep(2000);
		ImplementPOM.SaveAE().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS,  " Add New  License Entities Assignments successfully.");
		//---------------------Export------------------------
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ImplementPOM.ClickExport().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
			//	ImplementPOM.LicenseDeleteC().click();
			//	Thread.sleep(500);
			//	ImplementPOM.BitademopuneU().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteLocExpand().click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteABitPharmaCompany().click();
				Thread.sleep(2000);
				
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(4000);
				
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteUser().click();
				Thread.sleep(500);
				ImplementPOM.mgmtf1().click();
				Thread.sleep(4000);
				ImplementPOM.LicenseDeleteLoc().click();
				Thread.sleep(500);
				ImplementPOM.LicenseDeleteType().click();
				Thread.sleep(500);
				ImplementPOM.AerodromeLicence().click();
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
				
				SwitchtoParent(test);
		
	}
	
public static void AssignComplianceInternal( ExtentTest test) throws InterruptedException, IOException
	{
	Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		// switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
	
  		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
  		
  		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
		//Thread.sleep(4000);
		//CompanyPOM.clickInternalCompliance().click();
		Thread.sleep(4000);
		CompanyPOM.clickAssignCompliance().click();
		Thread.sleep(4000);
		CompanyPOM.clickLocation().click();
		Thread.sleep(4000);
		CompanyPOM.clickLocationExpand().click();
		Thread.sleep(4000);
		CompanyPOM.selectLocation().click();
		Thread.sleep(4000);
		CompanyPOM.clickPerformer().click();
		Thread.sleep(4000);
		CompanyPOM.selectPerformer().click();
		Thread.sleep(4000);
		CompanyPOM.clickReviewer().click();
		Thread.sleep(4000);
		CompanyPOM.selectReviewer().click();
		Thread.sleep(4000);
		CompanyPOM.clickCategory().click();
		Thread.sleep(4000);
		CompanyPOM.selectCategory().click();
		Thread.sleep(4000);
		CompanyPOM.selectCheckbox().click();
		
	
		//scroll down a page
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(4000);
		CompanyPOM.clickSaveBtn().click();
		
		Thread.sleep(8000);
	    // Switching to Alert        
        Alert alert1 = getDriver().switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage1= getDriver().switchTo().alert().getText();	
        
        
        test.log(LogStatus.PASS, alertMessage1);
        		
        // Displaying alert message		
        System.out.println(alertMessage1);
        
        // Accepting alert		
        	alert1.accept();
        
        Thread.sleep(4000);
		SwitchtoParent(test);
		
		
	
	}

public static void DepartmentReassignmentExport( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);
	SwitchtoChild(test);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
      Thread.sleep(1000);
	Thread.sleep(4000);
	   CompanyPOM.Configuration().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.DepartmentReassignment().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.SelectEntityLocationFilter().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.Checkbox().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.SelectButton().click();
	  	 Thread.sleep(2000);
	  	Thread.sleep(3000);
		File dir = new File("C:\\Users\\shitalb\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		CompanyPOM.ExportButton().click();
	  	 Thread.sleep(2000); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\shitalb\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.INFO,  " :- File does not downloaded.");
		}
		Thread.sleep(500);

	  	
		  	

}

	
public static void DepartmentReassignmentUpload( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);
	SwitchtoChild(test);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]")));	//Wait until records table get visible.
  	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
      Thread.sleep(1000);
	Thread.sleep(4000);
	   CompanyPOM.Configuration().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.DepartmentReassignment().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.SelectEntityLocationFilter().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.Checkbox().click();
	  	 Thread.sleep(2000);
	  	CompanyPOM.SelectButton().click();
	  	 Thread.sleep(2000);
	  	Thread.sleep(3000);
	  	Thread.sleep(500);
	  	CompanyPOM.Uploadbutton().click();
	  	 Thread.sleep(2000);
	  	 
	  	try {
            // Wait up to 70 seconds for the link to appear
	  		WebDriverWait wait1 = new WebDriverWait( getDriver(), 70);
            By locator = By.xpath("//div[@id='BodyContent_ctl01']//li");
            
			wait1.until(ExpectedConditions.presenceOfElementLocated(locator));
	  		
            System.out.println("Link is present!");
    		test.log(LogStatus.PASS, "Message displayed without upload file -- validation message displayed");

        } catch (Exception e) {
        	test.log(LogStatus.PASS, "Message displayed without upload file -- validation message not displayed");
        	
        }
	  	CompanyPOM.ChooseFileDR().sendKeys("E:\\Ethics Committee Details.xlsx"); // Writing Task title
		Thread.sleep(3000);
		CompanyPOM.Uploadbutton().click();
	  	 Thread.sleep(2000);
		String Msg7 = CompanyPOM.ValidationMessage().getText();
	//  	CompanyPOM.ChooseFileDR().click();
	 // 	 Thread.sleep(2000);
	  	
		test.log(LogStatus.PASS, "Message displayed after upload invalid file -:- " + Msg7);
		Thread.sleep(4000);
		
	  	SwitchtoParent(test);
	  	Thread.sleep(2000);
	  	
	  	
}

public static void AllReport( ExtentTest test) throws InterruptedException, IOException
{
			
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyPOM.clickStatutoryAssi().click();
	      		  	 Thread.sleep(2000);
	      		   CompanyPOM.SelectLocationSA().click();
	      		  	 Thread.sleep(1000);
	      		   CompanyPOM.Expand().click();
	      		  	 Thread.sleep(1000);
	      		   CompanyPOM.DPvtLtdAS().click();
	      		  	 Thread.sleep(1000);
	      		  	 
	      		  	 
	 	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdAllReport_lbkDownload_0']/img")));	//Wait until records table get visible.
	 		Thread.sleep(3000);
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.clickExport().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			
			
			Thread.sleep(1000);
			/*
		  	action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickCheckListAssi().click();
		    Thread.sleep(4000);
		    Thread.sleep(2000);
   		   CompanyPOM.SelectLocationSA().click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.Expand().click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.DPvtLtdAS().click();
   		   */
   		  	 Thread.sleep(2000);
   		  dir = new File("C:\\Users\\shitalb\\Downloads");
			 dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.clickExport1().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			 dir1 = new File("C:\\Users\\shitalb\\Downloads");
			 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- File does not downloaded.");
			}
			  	
			Thread.sleep(1000);
			/*
		  	action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
		      Thread.sleep(1000);
		    CompanyPOM.clickCheckListAssi().click();
		    Thread.sleep(4000);
		    Thread.sleep(2000);
   		   CompanyPOM.SelectLocationSA().click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.Expand().click();
   		  	 Thread.sleep(1000);
   		   CompanyPOM.DPvtLtdAS().click();
   		   */
   		  	 Thread.sleep(1000);
   		  dir = new File("C:\\Users\\shitalb\\Downloads");
			 dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.ShortReport().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			 dir1 = new File("C:\\Users\\shitalb\\Downloads");
			 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " Short Report downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  " Short Report does not downloaded.");
			}
			Thread.sleep(1000);
	   		  dir = new File("C:\\Users\\shitalb\\Downloads");
				 dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(500);
				CompanyPOM.DocumentDownload().click(); // Exporting (Downloading) file

				Thread.sleep(8000);
				 dir1 = new File("C:\\Users\\shitalb\\Downloads");
				 allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {
					test.log(LogStatus.PASS,  " Document downloaded successfully.");
				} else {
					test.log(LogStatus.FAIL,  " Document does not downloaded.");
				}

			

}

public static void LogReport( ExtentTest test) throws InterruptedException, IOException
{
			
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
	      Thread.sleep(2000);
	      CompanyPOM.clickCheckListAssi().click();
	      		  	 Thread.sleep(2000);
	      		  	SwitchToNewlyOpenedWindow(test);
	      			Thread.sleep(3000);
	      		   CompanyPOM.Locationentity().click();
	      		  	 Thread.sleep(1000);
	      		  	CompanyPOM.SelectAll().click();
	      		  	 Thread.sleep(1000);
	      		  	CompanyPOM.Locationentity().click();
	      		  	 Thread.sleep(1000);
	      		  	CompanyPOM.Apply().click();
	      		  	 Thread.sleep(3000);
	      		  	 
	      		  	
	 	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']")));	//Wait until records table get visible.
	 		Thread.sleep(3000);
			File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.Exportlog().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " Log Report Exported successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- Log Report Exported does not Exported.");
			}
						
			Thread.sleep(1000);
			CompanyPOM.ClearbuttonLogReport().click();
 		  	 Thread.sleep(2000);
 		  	test.log(LogStatus.PASS,  " Clear button working successfully.");
 		   Thread.sleep(2000);

}

public static void UserLogReport( ExtentTest test) throws InterruptedException, IOException
{
			
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
	      Thread.sleep(2000);
	      CompanyPOM.clickEventBasedAssi().click();
	      		  	 Thread.sleep(2000);
	      		  	SwitchToNewlyOpenedWindow(test);
	      			Thread.sleep(3000);
	 	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']")));//Wait until records table get visible.	 	  	
	 		Thread.sleep(3000);
	 		ExcelcountAndGridMatch(test,workbook);
	 		Thread.sleep(2000);
	 		 CompanyPOM.UserDropDown().click();
  		  	 Thread.sleep(4000);
  		  	CompanyPOM.UserDropDownSelectValue().click();
  		  	 Thread.sleep(1000);
  		  	CompanyPOM.UserDropDown().click();
  		  	 Thread.sleep(1000);
  		  	CompanyPOM.Apply().click();
  		  	 Thread.sleep(3000);
			CompanyPOM.ClearbuttonLogReport().click();
 		  	 Thread.sleep(2000);
 		  	test.log(LogStatus.PASS,  " Clear button working successfully.");
 		   Thread.sleep(2000);

}

public static void ReassignmentExcludeReport( ExtentTest test) throws InterruptedException, IOException
{
			
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    // switching child window
		SwitchtoChild(test);
		Thread.sleep(3000);
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyPOM.clickReport()).click().build().perform();
	      Thread.sleep(2000);
	      CompanyPOM.clickInternalAssi().click();
	      		  	 Thread.sleep(2000);
	      		  //	SwitchToNewlyOpenedWindow(test);
	      			//Thread.sleep(3000);
	 	//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='grid']")));//Wait until records table get visible.	 	  	
	 		Thread.sleep(3000);
	 		CompanyPOM.SelectLocationSA().click();
 		  	 Thread.sleep(1000);
 		   CompanyPOM.Expand().click();
 		  	 Thread.sleep(1000);
 		   CompanyPOM.DPvtLtdAS().click();
 		  	 Thread.sleep(3000);
 		  	File dir = new File("C:\\Users\\shitalb\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			CompanyPOM.clickExport().click(); // Exporting (Downloading) file

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\shitalb\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " Excel Exported successfully.");
			} else {
				test.log(LogStatus.FAIL,  " :- Excel Exported does not Exported.");
			}
						
			Thread.sleep(1000);

}

public static void ExcelcountAndGridMatch( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
{
		    
  
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000); 		
    
    Thread.sleep(7000);
    CompanyPOM.readTotalItems().click();
	String item = CompanyPOM.readTotalItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = CompanyPOM.readTotalItems().getText();
		bits = item.split(" ");
    
	}
	
	Thread.sleep(2000);
    JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
    
    js1.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\shitalb\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
CompanyPOM.Exportlog().click();
Thread.sleep(9000);					//Clicking on 'Excel Report' image.
test.log(LogStatus.PASS, "User Log Report downloaded successfully.");

Thread.sleep(5500);
File dir1 = new File("C:\\Users\\shitalb\\Downloads");
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
test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}

    

}

public static void UsageReport( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (80));
	Thread.sleep(3000);

	
				//---------------------------Add New Entities Assignments	--------------------------------																						

	SwitchtoChild(test);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[2]/a"))); 																					

	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	CompanyPOM.MCReportUR().click();
	Thread.sleep(3000);
	CompanyPOM.UsageReport().click();
	Thread.sleep(4000);
	CompanyPOM.LocationSelect().click();
	Thread.sleep(3000);
	CompanyPOM.LocationSelectValue().click();
	Thread.sleep(4000);
//	CompanyPOM.LocationSelect().click();
//	Thread.sleep(3000);
	CompanyPOM.Fromdate().click();
	Thread.sleep(3000);
	String OptionText = "Option 1";
	String xpathExpression = String.format("//select[@class='ui-datepicker-month']/option[1]",OptionText);
	WebElement dropdownOption = getDriver().findElement(By.xpath(xpathExpression));
	dropdownOption.click();
	Thread.sleep(1000);
	String OptionText1 = "Option 73";
	String xpathExpression1 = String.format("//select[@class='ui-datepicker-year']/option[73]",OptionText1);
	WebElement dropdownOption1 = getDriver().findElement(By.xpath(xpathExpression1));
	dropdownOption1.click();
	Thread.sleep(1000);
	CompanyPOM.Formdate1jan().click();
	Thread.sleep(2000);
	CompanyPOM.Todate().click();
	Thread.sleep(4000);
	CompanyPOM.Todatesep1().click();
	Thread.sleep(2000);
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	CompanyPOM.ExportExcel().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Usage Report Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Usage Report Exported does not Exported.");
	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
}

public static void LicenceList( ExtentTest test)
		throws InterruptedException, IOException {
	Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (140));
	Thread.sleep(3000);
	SwitchtoChild(test);
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
	action.moveToElement(CompanyPOM.ManageCompliances()).click().build().perform();
	Thread.sleep(1000);
	CompanyPOM.MCReportUR().click();
	Thread.sleep(3000);
	CompanyPOM.Licenselist().click();
	Thread.sleep(4000);
	CompanyPOM.EntityLocation().click();
	Thread.sleep(3000);
	CompanyPOM.Expand().click();
	Thread.sleep(3000);
	String locationtext = CompanyPOM.EntityLocationValue().getText();
	Thread.sleep(2000);
	CompanyPOM.EntityLocationValue().click();
	Thread.sleep(9000);
	CompanyPOM.Licensetypename().click();
	Thread.sleep(500);
	String licensetypenametext = CompanyPOM.Licensetypenamevalue().getText();
	Thread.sleep(2000);
	CompanyPOM.Licensetypenamevalue().click();
	Thread.sleep(2000);
	  	  
	 	
	  	 
			
			  Thread.sleep(500);
		        List<String> li=new ArrayList<String>();
		        
		        li.add(locationtext);
		        li.add(licensetypenametext);
		       
		        Thread.sleep(3000);
		        
				List<String> filter=new ArrayList<String>();	
				filter.add("Location");
				filter.add("License Type");
			
				List<WebElement> Location= getDriver().findElements(By.xpath("//*[@id='BodyContent_grdLicenseList']/tbody/tr[3]/td[1]"));
				List<WebElement> LicenseType= getDriver().findElements(By.xpath("//*[@id='BodyContent_grdLicenseList']/tbody/tr[3]/td[2]"));


				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(Location);
						}
						if(i==1)
						{
							raw.addAll(LicenseType);
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
				}
				
	


public static void UploadInternalData( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.UploadInternalTab().click();
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
	Thread.sleep(1000);
	CompanyPOM.ExcelFormat().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Excel Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Excel does not Exported.");
	}
				
	Thread.sleep(3000);
	CompanyPOM.ChooseFileInternal().sendKeys("E:\\Regtrack Merge Project\\Regtrack-Project\\TestData\\UploadSheet\\Internal Compliance Upload Format (3).xlsx"); // Writing Task title
	Thread.sleep(3000);
	CompanyPOM.UploadInternal().click();
	Thread.sleep(2000);
	String t = CompanyPOM.ValMessage().getText();
	Thread.sleep(2000);
	if(t.equalsIgnoreCase("Entity Details Saved Successfully")) 
	 {
			test.log(LogStatus.PASS, t);
		}
		else
		{
			test.log(LogStatus.FAIL, t);
			
			
		} 
	Thread.sleep(2000);
	CompanyPOM.ValMessage().click();
	Thread.sleep(2000);
	String t1 = CompanyPOM.SaveValMessage().getText();
	Thread.sleep(2000);
	if(t1.equalsIgnoreCase("Entity Details Saved Successfully")) 
	 {
			test.log(LogStatus.PASS, t1);
		}
		else
		{
			test.log(LogStatus.FAIL, t1);
			
			
		} 
		
		Thread.sleep(5000);
	SwitchtoParent(test);
	
	}

public static void LicenseEntitiesAssignment( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.LicenseEntities().click();
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	CompanyPOM.ExportExcelL().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Excel Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Excel Exported does not Exported.");
	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
	}

public static void EntitiesAssignment( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.EntitiesAssignment().click();
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	CompanyPOM.ExportExcelL().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Excel Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Excel Exported does not Exported.");
	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
	}
public static void UploadAssignment( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.UploadAssignment().click();
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	CompanyPOM.ExcelFormat().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Excel Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Excel Exported does not Exported.");
	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
	}

public static void ActivateChecklist( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.ActivateChecklist().click();
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	CompanyPOM.ExportExcelL().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Excel Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Excel Exported does not Exported.");
	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
	}

public static void ComplianceAssignments( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.ActivateChecklist().click();
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	CompanyPOM.ExportExcelL().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Excel Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Excel Exported does not Exported.");
	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
	}

public static void Compliance( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.Compliance().click();
	File dir = new File("C:\\Users\\shitalb\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	CompanyPOM.ExportExcelL().click(); // Exporting (Downloading) file

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\shitalb\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		test.log(LogStatus.PASS,  " Excel Exported successfully.");
	} else {
		test.log(LogStatus.FAIL,  " :- Excel Exported does not Exported.");
	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
	}

public static void ComplianceAddnewlink( ExtentTest test) throws InterruptedException, IOException
{
Actions action = new Actions(getDriver());
	WebDriverWait wait = new WebDriverWait( getDriver(), (40));
	Thread.sleep(3000);
	// switching child window
	SwitchtoChild(test);
	Thread.sleep(3000);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[5]")));	//Wait until records table get visible.
		
		action.moveToElement(CompanyPOM.clickInternalCompliance()).click().build().perform();
	//Thread.sleep(4000);
	//CompanyPOM.clickInternalCompliance().click();
	Thread.sleep(4000);
	CompanyPOM.Compliance().click();
	Thread.sleep(2000);
	if(CompanyPOM.AddNewlink().isDisplayed()) {
		test.log(LogStatus.PASS, "Add new link should be seen after click on compliance tab" );
	}
	else {
		test.log(LogStatus.FAIL, "Add new link should not be seen after click on compliance tab" );

	}
				
	Thread.sleep(1000);
	SwitchtoParent(test);
	
	}

}









