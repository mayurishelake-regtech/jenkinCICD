package login;
	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class LoginPOM extends BasePage
	{
		private static WebElement uname = null;			//WebElement variable created for Username input 
		private static WebElement pass = null;			//WebElement variable created for Password input
		private static WebElement submit = null;		//WebElement variable created for Submit button click
		private static WebElement QALink = null;		//WebElement variable created for Question Answer link after comes up after login
		private static WebElement question1 = null;		//WebElement variable created for question1 element
		private static WebElement question2 = null;		//WebElement variable created for question2 element
		private static WebElement ans1 = null;			//WebElement variable created for Answer1 input
		private static WebElement ans2 = null;			//WebElement variable created for Answer2 input
		private static WebElement validate = null;		//WebElement variable created for Answer Submit/Validate button
		private static WebElement comp_img = null;		//WebElement variable created for Compliance Image click
		private static WebElement liti_img = null;
	
		public static WebElement setUname()		//Method for searching Username input
		{
			uname = getDriver().findElement(By.xpath("//input[@placeholder='Username']"));
			return uname;
		}
		
		public static WebElement setPassword()	//Method for searching Password input
		{
			pass =getDriver().findElement(By.xpath("//input[@placeholder='Password']"));
			return pass;
		}
		
		public static WebElement readMsg()	//Method for searching Password input
		{
			pass =getDriver().findElement(By.xpath("//*[@id='vsLogin']/ul/li"));
			return pass;
		}
		
		public static WebElement readMsg1()	//Method for searching Password input
		{
			pass =getDriver().findElement(By.xpath("//*[@id='ValidationSummary2']/ul/li"));
			return pass;
		}
		
		public static WebElement alrtMsg()	//Method for searching Password input
		{
			pass =getDriver().findElement(By.xpath("//*[@id='divbnl']/div/div/div[1]/button"));
			return pass;
		}
		
		public static WebElement readMsg2()	//Method for searching Password input
		{
			pass =getDriver().findElement(By.xpath("//*[@id='vsLogin']/ul/li"));
			return pass;
		}
		
		public static WebElement readMsg3()	//Method for searching Password input
		{
			pass =getDriver().findElement(By.xpath("//*[@id='ValidationSummary3']/ul/li"));
			return pass;
		}
		
		public static WebElement readMsg4()	//Method for searching Password input
		{
			pass =getDriver().findElement(By.xpath("//*[@id='ValidationSummary3']/ul/li"));
			return pass;
		}
		
		public static WebElement clickSubmit()	//Method for searching button for Save/Sign-in
		{
			submit = getDriver().findElement(By.xpath("//input[@name='Submit']"));
			return submit;
		}
		
		public static WebElement clickQALink()	//Method for searching QALink for user login
		{
			//QALink = getDriver().findElement(By.xpath("//a[@id='lnkSecurityQA']"));
			QALink = getDriver().findElement(By.linkText("Do not have access to OTP?"));
	return QALink;
		}
		
		public static WebElement Answer1()		//Method for searching input box of first answer
		{
			ans1 = getDriver().findElement(By.xpath("//*[@id='txtAnswer1']"));
			return ans1;
		}
		
		public static WebElement Answer2()		//Method for searching input box of second answer
		{
			ans2 = getDriver().findElement(By.xpath("//*[@id='txtAnswar2']"));
			return ans2;
		}
		public static WebElement Question1()	//Method for searching first Question 
		{
			question1 = getDriver().findElement(By.xpath("//span[@id='lblQuestion1']"));
			return question1;
		}
		
		public static WebElement Question2()	//Method for searching second Question
		{
			question2 = getDriver().findElement(By.xpath("//span[@id='lblQuestion2']"));
			return question2;
		}
		
		public static WebElement SubmitAnswer()	//Method for searching button to submit answers
		{
			validate = getDriver().findElement(By.xpath("//input[@value='Validate']"));
			return validate;
		}
		
		public static WebElement clickComplicane()		//Method for searching Compliance image
		{
			comp_img = getDriver().findElement(By.xpath("//div[@id='dvbtnCompliance']/div[1]/img"));
			return comp_img;
		}
		//div[@id='dvbtnCompliance']/div[1]/img
		public static WebElement clickLicense()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='dvbtnLicense']"));
			return comp_img;
		}
		
		public static WebElement ClickLitigation()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='dvbtnLitigation']/div[2]"));
			return comp_img;
		}
		
		public static WebElement ClickContract()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='dvbtnContract']"));
			return comp_img;
		}
		
		public static WebElement EnterOtp()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='txtOTP']"));
			return comp_img;
		}
		
		public static WebElement VerifyOTP()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='btnOTP']"));
			return comp_img;
		}
		
		public static WebElement ValOTP()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='vsLogin']/ul/li"));
			return comp_img;
		}
		
		public static WebElement ResendOTP()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='lnkResendOTP']"));
			return comp_img;
		}
		
		public static WebElement ResendOTPVal()
		{
			comp_img = getDriver().findElement(By.xpath("//*[@id='vsLogin']/ul/li"));
			return comp_img;
		}
	}


