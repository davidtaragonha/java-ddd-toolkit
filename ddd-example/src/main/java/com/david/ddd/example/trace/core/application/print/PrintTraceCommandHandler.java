package com.david.ddd.example.trace.core.application.print;

import com.david.ddd.command.CommandHandler;
import com.david.ddd.example.trace.core.domain.Trace;
import com.david.ddd.example.trace.core.domain.TraceId;
import com.david.ddd.example.trace.core.domain.TraceRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PrintTraceCommandHandler implements CommandHandler<PrintTraceCommand> {
    private final TraceRepository repository;

    @Inject
    public PrintTraceCommandHandler(TraceRepository repository) {
        this.repository = repository;
    }


    @Override
    public void execute(PrintTraceCommand command) {
        TraceId traceId = TraceId.of(command.getTraceId());

        repository.save(new Trace(traceId));
    }

    @Override
    public Class<PrintTraceCommand> handle() {
        return PrintTraceCommand.class;
    }
}
