package com.example.parser.strategies;

public interface ParserStrategy<T> {
    public T parse(String sourceData);
}