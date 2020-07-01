package application;

import model.Database;
import model.Driver;
import model.Seat;
import model.Trip;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateTripsController {
	String start, dest, vehicle, vnum, drivername, date, time, ticketprice;
	int ID, index;
	Seat seat;
	Trip T;
	model.Driver[] D;
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