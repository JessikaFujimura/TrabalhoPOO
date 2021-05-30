CREATE DATABASE TRABPOO;
USE TRABPOO;

CREATE TABLE EVENTOS (IDEV int AUTO_INCREMENT PRIMARY KEY, TITULO varchar(150),DATA date, HORA char(5));

INSERT INTO eventos (TITULO, DATA, HORA) VALUES ('Visita ao zoologico municipal', '2022-03-15', '09:00');

CREATE TABLE ALUNOS (IDALUNO int AUTO_INCREMENT PRIMARY KEY, NOMEALUNO varchar(150),N1 decimal(10,2), N2 decimal(10,2),N3 decimal(10,2),N4 decimal(10,2),FALTA int);

INSERT INTO ALUNOS (NOMEALUNO,N1,N2,N3,N4, FALTA) VALUES ('João Silva', 8.0, 5.5, 7.0, 6.5, 2), ('Maria', 5.0, 7.5, 8.0, 10.0, 0);
INSERT INTO ALUNOS (NOMEALUNO,N1,N2,N3,N4, FALTA) VALUES ('Jose Moreira', 4.0, 7.5, 3.0, 9.5, 5);

CREATE TABLE MATERIA (IDMATERIA int AUTO_INCREMENT PRIMARY KEY, NOMEMAT varchar(150));

INSERT INTO MATERIA (NOMEMAT) VALUES ('Portugues'), ('Matemática'),('Geografia'), ('História'), ('Biologia');

CREATE TABLE ALUNOSMAT(
	ANO INT,
	IDALUNO INT,
	IDMATERIA INT,
	PRIMARY KEY (IDALUNO, IDMATERIA),
	FOREIGN KEY (IDALUNO) REFERENCES ALUNOS (IDALUNO),
	FOREIGN KEY (IDMATERIA) REFERENCES MATERIA(IDMATERIA)
);

INSERT INTO ALUNOSMAT (ANO,IDALUNO,IDMATERIA) VALUES (2020,1,1), (2020,1,2), (2020,2,3),(2020,1,4), (2020,2,1);
INSERT INTO ALUNOSMAT (ANO,IDALUNO,IDMATERIA) VALUES (2020,3,3);



SELECT * FROM ALUNOS WHERE IDALUNO = ANY (SELECT IDALUNO FROM ALUNOSMAT WHERE IDMATERIA=1); 