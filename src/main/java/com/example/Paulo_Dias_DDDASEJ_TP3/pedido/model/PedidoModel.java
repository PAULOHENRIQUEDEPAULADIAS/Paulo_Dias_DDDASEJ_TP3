package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "Pedido")
@Getter
@Setter
public class PedidoModel {
    @Id
    private UUID id_aggregate;
    private UUID id_cliente;
    private String itemsJson;
    private Double value;
    private Instant timeStamp;
    private String type;
}
