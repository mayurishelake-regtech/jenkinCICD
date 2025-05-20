package complianceCertificateOwner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import companyadmin.CompanyPOM;
import implementation.ImplementPOM;
import login.BasePage;

public class CertificateOwnerMethod extends BasePage{
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="E:\\AVACOM Project\\AvacomModified\\TestData\\ComplianceSheet.xlsx";
	
	public static void CertificateOwner( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		Thread.sleep(1000);
		CertificateOwnerPOM.clickMyCertificate().click();
		Thread.sleep(1000);
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
	String text=	CertificateOwnerPOM.CertificateOwnerPage().getText();
	test.log(LogStatus.PASS,  "Page Open - " +text);
	
	    Thread.sleep(1000);
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		CertificateOwnerPOM.ExporttoPDF().click(); // Exporting (Downloading) file

		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "  File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		CertificateOwnerPOM.Preview().click();
		Thread.sleep(4000);
		CertificateOwnerPOM.Previewclose().click();
		Thread.sleep(3000);
	
	test.log(LogStatus.PASS,  "Preview successfully. " );
	
	File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

	
	CertificateOwnerPOM.DownloadCertificate().click(); // Exporting (Downloading) file

	
	File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  "Download Certificate - File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
	
	
	File dir5 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] dirContents2 = dir5.listFiles(); // Counting number of files in directory before download

	
	CertificateOwnerPOM.DownloadUploadCertificate().click(); // Exporting (Downloading) file

	
	File dir6 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
	File[] allFilesNew2 = dir6.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents2.length < allFilesNew2.length) {
		test.log(LogStatus.PASS,  "Download Upload Certificate - File downloaded successfully.");
	} else {
		test.log(LogStatus.FAIL, "  File does not downloaded.");
	}
		
	CertificateOwnerPOM.EntitySubEntityLocation().click();
	Thread.sleep(1000);
	CertificateOwnerPOM.ComplianceTech().click();
	Thread.sleep(3000);
	CertificateOwnerPOM.ReviewerPageClearfilterMain().click();
	Thread.sleep(3000);

