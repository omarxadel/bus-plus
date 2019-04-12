package application;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class HomeScreenController implements Initializable {

	String [] promocode = new String [5];
	float totalCheck = 0;
	static PaymentMethod pay;
	Ticket new_Ticket;
	Ticket [] unpaidTickets;
	static Reservation reserve = new Reservation();
	public AnchorPane editProfile;
	Trip reservedTrip;
	static boolean flag;
	String [] seatsChosen;
	//Manager M;
	Passenger P;
	int currentuserIndex;
	Seat s;
	Stage stage;
	Scene scene;
	public Trip[] trip;
	//Driver D;
	static Database d = new Database();
	public AnchorPane Trip1, booking, myTripsPane, searchAnc;
	public AnchorPane payment;
	public AnchorPane Editacc;
	public AnchorPane searchResultPane;
	public Button PromoCodes;
	public Button PassengerProfileButton;
	public Button SeatingOptions;
	public Button Service;
	public Button Settings;
	public Button back;
	//public Button EditAccount;
	public TextField FirstnameManager,LastnameManager,UsernameManager,CityManager,CountryManager;
	public PasswordField PasswordManager, RepassManager;
	public ChoiceBox<String> GenderManager;
	public Button ReturnProf;
	public MenuItem OnewayOption;
	public MenuItem Round;
	public MenuItem line1;
	public MenuItem line2;
	public MenuItem line3;
	public VBox PassengerTabs;
	public Label WelcomeLabel;
	public Label checkTotal;
	public AnchorPane ProfFull;
	public Label Fname;
	public Label Country;
	public Label ID;
	public VBox ProfTitle;
	public VBox SearchTabs;
	public VBox LabelChoose;
	public TextField seatingTxt;
	public ChoiceBox<String> type;
	public ChoiceBox<String> start;
	public ChoiceBox<String> destination;
	public DatePicker date;
	public ListView<String> searchView;
	public ListView<String> purchaseView, myTrips;
	private Trip [] resultTrips;
	private String [] results;
	public Label startDestLabel, timeLabel, dateLabel, priceLabel, seatsLabel;
	private Ticket[] upaid;
	private Ticket[] resultTickets;
	private String[] Ticketresults;
	int instr;
	private int pIndex;
	
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
		SearchTabs.setVisible(false);
		PassengerTabs.setVisible(false);
		
		
	}
	
	
	public void customerService(ActionEvent e) {
		AlertBox.display("CUSTOMER SERVICE", "You can contact us directly through our email: busPlus@bplus.com", "OK");
	}

	public void returnProfButtonClicked (ActionEvent e)
	{   
		SearchTabs.setVisible(true);
		PassengerTabs.setVisible(true);
		ProfFull.setVisible(false);
		ProfTitle.setVisible(false);

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
		seatingTxt.setText("");
		SeatsDesign.display(reservedTrip, reservedTrip.seat.capacity);
		seatsChosen = SeatsDesign.getSeatsChosen();		
	}
	public Scene getScene() {
		return scene;
	}

	// --------------- Editing Profile Info ---------------\\
	
	public void initEditProfile() {
		FirstnameManager.setText(P.firstname);
		LastnameManager.setText(P.lastname);
		UsernameManager.setText(P.username);
		PasswordManager.setText(P.getPassword());
		RepassManager.setText(P.getPassword());
		CityManager.setText(P.city);
		CountryManager.setText(P.country);
		GenderManager.getItems().addAll("Male", "Female");
		GenderManager.setValue(P.gender);
	}
	
	public void toEditprofileClicked(ActionEvent e) {
		initEditProfile();
		editProfile.setVisible(true);
		ProfTitle.setVisible(false);
		ProfFull.setVisible(false);
	}
	
	public void returnFromEditProfile(ActionEvent e) {
		getProfile(d.P[currentuserIndex]);
		ProfTitle.setVisible(true);
		ProfFull.setVisible(true);
		editProfile.setVisible(false);
	}
	
	public static void displayDialogueBoxEdit(String title, String message, String buttonTxt, String buttonTxt2) {
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
		displayDialogueBoxEdit("MESSAGE","Are you sure you want to update the saved data?","Yes","No");
		if(flag) {
		if(FirstnameManager.getText() == null || LastnameManager.getText() == null || UsernameManager.getText() == null || PasswordManager.getText() == null || CityManager.getText() == null || CountryManager.getText() == null || GenderManager.getValue() == null) {
			if(FirstnameManager.getText().equals(null) || LastnameManager.getText().equals(null) || UsernameManager.getText().equals(null) || PasswordManager.getText().equals(null) || CityManager.getText().equals(null) || CountryManager.getText().equals(null) || GenderManager.getValue().equals(null)) {
				AlertBox.display("UNEXPECTED INPUTS!", "Make sure you fill in all the fields!", "OK");
			}
		}
		P.firstname = FirstnameManager.getText();
		P.lastname = LastnameManager.getText();
		P.username = UsernameManager.getText();
		P.setPassword(PasswordManager.getText());
		P.city = CityManager.getText();
		P.country = CountryManager.getText();
		P.gender = GenderManager.getValue();
		d.P[currentuserIndex] = P;
		d.saveManagerData();
		AlertBox.display("SUCCESS", "Account has been updated successfully!", "OK");
		returnFromEditProfile(e);
		
		}
		else return;
		
	}
	

