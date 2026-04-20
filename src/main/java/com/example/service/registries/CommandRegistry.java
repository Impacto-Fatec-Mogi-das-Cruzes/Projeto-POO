package com.example.service.registries;

import com.example.core.commands.TerminalCommand;

public class CommandRegistry extends Registry<TerminalCommand> {
    private static final CommandRegistry instance = new CommandRegistry();
    
    private CommandRegistry() {
        super();
    }

    public static CommandRegistry getInstance() {
        return instance;
    }
}
