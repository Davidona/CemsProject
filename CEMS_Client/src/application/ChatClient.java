package application;

import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import entities.Message;
import ocsf.client.AbstractClient;
import dataParsing.Parsing;

public class ChatClient extends AbstractClient {

	public static boolean awaitResponse = false;

	public ChatClient(String host, int port) throws IOException {
		super(host, port);
	}

	/**
	 * This function receives a message from the server and converts it so that the client side will understand it.
	 */
	public void handleMessageFromServer(Object msg) {
		Message receivedMessage = (Message) msg;
		awaitResponse = false;
		Parsing.Message(receivedMessage);

	}

	/**
	 * @param This function receives a message from the client and converts it so that the server will understand it.
	 */
	public void handleMessageFromClient(Message message) {
		try {
			openConnection();
			awaitResponse = true;
			sendToServer(message);
			while (awaitResponse) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			closeConnection();
		} catch (IOException e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setHeaderText("Error Connection");
			errorAlert.setContentText("cant connect to server");
			errorAlert.showAndWait();
		}

	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}

}
