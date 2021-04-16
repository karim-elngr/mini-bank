package com.karimelnaggar.currentaccounts.saga.framework.internal;

import com.fasterxml.jackson.databind.JsonNode;
import com.karimelnaggar.currentaccounts.saga.framework.SagaStatus;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;

@TypeDef(name = "jsonb", typeClass = JsonNodeBinaryType.class)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SagaState {

    @Id
    private UUID id;

    @Version
    private int version;

    private String type;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private JsonNode payload;

    private String currentStep;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private JsonNode stepStatus;

    @Enumerated(EnumType.STRING)
    private SagaStatus sagaStatus;
}
