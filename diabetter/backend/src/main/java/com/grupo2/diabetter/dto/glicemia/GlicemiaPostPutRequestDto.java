package com.grupo2.diabetter.dto.glicemia;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GlicemiaPostPutRequestDto {
    @JsonProperty("measurement")
    private float measurement;
}
