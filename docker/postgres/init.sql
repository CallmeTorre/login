CREATE TABLE usuarios(
    id serial NOT NULL,
    nombre_usuario varchar NOT NULL,
    contrasena varchar NOT NULL,
    CONSTRAINT usuarios_pk PRIMARY KEY (id)
);
