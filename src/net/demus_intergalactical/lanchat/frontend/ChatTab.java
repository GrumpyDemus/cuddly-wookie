package net.demus_intergalactical.lanchat.frontend;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class ChatTab extends BorderPane {

	private Label tabName = new Label();
	private Button tabButton = new Button();

	public ChatTab(String name, boolean closable) {

		tabName.setText(name);
		this.setCenter(tabName);
		this.setId("tab");

		if(closable) {
			this.setRight(tabButton);
		}

		this.setOnMouseClicked(e -> {
			UIController.changeInstance(name);
		});

		tabButton.setOnAction(e -> {
			ChatInstance i = ChatPool.get(name);
		});
	}

	public void getName() {
		tabName.getText();
	}

	public void setActive(boolean b) {
		if(b) {
			this.setId("tabactive");
		} else {
			this.setId("tab");
		}
	}
}
