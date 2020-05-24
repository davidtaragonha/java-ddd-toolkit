package com.david.ddd.example.trace.core.infrastructure;

import com.david.ddd.example.trace.core.domain.Trace;
import com.david.ddd.example.trace.core.domain.TraceRepository;

import javax.enterprise.context.ApplicationScoped;
import java.time.ZonedDateTime;

@ApplicationScoped
public class TraceRepositoryConsole implements TraceRepository {
    @Override
    public Trace save(Trace trace) {
        System.out.println("Trace with Id:"+ trace.getTraceId().getId()+" "+ ZonedDateTime.now());
        return trace;
    }
}
