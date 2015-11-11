package net.demus_intergalactical.lanchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        WindowRegistry.setApplication(this);
        WindowRegistry.setPrimaryStage(primaryStage);
        primaryStage.setTitle("LANchat");
        primaryStage.minHeightProperty().set(400);
        primaryStage.minWidthProperty().set(600);
        primaryStage.setResizable(true);
        //Font.loadFont(Main.class.getClassLoader().getResourceAsStream("fonts/minecraft.ttf"), 10);
        Parent root;
        try {
            root = FXMLLoader.load(Main.class.getClassLoader().getResource("style.fxml"));
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

		String username = System.getProperty("user.name");

		primaryStage.show();
    }


    public static void main(String[] args) {
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
