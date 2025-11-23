package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.service;

import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.model.PedidoModel;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PedidoConsultaService {

    private final PedidoRepository repository;

    public PedidoConsultaService(PedidoRepository repository) {
        this.repository = repository;
    }

    public PedidoModel obterPorId(UUID idAggregate) {
        return repository.findById(idAggregate)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
