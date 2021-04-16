package com.karimelnaggar.currentaccounts.saga.framework;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SagaStepMessage {

    public String type;
    public String eventType;
    public JsonNode payload;
}
