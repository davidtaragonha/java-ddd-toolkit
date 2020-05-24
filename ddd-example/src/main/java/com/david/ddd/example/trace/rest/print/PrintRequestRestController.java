package com.david.ddd.example.trace.rest.print;

import com.david.ddd.command.CommandBus;
import com.david.ddd.example.trace.core.application.print.PrintTraceCommand;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/trace")
public class PrintRequestRestController {
    private final CommandBus commandBus;

    @Inject
    public PrintRequestRestController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @POST
    @Path("print")
    @Produces(MediaType.APPLICATION_JSON)
    public void print(PrintRequest printRequest) {
        commandBus.push(PrintTraceCommand.of(printRequest.getTraceId()));
    }
}
