package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HomeScreenController {
	Passenger P;
	public Label labelHelloUser;
	/*public Label Fname;
	public Label Account;
	public Label Country;
	public Label Id;*/
	// --------------- Profile Controls ---------------\\
		
		public void getProfile(Passenger P) {
			this.P=P;
			
			if(P.gender.equals("Male")) {
				labelHelloUser.setText("Hello Mister " + P.firstname);
			}
			else {
				labelHelloUser.setText("Hello Mrs. " + P.firstname);
			}
			
			/*Fname.setText("" + M.firstname + " " + M.lastname);
			Account.setText("" + M.job);
			Country.setText("" + M.city +", "+ M.country);
			Id.setText("" + M.ID);
		}*/
		
		/*public void profileButtonClicked(ActionEvent e) {
			ProfTitle.setVisible(true);
			ProfFull.setVisible(true);
			MainTabManager.setVisible(false);
		}

		public void returnProfButtonClicked(ActionEvent e) {
			MainTabManager.setVisible(true);
			ProfTitle.setVisible(false);
			ProfFull.setVisible(false);
		}
		
		public void logOut(ActionEvent e) throws IOException {
			Parent Main = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
			Scene MainScene = new Scene(Main);
			
			Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
			window.setScene(MainScene);
		}*/
	
		}
}

