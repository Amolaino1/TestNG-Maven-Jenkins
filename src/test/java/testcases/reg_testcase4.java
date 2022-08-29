package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class reg_testcase4 {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	@Test(priority=1)
	public void validateHomePageTitle() {
		driver.get("http://zero.webappsecurity.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Zero - Personal Banking - Loans - Credit Cards", driver.getTitle());
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("signin_button")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		System.out.println(driver.getTitle());
		String actual=driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=account-summary.html']")).getText();
		Assert.assertEquals("Account Summary", actual);
		}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
