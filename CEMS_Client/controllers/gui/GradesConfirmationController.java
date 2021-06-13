package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import application.ClientUI;
import common.Operation;
import entities.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

    public class GradesConfirmationController implements Initializable {

        @FXML
        private JFXTextField calculatedGrade_txtField;

        @FXML
        private JFXTextField newGrade_txtField;

        @FXML
        private JFXToggleButton confimation_slideBar;

        @FXML
        private JFXTextField reasonForChange_txtField;

        @FXML
        private JFXButton confirmation_btnClose;

        @FXML
        private JFXButton confirmation_BtnSave;
        
        @FXML
        void changeGrade(ActionEvent event) {
        	newGrade_txtField.setVisible(true);
    		reasonForChange_txtField.setVisible(true);
    		confirmation_BtnSave.setText("Save");
    		
        }


        @FXML
        void Save(ActionEvent event) {
        	int newGrade = Integer.parseInt(newGrade_txtField.getText());
    		String reason = reasonForChange_txtField.getText();
    		
    		String op = confirmation_BtnSave.getText();
    		switch (op) {
    		case "Save":
    			
    			break;
    		case "Authorize":
    			
    			break;
    		}
    		
   
    		
    		
        }
        
        @FXML
        void close(ActionEvent event) {
        	Stage stage = (Stage) confirmation_btnClose.getScene().getWindow();
        	stage.close();
        }
        
        public void start(Stage primaryStage) {	
        	Pane root;
        	FXMLLoader loader = new FXMLLoader();
    		loader.setLocation(getClass().getResource("/fxml/GradesConfirmation.fxml"));
    		try {
				root = loader.load();
				Scene scene = new Scene(root);
	    		primaryStage.setTitle("Confirm Grades");
	    		primaryStage.setScene(scene);
	    		primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			ClientUI.chat.accept(new Message(Operation.GetCalculatedGradeForConfirmation, null));
			calculatedGrade_txtField.setText(null);
			newGrade_txtField.setVisible(false);
    		reasonForChange_txtField.setVisible(false);
    		confirmation_BtnSave.setText("Authorize");
			
		}
        

    }

