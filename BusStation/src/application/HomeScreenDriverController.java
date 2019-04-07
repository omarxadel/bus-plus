package application;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeScreenDriverController {
	Driver D;
	private Button TripsSchedule;
	private Button Tripscomments;
	private Button Profile;
	private Button newtrip;
	private Label welcomelabel;
	
	// --------------- Profile Controls ---------------\\
	
	public void getProfile(Driver D)
	{
		this.D=D;
		welcomelabel.setText("Hello Mister  "+ D.firstname);	
	}
	public void profileButtonClicked (ActionEvent e)
	{
		
	}
	public void returnProfButtonClicked (ActionEvent e)
	{
		
	}
	
	// --------------- Manage Trips Button ------------\\
	
	public void ManageTripButtonClicked(ActionEvent e)
	{
		
	}
	public void returnManageTripButtonClicked(ActionEvent e)
	{
		
	}
}

