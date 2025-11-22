package com.example.Paulo_Dias_DDDASEJ_TP3.event;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.Instant;
import java.util.UUID;


@Getter
@AllArgsConstructor
@MappedSuperclass
public class BaseEvent {
    @Id
    private UUID id_event;

    @Column(name = "tipo")
    private String type;

    @Column(name = "timestamp")
    private Instant timestamp;

    @Column(name = "id_agregado")
    private UUID id_aggregate;
}