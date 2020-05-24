package com.david.ddd.command;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class CommandBusInMemory implements CommandBus {
    private final Map<Class<? extends Command>, CommandHandler> handlerMap;

    @Inject
    public CommandBusInMemory(Instance<CommandHandler<? extends Command>> commandHandlers) {
        handlerMap = commandHandlers
            .stream()
            .collect(Collectors.toMap(CommandHandler::handle, Function.identity()));
    }


    @Override
    @SuppressWarnings("unchecked")
    public void push(Command command) {
        handlerMap
            .computeIfAbsent(
                    command.getClass(),
                    clazz -> {throw new IllegalStateException();}
            ).execute(command);
    }
}
