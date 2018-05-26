package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class Controller {

    @FXML
    private Button games;

    @FXML
    private Button streetview;


    @FXML
    void onStreetview() {
        new ArduinoChatter("street");
    }

    @FXML
    void onGames() {
        new ArduinoChatter("games");
    }
}