CREATE TABLE usuario(
        id serial,
	nome_completo varchar(50) not null,
	apelido varchar(10) not null,
	data_nasc varchar(10) not null,
	cidade varchar(15) not null,
	estado varchar(2) not null,
	email varchar(50) not null unique,
	senha text not null,
	profissao varchar(20) not null,
	descricao text not null,
	status varchar(10) not null,
	altura double precision not null,
	cor_cabelo varchar(10) null,
	sexo varchar(1) not null,
	foto_perfil varchar(50) not null,
	PRIMARY KEY(id)
);

CREATE TABLE passatempo (
	id_usuario int,
	passatempo VARCHAR(80),
	PRIMARY KEY(id_usuario),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE galeria(
	id_galeria serial,
	id_usuario int,
	nomegaleria VARCHAR(100) NOT NULL,
	foto VARCHAR(500),
	PRIMARY KEY (id_galeria, id_usuario),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE amizade(
	id_usuario int,
	id_amigo int,
	PRIMARY KEY(id_usuario, id_amigo),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (id_amigo) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE solicita_amizade(
        id_solicitador int,
        id_solicitante int,
        status int not null,
        primary key(id_solicitador, id_solicitante),
        FOREIGN KEY (id_solicitador) REFERENCES usuario(id),
	FOREIGN KEY (id_solicitante) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE mensagem(
	id serial,
	id_remetente int,
	id_destinatario int,
	mensagem VARCHAR(1000) not null,
        status int not null,
	PRIMARY KEY (id, id_remetente, id_destinatario),
	FOREIGN KEY (id_remetente) REFERENCES usuario(id) ON DELETE CASCADE,
	FOREIGN KEY (id_destinatario) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE relacionamento(
	id_usuario int,
	tipo VARCHAR(10) NOT NULL,
	par int,
	PRIMARY KEY(id_usuario, par),
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (par) REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE postagem(
        id serial,
        id_usuario int,
        descricao text,
        foto text not null,
        primary key(id, id_usuario),
        foreign key(id_usuario) references usuario(id) on delete cascade
);
	