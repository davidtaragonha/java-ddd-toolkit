package com.david.ddd.example.trace.core.application.print;

import com.david.ddd.command.Command;

import java.util.UUID;

public class PrintTraceCommand extends Command {
    private final String traceId;

    private PrintTraceCommand(String commandId, String traceId) {
        super(commandId);
        this.traceId = traceId;
    }

    public static PrintTraceCommand of(String traceId){
        return new PrintTraceCommand(UUID.randomUUID().toString(), traceId);
    }

    public String getTraceId() {
        return traceId;
    }
}
