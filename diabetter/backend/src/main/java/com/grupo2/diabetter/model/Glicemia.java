package com.grupo2.diabetter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Glicemia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    @JsonProperty
    private UUID id;

    @Column(name = "valorGlicemia", nullable = false)
    @JsonProperty
    private float valorGlicemia;

    @ManyToOne
    @JoinColumn(name = "horario_id", nullable = false)
    private Horario horario;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "glicemia", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private Insulina insulina;

    @Column(name = "comentario", columnDefinition = "TEXT", nullable = true)
    private String comentario;
}
