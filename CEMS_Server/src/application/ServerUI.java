package application;

import gui.ServerController;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 *  The server function that determines the port and start the server.
 *
 */
public class ServerUI extends Application {

	final public static int DEFAULT_PORT = 5556;

	/**
	 * Standard application starting mechanism.
	 * @param stage - a stage to start on.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		ServerController aFrame = new ServerController();
		aFrame.start(primaryStage);
	}

	public static void main(String args[]) throws Exception {
		launch(args);
	}

}
