package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.command;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoCommandService {

    @Autowired
    private CommandGateway commandGateway;

    public UUID criarPedido(UUID id_cliente, List<?> items, Double value){

        UUID id_command = UUID.randomUUID();
        Instant now = Instant.now();
        UUID id_aggregate = UUID.randomUUID();

        CriarPedidoCommand criarPedidoCommand = new CriarPedidoCommand(id_command,
                now, id_aggregate, id_cliente, items, value);

        commandGateway.sendAndWait(criarPedidoCommand);

        return id_aggregate;
    }

}
