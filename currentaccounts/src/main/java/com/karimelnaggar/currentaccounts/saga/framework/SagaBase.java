package com.karimelnaggar.currentaccounts.saga.framework;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.karimelnaggar.currentaccounts.saga.framework.internal.SagaState;
import com.karimelnaggar.currentaccounts.saga.framework.internal.SagaStepStatus;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public abstract class SagaBase {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final SagaState state;

    protected SagaBase(ApplicationEventPublisher applicationEventPublisher, SagaState state) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.state = state;
    }

    protected final void advance() {

        String nextStep = getNextStep();

        if (nextStep == null) {

            state.setCurrentStep(null);
            return;
        }

        final SagaStepMessage stepEvent = getStepMessage(nextStep);
        applicationEventPublisher.publishEvent(new SagaEvent(
                getId(),
                stepEvent.type,
                stepEvent.eventType,
                stepEvent.payload,
                Instant.now()
        ));

        ObjectNode stepStatus = (ObjectNode) state.getStepStatus();
        stepStatus.put(nextStep, SagaStepStatus.STARTED.name());

        state.setCurrentStep(nextStep);
    }

    private String getNextStep() {

        if (getCurrentStep() == null) {

            return getStepIds().get(0);
        }

        int idx = getStepIds().indexOf(getCurrentStep());

        if (idx < 0 || idx >= getStepIds().size() - 1) {

            return null;
        }

        return getStepIds().get(idx + 1);
    }

    protected String getCurrentStep() {

        return state.getCurrentStep();
    }

    public final UUID getId() {

        return state.getId();
    }

    public final List<String> getStepIds() {

        return Arrays.asList(getClass().getAnnotation(Saga.class).stepIds());
    }

    public final JsonNode getPayload() {

        return state.getPayload();
    }

    protected abstract SagaStepMessage getStepMessage(String id);
}
