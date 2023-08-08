package CreateProductWithCampigns;

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
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.propertyFileUtility;

public class CreeateProductWithCampigns extends BaseClass {

	@Test(groups="RegressionSuite")
	public  void product() throws Throwable {
		
		
		

		// Step 1: Read all the necessary data

		/* Read data from property File - Common Data */
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		int Random = jUtil.getRandomNumber();
		
		String PRODUCT = eUtil.getDataFromExcel("Products", 1, 2)+Random;
		String CAMPIGN = eUtil.getDataFromExcel("Campigns", 1, 2)+Random;
		
		
		
		//Step 4: Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Click on Products Link
		driver.findElement(By.linkText("Products")).click();
		
//		Navigate to create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		
//		Create Products with Mandatory Informations
		driver.findElement(By.name("productname")).sendKeys(PRODUCT);
		wUtil.handleDropDown(" 303-Interest-Income ", driver.findElement(By.xpath("//select[@name='glacct']")));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String ProductHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		Assert.assertTrue(ProductHeader.contains(PRODUCT));
		
		
		//Step 5: Click on Campaigns Link
		WebElement element = driver.findElement(By.linkText("More"));
		wUtil.mouseHoverAction(driver, element);
		
		driver.findElement(By.name("Campaigns")).click();
		
		driver.findElement(By.cssSelector("img[alt='Create Campaign...']")).click();
		
		driver.findElement(By.name("campaignname")).sendKeys(CAMPIGN);
		
		wUtil.handleDropDown("Webinar", driver.findElement(By.name("campaigntype")));
		
		wUtil.handleDropDown("Active", driver.findElement(By.name("campaignstatus")));
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		wUtil.swtichToWindow(driver, "Products");
		
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+PRODUCT+"']")).click();
		
		wUtil.swtichToWindow(driver, "Campaigns");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, AdminImg);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Logout successfull");
		
	}
	
	
		

	

}
