package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import animatefx.animation.*;
import javafx.stage.StageStyle;

import java.awt.event.MouseEvent;


public class Main extends Application {
	double xOffset;
	double yOffset;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("BUS+");
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("../view/MainMenu.fxml"));
			Scene scene = new Scene(root,720,435);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);

			// MOVE THE WINDOW
			root.setOnMousePressed(mouseEvent -> {
				xOffset = primaryStage.getX() - mouseEvent.getScreenX();
				yOffset = primaryStage.getY() - mouseEvent.getScreenY();
			});

			root.setOnMouseDragged(mouseEvent -> {
				primaryStage.setX(mouseEvent.getScreenX() + xOffset);
				primaryStage.setY(mouseEvent.getScreenY() + yOffset);
			});

			primaryStage.initStyle(StageStyle.TRANSPARENT);
			new FadeIn(root).play();

			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
