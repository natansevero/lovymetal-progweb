CREATE TABLE Usuario(
	id serial,
	senha VARCHAR(13) NOT NULL,
	nome_completo VARCHAR(100) NOT NULL UNIQUE,
	apelido VARCHAR(80),
	data_nasc VARCHAR(11) NOT NULL,
	cidade VARCHAR(80) NOT NULL,
	email VARCHAR(80) UNIQUE NOT NULL,
	profissao VARCHAR(80) NOT NULL,
	descricao VARCHAR (200),
	sexo VARCHAR(1) NOT NULL,
	status VARCHAR(30) NOT NULL,
	altura DOUBLE PRECISION NOT NULL,
        peso DOUBLE PRECISION NOT NULL,
	cor_cabelo VARCHAR(20) NOT NULL,
	foto_perfil VARCHAR(500),
	PRIMARY KEY(id)
);

CREATE TABLE Solicita_amizade(
	solicitador int,
	solicitante int,
	status int NOT NULL,
	PRIMARY KEY(solicitador,solicitante),
	FOREIGN KEY (solicitador) REFERENCES Usuario(id) ON DELETE CASCADE,
	FOREIGN KEY (solicitante) REFERENCES Usuario(id) ON DELETE CASCADE		
);

CREATE TABLE Amizade(
	usuario int,
	amigo int,
	PRIMARY KEY(usuario, amigo),
	FOREIGN KEY (usuario) REFERENCES Usuario(id),
	FOREIGN KEY (amigo) REFERENCES Usuario(id) ON DELETE CASCADE
);


CREATE TABLE Galeria(
	galeria_id serial,
	usuario_id int,
	nomegaleria VARCHAR(100) NOT NULL,
	foto VARCHAR(1000),
	PRIMARY KEY (galeria_id,usuario_id),
	FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE Mensagem(
	mensagem_id serial,
	remetente int,
	destinatario int,
	mensagem text,
	status int NOT NULL,
	PRIMARY KEY (mensagem_id),
	FOREIGN KEY (remetente) REFERENCES Usuario(id) ON DELETE CASCADE,
	FOREIGN KEY (destinatario) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE Passatempos(
	id_usuario int,
	passatempo VARCHAR(80),
	PRIMARY KEY(id_usuario, passatempo),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE Relacionamento(
	id_usuario int,
	tipo VARCHAR(10) NOT NULL,
	par int,
	PRIMARY KEY(id_usuario, par),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id),
	FOREIGN KEY (par) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE Postagem(
	postagem_id serial,
	usuario_id int,
	descricao text,
	foto VARCHAR(1000),
	PRIMARY KEY(postagem_id,usuario_id),
	FOREIGN KEY(usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
)	