package net.demus_intergalactical.lanchat.frontend;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import org.fxmisc.richtext.InlineCssTextArea;

public class UIController {

	static InlineCssTextArea chatLog;
	static TextField inputField;
	static ListView<BorderPane> userList;
	static ListView<BorderPane> fileList;
	static Label username;

	public static void init(Parent root) {

		Platform.runLater(() -> {
			chatLog = (InlineCssTextArea) root.lookup("#chatlog");
			inputField = (TextField) root.lookup("#inputfield");
			userList = (ListView<BorderPane>) root.lookup("#userlist");
			fileList = (ListView<BorderPane>) root.lookup("#filelist");
			username = (Label) root.lookup("#username");

			username.setText("Connected as " + System.getProperty("user.name"));
		});
	}

}
