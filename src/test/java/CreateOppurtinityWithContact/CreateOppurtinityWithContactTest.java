package CreateOppurtinityWithContact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.propertyFileUtility;
import vtiger.ObjectRepository.HomePage;

public class CreateOppurtinityWithContactTest extends BaseClass {

	@Test
	public void CreateOppurtinityWithContact() throws Throwable{
		
		int Random = jUtil.getRandomNumber();

		/* Read Data from Excel sheet - Test data */
		String CONTACTS = eUtil.getDataFromExcel("Contacts", 4, 3)+Random;
		String LASTNAME = eUtil.getDataFromExcel("Contacts", 4, 2)+Random;
		String OPPORTUNITY = eUtil.getDataFromExcel("Opportunity", 1, 2);

	
	
	HomePage hp = new HomePage(driver);
	hp.clickcontact();
	
	
	
	
//	Navigate to create contact look up image
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
//	Create Contact with Mandatory Informations
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(ContactHeader.contains(LASTNAME))
	{
		System.out.println("PASS");
		System.out.println(LASTNAME);
	}
	else
	{
		System.out.println("Fail");
	}
	
	
	driver.findElement(By.linkText("Opportunities")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
	driver.findElement(By.cssSelector("input[name='potentialname']")).sendKeys(LASTNAME);
	
	wUtil.handleDropDown("Contacts", driver.findElement(By.id("related_to_type")));
	
	driver.findElement(By.xpath("//input[@id=\"related_to_display\"]/following-sibling::img[@title='Select']")).click();
	
	wUtil.swtichToWindow(driver, "Contacts");
	
	driver.findElement(By.name("search_text")).sendKeys(LASTNAME);
	
	
	driver.findElement(By.name("search")).click();
	
	driver.findElement(By.xpath("//a[text()=' "+LASTNAME+"']")).click();
	
	wUtil.swtichToWindow(driver, "parenttab");
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	String opportunity = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Assert.assertTrue((opportunity.contains(LASTNAME)));
	System.out.println(LASTNAME);
	wUtil.takeScreenShot(driver, LASTNAME);
	
	

	}

}
