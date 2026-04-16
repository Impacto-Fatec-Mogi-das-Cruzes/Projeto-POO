package com.example.parsers;

import com.example.commands.ParsedCommand;
import com.example.parsers.strategies.ParsingCommand;

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
