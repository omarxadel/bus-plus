package application;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.sun.glass.ui.View;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreenManagerController implements Initializable {
	
	Manager M;
	Driver D[];
	Database d = new Database();
	public VBox MainTabManager;
	public VBox ManageTripsTab;
	public VBox ProfTitle;
	public VBox editTitle;
	public AnchorPane ProfFull;
	public AnchorPane addTripFull;
	public AnchorPane editFull;
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
	public ChoiceBox<String> DestL;
	public ChoiceBox<String> Driver;
	public ChoiceBox<String> car;
	public ChoiceBox<String> carNo;
	public DatePicker date;
	public TextField ticket;
	public TextField Time1, Time2;
	public TableView<Trip> Table;
	public TableColumn<Trip, Integer> TripIDc;
	public TableColumn<Trip, String> TripStart; 
	public TableColumn<Trip, String> TripDest; 
	public TableColumn<Trip, String> Vehicle; 
	public TableColumn<Trip, Integer> Vnumc;
	public TableColumn<Trip, String> DNamec; 
	public TableColumn<Trip, String> Datec;
	public TableColumn<Trip, String> Timec;
	public TableColumn<Trip, Float> Ticketc; 
	public Trip[] trip;


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	initTable();
	Table.setItems(getTrips());
	
}
	
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

	// --------------- Add Trips Controls ------------\\
	
	public void choiceInit() {
		startL.getItems().addAll("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "District10");
		startL.setValue("District1");
		DestL.getItems().addAll("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "District10");
		DestL.setValue("District10");
		int i = 0;
		while(D[i] != null) {
			Driver.getItems().add(D[i].username);
			i++;
		}
		if(D[0] != null) Driver.setValue(D[0].username);
		car.getItems().addAll("KiaGranbird","MercedesCito","VolvoB12","ToyotaHiAce","HyundaiEquus");
		car.setValue("KiaGranbird");
		carNo.getItems().add("12345");
	}
	
	public void addTripButtonClicked(ActionEvent e) {
		addTripTitle.setVisible(true);
		addTripFull.setVisible(true);
		ManageTripsTab.setVisible(false);
	}
	
	public void ReturnAddTripClicked(ActionEvent e) {
		ManageTripsTab.setVisible(true);
		addTripTitle.setVisible(false);
		addTripFull.setVisible(false);
	}
	 public void addTripButtonClickedin(ActionEvent e) throws IOException {
		 String date = this.date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 String time;
		 time = ("" + Time1.getText() + ":" + Time2.getText());
		 d.addTripData(startL.getValue(), DestL.getValue(), car.getValue(), carNo.getValue(), Driver.getValue(), date, time, ticket.getText());
	 }

// --------------- Edit Trips Controls ------------\\

public void initTable() {
	Table.setEditable(true);
	TripIDc.setCellValueFactory(new PropertyValueFactory<>("ID"));
	TripStart.setCellValueFactory(new PropertyValueFactory<>("start1"));
	TripDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
	Vehicle.setCellValueFactory(new PropertyValueFactory<>("vmodel"));
	Vnumc.setCellValueFactory(new PropertyValueFactory<>("vnum"));
	DNamec.setCellValueFactory(new PropertyValueFactory<>("driverName"));
	Datec.setCellValueFactory(new PropertyValueFactory<>("date"));
	Timec.setCellValueFactory(new PropertyValueFactory<>("time"));
	Ticketc.setCellValueFactory(new PropertyValueFactory<>("ticket"));
}
	 
public ObservableList<Trip> getTrips(){
	final ObservableList<Trip> tripsView = FXCollections.observableArrayList(new Trip ("Trip"));
	return tripsView;
}

public void editButtonClicked(ActionEvent e) {
	editTitle.setVisible(true);
	editFull.setVisible(true);
	Table.setVisible(true);
	ManageTripsTab.setVisible(false);
}

public void returnEditTripClicked(ActionEvent e) {
	ManageTripsTab.setVisible(true);
	editTitle.setVisible(false);
	Table.setVisible(false);
	editFull.setVisible(false);
}
 
}