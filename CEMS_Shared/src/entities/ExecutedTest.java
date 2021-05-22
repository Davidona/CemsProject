package entities;

import java.util.ArrayList;
import java.util.HashMap;

public class ExecutedTest extends Test {
	public ExecutedTest(ArrayList<Question> questions, String testID, int allocatedDuration, String commentsForStudents,
			String commentsForTeachers, String currExecutionCode, HashMap<Question, Integer> pointDistribution,
			boolean isActivated) {
		super(questions, testID, allocatedDuration, commentsForStudents, commentsForTeachers, currExecutionCode,
				pointDistribution, isActivated);
	}

	private String executionCodePK;


}
