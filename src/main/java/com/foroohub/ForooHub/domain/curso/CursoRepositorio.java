package com.foroohub.ForooHub.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
    Optional<Curso> findById(Long cursoId);

}

