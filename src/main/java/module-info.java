module com.example.fxmessenger {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.lanmessenger.fxmessenger to javafx.fxml;
    exports com.lanmessenger.fxmessenger;
}