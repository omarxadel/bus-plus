/*
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.Driver;
import model.Admin;
import model.Trip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeScreenDriverController implements Initializable{
	static boolean flag = false;
	static Database d = new Database();
	int userIndex;
	Trip[] tripsView = new Trip[100];
	Driver D;
	Admin M[];
	public Trip[] trip;
	public VBox MainTabManager;
	public VBox ProfTitle;
	public VBox Schedule;
	public AnchorPane ProfFull;
	public AnchorPane addTripFull;
	public AnchorPane trip1;
	public AnchorPane trip2;
	public AnchorPane trip3;
	public AnchorPane editProfile;
	public TextField FirstnameManager,LastnameManager,UsernameManager,CityManager,CountryManager;
	public PasswordField PasswordManager, RepassManager;
	public Label WelcomeDriver;
	public Label Fname;
	public Label Account;
	public Label Country;
	public Label ID;
	public MenuButton TripsSchedule;
	public MenuItem line1;
	public MenuItem line2;
	public MenuItem line3;
	public Button profReturn;
	public Button EditAccount;
	public Button StartTrip;
	public Button Back;
	public Button Tripscomments;
	public Label credit;
	public ListView<String> line1V;
	@FXML
	MenuBar myMenuBar;
	public MenuItem seeTrips, seeProf, seeEdit;
	
	// --------------- Profile Controls ---------------\\
	
	public void getProfile(Driver D)
	{
		this.D=D;
		WelcomeDriver.setText("Hello Mr. " + D.firstname);
		Fname.setText("" + D.firstname + " " + D.lastname);
		Account.setText("" + D.job);
		Country.setText("" + D.city +", "+ D.country);
		ID.setText("" + D.ID);
		credit.setText("Credit : "+D.getCredit());
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
		ProfFull.setVisible(false);
		ProfTitle.setVisible(false);
	}
	
	public void logOut(ActionEvent e) throws IOException {
		Parent Main = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene MainScene = new Scene(Main);
		Stage window = (Stage)(((Node) e.getSource()).getScene().getWindow());
		window.setScene(MainScene);
	}
	public void initEditProfile()
	{
		FirstnameManager.setText(D.firstname);
		LastnameManager.setText(D.lastname);
		PasswordManager.setText(D.getPassword());
		RepassManager.setText(D.getPassword());
		CityManager.setText(D.city);
		CountryManager.setText(D.country);
		
	}
	public void toEditprofileClicked(ActionEvent e) {
		editProfile.setVisible(true);
		ProfTitle.setVisible(false);
		ProfFull.setVisible(false);
	}
	public void returnFromEditProfile(ActionEvent e) {
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
			D.firstname = FirstnameManager.getText();
		D.lastname = LastnameManager.getText();
		D.username = UsernameManager.getText();
		D.setPassword(PasswordManager.getText());
		D.city = CityManager.getText();
		D.country = CountryManager.getText();
		d.D[userIndex] = D;
		d.saveManagerData();
		}
		else return;
		
	}
	// --------------- Trips Schedule Tab ---------------\\
	
	public void menuTripsClicked(ActionEvent e) {
		
	}
	
	public void SelectTrip (ActionEvent e) throws IOException
	{
		Schedule.setVisible(true);
		trip1.setVisible(true);
		line1V.setVisible(true);
		MainTabManager.setVisible(false);
		ProfFull.setVisible(false);
		ProfTitle.setVisible(false);

	}
	
	public void BackMainTab (ActionEvent e) throws IOException
	{
		MainTabManager.setVisible(true);
		trip1.setVisible(false);
		line1V.setVisible(false);
		Schedule.setVisible(false);
		Back.setVisible(false);
	}
	

	
	public void myTripsClicked() {
	}
	
	public void myTripsInit() {
		String[] tripData = getTrips();
		int i = 0;
		while (tripData[i] != null) {
			line1V.getItems().add(tripData[i]);
			i++;
		}
	
	}
		
	public String[] getTrips(){
			int i = 0, j=0;
			while(d.T[i] != null) {
				if(D.username.equals(d.T[i].driverName)) {
					tripsView[j] = d.T[i];
					j++;
				}
				i++;
			}
			i=0;
			String ID, ticketData, tripData, vnumb;
			String [] tripsDataS = new String[100];
			while(tripsView[i] != null) {
				ID = Integer.toString(tripsView[i].ID);
				vnumb = Integer.toString(tripsView[i].vnum);
				ticketData = Float.toString(tripsView[i].ticket);
				tripData = (ID + " " + tripsView[i].start + " " + tripsView[i].destination + " " + tripsView[i].vmodel + " " + vnumb + " " + tripsView[i].driverName + " " + tripsView[i].date + " " + tripsView[i].time + " " + ticketData);
				tripsDataS[i] = tripData;
				i++;
			}
			return tripsDataS;
		}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		seeTrips.setOnAction(e->{
			try {
				SelectTrip(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		*/
/*seeProf.setOnAction(e->{
			try {
				SelectTrip(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		seeEdit.setOnAction(e->{
			try {
				SelectTrip(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});*//*

	
	}
	}*/
