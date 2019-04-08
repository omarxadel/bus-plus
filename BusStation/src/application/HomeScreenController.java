package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class HomeScreenController {
	//Manager M;
	Passenger P;
	SeatsDesign SD;
	Seat s;
	Stage stage;
	Scene scene;
	//Driver D;
	
	public Button PromoCodes;
	public Button PassengerProfileButton;
	public Button SeatingOptions;
	public Button Service;
	public Button Settings;
	public MenuItem OnewayOption;
	public VBox PassengerTabs;
	public Label WelcomeLabel;
	public AnchorPane ProfFull;

	// --------------- Profile Controls ---------------\\
	 
	public void getProfile (Passenger P)
	{
		this.P=P;
		WelcomeLabel.setText("Hello Mister"+P.firstname);
	}
	
	public void profileButtonClicked (ActionEvent e)
	{
		ProfFull.setVisible(true);
	}
	
	public void returnProfButtonClicked (ActionEvent e)
	{
		ProfFull.setVisible(false);
	}
	// --------------- Choosing Seats ---------------\\
	
	public void SeatingOptions (ActionEvent e) throws IOException
	{
		stage.setScene(SD.getScene());
		
	}
	
	public void setSD(SeatsDesign sD) {
		SD = sD;
	}
	 
}
