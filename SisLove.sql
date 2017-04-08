CREATE TABLE Usuario(
	login VARCHAR(30) UNIQUE,
	senha VARCHAR(13) UNIQUE NOT NULL,
	nome VARCHAR(100) NOT NULL,
	apelido VARCHAR (80),
	datanasc DATE NOT NULL,
	cidade VARCHAR(80) NOT NULL,
	email VARCHAR(80) NOT NULL,
	profissao VARCHAR(80) NOT NULL,
	descricao VARCHAR (200),
	sexo VARCHAR(2) NOT NULL,
	status VARCHAR(3) UNIQUE NOT NULL,
	altura REAL NOT NULL,
	peso REAL NOT NULL,
	cabelo VARCHAR(20) NOT NULL,
	fotoperfil VARCHAR(500),
	PRIMARY KEY(login)
);

CREATE TABLE Amizade(
	usuario VARCHAR(30),
	amigo VARCHAR(30),
	PRIMARY KEY(usuario, amigo),
	FOREIGN KEY (usuario) REFERENCES Usuario(login),
	FOREIGN KEY (amigo) REFERENCES Usuario(login) ON DELETE CASCADE
);


CREATE TABLE Galeria(
	id VARCHAR(30),
	usuariologin VARCHAR(30),
	nomegaleria VARCHAR(100) NOT NULL,
	foto VARCHAR(500),
	PRIMARY KEY (id),
	FOREIGN KEY (usuariologin) REFERENCES Usuario(login) ON DELETE CASCADE
);

CREATE TABLE Mensagem(
	mensagemid VARCHAR(30),
	remetente VARCHAR(30),
	destinatario VARCHAR(30),
	mensagem VARCHAR(1000),
	PRIMARY KEY (mensagemid),
	FOREIGN KEY (remetente) REFERENCES Usuario(login) ON DELETE CASCADE,
	FOREIGN KEY (destinatario) REFERENCES Usuario(login) ON DELETE CASCADE
);

CREATE TABLE Passatempos(
	usuariologin VARCHAR(30),
	passatempo VARCHAR(80),
	PRIMARY KEY(usuariologin, passatempo),
	FOREIGN KEY (usuariologin) REFERENCES Usuario(login) ON DELETE CASCADE
);

CREATE TABLE Relacionamento(
	usuariologin VARCHAR(30),
	tipo VARCHAR(10) NOT NULL,
	par VARCHAR(30),
	PRIMARY KEY(usuariologin, par),
	FOREIGN KEY (usuariologin) REFERENCES Usuario(login),
	FOREIGN KEY (par) REFERENCES Usuario(login) ON DELETE CASCADE
)
	