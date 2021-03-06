package request;

import cachedUserData.DataManager;
import entities.Message;

/**Class for generating question ID.
 * In addition, uses the local cache(DataManager) for the purpose of creating question.
 * @author Aviv
 *
 */
public class GenerateQuestionID {


	/**Method for generating question ID using the course ID and the number of questions as an input.
	 * @param courseID course ID of affiliated question
	 * @param numOfExistingQuestions number of existing questions affiliated with the course ID
	 * @return
	 */
	public static String Generate(String courseID,int numOfExistingQuestions) {
		numOfExistingQuestions++;
		int qNum=numOfExistingQuestions;
		String generatedID="";
		String qNumString="";
		if(qNum<10) {
			qNumString="00"+Integer.toString(qNum);
		}
		else if(qNum<100) {
			qNumString="0"+Integer.toString(qNum);
		}
		else
			qNumString=Integer.toString(qNum);
		generatedID=courseID+qNumString;
		return generatedID;
	}
	
	public static void setQuestionAmount(Message msg) {
		String str = (String) msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setAmountOfQuestions(str);
	}
	public static void setTempQuestionAmount(Message msg) {
		int amount = (int) msg.getObj();
		DataManager dm = DataManager.getDataManager();
		dm.setCourseAmountQuestions(amount);
	}
	
	public static void setAddQuestionMsg(Message msg) {
		String str=(String)msg.getObj();
		DataManager dm=DataManager.getDataManager();
		dm.setAddQuestionMsg(str);
	}
	
	public static void setIncNumOfQuestionMsg(Message msg) {
		String str=(String)msg.getObj();
		DataManager dm=DataManager.getDataManager();
		dm.setIncQuestionNumMsg(str);
	}
	

}
