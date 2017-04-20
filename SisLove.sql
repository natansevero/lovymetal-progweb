CREATE TABLE Usuario(
	id serial,
	senha VARCHAR(13) UNIQUE NOT NULL,
	nome VARCHAR(100) NOT NULL,
	apelido VARCHAR (80),
	datanasc DATE NOT NULL,
	cidade VARCHAR(80) NOT NULL,
	email VARCHAR(80) UNIQUE NOT NULL,
	profissao VARCHAR(80) NOT NULL,
	descricao VARCHAR (200),
	sexo VARCHAR(2) NOT NULL,
	status VARCHAR(3) UNIQUE NOT NULL,
	altura REAL NOT NULL,
	peso REAL NOT NULL,
	cabelo VARCHAR(20) NOT NULL,
	fotoperfil VARCHAR(500),
	PRIMARY KEY(id)
);

CREATE TABLE solicita_amizade(
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
	id_usuario VARCHAR(30),
	nomegaleria VARCHAR(100) NOT NULL,
	foto VARCHAR(1000),
	PRIMARY KEY (id_galeria,usuario_id),
	FOREIGN KEY (usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
);

CREATE TABLE Mensagem(
	mensagem_id serial,
	remetente int,
	destinatario int,
	mensagem text,
	status int NOT NULL,
	PRIMARY KEY (mensagemid),
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
	id_usuario int,
	descricao text,
	foto VARCHAR(1000),
	PRIMARY KEY(postagem_id,id_usuario),
	FOREIGN KEY(usuario_id) REFERENCES Usuario(id) ON DELETE CASCADE
)	