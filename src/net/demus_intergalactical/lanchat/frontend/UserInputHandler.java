package net.demus_intergalactical.lanchat.frontend;

public class UserInputHandler {

	static String username = System.getProperty("user.name");

	public static void sendMsg(String msg) {
		ChatPool.get(UIController.getActiveInstance()).appendToChat("#FF0000", username);
		ChatPool.get(UIController.getActiveInstance()).appendToChat("#000000", ": " + msg + "\n");
	}

	public static void receiveMsg(String msg, String user) {
		UIController.appendToChat("#0000FF", user);
		UIController.appendToChat("#000000", ": " + msg + "\n");
	}

}
