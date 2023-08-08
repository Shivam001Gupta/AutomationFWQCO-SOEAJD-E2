package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {
	
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createOrganizationlnk;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrganizationslnk() {
		return createOrganizationlnk;
	}
	
	public void clickonCreateOrgLookUpImage ()
	{
		createOrganizationlnk.click();
	}
	
	

	

}
