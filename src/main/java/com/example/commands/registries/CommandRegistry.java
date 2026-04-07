package com.example.commands.registries;

import java.util.HashMap;
import java.util.Map;

import com.example.commands.Command;
import com.example.commands.concretes.DuckCommand;

// Registry Pattern
public class CommandRegistry {
    private static final CommandRegistry instance = new CommandRegistry();
    private Map<String, Command> commandRegistry;
    
    private CommandRegistry() {
        commandRegistry = new HashMap<>();
        register("duck", new DuckCommand());
    }

    public static CommandRegistry getInstance() {
        return instance;
    }

    public void register(String key, Command command) {
        commandRegistry.put(key, command);
    }

    public Command get(String key) {
        return commandRegistry.get(key);
    }
}
