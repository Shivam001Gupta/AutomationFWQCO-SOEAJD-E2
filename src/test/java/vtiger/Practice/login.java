package vtiger.Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class login {

	public static void main(String[] args) throws InterruptedException {
		
		Random r  = new Random();
		int Random = r.nextInt(1000);
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		
//		Create Contacts
//		driver.findElement(By.linkText("Contacts")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Gupta");
//		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
//		driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		
//		Click on the Organizations
		driver.findElement(By.linkText("Organizations")).click();
		
//		Click on Create Organizations
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		Thread.sleep(2000);
		
//		Enter Account name
		String Rnname = "L&T"+Random;
		driver.findElement(By.cssSelector("input[name=\"accountname\"]")).sendKeys(Rnname);
		Thread.sleep(3000);
//		new Select(driver.findElement(By.xpath("//Select[@name=\"industry\"]"))).selectByVisibleText("Chemicals");
		
		new Select(driver.findElement(By.xpath("//Select[@name=\"industry\"]"))).selectByVisibleText("Energy");
		new Select(driver.findElement(By.cssSelector("select[ name='accounttype']"))).selectByVisibleText("Customer");
		
		
		driver.findElement(By.xpath("(//input[@value='  Save  '])[1]")).click();
		Thread.sleep(2000);
		
		String cretcomp = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (cretcomp.contains(Rnname))
		{
			System.out.println("Pass");
			System.out.println(cretcomp);
		}
		
		else
		{
			System.out.println("Fail");
		}
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

	}

}
