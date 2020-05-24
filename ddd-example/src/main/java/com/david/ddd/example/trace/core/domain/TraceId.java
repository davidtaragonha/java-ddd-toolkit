package com.david.ddd.example.trace.core.domain;

import com.david.ddd.domain.ValueObject;

import java.util.Objects;

public class TraceId extends ValueObject {
    private final String id;

    private TraceId(String id) {
        this.id = id;
    }

    public static TraceId of(String traceId) {
        return new TraceId(traceId);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TraceId traceId = (TraceId) o;
        return Objects.equals(id, traceId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
