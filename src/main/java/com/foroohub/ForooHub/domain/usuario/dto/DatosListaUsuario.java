package com.foroohub.ForooHub.domain.usuario.dto;

import com.foroohub.ForooHub.domain.usuario.Usuario;

public record DatosListaUsuario(Long id, String nombre, String correo) {

    public DatosListaUsuario(Usuario usuario) {
        this(usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo());
    }

}

