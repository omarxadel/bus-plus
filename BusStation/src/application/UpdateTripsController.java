package application;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateTripsController {
	String start, dest, vehicle, vnum, drivername, date, time, ticketprice;
	int ID, index;
	Seat seat;
	Trip T;
	Driver [] D;
	Driver select;
	Database d = new Database();
	public Button Cancel;
	public ChoiceBox<String> startL;
	public ChoiceBox<String> DestL;
	public ChoiceBox<String> Driver;
	public ChoiceBox<String> car;
	public ChoiceBox<String> carNo;
	public DatePicker datep;
	public TextField ticket;
	public TextField Time1, Time2;
	




	
	
}