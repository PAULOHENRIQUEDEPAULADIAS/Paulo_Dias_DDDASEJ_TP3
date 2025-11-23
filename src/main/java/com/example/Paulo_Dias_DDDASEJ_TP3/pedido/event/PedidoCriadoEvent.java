package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.event;

import com.example.Paulo_Dias_DDDASEJ_TP3.event.BaseEvent;
import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
public class PedidoCriadoEvent extends BaseEvent {

    private List<?> items;

    private UUID id_cliente;

    private Double value;

    public PedidoCriadoEvent(UUID id_event, String type, Instant timestamp,
                             UUID id_aggregate, UUID id_cliente,
                             List<?> items, Double value) {
        super(id_event, type, timestamp, id_aggregate);
        this.id_cliente = id_cliente;
        this.items = items;
        this.value = value;
    }
}
