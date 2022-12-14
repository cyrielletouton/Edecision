DROP TABLE IF EXISTS propositions;

CREATE TABLE propositions (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  problematique varchar(5000) default NOT NULL,
  commentaire varchar(5000) default NULL,
  status enum ('Ouvert','En cours', 'Terminé') default NOT NULL,
  estAccepte boolean default NOT NULL,
  impact int default NULL,
  maxVote int default NULL,
  nbrVote int default NULL,
  dateDepot DATE default(NOW()) NULL
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