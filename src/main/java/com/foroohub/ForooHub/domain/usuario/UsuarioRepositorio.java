package com.foroohub.ForooHub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
        Optional<Usuario> findById(Long idautor);
    }


