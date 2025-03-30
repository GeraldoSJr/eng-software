package com.grupo2.diabetter.service.glicemia;

import com.grupo2.diabetter.dto.glicemia.GlicemiaResponseDTO;
import com.grupo2.diabetter.dto.glicemia.GlicemiaPostPutRequestDto;
import com.grupo2.diabetter.exception.NotFoundException;
import com.grupo2.diabetter.model.Glicemia;
import com.grupo2.diabetter.repository.GlicemiaRepository;
import com.grupo2.diabetter.service.glicemia.interfaces.IAtualizarGlicemiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AtualizarGlicemiaService implements IAtualizarGlicemiaService {

    @Autowired
    private GlicemiaRepository glicemiaRepository;

    @Override
    public GlicemiaResponseDTO executar(UUID id, GlicemiaPostPutRequestDto dto) {
        Glicemia glicemia = glicemiaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Glicemia não encontrada"));
    
        glicemia.setValorGlicemia(dto.getValorGlicemia());
    
        // Agora horário é apenas uma String, então atribuímos direto:
        if (dto.getHorario() != null) {
            glicemia.setHorario(dto.getHorario());
        }
    
        if (dto.getComentario() != null) {
            glicemia.setComentario(dto.getComentario());
        }
    
        Glicemia updatedGlicemia = glicemiaRepository.save(glicemia);
    
        return GlicemiaResponseDTO.builder()
                .id(updatedGlicemia.getId())
                .valorGlicemia(updatedGlicemia.getValorGlicemia())
                .horario(updatedGlicemia.getHorario()) // agora é uma String mesmo
                .insulina(updatedGlicemia.getInsulina() != null ? updatedGlicemia.getInsulina().getId() : null)
                .comentario(updatedGlicemia.getComentario())
                .createdAt(updatedGlicemia.getCreatedAt())
                .build();
    }
    

}
