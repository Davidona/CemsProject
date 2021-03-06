package gui;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * A controller class handling the interaction with teacher in lock test window.
 */
public class LocktestController {

    @FXML
    private JFXButton btnLockClose;

    @FXML
    private JFXButton btnLock;
    
    @FXML
    private JFXTextField testCodeToLock_txtField;

	/**
	 * Standard controller starting mechanism.
	 * @param primaryStage
	 */
	public void start(Stage primaryStage){
		Pane root;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/Locktest.fxml"));
		try {
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle("Lock test menu");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    /**
     * @param This method will result in writing isActivated=0 for the desired activatedTest
     * tuple - which will result in a test lock.
     */
    @FXML
    void Lock(ActionEvent event) {
    	String testCodeToLock = testCodeToLock_txtField.getText();
    	ClientUI.chat.accept(new Message(Operation.LockTest, testCodeToLock));
    }

    /**
     * This method will close the current window and route the user back to teacher main menu window.
     * @param event
     */
    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage)btnLockClose.getScene().getWindow();
    	stage.close();
    	TeacherMenuController tmc = new TeacherMenuController();
    	Stage primaryStage = new Stage();
    	tmc.start(primaryStage);
    }

}

