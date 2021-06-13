package dataParsing;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.Operation;
import database.Query;
import entities.Message;
import entities.Question;
import gui.ServerController;

public class AddQuestionOperations {

	public static Message getAmountOfQuestions(Message msg) {
		Integer amountOfQuestions;
		ResultSet rs;
		Message messageToReturn;
		try {
			rs = Query.countTableEntries("question");
			ServerController.sc.addToTextArea("Counting Questions");
			rs.next();
			amountOfQuestions = rs.getInt(1);
			rs.close();
			messageToReturn = new Message(Operation.GetAmountOfQuestions, amountOfQuestions.toString());
			return messageToReturn;
		} catch (SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
	public static Message getAmountOfCourseQuestions(Message msg) {
		Integer amountOfQuestions;
		ResultSet rs;
		Message messageToReturn;
		try {
			rs=Query.SelectColumnTableWhere("numOfQuestions", "course", "ID", (String)msg.getObj());
			ServerController.sc.addToTextArea("Counting Questions For Course ID: "+(String)msg.getObj());
			rs.next();
			amountOfQuestions=rs.getInt(1);
			rs.close();
			messageToReturn=new Message(Operation.GetCourseAmountOfQuestions,amountOfQuestions);
			return messageToReturn;
		}catch(SQLException e) {
			System.out.println("Error setting table");
			e.printStackTrace();
		}
		return null;
	}
	public static Message addQuestionToDB(Message msg) {
		Question qst=(Question) msg.getObj();
		String courseID=qst.getQuestionID().substring(0,2);
		Message messageToReturn;
		Query.InsertQuestionToDataBase(qst);
		Query.IncreaseNumOfQuestionInCourse(courseID);
		ServerController.sc.addToTextArea("Added a question to the database with ID: "+qst.getQuestionID());
		messageToReturn=new Message(Operation.AddQuestionToDatabase,"Question has been added");
		return messageToReturn;
	}
	
	public static Message increaseNumOfQuestionsInCourse(Message msg) {
		String courseID=(String) msg.getObj();
		Message messageToReturn;
		Query.IncreaseNumOfQuestionInCourse(courseID);
		ServerController.sc.addToTextArea("Increased number of questions in course ID: "+courseID);
		messageToReturn=new Message(Operation.IncrementNumOfQuestionsInCourse,"Number of question has been increased");
		return messageToReturn;
	}

}
