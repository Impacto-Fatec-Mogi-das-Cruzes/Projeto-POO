package com.example.service.parser;

import com.example.core.command.ParsedCommand;
import com.example.service.parser.strategy.ParsingCommand;

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
