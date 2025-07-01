package login;


	
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.xml.datatype.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;

import approval.ApprovalcountPOM;
import cfo.CFOcountPOM;
import performer.OverduePOM;

	

	public class BasePage {

		public Properties prop;
		protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
		String URL;
		public String browser= "chrome";	
		public String website;
		public static ExtentReports extent;			//Instance created for report file
		public static ExtentTest test;
		public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		private final ReadWriteLock lock;
	    protected String uname;
	    protected   String password;
	    protected String url;
	   // static SelfHealingDriver 	healingDriver;
	    String filePath ="D:\\Regtrack-Project\\TestData\\ComplianceSheet.xlsx";
	    
		public static WebDriver getDriver() {
			return driver.get();
		}

		public static XSSFSheet ReadExcel(int no) throws IOException
		{
			//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
			fis = new FileInputStream("D:\\Regtrack-Project\\TestData\\ComplianceSheet.xlsxx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(no);					//Retrieving third sheet of Workbook
			return sheet;
		}
		
	private synchronized void loadProperties(int no) throws IOException {
		
		XSSFSheet sheet = ReadExcel(no);
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		 URL = c1.getStringCellValue();
			/*prop = new Properties();
			try {
				FileInputStream file = new FileInputStream("D:\\LabourCompliance_m\\LabourCompliance\\LabourCompliance\\env_data\\config.properties");
				prop.load(file);
				  browser = prop.getProperty("browser");	
				  website = prop.getProperty("website");
				  
				  }
			catch(Exception e){
				e.printStackTrace();
			}*/
		}
		

		
	
	
	public  BasePage() {
		   // this.filePath = filePath;
		    this.lock = new ReentrantReadWriteLock();
		}
	
	public String read_Login_url(int no) throws IOException {
		  lock.readLock().lock();
	    try {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(no);
	        Row row1 = sheet.getRow(0);
	        Cell c1 = row1.getCell(1);
	         url = c1.getStringCellValue();
	         
	        workbook.close();
	        fis.close();
	        return url;
	        
	    }
	    
	    finally {
	        lock.readLock().unlock();
	    }

	}

	
	public String read_Login_username(int no) throws IOException {
		  lock.readLock().lock();
	    try {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(no);
	        Row row1 = sheet.getRow(1);
	        Cell c1 = row1.getCell(1);
	         uname = c1.getStringCellValue();
	        workbook.close();
	        fis.close();
	        return uname;
	    }
	    
	    finally {
	        lock.readLock().unlock();
	    }

	}

	public String read_Login_password(int no) throws IOException {
		  lock.readLock().lock();
	  try {
	      FileInputStream fis = new FileInputStream(filePath);
	      Workbook workbook = WorkbookFactory.create(fis);
	      Sheet sheet = workbook.getSheetAt(no);
	      Row row2 = sheet.getRow(2);
	      Cell c2 = row2.getCell(1);
	       password = c2.getStringCellValue();
	      workbook.close();
	      fis.close();
	      return password;
	  }
	  
	  finally {
	      lock.readLock().unlock();
	  }
	}
	
	/*public class DriverManager {
	    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  
	}
	
	public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }*/
	
	private void openBrower(int no) throws IOException, InterruptedException {

		if (browser.contains("chrome")) {
					System.setProperty("webdriver.chrome.driver", "D:\\Regtrack-Project\\Driver\\chromedriver.exe");
					//WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					driver.set(new ChromeDriver(options));
					//ChromeDriver originalDriver = new ChromeDriver(options);
				//	Thread.sleep(3000);
					// 	healingDriver = SelfHealingDriver.create(originalDriver);
					// 	Thread.sleep(3000);
			        // Set the driver to your driver manager (you should have setDriver() method)
			     //   setDriver(healingDriver);
					
	}
				
				else {
					System.out.println("please select valid browser");
				}
		
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//getDriver().get(url);
			read_Login_url(no);
			getDriver().get(url);
			

	 }

	public void initialization(String link,int no,String text) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
		openBrower(no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	/*	Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		*/
		
		read_Login_username(no);
		read_Login_password(no);
		
		
		login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		if(text.equalsIgnoreCase("internal")) {
		Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(3000);
		}else if(text.equalsIgnoreCase("StatutoryExcludingChecklist")) {
			Thread.sleep(3000);
			//CFOcountPOM.RefreshNow().click();
			Thread.sleep(3000);
			ApprovalcountPOM.Filters().click();
			Thread.sleep(2000);
			ApprovalcountPOM.StatutoryExcludingChecklist().click();
			Thread.sleep(4000);
			CFOcountPOM.clickApply().click();
		}else {
			
		}
		
//		Thread.sleep(3000);
//		CFOcountPOM.YearTodate().click();
//		Thread.sleep(1000);
//		CFOcountPOM.ALL().click();
//		Thread.sleep(1000);
//		CFOcountPOM.clickApply().click();
		
		Thread.sleep(3000);
		//CFOcountPOM.RefreshNowD().click();
		
		//CFOcountPOM.RefreshNow().click();
		
		Thread.sleep(3000);
		try {
		// Combine the two XPaths with the '|' operator
        WebElement element = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

        if (element != null) {
        	element.click();
            System.out.println("Element found!");
            // Perform actions on the element
        } else {
        	
            System.out.println("Element not found");
        }
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(8000);
		try {
			Thread.sleep(8000);
			Thread.sleep(8000);
			Thread.sleep(8000);
	    	WebDriverWait wait = new WebDriverWait(getDriver() ,(50));
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tawk-chat-message-container']/span/div/div/div/div/p/div/span"))); // Replace with actual selector
	        WebElement closeBtn = popup.findElement(By.xpath("//*[@id='tawk-chat-message-container']/span/div/div/div/div/p/div/span")); // Adjust as needed
	     //   closeBtn.click();
	}catch(Exception e) {
	    	
	    }
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(8000);
		
	}
	
	public void initialization1(String link,int no,String text) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
		openBrower(no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	/*	Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		*/
		read_Login_username( no);
		read_Login_password( no);
		login.Login.UserLogin(uname,password,link);		//Method of Login class to login user.
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		//wait.until(ExpectedConditions.visibilityOf(ApprovalcountPOM.clickManagement()));

		

		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage()));
			if(OverduePOM.closeMessage().isDisplayed())	//If Compliance Updation message popped up,
			{
				Thread.sleep(1000);
				OverduePOM.closeMessage().click();		//then close the message.
			}
		}
		catch(Exception e)
		{
		}
		Thread.sleep(3000);
		//ApprovalcountPOM.clickManagement().click();
By locator = By.xpath("//*[@id='ContentPlaceHolder1_LinkButton3']");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(3000);
		// retrieving "foo-button" HTML element
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
    JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		
		Thread.sleep(3000);
		if(text.equalsIgnoreCase("internal")) {
			Thread.sleep(3000);
		Select drp = new Select(CFOcountPOM.selectInternal());
		Thread.sleep(700);
		drp.selectByIndex(1);
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply().click();
		Thread.sleep(3000);
		}else if(text.equalsIgnoreCase("StatutoryExcludingChecklist")) {
			Select drp = new Select(CFOcountPOM.selectInternal());
			Thread.sleep(700);
			drp.selectByIndex(0);
			Thread.sleep(4000);
			CFOcountPOM.clickApply().click();
		}
		
		
	//	CFOcountPOM.RefreshNow().click();
	//	Thread.sleep(3000);
		
		WebElement element = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnRefresh1']/label | //*[@id='ContentPlaceHolder1_btnRefresh']/label"));

        if (element != null) {
        	element.click();
            System.out.println("Element found!");
            // Perform actions on the element
        } else {
        	
            System.out.println("Element not found");
        }
        
        
        try {
			Thread.sleep(8000);
			Thread.sleep(8000);
			Thread.sleep(8000);
	    	//WebDriverWait wait = new WebDriverWait(getDriver() ,(50));
	        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tawk-chat-message-container']/span/div/div/div/div/p/div/span"))); // Replace with actual selector
	        WebElement closeBtn = popup.findElement(By.xpath("//*[@id='tawk-chat-message-container']/span/div/div/div/div/p/div/span")); // Adjust as needed
	     //   closeBtn.click();
	}catch(Exception e) {
	    	
	    }
		
		CFOcountPOM.RefreshNow().click();
		Thread.sleep(8000);
		
	}
	
	
	
	

	public void closeBrowser() {
		getDriver().quit();
		driver.remove();
	}
	}


