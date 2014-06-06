package seleniumTest.webDriver;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

abstract public class WebDriver_triggerEventIT implements URL, Selectors{
	protected WebDriver driver;

	public abstract void initializeWebDriver();

	@Before
	public void beforeMethod() throws Exception {
		initializeWebDriver();
		driver.get(url);
	}

	@After
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

	@Test
	public void triggerEvent() throws Exception {
		Thread.sleep(1000);
		driver.findElement(By.id(button_eventOverview)).click();
		//trigger the first event
		Thread.sleep(1000);
		driver.findElements(By.className("trigger")).get(0).click();
	}

}
