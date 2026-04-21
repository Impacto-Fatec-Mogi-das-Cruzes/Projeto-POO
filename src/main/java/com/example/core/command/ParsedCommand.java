package com.example.core.command;

import java.util.List;

public record ParsedCommand(
    String command,
    List<String> args
) {}
