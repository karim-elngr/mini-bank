package com.karimelnaggar.currentaccounts.saga.framework.outbox;

import com.fasterxml.jackson.databind.JsonNode;
import com.karimelnaggar.currentaccounts.saga.framework.ExportedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SagaEventListener {

    private final EntityManager em;

    @EventListener
    public void handleOutboxEvent(ExportedEvent<String, JsonNode> event) {

        UUID uuid = UUID.randomUUID();

        final OutboxEventEntity outboxEvent = new OutboxEventEntity(
                event.getAggregateType(),
                event.getAggregateId(),
                event.getType(),
                event.getPayload(),
                event.getTimestamp()
        );

        em.persist(outboxEvent);

        /*
         * Delete the event once written, so that the outbox doesn't grow.
         * The CDC eventing polls the database log entry and not the table in the database.
         */
        em.remove(outboxEvent);
    }
}
