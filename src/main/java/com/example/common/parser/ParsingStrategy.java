package com.example.common.parser;

public interface ParsingStrategy<T> {
    public T parse(String sourceData);
}