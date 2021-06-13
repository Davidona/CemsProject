package logics;

import common.Permission;
import dataParsing.ActivateTest;
<<<<<<< HEAD
import dataParsing.AddQuestionOperations;
=======

import dataParsing.GetCurrentExecutionExamEmail;
import dataParsing.GetDurationForExecTest;

>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
import dataParsing.AddTestsOperations;

import dataParsing.GetFullTestTable;
import dataParsing.GetTestConfirmationTable;
import dataParsing.GetTestTable;
import dataParsing.HandleTestsActivatedByTeacher;
import dataParsing.ManualTestDownloader;
import dataParsing.ManualTestUploader;
import dataParsing.PrincipalGetExtentionRequests;
import dataParsing.PrincipalGetReport;
import dataParsing.SetCompletedStudentExam;
import dataParsing.TeacherGetAllSelfExecutedTests;
import dataParsing.TestCodeValidation;
import database.GetLogin;
import entities.Message;
import server.EchoServer;

public class DataParsing {
	public static Message Start(Object msg) {
		Message receivedMessage;
		if (msg instanceof Message)
			receivedMessage = (Message) msg;
		else {
			EchoServer.SC.addToTextArea("Cant Cast msg");
			return null;
		}
		switch (receivedMessage.getOperationType()) {
		
		case Login:
			return GetLogin.userLoginData(receivedMessage);
		case Logout:
			return GetLogin.logOut(receivedMessage);
		case GetTestTable:
			return GetTestTable.getTestTable(receivedMessage);
		case SendTestCode:
			return TestCodeValidation.validateTestCode(receivedMessage);
		case GetFullTestTable:
			return GetFullTestTable.getTestTable(receivedMessage);
		case ActivateTestCode:
			return ActivateTest.validateAndActivate(receivedMessage);	
		case DownloadManualTest:
			return ManualTestDownloader.downloadManualTest(receivedMessage);
		case UploadManualTest:
			return ManualTestUploader.uploadManualTest(receivedMessage);
		case GetReport:
			return PrincipalGetReport.getReport(receivedMessage);
		case GetTestsForTeacherReport:
			return TeacherGetAllSelfExecutedTests.getAllSelfExecutedTests(receivedMessage);

		case getInstructionsAndMail:
			return GetCurrentExecutionExamEmail.getComposerEmail(receivedMessage);
		case GetTimeForTestInExecution:
			return GetDurationForExecTest.getDuration(receivedMessage);
		case SetCompletedExam:
			return SetCompletedStudentExam.setExam(receivedMessage);

		case GetSubjectsAndCourses:
			return AddTestsOperations.getSubjectsAndCourses(receivedMessage);
		case GetQuestions:
			return AddTestsOperations.getQuestions(receivedMessage);
		case GetAmountOfTests:
			return AddTestsOperations.getAmountOfTests(receivedMessage);
		case GetAmountOfQuestions:
			return AddQuestionOperations.getAmountOfQuestions(receivedMessage);
		case GetCourseAmountOfQuestions:
			return AddQuestionOperations.getAmountOfCourseQuestions(receivedMessage);
		case AddNewTest:
			return AddTestsOperations.addTest(receivedMessage);
<<<<<<< HEAD
		case AddQuestionToDatabase:
			return AddQuestionOperations.addQuestionToDB(receivedMessage);
		case IncrementNumOfQuestionsInCourse:
			return AddQuestionOperations.increaseNumOfQuestionsInCourse(receivedMessage);
=======
		case ChangeAmountOfTestsInCourseTable:
			return AddTestsOperations.changeAmountOfTestsInCourseTable(receivedMessage);
		case GetExtensionRequests:
			return PrincipalGetExtentionRequests.getExtensions(receivedMessage);
		case GetTestConfirmationTable:
			return GetTestConfirmationTable.get(receivedMessage);
>>>>>>> branch 'master' of https://github.com/menison/G13_TheGreatProject.git
		default:
			break;
		}
		return null;
	}
	
	public static Permission getPermission(String password1, String password2) {
		return password1.equals(password2) ? Permission.yes : Permission.no;
	}

}