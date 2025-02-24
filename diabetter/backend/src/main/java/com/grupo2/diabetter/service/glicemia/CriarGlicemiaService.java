package com.grupo2.diabetter.service.glicemia;

import com.grupo2.diabetter.dto.glicemia.GlicemiaPostPutRequestDto;
import com.grupo2.diabetter.model.Glicemia;
import com.grupo2.diabetter.repository.GlicemiaRepository;
import com.grupo2.diabetter.service.glicemia.interfaces.ICriarGlicemiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarGlicemiaService implements ICriarGlicemiaService {

    @Autowired
    private GlicemiaRepository glicemiaRepository;

    @Override
    public Glicemia executar(GlicemiaPostPutRequestDto dto) {
        Glicemia glicemia = Glicemia.builder()
                .measurement(dto.getMeasurement())
                .timeUuid(dto.getTimeUuid())
                .build();
        return this.glicemiaRepository.save(glicemia);
    }
}
