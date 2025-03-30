package com.grupo2.diabetter.dto.insulina;

import java.time.LocalDateTime;
import java.util.UUID;

import com.grupo2.diabetter.enuns.TipoInsulina;
import com.grupo2.diabetter.model.Glicemia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsulinPostPutRequestDTO {
    private TipoInsulina tipoInsulina;
    private float unidades;
    private String horario;
    private UUID glicemia;
}