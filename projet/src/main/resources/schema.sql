DROP TABLE IF EXISTS projets;

CREATE TABLE projets (
  id bigint AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nom varchar(255) default NOT NULL,
  proposition varchar(255) default NULL,
  equipe varchar(255) default NULL
);