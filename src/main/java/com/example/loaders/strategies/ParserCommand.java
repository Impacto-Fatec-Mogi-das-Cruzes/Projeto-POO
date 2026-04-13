package com.example.loaders.strategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.commands.ParsedCommand;

public class ParserCommand implements ParserStrategy<ParsedCommand>{

    @Override
    public ParsedCommand parse(String rawInput) {
        String command;
        List<String> args = new ArrayList<>(Arrays.asList(rawInput.split("\\s+")));

        command = args.getFirst();
        args.remove(command);

        return new ParsedCommand(command, args);
    }

}
