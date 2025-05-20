package companyAdminDiy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import companyadmin.CompanyPOM;
import implementation.ImplementPOM;
import login.BasePage;

public class CompanyAdminDiyMethod  extends BasePage{
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	public static void SwitchtoChild( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Thread.sleep(3000);
		CompanyPOM.clickAdmin().click();
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	      
	      sheet = workbook.getSheetAt(21); // Retrieving fourth sheet of Workbook(Named - Update Tasks)
			int row = 0;
			Thread.sleep(500);
			Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
			Cell c1 = null;
			row0 = sheet.getRow(3);
			c1 = row0.getCell(1);
			String URL1 = c1.getStringCellValue();

			getDriver().get(URL1);
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

	public static void User( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		SwitchtoChild(test,workbook);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyAdminDiyLocator.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyAdminDiyLocator.Users().click();
	      		  	 Thread.sleep(2000);
	      		   CompanyAdminDiyLocator.ModifyAssignmentsLink().click();
	      		  	 Thread.sleep(2000);
	      		  	if(CompanyAdminDiyLocator.DepartmentDropdown().isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	      			js.executeScript("window.scrollBy(0,500)");	
	      			Thread.sleep(4000);
	      			
	      			CompanyAdminDiyLocator.ModifyAssignmentsClose().click();
	      			Thread.sleep(4000);
	      			SwitchtoParent(test);
	}

	
	public static void ModifyAssignments( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		SwitchtoChild(test,workbook);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.
//-------------------------------Statutory Assignment Report-------------------------------
	      action.moveToElement(CompanyAdminDiyLocator.ManageUsers()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyAdminDiyLocator.ModifyAssignments().click();
	      		  	 Thread.sleep(2000);
	      		  
	      		  	if(CompanyAdminDiyLocator.DepartmentDropdownMA().isDisplayed()) {
	      				
	      				test.log(LogStatus.PASS, " Department Dropdown is Displayed  ");
	      				
	      			}else {
	      				test.log(LogStatus.FAIL, " Department Dropdown is not Displayed  ");
	      			}
	      			
	      			
	      			Thread.sleep(4000);
	      			
	      			
	      			SwitchtoParent(test);
	}
	
	public static void ReopeningofCompliance( ExtentTest test, XSSFWorkbook workbook) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		
		SwitchtoChild(test,workbook);
	      
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a")));	//Wait until records table get visible.

	      action.moveToElement(CompanyAdminDiyLocator.ManageCompliances()).click().build().perform();
	      Thread.sleep(1000);
	      CompanyAdminDiyLocator.ReopeningofCompliance().click();
	      		  	 Thread.sleep(2000);
	      		  	CompanyAdminDiyLocator.ReopeninCheckBox().click();
	      		  	 Thread.sleep(2000);
	      			CompanyAdminDiyLocator.ReopeninSave().click();
	      		  	 Thread.sleep(2000);  
	      		  	 
	      		  	 getDriver().switchTo().alert().accept();
	      		   Thread.sleep(1000);  
	      	String Msg=	 getDriver().switchTo().alert().getText();
	      	 getDriver().switchTo().alert().accept();
	      	test.log(LogStatus.PASS, Msg);
	      	Thread.sleep(4000);
  			
  			
  			SwitchtoParent(test);
	}

	
}
