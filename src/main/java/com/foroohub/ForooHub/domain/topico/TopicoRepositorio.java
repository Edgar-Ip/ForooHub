package com.foroohub.ForooHub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface TopicoRepositorio extends JpaRepository<Topico,Long> {
        void deleteById(Long id);
    }


