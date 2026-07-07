INSERT INTO utente (id, nome, cognome) VALUES (1, 'Admin', 'Principale');
INSERT INTO credenziali (id, username, password, role, utente_id) VALUES (1, 'admin', '$2a$12$gmNmm4xe7BWSpQjhS3CXdOf4K0WDpZDD7L/s/pmkXa8u2U4piXJuS', 'ADMIN', 1);
INSERT INTO torneo (id, nome) VALUES (100, 'Champions League');
INSERT INTO torneo (id, nome) VALUES (101, 'Serie A');

INSERT INTO squadra (id, nome, annoDiFondazione, citta) VALUES (200, 'AS Roma', 1927, 'Roma');
INSERT INTO squadra (id, nome, annoDiFondazione, citta) VALUES (201, 'Manchester United', 2023, 'Manchester');
INSERT INTO squadra (id, nome, annoDiFondazione, citta) VALUES (202, 'Real Madrid', 2015, 'Madrid');

INSERT INTO utente (id, nome, cognome) VALUES (2, 'alessio', 'falasca');
INSERT INTO credenziali (id, username, password, role, utente_id) 
VALUES (2, 'alessio', '$2a$12$gri85Wnw4Er7y9nfWWwIx.8yMRW5F5EdL5M4i9Sj4yaidG3TXpfpG', 'DEFAULT', 2);

INSERT INTO arbitro (id, nome, cognome) VALUES (500, 'Pierluigi', 'Collina');
INSERT INTO arbitro (id, nome, cognome) VALUES (501, 'Daniele', 'Orsato');
