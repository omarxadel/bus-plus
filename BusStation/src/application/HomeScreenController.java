package application;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class HomeScreenController implements Initializable {
	//Manager M;
	Passenger P;
	Seat s;
	Stage stage;
	Scene scene;
	public Trip[] trip;
	//Driver D;
	static Database d = new Database();
	public AnchorPane Trip1;
	public AnchorPane Trip2;
	public AnchorPane Trip3;
	public AnchorPane Editacc;
	public AnchorPane searchResultPane;
	public Button PromoCodes;
	public Button PassengerProfileButton;
	public Button SeatingOptions;
	public Button Service;
	public Button Settings;
	public Button back;
	//public Button EditAccount;
	public Button ReturnProf;
	public MenuItem OnewayOption;
	public MenuItem Round;
	public MenuItem line1;
	public MenuItem line2;
	public MenuItem line3;
	public VBox PassengerTabs;
	public Label WelcomeLabel;
	public AnchorPane ProfFull;
	public Label Fname;
	public Label Country;
	public Label ID;
	public VBox ProfTitle;
	public VBox SearchTabs;
	public VBox instr;
	public VBox LabelChoose;
	public ChoiceBox<String> type;
	public ChoiceBox<String> start;
	public ChoiceBox<String> destination;
	public DatePicker date;
	public ListView<String> searchView;
	private Trip [] resultTrips;
	private String [] results;
	
	// --------------- Profile Controls ---------------\\
	 
	public void getProfile (Passenger P)
	{
		this.P=P;
		if(P.gender.equals("Male")) {
			WelcomeLabel.setText("Hello Mr. " + P.firstname);
		}
		else {
			WelcomeLabel.setText("Hello Mrs. " + P.firstname);
		}
		Fname.setText("" + P.firstname + " " + P.lastname);
		Country.setText("" + P.city +", "+ P.country);
		ID.setText("" + P.ID);
		
	}
	
	public void profileButtonClicked (ActionEvent e)
	{
		ProfFull.setVisible(true);
		ProfTitle.setVisible(true);
		Editacc.setVisible(true);
		SearchTabs.setVisible(false);
		instr.setVisible(false);
		PassengerTabs.setVisible(false);
		
		
	}

	public void returnProfButtonClicked (ActionEvent e)
	{   
		SearchTabs.setVisible(true);
		instr.setVisible(true);
		PassengerTabs.setVisible(true);
		ProfFull.setVisible(false);
		ProfTitle.setVisible(false);
		Editacc.setVisible(false);

	}
	
	public void logOut(ActionEvent e) throws IOException {
		Parent Main = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene MainScene = new Scene(Main);
		
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(MainScene);
	}
	// --------------- Choosing Seats ---------------\\
	
	public void SeatingOptions (ActionEvent e) throws IOException
	{
		SeatsDesign.display(48);
		
	}

	public Scene getScene() {
		return scene;
	}


//--------------- Search Trip Controls ---------------\\

	public void choiceInit() {
		type.getItems().addAll("One-Way", "Round-Trip");
		start.getItems().addAll("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "District10");
		destination.getItems().addAll("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "District10");
	}
	
	public String[] getSelection() {
		String [] searchData = new String [4];
		if(type.getValue() == null || start.getValue() == null || destination.getValue() == null || date.getValue() == null) {
			AlertBox.display("UNEXPECTED INPUTS", "Make sure you enter all the search fields!", "OK");
		}
		else {
			searchData[0] = type.getValue();
			searchData[1] = start.getValue();
			searchData[2] = destination.getValue();
			searchData[3] = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return searchData;
	}
	
	public Trip[] queryTrips() {
		int i = 0, k =0;
		resultTrips = new Trip[100];
		String [] searchData;
		searchData = getSelection();
		while(d.T[i] != null) {
			if(d.T[i].type.equals(searchData[0]) && d.T[i].start.equals(searchData[1]) && d.T[i].destination.equals(searchData[2]) && d.T[i].date.equals(searchData[3])) {
				resultTrips[k] = d.T[i];
				k++;
			}
			i++;
		}
		return resultTrips;
	}
	
	public String [] showResults() {
		
		Trip [] T = queryTrips();
		results = new String[50];
		int i = 0;
		while(T[i] != null) {
			results[i] = ("Trip type: " + T[0].type + "		Start: " + T[0].start + "		Destination: " + T[0].destination + "		Vehicle Type:" + T[i].seat.vtype + "		Free Seats:" + Integer.toString(T[0].seat.getFreeSeats())+ "		Date:" + T[0].date + "		Time:" + T[0].time +		" 	Price for one ticket:" + Float.toString(T[0].ticket));
			i++;
		}
		return results;
	}
	
	public void searchTableInit() {
		String [] results = showResults();
		int i = 0;
		while(results[i] != null) {
			searchView.getItems().add(results[i]);
			i++;
		}
	}

	
	public void searchButtonClicked(ActionEvent e) {
		searchTableInit();
		searchResultPane.setVisible(true);
		SearchTabs.setVisible(false);
		PassengerTabs.setVisible(false);
		instr.setVisible(false);
		
	}
	
	public void choiceReset() {
		type.setValue(null);
		start.setValue(null);
		destination.setValue(null);
		date.setValue(null);		
	}
	
	public void returnSearchTab(ActionEvent e) {
		choiceReset();
		SearchTabs.setVisible(true);
		PassengerTabs.setVisible(true);
		instr.setVisible(true);
		searchResultPane.setVisible(false);
	}

//--------------- Booking a Trip ---------------\\


	
	
	
//--------------- Trips Schedule Tab ---------------\\

	public void SelectTrip (ActionEvent e) throws IOException
	{
		LabelChoose.setVisible(true);
		back.setVisible(true);
		if(line1.getTypeSelector() != null)
		{
			Trip1.setVisible(true);
		}
		if(line2.getTypeSelector() != null)
		{
			Trip2.setVisible(true);
		}
		if(line3.getTypeSelector() != null)
		{
			Trip3.setVisible(true);
		}
		SearchTabs.setVisible(false);
		instr.setVisible(false);
		PassengerTabs.setVisible(false);
		
	}
	public void BackMainTab (ActionEvent e) throws IOException
	{
		
		SearchTabs.setVisible(true);
		instr.setVisible(true);
		PassengerTabs.setVisible(true);
		Trip1.setVisible(false);
		Trip2.setVisible(false);
		Trip3.setVisible(false);
		LabelChoose.setVisible(false);
		back.setVisible(false);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choiceInit();
	}

}