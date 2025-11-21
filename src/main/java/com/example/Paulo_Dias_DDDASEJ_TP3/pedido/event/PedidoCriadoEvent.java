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

    public PedidoCriadoEvent(UUID id_event, String type, Instant timestamp,
                             Long version, UUID id_aggregate, UUID id_cliente,
                             List<?> items) {
        super(id_event, type, timestamp, version, id_aggregate);
        this.id_cliente = id_cliente;
        this.items = items;
    }
}
