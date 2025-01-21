package com.foroohub.ForooHub.domain.topico.dto;

import com.foroohub.ForooHub.domain.curso.Curso;
import com.foroohub.ForooHub.domain.topico.Topico;

public record DatosDetalleTopico(Long id, String titulo, String mensaje, String nombreAutor, Curso curso) {

    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getCurso()
        );
    }


    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public String mensaje() {
        return mensaje;
    }



}

