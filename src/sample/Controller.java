package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;

public class Controller {
    private File dir = new File("C:\\Users\\pwbla\\Desktop\\Scripts");

    @FXML
    private Button squareGame;

    @FXML
    private Button spaceInvaders;

    @FXML
    private Button streetview;


    @FXML
    void onStreetview() {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "streetview.cmd");
        pb.directory(dir);
        try {
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onSpaceInvaders() {

    }

    @FXML
    void on2048() {

    }
}