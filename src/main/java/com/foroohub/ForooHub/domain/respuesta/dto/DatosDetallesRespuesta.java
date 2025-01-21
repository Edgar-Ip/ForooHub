package com.foroohub.ForooHub.domain.respuesta.dto;

import com.foroohub.ForooHub.domain.respuesta.Respuesta;

import java.time.LocalDateTime;

public record DatosDetallesRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fecha,
        Boolean borrado,
        Long usuarioId,
        String nombre,
        Long topicoId,
        String topico
) {


    public DatosDetallesRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFecha(),
                respuesta.getBorrado(),
                respuesta.getAutor().getId(),
                respuesta.getAutor().getNombre(),
                respuesta.getTopico().getId(),
                respuesta.getTopico().getTitulo());
    }
}
