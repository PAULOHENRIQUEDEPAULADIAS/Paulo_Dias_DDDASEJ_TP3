package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.dto;

import java.util.List;
import java.util.UUID;

public record CriarPedidoDTO(
        UUID id_cliente,
        List<?> items,
        Double value
) {}