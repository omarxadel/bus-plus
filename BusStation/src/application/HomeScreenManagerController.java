package application;



import Model.*;
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

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeScreenManagerController implements Initializable {
	
	static boolean flag = false;
	int index, ID, currentuserInd;
	Manager M;
	Model.Driver D[];
	static Database d = new Database();
	int userIndex;
	String uStart, uDest, uCar, uCarnum, uDriver, uTime, uTicket;
	public AnchorPane editProfile, ManagerDb, managerEdit;
	public AnchorPane DriveAddFull, DriverEdit;
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
	public ChoiceBox<String> ttype, ttype1;
	public DatePicker date;
	public TextField ticket, ticket2;
	public TextField Time1, Time2, Time12, Time22;
	public TextField FirstnameManager,LastnameManager,UsernameManager,CityManager,CountryManager;
	public PasswordField PasswordManager, RepassManager;
	public ChoiceBox<String> GenderManager;
	public ListView<String> Table;
	public ListView<String> Table2, managerTable;
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
	public TextField FirstnameAdd, LastnameAdd, UsernameAdd , PasswordAdd, RepassAdd, CityAdd, CountryAdd;
	public TextField FirstnameAdd1, LastnameAdd1, UsernameAdd1 , PasswordAdd1, RepassAdd1, CityAdd1, CountryAdd1;
	public ChoiceBox<String> GenderAdd1;
	private String uType;
	public AnchorPane managerUpdate;


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	trip = d.T;
	initTable();
	updateDataInit();
	initTableDriver();
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
	
	public void initEditProfile() {
		FirstnameManager.setText(M.firstname);
		LastnameManager.setText(M.lastname);
		UsernameManager.setText(M.username);
		PasswordManager.setText(M.getPassword());
		RepassManager.setText(M.getPassword());
		CityManager.setText(M.city);
		CountryManager.setText(M.country);
		GenderManager.getItems().addAll("Male", "Female");
		GenderManager.setValue(M.gender);
	}
	
	public void toEditprofileClicked(ActionEvent e) {
		initEditProfile();
		editProfile.setVisible(true);
		ProfTitle.setVisible(false);
		ProfFull.setVisible(false);
	}
	
	public void returnFromEditProfile(ActionEvent e) {
		getProfile(d.M[currentuserInd]);
		ProfTitle.setVisible(true);
		ProfFull.setVisible(true);
		editProfile.setVisible(false);
	}
	
	public static void displayDialogueBox(String title, String message, String buttonTxt, String buttonTxt2) {
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinWidth(300);
		window.initModality(Modality.APPLICATION_MODAL);
		HBox internalLayout = new HBox(10);
		Button Button2 = new Button(buttonTxt);
		Button Button1 = new Button(buttonTxt2);
		internalLayout.getChildren().addAll(Button1, Button2);
		internalLayout.setAlignment(Pos.CENTER);
		Label error = new Label(message);
		Button1.setOnAction(e->{
			flag = false;
			window.close();
			});
		
		Button2.setOnAction(e-> {
			flag = true;
			window.close();
		});
		VBox layout = new VBox(10);
		layout.getChildren().addAll(error, internalLayout);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public void saveProfileEditClicked(ActionEvent e) throws IOException {
		displayDialogueBox("MESSAGE","Are you sure you want to update the saved data?","Yes","No");
		if(flag) {
		if(FirstnameManager.getText() == null || LastnameManager.getText() == null || UsernameManager.getText() == null || PasswordManager.getText() == null || CityManager.getText() == null || CountryManager.getText() == null || GenderManager.getValue() == null) {
			if(FirstnameManager.getText().equals(null) || LastnameManager.getText().equals(null) || UsernameManager.getText().equals(null) || PasswordManager.getText().equals(null) || CityManager.getText().equals(null) || CountryManager.getText().equals(null) || GenderManager.getValue().equals(null)) {
				AlertBox.display("UNEXPECTED INPUTS!", "Make sure you fill in all the fields!", "OK");
			}
		}
		M.firstname = FirstnameManager.getText();
		M.lastname = LastnameManager.getText();
		M.username = UsernameManager.getText();
		M.setPassword(PasswordManager.getText());
		M.city = CityManager.getText();
		M.country = CountryManager.getText();
		M.gender = GenderManager.getValue();
		d.M[userIndex] = M;
		d.saveManagerData();
		AlertBox.display("SUCCESS", "Account has been updated successfully!", "OK");
		returnFromEditProfile(e);
		
		}
		else return;
		
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

	public boolean isTicketPrice(String ticketInput) {
		try {
			Float.parseFloat(ticketInput);
			return true;
		}
		catch(NumberFormatException exception) {
			return false;
		}
	}
	// --------------- Add Trips Controls ------------\\
	
	public void choiceInit() {
		ttype.getItems().addAll("One-Way", "Round-Trip");
		ttype.setValue("One-Way");
		startL.getItems().addAll(d.location.getLocations());
		startL.setValue("Brussels");
		DestL.getItems().addAll(d.location.getLocations());
		DestL.setValue("Amsterdam");
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
	
	public void choiceReset() {
		ttype.setValue("One-Way");
		startL.setValue("District1");
		DestL.setValue("District10");
		car.setValue("KiaGranbird");
		carNo.setValue("12345");
		Time1.setText(null);
		Time2.setText(null);
		ticket.setText(null);
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
		 boolean flag = false, flag2 = false;
		 Trip T = null;
		 if(this.date.getValue() == null || startL.getValue() == null || DestL.getValue() == null || Driver.getValue() == null || car.getValue() == null || carNo.getValue() == null || ticket.getText() == null || Time1.getText() == (null) || Time2.getText() == (null) || ticket.getText().isEmpty() || Time1.getText().isEmpty() || Time2.getText().isEmpty()) {
			 AlertBox.display("UNEXPECTED INPUTS", "Please make sure you filled all the fields!", "OK");
		 }
		 else if(!isTicketPrice(ticket.getText())) {
			 AlertBox.display("UNEXPECTED INPUTS", "Please make sure you enter a vaid ticket price!", "OK");
		 }
		 else {
		 String date = this.date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		 String time;
		 int timevalid1 = 0, timevalid2 = 0;
		 try {
			 timevalid1 = Integer.parseInt(Time1.getText());
			 timevalid2 = Integer.parseInt(Time2.getText());
			if(timevalid1 > 13 || timevalid2 > 60) flag2=true;
			else flag = true;
		 }
		 catch(NumberFormatException exception) {
			 AlertBox.display("UNEXPECTED INPUT!", "You have to insert a valid time input!", "OK");
			 Time1.setText(null);
			 Time2.setText(null);
		 }
		 String txttime = null, txttime2=null;
		 if(flag) {
			 if(timevalid1 < 10) {
					txttime = ("0" + Integer.toString(timevalid1));
				}
			 else txttime = Integer.toString(timevalid1);
			 if(timevalid2 < 10) {
					txttime2 = ("0" + Integer.toString(timevalid2));
				}
			 else txttime2 = Integer.toString(timevalid2);
			time = ("" + txttime + ":" + txttime2);
			
			T = d.addTripData(ttype.getValue(), startL.getValue(), DestL.getValue(), car.getValue(), carNo.getValue(), Driver.getValue(), date, time, ticket.getText());
			Table.getItems().add(Integer.toString(T.ID) + " " + T.type + " " + T.start + " " + T.destination + " " + (T.vmodel) + " " + Integer.toString(T.vnum)+ " " + T.driverName + " " + T.date + " " + T.time + " " + Float.toString(T.ticket));
			AlertBox.display("SUCCESS", "A new trip was added susccessfully!", "OK");
			choiceReset();
			}
		 else if(flag2) {
			 AlertBox.display("UNEXPECTED INPUT!", "You have to insert a valid time input!", "OK");
			 Time1.setText(null);
			 Time2.setText(null);
		 }
		 }
		 
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
				tripData = (ID + " " + d.T[i].type + " " + d.T[i].start + " " + d.T[i].destination + " " + d.T[i].vmodel + " " + vnumb + " " + d.T[i].driverName + " " + d.T[i].date + " " + d.T[i].time + " " + ticketData);
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
		if(flag) {
			Table.getItems().remove(Table.getSelectionModel().getSelectedIndex());
		}
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
		Button2.setOnAction(e->{
			window.close();
			flag = false;
			});
		
		Button1.setOnAction(e-> {
			try {
				d.cancelTrip(index);
				flag = true;
				window.close();
				
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
			updateInit(ID, d.T[index].type , d.T[index].start, d.T[index].destination, d.T[index].vmodel, Integer.toString(d.T[index].vnum) ,dateGet, time1[0], time1[1], Float.toString(d.T[index].ticket), d.T[index].driverName, index);
		}
	}
	
	
	public void updateDataInit() {
		ttype1.getItems().addAll("One-Way", "Round-Trip");
		startL2.getItems().addAll(d.location.getLocations());
		DestL2.getItems().addAll(d.location.getLocations());
		int i = 0;
		while(d.D[i] != null) {
			Driver2.getItems().add(d.D[i].username);
			i++;
		}
		car2.getItems().addAll("KiaGranbird","MercedesCito","VolvoB12","ToyotaHiAce","HyundaiEquus");
		i = 0;
		while(d.T[i] != null) {
			carNo2.getItems().add(Integer.toString(d.T[i].vnum));
			i++;
		}
	}
	
	
	public void updateInit(int ID, String type, String start, String dest, String v, String vnum, String date, String time1, String time2, String tick, String select, int ind) {
		uType = type;
		uStart = start;
		uDest = dest;
		uCar = v;
		uCarnum = vnum;
		time = (time1 + ":" + time2);
		uTicket = tick;
		uDriver = select;
		ttype1.setValue(type);
		startL2.setValue(start);
		DestL2.setValue(dest);
		Driver2.setValue(select);
		car2.setValue("KiaGranbird");
		Time12.setText(time1);
		Time22.setText(time2);
		ticket2.setText(uTicket);
	}

	public void closeClicked(ActionEvent e) {
		editTitle.setVisible(true);
		editFull.setVisible(true);
		Table.setVisible(true);
		UpdateTrips.setVisible(false);

	}
	
	public void updateButtonClicked(ActionEvent e) throws IOException {
		do AlertBox.display("UNEXPECTED INPUT", "Please enter a valid ticket price!", "OK");
		while(!isTicketPrice(ticket2.getText()));
		
			if(date2.getValue() != null) {
				dateGet = this.date2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			if(Time12.getText() != null && Time22.getText() != null) {
				 time = (Time12.getText() + ":" + Time22.getText());
			}
			 if(startL2.getValue() != null) {
				  uStart = startL2.getValue();
			 }
			 if(DestL2.getValue() != (null)) {
				 uDest = DestL2.getValue();
			 }
			 if(car2.getValue() != (null)) {
				 uCar = car2.getValue();
			 }
			 if(carNo2.getValue() != (null)) {
				 uCarnum = carNo2.getValue();
			 }
			 if(Driver2.getValue() != (null)) {
				 uDriver = Driver2.getValue();
			 }
			 if(ticket2.getText() != (null)) {
				 uTicket = ticket2.getText();
			 }
			 uType = ttype1.getValue();
			 Seat s;
			 s = new Vehicle(uCar).s;
			 Trip T = new Trip(ID, uType, uStart, uDest, uCar, Integer.parseInt(uCarnum), uDriver, dateGet, time, Float.parseFloat(uTicket), s);
			 d.T[index] = T;
			 d.saveTripData();
			 Table.getItems().remove(index);
			 String tripData = (ID + " " + uType + " " + uStart + " " + uDest + " " + uCar + " " + uCarnum + " " + uDriver + " " + dateGet + " " + time + " " + uTicket);
			 Table.getItems().add(index, tripData);
			 AlertBox.display("SUCCESS", "Trips were updated successfully!", "Return");
			 editTitle.setVisible(true);
			 Table.setVisible(true);
			 editFull.setVisible(true);
			 UpdateTrips.setVisible(false);
			 
	}
	
	// --------------- Manage Driver Controls ------------\\
	

	public void manageDriverButtonClicked(ActionEvent e) {
		DriveAddFull.setVisible(true);
		Table2.setVisible(true);
		MainTabManager.setVisible(false);
	}
	
	public void initTableDriver() {
		String[] driverData = getDrivers();
		int i = 0;
		while (driverData[i] != null) {
			Table2.getItems().add(driverData[i]);
			i++;
		}
		
	}
		 
	public String[] getDrivers(){
		int i=0;
		String ID, driverData;
		String [] driverView = new String[100];
		while(d.D[i] != null) {
			ID = Integer.toString(d.D[i].ID);
			driverData = (d.D[i].firstname + " " + d.D[i].lastname + " " + d.D[i].username+ " " + ID + " " + d.D[i].city + " " + d.D[i].country);
			driverView[i] = driverData;
			i++;
		}
		return driverView;
	}

		public void returnManageDriverClicked(ActionEvent e) {
			MainTabManager.setVisible(true);
			DriveAddFull.setVisible(false);
			Table2.setVisible(false);
		}

		public void removeDriverButtonClicked(ActionEvent e) throws IOException {
			displayDialogueBoxDriver("MESSAGE ALERT", "Are you sure you want to remove the selected driver?", "Abort", "Yes", Table2.getSelectionModel().getSelectedIndex());
			if(flag) {
				Table2.getItems().remove(Table2.getSelectionModel().getSelectedIndex());
				AlertBox.display("SUCCESS", "Your Trip was removed successfully!", "OK");
			}
		}
		
		public static void displayDialogueBoxDriver(String title, String message, String buttonTxt, String buttonTxt2, int index) {
			Stage window = new Stage();
			window.setTitle(title);
			window.setMinWidth(300);
			window.initModality(Modality.APPLICATION_MODAL);
			HBox internalLayout = new HBox(10);
			Button Button2 = new Button(buttonTxt);
			Button Button1 = new Button(buttonTxt2);
			internalLayout.getChildren().addAll(Button1, Button2);
			internalLayout.setAlignment(Pos.CENTER);
			Label error = new Label(message);
			Button2.setOnAction(e-> {
				flag=false;
			window.close();}
					);
			Button1.setOnAction(e-> {
				try {
					d.removeDriver(index);
					flag=true;
					window.close();
					
				} catch (IOException e1) {
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
		

		public void editDriverButtonClicked() throws IOException {
				
				DriverEdit.setVisible(true);
				Table2.setVisible(false);
				DriveAddFull.setVisible(false);
				
				index = Table2.getSelectionModel().getSelectedIndex();
				if(index == -1) {
				}
				else {				
				editDriverInit(d.D[index].firstname, d.D[index].lastname, d.D[index].username, d.D[index].getPassword(), d.D[index].city, d.D[index].country);
				}
		}
		
		public void editDriverInit(String fname, String lname, String username, String password, String city, String country) {
			FirstnameAdd.setText(fname);
			LastnameAdd.setText(lname);
			UsernameAdd.setText(username);
			PasswordAdd.setText(password);
			CityAdd.setText(city);
			CountryAdd.setText(country);
		}
		
		public void editDriverReset() {
			FirstnameAdd.setText(null);
			LastnameAdd.setText(null);
			UsernameAdd.setText(null);
			PasswordAdd.setText(null);
			RepassAdd.setText(null);
			CityAdd.setText(null);
			CountryAdd.setText(null);
		}

		public void closeDriverOutClicked(ActionEvent e) {
			MainTabManager.setVisible(true);
			Table2.setVisible(false);
			DriveAddFull.setVisible(false);
		}
		
		public void returnDriverInClicked(ActionEvent e) {
			Table2.setVisible(true);
			DriveAddFull.setVisible(true);
			DriverEdit.setVisible(false);
		}
		
		public void updateDriverClicked(ActionEvent e) throws IOException {
			if(index == -1) {
				AlertBox.display("ERROR", "Can't update user if you didn't select one!", "OK");
			}
			else {
			if(FirstnameAdd.getText()==null || LastnameAdd.getText() == null || PasswordAdd.getText() == null || RepassAdd.getText() == null || CityAdd.getText() == null || CountryAdd.getText() == null || FirstnameAdd.getText().isEmpty() || PasswordAdd.getText().isEmpty() || RepassAdd.getText().isEmpty() || CityAdd.getText().isEmpty()|| CountryAdd.getText( ).isEmpty()) {
				AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you fill in all the fields!", "OK");
			}
			else if (!PasswordAdd.getText().equals(RepassAdd.getText())) {
					AlertBox.display("UNEXPECTED INPUTS!", "Please re-enter the password correctly", "OK");
				}
			else{ Driver D = new Driver(FirstnameAdd.getText(), LastnameAdd.getText(), UsernameAdd.getText() ,PasswordAdd.getText(), d.D[index].ID , CityAdd.getText(), CountryAdd.getText(), "Driver");
				d.D[index] = D;
				d.saveDriversData();
				Table2.getItems().remove(index);
				String DriverData = (FirstnameAdd.getText() + " " + LastnameAdd.getText() + " " + UsernameAdd.getText() + " " + d.D[index].ID + " "  + CityAdd.getText() + " " +  CountryAdd.getText());
				Table2.getItems().add(index, DriverData);
				AlertBox.display("SUCCESS", "Selected Driver was updated successfully!", "Return");
				editDriverReset();
				Table2.setVisible(true);
				DriveAddFull.setVisible(true);
				DriverEdit.setVisible(false);
			}
			}
			
		}
		public void saveAsClicked(ActionEvent e) throws IOException {
				if(FirstnameAdd.getText()==null || LastnameAdd.getText() == null || PasswordAdd.getText() == null || RepassAdd.getText() == null || CityAdd.getText() == null || CountryAdd.getText() == null || FirstnameAdd.getText().isEmpty() || PasswordAdd.getText().isEmpty() || RepassAdd.getText().isEmpty() || CityAdd.getText().isEmpty()|| CountryAdd.getText( ).isEmpty()) {
					AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you fill in all the fields!", "OK");
				}
				else if(!PasswordAdd.getText().equals(RepassAdd.getText())) {
					AlertBox.display("UNEXPECTED INPUTS!", "Please re-enter the password correctly", "OK");
				}
				else {
					d.addDriver(FirstnameAdd.getText(), LastnameAdd.getText(), UsernameAdd.getText() ,PasswordAdd.getText(), CityAdd.getText(), CountryAdd.getText());
					int i=0;
					while(d.D[i] != null) {
						i++;
					}
					String DriverData = (FirstnameAdd.getText() + " " + LastnameAdd.getText() + " " + UsernameAdd.getText() + " " + d.D[i-1].ID + " "  + CityAdd.getText() + " " +  CountryAdd.getText());
					Table2.getItems().add(DriverData);
				
				AlertBox.display("SUCCESS", "New Driver was added successfully!", "Return");
				editDriverReset();
				Table2.setVisible(true);
				DriveAddFull.setVisible(true);
				DriverEdit.setVisible(false);
				}
			}
		
	// --------------- Manage Admin Controls ------------\\
		
		
			public void initTableManager() {
				String[] managerData = getManagers();
				int i = 0;
				while (managerData[i] != null) {
					managerTable.getItems().add(managerData[i]);
					i++;
				}		
		
	}
		 
	public String[] getManagers(){
		int i=0;
		String ID, managerData;
		String [] managerView = new String[100];
		while(d.M[i] != null) {
			if(d.M[i].username == M.username) {
				i++;
				System.out.println(i);
			}
			else {
			ID = Integer.toString(d.M[i].ID);
			managerData = (d.M[i].firstname + " " + d.M[i].lastname + " " + d.M[i].username+ " " + ID + " " + d.M[i].city + " " + d.M[i].country);
			managerView[i] = managerData;
			i++;
		}}
		return managerView;
	}
	
	

		
		
			public void manageManagersButtonClicked(ActionEvent e) {
				initTableManager();
				ManagerDb.setVisible(true);
				managerTable.setVisible(true);
				MainTabManager.setVisible(false);
			}

			public void returnManageManagerClicked(ActionEvent e) {
				MainTabManager.setVisible(true);
				ManagerDb.setVisible(false);
				managerTable.setVisible(false);
			}

			public void removeManagerButtonClicked(ActionEvent e) throws IOException {
				displayDialogueBoxDriver("MESSAGE ALERT", "Are you sure you want to remove the selected account?", "Abort", "Yes", Table2.getSelectionModel().getSelectedIndex());
				if(flag) {
					managerTable.getItems().remove(managerTable.getSelectionModel().getSelectedIndex());
				}
			}
			
			public static void displayDialogueBoxManager(String title, String message, String buttonTxt, String buttonTxt2, int index) {
				Stage window = new Stage();
				window.setTitle(title);
				window.setMinWidth(300);
				window.initModality(Modality.APPLICATION_MODAL);
				HBox internalLayout = new HBox(10);
				Button Button2 = new Button(buttonTxt);
				Button Button1 = new Button(buttonTxt2);
				internalLayout.getChildren().addAll(Button1, Button2);
				internalLayout.setAlignment(Pos.CENTER);
				Label error = new Label(message);
				Button2.setOnAction(e-> {
					flag=false;
				window.close();}
						);
				Button1.setOnAction(e-> {
					try {
						d.removeManager(index);
						flag=true;
						window.close();
						
					} catch (IOException e1) {
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
			

			public void editManagerButtonClicked() throws IOException {
					
					
					
					index = managerTable.getSelectionModel().getSelectedIndex();
					if(index == -1) {
						AlertBox.display("Error","Please make sure you select a manager!", "OK");
						return;
					}
					else {
						
					editManagerInit(d.M[index].firstname, d.M[index].lastname, d.M[index].username, d.M[index].getPassword(), d.M[index].city, d.M[index].country, d.M[index].gender);
					managerUpdate.setVisible(true);
					managerTable.setVisible(false);
					ManagerDb.setVisible(false);
					}
			}
			
			public void editManagerInit(String fname, String lname, String username, String password, String city, String country, String gender) {
				FirstnameAdd1.setText(fname);
				LastnameAdd1.setText(lname);
				UsernameAdd1.setText(username);
				PasswordAdd1.setText(password);
				CityAdd1.setText(city);
				CountryAdd1.setText(country);
				GenderAdd1.getItems().addAll("Male", "Female");
				GenderAdd1.setValue(gender);
			}
			
			public void editManagerReset() {
				FirstnameAdd1.setText(null);
				LastnameAdd1.setText(null);
				UsernameAdd1.setText(null);
				PasswordAdd1.setText(null);
				RepassAdd1.setText(null);
				CityAdd1.setText(null);
				CountryAdd1.setText(null);
			}

			public void closeManagerOutClicked(ActionEvent e) {
				MainTabManager.setVisible(true);
				managerTable.setVisible(false);
				ManagerDb.setVisible(false);
			}
			
			public void returnManagerInClicked(ActionEvent e) {
				managerTable.setVisible(true);
				ManagerDb.setVisible(true);
				managerUpdate.setVisible(false);
			}
			
			public void updateManagerClicked(ActionEvent e) throws IOException {
				if(index == -1) {
					AlertBox.display("ERROR", "Can't update user if you didn't select one!", "OK");
				}
				else {
				if(FirstnameAdd1.getText()==null || LastnameAdd1.getText() == null || PasswordAdd1.getText() == null || RepassAdd1.getText() == null || CityAdd1.getText() == null || CountryAdd1.getText() == null || FirstnameAdd1.getText().isEmpty() || PasswordAdd1.getText().isEmpty() || RepassAdd1.getText().isEmpty() || CityAdd1.getText().isEmpty()|| CountryAdd1.getText( ).isEmpty()) {
					AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you fill in all the fields!", "OK");
				}
				else if (!PasswordAdd1.getText().equals(RepassAdd1.getText())) {
						AlertBox.display("UNEXPECTED INPUTS!", "Please re-enter the password correctly", "OK");
					}
				else{ Manager M = new Manager(FirstnameAdd1.getText(), LastnameAdd1.getText(), UsernameAdd1.getText() ,PasswordAdd1.getText(), d.M[index].ID , CityAdd1.getText(), CountryAdd1.getText(), "Manager", GenderAdd1.getValue());
					d.M[index] = M;
					d.saveManagerData();
					managerTable.getItems().remove(index);
					String ManagerData = (FirstnameAdd1.getText() + " " + LastnameAdd1.getText() + " " + UsernameAdd1.getText() + " " + d.M[index].ID + " "  + CityAdd1.getText() + " " +  CountryAdd1.getText());
					managerTable.getItems().add(index, ManagerData);
					AlertBox.display("SUCCESS", "Selected account was updated successfully!", "Return");
					editManagerReset();
					managerTable.setVisible(true);
					ManagerDb.setVisible(true);
					managerUpdate.setVisible(false);
				}
				}
				
			}
			public void saveAsManagerClicked(ActionEvent e) throws IOException {
					if(FirstnameAdd1.getText()==null || LastnameAdd1.getText() == null || PasswordAdd1.getText() == null || RepassAdd1.getText() == null || CityAdd1.getText() == null || CountryAdd1.getText() == null || FirstnameAdd1.getText().isEmpty() || PasswordAdd1.getText().isEmpty() || RepassAdd1.getText().isEmpty() || CityAdd1.getText().isEmpty()|| CountryAdd1.getText( ).isEmpty()) {
						AlertBox.display("UNEXPECTED INPUTS!", "Please make sure you fill in all the fields!", "OK");
					}
					else if(!PasswordAdd1.getText().equals(RepassAdd1.getText())) {
						AlertBox.display("UNEXPECTED INPUTS!", "Please re-enter the password correctly", "OK");
					}
					else {
						d.addManagerData(FirstnameAdd1.getText(), LastnameAdd1.getText(), UsernameAdd1.getText() ,PasswordAdd1.getText(), CityAdd1.getText(), CountryAdd1.getText(), GenderAdd1.getValue());
						int i=0;
						while(d.M[i] != null) {
							i++;
						}
						String ManagerData = (FirstnameAdd1.getText() + " " + LastnameAdd1.getText() + " " + UsernameAdd1.getText() + " " + d.M[i-1].ID + " "  + CityAdd1.getText() + " " +  CountryAdd1.getText());
						managerTable.getItems().add(ManagerData);
					
					AlertBox.display("SUCCESS", "New account was added successfully!", "Return");
					editManagerReset();
					managerTable.setVisible(true);
					ManagerDb.setVisible(true);
					managerUpdate.setVisible(false);
					}
				}
		
}