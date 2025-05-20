package login;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import performer.OverduePOM;

public class Login extends BasePage
{
//	public static WebDriver driver = null;				//WebDriver instance created
	public static WebElement upload = null;				//WebElement to get upload button
	
/*	public static void BrowserSetup(String URL) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Avacom22Nov\\AvacomUpdated26JULY2023\\Chrome\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver"); //Set the Chrome driver variable
	
	//	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		
		
		//	WebDriverManager.edgedriver().setup();
	//	driver = new EdgeDriver();					//Created new Chrome driver instance. 
	//	WebDriverManager.firefoxdriver().setup();
	//	driver = new FirefoxDriver();
			
		driver.manage().window().maximize();			//Set window size to maximum.
		Thread.sleep(3000);
		driver.get(URL);								//Set the URL of WebApplication.
	}
	
	public static void BrowserSetup1(String URL,String browser) throws Exception
	{
		
			if(browser.equalsIgnoreCase("firefox")){
			 //create firefox instance
				System.setProperty("webdriver.gecko.driver", "C:/Users/Mayuri Gaikwad/Downloads/geckodriver-v0.29.0-win64/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver","C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\Driver1\\chromedriver.exe");
				
	            //create chrome instance
				driver = new ChromeDriver();
			}
			//Check if parameter passed as 'Edge'
					else if(browser.equalsIgnoreCase("Edge")){
						//set path to Edge.exeMicrosoftWebDriver
						System.setProperty("webdriver.edge.driver","C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\edgeDriver\\msedgedriver.exe");
						//create Edge instance
						driver = new EdgeDriver();
					}//3.141.0
					else if(browser.equalsIgnoreCase("opera")){
						//set path to Edge.exeMicrosoftWebDriver
						System.setProperty("webdriver.opera.driver","C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\operaDri\\operadriver.exe");
						//create Edge instance
						driver = new OperaDriver();
					}
					else if(browser.equalsIgnoreCase("IE")){
						//set path to Edge.exeMicrosoftWebDriver
						System.setProperty("webdriver.ie.driver","C:\\Users\\Mayuri Gaikwad\\Desktop\\PerformerPom\\IEDriver\\IEDriverServer.exe");
						//create Edge instance
						driver = new InternetExplorerDriver();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();			//Set window size to maximum.
		driver.get(URL);								//Set the URL of WebApplication.
	}
	*/
	
