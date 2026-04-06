package com.investigacao.commands;

import java.util.List;

public record ParsedCommand(
    String command,
    List<String> args
) {}
