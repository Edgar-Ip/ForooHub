package com.foroohub.ForooHub.domain.usuario.dto;

import com.foroohub.ForooHub.domain.usuario.Usuario;

public record DatosDetallesUsuario(Long id, String nombre, String correo){

    public DatosDetallesUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo()
        );
    }
}
