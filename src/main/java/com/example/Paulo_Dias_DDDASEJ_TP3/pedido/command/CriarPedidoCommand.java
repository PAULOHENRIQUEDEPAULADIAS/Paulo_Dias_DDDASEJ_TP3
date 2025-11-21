package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.command;

import com.example.Paulo_Dias_DDDASEJ_TP3.command.BaseCommand;
import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
public class CriarPedidoCommand extends BaseCommand {

    private UUID id_cliente;

    private List<?> items;


    public CriarPedidoCommand(UUID id_command, Instant timestamp, UUID id_aggregate,
                              UUID id_cliente, List<?> items) {
        super(id_command, timestamp, id_aggregate);
        this.id_cliente = id_cliente;
        this.items = items;
    }
}
