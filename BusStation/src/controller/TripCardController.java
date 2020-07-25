package controller;

import animatefx.animation.FadeIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class TripCardController {
    private String[] details;

    @FXML
    private Label city1_lbl, city2_lbl, date_lbl, time_lbl;

    public TripCardController(){}


    public void setLabels(String city1, String city2, String date, String time, String price) {
        city1_lbl.setText(city1);
        city2_lbl.setText(city2);
        date_lbl.setText(date);
        time_lbl.setText(time);

        details = new String[5];
        details[0] = city1;
        details[1] = city2;
        details[2] = date;
        details[3] = time;
        details[4] = price;

    }

    @FXML
    private void handleMouseClick(MouseEvent event){
        Stage stage = new Stage();
        stage.setMinWidth(330);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.initModality(Modality.APPLICATION_MODAL);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../ui_components/TripDetails.fxml"));
        AnchorPane layout = null;
        try {
            layout = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TripDetailsController controller = loader.getController();
        controller.setStage(stage);
        controller.setLabels(details);
        new FadeIn(layout).play();
        Scene scene = new Scene(layout);

        stage.setScene(scene);
        stage.showAndWait();
    }

}
