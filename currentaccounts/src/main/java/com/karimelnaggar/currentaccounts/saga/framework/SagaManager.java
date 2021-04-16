package com.karimelnaggar.currentaccounts.saga.framework;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.karimelnaggar.currentaccounts.saga.framework.internal.SagaState;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SagaManager {

    private final ApplicationEventPublisher applicationEventPublisher;
    private final EntityManager entityManager;

    public <S extends SagaBase> S begin(Class<S> sagaType, JsonNode payload) {

        try {

            final UUID sagaId = UUID.randomUUID();

            final SagaState state = SagaState.builder()
                    .id(sagaId)
                    .type(sagaType.getAnnotation(Saga.class).type())
                    .payload(payload)
                    .sagaStatus(SagaStatus.STARTED)
                    .stepStatus(JsonNodeFactory.instance.objectNode())
                    .build();

            entityManager.persist(state);

            final S saga = sagaType.getConstructor(ApplicationEventPublisher.class, SagaState.class).newInstance(applicationEventPublisher, state);
            saga.advance();
            return saga;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
