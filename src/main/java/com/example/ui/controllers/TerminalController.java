package com.example.ui.controllers;

import com.example.core.commands.ParsedCommand;
import com.example.core.commands.TerminalCommand;
import com.example.core.commands.concretes.DuckCommand;
import com.example.service.parsers.CommandParser;
import com.example.service.registries.CommandRegistry;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TerminalController {
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private VBox outputArea;

    @FXML
    private TextField inputField;

    @FXML
    private void initialize() {
        registerAllCommands();
    }
    private void registerAllCommands() {
        CommandRegistry commandRegistry =  CommandRegistry.getInstance();
        DuckCommand duckCommand = new DuckCommand();
        commandRegistry.register(duckCommand.getCommandName(), duckCommand);
    }

    @FXML
    private void commandEntered() {
        String rawInput = inputField.getText().trim();
        if (rawInput.isEmpty()) return;

        CommandParser commandParser = CommandParser.getInstance();
        ParsedCommand parsedCommand = commandParser.parse(rawInput);
        TerminalCommand command = CommandRegistry.getInstance().get(parsedCommand.command());
        
        String[] output;
        String styleClass = "";
        if (command != null) {
            command.run(parsedCommand.args());
            output = command.getOutput().split("\n");
            styleClass = "term-line-system";
        } else {
            output = "Invalid Command, please enter a valid command or use the {help} command for more information".split("\n");
            styleClass = "term-line-error";
        }

        Label lineLabel = null;
        
        for (String line : output) {
            lineLabel = new Label(line);
            lineLabel.getStyleClass().add(styleClass);
            lineLabel.setMaxWidth(Double.MAX_VALUE);
            outputArea.getChildren().add(lineLabel);
        }
        inputField.clear();
        Platform.runLater(() -> scrollPane.setVvalue(1.0));
    }

    @FXML
    private void exitGame() {
        Platform.exit();
    }
}
