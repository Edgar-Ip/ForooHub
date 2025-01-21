package com.foroohub.ForooHub.domain.usuario;


import com.foroohub.ForooHub.domain.usuario.dto.DatosCrearUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

    @Entity
    @Table(name= "autor")
    @AllArgsConstructor
    @EqualsAndHashCode(of= "id")

    public class Usuario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String correo;

        private String clave;

        public Usuario() {
        }

        public Usuario(DatosCrearUsuario datos) {
            this.nombre = datos.nombre();
            this.correo = datos.correo();
        }


        public Long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public String getClave() {
            return clave;
        }

        public Usuario actualizarDatosUsuario(Usuario datos) {
            this.nombre = datos.nombre();
            this.correo = datos.correo();
            this.clave = datos.clave();
            return this;
        }

        private String correo() {
            return correo;
        }
        private String nombre(){
            return nombre;
        }
        private String clave(){
            return clave;
        }
    }

