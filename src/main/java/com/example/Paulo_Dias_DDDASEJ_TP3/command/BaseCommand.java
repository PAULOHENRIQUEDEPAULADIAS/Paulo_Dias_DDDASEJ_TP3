package com.example.Paulo_Dias_DDDASEJ_TP3.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class BaseCommand {

    private UUID id_command;

    private Instant timestamp;

    @TargetAggregateIdentifier
    private UUID id_aggregate;

}
