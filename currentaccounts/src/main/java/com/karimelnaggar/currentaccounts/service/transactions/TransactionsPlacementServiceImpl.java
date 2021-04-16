package com.karimelnaggar.currentaccounts.service.transactions;

import com.karimelnaggar.currentaccounts.saga.framework.SagaManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionsPlacementServiceImpl implements TransactionsPlacementService {

    private final SagaManager sagaManager;

    @Override
    public void placeNewTransaction(Transaction topUpTransaction) {

        sagaManager.begin(TransactionPlacementSaga.class, TransactionPlacementSaga.payloadFor(topUpTransaction));
    }
}
