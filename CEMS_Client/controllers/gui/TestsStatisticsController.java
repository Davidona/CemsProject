package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import entities.TestForTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * A controller class handling interaction with user in test statistics window.
 */
public class TestsStatisticsController {

	@FXML
	private JFXButton testsStatistics_btnClose;

	@FXML
	private TableView<TestForTable> testStatisticsTable;

	@FXML
	private TableColumn<TestForTable, String> testIdColumn;

	@FXML
	private JFXButton testsStatistics_btnGetStatistics;

	 /**
     * Standard controller starting mechanism.
     * @param primaryStage - a stage to start on.
     */
	public void start(Stage newStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/TestsStatistics.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Tests Statistics");
		newStage.setScene(scene);
		newStage.show();
	}

	/**
	 * This method closes the current window and re-opens teacher main menu window.
	 * @param event - a click on close has occured.
	 * @throws Exception
	 */
	@FXML
	void testsStatistics_btnCloseClicked(ActionEvent event) throws Exception {
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		TeacherMenuController tmc = new TeacherMenuController();
		tmc.start(newStage);
		currentStage.close();
	}

	/**
	 * This method gets a report from the server using data saved within the DB
	 * and displays it visually to the teacher.
	 * @param event - a request to get report has occured.
	 * @throws IOException
	 */
	@FXML
	void getReport(ActionEvent event) throws IOException {
		if (testStatisticsTable.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("There is no executed tests written by you or you didn't choose a test");
			alert.showAndWait();
		} else {
			String values = "";
			values += "Test";
			values += "_";
			values += testStatisticsTable.getSelectionModel().getSelectedItem().getTestID();
			ClientUI.chat.accept(new Message(Operation.GetReport, values));
			Stage newStage = new Stage();
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			TeacherReportWindowController trwc = new TeacherReportWindowController();
			trwc.start(newStage);
			currentStage.close();
		}
	}

	
	/**
	 * This method Initializes the table cells.
	 */
	@FXML
	public void initialize() {
		DataManager dm = DataManager.getDataManager();
		ObservableList<TestForTable> tests = FXCollections.observableArrayList(dm.getExecutedExams());
		testIdColumn.setCellValueFactory(new PropertyValueFactory<>("testID"));
		testStatisticsTable.setItems(tests);
	}

}
