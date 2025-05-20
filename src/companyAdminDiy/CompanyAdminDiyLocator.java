package companyAdminDiy;

import java.util.List;

import org.openqa.selenium.By;
import login.BasePage;

import org.openqa.selenium.WebElement;

public class CompanyAdminDiyLocator extends BasePage {

	private static WebElement admin = null;				//WebElement variable created for 'Categories' click
	
	private static List<WebElement> adminList = null;		
	
	public static WebElement ManageUsers()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[3]/a"));
		return admin;
	}
	
	public static WebElement Users()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:14']/li[2]/a"));
		return admin;
	}
	
	public static WebElement ModifyAssignmentsLink()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnModifyAssignment_0']"));
		return admin;
	}
	
	public static WebElement DepartmentDropdown()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[8]/td[4]/span/input"));
		return admin;
	}
	
	public static WebElement ModifyAssignmentsClose()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='BodyContent_Button2']"));
		return admin;
	}
	
	public static WebElement ModifyAssignments()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:14']/li[4]/a"));
		return admin;
	}
	
	
	public static WebElement DepartmentDropdownMA()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='BodyContent_upModifyAssignment']/div[1]/table/tbody/tr[6]/td[4]/span/input"));
		return admin;
	}
	
	public static WebElement ManageCompliances()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[4]"));
		return admin;
	}
	
	public static WebElement ReopeningofCompliance()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:26']/li[12]/a"));
		return admin;
	}
	
	public static WebElement ReopeninCheckBox()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='chkApprover']"));
		return admin;
	}
	
	public static WebElement ReopeninSave()		//Method for closing Message Popup
	{
		admin = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
		return admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
