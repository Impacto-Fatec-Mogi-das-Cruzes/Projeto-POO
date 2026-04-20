package com.example.core.commands;

import java.util.List;

public record ParsedCommand(
    String command,
    List<String> args
) {}
