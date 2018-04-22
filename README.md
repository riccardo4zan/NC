CREATE TABLE Categorie ( Codice int(3) NOT NULL, Descrizione varchar(255) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Clienti ( Piva varchar(11) NOT NULL, Nome varchar(50) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE CTeam ( MatricolaDipendente int(3) NOT NULL, CodiceNC int(5) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Dipendenti ( Matricola int(3) NOT NULL, Nome varchar(30) NOT NULL, Cognome varchar(30) NOT NULL, Reparto int(3) NOT NULL, Username varchar(45) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO Dipendenti (Matricola, Nome, Cognome, Reparto, Username) VALUES (1, 'Operaio', 'Operaio', 1, 'Operaio'), (2, 'Manager', 'Manager', 2, 'Manager'), (3, 'Responsabile Qualita', 'Responsabile Qualita', 3, 'ResponsabileQualita'), (4, 'ControlloreQualita', 'ControlloreQualita', 1, 'ControlloreQualita');

CREATE TABLE Elaborazioni ( Codice int(4) NOT NULL, Descrizione varchar(255) NOT NULL, DataInizio date NOT NULL, DataFine date DEFAULT NULL, MatricolaDipendente int(3) NOT NULL, CodiceNC int(5) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Fornitori ( Piva varchar(11) NOT NULL, Nome varchar(50) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE NonConformita ( Codice int(5) NOT NULL, Descrizione varchar(255) NOT NULL, AzioniContenimento varchar(255) NOT NULL, AzioniCorrettive varchar(255) DEFAULT NULL, AzioniPreventive varchar(255) DEFAULT NULL, DataApertura date NOT NULL, DataChiusura date DEFAULT NULL, Cause varchar(255) NOT NULL, Gravita int(2) NOT NULL, Costo decimal(12,2) DEFAULT NULL, Tipo varchar(30) NOT NULL, PivaFornitore varchar(11) DEFAULT NULL, PivaCliente varchar(11) DEFAULT NULL, IDReparto int(3) DEFAULT NULL, MatricolaDipendente int(3) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Pezzi ( Codice int(7) NOT NULL, Categoria int(3) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE PezzoNC ( CodicePezzo int(7) NOT NULL, CodiceNC int(5) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Reparti ( ID int(3) NOT NULL, Nome varchar(20) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO Reparti (ID, Nome) VALUES (1, 'Produzione'), (2, 'Direzione'), (3, 'Qualita');

CREATE TABLE Segnalazioni ( Codice int(5) NOT NULL, Titolo varchar(255) NOT NULL, Descrizione varchar(255) NOT NULL, Data date NOT NULL, MatricolaDipendente int(3) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Tipi ( Nome varchar(30) NOT NULL, Descrizione varchar(255) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE users ( username varchar(45) NOT NULL, password varchar(60) NOT NULL, enabled tinyint(4) NOT NULL DEFAULT '1' ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO users (username, password, enabled) VALUES ('ControlloreQualita', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1), ('Manager', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1), ('Operaio', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1), ('ResponsabileQualita', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1);

CREATE TABLE user_roles ( user_role_id int(11) NOT NULL, username varchar(45) NOT NULL, role varchar(45) NOT NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO user_roles (user_role_id, username, role) VALUES (5, 'ControlloreQualita', 'ROLE_CONTROLQUA'), (2, 'Manager', 'ROLE_MANAGER'), (3, 'Operaio', 'ROLE_OPERAIO'), (4, 'ResponsabileQualita', 'ROLE_RESPOQUA');

ALTER TABLE Categorie ADD PRIMARY KEY (Codice);

ALTER TABLE Clienti ADD PRIMARY KEY (Piva);

ALTER TABLE CTeam ADD PRIMARY KEY (MatricolaDipendente,CodiceNC), ADD KEY CodiceNC (CodiceNC);

ALTER TABLE Dipendenti ADD PRIMARY KEY (Matricola), ADD KEY Reparto (Reparto), ADD KEY Username (Username);

ALTER TABLE Elaborazioni ADD PRIMARY KEY (Codice), ADD KEY MatricolaDipendente (MatricolaDipendente), ADD KEY CodiceNC (CodiceNC);

ALTER TABLE Fornitori ADD PRIMARY KEY (Piva);

ALTER TABLE NonConformita ADD PRIMARY KEY (Codice), ADD KEY Tipo (Tipo), ADD KEY PivaFornitore (PivaFornitore), ADD KEY PivaCliente (PivaCliente), ADD KEY IDReparto (IDReparto), ADD KEY MatricolaDipendente (MatricolaDipendente);

ALTER TABLE Pezzi ADD PRIMARY KEY (Codice), ADD KEY Categoria (Categoria);

ALTER TABLE PezzoNC ADD PRIMARY KEY (CodicePezzo,CodiceNC), ADD KEY CodiceNC (CodiceNC);

ALTER TABLE Reparti ADD PRIMARY KEY (ID);

ALTER TABLE Segnalazioni ADD PRIMARY KEY (Codice), ADD KEY MatricolaDipendente (MatricolaDipendente);

ALTER TABLE Tipi ADD PRIMARY KEY (Nome);

ALTER TABLE users ADD PRIMARY KEY (username);

ALTER TABLE user_roles ADD PRIMARY KEY (user_role_id), ADD UNIQUE KEY uni_username_role (role,username), ADD KEY fk_username_idx (username);

ALTER TABLE Categorie MODIFY Codice int(3) NOT NULL AUTO_INCREMENT;

ALTER TABLE Dipendenti MODIFY Matricola int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE Elaborazioni MODIFY Codice int(4) NOT NULL AUTO_INCREMENT;

ALTER TABLE NonConformita MODIFY Codice int(5) NOT NULL AUTO_INCREMENT;

ALTER TABLE Pezzi MODIFY Codice int(7) NOT NULL AUTO_INCREMENT;

ALTER TABLE Reparti MODIFY ID int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE Segnalazioni MODIFY Codice int(5) NOT NULL AUTO_INCREMENT;

ALTER TABLE user_roles MODIFY user_role_id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE CTeam ADD CONSTRAINT CTeam_ibfk_1 FOREIGN KEY (MatricolaDipendente) REFERENCES Dipendenti (Matricola), ADD CONSTRAINT CTeam_ibfk_2 FOREIGN KEY (CodiceNC) REFERENCES NonConformita (Codice);

ALTER TABLE Dipendenti ADD CONSTRAINT Dipendenti_ibfk_1 FOREIGN KEY (Reparto) REFERENCES Reparti (ID), ADD CONSTRAINT Dipendenti_ibfk_2 FOREIGN KEY (Username) REFERENCES users (username);

ALTER TABLE Elaborazioni ADD CONSTRAINT Elaborazioni_ibfk_1 FOREIGN KEY (MatricolaDipendente) REFERENCES Dipendenti (Matricola), ADD CONSTRAINT Elaborazioni_ibfk_2 FOREIGN KEY (CodiceNC) REFERENCES NonConformita (Codice);

ALTER TABLE NonConformita ADD CONSTRAINT NonConformita_ibfk_1 FOREIGN KEY (Tipo) REFERENCES Tipi (Nome), ADD CONSTRAINT NonConformita_ibfk_2 FOREIGN KEY (PivaFornitore) REFERENCES Fornitori (Piva), ADD CONSTRAINT NonConformita_ibfk_3 FOREIGN KEY (PivaCliente) REFERENCES Clienti (Piva), ADD CONSTRAINT NonConformita_ibfk_4 FOREIGN KEY (IDReparto) REFERENCES Reparti (ID), ADD CONSTRAINT NonConformita_ibfk_5 FOREIGN KEY (MatricolaDipendente) REFERENCES Dipendenti (Matricola);

ALTER TABLE Pezzi ADD CONSTRAINT Pezzi_ibfk_1 FOREIGN KEY (Categoria) REFERENCES Categorie (Codice);

ALTER TABLE PezzoNC ADD CONSTRAINT PezzoNC_ibfk_1 FOREIGN KEY (CodicePezzo) REFERENCES Pezzi (Codice), ADD CONSTRAINT PezzoNC_ibfk_2 FOREIGN KEY (CodiceNC) REFERENCES NonConformita (Codice);

ALTER TABLE Segnalazioni ADD CONSTRAINT Segnalazioni_ibfk_1 FOREIGN KEY (MatricolaDipendente) REFERENCES Dipendenti (Matricola);

ALTER TABLE user_roles ADD CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username);

alter table Segnalazioni add Titolo varchar(50) not null;
