package com.lanmessenger.fxmessenger;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField msg_field;

    @FXML
    private Button send_button;

    @FXML
    private TextArea text_field;

    @FXML
    void initialize() {
        send_button.setOnAction(event -> {
            System.out.println(msg_field.getText());
            text_field.setText(msg_field.getText());
        });
    }
}