	public static WebDriver UserLogin(String username, String password, String method) throws InterruptedException
	{		
		//WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);
		
		LoginPOM.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(3000);
		LoginPOM.setPassword().sendKeys(password);	//Sent password to input box
		Thread.sleep(3000);
		LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
		Thread.sleep(3000);
		
		try {
			getDriver().switchTo().alert().accept();
			
		}catch(Exception e) {
			
		}
		if(!username.equalsIgnoreCase("performer@avantis.info"))
		{
			try
			{
				Thread.sleep(500);
				wait1.until(ExpectedConditions.visibilityOf(LoginPOM.clickQALink()));
				wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickQALink()));
				LoginPOM.clickQALink().click();				//Clicking on QA Link instead of OTP.
				
				//----------------------------------------------------------
				
				wait1.until(ExpectedConditions.invisibilityOf(LoginPOM.clickQALink()));
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(500);
			try {
				getDriver().switchTo().alert().accept();
				
			}catch(Exception e) {
				
			}
			Thread.sleep(500);
			try
			{
			wait1.until(ExpectedConditions.visibilityOf(LoginPOM.Question1()));
			wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.Question1()));
			String que1 = LoginPOM.Question1().getText();	//Storing the question in que variable.
			String ans1 = null;
		//	LoginPOM.Answer1(driver).sendKeys("dog");
		//	LoginPOM.Answer2(driver).sendKeys("red");
		//	LoginPOM.SubmitAnswer(driver).click();
			if(method.equalsIgnoreCase("cfo"))
			{
				ans1 = getAnswerCFO(que1);						//Storing the answer in ans variable.
			}else if(method.equalsIgnoreCase("FE"))
			{
				ans1 = getAnswerFE(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("GMTA") )
			{
				ans1 = getAnswerMGMT(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("mgmt") )
			{
				ans1 = getAnswermGMT(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("mgmt1") )
			{
				ans1 = "123";								//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Tlcg") )
			{
				ans1 = getAnswerTlcg(que1);						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("Auditor") )
			{
				ans1 = getAnswerAuditor(que1);						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("Shivraj") )
			{
				ans1 = getAnswerApproval(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Department") )
			{
			//	ans1 = getAnswerDept(que1);						//Storing the answer in ans variable.
				ans1 = "123";	
			}else if(method.equalsIgnoreCase("Department1") )
			{
				ans1 = getAnswerDept(que1);						//Storing the answer in ans variable.
			//	ans1 = "123";	
			}
//			else if(method.equalsIgnoreCase("Implementation") )
//			{
//				ans1 = getAnswerDept(que1);						//Storing the answer in ans variable.
//	     	}
			else if(method.equalsIgnoreCase("Implementation") )
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("PerTlcg") )
			{
				
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("richa") )
			{
			//	ans1 = getAnswerARS(que1);						//Storing the answer in ans variable.
				ans1 = "123";	
			}
			else if(method.equalsIgnoreCase("cfo-diy"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("amruta"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("compayAdmin"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("CertificateOwner"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("FM"))
			{
				ans1 = getAnswerCFO(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("CertificateOwnerDiy"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Auditor1"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else
			{
				ans1 = getAnswer(que1);							//Storing the answer in ans variable.
			}
			
			if(ans1.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer1().sendKeys("place");		//Sending answer to the input box.//place
			else
				LoginPOM.Answer1().sendKeys(ans1);		//Sending answer to the input box.
			Thread.sleep(1000);
			
			//----------------------------------------------------------
			
			String que2 = LoginPOM.Question2().getText();	//Storing the question in que variable.
			String ans2 = null;
			if(method.equalsIgnoreCase("cfo"))
			{
				ans2 = getAnswerCFO(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("FE"))
			{
				ans2 = getAnswerFE(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("GMTA") )
			{
				ans2 = getAnswerMGMT(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("mgmt") )
			{
				ans2 = getAnswermGMT(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("mgmt1") )
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Tlcg") )
			{
				ans2 = getAnswerTlcg(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Auditor") )
			{
				ans2 = getAnswerAuditor(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Shivraj") )
			{
				ans2 = getAnswerApproval(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Department") )
			{
			//	ans2 = getAnswerDept(que2);						//Storing the answer in ans variable.
				ans2 = "123";	
			}
			else if(method.equalsIgnoreCase("Department1") )
			{
				ans2 = getAnswerDept(que2);						//Storing the answer in ans variable.
			//	ans2 = "123";	
			}
	/*	else if(method.equalsIgnoreCase("Implementation") )
			{
				ans2 = getAnswerDept(que2);						//Storing the answer in ans variable.
			}*/
		else if(method.equalsIgnoreCase("Implementation") )
			{
				ans2 = "123";					//Storing the answer in ans variable.
			}
		else if(method.equalsIgnoreCase("PerTlcg") )
		{
			ans2 = "123";					//Storing the answer in ans variable.
		}
			else if(method.equalsIgnoreCase("richa") )
			{
				//ans2 = getAnswerARS(que2);						//Storing the answer in ans variable.
				ans2 = "123";	
			}
			
			else if(method.equalsIgnoreCase("cfo-diy") )
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("amruta") )
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("compayAdmin") )
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("CertificateOwner") )
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("FM") )
			{
				ans2 = getAnswerCFO(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("CertificateOwnerDiy") )
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("Auditor1") )
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			
			else
			{
				ans2 = getAnswer(que2);							//Storing the answer in ans variable.
			}
			
			if(ans2.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer2().sendKeys("place");		//Sending answer to the input box.//place
			else
				LoginPOM.Answer2().sendKeys(ans2);		//Sending answer to the input box.
			Thread.sleep(100);
			
			LoginPOM.SubmitAnswer().click();			//Clicking on Submit button.
			}
			catch(Exception e)
			{
				
			}
		}
		
			if(!method.equalsIgnoreCase("Implementation"))
		{
		//	wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickComplicane(driver)));
		if(method.equalsIgnoreCase("License"))
			{
				LoginPOM.clickLicense().click();				//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Litigation"))
			{
				LoginPOM.ClickLitigation().click();			//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Contract"))
			{
				LoginPOM.ClickContract().click();			//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("richa"))
			{
//				ArsLocators.clickARS().click();			//Clicking on Litigation Image.
			}
		/*
			else
			{
				
				LoginPOM.clickComplicane().click();			//Clicking on Compliance Image.
				Thread.sleep(6000);
			}
			*/
		else
		{
			try {
				LoginPOM.clickComplicane().click();			//Clicking on Compliance Image.
				Thread.sleep(6000);			//Clicking on Compliance Image.
				
				Thread.sleep(2000);
			}catch(Exception e)
			{
				
			}
			
		}
		
		Thread.sleep(6000);
		try {
			Thread.sleep(6000);
			LoginPOM.alrtMsg().click();			//Clicking on Compliance Image.
			
			Thread.sleep(2000);
		}catch(Exception e)
		{
			
		}
			
			try
			{
			
				Thread.sleep(2000);
				if(OverduePOM.closeMessage().isDisplayed())	//If Compliance Updation message popped up,
				{
					
					
					wait1.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage()));
					OverduePOM.closeMessage().click();		//then close the message.
				}
			}
			catch(Exception e)
			{
				
			}
			Thread.sleep(8000);
		}
			//LoginPOM.ClickLitigation(driver).click();
		

		return getDriver();

	}
	
	public static String getAnswer(String que)				//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));		//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "123";
		if(ans.equalsIgnoreCase("car"))                    
			ans = "123";
		if(ans.equalsIgnoreCase("birthplace"))
			ans = "123";
		return ans.toLowerCase();
		//return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	
	
	public static String getAnswerCFO(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "dog";
		if(ans.equalsIgnoreCase("car"))
			ans = "red";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerFE(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "dog";
		if(ans.equalsIgnoreCase("car"))
			ans = "red";
		
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswermGMT(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("boss"))
			ans = "boss";
		if(ans.equalsIgnoreCase("car"))
			ans = "red";
		if(ans.equalsIgnoreCase("name"))
			ans = "name";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerFm(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("owned"))
			ans = "dell";
		if(ans.equalsIgnoreCase("pet"))
			ans = "dog";
		if(ans.equalsIgnoreCase("boss"))
			ans = "boss";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerARS(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("own"))
			ans = "own";
		if(ans.equalsIgnoreCase("car"))
			ans = "car";
		if(ans.equalsIgnoreCase("pet"))
			ans = "pet";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerTlcg(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("brand"))
			ans = "brand";
		if(ans.equalsIgnoreCase("car"))
			ans = "car";
		if(ans.equalsIgnoreCase("power"))
			ans = "power";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerMGMT(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "pet";
		if(ans.equalsIgnoreCase("car"))
			ans = "car";
		if(ans.equalsIgnoreCase("power"))
			ans = "power";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerDept(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "pet";
		if(ans.equalsIgnoreCase("car"))
			ans = "car";
		if(ans.equalsIgnoreCase("power"))
			ans = "power";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerAuditor(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "pet";
		if(ans.equalsIgnoreCase("car"))
			ans = "car";
		if(ans.equalsIgnoreCase("place"))
			ans = "place";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerApproval(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("power"))
			ans = "power";
		if(ans.equalsIgnoreCase("car"))
			ans = "car";
		if(ans.equalsIgnoreCase("place"))
			ans = "place";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static WebDriver UserLogin1(String username, String password, String method) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 40);
		
		LoginPOM.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginPOM.setPassword().sendKeys(password);	//Sent password to input box
		//LoginPOM.clickSubmit(driver).click();				//Clicked on Sign-in button
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//	js.executeScript("window.scrollBy(0,200)");
			Thread.sleep(2000);
		return getDriver();
	}
	
}
