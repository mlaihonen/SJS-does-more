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