  package vtiger.Practice;

  import java.io.IOException;
  import org.apache.poi.EncryptedDocumentException;
  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.firefox.FirefoxDriver;
  import org.testng.annotations.DataProvider;
  import org.testng.annotations.Test;
  import io.github.bonigarcia.wdm.WebDriverManager;
  import vtiger.GenericUtilities.ExcelFileUtility;
  import vtiger.GenericUtilities.JavaUtility;
  import vtiger.GenericUtilities.WebDriverUtility;
  import vtiger.GenericUtilities.propertyFileUtility;
  import vtiger.ObjectRepository.CreateNewOrganizationsPage;
  import vtiger.ObjectRepository.HomePage;
  import vtiger.ObjectRepository.LoginPage;
  import vtiger.ObjectRepository.OrganizationsInfoPage;
  import vtiger.ObjectRepository.OrganizationsPage;

  public class CreateMultipleOrgWithIndustry {

    ExcelFileUtility eUtil = new ExcelFileUtility();
    JavaUtility jUtil = new JavaUtility();
    propertyFileUtility pUtil = new propertyFileUtility();
    WebDriverUtility wUtil = new WebDriverUtility();

    @Test(dataProvider = "getData")
    public void createMultipleOrg(String ORG, String INDUSTRY)  throws Throwable {

      WebDriver driver = null;

      // Step 1: Read all the necessary data

      /* Read data from property File - Common Data */
      String BROWSER = pUtil.getDataFromPropertyFile("browser");
      String URL = pUtil.getDataFromPropertyFile("url");
      String USERNAME = pUtil.getDataFromPropertyFile("username");
      String PASSWORD = pUtil.getDataFromPropertyFile("password");

      /* Read Data from Excel sheet - Test data */
      String ORGNAME = ORG + jUtil.getRandomNumber();

      // Step 2: Launch the browser - driver is acting based runtime data - RunTime
      // polymorphism
      if (BROWSER.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println(BROWSER + " --- Browser launched");

      } else if (BROWSER.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.out.println(BROWSER + " --- Browser launched");
      } else {
        System.out.println("invalid Browser name");
      }

      wUtil.maximizeWindow(driver);
      wUtil.waitForElementsToLoad(driver);

      // Step 3: Load the URL
      driver.get(URL);

      // Step 4: Login to the Application
      LoginPage lp = new LoginPage(driver);
      lp.LoginToApp(USERNAME, PASSWORD);

      // Step 5: Click on Organizations Link
      HomePage hp = new HomePage(driver);
      hp.OrganizationHomePage();

      // Step 6: click on Create Organization look up image
      OrganizationsPage op = new OrganizationsPage(driver);
      op.clickonCreateOrgLookUpImage();

      // Step 6: create Organization
      CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
      cnop.CreateOrganizations(ORGNAME, INDUSTRY);

      // Step 8: Validate
      OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
      String OrgHeader = oip.OrgHeaderText();
      if (OrgHeader.contains(ORGNAME)) {
        System.out.println("PASS");
        System.out.println(OrgHeader);
      } else {
        System.out.println("Fail");
      }

      // Step 9: Logout of Application
      hp.logoutOfApp(driver);
      System.out.println("Logout successfull");
    }

    @DataProvider
    public Object[][] getData() throws Throwable, IOException {
      return eUtil.readMultipleData("MultipleOrg");
    }

  }
