package com.example.core.command.concrete;

import java.util.List;

import com.example.core.command.CommandExitCode;
import com.example.core.command.CommandMetadata;
import com.example.core.command.CommandOutput;
import com.example.core.command.CommandOutputBuilder;
import com.example.core.command.TerminalCommand;

public class DuckCommand extends TerminalCommand{

    public DuckCommand() {
        super(new CommandMetadata("duck", "shows a duck", "Yeah, it just shows a duck idk what more to say"));
    }

    // TODO: find a way to deal with args
    @Override
    public CommandOutput run(List<String> args) {        
        CommandOutputBuilder outputBuilder = new CommandOutputBuilder();
        
        for (String arg : args) {
            if (arg.equals("no")) {
                outputBuilder.text("Duck said no, so no").exitCode(CommandExitCode.FAILURE);
                return outputBuilder.build();
            }
        }
        
        outputBuilder
            .text("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡶⠿⠿⠷⣶⣄⠀⠀⠀⠀⠀")
            .text("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡿⠁⠀⠀⢀⣀⡀⠙⣷⡀⠀⠀⠀")
            .text("⠀⠀⠀⡀⠀⠀⠀⠀⠀⢠⣿⠁⠀⠀⠀⠘⠿⠃⠀⢸⣿⣿⣿⣿   Quack")
            .text("⠀⣠⡿⠛⢷⣦⡀⠀⠀⠈⣿⡄⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⠟")
            .text("⢰⡿⠁⠀⠀⠙⢿⣦⣤⣤⣼⣿⣄⠀⠀⠀⠀⠀⢴⡟⠛⠋⠁⠀")
            .text("⣿⠇⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠈⣿⡀⠀⠀⠀")
            .text("⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡇⠀⠀⠀")
            .text("⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡇⠀⠀⠀")
            .text("⠸⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡿⠀⠀⠀⠀")
            .text("⠀⠹⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣰⡿⠁⠀⠀⠀⠀")
            .text("⠀⠀⠀⠉⠙⠛⠿⠶⣶⣶⣶⣶⣶⠶⠿⠟⠛⠉⠀⠀⠀⠀⠀⠀")
            .exitCode(CommandExitCode.SUCESS);
        
        return outputBuilder.build();
    }
}
