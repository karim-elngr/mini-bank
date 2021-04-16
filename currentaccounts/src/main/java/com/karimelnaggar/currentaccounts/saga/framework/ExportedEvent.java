package com.karimelnaggar.currentaccounts.saga.framework;

import java.time.Instant;

public interface ExportedEvent<AggregateId, Payload> {

    AggregateId getAggregateId();

    String getAggregateType();

    Payload getPayload();

    String getType();

    Instant getTimestamp();
}
