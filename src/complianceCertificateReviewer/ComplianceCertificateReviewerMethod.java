package complianceCertificateReviewer;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import complianceCertificateOwner.CertificateOwnerPOM;
import login.BasePage;

public class ComplianceCertificateReviewerMethod extends BasePage {

	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;	
private static WebElement Reviewer = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> ReviewerList = null;
	
	public static WebElement CertificateReviewer()		//Method for closing Message Popup
	{
		Reviewer = getDriver().findElement(By.xpath("//*[@id='LiCerReviwerlist']"));
		return Reviewer;
	}
	
	public static WebElement ComplianceTech()		//Method for closing Message Popup
	{
		Reviewer = getDriver().findElement(By.xpath("(//span[@class='k-in'])[19]"));
		return Reviewer;
	}
	
	public static WebElement readCount()		//Method for closing Message Popup
	{
		Reviewer = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		return Reviewer;
	}
	public static WebElement Text()		//Method for closing Message Popup
	{
		Reviewer = getDriver().findElement(By.xpath("/html/body/p[4]/font/strong"));
		return Reviewer;
	}
		
	

	public static void CertificateReviewer( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		Thread.sleep(1000);
		CertificateOwnerPOM.clickMyCertificate().click();
		Thread.sleep(1000);
		CertificateReviewer().click();
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
	
	CertificateOwnerPOM.EntitySubEntityLocation().click();
	Thread.sleep(2000);
	ComplianceTech().click();
	Thread.sleep(3000);
	CertificateOwnerPOM.ReviewerPageClearfilterMain().click();
	Thread.sleep(3000);

test.log(LogStatus.PASS,  " Clear Filter Working successfully." );
		
	
	
	}
	
	public static void CertificateReviewerParticularPeriod( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateReviewer().click();
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
		
		CertificateOwnerPOM.Back().click(); 
	}
	
	public static void CertificateReviewerParticularPeriodCompliance( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateReviewer().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(2000);
		CertificateOwnerPOM.PeriodView().click();
		Thread.sleep(2000);
		File dir2 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] dirContents1 = dir2.listFiles(); // Counting number of files in directory before download

		
		CertificateOwnerPOM.ExporttoPDFPe().click(); // Exporting (Downloading) file
		Thread.sleep(2000);
		
		File dir3 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
		File[] allFilesNew1 = dir3.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  "Export to PDF - File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL, "  File does not downloaded.");
		}
		
		
	}
	
	public static void CertificatePerformerUser( ExtentTest test)
			throws InterruptedException, IOException {
	
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateReviewer().click();
		
		CertificateOwnerPOM.View().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.PeriodView().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.CompliancePageView().click();
		Thread.sleep(2000);
		CertificateOwnerPOM.ReviewerPageView().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.ReviewerPageViewclose().click();
		test.log(LogStatus.PASS,  "Performer  - Performer  User - View Successfully");
		
			Thread.sleep(3000);
			readCount().click();					//CLicking on Total Pages value to scroll down
			Thread.sleep(500);
			String s1 = readCount().getText();	//Reading the total items count in String
			String[] bits = s1.split(" ");								//Splitting the String
			String itomsCount = bits[bits.length - 2];					//Getting the second last word (total number of items)
			int TotalRecords;
			if(itomsCount.equalsIgnoreCase("to"))						//If no records found, it shows 'No items to display'
			{
				test.log(LogStatus.PASS, " does not have any records to download.");
			}
			else
			{
				TotalRecords = Integer.parseInt(itomsCount);				//Reading total number of pages to click next
				
				Thread.sleep(500);
							
				
				File dir = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
				File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
				
				Thread.sleep(500);
				CertificateOwnerPOM.ReviewerPageExport().click();				//Exporting (Downloading) file
				
				Thread.sleep(3000);//C://Users//jiya//Downloads//
				File dir1 = new File("C:\\Users\\Mayuri Gaikwad\\Downloads");
				File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
				
				if(dirContents.length < allFilesNew.length)
				{
					test.log(LogStatus.PASS, "  File downloaded successfully.");	
					
					File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
				    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
				    {
				       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
				       {
				           lastModifiedFile = allFilesNew[i];
				       }
				    }
					
					Thread.sleep(500);
					fis = new FileInputStream(lastModifiedFile);	//Provided last modified / latest downloaded file.
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
					Row row4 = sheet.getRow(3);						//Selected 3rd index row (Fourth row)
					Cell c1 = row4.createCell(0);					//Selected cell (4th row, 1st column)
					c1.setCellValue("Test");						//Entered temp data at empty row, so that it could make easy to get Last Row Number
				/*	FileOutputStream fos = new FileOutputStream(lastModifiedFile);
					workbook.write(fos);
					fos.close();
					*/
					int no = sheet.getLastRowNum();
					int SheetRecords = no - 4;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
					
					if(SheetRecords == TotalRecords)
					{
						test.log(LogStatus.PASS, "  No of records displayed = " + TotalRecords + " matches to No of records in excel sheet = "+SheetRecords);
					}
					else
					{
						test.log(LogStatus.FAIL,"  No of records displayed = " + TotalRecords + " doesn't matches to No of records in excel sheet = "+SheetRecords);
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "  File does not downloaded.");
				}
			}
			Thread.sleep(3000);
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
	
	
	public static void CertificateOfficerPR(ExtentTest test)throws InterruptedException, IOException 
	{
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		
		CertificateReviewer().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(5000);
		
		CertificateOwnerPOM.ClickPreview().click(); 
		Thread.sleep(5000);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_RadDisplayControl_contentIframe"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		String text=	Text().getText();
	
		test.log(LogStatus.PASS, "After adding the notice by the owner for a particular period text displyed :- " +text);
		
		getDriver().switchTo().parentFrame();
		Thread.sleep(8000);
		CertificateOwnerPOM.Previewclose().click(); 
		Thread.sleep(8000);
		CertificateOwnerPOM.Back().click(); 
	}
	
	public static void CertificateOfficerP1R( ExtentTest test)throws InterruptedException, IOException {
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftworkspacemenuCer']/a"))); 
		
		CertificateOwnerPOM.clickMyCertificate().click();
		Thread.sleep(1000);
		ComplianceCertificateReviewerMethod.CertificateReviewer().click();
		Thread.sleep(3000);
		CertificateOwnerPOM.View().click();
		Thread.sleep(5000);
		
		
		CertificateOwnerPOM.ClickPreview().click(); 
		Thread.sleep(5000);
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_RadDisplayControl_contentIframe"));	//Wait until frame get visible and switch to it.
		Thread.sleep(8000);
		
		String text=	Text().getText();
		if(text.equalsIgnoreCase("No Notice has been received under the Regulatory Act during this Subjected / Compliance Period - Kindly Refer to the Annexure."))
		{
			test.log(LogStatus.PASS, "If Notice has been not added by the owner then text displyed :- " +text);
		}
		else 
		{
			test.log(LogStatus.FAIL, " text displyed :- " +text);

		}
		
		getDriver().switchTo().parentFrame();
		Thread.sleep(8000);
		CertificateOwnerPOM.Previewclose().click(); 
		Thread.sleep(8000);
		CertificateOwnerPOM.Back().click(); 
	}
	
	
	
	
	
	
}
