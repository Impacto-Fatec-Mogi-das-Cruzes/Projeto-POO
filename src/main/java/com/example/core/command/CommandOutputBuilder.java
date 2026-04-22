package com.example.core.command;

import java.util.ArrayList;
import java.util.List;

public class CommandOutputBuilder {
    private List<String> segments = new ArrayList<>();
    private CommandExitCode exitCode = CommandExitCode.SUCESS;
    private boolean clearScreen = false;

    public CommandOutputBuilder text(String text) {
        segments.add(text);
        return this;
    }

    public CommandOutputBuilder newLine() {
        segments.add("\n");
        return this;
    }

    public void exitCode(CommandExitCode failure) {
        this.exitCode = failure;
    }
    
    public void clearScreen(boolean clearScreen) {
        this.clearScreen = clearScreen;
    }

    public CommandOutput build() {
        return new CommandOutput(segments, exitCode, clearScreen);
    }
}
