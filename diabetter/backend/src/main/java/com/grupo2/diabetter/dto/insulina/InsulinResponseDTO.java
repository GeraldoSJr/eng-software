package com.grupo2.diabetter.dto.insulina;

import java.time.LocalDateTime;
import java.util.UUID;

import com.grupo2.diabetter.enuns.TipoInsulina;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsulinResponseDTO {
    private UUID insulidaId;
    private TipoInsulina tipoInsulina;
    private float unidades;
    private UUID glicemia;
    private String horario;
    private LocalDateTime dataAplicacao;
}