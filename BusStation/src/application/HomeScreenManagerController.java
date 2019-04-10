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
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeScreenManagerController implements Initializable {
	
	int index, ID;
	Manager M;
	Driver D[];
	static Database d = new Database();
	String uStart, uDest, uCar, uCarnum, uDriver, uTime, uTicket;
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
	public ChoiceBox<String> startL2;
	public ChoiceBox<String> DestL;
	public ChoiceBox<String> Driver2;
	public ChoiceBox<String> Driver;
	public ChoiceBox<String> car2;
	public ChoiceBox<String> car;
	public ChoiceBox<String> carNo;
	public ChoiceBox<String> carNo2;
	public DatePicker date;
	public TextField ticket, ticket2;
	public TextField Time1, Time2, Time12, Time22;
	public ListView<String> Table;
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
	public ChoiceBox<String> DestL2;
	public DatePicker date2;
	public AnchorPane UpdateTrips;
	private String dateGet;
	private String time;


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	trip = d.T;
	initTable();	
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
	String[] tripData = getTrips();
	int i = 0;
	while (tripData[i] != null) {
		Table.getItems().add(tripData[i]);
		i++;
	}
	
}
	 
public String[] getTrips(){
	int i=0;
	String ID, ticketData, tripData, vnumb;
	String [] tripsView = new String[100];
	while(d.T[i] != null) {
		ID = Integer.toString(d.T[i].ID);
		vnumb = Integer.toString(d.T[i].vnum);
		ticketData = Float.toString(d.T[i].ticket);
		tripData = (ID + " " + d.T[i].start + " " + d.T[i].destination + " " + d.T[i].vmodel + " " + vnumb + " " + d.T[i].date + " " + d.T[i].time + " " + ticketData);
		tripsView[i] = tripData;
		i++;
	}
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

	public void cancelTripButtonClicked(ActionEvent e) throws IOException {
		displayDialogueBox("MESSAGE ALERT", "Are you sure you want to cancel the selected trip?", "Yes", "Abort", Table.getSelectionModel().getSelectedIndex());
		Table.getItems().clear();
		initTable();
	}
	
	public static void displayDialogueBox(String title, String message, String buttonTxt, String buttonTxt2, int index) {
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(300);
		window.initModality(Modality.APPLICATION_MODAL);
		HBox internalLayout = new HBox(10);
		Button Button1 = new Button(buttonTxt);
		Button Button2 = new Button(buttonTxt2);
		internalLayout.getChildren().addAll(Button1, Button2);
		internalLayout.setAlignment(Pos.CENTER);
		Label error = new Label(message);
		Button1.setOnAction(e-> window.close());
		Button2.setOnAction(e-> {
			try {
				d.cancelTrip(index);
				
			} catch (IOException e1) {
				System.out.println("Error in cancelTrip");
				e1.printStackTrace();
			}
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(error, internalLayout);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static void displayDialogueBoxUpdate(String title, String message, String buttonTxt, String buttonTxt2, int index) {
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(600);
		window.setMinHeight(600);
		window.initModality(Modality.APPLICATION_MODAL);
		HBox internalLayout = new HBox(10);
		Button Button1 = new Button(buttonTxt);
		Button Button2 = new Button(buttonTxt2);
		internalLayout.getChildren().addAll(Button1, Button2);
		internalLayout.setAlignment(Pos.CENTER);
		Label error = new Label(message);
		Button1.setOnAction(e-> window.close());
		Button2.setOnAction(e-> {
			try {
				d.cancelTrip(index);
			} catch (IOException e1) {
				System.out.println("Error in cancelTrip");
				e1.printStackTrace();
			}
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(error, internalLayout);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	

	public void updateTripsButtonClicked() throws IOException {
		if(Table.getSelectionModel().getSelectedIndex() == -1) {
			AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you selected a trip!", "OK");
		}
		else {
			index = Table.getSelectionModel().getSelectedIndex();
			ID = d.T[index].ID;
			String[] time1;
			String timedata;
			timedata=d.T[index].time;
			time1=timedata.split(":");
			UpdateTrips.setVisible(true);
			editTitle.setVisible(false);
			editFull.setVisible(false);
			Table.setVisible(false);
			dateGet = d.T[index].date;
			updateInit(ID, d.T[index].start, d.T[index].destination, d.T[index].vmodel, Integer.toString(d.T[index].vnum), dateGet, time1[0], time1[1], Float.toString(d.T[index].ticket), d.T[index].driverName, index);
		}
	}
	
	public void updateInit(int ID, String start, String dest, String v, String vnum, String date, String time1, String time2, String tick, String select, int ind) {
		
		uStart = start;
		uDest = dest;
		uCar = v;
		uCarnum = vnum;
		time = (time1 + ":" + time2);
		uTicket = tick;
		uDriver = select;
		startL2.getItems().addAll("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "District10");
		startL2.setValue(start);
		DestL2.getItems().addAll("District1","District2","District3","District4","District5","District6","District7","District8", "District9", "District10");
		DestL2.setValue(dest);
		int i = 0;
		while(D[i] != null) {
			Driver2.getItems().add(D[i].username);
			i++;
		}
		Driver2.setValue(select);
		car2.getItems().addAll("KiaGranbird","MercedesCito","VolvoB12","ToyotaHiAce","HyundaiEquus");
		car2.setValue("KiaGranbird");
		carNo2.getItems().add(vnum);
		Time12.setText(time1);
		Time22.setText(time2);
	}

	public void closeClicked(ActionEvent e) {
		editTitle.setVisible(true);
		editFull.setVisible(true);
		Table.setVisible(true);
		UpdateTrips.setVisible(false);

	}
	
	public void updateButtonClicked(ActionEvent e) throws IOException {
			if(date2.getValue() != null) {
				dateGet = this.date2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			if(Time12.getText() != null && Time22.getText() != null) {
				 time = (Time12.getText() + ":" + Time22.getText());
			}
			 if(startL2.getValue() != null) {
				  uStart = startL2.getValue();
			 }
			 if(DestL2.getValue() != null) {
				 uDest = DestL2.getValue();
			 }
			 if(car2.getValue() != null) {
				 uCar = car2.getValue();
			 }
			 if(carNo2.getValue() != null) {
				 uCarnum = carNo2.getValue();
			 }
			 if(Driver2.getValue() != null) {
				 uDriver = Driver2.getValue();
			 }
			 Seat s;
			 Vehicle v = new Vehicle(uCar);
			 s = v.s;
			 System.out.println(ID + uStart + uDest + uCar + Integer.parseInt(uCarnum) + uDriver + dateGet + time + Float.parseFloat(uTicket));
			 System.out.println(s.capacity);
			 Trip T = new Trip(ID, uStart, uDest, uCar, Integer.parseInt(uCarnum), uDriver, dateGet, time, Float.parseFloat(uTicket), s);
			 d.T[index] = T;
			 System.out.println(index);
			 d.saveTripData();
	}
	
}