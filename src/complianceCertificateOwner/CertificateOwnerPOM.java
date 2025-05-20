package complianceCertificateOwner;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class CertificateOwnerPOM  extends BasePage{
	
private static WebElement owner = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> ownerList = null;		
	

	public static WebElement clickMyCertificate()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenuCer']/a"));
		return owner;//*[@id="leftworkspacemenuCer"]/a
	}
	
	public static WebElement CertificateOwner()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='LiCerOwnerlist']"));
		return owner;
	}
	
	public static WebElement ExporttoPDF()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/div/button"));
		return owner;
	}
	
	public static WebElement View()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[2]/td[8]/a[1]"));
		return owner;                       
	}
	
	
	public static WebElement CertificateOwnerPage()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='pagetype']"));
		return owner;
	}
	
	public static WebElement PeriodView()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[1]"));
		return owner;
	}
	
	public static WebElement CompliancePageView()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a"));
		return owner;
	}
	
	public static WebElement ReviewerPageView()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[12]/a"));
		return owner;
	}
	
	public static WebElement ReviewerPageViewclose()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='divOverView1']/div/div/div[1]/button"));
		return owner;
	}
	
	public static WebElement ReviewerPageExport()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='export']"));
		return owner;
	}
	
	
	public static WebElement ReviewerPageLoaction()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/div[1]/div/span[1]"));
		return owner;
	}
	
	public static WebElement ReviewerPageClickExpand()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//span[@class='k-icon k-i-expand']"));
		return owner;
	}
	
	public static WebElement ReviewerPageCT()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("(//span[@class='k-checkbox-label checkbox-span'])[10]"));
		return owner;
	}
	
	public static WebElement ReviewerPageClearfilterMain()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return owner;
	}
	
	public static WebElement ClickDownloadAll()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='btnDownloadAll']"));
		return owner;
	}
	
	public static WebElement ExporttoPDFPe()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/div/button"));
		return owner;
	}
	
	public static WebElement ClickPreview()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[2]"));
		return owner;
	}
	
	public static WebElement ClosePreview()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("/html/body/div[9]/div[1]/div/a"));
		return owner;
	}
	public static WebElement DwonloadDoc()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[3]"));
		return owner;
	}
	
	public static WebElement Back()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='btnBack']"));
		return owner;
	}
	
	
	public static WebElement Preview()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[8]/a[2]"));
		return owner;
	}
	
	public static WebElement Previewclose()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
		return owner;
	}
	
	public static WebElement Submit()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='btnSubmit']"));
		return owner;
	}
	
	public static WebElement SubmitMsg()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@class='delete-message']"));
		return owner;
	}
	
	public static WebElement SubmitYes()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.linkText("Yes"));
		return owner;
	}
	
	
	public static WebElement DownloadCertificate()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[8]/a[3]"));
		return owner;
	}
	
	public static WebElement DownloadUploadCertificate()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[8]/a[4]"));
		return owner;
	}
	
	public static WebElement EntitySubEntityLocation()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[2]/span[1]/span/span[3]/span"));
		return owner;
	}
	
	public static WebElement ComplianceTech()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("(//span[@class='k-in'])[20]"));
		return owner;
	}
	
	
	public static WebElement CertificateOwnerview()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[4]/td[8]/a[1]"));
		return owner;
	}
	
	public static WebElement PeriodView1()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[1]"));
		return owner;
	}
	
	public static WebElement PeriodDec22View1()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[6]/a"));
		return owner;
	}
	
	public static WebElement ReopenButton()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[12]/a[2]"));
		return owner;
	}
	
	public static WebElement Addnotice()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[6]/a[1]"));
		return owner;
	}
	
	public static WebElement Act()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='AddExceptPopUp']/div/fieldset/div[1]/span[1]/span/span[2]/span"));
		return owner;
	}
	
	public static WebElement Act1()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='dropdownACT_listbox']/li"));
		return owner;
	}
	
	public static WebElement Description()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='txtDescription']"));
		return owner;
	}
	
	public static WebElement Liability ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='txtLiability']"));
		return owner;
	}
	
	public static WebElement Status ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='txtStatus']"));
		return owner;
	}
	
	public static WebElement NoticeReceiptDate ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='AddExceptPopUp']/div/fieldset/div[1]/span[2]/span/span[2]/span"));
		return owner;
	}
	
	public static WebElement NoticeReceiptDate1 ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.linkText("1"));
		return owner;
	}
	
	
	public static WebElement NoticeDueDate ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='AddExceptPopUp']/div/fieldset/div[2]/span/span/span[2]/span"));
		return owner;
	}
	
	public static WebElement NoticeDueDate1 ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.linkText("25"));
		return owner;
	}
	
	
	public static WebElement ActionTaken ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='txtActionTaken']"));
		return owner;
	}
	
	public static WebElement SubmitN ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='btnadd']"));
		return owner;
	}
	
	public static WebElement Close ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
		return owner;
	}
	
	public static WebElement Edit ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@class='k-button k-button-icontext Ex-edit k-grid-editEx']"));
		return owner;
	}
	
	public static WebElement Delete ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@class='k-button k-button-icontext Ex-delete k-grid-deleteEx']"));
		return owner;
	}
	
	public static WebElement Export ()		//Method for closing Message Popup
	{
		owner = getDriver().findElement(By.xpath("//*[@id='btnExortNotice']"));
		return owner;
	}
	
	
	
	
	
	
	
}
