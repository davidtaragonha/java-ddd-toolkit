package com.david.ddd.command;

public interface CommandHandler<T extends Command> {
    void execute(T command);
    Class<T> handle();
}
