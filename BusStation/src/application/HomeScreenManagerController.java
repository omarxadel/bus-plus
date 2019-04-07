package application;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HomeScreenManagerController {
	Manager M;
	public VBox MainTabManager;
	public VBox ManageTripsTab;
	public VBox ProfTitle;
	public AnchorPane ProfFull;
	public AnchorPane addTripFull;
	public VBox addTripTitle;
	public Label labelHelloManager;
	public Label Fname;
	public Label Account;
	public Label Country;
	public Label Id;
	public Button profReturn;
	public Button AddReturn;
	public Button addNewTrip;
	
// --------------- Profile Controls ---------------\\
	
	public void getProfile(Manager M) {
		this.M=M;
		labelHelloManager.setText("Hello Mister " + M.firstname);
		Fname.setText("" + M.firstname + " " + M.lastname);
		Account.setText("" + M.job);
		Country.setText("" + M.city +", "+ M.country);
		Id.setText("" + M.ID);
	}
	
	public void profileButtonClicked(ActionEvent e) {
		ProfTitle.setVisible(true);
		ProfFull.setVisible(true);
		MainTabManager.setVisible(false);
	}

	public void returnProfButtonClicked(ActionEvent e) {
		MainTabManager.setVisible(true);
		ProfTitle.setVisible(false);
		ProfFull.setVisible(false);
	}

// --------------- Manage Trips Button ------------\\
	
	public void ManageTripButtonClicked(ActionEvent e) {
		ManageTripsTab.setVisible(true);
		MainTabManager.setVisible(false);
	}
	public void returnManageTripButtonClicked(ActionEvent e) {
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
