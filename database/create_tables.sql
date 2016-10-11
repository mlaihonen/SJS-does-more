CREATE TABLE tapahtuma
(t_id INTEGER NOT NULL AUTO_INCREMENT
, t_nimi VARCHAR(255) not null
, t_kuvaus varchar(500) not null
, t_pvm date not null
, t_aika time not null
, t_paikka varchar(255) not null
, t_osallistujalkm integer 
, t_jarjestaja_id integer
, t_kategoria varchar(255)
, CONSTRAINT pk_tapaht PRIMARY KEY (t_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE kayttaja
(k_id INTEGER NOT NULL AUTO_INCREMENT
, k_etunimi VARCHAR(50) not null
, k_sukunimi varchar(50) not null
, k_kuvaus varchar(500)
, k_sposti varchar (30) not null
, k_puh varchar (20)
, CONSTRAINT pk_kayt PRIMARY KEY (k_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE tapahtumaosallistuja
(k_id INTEGER NOT NULL 
, t_id INTEGER NOT NULL
, CONSTRAINT pk_osallist PRIMARY KEY (k_id, t_id)
, CONSTRAINT fk_kayt FOREIGN KEY (k_id) REFERENCES kayttaja(k_id)
, CONSTRAINT fk_tapahtuma FOREIGN KEY (t_id) REFERENCES tapahtuma(t_id)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;