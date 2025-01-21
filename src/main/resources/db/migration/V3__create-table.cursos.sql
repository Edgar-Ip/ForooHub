create table cursos(

    id bigint not null auto_increment,
    nombre varchar(20) not null,
    categoria ENUM("Programación", "Front End", "Back End", "Data Science", "DevOps", "Otro") not null,
    activo bit(1) not null,

    primary key(id)

);

