package com.example.loaders.strategies;

public interface ParserStrategy<T> {
    public T parse(String sourceData);
}