package seleniumTest.webDriver;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriver_overviewIT implements Selectors, URL {
	protected WebDriver driver;


	@Test
	public void filter() throws Exception {
		// test case 18
		//insert a issue name
		driver.findElement(By.id(eingabefeld_filterIssueName)).sendKeys("Beispiel");
		driver.findElement(By.id(eingabefeld_filterIssueName)).clear();
		//select every type
		Select filterTyp = new Select(driver.findElement(By.id(checkbox_filterIssueTyp))); 
//		filterTyp.deselectAll();
		filterTyp.selectByVisibleText(IssueType.Bug.toString());
		filterTyp.selectByVisibleText(IssueType.Improvement.toString());
		filterTyp.selectByVisibleText(IssueType.Task.toString());
		filterTyp.selectByVisibleText("Alle Typen");

		//select every resolution
		Select filterResolution = new Select(driver.findElement(By.id(checkbox_filterIssueResolution)));
		filterResolution.selectByVisibleText("Cannot Reproduce");
		//submit
		driver.findElement(By.id(button_suchen));
		Thread.sleep(1000);
		filterResolution.selectByVisibleText("Done");
		//submit
		driver.findElement(By.id(button_suchen));
		Thread.sleep(1000);
		filterResolution.selectByVisibleText("Duplicate");
		//submit
		driver.findElement(By.id(button_suchen));
		Thread.sleep(1000);
		filterResolution.selectByVisibleText("Fixed");
		//submit
		driver.findElement(By.id(button_suchen));
		Thread.sleep(1000);
		filterResolution.selectByVisibleText("Wont Fix");
		//submit
		driver.findElement(By.id(button_suchen));
		Thread.sleep(1000);
		filterResolution.selectByVisibleText("Unresolved");
		//submit
		driver.findElement(By.id(button_suchen));
		Thread.sleep(1000);
		filterResolution.selectByVisibleText("Alle Resolutionen");
		//submit
		driver.findElement(By.id(button_suchen));
		Thread.sleep(1000);
	}

	
	public abstract void initializeWebDriver();
	
	@Before
	public void beforeMethod(){
		initializeWebDriver();
		driver.get(url);
	}

	@After
	public void afterMethod() {
		driver.close();
		driver.quit();
	}
}
