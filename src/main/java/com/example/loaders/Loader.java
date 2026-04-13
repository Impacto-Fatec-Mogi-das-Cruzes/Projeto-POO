package com.example.loaders;

import com.example.loaders.strategies.ParserStrategy;

public abstract class Loader<T> {
    private final ParserStrategy<T> parseStrategy;

    public Loader(ParserStrategy<T> parseStrategy) {
        this.parseStrategy = parseStrategy;
    }

    public abstract T parse(String resourceFile);

    public ParserStrategy<T> getParseStrategy() {
        return this.parseStrategy;
    }
}
