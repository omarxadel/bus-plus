package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;




public class TripDetailsController {
    private Stage stage;
    private double xOffset, yOffset;

    @FXML
    private AnchorPane root;
    @FXML
    private Label city1, city2, date, time, price;
    @FXML
    private Button cancel_btn, book_btn;


    public TripDetailsController(){}

    public void setStage(Stage stage){
        this.stage = stage;
        // MOVE THE WINDOW
        root.setOnMousePressed(mouseEvent -> {
            xOffset = stage.getX() - mouseEvent.getScreenX();
            yOffset = stage.getY() - mouseEvent.getScreenY();
        });

        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() + xOffset);
            stage.setY(mouseEvent.getScreenY() + yOffset);
        });
    }

    public void setLabels(String[] details){
        city1.setText(details[0]);
        city2.setText(details[1]);
        date.setText(details[2]);
        time.setText(details[3]);
        price.setText(details[4]);
    }

    @FXML
    private void handleMouseClick(MouseEvent event){
        if(event.getSource() == book_btn){
            // TODO: BOOK A TRIP RESERVATION
        }
        if(event.getSource() == cancel_btn){
            stage.close();
        }
    }
}