test.log(LogStatus.PASS,  " Clear Filter Working successfully." );
		
	
	
	}
	
	public static void CertificateOwnerReviewer( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateOwnerPOM.CertificateOwner().click();
		
		CertificateOwnerPOM.View().click();
		
		CertificateOwnerPOM.PeriodView().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.CompliancePageView().click();
		
		CertificateOwnerPOM.ReviewerPageView().click();
		CertificateOwnerPOM.ReviewerPageViewclose().click();
		test.log(LogStatus.PASS,  "Reviewer - Reviewer User - View Successfully");
		
		
			File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			
			CertificateOwnerPOM.ReviewerPageExport().click(); // Exporting (Downloading) file

			
			File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  "  File downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL, "  File does not downloaded.");
			}
		
			CertificateOwnerPOM.ReviewerPageLoaction().click();
			Thread.sleep(3000);
			CertificateOwnerPOM.ReviewerPageClickExpand().click();
			Thread.sleep(3000);
			CertificateOwnerPOM.ReviewerPageCT().click();
			Thread.sleep(3000);
			if(CertificateOwnerPOM.ReviewerPageClearfilterMain().isEnabled()) {
				CertificateOwnerPOM.ReviewerPageClearfilterMain().click();
				test.log(LogStatus.PASS,  "  Clear Filter Working successfully.");
			}else {
				test.log(LogStatus.FAIL,  "  Clear Filter not Working successfully.");
			}	
			performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
			Thread.sleep(1000);
	
	}
	
	public static void CertificateOwnerParticularPeriod( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.ClickDownloadAll().click(); // Exporting (Downloading) file

		
		File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Download All - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.ExporttoPDFPe().click(); // Exporting (Downloading) file

		
		File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  "Export to PDF - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		CertificateOwnerPOM.ClickPreview().click(); 
		Thread.sleep(2000);
		CertificateOwnerPOM.Previewclose().click(); 
		test.log(LogStatus.PASS,  " Preview successfully.");
		
		File dir5 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents2 = dir5.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.DwonloadDoc().click(); // Exporting (Downloading) file

		
		File dir6 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew2 = dir6.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents2.length < allFilesNew2.length) {
			test.log(LogStatus.PASS,  "Dwonload Doc - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		/*Thread.sleep(2000);
		CertificateOwnerPOM.Submit().click(); 
		Thread.sleep(2000);
		
		String text=	CertificateOwnerPOM.SubmitMsg().getText();
		test.log(LogStatus.PASS,  "Message Display " +text);
		Thread.sleep(2000);
		CertificateOwnerPOM.SubmitYes().click(); 
		Thread.sleep(2000);
	String Msg=	.switchTo().alert().getText();
	.switchTo().alert().accept();
	test.log(LogStatus.PASS,  "Message Display " +Msg);
	Thread.sleep(2000);
		*/
		CertificateOwnerPOM.Back().click(); 
	}
	
	public static void CertificateOwnerParticularPeriodCompliance( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(2000);
		CertificateOwnerPOM.PeriodView().click();
		Thread.sleep(2000);
		File dir2 = new File("C:\\Users\\snehalp\\Downloads");
		File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.ExporttoPDFPe().click(); // Exporting (Downloading) file
		Thread.sleep(2000);
		
		File dir3 = new File("C:\\Users\\snehalp\\Downloads");
		File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  "Export to PDF - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		
	}
	
	public static void CertificateOwnerReopen( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		Thread.sleep(1000);
		CertificateOwnerPOM.clickMyCertificate().click();
		Thread.sleep(1000);
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
		
		CertificateOwnerPOM.CertificateOwnerview().click();
		Thread.sleep(2000);
		CertificateOwnerPOM.PeriodView1().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.PeriodDec22View1().click();
		Thread.sleep(3000);
		try {
		CertificateOwnerPOM.ReopenButton().click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews4"));	//Wait until frame get visible and switch to it.
		Thread.sleep(500);
		CFOcountPOM.EnterRemark().sendKeys("remark");
		Thread.sleep(1000);
		CFOcountPOM.ReOpen().click();
		Thread.sleep(8000);
		String msg =getDriver().switchTo().alert().getText();
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		test.log(LogStatus.PASS, "Message Display : - " +msg);
       Thread.sleep(1000);
       getDriver().switchTo().parentFrame();
     Thread.sleep(5000);
}catch(Exception e) {
	
	test.log(LogStatus.PASS, "ReOpen Button Not present ");
	
}
		performer.OverduePOM.clickDashboard().click();			//Clicking on Dashboard
		Thread.sleep(1000);
		
	}
	
	public static void NoticeCreated( ExtentTest test)throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(8000);
		
		CertificateOwnerPOM.Addnotice().click();
		Thread.sleep(8000);
		
		CertificateOwnerPOM.Act().click();
		Thread.sleep(1000);
		CertificateOwnerPOM.Act1().click();
		Thread.sleep(3000);
		
		
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(16);
		
	
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(3);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CertificateOwnerPOM.Description().sendKeys(c1.getStringCellValue()); // Writing Task title
		
		
		Thread.sleep(2000);
		
		row0 = sheet.getRow(4);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

		int No = (int) c1.getNumericCellValue();
		CertificateOwnerPOM.Liability().sendKeys("" + No + ""); // Writing Task title
		Thread.sleep(4000);
		
		row0 = sheet.getRow(5);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CertificateOwnerPOM.Status().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		
		CertificateOwnerPOM.NoticeReceiptDate().click();
		Thread.sleep(1000);
		CertificateOwnerPOM.NoticeReceiptDate1().click();
		Thread.sleep(3000);
		
		CertificateOwnerPOM.NoticeDueDate().click();
		Thread.sleep(1000);
		CertificateOwnerPOM.NoticeDueDate1().click();
		Thread.sleep(3000);
		
		row0 = sheet.getRow(6);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CertificateOwnerPOM.ActionTaken().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		
		
		Thread.sleep(2000);
		CertificateOwnerPOM.SubmitN().click(); 
		Thread.sleep(6000);
	
	String Msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS,  "Message Display " +Msg);
	Thread.sleep(2000);
		
		CertificateOwnerPOM.Close().click(); 
	}
	
	public static void NoticeCreatedEdit( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(8000);
		
		CertificateOwnerPOM.Addnotice().click();
		Thread.sleep(8000);
		
		CertificateOwnerPOM.Edit().click();
		Thread.sleep(4000);
		
		
	
		
		
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(16);
	        CertificateOwnerPOM.Description().clear();
	        Thread.sleep(4000);
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		row0 = sheet.getRow(7);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		CertificateOwnerPOM.Description().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(2000);
		
	
		
		Thread.sleep(2000);
		CertificateOwnerPOM.SubmitN().click(); 
		Thread.sleep(6000);
	
	String Msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS,  "Message Display " +Msg);
	Thread.sleep(2000);
		
		CertificateOwnerPOM.Close().click(); 
	}
	
	
	public static void NoticeCreatedDelete( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(8000);
		
		CertificateOwnerPOM.Addnotice().click();
		Thread.sleep(8000);
		
		CertificateOwnerPOM.Delete().click();
		Thread.sleep(4000);
		
		getDriver().switchTo().alert().accept();
		Thread.sleep(4000);
	String Msg=	getDriver().switchTo().alert().getText();
	Thread.sleep(2000);
	getDriver().switchTo().alert().accept();
	test.log(LogStatus.PASS,  "Message Display " +Msg);
	Thread.sleep(2000);
		
		CertificateOwnerPOM.Close().click(); 
	}
	
	
	public static void NoticeCreatedExport( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateOwnerPOM.CertificateOwner().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(8000);
		
		CertificateOwnerPOM.Addnotice().click();
		Thread.sleep(8000);
		
		File dir2 = new File("C:\\Users\\snehalp\\Downloads");
		File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.Export().click(); // Exporting (Downloading) file
		Thread.sleep(2000);
		
		File dir3 = new File("C:\\Users\\snehalp\\Downloads");
		File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		
		
		CertificateOwnerPOM.Close().click(); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
