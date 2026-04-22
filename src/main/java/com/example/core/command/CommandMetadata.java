package com.example.core.command;

public record CommandMetadata(
    String commandName,
    String helpMessageBrief,
    String helpMessageLong
) {}
