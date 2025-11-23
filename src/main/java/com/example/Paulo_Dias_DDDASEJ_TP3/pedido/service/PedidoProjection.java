package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.service;

import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.event.PedidoCriadoEvent;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.model.PedidoModel;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.repository.PedidoRepository;
import com.google.gson.Gson;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
public class PedidoProjection {

    private final PedidoRepository repository;

    public PedidoProjection(PedidoRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(PedidoCriadoEvent event) {
        PedidoModel model = new PedidoModel();
        model.setId_aggregate(event.getId_aggregate());
        model.setId_cliente(event.getId_cliente());
        model.setTimeStamp(event.getTimestamp());
        model.setValue(event.getValue());
        model.setType(event.getType());

        Gson gson = new Gson();
        model.setItemsJson(gson.toJson(event.getItems()));

        repository.save(model);
    }
}
