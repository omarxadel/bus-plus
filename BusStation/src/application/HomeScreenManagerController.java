package application;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreenManagerController {
	ObservableList<String> startLocations = FXCollections.observableArrayList("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "Dsitrict10");
	ObservableList<String> DestLocations = FXCollections.observableArrayList("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "Dsitrict10");	
	ObservableList<String> drivers = FXCollections.observableArrayList("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "Dsitrict10");	
	ObservableList<String> cars = FXCollections.observableArrayList("VolvoB12","KiaGranbird","MercedesCito","ToyotaHiAcae","HundaiEquus");	
	ObservableList<String> carno = FXCollections.observableArrayList("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "Dsitrict10");	
	String[] Start = {"District1","District2","District3","District4","District5","District6","District7","District8", "District9", "Dsitrict10"};
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
	public Button LogOutButton;
	public ChoiceBox<String> startL;
	public Trip trip;
	
// --------------- Profile Controls ---------------\\
	
	public void getProfile(Manager M) {
		this.M=M;
		if(M.gender.equals("Male")) {
			labelHelloManager.setText("Hello Mister " + M.firstname);
		}
		else {
			labelHelloManager.setText("Hello Mrs. " + M.firstname);
		}
		
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
	
	public void logOut(ActionEvent e) throws IOException {
		Parent Main = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene MainScene = new Scene(Main);
		
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(MainScene);
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
	@FXML
	private void initializeChoiceStart() {
		startL.setValue("Start");
		startL.setItems(startLocations);
	}
	@FXML
	private void initializeChoiceDestination() {
		startL.setValue("Destination");
		startL.setItems(DestLocations);
	}

	// --------------- Add Trips Controls ------------\\
	
	public void addTripButtonClicked(ActionEvent e) {
		initializeChoiceStart();
		addTripTitle.setVisible(true);
		addTripFull.setVisible(true);
		ManageTripsTab.setVisible(false);
	}
	
	public void returnaddTripClicked(ActionEvent e) {
		ManageTripsTab.setVisible(true);
		addTripTitle.setVisible(false);
		addTripFull.setVisible(false);
	}
	
	public void checkboxStart(){
		startL.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		public void changed(ObservableValue ov, Number value, Number new_value) {
			
		}
			
			
			
	});
	}
}