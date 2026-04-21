package com.example.service.parser.strategy;

public interface ParsingStrategy<T> {
    public T parse(String sourceData);
}