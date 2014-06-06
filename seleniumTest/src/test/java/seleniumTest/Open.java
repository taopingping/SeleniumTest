package seleniumTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import seleniumTest.webDriver.URL;

public class Open implements URL{
	private WebDriver driver;

	 @Test
	 public void safariTest() {
	 driver = new SafariDriver();
	 driver.get(url);
	 }

	@Test
	public void chromeTest() {
		driver = new ChromeDriver();
		driver.get(url);
	}

	

	@Test
	public void firefoxTest() {
		driver = new FirefoxDriver();
		driver.get(url);
	}

	@After
	public void closeDriver() {
		 driver.close();
		 driver.quit();
	}
}
