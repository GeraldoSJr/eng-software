package com.grupo2.diabetter.repository;

import com.grupo2.diabetter.model.Glicemia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GlicemiaRepository extends JpaRepository<Glicemia, UUID> {
    List<Glicemia> findByTimeUuid(UUID timeUuid);
}
