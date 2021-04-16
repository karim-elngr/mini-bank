package com.karimelnaggar.currentaccounts.service.transactions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.karimelnaggar.currentaccounts.saga.framework.Saga;
import com.karimelnaggar.currentaccounts.saga.framework.SagaBase;
import com.karimelnaggar.currentaccounts.saga.framework.SagaStepMessage;
import com.karimelnaggar.currentaccounts.saga.framework.internal.SagaState;
import org.springframework.context.ApplicationEventPublisher;

import static com.karimelnaggar.currentaccounts.service.transactions.TransactionPlacementSaga.TRANSACTION_CREATION;

@Saga(type = "transaction-placement", stepIds = {TRANSACTION_CREATION})
public class TransactionPlacementSaga extends SagaBase {

    protected static final String TRANSACTION_CREATION = "transaction-creation";

    private static final String REQUEST = "REQUEST";

    public TransactionPlacementSaga(ApplicationEventPublisher applicationEventPublisher, SagaState state) {
        super(applicationEventPublisher, state);
    }

    public static JsonNode payloadFor(Transaction topUpTransaction) {

        final ObjectMapper objectMapper = new ObjectMapper();

        final ObjectNode payload = objectMapper.createObjectNode();

        payload.put("transaction-id", topUpTransaction.getTransactionId());
        payload.put("current-account-id", topUpTransaction.getCurrentAccountId());
        payload.put("amount", topUpTransaction.getAmount());
        payload.put("currency-code", topUpTransaction.getCurrencyCode());
        payload.put("type", REQUEST);

        return payload;
    }

    @Override
    protected SagaStepMessage getStepMessage(String id) {

        switch (id) {
            case TRANSACTION_CREATION:
                return new SagaStepMessage(TRANSACTION_CREATION, REQUEST, getPayload());
        }

        throw new IllegalStateException("Illegal Saga Step Id: " + id);
    }
}
