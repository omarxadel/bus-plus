package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreenDriverController {
	Driver D;
	@FXML
	public VBox MainTabManager;
	public VBox ManageTripsTab;
	public VBox ProfTitle;
	public AnchorPane ProfFull;
	public VBox addTripTitle;
	public AnchorPane addTripFull;
	public Label WelcomeDriver;
	public Label Fname;
	public Label Account;
	public Label Country;
	public Label Id;
	public Button profReturn;
	public Button AddReturn;
	public Button TripsSchedule;
	public Label NewTrip;
	public Button newTrip;
	public Button EditTrip;
	public Button CancelTrip;
	public Button Tripscomments;
	public Button addNewTrip;
	
	
	// --------------- Profile Controls ---------------\\
	
	public void getProfile(Driver driver)
	{
		this.D=driver;
		if(D.gender.equals("Male")) {
			WelcomeDriver.setText("Hello Mister " + D.firstname);
		}
		else {
			WelcomeDriver.setText("Hello Mrs. " + D.firstname);
		}
		Fname.setText("" +D.firstname + " " + D.lastname);
		Account.setText("" + D.job);
		Country.setText("" + D.city +", "+ D.country);
		Id.setText("" + D.ID);
	}
	public void profileButtonClicked (ActionEvent e)
	{
		ProfTitle.setVisible(true);
		ProfFull.setVisible(true);
		MainTabManager.setVisible(false);
	}
	public void returnProfButtonClicked (ActionEvent e)
	{
		MainTabManager.setVisible(true);
		ProfTitle.setVisible(false);
		ProfFull.setVisible(false);
	}
	public void logOut(ActionEvent e) throws IOException {
		Parent Main = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene MainScene = new Scene(Main);
		
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(MainScene);
	}
	
	// --------------- Manage Trips Button ------------\\
	
	public void ManageTripButtonClicked(ActionEvent e)
	{
		ManageTripsTab.setVisible(true);
		MainTabManager.setVisible(false);
	}
	public void returnManageTripButtonClicked(ActionEvent e)
	{
		MainTabManager.setVisible(true);
		ManageTripsTab.setVisible(false);
	}
	
	// --------------- Add Trips Controls ------------\\
	
	public void addTripButtonClicked(ActionEvent e) {
		addTripTitle.setVisible(true);
		addTripFull.setVisible(true);
		ManageTripsTab.setVisible(false);
	}
	
	public void returnaddTripClicked(ActionEvent e) {
		ManageTripsTab.setVisible(true);
		addTripTitle.setVisible(false);
		addTripFull.setVisible(false);
	}
	
	
}

