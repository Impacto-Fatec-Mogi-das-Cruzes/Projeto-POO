package com.example.service.parsers.strategies;

public interface ParsingStrategy<T> {
    public T parse(String sourceData);
}