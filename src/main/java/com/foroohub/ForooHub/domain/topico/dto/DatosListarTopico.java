package com.foroohub.ForooHub.domain.topico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.foroohub.ForooHub.domain.curso.Curso;
import com.foroohub.ForooHub.domain.topico.Topico;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public record DatosListarTopico(Long id,
                                String titulo,
                                String mensaje,
                                String nombreAutor,
                                Curso curso,
                                @CreatedDate @JsonFormat(pattern ="dd-MM-yyyy HH:mm")
                                LocalDateTime fecha,
                                Boolean status
) {

    public DatosListarTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getAutor().getNombre(),
                topico.getCurso(),
                topico.getFecha(),
                topico.isStatus()
        );
    }

}
