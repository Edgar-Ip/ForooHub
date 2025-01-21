package com.foroohub.ForooHub.domain.respuesta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestasRepositorio extends JpaRepository<Respuesta, Long> {
    Page<Respuesta> findAllByTopicoId(Long topicoId, Pageable pageable);

    @SuppressWarnings("null")
    Respuesta getReferenceById(Long id);
}

