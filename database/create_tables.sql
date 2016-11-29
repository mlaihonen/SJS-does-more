CREATE TABLE tapahtuma
(tapahtumaid INTEGER NOT NULL AUTO_INCREMENT
, nimi VARCHAR(255) not null
, kuvaus varchar(500) not null
, pvm date not null
, aika time not null
, paikka varchar(255) not null
, maxosallistujalkm integer
, jarjestaja_id integer
, kategoria varchar(255)
, CONSTRAINT pk_tapaht PRIMARY KEY (tapahtumaid)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE kayttaja
(kayttajaid INTEGER NOT NULL AUTO_INCREMENT
, etunimi VARCHAR(50) not null
, sukunimi varchar(50) not null
, bio varchar(500)
, sposti varchar (30) not null
, puh varchar (20)
, CONSTRAINT pk_kayt PRIMARY KEY (kayttajaid)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE tapahtumaosallistuja
(k_id INTEGER NOT NULL 
, t_id INTEGER NOT NULL
, CONSTRAINT pk_osallist PRIMARY KEY (k_id, t_id)
, CONSTRAINT fk_kayt FOREIGN KEY (k_id) REFERENCES kayttaja(kayttajaid)
, CONSTRAINT fk_tapahtuma FOREIGN KEY (t_id) REFERENCES tapahtuma(tapahtumaid)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;