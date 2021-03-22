package Demo;

import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.PrinterLocation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class FirstClass {

	WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void openBrowser(String browserName) {
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.get("https://www.transnomis.com/");
		driver.manage().window().maximize();
		//WebDriverWait wait=new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title=\"Search\"]")));
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		//mnkdakdka

	}
	@Test
	public void verifyData() {
		try {
			driver.findElement(By.partialLinkText("Municipal511")).click();
			
			
			Actions hover=new Actions(driver);
			//WebElement ele=driver.findElement(By.cssSelector("#gbwa > div > a > svg"));
			//hover.moveToElement(ele).perform();
			//Assert.assertEquals(linkText, actualText);

		}
		catch(Exception ex) {
			ex.getMessage();
		}
	}
	
	@AfterTest
	public void closeApp() {
		//driver.close();
	}
}
