package net.demus_intergalactical.lanchat;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class WindowRegistry {
	private static Map<String, Stage> registry = new HashMap<>();
	private static Stage primaryStage = null;
	private static Application application = null;
	private static Image icon = new Image(Main.class.getClassLoader().getResourceAsStream("assets/logo32x32.png"));


	public static void closeAllStages() {
		for (String key : registry.keySet()) {
			try {
				Stage window = registry.get(key);

				window.close();
			} catch (NullPointerException npe) {
				System.err.println("Stage '" + key + "' was not initialized");
			}
		}
		primaryStage.close();
	}

	public static Stage getWindow(String name) {
		return registry.get(name);
	}


	public static void register(Stage window) {
		registry.put(window.toString(), window);

		window.getIcons().add(icon);
	}


	public static void remove(Stage window) {
		registry.remove(window.toString(), window);
	}

	public static void setPrimaryStage(Stage primaryStage) {
		WindowRegistry.primaryStage = primaryStage;

		primaryStage.getIcons().add(icon);
	}

	public static void setApplication(Application application) {
		WindowRegistry.application = application;
	}

	public static Application getApplication() {
		return application;
	}
}
