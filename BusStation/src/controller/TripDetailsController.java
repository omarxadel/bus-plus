package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class TripDetailsController {
    @FXML
    private Label city1_lbl, city2_lbl, date_lbl, time_lbl;

    public TripDetailsController(){
    }


    public void setLabels(String city1, String city2, String date, String time) {
        city1_lbl.setText(city1);
        city2_lbl.setText(city2);
        date_lbl.setText(date);
        time_lbl.setText(time);
    }

}
