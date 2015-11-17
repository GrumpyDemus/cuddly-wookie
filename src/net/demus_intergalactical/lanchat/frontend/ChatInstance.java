package net.demus_intergalactical.lanchat.frontend;

import org.fxmisc.richtext.InlineCssTextArea;

public class ChatInstance {

	private boolean isActive;
	private InlineCssTextArea chatLog;
	private String inputBuf;
	private ChatTab chatTab;

	public ChatInstance() {
		isActive = false;
		chatLog = new InlineCssTextArea();
	}

	public void init(String name, boolean closable) {
		chatTab = new ChatTab(name, closable);
		UIController.addTab(chatTab);
	}

	public void appendToConsole(String color, String text) {
		int currlength = chatLog.getText().length();
		chatLog.appendText(text);
		chatLog.setStyle(currlength, currlength + text.length(), "-fx-fill:" + color + ";");

		if (isActive) {
			UIController.appendToChat(color, text);
		}
	}

	public void setActive(boolean b) {
		isActive = b;
	}

	public void onActivated() {
		UIController.updateChat(chatLog.getDocument());
		UIController.updateInput(inputBuf);
	}

	public void setInputBuf(String inputBuf) {
		this.inputBuf = inputBuf;
	}

}
