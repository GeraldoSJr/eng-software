package com.grupo2.diabetter.service.insulina;

import com.grupo2.diabetter.dto.insulina.InsulinPostPutRequestDTO;
import com.grupo2.diabetter.dto.insulina.InsulinResponseDTO;
import com.grupo2.diabetter.exception.CommerceException;
import com.grupo2.diabetter.model.Insulina;
import com.grupo2.diabetter.repository.InsulinRepository;
import com.grupo2.diabetter.service.insulina.interfaces.IAtualizarInsulinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AtualizarInsulinService implements IAtualizarInsulinaService {

    @Autowired
    private InsulinRepository insulinRepository;

    @Override
    public InsulinResponseDTO atualizarInsulina(UUID id, InsulinPostPutRequestDTO requestDTO) {

        if (requestDTO.getTipoInsulina() == null) {
            throw new CommerceException("Tipo de insulina inválido");
        }

        if (requestDTO.getUnidades() <= 0) {
            throw new CommerceException("Unidades de insulina inválidas");
        }

        if (requestDTO.getHorario() == null) {
            throw new CommerceException("Horário de insulina inválido");
        }

        Insulina insulina = insulinRepository.findById(id)
                .orElseThrow(() -> new CommerceException("Insulina não encontrada"));


        insulina.setTipoInsulina(requestDTO.getTipoInsulina());
        insulina.setUnidades(requestDTO.getUnidades());
        insulina.setHorario(requestDTO.getHorario());


        Insulina insulinAtualizada = insulinRepository.save(insulina);

        return InsulinResponseDTO.builder()
                .insulidaId(insulinAtualizada.getId())
                .tipoInsulina(insulinAtualizada.getTipoInsulina())
                .unidades(insulinAtualizada.getUnidades())
                .horario(insulinAtualizada.getHorario())
                .glicemia(insulinAtualizada.getGlicemia() != null ? insulinAtualizada.getGlicemia().getId() : null)
                .dataAplicacao(insulinAtualizada.getDataAplicacao())
                .build();
    }
}
