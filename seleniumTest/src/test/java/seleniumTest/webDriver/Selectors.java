package seleniumTest.webDriver;

public interface Selectors {
	String date = "/html/body/div[4]/div[3]/table/tbody/tr[2]/td[5]";//change manually
	String day = "//*[@id=\"responsiveCalendar\"]/div[3]/div[13]/a";//change manually

	//overview
	String button_editTimeTask = "timeTaskOverviewButton";
	String button_editEventTask = "eventTaskOverviewButton";
	String button_suchen = "filterIssueView";
	String eingabefeld_filterIssueName = "filterIssueName";
	String checkbox_filterIssueTyp = "filterIssueType";
	String checkbox_filterIssueResolution = "filterIssueResolution";
	
	//createTask
	String button_neuerTask = "newTaskButton";
	String button_createTaskBreak = "stopNewTaskButton";
	String button_speichernTask = "saveNewTaskButton";
	String button_taskErstellenEventAuswaehlen = "newTaskSelectEventButton";
	String button_taskErstellenNeuesEvent = "newTaskNewEventButton";
	String button_taskErstellenIssueAuswaehlen = "selectSelectIssue";
	String button_speichernTaskIssueAuswaehlen = "saveSelectIssueForNewTaskButton";
	String button_taskErstellenNeuesIssue = "selectNewIssue";
	String button_speichernTaskNeuesIssue = "saveNewIssueForNewTaskButton";
	
	String eingabe_taskName = "Muster";
	String eingabe_taskBeschreibung = "Beispiel";
	
	String eingabefeld_taskErstellenNeuesEventName = "//*[@id=\"newEventNameParagraph\"]/input";//xpath
	String eingabefeld_taskName = "newTaskName";
	String eingabefeld_datum = "newTimeTaskDate";
	String eingabefeld_uhrzeit = "newTimeTaskTime";
	String eingabefeld_issueNameFuerTask = "newIssueNameForTask";
	String eingabefeld_issueBeschreibungFuerTask = "IssueDescription";


	String radioButton_eventbasiertTaskErstellen = "radioNewEventTask";
	String radioButton_zeitbasiertTaskErstellen = "radioNewTimeTask";
	
	
	//createIssue
	String button_issueErstellen = "newIssueButton";
	String button_createIssueBreak = "closeNewIssueentityButton";
	String button_createIssueNewIssueBreak = "closeNewIssueentityButton";
	String button_createIssueSelectIssueBreak = "stopSelectIssueForTask";
	String button_createIssueSaveSelectIssue = "stopSelectIssueForNewTaskButton";
	String button_createIssueSaveNewIssue = "saveNewIssueentityButton";
	
	String radioButton_createIssueSelectIssue = "newIssueSelectSelectIssue";
	String radioButton_createIssueNewIssue = "newIssueSelectCreateNewIssue";
	
	String checkbox_selectAnIssue = "selectIssuesForTask";//name
	
	String eingabefeld_createIssueName = "newIssueName";
	String eingabefeld_createIssueDescription = "newIssueIssueDescription";	
		
	//triggerEvent
	String button_eventOverview = "eventOverviewButton";
	
	//editIssue
	String eingabefeld_issueName = "newIssueName";
	String eingabefeld_issueBeschreibung = "newIssueIssueDescription";
	String className_editIssue = "editIssue";
	String className_removeIssue = "remove";
	String dropdown_resolution = "editTaskStatusResolution";
}
