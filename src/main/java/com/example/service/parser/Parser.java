package com.example.service.parser;

import com.example.service.parser.strategy.ParsingStrategy;

public abstract class Parser<T> {
    private final ParsingStrategy<T> parseStrategy;

    public Parser(ParsingStrategy<T> parseStrategy) {
        this.parseStrategy = parseStrategy;
    }

    public abstract T parse(String resourceFile);

    public ParsingStrategy<T> getParseStrategy() {
        return this.parseStrategy;
    }
}
