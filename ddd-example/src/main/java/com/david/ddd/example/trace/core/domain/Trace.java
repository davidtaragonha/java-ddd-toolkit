package com.david.ddd.example.trace.core.domain;

import com.david.ddd.domain.Aggregate;

public class Trace extends Aggregate {
    private TraceId traceId;

    public Trace(TraceId traceId) {
        this.traceId = traceId;
    }

    public TraceId getTraceId() {
        return traceId;
    }
}
