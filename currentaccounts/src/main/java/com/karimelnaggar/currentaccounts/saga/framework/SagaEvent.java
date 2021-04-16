package com.karimelnaggar.currentaccounts.saga.framework;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Builder
public class SagaEvent implements ExportedEvent<String, JsonNode> {

    private final UUID sagaId;
    private final String aggregateType;
    private final String eventType;
    private final JsonNode payload;
    private final Instant timestamp;

    @Override
    public String getAggregateId() {
        return String.valueOf(sagaId);
    }

    @Override
    public String getAggregateType() {
        return aggregateType;
    }

    @Override
    public JsonNode getPayload() {
        return payload;
    }

    @Override
    public String getType() {
        return eventType;
    }

    @Override
    public Instant getTimestamp() {
        return timestamp;
    }
}
