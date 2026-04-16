package com.example.parsers.strategies;

public interface ParsingStrategy<T> {
    public T parse(String sourceData);
}