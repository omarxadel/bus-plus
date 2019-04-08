package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeatsDesign {
	Seat s;
	int SNum;
	Stage NewWindow=new Stage ();
	GridPane grid = new  GridPane ();
	Scene scene=new Scene(grid);
	
	
	public SeatsDesign(int sNum) {
		SNum = sNum;
	}

	public void Design (int sNum)
	{
		sNum=s.capacity;
		
		if (sNum == 12)
		{
			Button driver = new Button ("D");
			Button one = new Button("A1");
			Button two = new Button("A2");
			Button three = new Button("A3");
			Button four = new Button("A4");
			Button five = new Button("A5");
			Button six = new Button("A6");
			Button seven = new Button("B1");
			Button eight = new Button("B2");
			Button nine = new Button("B3");
			Button ten = new Button("B4");
			Button eleven = new Button("B5");
			Button twelve= new Button("B6");
			
			Button Ok = new Button("Confirm");
			
			
			grid.setAlignment(Pos.CENTER);
			
			grid.add(driver,0,2);
			grid.add(one,1,2);
			grid.add(two,1,3);
			grid.add(three,2,2);
			grid.add(four,2,3);
			grid.add(five,3,2);
			grid.add(six,3,3);
			grid.add(seven,1,4);
			grid.add(eight,1,5);
			grid.add(nine,2,4);
			grid.add(ten,2,5);
			grid.add(eleven,3,4);
			grid.add(twelve,3,5);
			
			grid.add(Ok,5,3);
			
			grid.setVgap(7); 
		    grid.setHgap(7);
		    
		    grid.setAlignment(Pos.CENTER);
		    
			//----------------------------------------------------------------------------//
			one.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 0);
						one.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			two.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 1);
						two.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			three.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 0);
						three.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			four.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 1);
						four.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			five.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 0);
						five.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			six.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 1);
						six.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			seven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 0);
						seven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eight.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 1);
						eight.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			nine.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 2);
						nine.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			ten.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 2);
						ten.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eleven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 2);
						eleven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twelve.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 2);
						twelve.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			
		}
		if (sNum==36)
		{
			Button driver = new Button ("D");
			Button one = new Button("A1");
			Button two = new Button("A2");
			Button three = new Button("A3");
			Button four = new Button("A4");
			Button five = new Button("A5");
			Button six = new Button("A6");
			Button seven = new Button("A7");
			Button eight = new Button("A8");
			Button nine = new Button("A9");
			Button ten = new Button("A10");
			Button eleven = new Button("A11");
			Button twelve= new Button("A12");
			Button thirteen = new Button("A13");
			Button fourteen = new Button("A14");
			Button fifteen = new Button("A15");
			Button sixteen = new Button("A16");
			Button seventeen = new Button("A17");
			Button eighteen = new Button("A18");
			Button nineteen = new Button("B1");
			Button twenty = new Button("B2");
			Button twentyone = new Button("B3");
			Button twentytwo = new Button("B4");
			Button twentythree = new Button("B5");
			Button twentyfour = new Button("B6");
			Button twentyfive = new Button("B7");
			Button twentysix = new Button("B8");
			Button twentyseven = new Button("B9");
			Button twentyeight = new Button("B10");
			Button twentynine = new Button("B11");
			Button thirty = new Button("B12");
			Button thirtyone = new Button("B13");
			Button thirtytwo = new Button("B14");
			Button thirtythree = new Button("B15");
			Button thirtyfour = new Button("B16");
			Button thirtyfive = new Button("B17");
			Button thirtysix = new Button("B18");
			Button Ok = new Button("Confirm");
			
			grid.add(driver,0,2);
			grid.add(one,1,2);
			grid.add(two,1,3);
			grid.add(three,2,2);
			grid.add(four,2,3);
			grid.add(five,3,2);
			grid.add(six,3,3);
			grid.add(seven,4,2);
			grid.add(eight,4,3);
			grid.add(nine,5,2);
			grid.add(ten,5,3);
			grid.add(eleven,6,2);
			grid.add(twelve,6,3);
			grid.add(thirteen,7,2);
			grid.add(fourteen,7,3);
			grid.add(fifteen,8,2);
			grid.add(sixteen,8,3);
			grid.add(seventeen,9,2);
			grid.add(eighteen,9,3);
			grid.add(nineteen,1,4);
			grid.add(twenty,1,5);
			grid.add(twentyone,2,4);
			grid.add(twentytwo,2,5);
			grid.add(twentythree,3,4);
			grid.add(twentyfour,3,5);
			grid.add(twentyfive,4,4);
			grid.add(twentysix,4,5);
			grid.add(twentyseven,5,4);
			grid.add(twentyeight,5,5);
			grid.add(twentynine,6,4);
			grid.add(thirty,6,5);
			grid.add(thirtyone,7,4);
			grid.add(thirtytwo,7,5);
			grid.add(thirtythree,8,4);
			grid.add(thirtyfour,8,5);
			grid.add(thirtyfive,9,4);
			grid.add(thirtysix,9,5);
			grid.add(Ok,11,3);
			
			grid.setVgap(7); 
		    grid.setHgap(7);
		    
			grid.setAlignment(Pos.CENTER);
			
			//-------------------------------------------------------------------//
			
			one.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 0);
						one.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			two.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 1);
						two.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			three.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 0);
						three.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			four.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 1);
						four.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			five.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 0);
						five.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			six.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 1);
						six.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			seven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 0);
						seven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eight.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 1);
						eight.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			nine.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 0);
						nine.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			ten.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 1);
						ten.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eleven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 0);
						eleven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twelve.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 1);
						twelve.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 0);
						thirteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fourteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 1);
						fourteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fifteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 0);
						fifteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			sixteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 1);
						sixteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			seventeen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8, 0);
						seventeen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eighteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8,1);
						eighteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			nineteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 2);
						nineteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twenty.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 3);
						twenty.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 2);
						twentyone.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentytwo.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 3);
						twentytwo.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentythree.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 2);
						twentythree.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyfour.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 3);
						twentyfour.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyfive.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 2);
						twentyfive.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentysix.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 3);
						twentysix.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyseven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 2);
						twentyseven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyeight.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 3);
						twentyeight.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentynine.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 2);
						twentynine.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirty.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 3);
						thirty.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 2);
						thirtyone.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtytwo.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 3);
						thirtytwo.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtythree.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 2);
						thirtythree.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyfour.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 3);
						thirtyfour.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyfive.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8, 2);
						thirtyfive.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtysix.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8, 3);
						thirtysix.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			
		}
		
		if (sNum == 46)
		{
			Button driver = new Button ("D");
			Button one = new Button("A1");
			Button two = new Button("A2");
			Button three = new Button("A3");
			Button four = new Button("A4");
			Button five = new Button("A5");
			Button six = new Button("A6");
			Button seven = new Button("A7");
			Button eight = new Button("A8");
			Button nine = new Button("A9");
			Button ten = new Button("A10");
			Button eleven = new Button("A11");
			Button twelve= new Button("A12");
			Button thirteen = new Button("A13");
			Button fourteen = new Button("A14");
			Button fifteen = new Button("A15");
			Button sixteen = new Button("A16");
			Button seventeen = new Button("A17");
			Button eighteen = new Button("A18");
			Button nineteen = new Button("A19");
			Button twenty = new Button("A20");
			Button twentyone = new Button("A21");
			Button twentytwo = new Button("A22");
			Button twentythree = new Button("A23");
			Button twentyfour = new Button("B1");
			Button twentyfive = new Button("B2");
			Button twentysix = new Button("B3");
			Button twentyseven = new Button("B4");
			Button twentyeight = new Button("B5");
			Button twentynine = new Button("B6");
			Button thirty = new Button("B7");
			Button thirtyone = new Button("B8");
			Button thirtytwo = new Button("B9");
			Button thirtythree = new Button("B10");
			Button thirtyfour = new Button("B11");
			Button thirtyfive = new Button("B12");
			Button thirtysix = new Button("B13");
			Button thirtyseven = new Button("B14");
			Button thirtyeight = new Button("B15");
			Button thirtynine = new Button("B16");
			Button forty = new Button("B17");
			Button fortyone = new Button("B18");
			Button fortytwo = new Button("B19");
			Button fortythree = new Button("B20");
			Button fortyfour = new Button("B21");
			Button fortyfive = new Button("B22");
			Button fortysix = new Button("B23");
			Button Ok = new Button("Confirm");
				
			grid.add(driver,0,2);
			grid.add(one,1,2);
			grid.add(two,1,3);
			grid.add(three,2,2);
			grid.add(four,2,3);
			grid.add(five,3,2);
			grid.add(six,3,3);
			grid.add(seven,4,2);
			grid.add(eight,4,3);
			grid.add(nine,5,2);
			grid.add(ten,5,3);
			grid.add(eleven,6,2);
			grid.add(twelve,6,3);
			grid.add(thirteen,7,2);
			grid.add(fourteen,7,3);
			grid.add(fifteen,8,2);
			grid.add(sixteen,8,3);
			grid.add(seventeen,9,2);
			grid.add(eighteen,9,3);
			grid.add(nineteen,10,2);
			grid.add(twenty,10,3);
			grid.add(twentyone,11,2);
			grid.add(twentytwo,11,3);
			grid.add(twentythree,12,2);
			grid.add(twentyfour,1,4);
			grid.add(twentyfive,1,5);
			grid.add(twentysix,2,4);
			grid.add(twentyseven,2,5);
			grid.add(twentyeight,3,4);
			grid.add(twentynine,3,5);
			grid.add(thirty,4,4);
			grid.add(thirtyone,4,5);
			grid.add(thirtytwo,5,4);
			grid.add(thirtythree,5,5);
			grid.add(thirtyfour,6,4);
			grid.add(thirtyfive,6,5);
			grid.add(thirtysix,7,4);
			grid.add(thirtyseven,7,5);
			grid.add(thirtyeight,8,4);
			grid.add(thirtynine,8,5);
			grid.add(forty,9,4);
			grid.add(fortyone,9,5);
			grid.add(fortytwo,10,4);
			grid.add(fortythree,10,5);
			grid.add(fortyfour,11,4);
			grid.add(fortyfive,11,5);
			grid.add(fortysix,12,5);
			grid.add(Ok,14,3);
			
			grid.setVgap(7); 
		    grid.setHgap(7);
		    
			grid.setAlignment(Pos.CENTER);
			
			//----------------------------------------------------------------------//
			
			one.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 0);
						one.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			two.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 1);
						two.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			three.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 0);
						three.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			four.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 1);
						four.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			five.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 0);
						five.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			six.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 1);
						six.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			seven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 0);
						seven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eight.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 1);
						eight.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			nine.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 0);
						nine.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			ten.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 1);
						ten.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eleven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 0);
						eleven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twelve.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 1);
						twelve.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 0);
						thirteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fourteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 1);
						fourteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fifteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 0);
						fifteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			sixteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 1);
						sixteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			seventeen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8, 0);
						seventeen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			eighteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8,1);
						eighteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			nineteen.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(9, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(9, 0);
						nineteen.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twenty.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(9, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(9, 1);
						twenty.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(10, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(10, 0);
						twentyone.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentytwo.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(10, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(10, 1);
						twentytwo.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentythree.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(11, 0))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(11, 0);
						twentythree.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyfour.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(11, 1))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(11, 1);
						twentyfour.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyfive.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 2);
						twentyfive.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentysix.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(0, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(0, 3);
						twentysix.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyseven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 2);
						twentyseven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentyeight.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(1, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(1, 3);
						twentyeight.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			twentynine.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 2);
						twentynine.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirty.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(2, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(2, 3);
						thirty.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 2);
						thirtyone.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtytwo.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(3, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(3, 3);
						thirtytwo.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtythree.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 2);
						thirtythree.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyfour.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(4, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(4, 3);
						thirtyfour.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyfive.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 2);
						thirtyfive.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtysix.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(5, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(5, 3);
						thirtysix.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyseven.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 2);
						thirtyseven.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtyeight.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(6, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(6, 3);
						thirtyeight.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			thirtynine.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 2);
						thirtysix.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			forty.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(7, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(7, 3);
						forty.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fortyone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8, 2);
						fortyone.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fortytwo.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(8, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(8, 3);
						fortytwo.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fortythree.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(9, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(9, 2);
						fortythree.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fortyfour.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(9, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(9, 3);
						fortyfour.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fortyfive.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(10, 2))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(10, 2);
						fortyfive.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			fortysix.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					if (s.isBooked(10, 3))
						AlertBox.display("ERROR!", "This seat is already booked , choose another one !");
					else 
					{
						s.bookSeat(10, 3);
						fortyfive.setStyle("-fx-background-color: darkslateblue;");
					}
				}
				
			});
			
		}
		NewWindow.setTitle("Reserve your place");
		scene = new Scene(grid,600,400);
				
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}