//--------------- Search Trip Controls ---------------\\

	public void choiceInit() {
		type.getItems().addAll("One-Way", "Round-Trip");
		start.getItems().addAll(d.location.getLocations());
		destination.getItems().addAll(d.location.getLocations());
		type.setValue("One-Way");
		start.setValue("Brussels");
		destination.setValue("Amsterdam");
	}
	
	public String[] getSelection() {
		String [] searchData = new String [4];
		if(type.getValue() == null || start.getValue() == null || destination.getValue() == null || date.getValue() == null || start.getValue().equals(destination.getValue())) {
			AlertBox.display("UNEXPECTED INPUTS", "Make sure you enter all the search fields correctly!", "OK");
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
			results[i] = ("Trip type: " + T[0].type + "		Start: " + T[0].start + "		Destination: " + T[0].destination + "		Vehicle Type: " + T[i].seat.vtype + "		Free Seats: " + Integer.toString(T[0].seat.getFreeSeats())+ "		Date: " + T[0].date + "		Time: " + T[0].time +		" 	Price for one ticket: " + Float.toString(T[0].ticket));
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
		searchAnc.setVisible(true);
		searchResultPane.setVisible(true);
		SearchTabs.setVisible(false);
		PassengerTabs.setVisible(false);
	}
	
	public void choiceReset() {
		type.setValue(null);
		start.setValue(null);
		destination.setValue(null);
		date.setValue(null);
		searchView.getItems().clear();
		
	}
	
	public void returnSearchTab(ActionEvent e) {
		choiceReset();
		SearchTabs.setVisible(true);
		PassengerTabs.setVisible(true);
		searchAnc.setVisible(false);
		searchResultPane.setVisible(false);
	}
	
	

//--------------- Booking a Trip ---------------\\

	public void getSearchSelection() {
		Trip thisTrip = resultTrips[searchView.getSelectionModel().getSelectedIndex()];
		startDestLabel.setText(thisTrip.start + " - " + thisTrip.destination);
		timeLabel.setText(thisTrip.time);
		dateLabel.setText(thisTrip.date);
		priceLabel.setText(Float.toString(thisTrip.ticket));
		seatsLabel.setText(Integer.toString(thisTrip.seat.getFreeSeats()));
		reservedTrip = thisTrip;
	}
	
	public void bookTripButtonClicked(ActionEvent e) {
		if(searchView.getSelectionModel().getSelectedIndex() == -1) {
			AlertBox.display("UNEXPECTED INPUTS", "Please make sure you selected a trip!", "OK");
		}
		else {
		getSearchSelection();
		booking.setVisible(true);
		searchAnc.setVisible(false);
		searchResultPane.setVisible(false);
		}
	}
	
	public void returnBookTripButtonClicked(ActionEvent e) {
		displayDialogueBox("MESSAGE ALERT","Are you sure you want to return? Any unsaved data will be lost!" , "Proceed" , "Abort");
		if(flag) {
			searchAnc.setVisible(true);
			searchResultPane.setVisible(true);
			booking.setVisible(false);
		}
		else return;
		
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
	
	
	public void bookTripClicked(ActionEvent e) throws IOException {
		paymentDisplay();
		showUnpaidTickets();
		
	}

	//--------------- Payment Window ---------------\\
	
	
	public int ticketSerialGenerator() {
		int serial = 225000 , i = 0 ;
		while(d.Tk[i] != null) {
			if(d.Tk[i].serial == serial) {
				serial++;
				i++;
				continue;
			}
			else {
				i++;
				continue;
			}
		}
		i=0;
		if(upaid == null) {
			
		}
		else {
	while(upaid[i] != null) {
			if(upaid[i].serial == serial) {
				serial++;
				i++;
				continue;
			}
			else {
				i++;
				continue;
			}
		}}
		return serial;
	}

	public void paymentDisplay() {
		payment.setVisible(true);
		booking.setVisible(false);
	}
	
	public void getPaymentMethod(String paymentMethod) throws IOException {
		if(paymentMethod.equals("Cash")) {
			pay = new Cash();
			book(1);
		}
		else if(paymentMethod.equals("Credit")) {
			pay = new CreditCard();
			boolean flag = PaymentWindow.display("Credit Card", "Payment Information", "Card", "Return", "Pay "+totalCheck + " €", "Card Number");
			if(flag) {
				String credit = PaymentWindow.code;
				if(d.credit.validateCreditCard(credit)) {
					if(d.credit.sufficient(totalCheck, credit)) {
						pay.pay(totalCheck, credit);
						book(2);
					}
					else AlertBox.display("ERROR", "Not sufficient balance!", "OK");
				}
				else AlertBox.display("ERROR", "Not an existing credit card number!", "OK");
				return;
			}
		}
		else if(paymentMethod.equals("Promo")) {
			pay = new PromoCode();
			boolean flag = PaymentWindow.display("Promo Code", "Payment Information", "Promo", "Return", "Enter", "Promo Code");
			if(flag) {
				String credit = PaymentWindow.code;
				int i = 0;
				if(d.promo.validatePromoCode(credit)) {
					while(promocode[i] != null) {
						if(promocode[i].equals(credit)) {
							AlertBox.display("ERROR", "You can't use a promo code twice at the same session", "OK");
							i++;
							return;
							
						}}
				
					d.promo.pay(totalCheck, credit);
					totalCheck = d.promo.getNewPrice();
					promocode[pIndex] = credit;
					book(3);
				}
				else AlertBox.display("ERROR", "Not an existing promo code!", "OK");
			}
			return;
		}
	}
	
	public Ticket[] getUnpaidTickets() {
		int index=0;
		Ticket [] unpaidTickets = new Ticket[50];
		if(seatingTxt.getText().equals(null) || seatingTxt.getText() == null) {
			if(seatsChosen == null) {
				AlertBox.display("UNEXPECTED INPUTS", "Please make sure you chose at least 1 seat!", "OK");
				return null;
			}
			else {
				int i = 0;
				Ticket tmp = null;
				while(seatsChosen[i] != null)
					tmp = reserve.makeReservation(reservedTrip, P.username,ticketSerialGenerator(), seatsChosen[i], "UNPAID");
					totalCheck += tmp.price;
					unpaidTickets[index] = tmp;
					i++;
					index++;
			}
		}
		else {
			if(seatsChosen!=null) {
					int i = 0;
					Ticket tmp = null;
					while(seatsChosen[i] != null) {
						tmp = reserve.makeReservation(reservedTrip, P.username, ticketSerialGenerator(), seatsChosen[i], "UNPAID");
						totalCheck += tmp.price;
						unpaidTickets[index] = tmp;
						i++;
					}
			}			
			else if(seatsChosen == null) {
				int numSeats;
			
				try{
					numSeats = Integer.parseInt(seatingTxt.getText());
					if(numSeats > reservedTrip.seat.getFreeSeats()) {
						AlertBox.display("UNEXPECTED INPUTS", "Enter a valid number of seats!", "OK");
						return null;
					}
				}
				catch(NumberFormatException exception) {
					AlertBox.display("UNEXPECTED INPUTS", "Enter a valid number of seats!", "OK");
					seatingTxt.setText("");
					return null;
				}
				while(numSeats != 0) {
					System.out.println(numSeats);
					Ticket tmp = reserve.makeReservation(reservedTrip, P.username, ticketSerialGenerator(), reservedTrip.seat.bookRandom(), "UNPAID");
					totalCheck += tmp.price;
					unpaidTickets[index] = tmp;
					upaid = unpaidTickets;
					index++;
					numSeats --;
					
				}
			}
		}
		
		return unpaidTickets;
	}
	
	
	public void showUnpaidTickets() {
		int i = 0;
		Ticket[] unpaid = getUnpaidTickets();
		String unpaidData;
		while(unpaid[i] != null) {
			unpaidData = (unpaid[i].serial + " " + unpaid[i].T.destination + " " + unpaid[i].T.start + " " + unpaid[i].T.date + " " + unpaid[i].T.time + " " + unpaid[i].price + " " + unpaid[i].seat);
			purchaseView.getItems().add(unpaidData);
			i++;
		}
		checkTotal.setText(Float.toString(totalCheck) + " €");
	}
	
	public void bookNowClicked(ActionEvent e) {
		showUnpaidTickets();
	}
	
	public void cashButtonClicked(ActionEvent e) throws IOException {
		getPaymentMethod("Cash");
	}
	
	public void creditButtonClicked(ActionEvent e) throws IOException {
		getPaymentMethod("Credit");
	}
	
	public void promoButtonClicked(ActionEvent e) throws IOException {
		getPaymentMethod("Promo");
	}
	
	public void clearUnpaidTicket() {
		purchaseView.getItems().clear();
		checkTotal.setText(null);
		searchResultPane.setVisible(true);
		booking.setVisible(false);
		payment.setVisible(false);
		totalCheck = 0;
		reservedTrip = null;
		upaid = null;
		
	}
	
	
	public void book(int type) throws IOException {
		Ticket [] unpaidTickets = upaid;
		int i = 0;
		while(unpaidTickets[i] != null) {
			if(type == 1) {
				d.addTicket(unpaidTickets[i].T, P.username, unpaidTickets[i].serial, unpaidTickets[i].seat , unpaidTickets[i].price, "Cash");
			}
			else if(type == 3) {
				checkTotal.setText(Float.toString(totalCheck) + " €");
				AlertBox.display("SUCCESS", "Your total check has been reduced by "+d.promo.promocodes.get(promocode[pIndex]) + " %", "Continue");
				pIndex++;
				return;
			}
			else {
				d.addTicket(unpaidTickets[i].T, P.username, unpaidTickets[i].serial, unpaidTickets[i].seat , unpaidTickets[i].price, "CreditCard");
			}
			i++;
		}
		d.saveTripData();
		clearUnpaidTicket();
		AlertBox.display("SUCCESS", "Your reservation has been made successfully! You may now view it from MyTrips tab!", "OK");
		
	}
	
	public void returnPaymentClicked(ActionEvent e) {
		purchaseView.getItems().clear();
		int i = 0;
		if(upaid != null)
		while(upaid[i] != null) {
			reservedTrip.seat.resetByName(upaid[i].seat);
			i++;
		}
		
		booking.setVisible(true);
		payment.setVisible(false);
	}
	
	
	
	
//--------------- Trips Schedule Tab ---------------\\

	public void SelectTrip (ActionEvent e) throws IOException
	{
		LabelChoose.setVisible(true);
		back.setVisible(true);
		if(line1.getTypeSelector() != null)
		{
			Trip1.setVisible(true);
		}
		SearchTabs.setVisible(false);
		PassengerTabs.setVisible(false);
		
	}
	public void BackMainTab (ActionEvent e) throws IOException
	{
		
		SearchTabs.setVisible(true);
		PassengerTabs.setVisible(true);
		Trip1.setVisible(false);
		LabelChoose.setVisible(false);
		back.setVisible(false);
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choiceInit();
	}
	
	
		
	

	//--------------- MyTrips View ---------------\\
	
	
	public Ticket[] queryMyTrips() {
		int i = 0, k =0;
		resultTickets = new Ticket[100];
		while(d.Tk[i] != null) {
			if(d.Tk[i].uname.equals(P.username)){
				resultTickets[k] = d.Tk[i];
				k++;
			}
			i++;
		}
		return resultTickets;
	}
	
	public String [] showMyResults() {
		Ticket [] Tk = queryMyTrips();
		Ticketresults = new String[50];
		int i = 0;
		while(Tk[i] != null) {
			Ticketresults[i] = ("Ticket Number: " + Tk[i].serial + "		Destination: "+ Tk[i].T.destination + "		Start: " + Tk[i].T.start + "		Ticket Price: " + Tk[i].price + "		Payment Method Chosen: " + Tk[i].payment);
			i++;
		}
		return Ticketresults;
	}
	
	public void myTripTableInit() {
		String [] results = showMyResults();
		int i = 0;
		while(results[i] != null) {
			myTrips.getItems().add(results[i]);
			i++;
		}
	}

	
	public void myTripsClicked(ActionEvent e) {
		myTripTableInit();
		myTripsPane.setVisible(true);
		myTrips.setVisible(true);
		searchResultPane.setVisible(false);
		SearchTabs.setVisible(false);
		PassengerTabs.setVisible(false);
	}
	
	public void myTripsReset() {
		myTrips.getItems().clear();
		
	}
	
	public void returnMyTrips(ActionEvent e) {
		myTripsReset();
		SearchTabs.setVisible(true);
		PassengerTabs.setVisible(true);
		myTripsPane.setVisible(false);
	}
	
	
	public void showTripDetails(ActionEvent e) throws IOException {
			System.out.println("CLICK");
			Ticket[] T = queryMyTrips();
			int index = myTrips.getSelectionModel().getSelectedIndex();
			Ticket selection = T[index];
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("ShowTicket.fxml"));
			Parent Show =(Parent) loader.load();
			ShowTicketController controller = loader.getController();
			controller.addData(selection.uname, selection.T.start, selection.T.destination, selection.T.time, selection.T.date, Integer.toString(selection.T.ID));
			Stage window = new Stage();
			window.setTitle("Ticket Details");
			window.setScene(new Scene(Show));
			window.showAndWait();
		
	}
	
	
	
	
}