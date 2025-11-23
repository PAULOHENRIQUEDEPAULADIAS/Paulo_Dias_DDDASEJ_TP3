package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.repository;

import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.model.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<PedidoModel, UUID> {
}
