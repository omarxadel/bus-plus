package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HomeScreenController {
	//Manager M;
	Passenger P;
	Seat s;
	Stage stage;
	Scene scene;
	//Driver D;
	
	public Button PromoCodes;
	public Button PassengerProfileButton;
	public Button SeatingOptions;
	public Button Service;
	public Button Settings;
	public Button EditAccount;
	public Button ReturnProf;
	public MenuItem OnewayOption;
	public VBox PassengerTabs;
	public Label WelcomeLabel;
	public AnchorPane ProfFull;
	public Label Account;
	public Label Fname;
	public Label Country;
	public Label ID;
	public Label how;
	public Label search;
	public Label find;
	public Label book;
	public Label booking;
	public VBox MyProfile;

	// --------------- Profile Controls ---------------\\
	 
	public void getProfile (Passenger P)
	{
		this.P=P;
		if(P.gender.equals("Male")) {
			WelcomeLabel.setText("Hello Mister " + P.firstname);
		}
		else {
			WelcomeLabel.setText("Hello Mrs. " + P.firstname);
		}
		Fname.setText("" + P.firstname + " " + P.lastname);
		Account.setText("" + P.job);
		Country.setText("" + P.city +", "+ P.country);
		ID.setText("" + P.ID);
		
	}
	
	public void profileButtonClicked (ActionEvent e)
	{
		ProfFull.setVisible(true);
		//MyProfile.setVisible(true);
		how.setVisible(false);
		search.setVisible(false);
		find.setVisible(false);
		book.setVisible(false);
		booking.setVisible(false);
		
		
	}
	
	public void returnProfButtonClicked (ActionEvent e)
	{   
		how.setVisible(true);
		search.setVisible(true);
		find.setVisible(true);
		book.setVisible(true);
		booking.setVisible(true);
		ProfFull.setVisible(false);
		//MyProfile.setVisible(false);
		
		
	}
	// --------------- Choosing Seats ---------------\\
	
	public void SeatingOptions (ActionEvent e) throws IOException
	{
		SeatsDesign.display(36);
		
	}

	public Scene getScene() {
		return scene;
	}
}
	/*Passenger P;
	public Label labelHelloUser;
	/*public Label Fname;
	public Label Account;
	public Label Country;
	public Label Id;*/
	// --------------- Profile Controls ---------------\\
		
		/*public void getProfile(Passenger P) {
			this.P1=P;
			
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
	
		


