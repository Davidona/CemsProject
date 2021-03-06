package gui;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * A controller class handling interaction with principal in principal menu.
 */
public class PrincipalMenuController {

    @FXML
    private JFXButton PrincipalMenu_btnReports;

    @FXML
    private JFXButton PrincipalMenu_btnExtensionRequests;

    @FXML
    private JFXButton PrincipalMenu_btnLogout;
    /**
     * Standard controller starting mechanism.
     * @param primaryStage - a stage to start on.
     */
    public void start(Stage primaryStage) throws Exception {	
    	Pane root;
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/fxml/PrincipalMenu.fxml"));
		root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Principal Menu");
		primaryStage.setScene(scene);
		primaryStage.show();	
	}
    
    /**
     * This method opens the next window - get report window.
     * @param event - a click on reports has occured.
     * @throws Exception
     */
    @FXML
    void PrincipalMenu_btnReportsClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalGetReportWindowController pgrwc = new PrincipalGetReportWindowController();
    	pgrwc.start(newStage);
    	currentStage.close();
    }
    
    
    /**
     * This method opens the next window - extension requests.
     * @param event - a click on extension requests has occured.
     * @throws Exception
     */
    @FXML
    void PrincipalMenu_btnExtensionRequestsClicked(ActionEvent event) throws Exception {
    	Stage newStage = new Stage();
    	Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	PrincipalTestExtentionRequestsController pterc = new PrincipalTestExtentionRequestsController();
    	pterc.start(newStage);
    	currentStage.close();
    }
    
    /**
     * This method logouts the principal from the system and re-opens login window.
     * @param event - a click on logout has occured.
     * @throws Exception
     */
    @FXML
    void PrincipalMenu_btnLogoutClicked(ActionEvent event) throws Exception {
		Stage newStage = new Stage();
		LoginCemsController lcc = new LoginCemsController();
		try {
			lcc.start(newStage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((Node) event.getSource()).getScene().getWindow().hide();
    }


}
