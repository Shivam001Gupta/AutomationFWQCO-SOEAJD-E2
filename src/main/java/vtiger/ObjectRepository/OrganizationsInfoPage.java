package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class OrganizationsInfoPage extends WebDriverUtility {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText;
	
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Organizationscnfpage() {
		return OrgHeaderText;
	}
	
	public String OrgHeaderText ()
	{
		return OrgHeaderText.getText();
	}
	
	
	
}
