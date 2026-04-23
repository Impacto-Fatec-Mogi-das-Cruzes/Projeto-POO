package com.forensys.core.command.concrete;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import com.forensys.core.SystemContext;
import com.forensys.core.command.CommandExitCode;
import com.forensys.core.command.CommandMetadata;
import com.forensys.core.command.CommandOutput;
import com.forensys.core.command.CommandOutputBuilder;
import com.forensys.core.command.TerminalCommand;
import com.forensys.core.filestructure.FileSystemEntry;
import com.forensys.core.filestructure.concrete.Directory;

public class GoCommand extends TerminalCommand {

    public GoCommand() {
        super(new CommandMetadata("go", "Changes the current directory", "hint: you can use back, if you want to go back"));
    }

    // TODO: Needs refactoring...
    @Override
    public CommandOutput run(List<String> args) {
        SystemContext context = SystemContext.getInstance();
        CommandOutputBuilder outputBuilder = new CommandOutputBuilder();
        Map<String, FileSystemEntry> children = context.getCurrentDirectory().getChildren();

        if (args.size() > 1) {
            return outputBuilder.text("Too many arguments passed for command go").exitCode(CommandExitCode.FAILURE).build();
        }

        if (args.getFirst().equals("back")) {
            try {
                context.restore();
            } catch (NoSuchElementException e) {
                return outputBuilder.text("No parent directory to go back to").exitCode(CommandExitCode.FAILURE).build();
            }
        } else {
            FileSystemEntry fileSystemEntry = children.get(args.getFirst());
            if (!(fileSystemEntry instanceof Directory)) {
                return outputBuilder.text("Cannot go there, please choose a directory to go").exitCode(CommandExitCode.FAILURE).build();
            }
            context.setCurrentDirectory((Directory) fileSystemEntry);
        }

        return outputBuilder.exitCode(CommandExitCode.SUCESS).build();
    }

}
