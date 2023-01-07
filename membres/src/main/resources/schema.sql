DROP TABLE IF EXISTS members;

CREATE TABLE members (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nom varchar(255) default NOT NULL,
  mdp varchar(255) NOT NULL,
  propositions varchar(255) default NULL,
  equipes varchar(255) default NOT NULL
);

DROP TABLE IF EXISTS propositions;

CREATE TABLE propositions (
  proposition_id bigint default NULL,
  membre_id bigint default NULL
);

DROP TABLE IF EXISTS equipes;

CREATE TABLE equipes (
  equipe_id bigint default NOT NULL,
  membre_id bigint default NULL
);