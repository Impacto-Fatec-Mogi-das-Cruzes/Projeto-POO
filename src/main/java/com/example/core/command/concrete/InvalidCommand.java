package com.example.core.command.concrete;

import java.util.List;

import com.example.core.command.CommandExitCode;
import com.example.core.command.CommandMetadata;
import com.example.core.command.CommandOutput;
import com.example.core.command.CommandOutputBuilder;
import com.example.core.command.TerminalCommand;

public class InvalidCommand extends TerminalCommand {

    public InvalidCommand() {
        super(new CommandMetadata("", "", ""));
    }

    @Override
    public CommandOutput run(List<String> args) {
        CommandOutputBuilder outputBuilder = new CommandOutputBuilder();
        
        outputBuilder
            .text("Invalid Command, plase input a valid command")
            .exitCode(CommandExitCode.FAILURE);
            
        return outputBuilder.build();
    }

}
