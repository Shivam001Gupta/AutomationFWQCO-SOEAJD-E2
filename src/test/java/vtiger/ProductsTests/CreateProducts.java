package vtiger.ProductsTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.propertyFileUtility;
import vtiger.ObjectRepository.LoginPage;

public class CreateProducts {

	public static void main(String[] args) throws Throwable {
		JavaUtility jUtil = new JavaUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		propertyFileUtility pUtil = new propertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		WebDriver driver = null;
		

		// Step 1: Read all the necessary data

		/* Read data from property File - Common Data */
		String BROWSER = pUtil.getDataFromPropertyFile("browser");
		String URL = pUtil.getDataFromPropertyFile("url");
		String USERNAME = pUtil.getDataFromPropertyFile("username");
		String PASSWORD = pUtil.getDataFromPropertyFile("password");
		int Random = jUtil.getRandomNumber();
		
		String PRODUCT = eUtil.getDataFromExcel("Products", 1, 2)+Random;
		
		//Step 2: Launch the browser - driver is acting based runtime data 
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+" --- Browser launched");
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+" --- Browser launched");
		}
		else
		{
			System.out.println("invalid Browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 3: Load the URL
		driver.get(URL);
		
		//Step 4: Login to the Application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		
		//Step 5: Click on Products Link
		driver.findElement(By.linkText("Products")).click();
		
//		Navigate to create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		
//		Create Products with Mandatory Informations
		driver.findElement(By.name("productname")).sendKeys(PRODUCT);
		wUtil.handleDropDown(" 303-Interest-Income ", driver.findElement(By.xpath("//select[@name='glacct']")));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String ProductHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(ProductHeader.contains(PRODUCT))
		{
			System.out.println("PASS");
			System.out.println(PRODUCT);
		}
		else
		{
			System.out.println("Fail");
		}
	}

	private static void LoginToApp(String uSERNAME, String pASSWORD) {
		// TODO Auto-generated method stub
		
	}

}
