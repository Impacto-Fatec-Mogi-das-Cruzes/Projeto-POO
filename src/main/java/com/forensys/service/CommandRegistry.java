package com.forensys.service;

import com.forensys.common.Registry;
import com.forensys.core.command.TerminalCommand;

public class CommandRegistry extends Registry<TerminalCommand> {
    private static final CommandRegistry instance = new CommandRegistry();
    
    private CommandRegistry() {
        super();
    }

    public static CommandRegistry getInstance() {
        return instance;
    }
}
