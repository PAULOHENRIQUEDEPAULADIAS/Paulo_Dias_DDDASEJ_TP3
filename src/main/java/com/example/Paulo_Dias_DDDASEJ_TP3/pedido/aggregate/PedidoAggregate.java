package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.aggregate;

import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.command.CriarPedidoCommand;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.event.PedidoCriadoEvent;
import lombok.NoArgsConstructor;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;
import java.util.UUID;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class PedidoAggregate {

    @AggregateIdentifier
    private UUID id_aggregate;

    private UUID id_cliente;

    private List<?> items;

    public PedidoAggregate(CriarPedidoCommand cpc){
        if (cpc.getId_cliente() == null) {throw new IllegalArgumentException ("Pedido deve possuir vínculo com algum cliente");}
        if (cpc.getItems().isEmpty()) {throw new IllegalArgumentException("Pedido deve conter itens");}
        if (cpc.getValue() <= 0.00) { throw new IllegalArgumentException("Pedido deve conter um valor positivo");}
        String type = "PedidoCriadoEvent";
        PedidoCriadoEvent pce = new PedidoCriadoEvent(
                cpc.getId_command(),
                type,
                cpc.getTimestamp(),
                cpc.getId_aggregate(),
                cpc.getId_cliente(),
                cpc.getItems()
        );
        apply(pce);
    }

    @EventSourcingHandler
    public void eventHandler(PedidoCriadoEvent event){
        this.id_aggregate = event.getId_aggregate();
        this.id_cliente = event.getId_cliente();
        this.items = event.getItems();
    }
}
