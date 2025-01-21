create table topicos(

    id bigint not null auto_increment PRIMARY KEY,
    titulo varchar(30) not null unique,
    mensaje varchar(100) not null unique,
    autor varchar(30) not null,
    curso varchar(30) not null,
    fecha datetime not null,
    status varchar (20) not null,
    topico_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL


);