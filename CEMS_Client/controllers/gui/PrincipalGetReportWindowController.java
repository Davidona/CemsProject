package gui;

import java.io.IOException;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import application.ClientUI;
import cachedUserData.DataManager;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * A controller class handling the interaction with principal in get report window.
 */
public class PrincipalGetReportWindowController {

	@FXML
	private JFXComboBox<String> PrincipalGetReportWindow_generateByCombo;

	@FXML
	private JFXTextField PrincipalGetReportWindow_valueTxt;

	@FXML
	private JFXButton PrincipalGetReportWindow_btnSubmit;

	@FXML
	private Button PrincipalGetReportWindow_btnBack;

	/**
	 * Standard controller starting mechanism.
	 * @param newStage
	 * @throws IOException
	 */
	public void start(Stage newStage) throws IOException {
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/PrincipalGetReportWindow.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		newStage.setTitle("Report Requests");
		newStage.setScene(scene);
		newStage.show();
	}

	/**
	 * This method routes the user to the previous window - principal menu window.
	 * @param event - back was clicked.
	 * @throws Exception
	 */
	@FXML
	void PrincipalGetReportWindow_btnBackClicked(ActionEvent event) throws Exception {
		Stage newStage = new Stage();
		Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		PrincipalMenuController pmc = new PrincipalMenuController();
		pmc.start(newStage);
		currentStage.close();
	}
	
	/**
	 * This methods initializes the relevant combobox with data.
	 */
	@FXML
	public void initialize() {
		PrincipalGetReportWindow_generateByCombo.getItems().addAll("Teacher", "Course", "Student");
	}
	
	/**
	 * This method submits the report request to the server, and if there is an available data
	 * it routes the user to the next page - generated report window.
	 * @param event- submit was clicked.
	 * @throws Exception 
	 */
	@FXML
	void PrincipalGetReportWindow_btnSubmitClicked(ActionEvent event) throws Exception {
		String values = "";
		values += PrincipalGetReportWindow_generateByCombo.getSelectionModel().getSelectedItem();
		values +="_";
		values +=PrincipalGetReportWindow_valueTxt.getText();
		ClientUI.chat.accept(new Message(Operation.GetReport ,values));
		if(DataManager.getDataManager().getReport() == null || DataManager.getDataManager().getReport().getGradesAndAppearance().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("There is no data for " + PrincipalGetReportWindow_generateByCombo.getSelectionModel().getSelectedItem() +"-" +PrincipalGetReportWindow_valueTxt.getText());
			alert.showAndWait();
		}
		else {
			Stage newStage = new Stage();
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			PrincipalGeneratedReportController pgmc = new PrincipalGeneratedReportController();
			pgmc.start(newStage);
			currentStage.close();
		}
	}
}
