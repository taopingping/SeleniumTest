package seleniumTest.webDriver;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class WebDriver_editIssueIT implements Selectors, URL {
	protected WebDriver driver;

	@Test
	public void editIssueStatus() throws Exception {
		// select an issue
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"accordion1\"]/div[1]/a/div/h6"))
				.click();
		// click edit icon
		Thread.sleep(1000);
		driver.findElements(By.className(className_editIssue)).get(0).click();
		// close the issue
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id=\"editIssueRadioStatusInProgress\"]"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"editIssueRadioStatusClosed\"]"))
				.click();
		// save
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"saveEditedIssue\"]")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	@Test
	public void editResolutionOfClosedIssue() throws Exception {
		// test case 17
		// select an issue
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"accordion1\"]/div[1]/a/div/h6"))
				.click();
		// click edit icon
		Thread.sleep(1000);
		driver.findElements(By.className(className_editIssue)).get(0).click();
		// change the status to "closed"
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"editIssueRadioStatusClosed\"]"))
				.click();
		// change the solution
		Select resolution = new Select(driver.findElement(By
				.id(dropdown_resolution)));
		resolution.selectByVisibleText("Fixed");
		// save
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"saveEditedIssue\"]")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();		
	}

	//
	@Test
	public void editResolutionOfNoClosedIssue() throws Exception {
		// test case 17
		// select an issue
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"accordion1\"]/div[1]/a/div/h6"))
				.click();
		// click edit icon
		Thread.sleep(1000);
		driver.findElements(By.className(className_editIssue)).get(0).click();
		// change the status to "in progress"
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id=\"editIssueRadioStatusInProgress\"]"))
				.click();
		// change the solution
		Select resolution = new Select(driver.findElement(By
				.id(dropdown_resolution)));
		resolution.selectByVisibleText("Fixed");
		// save
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"saveEditedIssue\"]")).click();
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	protected abstract void initializeWebDriver();

	@Before
	public void beforeMethod() throws Exception {
		initializeWebDriver();
		driver.get(url);

		// create an new issue
		Thread.sleep(1000);
		driver.findElement(By.id(button_issueErstellen)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(radioButton_createIssueNewIssue)).click();
		// fill name and description
		Thread.sleep(1000);
		driver.findElement(By.id(eingabefeld_createIssueName)).sendKeys(
				"createAnIssueTest");
		driver.findElement(By.id(eingabefeld_createIssueDescription)).sendKeys(
				"RT");
		Thread.sleep(1000);
		// select every type
		Select filterTyp = new Select(driver.findElement(By
				.id(checkbox_filterIssueTyp)));
		filterTyp.selectByVisibleText("Bug");
		filterTyp.selectByVisibleText("Improvement");
		filterTyp.selectByVisibleText("Task");
		// save the issue
		driver.findElement(By.id(button_createIssueSaveNewIssue)).click();
	}

	@After
	public void afterMethod() throws Exception {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void deleteNewIssues() throws Exception {
	for (int i = 0; i < 1; i++) {
		// select an new issue
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id=\"accordion1\"]/div[1]/a/div/h6"))
				.click();
		// click edit icon
		Thread.sleep(1000);
		driver.findElements(By.className(className_editIssue)).get(0)
				.click();
		// close the issue
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id=\"editIssueRadioStatusClosed\"]"))
				.click();
		// save
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"saveEditedIssue\"]"))
				.click();
		Thread.sleep(10000);
		driver.navigate().refresh();

		// delete an issue
		// select an issue
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//*[@id=\"accordion3\"]/div[1]/a/div/h6"))
				.click();
		// click remove icon
		Thread.sleep(1000);
		driver.findElements(By.className(className_removeIssue)).get(0)
				.click();
	}
}

//@Test
//public void deleteIssuesInProgress() throws Exception {
//	int t = 0;
//	int startIndex = 3;//must be manually wrote
//	for (int i = 0; i < 1; i++) {
//		// select an issue in progress
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"accordion2\"]/div[1]/a/div"))
//				.click();
//		// click edit icon
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id="+(startIndex+t)+"]/div/button"))
//				.click();
//		t++;
//		// close the issue
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("//*[@id=\"editIssueRadioStatusClosed\"]"))
//				.click();
//		// save
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//*[@id=\"saveEditedIssue\"]"))
//				.click();
//		Thread.sleep(1000);
//		driver.navigate().refresh();
//
//		// delete an issue
//		// select an issue
//		Thread.sleep(1000);
//		driver.findElement(
//				By.xpath("//*[@id=\"accordion3\"]/div[1]/a/div/h6"))
//				.click();
//		// click remove icon
//		Thread.sleep(1000);
//		driver.findElements(By.className(className_removeIssue)).get(0)
//				.click();
//		driver.navigate().refresh();
//	}
//}

}
