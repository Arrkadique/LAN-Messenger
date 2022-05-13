package com.lanmessenger.fxmessenger;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.lanmessenger.network.TCPConnection;
import com.lanmessenger.network.TCPConnectionListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller implements TCPConnectionListener {

    private final int PORT = 8189;
    private final String IP = "172.17.0.1";
    private TCPConnection connection;

    @FXML
    private Button server_button;

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
        try {
            connection = new TCPConnection(this, IP, PORT)
        } catch (IOException e) {
            printMsg("Connection exception: " + e.getMessage());
        }
        send_button.setOnAction(event -> {
            if(text_field.getText().equals("")){

            }else{
                connection.sendString(msg_field.getText());
                msg_field.setText("");
            }
        });
        server_button.setOnAction(event -> {
        });
    }

    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Connection is ready");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMsg(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMsg("Connection lost");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        printMsg("Connection exception: " + e.getMessage());
    }

    private void printMsg(String msg){
        text_field.appendText(msg + "\n");
    }
}