package CreateOrganizationWithIndustryType;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.propertyFileUtility;
import vtiger.ObjectRepository.CreateNewOrganizationsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;


public class CreateOrganizationWithIndustryTypeTest extends BaseClass {
	
	@Test(groups="RegressionSuite")
	public  void createOrgWithIndustry() throws Throwable {
	
		
		int Random = jUtil.getRandomNumber();
		
	
		/* Read Data from Excel sheet - Test data */
		String ORGNAME = eUtil.getDataFromExcel("Organizations", 1, 2)+Random;
		String INDUSTRY = eUtil.getDataFromExcel("Organizations", 4, 3);
		
		
		//Step 5: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.OrganizationHomePage();
		
		//Step 6: click on Create Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickonCreateOrgLookUpImage ();
		
		
		//Step 6: create Organization With Industry and Save
		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.CreateOrganizations(ORGNAME, INDUSTRY);
		
		//Step 7: Validate
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);

		String OrgHeader = oip.OrgHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
		
}
//	@Test 
//	public void fail()
//	{
//		Assert.assertFalse(false);
//		System.out.println("fail");
//		
//		
//		
//
//	}

}
