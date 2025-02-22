DROP TABLE fonoteca IF EXISTS;

CREATE TABLE fonoteca (
    songId VARCHAR(20) NOT NULL,
    titulo VARCHAR(20),
    artista VARCHAR(60),
    album VARCHAR(30),
    genero VARCHAR(30),
    duracion VARCHAR(20)
);
