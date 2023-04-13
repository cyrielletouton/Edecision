DROP TABLE IF EXISTS propositions;

CREATE TABLE propositions
(
    id          bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
    titre       varchar(5000) default NOT NULL,
    description varchar(5000) default NULL,
    statut      enum ('OUVERT','EN COURS', 'TERMINE') default NOT NULL,
    estAccepte  boolean       default NOT NULL,
    maxVote     int           default NULL,
    nbrVote     int           default NULL,
    proprietaire bigint default NOT NULL
);

DROP TABLE IF EXISTS equipes;

CREATE TABLE equipes (
                         equipe_id bigint NOT NULL,
                         proprietaire bigint NOT NULL
);

DROP TABLE IF EXISTS amendements;

CREATE TABLE amendements (
                             id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
                             contenu varchar(255) default NOT NULL
);
