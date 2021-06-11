package entities;

import java.time.LocalTime;
import java.util.HashMap;

public class ExecutedTest  {
	
	private Student executedBy;
	private Test testInExecution;
	private String executionCodePK = null;
	private HashMap<Question, Integer> answers;
	private int actualDuration;
	private LocalTime startTime;
	private LocalTime endTime;
	

	public ExecutedTest(Test testInExecution, String executionCodePK, HashMap<Question, Integer> answers,
			Student executedBy, int actualDuration, LocalTime startTime, LocalTime endTime) {
		super();
		this.testInExecution = testInExecution;
		this.executionCodePK = testInExecution.getCurrExecutionCode();
		this.answers = answers;
		this.executedBy = executedBy;
		this.actualDuration = actualDuration;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getExecutionCodePK() {
		return executionCodePK;
	}

	public void setExecutionCodePK(String executionCodePK) {
		this.executionCodePK = executionCodePK;
	}

	public HashMap<Question, Integer> getAnswers() {
		return answers;
	}

	public int getActualDuration() {
		return actualDuration;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public Student getExecutedBy() {
		return executedBy;
	}

	public void setExecutedBy(Student executedBy) {
		this.executedBy = executedBy;
	}

	public Test getTestInExecution() {
		return testInExecution;
	}


}
