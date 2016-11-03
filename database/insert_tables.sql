INSERT INTO tapahtuma (t_nimi, t_kuvaus, t_pvm, t_aika, t_paikka, t_maxosallistujalkm) VALUES
( 'Esiintymistaito'
, 'Tervetuloa parantamaan esiintymistaitoasi näyttelijägurun johdolla!'
, '2016-01-10'
, '12:30'
, 'Pasilan kirjasto'
, 20
);

INSERT INTO tapahtuma (t_nimi, t_kuvaus, t_pvm, t_aika, t_paikka, t_maxosallistujalkm) VALUES
( 'Nokkahuilutunti'
, 'Nokkahuilu on rock!!!!1'
, '2016-10-11'
, '18:00'
, 'Haaga-Helia'
, 10
);

INSERT INTO kayttaja (k_etunimi, k_sukunimi, k_kuvaus, k_sposti, k_puh) VALUES
( 'Timo'
, 'Testaaja'
, 'Hei, Olen testaaja'
, 'timo.testaaja@clubpenguin.com'
, '040123123'
);

INSERT INTO tapahtumaosallistuja (k_id, t_id) VALUES
( 1
, 1
);

INSERT INTO tapahtumaosallistuja (k_id, t_id) VALUES
( 2
, 2
);




