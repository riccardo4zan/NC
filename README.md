# NC

Create table to use the program

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username)
);

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);


INSERT INTO users(username,password,enabled)
VALUES ('mkyong','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
INSERT INTO users(username,password,enabled)
VALUES ('alex','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);

INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('alex', 'ROLE_USER');

CREATE TABLE Reparti( 
	ID INT(3) NOT NULL AUTO_INCREMENT,
	Nome VARCHAR(20) NOT NULL,
	PRIMARY KEY(ID)	
);

CREATE TABLE Tipi(
	Nome VARCHAR(30) NOT NULL,
	PRIMARY KEY(Nome),
	Descrizione VARCHAR(255) NOT NULL
);

CREATE TABLE Categorie(
	Codice INT(3) AUTO_INCREMENT NOT NULL,
	PRIMARY KEY(Codice),
	Descrizione VARCHAR(255) NOT NULL
);

CREATE TABLE Fornitori(
	Piva VARCHAR(11) NOT NULL,
	PRIMARY KEY(Piva),
	Nome VARCHAR(50) NOT NULL
);

CREATE TABLE Clienti(
	Piva VARCHAR(11) NOT NULL,
	PRIMARY KEY(Piva),
	Nome VARCHAR(50) NOT NULL
);

CREATE TABLE Pezzi(
	Codice INT(7) AUTO_INCREMENT NOT NULL,
	PRIMARY KEY(Codice),
	Categoria INT(3) NOT NULL,
	FOREIGN KEY(Categoria) REFERENCES Categorie(Codice)
)ENGINE = INNODB;

CREATE TABLE Dipendenti(
	Matricola INT(3) AUTO_INCREMENT NOT NULL,
	PRIMARY KEY(Matricola),
	Nome VARCHAR(30) NOT NULL,
	Cognome VARCHAR(30) NOT NULL,
	Reparto INT(3) NOT NULL,
	FOREIGN KEY(Reparto) REFERENCES Reparti(ID),
	Username VARCHAR(45) NOT NULL,
	FOREIGN KEY(Username) REFERENCES users(username)
)ENGINE = INNODB;

CREATE TABLE Segnalazioni(
	Codice INT(5) AUTO_INCREMENT NOT NULL,
	PRIMARY KEY(Codice),
	Descrizione VARCHAR(255) NOT NULL,
	Data DATE NOT NULL,
	MatricolaDipendente INT(3) NOT NULL,
	FOREIGN KEY(MatricolaDipendente) REFERENCES Dipendenti(Matricola)
)ENGINE = INNODB;

CREATE TABLE NonConformita(
	Codice INT(5) AUTO_INCREMENT NOT NULL,
	PRIMARY KEY(Codice),
	Descrizione VARCHAR(255) NOT NULL,
	AzioniContenimento VARCHAR(255) NOT NULL,
	AzioniCorrettive VARCHAR(255),
	AzioniPreventive VARCHAR(255),
	DataApertura DATE NOT NULL,
	DataChiusura DATE,
	Cause VARCHAR(255) NOT NULL,
	Gravita INT(2) NOT NULL,
        Costo DECIMAL(12,2), 
	Tipo VARCHAR(30) NOT NULL,
	FOREIGN KEY (Tipo) REFERENCES Tipi(Nome),
	PivaFornitore VARCHAR(11),
	FOREIGN KEY (PivaFornitore) REFERENCES Fornitori(Piva),
	PivaCliente VARCHAR(11),
	FOREIGN KEY (PivaCliente) REFERENCES Clienti(Piva),
	IDReparto INT(3),
	FOREIGN KEY (IDReparto) REFERENCES Reparti(ID),
	MatricolaDipendente INT(3) NOT NULL,
	FOREIGN KEY (MatricolaDipendente) REFERENCES Dipendenti(Matricola)
)ENGINE = INNODB;

CREATE TABLE CTeam(
	MatricolaDipendente INT(3) NOT NULL,
	FOREIGN KEY (MatricolaDipendente) REFERENCES Dipendenti(Matricola),
	CodiceNC INT(5) NOT NULL,
	FOREIGN KEY (CodiceNC) REFERENCES NonConformita(Codice),
	PRIMARY KEY(MatricolaDipendente,CodiceNC)
)ENGINE = INNODB;

CREATE TABLE PezzoNC(
	CodicePezzo INT(7) NOT NULL,
	FOREIGN KEY (CodicePezzo) REFERENCES Pezzi(Codice),
	CodiceNC INT(5) NOT NULL,
	FOREIGN KEY (CodiceNC) REFERENCES NonConformita(Codice),
	PRIMARY KEY(CodicePezzo,CodiceNC)
)ENGINE = INNODB;

CREATE TABLE Elaborazioni(
	Codice INT(4) AUTO_INCREMENT NOT NULL,
	PRIMARY KEY(Codice),
	Descrizione VARCHAR(255) NOT NULL,
	DataInizio DATE NOT NULL,
	DataFine DATE,
	MatricolaDipendente INT(3) NOT NULL,
	FOREIGN KEY (MatricolaDipendente) REFERENCES Dipendenti(Matricola),
	CodiceNC INT(5) NOT NULL,
	FOREIGN KEY (CodiceNC) REFERENCES NonConformita(Codice)
)ENGINE = INNODB;  
