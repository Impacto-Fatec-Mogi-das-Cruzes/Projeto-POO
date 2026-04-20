package com.example.service.parsers;

import com.example.service.parsers.strategies.ParsingCommand;
import com.example.core.commands.ParsedCommand;

public class CommandParser extends Parser<ParsedCommand> {
    private static CommandParser instance;

    private CommandParser() {
        super(new ParsingCommand());
    }

    public static CommandParser getInstance() {
        if (instance == null) {
            instance = new CommandParser();
        }
        return instance;
    }

    @Override
    public ParsedCommand parse(String rawInput) {
        return getParseStrategy().parse(rawInput);
    }
}
