package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	@FindBy(linkText ="Organizations")
	private WebElement organizationslnk;
	
	@FindBy(linkText= "Sign Out")
	private WebElement signOutlnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement  AdministratorImg;

	@FindBy(linkText ="Contacts")
	private WebElement contactlnk;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrganizationslnk() {
		return organizationslnk;
	}
	public WebElement getcontactlnk() {
		return contactlnk;
	}
	
	public WebElement getsignOutImg() {
		return  AdministratorImg;
	}
	
	public WebElement getsignOutlnk() {
		return signOutlnk;
	}
	
	public void OrganizationHomePage ()
	{
		organizationslnk.click();
	}
	
	public void logoutOfApp (WebDriver driver) throws Throwable
	{
		mouseHoverAction(driver, AdministratorImg);
		Thread.sleep(1000);
		signOutlnk.click();
	}
	
	public void clickcontact()
	{
		contactlnk.click();
	}
	

	
	
	

}
