package com.example.parser;

import com.example.commands.ParsedCommand;
import com.example.parser.strategies.ParserCommand;

public class CommandLoader extends Loader<ParsedCommand> {
    private static CommandLoader instance;

    private CommandLoader() {
        super(new ParserCommand());
    }

    public static CommandLoader getInstance() {
        if (instance == null) {
            instance = new CommandLoader();
        }
        return instance;
    }

    @Override
    public ParsedCommand parse(String rawInput) {
        return getParseStrategy().parse(rawInput);
    }
}
