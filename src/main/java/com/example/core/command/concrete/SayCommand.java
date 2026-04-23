package com.example.core.command.concrete;

import java.util.List;

import com.example.core.command.CommandExitCode;
import com.example.core.command.CommandMetadata;
import com.example.core.command.CommandOutput;
import com.example.core.command.CommandOutputBuilder;
import com.example.core.command.TerminalCommand;

public class SayCommand extends TerminalCommand {

    public SayCommand() {
        super(new CommandMetadata("say", "Make your terminal say something", "Using this command you can make the terminal say something by doing 'say {text}'"));
    }

    @Override
    public CommandOutput run(List<String> args) {
        CommandOutputBuilder outputBuilder = new CommandOutputBuilder();

        String phrase = "";
        for (String arg : args) {
            phrase += arg + " ";
        }
        
        outputBuilder.text(phrase).exitCode(CommandExitCode.SUCESS);
        return outputBuilder.build();
    }
}
