package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGParallelTestsWithDriverFactory {
	
	@BeforeClass
	void setUpClass() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/patri/Downloads/chromedriver.exe");
	}
	
	@Test
	void calcTest() {			
		WebDriver driver = DriverFactory.getInstance().getDriver(BrowserType.CHROME);
		driver.get("http://www.google.com");	
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("2 + 3");
		element.submit();
			
		WebElement result = driver.findElement(By.id("cwos"));
		AssertJUnit.assertEquals(result.getText(), "5");
	}
	
	@Test
	void searchTest() {
		WebDriver driver = DriverFactory.getInstance().getDriver(BrowserType.CHROME);
		driver.get("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium WebDriver");
		element.submit();
		
		AssertJUnit.assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));
	}

	
}
