package net.demus_intergalactical.lanchat.frontend;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.fxmisc.richtext.InlineCssTextArea;
import org.fxmisc.richtext.StyledDocument;

public class UIController {

	static InlineCssTextArea chatLog;
	static TextField inputField;
	static BorderPane tabBar;
	static HBox tabBarTabs;
	static ListView<BorderPane> userList;
	static ListView<BorderPane> fileList;
	static Label userStatus;
	static String activeInstance;

	public static void init(Parent root) {

		Platform.runLater(() -> {
			chatLog = (InlineCssTextArea) root.lookup("#chatlog");
			inputField = (TextField) root.lookup("#inputfield");
			tabBar = (BorderPane) root.lookup("#tabbar");
			userList = (ListView<BorderPane>) root.lookup("#userlist");
			fileList = (ListView<BorderPane>) root.lookup("#filelist");
			userStatus = (Label) root.lookup("#userstatus");
			tabBarTabs = (HBox) root.lookup("#tabbartabs");

			chatLog.setWrapText(true);
			userStatus.setText("Connected as " + System.getProperty("user.name"));
		});
	}

	public static void addTab(ChatTab chattab) {
		Platform.runLater(() -> tabBarTabs.getChildren().add(chattab));
	}

	public static void removeTab(ChatTab chattab) {
		Platform.runLater(() ->
			tabBarTabs.getChildren().remove(chattab)
		);
	}

	public static void appendToChat(String color, String text) {
		Platform.runLater(() -> {
			int currlength = chatLog.getText().length();
			chatLog.appendText(text);
			chatLog.setStyle(currlength, currlength + text.length(), "-fx-fill:" + color + ";");
		});
	}

	public static void changeInstance(String instance) {
		Platform.runLater(() -> {
			if (activeInstance != null &&
					activeInstance.equals(instance)) {
				return;
			}
			if (activeInstance != null) {
				ChatPool.get(activeInstance).setActive(false);
				ChatPool.get(activeInstance).setInputBuf(inputField.getText());
				//ChatPool.get(activeInstance).getChatTab().setActive(false);
			}
			ChatPool.get(instance).setActive(true);
			//ChatPool.get(instance).getChatTab().setActive(true);
			activeInstance = instance;
			ChatPool.get(instance).onActivated();
		});
	}

	public static void setActiveInstance(String name) {
		activeInstance = name;
	}

	public static void updateChat(StyledDocument<String> consoleLog) {
		Platform.runLater(() -> {
			chatLog.clear();
			chatLog.replace(consoleLog);
		});
	}

	public static void updateInput(String inputBuf) {
		Platform.runLater(() -> inputField.setText(inputBuf));
	}

	public static String getActiveInstance() {
		return activeInstance;
	}

	public static void clearInput() {
		inputField.setText("");
	}

}
