package com.david.ddd.command;

public abstract class Command {
    protected final String commandId;

    protected Command(String commandId) {
        this.commandId = commandId;
    }

    public String getCommandId() {
        return commandId;
    }
}
