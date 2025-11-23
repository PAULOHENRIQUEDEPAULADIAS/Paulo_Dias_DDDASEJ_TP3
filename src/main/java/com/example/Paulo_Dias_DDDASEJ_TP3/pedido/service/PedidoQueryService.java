package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.service;

import org.axonframework.eventsourcing.eventstore.DomainEventStream;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoQueryService {

    private final EventStore eventStore;

    public PedidoQueryService(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public List<Object> listarEventoPorId(UUID id_aggregate) {

        DomainEventStream stream = eventStore.readEvents(id_aggregate.toString());
        if (!stream.hasNext()) {
            throw new RuntimeException("Nenhum evento encontrado para o aggregate: " + id_aggregate);
        }
        List<Object> eventos = new ArrayList<>();
        stream.asStream().forEach(domainEvent -> {
            eventos.add(domainEvent.getPayload());
        });
        return eventos;
    }
}
