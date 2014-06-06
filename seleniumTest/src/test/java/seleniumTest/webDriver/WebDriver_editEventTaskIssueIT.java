package seleniumTest.webDriver;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract public class WebDriver_editEventTaskIssueIT implements URL, Selectors {
	protected WebDriver driver;

	public abstract void initializeWebDriver();

	@Before
	public void beforeMethod() throws Exception {
		initializeWebDriver();
		driver.get(url);

		// create a task based on event
		driver.findElement(By.id(button_neuerTask)).click();
		// fill name and description
		Thread.sleep(1000);
		driver.findElement(By.id(eingabefeld_taskName)).sendKeys("Event");
		// based on event
		driver.findElement(By.id(radioButton_eventbasiertTaskErstellen))
				.click();
		// select a event
		driver.findElement(By.id(button_taskErstellenNeuesEvent)).click();
		driver.findElement(By.xpath(eingabefeld_taskErstellenNeuesEventName))
				.sendKeys("Beispielevent");
		// create a new issue
		driver.findElement(By.id(button_taskErstellenNeuesIssue)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(eingabefeld_issueNameFuerTask)).sendKeys(
				"Muster");
		driver.findElement(By.id(eingabefeld_issueBeschreibungFuerTask))
				.sendKeys("Beispiel");
		driver.findElement(By.id(button_speichernTaskNeuesIssue)).click();
		Thread.sleep(1000);
		// save the task
		driver.findElement(By.id(button_speichernTask)).click();
		
		//open event task list
		Thread.sleep(1000);
		driver.findElement(By.id(button_editEventTask)).click();
		Thread.sleep(1000);
		driver.findElements(By.className("editIssue")).get(0).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"modalOneBody\"]/button")).click();
	}

	@After
	public void afterMethod() {
		driver.close();
		driver.quit();
	}

	@Test
	public void selectEventTaskIssue() throws Exception {
		// show issue list
		Thread.sleep(1000);
		driver.findElement(By.id("selectSelectIssue")).click();
		// select the first issue
		Thread.sleep(1000);
		int selectorNumber = 0;
		boolean select;
		WebElement firstIssue;
		do {
			selectorNumber++;
			firstIssue = driver.findElement(By.id(selectorNumber
					+ "selectIssuesForTask"));
			select = firstIssue.isSelected();
		} while (select == true);
		firstIssue.click();
		// save selected issues
		Thread.sleep(1000);
		driver.findElement(By.id("saveSelectedIssueForExistTaskButton"))
				.click();
		// ok
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"modalTwoFooter\"]/button"))
				.click();

		// compare
		driver.navigate().refresh();
		// open a time task
		Thread.sleep(1000);
		driver.findElement(By.id(button_editEventTask)).click();
		// select task to edit
		Thread.sleep(1000);
		driver.findElements(By.className("editIssue")).get(0).click();
		Thread.sleep(1000);
		// edit issue
		driver.findElement(By.xpath("//*[@id=\"modalOneBody\"]/button"))
				.click();
		// show issue list
		Thread.sleep(1000);
		driver.findElement(By.id("selectSelectIssue")).click();
		Thread.sleep(1000);
		assertEquals(
				driver.findElement(
						By.id(selectorNumber + "selectIssuesForTask"))
						.isSelected(), true);

	}

	@Test
	public void createEventTaskIssue() throws Exception {
		// click button to create a new issue
		Thread.sleep(1000);
		driver.findElement(By.id("selectNewIssue")).click();
		// fill name and description
		Thread.sleep(1000);
		driver.findElement(By.id("newIssueNameForTask")).sendKeys(
				"editTimeTaskIssueNewIssueName");
		driver.findElement(By.id("IssueDescription")).sendKeys(
				"editTimeTaskIssueNewIssueDescription");
		// save
		driver.findElement(By.id("saveNewIssueForNewTaskButton")).click();
	}

	@Test
	public void deleteEventTaskIssue() throws Exception {
		// click button to create a new issue
		Thread.sleep(1000);
		driver.findElement(By.id("selectNewIssue")).click();
		// fill name and description
		Thread.sleep(1000);
		driver.findElement(By.id("newIssueNameForTask")).sendKeys(
				"editTimeTaskIssueNewIssueName");
		driver.findElement(By.id("IssueDescription")).sendKeys(
				"editTimeTaskIssueNewIssueDescription");
		// save
		driver.findElement(By.id("saveNewIssueForNewTaskButton")).click();

		// remove the first issue
		Thread.sleep(1000);
		driver.findElements(By.className("remove")).get(0).click();
	}

}
