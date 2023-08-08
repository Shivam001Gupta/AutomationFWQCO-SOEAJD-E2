package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createContactlnk;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy (xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy (name = "search_text")
	private WebElement orgSearchEdt;
	
	@FindBy (name = "search")
	private WebElement orgSearchBtn;
	
	

	

	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getcreateContactlnk() {
		return createContactlnk;
	}
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	public WebElement getOrgSearchBtn() {
		return orgSearchBtn;
	}
	
	public void clickonCreateContactLookUpImage ()
	{
		createContactlnk.click();
	}
	
	public void CreateContacts (String LASTNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	public void orgSearch(String ORGNAME) {
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		
	}
	
	
	public void createContact(WebDriver driver, String LASTNAME, String ORGNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		swtichToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(ORGNAME);
		orgSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		swtichToWindow(driver, "Contacts");
		saveBtn.click();
		
	}

	
	
	
	

}
