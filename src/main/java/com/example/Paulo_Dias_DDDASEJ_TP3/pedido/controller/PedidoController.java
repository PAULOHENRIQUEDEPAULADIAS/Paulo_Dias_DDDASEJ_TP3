package com.example.Paulo_Dias_DDDASEJ_TP3.pedido.controller;

import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.command.PedidoCommandService;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.dto.CriarPedidoDTO;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.model.PedidoModel;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.service.PedidoConsultaService;
import com.example.Paulo_Dias_DDDASEJ_TP3.pedido.service.PedidoQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoCommandService service;

    private final PedidoQueryService eventStoreQuery;
    private final PedidoConsultaService jpaQuery;

    public PedidoController(PedidoCommandService service, PedidoQueryService eventStoreQuery, PedidoConsultaService jpaQuery) {
        this.service = service;
        this.eventStoreQuery = eventStoreQuery;
        this.jpaQuery = jpaQuery;
    }

    @GetMapping("/eventos/{id}")
    public List<Object> listarEventos(@PathVariable UUID id) {
        return eventStoreQuery.listarEventoPorId(id);
    }

    @GetMapping("/{id}")
    public PedidoModel buscarPorId(@PathVariable UUID id) {
        return jpaQuery.obterPorId(id);
    }

    @PostMapping("/")
    public ResponseEntity<UUID> criarPedido(@RequestBody CriarPedidoDTO dto) {

        UUID idGerado = service.criarPedido(dto.id_cliente(), dto.items(), dto.value());

        return ResponseEntity.ok(idGerado);
    }

}
