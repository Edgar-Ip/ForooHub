package com.foroohub.ForooHub.domain.curso;

public enum Categoria {

    PROGRAMACION("Programación"),
    FRONTEND("Front End"),
    BACKEND("Back End"),
    DATASCIENCE("Data Science"),
    DEVOPS("DevOps"),
    OTRO("Otro");

    private String categoriaTopico;
    Categoria (String categoriaTopico){
        this.categoriaTopico=categoriaTopico;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaTopico.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}


