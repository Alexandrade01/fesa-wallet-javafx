create database fesawallet;
use fesawallet;

create table usuario (
id int(11) NOT NULL AUTO_INCREMENT,
nome varchar(100) NOT NULL,
sobrenome varchar(100) NOT NULL,
email varchar(100) NOT NULL,
senha varchar(100) NOT NULL,
PRIMARY KEY (id)
);

create table meiopagamento(
id int(11) NOT NULL AUTO_INCREMENT,
descricao varchar(100) NOT NULL,
saldo double,
usuarioId int(11),
PRIMARY KEY (id),
FOREIGN KEY (usuarioId) REFERENCES usuario (id)
);

INSERT INTO usuario (nome, sobrenome, email, senha)
VALUES ('Ale','Andrade','ale90@hotmail.com','senha'),
('ze1','alves1','ale90@hotmail.com','senha');


#COMANDOS
select * from usuario;

SELECT usuario.* from usuario WHERE usuario.nome = 'Ale' and usuario.senha = 'senha';

