package com.foroohub.ForooHub.domain.respuesta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foroohub.ForooHub.domain.respuesta.dto.DatosCrearRespuesta;
import com.foroohub.ForooHub.domain.topico.Topico;
import com.foroohub.ForooHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

    @Entity
    @Table (name = "respuestas")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode(of = "id")
    public class Respuesta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String mensaje;

        @Column(name = "fecha")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        private LocalDateTime fecha;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id")
        @JsonIgnore
        private Usuario autor;

        private Boolean borrado;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "topico_id")
        @JsonIgnore
        private Topico topico;

        public Respuesta(DatosCrearRespuesta datosCrearRespuesta, Usuario usuario, Topico topico) {
            this.mensaje = datosCrearRespuesta.mensaje();
            this.fecha = LocalDateTime.now();
            this.autor = usuario;
            this.topico = topico;
            this.borrado = false;
        }


        public void eliminarRespuesta() {
            this.borrado = true;
        }

        public Long getId() {
            return id;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public Topico getTopico(){
            return topico;
        }

        public Boolean getBorrado() {
            return borrado;
        }

        public Usuario getAutor() {
            return autor;
        }

        public String getMensaje(){
            return mensaje;
        }
    }


