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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeScreenDriverController {
	Driver D;
	Manager M[];
	Database d = new Database();
	
	public VBox MainTabManager;
	public VBox ProfTitle;
	public VBox Schedule;
	public AnchorPane ProfFull;
	public AnchorPane addTripFull;
	public AnchorPane trip1;
	public AnchorPane trip2;
	public AnchorPane trip3;
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
	
	// --------------- Trips Schedule Tab ---------------\\
	
	public void SelectTrip (ActionEvent e) throws IOException
	{
		Schedule.setVisible(true);
		Back.setVisible(true);
		MainTabManager.setVisible(false);
		if(line1.getTypeSelector() != null)
		{
			trip1.setVisible(true);
		}
		if(line2.getTypeSelector() != null)
		{
			trip2.setVisible(true);
		}
		if(line3.getTypeSelector() != null)
		{
			trip3.setVisible(true);
		}
		
	}
	public void BackMainTab (ActionEvent e) throws IOException
	{
		
		MainTabManager.setVisible(true);
		trip1.setVisible(false);
		trip2.setVisible(false);
		trip3.setVisible(false);
		Schedule.setVisible(false);
		Back.setVisible(false);
	}
	
		
}

