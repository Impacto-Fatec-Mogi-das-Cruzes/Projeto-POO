module com.example {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;

    opens com.example.ui.controller to javafx.fxml;
    opens com.example.core.setting to com.fasterxml.jackson.databind;
    opens com.example.core.filestructure to com.fasterxml.jackson.databind;
    opens com.example.core.filestructure.concrete to com.fasterxml.jackson.databind;
    exports com.example;
}
