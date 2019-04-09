package application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class AlertBox{
	
	
	public static void display(String title, String message, String buttonTxt) {
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(300);
		window.initModality(Modality.APPLICATION_MODAL);
		
		Button OkButton = new Button(buttonTxt);
		Label error = new Label(message);
		OkButton.setOnAction(e-> window.close());
		VBox layout = new VBox(10);
		layout.getChildren().addAll(error, OkButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	public static void display2(String title, String message) {
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(300);
		window.initModality(Modality.APPLICATION_MODAL);
		
		Button OkButton = new Button("Confirm");
		Label error = new Label(message);
		OkButton.setOnAction(e-> window.close());
		VBox layout = new VBox(10);
		layout.getChildren().addAll(error, OkButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
