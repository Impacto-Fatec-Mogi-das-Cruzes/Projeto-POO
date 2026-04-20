module com.example {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;

    opens com.example.controllers to javafx.fxml;
    opens com.example.gamestate.settings to com.fasterxml.jackson.databind;
    opens com.example.gamestate.filestructure to com.fasterxml.jackson.databind;
    opens com.example.gamestate.filestructure.concretes to com.fasterxml.jackson.databind;
    exports com.example;
}
