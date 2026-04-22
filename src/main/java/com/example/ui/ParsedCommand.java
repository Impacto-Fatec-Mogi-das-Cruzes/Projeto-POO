package com.example.ui;

import java.util.List;

public record ParsedCommand(
    String command,
    List<String> args
) {}
