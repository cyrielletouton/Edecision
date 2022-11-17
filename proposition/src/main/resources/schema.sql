DROP TABLE IF EXISTS propositions;

CREATE TABLE propositions (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  problematique varchar(5000) default NOT NULL,
  commentaire varchar(5000) default NULL,
  status enum ('Ouvert','En cours', 'Terminé') default NOT NULL,
  estAccepte boolean default NOT NULL,
  impact int default NULL,
  maxVote int default NULL,
  nbrVote int default NULL,
  proprietaire varchar(255) default NULL,
  scope varchar(255) default NULL,
  dateDepot DATE default(NOW()) NULL
);

DROP TABLE IF EXISTS amendements;

CREATE TABLE amendements (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  contenu varchar(255) default NOT NULL
);

DROP TABLE IF EXISTS propositions_generales;

CREATE TABLE propositions_generales (
  id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
  proposition int default NULL,
  amendement int default NULL
);