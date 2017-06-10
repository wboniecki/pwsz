package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.Random;

public class Controller {
    private int count = 0;
    @FXML
    Button runButton;

    @FXML
    private void initialize() {
        runButton.setOnMouseEntered(event -> changeThePositionOfButton());
    }

    private void changeThePositionOfButton() {
        count++;
        Random random = new Random();
        runButton.setTranslateX(random.nextInt(300));
        runButton.setTranslateY(random.nextInt(250));
        if(count>10 && count<20) {
            runButton.setText("ZOSTAW TO!");
        }
        if (count > 20) {
            runButton.setText("ZDENERWOWAŁEŚ MNIE!");
            runButton.setStyle("-fx-background-color: #ff0000; -fx-font-weight: bold;");
        }
    }
}
