DROP TABLE IF EXISTS members;

CREATE TABLE members (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nom varchar(255) default NOT NULL,
  mdp varchar(255) NOT NULL,
  propositions varchar(255) default NULL,
  equipe varchar(255) default NOT NULL
);
