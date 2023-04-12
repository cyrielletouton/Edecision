DROP TABLE IF EXISTS propositions;

CREATE TABLE propositions (
                              id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
                              titre varchar(5000) default NOT NULL,
                              description varchar(5000) default NULL,
                              status enum ('OUVERT','ENCOURS', 'TERMINE') default NOT NULL,
                              estAccepte boolean default NOT NULL,
                              impact int default NULL,
                              maxVote int default NULL,
                              nbrVote int default NULL
);

DROP TABLE IF EXISTS proprietaire;

CREATE TABLE proprietaire (
                              proprietaire_id bigint NOT NULL,
                              proposition_id bigint NOT NULL
);

DROP TABLE IF EXISTS scope;

CREATE TABLE scope (
                       scope_id bigint NOT NULL,
                       proposition_id bigint NOT NULL
);

DROP TABLE IF EXISTS amendements;

CREATE TABLE amendements (
                             id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
                             contenu varchar(255) default NOT NULL
);
