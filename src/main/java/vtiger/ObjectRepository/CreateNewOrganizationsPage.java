package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizationsPage extends WebDriverUtility {
	
	@FindBy(name ="accountname")
	private WebElement OrgNameEdt;
	
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
		

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getAccountNameEdt() {
		return OrgNameEdt;
	}



	public WebElement getIndustryNamedrp() {
		return IndustryDropDown;
	}



	public WebElement getSavebtn() {
		return SaveBtn;
	}
	
	
	
	public void CreateOrganizations (String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
	}
	/**
	 * This method is used to create Organization with Industry
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	
	public void CreateOrganizations (String ORGNAME, String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(INDUSTRY, IndustryDropDown);
		SaveBtn.click();
		
	}
	
	public void SaveBtn()
	{
		SaveBtn.click();
	}

}
