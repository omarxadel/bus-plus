package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PaymentWindow {
	static String code;
	static boolean flag;
	
	public static boolean display(String title, String message, String instr, String buttonTxt, String payTxt, String prompt) {
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(400);
		window.setMinHeight(400);
		window.initModality(Modality.APPLICATION_MODAL);
		flag = false;
		TextField creditNumber = new TextField();
		creditNumber.setPromptText(prompt);
		creditNumber.setMinWidth(200);
		Button returnButton = new Button(buttonTxt);
		Button pay = new Button(payTxt);
		Label payment = new Label(message);
		Label instruction = new Label (instr);
		returnButton.setOnAction(e->{
			flag = false;
			window.close();
		});
		pay.setOnAction(e-> {
			code = creditNumber.getText();
			flag = true;
			window.close();
		});
		HBox subButton = new HBox(50);
		subButton.setAlignment(Pos.CENTER);
		subButton.getChildren().addAll(returnButton, pay);
		VBox layout = new VBox(10);
		layout.getChildren().addAll(payment, instruction, creditNumber, subButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		return flag;
	}
}
