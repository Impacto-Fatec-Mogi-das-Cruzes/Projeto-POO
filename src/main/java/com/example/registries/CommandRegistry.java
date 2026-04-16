package com.example.registries;

import com.example.commands.TerminalCommand;

public class CommandRegistry extends Registry<TerminalCommand> {
    private static final CommandRegistry instance = new CommandRegistry();
    
    private CommandRegistry() {
        super();
    }

    public static CommandRegistry getInstance() {
        return instance;
    }
}
