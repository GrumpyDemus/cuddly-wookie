package net.demus_intergalactical.lanchat.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFrontEnd extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		WindowRegistry.setApplication(this);
		WindowRegistry.setPrimaryStage(primaryStage);
		primaryStage.setTitle("LANchat");
		primaryStage.minHeightProperty().set(400);
		primaryStage.minWidthProperty().set(600);
		primaryStage.setResizable(true);
		//Font.loadFont(Main.class.getClassLoader().getResourceAsStream("fonts/minecraft.ttf"), 10);
		Parent root;
		try {
			root = FXMLLoader.load(MainFrontEnd.class.getClassLoader()
				.getResource("style.fxml"));
		} catch (IOException e) {
			System.err.println("Style not loaded");
			e.printStackTrace();
			System.err.println("We honestly messed something up. Sorry.");
			return;
		}
		primaryStage.setScene(new Scene(root));
		primaryStage.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

		init(root);

		ChatInstance allchat = new ChatInstance();
		allchat.init("All Chat", true);

		primaryStage.show();
	}

	private void init(Parent root) {
		ChatPool.init();
		UIController.init(root);
	}

	public void run(String... args) {
		launch(args);
	}

	public void closeProgram() {
		WindowRegistry.closeAllStages();

		try {
			this.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
