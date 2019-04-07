package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SeatsDesign {
	Seat s;
	int SNum;
	
	
	public SeatsDesign(int sNum) {
		SNum = sNum;
	}

	public void Design (int sNum)
	{
		sNum=s.capacity;
		Stage NewWindow=new Stage ();
		GridPane grid = new  GridPane ();
		
		if (SNum == 12)
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
			
			grid.setVgap(7); 
		    grid.setHgap(7);
		
			
		}
		if (SNum == 46)
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
			
			grid.setVgap(7); 
		    grid.setHgap(7);
		    
			grid.setAlignment(Pos.CENTER);
		}
		Scene scene = new Scene(grid,600,400);
		NewWindow.setTitle("Reserve your place");
		NewWindow.initModality(Modality.APPLICATION_MODAL);
		
		
		
		
	}
}