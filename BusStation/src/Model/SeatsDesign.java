package Model;

import java.net.URL;
import java.util.ResourceBundle;

import application.AlertBox;
import application.HomeScreenController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeatsDesign implements Initializable{
	static String [] bookedSeats = new String[50];
	static Trip T;
	HomeScreenController homescreen;
	int SNum;
	static Stage window=new Stage ();
	static GridPane grid = new  GridPane ();
	static Scene scene = new Scene(grid);
	static int i = 0;
	static int j=1;
	
	
	public SeatsDesign(int sNum) {
	SNum = sNum;
	}

	public static GridPane Design (int sNum)
	{
	//s.capacity=sNum;
	
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
	Button OK=new Button("Confrim");
	
	grid.setAlignment(Pos.CENTER);
	
	grid.add(driver,1,1);
	grid.add(one,1,2);
	grid.add(two,2,2);
	grid.add(three,1,3);
	grid.add(four,2,3);
	grid.add(five,1,4);
	grid.add(six,2,4);
	
	grid.add(seven,5,2);
	grid.add(eight,6,2);
	grid.add(nine,5,3);
	grid.add(ten,6,3);
	grid.add(eleven,5,4);
	grid.add(twelve,6,4);
	
	grid.add(OK, 7, 7);
	
	grid.setVgap(7); 
	grid.setHgap(7);
	    
	grid.setAlignment(Pos.CENTER);
	//-------------------------------------------------------------------------\\
	 one.setStyle("-fx-background-color: #E303F52; ");
	 two.setStyle("-fx-background-color: #E303F52;");
	three.setStyle("-fx-background-color: #E303F52;");
	four.setStyle("-fx-background-color: #E303F52;");
	five.setStyle("-fx-background-color: #E303F52;");
	six.setStyle("-fx-background-color: #E303F52;");
	seven.setStyle("-fx-background-color: #E303F52;");
	eight.setStyle("-fx-background-color: #E303F52;");
	nine.setStyle("-fx-background-color: #E303F52;");
	ten.setStyle("-fx-background-color: #E303F52;");
	eleven.setStyle("-fx-background-color: #E303F52;");
	twelve.setStyle("-fx-background-color: #ED8063;");
		
	//---------------------------------------------------------------------------\\
	if (T.seat.isBooked(0,0)) one.setStyle("-fx-background-color: #ED8063; ");
	if (T.seat.isBooked(1,0)) two.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,1)) three.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,1)) four.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,2)) five.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,2)) six.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,3)) seven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,3)) eight.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,0)) nine.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,1)) ten.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,2)) eleven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,3)) twelve.setStyle("-fx-background-color: #ED8063;");
	
	//---------------------------------------------------------------------------\\
	
	one.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 0);
						 bookedSeats[i]=("A1");
						 i++;
						 one.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 0);  
				     one.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	two.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 0);
						 bookedSeats[i]=("A2");
						 i++;
						 two.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 0);  
				     two.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	three.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 1))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 1);
						 bookedSeats[i]=("A3");
						 i++;
						 three.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 1);  
				     three.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	four.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 1))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 1);
						 bookedSeats[i]=("A4");
						 i++;
						 four.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 1);  
				     four.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	five.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 2))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 2);
						 bookedSeats[i]=("A5");
						 i++;
						 five.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 2);  
				     five.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	six.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 2))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 2);
						 bookedSeats[i]=("A6");
						 i++;
						 six.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 2);  
				     six.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	seven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 3);
						 bookedSeats[i]=("B1");
						 i++;
						 seven.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 3);  
				     seven.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	eight.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 3);
						 bookedSeats[i]=("B2");
						 i++;
						 eight.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 3);  
				     eight.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	nine.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 0);
						 bookedSeats[i]=("B3");
						 i++;
						 nine.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 0);  
				     nine.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	ten.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 1))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 1);
						 bookedSeats[i]=("B4");
						 i++;
						 ten.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 1);  
				     ten.setStyle("-fx-background-color: #303F50;");
						  }
				}
			}
	}); 
	eleven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 2))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 2);
						 bookedSeats[i]=("B5");
						 i++;
						 eleven.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 2);  
				     eleven.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	twelve.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 3);
						 bookedSeats[i]=("B6");
						 i++;
						 twelve.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 3);  
				     twelve.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	    
	//----------------------------------------------------------------------------//
	OK.setOnAction(new EventHandler<ActionEvent>() {

	@Override
	public void handle(ActionEvent event) {
	window.close();
	}
	});
	
	
	
	}
	if (sNum==36){
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
	Button Ok = new Button("Confrim");
	
	grid.add(driver,1,1);
	grid.add(one,1,2);
	grid.add(two,2,2);
	grid.add(three,1,3);
	grid.add(four,2,3);
	grid.add(five,1,4);
	grid.add(six,2,4);
	grid.add(seven,1,5);
	grid.add(eight,2,5);
	grid.add(nine,1,6);
	grid.add(ten,2,6);
	grid.add(eleven,1,7);
	grid.add(twelve,2,7);
	grid.add(thirteen,1,8);
	grid.add(fourteen,2,8);
	grid.add(fifteen,1,9);
	grid.add(sixteen,2,9);
	grid.add(seventeen,1,10);
	grid.add(eighteen,2,10);
	
	grid.add(nineteen,5,2);
	grid.add(twenty,6,2);
	grid.add(twentyone,5,3);
	grid.add(twentytwo,6,3);
	grid.add(twentythree,5,4);
	grid.add(twentyfour,6,4);
	grid.add(twentyfive,5,5);
	grid.add(twentysix,6,5);
	grid.add(twentyseven,5,6);
	grid.add(twentyeight,6,6);
	grid.add(twentynine,5,7);
	grid.add(thirty,6,7);
	grid.add(thirtyone,5,8);
	grid.add(thirtytwo,6,8);
	grid.add(thirtythree,5,9);
	grid.add(thirtyfour,6,9);
	grid.add(thirtyfive,5,10);
	grid.add(thirtysix,6,10);
	
	grid.add(Ok, 7, 12);
	
	grid.setVgap(7); 
	grid.setHgap(7);
	    
	grid.setAlignment(Pos.CENTER);
	
	//-------------------------------------------------------------\\
	one.setStyle("-fx-background-color: #303F52;");
	two.setStyle("-fx-background-color: #303F52;");
	three.setStyle("-fx-background-color: #303F52;");
	four.setStyle("-fx-background-color: #303F52;");
	five.setStyle("-fx-background-color: #303F52;");
	six.setStyle("-fx-background-color: #303F52;");
	seven.setStyle("-fx-background-color: #303F52;");
	eight.setStyle("-fx-background-color: #303F52;");
	nine.setStyle("-fx-background-color: #303F52;");
	ten.setStyle("-fx-background-color: #303F52;");
	eleven.setStyle("-fx-background-color: #303F52;");
	twelve.setStyle("-fx-background-color: #303F52;");
	thirteen.setStyle("-fx-background-color: #303F52;");
	fourteen.setStyle("-fx-background-color: #303F52;");
	fifteen.setStyle("-fx-background-color: #303F52;");
	sixteen.setStyle("-fx-background-color: #303F52;");
	seventeen.setStyle("-fx-background-color: #303F52;");
	eighteen.setStyle("-fx-background-color: #303F52;");
	nineteen.setStyle("-fx-background-color: #303F52;");
	twenty.setStyle("-fx-background-color: #303F52;");
	twentyone.setStyle("-fx-background-color: #303F52;");
	twentytwo.setStyle("-fx-background-color: #303F52;");
	twentythree.setStyle("-fx-background-color: #303F52;");
	twentyfour.setStyle("-fx-background-color: #303F52;");
	twentyfive.setStyle("-fx-background-color: #303F52;");
	twentysix.setStyle("-fx-background-color: #303F52;");
	twentyseven.setStyle("-fx-background-color: #303F52;");
	twentyeight.setStyle("-fx-background-color: #303F52;");
	twentynine.setStyle("-fx-background-color: #303F52;");
	thirty.setStyle("-fx-background-color: #303F52;");
	thirtyone.setStyle("-fx-background-color: #303F52;");
	thirtytwo.setStyle("-fx-background-color: #303F52;");
	thirtythree.setStyle("-fx-background-color: #303F52;");
	thirtyfour.setStyle("-fx-background-color: #303F52;");
	thirtyfive.setStyle("-fx-background-color: #303F52;");
	thirtysix.setStyle("-fx-background-color: #303F52;");
	//-----------------------------------------------------------------\\
	if (T.seat.isBooked(0,0)) one.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,0)) two.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,1)) three.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,1)) four.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,2)) five.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,2)) six.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,3)) seven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,3)) eight.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,4)) nine.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,4)) ten.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,5)) eleven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,5)) twelve.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,6)) thirteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,6)) fourteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,7)) fifteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,7)) sixteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,8)) seventeen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,8)) eighteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,0)) nineteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,0)) twenty.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,1)) twentyone.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,1)) twentytwo.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,2)) twentythree.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,2)) twentyfour.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,3)) twentyfive.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,3)) twentysix.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,4)) twentyseven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,4)) twentyeight.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,5)) twentynine.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,5)) thirty.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,6)) thirtyone.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,6)) thirtytwo.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,7)) thirtythree.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,7)) thirtyfour.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,8)) thirtyfive.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,8)) thirtysix.setStyle("-fx-background-color: #ED8063;");
	
	//-------------------------------------------------------------------\\
	one.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 0);
						 bookedSeats[i]=("A1");
						 i++;
						 one.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 0);  
				     one.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	two.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 0);
						 bookedSeats[i]=("A2");
						 i++;
						 two.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 0);  
				     two.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	three.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 1))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 1);
						 bookedSeats[i]=("A3");
						 i++;
						 three.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 1);  
				     three.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	four.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 1))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 1);
						 bookedSeats[i]=("A4");
						 i++;
						 four.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 0);  
				     four.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	five.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 2))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 2);
						 bookedSeats[i]=("A5");
						 i++;
						 five.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 2);  
				     five.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	six.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 2))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 2);
						 bookedSeats[i]=("A6");
						 i++;
						 six.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 2);  
				     six.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	seven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 3);
						 bookedSeats[i]=("A7");
						 i++;
						 seven.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 3);  
				     seven.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	eight.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 3);
						 bookedSeats[i]=("A8");
						 i++;
						 eight.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 3);  
				     eight.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	nine.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 4))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 4);
						 bookedSeats[i]=("A9");
						 i++;
						 nine.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 4);  
				     nine.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	ten.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 4))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 4);
						 bookedSeats[i]=("A10");
						 i++;
						 ten.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 4);  
				     ten.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	eleven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 5))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 5);
						 bookedSeats[i]=("A11");
						 i++;
						 eleven.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 5);  
				     eleven.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	twelve.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 5))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 5);
						 bookedSeats[i]=("A12");
						 i++;
						 twelve.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 5);  
				     twelve.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	});	
	thirteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 6))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 6);
						 bookedSeats[i]=("A13");
						 i++;
						 thirteen.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 6);  
				     thirteen.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	fourteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 6))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 6);
						 bookedSeats[i]=("A14");
						 i++;
						 fourteen.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 6);  
				     fourteen.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	});	
	fifteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 7))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 7);
						 bookedSeats[i]=("A15");
						 i++;
						 fifteen.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 7);  
				     fifteen.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 	
	sixteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 7))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 7);
						 bookedSeats[i]=("A16");
						 i++;
						 sixteen.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 7);  
				     sixteen.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	seventeen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(0, 8))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(0, 8);
						 bookedSeats[i]=("A17");
						 i++;
						 seventeen.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(0, 8);  
				     seventeen.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	eighteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 8))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 8);
						 bookedSeats[i]=("A18");
						 i++;
						 eighteen.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 8);  
				     eighteen.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	nineteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 0);
						 bookedSeats[i]=("B1");
						 i++;
						 nineteen.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 0);  
				     nineteen.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twenty.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 0);
						 bookedSeats[i]=("B12");
						 i++;
						 twenty.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 0);  
				     twenty.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twentyone.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 1))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 1);
						 bookedSeats[i]=("B3");
						 i++;
						 twentyone.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 1);  
				     twentyone.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twentythree.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 2))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 2);
						 bookedSeats[i]=("B5");
						 i++;
						 twentythree.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 2);  
				     twentythree.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twentyfour.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 3);
						 bookedSeats[i]=("B6");
						 i++;
						 twentyfour.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 3);  
				     twentyfour.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twentyfive.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 3);
						 bookedSeats[i]=("B7");
						 i++;
						 twentyfive.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 3);  
				     twentyfive.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twentysix.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 3))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 3);
						 bookedSeats[i]=("B8");
						 i++;
						 twentysix.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 3);  
				     twentysix.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twentyseven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 4))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 4);
						 bookedSeats[i]=("B9");
						 i++;
						 twentyseven.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 4);  
				     twentyseven.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 

	twentyeight.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 4))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 4);
						 bookedSeats[i]=("B10");
						 i++;
						 twentyeight.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 4);  
				     twentyeight.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	twentynine.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 5))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 5);
						 bookedSeats[i]=("B11");
						 i++;
						 twentynine.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 5);  
				     twentynine.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	});
	
	thirty.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 5))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 5);
						 bookedSeats[i]=("B12");
						 i++;
						 thirty.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 5);  
				     thirty.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	thirtyone.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 6))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 6);
						 bookedSeats[i]=("B13");
						 i++;
						 thirtyone.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 6);  
				     thirtyone.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	thirtytwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 6))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 6);
						 bookedSeats[i]=("B14");
						 i++;
						 thirtytwo.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 6);  
				     thirtytwo.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	thirtythree.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 7))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 7);
						 bookedSeats[i]=("B15");
						 i++;
						 thirtythree.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 7);  
				     thirtythree.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	
	thirtyfour.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 7))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 7);
						 bookedSeats[i]=("B16");
						 i++;
						 thirtyfour.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 7);  
				     thirtyfour.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	
	thirtyfive.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(2, 8))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(2, 8);
						 bookedSeats[i]=("B17");
						 i++;
						 thirtyfour.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(2, 8);  
				     thirtyfour.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	thirtysix.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(3, 8))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(3, 8);
						 bookedSeats[i]=("B18");
						 i++;
						 thirtysix.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(3, 8);  
				     thirtysix.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 
	
	
	//-------------------------------------------------------------------\\
	
	Ok.setOnAction(new EventHandler<ActionEvent>(){
	@Override
	public void handle(ActionEvent event) {
	window.close();
	}
	});
	
	
	}
	
	if (sNum == 48)
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
	Button twentyfour = new Button("A24");
	Button twentyfive = new Button("B1");
	Button twentysix = new Button("B2");
	Button twentyseven = new Button("B3");
	Button twentyeight = new Button("B4");
	Button twentynine = new Button("B5");
	Button thirty = new Button("B6");
	Button thirtyone = new Button("B7");
	Button thirtytwo = new Button("B8");
	Button thirtythree = new Button("B9");
	Button thirtyfour = new Button("B10");
	Button thirtyfive = new Button("B11");
	Button thirtysix = new Button("B12");
	Button thirtyseven = new Button("B13");
	Button thirtyeight = new Button("B14");
	Button thirtynine = new Button("B15");
	Button forty = new Button("B16");
	Button fortyone = new Button("B17");
	Button fortytwo = new Button("B18");
	Button fortythree = new Button("B19");
	Button fortyfour = new Button("B20");
	Button fortyfive = new Button("B21");
	Button fortysix = new Button("B22");
	Button fortyseven = new Button("B23");
	Button fortyeight = new Button("B24");
	
	Button Ok = new Button("Confirm");
	
	grid.add(driver,1,1);
	grid.add(one,1,2);
	grid.add(two,2,2);
	grid.add(three,1,3);
	grid.add(four,2,3);
	grid.add(five,1,4);
	grid.add(six,2,4);
	grid.add(seven,1,5);
	grid.add(eight,2,5);
	grid.add(nine,1,6);
	grid.add(ten,2,6);
	grid.add(eleven,1,7);
	grid.add(twelve,2,7);
	grid.add(thirteen,1,8);
	grid.add(fourteen,2,8);
	grid.add(fifteen,1,9);
	grid.add(sixteen,2,9);
	grid.add(seventeen,1,10);
	grid.add(eighteen,2,10);
	grid.add(nineteen,1,11);
	grid.add(twenty,2,11);
	grid.add(twentyone,1,12);
	grid.add(twentytwo,2,12);
	grid.add(twentythree,1,13);
	grid.add(twentyfour,2,13);
	
	grid.add(twentyfive,5,2);
	grid.add(twentysix,6,2);
	grid.add(twentyseven,5,3);
	grid.add(twentyeight,5,4);
	grid.add(twentynine,6,3);
	grid.add(thirty,6,4);
	grid.add(thirtyone,5,5);
	grid.add(thirtytwo,6,5);
	grid.add(thirtythree,5,6);
	grid.add(thirtyfour,6,6);
	grid.add(thirtyfive,5,7);
	grid.add(thirtysix,6,7);
	grid.add(thirtyseven,5,8);
	grid.add(thirtyeight,6,8);
	grid.add(thirtynine,5,9);
	grid.add(forty,6,9);
	grid.add(fortyone,5,10);
	grid.add(fortytwo,6,10);
	grid.add(fortythree,5,11);
	grid.add(fortyfour,6,11);
	grid.add(fortyfive,5,12);
	grid.add(fortysix,6,12);
	grid.add(fortyseven,5,13);
	grid.add(fortyeight,6,13);
	
	grid.add(Ok,7,15);
	
	grid.setVgap(7); 
	grid.setHgap(7);
	    
	grid.setAlignment(Pos.CENTER);
	//----------------------------------------------------------------------//
	
	one.setStyle("-fx-background-color: #303F52;");
	two.setStyle("-fx-background-color: #303F52;");
	three.setStyle("-fx-background-color: #303F52;");
	four.setStyle("-fx-background-color: #303F52;");
	five.setStyle("-fx-background-color: #303F52;");
	six.setStyle("-fx-background-color: #303F52;");
	seven.setStyle("-fx-background-color: #303F52;");
	eight.setStyle("-fx-background-color: #303F52;");
	nine.setStyle("-fx-background-color: #303F52;");
	ten.setStyle("-fx-background-color: #303F52;");
	eleven.setStyle("-fx-background-color: #303F52;");
	twelve.setStyle("-fx-background-color: #303F52;");
	thirteen.setStyle("-fx-background-color: #303F52;");
	fourteen.setStyle("-fx-background-color: #303F52;");
	fifteen.setStyle("-fx-background-color: #303F52;");
	seventeen.setStyle("-fx-background-color: #303F52;");
	eighteen.setStyle("-fx-background-color: #303F52;");
	nineteen.setStyle("-fx-background-color: #303F52;");
	twenty.setStyle("-fx-background-color: #303F52;");
	twentyone.setStyle("-fx-background-color: #303F52;");
	twentytwo.setStyle("-fx-background-color: #303F52;");
	twentythree.setStyle("-fx-background-color: #303F52;");
    twentyfour.setStyle("-fx-background-color: #303F52;");
	twentyfive.setStyle("-fx-background-color: #303F52;");
	twentysix.setStyle("-fx-background-color: #303F52;");
	twentyseven.setStyle("-fx-background-color: #303F52;");
	twentyeight.setStyle("-fx-background-color: #303F52;");
	twentynine.setStyle("-fx-background-color: #303F52;");
	thirty.setStyle("-fx-background-color: #303F52;");
	thirtyone.setStyle("-fx-background-color: #303F52;");
	thirtytwo.setStyle("-fx-background-color: #303F52;");
	thirtythree.setStyle("-fx-background-color: #303F52;");
	thirtyfour.setStyle("-fx-background-color: #303F52;");
	thirtyfive.setStyle("-fx-background-color: #303F52;");
	thirtysix.setStyle("-fx-background-color: #303F52;");
	thirtyseven.setStyle("-fx-background-color: #303F52;");
	thirtyeight.setStyle("-fx-background-color: #303F52;");
	thirtynine.setStyle("-fx-background-color: #303F52;");
	forty.setStyle("-fx-background-color: #303F52;");
	fortyone.setStyle("-fx-background-color: #303F52;");
	fortytwo.setStyle("-fx-background-color: #303F52;");
    fortythree.setStyle("-fx-background-color: #303F52;");
	fortyfour.setStyle("-fx-background-color: #303F52;");
	fortyfive.setStyle("-fx-background-color: #303F52;");
	fortysix.setStyle("-fx-background-color: #303F52;");
	fortyseven.setStyle("-fx-background-color: #303F52;");
	fortyeight.setStyle("-fx-background-color: #303F52;");
	//----------------------------------------------------------------------//
	if (T.seat.isBooked(0,0)) one.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,0)) two.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,1)) three.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,1)) four.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,2)) five.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,2)) six.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,3)) seven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,3)) eight.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,4)) nine.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,4)) ten.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,5)) eleven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,5)) twelve.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,6)) thirteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,6)) fourteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,7)) fifteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,7)) sixteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,8)) seventeen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,8)) eighteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,9)) nineteen.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,9)) twenty.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,10)) twentyone.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,10)) twentytwo.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(0,11)) twentythree.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(1,11)) twentyfour.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,0)) twentyfive.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,0)) twentysix.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,1)) twentyseven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,1)) twentyeight.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,2)) twentynine.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,2)) thirty.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,3)) thirtyone.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,3)) thirtytwo.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,4)) thirtythree.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,4)) thirtyfour.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,5)) thirtyfive.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,5)) thirtysix.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,6)) thirtyseven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,6)) thirtyeight.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,7)) thirtynine.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,7)) forty.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,8)) fortyone.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,8)) fortytwo.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,9)) fortythree.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,9)) fortyfour.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,10)) fortyfive.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,10)) fortysix.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(2,11)) fortyseven.setStyle("-fx-background-color: #ED8063;");
	if (T.seat.isBooked(3,11)) fortyeight.setStyle("-fx-background-color: #ED8063;");
	
	//----------------------------------------------------------------------//
	Ok.setOnAction(new EventHandler<ActionEvent>() {

	@Override
	public void handle(ActionEvent event) {
	
	window.close();
	}
	
	});
	
	one.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 0))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 0);
					  bookedSeats[i]=("A1");
				      i++;
				      one.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 0);  
				 one.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});

	two.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
				 if (mouseEvent.getClickCount()==1){
					 if (T.seat.isBooked(1, 0))
						 AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			         else{
			        	 T.seat.bookSeat(1, 0);
						 bookedSeats[i]=("A2");
						 i++;
						 two.setStyle("-fx-background-color: #ED8063;");
						  }
			        }
				 if (mouseEvent.getClickCount()==2){
					 T.seat.freeSeat(1, 0);  
				     two.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	}); 

	three.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)){
				if (mouseEvent.getClickCount()==1){
				if (   T.seat.isBooked(0, 1))
					AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			     else{
			    	 T.seat.bookSeat(0, 1);
					 bookedSeats[i]=("A3");
					 i++;
					 three.setStyle("-fx-background-color: #ED8063;");
					}
			        }
				      if (mouseEvent.getClickCount()==2) {
					      T.seat.freeSeat(0, 1);  
				    	  three.setStyle("-fx-background-color: #303F52;");
						  }
				}
			}
	});
		
	four.setOnMouseClicked(new EventHandler<MouseEvent>() {

		
		@Override
		public void handle(MouseEvent mouseEvent) {
			 
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY))
			   {           
				      if (mouseEvent.getClickCount()==1)
				   {
				           if (   T.seat.isBooked(1, 1))
						        AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			                else 
						 {
						         T.seat.bookSeat(1, 1);
						         bookedSeats[i]=("A4");
						         i++;
						        four.setStyle("-fx-background-color: #ED8063;");
						        }
			        }
				      if (mouseEvent.getClickCount()==2)
						  {
					      T.seat.freeSeat(1, 1);  
				    	  four.setStyle("-fx-background-color: #303F52;");
						  }
				}
					
			}
		
		
	});
	
	five.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			 
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY))
			   {           
				      if (mouseEvent.getClickCount()==1)
				   {
				           if (   T.seat.isBooked(0, 2))
						        AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			                else {
						         T.seat.bookSeat(0, 2);
						         bookedSeats[i]=("A5");
						         i++;
						        five.setStyle("-fx-background-color: #ED8063;");
						        }
			        }
				      if (mouseEvent.getClickCount()==2)
						  {
					         T.seat.freeSeat(0, 2);  
				    	     five.setStyle("-fx-background-color: #303F52;");
						  }
				}
					
			}
		
		
	});
	
	six.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 2))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 2);
					  bookedSeats[i]=("A6");
				      i++;
				      six.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 2);  
				 six.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	seven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 3))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 3);
					  bookedSeats[i]=("A7");
				      i++;
				      seven.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 3);  
				 seven.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	eight.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 3))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 3);
					  bookedSeats[i]=("A8");
				      i++;
				      eight.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 3);  
				 eight.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	nine.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 4))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 4);
					  bookedSeats[i]=("A9");
				      i++;
				      nine.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 4);  
				 nine.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	ten.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 4))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 4);
					  bookedSeats[i]=("A10");
				      i++;
				      ten.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 4);  
				 ten.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	eleven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 5))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 5);
					  bookedSeats[i]=("A11");
				      i++;
				      eleven.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 5);  
				 eleven.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twelve.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 5))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 5);
					  bookedSeats[i]=("A12");
				      i++;
				      twelve.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 5);  
				 twelve.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 6))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 6);
					  bookedSeats[i]=("A13");
				      i++;
				      thirteen.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 6);  
				 thirteen.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fourteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 6))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 6);
					  bookedSeats[i]=("A14");
				      i++;
				      fourteen.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 6);  
				 fourteen.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fifteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 7))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 7);
					  bookedSeats[i]=("A15");
				      i++;
				      fifteen.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 7);  
				 fifteen.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	sixteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 7))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 7);
					  bookedSeats[i]=("A16");
				      i++;
				      sixteen.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 7);  
				 sixteen.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	seventeen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 8))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 8);
					  bookedSeats[i]=("A17");
				      i++;
				      seventeen.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 8);  
				 seventeen.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	eighteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 8))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 8);
					  bookedSeats[i]=("A18");
				      i++;
				      eighteen.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 8);  
				 eighteen.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	nineteen.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 9))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 9);
					  bookedSeats[i]=("A19");
				      i++;
				      nineteen.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 9);  
				 nineteen.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twenty.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 9))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 9);
					  bookedSeats[i]=("A20");
				      i++;
				      twenty.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 9);  
				 twenty.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentyone.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 10))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 10);
					  bookedSeats[i]=("A21");
				      i++;
				      twentyone.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 10);  
				 twentyone.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentytwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 10))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 10);
					  bookedSeats[i]=("A22");
				      i++;
				      twentytwo.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 10);  
				 twentytwo.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentythree.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(0, 11))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(0, 11);
					  bookedSeats[i]=("A23");
				      i++;
				      twentythree.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(0, 11);  
				 twentythree.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentyfour.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(1, 11))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(1, 11);
					  bookedSeats[i]=("A24");
				      i++;
				      twentyfour.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(1, 11);  
				 twentyfour.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentyfive.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 0))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 0);
					  bookedSeats[i]=("B1");
				      i++;
				      twentyfive.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 0);  
				 twentyfive.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentysix.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 0))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 0);
					  bookedSeats[i]=("B2");
				      i++;
				      twentysix.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 0);  
				 twentysix.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentyseven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 1))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 1);
					  bookedSeats[i]=("B3");
				      i++;
				      twentyseven.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 1);  
				 twentyseven.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentyeight.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 1))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 1);
					  bookedSeats[i]=("B4");
				      i++;
				      twentyeight.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 1);  
				 twentyeight.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	twentynine.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 2))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 2);
					  bookedSeats[i]=("B5");
				      i++;
				      twentynine.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 2);  
				 twentynine.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirty.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 2))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 2);
					  bookedSeats[i]=("B6");
				      i++;
				      thirty.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 2);  
				 thirty.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtyone.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 3))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 3);
					  bookedSeats[i]=("B7");
				      i++;
				      thirtyone.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 3);  
				 thirtyone.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});

	thirtytwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 3))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 3);
					  bookedSeats[i]=("B8");
				      i++;
				      thirtytwo.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 3);  
				 thirtytwo.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtythree.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 4))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 4);
					  bookedSeats[i]=("B9");
				      i++;
				      thirtythree.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 4);  
				 thirtythree.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtyfour.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 4))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 4);
					  bookedSeats[i]=("B10");
				      i++;
				      thirtyfour.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 4);  
				 thirtyfour.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtyfive.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 5))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 5);
					  bookedSeats[i]=("B11");
				      i++;
				      thirtyfive.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 5);  
				 thirtyfive.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtysix.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 5))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 5);
					  bookedSeats[i]=("B12");
				      i++;
				      thirtysix.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 5);  
				 thirtysix.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtyseven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 6))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 6);
					  bookedSeats[i]=("B13");
				      i++;
				      thirtyseven.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 6);  
				 thirtyseven.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtyeight.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 6))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 6);
					  bookedSeats[i]=("B14");
				      i++;
				      thirtyeight.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 6);  
				 thirtyeight.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	thirtynine.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 7))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 7);
					  bookedSeats[i]=("B15");
				      i++;
				      thirtynine.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 7);  
				 thirtynine.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	forty.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 7))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 7);
					  bookedSeats[i]=("B16");
				      i++;
				      forty.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 7);  
				 forty.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortyone.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 8))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 8);
					  bookedSeats[i]=("B17");
				      i++;
				      fortyone.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 8);  
				 fortyone.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortytwo.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 8))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 8);
					  bookedSeats[i]=("B18");
				      i++;
				      fortytwo.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 8);  
				 fortytwo.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortythree.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 9))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 9);
					  bookedSeats[i]=("B19");
				      i++;
				      fortythree.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 9);  
				 fortythree.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortyfour.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 9))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 9);
					  bookedSeats[i]=("B20");
				      i++;
				      fortyfour.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 9);  
				 fortyfour.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortyfive.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 10))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 10);
					  bookedSeats[i]=("B21");
				      i++;
				      fortyfive.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 10);  
				 fortyfive.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortysix.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 10))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 10);
					  bookedSeats[i]=("B22");
				      i++;
				      fortysix.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 10);  
				 fortysix.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortyseven.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(2, 11))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(2, 11);
					  bookedSeats[i]=("B23");
				      i++;
				      fortyseven.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(2, 11);  
				 fortyseven.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});
	fortyeight.setOnMouseClicked(new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent mouseEvent) {
			if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
		      if (mouseEvent.getClickCount()==1)
		      {
		         if (T.seat.isBooked(3, 11))
				     AlertBox.display2("ERROR!", "This seat is already booked , choose another one !");
			      else {
			    	  T.seat.bookSeat(3, 11);
					  bookedSeats[i]=("B24");
				      i++;
				      fortyeight.setStyle("-fx-background-color: #ED8063;");}
			  }
				     
			  if (mouseEvent.getClickCount()==2)
		      {
				 T.seat.freeSeat(3, 11);  
				 fortyeight.setStyle("-fx-background-color: #303F52;");
			  }
				}
			}
	});	
	
	}
	return grid;
	
}
	
	public void setScene(Scene scene) {
	this.scene = scene;
	}
	public static void windowInit() {
	window.setTitle("Seating Chart");
	window.setMinWidth(800);
	window.setMinHeight(500);
	window.initModality(Modality.APPLICATION_MODAL);	
	}
	public static void display(Trip current, int capacity) {
	T = current;
	
	Parent root = Design(capacity);
	scene.setRoot(root);
	window.setScene(scene);
	window.showAndWait();
	}
	
	public static String[] getSeatsChosen() {
	return bookedSeats;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	windowInit();
	
	}
}

