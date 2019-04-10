package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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

public class HomeScreenController implements PaymentMethod{
	//Manager M;
	Passenger P;
	Seat s;
	Stage stage;
	Scene scene;
	public Trip[] trip;
	//Driver D;
	
	public AnchorPane Trip1;
	public AnchorPane Trip2;
	public AnchorPane Trip3;
	public AnchorPane Editacc;
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
	
	@Override
	public void pay() {
		cash ();
		Visa ();
	}

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

	//-------------------------------------------------\\
	public void cash ()
	{
		
	}
	public void Visa()
	{
		
	}
}
	
