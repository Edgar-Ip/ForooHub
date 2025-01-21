package com.foroohub.ForooHub.domain.respuesta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCrearRespuesta(@NotBlank String mensaje,
                                  @NotNull Long usuarioId,
                                  @NotNull long topicoId

) {
}
