package com.david.ddd.command;

public interface CommandBus {
     void push(Command command);
}
