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

			chatLog.setWrapText(true);
			username.setText("Connected as " + System.getProperty("user.name"));
		});
	}

	public static void appendToChat(String color, String text) {
		Platform.runLater(() -> {
			int currlength = chatLog.getText().length();
			chatLog.appendText(text);
			chatLog.setStyle(currlength, currlength + text.length(), "-fx-fill:" + color + ";");
		});
	}

}
