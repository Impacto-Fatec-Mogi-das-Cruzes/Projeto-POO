package com.forensys.core.command.concrete;

import java.util.List;
import java.util.NoSuchElementException;

import com.forensys.common.ApplicationContext;
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
        ApplicationContext context = ApplicationContext.getInstance();
        CommandOutputBuilder outputBuilder = new CommandOutputBuilder();
        List<FileSystemEntry> children = context.getCurrentDirectory().getChildren();

        if (args.size() > 1) {
            return outputBuilder.text("Too many arguments passed for command go").exitCode(CommandExitCode.FAILURE).build();
        }

        if (args.getFirst().equals("back")) {
            try {
                context.restore();
                outputBuilder.text("Back to parent directory").exitCode(CommandExitCode.SUCESS).build();
            } catch (NoSuchElementException e) {
                return outputBuilder.text("No parent directory to go back to").exitCode(CommandExitCode.FAILURE).build();
            }
        } else {
            FileSystemEntry fileSystemEntry = children.stream().filter(obj -> obj.getMetadata().getName().equals(args.getFirst())).findFirst().orElse(null);
            if (!(fileSystemEntry instanceof Directory)) {
                return outputBuilder.text("Cannot go there, please choose a directory to go").exitCode(CommandExitCode.FAILURE).build();
            }
            context.setCurrentDirectory((Directory) fileSystemEntry);
            outputBuilder.text("Changed dir to " + args.getFirst()).exitCode(CommandExitCode.SUCESS);
        }

        return outputBuilder.build();
    }

}
