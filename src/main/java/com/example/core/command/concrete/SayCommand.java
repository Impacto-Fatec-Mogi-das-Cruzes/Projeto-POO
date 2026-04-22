package com.example.core.command.concrete;

import java.util.List;

import com.example.core.command.CommandMetadata;
import com.example.core.command.CommandOutput;
import com.example.core.command.TerminalCommand;

public class SayCommand extends TerminalCommand {

    public SayCommand() {
        super(new CommandMetadata("say", "Make your terminal say something", "Using this command you can make the terminal say something by doing 'say {text}'"));
    }

    @Override
    public CommandOutput run(List<String> args) {
        String phrase = "";
        for (String arg : args) {
            phrase.concat(arg);
        }
        builder.text(phrase);
        return builder.build();
    }
}
