package com.foroohub.ForooHub.domain.curso;


import com.foroohub.ForooHub.domain.curso.dto.DatosActualizarCurso;
import com.foroohub.ForooHub.domain.curso.dto.DatosCrearCurso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.PathVariable;


    @Entity
    @Table(name= "cursos")
    @AllArgsConstructor
    @EqualsAndHashCode(of= "id")

    public class Curso {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        @Enumerated (EnumType.STRING)
        private Categoria categoria;

        public Curso(){}

        public Curso (DatosCrearCurso datos){
            this.nombre = datos.nombre();
            this.categoria = Categoria.fromString(datos.categoria());
        }
        public Long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public Categoria getCategoria() {
            return categoria;
        }



        public void actualizarCurso(@Valid @PathVariable DatosActualizarCurso datosActualizarCurso) {
            if (datosActualizarCurso.nombreCurso() != null) {
                this.nombre = datosActualizarCurso.nombreCurso();
            }
        }
    }


