-- DROP SCHEMA IF EXISTS pj01;
-- CREATE SCHEMA pj01;
-- USE pj01;

drop table if exists Disciplinas;
drop table if exists Provas;
drop table if exists Assuntos;
drop table if exists Perguntas;
drop table if exists Historico;

CREATE TABLE Disciplinas (
    idDisc INTEGER NOT NULL PRIMARY KEY,
    nome TEXT NOT NULL);
    
CREATE TABLE Provas (
    idProva INTEGER NOT NULL PRIMARY KEY,
    semestre INTEGER NOT NULL,
    idDisc INTEGER,
    data INTEGER NOT NULL,
    CONSTRAINT Provas_Disciplinas FOREIGN KEY (idDisc)
    REFERENCES Disciplinas (idDisc));
    
CREATE TABLE Assuntos (
    idAssunto INTEGER NOT NULL PRIMARY KEY,
    idDisc INTEGER,
    nome TEXT NOT NULL,
    CONSTRAINT Assuntos_Disciplinas FOREIGN KEY (idDisc)
    REFERENCES Disciplinas (idDisc));
    
CREATE TABLE Perguntas (
    idPergunta INTEGER NOT NULL PRIMARY KEY,
    pergunta TEXT NOT NULL,
    resposta TEXT NOT NULL,
    idAssunto INTEGER,
    flag_alternativa BOOLEAN NOT NULL,
    alternativa TEXT,
    CONSTRAINT Perguntas_Assuntos FOREIGN KEY (idAssunto)
    REFERENCES Assuntos (idAssunto));

CREATE TABLE Historico (
    idProva INTEGER,
    idPergunta INTEGER,
    CONSTRAINT Provas_Historico FOREIGN KEY (idProva)
    REFERENCES Provas (idProva),
    CONSTRAINT Perguntas_Historico FOREIGN KEY (idPergunta)
    REFERENCES Perguntas (idPergunta));

