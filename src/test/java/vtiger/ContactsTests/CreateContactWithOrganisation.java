package vtiger.ContactsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtilities.IConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.propertyFileUtility;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateContactInfoPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganisation extends BaseClass {

	@Test
	public  void createcotactwithorganization() throws Throwable {
		//Create object of required Utilities
			
	
			WebDriver driver = null;
			
	
			// Step 1: Read all the necessary data
	
			/* Read data from property File - Common Data */
			int Random = jUtil.getRandomNumber();
			
	
			/* Read Data from Excel sheet - Test data */
			String ORGNAME = eUtil.getDataFromExcel("Contacts", 4, 3)+Random;
			String LASTNAME = eUtil.getDataFromExcel("Contacts", 4, 2);

		
		
		//Step 5: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.OrganizationHomePage();
		Reporter.log("Clicked on Organization Link");
		
		//Step 6: click on Create Organization look up image		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgLookUpImage();
		Reporter.log("Clicked on LookUpImage");
		
		//Step 6: create Organization
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.CreateOrganizations(ORGNAME);
		
		

		//Step 7: save 
		cnop.SaveBtn();
		
		//Step 8: Validate
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String OrgHeader = oip.OrgHeaderText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("Fail");
		}
		
//		Step 9  Select Contacts
		hp.clickcontact();
		Reporter.log("Clicked on Contact");
		
		
//		Navigate to create contact look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.CreateOnClickContactLookUPImg();
		
		
		
		CreateNewContactPage cncp =  new CreateNewContactPage(driver);
		cncp.createContact(driver,LASTNAME, ORGNAME);
		Reporter.log("Clicked on Organization Link");
		
		CreateContactInfoPage cnif = new CreateContactInfoPage(driver);
		
		
		String ContactHeader = cnif.ContactHeaderText();
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
			System.out.println(LASTNAME);
		}
		else
		{
			System.out.println("Fail");
		}
		
		hp.logoutOfApp(driver);
		System.out.println("Logout successfull");
		
		
		
		
		

	}

	@Test
	public void addnam() {
		driver.findElement(By.xpath("//a[@class='klsjle']")).click();
		
	}

}