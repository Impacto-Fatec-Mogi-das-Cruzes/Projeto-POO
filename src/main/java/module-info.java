module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.example.controllers to javafx.fxml;
    opens com.example.gamestate.settings to com.fasterxml.jackson.databind;
    exports com.example;
}
